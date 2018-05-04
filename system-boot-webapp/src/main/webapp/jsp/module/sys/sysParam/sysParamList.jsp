<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>参数设置</title>
    <%@ include file="/jsp/public/commonTable.jsp" %>
</head>
<body>
<div id="vueApp">
    <div class="container-fluid">
        <div class="row-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">参数设置</h3>
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
                        <form class="form-inline" name="searchForm">
                            <div class="form-group">
                                <select v-model="form.filter.domainId" class="form-control">
                                    <option v-for="option in form.options.domainList" v-bind:value="option.id">
                                        {{option.text}}
                                    </option>
                                </select>
                                <button class="btn btn-primary" type="button" onclick="refreshTable()">查询</button>
                            </div>
                        </form>
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
                            <label class="control-label col-xs-4">所属域：</label>
                            <div class="col-xs-8">
                                <select class="form-control" id="domainId" name="domainId" v-model="form.data.domainId">
                                    <option v-for="(option,index) in form.options.domainList"
                                            v-bind:value="option.id">{{option.text}}
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">参数名：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="label" name="label"
                                       v-model="form.data.label"
                                       placeholder="请输入标签名">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">参数代码：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="code" name="code" v-model="form.data.code"
                                       placeholder="请输入参数代码">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">数据值：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="value" name="value"
                                       v-model="form.data.value"
                                       placeholder="请输入数据值">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">描述：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="description" name="description"
                                       v-model="form.data.description"
                                       placeholder="请输入描述">
                            </div>
                        </div>
                        <%--<div class="form-group">
                            <label class="control-label col-xs-4">创建者：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="createBy"  name="createBy" v-model="form.data.createBy"
                                       placeholder="请输入创建者">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">创建时间：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="createDate"  name="createDate" v-model="form.data.createDate"
                                       placeholder="请输入创建时间">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">更新者：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="updateBy"  name="updateBy" v-model="form.data.updateBy"
                                       placeholder="请输入更新者">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">更新时间：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="updateDate"  name="updateDate" v-model="form.data.updateDate"
                                       placeholder="请输入更新时间">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">备注信息：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="remarks"  name="remarks" v-model="form.data.remarks"
                                       placeholder="请输入备注信息">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="control-label col-xs-4">删除标记：</label>
                            <div class="col-xs-8">
                                <input type="text" class="form-control" id="delFlag"  name="delFlag" v-model="form.data.delFlag"
                                       placeholder="请输入删除标记">
                            </div>
                        </div>--%>
                        <input type="hidden" name="id" id="id">

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
    <!-- 操作提示-->
    <div class="alert hidden" id="alert" style="position: fixed;right: 10px;top: 10px;width: 300px;">
        <a href="#" class="close" data-dismiss="alert">
            &times;
        </a>
        <div id="alertMessage"></div>
    </div>
</div>
<script>
    var datatable;
    $(function () {
        getDomainList();
    });
    function getDomainList() {
        $.get("/com/lizhivscaomei/jes/sys/controller/sysDomain/query/spinner", {}, function (data) {
            vueApp.form.options.domainList = data;
            //查询参数默认值
            vueApp.form.data.domainId = data[0].id;
            //添加表单默认值
            vueApp.form.filter.domainId = data[0].id;
            createTable();
        });
    }
    //初始化表格
    function createTable() {
        var queryBaseUr = "/com/lizhivscaomei/jes/sys/controller/sysParam/query/page";
        var options = {};
        $.extend(options, dataTableJesOptions);
        options.ajax = {
            url: queryBaseUr,
            data: function (d) {
                return vueApp.form.filter;
            }
        };
        options.columns = [
            {
                "title": "序号",
                "data": "id"
            },
            {
                "title": "参数名",
                "data": "label"
            },
            {
                "title": "参数代码",
                "data": "code"
            },
            {
                "title": "数据值",
                "data": "value"
            },
            {
                "title": "描述",
                "data": "description"
            },
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
            /*{
                "title": "所属域",
                "data": "domainId"
            },*/
            {
                "title": "所属域",
                "data": "domainName"
            },
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
                "width": "200px",
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
            $("#alert").alert('close');
        }, 2000);
    }
    //添加按钮事件响应
    function add() {
        $("#id").val("");
        vueApp.form.data.id = "";
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
        var url = "/com/lizhivscaomei/jes/sys/controller/sysParam/delete";
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
        var url = "/com/lizhivscaomei/jes/sys/controller/sysParam/query/detail";
        $.get(url, {"id": id}, function (data) {
            vueApp.form.data.id = id;
            vueApp.form.data.code = data.data.code;
            vueApp.form.data.value = data.data.value;
            vueApp.form.data.label = data.data.label;
            vueApp.form.data.description = data.data.description;
            /*vueApp.form.data.createBy=data.data.createBy;
             vueApp.form.data.createDate=data.data.createDate;
             vueApp.form.data.updateBy=data.data.updateBy;
             vueApp.form.data.updateDate=data.data.updateDate;
             vueApp.form.data.remarks=data.data.remarks;
             vueApp.form.data.delFlag=data.data.delFlag;*/
            vueApp.form.data.domainId = data.data.domainId;
        });
    }
    //保存表单（添加或修改）
    function saveForm() {
        var url = "/com/lizhivscaomei/jes/sys/controller/sysParam/save";
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
        el: "#vueApp",
        data: {
            form: {
                data: {
                    //参数代码
                    code: "",
                    //数据值
                    value: "",
                    //标签名
                    label: "",
                    //描述
                    description: "",
                    /*//创建者
                     createBy:"",
                     //创建时间
                     createDate:"",
                     //更新者
                     updateBy:"",
                     //更新时间
                     updateDate:"",
                     //备注信息
                     remarks:"",
                     //删除标记
                     delFlag:"",*/
                    //域ID
                    domainId: "",
                    id: ""
                },
                filter: {
                    domainId: ""
                },
                options: {
                    domainList: []
                }
            }
        },
        methods: {}
    });
</script>
</body>

</html>