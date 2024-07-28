package com.travel.citybus.best.ui.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.view.fragment.FilterPriceSliderFragment;
import com.travel.citybus.R;
import com.travel.citybus.best.e.d;
import com.travel.citybus.best.model.BestEPurse;
import com.travel.citybus.best.model.BestEPurseTokenResponse;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;

public final class d extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final a f23097a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public BestEPurse f23098b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public b f23099c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f23100d;

    public interface b {
        void a();
    }

    private View a(int i2) {
        if (this.f23100d == null) {
            this.f23100d = new HashMap();
        }
        View view = (View) this.f23100d.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f23100d.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = null;
            if ((arguments != null ? arguments.getSerializable("best_e_purse_data") : null) != null) {
                if ((arguments != null ? arguments.getSerializable("best_e_purse_data") : null) instanceof BestEPurse) {
                    if (arguments != null) {
                        serializable = arguments.getSerializable("best_e_purse_data");
                    }
                    this.f23098b = (BestEPurse) serializable;
                }
            }
        }
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        if (context instanceof b) {
            this.f23099c = (b) context;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_city_bus_e_purse_details, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        a();
    }

    public final void onResume() {
        super.onResume();
        com.travel.citybus.best.d.a aVar = com.travel.citybus.best.d.a.f23050a;
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        com.travel.citybus.best.d.a.a(context, new e(this));
    }

    public final void onDetach() {
        this.f23099c = null;
        super.onDetach();
    }

    /* access modifiers changed from: private */
    public final void a() {
        String str;
        TextView textView = (TextView) a(R.id.tv_avail_balance);
        k.a((Object) textView, "tv_avail_balance");
        StringBuilder sb = new StringBuilder(FilterPriceSliderFragment.RUPEE_SYMBOL);
        BestEPurse bestEPurse = this.f23098b;
        Float valueOf = bestEPurse != null ? Float.valueOf(bestEPurse.getAmountBalance()) : null;
        if (valueOf == null) {
            k.a();
        }
        sb.append(com.travel.citybus.best.e.b.a(valueOf.floatValue()));
        textView.setText(sb.toString());
        TextView textView2 = (TextView) a(R.id.tv_pass_id);
        k.a((Object) textView2, "tv_pass_id");
        BestEPurse bestEPurse2 = this.f23098b;
        if (bestEPurse2 == null || (str = bestEPurse2.getPassNumber()) == null) {
            str = "NA";
        }
        textView2.setText(str);
        ((TextView) a(R.id.tv_add_money)).setOnClickListener(new c(this));
        ((AppCompatImageView) a(R.id.iv_wallet_back_button)).setOnClickListener(new C0450d(this));
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f23101a;

        c(d dVar) {
            this.f23101a = dVar;
        }

        public final void onClick(View view) {
            b a2 = this.f23101a.f23099c;
            if (a2 != null) {
                a2.a();
            }
        }
    }

    /* renamed from: com.travel.citybus.best.ui.a.d$d  reason: collision with other inner class name */
    static final class C0450d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f23102a;

        C0450d(d dVar) {
            this.f23102a = dVar;
        }

        public final void onClick(View view) {
            FragmentActivity activity = this.f23102a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f23103a;

        e(d dVar) {
            this.f23103a = dVar;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            d.a aVar = com.travel.citybus.best.e.d.f23053a;
            Context context = this.f23103a.getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            String string = this.f23103a.getString(R.string.brts_error);
            k.a((Object) string, "getString(R.string.brts_error)");
            String string2 = this.f23103a.getString(R.string.city_bus_failed_fetch_purse_details);
            k.a((Object) string2, "getString(R.string.city_…iled_fetch_purse_details)");
            d.a.a(context, string, string2);
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            BestEPurse response;
            if ((iJRPaytmDataModel instanceof BestEPurseTokenResponse) && (response = ((BestEPurseTokenResponse) iJRPaytmDataModel).getResponse()) != null) {
                this.f23103a.f23098b = response;
                this.f23103a.a();
            }
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f23100d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
