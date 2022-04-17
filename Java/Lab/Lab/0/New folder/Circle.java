public class Circle extends GeoShape
{
	public Circle (double dim1)
	{
		super (dim1);
	}
	@Override
	public double getArea()
	{
		return 3.14*this.getDim1()*this.getDim1();
	}
}