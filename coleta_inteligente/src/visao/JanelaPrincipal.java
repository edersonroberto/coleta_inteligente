package visao;

import java.awt.image.BufferedImage;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class JanelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextArea texto = new JTextArea();
	static String chave = "AIzaSyDHIY5M3CdjQu6VbVEnz8WuxaYRxbjXMoc";
	static String tipo = "roadmap";
	static String zoom = "8";
	static JLabel label;

	static String endereco = "http://maps.googleapis.com/maps/api/staticmap?center=-22.8634,-43.1792&zoom=" + zoom
			+ "&size=640x640&maptype=" + tipo + "&key=" + chave + "&sensor=false&format=jpg";

	public JanelaPrincipal() {
	
		super("Só uma janela mesmo");
		this.montaJanela();
	}

	public void montaJanela() {
		this.getContentPane().add(label);
	}

	public static void main(String[] args) {

		URL url;
		BufferedImage img = null;
		try {
			url = new URL(endereco);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			img = ImageIO.read(con.getInputStream());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		ImageIcon mapa = new ImageIcon(img);
		label = new JLabel(mapa);
		
		JanelaPrincipal janela = new JanelaPrincipal();
		janela.setSize(640, 640);
		janela.setVisible(true);
		
		
		
		

	}

}
