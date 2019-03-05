<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<spring:message code="label_home_page" var="labelHome" />
<spring:message code="label_create_article" var="labelCreate" />
<div id="templatemo_menu">

    <ul>
        <li><a href="${contextPath}">${labelHome}</a></li>
        <li><a href="${contextPath}/adv/add">${labelCreate}</a></li>
    </ul>

    <div><a href="${contextPath}/?lang=en">en</a> </div>
    <div><a href="${contextPath}/?lang=ru">ru</a> </div>

</div> <!-- end of templatemo_menu -->