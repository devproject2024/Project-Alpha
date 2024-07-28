package org.greenrobot.greendao.internal;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;

public final class FastCursor implements Cursor {
    private final int count;
    private int position;
    private final CursorWindow window;

    public final Uri getNotificationUri() {
        return null;
    }

    public FastCursor(CursorWindow cursorWindow) {
        this.window = cursorWindow;
        this.count = cursorWindow.getNumRows();
    }

    public final int getCount() {
        return this.window.getNumRows();
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean move(int i2) {
        return moveToPosition(this.position + i2);
    }

    public final boolean moveToPosition(int i2) {
        if (i2 < 0 || i2 >= this.count) {
            return false;
        }
        this.position = i2;
        return true;
    }

    public final boolean moveToFirst() {
        this.position = 0;
        if (this.count > 0) {
            return true;
        }
        return false;
    }

    public final boolean moveToLast() {
        int i2 = this.count;
        if (i2 <= 0) {
            return false;
        }
        this.position = i2 - 1;
        return true;
    }

    public final boolean moveToNext() {
        int i2 = this.position;
        if (i2 >= this.count - 1) {
            return false;
        }
        this.position = i2 + 1;
        return true;
    }

    public final boolean moveToPrevious() {
        int i2 = this.position;
        if (i2 <= 0) {
            return false;
        }
        this.position = i2 - 1;
        return true;
    }

    public final boolean isFirst() {
        return this.position == 0;
    }

    public final boolean isLast() {
        return this.position == this.count - 1;
    }

    public final boolean isBeforeFirst() {
        throw new UnsupportedOperationException();
    }

    public final boolean isAfterLast() {
        throw new UnsupportedOperationException();
    }

    public final int getColumnIndex(String str) {
        throw new UnsupportedOperationException();
    }

    public final int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public final String getColumnName(int i2) {
        throw new UnsupportedOperationException();
    }

    public final String[] getColumnNames() {
        throw new UnsupportedOperationException();
    }

    public final int getColumnCount() {
        throw new UnsupportedOperationException();
    }

    public final byte[] getBlob(int i2) {
        return this.window.getBlob(this.position, i2);
    }

    public final String getString(int i2) {
        return this.window.getString(this.position, i2);
    }

    public final void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        throw new UnsupportedOperationException();
    }

    public final short getShort(int i2) {
        return this.window.getShort(this.position, i2);
    }

    public final int getInt(int i2) {
        return this.window.getInt(this.position, i2);
    }

    public final long getLong(int i2) {
        return this.window.getLong(this.position, i2);
    }

    public final float getFloat(int i2) {
        return this.window.getFloat(this.position, i2);
    }

    public final double getDouble(int i2) {
        return this.window.getDouble(this.position, i2);
    }

    public final boolean isNull(int i2) {
        return this.window.isNull(this.position, i2);
    }

    public final void deactivate() {
        throw new UnsupportedOperationException();
    }

    public final boolean requery() {
        throw new UnsupportedOperationException();
    }

    public final void close() {
        throw new UnsupportedOperationException();
    }

    public final boolean isClosed() {
        throw new UnsupportedOperationException();
    }

    public final void registerContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public final void unregisterContentObserver(ContentObserver contentObserver) {
        throw new UnsupportedOperationException();
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        throw new UnsupportedOperationException();
    }

    public final void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        throw new UnsupportedOperationException();
    }

    public final boolean getWantsAllOnMoveCalls() {
        throw new UnsupportedOperationException();
    }

    public final Bundle getExtras() {
        throw new UnsupportedOperationException();
    }

    public final Bundle respond(Bundle bundle) {
        throw new UnsupportedOperationException();
    }

    public final int getType(int i2) {
        throw new UnsupportedOperationException();
    }
}
