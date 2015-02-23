/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Catarina Vinagre
 */
public class Utilizador {
    
    private String user; //nome do utilizador
    private String pass; //password do utilizador
    
    public Utilizador(String user, String pass) throws NoSuchAlgorithmException{
    
        this.user = user;
        this.pass = Seguranca.encriptarMD5(pass); //gera o MD5(algoritmo de seguranca) da password que o utilizador escreveu
    }
    
    public String getuser(){   //retornar o utilizador
        return user;
    }
    
    public String getpass(){  //retornar a password
        return pass;
    }
    
    public void setpass(String pass) throws NoSuchAlgorithmException{       //para o caso de utilizador querer mudar de password
        this.pass = Seguranca.encriptarMD5(pass);  
    }
}
