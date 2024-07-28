package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

public abstract class dw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f29537a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29538b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29539c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29540d;

    /* renamed from: e  reason: collision with root package name */
    protected RoomSelectionViewModel f29541e;

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected dw(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, 2);
        this.f29537a = imageView;
        this.f29538b = imageView2;
        this.f29539c = textView;
        this.f29540d = textView2;
    }
}
