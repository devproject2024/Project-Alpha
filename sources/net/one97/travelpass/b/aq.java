package net.one97.travelpass.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;

public abstract class aq extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f30109a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f30110b;

    /* renamed from: c  reason: collision with root package name */
    public final View f30111c;

    protected aq(Object obj, View view, RelativeLayout relativeLayout, TextView textView, View view2) {
        super(obj, view, 0);
        this.f30109a = relativeLayout;
        this.f30110b = textView;
        this.f30111c = view2;
    }
}
