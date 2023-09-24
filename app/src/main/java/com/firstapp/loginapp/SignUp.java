package com.firstapp.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SetupLoginClickableSpan();
    }

    private void SetupLoginClickableSpan()
    {

        TextView loginTextView = (TextView) findViewById(R.id.login_here);
        String loginText = "Already have an account? Login";
        SpannableString loginSpan = new SpannableString(loginText);

        ClickableSpan loginClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.argb(255, 111, 117, 179));
                ds.setUnderlineText(false);
            }
        };

        loginSpan.setSpan(loginClickableSpan, 25, 29, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginTextView.setText(loginSpan);
    }

}