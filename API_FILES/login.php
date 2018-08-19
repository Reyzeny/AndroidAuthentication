<?php
	include_once('user/Authentication.php');
	use user\Authentication;

	$auth = new Authentication();
	$auth->prepare($_POST);
	$userstatus = $auth->isUserValidToLogin();

	if ($userstatus){
		$json['success'] = 1;
		$json['message'] = 'user successfully logged';

		echo json_encode($json);
	}else{
		$json['success'] = 0;
		$json['message'] = 'Wrong email or password';

		echo json_encode($json);
	}
?>