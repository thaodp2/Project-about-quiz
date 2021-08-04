
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .start {
                font: bold 11px Arial;
                text-decoration: none;
                background-color: #EEEEEE;
                color: #333333;
                padding: 5px 6px 5px 6px;
                border-top: 1px solid #CCCCCC;
                border-right: 1px solid #333333;
                border-bottom: 1px solid #333333;
                border-left: 1px solid #CCCCCC;
                margin-left: 20px;
               
            }
        </style>
    </head>
    <body>

        <c:if test="${timeover ne null}">
            <span class="red">${timeover} <br>Your test was rejected!</span>
            </c:if>
            <c:if test="${timeover eq null}">
            <div class="light-blue sz-20" >Your score          
                <c:if  test="${score ge 5 }">
                    <span class="blue">${score} (${percent}%) - Passed</span>
                </c:if>
                <c:if test="${score lt 5 }">
                    <span class="red">${score} (${percent}%) - Not Pass</span>
                </c:if>
            </div>
        </c:if>
        <div class="light-blue sz-20 mg-top-35" >Take another test <a class="start" href="TakeQuizController">Start</a></div>

    </body>



</html>
