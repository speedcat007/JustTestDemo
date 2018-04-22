package com.example.hasee.myapplication;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public class TestProvider extends ContentProvider {

    private static final String TAG = "TestProvider";

    public static final String AUTOHORITY = "com.test.demo.authorityy";

    public static final int User_Code = 1;

    private TestDBHelper mDbHelper;

    private static final UriMatcher mMatcher;
    static{
        mMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        // 初始化
        mMatcher.addURI(AUTOHORITY,"user", User_Code);
    }

    @Override
    public boolean onCreate() {
        mDbHelper = new TestDBHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String tableName;
        switch (mMatcher.match(uri)) {
            case User_Code:
                tableName = TestDBHelper.USER_TABLE_NAME;
                break;
            default:
                return null;
        }
        return db.query(tableName,strings,s,strings1,null,null,s1);

    }


    @Override
    public Uri insert( Uri uri,  ContentValues contentValues) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        String tableName1;
        switch (mMatcher.match(uri)) {
            case User_Code:
                tableName1 = TestDBHelper.USER_TABLE_NAME;
                break;
            default:
                return null;
        }
        db.insert(tableName1,null,contentValues);
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }
}