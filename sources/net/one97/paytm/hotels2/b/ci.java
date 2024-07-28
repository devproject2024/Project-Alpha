package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotels2.R;

public abstract class ci extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29363a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29364b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29365c;

    /* renamed from: d  reason: collision with root package name */
    protected CJRRoom f29366d;

    public abstract void a(CJRRoom cJRRoom);

    protected ci(Object obj, View view, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f29363a = textView;
        this.f29364b = textView2;
        this.f29365c = textView3;
    }

    public static ci a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (ci) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_list_item_room_price, viewGroup, false, f.a());
    }
}
