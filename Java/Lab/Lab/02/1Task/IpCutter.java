class IpCutter{

	public static void main(String[] args){
		String word;
		int beginIndex = 0;
		int index = args[0].indexOf(".");
		System.out.println("Using way of IpCutter");
		while(index != -1){
			word = args[0].substring(beginIndex , index);
			System.out.println(word);
			beginIndex = index+1;
			index = args[0].indexOf("." , beginIndex);
			
		}
		index = args[0].lastIndexOf(".");
		word = args[0].substring(index+1);
		System.out.println(word);

	}
}