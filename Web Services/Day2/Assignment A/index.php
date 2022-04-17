<?php
  spl_autoload_register(function($class)
  {
    include "$class.php";
  });
  $EgyptianCities = WeatherAPI::get_cities('eg');
  $long='';
  $lat='';
  $result=array();
  if(isset($_GET['city'])){
      $lat=$EgyptianCities[$_GET['city']]['coord']['lat'];
      $long=$EgyptianCities[$_GET['city']]['coord']['lon'];
      $result= WeatherAPI::get_weather($lat, $long);
  }else{echo json_encode([
    'status' => 401,
    'message' => "Invalid Request"
]);}

?>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Document</title>
</head>
<body>
<form method="get" id="chooseCityForm">
  <select name="city" id="city">
    <?php for($i = 0; $i < count($EgyptianCities); $i++) { ?>
      <option  value="<?php echo $i ?>"><?= $EgyptianCities[$i]['name'] ?></option>
    <?php } ?>
  </select>
  <button type="submit">Show Weather</button>
</form>

<div id="weatherData">
    <?php echo $result->name;
    echo '</br></br>weather';
    foreach ($result->weather[0] as $key=> $value) {
            echo '</br>'.$key.' : '.$value;
          }
    echo '</br></br>main';
    foreach ($result->main as $key=> $value) {
        echo '</br>'.$key.' : '.$value;
    }
    echo '</br></br>wind';
    foreach ($result->wind as $key=> $value) {
        echo '</br>'.$key.' : '.$value;
    }
    ?>
    </div>
</body>
</html>