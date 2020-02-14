package com.example.androidjetpack.NoteActivity.EditNote;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.androidjetpack.NoteActivity.Note;
import com.example.androidjetpack.R;

public class EditNoteActivity extends AppCompatActivity {

    public static final String NOTE_ID = "note_id";
    public static final String UPDATED_NOTE = "note_text";
    private EditText etNote;
    private Bundle bundle;
    private String noteId;
    private LiveData<Note> note;


    EditNoteViewModel noteViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);


        etNote = findViewById(R.id.editNoteText);

        bundle = getIntent().getExtras();
        if (bundle != null){
            noteId = bundle.getString("note_id");
        }


        noteViewModel = ViewModelProviders.of(this).get(EditNoteViewModel.class);

        note = noteViewModel.getNote(noteId);
        note.observe(this, new Observer<Note>() {
            @Override
            public void onChanged(Note note) {
                etNote.setText(note.mNote());
            }
        });




    }


    public void updateNote(View view){
        String updatedNote = etNote.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra(NOTE_ID, noteId);
        resultIntent.putExtra(UPDATED_NOTE, updatedNote);
        setResult(RESULT_OK,resultIntent);
        finish();


    }
    public void cancelNote(View view){

        finish();

    }


}
