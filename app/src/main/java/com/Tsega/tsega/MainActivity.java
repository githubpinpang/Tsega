package com.Tsega.tsega;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    PDFView pdfView;
    Button button, newButton;
    Button button1,  button2, button3, button4,button5,button6,button7,button8;
    EditText Edt;
    AutoCompleteTextView ATV; View V1, V11, V22, V33, v44, v55,v6, v7, v8, v9, v10;
    TextView TV1;
    String name;
    String [] inputs = {"Egziabher", "yayenal", "Hana", "Abrham", "Apple", "Shiro", "Tibs"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize and assign variable
        //BottomNavigationView bottomNavigationView=findViewById(R.id.bottomAppBar);

        // Set Home selected
        //bottomNavigationView.setSelectedItemId(R.id.fab);
        // Set Home selected


        // Perform item selected listener
        //bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          //  @Override
            //public boolean onNavigationItemSelected(@NonNull MenuItem item) {

              //  switch(item.getItemId())
                //{
                  //  case R.id.fab:
                    //    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                      //  overridePendingTransition(0,0);
                        //return true;

                //}
                //return false;
            //}
        //});

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

         Edt = (EditText) findViewById(R.id.edt);
    Button  Nb = (Button) findViewById(R.id.nb);
      Nb.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              addButton();
          }
      });

       FloatingActionButton Fab = findViewById(R.id.fab);
        Fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           // addButton();


              Intent In = new Intent(MainActivity.this, About.class);
               startActivity(In);
            }
        });



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

    public void addButton()
    {
        final LinearLayout layout = (LinearLayout) findViewById(R.id.root);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("የመዝሙር ስም");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        builder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
             name = input.getText().toString().trim();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Canceled", Toast.LENGTH_SHORT).show();
            }
        });

           builder.create().show();
        newButton = new Button(this);
      //  Edt.setVisibility(View.VISIBLE);
        newButton.setText(name);
        layout.addView(newButton);
    }

   public void openActivity3()
    {
        Intent intent = new Intent(MainActivity.this, Activity3.class);
        startActivity(intent);

    }


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        MenuItem searchViewItem = menu.findItem(R.id.app_bar_search);
        return super.onCreateOptionsMenu(menu);
    }

    }