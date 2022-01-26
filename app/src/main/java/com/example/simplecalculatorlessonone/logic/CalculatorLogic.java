package com.example.simplecalculatorlessonone.logic;

import static com.example.simplecalculatorlessonone.R.id.btn_add_eight;
import static com.example.simplecalculatorlessonone.R.id.btn_add_five;
import static com.example.simplecalculatorlessonone.R.id.btn_add_four;
import static com.example.simplecalculatorlessonone.R.id.btn_add_nine;
import static com.example.simplecalculatorlessonone.R.id.btn_add_onee;
import static com.example.simplecalculatorlessonone.R.id.btn_add_seven;
import static com.example.simplecalculatorlessonone.R.id.btn_add_six;
import static com.example.simplecalculatorlessonone.R.id.btn_add_threee;
import static com.example.simplecalculatorlessonone.R.id.btn_add_twoo;



public class CalculatorLogic {


    public int result;
    StringBuilder stringBuilder = new StringBuilder();


    public void onNumberPressed(int btn_id) {

        if (stringBuilder.length()==0) {

            switch (btn_id) {
                case btn_add_onee:

                    result += 1;
                    break;
                case btn_add_twoo:

                    result += 2;
                    break;
                case btn_add_threee:

                    result += 3;
                    break;

                case btn_add_four:

                    result += 4;
                    break;
                case btn_add_five:

                    result += 5;
                    break;
                case btn_add_six:

                    result += 6;
                    break;
                case btn_add_seven:

                    result += 7;
                    break;

                case btn_add_eight:

                    result += 8;
                    break;

                case btn_add_nine:

                    result += 9;
                    break;





            }

        }


    }

    public String returnText() {
        return String.valueOf(result);
    }

    public int setToZero () {

        result = 0;
        stringBuilder.append(result);

        return Integer.parseInt(stringBuilder.toString());

    }


}