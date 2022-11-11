package com.Tsega.tsega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Activity4 extends AppCompatActivity {
    PDFView pdfView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        pdfView1 = (PDFView) findViewById(R.id.pdfbook2);
        pdfView1.fromAsset("ML.pdf").load();
    }
}