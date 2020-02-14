package com.example.androidjetpack.NoteActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.androidjetpack.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import java.util.UUID;

public class Room extends AppCompatActivity {

    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;

    FloatingActionButton button;
    private NoteViewModel noteViewModel;
    RecyclerView recyclerView;
    private NoteListAdapter noteListAdapter;
    LayoutInflater layoutInflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        button = findViewById(R.id.floatingActionButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Room.this, NewNoteActivity.class);
                startActivityForResult(intent, NEW_NOTE_ACTIVITY_REQUEST_CODE);

            }
        });

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);


        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {

                noteListAdapter.setNote(notes);
            }
        });

        recyclerView = findViewById(R.id.liste);
        noteListAdapter = new NoteListAdapter(this, layoutInflater);
        recyclerView.setAdapter(noteListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            final String note_id = UUID.randomUUID().toString();

            Note note = new Note(note_id, data.getStringExtra(NewNoteActivity.NOTE_ADDED));
            noteViewModel.insert(note);

            Toast.makeText(getApplicationContext(),
                    "Saved",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),
                    "Not Saved !! ",
                    Toast.LENGTH_SHORT).show();
        }

    }

}
