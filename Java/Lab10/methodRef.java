interface message{ 
void saySomething();
} 
public class methodRef {  
 public static void saySomething(){  
        System.out.println("Hello, this is static method.");  
    }   
    public static void main(String[] args) {  
        message msg = methodRef::saySomething;
		msg.saySomething();
    }  
}  