package net.one97.paytm.upi.e;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f66799a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f66800b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f66801c;

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f66802d;

    private e(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView, RecyclerView recyclerView2) {
        this.f66802d = linearLayout;
        this.f66799a = imageView;
        this.f66800b = recyclerView;
        this.f66801c = recyclerView2;
    }

    public static e a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.closeButton);
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.firstFortnightRecyclerView);
            if (recyclerView != null) {
                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.secondFortnightRecyclerView);
                if (recyclerView2 != null) {
                    return new e((LinearLayout) view, imageView, recyclerView, recyclerView2);
                }
                str = "secondFortnightRecyclerView";
            } else {
                str = "firstFortnightRecyclerView";
            }
        } else {
            str = "closeButton";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
