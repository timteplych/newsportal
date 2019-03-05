<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath" />
    <c:if test="${not empty adv}">
        <div class='post_section view'>
            <h2><a class='article__title' href='' ></a>${adv.title}</h2>
            <strong>Дата: </strong>
            <span class='article__date'><fmt:formatDate pattern="yyyy-MM-dd" value="${adv.publishedDate}" /></span> |
            <strong>Организация:</strong> <span class='article__author'>${adv.company.title}</span>
            <div class="cleaner"></div>
            <p><div class='article__content view'>${adv.content}</div>
            <div class='cleaner'></div>
            <p><div class='category view'>Категория: <span>${adv.category.title}</span></div>
        </div>
    </c:if>
