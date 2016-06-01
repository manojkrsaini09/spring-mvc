weatherForecast.service('cityService',function($http){
  this.city = "Jaipur";
});


weatherForecast.factory('dataservice',['$resource','$http','$q',function($resource,$http,$q){
	 
	return{
		getData : getData
	};
	
	function getData(){
		return $http({
			method: 'GET',
			url: '/abc'
		}).then(sendResponseData)
		.catch(sendError);
	  } 
	  
	  function sendResponseData(response){
		  console.log(response);
		 return response.data;
	  }
	  
	  function sendError(response){
		  return $q.reject('Error :' + response);
	  }
}]);

