package muitasort_gabriel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import sun.security.util.Debug;

// [Entrega de trabalho - MUITA SORT!!]
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


public class MuitaSort_Gabriel {

    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        System.out.println("[ MUITA SORT!! ]");
        System.out.println("Feito por: Gabriel da Silva Barros"
                +          "\nBacharelado em Jogos Digitais - 3º Semestre 2021."
                +          "\nProfessor: Fábio Lubacheski");
        System.out.println("\n---------------------------------------------------\n");
        
        TimeUnit.MILLISECONDS.sleep(500);
        
        // VETOR
        int[] v;

        // QTD DE ELEMENTOS & TAMNAHO DE MOD
        int[] nm = new int[2]; // N = nm[0] ; M = nm[1]
        
        v = initialize(nm); /////////////////////////////////////////////////////
        int[] mod = new int[nm[0]];
        
        Scanner read = new Scanner (System.in);
        int resposta=0;
        
        TimeUnit.MILLISECONDS.sleep(250);
        System.out.println("Deseja ver os restos dos índices?");
        System.out.println("[1] Sim     [2] Não    ");
        
        
        resposta = read.nextInt();
        
        
        modMaker(mod, v, nm); //faz
        
        // CRIA ELEMENTOS DE MOD
        System.out.print("\n");
        
        bubbleSort(mod, v);
        
        // PRINTA MOD E VETOR
        printVector(v);
        
        if (resposta == 1){
            printMod(mod);
        }
        
    }
    
    public static int [] initialize(int [] nm) throws IOException{
        
        FileReader lerArquivo = new FileReader ("sortme.txt");
        
        BufferedReader lerBufferizado = new BufferedReader (lerArquivo);
        
        String linha = lerBufferizado.readLine(); // ler a 1ra linha
        String [] vetorStrings = linha.split(" ");
        
        nm[0] = (Integer.parseInt(vetorStrings[0])); // N  ----  v.length
        nm[1] = Integer.parseInt(vetorStrings[1]); // M  ----  x % N
        
        int n = nm[0];
        
        int[] v = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i]=10;
        }

        linha = lerBufferizado.readLine(); // ler a 2da linha
        vetorStrings = linha.split(" ");
        System.out.println("Vetor dentro do arquivo de texto:");
        for (int i = 0; i < n; i++)
        { 
            v[i] = Integer.parseInt(vetorStrings[(i)]);
            System.out.print(v[i] + " ");
        }
        lerBufferizado.close();
        
        System.out.println("\n\nN (tamanho do vetor): "+n);
        System.out.println("M (número divisor para a obtencão do resto): "+nm[1]);
        System.out.println("\n---------------------------------------------------------------------------------");
        System.out.println(  "--   Leia o arquivo \"sortme.txt\" dentro do projeto, para fazer altearções.   --");
        System.out.println(  "---------------------------------------------------------------------------------\n");
        
        return v;

    }
       
    // CRIA O MOD COM BASE NO VETOR
    public static void modMaker(int[] mod, int[] v, int[] mn){
        for (int i = 0; i < mod.length; i++) { 
            mod[i] = v[i] % mn[1];
        }
    }
    
    // ORDENADOR DOS MODS - BUBBLE SORT
    public static void bubbleSort(int[] mod, int[] v){
        for (int i = 0; i < v.length; i++) {
            for (int j = i+1; j < v.length; j++) {
                
                // SE 2 MODs sao IGUAIS, ha um IMPAR e PAR, o IMPAR vem ANTES
                if ( mod[i] == mod[j] && (v[i] %2) != (v[j] %2) ){
                    
                    // para o vetor normal
                    //int impar, par;
                    int vImpar;
                    // para o vetor mod
                    int modAux;
                    
                    if (v[i]%2 == 0){
                        //par = v[i];
                        //impar = v[j];
                        vImpar = v[j]; // impar recebe o j (impar)
                        
                        // troca numeros do vetor mod de lugar
                        modAux = mod[j];
                        mod[j] = mod[i];
                        mod[i] = modAux; //OK
                        
                        // troca numeros do vetor de lugar
                        //v[i] = impar;
                        //v[j] = par;
                        
                        v[j] = v[i]; // j recebe o par
                        v[i] = vImpar; // i recebe o impar
                    }
                }
                
                // SE 2 MODs sao IGUAIS e íMPARES, i será um número ímpar maior que j
                else if ( (mod[i] != 0 && mod[j] != 0)  &&  ( mod[i] == mod[j] )  &&  (v[i] %2 > 0) && (v[j] %2 > 0) ){
                    
                    int auxMaior;
                    int auxMod;
                    
                    // troca vetor normal de pos
                    auxMaior = v[j];
                    v[j] = v[i];
                    v[i] = auxMaior;
                    
                    // troca vetor mod de pos
                    auxMod = mod[j];
                    mod[j] = mod[i];
                    mod[i] = auxMod;
                    
                }
                
                // SE 2 MODs sao IGUAIS e PARES, o MENOR PAR precede MAIOR PAR
                else if ( (mod[i] == 0 && mod[j] == 0)  &&  ( mod[i] == mod[j] )  &&
                        (v[i] %2 == 0) && (v[j] %2 == 0) ){
                    if (v[i] > v[j]){
                        int jAux, modAux;
                        
                        jAux = v[j];
                        v[j] = v[i];
                        v[i] = jAux;
                        
                        modAux = mod[j];
                        mod[j] = mod[i];
                        mod[i] = jAux;
                    }
                }
            }
        }
    }
    
    // FUNCOES PRINT
    public static void printVector(int[] v){
        System.out.print("Vetor:   ");
        for (int i = 0; i < v.length; i++) {
            if (i == v.length -1){
                System.out.printf("%2d.\n", v[i]);
            }
            else
                System.out.printf("%2d, ", v[i]);
        }
    }
    
    public static void printMod(int[] mod){
        System.out.print("Restos:  ");
        for (int i = 0; i < mod.length; i++) {
            if (i == mod.length -1){
                System.out.printf("%2d.\n", mod[i]);
            }
            else
                System.out.printf("%2d, ", mod[i]);
        }
    }
}
