<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
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
                    <h1>Edit purchase</h1>

                    <form:form id="form" modelAttribute="purchase" action="${pageContext.request.contextPath}/purchases/edit${purchase.ID}.htm" method="post">

                        <form:errors path="title" cssClass="error" element="p"/>
                        <form:errors path="description" cssClass="error" element="p"/>
                        <form:errors path="price" cssClass="error" element="p"/>
                        <label for="title">Title</label> 
                        <form:input path="title"  id="title" type="text"/>
                        <label for="description">Description</label> 
                        <form:input path="description" id="description" type="text"/>
                        <label for="price">Price</label> 
                        <form:input path="price" id="price" type="number"/>

                    </form:form>

                </article>
                <section>
                    <input form="form" class="formbuttons" type="submit" value="Confirm">
                </section>
            </section>
        </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>