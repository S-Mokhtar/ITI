<?php

class RequestHandler {
    private $__method;
    private $__parameters = array();
    private $__resource;
    private $__resource_id;
    private $__allowed_methods= array("GET","POST","DELETE","PUT");
    
    
    function get__method() {
        return $this->__method;
    }

    function get__parameters() {
        return $this->__parameters;
    }

    function get__resource() {
        return $this->__resource;
    }

    function get__resource_id() {
        return $this->__resource_id;
    }

    
 

    public function __construct() {

            
        
        
    }

     //***********************************************************************************************************
    //this function should output or return the request elements (resource, method, parameters and resource id)
	//if $output is false the function should returns otherwise it should echo the response in JSON formats
	//***********************************************************************************************************
    public function scan($output=true){
       
     
        
    }
	//***********************************************************************************************************
    //this function should validate the request 
	//if $output is false the function should returns the result otherwise it should echo the results in JSON formats
	//$correct_resource : The resource which the service should accepts, "items" in this example. 
	//***********************************************************************************************************
    public function validate($correct_resource,$output = true){
      
    }
    
    

}
