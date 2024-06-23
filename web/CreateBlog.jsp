<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html><html class="menu">
    <html>

        <head>

            <meta charset="utf-8"/>
            <meta http-equiv="X-UA-Compatible" content=="IE=edge"/>
            <meta name="google" value="notranslate"/>
            <title>Side Menu</title>

            <link rel="stylesheet" type="text/css" href="./assets/css/empui.css">

            <link rel="stylesheet" type="text/css" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">

            <link rel="icon" href="assets/images/favicon.ico">
            <link rel="stylesheet" href="assets/css/icontop1.css">

            <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">
            <title>Easyjob | Free Job For Everyone</title>
            <!-- Bootstrap core CSS -->
            <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
            <!-- Additional CSS Files -->
            <link rel="stylesheet" href="assets/css/fontawesome.css">
            <link rel="stylesheet" href="assets/css/owl.css">
            <link rel="stylesheet" href="assets/css/button.css">
            <link rel="stylesheet" href="assets/css/styles.css">

            <link rel="stylesheet" href="assets/css/icontop.css">
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">

        </head>

        <body>
            <div class=" container-fluid ">

                <div class=" banners text-center ">      
                    <h1>Create Blog </h1>
                </div> 
            </div> 

            <!-- banner end -->
            <!-- Form start -->

            <form class="user-form container" action="addblog" method="get" enctype="multipart/form-data">
                <label class="form-label">Title blogs</label>
                <div class="input-group mb-3">
                    <input value="" name="title" type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>

                <div class="mt-3 mb-3">
                    <label class="form-label">Your Blogs Description</label>
                    <textarea class="form-control" name="content" rows="5"></textarea>
                </div>

                <div class="mt-3 input-group mb-3">

                    <div class="mt-3 input-group mb-3">
                        <div class="container">
                            
                            <div class="row">
                                <input type="file" class="form-control mt-2 col-9" name="image" id="fileInputBlogImage" aria-describedby="inputGroupFileAddon03" aria-label="Upload">
                                
                            </div>
                        </div>
                    </div>



                    <div class="mt-2 d-grid gap-2">
                        <button type="submit" class="btn btn-warning btn-block">Create</button>
                    </div>
            </form>









            <!-- Bootstrap core JavaScript -->
            <script src="vendor/jquery/jquery.min.js"></script>
            <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>


            <!-- Additional Scripts -->
            <script src="assets/js/custom.js"></script>
            <script src="assets/js/owl.js"></script>

            <script>
             

                document.getElementById('fileInputBlogImage').addEventListener('change', function () {
                    var formData = new FormData();
                    formData.append('file', this.files[0]);

                    var xhr = new XMLHttpRequest();
                    xhr.open('POST', 'uploadBlogImage', true);
                    xhr.onload = function () {
                        if (xhr.status === 200) {
                            var response = JSON.parse(xhr.responseText);
                            var fileName = response.fileName;
                            var oldimg = document.getElementById('oldimg');
                            oldimg.src = 'assets/blog/' + fileName;
                            console.log(fileName);
                        }
                    };
                    xhr.send(formData);
                });
            </script>
        </body>
    </html>
