package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;
import net.one97.paytm.hotels2.R;

public abstract class ae extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final Button f29122a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29123b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f29124c;

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f29125d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29126e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29127f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29128g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29129h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29130i;
    public final View j;
    public final View k;
    protected RoomSelectionViewModel l;

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected ae(Object obj, View view, Button button, ImageView imageView, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3) {
        super(obj, view, 2);
        this.f29122a = button;
        this.f29123b = imageView;
        this.f29124c = recyclerView;
        this.f29125d = recyclerView2;
        this.f29126e = textView;
        this.f29127f = textView2;
        this.f29128g = textView3;
        this.f29129h = textView4;
        this.f29130i = textView5;
        this.j = view2;
        this.k = view3;
    }

    public static ae a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ae) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_fare_breakup_bottom_sheet, viewGroup, false, f.a());
    }
}
