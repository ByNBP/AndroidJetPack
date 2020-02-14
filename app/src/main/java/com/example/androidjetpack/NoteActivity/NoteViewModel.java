package com.example.androidjetpack.NoteActivity;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteDao noteDao;
    private NoteRoomDatabase noteDB;
    private LiveData<List<Note>> mAllNotes;

    public NoteViewModel(Application application) {
        super(application);

        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDao = noteDB.noteDao();
        mAllNotes = noteDao.getAllNotes();

    }

    public void insert(Note note) {
        new InsertAsyncTask(noteDao).execute(note);
    }

    LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i("TAG", "ViewModel Destroyed !!");
    }

    private class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

        NoteDao mNoteDao;

        public InsertAsyncTask(NoteDao mNoteDao) {
            this.mNoteDao = mNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insert(notes[0]);
            return null;
        }
    }


}
