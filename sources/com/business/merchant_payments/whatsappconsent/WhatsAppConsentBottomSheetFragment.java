package com.business.merchant_payments.whatsappconsent;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import com.business.merchant_payments.R;
import com.business.merchant_payments.gtm.GAGTMTagAnalytics;
import com.business.merchant_payments.widget.CustomBottomSheetDialogFragment;
import java.util.HashMap;
import kotlin.g.b.k;

public final class WhatsAppConsentBottomSheetFragment extends CustomBottomSheetDialogFragment {
    public HashMap _$_findViewCache;
    public Context activityContext;
    public Button mConsentButton;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ Button access$getMConsentButton$p(WhatsAppConsentBottomSheetFragment whatsAppConsentBottomSheetFragment) {
        Button button = whatsAppConsentBottomSheetFragment.mConsentButton;
        if (button == null) {
            k.a("mConsentButton");
        }
        return button;
    }

    public final void onAttach(Context context) {
        k.d(context, "context");
        super.onAttach(context);
        this.activityContext = context;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.d(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.mp_bottom_sheet_what_up, viewGroup, false);
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        initUI();
        initOnClicks();
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.d(view, "view");
        super.onViewCreated(view, bundle);
        GAGTMTagAnalytics.getSingleInstance().sendEvent(this.activityContext, "HomePage", "Bottom pop up", "", "Whatsapp consent", "Promo Impression");
    }

    private final void initUI() {
        Button button = (Button) _$_findCachedViewById(R.id.button_whats_up_consent);
        k.b(button, "button_whats_up_consent");
        this.mConsentButton = button;
    }

    private final void initOnClicks() {
        Button button = this.mConsentButton;
        if (button == null) {
            k.a("mConsentButton");
        }
        button.setOnClickListener(new WhatsAppConsentBottomSheetFragment$initOnClicks$1(this));
    }

    /* access modifiers changed from: private */
    public final void statusRecieved(String str, boolean z, Context context) {
        String string;
        if (z) {
            if (isAdded()) {
                dismissAllowingStateLoss();
            }
            FragmentActivity activity = getActivity();
            if (activity != null && (string = activity.getString(R.string.mp_whatapp_consent_succcess_msg)) != null) {
                k.b(string, "it");
                UpsUtility.showToast(string, true, context);
                return;
            }
            return;
        }
        Button button = this.mConsentButton;
        if (button == null) {
            k.a("mConsentButton");
        }
        button.setEnabled(true);
        UpsUtility.showToast(str, false, context);
    }

    public final void show(j jVar, String str) {
        k.d(jVar, "manager");
        try {
            q a2 = jVar.a();
            k.b(a2, "manager.beginTransaction()");
            a2.a((Fragment) this, str);
            a2.c();
        } catch (IllegalStateException e2) {
            e2.printStackTrace();
        }
    }

    public final void onDetach() {
        super.onDetach();
        this.activityContext = null;
    }
}
