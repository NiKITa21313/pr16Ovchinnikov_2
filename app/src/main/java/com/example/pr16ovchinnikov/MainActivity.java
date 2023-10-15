package com.example.pr16ovchinnikov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private EditText inputEditText;
    private Button saveButton;
    private Button showButton;
    private TextView outputTextView;
    private String savedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditText = findViewById(R.id.inputText);
        saveButton = findViewById(R.id.save);
        showButton = findViewById(R.id.move);
        outputTextView = findViewById(R.id.moveText);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savedValue = inputEditText.getText().toString();
                Toast.makeText(MainActivity.this, "строка: <" + savedValue + "> сохранена" , Toast.LENGTH_SHORT).show();
            }
        });

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputTextView.setText(savedValue);
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedValue = savedInstanceState.getString("savedValue");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedValue", savedValue);
    }
}



