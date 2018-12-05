package com.blogspot.strongdv.scoretransfer;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import static com.blogspot.strongdv.scoretransfer.counters.SAVED_HISTORY;
import static com.blogspot.strongdv.scoretransfer.counters.getdata;


public class History extends AppCompatActivity {
 TextView hisText;
  TextView textViewLast;
    // FileInputStream inputStream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        hisText = findViewById(R.id.textView);
        textViewLast = findViewById(R.id.textViewLast);
        //hisText.append(getdata);
       // textViewLast.setText(getdata);

        onOpen();

       // saveHis();
    }
   // public void saveHis(){}
   private void onOpen(){

       FileInputStream fin = null;

       try {
           fin = openFileInput(SAVED_HISTORY);//let's create stream
           byte[] bytes = new byte[fin.available()];
           fin.read(bytes);
           String text = new String (bytes);
           hisText.append(text);
       }
       catch(IOException ex) {

           Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
       }
       finally{

           try{
               if(fin!=null)
                   fin.close();//close stream
           }
           catch(IOException ex){

               Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
           }
       }
   }





   }








//if (getIni == null) {




        //  onOpenIni();
        //  onOpenFlat();
        // dbOpen();





   /* public void Save(View view){
        String n = name.getText().toString();
        String e = flat.getText().toString();
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(Name, n);
        editor.putString(Flat, e);
        editor.commit();
    }
*/




    // @Override
   // public boolean deleteDatabase(String name) {
     //   return super.deleteDatabase(name);
   // }



   /* private void onOpenIni(){
    FileInputStream fin;
        try
    {
        fin = openFileInput(filenameIni);//let's open stream
        byte[] bytes = new byte[fin.available()];
        fin.read(bytes);
        String text = new String(bytes);
getIni.setText(text);
    }
        catch(
    IOException ex)
    {
        Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
    private void onOpenFlat(){
        FileInputStream fin;
        try
        {
            fin = openFileInput(filenameFlat);//let's open stream
            byte[] bytes = new byte[fin.available()];
            fin.read(bytes);
            String text = new String(bytes);
           getFlat.setText(text);
        }
        catch(
                IOException ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
*/




