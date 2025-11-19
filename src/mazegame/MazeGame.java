package mazegame;

import java.util.Random;
import java.util.Scanner;


public class MazeGame {

   public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rd = new Random();
        char labirinto [][] = {
    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
    {'#','P',' ',' ',' ',' ','#',' ',' ',' ',' ',' ','#',' ','#'},
    {'#',' ','#','#','#',' ','#',' ','#','#',' ',' ','#',' ','#'},
    {'#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ',' ','#'},
    {'#',' ','#',' ','#','#','#',' ','#',' ','#','#','#',' ','#'},
    {'#',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
    {'#',' ','#','#','#','#',' ','#','#',' ','#',' ','#','#','#'},
    {'#',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ','#',' ','#'},
    {'#',' ','#','#',' ','#','#','#','#','#',' ','#',' ',' ','#'},
    {'#',' ',' ','#',' ',' ',' ',' ','#',' ',' ','#','#',' ','#'},
    {'#',' ','#',' ','#','#','#',' ','#',' ',' ',' ',' ',' ','#'},
    {'#',' ','#',' ',' ',' ',' ',' ','#',' ','#','#','#',' ','#'},
    {'#',' ','#','#','#','#',' ','#','#',' ','#',' ',' ',' ','#'},
    {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S','#'},
    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
};
        
        
        int linhaSaida = 13;
        int colunaSaida = 13;
        
        
        int colunaJogador = 1, linhaJogador = 1;
        int proximaColuna = colunaJogador; 
        int proximaLinha = linhaJogador;
        int linhaInimigo = linhaSaida - 1;
        int colunaInimigo = colunaSaida - 1;
        
        for(int i = 0; i < labirinto.length; i++){
                for(int j = 0; j < labirinto[i].length; j++){
                    System.out.print(labirinto[i][j]);
                }
                System.out.println();
            }
        
        int contador = 0;
        do{
            
            contador++;
            System.out.println("Direção: ");
            String direcao = input.next();
            labirinto [linhaJogador][colunaJogador] = ' ';
            if(direcao.equals("a")){
                proximaColuna--;
            }else if(direcao.equals("d")){
                proximaColuna++;
            }else if(direcao.equals("s")){
                proximaLinha++;
            }else if(direcao.equals("w")){
                proximaLinha--;
            }else{
                System.out.println("Direção Inválida");
            }
            
            
            
            if(labirinto[proximaLinha][proximaColuna] == '#'){
                System.out.println("Você bateu na parede");
                proximaColuna = colunaJogador;
                proximaLinha = linhaJogador;
            }else{
                colunaJogador = proximaColuna;
                linhaJogador = proximaLinha;
            }
            if(contador>=3){
                labirinto[linhaInimigo][colunaInimigo] = 'E';
            } 
            
            if(labirinto[linhaJogador][colunaJogador] != 'S'){
            labirinto [linhaJogador] [colunaJogador] = 'P';
            
            }
            
            
            
            for(int i = 0; i < labirinto.length; i++){
                for(int j = 0; j < labirinto[i].length; j++){
                    System.out.print(labirinto[i][j]);
                }
                System.out.println();
            }
            
            
            
            
            
        }while(labirinto[linhaJogador][colunaJogador] != 'S');
        
        System.out.println("Você Ganhou EEEEEEEEEEEEEBAAAAAAAAAAAAA");
    }
    
}
