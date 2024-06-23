<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>

        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="codepixer">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Job Listing</title>

        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,400,300,500,600,700" rel="stylesheet">
        <!--
            CSS
            ============================================= -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="assets/css/main.css">
        <link rel="stylesheet" href="https://cdn.linearicons.com/free/1.0.0/icon-font.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="assets/images/favicon.ico">
        <link rel="stylesheet" href="assets/css/icontop.css">
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">



        <link rel="stylesheet" href="assets/css/style.css">

        <link rel="stylesheet" href="assets/css/button.css">

        <style>
            .report-options {
                display: none;
                position: absolute;
                background-color: #ffffff;
                border: 1px solid #ccc;
                padding: 10px;
                z-index: 1;
            }

            .reply-btn:hover .report-options {
                display: flex;
                flex-direction: column;
                margin-top: 10px;
            }

            .report-options a {
                border: 1px solid black;
                padding: 5px;
                margin-bottom: 5px;
            }

            .custom-btn {
                background-color: red;
                color: white;
                padding: 8px 16px;
                border: 2px solid red;
                border-radius: 20px;
                text-decoration: none;
                cursor: pointer;
                transition: all 0.3s ease;
            }

            .custom-btn:hover {
                background-color: transparent;
                color: red;
            }

            .bottom-meta .list-inline-item a {
                font-size: 16px;
            }

            .bottom-meta .list-inline-item a span {
                font-size: 20px;
                margin-right: 5px;
            }

            .thumb {
                position: relative;
                text-align: center; /* Center align the button under the image */
            }

            .thumb img {
                display: block;
                margin: 0 auto;
            }

            .report-button {
                display: block;
                margin: 10px auto 0 auto; /* 10px margin above the button */
                background-color: black;
                color: white;
                padding: 5px 10px;
                border: none;
                cursor: pointer;
                width: 60px;
                text-align: center;

            }

            .report-button:hover {
                background-color: darkred;
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

      

        <!-- Page Content -->
        <div class="page-heading about-heading header-text" style="background-image: url(assets/images/heading-6-1920x500.jpg);">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="text-content">

                            <h2>Blog ${blog.title}</h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Start blog-posts Area -->
        <section class="blog-posts-area section-gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 post-list blog-post-list">
                        <div class="single-post">
                            <img class="img-fluid" src="assets/blog/${blog.image}" alt="" style="width: 690px; height: 294px;">

                            <a href="#">
                                <h1>
                                    ${blog.title}
                                </h1>
                            </a>
                            <div class="content-wrap">
                                <p style="text-align: justify;">
                                    ${blog.content}

                                </p>

                            </div>
                            <div class="bottom-meta">
                                <div class="user-details row align-items-center" style="margin-top: 30px">
                                    <div class="comment-wrap col-lg-12" >
                                        <ul class="list-inline">
                                            <li class="list-inline-item"><a href="${pageContext.request.contextPath}/likeBlogs?uid=${sessionScope.account.idUser}&&bid=${blog.blogId}"><span class="lnr lnr-heart"></span> ${blog.nLike}
                                                    likes</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="lnr lnr-bubble"></span> ${blog.nCmt}
                                                    Comments</a></li>
                                            <li class="list-inline-item"><a href="#"><span class="lnr lnr-history"></span>
                                                    ${blog.date}</a></li>
                                        </ul>
                                    </div>

                                </div>
                            </div>

                            <!-- <section class="nav-area pt-50 pb-100">
                                <div class="container">
                                    <div class="row justify-content-between">
                                        <div class="col-sm-6 nav-left justify-content-start d-flex">
                                            <div class="thumb">
                                                <img src="prev.jpg" alt="" style="width: 80px; height: 80px;">
                                            </div>
                                            <div class="post-details">
                                                <p>Prev Post</p>
                                                <h4 class="text-uppercase"><a href="#" style="width: 150px; height: 150px">Cartridge Is Better Than Ever
                                                        A Discount Toner</a></h4>
                                            </div>
                                        </div>
                                        <div class="col-sm-6 nav-right justify-content-end d-flex">
                                            <div class="post-details">
                                                <p>Next Post</p>
                                                <h4 class="text-uppercase" ><a href="#" style="width: 150px; height: 150px;">Cartridge Is Better Than Ever
                                                        A Discount Toner</a></h4>
                                            </div>
                                            <div class="thumb">
                                                <img src="next.jpg" alt="" style="width: 80px; height: 80px;">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section> -->

                            <!-- End nav Area -->

                            <!-- Start comment-sec Area -->
                            <section class="comment-sec-area pt-80 pb-80">
                                <div class="container">
                                    <div class="row flex-column">
                                        <h5 class="text-uppercase pb-80"><span class="lnr lnr-bubble"></span>   ${blog.nCmt} Comments</h5>

                                        <div class="comment-list">
                                            <c:forEach items    ="${blog.cmt}" var="c" >
                                                <div class="single-comment justify-content-between d-flex" style="margin-top:20px">
                                                    <div class="user justify-content-between d-flex">
                                                        <div class="thumb">
                                                            <img src="assets/avatars/${c.avatar}" alt="" style="width: 62px; height: 62px">
                                                             <a class="report-button" href="reportComment?commentId=${c.commentId}&blogId=${blog.blogId}" onclick="return confirm('Are you sure you want to report this comment?')">Report</a>
                                                        </div>
                                                        <div class="desc">
                                                            <h5><a >${c.uFullName}</a></h5>
                                                            <p class="date"><i class="zmdi zmdi-calendar-alt"></i>  ${c.date} </p>
                                                            <p class="comment">
                                                                ${c.content} 

                                                            </p>
                                                        </div>
                                                    </div>
                                                    <div class="reply-btn">
                                                        <c:if test="${sessionScope.account.idUser eq c.userId}">
                                                            <a href="#" class="btn-reply text-uppercase">Edit</a>
                                                        </c:if>
                                                        <div class="report-options">

                                                            <a href="#2">Update</a>
                                                            <a href="deleteComment?commentId=${c.commentId}&blogId=${blog.blogId}" onclick="return confirm('Are you sure you want to delete this comment?')">Delete</a>
                                                        </div>
                                                    </div>

                                                </div>
                                            </c:forEach>
                                        </div>




                                    </div>
                                </div>
                            </section>
                            <!-- End comment-sec Area -->


                            <!--<a class="primary-btn mt-20 custom-btn" href="#">cai nay tren 3 Comment bam thi hien ra may
                                comment sau</a>  -->




                            <!-- Start commentform Area -->
                            <section class="commentform-area pt-80">
                                <form action="${pageContext.request.contextPath}/commentBlog" method="POST" onsubmit="return validateForm()">
                                    <div class="container">
                                        <h5 class="pb-50">Leave a Reply</h5>
                                        <div class="row flex-row d-flex">
                                            <input type="hidden" name="bid" value="${blog.blogId}" />
                                            <input type="hidden" name="uid" value="${sessionScope.account.idUser}" />
                                            <div class="col-lg-8 col-md-12">
                                                <textarea id="commentContent" name="content" class="form-control mb-10" placeholder="500 characters remaining"
                                                          onfocus="this.placeholder = ''" onblur="this.placeholder = '500 characters remaining'"
                                                          required="" maxlength="500"></textarea>

                                                <input id="submitButton" class="primary-btn mt-20" href="#" value="Comment" type="submit" />
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </section>
                            <!-- End commentform Area -->


                        </div>
                    </div>
                    <div class="col-lg-4 sidebar">


                        <div class="single-widget protfolio-widget">
                            <img src="assets/avatars/${author.avatar}" alt="" style="width: 120px; height: 120px;">
                            <a href="#">
                                <h4>${author.firstName} ${author.lastName}</h4>
                            </a>


                            <p><span class="lnr lnr-map-marker"></span>
                                ${author.city}
                            </p>
                            <p><i class="zmdi zmdi-google-plus-box"></i></span>
                                ${author.email}
                            </p>

                        </div>



                        <div class="single-widget recent-posts-widget">
                            <h4 class="title">Influence Posts</h4>
                            <div class="blog-list">
                                <c:forEach var="influencePost" items="${influencePosts}">
                                    <div class="single-recent-post d-flex flex-row" style="margin-bottom: 10px">
                                        <div class="recent-thumb">
                                            <img class="img-fluid" src="assets/blog/${influencePost.image}" alt="" style="width: 80px; height: 80px">
                                        </div>
                                        <div class="recent-details">
                                            <a href="${pageContext.request.contextPath}/blogDetails?bid=${influencePost.blogId}">
                                                <h4>${influencePost.title}</h4>
                                            </a>
                                            <p><span class="lnr lnr-heart"></span> ${influencePost.nLike} likes</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
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

        </section>
        <!-- End blog-posts Area -->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


        <!-- Additional Scripts -->
        <script src="assets/js/custom.js"></script>
        <script src="assets/js/owl.js"></script>
    </body>

</html>
