<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="css/login.css" rel="stylesheet" />
        <title>Login Page</title>

    </head>
    <body>      
        <form action="LoginController" method="post"> 

            <table border="0">

                <tr>
                    <td><p class="dark-blue lblLoginForm bold">Login Form</p></td>
                    <td></td>
                <c:if test="${status != null}">
                    <tr>
                        <td></td>
                        <td style="color: red;"><a>${status}</a></td>
                    </tr>
                </c:if> 
                <tr>
                    <td class="light-blue sz-20">User Name:</td>
                    <td><input pattern="^(?!\s*$).+" type="text" name="username" class="txtLogin " value="${userName}" maxlength="20" required /></td>
                </tr>
                <tr>
                    <td class="light-blue sz-20"> Password:</td>
                    <td><input type="password" name="password" class="txtLogin " maxlength="20" required /></td>
                </tr>

                <tr>                            
                    <td></td>
                    <td><input type="submit" class="submit-login" value="Sign in" /> 
                        <a class="light-blue none-decoration sz-16" href="RegisterController">Register</a></td>
                </tr>                  
            </table>

        </form>        
    </body>
</html>
