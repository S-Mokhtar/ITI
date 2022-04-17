class Parent
{
	private int x,y;
	
	public void setX(int x)
	{
		this.x=x;
	}
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y=y;
	}
	public int getY()
	{
		return y;
	}
	
	public int printNum(int x)
	{
		return  x;
		
	    
	}
	public int printNum (int x ,int y)
	{
		return x+y;
	}
	
	
}
class Child extends Parent
{
	private int z;
	
	public void setZ(int z)
	{
		this.z=z;
	}
	public int getZ()
	{
		return z;
	}
	
	public int printNum (int x ,int y ,int z)
	{
		return x+y+z;
	}
	@Override
	public int printNum (int x )
	{
		return x+1;
	}
	
}
