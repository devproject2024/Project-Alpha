package com.travel.citybus.best.ui.a;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.LottieAnimationView;
import com.travel.citybus.R;
import com.travel.citybus.best.b.c;
import com.travel.citybus.best.model.BestEPurse;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.g;

public final class c extends g implements c.a {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BestEPurse f23089a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f23090b = Boolean.TRUE;

    /* renamed from: c  reason: collision with root package name */
    private com.travel.citybus.best.c.c f23091c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f23092d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f23093e;

    public interface a {
        void a();

        void b();
    }

    public final View a(int i2) {
        if (this.f23093e == null) {
            this.f23093e = new HashMap();
        }
        View view = (View) this.f23093e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23093e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void a(BestEPurse bestEPurse) {
    }

    public final void b(String str) {
    }

    public static final /* synthetic */ com.travel.citybus.best.c.c b(c cVar) {
        com.travel.citybus.best.c.c cVar2 = cVar.f23091c;
        if (cVar2 == null) {
            k.a("cityBusTokenPresenter");
        }
        return cVar2;
    }

    public final int getTheme() {
        return R.style.DialogTheme;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        Boolean bool = null;
        this.f23089a = (BestEPurse) (arguments != null ? arguments.getSerializable("extra_e_purse") : null);
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            bool = Boolean.valueOf(arguments2.getBoolean("from_validation_screen"));
        }
        this.f23090b = bool;
        this.f23091c = new com.travel.citybus.best.c.c(this);
    }

    public final void onAttach(Activity activity) {
        k.c(activity, "activity");
        super.onAttach(activity);
        if (activity instanceof a) {
            this.f23092d = (a) activity;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.best_token_dialog, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) a(R.id.tv_only_one);
        k.a((Object) textView, "tv_only_one");
        textView.setText("You can only book 1 token at a time");
        TextView textView2 = (TextView) a(R.id.tv_info);
        k.a((Object) textView2, "tv_info");
        textView2.setText("You already have an active token.  Please cancel your token to proceed with another booking.");
        ((Button) a(R.id.btn_go_back)).setOnClickListener(new b(this));
        ((TextView) a(R.id.btn_ok)).setOnClickListener(new C0449c(this));
        ((Button) a(R.id.btn_cancel_token)).setOnClickListener(new d(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23094a;

        b(c cVar) {
            this.f23094a = cVar;
        }

        public final void onClick(View view) {
            this.f23094a.dismiss();
        }
    }

    /* renamed from: com.travel.citybus.best.ui.a.c$c  reason: collision with other inner class name */
    static final class C0449c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23095a;

        C0449c(c cVar) {
            this.f23095a = cVar;
        }

        public final void onClick(View view) {
            a a2 = this.f23095a.f23092d;
            if (a2 != null) {
                a2.b();
            }
            this.f23095a.dismiss();
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f23096a;

        d(c cVar) {
            this.f23096a = cVar;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0033, code lost:
            r0 = r0.getToken();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r9) {
            /*
                r8 = this;
                com.travel.citybus.best.ui.a.c r9 = r8.f23096a
                int r0 = com.travel.citybus.R.id.llCancelBtnContainer
                android.view.View r9 = r9.a((int) r0)
                android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
                java.lang.String r0 = "llCancelBtnContainer"
                kotlin.g.b.k.a((java.lang.Object) r9, (java.lang.String) r0)
                r0 = 8
                r9.setVisibility(r0)
                com.travel.citybus.best.ui.a.c r9 = r8.f23096a
                r0 = 1
                r9.a((boolean) r0)
                com.travel.citybus.best.ui.a.c r9 = r8.f23096a
                com.travel.citybus.best.c.c r9 = com.travel.citybus.best.ui.a.c.b((com.travel.citybus.best.ui.a.c) r9)
                if (r9 == 0) goto L_0x00b1
                com.travel.citybus.best.ui.a.c r0 = r8.f23096a
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                r1 = r0
                android.content.Context r1 = (android.content.Context) r1
                com.travel.citybus.best.ui.a.c r0 = r8.f23096a
                com.travel.citybus.best.model.BestEPurse r0 = r0.f23089a
                if (r0 == 0) goto L_0x003e
                com.travel.citybus.best.model.BestToken r0 = r0.getToken()
                if (r0 == 0) goto L_0x003e
                java.lang.String r0 = r0.getTokenId()
                goto L_0x003f
            L_0x003e:
                r0 = 0
            L_0x003f:
                com.travel.citybus.brts.f r2 = com.travel.citybus.brts.f.d()
                java.lang.String r3 = "TransportBrtsController.getInstance()"
                kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
                com.travel.citybus.a r2 = com.travel.citybus.brts.f.e()
                java.lang.String r3 = "cityBusTokenUrl"
                java.lang.String r2 = r2.a((java.lang.String) r3)
                r3 = r2
                java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                boolean r3 = android.text.TextUtils.isEmpty(r3)
                if (r3 == 0) goto L_0x005d
                java.lang.String r2 = com.travel.citybus.brts.a.m
            L_0x005d:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r2 = 47
                r3.append(r2)
                r3.append(r0)
                java.lang.String r2 = r3.toString()
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                r4 = r0
                java.util.Map r4 = (java.util.Map) r4
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/json"
                r4.put(r0, r3)
                org.json.JSONObject r0 = new org.json.JSONObject
                r0.<init>()
                java.lang.String r3 = com.paytm.utility.b.n((android.content.Context) r1)
                java.lang.String r5 = "user_id"
                r0.put(r5, r3)
                com.travel.citybus.best.a.b r3 = com.travel.citybus.best.a.b.INVALID
                java.lang.String r3 = r3.name()
                java.lang.String r5 = "status"
                r0.put(r5, r3)
                com.travel.citybus.brts.b.a.a()
                r3 = 0
                java.lang.String r5 = r0.toString()
                com.travel.citybus.best.model.BestEPurseTokenResponse r0 = new com.travel.citybus.best.model.BestEPurseTokenResponse
                r0.<init>()
                r6 = r0
                com.paytm.network.model.IJRPaytmDataModel r6 = (com.paytm.network.model.IJRPaytmDataModel) r6
                r7 = r9
                com.paytm.network.listener.b r7 = (com.paytm.network.listener.b) r7
                com.travel.citybus.brts.b.a.a(r1, r2, r3, r4, r5, r6, r7)
            L_0x00b1:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.citybus.best.ui.a.c.d.onClick(android.view.View):void");
        }
    }

    public final void onDetach() {
        this.f23092d = null;
        super.onDetach();
    }

    public final void a(boolean z) {
        LottieAnimationView lottieAnimationView = (LottieAnimationView) a(R.id.lottie_in_token_dialog);
        k.a((Object) lottieAnimationView, "lottie_in_token_dialog");
        lottieAnimationView.setVisibility(z ? 0 : 8);
    }

    public final void S_() {
        ((AppCompatImageView) a(R.id.iv_token)).setImageResource(R.drawable.best_illustration_token_cancelled);
        TextView textView = (TextView) a(R.id.tv_info);
        k.a((Object) textView, "tv_info");
        textView.setVisibility(8);
        TextView textView2 = (TextView) a(R.id.tv_only_one);
        k.a((Object) textView2, "tv_only_one");
        textView2.setText("Your Token Has Been Cancelled!");
        a(false);
        TextView textView3 = (TextView) a(R.id.btn_ok);
        k.a((Object) textView3, "btn_ok");
        textView3.setVisibility(0);
        a aVar = this.f23092d;
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void c() {
        a(false);
        LinearLayout linearLayout = (LinearLayout) a(R.id.llCancelBtnContainer);
        k.a((Object) linearLayout, "llCancelBtnContainer");
        linearLayout.setVisibility(0);
        Toast.makeText(getContext(), getString(R.string.some_went_wrong), 0).show();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23093e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
