var app = angular.module('prepup', []);

const baseurl="http://localhost:8082/rest";
var temp;

app.controller('LoginController', function ($scope, $http) {

    $scope.postData = function() {
		const body={
	"email":$scope.email,
	"password":$scope.password
}
       $http.post(baseurl+"/login",body)
            .then(function(resp) {
                /*$scope.token = resp.data.token;*/
               const status_code = resp.data.status_code;
				if(status_code==200)				
				{	
					const rolee =	resp.data.userDetails.role;
					
					sessionStorage.setItem("userDetails", JSON.stringify(resp.data.userDetails));					
					if (rolee == "Teacher") 
						{						
	                    location.replace("teacherdash.html");						
	                } else 
						{						
	                    location.replace("studentdash.html");						
	                }				}
				else
				{						
					$scope.message= resp.data.message;					
				}
            }, function error(resp) {
    });
    };
});

app.controller('RegistrationController', function ($scope, $http ) {

   $scope.postData = function() {
		
		const body1={
			"fname":$scope.fname,"mname":$scope.mname,"lname":$scope.lname,"phone":$scope.phone,
	"email":$scope.email,
	"password":$scope.password,"institute":$scope.institute,"role":$scope.role,
}
/*	alert(JSON.stringify(body1));*/
       $http.post(baseurl+"/registration",body1)
            .then(function(resp) {
                /*$scope.token = resp.data.token;*/
               const status_code_r = resp.data.status_code;
			  // const role =	resp.data.userDetails.role;
				
					
				if(status_code_r==200)				
				{	
					alert("success");
					window.location.reload();
					$scope.message1= resp.data.message;
				}
				else
				{
					alert(resp.data.message+", User with given credentials already exists");
					window.location.reload();
					$scope.message= resp.data.message;					
				}
				
     
            }, function error(resp) {
		alert("Server Not Connected");
      /*$scope.error = 'Invalid credentials!!!';*/
    });
    };
});


app.controller('UpdateController', function ($scope, $http ) {
string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.fname = obj.fname;
		$scope.mname = obj.mname;
		$scope.lname = obj.lname;
		$scope.phone =  parseInt(obj.phnumber);
		$scope.institute = obj.instname;
		$scope.email=obj.emailid;
		
  $scope.postData = function() {		
		const body2={
			"fname":$scope.fname,"mname":$scope.mname,"lname":$scope.lname,"phone":$scope.phone,
	"email":$scope.email,
	"institute":$scope.institute
} 



       $http.post(baseurl+"/profileupdate",body2)
            .then(function(resp) {
                /*$scope.token = resp.data.token;*/
               const status_code = resp.data.status_code;
				if(status_code==200)				
				{	
				
				const rolee =	obj.role;
									
					if (rolee == "teacher") 
						{			
						alert("Update Success");			
	                    location.replace("teacherdash.html");
	                    sessionStorage.setItem("userDetails", JSON.stringify(resp.data.userDetails));
	                } else 
						{		
							alert("Update Success");					
	                    location.replace("studentdash.html");						
	                }			}
				else
				{						
					$scope.message= resp.data.message;
										alert("Updation failed");
				}
            }, function error(resp) {
    
    });
	console.log(JSON.stringify(body2));
    };
});


app.controller('ChangepassController', function ($scope, $http ) {

string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.user = obj.fname;
		$scope.emailid=obj.emailid;
		
  $scope.postData = function() {		
		const body2={			
	"emaiId":$scope.emailid,"oldPass":$scope.oldPass,
	"newPass":$scope.newPass
} 
		console.log(JSON.stringify(body2));
       $http.post(baseurl+"/changepass",body2)
            .then(function(resp) {
                /*$scope.token = resp.data.token;*/
               const status_code = resp.data.status_code;
				if(status_code==200)				
				{	
					alert("success");
					sessionStorage.clear();
					location.replace("login.html")
					
				}
				else
				{						
					$scope.message= resp.data.message;
				}
            }, function error(resp) {
    
    });

    };

});

app.controller('CreateClass', function ($scope, $http) {
	string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.userid=obj.userid;
		

		$scope.postData = function() {	
					const body2={			
	"className":$scope.className,"classDesc":$scope.classDesc,
	"teacherId":$scope.userid
} 
		 $http.post(baseurl+"/createclass",body2)
            .then(function(resp) {
                /*$scope.token = resp.data.token;*/
				const status_code = resp.data.status_code;
				if(status_code==200)				
				{	
					alert("Class Creation Success");
					window.location.reload();
					
				}
				else
				{						
					$scope.message= resp.data.message;
					alert("Class Creation Failed")
				}
               
            }, function error(resp) {
    
    });
    };

	
		
});


app.controller('TeacherClasses', function ($scope, $http) {
	string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.userid=obj.userid;		
			const body2={  "teacherId":$scope.userid } 
			/*	console.log(JSON.stringify(body2));	*/			
		 $http.post(baseurl+"/findclassbyteacherid",body2)
            .then(function(resp) {
				$scope.obj=resp.data;
				/*console.log($scope.obj);*/


            }, function error(resp) {    
    });	
		$scope.postData = function(classs) {

    	$scope.classid=classs.classId;
		/*console.log($scope.classid);*/
    	sessionStorage.setItem("classID",$scope.classid);
		/*console.log(sessionStorage.getItem("classID"));*/
  };
});





app.controller('ViewUser', function ($scope) {
	
		string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.user = obj.fname;
		$scope.emailid=obj.emailid;
		
});

app.controller('logout', function ($scope) {
	
		

		  $scope.postData = function() {	
					
				sessionStorage.clear();
				string=sessionStorage.getItem("userDetails");
				console.log(string);
				location.replace("login.html");

    };
});



		