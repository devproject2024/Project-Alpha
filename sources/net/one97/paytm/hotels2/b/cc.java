package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotels2.R;

public abstract class cc extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29339a;

    /* renamed from: b  reason: collision with root package name */
    protected String f29340b;

    /* renamed from: c  reason: collision with root package name */
    protected String f29341c;

    public abstract void a(String str);

    public abstract void b(String str);

    protected cc(Object obj, View view, TextView textView) {
        super(obj, view, 0);
        this.f29339a = textView;
    }

    public static cc a(View view) {
        return (cc) bind(f.a(), view, R.layout.h4_list_item_amenity);
    }
}
