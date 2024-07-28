package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.ui.feed.a;

public abstract class bi extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f33948a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f33949b;

    /* renamed from: c  reason: collision with root package name */
    public final RelativeLayout f33950c;

    /* renamed from: d  reason: collision with root package name */
    public final RoundedImageView f33951d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f33952e;

    /* renamed from: f  reason: collision with root package name */
    protected String f33953f;

    /* renamed from: g  reason: collision with root package name */
    protected String f33954g;

    /* renamed from: h  reason: collision with root package name */
    protected String f33955h;

    /* renamed from: i  reason: collision with root package name */
    protected Integer f33956i;
    protected a j;

    protected bi(Object obj, View view, TextView textView, RecyclerView recyclerView, RelativeLayout relativeLayout, RoundedImageView roundedImageView, TextView textView2) {
        super(obj, view, 0);
        this.f33948a = textView;
        this.f33949b = recyclerView;
        this.f33950c = relativeLayout;
        this.f33951d = roundedImageView;
        this.f33952e = textView2;
    }
}
