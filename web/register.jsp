<%-- 
    Document   : register
    Created on : May 15, 2024, 1:50:24 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/login.css">

    </head>
    <body>
        <a class="navbar-brand" href="index.jsp">
            <figure style="width: 55px;height: 55px;">
                <img style="height: 100%;width: 100%;object-fit: cover;" src="./assets/images/easyjobb.png" alt="alt"/>
            </figure>

        </a>
        <div class="login-box">
            <form action="registerjobseeker?role=2" class="form_container" method="post">
                <div class="logo_container">
                    <img style="height: 100%;width: 100%;object-fit: cover" src="./assets/images/easyjobwithouttext.png" alt="alt"/>
                </div>
                <div class="title_container">
                    <p class="title">Register to your Account</p>
                    <span class="subtitle">Get started with our platform, just create an account and enjoy the experience.</span>
                </div>
                <br>

                <div class="edit--flex">
                    <div class="input_container">
                        <label class="input_label" for="">First name</label>
                        <svg class="icon" width="20px" height="24px" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" fill="#000000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <title>users</title> <desc>Created with sketchtool.</desc> <g id="web-app" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"> <g id="users" fill="#000000"> <path d="M8,13 C6.34314575,13 5,11.6568542 5,10 C5,8.34314575 6.34314575,7 8,7 C9.65685425,7 11,8.34314575 11,10 C11,11.6568542 9.65685425,13 8,13 Z M16,13 C14.3431458,13 13,11.6568542 13,10 C13,8.34314575 14.3431458,7 16,7 C17.6568542,7 19,8.34314575 19,10 C19,11.6568542 17.6568542,13 16,13 Z M8,15 C10.3893851,15 12.5341111,16.0475098 14,17.7083512 C14,18.1839232 14,18.6144728 14,19 L2,19 C2,18.6144728 2,18.1839232 2,17.7083512 C3.46588891,16.0475098 5.61061495,15 8,15 Z M16,19 L16,16.9519717 L15.4994784,16.3848843 C15.1151403,15.949432 14.6965808,15.550843 14.2491048,15.1921858 C14.8126186,15.0663701 15.3985585,15 16,15 C18.3893851,15 20.5341111,16.0475098 22,17.7083512 L22,19 L16,19 Z" id="Shape"> </path> </g> </g> </g></svg>
                        <input placeholder="" title="" name="firstname" type="text" class="input_field" id="">
                    </div>
                    <div class="input_container">
                        <label class="input_label" for="">Last name</label>
                        <svg class="icon" width="20px" height="24px" viewBox="0 0 24 24" version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" fill="#000000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <title>users</title> <desc>Created with sketchtool.</desc> <g id="web-app" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd"> <g id="users" fill="#000000"> <path d="M8,13 C6.34314575,13 5,11.6568542 5,10 C5,8.34314575 6.34314575,7 8,7 C9.65685425,7 11,8.34314575 11,10 C11,11.6568542 9.65685425,13 8,13 Z M16,13 C14.3431458,13 13,11.6568542 13,10 C13,8.34314575 14.3431458,7 16,7 C17.6568542,7 19,8.34314575 19,10 C19,11.6568542 17.6568542,13 16,13 Z M8,15 C10.3893851,15 12.5341111,16.0475098 14,17.7083512 C14,18.1839232 14,18.6144728 14,19 L2,19 C2,18.6144728 2,18.1839232 2,17.7083512 C3.46588891,16.0475098 5.61061495,15 8,15 Z M16,19 L16,16.9519717 L15.4994784,16.3848843 C15.1151403,15.949432 14.6965808,15.550843 14.2491048,15.1921858 C14.8126186,15.0663701 15.3985585,15 16,15 C18.3893851,15 20.5341111,16.0475098 22,17.7083512 L22,19 L16,19 Z" id="Shape"> </path> </g> </g> </g></svg>

                        <input placeholder="" title="" name="lastname" type="text" class="input_field" id="">
                    </div>

                </div>
                <div class="input_container">
                    <label class="input_label" for="email_field">Email</label>
                    <svg fill="none" viewBox="0 0 24 24" height="24" width="24" xmlns="http://www.w3.org/2000/svg" class="icon">
                    <path stroke-linejoin="round" stroke-linecap="round" stroke-width="1.5" stroke="#141B34" d="M7 8.5L9.94202 10.2394C11.6572 11.2535 12.3428 11.2535 14.058 10.2394L17 8.5"></path>
                    <path stroke-linejoin="round" stroke-width="1.5" stroke="#141B34" d="M2.01577 13.4756C2.08114 16.5412 2.11383 18.0739 3.24496 19.2094C4.37608 20.3448 5.95033 20.3843 9.09883 20.4634C11.0393 20.5122 12.9607 20.5122 14.9012 20.4634C18.0497 20.3843 19.6239 20.3448 20.7551 19.2094C21.8862 18.0739 21.9189 16.5412 21.9842 13.4756C22.0053 12.4899 22.0053 11.5101 21.9842 10.5244C21.9189 7.45886 21.8862 5.92609 20.7551 4.79066C19.6239 3.65523 18.0497 3.61568 14.9012 3.53657C12.9607 3.48781 11.0393 3.48781 9.09882 3.53656C5.95033 3.61566 4.37608 3.65521 3.24495 4.79065C2.11382 5.92608 2.08114 7.45885 2.01576 10.5244C1.99474 11.5101 1.99475 12.4899 2.01577 13.4756Z"></path>
                    </svg>
                    <input placeholder="name@mail.com" title="Inpit title" name="email" type="email" class="input_field" id="email_field">
                </div>
                <div class="input_container">
                    <label class="input_label" for="password_field">Password</label>
                    <svg fill="none" viewBox="0 0 24 24" height="24" width="24" xmlns="http://www.w3.org/2000/svg" class="icon">
                    <path stroke-linecap="round" stroke-width="1.5" stroke="#141B34" d="M18 11.0041C17.4166 9.91704 16.273 9.15775 14.9519 9.0993C13.477 9.03404 11.9788 9 10.329 9C8.67911 9 7.18091 9.03404 5.70604 9.0993C3.95328 9.17685 2.51295 10.4881 2.27882 12.1618C2.12602 13.2541 2 14.3734 2 15.5134C2 16.6534 2.12602 17.7727 2.27882 18.865C2.51295 20.5387 3.95328 21.8499 5.70604 21.9275C6.42013 21.9591 7.26041 21.9834 8 22"></path>
                    <path stroke-linejoin="round" stroke-linecap="round" stroke-width="1.5" stroke="#141B34" d="M6 9V6.5C6 4.01472 8.01472 2 10.5 2C12.9853 2 15 4.01472 15 6.5V9"></path>
                    <path fill="#141B34" d="M21.2046 15.1045L20.6242 15.6956V15.6956L21.2046 15.1045ZM21.4196 16.4767C21.7461 16.7972 22.2706 16.7924 22.5911 16.466C22.9116 16.1395 22.9068 15.615 22.5804 15.2945L21.4196 16.4767ZM18.0228 15.1045L17.4424 14.5134V14.5134L18.0228 15.1045ZM18.2379 18.0387C18.5643 18.3593 19.0888 18.3545 19.4094 18.028C19.7299 17.7016 19.7251 17.1771 19.3987 16.8565L18.2379 18.0387ZM14.2603 20.7619C13.7039 21.3082 12.7957 21.3082 12.2394 20.7619L11.0786 21.9441C12.2794 23.1232 14.2202 23.1232 15.4211 21.9441L14.2603 20.7619ZM12.2394 20.7619C11.6914 20.2239 11.6914 19.358 12.2394 18.82L11.0786 17.6378C9.86927 18.8252 9.86927 20.7567 11.0786 21.9441L12.2394 20.7619ZM12.2394 18.82C12.7957 18.2737 13.7039 18.2737 14.2603 18.82L15.4211 17.6378C14.2202 16.4587 12.2794 16.4587 11.0786 17.6378L12.2394 18.82ZM14.2603 18.82C14.8082 19.358 14.8082 20.2239 14.2603 20.7619L15.4211 21.9441C16.6304 20.7567 16.6304 18.8252 15.4211 17.6378L14.2603 18.82ZM20.6242 15.6956L21.4196 16.4767L22.5804 15.2945L21.785 14.5134L20.6242 15.6956ZM15.4211 18.82L17.8078 16.4767L16.647 15.2944L14.2603 17.6377L15.4211 18.82ZM17.8078 16.4767L18.6032 15.6956L17.4424 14.5134L16.647 15.2945L17.8078 16.4767ZM16.647 16.4767L18.2379 18.0387L19.3987 16.8565L17.8078 15.2945L16.647 16.4767ZM21.785 14.5134C21.4266 14.1616 21.0998 13.8383 20.7993 13.6131C20.4791 13.3732 20.096 13.1716 19.6137 13.1716V14.8284C19.6145 14.8284 19.619 14.8273 19.6395 14.8357C19.6663 14.8466 19.7183 14.8735 19.806 14.9391C19.9969 15.0822 20.2326 15.3112 20.6242 15.6956L21.785 14.5134ZM18.6032 15.6956C18.9948 15.3112 19.2305 15.0822 19.4215 14.9391C19.5091 14.8735 19.5611 14.8466 19.5879 14.8357C19.6084 14.8273 19.6129 14.8284 19.6137 14.8284V13.1716C19.1314 13.1716 18.7483 13.3732 18.4281 13.6131C18.1276 13.8383 17.8008 14.1616 17.4424 14.5134L18.6032 15.6956Z"></path>
                    </svg>
                    <input placeholder="Password" title="Inpit title" name="password" type="password" class="input_field" id="password_field">
                </div>

                <b class="notice-erorr">${notice}</b>
                <button title="Sign In" type="submit" class="sign-in_btn">



                    <span class="sign-in-text">Register</span>
                </button>


                <div style="display: flex;align-items: center">
                    <p class="note" style="color:#00000080;font-weight: 600; ">Already have an  account? </p><a style="text-decoration: none;font-weight: 600" href="login.jsp"class="note">&nbsp; Login now</a>

                </div>


            </form>

        </div>

    </body>
</html>
