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
    <div id="templatemo_main_wrapper">
        <div id="templatemo_content_wrapper">
            <h2 class="category_name">${advCategory.title}</h2>
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

            <div id="templatemo_sidebar_one">

                <h4>Категории</h4>
                <ul class="templatemo_list">
                    <c:if test="${not empty advCategories}">
                        <c:forEach items="${advCategories}"  var="category" >
                            <li>
                                <a class="category_reff" href="${contextPath}/categories/${category.id}">${category.title}</a>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>

                <div class="cleaner_h40"></div>
            </div>

            <%--<div id="templatemo_sidebar_two">--%>

            <%--<div class="banner_250x200">--%>
            <%--<a href="" target="_parent"><img src="${resPath}/images/250x200_banner.jpg" alt="templates" /></a>--%>
            <%--</div>--%>

            <%--<div class="banner_125x125">--%>
            <%--<a href="" target="_parent"><img src="${resPath}/images/templatemo_ads.jpg" alt="web 1" /></a>--%>
            <%--<a href="" target="_parent"><img src="${resPath}/images/templatemo_ads.jpg" alt="web 2" /></a>--%>
            <%--<a href="" target="_parent"><img src="${resPath}/images/templatemo_ads.jpg" alt="templates 2" /></a>--%>
            <%--<a href="" target="_parent"><img src="${resPath}/images/templatemo_ads.jpg" alt="templates 1" /></a>--%>
            <%--</div>--%>

            <%--<div class="cleaner_h40"></div>--%>

            <%--</div>--%>

            <div class="cleaner"></div>
        </div>
    </div>
</body>
</html>
