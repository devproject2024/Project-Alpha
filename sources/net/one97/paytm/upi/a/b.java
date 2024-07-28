package net.one97.paytm.upi.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.HashMap;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.a.c;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;

public final class b extends net.one97.paytm.i.f {

    /* renamed from: a  reason: collision with root package name */
    public static final a f66500a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private c f66501b;

    /* renamed from: c  reason: collision with root package name */
    private d f66502c;

    /* renamed from: d  reason: collision with root package name */
    private LottieAnimationView f66503d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f66504e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f66505f;

    public static final void a(j jVar) {
        a.a(jVar);
    }

    /* renamed from: net.one97.paytm.upi.a.b$b  reason: collision with other inner class name */
    static final class C1339b extends l implements m<String, String, x> {
        final /* synthetic */ View $view$inlined;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1339b(b bVar, View view) {
            super(2);
            this.this$0 = bVar;
            this.$view$inlined = view;
        }

        public final /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            invoke((String) obj, (String) obj2);
            return x.f47997a;
        }

        public final void invoke(String str, String str2) {
            k.c(str, "deeplink");
            k.c(str2, "label");
            net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
            k.a((Object) a2, "PaytmUpiSdk.getInstance()");
            a2.c().a((Activity) this.this$0.getActivity(), str);
            CJRSendGTMTag.sendCustomGTMEvents(this.this$0.getActivity(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "success_action_clicked", str2, "", "", "");
            this.this$0.dismiss();
        }
    }

    static final class c<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f66506a;

        c(View view) {
            this.f66506a = view;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            View findViewById = this.f66506a.findViewById(R.id.offerText);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.offerText)");
            ((TextView) findViewById).setText((String) obj);
        }
    }

    static final class d<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f66507a;

        d(View view) {
            this.f66507a = view;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            View findViewById = this.f66507a.findViewById(R.id.heading);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.heading)");
            ((TextView) findViewById).setText((String) obj);
        }
    }

    static final class e<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f66508a;

        e(View view) {
            this.f66508a = view;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            View findViewById = this.f66508a.findViewById(R.id.subHeading);
            k.a((Object) findViewById, "view.findViewById<TextView>(R.id.subHeading)");
            ((TextView) findViewById).setText((String) obj);
        }
    }

    static final class f<T> implements z<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66509a;

        f(b bVar) {
            this.f66509a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            String str = (String) obj;
            TextView a2 = b.a(this.f66509a);
            a2.setText(str);
            a2.setOnClickListener(new a(a2, this, str));
        }

        static final class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TextView f66510a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ f f66511b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f66512c;

            a(TextView textView, f fVar, String str) {
                this.f66510a = textView;
                this.f66511b = fVar;
                this.f66512c = str;
            }

            public final void onClick(View view) {
                net.one97.paytm.upi.i a2 = net.one97.paytm.upi.i.a();
                k.a((Object) a2, "PaytmUpiSdk.getInstance()");
                a2.c().f(this.f66510a.getContext());
                this.f66511b.f66509a.dismiss();
            }
        }
    }

    static final class g<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66513a;

        g(b bVar) {
            this.f66513a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            Boolean bool = (Boolean) obj;
            if (bool == null) {
                k.a();
            }
            if (bool.booleanValue()) {
                b.a(this.f66513a).setVisibility(8);
                AnimationFactory.startWalletLoader(b.b(this.f66513a));
                return;
            }
            AnimationFactory.stopWalletLoader(b.b(this.f66513a));
            b.a(this.f66513a).setVisibility(0);
        }
    }

    static final class h<T> implements z<List<? extends c.a>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66514a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f66515b;

        h(b bVar, View view) {
            this.f66514a = bVar;
            this.f66515b = view;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            b.a(this.f66514a, this.f66515b, (List) obj);
        }
    }

    static final class i<T> implements z<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f66516a;

        i(b bVar) {
            this.f66516a = bVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            if (k.a((Object) (Boolean) obj, (Object) Boolean.TRUE)) {
                this.f66516a.dismiss();
            }
        }
    }

    public static final /* synthetic */ TextView a(b bVar) {
        TextView textView = bVar.f66504e;
        if (textView == null) {
            k.a("exploreMoreServiceTextView");
        }
        return textView;
    }

    public static final /* synthetic */ LottieAnimationView b(b bVar) {
        LottieAnimationView lottieAnimationView = bVar.f66503d;
        if (lottieAnimationView == null) {
            k.a("lottieProgress");
        }
        return lottieAnimationView;
    }

    public final void setupDialog(Dialog dialog, int i2) {
        k.c(dialog, "dialog");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.fragment_bank_account_added, (ViewGroup) null);
        dialog.setContentView(inflate);
        k.a((Object) inflate, "view");
        ViewParent parent = inflate.getParent();
        if (parent != null) {
            View view = (View) parent;
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            view.setBackgroundColor(androidx.core.content.b.c(context, 17170445));
            View findViewById = inflate.findViewById(R.id.loading_threedots_lav);
            k.a((Object) findViewById, "view.findViewById(R.id.loading_threedots_lav)");
            this.f66503d = (LottieAnimationView) findViewById;
            View findViewById2 = inflate.findViewById(R.id.exploreMoreServiceTextView);
            k.a((Object) findViewById2, "view.findViewById(R.id.exploreMoreServiceTextView)");
            this.f66504e = (TextView) findViewById2;
            if (getContext() == null) {
                k.a();
            }
            net.one97.paytm.upi.registration.b.a.b a2 = net.one97.paytm.upi.g.a((net.one97.paytm.upi.h.a) null);
            k.a((Object) a2, "Injection.provideUpiRegi…pository(context!!, null)");
            this.f66502c = new d(a2);
            Fragment fragment = this;
            d dVar = this.f66502c;
            if (dVar == null) {
                k.a("viewModelFactory");
            }
            ai a3 = am.a(fragment, (al.b) dVar).a(c.class);
            k.a((Object) a3, "ViewModelProviders.of(th…dedViewModel::class.java)");
            this.f66501b = (c) a3;
            c cVar = this.f66501b;
            if (cVar == null) {
                k.a("viewModel");
            }
            cVar.f66522f.setValue(Boolean.TRUE);
            cVar.f66525i.a((c.b) new c.C1340c(cVar));
            c cVar2 = this.f66501b;
            if (cVar2 == null) {
                k.a("viewModel");
            }
            q qVar = this;
            cVar2.f66519c.observe(qVar, new c(inflate));
            c cVar3 = this.f66501b;
            if (cVar3 == null) {
                k.a("viewModel");
            }
            cVar3.f66517a.observe(qVar, new d(inflate));
            c cVar4 = this.f66501b;
            if (cVar4 == null) {
                k.a("viewModel");
            }
            cVar4.f66518b.observe(qVar, new e(inflate));
            c cVar5 = this.f66501b;
            if (cVar5 == null) {
                k.a("viewModel");
            }
            cVar5.f66521e.observe(qVar, new f(this));
            c cVar6 = this.f66501b;
            if (cVar6 == null) {
                k.a("viewModel");
            }
            cVar6.f66523g.observe(qVar, new g(this));
            c cVar7 = this.f66501b;
            if (cVar7 == null) {
                k.a("viewModel");
            }
            cVar7.f66520d.observe(qVar, new h(this, inflate));
            c cVar8 = this.f66501b;
            if (cVar8 == null) {
                k.a("viewModel");
            }
            cVar8.f66524h.observe(qVar, new i(this));
            CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "", "", "", "/upi_onb_congrats", "wallet");
            return;
        }
        throw new u("null cannot be cast to non-null type android.view.View");
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void a(j jVar) {
            k.c(jVar, "fragmentManager");
            new b().show(jVar, b.class.getSimpleName());
        }
    }

    public static final /* synthetic */ void a(b bVar, View view, List list) {
        CJRSendGTMTag.sendCustomGTMEvents(bVar.getActivity(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "upi_success_screen_load", "", "", "", "");
        if (list != null) {
            a aVar = new a(list, new C1339b(bVar, view));
            View findViewById = view.findViewById(R.id.optionsRecyclerView);
            k.a((Object) findViewById, "view.findViewById<Recycl…R.id.optionsRecyclerView)");
            ((RecyclerView) findViewById).setAdapter(aVar);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66505f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
