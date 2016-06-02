package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import controlador.UsuarioDAO;
import modelo.Usuario;

@FacesConverter(value="usuarioConverter", forClass = Usuario.class)
public class UsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.equals("")) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = new Usuario();
			usuario = usuarioDAO.getUsuarioById(Long.parseLong(value));
			return usuario;
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object object) {
		try {
			if (!object.equals(new Usuario())) {
				return String.valueOf(((Usuario) object).getId());
			}
		} catch (ConverterException e) {
			e.printStackTrace();
		}
		return null;
	}

}
