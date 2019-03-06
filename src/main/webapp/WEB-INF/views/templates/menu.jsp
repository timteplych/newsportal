<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />

<spring:message code="label_home_page" var="labelHome" />
<spring:message code="label_create_article" var="labelCreate" />
<spring:message code="label_button_reg" var="labelReg" />
<spring:message code="label_button_login" var="labelLogin" />
<div id="templatemo_menu">

    <ul id="panel_reff">
        <li><a href="${contextPath}">${labelHome}</a></li>
        <sec:authorize access="isAuthenticated()">
        <li><a href="${contextPath}/adv/add">${labelCreate}</a></li>
        </sec:authorize>
        <sec:authorize access="isAnonymous()">
        <li><a href="${contextPath}/registration">${labelReg}</a></li>
        </sec:authorize>
    </ul>
    <ul id="panel_acc">
        <sec:authorize access="isAnonymous()">
            <li><a href="${contextPath}/login">${labelLogin}</a></li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <li><a id="quit" href="${contextPath}/logout">Выйти</a><span id="username">${pageContext.request.userPrincipal.name}|</span></li>
        </sec:authorize>
    </ul>


    <div><a href="${contextPath}/?lang=en">en</a> </div>
    <div><a href="${contextPath}/?lang=ru">ru</a> </div>

</div> <!-- end of templatemo_menu -->