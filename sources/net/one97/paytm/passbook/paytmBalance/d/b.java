package net.one97.paytm.passbook.paytmBalance.d;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import java.util.Arrays;
import java.util.Locale;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.paytmBalance.activity.PaytmBalanceActivity;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    final net.one97.paytm.passbook.paytmBalance.fragment.a f58215a;

    public b(net.one97.paytm.passbook.paytmBalance.fragment.a aVar) {
        k.c(aVar, "mPaytmBalanceTransactionsFragment");
        this.f58215a = aVar;
    }

    private static void a(LottieAnimationView lottieAnimationView, boolean z) {
        if (z) {
            lottieAnimationView.setVisibility(0);
            net.one97.paytm.passbook.utility.a.a(lottieAnimationView);
            return;
        }
        lottieAnimationView.setVisibility(8);
        net.one97.paytm.passbook.utility.a.b(lottieAnimationView);
    }

    public final void a(boolean z) {
        if (this.f58215a.f58230c == 0) {
            LottieAnimationView lottieAnimationView = (LottieAnimationView) this.f58215a.a(R.id.loaderCenter);
            k.a((Object) lottieAnimationView, "mPaytmBalanceTransactionsFragment.loaderCenter");
            a(lottieAnimationView, z);
            return;
        }
        LottieAnimationView lottieAnimationView2 = (LottieAnimationView) this.f58215a.a(R.id.loaderBottom);
        k.a((Object) lottieAnimationView2, "mPaytmBalanceTransactionsFragment.loaderBottom");
        a(lottieAnimationView2, z);
    }

    public final void a() {
        if (this.f58215a.getActivity() instanceof PaytmBalanceActivity) {
            x.e eVar = new x.e();
            FragmentActivity activity = this.f58215a.getActivity();
            if (activity != null) {
                eVar.element = (LinearLayout) ((PaytmBalanceActivity) activity).a(R.id.tagSavedLl);
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f58215a.getContext(), R.anim.pass_text_scroll_top_to_bottom);
                LinearLayout linearLayout = (LinearLayout) eVar.element;
                k.a((Object) linearLayout, "view");
                linearLayout.setVisibility(0);
                ((LinearLayout) eVar.element).startAnimation(loadAnimation);
                new Handler().postDelayed(new a(this, eVar), 3000);
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.paytmBalance.activity.PaytmBalanceActivity");
        }
    }

    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f58216a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f58217b;

        a(b bVar, x.e eVar) {
            this.f58216a = bVar;
            this.f58217b = eVar;
        }

        public final void run() {
            LinearLayout linearLayout = (LinearLayout) this.f58217b.element;
            k.a((Object) linearLayout, "view");
            if (linearLayout.getVisibility() == 0 && this.f58216a.f58215a.isAdded()) {
                Animation loadAnimation = AnimationUtils.loadAnimation(this.f58216a.f58215a.getContext(), R.anim.pass_save_tag_banner_up);
                ((LinearLayout) this.f58217b.element).startAnimation(loadAnimation);
                loadAnimation.setAnimationListener(new C1121a(this));
            }
        }

        /* renamed from: net.one97.paytm.passbook.paytmBalance.d.b$a$a  reason: collision with other inner class name */
        public static final class C1121a implements Animation.AnimationListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f58218a;

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }

            C1121a(a aVar) {
                this.f58218a = aVar;
            }

            public final void onAnimationEnd(Animation animation) {
                LinearLayout linearLayout = (LinearLayout) this.f58218a.f58217b.element;
                k.a((Object) linearLayout, "view");
                linearLayout.setVisibility(8);
            }
        }
    }

    public final String a(int i2) {
        String[] stringArray = this.f58215a.getResources().getStringArray(R.array.passbook_tabs);
        k.a((Object) stringArray, "mPaytmBalanceTransaction…ay(R.array.passbook_tabs)");
        Object obj = kotlin.a.k.d((String[]) Arrays.copyOf(stringArray, stringArray.length)).get(i2);
        k.a(obj, "list[filterSelectedPosition]");
        String a2 = p.a((String) obj, " ", "_", false);
        Locale locale = Locale.ROOT;
        k.a((Object) locale, "Locale.ROOT");
        if (a2 != null) {
            String upperCase = a2.toUpperCase(locale);
            k.a((Object) upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }
}
