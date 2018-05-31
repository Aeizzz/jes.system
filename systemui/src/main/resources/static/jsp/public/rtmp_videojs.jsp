<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="head.jsp"%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<link href="${ctx}/component/videojs/video-js.css" rel="stylesheet" type="text/css">
<script src="${ctx}/component/videojs/video.js"></script>
<script src="${ctx}/js/public/jquery-1.10.2.min.js"></script>
<script>
   videojs.options.flash.swf = "${ctx}/component/videojs/video-js.swf";
</script>
<title>直播</title>
</head>
<body >
<div id="engage_view" style="display: block;">
    <div id="engage_content">
        <div id="engage_resize_container">

            <div id="engage_video">
                <!-- theodul video videojs plugin desktop mode  controls preload="auto"
                        vjs-big-play-centered 播放按钮居中
                        poster默认的显示界面，就是还没点播放，给你显示的界面
                        controls
                        preload="auto" 是否提前加载
                        autoplay 自动播放
                        loop=true 自动循环
                        data-setup='{"example_option":true}' 可以把一些属性写到这个里面来，如data-setup={"autoplay":true}
                -->
                <video id="my-video" class="video-js vjs-default-skin vjs-big-play-centered"
                         height="380px"
                >
                    <!--
                        <source src="../output.mp4" type='video/mp4'>  mp4格式
                        <source src='rtmp://127.0.0.1/hls/test' type='rtmp/flv'/> rtmp格式
                        <source src='http://127.0.0.1/hls/test.m3u8' type='application/x-mpegURL'/>  m3u8格式
                        <source src='http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8' type='application/x-mpegURL'/> m3u8格式，可用
                    -->
                    <source src='${rtmp }' type='rtmp/flv'/>
                </video>

                <!-- http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8 可用的m3u8地址    -->
                <!-- rtmp://live.hkstv.hk.lxdns.com/live/hks  可用的rtmp地址-->
            </div>
        </div>
        <!-- timeline plugin container -->
    </div>
</div>
<div class="clear"></div>
<div id="information_wrapper">
    <!-- description plugin container -->
    <div id="engage_description"><!-- theodul description plugin desktop mode -->

        <div id="engage_basic_description"></div>

    </div>
</div>
<div class="tab-pane" id="engage_Slide_text_tab"><!-- theodul tab slidetext plugin embed mode -->
</div>

<script src="flash.js"></script>
<!-- <script src="videojs/videojs-contrib-hls.min.js"></script>-->

<script>

    //播放的话，就直接使用下面2行
    //后面注释的那些其实也是可用用的，不过刚开始集成，越简单越好
    
    
    (function ($) {
        var player = videojs('my-video');
        var resetVideoSize = function (player) {
            var videoJsBoxWidth = $(".video-js").width();
            var ratio = 1440 / 900;
            var videoJsBoxHeight = videoJsBoxWidth / ratio;
            player.height(videoJsBoxHeight);
        }

        $(window).on("resize", function () {
            resetVideoSize(player);
        });
       
        player.play();
    })(jQuery)
    /*
    function changeSrc() {
        var src = "http://127.0.0.1/hls/test.m3u8";
        var myPlayera = videojs("my-video");
        $("#my-video").attr("src", "rtmp://live.hkstv.hk.lxdns.com/live/hks")
        myPlayera.src("rtmp://live.hkstv.hk.lxdns.com/live/hks"); //重新初始化视频地址
        myPlayera.load("rtmp://live.hkstv.hk.lxdns.com/live/hks"); //重新加载
    }
    */
    function changeSrc(src) {

        var myPlayera = videojs("my-video");
        //$("#videojs_videodisplay_presentation_html5_api").attr("src", "rtmp://live.hkstv.hk.lxdns.com/live/hks")
        myPlayera.src(src); //重新初始化视频地址
        myPlayera.load(src); //重新加载
    }
</script>

</body>
</html>