package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static com.example.quiz.MainActivity.listofques;

public class DashboardActivity extends AppCompatActivity {

    List<ModelClass> allquestions;
    ModelClass modelclass;
    int index=0;
    TextView cardquestion,cardoptiona,cardoptionb,cardoptionc,cardoptiond;
    CardView cardoA,cardoB,cardoC,cardoD;
    int correctcount=0;
    int wrongcount=0;
    LinearLayout nextbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Hooks();

        allquestions=  listofques;
        Collections.shuffle(allquestions);
        modelclass= listofques.get(index);
        cardoA.setBackgroundColor(getResources().getColor(R.color.white));
        cardoB.setBackgroundColor(getResources().getColor(R.color.white));
        cardoC.setBackgroundColor(getResources().getColor(R.color.white));
        cardoD.setBackgroundColor(getResources().getColor(R.color.white));
        nextbtn.setClickable(false);
       setalldata();

    }

    private void setalldata() {

        cardquestion.setText(modelclass.getQuestion());
        cardoptiona.setText(modelclass.getoA());
        cardoptionb.setText(modelclass.getoB());
        cardoptionc.setText(modelclass.getoC());
        cardoptiond.setText(modelclass.getoD());


    }

    private void Hooks() {
       cardquestion= findViewById(R.id.cardquestion);
        cardoptiona= findViewById(R.id.cardoptiona);
        cardoptionb= findViewById(R.id.cardoptionb);
        cardoptionc= findViewById(R.id.cardoptionc);
        cardoptiond= findViewById(R.id.cardoptiond);
        cardoA = findViewById(R.id.carda);
        cardoB= findViewById(R.id.cardb);
        cardoC= findViewById(R.id.cardc);
        cardoD= findViewById(R.id.cardd);

        nextbtn= findViewById(R.id.nextbtn);

    }
    public void Correct(CardView cardoA)
    {
        cardoA.setCardBackgroundColor(getResources().getColor(R.color.green));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correctcount++;
                index++;
                modelclass= listofques.get(index);
                setalldata();
            }
        });

    }
    public void Wrong( CardView cardoA)
    {
       cardoA.setCardBackgroundColor(getResources().getColor(R.color.red));
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wrongcount++;
                if(index< listofques.size())
                {
                    index++;
                    modelclass= listofques.get(index);
                    setalldata();
                    resetcolor();
                }
                else
                {
                    GameWon();
                }
            }
        });

    }

    private void GameWon() {
        Intent intent= new Intent(DashboardActivity.this,WonActivity.class);
        startActivity(intent);
    }
    public void enablebtn()
    {
        cardoA.setClickable(true);
        cardoB.setClickable(true);
        cardoC.setClickable(true);
        cardoD.setClickable(true);

    }
    public void disablebtn()
    {
        cardoA.setClickable(false);
        cardoB.setClickable(false);
        cardoC.setClickable(false);
        cardoD.setClickable(false);

    }
    public void resetcolor()
    {
        cardoA.setBackgroundColor(getResources().getColor(R.color.white));
        cardoB.setBackgroundColor(getResources().getColor(R.color.white));
        cardoC.setBackgroundColor(getResources().getColor(R.color.white));
        cardoD.setBackgroundColor(getResources().getColor(R.color.white));

    }
    public void optionAClick(View view)
    {
        disablebtn();
        nextbtn.setClickable(true);
        if(modelclass.getoA().equals(modelclass.getAns()))
        {
            cardoA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index< listofques.size()-1)
            {
                index++;
                Correct(cardoA);
            }
            else
            {
                GameWon();
            }
        }
        else{
            Wrong(cardoA);
        }
    }
    public void optionBClick(View view)
    {
        disablebtn();
        nextbtn.setClickable(true);
        if(modelclass.getoB().equals(modelclass.getAns()))
        {
            cardoB.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index< listofques.size()-1)
            {
                index++;
                Correct(cardoB);
            }
            else
            {
                GameWon();
            }
        }
        else{
            Wrong(cardoB);
        }
    }
    public void optionCClick(View view)
    {
        disablebtn();
        nextbtn.setClickable(true);
        if(modelclass.getoC().equals(modelclass.getAns()))
        {
            cardoC.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index< listofques.size()-1)
            {
                index++;
                Correct(cardoC);
            }
            else
            {
                GameWon();
            }
        }
        else{
            Wrong(cardoC);
        }
    }
    public void optionDClick(View view)
    {
        disablebtn();
        nextbtn.setClickable(true);
        if(modelclass.getoD().equals(modelclass.getAns()))
        {
            cardoD.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index< listofques.size()-1)
            {
                index++;
               Correct(cardoD);
            }
            else
            {
                GameWon();
            }
        }
        else{
            Wrong(cardoD);
        }
    }

}