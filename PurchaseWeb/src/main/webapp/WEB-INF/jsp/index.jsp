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
                    <h2><spring:message code="index.title"/></h2>
                    <p><spring:message code="index.message"/></p>
                </article>
                <section>
                    <a href="<c:url value="/purchases/new.htm"/>"><spring:message code="button.addlong"/></a><a href="<c:url value="/purchases.htm"/>"><spring:message code="button.alllong"/></a>
                </section>
            </section>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>