package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.flaviofaria.kenburnsview.KenBurnsView;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.feed.a;

public abstract class ae extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33820a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f33821b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33822c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f33823d;

    /* renamed from: e  reason: collision with root package name */
    public final KenBurnsView f33824e;

    /* renamed from: f  reason: collision with root package name */
    protected FeedGeneric f33825f;

    /* renamed from: g  reason: collision with root package name */
    protected Integer f33826g;

    /* renamed from: h  reason: collision with root package name */
    protected a f33827h;

    /* renamed from: i  reason: collision with root package name */
    protected Boolean f33828i;

    protected ae(Object obj, View view, TextView textView, TextView textView2, TextView textView3, ImageView imageView, KenBurnsView kenBurnsView) {
        super(obj, view, 0);
        this.f33820a = textView;
        this.f33821b = textView2;
        this.f33822c = textView3;
        this.f33823d = imageView;
        this.f33824e = kenBurnsView;
    }
}
