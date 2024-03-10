package retos;

import java.util.List;

public class threadsAll {
	public static void main(String[] args) {
		Thread.getAllStackTraces().keySet().forEach(thread->{
			System.out.println(thread.getId());
		});
		
		pruebaCaprichosa(4);
		
		
	}

	private static void pruebaCaprichosa(int travieso) {
		int caprichosa = 0;
		
		List<Integer> numeritos = List.of(new Integer[] {2 ,3 ,4, 5,5});
		
		numeritos.forEach(x->{
			
			if(x>caprichosa) {
				metodoAuxiliar(travieso);
			}
			
		});
	}

	private static void metodoAuxiliar(int travieso) {
		Integer x;
		x= travieso;
	}
}
