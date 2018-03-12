package com.example.apurva.feb12assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_open;
    Intent intent;
    String url;
    String[] myarray;
    ArrayAdapter<String> adapter;
    AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_open=findViewById(R.id.btn_open);
        autoCompleteTextView=findViewById(R.id.autoCompleteTextView);

        myarray=getResources().getStringArray(R.array.myarray);
        adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myarray);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setThreshold(1);


        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                url=autoCompleteTextView.getText().toString();

                if (url.equalsIgnoreCase(""))
                {
                    autoCompleteTextView.setError("Please Enter a url");
                }
                else {
                    intent=new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("url",url);
                    startActivity(intent);
                }

            }
        });
    }
}
