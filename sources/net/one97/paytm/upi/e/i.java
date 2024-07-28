package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CircularImageView;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66824a;

    /* renamed from: b  reason: collision with root package name */
    public final LottieAnimationView f66825b;

    /* renamed from: c  reason: collision with root package name */
    public final CircularImageView f66826c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f66827d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f66828e;

    /* renamed from: f  reason: collision with root package name */
    public final RecyclerView f66829f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f66830g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f66831h;

    /* renamed from: i  reason: collision with root package name */
    private final LinearLayout f66832i;

    private i(LinearLayout linearLayout, ImageView imageView, LottieAnimationView lottieAnimationView, CircularImageView circularImageView, TextView textView, TextView textView2, RecyclerView recyclerView, TextView textView3, TextView textView4) {
        this.f66832i = linearLayout;
        this.f66824a = imageView;
        this.f66825b = lottieAnimationView;
        this.f66826c = circularImageView;
        this.f66827d = textView;
        this.f66828e = textView2;
        this.f66829f = recyclerView;
        this.f66830g = textView3;
        this.f66831h = textView4;
    }

    public static i a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.crossImage);
        if (imageView != null) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.loader);
            if (lottieAnimationView != null) {
                CircularImageView circularImageView = (CircularImageView) view.findViewById(R.id.payeeLogo);
                if (circularImageView != null) {
                    TextView textView = (TextView) view.findViewById(R.id.payeeName);
                    if (textView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.payeeVpa);
                        if (textView2 != null) {
                            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.timelineAdapter);
                            if (recyclerView != null) {
                                TextView textView3 = (TextView) view.findViewById(R.id.tv_initials);
                                if (textView3 != null) {
                                    TextView textView4 = (TextView) view.findViewById(R.id.tvScheduleMandate);
                                    if (textView4 != null) {
                                        return new i((LinearLayout) view, imageView, lottieAnimationView, circularImageView, textView, textView2, recyclerView, textView3, textView4);
                                    }
                                    str = "tvScheduleMandate";
                                } else {
                                    str = "tvInitials";
                                }
                            } else {
                                str = "timelineAdapter";
                            }
                        } else {
                            str = "payeeVpa";
                        }
                    } else {
                        str = "payeeName";
                    }
                } else {
                    str = "payeeLogo";
                }
            } else {
                str = "loader";
            }
        } else {
            str = "crossImage";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
