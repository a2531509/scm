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
  
    <title>supplier select page</title>
  	<script type="text/javascript">
  		$(function(){
  			var win = parent.$("iframe[title='商品入库']").get(0).contentWindow;
	  		$('#dg').datagrid({    
				url:'${proPath}/supplier/selectPageUseDyc.action', //支持多个条件的分页查询
			    striped:true,
			    fitColumns:true,
			    idField:'supId',
			    rownumbers:true,
			    loadMsg:"加载中，请稍等...",
			    pagination:true,
			    pageSize:5,
			    pageList:[2,5,10,15],
			    singleSelect:true,
			    
			    toolbar: [{
					iconCls: 'icon-ok',
					text:'确定',
					handler: function(){
						var row = $('#dg').datagrid("getSelected");
						if(row==null){
							alert("请选择一个供应商");
							return false;
						}
						win.$('#ff').form("load",{
							supId:row.supId,
							supName:row.supName
						});
						parent.$('#win').window("close");
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
			        {field:'supType',title:'供应商类型',width:100},   
			        {field:'supRemark',title:'备注',width:100,align:'right'}    
			    ]]    
			});  
			
			$('#supAddress').searchbox({ 
			searcher:function(value,name){ 
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
 	<table id="dg"></table>  

  </body>
</html>