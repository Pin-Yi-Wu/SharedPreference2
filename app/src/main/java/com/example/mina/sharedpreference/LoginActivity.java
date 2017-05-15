package com.example.mina.sharedpreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText txtUsername;
    EditText txtPassword;
    Button btnLogin;
    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_log);

        session = new SessionManager(getApplicationContext());
        this.session = new SessionManager(this.getApplicationContext());
        this.txtUsername = (EditText)this.findViewById(R.id.edName);
        this.txtPassword = (EditText)this.findViewById(R.id.edPass);
        Toast.makeText(this.getApplicationContext(), "User Login Status: " + this.session.isLoggedIn(), Toast.LENGTH_LONG).show();
        this.btnLogin = (Button)this.findViewById(R.id.btnLogin);
        this.btnLogin.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                String username = LoginActivity.this.txtUsername.getText().toString();
                String password = LoginActivity.this.txtPassword.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0) {
                    if(username.equals("Vikas") && password.equals("Vikas")) {
                        LoginActivity.this.session.createLoginSession("Vikas Gutte", "vgutte@outlook.com");
                        Intent i = new Intent(LoginActivity.this.getApplicationContext(), MainActivityLog.class);
                        LoginActivity.this.startActivity(i);
                        LoginActivity.this.finish();

                    } else {
                        LoginActivity.this.alert.showAlertDialog(LoginActivity.this, "Login failed..", "Dear User Username/Password is incorrect", Boolean.valueOf(false));
                    }
                } else {
                    LoginActivity.this.alert.showAlertDialog(LoginActivity.this, "Login failed..", "Dear User Please enter username and password", Boolean.valueOf(false));
                }

            }
        });
    }
}

