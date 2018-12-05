package com.blogspot.strongdv.scoretransfer;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static com.blogspot.strongdv.scoretransfer.MainActivity.APP_PREFERENCES_FLAT;
import static com.blogspot.strongdv.scoretransfer.MainActivity.APP_PREFERENCES_NAME;
import static com.blogspot.strongdv.scoretransfer.MainActivity.PREF_NAME;
import static com.blogspot.strongdv.scoretransfer.MainActivity.getFlat;
import static com.blogspot.strongdv.scoretransfer.MainActivity.getIni;
import static com.blogspot.strongdv.scoretransfer.MainActivity.settings;

import static java.lang.String.valueOf;

public class counters extends AppCompatActivity {
    EditText inGvs;
    EditText inHvs;
    EditText inEl;
    public static String getGvs;
    public static String getHvs;
    public static String getEl;
    public static String DATA_BASE = "app.db";
    public static String name;
    public static String flat;
    public static String getdata;
    FileOutputStream outputStream;
   public static String SAVED_HISTORY="history";
//FileOutputStream fos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_counters);
        inGvs = findViewById(R.id.editText);
        inHvs = findViewById(R.id.editText2);
        inEl = findViewById(R.id.editText3);
        name = settings.getString(APP_PREFERENCES_NAME, getIni);
        flat = settings.getString(APP_PREFERENCES_FLAT, getFlat);

    }

    protected void onResume() {
        super.onResume();
        inEl.setText("");
        inHvs.setText("");
        inGvs.setText("");
    }

    public void onClickSend(View view) {
        if (inGvs.getText().length() == 0)
            return;
        else {
            getGvs = valueOf(inGvs.getText().toString());
        }
        if (inGvs.getText().length() == 0) return;
        else {
            getGvs = valueOf(inGvs.getText().toString());
        }
        if (inHvs.getText().length() == 0) return;
        else {
            getHvs = valueOf(inHvs.getText().toString());
        }
        if (inEl.getText().length() == 0) return;
        else {
            getEl = valueOf(inEl.getText().toString());
        }
        dbOpen();
        saveHis();
//finish();
        //   try {
        //     fos = openFileOutput(filename, Context.MODE_PRIVATE);
        //    fos.write(" ".getBytes());
        //    fos.write(getGvs.getBytes());
        //   fos.write(" ".getBytes());
        // fos.write(getHvs.getBytes());
        //  fos.write(" ".getBytes());
//                fos.close();

        //  } catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //   } catch (Exception e) {
        //         e.printStackTrace();
    }

    public void dbOpen() {
        String create = "CREATE TABLE IF NOT EXISTS users (date DATETIME DEFAULT CURRENT_TIMESTAMP, name TEXT, flat TEXT, gvs INT, hvs INT, el INT)";
        SQLiteDatabase db = getBaseContext().openOrCreateDatabase(DATA_BASE, MODE_PRIVATE, null);
        db.execSQL(create);
        ContentValues insertValues = new ContentValues();
        insertValues.put("name", name);
        insertValues.put("flat", flat);
        insertValues.put("gvs", getGvs);
        insertValues.put("hvs", getHvs);
        insertValues.put("el", getEl);
        db.insert("users", null, insertValues);
        Cursor query = db.rawQuery("SELECT * FROM users;", null);
        if (query.moveToFirst()) {
            do {
                String date = query.getString(0);
                name = query.getString(1);
                flat = query.getString(2);
                String gvs = query.getString(3);
                String hvs = query.getString(4);
                String el = query.getString(5);
                getdata = "дата: " + date + "\n"
                        + "ФИО: " + name + "\n" + " Квартира: " + flat + "\n" +
                        "ГВС " + gvs + " ХВС " + hvs + " Электричество " + el + "\n" + "" + "\n";

            }
            while (query.moveToNext());
        }
        query.close();
        db.close();
    }
    public void saveHis() {

        try {
            outputStream = openFileOutput(SAVED_HISTORY, Context.MODE_APPEND);
            outputStream.write(getdata.getBytes());
            outputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






















    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.hist:
if (getdata==null)
{Toast.makeText(this, "нет записей", Toast.LENGTH_SHORT).show();
return true;}
                else  {
                    Intent intent;
                    intent = new Intent(counters.this, History.class);
                    startActivity(intent);
                    return true;
                }
 case R.id.set:
                //finish();
               /* deleteFile(filenameIni);
                deleteFile(filenameFlat);*/
                //  inGvs.setText(null);
                // inGvs.setText(null);
                //  inEl.setText(null);
                getSharedPreferences(PREF_NAME, MODE_PRIVATE).edit().clear().apply();

                deleteDatabase(DATA_BASE);
                deleteFile(APP_PREFERENCES_NAME);
                deleteFile(APP_PREFERENCES_FLAT);
                getdata=null;
                Intent intentt;
                intentt = new Intent(counters.this, MainActivity.class);
                startActivity(intentt);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}









