<?php
$data=array();
if(isset($_POST["submit"])){
    foreach($_POST as $key=>$value){
		if(empty($value))
            $data[] = "$key is required!";
	}
    $name=$_POST["name"];
    if(strlen($_POST["name"])>100){
        $data[]="Invalid name";
    }
    $email=$_POST["email"];
    if(!empty($email)){
        if(empty($email)||!filter_var($email,FILTER_VALIDATE_EMAIL)){
            $data[]="Invalid email";
        }
}
    $message=$_POST["message"];
    if(strlen($_POST["message"])>255){
        $data[]="Invalid message";
    }
    if(empty($data)){
        echo "<br/><center>Thank you for submitting the form!</center>";
		foreach($_POST as $key=>$value){
			if($key != "submit") 
                echo "<br/>$key: $value";
		}
	}
}
function remember($field){
    if(isset($_POST[$field])){
		echo $_POST[$field];
	}else{
		echo "";
	}
}

$fp = fopen("anotherlog.txt","a+");
$date = date( 'F j, Y, g:i a');
$result = str_replace(',', '', $date);
$ip_add = isset($_SERVER['REMOTE_ADDR'])?$_SERVER['REMOTE_ADDR']:"there is no ip address";
$email = isset($_POST["email"])?$_POST["email"]:"No email sent";
$name = isset($_POST["name"])?$_POST["name"]:"No name sent";
$entries = array("Visit Date: ","Visit Date"=>$result,"\n","IP Address: ","IP Address"=>$ip_add,"\n","Email: ","Email"=>$email,"\n","Name: ","Name"=>$name,"\n");
$final_result= implode("",$entries);
fwrite($fp, print_r($final_result, true));
fclose($fp);

$fp1 = fopen("log.txt","a+");
$date1 = date( 'F j, Y, g:i a');
$result1 = str_replace(',', '', $date1);
$ip_add1 = isset($_SERVER['REMOTE_ADDR'])?$_SERVER['REMOTE_ADDR']:"there is no ip address";
$email1 = isset($_POST["email"])?$_POST["email"]:"No email sent";
$name1 = isset($_POST["name"])?$_POST["name"]:"No name sent";
$entries1 = array("Visit Date"=>$result1,"IP Address"=>$ip_add1,"Email"=>$email1,"Name"=>$name1,"\n");
$final_result1 = implode(",",$entries1);
fwrite($fp1, print_r($final_result1, true));
fclose($fp1);
?>
<html>
    <head>
        <title> Contact Form </title>
    </head>

    <body>
        <h3> Contact Form </h3>
        <div id="after_submit">
            <?php
                foreach($data as $line){
                    echo "** $line <br/>";
                }
            ?>
        </div>
        <form id="contact_form" action="#" method="POST" enctype="multipart/form-data">

            <div class="row">
                <label class="required" for="name">Your name:</label><br />
                <input id="name" class="input" name="name" type="text" value="<?php  remember("name");   ?>" size="30" /><br />

            </div>
            <div class="row">
                <label class="required" for="email">Your email:</label><br />
                <input id="email" class="input" name="email" type="text" value="<?php  remember("email");   ?>" size="30" /><br />

            </div>
            <div class="row">
                <label class="required" for="message">Your message:</label><br />
                <textarea id="message" class="input" name="message" rows="7" cols="30"></textarea><br />

            </div>

            <input id="submit" name="submit" type="submit" value="Send Email" />
            <input id="clear" name="clear" type="reset" value="Clear Form" />

        </form>
    </body>

</html>