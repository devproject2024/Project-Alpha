package net.one97.paytm.fastag.ui.c;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.google.gsonhtcfix.b.g;
import com.paytm.utility.b;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.io.Serializable;
import java.util.HashMap;
import net.one97.paytm.fastag.R;
import net.one97.paytm.fastag.c.a;
import net.one97.paytm.fastag.model.CJROrderSummary;
import net.one97.paytm.fastag.model.CJROrderedCart;
import net.one97.paytm.m;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.Events;
import net.one97.paytm.upi.util.UpiConstants;

public class d extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private static final String f13908b = d.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    boolean f13909a;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13910c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public CJROrderSummary f13911d = null;

    /* renamed from: e  reason: collision with root package name */
    private TextView f13912e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f13913f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f13914g;

    /* renamed from: h  reason: collision with root package name */
    private String f13915h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ProgressDialog f13916i;

    public static d a(CJROrderSummary cJROrderSummary, boolean z, String str) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order_summary_key", cJROrderSummary);
        bundle.putBoolean("contact_us_key", z);
        bundle.putString("order_item_id", str);
        dVar.setArguments(bundle);
        return dVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                this.f13911d = (CJROrderSummary) arguments.getSerializable("order_summary_key");
                this.f13909a = arguments.getBoolean("contact_us_key");
                this.f13915h = arguments.getString("order_item_id");
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
        View inflate = layoutInflater.inflate(R.layout.fastag_help_layout, (ViewGroup) null);
        this.f13910c = (TextView) inflate.findViewById(R.id.tv_vehicle_registration_no);
        this.f13912e = (TextView) inflate.findViewById(R.id.tv_fasttag_amount);
        this.f13913f = (TextView) inflate.findViewById(R.id.tv_order_id);
        this.f13914g = (TextView) inflate.findViewById(R.id.tv_nedd_help);
        this.f13914g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                d dVar = d.this;
                d.a(dVar, dVar.f13911d);
                d.a(d.this, Events.Action.NEED_HELP_CLICKED, "");
            }
        });
        CJROrderSummary cJROrderSummary = this.f13911d;
        if (cJROrderSummary != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            this.f13910c.setText(String.format(getString(R.string.fastag_vehicle_no), new Object[]{((g) this.f13911d.getOrderedCartList().get(0).getMetaDataResponse()).get("vehicle_registrtion_number")}));
            this.f13913f.setText(String.format(getString(R.string.fastag_ordfer_id), new Object[]{this.f13911d.getId()}));
            CJROrderSummary cJROrderSummary2 = this.f13911d;
            if (cJROrderSummary2 != null && (cJROrderSummary2.getPaymentStatus().equalsIgnoreCase(SDKConstants.GA_NATIVE_FAILED) || this.f13911d.getPaymentStatus().equalsIgnoreCase("Pending"))) {
                this.f13912e.setVisibility(0);
                this.f13912e.setText(getString(R.string.fastag_amount, b.x(this.f13911d.getOrderedCartList().get(0).getAggregateItemPrice())));
            }
        }
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    static /* synthetic */ void a(d dVar, CJROrderSummary cJROrderSummary) {
        try {
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            cJROrderedCart.setOrderId(cJROrderSummary.getId());
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, (Serializable) b.a((Object) cJROrderedCart, net.one97.paytm.common.entity.shopping.CJROrderedCart.class));
            a.a().f13559b.startCSTOrderIssuesActivity(dVar.getActivity(), bundle, new m() {
                public final void show() {
                    d dVar = d.this;
                    ProgressDialog unused = dVar.f13916i = ProgressDialog.show(dVar.getActivity(), "Loading", "Please wait...", true);
                }

                public final void dismiss() {
                    d.this.f13916i.dismiss();
                }
            });
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(d dVar, String str, String str2) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("event_category", "fastag");
            hashMap.put("event_action", str);
            if (TextUtils.isEmpty(str2)) {
                hashMap.put("event_label", str2);
            }
            a.a().f13559b.sendCustomEventWithMap(GAUtil.CUSTOM_EVENT, hashMap, dVar.getActivity());
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        }
    }
}
