package controlador;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import modelo.Lixeira;

public class TestaLixeiraDao {
	
	@Test
	public void testeCadastrarLixeira(){
		
		Lixeira lixeira = new Lixeira();
		LixeiraDao lixeriaDao = new LixeiraDao();
		
		lixeira.setNome("Citrolandia Betim");
		lixeira.setCapacidade(50.0);
		lixeira.setLatitude("-20.0281928");
		lixeira.setDescricao("R. Geraldo José Viêira - Citrolândia, Betim - MG, Brasil");
		lixeira.setLongitude("-44.22245429999998");
		
		boolean resultado = lixeriaDao.createLixeira(lixeira);
		assertEquals(true, resultado);
		
	}
}
