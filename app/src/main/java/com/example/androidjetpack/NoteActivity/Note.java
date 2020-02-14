package com.example.androidjetpack.NoteActivity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NonNls;

@Entity(tableName = "notes")
public class Note {




    @PrimaryKey
    @NonNull
    private String id;

    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public Note( String id, String mNote) {
        this.id = id;
        this.mNote = mNote;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId( String id) {
        this.id = id;
    }

    @NonNull
    public String mNote() {
        return mNote;
    }
}
