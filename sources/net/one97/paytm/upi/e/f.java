package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66803a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f66804b;

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f66805c;

    private f(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView) {
        this.f66805c = linearLayout;
        this.f66803a = imageView;
        this.f66804b = recyclerView;
    }

    public static f a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.closeButton);
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.paymentDayRecyclerView);
            if (recyclerView != null) {
                return new f((LinearLayout) view, imageView, recyclerView);
            }
            str = "paymentDayRecyclerView";
        } else {
            str = "closeButton";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
