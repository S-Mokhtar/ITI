<?php
class counter{
    public static function increase(){
        $data=file("counter.txt");
        $data[0]++;
        $fp=fopen("counter.txt","w");
        fwrite($fp,$data[0]++);
        fclose($fp);
    }
}
?>