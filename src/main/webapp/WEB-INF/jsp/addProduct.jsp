<%-- 
    Document   : addProduct
    Created on : Oct 13, 2017, 7:46:34 PM
    Author     : Saddam
--%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty product}">
                <form action ="http://localhost:8085/FuelManagementSystem/products/update" method="POST">
                    <input type="text" name="name" value="${product.name}"><br/>  
                    <input type="text" name="type" value="${product.type}"><br/>  
                    <input type="number" name="price" value="${product.price}"><br/>  
                    <input type="number" name="saleRate" value="${product.saleRate}"><br/>  
                    <input type="number" name="opening" value="${product.opening}"><br/>  
                    <input type="text" name="meterDate" value="${product.meterDate}"><br/>  
                    <input type="number" name="openingPrice" value="${product.openingPrice}"><br/>  
                    <input type="hidden" name="id" value="${product.productID}"><br/>  
                    <input type="submit" value="submit">
                </form>
                <br />
            </c:when>    
            <c:otherwise>
                <form action ="http://localhost:8085/FuelManagementSystem/products/add" method="POST">
                    <input type="text" name="name"><br/>  
                    <input type="text" name="type"><br/>  
                    <input type="number" name="price"><br/>  
                    <input type="number" name="saleRate"><br/>  
                    <input type="number" name="opening"><br/>  
                    <input type="text" name="meterDate"><br/>  
                    <input type="number" name="openingPrice"><br/>  
                    <input type="submit" value="submit">
                </form>
                <br />
            </c:otherwise>
        </c:choose>

    </body>
</html>
