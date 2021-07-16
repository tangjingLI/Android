package com.byted.camp.todolist.ui;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.byted.camp.todolist.NoteOperator;
import com.byted.camp.todolist.R;
import com.byted.camp.todolist.beans.Note;
import com.byted.camp.todolist.beans.State;

import java.text.SimpleDateFormat;
import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author zhongshan
 * @date 2021-04-19
 */
public class NoteViewHolder extends RecyclerView.ViewHolder {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat("EEE, d MMM yyyy", Locale.ENGLISH);

    private final NoteOperator operator;
    private RelativeLayout notePad;
    private CheckBox checkBox;
    private TextView contentText;
    private TextView dateText;
    private TextView ddl;
    private View deleteBtn;

    public NoteViewHolder(@NonNull View itemView, NoteOperator operator) {
        super(itemView);
        this.operator = operator;
        notePad = itemView.findViewById(R.id.note);
        checkBox = itemView.findViewById(R.id.checkbox);
        contentText = itemView.findViewById(R.id.text_content);
        dateText = itemView.findViewById(R.id.text_date);
        deleteBtn = itemView.findViewById(R.id.btn_delete);
        ddl = itemView.findViewById(R.id.text_ddl);
    }

    public void bind(final Note note) {
        notePad.setBackgroundColor(note.getPriority().color);
        contentText.setText(note.getContent());
        dateText.setText("created on: "+SIMPLE_DATE_FORMAT.format(note.getDate()));
        ddl.setText("Deadline: "+note.getDeadline());
        checkBox.setOnCheckedChangeListener(null);
        checkBox.setChecked(note.getState() == State.DONE);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                note.setState(isChecked ? State.DONE : State.TODO);
                operator.updateNote(note);
            }
        });
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator.deleteNote(note);
            }
        });

        if (note.getState() == State.DONE) {
            contentText.setTextColor(Color.GRAY);
            contentText.setPaintFlags(contentText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            contentText.setTextColor(Color.BLACK);
            contentText.setPaintFlags(contentText.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
