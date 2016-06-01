// Module

var weatherForecast = angular.module('weatherForecast',['ngRoute','ngResource']);

// Routes

/* weatherForecast.config(function($routeProvider){
     $routeProvider.when('/',{
       templateUrl: 'views/home.html',
       controller: 'homeController'
     })
     .when('/forecast',{
       templateUrl: 'views/forecast.html',
       controller: 'forecastController'
     })
 });*/



// Services

/*weatherForecast.service('cityService',function(){
  this.city = "Jaipur";
});*/

// Controller

/*weatherForecast.controller('homeController',['$scope','cityService',function($scope,cityService){
        $scope.city =  cityService.city;
        $scope.$watch('city',function(){
          cityService.city = $scope.city;
        });

}]);

weatherForecast.controller('forecastController',['$scope','$resource','cityService',function($scope,$resource,cityService){
   $scope.city =  cityService.city;
   //$scope.weatherApi = $resource("api.openweathermap.org/data/2.5/forecast/daily",{callback: "JSON_CALLBACK"},{get:{method:"JSONP"}});
  //$scope.weatherResult =  $scope.weatherApi.get({q:$scope.city,cnt:2,APPID:'a456867155f87365fe56f516fb229d68'});
  //console.log($scope.weatherResult);
}]);*/
