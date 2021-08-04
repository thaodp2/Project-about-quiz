<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <link href="css/takeQuiz.css" rel="stylesheet" type="text/css"/>
        <link href="css/manage.css" rel="stylesheet" type="text/css"/>
        <title>Online Quiz</title>
    </head>
    <body>

        <div class="top-box"> </div>
        <div class="container">
            <div class="menu">
                <ul class="flex-box bold">
                    <li><a href="LoginController">Home</a></li>
                    <li><a href="TakeQuizController">Take Quiz</a></li>
                    <li><a href="MakeQuizController">Make Quiz</a></li>
                    <li><a href="ManageQuizController">Manage Quiz</a></li>
                    <c:if test="${not empty sessionScope.user}">
                    <li><a href="LogoutController">Log out</a></li>
                    </c:if>
                </ul>
            </div>
            <div class="content">
                <jsp:include page="${body}" />
            </div>
        </div>
    </body>
</html>
