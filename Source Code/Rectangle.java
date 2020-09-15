package shape;
public class Rectangle{
	
	private int length;
	private int breadth;
	
	public Rectangle(int length,int breadth){
		this.length=length;
		this.breadth=breadth;
	}
	
	public Rectangle(){
		length=5;
		breadth=10;
	}
	
	/*public void setLength(int len){
			length=len;
	}
	
	public void setBreadth(int bth){
			breadth=bth;
	}*/
	
	public double calculateArea(){
		return (length*breadth);
	}
	
	/*public static void main(String[] args){
		Rectangle ra=new Rectangle(); 
		ra.setLength(5);
		ra.setBreadth(3);
		System.out.println("Area of RectAngle: "+ ra.calculateArea());
	}*/
}