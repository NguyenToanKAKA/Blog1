<%-- 
    Document   : otpchecker
    Created on : May 15, 2024, 3:50:38 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/otp.css">

    </head>
    <style>


    </style>
    <body>
        <a class="navbar-brand" href="index.jsp">
            <figure style="width: 55px;height: 55px;">
                <img style="height: 100%;width: 100%;object-fit: cover;" src="./assets/images/easyjobb.png" alt="alt"/>
            </figure>

        </a>
        <div class="middle">
            <form class="otp-Form" method="post" action="verifychangepass?role=2">
                <span class="mainHeading">Enter OTP</span>
                <p class="otpSubheading">We have sent a verification code to your email.</p>
                <div class="inputContainer">
                    <input name="userID" value="${userID}" hidden="" type="hidden"/>
                    <input name="token" value="${token}" hidden=""type="hidden"/>
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input1">
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input2">
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input3">
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input4"> 
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input5"> 
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input6"> 
                </div>
                <b class="notice-erorr">${notice}</b>
                <button class="verifyButton" type="submit">Verify</button>
                <button class="exitBtn">×</button>
                <input name="userID" value="${user.idUser}" hidden="" type="hidden"/>
                <input name="token" value="${token}" hidden=""type="hidden"/>

            </form>




        </div>
    </body>
</html>
