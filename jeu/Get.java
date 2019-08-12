package jeu;
import java.util.Scanner;


public abstract class Get {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int nextInt(){
		int i = sc.nextInt();
		//sc.reset();
		return i;
	}
	
	public static String nextLine(){
		String str = sc.nextLine();
		//sc.reset();
		return str;
	}
	
	public static double nextDouble(){
		double d = sc.nextDouble();
		//sc.reset;
		return d;
	}
	
}
