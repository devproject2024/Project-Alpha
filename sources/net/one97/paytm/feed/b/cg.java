package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.stories.Stories;
import net.one97.paytm.feed.ui.feed.story.e;
import net.one97.paytm.feed.utility.CircleImageView;

public abstract class cg extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final CircleImageView f34043a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f34044b;

    /* renamed from: c  reason: collision with root package name */
    public final RoundedImageView f34045c;

    /* renamed from: d  reason: collision with root package name */
    protected Integer f34046d;

    /* renamed from: e  reason: collision with root package name */
    protected Integer f34047e;

    /* renamed from: f  reason: collision with root package name */
    protected Stories f34048f;

    /* renamed from: g  reason: collision with root package name */
    protected e f34049g;

    protected cg(Object obj, View view, CircleImageView circleImageView, TextView textView, RoundedImageView roundedImageView) {
        super(obj, view, 0);
        this.f34043a = circleImageView;
        this.f34044b = textView;
        this.f34045c = roundedImageView;
    }
}
