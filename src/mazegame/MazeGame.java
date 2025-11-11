package mazegame;

import java.util.Scanner;


public class MazeGame {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Jogo do labirinto");
        
        char labirinto [][] = {
            {'#','#','#','#','#','#','#','#','#','#'},
            {'#','P',' ',' ','#',' ',' ',' ',' ','#'},
            {'#','#','#',' ','#',' ','#','#',' ','#'},
            {'#',' ','#',' ',' ',' ','#',' ',' ','#'},
            {'#',' ','#','#','#',' ','#',' ','#','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ','#'},
            {'#',' ','#',' ','#','#','#','#',' ','#'},
            {'#',' ','#',' ',' ',' ',' ','#',' ','#'},
            {'#',' ',' ',' ','#','#',' ',' ','S','#'},
            {'#','#','#','#','#','#','#','#','#','#'}
    };
        
        
        int colunaJogador = 1, linhaJogador = 1;
        
        
        System.out.println("Movimente-se com w, a, s, d");
        do{
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
            
            if(labirinto[linhaJogador][colunaJogador] == '#'){
                colunaJogador = 1;
                linhaJogador = 1;
            }
            
            labirinto [linhaJogador] [colunaJogador] = 'P';
            
            for(int i = 0; i < labirinto.length; i++){
                for(int j = 0; j < labirinto[i].length; j++){
                    System.out.print(labirinto[i][j]);
                }
                System.out.println();
            }
            
            
            
            
            
        }while(labirinto[linhaJogador][colunaJogador] != labirinto[8][8]);
        
        
    }
    
}
