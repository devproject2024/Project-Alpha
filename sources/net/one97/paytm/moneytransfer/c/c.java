package net.one97.paytm.moneytransfer.c;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.cardview.widget.CardView;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.upi.e.d;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final FrameLayout f53717a;

    /* renamed from: b  reason: collision with root package name */
    public final View f53718b;

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f53719c;

    /* renamed from: d  reason: collision with root package name */
    public final CardView f53720d;

    /* renamed from: e  reason: collision with root package name */
    public final d f53721e;

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f53722f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f53723g;

    private c(LinearLayout linearLayout, FrameLayout frameLayout, View view, FrameLayout frameLayout2, CardView cardView, d dVar, FrameLayout frameLayout3) {
        this.f53723g = linearLayout;
        this.f53717a = frameLayout;
        this.f53718b = view;
        this.f53719c = frameLayout2;
        this.f53720d = cardView;
        this.f53721e = dVar;
        this.f53722f = frameLayout3;
    }

    public static c a(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.createNewPinContainer);
        String str = "relBottom";
        if (frameLayout != null) {
            View findViewById = view.findViewById(R.id.divider1);
            if (findViewById != null) {
                FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R.id.primaryAccountContainer);
                if (frameLayout2 != null) {
                    CardView cardView = (CardView) view.findViewById(R.id.pullUpBarView);
                    if (cardView != null) {
                        View findViewById2 = view.findViewById(R.id.rel_bottom);
                        if (findViewById2 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) findViewById2.findViewById(net.one97.paytm.upi.R.id.rel_bottom);
                            if (relativeLayout != null) {
                                RelativeLayout relativeLayout2 = (RelativeLayout) findViewById2.findViewById(net.one97.paytm.upi.R.id.rel_light_blue);
                                if (relativeLayout2 != null) {
                                    d dVar = new d((RelativeLayout) findViewById2, relativeLayout, relativeLayout2);
                                    FrameLayout frameLayout3 = (FrameLayout) view.findViewById(R.id.removeBankContainer);
                                    if (frameLayout3 != null) {
                                        return new c((LinearLayout) view, frameLayout, findViewById, frameLayout2, cardView, dVar, frameLayout3);
                                    }
                                    str = "removeBankContainer";
                                } else {
                                    str = "relLightBlue";
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(str));
                        }
                    } else {
                        str = "pullUpBarView";
                    }
                } else {
                    str = "primaryAccountContainer";
                }
            } else {
                str = "divider1";
            }
        } else {
            str = "createNewPinContainer";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }
}
