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

import com.lizhivscaomei.jes.sys.entity.SysMenu;
import com.lizhivscaomei.jes.sys.entity.SysMenuExample.Criteria;
import com.lizhivscaomei.jes.sys.entity.SysMenuExample.Criterion;
import com.lizhivscaomei.jes.sys.entity.SysMenuExample;
import java.util.List;
import java.util.Map;

public class SysMenuSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String countByExample(SysMenuExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("sys_menu");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String deleteByExample(SysMenuExample example) {
        BEGIN();
        DELETE_FROM("sys_menu");
        applyWhere(example, false);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String insertSelective(SysMenu record) {
        BEGIN();
        INSERT_INTO("sys_menu");
        
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
        
        if (record.getHref() != null) {
            VALUES("href", "#{href,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            VALUES("target", "#{target,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            VALUES("is_show", "#{isShow,jdbcType=CHAR}");
        }
        
        if (record.getPermission() != null) {
            VALUES("permission", "#{permission,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String selectByExample(SysMenuExample example) {
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
        SELECT("href");
        SELECT("target");
        SELECT("icon");
        SELECT("is_show");
        SELECT("permission");
        SELECT("create_by");
        SELECT("create_date");
        SELECT("update_by");
        SELECT("update_date");
        SELECT("remarks");
        SELECT("del_flag");
        SELECT("domain_id");
        FROM("sys_menu");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysMenu record = (SysMenu) parameter.get("record");
        SysMenuExample example = (SysMenuExample) parameter.get("example");
        
        BEGIN();
        UPDATE("sys_menu");
        
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
        
        if (record.getHref() != null) {
            SET("href = #{record.href,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            SET("target = #{record.target,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            SET("is_show = #{record.isShow,jdbcType=CHAR}");
        }
        
        if (record.getPermission() != null) {
            SET("permission = #{record.permission,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("sys_menu");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        SET("parent_ids = #{record.parentIds,jdbcType=VARCHAR}");
        SET("name = #{record.name,jdbcType=VARCHAR}");
        SET("sort = #{record.sort,jdbcType=DECIMAL}");
        SET("href = #{record.href,jdbcType=VARCHAR}");
        SET("target = #{record.target,jdbcType=VARCHAR}");
        SET("icon = #{record.icon,jdbcType=VARCHAR}");
        SET("is_show = #{record.isShow,jdbcType=CHAR}");
        SET("permission = #{record.permission,jdbcType=VARCHAR}");
        SET("create_by = #{record.createBy,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=TIMESTAMP}");
        SET("update_by = #{record.updateBy,jdbcType=VARCHAR}");
        SET("update_date = #{record.updateDate,jdbcType=TIMESTAMP}");
        SET("remarks = #{record.remarks,jdbcType=VARCHAR}");
        SET("del_flag = #{record.delFlag,jdbcType=CHAR}");
        SET("domain_id = #{record.domainId,jdbcType=VARCHAR}");
        
        SysMenuExample example = (SysMenuExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    public String updateByPrimaryKeySelective(SysMenu record) {
        BEGIN();
        UPDATE("sys_menu");
        
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
        
        if (record.getHref() != null) {
            SET("href = #{href,jdbcType=VARCHAR}");
        }
        
        if (record.getTarget() != null) {
            SET("target = #{target,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getIsShow() != null) {
            SET("is_show = #{isShow,jdbcType=CHAR}");
        }
        
        if (record.getPermission() != null) {
            SET("permission = #{permission,jdbcType=VARCHAR}");
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
     * This method corresponds to the database table sys_menu
     *
     * @mbggenerated Fri May 18 17:40:52 CST 2018
     */
    protected void applyWhere(SysMenuExample example, boolean includeExamplePhrase) {
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