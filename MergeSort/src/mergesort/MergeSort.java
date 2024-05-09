/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MergeSort {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        /*
        FileReader lerArquivo = null;
        lerArquivo = new FileReader("entrada.txt");
        BufferedReader lerBufferizado = new BufferedReader (lerArquivo);
        
        for (int i = 0; i < 10; i++) {
            String line = lerBufferizado.readLine();
        }
        */
        
        String[] linha = {"4" +
                          "Top Coder comp Wedn at midnight" +
                          "one three five" +
                          "I love cpp C" +
                          "sj sa df r e w f d s v c x z sd fd a"};
        
        
        
        
    }
    
    public static void testingAndHavingFun() {
        
        int p=0, r=0;
        
        int q = 10/2; //change here
        
        String maior, menor = null;
        String athos = "athos";
        String gabriel = "gabriel";
        
        
       String [] nomes = {"athos","pneumastropopicoscomático alimentomático pirocinético do carvalho", "gabriel", "pedro", "poze", "exemplo"};
       
        if (athos.length() > gabriel.length()){
            maior = athos;
        }
        
        else
            maior = gabriel;
        System.out.println(maior + " é maior por "+ maior.length()+" letras! esse cara é gigante!S");
        
        System.out.println("-------------------------");
        
        
        
        maior = "";
        for (int i = 0; i < nomes.length -1; i++){
            if (nomes[i].length() > maior.length()){
                maior = nomes[i];
            }
        }
        
        System.out.println(maior);
        // primeira metade
        for (int i = 0; i < q; i++) {
            
        }
        
        // segunda metade
        for (int i = 0; i < r; i++) {
            
        }
        
    }
    
}
