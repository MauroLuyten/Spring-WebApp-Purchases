<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <jsp:include page="head.jsp">
            <jsp:param value="Home-Purchases" name="pagetitle" />
        </jsp:include>
    </head>

    <body>
        <div class="container">
            <jsp:include page="header.jsp">
                <jsp:param value="border-bottom" name="homeunderline" />
            </jsp:include>
            <section class="sectionhome">
                <article>
                    <h2>Welcome</h2>
                    <p>Log your Purchases here!</p>
                </article>
                <section>
                    <a href="<c:url value="/purchases/new.htm"/>">Add a purchase</a><a href="<c:url value="/purchases.htm"/>">All purchases</a>
                </section>
            </section>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>