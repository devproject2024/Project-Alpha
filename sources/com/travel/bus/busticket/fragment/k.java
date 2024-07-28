package com.travel.bus.busticket.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.play.core.splitcompat.a;
import com.paytm.utility.b;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.travel.bus.R;
import com.travel.bus.busticket.a.ae;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.i.h;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public class k extends h {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f22291a;

    /* renamed from: b  reason: collision with root package name */
    public Context f22292b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22293c;

    /* renamed from: d  reason: collision with root package name */
    public ae f22294d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f22295e;

    /* renamed from: f  reason: collision with root package name */
    public int f22296f;

    public k() {
    }

    public void onAttach(Context context) {
        a.b(context);
        super.onAttach(context);
    }

    public void onResume() {
        super.onResume();
        a.b((Context) getActivity());
    }

    public k(Context context) {
        this.f22292b = context;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        HashMap hashMap = new HashMap();
        hashMap.put("event_category", "travel_referral");
        hashMap.put("event_action", "earning_screen_loaded");
        hashMap.put("event_label", Integer.valueOf(this.f22296f));
        hashMap.put("user_id", b.n((Context) getActivity()));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "Referrer Earning Screen");
        hashMap.put("vertical_name", "travel");
        com.travel.bus.a.a();
        com.travel.bus.a.b().a(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, (Context) getActivity());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pre_b_refer_view_earnings_fragment, viewGroup, false);
        this.f22291a = (RecyclerView) inflate.findViewById(R.id.view_earnings_members_recycler);
        this.f22293c = (TextView) inflate.findViewById(R.id.no_booking_text);
        this.f22295e = (RelativeLayout) inflate.findViewById(R.id.root_layout);
        return inflate;
    }
}
