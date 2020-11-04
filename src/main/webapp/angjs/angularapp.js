var app = angular.module('prepup', []);
//===========================================Base URL Declaration========================================
//=================================================Start=================================================
const baseurl="http://localhost:8082/rest";
//=================================================End=================================================
//=================================================End=================================================



//===========================================Login Controller===========================================
//=================================================Start=================================================

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
	                	} 
					else 
						{						
	                    location.replace("studentdash.html");						
	                	}				
				}
				else
				{						
					$scope.message= resp.data.message;					
				}
            }, function error(resp) {
    			});
    };
});
//=================================================End=================================================
//=================================================End=================================================



//=========================================Registration Controller=======================================
//											To Register New Users
//=================================================Start=================================================
app.controller('RegistrationController', function ($scope, $http ) {

   $scope.postData = function() {
		
		const body1={
				"fname":$scope.fname,"mname":$scope.mname,"lname":$scope.lname,
				"phone":$scope.phone,"email":$scope.email,"password":$scope.password,
				"institute":$scope.institute,"role":$scope.role,
					}

       $http.post(baseurl+"/registration",body1)
            .then(function(resp) {

               const status_code_r = resp.data.status_code;

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
    			});
    };
});
//=================================================End=================================================
//=================================================End=================================================



//===========================================Update Controller===========================================
//									 To Update Details of existing Users
//=================================================Start=================================================
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
	                	} 
					else 
						{		
							alert("Update Success");					
	                    	location.replace("studentdash.html");						
	                	}	
				}
				else
				{						
					$scope.message= resp.data.message;
					alert("Updation failed");
				}
            }, function error(resp) {
    
    				});
    };
});
//=================================================End=================================================
//=================================================End=================================================




//========================================Change Password Controller=====================================
//									 To Change Password of existing Users
//=================================================Start=================================================
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
		
      		 $http.post(baseurl+"/changepass",body2)
            .then(function(resp) {
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
//=================================================End=================================================
//=================================================End=================================================




//=========================================Create Class Controller=======================================
//									 		To Create a new Class
//=================================================Start=================================================
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
//=================================================End=================================================
//=================================================End=================================================



//========================================Teacher Classes Controller=====================================
//									 To Show the classes Created by a teacher
//=================================================Start=================================================

app.controller('TeacherClasses', function ($scope, $http) {
	string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.userid=obj.userid;		
			const body2={  
				"teacherId":$scope.userid 
					} 		
						
		 $http.post(baseurl+"/findclassbyteacherid",body2)
            .then(function(resp) {
				$scope.obj=resp.data;

            }, function error(resp) {    
   					 });	
		$scope.postData = function(classs) {

    	$scope.classid=classs.classId;

    	sessionStorage.setItem("classID",$scope.classid);

		location.replace("teacherclassdetails.html")
  };
});
//=================================================End=================================================
//=================================================End=================================================




//=========================================Create Exam Controller========================================
//									     To Create new Exam for a class
//=================================================Start=================================================
app.controller('CreateExam', function ($scope, $http) {
	
	
			string=sessionStorage.getItem("userDetails");
			var obj =JSON.parse(string);
			$scope.username=obj.fname +" "+ obj.lname;	
			
			string=sessionStorage.getItem("classID");
			$scope.classId =string;
				
				$scope.postData = function() {	
					const body2={			
						"eName":$scope.examname,"classId":$scope.classId,"date":$scope.examdate,
						"duration" :$scope.examduration,"instruction":$scope.examdsc	 
								}
			
			$http.post(baseurl+"/createexam",body2)
            .then(function(resp) {
                
				const status_code = resp.data.examId;
				sessionStorage.setItem("examid",status_code);
				if(status_code !==null)				
				{	
					alert("Class Creation Success");
					location.replace("addquestions.html")
				}
				else
				{						
					$scope.message= resp.data.message;
					alert("Class Creation Failed");
				}
               
            }, function error(resp) {
    
    			});
    };		
});
//=================================================End=================================================
//=================================================End=================================================



//========================================Add Question Controller========================================
//								To Add Questions To a Exam Create By the Teacher
//=================================================Start=================================================
app.controller('Addquestion', function ($scope, $http) {
	
	
		string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.username=obj.fname +" "+ obj.lname;	
		
			string=sessionStorage.getItem("examid");
			$scope.examid =string;		
					
				 var a=[];
				$scope.a=[];
				
				$scope.addquestion=function(){					 
					const obj={
							"question":$scope.question,"optionA":$scope.opt1,"optionB":$scope.opt2,
							"optionC":$scope.opt3,"optionD":$scope.opt4,"answer":$scope.crtans
								}
					a.push(obj);
					
					sessionStorage.setItem("examquestion",JSON.stringify(a));
					
					};
					
				$scope.postData = function() {	
					
					$scope.addquestion();
					
					a=JSON.parse(sessionStorage.getItem("examquestion"));
					const body2={
						"eCode":$scope.examid,
						"questions":a
							}	
					 $http.post(baseurl+"/addquestions",body2)
           			 .then(function(resp) {
               
		               const status_code = resp.data.status_code;
						if(status_code==200)				
						{	
							alert(resp.data.message);
							location.replace("teacherdash.html")
							
							sessionStorage.removeItem("examquestion");
							sessionStorage.removeItem("examid");
							sessionStorage.removeItem("classID");
						}
						else
						{						
							$scope.message= resp.data.message;
						}
		            }, function error(resp) {
		    
		   				 });
	 }

});
//=================================================End=================================================
//=================================================End=================================================




//====================================Teacher Class Details Controller===================================
//					To Show all The required details of the class created by the teacher
//=================================================Start=================================================
app.controller('TeacherClassesDetails', function ($scope, $http) {
	
	
			string=sessionStorage.getItem("userDetails");
			var obj =JSON.parse(string);
			$scope.username=obj.fname +" "+ obj.lname;	

			$scope.classId=sessionStorage.getItem("classID");
	
			const body2={  "classId":$scope.classId } 
	
		 	$http.post(baseurl+"/findclassbyclassid",body2)
            .then(function(resp) {
				$scope.obj1=resp.data;
				sessionStorage.setItem("classdetails", $scope.obj1)		

            }, function error(resp) {    
   			 });	

		$scope.postData = function(classs) {
		    	$scope.classid=classs.classId;

		    	sessionStorage.setItem("classID",$scope.classid);
				
				location.replace("teacherclassdetails.html")
  };
});
//=================================================End=================================================
//=================================================End=================================================



//========================================Reset Password Controller======================================
//							To Reset the forgotten Password of Existing User
//=================================================Start=================================================
app.controller('ResetPassController', function ($scope, $http) {

    $scope.postData = function() {
		const body={
				"emailid":$scope.email
					}
			alert("Please Wait !!!!!");
       		$http.post(baseurl+"/resetpassword",body)
            .then(function(resp) {
               
               const status_code = resp.data.status_code;
				if(status_code==200)				
				{	
					alert(resp.data.message)
					location.replace("login.html");
				}
				else
				{						
					$scope.message= resp.data.message;					
				}
            }, function error(resp) {
				alert("Sending protocol failed");
				location.replace("resetpass.html");
   					 });
    };
});
//=================================================End=================================================
//=================================================End=================================================



//==========================================View User Controller=========================================
//								To Show the user details in required the pages
//=================================================Start=================================================
app.controller('ViewUser', function ($scope) {
	
		string=sessionStorage.getItem("userDetails");
		var obj =JSON.parse(string);
		$scope.user = obj.fname;
		$scope.emailid=obj.emailid;
		
});
//=================================================End=================================================
//=================================================End=================================================



//===========================================Logout Controller===========================================
//									   To logout and Session clear
//=================================================Start=================================================
app.controller('logout', function ($scope) {
		  $scope.postData = function() {	
					
				sessionStorage.clear();
				string=sessionStorage.getItem("userDetails");
				location.replace("login.html");

    };
});
//=================================================End=================================================


		