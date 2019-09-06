<?php
ob_start();
$name=(int)$_GET["sno"];
$counter=(int)$_GET["cno"];
$conn = new mysqli("localhost","id10748696_akash","sachin","id10748696_bank_queue");
    if($conn->connect_error)
    die("not connected:".$conn->connect_error);
$sql="SELECT * from details where token_no='$name'";
    	$result=$conn->query($sql);
        $row=$result->fetch_assoc();
    
        echo $row["token_no"];
        echo "<br/>";
        echo $row["name"];
        echo "<br/>";
        echo $row["phone"];
        echo "<br/>";
        echo $row["email"];

 if (isset($_POST['end'])){

$sql="SELECT * from current where sno='$name'";
$result1=$conn->query($sql);
$row1=$result1->fetch_assoc();

//$cno=$row1["counterno"];
$date=$row["date"];
$timein=$row1["timein"];
date_default_timezone_set("Asia/Kolkata");
//echo "The time is " . date("H:i:sa");
$timeout=date("H:i:s");

echo $timeout;

$sql="INSERT into history values($name,$counter,'$date','$timein','$timeout')";
if ($conn->query($sql) === FALSE) 
         {
        echo "Error updating record: " . $conn->error;
    }
//mysqli_query($conn, $sql);
$sql="DELETE from current where sno='$name'";
$result=$conn->query($sql);

$sql = "SELECT  * from current where counterno='$counter'";
$result=$conn->query($sql);
$row=$result->fetch_assoc();
$sno=$row["sno"];

mysqli_close($conn);
ob_end_clean();
header("Location:history.php?sno=$sno&cno=$counter");
}

//ob_flush();
?> 
<html>
<form method="POST">
<input type="submit" name="end" value="end">
</form>
</html>