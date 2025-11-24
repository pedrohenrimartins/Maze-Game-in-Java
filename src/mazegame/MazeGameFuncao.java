package mazegame;

import java.util.Random;
import java.util.Scanner;

public class MazeGameFuncao {
    
    public static void main(String[] args) {
        boolean ganhou = false; 
        boolean temChave = false;
        int[] chave = {1, 1};
        char [][] labirinto = definirMapa(chave);
        imprimirMapa(labirinto);
        int[] jogador = {1, 1};
        int[] inimigo = {13, 27};
        
        int turno = 0;
                 
        while(ganhou != true){
           if(jogador[0] == chave[0] && jogador[1] == chave[1]){
               temChave = true;
               System.out.println("Chave Coletada");
           }
            
           if(jogador[0] == inimigo[0] && jogador[1] == inimigo[1]){
               break;
           }else{     
           turno++;
           labirinto = moverJogador(labirinto, jogador);
           char[][] labirintoE = movimentoInimigo(labirinto, inimigo, turno);
           imprimirMapa(labirintoE);
           
           ganhou = checarVitoria(ganhou, labirintoE, jogador, inimigo, temChave);
           }
            
           }
        
        
        
        if(jogador[0] == inimigo[0] && jogador[1] == inimigo[1]){
            System.out.println("O inimigo te capturou GAME OVER!!!!");
        }else{
        System.out.println("Você Ganhou!!!!!!");
        }
                
    }
    
    static char [][] definirMapa(int [] chave) {
        Random rd = new Random();
        int escolherMapa = rd.nextInt(1, 4);
        char [][] labirinto = new char[15][30];
        
        
        escolherMapa = 2;
        if (escolherMapa == 1) {
        labirinto = new char[][]{
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','P',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ','K',' ','#'},
            {'#',' ','#','#',' ','#',' ','#',' ','#',' ','#',' ','#','#',' ','#',' ','#',' ','#',' ','#',' ','#',' ','#','#',' ','#'},
            {'#',' ',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ','#'},
            {'#','#','#','#',' ','#','#','#','#','#','#','#',' ','#',' ','#','#','#','#','#','#',' ','#','#','#',' ','#','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#',' ','#','#','#','#','#',' ','#','#','#','#',' ','#','#','#','#','#',' ','#','#','#','#','#',' ','#','#','#',' ','#'},
            {'#',' ','#',' ',' ',' ','#',' ','#',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ','#',' ',' ','#'},
            {'#',' ','#',' ','#',' ','#',' ','#',' ','#','#','#',' ','#',' ','#','#','#',' ','#',' ','#','#','#',' ','#',' ','#','#'},
            {'#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ','#'},
            {'#','#','#','#','#',' ','#','#','#','#','#',' ','#','#','#',' ','#',' ','#','#','#','#','#',' ','#',' ','#','#','#','#'},
            {'#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ','#',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ','#'},
            {'#',' ','#','#','#','#','#',' ','#',' ','#','#','#',' ','#',' ','#','#','#',' ','#',' ','#','#','#','#','#',' ','#','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };
       
        chave[0] = 1; 
        chave[1] = 27;
    } 
    
    
    else if (escolherMapa == 2) {
        labirinto = new char[][]{
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','P',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ','#','K',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#',' ','#',' ','#','#','#','#','#',' ','#',' ','#','#','#','#','#',' ','#','#','#','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ','#'},
            {'#',' ','#','#','#','#','#','#','#','#','#','#','#','#','#',' ','#','#','#','#','#','#','#','#','#',' ','#','#','#','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#'},
            {'#','#','#','#','#','#','#','#','#','#','#',' ',' ','#',' ',' ','#',' ',' ','#','#','#','#','#','#','#','#','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#'},
            {'#',' ','#','#','#','#','#','#','#','#','#',' ',' ','#','#','#','#','#','#','#',' ',' ','#','#','#','#',' ','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#'},
            {'#','#','#','#','#','#','#','#','#','#','#',' ',' ','#','#','#','#','#','#','#',' ',' ','#','#','#','#',' ','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ','#'},
            {'#',' ','#','#','#','#','#','#','#','#','#','#','#','#',' ','#','#','#','#','#','#','#','#','#','#','#',' ','#',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };
        
        chave[0] = 1;
        chave[1] = 25;
    } 
    
    else if (escolherMapa == 3) {
        labirinto = new char[][]{
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'},
            {'#','P',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ','#',' ','#',' ','#',' ','#',' ','#',' ','#',' ','#',' ','#',' ','#',' ','#',' ',' ',' ','#','#','#',' ','#'},
            {'#','#',' ','#',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ',' ',' ','#',' ','#',' ','#','K','#',' ','#'},
            {'#',' ',' ',' ',' ','#','#','#','#','#','#','#',' ','#','#','#',' ','#','#','#',' ','#',' ','#',' ','#',' ','#',' ','#'},
            {'#',' ','#','#','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ','#','#','#','#','#',' ','#','#','#','#','#',' ','#','#','#','#','#',' ','#','#','#',' ','#'},
            {'#','#','#','#','#','#',' ','#',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ','#',' ','#','#','#','#','#',' ','#','#','#',' ','#',' ','#','#','#',' ','#','#','#',' ','#'},
            {'#',' ','#','#','#','#','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ','#','#','#','#','#',' ','#',' ','#',' ','#',' ','#','#','#','#','#',' ','#',' ','#','#','#'},
            {'#','#','#','#','#','#',' ',' ',' ',' ',' ',' ',' ','#',' ','#',' ','#',' ',' ',' ',' ',' ',' ',' ','#',' ',' ',' ','#'},
            {'#',' ',' ',' ',' ',' ',' ','#','#','#','#','#','#','#',' ','#',' ','#','#','#',' ','#','#','#','#','#',' ','#',' ','#'},
            {'#',' ','#','#','#','#',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ',' ','S','#'},
            {'#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#','#'}
        };
        chave[0] = 3;
        chave[1] = 26;
    }
        
        return labirinto;
        
    }
    
    static void imprimirMapa(char labirinto [][]){
        for(int i = 0; i < labirinto.length; i++){
                for(int j = 0; j < labirinto[i].length; j++){
                    System.out.print(labirinto[i][j]);
                }
                System.out.println();
            }
    }
    
    static char[][] moverJogador(char labirinto [][], int[] jogador ){
       
        Scanner input = new Scanner(System.in);
        
        int linhaJogador = jogador[0];
        int colunaJogador = jogador[1];
        int proximaColuna = colunaJogador; 
        int proximaLinha = linhaJogador;
        
        System.out.println("Direção: ");
            String direcao = input.next();
            
            if(labirinto[jogador[0]][jogador[1]] != 'S'){
               labirinto [linhaJogador][colunaJogador] = ' ';
            }
            
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
                jogador[1] = colunaJogador;
                        
                jogador[0] = linhaJogador;
            }else{
                jogador[1] = proximaColuna;
                jogador[0] = proximaLinha;
            }
            
            if(labirinto[jogador[0]][jogador[1]] != 'S'){
              labirinto [jogador[0]] [jogador[1]] = 'P';
            }
            
            
            return labirinto;
    }
    
    static boolean checarVitoria(boolean ganhou, char[][]labirintoE, int[] jogador, int[]inimigo, boolean temChave){
        if(labirintoE[jogador[0]][jogador[1]] == 'S' && temChave == true){
            ganhou = true;
        }else if(labirintoE[jogador[0]][jogador[1]] == 'S' && temChave == false){
            ganhou = false;
            System.out.println("Você não pode sair sem a chave");
        }else{
            ganhou = false;
        }
        
        return ganhou;
            
    }
    static char[][] movimentoInimigo(char labirinto [][], int[] inimigo, int turno){
        Random rd = new Random();
        int direcao = rd.nextInt(1,5);
        
        int linhaInimigo = inimigo[0];
        int colunaInimigo = inimigo[1];
        int proximaColuna = colunaInimigo; 
        int proximaLinha = linhaInimigo;
            
        if(turno >= 3){
            labirinto [linhaInimigo][colunaInimigo] = ' ';
            if(direcao == 1){
                proximaColuna--;
            }else if(direcao == 2){
                proximaColuna++;
            }else if(direcao == 3){
                proximaLinha--;
            }else if(direcao == 4){
                proximaLinha++;
            }
            
            
            if(labirinto[proximaLinha][proximaColuna] == '#' || labirinto[proximaLinha][proximaColuna] == 'S'){
                
                inimigo[1] = colunaInimigo;
                        
                inimigo[0] = linhaInimigo;
            }else{
                inimigo[1] = proximaColuna;
                inimigo[0] = proximaLinha;
            }
            
            if(labirinto[inimigo[0]][inimigo[1]] != 'S'){
            labirinto [inimigo[0]] [inimigo[1]] = 'E';
            
            }
        }
            char[][]labirintoE = labirinto;
        
        return labirintoE;
    }
    
}
 