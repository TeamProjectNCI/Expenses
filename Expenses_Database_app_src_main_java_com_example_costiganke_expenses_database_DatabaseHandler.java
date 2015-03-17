package com.example.costiganke.expenses_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by costiganke on 16/03/2015.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "expenseManager",
    TABLE_EXPENSES = "expenses",
    KEY_ID = "id",
    KEY_DATE = "date",
    KEY_AMOUNT="amount",
    KEY_CATEGORY="category",
    KEY_SUBCATEGORY ="subcategory",
    KEY_DESCRIPTION ="description",
    KEY_VOLUME ="volume",
    KEY_WEIGHT ="weight",
    KEY_CALORIES="calories",
    KEY_PAYEE ="payee",
    KEY_DISTANCE ="distance";

    public DatabaseHandler(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.exeSQL("CREATE TABLE " + TABLE_EXPENSES + "( " + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_DATE + "TEXT" + KEY_AMOUNT + "amount" + KEY_CATEGORY + "category"
                + KEY_SUBCATEGORY + "subcategory" + KEY_DESCRIPTION + "description" + KEY_VOLUME + "volume" + KEY_WEIGHT + "weight" + KEY_CALORIES + "calories"
                + KEY_PAYEE + "payee" + KEY_DISTANCE +"distance" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_EXPENSES);

        onCreate(db);

    }

   public void createExpense(Expense expense) {
       SQLiteDatabase db = getWritableDatabase();

       ContentValues values = new ContentValues();

       values.put(KEY_DATE, expense.getDate());
       values.put(KEY_AMOUNT, expense.getAmount());
       values.put(KEY_CATEGORY, expense.getCategory());
       values.put(KEY_SUBCATEGORY, expense.getSubCategory());
       values.put(KEY_DESCRIPTION, expense.getDescription());
       values.put(KEY_VOLUME, expense.getVolume());
       values.put(KEY_WEIGHT, expense.getWeight());
       values.put(KEY_CALORIES, expense.getCalories());
       values.put(KEY_PAYEE, expense.getPayee());
       values.put(KEY_DISTANCE, expense.getDistance());

       db.insert(TABLE_EXPENSES, null, values);
       db.close();
   }
    public Expense getExpense(int id) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_EXPENSES, new String[]{KEY_ID, KEY_DATE, KEY_AMOUNT, KEY_CATEGORY, KEY_SUBCATEGORY, KEY_DESCRIPTION,
                KEY_VOLUME, KEY_WEIGHT, KEY_CALORIES, KEY_PAYEE, KEY_DISTANCE }, KEY_ID + "=?", new String[] {String.valueOf(id) }, null, null, null,null );
        if(cursor != null)
            cursor.moveToFirst();
        Expense expense = new Expense(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));
        return expense;

        public void deleteExpense(Expense expense) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_EXPENSES, KEY_ID + "=?", new String[] { String.valueOf(expense.getID())});
        db.close();
    }
    public int getExpensesCount(){
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_EXPENSES, null);
        cursor.close();

        return cursor.getCount();

    }

    public int updateExpense(Expense expense){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, expense.getDate());
        values.put(KEY_AMOUNT, expense.getAmount());
        values.put(KEY_CATEGORY, expense.getCategory());
        values.put(KEY_SUBCATEGORY, expense.getSubCategory());
        values.put(KEY_DESCRIPTION, expense.getDescription());
        values.put(KEY_VOLUME, expense.getVolume());
        values.put(KEY_WEIGHT, expense.getWeight());
        values.put(KEY_CALORIES, expense.getCalories());
        values.put(KEY_PAYEE, expense.getPayee());
        values.put(KEY_DISTANCE, expense.getDistance());

        return db.update(TABLE_EXPENSES, values, KEY_ID + "=?", new String[] {String.valueOf(contact.getID())});


    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>(Expense);

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_EXPENSES, null);

        if (cursor.moveToFirst()){
            do {
                Expense expense = new Expense(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6), cursor.getString(7), cursor.getString(8), cursor.getString(9), cursor.getString(10));
                contacts.add(contact);
            }
            while (cursor.moveToNext());
        }
        return expenses;
    }




   }
}
