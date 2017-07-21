package com.tutorial.android_tutorial_6;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.android_tutorial_6.data.HastaKayitContract;
import com.tutorial.android_tutorial_6.data.HastaKayitDbHelper;

import java.util.HashMap;
import com.tutorial.android_tutorial_6.data.HastaKayitContract.HastaEntry;

public class HastaKayitActivity extends AppCompatActivity {

    private EditText editTextHastaIsim;
    private EditText editTextHastaYas;
    private EditText editTextHastaAdres;

    private Button buttonHastaKaydet;

    private HastaKayitDbHelper hastaKayitDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasta_kayit);

        getSupportActionBar().setTitle("Hasta Kayıt");

        hastaKayitDbHelper = new HastaKayitDbHelper(HastaKayitActivity.this);

        editTextHastaIsim = (EditText) findViewById(R.id.editTextHastaIsmi);
        editTextHastaYas = (EditText) findViewById(R.id.editTextHastaYas);
        editTextHastaAdres = (EditText) findViewById(R.id.editTextHastaAdres);
        buttonHastaKaydet = (Button) findViewById(R.id.buttonHastaKaydet);


        buttonHastaKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hastaIsmi = editTextHastaIsim.getText().toString();

                if(hastaIsmi.length() == 0){
                    Toast.makeText(HastaKayitActivity.this, "lütfen ismi boş geçmeyin", Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                int hastaYas;
                 try {
                      hastaYas = Integer.parseInt(editTextHastaYas.getText().toString());
                 }catch (Exception e){
                     Toast.makeText(HastaKayitActivity.this,"Lütfen yaşa sayısal değer giriniz.." ,
                             Toast.LENGTH_LONG).show();
                     return;
                 }
                String hastaAdres = editTextHastaAdres.getText().toString();

                SQLiteDatabase db = hastaKayitDbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                values.put(HastaEntry.COLUMN_HASTA_ISMI, hastaIsmi);
                values.put(HastaEntry.COLUMN_HASTA_YAS, hastaYas);
                values.put(HastaEntry.COLUMN_HASTA_ADRES, hastaAdres);

                long yeniKayitId =  db.insert(HastaEntry.TABLE_NAME, null, values);

                Toast.makeText(HastaKayitActivity.this, "Hasta id : " + yeniKayitId, Toast.LENGTH_LONG).show();
            }
        });
    }
}
