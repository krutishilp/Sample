public class MyDate{
	
	private int day;
	private int month;
	private int year;

	public void setDay(int d){
		day=d;
	}
	
	public int getDay(){
		return day;
	}
	
	public void setMonth(int m){
		month=m;
	}
	
	public int getMonth(){
		return month;
	}
	
	public void setYear(int y){
		year=y;
	}
	
	public int getYear(){
		return year;
	}
	
	
	public static void main(String[] args){
		MyDate date=new MyDate();
		
		date.setDay(28);
		date.setMonth(7);
		date.setYear(2020);
		
		System.out.println("Date: "+date.getDay()+"/"+date.getMonth()+"/"+date.getYear());
	}
}