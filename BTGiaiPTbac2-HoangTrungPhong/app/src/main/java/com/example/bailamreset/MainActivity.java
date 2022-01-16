package com.example.bailamreset;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a, b,c;
    Button btnGPT,btnReset;
    TextView KQ;
    double x1,x2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        btnGPT = findViewById(R.id.calculate);
        KQ = findViewById(R.id.result);
        btnGPT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!a.getText().toString().equals("")&&!b.getText().toString().equals("")&&!c.getText().toString().equals(""))
                {

                    Double ax = Double.parseDouble(a.getText().toString());
                    Double bx = Double.parseDouble(b.getText().toString());
                    Double cx = Double.parseDouble(c.getText().toString());
                    Double dt = (bx*bx -4*ax*cx);
                    if(dt==0){
                        x1 = (-bx/2*ax);
                        KQ.setText("x = " +x1);
                    }
                    else if(dt > 0){
                        x1 = ((-bx+Math.sqrt(dt))/(2*ax));
                        x2 = ((-bx-Math.sqrt(dt))/(2*ax));
                        KQ.setText("x1 = " +x1 +"\n" +"x2 = " +x2);
                    }
                    else
                        KQ.setText("Phương trình vô nghiệm" + "\n\n" +"Hãyyy nhập lại -.-");

                }
            }
        });
        btnReset = findViewById(R.id.calculate2);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KQ.setText("Kết quả");
                a.setText("");
                b.setText("");
                c.setText("");
            }
        });
    }
}