
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:message code="label_author_reg" var="authorReg" />
<spring:message code="label_login" var="labelLogin" />
<spring:message code="label_password" var="labelPass" />
<spring:message code="label_email" var="labelCompanyEmail" />
<spring:message code="label_company_title" var="labelCompanyTitle" />
<spring:message code="label_company_address" var="labelAddress" />
<spring:message code="label_button_reg" var="labelBreg" />
<spring:message code="label_company_description" var="labelCompanyDescription" />
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<section class="container">
    <div class="login">
        <h1>${authorReg}</h1>
        <c:if test="${not empty message}">
            <span class="error">${message}</span>
            <p/>
        </c:if>
        <form:form modelAttribute="company" action="${contextPath}/registration" method='POST'>

            <p>${labelCompanyTitle}: <form:input  path="title"  value="" placeholder="${labelCompanyTitle}" /></p>
            <form:errors path="title" cssClass="error" />

            <p>${labelAddress}: <form:input  path="address"  value="" placeholder="${labelAddress}" /></p>
            <form:errors path="address" cssClass="error" />

            <p>${labelCompanyDescription}: <form:input  path="description"  value="" placeholder="${labelCompanyDescription}" /></p>
            <form:errors path="description" cssClass="error" />

            <%--<p>${labelCompanyEmail}: <form:input  path="email"  value="" placeholder="${labelCompanyEmail}" /></p>--%>
            <%--<form:errors path="email" cssClass="error" />--%>

            <p>${labelLogin}: <form:input path="login"  type="text"  placeholder="${labelLogin}" /></p>
            <form:errors path="login" cssClass="error" />

            <p>${labelPass}: <form:input path="password" type="password" placeholder="${labelPass}" /></p>
            <form:errors path="password" cssClass="error" />

            <p class="submit"><input type="submit" name="commit" value="${labelBreg}" /></p>
        </form:form>
    </div>
</section>
