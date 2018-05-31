<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<%@ include file="/jsp/public/weuiHead.jsp"%>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no" />
<title>直播</title>
</head>
<body style='overflow:hidden'>
	<div style="height:100%">
		<script type="text/javascript"
			src="${ctx}/component/sewise/player/sewise.player.min.js?server=live
			&type=rtmp
			&streamurl=${rtmp }
			&autostart=true
			&buffer=5
			&lang=zh_CN
			&topbardisplay=disable
			<%-- &logo=${ctx }/images/logo.png --%>
			<%-- &poster=${ctx }/images/back.jpg --%>
			&title=LiveVideo
			&skin=liveWhite"></script>
	</div>
</body>
</html>