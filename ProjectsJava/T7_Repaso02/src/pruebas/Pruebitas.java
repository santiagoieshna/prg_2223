package pruebas;

import java.util.HashMap;
import java.util.Iterator;

public class Pruebitas {
//	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		HashMap<Integer,String> mapitas = new HashMap<>();
		HashMap<Integer,String> mapitas2 = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			mapitas.put(i+1, "Sarandonga"+String.valueOf(i+1) );
		}
		
//		for (String string : mapitas) {
//			
//		}
		
//		System.out.println(mapitas.remove(2, "Sarandonga"));
//		System.out.println(mapitas.remove(2, "Sarandonga2"));
		
		
		//Iterator pito = mapitas.keySet().iterator();
		
		int i = 0;
		for (Iterator pito = mapitas.keySet().iterator(); pito.hasNext() ; i++ ) {
			
			if(mapitas.get(pito.next()).equalsIgnoreCase("Sarandonga"+String.valueOf(i+1))) {
				pito.remove();
			}
			
		}
		
		mapitas.forEach((llave,value) ->{
			
			System.out.println(llave+":"+value);
			
		});
		
	}
}
