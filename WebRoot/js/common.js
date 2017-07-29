function valueToText(str,value){
	str = str.substring(1, str.length-1);
	//alert("str:"+str);
	var array = str.split(",");
	for(var i =0;i<array.length;i++){
		//alert(array[i]);
		var array2 = array[i].split("=");
		//alert(array2[0]+"|"+array2[1]);
		if($.trim(value)==$.trim(array2[0])){
			return array2[1];
		}
	}	
	return "末知类型，请联系管理员";	
}