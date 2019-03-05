<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<spring:message code="label_categories" var="labelCategories" />

<div id="templatemo_sidebar_one">

    <h4>${labelCategories}</h4>
    <ul class="templatemo_list">
        <c:if test="${not empty categories}">
            <c:forEach items="${categories}"  var="category" >
                <li>
                    <a class="category_reff" href="./categories/${category.id}">${category.title}</a>
                </li>
            </c:forEach>
        </c:if>
    </ul>

    <div class="cleaner_h40"></div>
</div>