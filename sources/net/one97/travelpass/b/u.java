package net.one97.travelpass.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;

public abstract class u extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f30289a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f30290b;

    /* renamed from: c  reason: collision with root package name */
    public final RoboTextView f30291c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f30292d;

    protected u(Object obj, View view, ImageView imageView, FrameLayout frameLayout, RoboTextView roboTextView, Toolbar toolbar) {
        super(obj, view, 0);
        this.f30289a = imageView;
        this.f30290b = frameLayout;
        this.f30291c = roboTextView;
        this.f30292d = toolbar;
    }
}
