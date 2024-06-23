

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
    
     <style>
        #yellow-border{
            border: 2px solid orange;
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
                    <h2 class="mb-4 display-5 text-center">Create CV Profile</h2>
                    <p class="text-secondary text-center lead fs-4 mb-5">The Profile page is your digital hub, where you can fine-tune your experience. Here's a closer look at the settings you can expect to find in your profile page.</p>
                    <hr class="w-50 mx-auto mb-5 mb-xl-9 border-dark-subtle">
                </div>
            </div>
        </div>
        <div class="container">
            <form action="createCV" method="POST" class="row gy-3 gy-xxl-4">
                <div class="col-12">
                    <div class="row gy-2">
                        <p id="avatarImage"></p>
                        <div class="col-12">
                            <input type="file" id="fileInput" style="display: none;" name="linkPdf" />
                            <a href="#!" id="uploadButton" class="d-inline-block bg-primary link-light lh-1 p-2 rounded">
                                <i class="bi bi-upload"></i> Upload
                            </a>
                        </div>
                    </div>
                </div>

              
                <div class="col-12 col-md-6">
                    <label for="inputEducation" class="form-label">Education</label>
                    <input type="text" name="education" class="form-control" id="inputEducation" value="<c:out value="${cv.education}" />">
                </div>
                <div class="col-12 col-md-6">
                    <label for="inputSkills" class="form-label">Skills(Separate by comma)</label>
                    <input type="text" name="skills" class="form-control" id="inputSkills" value="<c:out value="${cv.skills}" />">
                </div>
                
                <div class="col-12 col-md-6">
                    <label for="inputExperience" class="form-label">Experience</label>
                    <input type="text" name="experience" class="form-control" id="inputExperience" value="<c:out value="${cv.experience}" />">
                </div>
                <div class="col-12 col-md-6">
                    <label for="inputCertification" class="form-label">Certification</label>
                    <input type="text" name="certification" class="form-control" id="inputCertification" value="<c:out value="${cv.certification}" />">
                </div>
                <div class="col-12">
                    <label for="inputAbout" class="form-label">Description</label>
                    <textarea name="description" class="form-control" id="inputAbout"><c:out value="${cv.description}" /></textarea>
                </div>

                <!-- Link phân cách b?i | -->
                <div id="yellow-border">
                   <br/>
                    <div class="col-12 col-md-6 yellow-border">
                        <label for="inputExperience" class="form-label">Link Youtube</label>
                        <input type="text" name="linkYoutube" class="form-control" id="inputExperience" />
                    </div>
                    <div class="col-12 col-md-6 yellow-border">
                        <label for="inputExperience" class="form-label">Link Twitter</label>
                        <input type="text" name="linkTwitter" class="form-control" id="inputExperience"  />
                    </div>
                    <div class="col-12 col-md-6 yellow-border">
                        <label for="inputExperience" class="form-label">Link Facebook</label>
                        <input type="text" name="linkFacebook" class="form-control" id="inputExperience"/>
                    </div>
                    <div class="col-12 col-md-6 yellow-border">
                        <label for="inputExperience" class="form-label">Link Linkedin</label>
                        <input type="text" name="linkLinkedin" class="form-control" id="inputExperience" />
                    </div>
                    <br/>
                </div>


                <div class="col-12">
                   <button type="submit" class="btn btn-primary">Create CV</button>
                </div>
            </form>
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

                                                
    <script>
    document.getElementById('uploadButton').addEventListener('click', function() {
        document.getElementById('fileInput').click();
    });

    document.getElementById('fileInput').addEventListener('change', function() {
        var formData = new FormData();
        formData.append('file', this.files[0]);

        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'upload', true);
        xhr.onload = function() {
            if (xhr.status === 200) {
                var response = JSON.parse(xhr.responseText);
                var fileName = response.fileName;
                var avatarImage = document.getElementById('avatarImage');
                avatarImage.innerText =  fileName; // Thay ??i src c?a hình ?nh avatarImage
                console.log(fileName);
            }
        };
        xhr.send(formData);
    });
</script>

    <!-- Bootstrap core JavaScript -->
    <script src="https://unpkg.com/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
