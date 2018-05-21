<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="jsp/public/head.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" id="vue">
<head>
    <title>微立方智慧农业管理平台</title>
    <%@ include file="jsp/public/nifty.jsp" %>
</head>

<body>
<div id="container">
    <el-container>
        <el-header>
            <!--NAVBAR 顶部横条-->
            <!--===================================================-->
            <header id="navbar">
                <div id="navbar-container" class="boxed">

                    <!--系统名称 Brand logo & name-->
                    <!--================================-->
                    <div class="navbar-header">
                        <a href="#" class="navbar-brand">
                            <img src="static/img/logo.png" alt="Nifty Logo" class="brand-icon">
                            <div class="brand-title">
                                <span class="brand-text">{{selectedDomain.name}}</span>
                            </div>
                        </a>
                    </div>
                    <!--================================-->
                    <!--End brand logo & name-->


                    <!--Navbar Dropdown-->
                    <!--================================-->
                    <div class="navbar-content clearfix">
                        <ul class="nav navbar-top-links">

                            <!--Navigation toogle button-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <li class="tgl-menu-btn">
                                <a class="mainnav-toggle" href="#" @click="toggleMainnav()">
                                    <i class="pli-list-view icon-lg"></i>
                                </a>
                            </li>
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <!--End Navigation toogle button-->


                            <!--搜索-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <li>
                                <div class="custom-search-form">
                                    <label class="btn btn-trans" for="search-input" data-toggle="collapse"
                                           data-target="#nav-searchbox">
                                        <i class="pli-magnifi-glass"></i>
                                    </label>
                                    <form>
                                        <div class="search-container collapse" id="nav-searchbox">
                                            <input id="search-input" type="text" class="form-control" placeholder="搜一搜">
                                        </div>
                                    </form>
                                </div>
                            </li>
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <!--End Search-->


                        </ul>
                        <ul class="nav navbar-top-links">

                            <li class="mega-dropdown">
                                <a href="#" class="mega-dropdown-toggle">
                                    <i class="pli-layout-grid"></i>
                                </a>
                                <div class="dropdown-menu mega-dropdown-menu">
                                    <div class="row">
                                        <div class="col-sm-12 col-md-3">
                                            <!--Mega menu list-->
                                            <ul class="list-unstyled">
                                                <li v-for="domain in my.domainList">
                                                    <a href="#" class="media mar-btm mega-dropdown-toggle" v-on:click="selectDomain(domain)">
                                                        <span class="badge badge-success pull-right">new</span>
                                                        <div class="media-left">
                                                            <i class="pli-data-settings icon-2x"></i>
                                                        </div>
                                                        <div class="media-body">
                                                            <p class="text-semibold text-main mar-no">
                                                                {{domain.text}}</p>
                                                            <small class="text-muted"></small>
                                                        </div>
                                                    </a>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <!--End mega dropdown-->


                            <!--Notification dropdown-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <li class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle">
                                    <i class="pli-bell icon-lg"></i>
                                    <span class="badge badge-header badge-danger"></span>
                                </a>

                                <!--Notification dropdown menu-->
                                <div class="dropdown-menu dropdown-menu-md dropdown-menu-right">
                                    <div class="nano scrollable">
                                        <div class="nano-content">
                                            <ul class="head-list">
                                                <!-- Dropdown list-->
                                                <li v-for="notification in my.notificationList">
                                                    <a href="#" class="media" v-on:click="openframe(notification)">
                                                        <span class="badge badge-success pull-right">1</span>
                                                        <div class="media-left">

									<span class="icon-wrap icon-circle bg-danger">
									    <i class="pli-mail-open icon-lg icon-lg"></i>
									</span>
                                                        </div>
                                                        <div class="media-body">
                                                            <div class="text-nowrap">{{notification.text}}</div>
                                                        </div>
                                                    </a>
                                                </li>

                                            </ul>
                                        </div>
                                    </div>

                                    <div class="pad-all bord-top">
                                        <a href="#" class="btn-link text-main box-block">
                                            <i class="pci-chevron chevron-right pull-right"></i>显示所有
                                        </a>
                                    </div>
                                </div>
                            </li>
                            <li id="dropdown-user" class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                                <span class="ic-user pull-right">
                                    <i class="pli-male"></i>
                                </span>
                                </a>


                                <div class="dropdown-menu dropdown-menu-sm dropdown-menu-right panel-default">
                                    <ul class="head-list">
                                        <li>
                                            <a href="#"><i class="pli-male icon-lg icon-fw"></i> 名片</a>
                                        </li>
                                        <li>
                                            <a href="#"><i class="pli-computer-secure icon-lg icon-fw"></i> 修改密码</a>
                                        </li>
                                        <li>
                                            <a href="#"><span class="label label-success pull-right">New</span><i
                                                    class="pli-folder-with-document icon-lg icon-fw"></i> 帮助</a>
                                        </li>
                                        <li>
                                            <a href="#"><span class="label label-success pull-right">New</span><i
                                                    class="pli-gear icon-lg icon-fw"></i> 设置</a>
                                        </li>
                                        <li>
                                            <a href="/logout"><i class="pli-unlock icon-lg icon-fw"></i> 安全退出</a>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </header>
        </el-header>
        <el-container>
            <el-aside>
                <el-menu :default-openeds="['userinfo']" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                         :collapse="isCollapse">

                    <el-submenu index="userinfo">
                        <template slot="title">
                            <i class="el-icon-picture"></i>
                            <span slot="title">当前用户</span>
                        </template>

                        <div class="mainnav-profile">
                            <div class="profile-wrap text-center">
                                <div class="pad-btm">
                                    <img class="img-circle img-md" src="img/profile-photos/1.png" alt="Profile Picture">
                                </div>
                                <a href="#profile-nav" class="box-block" data-toggle="collapse" aria-expanded="false">
                                    <p class="mnp-name">{{my.userinfo.name}}</p>
                                </a>
                            </div>
                        </div>
                    </el-submenu>
                    <el-submenu v-for="menu in selectedDomain.menuList" :index="menu.id">
                        <template slot="title">
                            <i class="el-icon-star-on"></i>
                            <span slot="title">{{menu.text}}</span>
                        </template>

                        <el-menu-item :index="menu2.id" v-for="menu2 in menu.nodes" @click="openframe(menu2)">

                            <i class="el-icon-tickets"></i>
                            <span>{{menu2.text}}</span>

                        </el-menu-item>
                    </el-submenu>
                </el-menu>
            </el-aside>
            <el-main>
                <div id="page-content" style="padding: 0px">
                    <iframe v-bind:src="iframeDefUrl" width="100%" height="90%" frameborder="0"
                            name="mainframe" id="mainframe"></iframe>
                </div>
            </el-main>
        </el-container>
    </el-container>
</div>
</body>
</html>
<script>
    var vueApp = new Vue({
        el: "#container",
        data: {
            isCollapse: false,
            url: {
                domainOptions: "/com/lizhivscaomei/jes/sys/controller/sysDomain/query/spinner",
                queryMenuTree: "/com/lizhivscaomei/jes/sys/controller/sysMenu/query/select"
            },
            my: {
                notificationList: [
                    {
                        id: "12313",
                        text: "未处理订单",
                        url: "http://www.163.com"
                    },
                    {
                        id: "12313",
                        text: "该浇水了",
                        url: "http://www.sohu.com"
                    },
                    {
                        id: "12313",
                        text: "该施肥水了",
                        url: "http://www.baidu.com"
                    }
                ],
                domainList: [],
                userinfo:{
                    name:"管理员"
                }
            },
            selectedDomain: {
                id: "d926086b-bdb9-4e9f-af4e-e960523e9427",
                name: "系统管理",
                menuList: []
            },
            iframeDefUrl: "http://www.baidu.com"
        },
        methods: {
            selectDomain: function (domain) {
                this.selectedDomain.id = domain.id;
                this.selectedDomain.name = domain.text;
                this.getDomainMenu(this.selectedDomain.id);
            },
            getDomainMenu: function (domainId) {
                //查询菜单
                this.$http.get(this.url.queryMenuTree, {params: {domainId: domainId}}).then(function (res) {
                    this.selectedDomain.menuList = res.data.data[0].nodes;
                }, function (res) {
                    this.$message({
                        showClose: true,
                        message: "网络错误,code=" + res.status,
                        type: "error"
                    });
                });
            },
            openframe: function (data) {
                $("#mainframe").attr("src", data.href);
            },
            handleOpen(key, keyPath) {
                debugger
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
                debugger
                console.log(key, keyPath);
            },
            toggleMainnav(){
                if (this.isCollapse) {
                    this.isCollapse = false;
                } else {
                    this.isCollapse = true;
                }
            }
        },
        mounted: function () {
            //查询域
            this.$http.get(this.url.domainOptions).then(function (res) {
                this.selectedDomain.id = res.data[0].id;
                this.selectedDomain.name = res.data[0].text;
                this.my.domainList = res.data;
                this.getDomainMenu(this.selectedDomain.id);
            }, function (res) {
                this.$message({
                    showClose: true,
                    message: "网络错误,code=" + res.status,
                    type: "error"
                });
            });

        }
    });
</script>
<%--一定要放在最后--%>
<script src="static/js/nifty.min.js"></script>

<style>
    .el-menu-vertical-demo:not(.el-menu--collapse) {
        width: 100%;
        min-height: 100%;
    }
    .brand-text{
        color: white;
        font-family: monospace;
    }
    #navbar .brand-title{
        width: 300px;
    }
    .el-main{
        padding: 0px;
    }
</style>