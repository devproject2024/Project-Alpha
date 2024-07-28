package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotels2.R;

public abstract class bi extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView f29256a;

    protected bi(Object obj, View view, RecyclerView recyclerView) {
        super(obj, view, 0);
        this.f29256a = recyclerView;
    }

    public static bi a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (bi) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_gallery_list_fragment, viewGroup, false, f.a());
    }
}
