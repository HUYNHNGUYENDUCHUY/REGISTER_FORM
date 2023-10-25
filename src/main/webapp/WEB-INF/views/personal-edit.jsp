<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/26/2023
  Time: 9:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="<c:url value="/resources/css/PersonalFormRegister1.css" />" rel="stylesheet">
    <%--    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>--%>
    <%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js"></script>--%>
    <%--    <script src="https://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.min.js"></script>--%>
    <%--    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/additional-methods.min.js"></script>--%>
    <%--    <script src="<c:url value="/resources/js/RegisterPersonal.js" />"></script>--%>


</head>
<body>
<div class="fullscreen">
    <div class="container-form-register">
        <div class="header-img-page">
            <img class="img-header" src="${pageContext.request.contextPath}/resources/img/ba-bai-bien-tron-nang-tuyet-dep-o-mien-trung.png" alt="">
        </div>
        <div class="content">
            <span>Visitor Information</span>
        </div>
        <div class="form-register">
            <div class="content-form">

                    <%--                        <span class="error" style="color:red ; display:flex;justify-content: center;">${error}</span>--%>
                    <table class="table-form">
                        <form:form action="update" modelAttribute="personal" method="post">
                        <!-- need to associate this data with personal id -->
                        <form:hidden path="id"/>
                            <c:url value="/personal/delete" var="deleteLink">
                                <c:param name="id" value="${id}"/>
                            </c:url>

                        <tr>
                            <td><label for="first-name">First Name</label></td>
                            <td><form:input path="firstName" id="first-name" class="input-text" /></td>
                        </tr>
                        <tr>
                            <td><label for="last-name">Last Name</label></td>
                            <td><form:input path="lastName"  id="last-name" class="input-text"/></td>
                        </tr>
                        <tr>
                            <td><label for="gender">Gender</label></td>
                            <td>
                                <form:select path="gender" items="${genderOptions}"/>
                            </td>

                        </tr>
                        <tr>
                            <td><label for="phone">Telephone</label></td>
                            <td><form:input path="phone"  name="phone" id="phone" class="input-text"/></td>
                        </tr>
                        <tr>
                            <td><label for="email">Email</label></td>
                            <td><form:input path="email"  name="email" id="email" class="input-text"/></td>
                        </tr>
                        <tr>
                            <td><label for="live">You are in</label></td>
                            <td>
                                <c:set var="count" value="0"/>
                                <c:forEach items="${liveOptions}" var="live">
                                    <c:set var="count" value="${count+1}"/>
                                    <form:radiobutton path="live" name="live" id="live" class="live" value="${live}"  /><span>${live}</span><c:if test="${count == 2}"><br></c:if>

                                </c:forEach>


                            </td>
                        </tr>
                        <tr>

                            <td><label for="hobbies">What are your hobbies</label></td>
                            <td>
                                <c:set var="count" value="0"/>
                                <c:forEach items="${hobbiesOptions}" var="hobbies">
                                    <c:set value="${count+1}" var="count"/>
                                    <form:checkbox path="hobbies"  id="hobbies" class="hobbies" value="${hobbies}" /><span>${hobbies}</span>
                                    <c:if test="${count % 3 == 0}"><br></c:if>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td><label for="description-text">Description</label></td>
                            <td><form:textarea path="description" id="description-text"/></td>
                        </tr>

                        <tr>
                            <td></td>
                            <td>
                                    <button  type="submit" class="button" id="save" >Save</button>
                                </form:form>
                                <form style="display:inline-block;" action="${deleteLink}" method="post">
                                    <button type="submit" class="button" id="delete"   >Delete</button>
                                </form>
                                <form style="display:inline-block;" action="/personal/cancel" method="post">
                                    <button type="submit" class="button" id="cancel"  >Cancel</button>
                                </form>
                            </td>
                        </tr>
                    </table>
            </div>
        </div>
    </div>
</div>


</body>
</html>
