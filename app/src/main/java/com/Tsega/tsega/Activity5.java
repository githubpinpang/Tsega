package com.Tsega.tsega;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class Activity5 extends AppCompatActivity {
    PDFView pdfVieww; Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

         pdfVieww= (PDFView) findViewById(R.id.pdfbook1);
        pdfVieww.fromAsset("tsega.pdf").load();

        but = (Button) findViewById(R.id.rec);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I = new Intent(Activity5.this, Rec.class);
                startActivity(I);
            }
        });
    }
}