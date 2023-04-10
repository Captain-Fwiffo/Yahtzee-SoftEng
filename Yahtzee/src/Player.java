
import java.util.Arrays;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
public class Player {
    /*topScore index key:
    0 = Ones
    1 = Twos
    2 = Threes
    3 = Fours
    4 = Fives
    5 = Sixes
    6 = Total Before Bonus
    7 = Bonus
    8 = Upper Total
    */
    int[] topScore = {-1, -1, -1, -1, -1, -1, 0, 0, 0}; 
    /*botScore index key:
    0 = 3 of a kind
    1 = 4 of a kind
    2 = Full House
    3 = Small Straight
    4 = Large Straight
    5 = Yahtzee
    6 = Chance
    7 = Lower Total
    8 = Grand Total
    */
    int[] botScore = {-1, -1, -1, -1, -1, -1, -1, 0, 0}; 
    int tempScore, count;
    int playerNumber;
    boolean valid;
    
    Player(int c){
        c = playerNumber;
    }
    
    public int returnPlayer()
    {
        return playerNumber;
    }
    
    public int[] getTopScore(){
        return topScore;
    }
    
    public int[] getBotScore(){
        return botScore;
    }
    //This checks if the score has already been submitted to decide whether or not to allow the submission. Returns true if score can be updated, false if score already submitted
    //inputs are topBot, 0 if top score sheet, 1 if bottom score sheet and index to show the index of the scorecard
    public boolean checkValid(int topBot, int index){
        if(topBot == 0){
            if(topScore[index] == -1)
                return true;
            else
                return false;
        }
        else{
            if(botScore[index] == -1)
                return true;
            else
                return false;
        }
    }
    
    public int ones(int[] hand){
        tempScore = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 1)
                tempScore = tempScore + 1;
        }
        topScore[0] = tempScore;
        return tempScore;
    }
    
    public int twos(int[] hand){
        tempScore = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 2)
                tempScore = tempScore + 2;
        }
        topScore[1] = tempScore;
        return tempScore;
    }
    
    public int threes(int[] hand){
        tempScore = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 3)
                tempScore = tempScore + 3;
        }
        topScore[2] = tempScore;
        return tempScore;
    }
    
    public int fours(int[] hand){
        tempScore = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 4)
                tempScore = tempScore + 4;
        }
        topScore[3] = tempScore;
        return tempScore;
    }
    public int fives(int[] hand){
        tempScore = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 5)
                tempScore = tempScore + 5;
        }
        topScore[4] = tempScore;
        return tempScore;
    }
    
    public int sixes(int[] hand){
        tempScore = 0;
        for(int i = 0; i < hand.length; i++){
            if(hand[i] == 6)
                tempScore = tempScore + 6;
        }
        topScore[5] = tempScore;
        return tempScore;
    }
    
    public int threeKind(int[] hand){
        tempScore = 0;
        valid = false;
        for(int i = 1; i <=6; i++){
            count = 0;
            for(int j = 0; j < hand.length; j++){
                if(hand[j] == i)
                    count++;
            }
            if(count >= 3)
                valid = true;
        }
        if(valid){
            for(int i = 0; i < hand.length; i++)
                tempScore = tempScore + hand[i];
            botScore[0] = tempScore;
            return tempScore;
        }
        else{ 
            botScore[0] = 0;
            return 0;
        }
    }
    
    public int fourKind(int[] hand){
        tempScore = 0;
        valid = false;
        for(int i = 1; i <=6; i++){
            count = 0;
            for(int j = 0; j < hand.length; j++){
                if(hand[j] == i)
                    count++;
            }
            if(count >= 4)
                valid = true;
        }
        if(valid){
            for(int i = 0; i < hand.length; i++)
                tempScore = tempScore + hand[i];
            botScore[1] = tempScore;
            return tempScore;
        }
        else{ 
            botScore[1] = 0;
            return 0;
        }
    }
    
    public int fullHouse(int[] hand){
        tempScore = 0;
        valid = false;
        int three = 0;
        for(int i = 1; i <= 6; i++){
            count = 0;
            for(int j = 0; j < hand.length; j++){
                if(hand[j] == i)
                    count++;
            }
            if(count == 3)
                three = i;
        }
        if(three != 0){
            for(int i = 1; i <= 6; i++){
                count = 0;
                for(int j = 0; j < hand.length; j++){
                    if(hand[j] == i)
                    count++;
                }
                if(count == 2 && three != i)
                    valid = true;
            }
        }
        if(valid){
            for(int i = 0; i < hand.length; i++)
                tempScore = tempScore + hand[i];
            botScore[2] = tempScore;
            return tempScore;
        }
        else{ 
            botScore[2] = 0;
            return 0;
        }
    }
    
    public int smallStraight(int[] hand){
        tempScore = 0;
        count = 0;
        valid = false;
        Arrays.sort(hand);
        for(int i = 0; i < hand.length - 1; i++){
            if(hand[i+1] == hand[i] + 1)
                count++;
            else if(hand[i+1] == hand[i])
                continue;
            else
                count = 0;
        }
        if(count >= 3)
            valid = true;
        if(valid){
            for(int i = 0; i < hand.length; i++)
                tempScore = tempScore + hand[i];
            botScore[3] = tempScore;
            return tempScore;
        }
        else{ 
            botScore[3] = 0;
            return 0;
        }
    }
    
    public int largeStraight(int[] hand){
        tempScore = 0;
        count = 0;
        valid = false;
        Arrays.sort(hand);
        for(int i = 0; i < hand.length - 1; i++){
            if(hand[i+1] == hand[i] + 1)
                count++;
            else
                count = 0;
        }
        if(count == 4)
            valid = true;
        if(valid){
            for(int i = 0; i < hand.length; i++)
                tempScore = tempScore + hand[i];
            botScore[4] = tempScore;
            return tempScore;
        }
        else{ 
            botScore[4] = 0;
            return 0;
        }
    }
    
    public int yahtzee(int[] hand){
        valid = false;
        for(int i = 1; i <= 6; i++){
            count = 0;
            for(int j = 0; j < hand.length; j++){
                if(hand[j] == i)
                    count++;
            }
            if(count == 5)
                valid = true;
        }
        if(valid){
            botScore[5] = 50;
            return 50;
        }
        else{ 
            botScore[5] = 0;
            return 0;
        }
    }
    
    public int chance(int[] hand){
        tempScore = 0;
        for(int i = 0; i < hand.length; i++)
            tempScore = tempScore + hand[i];
        botScore[6] = tempScore;
        return tempScore;
    }
    
    public void updateTopBeforeBonus(){
        topScore[6] = 0;
        for(int i = 0; i < 6; i++){
            if(topScore[i] != -1)
                topScore[6] = topScore[6] + topScore[i];
        }
    }
    
    public void updateBonus(){
        if(topScore[6] >= 63)
            topScore[7] = 35;
    }
    
    public void updateUpperTotal(){
        topScore[8] = topScore[6] + topScore[7];
    }
    
    public void updateLowerTotal(){
        botScore[7] = 0;
        for(int i = 0; i < 7; i++){
            if(botScore[i] != -1)
                botScore[7] = botScore[7] + botScore[i];
        }
    }
    
    public void updateGrandTotal(){
        botScore[8] = topScore[8] + botScore[7];
    }
    
    public void updateScores(){
        this.updateTopBeforeBonus();
        this.updateBonus();
        this.updateUpperTotal();
        this.updateLowerTotal();
        this.updateGrandTotal();
    }
}
