<%-- 
    Document   : allpurchases
    Created on : Feb 26, 2017, 4:21:28 PM
    Author     : Mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="nl">

    <head>
        <jsp:include page="head.jsp">
            <jsp:param value="All Items-Purchases" name="pagetitle" />
        </jsp:include>
    </head>

    <body>
        <div class="container">
            <jsp:include page="header.jsp">
                <jsp:param value="border-bottom" name="allitemsunderline" />
            </jsp:include>
            <section class="sectionhome" id="itemstable">
                <article class="allitems">
                    <h2>All Items</h2>
                    <table>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="purchase" items="${purchases}">
                            <tr>
                                <td>${purchase.ID}</td>
                                <td>${purchase.title}</td>
                                <td>${purchase.description}</td>
                                <td>€${purchase.price}</td>
                                <td><a href="<c:url value="/purchases/${purchase.ID}.htm"/>">edit</a>
                                <td><a href="<c:url value="/purchases/delete/${purchase.ID}.htm"/>">delete</a>
                            </tr>
                        </c:forEach>
                    </table>

                </article>
                <section>
                    <a href="<c:url value="/purchases/new.htm"/>">New Purchase</a>
                </section>
            </section>

        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>

</html>
