package com.example.androidjetpack.NoteActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidjetpack.NoteActivity.EditNote.EditNoteActivity;
import com.example.androidjetpack.NoteActivity.EditNote.EditNoteViewModel;
import com.example.androidjetpack.R;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    public interface OnDeleteClickListener{
        void OnDeleteClickListener(Note myNote);
    }

    private final LayoutInflater layoutInflater;
    private Context context;
    private List<Note> mNotes;
    private OnDeleteClickListener onDeleteClickListener;

    ImageView img_update;
    ImageView img_delete;


    public NoteListAdapter(Context context,OnDeleteClickListener listener) {


        this.onDeleteClickListener = listener;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setNote(List<Note> notes) {

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
            holder.setListeners();


        } else
            holder.notetemText.setText("No Note !!");

    }

    @Override
    public int getItemCount() {
        if (mNotes != null) {
            return mNotes.size();
        } else
            return 0;
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {

        private TextView notetemText;
        private int mPosition;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            notetemText = itemView.findViewById(R.id.itemText);
            img_delete = itemView.findViewById(R.id.delete);
            img_update = itemView.findViewById(R.id.edit);


        }

        public void setData(String note, int position) {
            notetemText.setText(note);
            mPosition = position;
        }

        public void setListeners() {

            img_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Intent intent = new Intent(context, EditNoteActivity.class);
                    intent.putExtra("note_id",mNotes.get(mPosition).getId());
                    ((Activity)context).startActivityForResult(intent,Room.UPDATE_NOTE_ACTIVITY_REQUEST_CODE);

                }
            });


            img_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onDeleteClickListener!= null){
                        onDeleteClickListener.OnDeleteClickListener(mNotes.get(mPosition));
                    }
                }
            });


        }
    }
}
