package net.one97.paytm.upi.referral;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final C1386a f68388a = new C1386a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private HashMap f68389b;

    /* renamed from: net.one97.paytm.upi.referral.a$a  reason: collision with other inner class name */
    public static final class C1386a {
        private C1386a() {
        }

        public /* synthetic */ C1386a(byte b2) {
            this();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.upi_referral_ribbon, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        view.findViewById(R.id.tv_message);
        view.findViewById(R.id.tv_subTitle);
        ((TextView) view.findViewById(R.id.tvInvite)).setOnClickListener(new b(this));
    }

    static final class b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f68390a;

        b(a aVar) {
            this.f68390a = aVar;
        }

        public final void onClick(View view) {
            a.a(this.f68390a);
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        CJRSendGTMTag.sendNewCustomGTMEvents(aVar.getActivity(), CJRGTMConstants.UPI_EVENT_CATEGORY, "invite_strip_clicked", (String) null, (String) null, (String) null, "/bhim-upi/profile", "wallet");
        Intent intent = new Intent(aVar.getContext(), UpiReferralActivity.class);
        FragmentActivity activity = aVar.getActivity();
        if (activity != null) {
            activity.startActivity(intent);
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f68389b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
