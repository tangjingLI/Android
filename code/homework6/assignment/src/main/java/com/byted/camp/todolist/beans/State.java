package com.byted.camp.todolist.beans;

/**
 * @author zhongshan
 * @date 2021-04-19
 */
public enum State {
    TODO(0), DONE(1);

    public final int intValue;

    State(int intValue) {
        this.intValue = intValue;
    }

    public static State from(int intValue) {
        for (State state : State.values()) {
            if (state.intValue == intValue) {
                return state;
            }
        }
        return TODO; // default
    }
}
