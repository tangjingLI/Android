package com.byted.camp.todolist.db;

import android.provider.BaseColumns;

/**
 * @author zhongshan
 * @date 2021-04-19
 */
public final class TodoContract {

    // TODO 定义表结构和 SQL 语句常量
    public static class TodoEntry implements BaseColumns {

        public static final String TABLE_NAME = "TodoList";
        public static final String COLUMN_DEADLINE = "ddl";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_STATE = "state";
        public static final String COLUMN_CONTENT = "content";
        public static final String COLUMN_PRIORITY = "priority";
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TodoEntry.TABLE_NAME
                    + "(" + TodoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    TodoEntry.COLUMN_DATE + " Integer, " + TodoEntry.COLUMN_STATE + " Integer, "
                    + TodoEntry.COLUMN_DEADLINE + " TEXT, " + TodoEntry.COLUMN_PRIORITY + " Integer, "
                    + TodoEntry.COLUMN_CONTENT + " TEXT)";

    public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS" + TodoEntry.TABLE_NAME;

}
