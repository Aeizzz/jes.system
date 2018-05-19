<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="jsp/public/head.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml" id="vue">
<head>
    <title>物联网平台</title>
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
                        <a href="index.html" class="navbar-brand">
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


                            <!--Mega dropdown-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
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
                                                    <a href="#" class="media mar-btm" v-on:click="selectDomain(domain)">
                                                        <span class="badge badge-success pull-right">new</span>
                                                        <div class="media-left">
                                                            <i class="pli-data-settings icon-2x"></i>
                                                        </div>
                                                        <div class="media-body">
                                                            <p class="text-semibold text-main mar-no">{{domain.text}}</p>
                                                            <small class="text-muted"></small>
                                                        </div>
                                                    </a>
                                                </li>

                                            </ul>
                                        </div>
                                        <%--<div class="col-sm-4 col-md-3">

                                            <!--Mega menu list-->
                                            <ul class="list-unstyled">
                                                <li class="dropdown-header"><i class="pli-mail icon-lg icon-fw"></i> Mailbox
                                                </li>
                                                <li><a href="#"><span class="pull-right label label-danger">Hot</span>Indox</a>
                                                </li>
                                                <li><a href="#">Read Message</a></li>
                                                <li><a href="#">Compose</a></li>
                                                <li><a href="#">Template</a></li>
                                            </ul>
                                            <p class="pad-top text-main text-sm text-uppercase text-bold"><i
                                                    class="icon-lg pli-calendar-4 icon-fw"></i>News</p>
                                            <p class="pad-top mar-top bord-top text-sm">Lorem ipsum dolor sit amet, consectetuer
                                                adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis
                                                natoque penatibus et magnis dis parturient montes.</p>
                                        </div>
                                        <div class="col-sm-12 col-md-3">
                                            <p class="dropdown-header"><i class="pli-file-jpg icon-lg icon-fw"></i> Gallery</p>
                                            <div class="row img-gallery">
                                                <div class="col-xs-4">
                                                    <img class="img-responsive" src="static/img/thumbs/img-1.jpg" alt="thumbs">
                                                </div>
                                                <div class="col-xs-4">
                                                    <img class="img-responsive" src="static/img/thumbs/img-3.jpg" alt="thumbs">
                                                </div>
                                                <div class="col-xs-4">
                                                    <img class="img-responsive" src="static/img/thumbs/img-2.jpg" alt="thumbs">
                                                </div>
                                                <div class="col-xs-4">
                                                    <img class="img-responsive" src="static/img/thumbs/img-4.jpg" alt="thumbs">
                                                </div>
                                                <div class="col-xs-4">
                                                    <img class="img-responsive" src="static/img/thumbs/img-6.jpg" alt="thumbs">
                                                </div>
                                                <div class="col-xs-4">
                                                    <img class="img-responsive" src="static/img/thumbs/img-5.jpg" alt="thumbs">
                                                </div>
                                            </div>
                                            <a href="#" class="btn btn-block btn-primary">Browse Gallery</a>
                                        </div>--%>
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

                                    <!--Dropdown footer-->
                                    <div class="pad-all bord-top">
                                        <a href="#" class="btn-link text-main box-block">
                                            <i class="pci-chevron chevron-right pull-right"></i>显示所有
                                        </a>
                                    </div>
                                </div>
                            </li>
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <!--End notifications dropdown-->


                            <!--User dropdown-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <li id="dropdown-user" class="dropdown">
                                <a href="#" data-toggle="dropdown" class="dropdown-toggle text-right">
                                <span class="ic-user pull-right">
                                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                                    <!--You can use an image instead of an icon.-->
                                    <!--<img class="img-circle img-user media-object" src="static/img/profile-photos/1.png" alt="Profile Picture">-->
                                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                                    <i class="pli-male"></i>
                                </span>
                                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                                    <!--You can also display a user name in the navbar.-->
                                    <!--<div class="username hidden-xs">Aaron Chavez</div>-->
                                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
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
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <!--End user dropdown-->

                            <%--<li>
                                <a href="#" class="aside-toggle">
                                    <i class="pli-dot-vertical"></i>
                                </a>
                            </li>--%>
                        </ul>
                    </div>
                    <!--================================-->
                    <!--End Navbar Dropdown-->

                </div>
            </header>
        </el-header>
        <el-container>
            <el-asize>
                <%--<ul id="mainnav-menu" class="list-group">
                                <!--Menu list item-->
                                <li v-for="menu in selectedDomain.menuList">
                                    <a href="#">
                                        <i class="pli-receipt-4"></i>
                                        <span class="menu-title"><strong>{{menu.text}}</strong></span><i class="arrow"></i>
                                    </a>
                                    <ul class="collapse">
                                        <li v-for="menu2 in menu.nodes" ><a href="#" v-on:click="openframe(menu2)"><i class="pli-circular-point"></i>{{menu2.text}}</a></li>
                                    </ul>
                                </li>
                            </ul>--%>
                <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
                         :collapse="isCollapse">

                    <el-submenu index="1">
                        <template slot="title">
                            <i class="el-icon-location"></i>
                            <span slot="title">导航一</span>
                        </template>
                        <el-menu-item-group>
                            <span slot="title">分组一</span>
                            <el-menu-item index="1-1">选项1</el-menu-item>
                            <el-menu-item index="1-2">选项2</el-menu-item>
                        </el-menu-item-group>
                        <el-menu-item-group title="分组2">
                            <el-menu-item index="1-3">选项3</el-menu-item>
                        </el-menu-item-group>
                        <el-submenu index="1-4">
                            <span slot="title">选项4</span>
                            <el-menu-item index="1-4-1">选项1</el-menu-item>
                        </el-submenu>
                    </el-submenu>
                    <el-menu-item index="2">
                        <i class="el-icon-menu"></i>
                        <span slot="title">导航二</span>
                    </el-menu-item>
                    <el-menu-item index="3" disabled>
                        <i class="el-icon-document"></i>
                        <span slot="title">导航三</span>
                    </el-menu-item>
                    <el-menu-item index="4">
                        <i class="el-icon-setting"></i>
                        <span slot="title">导航四</span>
                    </el-menu-item>
                </el-menu>
            </el-asize>
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
                domainList: []
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
                this.selectDomain.id = domain.id;
                this.selectDomain.name = domain.text;
                this.getDomainMenu(this.selectDomain.id);
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
                console.log(key, keyPath);
            },
            handleClose(key, keyPath) {
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
                this.selectedDomain.name = res.data[0].name;
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
</style>