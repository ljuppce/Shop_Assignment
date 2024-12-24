<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shop MVC - Početna stranica</title>
</head>
<body>
    <h1>Dobrodošli u Shop MVC aplikaciju!</h1>

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
