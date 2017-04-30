package com.example.mrgreen.memecreator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // this gets called by top fragment when the user clicks the button
    @Override
    public void CreateMeme(String top, String bottom) {

        BottomSectionFragment bottomFragment= (BottomSectionFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
        bottomFragment.setMemeText(top,bottom);
    }
}
