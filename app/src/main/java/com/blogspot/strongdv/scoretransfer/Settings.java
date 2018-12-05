package com.blogspot.strongdv.scoretransfer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import static com.blogspot.strongdv.scoretransfer.MainActivity.getFlat;
import static com.blogspot.strongdv.scoretransfer.MainActivity.getIni;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import static java.lang.String.valueOf;

public class Settings extends AppCompatActivity {
    EditText inputFlat;
    EditText inputIni;

  //  public static String getFlat;
   // public static String getIni;
  //  SharedPreferences settings;
  //  private static final String PREFS_FILE = "Account";
   // private static final String PREF_NAME = "Name";
  public static final String filenameIni = "ini";
    public static final String filenameFlat = "flat";
 //   FileOutputStream outputStreamIni;
 //  FileOutputStream outputStreamFlat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        inputFlat = findViewById(R.id.inputflatnum);
        inputIni=findViewById(R.id.inputIni);
    }

    public void onFirstClick(View view) {
        {
            if (inputFlat.getText().length() == 0) return;
            else {
                getFlat = valueOf(inputFlat.getText().toString());
            }
            if (inputIni.getText().length() == 0) return;
            else {
                getIni = valueOf(inputIni.getText().toString());
            }
            Intent intent;
            intent = new Intent(Settings.this, counters.class);
            startActivity(intent);
            //сразу прибиваем это активити
            finish();


            //  settings = getSharedPreferences(PREFS_FILE, MODE_PRIVATE);
            //  settings.edit().clear().commit();
        }
        //нажатие кнопки - если при вводе 0, то ничего не происходит. если есть цифра, то она назначается переменной getFlat//
        //intent - это переход в другую активность//

   /* public void onFirstClick(View view) {
       /* {
            if (inputFlat.getText().length() == 0) return;
            else {*/
        //             getFlat = valueOf(inputFlat.getText().toString());
            /*}
            /*if (inputIni.getText().length() == 0); return;
           else {*/
        //            getIni = valueOf(inputIni.getText().toString());
        /*  }*/
        //          Intent intent;
        //         intent = new Intent(Settings.this, counters.class);
        //          startActivity(intent);
//finish();


        // сохранение настроек
//записываем в поле  PREF_NAME значение getFlat ("можно текст")
        // SharedPreferences.Editor prefEditor = settings.edit();
        // prefEditor.putString(PREF_NAME, getFlat);
        // prefEditor.putString(PREF_NAME, getIni);
        //  prefEditor.apply();
//создание файла my file //
        //запись значения переменной getFlat в my file//
           /* try {
                outputStreamIni = openFileOutput(filenameIni, Context.MODE_PRIVATE);
                outputStreamIni.write(getIni.getBytes());
                outputStreamIni.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                outputStreamFlat = openFileOutput(filenameFlat, Context.MODE_PRIVATE);
                outputStreamFlat.write(getFlat.getBytes());
                outputStreamFlat.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
            */


    }}