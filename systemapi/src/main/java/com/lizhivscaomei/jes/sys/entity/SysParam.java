package com.lizhivscaomei.jes.sys.entity;

import java.io.Serializable;
import java.util.Date;

public class SysParam implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.code
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.value
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String value;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.label
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String label;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.description
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String description;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.create_by
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.create_date
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.update_by
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String updateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.update_date
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private Date updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.remarks
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String remarks;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.del_flag
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String delFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_param.domain_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String domainId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_param
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.id
     *
     * @return the value of sys_param.id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.id
     *
     * @param id the value for sys_param.id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.code
     *
     * @return the value of sys_param.code
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.code
     *
     * @param code the value for sys_param.code
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.value
     *
     * @return the value of sys_param.value
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getValue() {
        return value;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.value
     *
     * @param value the value for sys_param.value
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.label
     *
     * @return the value of sys_param.label
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getLabel() {
        return label;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.label
     *
     * @param label the value for sys_param.label
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.description
     *
     * @return the value of sys_param.description
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.description
     *
     * @param description the value for sys_param.description
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.create_by
     *
     * @return the value of sys_param.create_by
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.create_by
     *
     * @param createBy the value for sys_param.create_by
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.create_date
     *
     * @return the value of sys_param.create_date
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.create_date
     *
     * @param createDate the value for sys_param.create_date
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.update_by
     *
     * @return the value of sys_param.update_by
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.update_by
     *
     * @param updateBy the value for sys_param.update_by
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.update_date
     *
     * @return the value of sys_param.update_date
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.update_date
     *
     * @param updateDate the value for sys_param.update_date
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.remarks
     *
     * @return the value of sys_param.remarks
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.remarks
     *
     * @param remarks the value for sys_param.remarks
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.del_flag
     *
     * @return the value of sys_param.del_flag
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.del_flag
     *
     * @param delFlag the value for sys_param.del_flag
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_param.domain_id
     *
     * @return the value of sys_param.domain_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getDomainId() {
        return domainId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_param.domain_id
     *
     * @param domainId the value for sys_param.domain_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setDomainId(String domainId) {
        this.domainId = domainId == null ? null : domainId.trim();
    }
}