<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista proizvoda</title>
</head>
<body>
    <h2>Lista proizvoda</h2>

    <div>
        <a href="${pageContext.request.contextPath}/products/new">Dodaj novi proizvod</a>
    </div>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Naziv</th>
                <th>Cena</th>
                <th>Količina</th>
                <th>Akcije</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/products/edit/${product.id}">Izmeni</a> |
                        <form action="${pageContext.request.contextPath}/products/delete/${product.id}" method="post" style="display:inline;">
                            <button type="submit">Obriši</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
