package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.upi.R;

public final class k {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66842a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f66843b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f66844c;

    /* renamed from: d  reason: collision with root package name */
    public final LottieAnimationView f66845d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f66846e;

    /* renamed from: f  reason: collision with root package name */
    private final FrameLayout f66847f;

    private k(FrameLayout frameLayout, ImageView imageView, TextView textView, RecyclerView recyclerView, LottieAnimationView lottieAnimationView, TextView textView2) {
        this.f66847f = frameLayout;
        this.f66842a = imageView;
        this.f66843b = textView;
        this.f66844c = recyclerView;
        this.f66845d = lottieAnimationView;
        this.f66846e = textView2;
    }

    public static k a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.crossImage);
        if (imageView != null) {
            TextView textView = (TextView) view.findViewById(R.id.historyFor);
            if (textView != null) {
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.historyRecyclerView);
                if (recyclerView != null) {
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) view.findViewById(R.id.loader);
                    if (lottieAnimationView != null) {
                        TextView textView2 = (TextView) view.findViewById(R.id.title);
                        if (textView2 != null) {
                            return new k((FrameLayout) view, imageView, textView, recyclerView, lottieAnimationView, textView2);
                        }
                        str = "title";
                    } else {
                        str = "loader";
                    }
                } else {
                    str = "historyRecyclerView";
                }
            } else {
                str = "historyFor";
            }
        } else {
            str = "crossImage";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
