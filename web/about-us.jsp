<!DOCTYPE html>

<%@ page import="jakarta.servlet.http.HttpSession" %>
<%@ page import="model.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="assets/images/favicon.ico">
        <link rel="stylesheet" href="assets/css/button.css">



        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

        <title>PHPJabbers.com | Free Job Agency Website Template</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/icontop.css">



    </head>

    <body>




        <!-- ***** Preloader Start ***** -->
        <div id="preloader">
            <div class="jumper">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>  
        <!-- ***** Preloader End ***** -->

        <!-- Header -->


        <header class="">
            <nav class="navbar navbar-expand-lg">
                <div class="container">
                    <c:choose>
                        <c:when test="${sessionScope.account == null}">
                            <a style="width: 55px;height: 55px;display: inline-block" class="navbar-brand" href="index.jsp">
                            </c:when>
                            <c:otherwise> 
                                <a style="width: 55px;height: 55px;display: inline-block" class="navbar-brand" href="home.jsp">

                                </c:otherwise>

                            </c:choose>
                            <figure style="width: 100%;height: 100%;margin-right: -30px;">
                                <img style="height: 100%;width: 100%;object-fit: cover;" src="./assets/images/easyjobb.png" alt="alt"/>
                            </figure>

                        </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarResponsive">
                            <ul class="navbar-nav ml-auto">
                                <li class="nav-item">
                                    <c:choose>
                                        <c:when test="${sessionScope.account == null}">
                                            <a class="nav-link" href="index.jsp">Home
                                            </c:when>
                                            <c:otherwise> 
                                                <a class="nav-link" href="home.jsp">Home

                                                </c:otherwise>

                                            </c:choose>
                                            <span class="sr-only">(current)</span>
                                        </a>
                                </li> 

                                <li class="nav-item"><a class="nav-link" href="jobs.jsp">Jobs</a></li>

                                <li class="nav-item active"><a class="nav-link" href="about-us.jsp">About us</a></li>

                                <li class="nav-item"><a class="nav-link" href="blog.jsp">Blog</a></li>

                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">More</a>

                                    <div class="dropdown-menu">
                                        <a class="dropdown-item" href="team.jsp">Team</a>
                                        <a class="dropdown-item" href="testimonials.jsp">Testimonials</a>
                                        <a class="dropdown-item" href="terms.jsp">Terms</a>
                                    </div>
                                </li>

                                <li class="nav-item"><a class="nav-link" href="contact.jsp">Contact Us</a></li>
                            </ul>
                            <c:choose>
                                <c:when test="${sessionScope.account == null}">
                                    <div style="display: flex;align-items: center;margin-left: 100px;">
                                        <div style="display: flex;max-height: 45px;margin-bottom: 15px;">
                                            <a style="--clr:#ff6600" class="button" href="login.jsp">
                                                <span class="button__icon-wrapper">
                                                    <svg width="10" class="button__icon-svg" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 15">
                                                    <path fill="currentColor" d="M13.376 11.552l-.264-10.44-10.44-.24.024 2.28 6.96-.048L.2 12.56l1.488 1.488 9.432-9.432-.048 6.912 2.304.024z"></path>
                                                    </svg>

                                                    <svg class="button__icon-svg  button__icon-svg--copy" xmlns="http://www.w3.org/2000/svg" width="10" fill="none" viewBox="0 0 14 15">
                                                    <path fill="currentColor" d="M13.376 11.552l-.264-10.44-10.44-.24.024 2.28 6.96-.048L.2 12.56l1.488 1.488 9.432-9.432-.048 6.912 2.304.024z"></path>
                                                    </svg>
                                                </span>
                                                Find A Job
                                            </a>

                                        </div>
                                        <div style="display: flex;max-height: 45px;margin-bottom: 15px; margin-left: 20px">
                                            <a style="--clr:#7808d0 " class="button" href="loginemployeer.jsp">
                                                <span class="button__icon-wrapper">
                                                    <svg width="10" class="button__icon-svg" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 15">
                                                    <path fill="currentColor" d="M13.376 11.552l-.264-10.44-10.44-.24.024 2.28 6.96-.048L.2 12.56l1.488 1.488 9.432-9.432-.048 6.912 2.304.024z"></path>
                                                    </svg>

                                                    <svg class="button__icon-svg  button__icon-svg--copy" xmlns="http://www.w3.org/2000/svg" width="10" fill="none" viewBox="0 0 14 15">
                                                    <path fill="currentColor" d="M13.376 11.552l-.264-10.44-10.44-.24.024 2.28 6.96-.048L.2 12.56l1.488 1.488 9.432-9.432-.048 6.912 2.304.024z"></path>
                                                    </svg>
                                                </span>
                                                Post A Job
                                            </a>

                                        </div>
                                    </div>
                                </c:when >
                                <c:otherwise >
                                    <ul class="example-2" style="">
                                        <li class="icon-content">
                                            <a href="#!" aria-label="Discord" >
                                                <div class="filled"></div>
                                                <img width="24" height="24" src="https://img.icons8.com/material-outlined/24/appointment-reminders--v1.png" alt="appointment-reminders--v1"/>
                                            </a>
                                            <div class="tooltip">Notification</div>
                                        </li>
                                        <li class="icon-content">
                                            <a
                                                href="#!"


                                                >
                                                <div class="filled"></div>
                                                <svg xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" width="100" height="100" viewBox="0 0 24 24">
                                                <path d="M 12 2 C 6.486 2 2 6.262 2 11.5 C 2 14.045 3.088 16.487484 5 18.271484 L 5 22.617188 L 9.0800781 20.578125 C 10.039078 20.857125 11.02 21 12 21 C 17.514 21 22 16.738 22 11.5 C 22 6.262 17.514 2 12 2 z M 12 4 C 16.411 4 20 7.365 20 11.5 C 20 15.635 16.411 19 12 19 C 11.211 19 10.415672 18.884203 9.6386719 18.658203 L 8.8867188 18.439453 L 8.1855469 18.789062 L 7 19.382812 L 7 18.271484 L 7 17.402344 L 6.3632812 16.810547 C 4.8612813 15.408547 4 13.472 4 11.5 C 4 7.365 7.589 4 12 4 z M 11 9 L 6 14 L 10.5 12 L 13 14 L 18 9 L 13.5 11 L 11 9 z"></path>
                                                </svg>
                                            </a>
                                            <div class="tooltip">Message</div>
                                        </li>
                                        <li class="icon-content icon-content-1">
                                            <label class="popup" style="display: inline-block; margin-bottom: -8px;">
                                                <input type="checkbox">
                                                <div class="burger" tabindex="0">
                                                    <span></span>
                                                    <span></span>
                                                    <span></span>
                                                </div>
                                                <nav class="popup-window">
                                                    <legend>Actions</legend>
                                                    <ul>
                                                        <li>
                                                            <a class="a-new" href="profilejb.jsp">
                                                                <svg stroke-linejoin="round" stroke-linecap="round" stroke-width="2" stroke="currentColor" fill="none" viewBox="0 0 24 24" height="14" width="14" xmlns="http://www.w3.org/2000/svg">
                                                                <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                                                                <circle r="4" cy="7" cx="9"></circle>
                                                                <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                                                                <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                                                                </svg>
                                                                <span>Edit Profile</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a class="a-new" href="#!">
                                                                <svg stroke-linejoin="round" stroke-linecap="round" stroke-width="2" stroke="currentColor" fill="none" viewBox="0 0 24 24" height="14" width="14" xmlns="http://www.w3.org/2000/svg">
                                                                <rect ry="2" rx="2" height="13" width="13" y="9" x="9"></rect>
                                                                <path d="M5 15H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a2 2 0 0 1 2 2v1"></path>
                                                                </svg>
                                                                <span>Create CV</span>
                                                            </a>
                                                        </li>

                                                        <hr>
                                                        <li>
                                                            <a class="a-new" href="#!">
                                                                <img width="30" height="30" src="https://img.icons8.com/material/30/buy-upgrade--v1.png" alt="buy-upgrade--v1"/>
                                                                <span>Upgrade Package</span>
                                                            </a>
                                                        </li>
                                                        <li>
                                                            <a class="a-new" href="#!">
                                                                <img width="30" height="30" src="https://img.icons8.com/material-outlined/30/view.png" alt="view"/>
                                                                <span>CVs submitted</span>
                                                            </a>
                                                        </li>
                                                        <hr>
                                                        <li>
                                                            <a class="a-new" href="loginjobseeker">
                                                                <svg width="30px" height="30px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg" stroke="#FF0000"><g id="SVGRepo_bgCarrier" stroke-width="0"></g><g id="SVGRepo_tracerCarrier" stroke-linecap="round" stroke-linejoin="round"></g><g id="SVGRepo_iconCarrier"> <path d="M8.00171 7C8.01382 4.82497 8.11027 3.64706 8.87865 2.87868C9.75733 2 11.1715 2 14 2H15C17.8284 2 19.2426 2 20.1213 2.87868C21 3.75736 21 5.17157 21 8V16C21 18.8284 21 20.2426 20.1213 21.1213C19.2426 22 17.8284 22 15 22H14C11.1715 22 9.75733 22 8.87865 21.1213C8.11027 20.3529 8.01382 19.175 8.00171 17" stroke="#FF0000" stroke-width="1.5" stroke-linecap="round"></path> <path opacity="0.5" d="M8 19.5C5.64298 19.5 4.46447 19.5 3.73223 18.7678C3 18.0355 3 16.857 3 14.5V9.5C3 7.14298 3 5.96447 3.73223 5.23223C4.46447 4.5 5.64298 4.5 8 4.5" stroke="#FF0000" stroke-width="1.5"></path> <path d="M15 12L6 12M6 12L8 14M6 12L8 10" stroke="#FF0000" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path> </g></svg>
                                                                <span>Logout</span>
                                                            </a>
                                                        </li>
                                                    </ul>
                                                </nav>
                                            </label>
                                            <div class="tooltip">Account</div>
                                        </li>
                                    </ul>
                                </c:otherwise>
                            </c:choose>
                        </div>
                </div>
            </nav>
        </header>

        <!-- Page Content -->
        <div class="page-heading about-heading header-text" style="background-image: url(assets/images/heading-1-1920x500.jpg);">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content">
                            <h4>about us</h4>
                            <h2>our company</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="best-features about-features">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-heading">
                            <h2>Lorem ipsum dolor sit amet consectetur adipisicing</h2>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="right-image">
                            <img src="assets/images/about-1-570x350.jpg" alt="">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="left-content">
                            <h4>Lorem ipsum dolor sit amet.</h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed voluptate nihil eum consectetur similique? Consectetur, quod, incidunt, harum nisi dolores delectus reprehenderit voluptatem perferendis dicta dolorem non blanditiis ex fugiat. Lorem ipsum dolor sit amet, consectetur adipisicing elit.<br><br>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam? Aut, in eum facere corrupti necessitatibus perspiciatis quis.</p>
                            <ul class="social-icons">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="fa fa-behance"></i></a></li>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="team-members">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="section-heading">
                            <h2>Lorem ipsum dolor sit amet.</h2>
                        </div>

                        <h5>Lorem ipsum dolor sit amet.</h5>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sed voluptate nihil eum consectetur similique? Consectetur, quod, incidunt, harum nisi dolores delectus reprehenderit voluptatem perferendis dicta dolorem non blanditiis ex fugiat. Lorem ipsum dolor sit amet, consectetur adipisicing elit.<br><br>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Et, consequuntur, modi mollitia corporis ipsa voluptate corrupti eum ratione ex ea praesentium quibusdam? Aut, in eum facere corrupti necessitatibus perspiciatis quis.</p>

                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nemo quae eveniet tempora reprehenderit quo, necessitatibus vel sit laboriosam, sunt obcaecati quisquam explicabo voluptatibus earum facilis quidem fuga maiores. Quasi, obcaecati? <br><br> Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sequi, est officiis. Ipsam quas consequuntur adipisci quis, fuga pariatur eius eveniet qui similique nulla inventore accusantium, suscipit asperiores quibusdam culpa iure!</p>
                    </div>
                </div>
            </div>
        </div>

        <footer>
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="inner-content">
                            <p>Copyright © 2020 Company Name - Template by: <a href="https://www.phpjabbers.com/">PHPJabbers.com</a></p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>


        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


        <!-- Additional Scripts -->
        <script src="assets/js/custom.js"></script>
        <script src="assets/js/owl.js"></script>
    </body>

</html>
