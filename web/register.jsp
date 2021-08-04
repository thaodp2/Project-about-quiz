

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <title>JSP Page</title>
    </head>
    <body>
        <h3 class="dark-blue">Registration Form</h3>
        <c:if test="${ empty errorRegister}" >
            <c:if test="${status != null}">
                <a style="color: red;">${status}</a>
            </c:if> 
            <form action="RegisterController" method="post">
                <table border="0">

                    <tr>
                        <td class="light-blue">User Name:</td>
                        <td><input pattern="^(?!\s*$).+" 
                                   type="text" name="username" maxlength="20" value="${userName}" required /></td>
                    </tr>
                    <tr>
                        <td class="light-blue"> Password:</td>
                        <td><input type="password" name="password" maxlength="20" required /></td>
                    </tr>
                    <tr>

                        <td class="light-blue">User type:</td>
                        <td>
                            <select class="select-type" name="user-type" >
                                <option value="Teacher" ${isTeacher!=null?'selected"':''}>Teacher</option>
                                <option value="Student" ${isStudent!=null?'selected':''}>Student</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td class="light-blue">Email:</td>
                        <td><input maxlength="50" type="email" name="email" value="${email}" required /></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><input type="submit" value="Register" /></td>
                    </tr>
                </table>
            </form>   
        </c:if>
    </body>

</html>
