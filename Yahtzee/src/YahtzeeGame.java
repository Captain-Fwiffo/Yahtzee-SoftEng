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
    int[] handDice;
    boolean keep1;
    boolean keep2;
    boolean keep3;
    boolean keep4;
    boolean keep5;
    
    YahtzeeGame()
    {
        
    }
    
    public int roll()
    {
        int roll = rand.nextInt(6) + 1;
        return roll;
    }
    
    public String getImage(int r)
    {
        return "Dice" + r + ".png";
    }
    
}
