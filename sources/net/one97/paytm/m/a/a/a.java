package net.one97.paytm.m.a.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.transition.v;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.moneytransfer.R;

public final class a extends net.one97.paytm.upi.mandate.b.a {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f53125a;

    public final void b() {
        HashMap hashMap = this.f53125a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public final int a() {
        return R.layout.bottom_sheet_wallet_benefits;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        net.one97.paytm.moneytransfer.c.d a2 = net.one97.paytm.moneytransfer.c.d.a(view);
        k.a((Object) a2, "BottomSheetWalletBenefitsBinding.bind(view)");
        a2.t.setOnClickListener(new e(a2, this, a2));
        a2.u.setOnClickListener(new f(a2, this, a2));
        a2.f53727c.setOnClickListener(new g(this, a2));
        TextView textView = a2.k;
        k.a((Object) textView, "heading");
        String string = getString(R.string.wallet_benefits_heading);
        k.a((Object) string, "getString(R.string.wallet_benefits_heading)");
        CharSequence charSequence = string;
        SpannableString spannableString = new SpannableString(charSequence);
        int a3 = p.a(charSequence, "L ve", 0, false, 6);
        spannableString.setSpan(new ImageSpan(requireContext(), R.drawable.ic_wallet_benefit_heart, 1), a3 + 1, a3 + 2, 33);
        textView.setText(spannableString);
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53130a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f53131b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53132c;

        e(net.one97.paytm.moneytransfer.c.d dVar, a aVar, net.one97.paytm.moneytransfer.c.d dVar2) {
            this.f53130a = dVar;
            this.f53131b = aVar;
            this.f53132c = dVar2;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransfer.c.d dVar = this.f53132c;
            TextView textView = this.f53130a.f53725a;
            k.a((Object) textView, "answer1");
            a.a(dVar, !net.one97.paytm.upi.f.d(textView));
        }
    }

    static final class f implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53133a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ a f53134b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53135c;

        f(net.one97.paytm.moneytransfer.c.d dVar, a aVar, net.one97.paytm.moneytransfer.c.d dVar2) {
            this.f53133a = dVar;
            this.f53134b = aVar;
            this.f53135c = dVar2;
        }

        public final void onClick(View view) {
            net.one97.paytm.moneytransfer.c.d dVar = this.f53135c;
            TextView textView = this.f53133a.f53726b;
            k.a((Object) textView, "answer2");
            a.b(dVar, !net.one97.paytm.upi.f.d(textView));
        }
    }

    static final class g implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f53136a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53137b;

        g(a aVar, net.one97.paytm.moneytransfer.c.d dVar) {
            this.f53136a = aVar;
            this.f53137b = dVar;
        }

        public final void onClick(View view) {
            this.f53136a.dismiss();
        }
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53128a;

        c(net.one97.paytm.moneytransfer.c.d dVar) {
            this.f53128a = dVar;
        }

        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ImageView imageView = this.f53128a.f53731g;
            k.a((Object) imageView, "binding.downArrow2");
            imageView.setClickable(false);
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ImageView imageView = this.f53128a.f53731g;
            k.a((Object) imageView, "binding.downArrow2");
            imageView.setClickable(true);
        }
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53129a;

        d(net.one97.paytm.moneytransfer.c.d dVar) {
            this.f53129a = dVar;
        }

        public final void run() {
            this.f53129a.y.a(130);
        }
    }

    /* renamed from: net.one97.paytm.m.a.a.a$a  reason: collision with other inner class name */
    public static final class C0948a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53126a;

        C0948a(net.one97.paytm.moneytransfer.c.d dVar) {
            this.f53126a = dVar;
        }

        public final void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ImageView imageView = this.f53126a.f53730f;
            k.a((Object) imageView, "binding.downArrow1");
            imageView.setClickable(false);
        }

        public final void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ImageView imageView = this.f53126a.f53730f;
            k.a((Object) imageView, "binding.downArrow1");
            imageView.setClickable(true);
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.moneytransfer.c.d f53127a;

        b(net.one97.paytm.moneytransfer.c.d dVar) {
            this.f53127a = dVar;
        }

        public final void run() {
            this.f53127a.y.a(130);
        }
    }

    public static final /* synthetic */ void a(net.one97.paytm.moneytransfer.c.d dVar, boolean z) {
        dVar.f53730f.animate().rotationBy(180.0f).setListener(new C0948a(dVar)).start();
        if (z) {
            v.a((ViewGroup) dVar.x);
            TextView textView = dVar.f53725a;
            k.a((Object) textView, "binding.answer1");
            net.one97.paytm.upi.f.b((View) textView);
            dVar.y.postDelayed(new b(dVar), 310);
            return;
        }
        v.a((ViewGroup) dVar.x);
        TextView textView2 = dVar.f53725a;
        k.a((Object) textView2, "binding.answer1");
        net.one97.paytm.upi.f.a((View) textView2);
    }

    public static final /* synthetic */ void b(net.one97.paytm.moneytransfer.c.d dVar, boolean z) {
        dVar.f53731g.animate().rotationBy(180.0f).setListener(new c(dVar)).start();
        if (z) {
            v.a((ViewGroup) dVar.x);
            TextView textView = dVar.f53726b;
            k.a((Object) textView, "binding.answer2");
            net.one97.paytm.upi.f.b((View) textView);
            dVar.y.postDelayed(new d(dVar), 310);
            return;
        }
        v.a((ViewGroup) dVar.x);
        TextView textView2 = dVar.f53726b;
        k.a((Object) textView2, "binding.answer2");
        net.one97.paytm.upi.f.a((View) textView2);
    }
}
