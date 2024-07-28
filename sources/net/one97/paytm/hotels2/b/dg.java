package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

public abstract class dg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29465a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f29466b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29467c;

    /* renamed from: d  reason: collision with root package name */
    protected RoomSelectionViewModel f29468d;

    /* renamed from: e  reason: collision with root package name */
    protected ReviewViewModel f29469e;

    public abstract void a(ReviewViewModel reviewViewModel);

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected dg(Object obj, View view, TextView textView, LinearLayout linearLayout, TextView textView2) {
        super(obj, view, 4);
        this.f29465a = textView;
        this.f29466b = linearLayout;
        this.f29467c = textView2;
    }
}
