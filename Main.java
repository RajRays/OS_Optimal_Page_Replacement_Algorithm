package com.bhagroo.rajendra.opr;

import java.util.ArrayList;
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


    private ArrayList<Integer> refArrayList = new ArrayList<Integer>();
    private Scanner keyboard = new Scanner(System.in);
    private String[] memArray;
    private String refString;
    private int pageFaults;
    private int frameSize;




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




    private ArrayList<Integer> populateArrayList(String targetString){

        String[] tempArray = targetString.split("");
        ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

        for(int i = 0; i < tempArray.length; i++){
            tempArrayList.add(Integer.parseInt(tempArray[i]));
        }

        return tempArrayList;

    }




    private String[] populateArray(int targetFrameSize){

        String[] tempArray = new String[targetFrameSize];

        for(int i = 0; i < tempArray.length ; i++){
            tempArray[i] = "*";
        }

        return tempArray;

    }




    void initialize(){

        System.out.println("Enter A Numerical Reference String");

        //dataValidation Ensures Positive Integer
        refString = numericStringValidation("String");

        //Populates refArrayList Class Variable
        refArrayList = populateArrayList(refString);



        System.out.println("\nEnter The # Of Frames");

        //dataValidation Ensures Integer.parseInt() Will Not Throw An Exception
        frameSize = Integer.parseInt(numericStringValidation("Frame"));
        memArray = populateArray(frameSize);

    }




    private String displayArray(String[] targetArray, int targetFrames){

        String tempString = "";

        for(int i = 0; i < targetFrames; i++){
            tempString += targetArray[i];
        }

        return tempString;
    }


//Almost Done, Fix Paramters and Javadoc Annotations

    private void mutateArray(String[] targetArray, ArrayList<Integer> targetArrayList, int currentCount){

        if(currentCount < memArray.length){

            targetArray[currentCount] = targetArrayList.get(currentCount).toString();

            pageFaults++;

            System.out.println(refArrayList.get(currentCount)
                    + ": Memory is: "
                    + displayArray(memArray, frameSize)
                    + ": Page Fault: "
                    + " (Number of Page Faults: "
                    + pageFaults);

            currentCount++;

        } else {

            System.out.println(refArrayList.get(currentCount)
                    + ": Memory is: "
                    + displayArray(memArray, frameSize)
                    + ": Hit: \t\t"
                    + "(Number of Page Faults: "
                    + pageFaults);

            currentCount++;

        }

    }




    void simulate(){

        System.out.println("\n\nRunning Simulation: \n");
        System.out.println("Start: Memory is: " + displayArray(memArray,frameSize));

        for(int i = 0; i < refArrayList.size(); i++){

            mutateArray(memArray, refArrayList, i);

        }

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

// Reference String = 70120304230321201701