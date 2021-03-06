package com.lizhivscaomei.jes.sys.entity;

import java.util.Date;

public class SysArea {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.id
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.parent_id
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String parentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.parent_ids
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String parentIds;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.code
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.name
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.sort
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private Long sort;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.type
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String type;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.create_by
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.create_date
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.update_by
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.update_date
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.remarks
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_area.del_flag
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    private String delFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.id
     *
     * @return the value of sys_area.id
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.id
     *
     * @param id the value for sys_area.id
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.parent_id
     *
     * @return the value of sys_area.parent_id
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.parent_id
     *
     * @param parentId the value for sys_area.parent_id
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.parent_ids
     *
     * @return the value of sys_area.parent_ids
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.parent_ids
     *
     * @param parentIds the value for sys_area.parent_ids
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.code
     *
     * @return the value of sys_area.code
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.code
     *
     * @param code the value for sys_area.code
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.name
     *
     * @return the value of sys_area.name
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.name
     *
     * @param name the value for sys_area.name
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.sort
     *
     * @return the value of sys_area.sort
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public Long getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.sort
     *
     * @param sort the value for sys_area.sort
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.type
     *
     * @return the value of sys_area.type
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.type
     *
     * @param type the value for sys_area.type
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.create_by
     *
     * @return the value of sys_area.create_by
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.create_by
     *
     * @param createBy the value for sys_area.create_by
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.create_date
     *
     * @return the value of sys_area.create_date
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.create_date
     *
     * @param createDate the value for sys_area.create_date
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.update_by
     *
     * @return the value of sys_area.update_by
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.update_by
     *
     * @param updateBy the value for sys_area.update_by
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.update_date
     *
     * @return the value of sys_area.update_date
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.update_date
     *
     * @param updateDate the value for sys_area.update_date
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.remarks
     *
     * @return the value of sys_area.remarks
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.remarks
     *
     * @param remarks the value for sys_area.remarks
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_area.del_flag
     *
     * @return the value of sys_area.del_flag
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_area.del_flag
     *
     * @param delFlag the value for sys_area.del_flag
     *
     * @mbggenerated Wed Jun 06 16:37:19 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}