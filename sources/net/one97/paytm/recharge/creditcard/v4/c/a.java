package net.one97.paytm.recharge.creditcard.v4.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.Locale;
import kotlin.g.b.k;
import net.one97.paytm.common.views.ShimmerFrameLayout;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.creditcard.v4.activity.AJRNewCardActivityV4;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class a extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final C1209a f62577a = new C1209a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private d f62578b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f62579c;

    private View a(int i2) {
        if (this.f62579c == null) {
            this.f62579c = new HashMap();
        }
        View view = (View) this.f62579c.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f62579c.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.recharge.creditcard.v4.c.a$a  reason: collision with other inner class name */
    public static final class C1209a {
        private C1209a() {
        }

        public /* synthetic */ C1209a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v4_fragment_credit_card_landing_new_user, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        Bundle arguments;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            ai a2 = new al(activity).a(net.one97.paytm.recharge.creditcard.c.a.class);
            k.a((Object) a2, "ViewModelProvider(it).ge…dViewModelV2::class.java)");
            this.f62578b = ((net.one97.paytm.recharge.creditcard.c.a) a2).v;
        }
        try {
            net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
            Locale locale = Locale.ENGLISH;
            k.a((Object) locale, "Locale.ENGLISH");
            String lowerCase = "/onus_credit_card/new_user".toLowerCase(locale);
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            net.one97.paytm.recharge.di.helper.b.a((Context) getActivity(), lowerCase);
            d dVar = this.f62578b;
            if (dVar != null) {
                d.a(dVar, "onus_credit_card", "cc_new_user_screen_loaded", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
        } catch (Throwable unused) {
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.proceedBT);
        if (cJRProceedWidgetV8 != null) {
            cJRProceedWidgetV8.setOnClickListener(this);
        }
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) a(R.id.shimmer_view);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.a();
            }
        } catch (Exception unused2) {
        }
        Bundle arguments2 = getArguments();
        if (!TextUtils.isEmpty(arguments2 != null ? arguments2.getString("logo_url") : null) && (arguments = getArguments()) != null && arguments.containsKey("logo_url")) {
            w a3 = w.a();
            Bundle arguments3 = getArguments();
            if (arguments3 == null) {
                k.a();
            }
            a3.a(arguments3.getString("logo_url")).a((ImageView) a(R.id.newUserBgIV), (e) new b(this));
        }
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f62580a;

        public final void onError(Exception exc) {
        }

        b(a aVar) {
            this.f62580a = aVar;
        }

        public final void onSuccess() {
            a.a(this.f62580a);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AJRNewCardActivityV4.a aVar = AJRNewCardActivityV4.f62553a;
        if (i2 != AJRNewCardActivityV4.f62554c || az.d(getActivity())) {
            super.onActivityResult(i2, i3, intent);
        }
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i2 = R.id.proceedBT;
        if (valueOf != null && valueOf.intValue() == i2) {
            d dVar = this.f62578b;
            if (dVar != null) {
                d.a(dVar, "onus_credit_card", "proceed_new_user_clicked", (Object) null, (Object) null, (Object) null, (Object) null, (Object) null, 124);
            }
            Intent intent = new Intent(getContext(), AJRNewCardActivityV4.class);
            AJRNewCardActivityV4.a aVar = AJRNewCardActivityV4.f62553a;
            startActivityForResult(intent, AJRNewCardActivityV4.f62554c);
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        try {
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) aVar.a(R.id.shimmer_view);
            if (shimmerFrameLayout != null) {
                shimmerFrameLayout.b();
            }
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) aVar.a(R.id.shimmer_view);
            if (shimmerFrameLayout2 != null) {
                net.one97.paytm.recharge.common.utils.ai.b(shimmerFrameLayout2);
            }
        } catch (Exception unused) {
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f62579c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
