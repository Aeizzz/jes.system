package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.common.view.tree.TreeViewService;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysArea;
import com.lizhivscaomei.jes.sys.entity.SysDict;
import org.springframework.stereotype.Service;

/**
 * Created by lizhi on 2018/4/23.
 */
@Service
public class SysAreaTreeViewService extends TreeViewService<SysArea>{
    @Override
    public TreeVo convertDTO(SysArea sysArea) {
        this.setRootId("0");
        TreeVo vo=new TreeVo();
        vo.setId(sysArea.getId());
        vo.setPid(sysArea.getParentId());
        vo.setText(sysArea.getName()+"（"+sysArea.getCode()+"）");
        return vo;
    }
}
