package com.example.android.stonepaperscizzor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_stone, b_paper, b_scizzor;
    ImageView iv_cpu, iv_me;

    String myChoice, cpuChoice, result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_me = (ImageView) findViewById(R.id.iv_me);

        b_stone = (Button) findViewById(R.id.b_stone);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_scizzor = (Button) findViewById(R.id.b_scizzor);

        r = new Random();

        b_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Stone";
                iv_me.setImageResource(R.drawable.stone);
                calculate();
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Paper";
                iv_me.setImageResource(R.drawable.paper);
                calculate();
            }
        });
        b_scizzor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myChoice = "Scizzor";
                iv_me.setImageResource(R.drawable.scizzor);
                calculate();
            }
        });
    }

    public void calculate() {
        int cpu = r.nextInt(3);
        if (cpu == 0) {
            cpuChoice = "Stone";
            iv_cpu.setImageResource(R.drawable.stone);
        } else if (cpu == 1) {
            cpuChoice = "Paper";
            iv_cpu.setImageResource(R.drawable.paper);
        } else if (cpu == 2) {
            cpuChoice = "Scizzor";
            iv_cpu.setImageResource(R.drawable.scizzor);
        }

        if (myChoice.equals("Stone") && cpuChoice.equals("Paper")) {
            result = "You lose!";
        } else if (myChoice.equals("Stone") && cpuChoice.equals("Scizzor")) {
            result = "You win!";
        } else if (myChoice.equals("Stone") && cpuChoice.equals("Stone")) {
            result = "Draw!";
        } else if (myChoice.equals("Paper") && cpuChoice.equals("Paper")) {
            result = "Draw!";
        } else if (myChoice.equals("Paper") && cpuChoice.equals("Scizzor")) {
            result = "You lose!";
        } else if (myChoice.equals("Paper") && cpuChoice.equals("Stone")) {
            result = "You win!";
        } else if (myChoice.equals("Scizzor") && cpuChoice.equals("Paper")) {
            result = "You win!";
        } else if (myChoice.equals("Scizzor") && cpuChoice.equals("Scizoor")) {
            result = "Draw!";
        } else if (myChoice.equals("Scizzor") && cpuChoice.equals("Stone")) {
            result = "You lose!";
        }

        Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
    }
}
