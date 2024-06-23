<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="assets/images/favicon.ico">
        <link rel="stylesheet" href="assets/css/button.css">

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css"
              integrity="sha256-3sPp8BkKUE7QyPSl6VfBByBroQbKxKG7tsusY2mhbVY=" crossorigin="anonymous" />

        <title>PHPJabbers.com | Free Job Agency Website Template</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- Additional CSS Files -->
        <link rel="stylesheet" href="assets/css/fontawesome.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/owl.css">
        <link rel="stylesheet" href="assets/css/button.css">
        <link rel="stylesheet" href="assets/css/icontop.css">
        <link rel="stylesheet" href="assets/css/style_1.css">

        <!-- Toastr Notification Styles -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
        <style>
            .purple-button {
                background-color: purple;
                color: white; /* Adjust the text color to be visible on a purple background */
                border: none; /* Remove border if desired */
            }

            .purple-button:hover {
                background-color: darkviolet; /* Optional: Change color on hover */
            }
            .job-right .btn {
                margin-bottom: 5px; /* Adjust to decrease space */
            }

            .job-right .btn + .btn {
                margin-top: 0; /* Ensure no additional margin at the top */
            }

            /* Optional: Add margin between buttons */
            .col-md-12 .btn {

                margin-bottom: 10px
            }

        </style>
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
        <jsp:include page="header.jsp"/>

        <!-- Page Content -->
        <div class="page-heading about-heading header-text" style="background-image: url(assets/images/heading-6-1920x500.jpg);">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content">

                            <h2>Manage Blog</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="products">
            <div class="container">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12 text-right">
                            <a href="managerblog" class="btn btn-lg btn-custom purple-button">
                                Manager Blog
                            </a>
                            <a href="acceptblog" class="btn btn-lg btn-custom purple-button">
                                Accept Blog
                            </a>
                            <a href="rejectblog" class="btn btn-lg btn-custom purple-button">
                                Reject Blog
                            </a>
                            <a href="pendingblog" class="btn btn-lg btn-custom purple-button">
                                Pending Blog
                            </a>
                            <a href="CreateBlog.jsp" class="btn btn-lg btn-custom purple-button">
                                Create Blog
                            </a>

                        </div>
                    </div>
                </div>







                <div class="row">   


                    <div class="filter-result">
                        <c:forEach items="${listP}" var="p">  
                            <div class="job-box d-md-flex align-items-center justify-content-between mb-30">

                                <div class="job-left my-4 d-md-flex align-items-center flex-wrap">
                                    <img class="img-holder mr-md-4 mb-md-0 mb-4 mx-auto mx-md-0 d-md-none d-lg-flex" style="width:90px; height:90px" src="assets/blog/${p.image}" />


                                    <div class="job-content">
                                        <h5 class="text-center text-md-start mb-2">${p.title}</h5>
                                        <ul class="d-md-flex flex-wrap text-capitalize ff-open-sans">

                                            <li class="me-md-4">
                                                <i class="zmdi zmdi-calendar-alt"></i>Publish date: ${p.date}  
                                            </li>
                                            <li class="me-md-4">
                                                <i class="zmdi zmdi-account"></i>Status: ${p.status}  
                                            </li>

                                        </ul>
                                    </div>

                                </div>

                                <div class="job-right my-4 flex-shrink-0 d-flex flex-column">
                                    <c:choose>
                                        <c:when test="${p.status eq 'Pending'}">
                                            <button class="btn d-block w-100 d-sm-inline-block btn-light mb-2" disabled>
                                                <i class="zmdi zmdi-forward"></i> Detail now
                                            </button>
                                            <a class="btn d-block w-100 d-sm-inline-block btn-light" href="load?pid=${p.blogId}">
                                                <i class="zmdi zmdi-border-color"></i> Update now
                                            </a>
                                            <p class="text-danger mt-2">This blog is pending approval. Details are disabled.</p>
                                        </c:when>
                                        <c:when test="${p.status eq 'Reject'}">
                                            <button class="btn d-block w-100 d-sm-inline-block btn-light mb-2" disabled>
                                                <i class="zmdi zmdi-forward"></i> Detail now
                                            </button>
                                            <a class="btn d-block w-100 d-sm-inline-block btn-light" href="load?pid=${p.blogId}">
                                                <i class="zmdi zmdi-border-color"></i> Update now
                                            </a>
                                            <p class="text-danger mt-2">This blog has been rejected. Details are disabled.</p>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="blogDetails?bid=${p.blogId}" class="btn d-block w-100 d-sm-inline-block btn-light mb-2">
                                                <i class="zmdi zmdi-forward"></i> Detail now
                                            </a>
                                            <a href="load?pid=${p.blogId}" class="btn d-block w-100 d-sm-inline-block btn-light">
                                                <i class="zmdi zmdi-border-color"></i> Update now
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>



                            </div>
                        </c:forEach> 
                    </div>


                </div>
            </div>

            <nav aria-label="Page navigation">
                <ul class="pagination pagination-reset justify-content-center">
                    <li class="page-item ${currentPage == 1 ? 'disabled' : ''}">
                        <a class="page-link" href="?page=${currentPage - 1}" tabindex="-1" aria-disabled="true">
                            <i class="zmdi zmdi-long-arrow-left"></i>
                        </a>
                    </li>
                    <c:forEach begin="1" end="${noOfPages}" var="i">
                        <li class="page-item ${currentPage == i ? 'active' : ''}">
                            <a class="page-link" href="?page=${i}">${i}</a>
                        </li>
                    </c:forEach>
                    <li class="page-item ${currentPage == noOfPages ? 'disabled' : ''}">
                        <a class="page-link" href="?page=${currentPage + 1}">
                            <i class="zmdi zmdi-long-arrow-right"></i>
                        </a>
                    </li>
                </ul>
            </nav>
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

        <!-- Toastr Notification Scripts -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>


    </body>

</html>
