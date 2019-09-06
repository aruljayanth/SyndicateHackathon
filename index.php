<?php 
session_start();
ob_start();
static $token_no=0;
$name=$_GET["name"];
$phone=$_GET["phone"];
$email=$_GET["email"];
$service=$_GET["service"];
$year=$_GET["year"];
$month=$_GET["month"];
$day=$_GET["day"];
$hour=$_GET["hour"];
$minute=$_GET["minute"];
$date=$year."-".$month."-".$day;
$time=$hour.":".$minute;

$token_no++;
$conn = new mysqli("localhost","id10748696_akash","sachin","id10748696_bank_queue");
    if($conn->connect_error)
    die("not connected:".$conn->connect_error);

   $sql = "INSERT INTO details (name, phone, email, service, date, time) VALUES ('$name','$phone', '$email', '$service','$date','$time')";
    if(mysqli_query($conn, $sql))
    {

    	$sql="SELECT token_no from details where name='$name' and date='$date' and time='$time'";
    	$result=$conn->query($sql);
        $row=$result->fetch_assoc();
        $arr = array('tno'=>$row["token_no"]);
$json = json_encode($arr);
        echo $json;
    }

mysqli_close($conn);
ob_flush();
?> 

