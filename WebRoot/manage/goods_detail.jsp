<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>51商城――后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="../manage/CSS/style.css" rel="stylesheet">
<script src="onclock.JS"></script>
</head>
<body> 
<jsp:include page="banner.jsp"/>
<table width="1280" height="288"  border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
  <tr>

    <td align="center" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
      <tr>
        <td width="10" height="38" align="right">&nbsp;</td>
        <td colspan="3" class="tableBorder_B_dashed"><img src="../manage/images/manage_ico1.GIF" width="11" height="11">&nbsp;<a href="type_super_list.php"> [大分类信息管理]</a>&nbsp;&nbsp;&nbsp;<img src="../manage/images/manage_ico2.GIF" width="11" height="11">&nbsp;<a href="type_sub_list.php">[小分类信息管理]</a>&nbsp;&nbsp;&nbsp;<img src="../manage/images/manage_ico3.GIF" width="12" height="12">&nbsp;<a href="product_add.php">[添加商品信息]</a></td>
        <td width="12">&nbsp;</td>
      </tr>
      <tr>
        <td align="right">&nbsp;</td>
        <td height="10" colspan="3">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="29" align="right">&nbsp;</td>
        <td width="19" background="../manage/images/manage_leftTitle_left.GIF">&nbsp;</td>
        <td width="1070" align="center" background="../manage/images/manage_leftTitle_mid.GIF" class="word_white"><b>商品详细信息</b></td>
        <td width="20" background="../manage/images/manage_leftTitle_right.GIF">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="29" colspan="4" align="right">&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
    </table>

    <table width="96%" height="153"  cellpadding="0" cellspacing="0" border="1" bordercolor="#FFFFFF" bordercolordark="#FFFFFF" bordercolorlight="#E6E6E6" style="padding:5px;">
                    <tr>
                      <td width="37%" height="95" rowspan="4" align="center"><img src="../images/goods/${product.image }" width="120" height="80" class="tableBorder_l"></td>
                      <td width="63%" height="40">${product.name }</td>
                    </tr>
                    <tr>
                      <td height="40">单价：${product.priceNow }(元) </td>
                    </tr>
                    <tr>
                      <td height="40">${product.info }</td>
                    </tr>
                    <tr>
                      <td height="40"><input name="Submit" type="submit" class="btn_bg_short" onClick="history.back(-1);" value="返回">					</td>
                    </tr>
                  </table>	
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
