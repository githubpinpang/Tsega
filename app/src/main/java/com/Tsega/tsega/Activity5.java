package com.Tsega.tsega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Activity5 extends AppCompatActivity {
    PDFView pdfVieww;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

         pdfVieww= (PDFView) findViewById(R.id.pdfbook1);
        pdfVieww.fromAsset("tsega.pdf").load();
    }
}