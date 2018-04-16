<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="jsp/public/head.jsp" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title way-data="selectedDomain.name"></title>
    <%@ include file="jsp/public/nifty.jsp" %>
</head>

<body>
<div id="container" class="effect aside-float aside-bright mainnav-lg">

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
                        <span class="brand-text" way-data="selectedDomain.name"></span>
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
                        <a class="mainnav-toggle" href="#">
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
                                    <ul class="list-unstyled" way-repeat="domainList">
                                        <li>
                                            <a href="#" class="media mar-btm">
                                                <span class="badge badge-success pull-right">new</span>
                                                <div class="media-left">
                                                    <i class="pli-data-settings icon-2x"></i>
                                                </div>
                                                <div class="media-body">
                                                    <p class="text-semibold text-main mar-no" way-data="name"></p>
                                                    <small class="text-muted">This is the item description</small>
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
                                        <li>
                                            <a href="#">
                                                <div class="clearfix">
                                                    <p class="pull-left">Progressbar</p>
                                                    <p class="pull-right">70%</p>
                                                </div>
                                                <div class="progress progress-sm">
                                                    <div style="width: 70%;" class="progress-bar">
                                                        <span class="sr-only">70% Complete</span>
                                                    </div>
                                                </div>
                                            </a>
                                        </li>

                                        <!-- Dropdown list-->
                                        <li>
                                            <a href="#" class="media">
                                                <div class="media-left">
                                                    <i class="pli-hd icon-2x icon-lg"></i>
                                                </div>
                                                <div class="media-body">
                                                    <div class="text-nowrap">With Icon</div>
                                                    <small class="text-muted">15 minutes ago</small>
                                                </div>
                                            </a>
                                        </li>

                                        <!-- Dropdown list-->
                                        <li>
                                            <a href="#" class="media">
                                                <div class="media-left">
                                                    <i class="pli-power-cable icon-2x icon-lg"></i>
                                                </div>
                                                <div class="media-body">
                                                    <div class="text-nowrap">With Icon</div>
                                                    <small class="text-muted">15 minutes ago</small>
                                                </div>
                                            </a>
                                        </li>

                                        <!-- Dropdown list-->
                                        <li>
                                            <a href="#" class="media">
                                                <div class="media-left">

									<span class="icon-wrap icon-circle bg-primary">
									    <i class="pli-disk icon-lg icon-lg"></i>
									</span>
                                                </div>
                                                <div class="media-body">
                                                    <div class="text-nowrap">Circle Icon</div>
                                                    <small class="text-muted">15 minutes ago</small>
                                                </div>
                                            </a>
                                        </li>

                                        <!-- Dropdown list-->
                                        <li>
                                            <a href="#" class="media">
                                                <span class="badge badge-success pull-right">90%</span>
                                                <div class="media-left">

									<span class="icon-wrap icon-circle bg-danger">
									    <i class="pli-mail-open icon-lg icon-lg"></i>
									</span>
                                                </div>
                                                <div class="media-body">
                                                    <div class="text-nowrap">Circle icon with badge</div>
                                                    <small class="text-muted">50 minutes ago</small>
                                                </div>
                                            </a>
                                        </li>

                                        <!-- Dropdown list-->
                                        <li>
                                            <a href="#" class="media">
                                                <div class="media-left">

									<span class="icon-wrap bg-info">
									    <i class="pli-monitor-3 icon-lg icon-lg"></i>
									</span>
                                                </div>
                                                <div class="media-body">
                                                    <div class="text-nowrap">Square icon</div>
                                                    <small class="text-muted">Last Update 8 hours ago</small>
                                                </div>
                                            </a>
                                        </li>

                                        <!-- Dropdown list-->
                                        <li>
                                            <a href="#" class="media">
                                                <span class="label label-danger pull-right">New</span>
                                                <div class="media-left">

									<span class="icon-wrap bg-purple">
									    <i class="pli-paintbrush icon-lg icon-lg"></i>
									</span>
                                                </div>
                                                <div class="media-body">
                                                    <div class="text-nowrap">Square icon with label</div>
                                                    <small class="text-muted">Last Update 8 hours ago</small>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <!--Dropdown footer-->
                            <div class="pad-all bord-top">
                                <a href="#" class="btn-link text-main box-block">
                                    <i class="pci-chevron chevron-right pull-right"></i>Show All Notifications
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
                                    <a href="#"><span class="badge badge-danger pull-right">9</span><i
                                            class="pli-mail icon-lg icon-fw"></i> 通知</a>
                                </li>
                                <li>
                                    <a href="#"><span class="label label-success pull-right">New</span><i
                                            class="pli-gear icon-lg icon-fw"></i> 设置</a>
                                </li>
                                <li>
                                    <a href="#"><i class="pli-computer-secure icon-lg icon-fw"></i> 修改密码</a>
                                </li>
                                <li>
                                    <a href="/logout"><i class="pli-unlock icon-lg icon-fw"></i> 安全退出</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                    <!--End user dropdown-->

                    <li>
                        <a href="#" class="aside-toggle">
                            <i class="pli-dot-vertical"></i>
                        </a>
                    </li>
                </ul>
            </div>
            <!--================================-->
            <!--End Navbar Dropdown-->

        </div>
    </header>
    <!--===================================================-->
    <!--END NAVBAR-->

    <div class="boxed">

        <!--CONTENT CONTAINER-->
        <!--===================================================-->
        <div id="content-container">
            <!--Page content-->
            <!--===================================================-->
            <div id="page-content" style="padding: 0px">

                <iframe src="/jsp/module/sys/sysUser/sysUserList.jsp" width="100%" height="90%" frameborder="0"
                        name="mainframe" id="mainframe"></iframe>

            </div>
            <!--===================================================-->
            <!--End page content-->


        </div>
        <!--===================================================-->
        <!--END CONTENT CONTAINER-->


        <!--MAIN NAVIGATION-->
        <!--===================================================-->
        <nav id="mainnav-container">
            <div id="mainnav">


                <!--OPTIONAL : ADD YOUR LOGO TO THE NAVIGATION-->
                <!--It will only appear on small screen devices.-->
                <!--================================
                <div class="mainnav-brand">
                    <a href="index.html" class="brand">
                        <img src="static/img/logo.png" alt="Nifty Logo" class="brand-icon">
                        <span class="brand-text">Nifty</span>
                    </a>
                    <a href="#" class="mainnav-toggle"><i class="pci-cross pci-circle icon-lg"></i></a>
                </div>
                -->


                <!--Menu-->
                <!--================================-->
                <div id="mainnav-menu-wrap">
                    <div class="nano">
                        <div class="nano-content">

                            <!--Profile Widget-->
                            <!--================================-->
                            <div id="mainnav-profile" class="mainnav-profile">
                                <div class="profile-wrap text-center">
                                    <div class="pad-btm">
                                        <img class="img-circle img-md" src="static/img/profile-photos/1.png"
                                             alt="Profile Picture">
                                    </div>
                                    <a href="#profile-nav" class="box-block" data-toggle="collapse"
                                       aria-expanded="false">
                                            <span class="pull-right dropdown-toggle">
                                                <i class="dropdown-caret"></i>
                                            </span>
                                        <p class="mnp-name">${user.loginName}</p>
                                        <span class="mnp-desc">${user.name}</span>
                                    </a>
                                </div>
                                <div id="profile-nav" class="collapse list-group bg-trans">
                                    <a href="#" class="list-group-item">
                                        <i class="pli-male icon-lg icon-fw"></i> 名片
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="pli-gear icon-lg icon-fw"></i> 设置
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="pli-information icon-lg icon-fw"></i> 修改密码
                                    </a>
                                    <a href="#" class="list-group-item">
                                        <i class="pli-unlock icon-lg icon-fw"></i> 安全退出
                                    </a>
                                </div>
                            </div>


                            <!--Shortcut buttons-->
                            <!--================================-->
                            <div id="mainnav-shortcut">
                                <ul class="list-unstyled shortcut-wrap">
                                    <li class="col-xs-3" data-content="名片">
                                        <a class="shortcut-grid" href="#">
                                            <div class="icon-wrap icon-wrap-sm icon-circle bg-mint">
                                                <i class="pli-male"></i>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="col-xs-3" data-content="通知">
                                        <a class="shortcut-grid" href="#">
                                            <div class="icon-wrap icon-wrap-sm icon-circle bg-warning">
                                                <i class="pli-speech-bubble-3"></i>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="col-xs-3" data-content="修改密码">
                                        <a class="shortcut-grid" href="#">
                                            <div class="icon-wrap icon-wrap-sm icon-circle bg-success">
                                                <i class="pli-computer-secure"></i>
                                            </div>
                                        </a>
                                    </li>
                                    <li class="col-xs-3" data-content="安全退出">
                                        <a class="shortcut-grid" href="#">
                                            <div class="icon-wrap icon-wrap-sm icon-circle bg-purple">
                                                <i class="pli-lock-2"></i>
                                            </div>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                            <!--================================-->
                            <!--End shortcut buttons-->

                            <ul id="mainnav-menu" class="list-group">
                                <!--Menu list item-->

                                <li>
                                    <a href="#" data-original-title="" title="" class="" aria-expanded="false">
                                        <i class="pli-receipt-4"></i>
                                        <span class="menu-title"><strong>用户中心</strong></span><i class="arrow"></i></a>
                                    <ul class="collapse pop-in" id="用户中心" aria-expanded="false">
                                        <li class="menuItem" data-link="/jsp/module/sys/sysUser/sysUserList.jsp"><a href="#">
                                            <i class="pli-circular-point"></i>
                                            用户管理</a></li></ul>
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
                <!--================================-->
                <!--End menu-->

            </div>
        </nav>
        <!--===================================================-->
        <!--END MAIN NAVIGATION-->

        <!--ASIDE-->
        <!--===================================================-->
        <aside id="aside-container">
            <div id="aside">
                <div class="nano">
                    <div class="nano-content">

                        <!--Nav tabs-->
                        <!--================================-->
                        <ul class="nav nav-tabs nav-justified">
                            <li class="active">
                                <a href="#demo-asd-tab-1" data-toggle="tab">
                                    <i class="pli-speech-bubble-7"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#demo-asd-tab-2" data-toggle="tab">
                                    <i class="pli-information"></i>
                                    Reports
                                </a>
                            </li>
                            <li>
                                <a href="#demo-asd-tab-3" data-toggle="tab">
                                    <i class="pli-wrench"></i>
                                    Settings
                                </a>
                            </li>
                        </ul>
                        <!--================================-->
                        <!--End nav tabs-->


                        <!-- Tabs Content -->
                        <!--================================-->
                        <div class="tab-content">

                            <!--First tab-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <div class="tab-pane fade in active" id="demo-asd-tab-1">
                                <p class="pad-all text-lg">First tab</p>
                                <div class="pad-hor">
                                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                    volutpat.
                                    Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit
                                    lobortis nisl
                                    ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
                                    vulputate
                                    velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero
                                    eros et accumsan
                                    et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis
                                    dolore te feugait nulla facilisi.
                                </div>
                            </div>
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <!--End first tab-->


                            <!--Second tab-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <div class="tab-pane fade" id="demo-asd-tab-2">
                                <p class="pad-all text-lg">Second tab</p>
                                <div class="pad-hor">
                                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                    volutpat.
                                    Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit
                                    lobortis nisl
                                    ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
                                    vulputate
                                    velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero
                                    eros et accumsan
                                    et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis
                                    dolore te feugait nulla facilisi.
                                </div>
                            </div>
                            <!--End second tab-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->


                            <!--Third tab-->
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->
                            <div class="tab-pane fade" id="demo-asd-tab-3">
                                <p class="pad-all text-lg">Third tab</p>
                                <div class="pad-hor">
                                    Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                                    sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat
                                    volutpat.
                                    Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit
                                    lobortis nisl
                                    ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in
                                    vulputate
                                    velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero
                                    eros et accumsan
                                    et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis
                                    dolore te feugait nulla facilisi.
                                </div>
                            </div>
                            <!--~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~-->

                        </div>
                    </div>
                </div>
            </div>
        </aside>
        <!--===================================================-->
        <!--END ASIDE-->

    </div>


    <!-- FOOTER -->
    <!--===================================================-->
    <footer id="footer">

        <!-- Visible when footer positions are fixed -->
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <div class="show-fixed pad-rgt pull-right">
            You have <a href="#" class="text-main"><span class="badge badge-danger">3</span> pending action.</a>
        </div>


        <!-- Visible when footer positions are static -->
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <div class="hide-fixed pull-right pad-rgt">
            14GB of <strong>512GB</strong> Free.
        </div>


        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->
        <!-- Remove the class "show-fixed" and "hide-fixed" to make the content always appears. -->
        <!-- ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ -->

        <p class="pad-lft">&#0169; 2017 Your Company</p>


    </footer>
    <!--===================================================-->
    <!-- END FOOTER -->


    <!-- SCROLL PAGE BUTTON -->
    <!--===================================================-->
    <button class="scroll-top btn">
        <i class="pci-chevron chevron-up"></i>
    </button>
    <!--===================================================-->


</div>
<!--===================================================-->
<!-- END OF CONTAINER -->


</body>
</html>
<script>
    $(function () {
        //entity
        way.set("selectedDomain",{
            id:1,
            name:"物联网平台"
        });
        var menuData=[
            {
                id:1,
                name:"用户中心",
                url:"#",
                childs:[
                    {
                        id:1,
                        name:"用户管理",
                        url:"/jsp/module/sys/sysUser/sysUserList.jsp",
                        childs:[]
                    }
                ]
            },
            {
                id:2,
                name:"权限管理",
                url:"#",
                childs:[
                    {
                        id:1,
                        name:"域管理",
                        url:"/jsp/module/sys/sysDomain/sysDomainList.jsp",
                        childs:[]
                    },
                    {
                        id:1,
                        name:"角色管理",
                        url:"/jsp/module/sys/sysRole/sysRoleList.jsp",
                        childs:[]
                    },
                    {
                        id:1,
                        name:"权限管理",
                        url:"/jsp/module/sys/sysMenu/sysMenuList.jsp",
                        childs:[]
                    },
                    {
                        id:1,
                        name:"权限管理",
                        url:"/jsp/module/sys/sysMenu/sysMenuList.jsp",
                        childs:[]
                    }
                ]
            },
            {
                id:3,
                name:"基础数据",
                url:"#",
                childs:[]
            },
            {
                id:3,
                name:"系统设置",
                url:"#",
                childs:[]
            }
        ];
        initMenu(menuData);
        way.set("domainList",[
            {
                id:1,
                name:"物联网平台",
            },
            {
                id:1,
                name:"标准化种植",
            },
            {
                id:1,
                name:"价格体系",
            },
            {
                id:1,
                name:"区块链",
            },
            {
                id:1,
                name:"市政桥涵",
            }
        ]);
        //actions
        $("#mainnav-menu .menuItem").each(function () {
            $(this).click(function () {
                $("#mainframe").attr("src", $(this).data("link"));
            });
        });
    });

    function initMenu(json){
        var menuHtml = [];
        //一级菜单
        for(var i=0;i<json.length;i++){
            var root = json[i];
            menuHtml.push('<li ><a href="#">');
            if(!root.icon){
                root.icon = "pli-receipt-4";
            }
            menuHtml.push('<i class="'+root.icon+'"></i>');
            menuHtml.push(' <span class="menu-title"><strong>',root.name,'</strong></span><i class="arrow"></i></a>');
            appendChildren(menuHtml,root);
            menuHtml.push('</li>');
        }
        $('#mainnav-menu').prepend(menuHtml.join(''));
    }
    function appendChildren(menuHtml,obj){
        var childs = obj.childs;
        if(childs){
            menuHtml.push('<ul class="collapse" id="'+obj.name+'">');
            $.each(childs,function(){
                var icon = this.icon;
                if(!icon){
                    icon = "pli-circular-point";
                }
                menuHtml.push('<li class="menuItem" data-link="'+this.url+'"><a href="#">');
                menuHtml.push('<i class="'+icon+'"></i>');
                menuHtml.push(this.name+'</a></li>');
                appendChildren(menuHtml,this);
            });
            menuHtml.push('</ul>');
        }
    }
</script>
