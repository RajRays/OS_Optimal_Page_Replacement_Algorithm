package com.bhagroo.rajendra.opr;

import java.util.LinkedList;
import java.util.Queue;
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

    private Queue<Integer> refStringQueue = new LinkedList<Integer>();;
    private Scanner keyboard = new Scanner(System.in);
    private String refString;
    private int frames;




    //Ensures Input Is Numerical
    private String numericStringValidation(String msg){

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




    private Queue<Integer> populateQueue(String targetString){

        String[] tempArray = targetString.split("");
        Queue<Integer> tempQueue = new LinkedList<Integer>();;

        for(int i = 0; i < targetString.length(); i++){
            tempQueue.add(Integer.parseInt(tempArray[i]));
        }

        return tempQueue;

    }




    void initialize(){

        System.out.println("Enter A Numerical Reference String");

        //dataValidation Ensures Positive Integer
        refString = numericStringValidation("String");

        //Populates refStringQueue Class Variable
        refStringQueue = populateQueue(refString);



        System.out.println("\nEnter The # Of Frames");

        //dataValidation Ensures Integer.parseInt() Will Not Throw An Exception
        frames = Integer.parseInt(numericStringValidation("Frame"));

    }




    private String displayStack(){
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