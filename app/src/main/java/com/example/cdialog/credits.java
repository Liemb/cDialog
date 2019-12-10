package com.example.cdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class credits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    /**
     * indlating the menu
     */
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    /**
     * reacting to the menu choice
     */

    public boolean onOptionsItemSelected(MenuItem menu){
        String st=menu.getTitle().toString();
        if (st.equals("buttons")){
            finish();
        }
        return true;
    }



}
