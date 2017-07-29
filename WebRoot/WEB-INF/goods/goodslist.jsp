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
  
    <title>goods list page</title>
  	<script type="text/javascript">
  		$(function(){
	  		$('#dg').datagrid({    
	  		
				url:'${proPath}/goods/selectPageUseDyc.action', //支持多个条件的分页查询
			    striped:true,
			    fitColumns:true,
			    idField:'goodsId',
			    rownumbers:true,
			    loadMsg:"加载中，请稍等...",
			    pagination:true,
			    pageSize:5,
			    pageList:[2,5,10,15],
			    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'添加',
					handler: function(){
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'修改',
					handler: function(){
						
					}
				}
				,'-',{
					iconCls: 'icon-remove',
					text:'删除',
					handler: function(){
						
						
					}
				},'-',{
					text:"<input type='text' id='goodsName' name='goodsName'/>"
				}],
			     
			    columns:[[    
			    	{checkbox:true},    
			        {field:'goodsId',title:'商品编号',width:100},    
			        {field:'goodsName',title:'商品名称',width:100},  
			        {field:'goodsRemark',title:'备注',width:100,align:'right'}    
			    ]]    
			});  
			
			$('#goodsName').searchbox({ 
			searcher:function(value,name){ 
					$('#dg').datagrid('load',{
						goodsName:likeParam(value)
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