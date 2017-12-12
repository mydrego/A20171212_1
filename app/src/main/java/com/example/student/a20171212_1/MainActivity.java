package com.example.student.a20171212_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button bt;
    int i;
    boolean bl = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        bt = (Button) findViewById(R.id.button);
    }

    public void click1(View v) {
        if (bl) {
            bl = false;
            new Thread() { //1
                public void run() { //2
                    super.run();
                    for (i = 10; i >= 0; i--) {
                        runOnUiThread(new Runnable() { //4
                            @Override
                            public void run() {
                                tv.setText(String.valueOf(i));
                            }
                        });
                        try { //3
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    bl = true;
                }
            }.start();
        }
    }
}

