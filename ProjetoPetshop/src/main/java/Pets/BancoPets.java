package Pets;
import java.util.ArrayList;
import java.util.List;

public class BancoPets {
	private static List<Pets> listaPets = new ArrayList<>();
	private static int id = 0;
	
	public static void salva (Pets pet) {
		if(pet != null) {
			pet.setId(++id);
			listaPets.add(pet);
		}
	}
	
	public static List<Pets> busca(){
		return listaPets;
	}

}