weatherForecast.controller('homeController',['$scope','$location','cityService',function($scope,$location,cityService){
        $scope.city =  cityService.city;
        $scope.$watch('city',function(){
          cityService.city = $scope.city;
        });
        
        $scope.submit = function(){
        	$location.path("/forecast");
        }
        
        $scope.logout = function(){
        	$location.path = "/logout";
        }

}]);

weatherForecast.controller('forecastController',['$scope','$resource','cityService','dataservice',function($scope,$resource,cityService,dataservice){
   $scope.city =  cityService.city;
   
   /* dataservice.getData().then(getSuccess).catch(getError);
    
    function getSuccess(response){
    	console.log(response);
    }
    
    function getError(response){
    	console.log(response);
    	//console.log("Error code:"+response.status);
    }*/
  console.log($scope.data);
// console.log("data"+$scope.data);
   //$scope.weatherApi = $resource("api.openweathermap.org/data/2.5/forecast/daily",{callback: "JSON_CALLBACK"},{get:{method:"JSONP"}});
  //$scope.weatherResult =  $scope.weatherApi.get({q:$scope.city,cnt:2,APPID:'a456867155f87365fe56f516fb229d68'});
  //console.log($scope.weatherResult);
}]);