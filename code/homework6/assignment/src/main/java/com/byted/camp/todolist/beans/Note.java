package com.byted.camp.todolist.beans;

import java.util.Date;

/**
 * @author zhongshan
 * @date 2021-04-19
 */
public class Note {

    public final long id;
    private Date date;
    private State state;
    private String content;
    private String deadline;
    private Priority priority;


    public Note(long id) {
        this.id = id;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
