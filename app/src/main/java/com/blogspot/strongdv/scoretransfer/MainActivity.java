package com.blogspot.strongdv.scoretransfer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {
    EditText inputFlat;
    EditText inputIni;
    public static String getIni;
    public static String getFlat;
   // public static String getIni;
 //   public static String getFlat;
    public static SharedPreferences settings;
    public static final String PREF_NAME = "mypref";
    public static final String APP_PREFERENCES_NAME = "fio";
    public static final String APP_PREFERENCES_FLAT = "flat";
    //  public static final String filenameIni = "ini";
    //   public static final String filenameFlat = "flat";
    // FileOutputStream outputStreamIni;
    // FileOutputStream outputStreamFlat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        inputFlat = findViewById(R.id.inputflatnum);
        inputIni = findViewById(R.id.inputIni);
        settings = getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        if (settings.contains(APP_PREFERENCES_NAME))
            if (settings.contains(APP_PREFERENCES_FLAT))
        finish();
        cheCk();
        }
    //   public void clear(View view) {
    //      name.setText("");
    //       email.setText("");
    //      }
 //   public void Get(View view) {
    //нажатие кнопки - если при вводе 0, то ничего не происходит. если есть цифра, то она назначается переменной getFlat//
        //intent - это переход в другую активность//
        public void onFirstClick (View view){
                if (inputFlat.getText().length() == 0) return;
                else {
                    getFlat = valueOf(inputFlat.getText().toString());
                }
                if (inputIni.getText().length() == 0) return;
                else {
                    getIni = valueOf(inputIni.getText().toString());
                }
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(APP_PREFERENCES_NAME, getIni);
            editor.putString(APP_PREFERENCES_FLAT, getFlat);
            editor.apply();
                Intent intent;
                intent = new Intent(MainActivity.this, counters.class);
                startActivity(intent);
                //сразу прибиваем это активити
                finish();
                // сохранение настроек
//записываем в поле  PREF_NAME значение getFlat ("можно текст")


//создание файла my file //
                //запись значения переменной getFlat в my file//
         /*   try {
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
            }*/

            }
         public void cheCk(){
 {
    if (settings.contains(APP_PREFERENCES_NAME))
        getIni = settings.getString(APP_PREFERENCES_NAME, getIni);
    if (settings.contains(APP_PREFERENCES_FLAT)) {
        getFlat = settings.getString(APP_PREFERENCES_FLAT, getFlat);
        Intent intent;
        intent = new Intent(MainActivity.this, counters.class);
        startActivity(intent);
        //сразу прибиваем это активити
       // finish();
    }
}
    }
}































