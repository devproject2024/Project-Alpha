package com.travel.train.b;

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
import com.travel.train.R;
import java.util.ArrayList;

public final class x implements ListAdapter, SpinnerAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected Context f26572a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26573b;

    /* renamed from: c  reason: collision with root package name */
    protected int f26574c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f26575d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f26576e;

    /* renamed from: f  reason: collision with root package name */
    private String f26577f;

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

    public x(int i2, Context context, ArrayList<String> arrayList, Activity activity, String str) {
        this(i2, context);
        ((TextView) activity.getLayoutInflater().inflate(i2, (ViewGroup) null).findViewById(R.id.city_item_name)).setText(str);
        this.f26576e = arrayList;
        this.f26577f = str;
    }

    private x(int i2, Context context) {
        this.f26572a = context;
        this.f26573b = i2;
        this.f26574c = -1;
        this.f26575d = LayoutInflater.from(context);
    }

    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (i2 != 0) {
            return a(i2 - 1);
        }
        int i3 = this.f26574c;
        if (i3 == -1) {
            return new View(this.f26572a);
        }
        return this.f26575d.inflate(i3, viewGroup, false);
    }

    public final int getCount() {
        int size = this.f26576e.size();
        if (size == 0) {
            return 0;
        }
        return size + 1;
    }

    public final Object getItem(int i2) {
        if (i2 == 0) {
            return null;
        }
        return this.f26576e.get(i2 - 1);
    }

    private View a(int i2) {
        View inflate = this.f26575d.inflate(this.f26573b, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.city_item_name);
        inflate.setTag(textView);
        textView.setText(this.f26576e.get(i2));
        textView.setTextColor(b.c(this.f26572a, R.color.color_000000));
        return inflate;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (i2 != 0) {
            return a(i2 - 1);
        }
        View inflate = this.f26575d.inflate(this.f26573b, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.city_item_name);
        textView.setText(this.f26577f);
        textView.setTextColor(b.c(this.f26572a, R.color.payment_success_text_grey));
        return inflate;
    }
}
