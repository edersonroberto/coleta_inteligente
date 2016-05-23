package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import controlador.LixeiraDao;
import modelo.Lixeira;

@ManagedBean(name="lixeiraMB")
@ViewScoped
public class LixeiraBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LixeiraDao lixeiraDao = new LixeiraDao();
	private List<Lixeira> lixeiras;
	
	@PostConstruct
	public void init(){
		lixeiras = lixeiraDao.getLixeiras();
	}
	
	public List<Lixeira> getLixeiras() {
		
		return lixeiras;
	}
	
}
