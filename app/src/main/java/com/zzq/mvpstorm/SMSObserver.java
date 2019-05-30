package com.zzq.mvpstorm;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

public class SMSObserver extends ContentObserver {
    private Context mContext;

    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public SMSObserver(Handler handler, Context context) {
        super(handler);
        mContext = context;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
        Cursor cursor = mContext.getContentResolver().query(Uri.parse("content://sms/"), new String[]{"body",
                "type","status","_id"},
                "address == 10010", null, "date desc");
        cursor.moveToFirst();
        int type = cursor.getInt(cursor.getColumnIndex("type"));
        int status = cursor.getInt(cursor.getColumnIndex("status"));
        int id = cursor.getInt(cursor.getColumnIndex("_id"));
        if (type == 1){
            String msgContent = cursor.getString(cursor.getColumnIndex("body"));
            Toast.makeText(mContext, id + msgContent, Toast.LENGTH_SHORT).show();
        }
        cursor.close();
    }
}
