/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
//Stephen Slas
//CS 470 
//Lab 4
package lab4.cs470lab4slas;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.io.*;
import java.util.*;

public class lab4 {
    static Connection conn;
    static Statement stmt;
    static Scanner keyboard;
    static String userSQLInput;
    public static void main( String[] args ) throws IOException{

        keyboard = new Scanner(System.in);
        String username = "ORA_ss245", password = "CS470_3113";
        int input;
        boolean done = false;

        try{
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            System.out.println("Driver registered successfully");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle2.wiu.edu:1521/orclpdb1",username, password);
            System.out.println("Logged in as "+username);
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
        }catch(Exception e){
            System.out.println("Sign in failure");
            return;
        }
        while(!done){

            System.out.println("1: INSERT\n" +"2: UPDATE\n" +"3: QUERY\n" +"0: EXIT");
            keyboard.reset();
            input = keyboard.nextInt();
            keyboard.nextLine();
            keyboard.useDelimiter(";");
            System.out.print("\033[H\033[2J");
            switch (input) {
                case 1:
                    sqlInsert(null);
                    break;
                case 2:
                    sqlUpdate(null);
                    break;
                case 3:
                    sqlQuery(null);
                    break;
                case 0:
                    System.out.println("Goodbye");
                    try{conn.close();}catch(Exception e){System.out.println("Failure to exit");}
                    done = true;
                    break;
                default:
                    System.out.println("Please select a number between 0-3");
                    break;
            }
        }

    }
    public static void sqlInsert(String input){
        try{
            if(input == null) {
                System.out.println("INSERT command: ");
                userSQLInput = keyboard.next();
                keyboard.nextLine();
            }else{
                userSQLInput = input;
            }
            stmt.executeUpdate(userSQLInput);
            System.out.println("INSERT successful");
        }catch(Exception e){
            System.out.println("INSERT exception: "+e);
        }
    }
    public static void sqlUpdate(String input){
        try{
            if(input == null) {
                System.out.println("UPDATE command: ");
                userSQLInput = keyboard.next();
                keyboard.nextLine();
            }else{
                userSQLInput = input;
            }
            stmt.executeUpdate(userSQLInput);
            System.out.println("UPDATE successful");
        }catch(Exception e){
            System.out.println("UPDATE exception: "+e);
        }
    }
    public static void sqlQuery(String input){
        try{
            if(input == null) {
                System.out.println("QUERY command: ");
                userSQLInput = keyboard.next();
                keyboard.nextLine();
            }else{
                userSQLInput = input;
            }
            ResultSet rset = stmt.executeQuery(userSQLInput);
            ResultSetMetaData rsmd = rset.getMetaData();
            for(int i = 1; i<rsmd.getColumnCount() + 1; i++){
                System.out.printf("| %-25s ",rsmd.getColumnName(i));
            }
            System.out.print("\n");
            while(rset.next()){
                for(int i = 1; i<rsmd.getColumnCount() + 1; i++){
                    System.out.printf("| %-25s ",rset.getString(i));
                }
                System.out.println("|");

            }
            System.out.print("\n");
            System.out.println("QUERY successful");
        }catch(Exception e){
            System.out.println("QUERY exception: "+e);
        }
    }

}
