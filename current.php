<?php
session_start();
ob_start();
$conn = new mysqli("localhost","id10748696_akash","sachin","id10748696_bank_queue");
    if($conn->connect_error)
    die("not connected:".$conn->connect_error);
if (isset($_POST['submit'])){

	//echo "<script>document.getElementById(\"current\").style.display = \"none\"</script>";
$counter_no = mysqli_real_escape_string($conn, $_REQUEST['counter_no']);
//echo $counter_no;
$sql = "SELECT  * from current where counterno='$counter_no'";
$result=$conn->query($sql);
$row=$result->fetch_assoc();
        //echo $row["sno"];
$sno=$row["sno"];
mysqli_close($conn);
//ob_flush();

header("Location:history.php?sno=$sno&cno=$counter_no");
}

?> 






<!DOCTYPE html>
<html>
<head>
	<title>Current Status</title>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab&display=swap" rel="stylesheet">
    <style>
        * {
            font-family: 'Roboto Slab', serif;
        }
    </style>
</head>
<body>
<div class="container" id="current">
		<h3 class="heading text-center" > Current Status of the Counters </h3>
		<hr size="20" width="75%" align="center" color="green">
		<label for="type" class="hello" ><strong>Enter the Counter Number :</strong></label>
		<form action="" method="POST">
		<div class="form-group">
			<select class="form-control" name="counter_no" id="sel1">
				<option value="" disabled selected>Choose</option>
        <option value="1">counter 1</option>
        <option value="2">counter 2</option>
        <option value="3">counter 3</option>
        <option value="4">counter 4</option>
      </select>
      <input type="submit" name="submit">
			</div>
		</form>
		</div>



</body>
</html>