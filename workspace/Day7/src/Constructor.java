
public class Constructor {

	
	private String famousFood;
	private int price;
	private String food;

		public Constructor(String food , int price) {
		
		}
		public void info(String place , String food, int price)
		{
			this.food = food;
			this.price = price;
		}
		public String getFood() 
		{
			return food;
		}
		public int getPrice() 
		{
			return price;
		}

		public static void main(String[] args) {
			Constructor constructor=new Constructor("Biryani",100);
			System.out.println("Place : "+constructor.getFood());
			System.out.println("Famous Food: "+constructor.getPrice());
		
	}

}
