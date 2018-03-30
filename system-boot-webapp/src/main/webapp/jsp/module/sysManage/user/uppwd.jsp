<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@ include file="../../public/editHead.jsp"%>
	<%
		String contextpath = request.getContextPath();
	%>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#confirmBtn").click(function(){
				$("form").submit();
			});
			$('#closeBtn').click(function(){
			   top.$.jBox.close('editUpdatePwdWin');
			});
			initForm("updatePwdForm","data", function(data){
				 if(data.success){
			   	    top.$.jBox.tip("修改成功",'success');
			     } else
				    top.$.jBox.tip(data.info,'failure');
		    });
		})
	</script>
</head>

<body>
<div class="smart-widget no-border">
    <div class="smart-widget-inner">
        <div class="smart-widget-body">
            <form class="form-horizontal no-margin form-border" method="post" name="updatePwdForm" id="updatePwdForm" 
			action="<%=contextpath%>/permissions/SysUserController/updatePwd.do"">
                <div class="form-group">
                    <label class="control-label col-xs-4">原密码：</label>
                    <div class="col-xs-8">
                        <input type="password" class="form-control validate[required] required" name="userpass" required placeholder="请原密码" >
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-4">新密码：</label>
                    <div class="col-xs-8">
                       <input type="password" id="newpasswordid" class="form-control validate[required]" name="newuserpass" required placeholder="请输入用户名称">
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-4">确认密码：</label>
                    <div class="col-xs-8">
                       <input type="password" id="newuserpasscrm" class="form-control validate[equals[newpasswordid]]" required name="newuserpasscrm" required placeholder="请输入用户名称">
                    </div>
                </div>
                <div class="text-center m-top-md" id="optDiv">
                    <button type="submit" class="btn btn-info" id="confirmBtn">保存</button>
                    <button type="button" class="btn btn-danger" id="closeBtn">关闭</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
