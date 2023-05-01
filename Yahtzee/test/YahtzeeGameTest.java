/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan Byers
 */
public class YahtzeeGameTest {

    
    public YahtzeeGameTest() {
    }

    /**
     * Test of returnCurrentPlayer method, of class YahtzeeGame.
     */
    @Test
    public void testReturnCurrentPlayer() {
        System.out.println("returnCurrentPlayer");
        YahtzeeGame instance = new YahtzeeGame(8);
        int expResult = 1;
        int result = instance.returnCurrentPlayer();
        assertEquals(expResult, result);
        instance.roundEnd();
        instance.roundEnd();
        expResult = 3;
        result = instance.returnCurrentPlayer();
        assertEquals(expResult, result);
        instance.roundEnd();
        instance.roundEnd();
        instance.roundEnd();
        instance.roundEnd();
        instance.roundEnd();
        instance.roundEnd();
        expResult = 1;
        result = instance.returnCurrentPlayer();
        assertEquals(expResult, result);
    }


    /**
     * Test of roundStart method, of class YahtzeeGame.
     */
    @Test
    public void testRoundStart() {
        System.out.println("roundStart");
        YahtzeeGame instance = new YahtzeeGame(2);
        instance.roundStart();
        boolean expResult = false;
        boolean result = instance.getTurnOver();
        assertEquals(expResult, result);
        int expResult2 = 0;
        int result2 = instance.getRollCount();
        assertEquals(expResult2, result2);
        for(int i = 0; i < instance.handDice.length; i++)
        {
            int j = instance.handDice[i];
            assertEquals(expResult2, j);
        }
        instance.rollDice();
        expResult2 = 1;
        result2 = instance.getRollCount();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of roll method, of class YahtzeeGame.
     */
    /**@Test
    public void testRoll() {
        System.out.println("roll");
        YahtzeeGame instance = null;
        int expResult = 0;
        int result = instance.roll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    **/

    /**
     * Test of rollDice method, of class YahtzeeGame.
     */
    @Test
    public void testRollDice() {
        System.out.println("rollDice");
        YahtzeeGame instance = new YahtzeeGame(5);
        int expResult = 0;
        for(int i = 0; i < instance.handDice.length; i++)
        {
            int j = instance.handDice[i];
            assertEquals(expResult, j);
        }
        instance.rollDice();
        expResult = 1;
        assertEquals(expResult, instance.rollCount);
        expResult = instance.handDice[0];
        instance.keeps[0] = true;
        instance.rollDice();
        assertEquals(expResult, instance.handDice[0]);

    }

    /**
     * Test of toggleX method, of class YahtzeeGame.
     */
    /**
    @Test
    public void testToggleX() {
        System.out.println("toggleX");
        int x = 0;
        boolean y = false;
        YahtzeeGame instance = null;
        instance.toggleX(x, y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
**/
    /**
     * Test of resetToggle method, of class YahtzeeGame.
     */
    @Test
    public void testResetToggle() {
        System.out.println("resetToggle");
        YahtzeeGame instance = new YahtzeeGame(4);
        for(int i = 0; i < instance.keeps.length; i++){
            instance.toggleX(i, true);
            assertEquals(true, instance.keeps[i]);
        }
            
        
        instance.resetToggle();
        for(int i = 0; i < instance.keeps.length; i++){
            assertEquals(false, instance.keeps[i]);
        }
    }

    /**
     * Test of getDice method, of class YahtzeeGame.
     */
    /**
    @Test
    public void testGetDice() {
        System.out.println("getDice");
        int req = 0;
        YahtzeeGame instance = null;
        int expResult = 0;
        int result = instance.getDice(req);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }**/

    /**
     * Test of getHand method, of class YahtzeeGame.
     */
    /**
    @Test
    public void testGetHand() {
        System.out.println("getHand");
        YahtzeeGame instance = null;
        int[] expResult = null;
        int[] result = instance.getHand();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }**/

    /**
     * Test of getRollCount method, of class YahtzeeGame.
     */
    @Test
    public void testGetRollCount() {
        System.out.println("getRollCount");
        YahtzeeGame instance = new YahtzeeGame(4);
        int expResult = 0;
        int result = instance.getRollCount();
        assertEquals(expResult, result);
        instance.rollDice();
        result = instance.getRollCount();
        assertEquals(1, result);
    }

    /**
     * Test of rollLimit method, of class YahtzeeGame.
     */
    @Test
    public void testRollLimit() {
        System.out.println("rollLimit");
        YahtzeeGame instance = new YahtzeeGame(7);
        boolean expResult = false;
        boolean result = instance.rollLimit();
        assertEquals(expResult, result);
        instance.rollDice();
        result = instance.rollLimit();
        assertEquals(expResult, result);
        instance.rollDice();
        result = instance.rollLimit();
        assertEquals(expResult, result);
        instance.rollDice();
        result = instance.rollLimit();
        assertEquals(true, result);
    }

    /**
     * Test of getImage method, of class YahtzeeGame.
     */
    @Test
    public void testGetImage() {
        System.out.println("getImage");
        int r = 69;
        YahtzeeGame instance = new YahtzeeGame(16);
        String expResult = "Dice69.png";
        String result = instance.getImage(r);
        assertEquals(expResult, result);
    }

    /**
     * Test of roundEnd method, of class YahtzeeGame.
     */
    @Test
    public void testRoundEnd() {
        System.out.println("roundEnd");
        YahtzeeGame instance = new YahtzeeGame(3);
        instance.roundEnd();
        assertEquals(1, instance.currentPlayer);
        instance.roundEnd();
        assertEquals(2, instance.currentPlayer);
        instance.roundEnd();
        assertEquals(0, instance.currentPlayer);
        assertEquals(2, instance.turnCount);
        for(int i = 0; i < 36; i++)
            instance.roundEnd();
        assertEquals(14, instance.turnCount);
        assertEquals(true, instance.gameOver());

    }

    /**
     * Test of gameOver method, of class YahtzeeGame.
     */
    @Test
    public void testGameOver() {
        System.out.println("gameOver");
        YahtzeeGame instance = new YahtzeeGame(2);
        boolean expResult = false;
        boolean result = instance.gameOver();
        assertEquals(expResult, result);
        for(int i = 0; i < 26; i++)
            instance.roundEnd();
        assertEquals(true, instance.gameOver());

    }

    /**
     * Test of winnar method, of class YahtzeeGame.
     */
    @Test
    public void testWinnar() {
        System.out.println("winnar");
        int[] wiener = {6,6,6,6,6};
        int[] secnd = {5,5,5,5,5};
        int[] turd = {4,4,4,4,4};
        int[] fort = {3,3,3,3,3};
        YahtzeeGame instance = new YahtzeeGame(4);
        int expResult = 69;
        int result = instance.winnar();
        assertEquals(expResult, result);
        instance.chance(wiener);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(secnd);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(turd);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(fort);
        instance.updateScores();
        instance.roundEnd();
        result = instance.winnar();
        assertEquals(1, result);
        instance = new YahtzeeGame(4);
        instance.chance(secnd);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(wiener);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(fort);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(turd);
        instance.updateScores();
        instance.roundEnd();
        result = instance.winnar();
        assertEquals(2, result);
        instance = new YahtzeeGame(4);
        instance.chance(secnd);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(secnd);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(turd);
        instance.updateScores();
        instance.roundEnd();
        instance.chance(fort);
        instance.updateScores();
        instance.roundEnd();
        result = instance.winnar();
        assertEquals(69, result);
        
    }

    /**
     * Test of getTurnOver method, of class YahtzeeGame.
     */
    @Test
    public void testGetTurnOver() {
        System.out.println("getTurnOver");
        YahtzeeGame instance = new YahtzeeGame(2);
        boolean expResult = false;
        boolean result = instance.getTurnOver();
        assertEquals(expResult, result);
        instance.roundStart();
        expResult = false;
        result = instance.getTurnOver();
        assertEquals(expResult, result);
        instance.roundEnd();
        expResult = true;
        result = instance.getTurnOver();
        assertEquals(expResult, result);
    }
    
}
