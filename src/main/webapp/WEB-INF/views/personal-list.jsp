<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/26/2023
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="<c:url value="/resources/css/PersonalList1.css"/>" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>
</head>
<body>
    <div class="fullscreen">
        <div class="container-form-register">
            <div class="header-img-page">
                <img  class="img-header" src="${pageContext.request.contextPath}/resources/img/ba-bai-bien-tron-nang-tuyet-dep-o-mien-trung.png" alt="">
            </div>
            <div class="content">
                <p> Search Visitor</p>
                <br>
                <form method="post" action="${pageContext.request.contextPath}/personal/search">
                <label for="search-firstName">First Name :</label>
                <input type="text" name="firstName" class="input-name" id="search-firstName" autocomplete="off" >
                <button type="submit" class="button-search"> Search </button>
                </form>
            </div>
            <div class="form-search">
                <div class=" list-personal">
                    <table class="table-list-personal">
                        <tr>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Gender</th>
                            <th>Telephone</th>
                            <th>You're in</th>
                            <th>Hobbies</th>
                            <th>Description</th>
                        </tr>
                        <c:forEach items="${personals}" var="listPersonal">
                            <c:url value="${pageContext.request.contextPath}/personal/update" var="editLink">
                                <c:param name="id" value="${listPersonal.id}"/>
                            </c:url>
                            <tr>
                                <td><a href="${editLink}">${listPersonal.firstName}</a></td>
                                <td><a href="${editLink}">${listPersonal.lastName}</a</td>
                                <td><a href="${editLink}">${listPersonal.gender}</a</td>
                                <td><a href="${editLink}">${listPersonal.phone}</a</td>
                                <td><a href="${editLink}">${listPersonal.live}</a</td>
                                <td><a href="${editLink}">${listPersonal.hobbies}</a</td>
                                <td><a href="${editLink}">${listPersonal.description}</a</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
