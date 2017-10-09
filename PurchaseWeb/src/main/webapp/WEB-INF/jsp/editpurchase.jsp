<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="nl">

    <jsp:include page="head.jsp">
        <jsp:param value="Edit-Purchases" name="pagetitle" />
    </jsp:include>

    <body>
        <div class="container">
            <jsp:include page="header.jsp">
                <jsp:param value="border-bottom" name="allitemsunderline" />
            </jsp:include>
            <section class="sectionhome" id="formsection">
                <article>
                    <h1><spring:message code="edit.title"/></h1>

                    <form:form id="form" modelAttribute="purchase" action="${pageContext.request.contextPath}/purchases/edit${purchase.ID}.htm" method="post" novalidate="novalidate">

                        <form:errors path="title" cssClass="error" element="p"/>
                        <form:errors path="description" cssClass="error" element="p"/>
                        <form:errors path="price" cssClass="error" element="p"/>
                        <label for="title"><spring:message code="label.title"/></label> 
                        <form:input path="title"  id="title" type="text"/>
                        <label for="description"><spring:message code="label.description"/></label> 
                        <form:input path="description" id="description" type="text"/>
                        <label for="price"><spring:message code="label.price"/></label> 
                        <form:input path="price" id="price" type="number" novalidate="novalidate"/>
                        <form:input path="imageurl" id="imageurl" type="text" hidden="hidden"/>

                    </form:form>

                </article>
                <section>
                    <input form="form" class="formbuttons" type="submit" value="<spring:message code="submit.confirm"/>">
                </section>
            </section>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>