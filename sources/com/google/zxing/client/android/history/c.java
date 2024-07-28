package com.google.zxing.client.android.history;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.zxing.client.android.R;
import com.google.zxing.r;
import java.util.ArrayList;

final class c extends ArrayAdapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f40239a;

    c(Context context) {
        super(context, R.layout.history_list_item, new ArrayList());
        this.f40239a = context;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        String str;
        String str2;
        if (!(view instanceof LinearLayout)) {
            view = LayoutInflater.from(this.f40239a).inflate(R.layout.history_list_item, viewGroup, false);
        }
        b bVar = (b) getItem(i2);
        r rVar = bVar.f40236a;
        if (rVar != null) {
            str = rVar.f40577a;
            StringBuilder sb = new StringBuilder();
            if (bVar.f40237b == null || bVar.f40237b.isEmpty()) {
                sb.append(bVar.f40236a.f40577a);
            } else {
                sb.append(bVar.f40237b);
            }
            if (bVar.f40238c != null && !bVar.f40238c.isEmpty()) {
                sb.append(" : ");
                sb.append(bVar.f40238c);
            }
            str2 = sb.toString();
        } else {
            Resources resources = getContext().getResources();
            str = resources.getString(R.string.history_empty);
            str2 = resources.getString(R.string.history_empty_detail);
        }
        ((TextView) view.findViewById(R.id.history_title)).setText(str);
        ((TextView) view.findViewById(R.id.history_detail)).setText(str2);
        return view;
    }
}
