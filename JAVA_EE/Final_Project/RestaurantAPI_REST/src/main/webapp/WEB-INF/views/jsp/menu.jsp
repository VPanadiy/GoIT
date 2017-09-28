<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 14.08.2017
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

<%--<table id="menu">--%>
<%--<tr>--%>
<%--<td id="tdMenu1">--%>
<%--<table id="menuTable1">--%>
<%--<c:forEach items="${menu}" var="menu">--%>
<%--<c:if test="${menu.id%2 != 0}">--%>
<%--<tr>--%>
<%--<th colspan="3">${menu.name}</th>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th>Name</th>--%>
<%--<th>Weight</th>--%>
<%--<th>Cost</th>--%>
<%--</tr>--%>
<%--<c:forEach items="${dishes}" var="dish">--%>
<%--<tr>--%>
<%--<c:if test="${menu.id == dish.menu.id}">--%>
<%--<td><a href="/dish/${dish.name}">${dish.name}</a></td>--%>
<%--<td>${dish.weight}</td>--%>
<%--<td>${dish.cost}</td>--%>
<%--</c:if>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</c:if>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</td>--%>
<%--<td id="tdMenu2">--%>
<%--<table id="menuTable2">--%>
<%--<c:forEach items="${menu}" var="menu">--%>
<%--<c:if test="${menu.id%2 == 0}">--%>
<%--<tr>--%>
<%--<th colspan="3">${menu.name}</th>--%>
<%--</tr>--%>
<%--<tr>--%>
<%--<th>Name</th>--%>
<%--<th>Weight</th>--%>
<%--<th>Cost</th>--%>
<%--</tr>--%>
<%--<c:forEach items="${dishes}" var="dish">--%>
<%--<tr>--%>
<%--<c:if test="${menu.id == dish.menu.id}">--%>
<%--<td><a href="/dish/${dish.name}">${dish.name}</a></td>--%>
<%--<td>${dish.weight}</td>--%>
<%--<td>${dish.cost}</td>--%>
<%--</c:if>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</c:if>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</td>--%>
<%--</tr>--%>
<%--</table>--%>

<h1>Menu</h1>

<table id="menu">

    <tr id="trMenuTable1">
        <td id="tdMenuTable0">
            <table id="menuTable0">
                <tr>
                    <c:set var="menu0" value="${menu[0]}"/>
                    <th colspan="3"><c:out value="${menu0.name}"/></th>
                </tr>

                <tr>
                    <th>Name</th>
                    <th>Weight</th>
                    <th>Cost</th>
                </tr>

                <c:forEach items="${dishes}" var="dish">
                    <c:if test="${menu0.id == dish.menu.id}">
                        <tr>
                            <td id="tdDishName0"><a href="/dish/${dish.name}">${dish.name}</a></td>
                            <td>${dish.weight}</td>
                            <td>${dish.cost}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </td>
        <td id="tdMenuTable1">
            <table id="menuTable1">
                <tr>
                    <c:set var="menu1" value="${menu[1]}"/>
                    <th colspan="3"><c:out value="${menu1.name}"/></th>
                </tr>

                <tr>
                    <th>Name</th>
                    <th>Weight</th>
                    <th>Cost</th>
                </tr>

                <c:forEach items="${dishes}" var="dish">
                    <c:if test="${menu1.id == dish.menu.id}">
                        <tr>
                            <td id="tdDishName1"><a href="/dish/${dish.name}">${dish.name}</a></td>
                            <td>${dish.weight}</td>
                            <td>${dish.cost}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </td>
    </tr>

    <tr id="trMenuTable2">
        <td id="tdMenuTable2">
            <table id="menuTable2">
                <tr>
                    <c:set var="menu2" value="${menu[2]}"/>
                    <th colspan="3"><c:out value="${menu2.name}"/></th>
                </tr>

                <tr>
                    <th>Name</th>
                    <th>Weight</th>
                    <th>Cost</th>
                </tr>

                <c:forEach items="${dishes}" var="dish">
                    <c:if test="${menu2.id == dish.menu.id}">
                        <tr>
                            <td id="tdDishName2"><a href="/dish/${dish.name}">${dish.name}</a></td>
                            <td>${dish.weight}</td>
                            <td>${dish.cost}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </td>
        <td id="tdMenuTable3">
            <table id="menuTable3">
                <tr>
                    <c:set var="menu3" value="${menu[3]}"/>
                    <th colspan="3"><c:out value="${menu3.name}"/></th>
                </tr>

                <tr>
                    <th>Name</th>
                    <th>Weight</th>
                    <th>Cost</th>
                </tr>

                <c:forEach items="${dishes}" var="dish">
                    <c:if test="${menu3.id == dish.menu.id}">
                        <tr>
                            <td id="tdDishName3"><a href="/dish/${dish.name}">${dish.name}</a></td>
                            <td>${dish.weight}</td>
                            <td>${dish.cost}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </td>
    </tr>

    <tr id="trMenuTable3">
        <td id="tdMenuTable4">
            <table id="menuTable4">
                <tr>
                    <c:set var="menu4" value="${menu[4]}"/>
                    <th colspan="3"><c:out value="${menu4.name}"/></th>
                </tr>

                <tr>
                    <th>Name</th>
                    <th>Weight</th>
                    <th>Cost</th>
                </tr>

                <c:forEach items="${dishes}" var="dish">
                    <c:if test="${menu4.id == dish.menu.id}">
                        <tr>
                            <td id="tdDishName4"><a href="/dish/${dish.name}">${dish.name}</a></td>
                            <td>${dish.weight}</td>
                            <td>${dish.cost}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </td>
        <td id="tdMenuTable5">
            <table id="menuTable5">
                <tr>
                    <c:set var="menu5" value="${menu[5]}"/>
                    <th colspan="3"><c:out value="${menu5.name}"/></th>
                </tr>

                <tr>
                    <th>Name</th>
                    <th>Weight</th>
                    <th>Cost</th>
                </tr>

                <c:forEach items="${dishes}" var="dish">
                    <c:if test="${menu5.id == dish.menu.id}">
                        <tr>
                            <td id="tdDishName5"><a href="/dish/${dish.name}">${dish.name}</a></td>
                            <td>${dish.weight}</td>
                            <td>${dish.cost}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </td>
    </tr>

</table>

</body>
</html>
