<%-- 
    Document   : forgetpass
    Created on : May 15, 2024, 3:11:44 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/forget.css">
        <!--<link rel="stylesheet" href="assets/css/reset.css">-->


    </head>
    <body>
        <a class="navbar-brand" href="index.jsp">
            <figure style="width: 55px;height: 55px;">
                <img style="height: 100%;width: 100%;object-fit: cover;" src="./assets/images/easyjobb.png" alt="alt"/>
            </figure>

        </a>
        <div class="flex--item">
            <div class="newsletter-form">
                <p class="heading"> Enter your new password</p>
                <form class="form" method="get" action="changepassemployer">
                    <label for="email">New password</label>
                    <input required="" placeholder="New password" name="newpass" id="email" type="password">
                    <input placeholder="New password" name="userIDChange" value="${user.idUser}"  type="hidden">

                    <label for="email">Confirm new password</label>
                    <input required="" placeholder="Confirm new password" name="confirmnewpass" id="email" type="password">
                    <b class="notice-erorr">${notice}</b>
                    <input value="Reset password" type="submit" style="display: inline-block;padding: 16px 0;background-color: #7808d0;">
                    <a style="display: inline-block;color:#007be5; font-size: 15px; text-decoration: none;

                       font-family: Whyte, sans-serif; margin-top: 9px; margin-left: 50%;
                       transform: translateX(-50%);

                       " href="loginemployeer.jsp">Cancel</a>
                </form>
            </div>

        </div>
    </body>
</html>
