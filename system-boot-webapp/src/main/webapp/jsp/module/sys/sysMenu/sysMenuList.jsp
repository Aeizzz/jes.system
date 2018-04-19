<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>权限管理</title>
    <%@ include file="/jsp/public/commonTable.jsp" %>
</head>
<body>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">权限管理</h3>
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
                        <label class="control-label col-xs-4">父级编号：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="parentId"  name="parentId" v-model="form.data.parentId"
                                   placeholder="请输入父级编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">所有父级编号：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="parentIds"  name="parentIds" v-model="form.data.parentIds"
                                   placeholder="请输入所有父级编号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">名称：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="name"  name="name" v-model="form.data.name"
                                   placeholder="请输入名称">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">排序：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="sort"  name="sort" v-model="form.data.sort"
                                   placeholder="请输入排序">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">链接：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="href"  name="href" v-model="form.data.href"
                                   placeholder="请输入链接">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">目标：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="target"  name="target" v-model="form.data.target"
                                   placeholder="请输入目标">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">图标：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="icon"  name="icon" v-model="form.data.icon"
                                   placeholder="请输入图标">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">是否在菜单中显示：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="isShow"  name="isShow" v-model="form.data.isShow"
                                   placeholder="请输入是否在菜单中显示">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-4">权限标识：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="permission"  name="permission" v-model="form.data.permission"
                                   placeholder="请输入权限标识">
                        </div>
                    </div>
                    <%--<div class="form-group">
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
                    <div class="form-group">
                        <label class="control-label col-xs-4">域ID：</label>
                        <div class="col-xs-8">
                            <input type="text" class="form-control" id="domainId"  name="domainId" v-model="form.data.domainId"
                                   placeholder="请输入域ID">
                        </div>
                    </div>
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
            <div class="modal-header  bg-danger">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title modal-title-primary" id="deleteModalLabel"><i class="fa fa-exclamation-circle"></i>删除</h4>
            </div>
            <div class="modal-body">
                <p id="confirmMsg"></p>
            </div>
            <div class="modal-footer" >
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-danger" id="deleteConfirmBtn">确认</button>
            </div>
        </div>
    </div>
</div>
<!-- 操作提示-->
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
    function createTable() {
        var queryBaseUr="/com/lizhivscaomei/jes/sys/controller/sysMenu/query/page";
        var options={};
        $.extend(options,dataTableJesOptions);
        options.ajax={url:queryBaseUr};
        options.columns=[
            {
                "title": "序号",
                "data": "id"
            },
            /*{
                "title": "父级编号",
                "data": "parentId"
            },
            {
                "title": "所有父级编号",
                "data": "parentIds"
            },*/
            {
                "title": "名称",
                "data": "name"
            },
            {
                "title": "权限标识",
                "data": "permission"
            },
            {
                "title": "链接",
                "data": "href"
            },
            /*{
                "title": "目标",
                "data": "target"
            },*/
            {
                "title": "图标",
                "data": "icon"
            },
            {
                "title": "排序",
                "data": "sort"
            },
            /*{
                "title": "是否在菜单中显示",
                "data": "isShow"
            },*/

            /*{
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
            },
            {
                "title": "备注信息",
                "data": "remarks"
            },
            {
                "title": "删除标记",
                "data": "delFlag"
            },*/
            {
                "title": "所属域",
                "data": "domainId"
            },
            {
                "title": "操作",
                "data": "id"
            }
        ];
        options.columnDefs=[
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

             }, */{
                "targets": -1,//最后一列
                "width":"200px",
                "createdCell": function (td, cellData, rowData, row, col) {
                    $(td).empty();
                    var btn_group = '<div class="btn-group"></div>';
                    $(td).append(btn_group);
                    var btn_update = '<button class="btn btn-warning" onclick="edit(this)" data-row="' + row + '" data-id="' + rowData.id + '">修改</button>';
                    $(td).children(".btn-group").append(btn_update);
                    var btn_detail = '<button class="btn btn-info" onclick="view(this)" data-row="' + row + '" data-id="' + rowData.id + '">详情</button>';
                    $(td).children(".btn-group").append(btn_detail);
                    var btn_delete = '<button class="btn btn-danger" onclick="remove(this)" data-row="' + row + '" data-id="' + rowData.id + '">删除</button>';
                    $(td).children(".btn-group").append(btn_delete);
                    /*var btn_isuse = "";
                    if (rowData.isuse === 1) {
                        btn_isuse = '<button class="btn btn-warning" onclick="changeStatus(this)" data-row="' + row + '" data-id="' + rowData.id + '">禁用</button>';
                    } else {
                        btn_isuse = '<button class="btn btn-warning" onclick="changeStatus(this)" data-row="' + row + '" data-id="' + rowData.id + '">启用</button>';
                    }
                    $(td).children(".btn-group").append(btn_isuse);*/
                }
            }
        ];
        datatable = $('#datatable').dataTable(options);
    }
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
            }else if ("edit" == action) {
                $("#modal-actions").show();
                $("#editModalLabel").text("修改");
            }
        }
        $("#editModal").modal();
    }
    function showAlert(classAttr, msg) {
        $("#alert").attr("class", "alert " + classAttr);
        $("#alertMessage").text(msg);
        $("#alert").alert();
        setTimeout(function () {
            $("#alert").alert('close');
        },2000);
    }
    function add() {
        $("#id").val("");
        $("input").each(function () {
            $(this).removeAttr("readonly");
        });
        showModal("add");
    }
    function edit(node) {
        //datatable.api().row($(node).data("row")).data()

        $("input").each(function () {
            $(this).removeAttr("readonly");
        });
        showModal("edit", $(node).data("id"));
    }
    function remove(node) {
        var url="/com/lizhivscaomei/jes/sys/controller/sysMenu/delete";
        var rowData=datatable.api().row($(node).data("row")).data();
        $("#deleteConfirmBtn").click(function () {
            $.post(url,{id:rowData.id},function (data) {
                if (data.success) {
                    showAlert("alert-success", "删除成功");
                    $("#deleteModal").modal('toggle');
                    refreshTable();
                } else {
                    showAlert("alert-warning", "删除失败，" + data.info);
                }
            });
        });
        $("#confirmMsg").text("确定要删除"+rowData.name+"？");
        $("#deleteModal").modal('toggle');

    }
    function view(node) {
        //datatable.api().row($(node).data("row")).data()
        $("input").each(function () {
            $(this).attr("readonly","readonly");
        });
        showModal("view", $(node).data("id"));

    }
    function loadFormdata(id) {
        var url="/com/lizhivscaomei/jes/sys/controller/sysMenu/query/detail";
        $.get(url,{"id":id},function (data) {
            vueApp.form.data.id=id;
            vueApp.form.data.parentId=data.data.parentId;
            vueApp.form.data.parentIds=data.data.parentIds;
            vueApp.form.data.name=data.data.name;
            vueApp.form.data.sort=data.data.sort;
            vueApp.form.data.href=data.data.href;
            vueApp.form.data.target=data.data.target;
            vueApp.form.data.icon=data.data.icon;
            vueApp.form.data.isShow=data.data.isShow;
            vueApp.form.data.permission=data.data.permission;
            vueApp.form.data.createBy=data.data.createBy;
            vueApp.form.data.createDate=data.data.createDate;
            vueApp.form.data.updateBy=data.data.updateBy;
            vueApp.form.data.updateDate=data.data.updateDate;
            vueApp.form.data.remarks=data.data.remarks;
            vueApp.form.data.delFlag=data.data.delFlag;
            vueApp.form.data.domainId=data.data.domainId;
        });
    }
    function saveForm() {
        var url="/com/lizhivscaomei/jes/sys/controller/sysMenu/save";
        $.post(url,vueApp.form.data,function (data) {
            if (data.success) {
                showAlert("alert-success", "保存成功");
                $("#editModal").modal('toggle');
                refreshTable();
            } else {
                showAlert("alert-warning", "保存失败，" + data.info);
            }
        });
    }
    function refreshTable() {
        $('#datatable').DataTable().ajax.reload();
    }
    var vueApp=new Vue({
        el:"#entityForm",
        data:{
            form:{
                data:{
                    id:"",
                    parentId:"",
                    parentIds:"",
                    name:"",
                    sort:"",
                    href:"",
                    target:"",
                    icon:"",
                    isShow:"",
                    permission:"",
                    createBy:"",
                    createDate:"",
                    updateBy:"",
                    updateDate:"",
                    remarks:"",
                    delFlag:"",
                    domainId:""
                },
                options:{}
            }
        },
        methods:{}
    });
</script>
</body>

</html>