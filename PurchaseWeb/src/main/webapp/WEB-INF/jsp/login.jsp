<%-- 
    Document   : login.jsp
    Created on : May 5, 2017, 9:40:23 PM
    Author     : Mauro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="nl">

    <jsp:include page="head.jsp">
        <jsp:param value="Login-Purchases" name="pagetitle" />
    </jsp:include>

    <body>
        <div class="container">
            <jsp:include page="header.jsp">
                <jsp:param value="" name="addunderline" />
            </jsp:include>
            <section class="sectionhome" id="formsection">
                <article>
                    <h1><spring:message code="login.title"/></h1>
                   
                        <!--<p>${sessionscope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>-->
                        <p class="error">${error}</p>
                    
                    <p><spring:message code="login.message"/></p>
                    <form id="form" action="${pageContext.request.contextPath}/processLogin" method="post" novalidate="novalidate">
                        <label for="username"><spring:message code="login.username"/></label> 
                        <input id="username" name="username" type="text"/>
                        <label for="password"><spring:message code="login.password"/></label> 
                        <input  id="password" name="password" type="password"/>
                        
                        <input  name="${_csrf.parameterName}" type="hidden" value="${_csrf.token}" />

                    </form>
                </article>
                <section>
                    <input form="form" class="formbuttons" type="submit" value="<spring:message code="button.login"/>">
                </section>
            </section>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>