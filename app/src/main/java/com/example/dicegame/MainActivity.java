package com.example.dicegame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int count;
    private int finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        //rollDice
        Button buttonThrow = findViewById(R.id.buttonThrow);
        buttonThrow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finalResult += rollDice();
                TextView resultGame = findViewById(R.id.resultGame);
                resultGame.setText("Wynik gry: " + finalResult);
                count++;
                TextView throwCount = findViewById(R.id.throwCount);
                throwCount.setText("Liczba rzutów: " + count);
            }
        });

        //resetGame
        Button reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetGame();
            }
        });
    }


    public int rollDice(){
        ArrayList<Integer> list = new ArrayList();
        Random random = new Random();
        for(int i =0 ; i<5; i++){
            int n = random.nextInt(5) + 1;
            list.add(n);
        }

        int result = 0;
        for(int o=0; o<list.size(); o++){
            result += list.get(o);
        }

        TextView resultCurrent = findViewById(R.id.resultCurrent);
        resultCurrent.setText("Wynik tego losowania: " + result);

        TextView r1 = findViewById(R.id.r1);
        TextView r2 = findViewById(R.id.r2);
        TextView r3 = findViewById(R.id.r3);
        TextView r4 = findViewById(R.id.r4);
        TextView r5 = findViewById(R.id.r5);

        r1.setText(list.get(0).toString());
        r2.setText(list.get(1).toString());
        r3.setText(list.get(2).toString());
        r4.setText(list.get(3).toString());
        r5.setText(list.get(4).toString());

        Log.d("alo da", String.valueOf(list));
        Log.d("alo da", String.valueOf(result));

        return result;
    }

    public void resetGame(){
        TextView resultCurrent = findViewById(R.id.resultCurrent);
        TextView resultGame = findViewById(R.id.resultGame);
        TextView throwCount = findViewById(R.id.throwCount);
        TextView r1 = findViewById(R.id.r1);
        TextView r2 = findViewById(R.id.r2);
        TextView r3 = findViewById(R.id.r3);
        TextView r4 = findViewById(R.id.r4);
        TextView r5 = findViewById(R.id.r5);

        resultCurrent.setText("Wynik tego losowania: ");
        resultGame.setText("Wynik gry: ");
        throwCount.setText("Liczba rzutów: 0");
        r1.setText("?");
        r2.setText("?");
        r3.setText("?");
        r4.setText("?");
        r5.setText("?");

        count = 0;
        finalResult = 0;
    }

}