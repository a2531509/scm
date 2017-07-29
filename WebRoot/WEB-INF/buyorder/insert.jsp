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
  		var rowindex = undefined;
	  		$('#dg').datagrid({    

			    striped:true,
			    fitColumns:true,
			    idField:'goodsId',
			    rownumbers:true,
			    loadMsg:"加载中，请稍等...",
		    
			    toolbar: [{
					iconCls: 'icon-add',
					text:'添加商品',
					handler: function(){
						//alert("添加商品");
						parent.$('#win').window({ 
							title:'选择商品',      
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/goods/select.action' title='选择商品' height='100%' width='100%' frameborder='0px' ></iframe>"
						     
						}); 
					}
				},'-',{
					iconCls: 'icon-edit',
					text:'删除商品',
					handler: function(){
						alert('删除商品');
						/* var rows = $('#dg').datagrid('getSelections');
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
						     
						});  */
						
					}
				}
				,'-',{
					iconCls: 'icon-remove',
					text:'提交入库',
					handler: function(){
						var data = $('#dg').datagrid("getData");
						//alert(data);
						//console.info(data);
						var rows = data.rows;
						alert(JSON.stringify(rows));
						//console.info(rows);
						$('#ff').form('submit', {    
						    url:"${proPath}/buyOrder/insert.action",    
						    //
						    onSubmit: function(param){    
						        param.rows = JSON.stringify(rows);    
						         
						    }    
						});  
					}
				}],
			     

			     
			    columns:[[    
			    	{checkbox:true},    
			        {field:'goodsId',title:'商品编号',width:100},    
			        {field:'goodsName',title:'商品名称',width:100},  
			        {field:'goodsType',title:'型号',width:100},    
			        {field:'goodsUnit',title:'单位',width:100},
			        {field:'bodAmount',title:'数量',editor:'numberbox',width:100}, 
			        {field:'bodBuyPrice',title:'进价（元）',editor:'numberbox',width:100},  
			        {field:'bodTotalPrice',title:'总价（元）',width:100},   
			        {field:'bodImeiList',title:'串号',editor:'textarea',width:100,align:'right'}    
			    ]],
			    onDblClickCell:function(index,field,value){
			    //alert(index+"|"+field+"|"+value);
			    	$('#dg').datagrid('beginEdit',index);
				    var ed = $('#dg').datagrid('getEditor', {index:index,field:'bodAmount'});
					//$(ed.target).datebox('setValue', '5/4/2012');
					rowindex = index; 			    
			    },
			    onClickCell:function(index,field,value){
			       if(rowindex!=undefined){
				    	//获取数量
				    	var edBodAmount = $('#dg').datagrid('getEditor', {index:rowindex,field:'bodAmount'});
						var bodAmountValue = $(edBodAmount.target).numberbox('getValue');
						//alert(bodAmountValue);
						//获取进价
					    var edBodBuyPrice = $('#dg').datagrid('getEditor', {index:rowindex,field:'bodBuyPrice'});
						var bodBuyPriceValue = $(edBodBuyPrice.target).numberbox('getValue');
						//计算总价
						var bodTotalPriceValue =bodBuyPriceValue*bodAmountValue;
						//alert(bodTotalPriceValue);			
						
						$('#dg').datagrid('endEdit',rowindex);
						
							$('#dg').datagrid('updateRow',{
							index: rowindex,
							row: {
								bodTotalPrice: bodTotalPriceValue
							}
						});
						
						rowindex = undefined; 
					}			    
			    }  
			});  
			$('#supName').searchbox({ 
			searcher:function(value,name){ 
				alert(value + "," + name) ;
				parent.$('#win').window({ 
							title:'选择供应商',   
						    width:600,    
						    height:400,    
						    modal:true,
						    content:"<iframe src='${proPath}/base/goURL/supplier/select.action' title='选择供应商' height='100%' width='100%' frameborder='0px' ></iframe>"
						     
						});  
				}, 
				prompt:'请选择供应商' 
			}); 
			
				
  		//禁用供应商信息的输入
		var box = $('#supName').searchbox('textbox');//获取控件文本框对象
   	    box.attr('disabled',true);// 设置无效，禁用输入
		
  		});
  	
  		
 
  	
  		
  	</script>
  
  </head>  
  <body>

   <form class="myfm" style="padding:10px;margin:0px;background:#eee;" id="ff" action="">
   <div class="myftitle">请填写采购信息</div>
   
  
   <div class="myfitem2"> 	
 	 	  <label>供应商：</label><input  id="supName" class="easyui-searchbox" name="supName"/>
 	  <input type="hidden" id="supId" name="supId"/>
			<label for="shId">仓库类型：</label><select id="cc"
				class="easyui-combobox" name="shId" >
				<c:forEach items="${applicationScope.sysParam.shId}"
					var="sh">
					<option value="${sh.key}">${sh.key}--${sh.value}</option>
				</c:forEach>
			</select>		
 	<label>日期：</label><input  type="text" id="boDate"
				class="easyui-datebox" name="boDate" required/>
  
   </div>
   
    <div class="myfitem2">
    <label> 应付：</label><input type="text" id="boPayable" name="boPayable"/>   
    <label>已付：</label><input type="text" id="boPaid" name="boPaid"/>
 	<label>欠款：</label><input type="text" id="boArrears" name="boArrears"/>  
</div>

 <div class="myfitem2">
   
 	<label>原始单号：</label><input type="text" id="boOriginal" name="boOriginal"/>
 	<label>经手人：</label><input type="text" id="boAttn" name="boAttn"/>
 	<label>操作员：</label><input type="text" id="boOperator" name="boOperator"/>
 	</div>
 	
 	 <div class="myfitem2"> 
<label>备注：</label><input type="text" id="boRemark" name="boRemark"/>
 	</div>
 </form>
 	<table id="dg"></table>  



  </body>
</html>