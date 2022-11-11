package com.Tsega.tsega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;
    Button button;
    Button button1,  button2, button3, button4,button5,button6,button7,button8;

    AutoCompleteTextView ATV; View V1, V11, V22, V33, v44, v55,v6, v7, v8, v9, v10;
    TextView TV1;
    String [] inputs = {"Egziabher", "yayenal", "Hana", "Abrham", "Apple", "Shiro", "Tibs"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        V1 = findViewById(R.id.Sv);
        V11 = V1.findViewById(R.id.Rl);

        V22 = V11.findViewById(R.id.ll);
        button1 = (Button) findViewById(R.id.button2);

        V33 = V11.findViewById(R.id.l1);
        v44 = V11.findViewById(R.id.l2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In = new Intent(MainActivity.this, Activity5.class);
                startActivity(In);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openActivity3();
            }
        });
        button2 = (Button) findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In2 = new Intent(MainActivity.this, Activity4.class);
                startActivity(In2);
            }
        });
        button3 = (Button) findViewById(R.id.button7);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent In3 = new Intent(MainActivity.this, Activity2.class);
                startActivity(In3);
            }
        });

        ATV = (AutoCompleteTextView) findViewById(R.id.ACT);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,inputs);
        ATV.setAdapter(adapter);
    }
   public void openActivity3()
    {
        Intent intent = new Intent(MainActivity.this, Activity3.class);
        startActivity(intent);

    }
}