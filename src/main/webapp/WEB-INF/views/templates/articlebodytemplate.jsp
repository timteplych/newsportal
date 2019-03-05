<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<spring:message code="label_date" var="labelDate" />
<spring:message code="label_author" var="labelAuthor" />
<spring:message code="label_category" var="labelCategory" />
<spring:message code="label_button_read" var="labelButtonRead" />



<script>
    var articleBody="<div class='post_section'>"+"<h2><a class='article__title' href='{href}' >{article__title}</a></h2>"+"<strong>${labelDate}: </strong><span class='article__date'>{adv__date}</span>|<strong>${labelAuthor}: </strong><span class='article__author'>{adv__company}</span>"
        +"<p><div class='article__content'>{article__content}</div>"
        +"<div class='cleaner'></div>"
        +"<p><div class='category'>${labelCategory}: <span class='article__category'></span></div> <div class='button float_r'><a href=' ' class='more'>${labelButtonRead}</a></div>"+"<div class='cleaner'></div>"
        +"</div><div class='cleaner_h40'></div>";

    //данные, которые передаются на сервер
    //количество страниц
    var number=5;
    //порядок сортировки
    var order="DESC";
    //поле для сортировки
    var orderBy="id";
    //счетчик страниц(блоков)
    var pageCounter=0;
</script>