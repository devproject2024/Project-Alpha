package net.one97.paytm.upi.profile.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.referral.UpiReferralActivity;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;

public class l extends h {

    /* renamed from: a  reason: collision with root package name */
    private String f68306a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f68307b = "";

    /* renamed from: c  reason: collision with root package name */
    private TextView f68308c;

    /* renamed from: d  reason: collision with root package name */
    private ImageView f68309d;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_profile_offer, viewGroup, false);
        this.f68308c = (TextView) inflate.findViewById(R.id.tv_offer);
        this.f68309d = (ImageView) inflate.findViewById(R.id.iv_offer);
        ((RelativeLayout) inflate.findViewById(R.id.parent_layout)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                l.this.a(view);
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "invite_friends_clicked", "", "", "", GAConstants.SCREEN_NAME.UPI_LANDING_PAGE, "wallet");
        startActivity(new Intent(getActivity(), UpiReferralActivity.class));
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            this.f68308c.setText(getArguments().getString("offer_text"));
        }
    }
}
