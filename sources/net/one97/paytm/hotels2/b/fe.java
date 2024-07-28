package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;

public abstract class fe extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29697a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29698b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29699c;

    /* renamed from: d  reason: collision with root package name */
    protected AutoSearchDataItem f29700d;

    /* renamed from: e  reason: collision with root package name */
    protected Boolean f29701e;

    /* renamed from: f  reason: collision with root package name */
    protected Drawable f29702f;

    /* renamed from: g  reason: collision with root package name */
    protected String f29703g;

    /* renamed from: h  reason: collision with root package name */
    protected String f29704h;

    public abstract void a(Drawable drawable);

    public abstract void a(Boolean bool);

    public abstract void a(String str);

    public abstract void a(AutoSearchDataItem autoSearchDataItem);

    public abstract void b(String str);

    protected fe(Object obj, View view, View view2, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f29697a = view2;
        this.f29698b = textView;
        this.f29699c = textView2;
    }
}
