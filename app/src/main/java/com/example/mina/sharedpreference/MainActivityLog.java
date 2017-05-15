package com.example.mina.sharedpreference;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivityLog extends AppCompatActivity {
    AlertDialogManager alert = new AlertDialogManager();
    SessionManager session;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log);

        this.session = new SessionManager(this.getApplicationContext());
        TextView lblName = (TextView)this.findViewById(R.id.tvName);
        TextView lblEmail = (TextView)this.findViewById(R.id.tvPass);
        this.btnLogout = (Button)this.findViewById(R.id.btnLogout);

        Toast.makeText(this.getApplicationContext(), "User Login Status: " + this.session.isLoggedIn(), 1).show();
        this.session.checkLogin();

        HashMap user = this.session.getUserDetails();
        String name = (String)user.get("name");
        String email = (String)user.get("email");
        lblName.setText(Html.fromHtml("Name: <b>" + name + "</b>"));
        lblEmail.setText(Html.fromHtml("Email: <b>" + email + "</b>"));

        this.btnLogout.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                MainActivityLog.this.session.logoutUser();
            }
        });
    }
}

