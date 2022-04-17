<?php

echo "<table border='1'>";
$record_index = 0;
foreach ($all as $item) {
    if ($record_index === 0) {
        echo "<tr>";
        echo "<td> Name </td>";
        echo "<td> Price </td>";
        echo "<td> Country </td>";
        echo "<td> Image </td>";
        echo "<td> Visit </td>";
        echo "</tr>";
    }
    echo "<tr>";
        $image=explode(".",$item->Photo);
        $image=$image[0]."tz".".png";
        $current_url=(isset($_SERVER['HTTPS']) && $_SERVER['HTTPS']==='on' ? "https" : "http") . "://$_SERVER[HTTP_HOST]$_SERVER[REQUEST_URI]";
        $current_url=explode("?",$current_url);
        $details=$current_url[0]."?glass=".$item->id;
        //$details=$_SERVER["PHP_SELF"];
        echo "<td>".$item->product_name ."</td>";
        echo "<td>".$item->list_price ."</td>";
        echo "<td>".$item->CouNtry ."</td>";
        echo "<td><img src='Resources/images/".$image."'></td>";
        echo "<td><a href='".$details."'>Click to visit </a> </td>";
    echo "</tr>";

    $record_index ++;
}
echo "</table>";
?>




