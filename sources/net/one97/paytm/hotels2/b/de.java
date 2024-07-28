package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

public abstract class de extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29456a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f29457b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29458c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29459d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29460e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29461f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29462g;

    /* renamed from: h  reason: collision with root package name */
    public final View f29463h;

    /* renamed from: i  reason: collision with root package name */
    public final View f29464i;
    public final View j;
    protected RoomSelectionViewModel k;
    protected ReviewViewModel l;

    public abstract void a(ReviewViewModel reviewViewModel);

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected de(Object obj, View view, RecyclerView recyclerView, RecyclerView recyclerView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, View view3, View view4) {
        super(obj, view, 2);
        this.f29456a = recyclerView;
        this.f29457b = recyclerView2;
        this.f29458c = textView;
        this.f29459d = textView2;
        this.f29460e = textView3;
        this.f29461f = textView4;
        this.f29462g = textView5;
        this.f29463h = view2;
        this.f29464i = view3;
        this.j = view4;
    }
}
