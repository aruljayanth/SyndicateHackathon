<?php
ob_start();
include_once 'db-con.php';

$handle = fopen('php://input','r');
$jsonInput = fgets($handle);
$params = json_decode($jsonInput,true);



$sno = isset($params['sno'])?(int)$params['sno']:'';
$conn = new mysqli("localhost","id10748696_akash","sachin","id10748696_bank_queue");
    if($conn->connect_error)
    die("not connected:".$conn->connect_error);
$counter="SELECT service from details where token_no='$sno'";
$result=$conn->query($counter);
$row=$result->fetch_assoc();
$counter_no=0;
switch ($row["service"]) {
	case 'Create An Account':
	$counter_no=1;
		# code...
		break;
		case 'Withdraw':
		$counter_no=2;
		break;
		case 'Demand Draft':
		$counter_no=3;
		break;
		case 'Deposit':
		$counter_no=4;
			
			break;
	
	
}

date_default_timezone_set("Asia/Kolkata");
//echo "The time is " . date("h:i:sa");
$time=date("H:i:s");

$sql="INSERT into current values ('$sno','$counter_no','$time')";
if(mysqli_query($conn, $sql))
    {
    	echo "recorded";
}
else
echo $conn->error;
mysqli_close($conn);
ob_flush();
?> 


