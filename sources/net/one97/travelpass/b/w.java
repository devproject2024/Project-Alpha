package net.one97.travelpass.b;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import com.paytm.utility.RoboTextView;

public abstract class w extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f30297a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f30298b;

    /* renamed from: c  reason: collision with root package name */
    public final RoboTextView f30299c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f30300d;

    protected w(Object obj, View view, ImageView imageView, FrameLayout frameLayout, RoboTextView roboTextView, Toolbar toolbar) {
        super(obj, view, 0);
        this.f30297a = imageView;
        this.f30298b = frameLayout;
        this.f30299c = roboTextView;
        this.f30300d = toolbar;
    }
}
