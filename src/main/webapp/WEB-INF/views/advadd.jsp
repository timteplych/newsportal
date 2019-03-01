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
        <form:form modelAttribute="adv" class="add_article_form" method="POST" action="${contextPath}/adv/save">
            <h2 class="message">Создание статьи</h2>
            <strong class="add_category">Категория*</strong>
            <select id="categoryId" name="categoryId" class="cd-select">
                <c:if test="${not empty categories}">
                    <option value="0" selected>Выберите категорию</option>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.id}">${category.title}</option>
                    </c:forEach>
                </c:if>
            </select>
            <p><form:label path="title" class="add_title">Заголовок*</form:label><form:input type="text" path="title" class="add_title_input"  />
            <p style="padding-top:50px;">
                    <form:textarea path="content" id="content"  class="contentarea"></form:textarea>

            <div class="author_add">
                <span class="author_info_title">Данные автора*</span>
                <form:input path="company.title"  type="text" placeholder="Название компании" class="add_author_firstname" />
                <form:input path="company.address" type="text" placeholder="Адрес" name="add_author_lastname" />
                <form:input path="company.description" type="text" placeholder="Описание" name="add_author_lastname" />
            </div>

            <input type="submit"  class="button_sub" value="Опубликовать" />
        </form:form>

    </body>
</html>