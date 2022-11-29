package com.Tsega.tsega;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import io.realm.Realm;
import android.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.annotation.Nullable;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
          Button Newpage = findViewById(R.id.browse);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        Newpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               openDialog();
            }
        });
        // Initialize and assign variable
        //BottomNavigationView bottomNavigationView=findViewById(R.id.bottomAppBar);

        // Set Home selected
       // bottomNavigationView.setSelectedItemId(R.id.fab);

        // Perform item selected listener
        //bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          //  @Override
            //public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                //switch(item.getItemId())
                //{

                    //case R.id.fab:
                    //    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                  //      overridePendingTransition(0,0);
                //        return true;
              //  }
            //    return false;
          //  }
        //});
    }

public void openDialog()
{
    //AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    //builder.setTitle("መዝሙር ጫን");
     dialogBox dialogBox = new dialogBox();
     dialogBox.show(getSupportFragmentManager(), "example");
}
    private void getDocument()
    {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("application/pdf");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        // Only the system receives the ACTION_OPEN_DOCUMENT, so no need to test.
//        startActivityForResult(intent, REQUEST_CODE_DOC);
    }


}