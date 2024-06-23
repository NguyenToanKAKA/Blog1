<%-- 
    Document   : admin
    Created on : May 20, 2024, 8:55:57 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/admincss.css">

    </head>
    <body>

        <div style="display: flex; align-items: center;justify-content: center">  <!-- comment -->
            <form class="form" method="post" action="loginjobseeker?role=1" style="align-self: center;margin-top: 200px;">
                <p class="form-title">Sign in Admin Role</p>
                <div class="input-container">
                    <input type="email" placeholder="Enter email" name="email">
                    <span>
                    </span>
                </div>
                <div class="input-container">
                    <input type="password" placeholder="Enter password" name="password">
                </div>
                <b class="notice-erorr">${notice}</b>
                <button type="submit" class="submit">
                    Sign in
                </button>

            </form>

        </div>


    </body>
</html>
