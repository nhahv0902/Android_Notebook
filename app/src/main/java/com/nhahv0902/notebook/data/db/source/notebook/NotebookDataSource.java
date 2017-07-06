package com.nhahv0902.notebook.data.db.source.notebook;

import android.support.annotation.NonNull;
import com.nhahv0902.notebook.data.db.entity.Notebook;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

public interface NotebookDataSource {
    void addNotebook(@NonNull Notebook notebook);

}
