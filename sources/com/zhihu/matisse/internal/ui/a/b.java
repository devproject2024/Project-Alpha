package com.zhihu.matisse.internal.ui.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.android.chat.R;
import com.zhihu.matisse.internal.entity.Album;
import com.zhihu.matisse.internal.entity.c;

public final class b extends CursorAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final Drawable f45824a;

    public b(Context context) {
        super(context, (Cursor) null, false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.album_thumbnail_placeholder});
        this.f45824a = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.chat_album_list_item, viewGroup, false);
    }

    public final void bindView(View view, Context context, Cursor cursor) {
        Album a2 = Album.a(cursor);
        ((TextView) view.findViewById(R.id.album_name)).setText(a2.a(context));
        ((TextView) view.findViewById(R.id.album_media_count)).setText(String.valueOf(a2.f45761d));
        c.a.f45787a.p.a(context, context.getResources().getDimensionPixelSize(R.dimen.media_grid_size), this.f45824a, (ImageView) view.findViewById(R.id.album_cover), a2.f45760c);
    }
}
