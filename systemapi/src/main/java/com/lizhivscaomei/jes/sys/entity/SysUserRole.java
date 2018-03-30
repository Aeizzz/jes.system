package com.lizhivscaomei.jes.sys.entity;

import java.io.Serializable;

public class SysUserRole implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.user_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.role_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private String roleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table sys_user_role
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.user_id
     *
     * @return the value of sys_user_role.user_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.user_id
     *
     * @param userId the value for sys_user_role.user_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.role_id
     *
     * @return the value of sys_user_role.role_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.role_id
     *
     * @param roleId the value for sys_user_role.role_id
     *
     * @mbggenerated Wed Mar 28 21:06:18 CST 2018
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }
}