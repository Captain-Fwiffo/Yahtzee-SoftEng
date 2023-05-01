/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */

import java.util.Random;
import java.util.LinkedList;

public class YahtzeeGame 
{
    
    Random rand = new Random();
    int[] handDice = {0,0,0,0,0};
    boolean[] keeps = {false, false, false, false, false};
    int rollCount;
    int playerCount;
    int currentPlayer;
    Player[] players;
    boolean turnOver;
    int turnCount;
    boolean endOfGame = false;
    int winner;
    
    
    YahtzeeGame(int p)
    {
       playerCount = p;
       players = new Player[playerCount];

       for(int i = 0; i < playerCount; i++)
       {
           players[i] = new Player();
       }
       currentPlayer = 0;
       turnCount = 1;
    }
    
    
    //Beginning of Player Functions
    public int returnCurrentPlayer()
    {
        return currentPlayer + 1;
    }
    
    public int[] getTopScore(){
        return players[currentPlayer].getTopScore();
    }
    
    public int[] getBotScore(){
        return players[currentPlayer].getBotScore();
    }
    
    public int getPlayerScore(int player){
        return players[player].botScore[8];
    }
    
    public boolean checkValid(int topBot, int index){
        return players[currentPlayer].checkValid(topBot, index);
    }
    
    public int getOnes()
    {
        return players[currentPlayer].topScore[0];
    }
    public int getTwos()
    {
        return players[currentPlayer].topScore[1];
    }
    public int getThrees()
    {
        return players[currentPlayer].topScore[2];
    }
    public int getFours()
    {
        return players[currentPlayer].topScore[3];
    }
    public int getFives()
    {
        return players[currentPlayer].topScore[4];
    }
    public int getSixes()
    {
        return players[currentPlayer].topScore[5];
    }
    
    public int getThreeKind()
    {
        return players[currentPlayer].botScore[0];
    }
    
    public int getFourKind()
    {
        return players[currentPlayer].botScore[1];
    }
    
    public int getFullHouse()
    {
        return players[currentPlayer].botScore[2];
    }
    
    public int getSmallStraight()
    {
        return players[currentPlayer].botScore[3];
    }
    
    public int getLargeStraight()
    {
        return players[currentPlayer].botScore[4];
    }
    
    public int getYahtzee()
    {
        return players[currentPlayer].botScore[5];
    }
    
    public int getChance()
    {
        return players[currentPlayer].botScore[6];
    }
    
    public int ones(int[] hand){
        return players[currentPlayer].ones(hand);
    }
    
    public int twos(int[] hand){
        return players[currentPlayer].twos(hand);
    }
    
    public int threes(int[] hand){
        return players[currentPlayer].threes(hand);
    }
    
    public int fours(int[] hand){
        return players[currentPlayer].fours(hand);
    }
    public int fives(int[] hand){
        return players[currentPlayer].fives(hand);
    }
    
    public int sixes(int[] hand){
        return players[currentPlayer].sixes(hand);
    }
    
    public int threeKind(int[] hand){
        return players[currentPlayer].threeKind(hand);
    }
    
    public int fourKind(int[] hand){
        return players[currentPlayer].fourKind(hand);
    }
    
    public int fullHouse(int[] hand){
        return players[currentPlayer].fullHouse(hand);
    }
    
    public int smallStraight(int[] hand){
        return players[currentPlayer].smallStraight(hand);
    }
    
    public int largeStraight(int[] hand){
        return players[currentPlayer].largeStraight(hand);
    }
    
    public int yahtzee(int[] hand){
        return players[currentPlayer].yahtzee(hand);
    }
    
    public int chance(int[] hand){
        return players[currentPlayer].chance(hand);
    }
    
    public void updateTopBeforeBonus(){
        players[currentPlayer].updateTopBeforeBonus();
    }
    
    public void updateBonus(){
        players[currentPlayer].updateBonus();
    }
    
    public void updateUpperTotal(){
        players[currentPlayer].updateUpperTotal();
    }
    
    public void updateLowerTotal(){
        players[currentPlayer].updateLowerTotal();
    }
    
    public void updateGrandTotal(){
        players[currentPlayer].updateGrandTotal();
    }
    
    public void updateScores(){
        players[currentPlayer].updateScores();
    }
    //End of player related functions
    
    public void roundStart()
    {
        turnOver = false;
        rollCount = 0;
        for(int i = 0; i < handDice.length; i++)
        {
            handDice[i] = 0;
        }
        for(int i = 0; i < handDice.length; i++)
        {
            keeps[i] = false;
        }
    }
    
    
    //Beginning of dice related functions
    public int roll()
    {
        int roll = rand.nextInt(6) + 1;
        return roll;
    }
    
    public void rollDice()
    {
        for(int i = 0; i < handDice.length; i++)
        {
            if(keeps[i] == false)
            {
                handDice[i] = this.roll();
            }
        }
        rollCount++;
        
    }
    
    public void toggleX(int x, boolean y)
    {
        if(y == true)
        {
            keeps[x] = true;
        }
        if(y == false)
        {
            keeps[x] = false;
        }
    }
    
    public void resetToggle(){
        for(int i = 0; i < keeps.length; i++){
            keeps[i] = false;
        }
    }
    
    public int getDice(int req)
    {
        return handDice[req];
    }
    
    public int[] getHand(){
        return handDice;
    }
    
    public int getRollCount()
    {
        return rollCount;
    }
    
    public boolean rollLimit()
    {
        if(rollCount >= 3)
        {
            return true;
        }
        return false;
    }
    
    public String getImage(int r)
    {
        return "Dice" + r + ".png";
    }
    
    public void roundEnd()
    {
        turnOver = true;

        
        if(currentPlayer == (playerCount - 1))
        {
            currentPlayer = 0;
            turnCount++;
        }
        else
        {
            currentPlayer++;
        }
        if(turnCount > 13)
        {
            endOfGame = true;
        }
    }
    
    public boolean gameOver()
    {
        return endOfGame;
    }
    
    public int winnar()
    {
        int temp = 0;
        for(int i = 0; i < playerCount; i++){
            if(getPlayerScore(i) > temp){
                temp = getPlayerScore(i);
                winner = i + 1;
                        
                }
            else if(getPlayerScore(i) == temp){
                return 69;
                }
          
         }
         return winner;
    }
    
    public boolean getTurnOver()
    {
        return turnOver;
    }
    
}
