/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs;

/**
 *
 * @author Catarina Vinagre
 */
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Gestor_chaves {      //trabalho nao terminado, porem este nao imprime nada

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        
        Scanner sc = new Scanner(System.in);
        FicheiroDados ficheiroDados = new FicheiroDados(args[0]);  //instancia nova da classe FicheiroDados
        
        String user;
        String pass;
        
        System.out.print("User: ");
        user = sc.nextLine();
        System.out.print("Password: ");
        pass = sc.nextLine();
        
        Utilizador novoUtilizador = new Utilizador(user, pass);
        ficheiroDados.lerFicheiro();
        
        while (true){   //
        
            int opcao;
            System.out.println("1-Consultar registo");
            System.out.println("2-Adicionar registo");
            System.out.println("3-Apagar registo");
            System.out.println("4-Sair");
            System.out.print("Escolha uma das opcoes: ");
            opcao = sc.nextInt();
            
            switch(opcao){
                
                case 1: consultarRegisto();
                break;
                
                case 2: adicionarRegisto();
                break;
                
                case 3: apagarRegisto();
                break;
                    
                case 4: sair();
                break;    
            }
        }

    }
    
    public static void consultarRegisto(){
      //metodo para a consulta do registo
      
        
    }
    
    public static void adicionarRegisto(){
      //caso o utilizador queira adicionar um registo
        
    }
    
    public static void apagarRegisto(){
      //caso o utilizador queira apagar um registo
        
    }
    
    public static void sair(){
      //metodo para o utilizador sair da aplicacao
        
    }
}
