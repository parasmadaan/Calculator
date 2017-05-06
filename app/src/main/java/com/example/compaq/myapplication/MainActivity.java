package com.example.compaq.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener

{
    public static final String TAG = "me";
    EditText etVar1;
    Button btnadd, btnsub, btnmul, btndiv, btnequal, btnclear, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;
    TextView tvresult;
    int i = 0;

   float a=0 , b = 0 , c = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etVar1 = (EditText) findViewById(R.id.etVar1);
        btnadd = (Button) findViewById(R.id.btnadd);
        btnsub = (Button) findViewById(R.id.btnsub);
        btnmul = (Button) findViewById(R.id.btnmul);
        btnclear = (Button) findViewById(R.id.btnclear);
        btndiv = (Button) findViewById(R.id.btndiv);
        btnequal = (Button) findViewById(R.id.btnequal);
        tvresult=(TextView) findViewById(R.id.tvresult);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);


        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnadd.setOnClickListener(this);
        btnsub.setOnClickListener(this);
        btnmul.setOnClickListener(this);
        btndiv.setOnClickListener(this);
        btnequal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (i)
                {
                    case R.id.btnadd:
                        c = b + a;
                        break;
                    case R.id.btnsub:
                        c = b - a;
                        break;
                    case R.id.btnmul:
                        c = a * b;
                        break;
                    case R.id.btndiv:
                        if(a==0)
                        {
                            Toast t= Toast.makeText(MainActivity.this,"INVALID", Toast.LENGTH_SHORT);
                            break;
                        }
                        else
                            c = b / a;
                        break;
                }
                etVar1.setText(String.valueOf(c));
                tvresult.setText(String.valueOf(c));
                i=0;
                a=c;
            }
        });
        Toast t= Toast.makeText(this,"INVALID", Toast.LENGTH_SHORT);
        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etVar1.setText("");
                tvresult.setText("");
                a=0;
            }
        });
    }

    public void onClick(View v) {

        etVar1.setText(etVar1.getText().toString() + ((Button) v).getText());
        tvresult.setText(tvresult.getText().toString()+((Button)v).getText());
        if ((v.getId() != R.id.btnadd) && (v.getId() != R.id.btnsub) &&(v.getId() != R.id.btnmul) && (v.getId() != R.id.btndiv))
        {
            a = Float.parseFloat(etVar1.getText().toString());
        }

        else if (v.getId()==R.id.btnadd || v.getId()==R.id.btnsub ||v.getId()==R.id.btnmul ||v.getId()==R.id.btndiv )
        {
            etVar1.setText(String.valueOf(""));
            i=v.getId();
            b=a;

        }

    }

}


