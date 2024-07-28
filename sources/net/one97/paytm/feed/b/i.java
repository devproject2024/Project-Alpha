package net.one97.paytm.feed.b;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.livetv.Channel;
import net.one97.paytm.feed.ui.feed.livetv.channel.a;

public abstract class i extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f34172a;

    /* renamed from: b  reason: collision with root package name */
    public final RoundedImageView f34173b;

    /* renamed from: c  reason: collision with root package name */
    public final RoundedImageView f34174c;

    /* renamed from: d  reason: collision with root package name */
    protected Channel f34175d;

    /* renamed from: e  reason: collision with root package name */
    protected a f34176e;

    protected i(Object obj, View view, ConstraintLayout constraintLayout, RoundedImageView roundedImageView, RoundedImageView roundedImageView2) {
        super(obj, view, 0);
        this.f34172a = constraintLayout;
        this.f34173b = roundedImageView;
        this.f34174c = roundedImageView2;
    }
}
