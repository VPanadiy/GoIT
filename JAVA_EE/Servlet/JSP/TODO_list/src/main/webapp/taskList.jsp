<%@ page import="dream.development.Task" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--<%@ page errorPage="error.jsp" %>--%>

<html>
<head>
    <title>Task List</title>
    <style>
        <%@ include file="css/style.css"%>
    </style>
</head>
<body>
<h2>Current time is: ${sessionScope.get("time")}</h2>
<h2>Click Counter = ${sessionScope.get("counter")}</h2>
<h1>TODO List: ${sessionScope.get("firstName")} ${sessionScope.get("lastName")}</h1>

<jsp:useBean id="list" class="java.util.ArrayList" scope="session">
    <%
        list = (ArrayList<Task>) request.getAttribute("taskList");
    %>
</jsp:useBean>

<form action="/taskList" method="POST">
    <label for="taskName">Task Name:</label><input type="text" id="taskName" name="taskName" placeholder="Task Name"><br>
    <label for="taskDescription">Task Description:</label><textarea id="taskDescription" name="taskDescription" placeholder="Task Description" rows="5"></textarea><br>
    <label></label><input id="taskSubmit" type="submit" value="Add">
</form>

<table width="100%">
    <tr>
        <th width="5%">Id</th>
        <th width="20%">Name</th>
        <th width="55%">Description</th>
        <th width="8%">Status</th>
        <th colspan="2" width="12%">Actions</th>
    </tr>

    <c:if test="${!empty taskList && fn:length(taskList) gt 0}">
        <c:forEach items="${taskList}" var="tasks" varStatus="loop">
            <c:if test="${tasks.delete == false}">
                <tr>
                    <td><c:out value="${tasks.id}"/></td>
                    <td><c:out value="${tasks.taskName}"/></td>
                    <td><c:out value="${tasks.taskDescription}"/></td>
                    <td><c:out value="${tasks.status}"/></td>
                    <form action="/taskList" method="POST">
                        <td><input type="text" name="isDone" value="${tasks.id}" style="display: none"/>
                            <c:choose>
                                <c:when test="${tasks.status == false}">
                                    <input id="completeButtonDone" type="submit" value="Done" name="completeButton ${tasks.id}">
                                </c:when>
                                <c:otherwise>
                                    <input id="completeButtonUnDone" type="submit" value="unDone" name="completeButton ${tasks.id}">
                                </c:otherwise>
                            </c:choose>
                        </td>
                    </form>
                    <form action="/taskList" method="POST">
                        <td><input type="text" name="indexForRemove" value="${tasks.id}" style="display: none"/>
                            <input id="deleteButtonSubmit" type="submit" value="Delete" name="deleteButton ${tasks.id}"/></td>
                    </form>
                </tr>
            </c:if>
        </c:forEach>
    </c:if>
</table>

<h1>Deleted List</h1>

<table width="100%">
    <tr>
        <th width="5%">Id</th>
        <th width="20%">Name</th>
        <th width="55%">Description</th>
        <th width="10%">Status</th>
        <th width="10%">Delete</th>
    </tr>

    <c:if test="${!empty taskList && fn:length(taskList) gt 0}">
        <c:forEach items="${taskList}" var="tasks">
            <c:if test="${tasks.delete == true}">
                <tr>
                    <td><c:out value="${tasks.id}"/></td>
                    <td><c:out value="${tasks.taskName}"/></td>
                    <td><c:out value="${tasks.taskDescription}"/></td>
                    <td><c:out value="${tasks.status}"/></td>
                    <td><c:out value="${tasks.delete}"/></td>
                </tr>
            </c:if>
        </c:forEach>
    </c:if>
</table>

</body>
</html>
