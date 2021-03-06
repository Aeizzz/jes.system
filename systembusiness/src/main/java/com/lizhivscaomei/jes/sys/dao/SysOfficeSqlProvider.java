package com.lizhivscaomei.jes.sys.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.lizhivscaomei.jes.sys.entity.SysOffice;
import com.lizhivscaomei.jes.sys.entity.SysOfficeExample.Criteria;
import com.lizhivscaomei.jes.sys.entity.SysOfficeExample.Criterion;
import com.lizhivscaomei.jes.sys.entity.SysOfficeExample;
import java.util.List;
import java.util.Map;

public class SysOfficeSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    public String countByExample(SysOfficeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_office");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    public String deleteByExample(SysOfficeExample example) {
        BEGIN();
        DELETE_FROM("sys_office");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    public String insertSelective(SysOffice record) {
        BEGIN();
        INSERT_INTO("sys_office");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentIds() != null) {
            VALUES("parent_ids", "#{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            VALUES("sort", "#{sort,jdbcType=DECIMAL}");
        }
        
        if (record.getAreaId() != null) {
            VALUES("area_id", "#{areaId,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            VALUES("type", "#{type,jdbcType=CHAR}");
        }
        
        if (record.getGrade() != null) {
            VALUES("grade", "#{grade,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            VALUES("address", "#{address,jdbcType=VARCHAR}");
        }
        
        if (record.getZipCode() != null) {
            VALUES("zip_code", "#{zipCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaster() != null) {
            VALUES("master", "#{master,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            VALUES("fax", "#{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getUseable() != null) {
            VALUES("USEABLE", "#{useable,jdbcType=VARCHAR}");
        }
        
        if (record.getPrimaryPerson() != null) {
            VALUES("PRIMARY_PERSON", "#{primaryPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getDeputyPerson() != null) {
            VALUES("DEPUTY_PERSON", "#{deputyPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            VALUES("create_by", "#{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            VALUES("create_date", "#{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            VALUES("update_by", "#{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            VALUES("update_date", "#{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            VALUES("remarks", "#{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            VALUES("del_flag", "#{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getDomainId() != null) {
            VALUES("domain_id", "#{domainId,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    public String selectByExample(SysOfficeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("parent_id");
        SELECT("parent_ids");
        SELECT("name");
        SELECT("sort");
        SELECT("area_id");
        SELECT("code");
        SELECT("type");
        SELECT("grade");
        SELECT("address");
        SELECT("zip_code");
        SELECT("master");
        SELECT("phone");
        SELECT("fax");
        SELECT("email");
        SELECT("USEABLE");
        SELECT("PRIMARY_PERSON");
        SELECT("DEPUTY_PERSON");
        SELECT("create_by");
        SELECT("create_date");
        SELECT("update_by");
        SELECT("update_date");
        SELECT("remarks");
        SELECT("del_flag");
        SELECT("domain_id");
        FROM("sys_office");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysOffice record = (SysOffice) parameter.get("record");
        SysOfficeExample example = (SysOfficeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_office");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentIds() != null) {
            SET("parent_ids = #{record.parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            SET("sort = #{record.sort,jdbcType=DECIMAL}");
        }
        
        if (record.getAreaId() != null) {
            SET("area_id = #{record.areaId,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{record.type,jdbcType=CHAR}");
        }
        
        if (record.getGrade() != null) {
            SET("grade = #{record.grade,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{record.address,jdbcType=VARCHAR}");
        }
        
        if (record.getZipCode() != null) {
            SET("zip_code = #{record.zipCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaster() != null) {
            SET("master = #{record.master,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            SET("fax = #{record.fax,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getUseable() != null) {
            SET("USEABLE = #{record.useable,jdbcType=VARCHAR}");
        }
        
        if (record.getPrimaryPerson() != null) {
            SET("PRIMARY_PERSON = #{record.primaryPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getDeputyPerson() != null) {
            SET("DEPUTY_PERSON = #{record.deputyPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            SET("del_flag = #{record.delFlag,jdbcType=CHAR}");
        }
        
        if (record.getDomainId() != null) {
            SET("domain_id = #{record.domainId,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_office");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        SET("parent_ids = #{record.parentIds,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("sort = #{record.sort,jdbcType=DECIMAL}");
        SET("area_id = #{record.areaId,jdbcType=VARCHAR}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("type = #{record.type,jdbcType=CHAR}");
        SET("grade = #{record.grade,jdbcType=CHAR}");
        SET("address = #{record.address,jdbcType=VARCHAR}");
        SET("zip_code = #{record.zipCode,jdbcType=VARCHAR}");
        SET("master = #{record.master,jdbcType=VARCHAR}");
        SET("phone = #{record.phone,jdbcType=VARCHAR}");
        SET("fax = #{record.fax,jdbcType=VARCHAR}");
        SET("email = #{record.email,jdbcType=VARCHAR}");
        SET("USEABLE = #{record.useable,jdbcType=VARCHAR}");
        SET("PRIMARY_PERSON = #{record.primaryPerson,jdbcType=VARCHAR}");
        SET("DEPUTY_PERSON = #{record.deputyPerson,jdbcType=VARCHAR}");
        SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        SET("del_flag = #{record.delFlag,jdbcType=CHAR}");
        SET("domain_id = #{record.domainId,jdbcType=VARCHAR}");
        
        SysOfficeExample example = (SysOfficeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    public String updateByPrimaryKeySelective(SysOffice record) {
        BEGIN();
        UPDATE("sys_office");
        
        if (record.getParentId() != null) {
            SET("parent_id = #{parentId,jdbcType=VARCHAR}");
        }
        
        if (record.getParentIds() != null) {
            SET("parent_ids = #{parentIds,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getSort() != null) {
            SET("sort = #{sort,jdbcType=DECIMAL}");
        }
        
        if (record.getAreaId() != null) {
            SET("area_id = #{areaId,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            SET("type = #{type,jdbcType=CHAR}");
        }
        
        if (record.getGrade() != null) {
            SET("grade = #{grade,jdbcType=CHAR}");
        }
        
        if (record.getAddress() != null) {
            SET("address = #{address,jdbcType=VARCHAR}");
        }
        
        if (record.getZipCode() != null) {
            SET("zip_code = #{zipCode,jdbcType=VARCHAR}");
        }
        
        if (record.getMaster() != null) {
            SET("master = #{master,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFax() != null) {
            SET("fax = #{fax,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getUseable() != null) {
            SET("USEABLE = #{useable,jdbcType=VARCHAR}");
        }
        
        if (record.getPrimaryPerson() != null) {
            SET("PRIMARY_PERSON = #{primaryPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getDeputyPerson() != null) {
            SET("DEPUTY_PERSON = #{deputyPerson,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateBy() != null) {
            SET("create_by = #{createBy,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateDate() != null) {
            SET("create_date = #{createDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateBy() != null) {
            SET("update_by = #{updateBy,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateDate() != null) {
            SET("update_date = #{updateDate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemarks() != null) {
            SET("remarks = #{remarks,jdbcType=VARCHAR}");
        }
        
        if (record.getDelFlag() != null) {
            SET("del_flag = #{delFlag,jdbcType=CHAR}");
        }
        
        if (record.getDomainId() != null) {
            SET("domain_id = #{domainId,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_office
     *
     * @mbggenerated Wed Mar 28 21:19:21 CST 2018
     */
    protected void applyWhere(SysOfficeExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}