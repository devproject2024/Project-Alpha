package com.travel.bus.busticket.a;

import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.core.content.b;
import com.travel.bus.R;
import java.util.ArrayList;

public final class i implements ListAdapter, SpinnerAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected Context f21663a;

    /* renamed from: b  reason: collision with root package name */
    protected int f21664b;

    /* renamed from: c  reason: collision with root package name */
    protected int f21665c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f21666d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f21667e;

    /* renamed from: f  reason: collision with root package name */
    private String f21668f;

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final long getItemId(int i2) {
        while (i2 > 0) {
            i2--;
        }
        return (long) (i2 - 1);
    }

    public final int getItemViewType(int i2) {
        return 0;
    }

    public final int getViewTypeCount() {
        return 1;
    }

    public final boolean hasStableIds() {
        return true;
    }

    public final boolean isEmpty() {
        return false;
    }

    public final boolean isEnabled(int i2) {
        return i2 != 0;
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
    }

    public i(int i2, Context context, ArrayList<String> arrayList, Activity activity, String str) {
        this(i2, context);
        ((TextView) activity.getLayoutInflater().inflate(i2, (ViewGroup) null).findViewById(R.id.city_item_name)).setText(str);
        this.f21667e = arrayList;
        this.f21668f = str;
    }

    private i(int i2, Context context) {
        this.f21663a = context;
        this.f21664b = i2;
        this.f21665c = -1;
        this.f21666d = LayoutInflater.from(context);
    }

    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (i2 != 0) {
            return a(i2 - 1);
        }
        int i3 = this.f21665c;
        if (i3 == -1) {
            return new View(this.f21663a);
        }
        return this.f21666d.inflate(i3, viewGroup, false);
    }

    public final int getCount() {
        int size = this.f21667e.size();
        if (size == 0) {
            return 0;
        }
        return size + 1;
    }

    public final Object getItem(int i2) {
        if (i2 == 0) {
            return null;
        }
        return this.f21667e.get(i2 - 1);
    }

    private View a(int i2) {
        View inflate = this.f21666d.inflate(this.f21664b, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.city_item_name);
        inflate.setTag(textView);
        textView.setText(this.f21667e.get(i2));
        textView.setTextColor(b.c(this.f21663a, R.color.color_000000));
        return inflate;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (i2 != 0) {
            return a(i2 - 1);
        }
        View inflate = this.f21666d.inflate(this.f21664b, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.city_item_name);
        textView.setText(this.f21668f);
        textView.setTextColor(b.c(this.f21663a, R.color.payment_success_text_grey));
        return inflate;
    }
}
