package io.github.neto.costa.pedro;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Busca binária
 */
public class main {

    private static List<Integer> lista = Arrays.asList(1,2,5,6,7,12,25,27,28,30);

    public static void main(String[] args) {
        System.out.println("==============================================================");
        System.out.println("Numeros existentes na lista: " + lista.toString());
        System.out.print("Por favor, informar um numero para ser buscado na lista acima: ");
        Scanner numero = new Scanner(System.in);
        
        if(numero.hasNextInt()) {
            long inicio = new Date().getTime();
            System.out.println("Iniciando... " + inicio);

            buscaBinaria(numero.nextInt());

            long fim = new Date().getTime();
            System.out.println("Finalizado " + fim);
            System.out.println("Duração: " + (fim - inicio) + " milissegundos");
        }
    }

    private static void buscaBinaria(final Integer valor) {
        int pInicial = 0;
        int pFinal   = lista.size() - 1;
        int pMeio    = pFinal/2;
        
        boolean controle = true;

        while (controle) {
            int valorMeio = lista.get(pMeio);
            
            if(valor == valorMeio) {
                System.out.println("O valor foi encontrato na posição " + pMeio + " do array.");
                controle = false;
            }
            else if(valor > valorMeio && pMeio < (lista.size() - 1) && pMeio != pInicial) {
                System.out.println("O valor informado é maior que " + valorMeio);

                pInicial = pMeio;
                pMeio = (pFinal - pInicial) / 2;
                pMeio = pMeio == 0 ? pFinal : pInicial + pMeio;
            }
            else if(valor < valorMeio && pMeio > 0 && pMeio != pFinal) {
                System.out.println("O valor informado é menor que " + valorMeio);

                pFinal = pMeio;
                pMeio = (pFinal - pInicial) / 2;
                pMeio = pMeio == 0 ? pInicial : pFinal - pMeio;
            }
            else {
                System.out.println("O valor " + valor + " não encontrato!!!");
                controle = false;
            }
        }

    }    
}