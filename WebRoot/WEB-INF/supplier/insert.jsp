<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<%@ include file="/common/common.jspf"%>
<title>My JSP</title>
</head>
<body class="mybody">
<form id="ff" method="post" class="myfm">
<div class="myftitle">请输入供应商信息</div>
<div class="myfitem">
		
	   <div>
			<label for="supId">供应商编号:</label> <input type="text" name="supId" />
		</div>
		<div>
			<label for="supName">供应商:</label> <input type="text" name="supName" />
		</div>
		<div>
			<label for="supLinkman">联系人:</label> <input type="text"
				name="supLinkman" />
		</div>
		<div>
			<label for="supPhone">联系电话:</label> <input type="text"
				name="supPhone" />
		</div>
		<div>
			<label for="supAddress">联系地址:</label> <input type="text"
				name="supAddress" />
		</div>
				<div>
			<label for="supPay">期初应付:</label> <input type="text"
				name="supPay" />
		</div>
				<div>
			<label for="supType">供应商类型：</label> 									
				<select id="cc" class="easyui-combobox" name="supType" style="width:200px;">   
					<c:forEach items="${applicationScope.sysParam.supType}" var="supType">
					    <option value="${supType.key}">${supType.value}</option>   
					</c:forEach>   
				</select>  
		</div>
		<div>
			<label for="supRemark">备注:</label>
			<textarea name="supRemark"></textarea>
		</div>
		<div>
			<a id="btn" href="#" class="easyui-linkbutton" >提交</a> 
			<a id="btn1" href="#" onClick="javascript:$('#ff').form('reset')" class="easyui-linkbutton" >重置</a> 
		</div>
		</div>
	</form>


	<script type="text/javascript">
		$(function() {
			var win = parent.$("iframe[title='供应商管理']").get(0).contentWindow;//返回ifram页面文档（window)
		
			$("[name='supName']").validatebox({
				required : true,
				missingMessage : '请填写供应商！'
			});
			
			//禁用验证
			$("#ff").form("disableValidation");

			$("#btn").click(function() {
				$("#ff").form("enableValidation");
				if ($("#ff").form("validate")) {
					$('#ff').form('submit', {
						url : '${proPath}/supplier/insert.action',
						onSubmit : function() {
							return true;
						},
						success : function(count) {							
								//可以定义为对应消息框
								if(count>0){
									alert("成功");
								}else{
									alert("失败");
								}
                        	    
								parent.$("#win").window("close");
								win.$("#dg").datagrid("reload");							
						}
					});

				}

			});

		});
	</script>
</body>
</html>