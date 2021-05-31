package com.mallika_747.taskmanager;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.Date;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewTaskActivity extends AppCompatActivity {
    public TimePickerDialog tpd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        TextView taskdetails = (TextView) findViewById(R.id.event_new);
        EditText getdate = (EditText) findViewById(R.id.editTextDate);
        EditText time = (EditText) findViewById(R.id.editTextTime);
        Button submit = (Button) findViewById(R.id.button);
        String

        taskdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                taskdetails.getText().toString();
            }
        });

        getdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getdate.getText().toString();

            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tpd = new TimePickerDialog(NewTaskActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

                        time.setText(hourOfDay + ":" + minutes);

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR, hourOfDay);
                        calendar.set(Calendar.MINUTE, minutes);
                        calendar.getTime();
                    }
                }, 0, 0, false);
                tpd.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Date(String.valueOf(getdate));
                //obj of cf
                class_file cf;
                cf.tasks = taskdetails;
                cf.datetime = time;
                myRef.setValue(cf);
            }
        });

    }

}
