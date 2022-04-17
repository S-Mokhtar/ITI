class CommandLine{

	public static void main(String[] args){
		if(args.length == 3){
			Double fisrtNumber = Double.parseDouble(args[0]);
			Double secondNumber = Double.parseDouble(args[0]); 
			
			       switch(args[1]){
					case "+":
						System.out.println("Resualt = " + (fisrtNumber + secondNumber) );
						break;
					case "-":
						System.out.println("Resualt = " + (fisrtNumber - secondNumber) );
						break;
					case "x":
						System.out.println("Resualt = " + (fisrtNumber * secondNumber) );
						break;
					case "/":
						if(secondNumber == 0){
							System.out.println("Resualt = " + (fisrtNumber / secondNumber) );
						}else{
							System.out.println("Can not divide by 0");
						}
						
						break;
					default:
						System.out.println("You must one of this operator + - / *=x");
						break;
				}
				
						
			
		}else{
			System.out.println("You must enter two numbers and one opertaion like 2 + 3");
		}
		
	}


}