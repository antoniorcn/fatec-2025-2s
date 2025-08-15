package edu.fatec;

public class TesteString { 
	public static void main(String[] args) { 
		String a = "A";
		String b = "B";
		String c = a;
		String d = "A";

		d = d + "";
		if (a == b) { 
			System.out.println("(a) e igual a (b)");
		} else { 
			System.out.println("(a) e diferente de (b)");
		}
		if (a == c) { 
			System.out.println("(a) e igual a (c)");
		} else { 
			System.out.println("(a) e diferente de (c)");
		}	
		if (a == d) { 
			System.out.println("(a) e igual a (d)");
		} else { 
			System.out.println("(a) e diferente de (d)");
		}	
		if (b == d) { 
			System.out.println("(b) e igual a (d)");
		} else { 
			System.out.println("(b) e diferente de (d)");
		}	
	}
}