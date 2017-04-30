package com.example.mrgreen.memecreator;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;

// header files to make fragment communicate with Activity

import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TopSectionFragment extends Fragment {


    private static TextView topTextInput;
    private static TextView bottomTextInput;


    TopSectionListener activityCommander;

    public interface TopSectionListener
    {
        public void CreateMeme(String top,String bottom);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try
        {
            activityCommander=(TopSectionListener) activity;
        }
        catch(Exception e)
        {
             throw new ClassCastException(activity.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.top_section_fragment,container,false);

        topTextInput = (EditText)view.findViewById(R.id.topTextInput);
        bottomTextInput = (EditText)view.findViewById(R.id.bottomTextInput);
        final Button button = (Button)view.findViewById(R.id.button);

        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v)
                    {
                            buttonClicked(v);
                    }
                }
        );
        return view;
    }

    public void buttonClicked(View view)
    {
            activityCommander.CreateMeme(topTextInput.getText().toString(),bottomTextInput.getText().toString());
    }
}
