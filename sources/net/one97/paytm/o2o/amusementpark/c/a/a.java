package net.one97.paytm.o2o.amusementpark.c.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkConvenienceFee;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel;
import net.one97.paytm.common.entity.amPark.CJRValidatePackage;
import net.one97.paytm.common.entity.recharge.CJRRechargePayment;
import net.one97.paytm.i.h;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.d.c;
import net.one97.paytm.o2o.amusementpark.e.b;
import net.one97.paytm.o2o.amusementpark.utils.d;
import net.one97.paytm.o2o.amusementpark.utils.k;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;
import org.json.JSONObject;

public class a extends h implements View.OnClickListener, c {

    /* renamed from: a  reason: collision with root package name */
    public b f73411a;

    /* renamed from: b  reason: collision with root package name */
    boolean f73412b;

    /* renamed from: c  reason: collision with root package name */
    public C1473a f73413c;

    /* renamed from: d  reason: collision with root package name */
    private Button f73414d;

    /* renamed from: e  reason: collision with root package name */
    private net.one97.paytm.o2o.amusementpark.d.a f73415e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f73416f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f73417g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f73418h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f73419i;
    private TextView j;
    private TextView k;
    private RelativeLayout l;
    private TextView m;
    private TextView n;
    private ImageView o;
    /* access modifiers changed from: private */
    public boolean p = false;
    private Activity q;

    /* renamed from: net.one97.paytm.o2o.amusementpark.c.a.a$a  reason: collision with other inner class name */
    public interface C1473a {
        void a(Bundle bundle);

        void a(String str);

        void i();

        void j();

        void k();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.park_booking_review_and_pay_layout, viewGroup, false);
        if (this.f73411a == null) {
            this.f73411a = new b(this.q, this.f73413c);
        }
        b bVar = this.f73411a;
        Activity activity = this.q;
        bVar.f73606b = this;
        bVar.f73612h = activity;
        Bundle arguments = getArguments();
        if (arguments != null) {
            bVar.f73607c = (List) arguments.getSerializable("seat-summary-selected-list");
            bVar.f73608d = (CJRParticularAmParkDescriptionModel) arguments.getSerializable("event-address-list");
            bVar.f73611g = (AmParkTravellerResponseModel) arguments.getSerializable("traveller-response-model");
            bVar.j = (CJRAddressDetailModel) arguments.getSerializable("event-seat-selection-fragment-key-venue-model");
            bVar.k = arguments.getString("event-seat-selection-fragment-key-date");
            bVar.l = (CJRAmParkDateTimeModel.Time) arguments.getSerializable("event-seat-selection-fragment-key-time-model");
        }
        if (inflate != null) {
            this.f73414d = (Button) inflate.findViewById(R.id.events_review_and_pay_button);
            this.f73414d.setOnClickListener(this);
            this.f73416f = (TextView) inflate.findViewById(R.id.event_review_pay_base_fare);
            this.f73418h = (TextView) inflate.findViewById(R.id.event_review_pay_taxes);
            this.f73417g = (TextView) inflate.findViewById(R.id.event_review_pay_convenience_fee);
            this.f73419i = (TextView) inflate.findViewById(R.id.events_fare_breakup_title_textview);
            this.j = (TextView) inflate.findViewById(R.id.events_convenience_fee_title_textview);
            b bVar2 = this.f73411a;
            if (!(bVar2 == null || bVar2.g() == null)) {
                this.f73419i.setText(this.q.getString(R.string.event_fare_breakup_args, new Object[]{this.f73411a.g()}));
            }
            this.k = (TextView) inflate.findViewById(R.id.events_promo_code);
            this.k.setOnClickListener(this);
            this.k.setVisibility(0);
            this.l = (RelativeLayout) inflate.findViewById(R.id.lyt_events_promo_applied);
            this.m = (TextView) inflate.findViewById(R.id.txt_events_applied_promo_info);
            this.n = (TextView) inflate.findViewById(R.id.txt_events_cash_back_info);
            this.o = (ImageView) inflate.findViewById(R.id.img_events_remove_promo);
            this.o.setOnClickListener(this);
            try {
                Window window = getActivity().getWindow();
                if (!(window == null || window.getDecorView() == null || window.getDecorView().getWindowToken() == null)) {
                    ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(window.getDecorView().getWindowToken(), 0);
                }
            } catch (Exception unused) {
            }
        }
        b bVar3 = this.f73411a;
        bVar3.a(CJRAutomaticSubscriptionHistory.PROCESSING);
        String u = com.paytm.utility.b.u(bVar3.f73605a, com.paytm.utility.c.b(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_convenience_fee_url"), bVar3.f73605a));
        String c2 = bVar3.c();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        com.paytm.network.b bVar4 = new com.paytm.network.b();
        bVar4.f42877a = bVar3.f73605a;
        bVar4.f42878b = a.c.AM_PARK;
        bVar4.f42879c = a.C0715a.POST;
        bVar4.f42880d = u;
        bVar4.f42881e = null;
        bVar4.f42882f = hashMap;
        bVar4.f42883g = null;
        bVar4.f42884h = c2;
        bVar4.f42885i = new CJRAmParkConvenienceFee();
        bVar4.j = bVar3;
        bVar4.n = a.b.USER_FACING;
        bVar4.o = "AmPark";
        bVar4.t = b.j();
        com.paytm.network.a l2 = bVar4.l();
        l2.f42859c = false;
        l2.a();
        k.a(getActivity(), 6, d());
        return inflate;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f73415e = (net.one97.paytm.o2o.amusementpark.d.a) activity;
        this.q = activity;
    }

    public void onDestroyView() {
        super.onDestroyView();
        b bVar = this.f73411a;
        if (bVar != null) {
            bVar.f73605a = null;
            bVar.f73606b = null;
            this.f73411a = null;
        }
    }

    private static WindowManager.LayoutParams a(Dialog dialog) {
        try {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            try {
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
                return layoutParams;
            } catch (Exception unused) {
                return layoutParams;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public void onClick(View view) {
        JSONObject a2;
        if (view.getId() == R.id.events_review_and_pay_button) {
            try {
                k.b(getActivity(), 6, d());
            } catch (Exception unused) {
            }
            if (this.f73412b) {
                this.f73412b = false;
                b bVar = this.f73411a;
                if (bVar != null && (a2 = bVar.a(bVar.f73607c, bVar.f73611g.getForm())) != null) {
                    String jSONObject = a2.toString();
                    bVar.a("Processing...");
                    String u = com.paytm.utility.b.u(bVar.f73605a, "https://apiproxy.paytm.com/v1/entertainment/themeparks/validatePackage");
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    com.paytm.network.b bVar2 = new com.paytm.network.b();
                    bVar2.f42877a = bVar.f73605a;
                    bVar2.f42878b = a.c.AM_PARK;
                    bVar2.f42879c = a.C0715a.POST;
                    bVar2.f42880d = u;
                    bVar2.f42881e = null;
                    bVar2.f42882f = hashMap;
                    bVar2.f42883g = null;
                    bVar2.f42884h = jSONObject;
                    bVar2.f42885i = new CJRValidatePackage();
                    bVar2.j = bVar;
                    bVar2.n = a.b.USER_FACING;
                    bVar2.o = "AmPark";
                    bVar2.t = b.j();
                    com.paytm.network.a l2 = bVar2.l();
                    l2.f42859c = false;
                    l2.a();
                }
            }
        } else if (view.getId() == R.id.events_promo_code) {
            if (d.a((Context) this.q)) {
                c();
            } else {
                this.f73415e.a(258);
            }
        } else if (view.getId() == R.id.img_events_remove_promo && getActivity() != null && !getActivity().isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getResources().getString(R.string.remove_code_title));
            builder.setMessage(getResources().getString(R.string.remove_code_msg));
            builder.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    a.a(a.this);
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.show();
        }
    }

    public final void a(int i2) {
        if (i2 == 257) {
            this.f73411a.d();
        } else if (i2 == 258) {
            c();
        }
    }

    public final void a(CJRRechargePayment cJRRechargePayment, String str) {
        this.f73415e.a(cJRRechargePayment, str);
        this.f73412b = true;
    }

    public final void a(CJRAmParkConvenienceFee cJRAmParkConvenienceFee) {
        if (cJRAmParkConvenienceFee == null) {
            this.f73413c.j();
            return;
        }
        if (cJRAmParkConvenienceFee != null) {
            this.f73412b = true;
            b bVar = this.f73411a;
            double d2 = 0.0d;
            if (bVar.f73613i != null) {
                d2 = bVar.f73613i.getTotalCommision();
            }
            TextView textView = this.f73418h;
            textView.setText(this.q.getString(R.string.rupees) + " " + com.paytm.utility.b.a(d2));
            double e2 = (double) this.f73411a.e();
            String i2 = this.f73411a.i();
            TextView textView2 = this.f73416f;
            textView2.setText(this.q.getString(R.string.rupees) + " " + com.paytm.utility.b.a(e2));
            TextView textView3 = this.f73417g;
            textView3.setText(this.q.getString(R.string.rupees) + " " + i2);
            String a2 = com.paytm.utility.b.a(d2 + e2);
            this.f73414d.setText(this.q.getString(R.string.event_proceed_to_book_args, new Object[]{a2}));
        }
        b bVar2 = this.f73411a;
        if (bVar2 != null && bVar2.h() != null) {
            this.j.setText(this.q.getString(R.string.event_convenience_fee_args, new Object[]{this.f73411a.h()}));
        }
    }

    public final void a(String str, String str2) {
        this.f73413c.k();
        this.k.setVisibility(8);
        this.l.setVisibility(0);
        if (!TextUtils.isEmpty(str)) {
            this.m.setText(str);
        } else {
            this.m.setText("");
        }
        if (!TextUtils.isEmpty(str2)) {
            this.n.setText(str2);
        } else {
            this.n.setText("");
        }
    }

    public final void a() {
        if (d.a((Context) this.q)) {
            this.f73411a.d();
        } else if (this.f73415e != null) {
            this.f73412b = true;
            this.f73411a.f();
            this.f73415e.a(257);
        }
    }

    public final void a(CJRValidatePackage cJRValidatePackage) {
        if (cJRValidatePackage == null) {
            return;
        }
        if (!cJRValidatePackage.getShowMessage().booleanValue()) {
            a();
            return;
        }
        this.f73411a.f();
        if (getActivity() != null && !getActivity().isFinishing()) {
            FragmentActivity activity = getActivity();
            final String type = cJRValidatePackage.getType();
            String message = cJRValidatePackage.getMessage();
            if (!this.p && !activity.isFinishing()) {
                final com.paytm.utility.h hVar = new com.paytm.utility.h(activity);
                if (!TextUtils.isEmpty(type)) {
                    hVar.setTitle(type.toUpperCase(Locale.US));
                } else {
                    hVar.setTitle(type);
                }
                hVar.a(message);
                hVar.setCancelable(false);
                WindowManager.LayoutParams a2 = a((Dialog) hVar);
                hVar.a(-3, activity.getString(R.string.ok), new View.OnClickListener() {
                    public final void onClick(View view) {
                        hVar.cancel();
                        boolean unused = a.this.p = false;
                        String str = type;
                        if (str == null || !str.equalsIgnoreCase("warning")) {
                            a.this.f73412b = true;
                        } else {
                            a.this.a();
                        }
                    }
                });
                hVar.show();
                if (a2 != null) {
                    hVar.getWindow().setAttributes(a2);
                }
                this.p = true;
            }
        }
    }

    public final void b() {
        this.f73412b = true;
    }

    private void c() {
        if (!com.paytm.utility.b.c((Context) this.q)) {
            com.paytm.utility.b.b((Context) this.q, getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("from_vertical", 2);
        bundle.putInt(CLPConstants.PRODUCT_ID, Integer.parseInt(this.f73411a.f73608d.getProductId()));
        this.f73413c.a(bundle);
    }

    private String d() {
        if (getArguments() == null) {
            return "";
        }
        return getArguments().getString("park_id");
    }

    static /* synthetic */ void a(a aVar) {
        aVar.k.setVisibility(0);
        aVar.l.setVisibility(8);
        b bVar = aVar.f73411a;
        if (!TextUtils.isEmpty(bVar.m)) {
            bVar.m = null;
        }
    }
}
