package net.one97.paytm.upgradeKyc.videokyc.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;

public final class b extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public View f66354a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f66355b;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            setStyle(0, R.style.KycCustomBottomSheetDialogTheme);
        } catch (Exception unused) {
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.come_on_appointment_time_sheet, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…me_sheet,container,false)");
        this.f66354a = inflate;
        View view = this.f66354a;
        if (view == null) {
            k.a("lay");
        }
        return view;
    }

    public final void onViewCreated(View view, Bundle bundle) {
        View view2;
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        if (getContext() != null && (getContext() instanceof UpgradeKycBaseActivity)) {
            Context context = getContext();
            if (context != null) {
                ((UpgradeKycBaseActivity) context).b("noagents_popup_invoked", "/kyc/video_kyc/appointment_early");
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
            }
        }
        int i2 = R.id.tv_ok;
        if (this.f66355b == null) {
            this.f66355b = new HashMap();
        }
        View view3 = (View) this.f66355b.get(Integer.valueOf(i2));
        if (view3 == null) {
            View view4 = getView();
            if (view4 == null) {
                view2 = null;
                ((TextView) view2).setOnClickListener(this);
            }
            view3 = view4.findViewById(i2);
            this.f66355b.put(Integer.valueOf(i2), view3);
        }
        view2 = view3;
        ((TextView) view2).setOnClickListener(this);
    }

    public final void onClick(View view) {
        if (view != null && view.getId() == R.id.tv_ok) {
            dismiss();
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (getContext() != null && (getContext() instanceof UpgradeKycBaseActivity)) {
            Context context = getContext();
            if (context != null) {
                ((UpgradeKycBaseActivity) context).b("noagents_popup_closed", "/kyc/video_kyc/appointment_early");
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity");
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f66355b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
