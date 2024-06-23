

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Easyjob | Free Job For Everyone</title>
    <link rel="stylesheet" href="https://unpkg.com/bootstrap@5.3.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
     <script src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/2.4.0/jspdf.umd.min.js"></script>
     <script src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
   
     <script>
       function savePDF() {
            // L?y n?i dung c?a ph?n t? có id là "overview-tab-pane"
            //var overviewContent = document.getElementById("overview-tab-pane");
             var overviewContent = document.querySelector('.row.gy-4');

            // S? d?ng html2canvas ?? chuy?n ??i ph?n t? HTML thành hình ?nh
            html2canvas(overviewContent, {
                onrendered: function(canvas) {
                    // Sau khi ?ã có canvas, ti?p t?c t?o file PDF
                    var imgData = canvas.toDataURL('image/png');
                    var { jsPDF } = window.jspdf;
                    var pdf = new jsPDF();
                  pdf.addImage(imgData, 'PNG', 0, 0, pdf.internal.pageSize.getWidth(), pdf.internal.pageSize.getHeight(), null, 'FAST');
                  
                    // L?u PDF vào máy ng??i dùng v?i tên t?p là "cv.pdf"
                    pdf.save("cv.pdf");
                }
            });
        }

    </script>
     
    <style>
        img{
              width: 30%;
               height: 40%;
        }
        .cv-image-wrapper {
            width: 30%;
           
            position: relative;
            overflow: hidden;
        }

        .cv-image-wrapper img {
            width: 100%;
            height: 50%;
            display: block;
        }
        #yellow-border{
            border: 2px solid yellow;
            border-radius: 5px; 
        }
    </style>
</head>

<body>
    <!-- Profile 1 - Bootstrap Brain Component -->
    <section class="bg-light py-3 py-md-5 py-xl-8">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-12 col-md-10 col-lg-8 col-xl-7 col-xxl-6">
                    <h2 class="mb-4 display-5 text-center">Profile</h2>
                    <p class="text-secondary text-center lead fs-4 mb-5">The Profile page is your digital hub, where you can fine-tune your experience. Here's a closer look at the settings you can expect to find in your profile page.</p>
                    <hr class="w-50 mx-auto mb-5 mb-xl-9 border-dark-subtle">
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row gy-4 gy-lg-0">
                <div class="col-12 col-lg-4 col-xl-3">
                    <div class="row gy-4">
                        <div class="col-12">
                            <div class="card widget-card border-light shadow-sm">
                                <div class="card-header text-bg-primary">Welcome, <c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /></div>
                                <div class="card-body">
                                    <div class="text-center mb-3">
                                        Mail
                                    </div>
                                    <h5 class="text-center mb-1"><c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /></h5>
                                </div>
                            </div>
                        </div>

                        <!-- L?y ra link url phân cách nhau = kí t? | -->
                        <div class="col-12">
                            <div class="card widget-card border-light shadow-sm">
                                <div class="card-header text-bg-primary">Social Accounts</div>
                                <div class="card-body">
                                    <c:if test="${not empty cv.linkUrl}">
                                        <c:set var="socialAccounts" value="${fn:split(cv.linkUrl, '|')}" />
                                        <c:forEach var="socialAccount" items="${socialAccounts}" varStatus="loop">
                                            <c:set var="iconClass">
                                                <c:choose>
                                                    <c:when test="${loop.index == 0}">bi-youtube</c:when>
                                                    <c:when test="${loop.index == 2}">bi-twitter-x</c:when>
                                                    <c:when test="${loop.index == 1}">bi-facebook</c:when>
                                                    <c:when test="${loop.index == 3}">bi-linkedin</c:when>
                                                    <c:otherwise>bi-link</c:otherwise> 
                                                </c:choose>
                                            </c:set>
                                            <a href="<c:out value="${socialAccount}" />" class="d-inline-block bg-dark link-light lh-1 p-2 rounded">
                                                <i class="bi <c:out value="${iconClass}" />"></i>
                                            </a>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        
                        
                                
                        <div class="col-12">
                            <div class="card widget-card border-light shadow-sm">
                                <div class="card-header text-bg-primary">About Me</div>
                                <div class="card-body">
                                    <ul class="list-group list-group-flush mb-0">
                                        <li class="list-group-item">
                                            <h6 class="mb-1">
                                                <span class="bii bi-mortarboard-fill me-2"></span>
                                                Education
                                            </h6>
                                            <span><c:out value="${cv.education}" /></span>
                                        </li>
                                        <li class="list-group-item">
                                            <h6 class="mb-1">
                                                <span class="bii bi-geo-alt-fill me-2"></span>
                                                Location
                                            </h6>
                                            <span><c:out value="${user.cityName}" /></span>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                                
                        <!-- Phân tách skill b?ng d?u , -->
                        <div class="col-12">
                            <div class="card widget-card border-light shadow-sm">
                                <div class="card-header text-bg-primary">Skills</div>
                                <div class="card-body">
                                    <c:if test="${not empty cv.skills}">
                                        <c:set var="skillList" value="${fn:split(cv.skills, ',')}" />
                                        <c:forEach var="skill" items="${skillList}">
                                            <span class="badge text-bg-primary"><c:out value="${skill}" /></span>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                                        
                                        
                <div class="col-12 col-lg-8 col-xl-9">
                    <div class="card widget-card border-light shadow-sm">
                        <div class="card-body p-4">
                            <ul class="nav nav-tabs" id="profileTab" role="tablist">
                                <li class="nav-item" role="presentation">
                                    <button class="nav-link active" id="overview-tab" data-bs-toggle="tab" data-bs-target="#overview-tab-pane" type="button" role="tab" aria-controls="overview-tab-pane" aria-selected="true">Overview</button>
                                </li>
                               
                            </ul>
                            <div class="tab-content pt-4" id="profileTabContent">
                                <div class="tab-pane fade show active" id="overview-tab-pane" role="tabpanel" aria-labelledby="overview-tab" tabindex="0">
                                    <h5 class="mb-3">Description</h5>
                                    <p class="lead mb-3"><c:out value="${cv.description}" /></p>
                                    <h5 class="mb-3">Profile</h5>
                                    <div class="row g-0">
                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Experience</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2"><c:out value="${cv.experience}" /></div>
                                        </div>
                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Education</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2"><c:out value="${cv.education}" /></div>
                                        </div>
                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Address</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2"><c:out value="${user.cityName}" /></div>
                                        </div>
                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Phone</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2">(+84)<c:out value="${user.phoneNumber}" /></div>
                                        </div>
                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Email</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2"><c:out value="${user.email}" /></div>
                                        </div>
                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Date of Birth</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2"><c:out value="${user.date}" /></div>
                                        </div>
                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Certification</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2"><c:out value="${cv.certification}" /></div>
                                        </div>
<!--                                        <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">CV Image</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2">
                                                 <div class="cv-image-wrapper">
                                                    <img src="assets/images/<c:out value="${cv.avatar}" />" class="img-fluid" alt="CV Image">  
                                                 </div>
                                            </div>
                                        </div>-->

                                         <div class="col-5 col-md-3 bg-light border-bottom border-white border-3">
                                            <div class="p-2">Link pdf</div>
                                        </div>
                                        <div class="col-7 col-md-9 bg-light border-start border-bottom border-white border-3">
                                            <div class="p-2"><c:out value="${cv.linkPdf}" /></div>
                                        </div>
                                    </div>
                                                 
                                   
                                    
<!--                                    <div class="container mt-3">
                                        <a href="javascript:void(0);" onclick="savePDF()" class="btn btn-primary" download="cv.pdf">Download CV</a>
                                     </div>  -->


                                    <div class="container mt-3">
                                        <a href="./assets/pdf/<c:out value="${cv.linkPdf}" />" download="filename.pdf" class="btn btn-primary">Download CV</a>                                
                                    </div>   
                                                                              
                                </div>
                                                        
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="inner-content">
                        <p>Copyright © 2024 - Summer 2024 FPTU SWP</p>
                    </div>
                </div>
            </div>
        </div>
    </footer>

                                                
 

    <!-- Bootstrap core JavaScript -->
    <script src="https://unpkg.com/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
