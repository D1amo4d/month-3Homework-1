package com.example.month_3homework_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
//16:15
    TextInputEditText etGmail;
    TextInputEditText etTheme;
    TextInputEditText etSms;
    MaterialButton btnSend;
    MaterialButton btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btnClicer();

    }
    private void initView() {
        etGmail=findViewById(R.id.text_gmail);
        etTheme=findViewById(R.id.text_theme);
        etSms=findViewById(R.id.text_sms);
        btnSend=findViewById(R.id.btn_send);
        btnSend=findViewById(R.id.btn_exit);
    }
    private void btnClicer() {
        etGmail.getText().toString();
        etTheme.getText().toString();
        etSms.getText().toString();

        btnSend.setOnClickListener(view -> {
            Intent intent=new Intent(Intent.ACTION_GET_CONTENT  );
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{String.valueOf(etGmail)});
            intent.putExtra(Intent.EXTRA_SUBJECT, (CharSequence) etTheme);
            intent.putExtra(Intent.EXTRA_TEXT, (CharSequence) etSms);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent,"WYBERITE SOBSENIE"));
        });

        btnExit.setOnClickListener(view -> {
            finish();
        });
    }
}