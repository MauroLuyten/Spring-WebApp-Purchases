<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="footer">
    <p>Purchases</p>
    <p>Design: mauro.luyten@gmail.com</p>
    <form action="<c:url value="/logout"/>" method="POST" >
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
         <input type="submit" value="Logout">
    </form>
</div>
