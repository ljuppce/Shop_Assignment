<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Izmeni prodaju</title>
</head>
<body>
    <h2>Izmeni prodaju</h2>

    <form action="${pageContext.request.contextPath}/sales/update" method="post">
        <div>
            <label for="product">Proizvod:</label>
            <select name="product.id">
                <c:forEach var="product" items="${products}">
                    <option value="${product.id}" ${product.id == sale.product.id ? 'selected' : ''}>${product.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="buyer">Kupac:</label>
            <select name="buyer.id">
                <c:forEach var="buyer" items="${buyers}">
                    <option value="${buyer.id}" ${buyer.id == sale.buyer.id ? 'selected' : ''}>${buyer.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label for="quantity">Kolicina:</label>
            <input type="number" name="quantity" value="${sale.quantity}" required />
        </div>
        <div>
            <button type="submit">Spremi izmene</button>
        </div>
    </form>
</body>
</html>
