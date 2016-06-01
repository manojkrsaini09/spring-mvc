 weatherForecast.config(function($routeProvider){
     $routeProvider.when('/',{
       templateUrl: 'resources/static/views/home.html',
       controller: 'homeController'
     })
     .when('/forecast',{
       templateUrl: 'resources/static/views/forecast.html',
       controller: 'forecastController'
     })
 });