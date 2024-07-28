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

public abstract class ce extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f29347a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f29348b;

    /* renamed from: c  reason: collision with root package name */
    public final CardView f29349c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f29350d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f29351e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f29352f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f29353g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f29354h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f29355i;
    protected SRPDataItem j;

    public abstract void a(SRPDataItem sRPDataItem);

    protected ce(Object obj, View view, TextView textView, RecyclerView recyclerView, CardView cardView, ImageView imageView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, 0);
        this.f29347a = textView;
        this.f29348b = recyclerView;
        this.f29349c = cardView;
        this.f29350d = imageView;
        this.f29351e = textView2;
        this.f29352f = textView3;
        this.f29353g = textView4;
        this.f29354h = textView5;
        this.f29355i = textView6;
    }

    public static ce a(View view) {
        return (ce) bind(f.a(), view, R.layout.h4_list_item_map_hotels);
    }
}
