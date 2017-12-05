package com.bhagroo.rajendra.opr;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h1>Optimal Page Replacement Algorithm Implementation</h1>
 * The Raj_OS_Optimal_Page_Replacement Program Implements The Optimal
 * Page Replacement Algorithm On A Reference String To Simulate Page
 * Replacement Within Operating Systems.
 * <p>
 * <b>Sample Reference String : 70120304230321201701</b>
 *
 * @author  Rajendra Bhagroo
 * @version 9.0
 * @see     Main
 * @see     OptimalPage
 * @since   2017-12-2
 */
public class Main {

    public static void main(String... args) {

        OptimalPage OptimalAlgorithm = new OptimalPage();

        OptimalAlgorithm.initialize();
        OptimalAlgorithm.simulate();

    }

}//END Main Class


/**
 * Program Defined From "OptimalPage" Class, Executed Within "Main" Class
 */
class OptimalPage {

    /**
     * Used To Store Numerical Values From "refString"
     */
    private ArrayList<Integer> refArrayList = new ArrayList<Integer>();

    /**
     * Used To Obtain Input From User
     */
    private Scanner keyboard = new Scanner(System.in);

    /**
     * Used To Emulate Memory Using "frameSize"
     */
    private String[] memArray;

    /**
     * Used As Raw Input Of Reference String From User
     */
    private String refString;

    /**
     * Used To Track Number Of Page Faults
     */
    private int pageFaults;

    /**
     * Used As Raw Input Of Frame Size From User
     */
    private int frameSize;


    /**
     * Eliminates Need For Exception Handling As Method
     * Ensures Input Is A Positive Numerical String.
     * If Not, Method Loops And Asks For Valid Input.
     *
     * @param  msg           Message To Be Shown To User If Invalid Reference String/Frame Is Entered
     * @return tempString    To Be Saved Within Variables "refString" , "frameSize"
     */
    private String numericStringValidation(String msg) {

        boolean isInvalid = true;
        String tempString = null;

        while (isInvalid) {

            tempString = keyboard.next();

            if (!tempString.matches("[0-9]+")) {
                System.out.println("Please Enter A Numerical " + msg);
                continue;
            } else {
                break;
            }

        } //END WHILE

        return tempString;

    }


    /**
     * Takes "refString" Entered By User,
     * Creates New ArrayList Of Type Integer,
     * Splits "refString" Into Separate Numbers,
     * Fills "tempArrayList" With Each Number.
     *
     * @param  targetString            "refString" Entered By User
     * @return tempArrayList           Copies Contents Into "refArrayList"
     */
    private ArrayList<Integer> populateArrayList(String targetString) {

        String[] tempArray = targetString.split("");
        ArrayList<Integer> tempArrayList = new ArrayList<Integer>();

        for (int i = 0; i < tempArray.length; i++) {
            tempArrayList.add(Integer.parseInt(tempArray[i]));
        }

        return tempArrayList;

    }


    /**
     * Takes "frameSize" Entered By User And Fills
     * Every Index Of "tempArray" With Asterisks
     *
     * @param  targetFrameSize "frameSize" Entered By User
     * @return tempArray        Copies Contents Into "memArray"
     */
    private String[] populateArray(int targetFrameSize) {

        String[] tempArray = new String[targetFrameSize];

        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = "*";
        }

        return tempArray;

    }


    /**
     * ONLY METHOD To Ask/Receive USER INPUT
     * <p>
     * Initializes Class Variables...
     * <p>
     * "refString",
     * "refArrayList",
     * "frameSize",
     * "memArray",
     * <p>
     * And Uses...
     * <p>
     * "numericStringValidation()"
     * "populateArrayList()"
     * "populateArray()"
     * <p>
     * Methods To Achieve The Following...
     * <p>
     * "refString" -> INITIALIZE -> "refArrayList"
     * "frameSize" -> INITIALIZE -> "memArray"
     * <p>
     * Method Is Called Within Main Class.
     *
     * @return Nothing
     */
    void initialize() {

        System.out.println("Enter A Numerical Reference String");

        //numericStringValidation() Ensures Positive Integer
        refString = numericStringValidation("String");

        //Populates "refArrayList" Class Variable
        refArrayList = populateArrayList(refString);


        System.out.println("\nEnter The # Of Frames");

        //numericStringValidation() Ensures Integer.parseInt() Will Not Throw An Exception
        frameSize = Integer.parseInt(numericStringValidation("Frame"));

        memArray = populateArray(frameSize);

        keyboard.close();

    }


    /**
     * Displays Contents Of "memArray" To User, To Be Used Within Print Statement.
     *
     * @param  targetArray  Used As A Temporary Array To Copy Contents Into "memArray"
     * @param  targetFrames Used As A Max Limit To Reach Last Index Of "targetArray"
     * @return tempString   Used To Embed Contents Of Current Array In A Print Statement
     */
    private String displayArray(String[] targetArray, int targetFrames) {

        String tempString = "";

        for (int i = 0; i < targetFrames; i++) {
            tempString += targetArray[i];
        }

        return tempString;
    }


    /**
     * If The Current Reference Variable Within "refArrayList" Is Found Within ANY Index
     * Of "memArray"...Return True [No Page Fault], Else Return False [Page Fault].
     * If Index At "memArray" Is Not A Numerical Value [Page Fault].
     *
     * @param  targetArrayList Used As A Placeholder For "refArrayList"
     * @param  targetArray     Used As A Placeholder For "memArray"
     * @param  currentCount    Used As A Placeholder For "i" Within "simulate() -> checkForFault()"
     * @return isEqual         Used Within "checkForFault()" Method To Determine If Page Fault Occurred
     */
    private boolean currentRefEquals(ArrayList<Integer> targetArrayList, String[] targetArray, int currentCount) {

        boolean isEqual = false;

        for (int i = 0; i < frameSize; i++) {

            if (targetArrayList.get(currentCount).toString().equals(targetArray[i])
                    & targetArray[currentCount % frameSize].matches("[0-9]")) {

                isEqual = true;

            }

        }

        return isEqual;

    }


    /**
     * Called Within "checkForFault()" Method To Handle Page Fault. Prior To Execution Program Knows
     * There Is A Page Fault. First Portion Of "if...else" Block Replaces Any Non Numerical String
     * Within "memArray" With Numerical Value From "refArrayList". Second Portion Of "if...else" Block
     * Uses Personal Solution To "Optimal Page Replacement Algorithm".
     * <p>
     * Effectively, The Current Values Across All Index's Of "memArray" Are Compared Against The
     * Remaining Values Of "refArrayList" To Calculate The Index And Value Within "memArray" That
     * Will Not Be Seen For The Longest Period Of Time. This Index Is Replaced By The Current
     * Value Of "refArrayList".
     *
     * @param  targetArray     Used As A Placeholder For "memArray"
     * @param  targetArrayList Used As A Placeholder For "refArrayList"
     * @param  currentCount    Used As A Placeholder For "i" Within "simulate() -> checkForFault()"
     * @return Nothing
     */
    private void fault(String[] targetArray, ArrayList<Integer> targetArrayList, int currentCount) {

        //Current Value In Array Must Be A Numerical Value
        if (!targetArray[currentCount % frameSize].matches("[0-9]")) {

            targetArray[currentCount % frameSize] = targetArrayList.get(currentCount).toString();

        } else {
            //Run Algorithm To Manipulate Array Index To Replace With Largest Traversal

            String currentVal = targetArrayList.get(currentCount).toString();

            int traversals = 0;
            int length = 0;
            int largestTraversal = -1;
            int indexOfLargest = 0;
            int oldCount = currentCount;

            //Cycles Through Each Element Of "memArray"
            while (length < frameSize) {

                //Counts Number Of Traversals For Each Element In "refArrayList"
                for (; currentCount < targetArrayList.size(); currentCount++) {

                    if (!targetArrayList.get(currentCount).toString().equals(targetArray[length])) {
                        traversals++;
                    } else {

                        if (largestTraversal < traversals) {
                            largestTraversal = traversals;
                            indexOfLargest = length;
                        }

                        continue;

                    }

                }//END FOR LOOP

                length++;
                currentCount = oldCount;
                traversals = 0;

            }//END WHILE LOOP

            //Changes Index Of "memArray" With Largest Traversal [Value That Is Not Seen For Longest Time]
            targetArray[indexOfLargest] = currentVal;

        }

    }


    /**
     * Called From Within "simulate()" Method. This Method Uses The "fault()" Method To
     * Determine If There Is A Page Fault. This Method Also Tracks And Increments "pageFaults",
     * And "currentCount" Variables. "currentCount" Is Derived From "i" Within The "simulate()"
     * Method Which Cycles Through All Elements Of "refArrayList". User Is Notified of...
     * Current Value Within "refArrayList" -> Current Contents Of "memArrayList" As Well
     * As If A Page Fault Occurred Or If There Was A Hit [Number Already Existed Within "memArray"].
     * The Current Number Of "pageFaults" Is Then Displayed To The User.
     *
     * @param  targetArray     Used As A Placeholder For "memArray"
     * @param  targetArrayList Used As A Placeholder For "refArrayList"
     * @param  currentCount    Used As A Placeholder For "i" Within "simulate()"
     * @return description
     */
    private void checkForFault(String[] targetArray, ArrayList<Integer> targetArrayList, int currentCount) {


        if (!currentRefEquals(targetArrayList, targetArray, currentCount)) {

            //Current Index In "refArrayList" != Any # In "memArray"
            fault(memArray, refArrayList, currentCount);

            pageFaults++;

            System.out.println(targetArrayList.get(currentCount)
                    + ": Memory is: "
                    + displayArray(targetArray, frameSize)
                    + ": Page Fault: "
                    + " (Number of Page Faults: "
                    + pageFaults
                    + ")");

            currentCount++;

        } else {

            //Current Index In "refArrayList" == Any # In "memArray"
            System.out.println(targetArrayList.get(currentCount)
                    + ": Memory is: "
                    + displayArray(memArray, frameSize)
                    + ": Hit: \t\t"
                    + "(Number of Page Faults: "
                    + pageFaults
                    + ")");

            currentCount++;

        }

    }


    /**
     * Traverses "refArrayList" And Notifies Users Of Page Fault or Hit For Each Element
     * Found Within "refArrayList". Method Is Called Within "Main" Class.
     *
     * @return Nothing
     */
    void simulate() {

        System.out.println("\n\nRunning Simulation: \n");
        System.out.println("Start: Memory is: " + displayArray(memArray, frameSize));

        for (int i = 0; i < refArrayList.size(); i++) {

            checkForFault(memArray, refArrayList, i);

        }

        System.out.println("Total Number Of Page Faults: " + pageFaults);

    }


}//END OptimalPage Class