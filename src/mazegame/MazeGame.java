package mazegame;

import java.util.Random;
import java.util.Scanner;

public class MazeGame {
    
    public static void main(String[] args) {
        //Introdução ao jogo
        System.out.println("----------BEM-VINDO AO LABIRINTO----------");
        System.out.println();
        System.out.println(" INSTRUÇÕES:");
        System.out.println(" 1. Você é o 'P' (Player).");
        System.out.println(" 2. Seu objetivo é pegar a chave 'K'.");
        System.out.println(" 3. Com a chave, fuja pela saída 'S'.");
        System.out.println(" 4. Cuidado: O inimigo 'E' acordará em 3 turnos!");
        System.out.println("---------------------------------------------");
        System.out.println(" CONTROLES:");
        System.out.println(" 'w' = Cima | 's' = Baixo | 'a' = Esquerda | 'd' = Direita");
        System.out.println("-----------------------------------------------------------\n");
        
        // Pausa para leitura
        System.out.println("Pressione ENTER para começar...");
        new Scanner(System.in).nextLine(); 
        
        //inicialização de variáveis
        
        boolean ganhou = false; 
        boolean temChave = false;
        int turno = 0;
        
        //Coordenadas iniciais
        int[] chave = {1, 1}; 
        int[] jogador = {1, 1};
        int[] inimigo = {13, 27};
       
        
        //inicialização do vetor do mapa
        char [][] labirinto = definirMapa(chave);  
        System.out.println("O jogo começou!\n");
        imprimirMapa(labirinto);       
        
        
        //Loop principal do Jogo         
        while(ganhou != true){
            
            //Verificação chave
           if(jogador[0] == chave[0] && jogador[1] == chave[1]){
               temChave = true;
               System.out.println("-- CHAVE COLETADA! CORRA PARA SAÍDA! --");
           }
            //Verificação da colisão com o inimigo
           if(jogador[0] == inimigo[0] && jogador[1] == inimigo[1]){
               break;
           }else{     
           turno++;
           
           //Processo de movimento do jogador
           labirinto = moverJogador(labirinto, jogador);
           char[][] labirintoE = movimentoInimigo(labirinto, inimigo, turno);
           imprimirMapa(labirintoE);
           
           //Checar condições de vitória
           ganhou = checarVitoria(ganhou, labirintoE, jogador, inimigo, temChave);
           }
            
           }
        
        
        //Mensagens de encerramento
        if(jogador[0] == inimigo[0] && jogador[1] == inimigo[1]){
            System.out.println("---------- GAME OVER - O INIMIGO TE PEGOU -----------");
        }else{
        System.out.println("---------- PARABÉNS VOCÊ ESCAPOU ----------");
        }
                
    }
    //Seleção aleatória de mapas
    static char [][] definirMapa(int [] chave) {
        Random rd = new Random();
        int escolherMapa = rd.nextInt(1, 4);
        char [][] labirinto = new char[15][30];
        
                
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
       //coordenadas de posição da chave
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
    //Imprime o estado atual do mapa
    static void imprimirMapa(char labirinto [][]){
        for(int i = 0; i < labirinto.length; i++){
                for(int j = 0; j < labirinto[i].length; j++){
                    System.out.print(labirinto[i][j]);
                }
                System.out.println();
            }
    }
    //Movimento do jogador
    static char[][] moverJogador(char labirinto [][], int[] jogador ){
       
        Scanner input = new Scanner(System.in);
        
        int linhaJogador = jogador[0];
        int colunaJogador = jogador[1];
        int proximaColuna = colunaJogador; 
        int proximaLinha = linhaJogador;
        
        System.out.println("Sua vez (w/a/s/d):  ");
            String direcao = input.next();
            //limpa a posição anterior do jogador se não for a saída (permite o jogador atravessar a saída sem a chave)
            if(labirinto[jogador[0]][jogador[1]] != 'S'){
               labirinto [linhaJogador][colunaJogador] = ' ';
            }
            
            //direções 
            if(direcao.equals("a") || direcao.equals("A")){
                proximaColuna--;
            }else if(direcao.equals("d") || direcao.equals("D")){
                proximaColuna++;
            }else if(direcao.equals("s") || direcao.equals("S")){
                proximaLinha++;
            }else if(direcao.equals("w") || direcao.equals("W")){
                proximaLinha--;
            }else{
                System.out.println("-- Direção Inválida! Tente apenas w, a, s ou d.");
            }
            
            
            //Colisão com a parede
            if(labirinto[proximaLinha][proximaColuna] == '#'){
                System.out.println("-- Você bateu na parede");
                
                //Mantém a posição atual, não permitindo o jogador se movimentar
                jogador[1] = colunaJogador;
                        
                jogador[0] = linhaJogador;
            }else{
                //atualiza para a nova posição
                jogador[1] = proximaColuna;
                jogador[0] = proximaLinha;
            }
            //Substitui o caractér por P
            if(labirinto[jogador[0]][jogador[1]] != 'S'){
              labirinto [jogador[0]] [jogador[1]] = 'P';
            }
            
            
            return labirinto;
    }
    //função que verifica o status do jogo
    static boolean checarVitoria(boolean ganhou, char[][]labirintoE, int[] jogador, int[]inimigo, boolean temChave){
        //condições de vitória: chegar ao S (Saída) com a chave
        if(labirintoE[jogador[0]][jogador[1]] == 'S' && temChave == true){
            ganhou = true;
        }else if(labirintoE[jogador[0]][jogador[1]] == 'S' && temChave == false){
            //chegar ao fim sem a chave
            ganhou = false;
            System.out.println("-- A porta está trancada! Você precisa da CHAVE (K).");
        }else{
            ganhou = false;
        }
        
        return ganhou;
            
    }
    //Controle de movimentos do inimigo
    static char[][] movimentoInimigo(char labirinto [][], int[] inimigo, int turno){
        //gerador aleatório de geração
        Random rd = new Random();
        int direcao = rd.nextInt(1,5);
        
        
        int linhaInimigo = inimigo[0];
        int colunaInimigo = inimigo[1];
        int proximaColuna = colunaInimigo; 
        int proximaLinha = linhaInimigo;
            
        //Após 3 turnos, o inimigo começa a se mover
        if(turno >= 3){
            
               if(turno == 3){
                   System.out.println("-- CUIDADO O INIMIGO ACORDOU");
               }
               if(labirinto[inimigo[0]][inimigo[1]] != 'P'){
               labirinto [linhaInimigo][colunaInimigo] = ' ';
            }
            
            if(direcao == 1){
                proximaColuna--;
            }else if(direcao == 2){
                proximaColuna++;
            }else if(direcao == 3){
                proximaLinha--;
            }else if(direcao == 4){
                proximaLinha++;
            }
            
            //Colisão com a parede e com a saída
            if(labirinto[proximaLinha][proximaColuna] == '#' || labirinto[proximaLinha][proximaColuna] == 'S'){
                // //Mantém a posição atual, impedindo o inimigo se movimentar para essas coordenadas
                inimigo[1] = colunaInimigo;                        
                inimigo[0] = linhaInimigo;
            }else{
                //atualiza para a nova posição
                inimigo[1] = proximaColuna;
                inimigo[0] = proximaLinha;
            }
            //Substitui o caractér por P
            if(labirinto[inimigo[0]][inimigo[1]] != 'S'){
            labirinto [inimigo[0]] [inimigo[1]] = 'E';
            
            }
        }
        //Adiciona o inimigo ao labirinto
            char[][]labirintoE = labirinto;
        
        return labirintoE;
    }
    
}
 