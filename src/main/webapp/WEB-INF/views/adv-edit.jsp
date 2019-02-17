
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="EDIT ADV"></jsp:param>
</jsp:include>

<h1>EDIT ADV</h1>

<form:form method = "POST" action="/newsportal/adv/save" modelAttribute="adv">
    <p>
    <form:input path="id" type="hidden"/>
    </p>
    <p>
        <div style="...">TITLE</div>
        <form:input path="title"/>
    </p>
    <p>
        <div style="...">CONTENT</div>
        <form:input path="content"/>
    </p>
    <p>
        <button type="submit">SAVE</button>
    </p>
</form:form>