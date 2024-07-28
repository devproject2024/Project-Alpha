package net.one97.paytm.hotels2.b;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotels2.R;

public abstract class bs extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29290a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f29291b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f29292c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f29293d;

    protected bs(Object obj, View view, View view2, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        super(obj, view, 0);
        this.f29290a = view2;
        this.f29291b = imageView;
        this.f29292c = recyclerView;
        this.f29293d = textView;
    }

    public static bs a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return (bs) ViewDataBinding.inflateInternal(layoutInflater, R.layout.h4_image_text_bottom_sheet, viewGroup, false, f.a());
    }
}
