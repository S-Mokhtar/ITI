<?php
$id=$_GET["glass"];
if($table->where('id',$id)->exists()){
    $glass=$table->where('id',$id)->first();
}else{
    die("Glass is not exist");
}
?>
<html>
    <h5> name: <?php echo $glass->product_name; ?> </h5>
    <h5> country: <?php echo $glass->CouNtry; ?> </h5>
    <h5> image: <img src="Resources/images/<?php echo $glass->Photo; ?>"/> </h5>
</html>