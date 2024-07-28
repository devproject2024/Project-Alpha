package net.one97.paytm.feed.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.makeramen.roundedimageview.RoundedImageView;
import net.one97.paytm.feed.repository.models.comment.CommentResponse;
import net.one97.paytm.feed.ui.feed.actions.comment.b;
import net.one97.paytm.feed.ui.feed.actions.comment.i;
import net.one97.paytm.feed.utility.RoundCornersImageView;

public abstract class m extends ViewDataBinding {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f34191a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f34192b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f34193c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f34194d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f34195e;

    /* renamed from: f  reason: collision with root package name */
    public final RoundedImageView f34196f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f34197g;

    /* renamed from: h  reason: collision with root package name */
    public final RoundCornersImageView f34198h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f34199i;
    public final TextView j;
    protected Integer k;
    protected CommentResponse l;
    protected b m;
    protected i n;

    protected m(Object obj, View view, ImageView imageView, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, RoundedImageView roundedImageView, TextView textView3, RoundCornersImageView roundCornersImageView, TextView textView4, TextView textView5) {
        super(obj, view, 1);
        this.f34191a = imageView;
        this.f34192b = imageView2;
        this.f34193c = textView;
        this.f34194d = imageView3;
        this.f34195e = textView2;
        this.f34196f = roundedImageView;
        this.f34197g = textView3;
        this.f34198h = roundCornersImageView;
        this.f34199i = textView4;
        this.j = textView5;
    }
}
