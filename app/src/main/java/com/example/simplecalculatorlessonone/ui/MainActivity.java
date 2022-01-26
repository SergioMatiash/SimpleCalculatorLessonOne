package com.example.simplecalculatorlessonone.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.simplecalculatorlessonone.R;
import com.example.simplecalculatorlessonone.logic.CalculatorLogic;

public class MainActivity extends AppCompatActivity {

    //declare variables
    TextView returnResult;
    Button cleardata;
    ProgressDialog progressDialog;

    public CalculatorLogic calculator;

   //find view




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cleardata=findViewById(R.id.btn_clear);


        int[] pressedNumbers = new int[]{
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

        returnResult = findViewById(R.id.tv_result);

        //creating instance/ object of calculator

        calculator = new CalculatorLogic();
        View.OnClickListener numberOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //initialize Progress dialog

                progressDialog = new ProgressDialog(MainActivity.this);
                //showing dialog
                progressDialog.show();
                //setting content view
                progressDialog.setContentView(R.layout.progress_dialog);
                //set transparent background
                progressDialog.getWindow().setBackgroundDrawableResource(
                        android.R.color.transparent
                );



                //we are calling method for button pressed
                calculator.onNumberPressed(view.getId());

                //returning result on screen
                returnResult.setText(calculator.returnText());
                //change color of button pressed
                cleardata.setTextColor(Color.rgb(241,145,155));
            }
        };

        //linking it with our buttons array

        for (int i = 0; i < pressedNumbers.length; i++) {

            //we are finding id of every eack elements in array and assign click listener to int
            findViewById(pressedNumbers[i]).setOnClickListener(numberOnClickListener);


        }



        cleardata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult.setText(String.valueOf(calculator.setToZero()));
                cleardata.setTextColor(Color.BLUE);

            }
        });






    }

    @Override
    public void onBackPressed() {
        //dissmissing progress dialog
        progressDialog.dismiss();
    }
}