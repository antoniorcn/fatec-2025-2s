package edu.fatec;

public class TesteString { 

	public static void main(String[] args) {
		String a = "A";
		String b = "B";
		String c = a;
		String d = "A"; 

		d = d + "";
		
		if (a == b) { 
			System.out.println("(a) é igual a (b)");
		} else { 
			System.out.println("(a) é diferente de (b)");
		}

		if (a == c) { 
			System.out.println("(a) é igual a (c)");
		} else { 
			System.out.println("(a) é diferente de (c)");
		}

		if (a == d) { 
			System.out.println("(a) é igual a (d)");
		} else { 
			System.out.println("(a) é diferente de (d)");
		}

		if (c == d) { 
			System.out.println("(c) é igual a (d)");
		} else { 
			System.out.println("(c) é diferente de (d)");
		}
	}

}