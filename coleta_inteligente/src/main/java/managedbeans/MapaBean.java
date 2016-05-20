package managedbeans;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import controlador.ControladorMapa;
import modelo.Mapa;

@ManagedBean
@ViewScoped
public class MapaBean {
	
	private Mapa mapa;
	private ControladorMapa controladorMapa;
	
	public Mapa getMapa(String lat, String longt) {

		mapa = controladorMapa.getMapa(lat, longt);
		return mapa;
	}
	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
	
}
