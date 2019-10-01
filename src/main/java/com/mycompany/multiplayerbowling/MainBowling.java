/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.multiplayerbowling;

import bowling.SinglePlayerGame;
/**
 *
 * @author pedago
 */
public class MainBowling implements bowling.MultiPlayerGame {

    SinglePlayerGame[] gamesList;
    
    @Override
    public String startNewGame(String[] playerName) throws Exception {
        if(playerName.length<=0){
            throw new java.lang.Exception("Nombre de joueur incorrect");
        } else {
            this.gamesList = new SinglePlayerGame[playerName.length];
            for(int i = 0; i<playerName.length; i++) {
                this.gamesList[i] = new SinglePlayerGame();
            }
        
        return ("Prochain tir : joueur "+ playerName[0] +", tour n° 1, boule n° 1");
        }
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
