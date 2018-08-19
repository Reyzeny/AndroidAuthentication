<?php

namespace user;

class User{

	private $NAME;
	private $EMAIL;
	private $PASSWORD;

	private $DB_CONNECTION;
	private $servername = "";           //add ur local host ip
    	private $username = "";         //add your username
    	private $password = "";         //add your password
    	private $dbname = "";           //add your database name

	function __construct(){
		$this->DB_CONNECTION = mysqli_connect($this->servername, $this->username, $this->password, $this->dbname);
	}


	function prepare($data){
		if (array_key_exists('name', $data)){
			$this->NAME = $data['name'];
		}
		if (array_key_exists('email', $data)){
			$this->EMAIL = $data['email'];
		}
		if (array_key_exists('password', $data)){
			$this->PASSWORD = $data['password'];
		}
	}


	function insertNewUserIntoDB(){
		$sql = "INSERT INTO users(email, password, fullname) values('$this->EMAIL', '$this->PASSWORD', '$this->NAME')";

		$result = mysqli_query($this->DB_CONNECTION, $sql);
		if($result){
			$json['success'] = 1;
			$json['message'] = 'Successful';
			echo json_encode($json);
		}else{
			$json['success'] = 0 ;
			$json['message'] = 'was not Successful';

			echo json_encode($json);
		}
	}





}
?>