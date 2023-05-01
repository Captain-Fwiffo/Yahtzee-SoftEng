/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Administrator
 */
public class PlayerTest {
    
    Player player = new Player();
    int expResult;
    int result;
    
    int[] testHand1 = {1, 1, 1, 1, 1};
    int[] testHand2 = {2, 2, 2, 2, 2};
    int[] testHand3 = {3, 3, 3, 3, 3};
    int[] testHand4 = {4, 4, 4, 4, 4};
    int[] testHand5 = {5, 5, 5, 5, 5};
    int[] testHand6 = {6, 6, 6, 6, 6};
    int[] testHand3Kind = {6, 6, 6, 5, 2};
    int[] testHand4Kind = {3, 3, 3, 3, 4};
    int[] testHandSmSt = {1, 2, 3, 4, 4};
    int[] testHandLgSt = {1, 2, 3, 4, 5};
    int[] testHandFH = {1, 1, 2, 2, 2};
    int[] testHandCh = {1, 3, 5, 6, 3};
    
    //Individual Hand Score Updates
    @Test
    public void testOnes() {
        result = player.ones(testHandLgSt);
        expResult = 1;
        assertEquals(expResult, result);
        result = player.ones(testHand1);
        expResult = 5;
        assertEquals(expResult, result);
        result = player.ones(testHand3Kind);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testTwos() {
        result = player.twos(testHandLgSt);
        expResult = 2;
        assertEquals(expResult, result);
        result = player.twos(testHand2);
        expResult = 10;
        assertEquals(expResult, result);
        result = player.twos(testHand4Kind);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testThrees() {
        result = player.threes(testHandLgSt);
        expResult = 3;
        assertEquals(expResult, result);
        result = player.threes(testHand3);
        expResult = 15;
        assertEquals(expResult, result);
        result = player.threes(testHand3Kind);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testFours() {
        result = player.fours(testHandLgSt);
        expResult = 4;
        assertEquals(expResult, result);
        result = player.fours(testHand4);
        expResult = 20;
        assertEquals(expResult, result);
        result = player.fours(testHand3Kind);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testFives() {
        result = player.fives(testHandLgSt);
        expResult = 5;
        assertEquals(expResult, result);
        result = player.fives(testHand5);
        expResult = 25;
        assertEquals(expResult, result);
        result = player.fives(testHand4Kind);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testSixes() {
        result = player.sixes(testHandCh);
        expResult = 6;
        assertEquals(expResult, result);
        result = player.sixes(testHand6);
        expResult = 30;
        assertEquals(expResult, result);
        result = player.sixes(testHandLgSt);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void test3Kind(){
        result = player.threeKind(testHand3Kind);
        expResult = 25;
        assertEquals(expResult, result);
        result = player.threeKind(testHandCh);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void test4Kind(){
        result = player.fourKind(testHand4Kind);
        expResult = 16;
        assertEquals(expResult, result);
        result = player.fourKind(testHandCh);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testFullHouse(){
        result = player.fullHouse(testHandFH);
        expResult = 25;
        assertEquals(expResult, result);
        result = player.fullHouse(testHandCh);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testSmallStraight(){
        result = player.smallStraight(testHandSmSt);
        expResult = 30;
        assertEquals(expResult, result);
        result = player.smallStraight(testHandCh);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testLargeStraight(){
        result = player.largeStraight(testHandLgSt);
        expResult = 40;
        assertEquals(expResult, result);
        result = player.largeStraight(testHandCh);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testYahtzee(){
        result = player.yahtzee(testHand1);
        expResult = 50;
        assertEquals(expResult, result);
        result = player.threeKind(testHandCh);
        expResult = 0;
        assertEquals(expResult, result);
    }
    @Test
    public void testChance(){
        result = player.chance(testHandSmSt);
        expResult = 14;
        assertEquals(expResult, result);
        result = player.chance(testHandCh);
        expResult = 18;
        assertEquals(expResult, result);
    }
    @Test
    //Check Valid 
    public void testCheckValid(){
        assertTrue(player.checkValid(0,0));
        player.ones(testHand1);
        assertFalse(player.checkValid(0,0));
        assertTrue(player.checkValid(1, 0));
        player.threeKind(testHand3Kind);
        assertFalse(player.checkValid(1,0));
    }
    @Test
    //Cumulitive Score Updates
    public void testTopUpdates(){
        player.updateTopBeforeBonus();
        player.updateBonus();
        player.updateUpperTotal();
        result = player.getTopScore()[6];
        expResult = 0;
        assertEquals(expResult, result);
        result = player.getTopScore()[7];
        assertEquals(expResult, result);
        result = player.getTopScore()[8];
        assertEquals(expResult, result);
        player.sixes(testHand6);
        player.fives(testHand5);
        player.fours(testHand4);
        player.updateTopBeforeBonus();
        player.updateBonus();
        player.updateUpperTotal();
        result = player.getTopScore()[6];
        expResult = 75;
        assertEquals(expResult, result);
        result = player.getTopScore()[7];
        expResult = 35;
        assertEquals(expResult, result);
        result = player.getTopScore()[8];
        expResult = 110;
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateLowerTotal(){
        player.updateLowerTotal();
        result = player.getBotScore()[7];
        expResult = 0;
        assertEquals(expResult, result);
        player.smallStraight(testHandSmSt);
        player.yahtzee(testHand1);
        player.updateLowerTotal();
        result = player.getBotScore()[7];
        expResult = 80;
        assertEquals(expResult, result);
    }
    @Test
    public void testUpdateGrandTotal(){
        player.updateScores();
        result = player.getBotScore()[8];
        expResult = 0;
        assertEquals(expResult, result);
        player.ones(testHand1);
        player.threes(testHand3);
        player.threeKind(testHand3Kind);
        player.chance(testHandCh);
        player.updateScores();
        result = player.getBotScore()[8];
        expResult = 63;
        assertEquals(expResult, result);
    }
}
   
