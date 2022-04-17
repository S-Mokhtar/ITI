class Calculate
{
public static void calcArea(GeoShape g1 , GeoShape g2 , GeoShape g3) {

		double area=g1.getArea() + g2.getArea() + g3.getArea();
		
		System.out.println( "Total Area = " +area );
	}
public static void main (String [] args)
		{
		GeoShape g1 = new Circle(5);
		GeoShape g2  = new Triangle(3 ,  2);
		GeoShape g3  = new Rectangle(6 , 4);
		
		Calculate.calcArea(g1, g2, g3);
			
			
		}
		
}