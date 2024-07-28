package net.one97.paytm.upgradeKyc.aotp.a;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.f;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import androidx.lifecycle.ai;
import androidx.lifecycle.aj;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import androidx.lifecycle.z;
import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import kotlin.d.d;
import kotlin.g.b.k;
import kotlin.u;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import net.one97.paytm.i.h;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.aotp.b.c;
import net.one97.paytm.upgradeKyc.b.e;
import net.one97.paytm.upgradeKyc.d.m;
import net.one97.paytm.upgradeKyc.kycV3.c.g;
import net.one97.paytm.upgradeKyc.utils.l;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public C1294a f65468a;

    /* renamed from: b  reason: collision with root package name */
    public c f65469b;

    /* renamed from: c  reason: collision with root package name */
    public e f65470c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f65471d;

    /* renamed from: net.one97.paytm.upgradeKyc.aotp.a.a$a  reason: collision with other inner class name */
    public interface C1294a {
        void a(net.one97.paytm.upgradeKyc.aotp.a aVar);
    }

    static final class b<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<Object>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f65472a;

        b(a aVar) {
            this.f65472a = aVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            j supportFragmentManager;
            j supportFragmentManager2;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                int i2 = b.f65473a[bVar.f66168a.ordinal()];
                String str = null;
                boolean z = true;
                if (i2 != 1) {
                    if (i2 == 2) {
                        net.one97.paytm.common.widgets.a.a(this.f65472a.b().f65592f);
                    } else if (i2 == 3) {
                        net.one97.paytm.common.widgets.a.b(this.f65472a.b().f65592f);
                        l.a();
                        FragmentActivity activity = this.f65472a.getActivity();
                        if (activity == null) {
                            k.a();
                        }
                        Context context = activity;
                        NetworkCustomError networkCustomError = bVar.f66170c;
                        if (networkCustomError == null) {
                            throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
                        } else if (!l.a(context, networkCustomError)) {
                            NetworkCustomError networkCustomError2 = bVar.f66170c;
                            if (networkCustomError2 != null) {
                                str = networkCustomError2.getAlertMessage();
                            }
                            CharSequence charSequence = str;
                            if (!(charSequence == null || charSequence.length() == 0)) {
                                z = false;
                            }
                            if (z) {
                                str = this.f65472a.getString(R.string.some_went_wrong);
                            }
                            com.paytm.utility.b.b(this.f65472a.getContext(), AppConstants.TRANSACTION_STATUS_ERROR, str);
                        }
                    }
                } else if (bVar.f66169b != null && (bVar.f66169b instanceof net.one97.paytm.upgradeKyc.aotp.a)) {
                    ResultType resulttype = bVar.f66169b;
                    net.one97.paytm.common.widgets.a.b(this.f65472a.b().f65592f);
                    if (resulttype == net.one97.paytm.upgradeKyc.aotp.a.TNC_FETCHED) {
                        TextView textView = this.f65472a.b().f65594h;
                        k.a((Object) textView, "binding.proceedBtn");
                        textView.setEnabled(true);
                        TextView textView2 = this.f65472a.b().f65589c;
                        k.a((Object) textView2, "binding.consentText");
                        textView2.setEnabled(true);
                    } else if (resulttype == net.one97.paytm.upgradeKyc.aotp.a.CONSENT_GIVEN) {
                        C1294a a2 = this.f65472a.a();
                        if (resulttype != null) {
                            a2.a((net.one97.paytm.upgradeKyc.aotp.a) resulttype);
                            FragmentActivity activity2 = this.f65472a.getActivity();
                            if (activity2 != null && (supportFragmentManager2 = activity2.getSupportFragmentManager()) != null) {
                                supportFragmentManager2.d();
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.aotp.KycConsentAction");
                    } else if (resulttype == net.one97.paytm.upgradeKyc.aotp.a.TRY_USING_DIFFERENT_METHOD) {
                        net.one97.paytm.common.widgets.a.b(this.f65472a.b().f65592f);
                        C1294a a3 = this.f65472a.a();
                        if (resulttype != null) {
                            a3.a((net.one97.paytm.upgradeKyc.aotp.a) resulttype);
                            FragmentActivity activity3 = this.f65472a.getActivity();
                            if (activity3 != null && (supportFragmentManager = activity3.getSupportFragmentManager()) != null) {
                                supportFragmentManager.d();
                                return;
                            }
                            return;
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.aotp.KycConsentAction");
                    } else if (resulttype == net.one97.paytm.upgradeKyc.aotp.a.SHOW_TNC) {
                        FragmentActivity activity4 = this.f65472a.getActivity();
                        if (activity4 == null) {
                            k.a();
                        }
                        k.a((Object) activity4, "activity!!");
                        q a4 = activity4.getSupportFragmentManager().a();
                        int i3 = R.id.parent_layout;
                        c cVar = this.f65472a.f65469b;
                        if (cVar == null) {
                            k.a("viewModel");
                        }
                        a4.a(i3, (Fragment) m.a(cVar.a().getTncDataList())).a((String) null).c();
                    }
                }
            }
        }
    }

    public final C1294a a() {
        C1294a aVar = this.f65468a;
        if (aVar == null) {
            k.a("listener");
        }
        return aVar;
    }

    public final e b() {
        e eVar = this.f65470c;
        if (eVar == null) {
            k.a("binding");
        }
        return eVar;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        ao aoVar = this;
        g.a aVar = g.f66236a;
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application == null) {
            k.a();
        }
        ai a2 = new al(aoVar, (al.b) g.a.a(application)).a(c.class);
        k.a((Object) a2, "ViewModelProvider(this,K…entViewModel::class.java)");
        this.f65469b = (c) a2;
        ViewDataBinding a3 = f.a(layoutInflater, R.layout.fragment_aotp_exit_consent, viewGroup, false);
        k.a((Object) a3, "DataBindingUtil.inflate(…_consent,container,false)");
        this.f65470c = (e) a3;
        e eVar = this.f65470c;
        if (eVar == null) {
            k.a("binding");
        }
        c cVar = this.f65469b;
        if (cVar == null) {
            k.a("viewModel");
        }
        eVar.a(cVar);
        e eVar2 = this.f65470c;
        if (eVar2 == null) {
            k.a("binding");
        }
        return eVar2.getRoot();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(getString(R.string.kyc_consent_text));
        SpannableString spannableString = new SpannableString(getString(R.string.kyc_terms_and_conditions));
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context, R.color.paytm_blue)), 0, spannableString.length(), 33);
        spannableString.setSpan(new AbsoluteSizeSpan(getResources().getDimensionPixelSize(R.dimen.dimen_14sp)), 0, spannableString.length(), 33);
        spannableString.setSpan(new StyleSpan(1), 0, spannableString.length(), 33);
        spannableStringBuilder.append(spannableString);
        e eVar = this.f65470c;
        if (eVar == null) {
            k.a("binding");
        }
        TextView textView = eVar.f65589c;
        k.a((Object) textView, "binding.consentText");
        textView.setText(spannableStringBuilder);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
        spannableStringBuilder2.append(getString(R.string.kyc_wallet_validity_text));
        spannableStringBuilder2.append(" ");
        spannableStringBuilder2.append(net.one97.paytm.upgradeKyc.utils.j.g(getContext()));
        spannableStringBuilder2.append(AppUtility.CENTER_DOT);
        SpannableString spannableString2 = new SpannableString(getString(R.string.kyc_existing_wallet_will_be_replaced));
        spannableString2.setSpan(new StyleSpan(1), 0, spannableString2.length(), 33);
        spannableStringBuilder2.append(spannableString2);
        e eVar2 = this.f65470c;
        if (eVar2 == null) {
            k.a("binding");
        }
        TextView textView2 = eVar2.f65595i;
        k.a((Object) textView2, "binding.walletValidity");
        textView2.setText(spannableStringBuilder2);
        c cVar = this.f65469b;
        if (cVar == null) {
            k.a("viewModel");
        }
        cVar.f65566a.observe(getViewLifecycleOwner(), new b(this));
        c cVar2 = this.f65469b;
        if (cVar2 == null) {
            k.a("viewModel");
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(aj.a(cVar2), (kotlin.d.f) null, (CoroutineStart) null, new c.b(cVar2, (d) null), 3, (Object) null);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f65471d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
