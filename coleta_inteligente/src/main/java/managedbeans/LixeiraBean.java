package managedbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import controlador.LixeiraDao;
import modelo.Lixeira;
import util.Conversor;

@ManagedBean(name="lixeiraMB")
@ViewScoped
public class LixeiraBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LixeiraDao lixeiraDao = new LixeiraDao();
	private List<Lixeira> lixeiras;
	private String lixeirasJson;
	private Lixeira lixeira = new Lixeira();
	
	@PostConstruct
	public void init(){
		lixeiras = lixeiraDao.getLixeiras();
		lixeirasJson = lixeira2Json();
	}
	
	public List<Lixeira> getLixeiras() {
		
		return lixeiras;
	}
	
	public void cadastrarLixeira(){
		boolean resultado;
		resultado = lixeiraDao.createLixeira(lixeira);
		
		if(resultado){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sucesso!", "Lixeira Cadastrada!"));
		
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falha!", "Erro ao tentar Cadastrar Lixeira!"));
		
		}
		
	}
	
	public String status(){
		return "Vazia";
	}
	
	private String lixeira2Json(){
		
		String lixeirasJson = Conversor.converteObjetoParaJson(lixeiras);
		return lixeirasJson;
	}

	public String getLixeirasJson() {
		
		System.out.println(lixeirasJson);
		return lixeirasJson;
	}

	public Lixeira getLixeira() {
		return lixeira;
	}

	public void setLixeira(Lixeira lixeira) {
		this.lixeira = lixeira;
	}
	
}
