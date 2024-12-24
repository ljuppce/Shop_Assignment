<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista prodaja</title>
</head>
<body>
    <h2>Lista prodaja</h2>

    <div>
        <a href="${pageContext.request.contextPath}/sales/edit/new">Dodaj novu prodaju</a>
    </div>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Proizvod</th>
                <th>Kupac</th>
                <th>Datum prodaje</th>
                <th>Akcije</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="sale" items="${sales}">
                <tr>
                    <td>${sale.id}</td>
                    <td>${sale.product.name}</td>
                    <td>${sale.buyer.name}</td>
                    <td>${sale.saleDate}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/sales/edit/${sale.id}">Izmeni</a> |
                        <form action="${pageContext.request.contextPath}/sales/delete/${sale.id}" method="post" style="display:inline;">
                            <button type="submit">Obriši</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
