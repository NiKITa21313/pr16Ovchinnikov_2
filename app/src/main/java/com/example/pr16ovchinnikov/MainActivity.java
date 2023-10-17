package com.example.pr16ovchinnikov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputEditText;
    private Button saveButton,showButton;
    private TextView outputTextView;
    private String savedLine = "undefined";
    private String namePreferences = "Settings";
    final static String KeyLine = "ID_Line";

    SharedPreferences settings;//настройки
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.inputText);
        saveButton = findViewById(R.id.save);
        showButton = findViewById(R.id.move);
        outputTextView = findViewById(R.id.moveText);
        settings = getSharedPreferences(namePreferences, MODE_PRIVATE);
        saveButton.setOnClickListener(this);
        showButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.save){
            savedLine = inputEditText.getText().toString();
            SharedPreferences.Editor prefEditor = settings.edit();//строка для возможности вносить изменения
            prefEditor.putString(KeyLine, savedLine);//внесение изменений
            prefEditor.apply();//сохранение внесенных изменений
        }
        else if (view.getId() == R.id.move){
            savedLine = settings.getString(KeyLine, "Строка ещё не была сохранена");
            outputTextView.setText(savedLine);
        }
    }
    //метод для сохранения строки
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(KeyLine, savedLine);
        super.onSaveInstanceState(outState);
    }
    //метод для получения сохраненной строки по ключу
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedLine = savedInstanceState.getString(KeyLine);
        outputTextView.setText(savedLine);
    }
}



