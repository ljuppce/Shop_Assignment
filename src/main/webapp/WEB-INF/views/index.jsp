<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; language=java" %>
<!DOC TYPE html>
<html>
<head>
    <title>Shop MVC - Početna stranica</title>
</head>
<body>
    <h1>MVC shop</h1>

    <div>
        <a href="<spring:url value='/buyers' />">Kupci</a>
    </div>
    <div>
        <a href="<spring:url value='/products' />">Proizvodi</a>
    </div>
    <div>
        <a href="<spring:url value='/sales' />">Prodaje</a>
    </div>
</body>
</html>
