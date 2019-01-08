<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="categoryDetailId" class="textarea" id="typeID">
	<option value="">请选择</option>
	<c:forEach items="${categoryDetailList }" var="categoryDetail">
		<c:choose>
			<c:when test="${categoryDetail.categoryDetailId == categoryDetailId }">
		   		<option value="${categoryDetail.categoryDetailId }" selected>
		   			${categoryDetail.name }
		   		</option>
			</c:when>
			<c:otherwise>
				<option value="${categoryDetail.categoryDetailId }">
		   			${categoryDetail.name }
		   		</option>
			</c:otherwise>
		</c:choose>
	</c:forEach>
 </select>
