package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import net.one97.paytm.moneytransfer.R;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final AppBarLayout f53753a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f53754b;

    /* renamed from: c  reason: collision with root package name */
    public final CollapsingToolbarLayout f53755c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f53756d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f53757e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f53758f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f53759g;

    /* renamed from: h  reason: collision with root package name */
    public final RecyclerView f53760h;

    /* renamed from: i  reason: collision with root package name */
    public final h f53761i;
    public final CardView j;
    public final FrameLayout k;
    public final TextView l;
    private final CoordinatorLayout m;

    private i(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ImageView imageView, CollapsingToolbarLayout collapsingToolbarLayout, TextView textView, FrameLayout frameLayout, LinearLayout linearLayout, LinearLayout linearLayout2, RecyclerView recyclerView, h hVar, CardView cardView, FrameLayout frameLayout2, TextView textView2) {
        this.m = coordinatorLayout;
        this.f53753a = appBarLayout;
        this.f53754b = imageView;
        this.f53755c = collapsingToolbarLayout;
        this.f53756d = textView;
        this.f53757e = frameLayout;
        this.f53758f = linearLayout;
        this.f53759g = linearLayout2;
        this.f53760h = recyclerView;
        this.f53761i = hVar;
        this.j = cardView;
        this.k = frameLayout2;
        this.l = textView2;
    }

    public static i a(View view) {
        String str;
        AppBarLayout appBarLayout = (AppBarLayout) view.findViewById(R.id.appBar);
        if (appBarLayout != null) {
            ImageView imageView = (ImageView) view.findViewById(R.id.backButton);
            if (imageView != null) {
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
                if (collapsingToolbarLayout != null) {
                    TextView textView = (TextView) view.findViewById(R.id.editTextView);
                    if (textView != null) {
                        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.passbookContainer);
                        if (frameLayout != null) {
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.passbook_layout);
                            if (linearLayout != null) {
                                LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.search_layout);
                                if (linearLayout2 != null) {
                                    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.selfAccountList);
                                    if (recyclerView != null) {
                                        View findViewById = view.findViewById(R.id.self_shimmer_layout);
                                        if (findViewById != null) {
                                            h a2 = h.a(findViewById);
                                            CardView cardView = (CardView) view.findViewById(R.id.settingsBottomSheet);
                                            if (cardView != null) {
                                                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.settingsContainer);
                                                if (frameLayout2 != null) {
                                                    TextView textView2 = (TextView) view.findViewById(R.id.title);
                                                    if (textView2 != null) {
                                                        return new i((CoordinatorLayout) view, appBarLayout, imageView, collapsingToolbarLayout, textView, frameLayout, linearLayout, linearLayout2, recyclerView, a2, cardView, frameLayout2, textView2);
                                                    }
                                                    str = "title";
                                                } else {
                                                    str = "settingsContainer";
                                                }
                                            } else {
                                                str = "settingsBottomSheet";
                                            }
                                        } else {
                                            str = "selfShimmerLayout";
                                        }
                                    } else {
                                        str = "selfAccountList";
                                    }
                                } else {
                                    str = "searchLayout";
                                }
                            } else {
                                str = "passbookLayout";
                            }
                        } else {
                            str = "passbookContainer";
                        }
                    } else {
                        str = "editTextView";
                    }
                } else {
                    str = "collapsingToolbar";
                }
            } else {
                str = "backButton";
            }
        } else {
            str = "appBar";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
