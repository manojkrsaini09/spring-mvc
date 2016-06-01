<html ng-app="weatherForecast">
<head>
<meta name="google-signin-client_id" content="934485207812-icpbadbimtb712k6cgl7bcggi381en07.apps.googleusercontent.com">
  <title>Angular Tutorial </title>
  <script src="/resources/static/lib/jquery.min.js"></script>
  <script src="/resources/static/bootstrap/js/bootstrap.min.js"></script>
  <script src="/resources/static/lib/angular.min.js"> </script>
  <script src="/resources/static/lib/angular-resource.min.js"> </script>
  <script src="/resources/static/lib/angular-route.min.js"> </script>
  <script src="/resources/static/js/app.js"> </script>
  <script src="/resources/static/js/routes.js"> </script>
  <script src="/resources/static/js/services.js"> </script>
   <script src="/resources/static/controller/controllers.js"> </script>

  <link rel="stylesheet" href="/resources/static/bootstrap/css/bootstrap.min.css"/>
   <script src="https://apis.google.com/js/platform.js" async defer></script>
   
   <script>
   gapi.load('oauth2', function () {
	   gapi.auth2.init();
   });
   
   
   function onSignIn(googleUser) {
	   var profile = googleUser.getBasicProfile();
	   console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	   console.log('Name: ' + profile.getName());
	   console.log('Image URL: ' + profile.getImageUrl());
	   console.log('Email: ' + profile.getEmail());
	 }
 
 
  
     function signOut() {
       var auth2 = gapi.auth2.getAuthInstance();
       auth2.signOut().then(function () {
         console.log('User signed out.');
       });
     }
  

   
   </script>
</head>
<body>

     <nav class="navbar navbar-default">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="#">Angular Js</a>
        </div>
        <div class="navbar-header navbar-right">
          <a class="navbar-brand" href="#/">Home</a>
        </div>
        <div class="navbar-header navbar-right">
          <!-- <a class="navbar-brand" href="/logout">Logout</a> -->
           <a href="#" onclick="signOut();">Sign out</a>
        </div>
      </div>
      
        <div class="g-signin2" data-onsuccess="onSignIn"></div>
        
   </nav>
    <div class="container">
       <div ng-view> </div>
    </div>

  </body>
  </html>
