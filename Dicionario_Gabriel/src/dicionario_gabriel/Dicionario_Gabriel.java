package dicionario_gabriel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// [Entrega de trabalho - T3_Dicionario_Samuel]
//   GABRIEL DA SILVA BARROS
//   BJD 2021.3 - ALGORITMOS E PROGRAMAÇÃO II
//   Prof.: FABIO LUBACHESKI

/*

    Eu,
    Gabriel da Silva Barros ( Bacharelado em Jogos Digitais | BJD 2021.3),
    declaro que
    todas as respostas são fruto de meu próprio trabalho,
    não copiei respostas de colegas externos à equipe,
    não disponibilizei minhas respostas para colegas externos à equipe e
    não realizei quaisquer outras atividades desonestas para me beneficiar ou prejudicar
    outros.

*/


/*

    [ENUNCIADO]
    Samuel de apenas 8 anos tem um sonho - ele deseja criar o seu próprio dicionário.
    Isto não é uma tarefa fácil para ele, pois conhece poucas palavras.
    Bem, ao invés de pensar nas palavras que sabe, ele teve uma ideia brilhante.
    A partir do seu livro de histórias favorito, ele quer criar um dicionário
    com todas as palavras distintas que existem no livro, além disso Samuel
    quer que as palavras no dicionário estejam em ordem alfabética.

    É claro, isso é uma tarefa que toma bastante tempo e, por conta disso, ele decidiu
    que deveria pedir ajuda de um programador.
    Você foi convidado a escrever um programa que liste todas as diferentes palavras que existem no livro
    preferido do Samuel, as palavras do livro estarão armazenadas em arquivo texto. Considere que uma
    palavra é definida como uma sequência de letras, maiúsculas ou minúsculas, palavras com apenas uma
    letra também deverão ser consideradas. Ademais o seu programa deverá ser "CaSe InSeNsItIvE", por
    exemplo, palavras como "Apple", "apple" ou "APPLE" deverão ser consideradas como mesma palavra.
    Para garantir que não tenhamos palavras repetidas no dicionário do Samuel, para cada palavra lida no
    arquivo texto deve feita uma busca no dicionário, caso a palavra já conste no dicionário a palavra lida
    deve ser descartada, caso contrário a palavra deve ser inserida no dicionário de forma a manter a ordem
    alfabética.

    IMPORTANTE:
    • Para armazenar o dicionário de palavras use um vetor de String, não sendo permito o uso de
    classes prontas de lista do Java para armazenar as palavras, por exemplo a classe Arraylist.
    Considere que no arquivo texto não teremos mais de 100 palavras diferentes, ou seja, você pode
    declarar um vetor de String com 100 posições.

    • A busca no dicionário deve ser implementada utilizando uma função recursiva (sem loop) que faz
    busca binária no vetor de palavras (vetor de String).

    • Para inserir uma nova palavra no vetor de String use uma função recursiva (sem loops), essa
    operação deverá gastar no máximo n passos para cada palavra nova. Importante, não é para
    inserir todas as palavras no vetor e depois ordenar, e sim a cada palavra nova, esta deverá ser
    inserida no vetor de palavras que continuará ordenado

*/


public class Dicionario_Gabriel {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        FileReader lerArquivo = null; //FileReader criado
        lerArquivo = new FileReader("exemploProf.txt"); //atribuido valor ao FileReader 
        BufferedReader lerBufferizado = new BufferedReader (lerArquivo); //"Caixinha" criada
        
        String [] vPalavras = new String [100];
        String aux;
        
        //                               file reader,   bf reader,     strg[], strg[], conuter, int, tamanho maximo do  ngc
        lineSplitter(lerArquivo, lerBufferizado, vPalavras, null,     0,     99, 0, 0);
        
        
    }
    
    //vetor ja mata na paulada
    public static int lineSplitter(FileReader lerF, BufferedReader lerBufa, String [] vPalavras, String aux, int counter, int i, int k, int j //para vetorStrings
            ) throws IOException {
        
            
        lerF = new FileReader("exemploProf.txt");
        
        String line = lerBufa.readLine(); // cria String Linha, derivada da "Caixinha"
        
        String[] vetorStrings = line.split(" ");
        
        
        if (vPalavras[i] == null){
            counter=counter+1;
        }
        
        if (vetorStrings[k] != null){
            
            if (line.compareTo(".") == 0){ // nao esquecer do compareTo
                return 1;
            }
            
            vetorStrings = line.split(" ");
            
            //se tiver so 1 elemento
            if (vetorStrings.length == 1){
                Sort(j, k, vetorStrings,vPalavras,aux);
                vPalavras[j] = vetorStrings[k].toLowerCase();
                //System.out.println(vPalavras[j]);
            }
            //senao chamo a funcao
            else{
                int lastElement=vetorStrings.length -1;
                vPalavras = writeAndSort(j, k, vetorStrings,vPalavras,aux,lastElement);
            }
            
            /*
            if (j > 0){
                if (vPalavras[j].compareTo(vPalavras[j-1]) < 0){
                    aux = vPalavras[j-1];
                    vPalavras[j-1] = vPalavras[j];
                    vPalavras[j] = aux;
                    System.out.println(vPalavras[j]);
                    System.out.println(vPalavras[j-1]);
                }
            }
            */
        }
        
        lineSplitter(lerF, lerBufa, vPalavras, aux, counter, i-1,k, j+1);
        lerBufa.close();
        
        return 0;
        
        //return 0;
    }
    
    public static String[] Sort(int j, int k, String[] vetorStrings, String[] vPalavras, String aux) {
    
        if (j > 0){
                if (vPalavras[j].compareTo(vPalavras[j-1]) < 0){
                    aux = vPalavras[j-1];
                    vPalavras[j-1] = vPalavras[j];
                    vPalavras[j] = aux;
                    System.out.println(vPalavras[j-1]);
                    System.out.println(vPalavras[j]);
                }
        }
        else
            vPalavras[j] = vetorStrings[k];
        
        return vPalavras;
    }
    
    public static String[] writeAndSort(int j, int k, String[] vetorStrings, String[] vPalavras, String aux, int elementFinalPos) {
        
        if (k < elementFinalPos+1){
        //if (elementFinalPos >= k){
            vPalavras[j] = vetorStrings[k].toLowerCase();
            Sort(j,k,vetorStrings,vPalavras,aux);
            //System.out.println(vPalavras[j]);
            k++;
            //elementFinalPos--;
            j++;
            
            return writeAndSort(j,k,vetorStrings,vPalavras,aux,elementFinalPos);
        }
        return vPalavras;
    }
    
    public static void buscaBinaria(int j, int k, String[] vetorStrings, String[] vPalavras, String aux) {
        
        
        
    }
    
    // BACKUP da versão iterativa [ignorar]
    ///////////////////////
    /*
    public static void main2() throws FileNotFoundException, IOException {
        FileReader lerArquivo = null; //FileReader criado
        lerArquivo = new FileReader("exemploProf.txt"); //atribuido valor ao FileReader 
        BufferedReader lerBufferizado = new BufferedReader (lerArquivo); //"Caixinha" criada
        
        int j=0;
        String [] vPalavras = new String [100];
        String aux;
        int counter = 0;
        
        while (true){
            
            String line = lerBufferizado.readLine(); // cria String Linha, derivada da "Caixinha"
            
            if (line.compareTo(".") == 0){ // nao esquecer do compareTo
                break;
            }
            
            String[] vetorStrings = line.split(" "); //vetor de strings criado, onde " " é o que separa cada índice
            
            
            int i=0;
            while (i < vetorStrings.length)
            {
                
                
                vetorStrings[i] = vetorStrings[i].toLowerCase();
                
                //vPalavras[j] = (vPalavras[j].compareTo(vetorStrings[i])== 0);
                
                
                if (j != 0){
                    if (vPalavras[j].compareTo(vPalavras[j-1])>0){
                        aux = vetorStrings[j];
                        vetorStrings[j] = vetorStrings[j];
                        vetorStrings[j] = aux;
                    }
                }
                else{
                    if (vPalavras[j].compareTo(vPalavras[j-1])>0){
                        aux = vetorStrings[j];
                        vetorStrings[j] = vetorStrings[j];
                        vetorStrings[j] = aux;
                    }
                }
                
                vPalavras[j] = vetorStrings[i].toLowerCase();
                
                System.out.println(vPalavras[j]);
                if (line.compareTo(".") != 0){
                    i++;
                    j++;
                    //
                }
            } 
        }
        lerBufferizado.close();
    }
    */

}

