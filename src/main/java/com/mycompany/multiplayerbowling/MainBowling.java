/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.multiplayerbowling;

import bowling.SinglePlayerGame;
import java.util.Iterator;
import java.util.Map;
/**
 *
 * @author pedago
 */
public class MainBowling implements bowling.MultiPlayerGame {

    public static final String DISPLAY  = "Prochain tir : joueur %s, tour n° %d, boule n° %d";
    public Map<String,SinglePlayerGame> gameList ;
    //public SinglePlayerGame gameList[];
    public String gamersList[];
    public Iterator player;
    public String currentPlayer;
    public SinglePlayerGame currentGame;
    public boolean end;
    
    
    public String affichage(){
        String s ;
        if(end=true){
            return "Games has ended";
        }
        else{
            //s="Prochain tir : joueur "+currentPlayer+", tour n° "+currentGame.getFrameNumber()+", boule n° "+currentGame.getNextBallNumber()");
            //joueur, currentGame.getFrameNumber(), currentGame.getNextBallNumber()
            int tour = currentGame.getFrameNumber();
            int ball = currentGame.getNextBallNumber();
            return String.format(DISPLAY, currentPlayer, tour, ball);
        }
        //return s;
        
    }
    
    @Override
    public String startNewGame(String[] playerName) throws Exception {
        if((playerName==null)){
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        this.gamersList=playerName;
        
        for(int i=0;i<playerName.length;i++){
            //gameList[i]=(new SinglePlayerGame());
            gameList.put(playerName[i], new SinglePlayerGame());
        }
        currentPlayer=gamersList[0];
        currentGame=gameList.get(currentPlayer);
        player=gameList.keySet().iterator();
        this.end=false;
        return affichage();

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        if(nombreDeQuillesAbattues<0){
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        String joueur = currentPlayer;
        SinglePlayerGame game = currentGame;
        game.lancer(nombreDeQuillesAbattues);
        prochainJoueur();
        return affichage();
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        SinglePlayerGame game = gameList.get(playerName);
		
		if (game == null)
			throw new Exception("Unknown Player");
		
		return game.score();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void prochainJoueur(){
        if(!player.hasNext()){
            if(!currentGame.isFinished()){
                player=gameList.keySet().iterator();
            }
        }
        currentPlayer=(String) player.next();
        currentGame=gameList.get(currentPlayer);

    }
    
    
}
