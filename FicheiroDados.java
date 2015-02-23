/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 *
 * @author Catarina Vinagre
 */
public class FicheiroDados {
    
    String caminhoF; //caminho do ficheiro
    
    public FicheiroDados(String caminhoF){   //ja sabe onde esta o ficheiro
    
        this.caminhoF = caminhoF;  
    }
    
    public byte[] lerFicheiro(){
    
        byte[] dadosLidos = new byte[100];
        
        try{
            
            File f = new File(caminhoF);
            FileInputStream fin = new FileInputStream(f);
            fin.read(dadosLidos);  //ler uma determinada quantidade de bytes num ficheiro
            fin.close();
            return dadosLidos;
            
        }catch (Exception e){
            System.err.print("Ficheiro nao encontrado");
        }
        
        return null;
    }
    
    public void escreverFicheiro(byte[] dadosLidos){
    
        try{
            
            File f = new File(caminhoF);
            FileOutputStream fout = new FileOutputStream(f);
            fout.write(dadosLidos);  //ler uma determinada quantidade de bytes num ficheiro
            fout.close();
            
        }catch (Exception e){
            System.err.print("Ficheiro nao encontrado");
        }
    }
}
