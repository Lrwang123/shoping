<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>51商城――后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../manage/CSS/style.css" rel="stylesheet">
<script language="javascript" src="../manage/JS/jquery.min.js"></script>
<script language="javascript">
/***************************调用函数*************************/
/* $(document).ready(function(){
	selSubType(${product.categoryDetail.categoryId});
}); */

function selSubType(val){

$.get("../manage/type_sub_list.part",
		{superID:val},
		function(data){
			$("#subType").html(data); 		//显示获取到的小分类
});
}

function selSubTypeFirst(val,val2){

$.get("../manage/type_sub_list.part",
		{superID:val,categoryDetailId:val2},
		function(data){
			$("#subType").html(data); 		//显示获取到的小分类
});
}
</script>
</head>
<script language="javascript">
function mycheck(){
	if (form1.goodsName.value==""){
		alert("请输入商品名称！");form1.goodsName.focus();return;
	}
	if (form1.picture.value==""){
		alert("请输入图片文件的路径！");form1.picture.focus();return;
	}
	if (form1.price.value==""){
		alert("请输入商品的定价！");form1.price.focus();return;
	}
	if (isNaN(form1.price.value)){
		alert("您输入的定价错误，请重新输入！");form1.price.value="";form1.price.focus();return;
	}	
	if (form1.introduce.value==""){
		alert("请输入商品简介！");form1.introduce.focus();return;
	}		
	form1.submit();
}
</script>

<body onLoad="selSubTypeFirst(${product.categoryDetail.categoryId},${product.categoryDetailId })">
<jsp:include page="banner.jsp"/>
<table width="1280" height="288"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>

    <td align="center" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="10" height="38" align="right">&nbsp;</td>
        <td colspan="3" class="tableBorder_B_dashed">
			<img src="../manage/images/manage_ico1.GIF" width="11" height="11">
			&nbsp;
			<a href="type_super_list.php"> [大分类信息管理]</a>&nbsp;&nbsp;&nbsp;
			<img src="../manage/images/manage_ico2.GIF" width="11" height="11">
			&nbsp;
			<a href="type_sub_list.php">[小分类信息管理]</a>&nbsp;&nbsp;&nbsp;
			<img src="../manage/images/manage_ico3.GIF" width="12" height="12">
			&nbsp;
			<a href="product_add.php">[添加商品信息]</a>
		</td>
        <td width="12">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td height="10" colspan="3">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="29" align="right">&nbsp;</td>
        <td width="10" background="../manage/images/manage_leftTitle_left.GIF">&nbsp;</td>
        <td width="1089" align="center" background="../manage/images/manage_leftTitle_mid.GIF" class="word_white"><b>修改商品信息</b></td>
        <td width="10" background="../manage/images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>
	<!---->
      			 <form action="product_modify" method="post" name="form1">
			    <table width="94%"  border="0" align="right" cellpadding="-2" cellspacing="-2" bordercolordark="#FFFFFF">
                  <tr>
                    <td width="14%" height="27">&nbsp;商品名称：
                      <input name="ID" type="hidden" id="ID" value="${product.productId }"></td>
                    <td height="27" colspan="3">&nbsp;
                      <input name="goodsName" type="text" class="Sytle_text" value="${product.name }" size="50">
                      &nbsp;&nbsp;                    </td>
                  </tr>
                  <tr>
                    <td height="27">&nbsp;所属大类：</td>
                    <td width="31%" height="27">&nbsp;
                      <select name="supertype" class="textarea" id="supertype"  onChange="selSubType(this.value)">
					  <c:forEach items="${categoryList }" var="category">
					  	<option value="${category.categoryId }"
					  		<c:if test="${product.categoryDetail.categoryId == category.categoryId }"> 
   							selected
   							</c:if>>${category.name }</option>
					  </c:forEach>
                      </select></td>
                    <td width="13%" height="27"> &nbsp;所属小类：</td>
                    <td width="42%" height="27" id="subType">正在调用小分类信息……</td>
                  </tr>
                  <tr>
                    <td height="16">&nbsp;图片文件：</td>
                    <td height="27" colspan="3">&nbsp;
                        <input name="picture" type="text" class="Style_upload" id="picture" value="<%-- <%=picture%> --%>" size="30"> 
                        (此处只填写图片文件路径即可)                         </td>
                  </tr>
                  <tr>
                    <td height="27" align="center">定　　价：</td>
                    <td height="27"><span style="float:left;"><input name="price" type="text" class="Sytle_text" id="price3" value="${product.price }" size="14">                      
                     </span><span  style="float:left;padding-top:10px;">&nbsp;(元)</span></td><td height="27" align="center">现&nbsp;&nbsp;&nbsp;&nbsp;价： </td>
                    <td height="27"><span style="float:left;"><input name="nowPrice" type="text" class="Sytle_text" id="price4" value="${product.priceNow }" size="14">
</span><span  style="float:left;padding-top:10px;">&nbsp;(元)</span></td>
                  </tr>
                  <tr>
                    <td height="45">&nbsp;是否新品：</td>
                    <c:if test="${product.isNew == 1 }">
	                    <td>&nbsp; <input name="newGoods" type="radio" class="noborder" value="1" checked >是
	  								<input name="newGoods" type="radio" class="noborder" value="0">否
	  					</td>
                    </c:if>
                    <c:if test="${product.isNew != 1 }">
	                    <td>&nbsp; <input name="newGoods" type="radio" class="noborder" value="1" >是
	  								<input name="newGoods" type="radio" class="noborder" value="0" checked >否
	  					</td>
                    </c:if>
                    
                    <td>&nbsp;是否特价：</td>
                    <c:if test="${product.isPromotion == 1 }">
	                    <td><input name="sale" type="radio" class="noborder" value="1" checked>是
	  						<input name="sale" type="radio" class="noborder" value="0">否
	  					</td>
  					</c:if>
                    <c:if test="${product.isPromotion != 1 }">
	                    <td><input name="sale" type="radio" class="noborder" value="1" >是
	  						<input name="sale" type="radio" class="noborder" value="0" checked>否
	  					</td>
  					</c:if>
                  </tr>
                  <tr>
                    <td height="103">&nbsp;商品简介：</td>
                    <td colspan="3"><span class="style5">&nbsp; </span>
                        <textarea name="introduce" cols="60" rows="5" class="textarea" id="introduce">${product.info }</textarea></td>
                  </tr>
                  <tr>
                    <td height="38" colspan="4" align="center">
                        <input name="Button" type="button" class="btn_bg_short" value="保存" onClick="mycheck()">&nbsp;                        
                        <input name="Submit2" type="reset" class="btn_bg_short" value="重置">&nbsp;
                        <input name="Submit3" type="button" class="btn_bg_short" value="返回" onClick="JScript:history.back()">
                    </td>
                  </tr>
                </table>
			  </form>
</td>
	  
	      <td width="182" valign="top"><table width="100%" height="431"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="199" valign="top" bgcolor="#FFFFFF"><jsp:include page="navigation.jsp"/></td>
      </tr>
    </table></td>	  
  </tr>
</table>
<jsp:include page="copyright.jsp"/>
</body>
</html>
