<?php
class ResponseHandler {

    private $db;  //an object from MYSQLHandler class
    private $logger;  //logger object to log response if needed (bonus)
	
	
   //$db : an object from MYSQLHandler class
    public function __construct($db,$logger=null) {
     
    }

    //***********************************************************************************************************
	//use this function for output all success responses
	//it has a log parameters just incase you want to log the response (bonus)
	//$data could be any thing you send but mostlikely it will be an array or a confirmation message	
	//***********************************************************************************************************
    public function output_with_success($data, $sucess_code = 200, $log = null) {


    }
    
	 //***********************************************************************************************************
	//use this function for output and log any error
	//it has a log parameters just incase you want to log the response (bonus)
	//$error message is the text you want to display for the client of your API 	
	//***********************************************************************************************************
    public static function output_with_error($code = 400, $error_msg, $log = null) {

    }
    
	 //***********************************************************************************************************
	//use this function to handle the GET HTTP Verb
	//$id is the resource_id	
	//***********************************************************************************************************
    public function handle_get($id) {
    
    }
     //***********************************************************************************************************
	//use this function to handle the POST HTTP Verb
	//$params is sent params for a new resource
	//***********************************************************************************************************
    public function handle_post($params) {

     
    }

	//***********************************************************************************************************
	//use this function to handle the PUT HTTP Verb
	//$params is sent params for a new resource
	//$id is the resource_id
	//***********************************************************************************************************
    public function handle_put($params, $id) {
     
    }
    //***********************************************************************************************************
	//use this function to handle the GET HTTP Verb
	//$id is the resource_id
	//***********************************************************************************************************
    public function handle_delete($id) {
 
    }

}
