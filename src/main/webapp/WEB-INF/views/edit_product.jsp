<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Izmeni proizvod</title>
</head>
<body>
    <h2>Izmeni proizvod</h2>

    <form action="${pageContext.request.contextPath}/products/update/${product.id}" method="post">
        <div>
            <label for="name">Naziv:</label>
            <input type="text" name="name" value="${product.name}" required />
        </div>
        <div>
            <label for="price">Cena:</label>
            <input type="number" name="price" value="${product.price}" required />
        </div>
        <div>
            <label for="quantity">Količina:</label>
            <input type="number" name="quantity" value="${product.quantity}" required />
        </div>
        <div>
            <button type="submit">Spremi izmene</button>
        </div>
    </form>
</body>
</html>
