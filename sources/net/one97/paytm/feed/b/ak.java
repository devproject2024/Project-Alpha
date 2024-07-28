package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.feed.repository.models.livetv.ChannelCategory;
import net.one97.paytm.feed.ui.feed.livetv.a;

public abstract class ak extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33845a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f33846b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33847c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33848d;

    /* renamed from: e  reason: collision with root package name */
    protected ChannelCategory f33849e;

    /* renamed from: f  reason: collision with root package name */
    protected a f33850f;

    protected ak(Object obj, View view, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3) {
        super(obj, view, 0);
        this.f33845a = textView;
        this.f33846b = recyclerView;
        this.f33847c = textView2;
        this.f33848d = textView3;
    }
}
