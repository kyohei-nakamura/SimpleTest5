<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<body>
<h1>SpringMVC localization example</h1>
<spring:message code="global.username"/>
<form:form modelAttribute="viewordownload" action="${appUrl}/login" method="POST">
<form:radiobutton path="view" value="on" label="View"/><br>
<form:radiobutton path="download" value="on" label="Download"/><br>
<input type="submit">
</form:form>
</body>
</html>