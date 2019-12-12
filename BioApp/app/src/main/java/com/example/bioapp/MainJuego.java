package com.example.bioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainJuego extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_juego2);
    }

    public void play(View view){
        Intent intent= new Intent(this, GameActivity.class);
        startActivity(intent);
    }
}
