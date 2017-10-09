<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<header>
	<h1>Purchases</h1>
	<div class="shadebehindlinks"></div>
	<nav>
		<ul>
			<li class="${param.homeunderline}"><a
				href="<c:url value="/index.htm"/>"><spring:message code="nav.home"/></a></li>
                        <li class="${param.addunderline}"><a
				href="<c:url value="/purchases/new.htm"/>"><spring:message code="nav.add"/></a></li>
                        <li class="${param.allitemsunderline}"><a
				href="<c:url value="/purchases.htm"/>"><spring:message code="nav.all"/></a></li>
                        <li class="${param.registerunderline}"><a
				href="<c:url value="/purchases/register.htm"/>"><spring:message code="nav.register"/></a></li>
			
		</ul>
	</nav>
</header>