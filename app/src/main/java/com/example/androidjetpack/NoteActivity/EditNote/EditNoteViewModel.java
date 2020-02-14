package com.example.androidjetpack.NoteActivity.EditNote;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.androidjetpack.NoteActivity.Note;
import com.example.androidjetpack.NoteActivity.NoteDao;
import com.example.androidjetpack.NoteActivity.NoteRoomDatabase;

public class EditNoteViewModel extends AndroidViewModel {


    private NoteDao noteDao;
    private NoteRoomDatabase db;



    public EditNoteViewModel(@NonNull Application application) {
        super(application);
        Log.i("TAG", "EditNote ViewModel");

        db = NoteRoomDatabase.getDatabase(application);
        noteDao = db.noteDao();

    }

    public LiveData<Note> getNote(String noteId) {
        return noteDao.getNote(noteId);
    }
}
