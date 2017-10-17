<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <spring:url value="/static/css/main.css" var="mainCss" />
        <spring:url value="/static/css/normalize.css" var="normalizeCss" />
        <link href="${mainCss}" rel="stylesheet" />
        <link href="${normalizeCss}" rel="stylesheet" />


    </head>
    <body>
        <!--[if lt IE 8]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
            <![endif]-->

        <!-- Add your site or application content here -->

        <header>
            <img src="static/img/wiztech-header.jpg" alt="header">
        </header>
        <main>
            <section class="mainScreen">
                <ul class="item6">
                    <li><a href="http://localhost:8085/FuelManagementSystem/products"><i></i>Products</a></li>
                    <li><a href="javascript:void(0);"><i></i>Vendor</a></li>
                    <li><a href="javascript:void(0);"><i></i>Customer</a></li>
                    <li><a href="javascript:void(0);"><i></i>Department</a></li>
                    <li><a href="javascript:void(0);"><i></i>Employee</a></li>
                    <li><a href="javascript:void(0);"><i></i>Nozzle</a></li>
                </ul>
                <ul>
                    <li><a href="javascript:void(0);"><i></i>Sale</a></li>
                    <li><a href="javascript:void(0);"><i></i>Purchase</a></li>
                    <li><a href="http://localhost:8085/FuelManagementSystem/accounts"><i></i>Accounts</a></li>
                    <li><a href="javascript:void(0);"><i></i>Expense</a></li>
                    <li><a href="javascript:void(0);"><i></i>Create Reports</a></li>
                </ul>
                <ul>
                    <li><a href="javascript:void(0);"><i></i>Add Sale</a></li>
                    <li><a href="javascript:void(0);"><i></i>Add Purchase</a></li>
                    <li><a href="javascript:void(0);"><i></i>Add Accounts</a></li>
                    <li><a href="javascript:void(0);"><i></i>P & L Account</a></li>
                    <li><a href="javascript:void(0);"><i></i>Reports</a></li>
                </ul>
            </section>
            <section class="clearfix"></section>
        </main>

        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="/static/js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
        
        <spring:url value="/static/js/vendor/jquery-1.12.0.min.js" var="coreJs" />
        <script src="${coreJs}"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        
        <spring:url value="/static/js/plugins.js" var="plugJs" />
        <spring:url value="/static/js/main.js" var="bootstrapJs" />
        <script src="${bootstrapJs}"></script>
        <script src="${plugJs}"></script>

        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function (b, o, i, l, e, r) {
                b.GoogleAnalyticsObject = l;
                b[l] || (b[l] =
                        function () {
                            (b[l].q = b[l].q || []).push(arguments)
                        });
                b[l].l = +new Date;
                e = o.createElement(i);
                r = o.getElementsByTagName(i)[0];
                e.src = 'https://www.google-analytics.com/analytics.js';
                r.parentNode.insertBefore(e, r)
            }(window, document, 'script', 'ga'));
            ga('create', 'UA-XXXXX-X', 'auto');
            ga('send', 'pageview');
        </script>



        
    </body>
</html>