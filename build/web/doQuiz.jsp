
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/takeQuiz.js"></script>
    </head>
    <body>
        <div class="light-blue sz-20">Welcome <span class="blue">${sessionScope.user.username}</span>  </div>
        <input type="hidden" id="time" value="${time}"/>
        <input type="hidden" id="realtime" value="${realtime}"/>
        <div class="light-blue sz-20 time-couter">Time remaining 
            <span class="red" id="showTime" ></span>  
        </div>

        <c:if test="${not empty quesList}">
            <form class="mg-top-35" action="TakeQuizController" method="post" id="doquiz">

                <c:forEach var="quest" items="${quesList}">
                    <div class="question" hidden="true"> 

                        <input type="hidden" name="quenstionId" value="${quest.id }" />

                        <div class="light-blue" >${quest.question }</div>

                        <c:forEach var="answer" items="${quest.answerList }">

                            <input type="checkbox" 
                                   name="answer-for-${quest.id }" 
                                   value="${answer.id }" />
                            <label for="answer-${answer.id }" class="light-blue">${answer.answer }</label>
                            <br>
                        </c:forEach>

                    </div>
                </c:forEach>
               
                <input class="btn-submit" type="button" id="buttonNext" value="Next" onclick="next();" />
                
            </form>
        </c:if>
        <script src="js/takeQuiz.js" type="text/javascript">
        </script>
    </body>

</html>

