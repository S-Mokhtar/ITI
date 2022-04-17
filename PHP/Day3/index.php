<?php
require_once("vendor/autoload.php");
session_start();
if(!isset($_SESSION["is_counted"])){
    counter::increase();
    $_SESSION["is_counted"]=true;
}
$times = file("counter.txt");
echo $times[0];
?>