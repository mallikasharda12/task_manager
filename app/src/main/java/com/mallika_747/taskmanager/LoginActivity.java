package com.mallika_747.taskmanager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String email = "ms8049@srmist.edu.in";
        String password = "mallika01";
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
                                    // cf = task.getResult();
                                    Log.e(email, password);
                                    // Go to main activity
                                }
                            }
                        });
                    }
                }
        );
    }
}
