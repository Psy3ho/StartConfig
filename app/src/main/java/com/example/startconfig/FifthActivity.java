package com.example.startconfig;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.startconfig.services.NotificationService;

public class FifthActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        editText = findViewById(R.id.editTextNotification);

    }

    @Override
    protected void onResume() {
        super.onResume();
        stopService(new Intent(this, NotificationService.class));
    }

    public void notifyButton(View view) {
        String input = editText.getText().toString();
        Intent intent = new Intent(this, NotificationService.class);
        intent.putExtra("inputExtra", input);
        ContextCompat.startForegroundService(this, intent);
    }

    public void stopNotifyButton(View view) {
        stopService(new Intent(this, NotificationService.class));
    }
}
