package com.bhagroo.rajendra.opr;

import java.util.Scanner;

/**
 *<h1>Optimal Page Replacement Algorithm</h1>
 * The Raj_OS_Optimal_Page_Replacement program implements the optimal
 * page replacement algorithm on a reference string to simulate page
 * replacement within operating systems.
 *
 *
 * @author  Rajendra Bhagroo
 * @version 9.0
 * @see     Main
 * @see     OptimalPage
 * @since   2017-12-2
 */
public class Main {

    public static void main(String[] args) {

        OptimalPage OptimalAlgorithm = new OptimalPage();

        OptimalAlgorithm.initialize();
        OptimalAlgorithm.simulate();
    }



}//END Main Class






class OptimalPage {

    private Scanner keyboard = new Scanner(System.in);
    private String refString;
    private int frames;


    //Ensures Input Is Numerical
    String numericStringValidation(String msg){

        boolean isInvalid = true;
        String tempString = null;

        while(isInvalid){

            tempString = keyboard.next();

            if(!tempString.matches("[0-9]+")) {

                System.out.println("Please Enter A Numerical " + msg);
                continue;

            } else {

                break;

            }

        } //END WHILE

        return tempString;
    }






    void initialize(){

        System.out.println("Enter A Numerical Reference String");

        //dataValidation Ensures Positive Integer
        refString = numericStringValidation("String");

        //SPLIT STRING TO GET TOKENS, SAVE IN ARRAY




        System.out.println("\nEnter The # Of Frames");

        //dataValidation Ensures Integer.parseInt() Will Not Throw An Exception
        frames = Integer.parseInt(numericStringValidation("Frame"));

    }













    String displayStack(){
        //Displays Index's of Stack based off # of frames
        return "";
    }









    void simulate(){

        System.out.println("\n\nRunning Simulation: \n");
        System.out.println("Start: Memory is: " + displayStack() );

        //Some Sort Of Loop
        System.out.println();
    }






}//END OptimalPage Class





//METHODS
/**
 * Description of Method
 *
 * @param    p1            description
 * @param    p2            description
 * @return                 description
 * @throws   IOException   if...
 */

//VARIABLES
/** Description of variables */