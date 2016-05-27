package util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import controlador.LixeiraDao;
import modelo.Lixeira;

public class TestaConversor {
	
	@Test
	public void testeConversorJava2Json(){

		LixeiraDao lixeiraDao = new LixeiraDao();
		List<Lixeira> lixeiras = new ArrayList<Lixeira>();
		lixeiras = lixeiraDao.getLixeiras();
		
		for (Lixeira lixeira : lixeiras) {
			System.out.println("Descrição: " + lixeira.getDescricao());
			System.out.println("Latitude: " + lixeira.getLatitude());
			System.out.println("Longitude: " + lixeira.getLongitude());
		}
		
		String stringJson = Conversor.converteObjetoParaJson(lixeiras);
		
		System.out.println(stringJson);
		
		
	}
}
