<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2 class="category_name">${advCategory.title}</h2>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath" />
<div id="templatemo_content">
    <c:if test="${not empty advs}">
        <c:forEach items="${advs}"  var="adv" >
            <div class='post_section'>
                <h2><a class='article__title' href='${contextPath}/adv/${adv.id}' >${adv.title}</a></h2>
                <strong>Дата: ${adv.publishedDate}</strong><span class='article__date'></span>|<strong>Автор: </strong><span class='article__author'>${adv.company.title}</span>"
                <p><div class='article__content'>${adv.content}</div>
                <div class='cleaner'></div>
                <p><div class='category'>Категория: <span class='article__category'>${adv.category.title}</span></div> <div class='button float_r'><a href=' ' class='more'>Читать далее</a></div><div class='cleaner'></div>
            </div>
            <div class='cleaner_h40'></div>
        </c:forEach>
    </c:if>
</div>