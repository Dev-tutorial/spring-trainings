<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error{color: #ff0000;}
.errorblock{color: #000; background-color: #ffEEEE; border: 3px solid #ff0000; 
			padding: 2px; margin: 16px; max-width:50%;}
</style>
<script type="text/javascript" src="jquery-3.4.1.js"></script>
<script type="text/javascript">
$(document).ready(
		function(){
			$.getJSON('<spring:url value="categories.json"/>',{
				ajax : 'true'
			},function(data){
				var html = '<option value="">--Please Select One--</option>';
				var len = data.length;
				for(var i=0; i< len; i++){
					html += '<option value ="' +data[i].category+ '">'
							+ data[i].category + '</option>';
				}
				html += '</option>'
				$('#categories').html(html);
			});
		});
</script>
</head>
<body>
<h5 align="right">Welcome ${user.userName}</h5>
<h1><spring:message code="dashboard.title"/></h1>
<form:form commandName="dashboard">
<form:select path="category" id="categories"></form:select>
<table>

</table>
</form:form>

</body>
</html>