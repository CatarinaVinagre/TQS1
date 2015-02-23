package tqs;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Seguranca 
{
	private static SecretKeySpec obterChave(String chave) throws NoSuchAlgorithmException
	{
		byte[] bytesChave = chave.getBytes();
		MessageDigest sha = MessageDigest.getInstance("SHA-1");
		
		bytesChave = sha.digest(bytesChave);
		bytesChave = Arrays.copyOf(bytesChave, 16);
		
		return new SecretKeySpec(bytesChave, "AES");  //este algoritmo permite reverter a password
	}
		
	public static String encriptarMD5(String frase) throws NoSuchAlgorithmException
	{
		byte[] hash;
		StringBuffer hashHexadecimal = new StringBuffer();
		MessageDigest digestorMensagem = MessageDigest.getInstance("MD5");
		
		if(frase != null && frase.length() == 0 || frase.compareTo("") == 0)
		{
			throw new IllegalArgumentException("A string não pode ser nula ou vazia");
		}
		
		digestorMensagem.update(frase.getBytes());
		hash = digestorMensagem.digest();
		
		for (int indice = 0; indice < hash.length; indice++) 
		{
			if((0xFF & hash[indice]) < 0x10)
			{
				hashHexadecimal.append("0" + Integer.toHexString(0xFF & hash[indice]));
			}
			else
			{
				hashHexadecimal.append(Integer.toHexString(0xFF & hash[indice]));
			}
		}
		
		return hashHexadecimal.toString();
	}
	
	public static byte[] encriptarAES(String frase, String chave) throws Exception
	{
		Cipher cifra = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		cifra.init(Cipher.ENCRYPT_MODE, obterChave(chave));
		
		return cifra.doFinal(frase.getBytes("UTF-8"));
	}
	
	public static String desencriptarAES(byte[] fraseEncriptada, String chave) throws Exception
	{
		Cipher cifra = Cipher.getInstance("AES/ECB/PKCS5Padding");
		
		cifra.init(Cipher.DECRYPT_MODE, obterChave(chave));
		
		return new String(cifra.doFinal(fraseEncriptada));
	}
}
