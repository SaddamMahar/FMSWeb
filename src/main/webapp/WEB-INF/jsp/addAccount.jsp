<%-- 
    Document   : adaccount
    Created on : Oct 16, 2017, 12:12:46 PM
    Author     : Saddam
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js" lang="">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title></title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <!-- Place favicon.ico in the root directory -->

        <spring:url value="http://localhost:8085/FuelManagementSystem/static/css/normalize.css" var="normCss" />
        <link href="${normCss}" rel="stylesheet" />

        <spring:url value="http://localhost:8085/FuelManagementSystem//static/css/main.css" var="mainCss" />
        <spring:url value="http://localhost:8085/FuelManagementSystem//static/css/normalize.css" var="normalizeCss" />
        <link href="${mainCss}" rel="stylesheet" />
        <link href="${normalizeCss}" rel="stylesheet" />

    </head>
    <body>
        <header>
            <img src="http://localhost:8085/FuelManagementSystem/static/img/wiztech-header.jpg" alt="header">
        </header>
        <main>
            <section class="contentSec">
                <h2>new Account</h2>
                <div class="btnHolder">
                    <a href="http://localhost:8085/FuelManagementSystem/index">
                        <i></i>Back to Home Screen
                    </a>
                </div>


                <section class="tableContentSec">




                    <c:choose>
                        <c:when test="${not empty account}">
                            <form action ="http://localhost:8085/FuelManagementSystem/accounts/update" method="POST">
                                <input type="text" name="name" value="${account.name}" > <br/> 
                                <input type="text" name="branchCode" value="${account.branchCode}" ><br/>
                                <input type="text" name="accountNo" value="${account.accountNo}"><br/>
                                <input type="number" name="openingBalance" value="${account.openingBalance}"><br/>
                                <input type="number" name="currentBalance" value="${account.currentBalance}"><br/>
                                <input type="hidden" name="accountID" value="${account.accountID}"><br/>
                                <input type="submit" value="submit">
                            </form>
                            <br />
                        </c:when>    
                        <c:otherwise>
                            <form action ="http://localhost:8085/FuelManagementSystem/accounts/add" method="POST">
                                <input type="text" name="name"><br/>
                                <input type="text" name="branchCode"><br/>
                                <input type="text" name="accountNo"><br/>
                                <input type="number" name="openingBalance"><br/>
                                <input type="number" name="currentBalance"><br/>
                                <input type="submit" value="submit">
                            </form>
                            <br />
                        </c:otherwise>
                    </c:choose>
                </section>

            </section>
            <section class="clearfix"></section>
        </main>
    </body>
</html>
