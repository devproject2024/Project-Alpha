package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.viewmodel.ReviewViewModel;

public abstract class cw extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f29421a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f29422b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29423c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29424d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29425e;

    /* renamed from: f  reason: collision with root package name */
    protected ReviewViewModel f29426f;

    public abstract void a(ReviewViewModel reviewViewModel);

    protected cw(Object obj, View view, EditText editText, EditText editText2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 2);
        this.f29421a = editText;
        this.f29422b = editText2;
        this.f29423c = textView;
        this.f29424d = textView2;
        this.f29425e = textView3;
    }
}
