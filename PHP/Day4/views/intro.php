<?php
echo "<table border='1'>";
$record_index = 0;
foreach ($all as $item) {
    if ($record_index === 0) {
        echo "<tr>";
        foreach ($item as $key=>$value) {
            echo "<td> $key </td>";
        }
       
        echo "</tr>";
    } 
        echo "<tr>";
        foreach ($item as $value) {
            echo "<td>$value </td>";
        }
        echo "</tr>";
   
   $record_index ++;
}
echo "</table>";
?>
<div> 
    <a href="<?php echo $previous_link;  ?>"> << Prev </a> | <a href="<?php echo $next_link;  ?>">  Next >> </a>
</div>