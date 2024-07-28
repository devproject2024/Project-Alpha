package net.one97.paytm.hotels2.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotels2.R;

public abstract class ck extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29371a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f29372b;

    /* renamed from: c  reason: collision with root package name */
    public final CardView f29373c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f29374d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29375e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29376f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29377g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29378h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29379i;
    protected SRPDataItem j;

    public abstract void a(SRPDataItem sRPDataItem);

    protected ck(Object obj, View view, TextView textView, RecyclerView recyclerView, CardView cardView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, 0);
        this.f29371a = textView;
        this.f29372b = recyclerView;
        this.f29373c = cardView;
        this.f29374d = imageView;
        this.f29375e = textView2;
        this.f29376f = textView3;
        this.f29377g = textView4;
        this.f29378h = textView5;
        this.f29379i = textView6;
    }

    public static ck a(View view) {
        return (ck) bind(f.a(), view, R.layout.h4_list_item_similar_hotels);
    }
}
