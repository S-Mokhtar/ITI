import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandReg{

	public static void main(String[] args){
		if(args.length == 3){
			Pattern patternNumber = Pattern.compile("^[0-9]$");
			Pattern patternOpertion = Pattern.compile("[-|/|+|x]");
			Matcher matchNumber = patternNumber.matcher(args[0]);
			boolean isMatch = matchNumber.find();

			if(isMatch){
				matchNumber = patternNumber.matcher(args[2]);
				isMatch = matchNumber.find();

				if(isMatch){
					matchNumber = patternOpertion.matcher(args[1]);
					isMatch = matchNumber.find();

					if(isMatch){
						Double fisrtNumber = Double.parseDouble(args[0]);
						Double secondNumber = Double.parseDouble(args[2]);
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
								if(secondNumber != 0){
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
						System.out.println("Opertion must be one of this - / + *=x");
					}

				}else{
					System.out.println("Second Number must be number");
				}

			}else{
				System.out.println("First Number must be number");
			}										
			
		}else{
			System.out.println("You must enter two numbers and one opertaion like 2 + 3");
		}
		
	}


}