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

import com.lizhivscaomei.jes.sys.entity.SysParam;
import com.lizhivscaomei.jes.sys.entity.SysParamExample.Criteria;
import com.lizhivscaomei.jes.sys.entity.SysParamExample.Criterion;
import com.lizhivscaomei.jes.sys.entity.SysParamExample;
import java.util.List;
import java.util.Map;

public class SysParamSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    public String countByExample(SysParamExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_param");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    public String deleteByExample(SysParamExample example) {
        BEGIN();
        DELETE_FROM("sys_param");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    public String insertSelective(SysParam record) {
        BEGIN();
        INSERT_INTO("sys_param");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            VALUES("value", "#{value,jdbcType=VARCHAR}");
        }
        
        if (record.getLabel() != null) {
            VALUES("label", "#{label,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    public String selectByExample(SysParamExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("code");
        SELECT("value");
        SELECT("label");
        SELECT("description");
        SELECT("create_by");
        SELECT("create_date");
        SELECT("update_by");
        SELECT("update_date");
        SELECT("remarks");
        SELECT("del_flag");
        SELECT("domain_id");
        FROM("sys_param");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysParam record = (SysParam) parameter.get("record");
        SysParamExample example = (SysParamExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_param");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            SET("value = #{record.value,jdbcType=VARCHAR}");
        }
        
        if (record.getLabel() != null) {
            SET("label = #{record.label,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{record.description,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_param");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("code = #{record.code,jdbcType=VARCHAR}");
        SET("value = #{record.value,jdbcType=VARCHAR}");
        SET("label = #{record.label,jdbcType=VARCHAR}");
        SET("description = #{record.description,jdbcType=VARCHAR}");
        SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        SET("del_flag = #{record.delFlag,jdbcType=CHAR}");
        SET("domain_id = #{record.domainId,jdbcType=VARCHAR}");
        
        SysParamExample example = (SysParamExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    public String updateByPrimaryKeySelective(SysParam record) {
        BEGIN();
        UPDATE("sys_param");
        
        if (record.getCode() != null) {
            SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            SET("value = #{value,jdbcType=VARCHAR}");
        }
        
        if (record.getLabel() != null) {
            SET("label = #{label,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table sys_param
     *
     * @mbggenerated Wed Apr 18 09:53:45 CST 2018
     */
    protected void applyWhere(SysParamExample example, boolean includeExamplePhrase) {
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