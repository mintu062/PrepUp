var app = angular.module('prepup', []);

const baseurl="http://localhost:8082/rest";

app.controller('LoginController', function ($scope, $http,userService) {

    $scope.postData = function() {
		
		const body={
	"email":$scope.email,
	"password":$scope.password
}
	
       $http.post(baseurl+"/login",body)
            .then(function(resp) {
                /*$scope.token = resp.data.token;*/
               const status_code = resp.data.status_code;
			   const role =	resp.data.userDetails.role;
				
					
				if(status_code==200)				
				{	
					userService.setData(resp.data.userDetails.emailid);
					alert(resp.data.userDetails.emailid);
					
					if (role == "teacher") 
						{
	                    location.replace("teacherdash.html");
	                } else 
						{
						
	                    location.replace("studentdash.html");
	                }
				}
				else
				{
					$scope.message= resp.data.message;
					
				}
				
     
            }, function error(resp) {
		alert(message);
      /*$scope.error = 'Invalid credentials!!!';*/
    });
    };
});

app.controller('RegistrationController', function ($scope, $http) {

    $scope.postData = function() {
	
	
	};
});

app.controller('TeacherDash', function ($scope, $http,$rootScope,userService) {

    $rootScope.$on("userevent",function(){
		var t=userService.getData();
		alert(t);
		$scope.email=t;
	});
});

app.service("userService",function($rootScope){
	this.email="";
	
	this.setData = function(d){
		this.email=d;
		
		$rootScope.$emit("userevent");
	}
	this.getData = function(){
		return this.email;
	}
});
		