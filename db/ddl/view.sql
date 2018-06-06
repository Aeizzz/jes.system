SELECT DISTINCT
	`t`.`user_id` AS `user_id`,
	`menu`.`id` AS `id`,
	`menu`.`parent_id` AS `parent_id`,
	`menu`.`parent_ids` AS `parent_ids`,
	`menu`.`name` AS `name`,
	`menu`.`sort` AS `sort`,
	`menu`.`href` AS `href`,
	`menu`.`target` AS `target`,
	`menu`.`icon` AS `icon`,
	`menu`.`is_show` AS `is_show`,
	`menu`.`permission` AS `permission`,
	`menu`.`create_by` AS `create_by`,
	`menu`.`create_date` AS `create_date`,
	`menu`.`update_by` AS `update_by`,
	`menu`.`update_date` AS `update_date`,
	`menu`.`remarks` AS `remarks`,
	`menu`.`del_flag` AS `del_flag`,
	`menu`.`domain_id` AS `domain_id`
FROM
	(
		(
			`sys_user_role` `t`
			LEFT JOIN `sys_role_menu` `t2` ON (
				(
					`t2`.`role_id` = `t`.`role_id`
				)
			)
		)
		LEFT JOIN `sys_menu` `menu` ON (
			(`menu`.`id` = `t2`.`menu_id`)
		)
	)
ORDER BY
	`menu`.`sort`