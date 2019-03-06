<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:message code="label_button_login" var="labelButtonLogin" />
<spring:message code="label_login" var="labelLogin" />
<spring:message code="label_password" var="labelPassword" />
<spring:message code="label_authorization" var="labelAuth" />
<section class="container">
    <div class="login">
        <h1>${labelAuth}</h1>
        <form method="post"  action="<c:url value='/login' />" method='POST'>
            <c:if test="${not empty message}">
                <span class="error">${message}</span>
            </c:if>
            <p><input type="text" name="login" value="" placeholder="${labelLogin}"></p>
            <p><input type="password" name="password" value="" placeholder="${labelPassword}"></p>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p class="submit"><input type="submit" name="commit" value="${labelButtonLogin}"></p>
        </form>
    </div>
</section>