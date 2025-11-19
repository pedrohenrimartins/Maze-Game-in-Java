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
    {'#',' ','#','#','#','#',' ','#','#',' ','#',' ','E',' ','#'},
    {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S','#'},
    {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
};
        int linhaS = 14, colunaS = 14;
        
        
        
        int colunaJogador = 1, linhaJogador = 1;
        int linhaInimigo = linhaS-1, colunaInimigo = colunaS-1;
        
        for(int i = 0; i < labirinto.length; i++){
                for(int j = 0; j < labirinto[i].length; j++){
                    System.out.print(labirinto[i][j]);
                }
                System.out.println();
            }
        
        
        do{
            int contador = 0;
                    contador++;
            System.out.println("Direção: ");
            String direcao = input.next();
            labirinto [linhaJogador][colunaJogador] = ' ';
            if(direcao.equals("a")){
                colunaJogador--;
            }else if(direcao.equals("d")){
                colunaJogador++;
            }else if(direcao.equals("s")){
                linhaJogador++;
            }else if(direcao.equals("w")){
                linhaJogador--;
            }else{
                System.out.println("Direção Inválida");
            }
            
            if(contador>=3){
                labirinto[linhaInimigo][colunaInimigo] = 'E';
            } 
            
            if(labirinto[linhaJogador][colunaJogador] == '#'){
                colunaJogador = 1;
                linhaJogador = 1;
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
        
        
    }
    
}
