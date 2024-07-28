package net.one97.paytm.paymentsBank.c;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;

public abstract class c extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final RoboTextView f17478a;

    /* renamed from: b  reason: collision with root package name */
    public final RoboTextView f17479b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f17480c;

    protected c(Object obj, View view, RoboTextView roboTextView, RoboTextView roboTextView2, TextView textView) {
        super(obj, view, 0);
        this.f17478a = roboTextView;
        this.f17479b = roboTextView2;
        this.f17480c = textView;
    }
}
