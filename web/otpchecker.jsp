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
            <form class="otp-Form" method="post" action="verifyregister?action=verify&role=2">
                <span class="mainHeading">Enter OTP</span>
                <p class="otpSubheading">We have sent a verification code to your mobile number</p>
                <div class="inputContainer">
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input1">
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input2">
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input3">
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input4"> 
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input5"> 
                    <input required="required" maxlength="1" type="text" class="otp-input" name="otp-input6"> 


                </div>
                <button class="verifyButton" type="submit">Verify</button>
                <b class="notice-erorr">${notice}</b>
                <button class="exitBtn">×</button>
                <p class="resendNote">Didn't receive the code? 
                    <a href="verifyregister?action=resend&firstname=${jobseekerFirstName}&lastname=${jobseekerLastName}&email=${jobseekerEmail}&pass=${jobseekerPassword}&role=2" class="resendBtn">Resend Code</a></p>

                <input name="jobseekerFirstName" value="${jobseekerFirstName}" hidden="" type="hidden"/>
                <input name="jobseekerLastName" value="${jobseekerLastName}" hidden=""type="hidden"/>
                <input name="jobseekerEmail" value="${jobseekerEmail}" hidden=""type="hidden"/>
                <input name="jobseekerPassword" value="${jobseekerPassword}" hidden=""type="hidden"/>
                <input name="reqToken" value="${reqToken}" hidden=""/>

            </form>




        </div>
    </body>
</html>
