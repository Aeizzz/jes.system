CREATE TABLE sys_area
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    parent_id VARCHAR(64) NOT NULL COMMENT '父级编号',
    parent_ids VARCHAR(2000) NOT NULL COMMENT '所有父级编号',
    name VARCHAR(100) NOT NULL COMMENT '名称',
    sort DECIMAL(10) COMMENT '排序',
    code VARCHAR(100) NOT NULL COMMENT '行政区划代码',
    type CHAR(1) COMMENT '区域类型',
    create_by VARCHAR(64) COMMENT '创建者',
    create_date DATETIME COMMENT '创建时间',
    update_by VARCHAR(64) COMMENT '更新者',
    update_date DATETIME COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息',
    del_flag CHAR(1) DEFAULT '0' COMMENT '删除标记'
);
CREATE INDEX sys_area_del_flag ON sys_area (del_flag);
CREATE INDEX sys_area_parent_id ON sys_area (parent_id);
CREATE TABLE sys_dict
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    parent_id VARCHAR(64) DEFAULT '0' COMMENT '父级编号',
    parent_ids VARCHAR(64) DEFAULT '0' COMMENT '所有父级编号',
    name VARCHAR(100) NOT NULL COMMENT '名称',
    code VARCHAR(100) NOT NULL COMMENT '代码',
    type VARCHAR(100) NOT NULL COMMENT '类型(分类/项目)',
    description VARCHAR(100) NOT NULL COMMENT '描述',
    sort DECIMAL(10) NOT NULL COMMENT '排序（升序）',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息',
    domain_id VARCHAR(64) NOT NULL COMMENT '所属域'
);
CREATE INDEX sys_dict_label ON sys_dict (name);
CREATE INDEX sys_dict_value ON sys_dict (code);
CREATE TABLE sys_domain
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    name VARCHAR(100) NOT NULL COMMENT '名称',
    code VARCHAR(255) COMMENT '编码',
    home_page VARCHAR(255) COMMENT '地址',
    useable VARCHAR(64) COMMENT '是否可用',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息'
);
CREATE INDEX sys_role_enname ON sys_domain (code);
CREATE TABLE sys_mdict
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    parent_id VARCHAR(64) NOT NULL COMMENT '父级编号',
    parent_ids VARCHAR(2000) NOT NULL COMMENT '所有父级编号',
    name VARCHAR(100) NOT NULL COMMENT '名称',
    sort DECIMAL(10) NOT NULL COMMENT '排序',
    description VARCHAR(100) COMMENT '描述',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息',
    del_flag CHAR(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
    domain_id VARCHAR(64) NOT NULL COMMENT '域ID'
);
CREATE INDEX sys_mdict_del_flag ON sys_mdict (del_flag);
CREATE INDEX sys_mdict_parent_id ON sys_mdict (parent_id);
CREATE TABLE sys_menu
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    parent_id VARCHAR(64) NOT NULL COMMENT '父级编号',
    parent_ids VARCHAR(2000) COMMENT '所有父级编号',
    name VARCHAR(100) NOT NULL COMMENT '名称',
    sort DECIMAL(10) NOT NULL COMMENT '排序',
    href VARCHAR(2000) COMMENT '链接',
    target VARCHAR(20) COMMENT '目标',
    icon VARCHAR(100) COMMENT '图标',
    is_show CHAR(1) NOT NULL COMMENT '是否在菜单中显示',
    permission VARCHAR(200) COMMENT '权限标识',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息',
    del_flag CHAR(1) DEFAULT '0' NOT NULL COMMENT '删除标记',
    domain_id VARCHAR(64) NOT NULL COMMENT '域ID'
);
CREATE INDEX sys_menu_del_flag ON sys_menu (del_flag);
CREATE INDEX sys_menu_parent_id ON sys_menu (parent_id);
CREATE TABLE sys_office
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    parent_id VARCHAR(64) NOT NULL COMMENT '父级编号',
    parent_ids VARCHAR(2000) NOT NULL COMMENT '所有父级编号',
    name VARCHAR(100) NOT NULL COMMENT '名称',
    sort DECIMAL(10) NOT NULL COMMENT '排序',
    area_id VARCHAR(64) NOT NULL COMMENT '归属区域',
    code VARCHAR(100) COMMENT '区域编码',
    type CHAR(1) NOT NULL COMMENT '机构类型',
    grade CHAR(1) NOT NULL COMMENT '机构等级',
    address VARCHAR(255) COMMENT '联系地址',
    zip_code VARCHAR(100) COMMENT '邮政编码',
    master VARCHAR(100) COMMENT '负责人',
    phone VARCHAR(200) COMMENT '电话',
    fax VARCHAR(200) COMMENT '传真',
    email VARCHAR(200) COMMENT '邮箱',
    USEABLE VARCHAR(64) COMMENT '是否启用',
    PRIMARY_PERSON VARCHAR(64) COMMENT '主负责人',
    DEPUTY_PERSON VARCHAR(64) COMMENT '副负责人',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息',
    del_flag CHAR(1) DEFAULT '0' NOT NULL COMMENT '删除标记'
);
CREATE INDEX sys_office_del_flag ON sys_office (del_flag);
CREATE INDEX sys_office_parent_id ON sys_office (parent_id);
CREATE INDEX sys_office_type ON sys_office (type);
CREATE TABLE sys_param
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    domain_id VARCHAR(64) NOT NULL COMMENT '所属域',
    name VARCHAR(100) NOT NULL COMMENT '参数名',
    code VARCHAR(64) COMMENT '参数代码',
    value VARCHAR(100) NOT NULL COMMENT '参数值',
    description VARCHAR(100) NOT NULL COMMENT '描述',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息'
);
CREATE INDEX sys_dict_label ON sys_param (name);
CREATE INDEX sys_dict_value ON sys_param (value);
CREATE TABLE sys_role
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    office_id VARCHAR(64) COMMENT '归属机构',
    domain_id VARCHAR(64) NOT NULL COMMENT '所属域',
    enname VARCHAR(255) COMMENT '角色代码',
    name VARCHAR(100) NOT NULL COMMENT '角色名称',
    role_type VARCHAR(255) COMMENT '角色类型',
    data_scope CHAR(1) COMMENT '数据范围',
    is_sys VARCHAR(64) COMMENT '是否系统数据',
    useable VARCHAR(64) COMMENT '是否可用',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息',
    del_flag CHAR(1) DEFAULT '0' NOT NULL COMMENT '删除标记'
);
CREATE INDEX sys_role_del_flag ON sys_role (del_flag);
CREATE INDEX sys_role_enname ON sys_role (enname);
CREATE INDEX sys_role_ibfk_1 ON sys_role (domain_id);
CREATE TABLE sys_role_menu
(
    role_id VARCHAR(64) NOT NULL COMMENT '角色编号',
    menu_id VARCHAR(64) NOT NULL COMMENT '菜单编号',
    CONSTRAINT `PRIMARY` PRIMARY KEY (role_id, menu_id)
);
CREATE TABLE sys_role_office
(
    role_id VARCHAR(64) NOT NULL COMMENT '角色编号',
    office_id VARCHAR(64) NOT NULL COMMENT '机构编号',
    CONSTRAINT `PRIMARY` PRIMARY KEY (role_id, office_id)
);
CREATE TABLE sys_user
(
    id VARCHAR(64) PRIMARY KEY NOT NULL COMMENT '编号',
    company_id VARCHAR(64) COMMENT '归属公司',
    office_id VARCHAR(64) COMMENT '归属部门',
    login_name VARCHAR(100) NOT NULL COMMENT '登录名',
    password VARCHAR(100) NOT NULL COMMENT '密码',
    no VARCHAR(100) COMMENT '工号',
    name VARCHAR(100) NOT NULL COMMENT '姓名',
    email VARCHAR(200) COMMENT '邮箱',
    phone VARCHAR(200) COMMENT '电话',
    mobile VARCHAR(200) COMMENT '手机',
    user_type CHAR(1) COMMENT '用户类型',
    photo VARCHAR(1000) COMMENT '用户头像',
    login_ip VARCHAR(100) COMMENT '最后登陆IP',
    login_date DATETIME COMMENT '最后登陆时间',
    login_flag VARCHAR(64) COMMENT '是否可登录',
    create_by VARCHAR(64) NOT NULL COMMENT '创建者',
    create_date DATETIME NOT NULL COMMENT '创建时间',
    update_by VARCHAR(64) NOT NULL COMMENT '更新者',
    update_date DATETIME NOT NULL COMMENT '更新时间',
    remarks VARCHAR(255) COMMENT '备注信息',
    del_flag CHAR(1) DEFAULT '0' NOT NULL COMMENT '删除标记'
);
CREATE INDEX sys_user_company_id ON sys_user (company_id);
CREATE INDEX sys_user_del_flag ON sys_user (del_flag);
CREATE INDEX sys_user_login_name ON sys_user (login_name);
CREATE INDEX sys_user_office_id ON sys_user (office_id);
CREATE INDEX sys_user_update_date ON sys_user (update_date);
CREATE TABLE sys_user_role
(
    user_id VARCHAR(64) NOT NULL COMMENT '用户编号',
    role_id VARCHAR(64) NOT NULL COMMENT '角色编号',
    CONSTRAINT `PRIMARY` PRIMARY KEY (user_id, role_id)
);