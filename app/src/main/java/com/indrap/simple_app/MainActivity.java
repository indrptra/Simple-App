package com.indrap.simple_app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener{
    EditText txtin,txtout;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0;
    ImageButton btnsip,btndel,btnclear;
    TextView tvj;
    String txtfoc = "income";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txtin = (EditText)findViewById(R.id.txt_income);
        txtout = (EditText)findViewById(R.id.txt_outcome);
        btn0 = (Button)findViewById(R.id.btn_0);
        btn1 = (Button)findViewById(R.id.btn_1);
        btn2 = (Button)findViewById(R.id.btn_2);
        btn3 = (Button)findViewById(R.id.btn_3);
        btn4 = (Button)findViewById(R.id.btn_4);
        btn5 = (Button)findViewById(R.id.btn_5);
        btn6 = (Button)findViewById(R.id.btn_6);
        btn7 = (Button)findViewById(R.id.btn_7);
        btn8 = (Button)findViewById(R.id.btn_8);
        btn9 = (Button)findViewById(R.id.btn_9);
        //btnsip = (ImageButton)findViewById(R.id.btn_ok);
        btndel = (ImageButton)findViewById(R.id.btn_del);
        btnclear = (ImageButton)findViewById(R.id.btn_clear);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        //btnsip.setOnClickListener(this);
        btndel.setOnClickListener(this);
        btnclear.setOnClickListener(this);
        txtin.setOnFocusChangeListener(this);
        txtout.setOnFocusChangeListener(this);
        txtin.setInputType(InputType.TYPE_NULL);
        txtout.setInputType(InputType.TYPE_NULL);
        tvj = (TextView) findViewById(R.id.tv_jawab);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_ok);
        fab.setOnClickListener(this);


      /*  int start =txtin.getSelectionStart(); //this is to get the the cursor position
        String s = "Some string";
        txtin.getText().insert(start, s); //this will get the text and insert the String s into   the current position*/


    }

    @Override
    public void onClick(View v)
    {
        String txtisi = "";
        switch (v.getId())
        {
            case R.id.btn_0:
                txtisi = "0";
                break;
            case R.id.btn_1:
                txtisi = "1";
                break;
            case R.id.btn_2:
                txtisi = "2";
                break;
            case R.id.btn_3:
                txtisi = "3";
                break;
            case R.id.btn_4:
                txtisi = "4";
                break;
            case R.id.btn_5:
                txtisi = "5";
                break;
            case R.id.btn_6:
                txtisi = "6";
                break;
            case R.id.btn_7:
                txtisi = "7";
                break;
            case R.id.btn_8:
                txtisi = "8";
                break;
            case R.id.btn_9:
                txtisi = "9";
                break;
            case R.id.btn_del:
                if(txtfoc.equals("income")){
                    txtin.setText("");}
                else{
                    txtout.setText("");}
                break;
            case R.id.btn_clear:
                if(txtfoc.equals("income")){
                    if(txtin.length() > 0){
                        txtin.setText(txtin.getText().toString().substring(0, txtin.length() - 1));}}
                else{
                    if(txtout.length() > 0){
                        txtout.setText(txtout.getText().toString().substring(0, txtout.length() - 1));}
                }
                break;
            case R.id.fab_ok:
                if(!txtin.getText().toString().isEmpty() && !txtout.getText().toString().isEmpty())
                    tvj.setText(String.valueOf(Integer.valueOf(txtin.getText().toString()) - Integer.valueOf(txtout.getText().toString())));
                else
                    tvj.setText("");
                break;
        }
        if(txtfoc.equals("income")){
            txtin.setText(txtin.getText() + txtisi);
        }else{
            txtout.setText(txtout.getText() + txtisi);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch(v.getId()){
            case R.id.txt_income:
                txtfoc="income";
                break;
            case R.id.txt_outcome:
                txtfoc="outcome";
                break;
        }

    }
}
