package com.firstapp.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SetupSignUpClickableSpan();
    }

    private void SetupSignUpClickableSpan()
    {
        TextView signupTextView = findViewById(R.id.sign_up_here);
        String signupText = "Don't have an account? Sign up";
        SpannableString signupSpan = new SpannableString(signupText);

        ClickableSpan signupClickableSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent intent = new Intent(getApplicationContext(), SignUp.class);
                startActivity(intent);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.argb(255, 111, 117, 179));
                ds.setUnderlineText(false);
            }
        };

        signupSpan.setSpan(signupClickableSpan, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        signupTextView.setText(signupSpan);
        signupTextView.setClickable(true);
        signupTextView.setMovementMethod(LinkMovementMethod.getInstance());
    }

}