package bot;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import bdd.Data;

public class ChuckNorrisFacts {
	
	public static String mostrar(String user) throws Exception {
		
		ArrayList<String> lista = new ArrayList<String>();
		
		Scanner sc = new Scanner(new File("src/main/resources/chuck.data"));
		
		for(int i=0; i<10; i++) {
			lista.add(sc.nextLine());
		}
		
		sc.close();
		
		Data d = new Data(user);
		d.obtain();
		Integer chuck = d.getChuck();
		d.setChuck((chuck+1)%lista.size());
		d.save();
		return lista.get(chuck);
	}
	
}