

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Quiz Page</title>
    </head>
    <body>
        <c:if test="${empty noPermiss}">
            <c:if test="${checkMakeQuiz eq true}">
                 <p class="blue">${sucssessMakeQuiz}</p>
            </c:if>
            <p class="red">${notice}</p>
            <form action="MakeQuizController" method="POST">
                <table class="make-quiz">

                    <tr>
                        <td ><label class="light-blue">Question: </label></td>
                        <td>
                            <textarea pattern="^\S+$"  maxlength="50" class="textarea-question" name="question" required>${question}</textarea>
                        </td>
                    </tr>

                    <c:forEach var="i" begin="0" end="3" step="1" >
                        <tr>
                            <td><label class="light-blue">Option ${i+1}: </label></td>
                            <td>
                                <textarea  maxlength="50" class="textarea-option"  name="answer" pattern="^\S+$" required>${answer[i]}</textarea>
                            </td>
                        </tr>
                    </c:forEach>

                    <tr>

                        <td><label class="light-blue">Answer(s): </label></td>
                        <td>
                            <input type="checkbox" name="trueAnswer" value="0"  ${choice0!=null?'checked':''}/> <label class="light-blue">Option 1</label> 
                            <input type="checkbox" name="trueAnswer" value="1"  ${choice1!=null?'checked':''}/> <label class="light-blue">Option 2</label> 
                            <input type="checkbox" name="trueAnswer" value="2"  ${choice2!=null?'checked':''}/> <label class="light-blue">Option 3</label> 
                            <input type="checkbox" name="trueAnswer" value="3"  ${choice3!=null?'checked':''}/> <label class="light-blue">Option 4</label> 
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" value="Save"/> 
                        </td>
                    </tr>

                </table>
            </form>
            <p id="test" ></p>
        </c:if>
        <c:if test="${noPermiss}">
            <h3>You cannot use this function</h3>
        </c:if>
    </body>

</html>
