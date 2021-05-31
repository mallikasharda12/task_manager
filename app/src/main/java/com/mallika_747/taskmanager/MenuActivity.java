package com.mallika_747.taskmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        Button button1 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.new_task_page);
                    }
                }
        );

        Button button2 = (Button) findViewById(R.id.button4);

        button2.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.pending_task_page);
                    }
                }
        );
    }
}
