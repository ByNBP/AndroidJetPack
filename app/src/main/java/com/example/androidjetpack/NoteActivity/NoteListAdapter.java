package com.example.androidjetpack.NoteActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidjetpack.R;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {


    private final LayoutInflater layoutInflater;
    private Context context;
    private List<Note> mNotes;

    public NoteListAdapter(Context context, LayoutInflater layoutInflater) {

        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setNote(List<Note> notes){

        mNotes = notes;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = layoutInflater.inflate(R.layout.view_listview_item, parent, false);
        NoteViewHolder viewHolder = new NoteViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {

        if (mNotes != null) {
            Note note = mNotes.get(position);
            holder.setData(note.mNote(), position);
        } else
            holder.notetemText.setText("No Note !!");

    }

    @Override
    public int getItemCount() {
        if (mNotes != null){
            return mNotes.size();
        }else
            return 0;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView notetemText;
        private int mPosition;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            notetemText = itemView.findViewById(R.id.itemText);
        }

        public void setData(String note, int position) {
            notetemText.setText(note);
            mPosition = position;
        }
    }
}
