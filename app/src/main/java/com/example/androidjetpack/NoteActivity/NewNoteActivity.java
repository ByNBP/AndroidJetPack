package com.example.androidjetpack.NoteActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidjetpack.R;

public class NewNoteActivity extends AppCompatActivity {
    public static final String NOTE_ADDED = "new_note";


    EditText note_text;
    Button note_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        note_text = findViewById(R.id.note_text);
        note_button = findViewById(R.id.note_button);
        note_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                if (TextUtils.isEmpty(note_text.getText()))
                    setResult(RESULT_CANCELED,resultIntent);
                else {
                    String note = note_text.getText().toString();
                    resultIntent.putExtra(NOTE_ADDED,note);
                    setResult(RESULT_OK,resultIntent);
                }
                finish();
            }
        });

    }
}
