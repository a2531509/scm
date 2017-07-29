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
  			var win = parent.$("iframe[title='商品入库']").get(0).contentWindow;
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
			    singleSelect:true,
			    toolbar: [{
					iconCls: 'icon-ok',
					text:'确定',
					handler: function(){
						var row = $('#dg').datagrid("getSelected")
						if(row==null){
							alert("请选择需要商品!");
							return false;
						}
						win.$('#dg').datagrid('appendRow',{
							goodsId: row.goodsId,
							goodsName:row.goodsName,
							goodsType: row.goodsType,
							goodsUnit:row.goodsUnit,
							bodAmount:$('#bodAmount').val(),
							bodBuyPrice:$('#bodBuyPrice').val(),
							bodTotalPrice:$('#bodBuyPrice').val()*$('#bodAmount').val(),
							bodImeiList:$('#bodImeiList').val()
						});
						parent.$('#win').window("close");
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
 	
<form  style="padding:5px;margin:0px;background:#eee;"  action="">
	采购数量：<input type="text" id='bodAmount' name='bodAmount' class="easyui-numberbox" value="1" data-options="min:1,max:1000000000">
	价格：<input type="text" id='bodBuyPrice' name='bodBuyPrice' class="easyui-numberbox"  value="22" data-options="min:0,precision:2">
	手机串号：<textarea  id='bodImeiList' name='bodImeiList'>3333</textarea>

</form>
 	
  </body>
</html>