package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<ModelClass> listofques;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listofques= new ArrayList<>();
        listofques.add(new ModelClass("Which one of the following river flows between Vindhyan and Satpura ranges?","Narmada","Mahanadi","Son"," Netravati","Narmada")) ;
        listofques.add(new ModelClass("The Central Rice Research Station is situated in?","Chennai","Cuttack"," Bangalore"," Quilon","Cuttack"));
        listofques.add(new ModelClass("Who among the following wrote Sanskrit grammar?","Kalidasa"," Charak"," Panini","Aryabhatt"," Panini")) ;
        listofques.add(new ModelClass("Which among the following head streams meets the Ganges in last?","Alaknanda","Pindar"," Mandakini","Bhagirathi"," Bhagirathi"));
        listofques.add(new ModelClass("The metal whose salts are sensitive to light is?","Zinc","Silver","Copper","Aluminium","Silver")) ;
        listofques.add(new ModelClass("The country that has the highest in Barley Production?","China","India","Russia","France","Russia")) ;
        listofques.add(new ModelClass("Under which of the following Android is licensed?","OSS","Sourceforge","Apache/MIT","None of the above","Apache/MIT")) ;
        listofques.add(new ModelClass("For which of the following Android is mainly developed?","Servers","Desktops","Laptops","Mobile devices"," Mobile devices")) ;
        listofques.add(new ModelClass("Which of the following virtual machine is used by the Android operating system?","JVM","Dalvik virtual machine","Simple virtual machine","None of the above","Dalvik virtual machine")) ;
        listofques.add(new ModelClass("Android is based on which of the following language?","Java","C","C++","None","Java")) ;
        listofques.add(new ModelClass("APK stands for -","Android Phone Kit","Android Page Kit","Android Package Kit","None of the above","Android Package Kit")) ;

        long delayMillis;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        Intent intent = new Intent(MainActivity.this,DashboardActivity.class);
        startActivity(intent);
            }
        },delayMillis= 1500);
    }
}