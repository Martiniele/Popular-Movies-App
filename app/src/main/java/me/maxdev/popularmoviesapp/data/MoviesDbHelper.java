package me.maxdev.popularmoviesapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Manages a local database for movies.
 */
public class MoviesDbHelper extends SQLiteOpenHelper {

    static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_SCHEMA_VERSION = 2;

    public MoviesDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(MoviesContract.MovieEntry.SQL_CREATE_TABLE);
        db.execSQL(MoviesContract.MostPopularMovies.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DROP_TABLE_IF_EXISTS = "DROP TABLE IF EXISTS ";

        db.execSQL(SQL_DROP_TABLE_IF_EXISTS + MoviesContract.MovieEntry.TABLE_NAME);
        db.execSQL(SQL_DROP_TABLE_IF_EXISTS + MoviesContract.MostPopularMovies.TABLE_NAME);
        onCreate(db);
    }
}
