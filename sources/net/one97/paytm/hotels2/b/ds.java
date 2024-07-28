package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel;

public abstract class ds extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f29519a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29520b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29521c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29522d;

    /* renamed from: e  reason: collision with root package name */
    protected RoomSelectionViewModel f29523e;

    public abstract void a(RoomSelectionViewModel roomSelectionViewModel);

    protected ds(Object obj, View view, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, TextView textView) {
        super(obj, view, 0);
        this.f29519a = constraintLayout;
        this.f29520b = imageView;
        this.f29521c = imageView2;
        this.f29522d = textView;
    }
}
