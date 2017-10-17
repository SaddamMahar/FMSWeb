<%-- 
    Document   : account
    Created on : Oct 16, 2017, 12:28:53 PM
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

        <spring:url value="static/css/normalize.css" var="normCss" />
        <link href="${normCss}" rel="stylesheet" />
        
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
            <section class="contentSec">
                <h2>Accounts Information</h2>
                <div class="btnHolder">
                    <a href="http://localhost:8085/FuelManagementSystem/index">
                        <i></i>Back to Home Screen
                    </a>
                </div>
                <div class="btnHolder">
                    <a href="http://localhost:8085/FuelManagementSystem/accounts/add">
                        <i></i>Go to Add Account page
                    </a>
                </div>
                <section class="tableContentSec">
                    <table>
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Branch Code</th>
                            <th>Account No</th>
                            <th>Current Balance</th>
                            <th>Openning Balance</th>
                        </tr>



                        </thead>
                        <tbody>

                            <c:if test="${not empty accountList}">
                                <c:forEach var="listValue" items="${accountList}">                                
                                    <tr>
                                        <td>${listValue.name}</td>
                                        <td>${listValue.branchCode}</td>
                                        <td>${listValue.accountNo}</td>
                                        <td>${listValue.currentBalance}</td>
                                        <td>${listValue.openingBalance}</td>
                                        <td>
                                            <a href="http://localhost:8085/FuelManagementSystem/accounts/Edit/${listValue.accountID}">Edit</a>
                                            <a href="http://localhost:8085/FuelManagementSystem/accounts/delete/${listValue.accountID}">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>


                        </tbody>
                    </table>
                </section>

                <div class="btnHolder">
                    <section class="pull-right">
                        <button>
                            <i></i>Add New Account
                        </button>
                    </section>
                    <button type="button" modal-open>
                        <i></i>Ledger
                    </button>
                    <button>
                        <i></i>Full Stock report
                    </button>
                    <button>
                        <i></i>Current stock
                    </button>
                </div>
            </section>
            <section class="clearfix"></section>
        </main>
        <!-- LEDGER MODAL -->
        <section class="modal">
            <section class="modal-content">
                <a modal-close class="closeModal" href="javascript:void(0);">X</a>
                <h2>stock report</h2>
                <section class="stockPopupDetailSec">
                    <p>Report Type: <span>Partial</span></p>
                    <p>Product: <span>Delo 21030</span></p>
                </section>
                <section class="radioHolder">
                    <section class="radioSec">
                        <input name="radioSec" type="radio" id="radio1">
                        <label for="radio1">Daily</label>
                    </section>
                    <section class="radioSec">
                        <input name="radioSec" type="radio" id="radio2">
                        <label for="radio2">To Date</label>
                    </section>
                </section>
                <section class="selectDateSec">
                    <label for="">From</label>
                    <select>
                        <option>32131</option>
                        <option>32131</option>
                        <option>32131</option>
                        <option>32131</option>
                        <option>32131</option>
                    </select>
                </section>
                <section class="selectDateSec">
                    <label for="">To</label>
                    <select>
                        <option>32131</option>
                        <option>32131</option>
                        <option>32131</option>
                        <option>32131</option>
                        <option>32131</option>
                    </select>
                </section>
            </section>
        </section>
        <!-- END LEDGER MODAL -->
        
        

        <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="static/js/vendor/jquery-1.12.0.min.js"><\/script>')</script>
        <script src="static/js/plugins.js"></script>
        
        <spring:url value="/static/js/vendor/jquery-1.12.0.min.js" var="jqJs" />
        <link src="${jqJs}" />
        
        <spring:url value="/static/js/plugins.js" var="pJs" />
        <link src="${pJs}" />
        
        <spring:url value="/static/js/main.js" var="mJs" />
        <link src="${mJs}" />
        
        <script>
            $(document).ready(function () {
                $('[modal-open]').click(function () {
                   $('body').addClass('modal-open');
                });
                $('[modal-close]').click(function () {
                   $('body').removeClass('modal-open');
                });
            })
        </script>
        <!-- Google Analytics: change UA-XXXXX-X to be your site's ID. -->
        <script>
            (function(b,o,i,l,e,r){b.GoogleAnalyticsObject=l;b[l]||(b[l]=
            function(){(b[l].q=b[l].q||[]).push(arguments)});b[l].l=+new Date;
            e=o.createElement(i);r=o.getElementsByTagName(i)[0];
            e.src='https://www.google-analytics.com/analytics.js';
            r.parentNode.insertBefore(e,r)}(window,document,'script','ga'));
            ga('create','UA-XXXXX-X','auto');ga('send','pageview');
        </script>
    </body>
</html>
