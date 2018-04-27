<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>用户管理</title>
    <%@ include file="/jsp/public/commonTable.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">用户管理</h3>
            </div>

            <div class="panel-body">
                <div class="span12">
                    <div class="btn-group">
                        <button class="btn btn-default" type="button" onclick="add()">添加</button>
                        <%--<button class="btn btn-default" type="button" onclick="query()">刷新</button>--%>
                    </div>
                    <%--<div class="btn-group">--%>
                    <%--<button class="btn btn-default" type="button" onclick="superQuery()" >高级查询</button>--%>
                    <%--</div>--%>

                    <hr>
                    <table id="datatable" class="table">

                    </table>
                </div>

            </div>

            <div class="panel-footer"></div>
        </div>

    </div>
</div>
<!-- 弹窗 增加 修改 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header  bg-primary">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="editModalLabel">未知</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal no-margin form-border" method="post" name="entityForm" id="entityForm">
                    <div class="form-group">
                        <label class="control-label col-xs-4">归属公司：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="companyId" name="companyId"
                                   v-model="form.data.companyId"
                                   placeholder="请输入归属公司">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">归属部门：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="officeId" name="officeId"
                                   v-model="form.data.officeId"
                                   placeholder="请输入归属部门">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">登录名：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="loginName" name="loginName"
                                   v-model="form.data.loginName"
                                   placeholder="请输入登录名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">密码：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="password" name="password"
                                   v-model="form.data.password"
                                   placeholder="请输入密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">工号：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="no" name="no" v-model="form.data.no"
                                   placeholder="请输入工号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">姓名：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="name" name="name" v-model="form.data.name"
                                   placeholder="请输入姓名">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">邮箱：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="email" name="email" v-model="form.data.email"
                                   placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">电话：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="phone" name="phone" v-model="form.data.phone"
                                   placeholder="请输入电话">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">手机：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="mobile" name="mobile" v-model="form.data.mobile"
                                   placeholder="请输入手机">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">用户类型：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="userType" name="userType"
                                   v-model="form.data.userType"
                                   placeholder="请输入用户类型">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">用户头像：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="photo" name="photo" v-model="form.data.photo"
                                   placeholder="请输入用户头像">
                        </div>
                    </div>
                    <%--<div class="form-group">
                        <label class="control-label col-xs-4">最后登陆IP：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="loginIp"  name="loginIp"
                                   placeholder="请输入最后登陆IP">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">最后登陆时间：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="loginDate"  name="loginDate"
                                   placeholder="请输入最后登陆时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">是否可登录：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="loginFlag"  name="loginFlag"
                                   placeholder="请输入是否可登录">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">创建者：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="createBy"  name="createBy"
                                   placeholder="请输入创建者">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">创建时间：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="createDate"  name="createDate"
                                   placeholder="请输入创建时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">更新者：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="updateBy"  name="updateBy"
                                   placeholder="请输入更新者">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">更新时间：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="updateDate"  name="updateDate"
                                   placeholder="请输入更新时间">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">备注信息：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="remarks"  name="remarks"
                                   placeholder="请输入备注信息">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">删除标记：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="delFlag"  name="delFlag"
                                   placeholder="请输入删除标记">
                        </div>
                    </div>--%>
                    <input type="hidden" name="id" id="id" v-model="form.data.id">

                </form>
            </div>
            <div class="modal-footer" id="modal-actions">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="saveForm()">保存</button>
            </div>
        </div>
    </div>
</div>
<!-- 删除确认-->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header bg-danger">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title modal-title-primary" id="deleteModalLabel"><i
                        class="fa fa-exclamation-circle"></i>删除</h4>
            </div>
            <div class="modal-body">
                <p id="confirmMsg"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger" id="deleteConfirmBtn">确认</button>
            </div>
        </div>
    </div>
</div>
<%--操作提示--%>
<div class="alert hidden" id="alert" style="position: fixed;right: 10px;top: 10px;width: 300px;">
    <a href="#" class="close" data-dismiss="alert">
        &times;
    </a>
    <div id="alertMessage"></div>
</div>
<script>
    var datatable;
    $(function () {
        createTable();
    });
    //初始化表格
    function createTable() {
        var queryBaseUr = "/com/lizhivscaomei/jes/sys/controller/sysUser/query/page";
        var options = {};
        $.extend(options, dataTableJesOptions);
        options.ajax = {url: queryBaseUr};
        options.columns = [
            {
                "title": "序号",
                "data": "id"
            },
            {
                "title": "姓名",
                "data": "name"
            },
            {
                "title": "工号",
                "data": "no"
            },
            {
                "title": "登录名",
                "data": "loginName"
            },
            {
                "title": "用户类型",
                "data": "userType"
            },
            /* {
             "title": "归属公司",
             "data": "companyId"
             },*/
            {
                "title": "归属部门",
                "data": "officeId"
            },
            /* {
             "title": "密码",
             "data": "password"
             },*/
            {
                "title": "邮箱",
                "data": "email"
            },
            {
                "title": "电话",
                "data": "phone"
            },
            /*{
             "title": "手机",
             "data": "mobile"
             },*/
            /*{
             "title": "用户头像",
             "data": "photo"
             },
             {
             "title": "最后登陆IP",
             "data": "loginIp"
             },
             {
             "title": "最后登陆时间",
             "data": "loginDate"
             },
             {
             "title": "是否可登录",
             "data": "loginFlag"
             },
             {
             "title": "创建者",
             "data": "createBy"
             },
             {
             "title": "创建时间",
             "data": "createDate"
             },
             {
             "title": "更新者",
             "data": "updateBy"
             },
             {
             "title": "更新时间",
             "data": "updateDate"
             },*/
            /* {
             "title": "备注信息",
             "data": "remarks"
             },*/
            /* {
             "title": "删除标记",
             "data": "delFlag"
             },*/
            {
                "title": "操作",
                "data": "id"
            }
        ];
        options.columnDefs = [
            /*{
             "targets": -2,//最后第二列
             "createdCell": function (td, cellData, rowData, row, col) {
             $(td).empty();
             if (rowData.isuse === 1) {
             $(td).text("已启用");
             } else {
             $(td).text("已禁用");
             }
             }

             }, */

            {
                "targets": -1,//最后一列
                "width": "300px",
                "createdCell": function (td, cellData, rowData, row, col) {
                    $(td).empty();
                    var btn_group = '<div id=""btn-group-1" class="btn-group"></div>';
                    $(td).append(btn_group);
                    var btn_update = '<button class="btn btn-warning" onclick="edit(this)" data-row="' + row + '" data-id="' + rowData.id + '">修改</button>';
                    $(td).children(".btn-group").append(btn_update);
                    var btn_detail = '<button class="btn btn-info" onclick="view(this)" data-row="' + row + '" data-id="' + rowData.id + '">详情</button>';
                    $(td).children(".btn-group").append(btn_detail);
                    var btn_delete = '<button class="btn btn-danger" onclick="remove(this)" data-row="' + row + '" data-id="' + rowData.id + '">删除</button>';
                    $(td).children(".btn-group").append(btn_delete);
                    var btn_isuse = "";
                    if (rowData.loginFlag === 1) {
                        btn_isuse = '<button class="btn btn-warning" onclick="changeStatus(this)" data-row="' + row + '" data-id="' + rowData.id + '">禁用</button>';
                    } else {
                        btn_isuse = '<button class="btn btn-warning" onclick="changeStatus(this)" data-row="' + row + '" data-id="' + rowData.id + '">启用</button>';
                    }
                    $(td).children(".btn-group").append(btn_isuse);
                    var btn_reset_pwd = '<button class="btn btn-info" onclick="resetPwd(this)" data-row="' + row + '" data-id="' + rowData.id + '">重置密码</button>';
                    $(td).children(".btn-group").append(btn_reset_pwd);
                }
            }
        ];
        datatable = $('#datatable').dataTable(options);
    }
    //弹出表单Modal
    function showModal(action, data) {
        if ("add" == action) {
            $("#entityForm")[0].reset();
            $("#modal-actions").show();
            $("#editModalLabel").text("添加");
        }
        else {
            //load data
            loadFormdata(data);
            if ("view" == action) {
                $("#modal-actions").hide();
                $("#editModalLabel").text("详情");
            } else if ("edit" == action) {
                $("#modal-actions").show();
                $("#editModalLabel").text("修改");
            }
        }
        $("#editModal").modal();
    }
    //弹出提示
    function showAlert(classAttr, msg) {
        $("#alert").attr("class", "alert " + classAttr);
        $("#alertMessage").text(msg);
        $("#alert").alert();
        setTimeout(function () {
            $("#alert").alert('close')
        }, 2000);
    }
    //添加按钮事件响应
    function add() {
        $("#id").val("");
        vueApp.form.data.id="";
        $("input").each(function () {
            $(this).removeAttr("readonly");
        });
        showModal("add");
    }
    //修改按钮事件响应
    function edit(node) {
        //datatable.api().row($(node).data("row")).data()

        $("input").each(function () {
            $(this).removeAttr("readonly");
        });
        showModal("edit", $(node).data("id"));
    }
    //删除按钮事件响应
    function remove(node) {
        var url = "/com/lizhivscaomei/jes/sys/controller/sysUser/delete";
        var rowData = datatable.api().row($(node).data("row")).data();
        $("#deleteConfirmBtn").click(function () {
            $.post(url, {id: rowData.id}, function (data) {
                if (data.success) {
                    showAlert("alert-success", "删除成功");
                    $("#deleteModal").modal('toggle');
                    refreshTable();
                } else {
                    showAlert("alert-warning", "删除失败，" + data.info);
                }
            });
        });
        $("#confirmMsg").text("确定要删除" + rowData.name + "？");
        $("#deleteModal").modal('toggle');

    }
    //详情按钮事件响应
    function view(node) {
        //datatable.api().row($(node).data("row")).data()
        $("input").each(function () {
            $(this).attr("readonly", "readonly");
        });
        showModal("view", $(node).data("id"));

    }
    //加载表单数据
    function loadFormdata(id) {
        var url = "/com/lizhivscaomei/jes/sys/controller/sysUser/query/detail";
        $.get(url, {"id": id}, function (data) {
            /*$("#id").val(id);
             $("#companyId").val(data.data.companyId);
             $("#officeId").val(data.data.officeId);
             $("#loginName").val(data.data.loginName);
             $("#password").val(data.data.password);
             $("#no").val(data.data.no);
             $("#name").val(data.data.name);
             $("#email").val(data.data.email);
             $("#phone").val(data.data.phone);
             $("#mobile").val(data.data.mobile);
             $("#userType").val(data.data.userType);
             $("#photo").val(data.data.photo);
             $("#loginIp").val(data.data.loginIp);
             $("#loginDate").val(data.data.loginDate);
             $("#loginFlag").val(data.data.loginFlag);
             $("#createBy").val(data.data.createBy);
             $("#createDate").val(data.data.createDate);
             $("#updateBy").val(data.data.updateBy);
             $("#updateDate").val(data.data.updateDate);
             $("#remarks").val(data.data.remarks);
             $("#delFlag").val(data.data.delFlag);*/
            vueApp.form.data.id = id;
            vueApp.form.data.companyId = data.data.companyId;
            vueApp.form.data.officeId = data.data.officeId;
            vueApp.form.data.loginName = data.data.loginName;
            vueApp.form.data.password = data.data.password;
            vueApp.form.data.no = data.data.no;
            vueApp.form.data.name = data.data.name;
            vueApp.form.data.email = data.data.email;
            vueApp.form.data.phone = data.data.phone;
            vueApp.form.data.mobile = data.data.mobile;
            vueApp.form.data.userType = data.data.userType;
//             vueApp.form.data.photo=data.data.photo;
//             vueApp.form.data.loginIp=data.data.loginIp;
//             vueApp.form.data.loginDate=data.data.loginDate;
//             vueApp.form.data.loginFlag=data.data.loginFlag;
//             vueApp.form.data.createBy=data.data.createBy;
//             vueApp.form.data.createDate=data.data.createDate;
//             vueApp.form.data.updateBy=data.data.updateBy;
//             vueApp.form.data.updateDate=data.data.updateDate;
            vueApp.form.data.remarks = data.data.remarks;
//             vueApp.form.data.delFlag=data.data.delFlag;
        });
    }
    //保存表单（添加或修改）
    function saveForm() {
        var url = "/com/lizhivscaomei/jes/sys/controller/sysUser/save";

        $.post(url, vueApp.form.data, function (data) {
            if (data.success) {
                showAlert("alert-success", "保存成功");
                $("#editModal").modal('toggle');
                refreshTable();
            } else {
                showAlert("alert-warning", "保存失败，" + data.info);
            }
        });
    }
    //刷新表格
    function refreshTable() {
        $('#datatable').DataTable().ajax.reload();
    }
    //vueApp
    var vueApp = new Vue({
        el: "#entityForm",
        data: {
            form: {
                data: {
                    companyId: "",
                    officeId: "",
                    loginName: "",
//                    password:"",
                    no: "",
                    name: "",
                    email: "",
                    phone: "",
                    mobile: "",
                    userType: "",
                    photo: "",
//                    loginIp:"",
//                    loginDate:"",
//                    loginFlag:"",
//                    createBy:"",
//                    createDate:"",
//                    updateBy:"",
//                    updateDate:"",
                    remarks: "",
//                    delFlag:"",
                    id: ""
                },
                options: {}
            }
        },
        methods: {}
    });
</script>
</body>

</html>