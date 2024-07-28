package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotel4.viewmodel.ErrorDialogViewModel;
import net.one97.paytm.hotels2.R;

public abstract class as extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CardView f29184a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29185b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29186c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29187d;

    /* renamed from: e  reason: collision with root package name */
    protected ErrorDialogViewModel f29188e;

    public abstract void a(ErrorDialogViewModel errorDialogViewModel);

    protected as(Object obj, View view, CardView cardView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 1);
        this.f29184a = cardView;
        this.f29185b = textView;
        this.f29186c = textView2;
        this.f29187d = textView3;
    }

    public static as a(LayoutInflater layoutInflater) {
        return (as) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_fragment_error_dialog, (ViewGroup) null, false, f.a());
    }
}
