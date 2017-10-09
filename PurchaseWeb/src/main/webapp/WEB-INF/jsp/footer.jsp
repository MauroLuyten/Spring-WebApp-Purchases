<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="footer">
    <p><spring:message code="footer.title"/></p>
    <p>Design: mauro.luyten@gmail.com</p>
    <form action="<c:url value="/processLogout"/>" method="POST" >
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
         <input type="submit" value="Logout">
    </form>
         <a href="?lang=en"><spring:message code="lang.en"/></a>
         <a href="?lang=nl"><spring:message code="lang.nl"/></a>
</div>
