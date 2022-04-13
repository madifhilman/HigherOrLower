package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber;
    public void randomNumberGenerator()
    {
        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
    public void onGuess(View view){

        try {
            String message;
            EditText editTextNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessedNumber = Integer.parseInt(editTextNumber.getText().toString());

            if(guessedNumber > 0 && guessedNumber < 21){
                if(guessedNumber < randomNumber)
                    message="Higher !!";
                else if(guessedNumber > randomNumber)
                    message="Lower !!";
                else{
                    message="Boom, You got me !!";
                    randomNumberGenerator();
                }
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please input a number (1 - 20) !!", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e){
            Toast.makeText(this, "Please input a number !!", Toast.LENGTH_SHORT).show();
        }


  }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        randomNumber = rand.nextInt(20) + 1;
    }
}