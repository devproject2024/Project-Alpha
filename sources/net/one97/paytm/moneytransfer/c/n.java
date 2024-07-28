package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.moneytransfer.R;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f53793a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f53794b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f53795c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f53796d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f53797e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f53798f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f53799g;

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f53800h;

    /* renamed from: i  reason: collision with root package name */
    private final CoordinatorLayout f53801i;

    private n(CoordinatorLayout coordinatorLayout, ImageView imageView, RecyclerView recyclerView, RecyclerView recyclerView2, ImageView imageView2, TextView textView, ImageView imageView3, TextView textView2, FrameLayout frameLayout) {
        this.f53801i = coordinatorLayout;
        this.f53793a = imageView;
        this.f53794b = recyclerView;
        this.f53795c = recyclerView2;
        this.f53796d = imageView2;
        this.f53797e = textView;
        this.f53798f = imageView3;
        this.f53799g = textView2;
        this.f53800h = frameLayout;
    }

    public static n a(View view) {
        String str;
        ImageView imageView = (ImageView) view.findViewById(R.id.backArrow);
        if (imageView != null) {
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.collectRecyclerView);
            if (recyclerView != null) {
                RecyclerView recyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView);
                if (recyclerView2 != null) {
                    ImageView imageView2 = (ImageView) view.findViewById(R.id.scanner);
                    if (imageView2 != null) {
                        TextView textView = (TextView) view.findViewById(R.id.searchView);
                        if (textView != null) {
                            ImageView imageView3 = (ImageView) view.findViewById(R.id.settingsIcon);
                            if (imageView3 != null) {
                                TextView textView2 = (TextView) view.findViewById(R.id.title);
                                if (textView2 != null) {
                                    FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.toolbarLayout);
                                    if (frameLayout != null) {
                                        return new n((CoordinatorLayout) view, imageView, recyclerView, recyclerView2, imageView2, textView, imageView3, textView2, frameLayout);
                                    }
                                    str = "toolbarLayout";
                                } else {
                                    str = "title";
                                }
                            } else {
                                str = "settingsIcon";
                            }
                        } else {
                            str = "searchView";
                        }
                    } else {
                        str = "scanner";
                    }
                } else {
                    str = "recyclerView";
                }
            } else {
                str = "collectRecyclerView";
            }
        } else {
            str = "backArrow";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
