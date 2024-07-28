package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.g.d;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotels2.R;

public abstract class cg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29356a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29357b;

    /* renamed from: c  reason: collision with root package name */
    protected d<String, String> f29358c;

    public abstract void a(d<String, String> dVar);

    protected cg(Object obj, View view, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f29356a = textView;
        this.f29357b = textView2;
    }

    public static cg a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (cg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_list_item_pair, viewGroup, false, f.a());
    }
}
