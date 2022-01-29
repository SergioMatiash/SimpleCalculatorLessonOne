package com.example.simplecalculatorlessonone.ui;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.simplecalculatorlessonone.R;

import com.example.simplecalculatorlessonone.logic.CalculatorLogic;
import com.jackandphantom.customtogglebutton.CustomToggle;

public class MainActivity extends AppCompatActivity {

    public TextView screenResult;
    public CalculatorLogic calculatorlogic;


    //values
    //DECLARE ---- int array for buttons

    int[] numberButtons = new int[] {

            R.id.btn_add_onee,
            R.id.btn_add_twoo,
            R.id.btn_add_threee,
            R.id.btn_add_four,
            R.id.btn_add_five,
            R.id.btn_add_six,
            R.id.btn_add_seven,
            R.id.btn_add_eight,
            R.id.btn_add_nine


    };

    int [] functions = new int[] {
            R.id.btn_addition,
            R.id.btn_clear,
            R.id.btn_equals,
            R.id.btn_substract

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //view finding
        Button add_multiply = findViewById(R.id.btn_addition);
        Button substract_divide = findViewById(R.id.btn_substract);
        screenResult = findViewById(R.id.tv_result);
        calculatorlogic = new CalculatorLogic();
        CustomToggle lottieCheckedButton = (CustomToggle)  findViewById(R.id.lot_toggle_changer_function);

        //setting click listeners

        View.OnClickListener numberPressedListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };

        View.OnClickListener functionPressedListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        };


        //matching buttons and listeners

        for (int buttonNumber: numberButtons) {
            findViewById(buttonNumber).setOnClickListener(numberPressedListener);

        }
        for (int functionId:functions) {
            findViewById(functionId).setOnClickListener(functionPressedListener);
        }

        //set up toggle button for changing button add/multiply and subtract/divide


        lottieCheckedButton.setMagnification(9);
        lottieCheckedButton.setSlideBackgroundColor(Color.BLACK);
        lottieCheckedButton.setAnimationTime(700);
        lottieCheckedButton.setSlideColor(Color.GREEN);
        lottieCheckedButton.setOnToggleClickListener(new CustomToggle.OnToggleClickListener(){
            @Override
            public void onLefToggleEnabled(boolean enabled) {
                substract_divide.setText("-");
                add_multiply.setText("+");
            }

            @Override
            public void onRightToggleEnabled(boolean enabled) {
                substract_divide.setText("%");
                add_multiply.setText("*");
            }


            /*@Override
            public void onClick(View v) {
                if (ischeckDone) {

                    ischeckDone=false;




                } else {


                    ischeckDone=true;

                }
            }*/
        });




    }

}