package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Calculator calc = new Calculator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClick(View view){
        if (view.getId()==R.id.AC){
            calc.allClear();
        }else if (view.getId()==R.id.C) {
            calc.clear();
        }else {
            Button viewIsActuallyAButton = (Button) view;
            calc.keyPress(((Button) view).getText().charAt(0));
        }
        updateView();
    }
    private void updateView(){
        TextView display = findViewById(R.id.Text_field);
        display.setText(String.format(Locale.US, "%s",calc.getDisplay()));
    }
}
