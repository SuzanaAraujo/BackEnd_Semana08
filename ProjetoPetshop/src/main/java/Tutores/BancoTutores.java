package Tutores;

import java.util.ArrayList;
import java.util.List;

public class BancoTutores {
	
	private static List<Tutores> listaTutores = new ArrayList<>();
	private static int id = 0;
	
	public static void salvar (Tutores tutor) {
		if(tutor != null) {
			tutor.setId(++id);
			listaTutores.add(tutor);
		}
	}
	
	public static List<Tutores> buscar(){
		return listaTutores;
	}

}
