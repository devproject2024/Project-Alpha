package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

public abstract class du extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29528a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29529b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29530c;

    /* renamed from: d  reason: collision with root package name */
    protected RoomSelectionViewModel f29531d;

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected du(Object obj, View view, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 1);
        this.f29528a = textView;
        this.f29529b = textView2;
        this.f29530c = textView3;
    }
}
