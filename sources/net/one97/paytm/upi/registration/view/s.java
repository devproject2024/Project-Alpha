package net.one97.paytm.upi.registration.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.g.b.y;
import kotlin.m.p;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.UpiGTMLoader;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.e.u;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.e;
import net.one97.paytm.upi.registration.view.o;
import net.one97.paytm.upi.util.AnimationFactory;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.PermissionUtil;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public final class s extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f69050a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public u f69051b;

    /* renamed from: c  reason: collision with root package name */
    private HashMap f69052c;

    private final u a() {
        u uVar = this.f69051b;
        if (uVar == null) {
            k.a();
        }
        return uVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_benefits, viewGroup, false);
        this.f69051b = u.a(inflate);
        a().t.setOnClickListener(new c(this));
        a().f66902a.setOnClickListener(new d(this));
        a().f66907f.setOnClickListener(new e(this));
        TextView textView = a().u;
        k.a((Object) textView, "binding.title");
        textView.setText(getString(R.string.upi_benefits_title));
        RecyclerView recyclerView = a().f66903b;
        k.a((Object) recyclerView, "binding.bannerRecyclerView");
        UpiGTMLoader instance = UpiGTMLoader.getInstance();
        k.a((Object) instance, "UpiGTMLoader.getInstance()");
        String str = instance.getUpiBenefitsBannerUrl() + UpiAppUtils.getAuthDefaultParams(getContext());
        i a2 = i.a();
        k.a((Object) a2, "PaytmUpiSdk.getInstance()");
        a2.c().a((View) null, recyclerView, com.paytm.utility.b.t(getContext(), str) + "&child_site_id=" + com.paytm.utility.a.b() + "&site_id=" + com.paytm.utility.a.a(), requireActivity());
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, "screen_open", "", "", "", GAConstants.SCREEN_NAME.UPI_BENEFITS, "");
        return inflate;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f69054a;

        c(s sVar) {
            this.f69054a = sVar;
        }

        public final void onClick(View view) {
            s.a(this.f69054a);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f69055a;

        d(s sVar) {
            this.f69055a = sVar;
        }

        public final void onClick(View view) {
            s.b(this.f69055a);
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f69056a;

        e(s sVar) {
            this.f69056a = sVar;
        }

        public final void onClick(View view) {
            s.c(this.f69056a);
        }
    }

    private final void a(int i2) {
        if (isAdded() && getActivity() != null && (getActivity() instanceof SignUpAddBankActivity)) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                ((SignUpAddBankActivity) activity).b(i2);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type net.one97.paytm.upi.registration.view.SignUpAddBankActivity");
        }
    }

    public static final class b implements a.C1389a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s f69053a;

        b(s sVar) {
            this.f69053a = sVar;
        }

        public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
            if (this.f69053a.f69051b != null) {
                s.e(this.f69053a);
                if (upiBaseDataModel instanceof UpiAvailabilityModel) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (p.a("success", upiAvailabilityModel.getStatus(), true)) {
                        s sVar = this.f69053a;
                        UpiAvailabilityModel.UpiAvailabilityResponse response = upiAvailabilityModel.getResponse();
                        k.a((Object) response, "response.response");
                        s.a(sVar, response.isSameDevice());
                    }
                }
            }
        }

        public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
            if (this.f69053a.f69051b != null) {
                s.e(this.f69053a);
                s sVar = this.f69053a;
                if (sVar.getContext() == null) {
                    k.a();
                }
                if (sVar.getContext() == null) {
                    k.a();
                }
                s.a(sVar, g.a(g.a((a.C1347a) null)).g());
            }
        }
    }

    private final void a(String str) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_V1, str, "", "", "", GAConstants.SCREEN_NAME.UPI_BENEFITS, "");
    }

    public final void onDestroy() {
        this.f69051b = null;
        super.onDestroy();
    }

    private final boolean b() {
        if (getActivity() == null) {
            return false;
        }
        androidx.lifecycle.k lifecycle = getLifecycle();
        k.a((Object) lifecycle, "lifecycle");
        return lifecycle.a().isAtLeast(k.b.RESUMED);
    }

    public static final /* synthetic */ void a(s sVar) {
        sVar.a(2);
        sVar.a(GAConstants.ACTION.SKIP_CLICKED);
    }

    public static final /* synthetic */ void b(s sVar) {
        sVar.a(3);
        sVar.a(GAConstants.ACTION.ONB_APP_BACK_BUTTON_CLICKED);
    }

    public static final /* synthetic */ void c(s sVar) {
        if (sVar.b()) {
            FragmentActivity activity = sVar.getActivity();
            if (!(activity == null || activity.getSupportFragmentManager() == null)) {
                sVar.a().f66908g.setVisibility(0);
                AnimationFactory.startWalletLoader(sVar.a().l);
                sVar.a().f66907f.setEnabled(false);
                if (sVar.getContext() == null) {
                    kotlin.g.b.k.a();
                }
                if (sVar.getContext() == null) {
                    kotlin.g.b.k.a();
                }
                g.a(g.a((a.C1347a) null)).c(new b(sVar), "", "");
            }
            sVar.a(GAConstants.ACTION.LINK_ACC_PROCEED_CLICKED);
        }
    }

    public static final /* synthetic */ void e(s sVar) {
        sVar.a().f66908g.setVisibility(8);
        AnimationFactory.stopWalletLoader(sVar.a().l);
        sVar.a().f66907f.setEnabled(true);
    }

    public static final /* synthetic */ void a(s sVar, boolean z) {
        j supportFragmentManager;
        if (sVar.b() && UpiUtils.isSimAvailable(sVar.getContext())) {
            if (z) {
                j fragmentManager = sVar.getFragmentManager();
                if (fragmentManager != null) {
                    e.a aVar = e.f68830a;
                    new e().show(fragmentManager, y.b(e.class).b());
                }
            } else if (!PermissionUtil.checkPhoneStatePermission(sVar.requireActivity()) || !UpiUtils.isMultiSimDevice(sVar.getContext())) {
                FragmentActivity activity = sVar.getActivity();
                if (!(activity instanceof SignUpAddBankActivity)) {
                    activity = null;
                }
                SignUpAddBankActivity signUpAddBankActivity = (SignUpAddBankActivity) activity;
                if (signUpAddBankActivity != null) {
                    signUpAddBankActivity.a(-1);
                }
            } else {
                FragmentActivity activity2 = sVar.getActivity();
                if (activity2 != null && (supportFragmentManager = activity2.getSupportFragmentManager()) != null) {
                    q a2 = supportFragmentManager.a();
                    int i2 = R.id.container;
                    o.a aVar2 = o.f68987a;
                    kotlin.g.b.k.c("", "param1");
                    kotlin.g.b.k.c("", "param2");
                    o oVar = new o();
                    Bundle bundle = new Bundle();
                    bundle.putString("param1", "");
                    bundle.putString("param2", "");
                    oVar.setArguments(bundle);
                    a2.a(i2, (Fragment) oVar).a("javaClass").c();
                }
            }
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f69052c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
