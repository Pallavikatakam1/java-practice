
public class Methods {
	
	private String place;
	private String famousFood;

		public void info(String place , String famousFood)
		{
			this.place = place;
			this.famousFood= famousFood;
		}
		public void display(String place, String famousFood)
		{
			System.out.println("Place:" +place);
			System.out.println("Famous Food:" +famousFood);
			
		}
		public static void main(String[] args)
		{
			Methods methods = new Methods();
			methods.display("Hyderabad", "Biryani");
			
	}

}
