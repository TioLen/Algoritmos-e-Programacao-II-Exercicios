/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursao;

/**
 *
 * @author TioLen
 */
public class Recursao {
    public static void main(String[] args) {
        int[] v = {1,2,3,4,5,6,7,8,9,10,11};
        
        //
        int resultadoSoma = somar(0, v, 0); // ovo = somaInicial, vetor, posicaoInicial
        System.out.println("soma: " + resultadoSoma);
        
        int limiteFibo = 10;
        
        int[] somaFibo = new int[3];
        int resultadoFibo = fibonache(somaFibo, 0, limiteFibo, 0, 0); //vetor da soma (0), somaInicial (0), resultado (0), limite, elemento
        
        System.out.println(resultadoFibo);
    }
    

    
    public static int fibonache (int[] somaFibo, int soma, int limite, int posicao, int elemento){
        if (posicao < limite){
            if (posicao == 0 || posicao == 1){
                elemento = soma +1;
                return soma = 1;
            }
            soma = soma + elemento;
            somaFibo[posicao] = soma;
            return fibonache(somaFibo, soma, limite, posicao+1, elemento);
        }
        return soma;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //FUNCIONA
    public static int somar (int soma, int[] vetor, int posicao){
        if (posicao < vetor.length){
            soma = soma + vetor[posicao];
            return somar(soma, vetor, posicao+1);
        }
        return soma;
    }
}
