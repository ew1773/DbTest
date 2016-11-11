package alpha.com.dbtest;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 11/10/2016.
 */

public class SqlTest extends SQLiteOpenHelper {



    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Simple_Count";

    // Contacts table name
    private static final String TABLE_COUNT = "countTable";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_COUNT = "countInt";



    private static final String COUNT_TABLE_CREATE =
            "CREATE TABLE " + TABLE_COUNT + " (" +
                    KEY_ID + " TEXT, " +
                    KEY_COUNT + " TEXT);";

    public SqlTest(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(COUNT_TABLE_CREATE);
}
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COUNT);

        // Create tables again
        onCreate(db);
    }

    void addCount(Count count) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ID, count.getId()); // Contact Name
        values.put(KEY_COUNT, count.getCount()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_COUNT, null, values);
        db.close(); // Closing database connection
    }


        }