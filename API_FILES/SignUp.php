<?php
namespace user;
	include_once('user/Authentication.php');
	include_once('user/User.php');

	
	$auth = new Authentication();

	$auth->prepare($_POST);
	$userexits = $auth->isUserExisted();

	if (!$userexits){
		$user = new \user\User();
		$user->prepare($_POST);
		$user->insertNewUserIntoDB();
	}else{
		$json['success'] = 0;
		$json['message'] = 'user exists';

		echo json_encode($json);
	}
?>