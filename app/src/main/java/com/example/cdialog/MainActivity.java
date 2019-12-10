package com.example.cdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import java.util.Random;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @author liem
 * @since 05/12/19
 * in this activity there are 4 buttons for the user to choose
 * ll - the linear layout object
 * String[] colors - the colors options
 * int[]color - the rgb number array
 */
public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder adb;
    LinearLayout ll;
    final String[] colors={"Red","Green","Blue"};
    int[]color={0,0,0};
    Intent gi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.ll);
    }

    /**
     * this method lets the user choose a color between red green and blue
     */
    public void colors(View view) {
        color=new int[]{0,0,0};
        adb=new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("1st option");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]=255;
                ll.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * this method lets the user change the background to a mixing between the three colors
     */
    public void colorsbt(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("2nd option");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked)
                    color[which]=255;
                else if (color[which]==255)
                    color[which]=0;
                ll.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
    }

    /**
     * this method changes the color of the background back to white
     */
    public void white(View view) {
        ll.setBackgroundColor(Color.WHITE);
    }

    /**
     * this method gets a text from the user and returns it as a toast.
     */
    public void btext(View view) {
        adb=new AlertDialog.Builder(this);
        adb.setCancelable(false);
        adb.setTitle("4th option");
        final EditText et=new EditText(this);
        et.setHint("type something");
        adb.setView(et);
        adb.setPositiveButton("enter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str=et.getText().toString();
                Toast.makeText(MainActivity.this, ""+str, Toast.LENGTH_SHORT).show();
            }
        });
        adb.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad=adb.create();
        ad.show();
        }


    /**
     * inflating the menu
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    /**
     * responding to the menu choice
     */
    public boolean onOptionsItemSelected(MenuItem menu) {
        String st = menu.getTitle().toString();
        if (st.equals("credits")) {
            gi = new Intent(this, credits.class);
            startActivity(gi);
        }
        return true;
    }

}
