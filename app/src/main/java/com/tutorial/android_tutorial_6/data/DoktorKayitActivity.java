package com.tutorial.android_tutorial_6.data;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tutorial.android_tutorial_6.R;
import com.tutorial.android_tutorial_6.data.HastaKayitContract.DoktorEntry;

public class DoktorKayitActivity extends AppCompatActivity {
        private EditText editTextDoktorIsmi;
        private EditText editTextDoktorBransi;
        private Button buttonDoktorKaydet;

        private HastaKayitDbHelper hastaKayitDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doktor_kayit);

        getSupportActionBar().setTitle("Doktor Kayıt");

        hastaKayitDbHelper=new HastaKayitDbHelper(DoktorKayitActivity.this);

        editTextDoktorIsmi= (EditText) findViewById(R.id.editTextDoktorIsmi);
        editTextDoktorBransi= (EditText) findViewById(R.id.editTextDoktorBransi);
        buttonDoktorKaydet= (Button) findViewById(R.id.buttonDoktorKayit);

        buttonDoktorKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String doktorIsmi=editTextDoktorIsmi.getText().toString();
                String brans= editTextDoktorBransi.getText().toString();

                SQLiteDatabase db=hastaKayitDbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                values.put(DoktorEntry.COLUMN_DOKTOR_ISMI,doktorIsmi);
                values.put(DoktorEntry.COLUMN_DOKTOR_BRANS,brans);

                long yeniKayitId= db.insert(DoktorEntry.TABLE_NAME,null,values);
                Toast.makeText(DoktorKayitActivity.this,"doktor id: " + yeniKayitId
                        ,Toast.LENGTH_LONG).show();

            }
        });

    }
}
