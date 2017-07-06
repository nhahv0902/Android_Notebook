package com.nhahv0902.notebook.data.db;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import com.nhahv0902.notebook.data.db.dao.NotebookDao;
import com.nhahv0902.notebook.data.db.entity.Notebook;

@Database(entities = { Notebook.class }, version = 1)
public abstract class DatabaseCreator extends RoomDatabase {

    private static final String DATABASE_NAME = "Notebook.db";
    private static DatabaseCreator sInstance;

    public synchronized static DatabaseCreator getInstance(Context context) {
        if (sInstance == null) {
            synchronized (DatabaseCreator.class) {
                sInstance =
                        Room.databaseBuilder(context, DatabaseCreator.class, DATABASE_NAME).build();
            }
        }
        return sInstance;
    }

    abstract NotebookDao getNotebookDao();
}
