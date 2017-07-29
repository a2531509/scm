<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/common/common.jspf" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
.searchbox{
	margin:-3
}
</style>
  
    <title>supplier list page</title>
  	<script type="text/javascript">
  		$(function(){
	  		$('#dg').datagrid({    
	  		
			    //url:'${proPath}/supplier/selectPage.action', //支持单个关键字的分页查询  			 
				url:'${proPath}/supplier/selectPageUseDyc.action', //支持多个条件的分页查询
			    striped:true,
			    fitColumns:true,
			    idField:'supId',
			    rownumbers:true,
			    loadMsg:"加载中，请稍等...",
			    pagination:true,
			    pageSize:5,
			    pageList:[2,5,10,15],
			    //支持单个关键字分页查询
			 /*     queryParams:{
					keyWord:'%%'
				}, */
				//支持多条件分页查询
			   /*  queryParams:{
					supName:'%%',
					supAddress:'%%'
				},  */
			    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'添加',
					handler: function(){
						parent.$('#win').window({ 
							title:'添加供应商',      
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/supplier/insert.action' title='添加供应商' height='100%' width='100%' frameborder='0px' ></iframe>"
						     
						}); 
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler: function(){
						var rows = $('#dg').datagrid('getSelections');
						if(rows.length!=1){
							alert("请选择并且只能选择一条修改的记录！");
							return false;
						}
						
						parent.$('#win').window({ 
							title:'修改供应商',   
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/supplier/update.action' title='修改供应商' height='100%' width='100%' frameborder='0px' ></iframe>"
						     
						}); 
						
					}
				}
				,'-',{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						//alert('del按钮');
						/*
						1.获取选择的行，判断是否有选中
						2.获取行中记录ID数组
						3.确认是否删除
						4.提交删除请求
						5.刷新当前页面（列表部分）						
						*/
						//1.获取选择的行，判断是否有选中
						var rows = $('#dg').datagrid("getSelections");
						if(rows.length==0){
							alert("请选择需要删除的记录！");
							return false;
						}
						//2.获取行中记录ID数组
						var ids = new Array();
						for(var i=0;i<rows.length;i++){
							alert(rows[i].supId);
							ids[i]=rows[i].supId;							
						}
						
						
						parent.$.messager.confirm('删除对话框', '您确认要删除吗？', function(r) {
							if (r) {
								alert(r);
								$.ajax({
								  url: "${proPath}/supplier/deleteList.action",
								  type:"POST",
								  //设置为传统方式传送参数
								  traditional:true,
								  data:{pks:ids},
								  success: function(html){
								  if(html>0){
								  	alert("恭喜您，删除成功，共删除了"+html+"条记录！");
								  }else{
								  	alert("对不起，删除失败，请联系管理员！");								  
								  }
								  //重新刷新页面
								    $("#dg").datagrid("reload");
								    //请除所有勾选的行
								    $("#dg").datagrid("clearSelections");
								  },
								  error: function (XMLHttpRequest, textStatus, errorThrown) {
									    $.messager.alert('删除错误','请联系管理员！','error');
									},
								  dataType:'json'
								});
							}
							});
						
						
					}
				},'-',{
					text:"<input type='text' id='supName' name='supName'/>"
				},'-',{
					text:"<input type='text' id='supAddress' name='supAddress'/>"
				}],
			     
			    columns:[[    
			    	{checkbox:true},    
			        {field:'supId',title:'供应商编号',width:100},    
			        {field:'supName',title:'供应商名称',width:100},  
			        {field:'supLinkman',title:'联系人',width:100},    
			        {field:'supPhone',title:'联系电话',width:100},
			        {field:'supAddress',title:'地址',width:100}, 
			        {field:'supPay',title:'期初应付（元）',width:100},  
			        {field:'supType',title:'供应商类型',width:100,formatter: function(value,row,index){
			        		return valueToText("${applicationScope.sysParam.supType}",value);
						}
			        },   
			        {field:'supRemark',title:'备注',width:100,align:'right',
			       formatter: function(value,row,index){
					return "<span title='"+value+"'>"+value+"</span>";
					}
	       	 	}    
			    ]]    
			});  
			
			$('#supAddress').searchbox({ 
			searcher:function(value,name){ 
					alert(value + "," + name);
					alert($('#supName').val());
					
					$('#dg').datagrid('load',{
						supName:likeParam($('#supName').val()),
						supAddress:likeParam(value)
					});					
				}, 				
				prompt:'请输入供应商地址' 
			}); 
  		
  		});
  		//
  		function likeParam(value){
  			if(value==""){
  				return "";
  			}else{
  				return '%'+value+'%';
  			}
  		}
  		
  	</script>
  
  </head>  
  <body>
<!--   <form action="">
  <input type='text' id='supName' name='supName'/>
  <input type='text' id='supName' name='supName'/><br>
    <input type='text' id='supName' name='supName'/>
  <input type='text' id='supName' name='supName'/><br>
  </form> -->
 	<table id="dg"></table>  



  </body>
</html>