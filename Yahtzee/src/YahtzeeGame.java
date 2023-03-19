/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */

import java.util.Random;

public class YahtzeeGame 
{
    
    Random rand = new Random();
    int[] handDice = {0,0,0,0,0};
    boolean[] keeps = {false, false, false, false, false};
    int rollCount;
    
    YahtzeeGame()
    {
        
    }
    
    public void roundStart()
    {
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
    
}
