package com.travel.bus.busticket.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.travel.bus.R;

public final class j extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Context f21669a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f21670b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f21671c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21672d;

    public final Object getItem(int i2) {
        return null;
    }

    public final long getItemId(int i2) {
        return 0;
    }

    public j(Context context, String[] strArr, boolean z) {
        this.f21669a = context;
        this.f21670b = strArr;
        this.f21672d = z;
        this.f21671c = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.f21670b.length;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        View view2;
        if (this.f21672d) {
            view2 = this.f21671c.inflate(R.layout.pre_b_spinner_text_view, (ViewGroup) null);
        } else {
            view2 = this.f21671c.inflate(R.layout.pre_b_spinner_text_view_for_concession, (ViewGroup) null);
        }
        ((TextView) view2.findViewById(R.id.spinner_text)).setText(this.f21670b[i2]);
        return view2;
    }
}
