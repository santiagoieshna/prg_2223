package FOR_ANIDADOS;

public class FORANIDADOS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int doble = 2;
		
		for(int i = 1; i <= 5; i++) {
			
			System.out.print(i + "-->");
			
			for(int j = 1; j <= doble; j++) {
				
				System.out.print("* ");
			}
				System.out.println();
				doble = doble *2;
		}
		
	}
}
