package com.google.zxing.client.android.share;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.provider.Browser;
import android.view.View;
import android.widget.ListView;

public final class BookmarkPickerActivity extends ListActivity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40273a = BookmarkPickerActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f40274b = {"title", "url"};

    /* renamed from: c  reason: collision with root package name */
    private Cursor f40275c;

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        this.f40275c = getContentResolver().query(Browser.BOOKMARKS_URI, f40274b, "bookmark = 1 AND url IS NOT NULL", (String[]) null, (String) null);
        Cursor cursor = this.f40275c;
        if (cursor == null) {
            finish();
        } else {
            setListAdapter(new b(this, cursor));
        }
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        Cursor cursor = this.f40275c;
        if (cursor != null) {
            cursor.close();
            this.f40275c = null;
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onListItemClick(ListView listView, View view, int i2, long j) {
        if (this.f40275c.isClosed() || !this.f40275c.moveToPosition(i2)) {
            setResult(0);
        } else {
            Intent intent = new Intent();
            intent.addFlags(524288);
            intent.putExtra("title", this.f40275c.getString(0));
            intent.putExtra("url", this.f40275c.getString(1));
            setResult(-1, intent);
        }
        finish();
    }
}
