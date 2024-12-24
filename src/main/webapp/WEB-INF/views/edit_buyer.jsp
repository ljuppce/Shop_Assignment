<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
    <title>Izmeni kupca</title>
</head>
<body>
    <h2>Izmeni kupca</h2>

    <form action="${pageContext.request.contextPath}/buyers/update/${buyer.id}" method="post">
        <div>
            <label for="name">Ime:</label>
            <input type="text" name="name" value="${buyer.name}" required />
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" name="email" value="${buyer.email}" required />
        </div>
        <div>
            <button type="submit">Spremi izmene</button>
        </div>
    </form>
</body>
</html>
