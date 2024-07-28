package net.one97.paytm.hotels2.b;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class fs extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final View f29755a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f29756b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f29757c;

    /* renamed from: d  reason: collision with root package name */
    protected String f29758d;

    /* renamed from: e  reason: collision with root package name */
    protected Boolean f29759e;

    /* renamed from: f  reason: collision with root package name */
    protected Drawable f29760f;

    /* renamed from: g  reason: collision with root package name */
    protected String f29761g;

    public abstract void a(Drawable drawable);

    public abstract void a(Boolean bool);

    public abstract void a(String str);

    public abstract void b(String str);

    protected fs(Object obj, View view, View view2, TextView textView, TextView textView2) {
        super(obj, view, 0);
        this.f29755a = view2;
        this.f29756b = textView;
        this.f29757c = textView2;
    }
}
