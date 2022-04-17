<?php
ini_set('memory_limit', '-1');
$string=file_get_contents('city.list.json');
$json_cities=json_decode($string,true);
if (isset($_POST["submit"])) {
    $api_key="bda221b229641bb76fc9ae7142e0146b";
    $city_id=$_POST["city"];
    $api_url="http://api.openweathermap.org/data/2.5/weather?id=".$city_id."&APPID=".$api_key;
    $ch=curl_init();
    curl_setopt($ch,CURLOPT_RETURNTRANSFER,1);
    curl_setopt($ch,CURLOPT_URL,$api_url);
    curl_setopt($ch,CURLOPT_FOLLOWLOCATION,1);
    $response=curl_exec($ch);
    curl_close($ch);
    $data=json_decode($response,true);
    $current_time=time();
    //echo $data->weather[4]->description->value;
    //var_dump($data["weather"][0]["description"]);
    //var_export($data);
    echo '<pre>' . var_export($data, true) . '</pre>';
}
?>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
    <h2>Weather Forecast</h2>
    <form method="post">
    <select name="city" id="city">
    <option value="360542">EG>>Al Qurayn</option>
    <option value="361495">EG>>Al Ayyat</option>
    <option value="362882">EG>>Abu al Matamir</option>
    <option value="350789">EG>>Qalyub</option>
    <option value="355795">EG>>Halwan</option>
    <option value="356933">EG>>Farshut</option>
    <option value="356989">EG>>Faqus</option>
    </select>
  <br><br>
  <input type="submit" name="submit" value="Get Weather">
  </form>
    </body>
</html>