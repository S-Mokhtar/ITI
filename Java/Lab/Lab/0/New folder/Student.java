class Student
	{
		private String name;
		private String age;
		private String track;
		
		public Student(String name ,String age ,String track)
		{
			this.name=name;
			this.age=age;
			this.track=track;
		}
		
		public  void setName(String name)
		{
			this.name=name;
		}
		public  String getname()
		{
			return name;
		}
		
		public  void setAge(String age)
		{
			this.age=age;
		}
		public  String getAge()
		{
			return age;
		}
		
		public  void setTrack(String track)
		{
			this.track=track;
		}
		public String getTrack()
		{
			return track;
		}
		
		public void print()
		{
			System.out.println("name: "+name);
			System.out.println("age: "+age);
			System.out.println("track: "+track);
		}
		
		public static void main (String [] args)
		{
			Student S1 = new Student("Abdelrahman Gouda","21","Android");
			S1.print();
		}
		
	}