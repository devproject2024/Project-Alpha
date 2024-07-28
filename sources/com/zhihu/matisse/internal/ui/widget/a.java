package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.zhihu.matisse.internal.entity.Album;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public CursorAdapter f45884a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f45885b;

    /* renamed from: c  reason: collision with root package name */
    public b f45886c;

    /* renamed from: d  reason: collision with root package name */
    public AdapterView.OnItemSelectedListener f45887d;

    /* renamed from: e  reason: collision with root package name */
    public View f45888e;

    /* renamed from: f  reason: collision with root package name */
    public View f45889f;

    /* renamed from: g  reason: collision with root package name */
    private Context f45890g;

    public a(Context context) {
        this.f45890g = context;
        this.f45886c = new b(context);
        b bVar = this.f45886c;
        bVar.f45894b.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                a.this.a(adapterView.getContext(), i2);
                if (a.this.f45887d != null) {
                    a.this.f45887d.onItemSelected(adapterView, view, i2, j);
                }
            }
        });
    }

    public final void a(Context context, int i2) {
        this.f45886c.dismiss();
        Cursor cursor = this.f45884a.getCursor();
        cursor.moveToPosition(i2);
        String a2 = Album.a(cursor).a(context);
        if (this.f45885b.getVisibility() == 0) {
            this.f45885b.setText(a2);
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            this.f45885b.setAlpha(0.0f);
            this.f45885b.setVisibility(0);
            this.f45885b.setText(a2);
            this.f45885b.animate().alpha(1.0f).setDuration((long) context.getResources().getInteger(17694722)).start();
            return;
        }
        this.f45885b.setVisibility(0);
        this.f45885b.setText(a2);
    }
}
