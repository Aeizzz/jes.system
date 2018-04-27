package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.common.view.tree.TreeViewService;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysMenu;
import org.springframework.stereotype.Service;

/**
 * Created by lizhi on 2018/4/23.
 */
@Service
public class SysMenuTreeViewService  extends TreeViewService<SysMenu>{
    @Override
    public TreeVo convertDTO(SysMenu sysMenu) {
        TreeVo vo=new TreeVo();
        vo.setId(sysMenu.getId());
        vo.setPid(sysMenu.getParentId());
        vo.setText(sysMenu.getName());
        vo.setIcon(sysMenu.getIcon());
        vo.setHref(sysMenu.getHref());
        return vo;
    }
}
