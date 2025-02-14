package com.questk2.main;



	class Mobile 
	{
		 String mobileRingtone()
		 {
			 return ("");
		 }
	}
	class Samsung extends Mobile
	{
		 String mobileRingtone()
		 {
			 return ("tik tik");
		 }
	}
	class Iphone extends Mobile
	{
		 String mobileRingtone()
		 {
			 return("tring tring");
		 }
	}

	public class MethodOverRiding{	 
		public static void main(String[] args) 
		{
			Samsung samsung = new Samsung();
			Iphone iphone = new Iphone();
			System.out.println("Samsung ringtone : " +samsung.mobileRingtone());
			System.out.println("Iphone ringtone : " +iphone.mobileRingtone());
			
			
		}
	}


