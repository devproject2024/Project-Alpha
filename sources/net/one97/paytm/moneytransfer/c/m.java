package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.common.ShimmerFrameLayout;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53785a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f53786b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f53787c;

    /* renamed from: d  reason: collision with root package name */
    public final g f53788d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f53789e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f53790f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53791g;

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f53792h;

    private m(ConstraintLayout constraintLayout, ImageView imageView, RecyclerView recyclerView, Button button, g gVar, ImageView imageView2, TextView textView, TextView textView2) {
        this.f53792h = constraintLayout;
        this.f53785a = imageView;
        this.f53786b = recyclerView;
        this.f53787c = button;
        this.f53788d = gVar;
        this.f53789e = imageView2;
        this.f53790f = textView;
        this.f53791g = textView2;
    }

    public static m a(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.backButton);
        String str = "selfShimmerLayout";
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.selfAccountList);
            if (recyclerView != null) {
                Button button = (Button) view.findViewById(R.id.selfAccountProceed);
                if (button != null) {
                    View findViewById = view.findViewById(R.id.self_shimmer_layout);
                    if (findViewById != null) {
                        View findViewById2 = findViewById.findViewById(R.id.header_view);
                        if (findViewById2 != null) {
                            View findViewById3 = findViewById.findViewById(R.id.item_1);
                            if (findViewById3 != null) {
                                f a2 = f.a(findViewById3);
                                View findViewById4 = findViewById.findViewById(R.id.item_2);
                                if (findViewById4 != null) {
                                    f a3 = f.a(findViewById4);
                                    ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) findViewById.findViewById(R.id.self_shimmer_layout);
                                    if (shimmerFrameLayout != null) {
                                        g gVar = new g((ShimmerFrameLayout) findViewById, findViewById2, a2, a3, shimmerFrameLayout);
                                        ImageView imageView2 = (ImageView) view.findViewById(R.id.settingsIcon);
                                        if (imageView2 != null) {
                                            TextView textView = (TextView) view.findViewById(R.id.subHeading);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) view.findViewById(R.id.title);
                                                if (textView2 != null) {
                                                    return new m((ConstraintLayout) view, imageView, recyclerView, button, gVar, imageView2, textView, textView2);
                                                }
                                                str = "title";
                                            } else {
                                                str = "subHeading";
                                            }
                                        } else {
                                            str = "settingsIcon";
                                        }
                                    }
                                } else {
                                    str = "item2";
                                }
                            } else {
                                str = "item1";
                            }
                        } else {
                            str = "headerView";
                        }
                        throw new NullPointerException("Missing required view with ID: ".concat(str));
                    }
                } else {
                    str = "selfAccountProceed";
                }
            } else {
                str = "selfAccountList";
            }
        } else {
            str = "backButton";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
