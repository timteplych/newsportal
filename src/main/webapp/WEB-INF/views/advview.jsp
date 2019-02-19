<%@page import="ru.ttv.newsportal.model.Adv" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath}" var="contextPath" />
<c:set value="${contextPath}/resources" var="resPath" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <script   src="https://code.jquery.com/jquery-3.1.1.min.js"   integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="   crossorigin="anonymous"></script>
        <link href="${resPath}/style.css" rel="stylesheet" type="text/css" />
        <title>News portal</title>
    </head>
    <body>
    <div id="templatemo_header_wrapper">
        <div id="templatemo_header">

            <div id="site_title">

            </div>

            <div id="templatemo_rss">
                <a href="" target="_parent">SUBSCRIBE<br /><span>OUR FEED</span></a>
            </div>

        </div> <!-- end of header -->

        <div id="templatemo_menu">

            <ul>
                <li><a href="${contextPath}">Главная</a></li>
                <li><a href="${contextPath}/articles/add">Создать объявление</a></li>
            </ul>

        </div> <!-- end of templatemo_menu -->

    </div> <!-- end of header wrapper -->
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
    </body>
</html>
