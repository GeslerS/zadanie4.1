<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Hello!</title>
</head>
<body>
<form:form method="POST" action="/hello">
    <form:input type="text" path="name" />
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>