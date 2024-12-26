<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div>
Nema dovolje kolicine proizvoda: ${sale.product.name} na stanju
<div>
<div>
trenutna kolicina ${sale.product.name} iznosi ${product.quantity}
<div>
</body>
</html>