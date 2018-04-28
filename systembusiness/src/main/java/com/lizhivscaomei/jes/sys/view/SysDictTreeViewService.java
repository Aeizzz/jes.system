package com.lizhivscaomei.jes.sys.view;

import com.lizhivscaomei.jes.common.view.tree.TreeViewService;
import com.lizhivscaomei.jes.common.view.tree.TreeVo;
import com.lizhivscaomei.jes.sys.entity.SysDict;
import org.springframework.stereotype.Service;

/**
 * Created by lizhi on 2018/4/23.
 */
@Service
public class SysDictTreeViewService extends TreeViewService<SysDict>{
    @Override
    public TreeVo convertDTO(SysDict sysDict) {
        this.setRootId("0");
        TreeVo vo=new TreeVo();
        vo.setId(sysDict.getId());
        vo.setPid(sysDict.getParentId());
        vo.setText(sysDict.getName());
        return vo;
    }
}
