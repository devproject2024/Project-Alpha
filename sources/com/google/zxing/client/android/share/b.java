package com.google.zxing.client.android.share;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R;

final class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40291a;

    /* renamed from: b  reason: collision with root package name */
    private final Cursor f40292b;

    public final Object getItem(int i2) {
        return null;
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    b(Context context, Cursor cursor) {
        this.f40291a = context;
        this.f40292b = cursor;
    }

    public final int getCount() {
        return this.f40292b.getCount();
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (!(view instanceof LinearLayout)) {
            view = LayoutInflater.from(this.f40291a).inflate(R.layout.bookmark_picker_list_item, viewGroup, false);
        }
        if (!this.f40292b.isClosed()) {
            this.f40292b.moveToPosition(i2);
            ((TextView) view.findViewById(R.id.bookmark_title)).setText(this.f40292b.getString(0));
            ((TextView) view.findViewById(R.id.bookmark_url)).setText(this.f40292b.getString(1));
        }
        return view;
    }
}
