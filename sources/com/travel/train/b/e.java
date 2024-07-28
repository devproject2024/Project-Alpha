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
import com.travel.train.R;
import java.util.ArrayList;

public final class e implements ListAdapter, SpinnerAdapter {

    /* renamed from: a  reason: collision with root package name */
    protected Context f26383a;

    /* renamed from: b  reason: collision with root package name */
    protected int f26384b;

    /* renamed from: c  reason: collision with root package name */
    protected int f26385c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f26386d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<String> f26387e;

    /* renamed from: f  reason: collision with root package name */
    private String f26388f;

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

    public e(int i2, Context context, ArrayList<String> arrayList, Activity activity, String str) {
        this(i2, context);
        ((TextView) activity.getLayoutInflater().inflate(i2, (ViewGroup) null).findViewById(R.id.item_name)).setText(str);
        this.f26387e = arrayList;
        this.f26388f = str;
    }

    private e(int i2, Context context) {
        this.f26383a = context;
        this.f26384b = i2;
        this.f26385c = -1;
        this.f26386d = LayoutInflater.from(context);
    }

    public final View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        if (i2 != 0) {
            return a(i2 - 1);
        }
        int i3 = this.f26385c;
        if (i3 == -1) {
            return new View(this.f26383a);
        }
        return this.f26386d.inflate(i3, viewGroup, false);
    }

    public final int getCount() {
        int size = this.f26387e.size();
        if (size == 0) {
            return 0;
        }
        return size + 1;
    }

    public final Object getItem(int i2) {
        if (i2 == 0) {
            return null;
        }
        return this.f26387e.get(i2 - 1);
    }

    private View a(int i2) {
        View inflate = this.f26386d.inflate(this.f26384b, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.item_name);
        inflate.setTag(textView);
        textView.setText(this.f26387e.get(i2));
        textView.setTextColor(this.f26383a.getResources().getColor(R.color.color_000000));
        return inflate;
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        if (i2 != 0) {
            return a(i2 - 1);
        }
        View inflate = this.f26386d.inflate(this.f26384b, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.item_name);
        textView.setText(this.f26388f);
        textView.setTextColor(this.f26383a.getResources().getColor(R.color.payment_success_text_grey));
        return inflate;
    }
}
