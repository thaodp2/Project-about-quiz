
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Take Quiz Page</title>
    </head>
    <body>
        <c:if test="${empty noPermiss}">
            <p class="light-blue sz-20">Welcome <span class="blue">${sessionScope.user.username}</span>  </p>
  <p class="red">${errorTakeQuiz}</p>
            <form action="TakeQuizController" method="get">

                <table border="0">

                    <tr>
                        <td class="labelColor light-blue sz-20">Enter number of questions:</td>
                        <td></td>
                    </tr>
                    <tr>
                        <td> <input  class="txtNumberQuestion" type="text" name="NumberQuestion" /> </td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input name="submitTakeQuiz" class="submit-request" type="submit" value="Start"/></td>
                    </tr>

                </table>
              
            </form>   
        </c:if>
        <c:if test="${noPermiss}">
            <h3>You cannot use this function</h3>
        </c:if>
    </body>
</html>
