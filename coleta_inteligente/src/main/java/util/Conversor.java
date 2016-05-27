package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

import com.google.gson.Gson;

import modelo.Lixeira;

public class Conversor {

	public static String converteStringToMD5(String valor) {
		MessageDigest mDigest;

		try {
			mDigest = MessageDigest.getInstance("MD5");

			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

			StringBuffer sb = new StringBuffer();

			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
		}

		return null;

	}

	public static String converteObjetoParaJson(List<Lixeira> lixeiras) {

		String json = new Gson().toJson(lixeiras);
			

		return json;
	}
}
