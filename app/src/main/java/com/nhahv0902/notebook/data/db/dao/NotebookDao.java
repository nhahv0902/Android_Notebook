package com.nhahv0902.notebook.data.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.support.annotation.NonNull;
import com.nhahv0902.notebook.data.db.entity.Notebook;
import java.util.List;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

@Dao
public interface NotebookDao {
    @Query("SELECT * FROM notebook")
    List<Notebook> getAllNotebook();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNotebook(@NonNull Notebook notebook);

    @Delete
    void deleteNotebook(@NonNull Notebook notebook);
}
