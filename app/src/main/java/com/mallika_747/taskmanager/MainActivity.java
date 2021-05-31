package com.mallika_747.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        String email;
        String password;

        EditText userid = (EditText) findViewById(R.id.userid);
        EditText userpassword = (EditText)findViewById(R.id.userpassword);
        email = userid.getText().toString();
        password = userpassword.getText().toString();

        FirebaseAuth auth = FirebaseAuth.getInstance();
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    AuthResult user = task.getResult();
                                    String email = user.getUser().getEmail();
                                    Log.e(email, password);

                                    setContentView(R.layout.menu_page);
                                }
                            }
                        });
                    }
                });
    }
}