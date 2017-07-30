package enrinal.com.popularmovies;

import android.content.Context;
import android.database.Cursor;

import enrinal.com.popularmovies.data.MovieContract;

public class Utility {

    public static int isFavorite(Context context, int id) {
        Cursor cursor = context.getContentResolver().query(
                MovieContract.MovieEntry.CONTENT_URI,
                null,
                MovieContract.MovieEntry.COLUMN_MOVIE_ID + " = ?",
                new String[] { Integer.toString(id) },
                null
        );
        assert cursor != null;
        int numRows = cursor.getCount();
        cursor.close();
        return numRows;
    }

    public static String buildImageUrl(int width, String fileName) {
        return "http://image.tmdb.org/t/p/w" + Integer.toString(width) + fileName;
    }
}
