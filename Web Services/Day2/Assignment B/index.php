<?php
require_once("vendor/autoload.php");
use Doctrine\DBAL\Schema\Index;
use Illuminate\Database\Capsule\Manager as Capsule;
$capsule = new Capsule();
$capsule->addConnection([
    "driver" => _driver_,
    "host" => _host_,
    "database" => _database_,
    "username" => _username_,
    "password" => _password_
]);
$capsule->setAsGlobal();
$capsule->bootEloquent();
$api=new ApiHelper($capsule);
$id=$api->get_resource_id();

if($api->get_method()=="get"){
    if(empty($id)){
        $data=$capsule::table("items")->get();
    
    }else{
        $data=$capsule::table("items")->where("id","=",$id)->find($id);
    }
    $api->get($data);    
}

if($api->get_method()=="post"){
    $data=$capsule::table("items")->insert([
        "id"=>$id,
        "PRODUCT_code"=>"Iphone124241",
        "product_name"=>"Iphone 11",
        "list_price"=>12000,
        "reorder_level"=>30
    ]);
    $api->post($data);     
}

if($api->get_method()=="delete"){
    $data=$capsule::table('items')->where('id', $id)->delete();
    $api->delete($data);     
}
?>