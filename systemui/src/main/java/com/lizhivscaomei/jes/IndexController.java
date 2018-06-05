package com.lizhivscaomei.jes;

import com.lizhivscaomei.jes.common.entity.Msg;
import com.lizhivscaomei.jes.common.entity.SpinnerVo;
import com.lizhivscaomei.jes.common.exception.AppException;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysUser;
import com.lizhivscaomei.jes.sys.entity.VSysUserRoleDomain;
import com.lizhivscaomei.jes.sys.security.userdetails.JesUserDetails;
import com.lizhivscaomei.jes.sys.service.SysDomainService;
import com.lizhivscaomei.jes.sys.service.SysMenuService;
import com.lizhivscaomei.jes.sys.service.SysUserService;
import com.lizhivscaomei.jes.sys.view.SysMenuTreeViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * Created by lizhi on 2018/3/30.
 */
@Controller
public class IndexController {
    @Autowired
    SysMenuTreeViewService sysMenuTreeViewService;
    @Autowired
    SysDomainService sysDomainService;
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysUserService sysUserService;
    /**
     * 系统首页
     * 登录成功后，跳转的页面
     */
    @GetMapping(value = {"", "/", "/home", "/index", "/welcome"})
    public ModelAndView index(HttpSession session) {
        ModelAndView mv = new ModelAndView("index");
        JesUserDetails jesUserDetails = (JesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        mv.addObject("user", jesUserDetails);
        return mv;
    }

    /**
     * 系统登录页面
     * 登录失败后，跳转的页面，或者登录请求页面
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /*个人信息查询展示*/
    @ResponseBody
    @GetMapping("/myinfo")
    public Msg getMyInfo() {
        Msg msg = new Msg();
        JesUserDetails jesUserDetails = (JesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser user = new SysUser();
        user.setId(jesUserDetails.getId());
        user.setLoginName(jesUserDetails.getLoginName());
        user.setName(jesUserDetails.getName());
        msg.setSuccess(true);
        msg.setData(user);
        return msg;
    }

    /*当前用户所属域*/
    @ResponseBody
    @GetMapping("/mydomain")
    public Msg getMyDomain() {
        Msg msg = new Msg();
        List<SpinnerVo> spinnerVoList = new ArrayList<>();
        JesUserDetails currentUser = (JesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<VSysUserRoleDomain> domainList = this.sysDomainService.getByUser(currentUser.getId());
        if (domainList != null && domainList.size() > 0) {
            for (VSysUserRoleDomain domain : domainList) {
                SpinnerVo spinnerVo = new SpinnerVo();
                spinnerVo.setId(domain.getDomainId());
                spinnerVo.setText(domain.getDomainName());
                if(!spinnerVoList.contains(spinnerVo)){
                    spinnerVoList.add(spinnerVo);
                }
            }
        }
        msg.setSuccess(true);
        msg.setData(spinnerVoList);
        return msg;
    }

    /*当前用户特定域菜单*/
    @ResponseBody
    @GetMapping("/mymenu")
    public Msg getMyMenu(String domainId) {
        JesUserDetails currentUser = (JesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<SysMenu> list = this.sysMenuService.getByUserAndDomain(currentUser.getId(),domainId);
        SysMenu root=new SysMenu();
        root.setId("-1");
        root.setName("root");
        list.add(root);
        this.sysMenuTreeViewService.setTreeVoList(list);
        TreeVo treeVo = this.sysMenuTreeViewService.convertToTree();
        Msg msg = new Msg();
        msg.setSuccess(true);
        msg.setData(treeVo.getNodes());
        return msg;
    }

    /*修改密码*/
    @ResponseBody
    @PostMapping("/change/mypwd")
    public Msg changeMyPwd(String newpwd,String oldpwd) {
        Msg msg = new Msg();
        JesUserDetails currentUser = (JesUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            this.sysUserService.changePassword(currentUser.getId(),newpwd,oldpwd);
            msg.setSuccess(true);
        } catch (AppException e) {
            msg.setSuccess(false);
            msg.setInfo(e.getMessage());
        }
        return msg;
    }

}
