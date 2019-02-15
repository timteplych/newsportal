<%@page import="ru.ttv.newsportal.model.Adv" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="ADVS"></jsp:param>
</jsp:include>

    <h1>Adv management</h1>
    <table width="100%" cellspacing="10" cellpadding="10" border="1" style="...">
        <tr>
            <th colspan="7" align="center">Advs</th>
        </tr>
        <tr>
            <th width="60" nowrap="nowrap" align="center">№</th>
            <th width="200" nowrap="nowrap" align="left">ID</th>
            <th width="300" nowrap="nowrap" align="left">Title</th>
            <th width="100%" align="left">Content</th>
            <th width="80" nowrap="nowrap" align="center">EDIT</th>
            <th width="80" nowrap="nowrap" align="center">REMOVE</th>
        </tr>
        <c:forEach var="adv" items="${advList}" varStatus = "status">
            <tr>
                <td align="center" nowrap="nowrap">${status.index + 1}</td>
                <td align="left">${adv.id}</td>
                <td align="left">${adv.title}</td>
                <td align="left">${adv.content}</td>
                <td align="center" nowrap="nowrap">
                    <a href="/newsportal/adv/edit/${adv.id}">EDIT</a>
                </td>
                <td align="center" nowrap="nowrap">
                    <a href="/newsportal/adv/delete/${adv.id}">REMOVE</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/newsportal/adv/add">
        <input type="submit" value="Add new Adv">
    </form>
</html>
