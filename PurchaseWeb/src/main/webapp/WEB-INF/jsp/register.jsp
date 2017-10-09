<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">

    <jsp:include page="head.jsp">
        <jsp:param value="Login-Purchases" name="pagetitle" />
    </jsp:include>

    <body>
        <div class="container">
            <jsp:include page="header.jsp">
                <jsp:param value="border-bottom" name="registerunderline" />
            </jsp:include>
            <section class="sectionhome" id="formsection">
                <article>
                    <h1><spring:message code="register.title"/></h1>

                    <form:form id="form" modelAttribute="user" action="${pageContext.request.contextPath}/purchases/register.htm" method="post">

                        <form:errors path="userid" cssClass="error" element="p"/>
                        <form:errors path="password" cssClass="error" element="p"/>
                        <form:errors path="email" cssClass="error" element="p"/>
                        <form:errors path="firstName" cssClass="error" element="p"/>
                        <form:errors path="lastName" cssClass="error" element="p"/>
                        
                        <label for="userid"><spring:message code="register.username"/></label> 
                        <form:input path="userid"  id="userid" type="text"/>
                        <label for="password"><spring:message code="register.password"/></label> 
                        <form:input path="password" id="password" type="password"/>
                        <label for="email"><spring:message code="register.email"/></label> 
                        <form:input path="email" id="email" type="email"/>
                        <label for="firstname"><spring:message code="register.firstname"/></label> 
                        <form:input path="firstName" id="firstname" type="text"/>
                        <label for="lastname"><spring:message code="register.lastname"/></label> 
                        <form:input path="lastName" id="lastname" type="text"/>

                    </form:form>

                </article>
                <section>
                    <input form="form" class="formbuttons" type="submit" value="<spring:message code="button.register"/>">
                    
                </section>
            </section>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>