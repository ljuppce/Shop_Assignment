<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista kupaca</title>
</head>
<body>
    <h2>Lista kupaca</h2>

    <div>
        <a href="${pageContext.request.contextPath}/buyers/new">Dodaj novog kupca</a>
    </div>

    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Ime</th>
                <th>Email</th>
                <th>Akcije</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="buyer" items="${buyers}">
                <tr>
                    <td>${buyer.id}</td>
                    <td>${buyer.name}</td>
                    <td>${buyer.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/buyers/edit/${buyer.id}">Izmeni</a> |
                        <form action="${pageContext.request.contextPath}/buyers/delete/${buyer.id}" method="post" style="display:inline;">
                            <button type="submit">Obriši</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
