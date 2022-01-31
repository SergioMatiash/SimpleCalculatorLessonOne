package com.example.simplecalculatorlessonone.logic;


import android.view.View;

import com.example.simplecalculatorlessonone.R;
import com.jackandphantom.customtogglebutton.CustomToggle;

public class CalculatorLogic {

    /*figure out what class should do*/

    /**
     * Appropriate logic shoud be implemented - we need to modules - 1 for number realization (input numbers) -- 2 for realizing the fuctions 3-- reset
     * Function to be implemented - addition, substraction, division, multiplication
     * We need buffer where result should be stored
     * After pressing button Result the actions with numbers should be done and set to textview
     *
     *
     * */
    /*enumming values and methods*/

    /**
     * We need to set array of buttons
     * as well as array of functions
     * The appropriate states need to be implemented like mentioned: there is no value (set as zero for default), one value transferred, result is kept
     *
     * */

    /*writing pseudo - code*/
    /**
     * DECLARE ---- int array for buttons
     *
     *
     * DECLARE ---- int array for function buttons
     * SET ---- enum class with states
     *
     *  CREATE ---- method which accepts string value
     *  TRANSFORM --- that value to int
     *  PASS --- that value into the method
     *     CHECK:
     *
     *          IF ---- 2 values added we need to set status to weGetResult and now we could reset the value to initial as 0
     *
     *          ELSE IF --- its very first value we need to change state to onevalue added and add this value to the buffer
     *
     *
     *          ELSE --- we need to add value to previously settled one in the buffer
     *
     * OBTAIN --- users input (as button click)
     * TRANSFORM ---- it into value to be sent to the result
     *
     *
     *
     *
     * CHANGE button - set for REDEFINING button  +- need to be transfered to *%
     *
     * */


    /*realizing class*/

   public int firstArg, secondArg;
   public State state;
   public int actionSelected;

   public StringBuilder stringBuilder = new StringBuilder();
   public CustomToggle toggle;



    public CalculatorLogic() {
        state= State.firstArgInput;
    }

    public void onNumberPressed (int buttonId) {
        if (state ==State.resultShow) {
            state = State.firstArgInput;
            stringBuilder.setLength(0);
        }
        if (stringBuilder.length()<10) {
            switch (buttonId) {
                case R.id.btn_add_onee:
                    stringBuilder.append("1");
                    break;
                case R.id.btn_add_twoo:
                    stringBuilder.append("2");
                    break;
                case R.id.btn_add_threee:
                    stringBuilder.append("3");
                    break;
                case R.id.btn_add_four:
                    stringBuilder.append("4");
                    break;
                case R.id.btn_add_five:
                    stringBuilder.append("5");
                    break;

                case R.id.btn_add_six:
                    stringBuilder.append("6");
                    break;

                case R.id.btn_add_seven:
                    stringBuilder.append("7");
                    break;
                case R.id.btn_add_eight:
                    stringBuilder.append("8");
                    break;
                case R.id.btn_add_nine:
                    stringBuilder.append("9");
                    break;
            }


        }
    }

    public void onActionPressed (int actionId) {

        if (actionId == R.id.btn_equals && state==State.secondArgInput) {
            secondArg = Integer.parseInt(stringBuilder.toString());
            state = State.resultShow;
            stringBuilder.setLength(0);
            switch (actionId) {
                //add here switching method
                case R.id.btn_addition:
                    stringBuilder.append(firstArg+secondArg);
                    break;
                case R.id.btn_substract:
                    stringBuilder.append(firstArg-secondArg);
                    break;
            }
        } else if (stringBuilder.length()>0 && state == State.firstArgInput) {
            firstArg = Integer.parseInt(stringBuilder.toString());
            state = State.secondArgInput;
            stringBuilder.setLength(0);

            switch (actionId) {
                case R.id.btn_addition:
                   actionSelected = R.id.btn_addition;
                   break;
                case R.id.btn_substract:
                    actionSelected = R.id.btn_substract;
                    break;
            }

        }
    }



//check - it works
    public void onClearPressed (int actionId) {
       if (actionId == R.id.btn_clear && stringBuilder.length()!=0) {
           stringBuilder.setLength(0);
       }
    }

    public void addingToMultiply (int actionId) {
        if (actionId == R.id.btn_addition) {
            stringBuilder.append(firstArg*secondArg);
        }
    }


    public String getText () {

        return stringBuilder.toString();
    }

    /*testing methods*/


    /*debugging*/


    /*so now we are checking mistakes*/

}