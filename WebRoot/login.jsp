<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>Login page</title>
  	<script type="text/javascript">
  		$(function(){
		  		$('#dd').dialog({    
			    title: '登录窗口',    
			    width: 250,    
			    height: 150,    
			    closed: false,    
			    cache: false,    
			    //href: 'get_content.php',    
			    modal: true,
			    buttons:[{
					text:'登录',
					handler:function(){
						$('#ff').form('enableValidation');
						//进行验证,如果通过(返回true)提交表单
						if($('#ff').form('validate')){
							$('#ff').submit();
					}
				}
			},{
				text:'重置',
				handler:function(){
					//alert('重置表单');
					$('#ff').form('reset');
				}
				}]   
			});
			//禁用表单验证
			$('#ff').form("disableValidation");    
  		});
  	</script>
  
  </head>

    
  <body>
  <div id="dd">
	  	<form id="ff" action="${proPath}/account/login.action" method="post">   
	    <div>   
	        <label for="name">账号:</label>   
	        <input class="easyui-validatebox" type="text" name="accLogin" data-options="required:true" />   
	    </div>   
	    <div>   
	        <label for="email">密码:</label>   
	        <input class="easyui-validatebox" type="text" name="accPass" data-options="required:true" />   
	    </div> 
	    <div style="color:red">${requestScope.errMsg}</div>  
	</form>  
  </div>
  </body>
</html>
