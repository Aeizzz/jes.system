package com.lizhivscaomei.jes.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysMenu implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.parent_id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.parent_ids
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String parentIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.name
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.sort
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private Long sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.href
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String href;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.target
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String target;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.icon
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String icon;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.is_show
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String isShow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.permission
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String permission;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.create_by
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.create_date
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.update_by
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.update_date
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.remarks
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.del_flag
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_menu.domain_id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private String domainId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.id
     *
     * @return the value of sys_menu.id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.id
     *
     * @param id the value for sys_menu.id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.parent_id
     *
     * @return the value of sys_menu.parent_id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.parent_id
     *
     * @param parentId the value for sys_menu.parent_id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.parent_ids
     *
     * @return the value of sys_menu.parent_ids
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.parent_ids
     *
     * @param parentIds the value for sys_menu.parent_ids
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.name
     *
     * @return the value of sys_menu.name
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.name
     *
     * @param name the value for sys_menu.name
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.sort
     *
     * @return the value of sys_menu.sort
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public Long getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.sort
     *
     * @param sort the value for sys_menu.sort
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.href
     *
     * @return the value of sys_menu.href
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getHref() {
        return href;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.href
     *
     * @param href the value for sys_menu.href
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setHref(String href) {
        this.href = href == null ? null : href.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.target
     *
     * @return the value of sys_menu.target
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getTarget() {
        return target;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.target
     *
     * @param target the value for sys_menu.target
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.icon
     *
     * @return the value of sys_menu.icon
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.icon
     *
     * @param icon the value for sys_menu.icon
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.is_show
     *
     * @return the value of sys_menu.is_show
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.is_show
     *
     * @param isShow the value for sys_menu.is_show
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.permission
     *
     * @return the value of sys_menu.permission
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getPermission() {
        return permission;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.permission
     *
     * @param permission the value for sys_menu.permission
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.create_by
     *
     * @return the value of sys_menu.create_by
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.create_by
     *
     * @param createBy the value for sys_menu.create_by
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.create_date
     *
     * @return the value of sys_menu.create_date
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.create_date
     *
     * @param createDate the value for sys_menu.create_date
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.update_by
     *
     * @return the value of sys_menu.update_by
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.update_by
     *
     * @param updateBy the value for sys_menu.update_by
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.update_date
     *
     * @return the value of sys_menu.update_date
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.update_date
     *
     * @param updateDate the value for sys_menu.update_date
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.remarks
     *
     * @return the value of sys_menu.remarks
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.remarks
     *
     * @param remarks the value for sys_menu.remarks
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.del_flag
     *
     * @return the value of sys_menu.del_flag
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.del_flag
     *
     * @param delFlag the value for sys_menu.del_flag
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_menu.domain_id
     *
     * @return the value of sys_menu.domain_id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_menu.domain_id
     *
     * @param domainId the value for sys_menu.domain_id
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public void setDomainId(String domainId) {
        this.domainId = domainId == null ? null : domainId.trim();
    }
}