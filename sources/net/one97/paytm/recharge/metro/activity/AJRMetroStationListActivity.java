package net.one97.paytm.recharge.metro.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import java.util.List;
import kotlin.x;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ab;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.metro.c.c;
import net.one97.paytm.recharge.metro.c.q;
import net.one97.paytm.recharge.metro.f.a;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroQRFrequentOrder;
import net.one97.paytm.recharge.model.metro.CJRMetroStationListResponse;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;
import net.one97.paytm.recharge.ordersummary.h.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public class AJRMetroStationListActivity extends CJRBaseMetroActivity implements c.a, q.a {

    /* renamed from: a  reason: collision with root package name */
    public CJRMetroStationModel f63207a;

    /* renamed from: b  reason: collision with root package name */
    public CJRMetroStationModel f63208b;

    /* renamed from: c  reason: collision with root package name */
    protected boolean f63209c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f63210d;

    /* renamed from: e  reason: collision with root package name */
    TextView f63211e;

    /* renamed from: g  reason: collision with root package name */
    private String f63212g;

    /* renamed from: h  reason: collision with root package name */
    private List<CJRMetroStationModel> f63213h;

    /* renamed from: i  reason: collision with root package name */
    private String f63214i;
    private String j;
    private CJRMetroQRFrequentOrder k;
    private String l = "";
    private String m = "";
    private String n;
    private String o = "";
    private String u = "";
    private View v;
    private d w = new d(this);

    public void a(CJRMetroStationModel cJRMetroStationModel) {
    }

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        View findViewById = findViewById(R.id.ll_abs);
        if (findViewById != null) {
            findViewById.setBackgroundResource(17170445);
        }
        getLayoutInflater().inflate(R.layout.activity_station_list, this.f63266f, true);
        if (getIntent().hasExtra("source_name_for_penalty")) {
            this.f63209c = true;
            this.f63207a = (CJRMetroStationModel) getIntent().getSerializableExtra("source_name_for_penalty");
        }
        if (getIntent().hasExtra("layout_title_for_penalty")) {
            str = getIntent().getStringExtra("layout_title_for_penalty");
        } else if (this.f63207a == null) {
            str = getIntent().getStringExtra("source_station");
        } else {
            str = getIntent().getStringExtra("destination_station");
        }
        this.f63212g = str;
        if (getIntent().hasExtra("is_new_metro_flow")) {
            this.f63210d = getIntent().getBooleanExtra("is_new_metro_flow", false);
        }
        if (getIntent().hasExtra("actionBarTitle")) {
            this.f63214i = getIntent().getStringExtra("actionBarTitle");
        }
        if (getIntent().hasExtra("station_hint")) {
            this.o = getIntent().getStringExtra("station_hint");
        }
        if (getIntent().hasExtra("metroTicketVariant")) {
            this.m = getIntent().getStringExtra("metroTicketVariant");
        }
        if (getIntent().hasExtra("ticket_type")) {
            this.u = getIntent().getStringExtra("ticket_type");
        }
        if (getIntent().hasExtra("station_hint_dest")) {
            this.l = getIntent().getStringExtra("station_hint_dest");
        }
        if (getIntent().hasExtra("product-type")) {
            this.n = getIntent().getStringExtra("product-type");
        }
        if (this.f63210d) {
            getSupportActionBar().f();
            this.v = getLayoutInflater().inflate(R.layout.custom_abs_layout_metro, (ViewGroup) null, false);
            ((LinearLayout) a(R.id.ll_abs)).addView(this.v, 0);
            this.f63211e = (TextView) findViewById(R.id.tv_ab_title);
            ImageView imageView = (ImageView) findViewById(R.id.back_button);
            if (this.f63207a == null) {
                this.f63211e.setText(this.f63214i);
                this.j = getString(R.string.metro_origin_station);
            } else {
                this.f63211e.setText(this.f63214i);
                this.j = getString(R.string.metro_destination_station);
            }
            imageView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJRMetroStationListActivity.this.onBackPressed();
                }
            });
        }
        this.f63213h = (List) getIntent().getSerializableExtra("metroStationList");
        List<CJRMetroStationModel> list = this.f63213h;
        if (list != null) {
            a(list, this.f63212g, this.f63207a, this.j, this.o, this.l);
        } else if (b.c((Context) this)) {
            b();
        } else {
            Toast.makeText(this, R.string.network_error_heading_re, 0).show();
            finish();
        }
    }

    private void b() {
        a((Context) this, getString(R.string.please_wait_progress_msg_re));
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        CJRRechargeErrorModel a2 = net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
        a2.setFlowName(new CRUFlowModel());
        a2.getFlowName().setErrorType(ERROR_TYPE.UNDEFINED.name());
        a2.getFlowName().setActionType(ACTION_TYPE.GET_STATION_LIST.name());
        a2.getFlowName().setVariantType(this.n);
        a.a("fetch_metro_station", (Context) this, this.n, this.m, (ai) this, (Object) a2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: net.one97.paytm.recharge.metro.c.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: net.one97.paytm.recharge.metro.c.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: net.one97.paytm.recharge.metro.c.q} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: net.one97.paytm.recharge.metro.c.q} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<net.one97.paytm.recharge.model.metro.CJRMetroStationModel> r11, java.lang.String r12, net.one97.paytm.recharge.model.metro.CJRMetroStationModel r13, java.lang.String r14, java.lang.String r15, java.lang.String r16) {
        /*
            r10 = this;
            r0 = r10
            r9 = r13
            boolean r1 = r0.f63210d
            if (r1 == 0) goto L_0x0037
            android.content.Intent r1 = r10.getIntent()
            java.lang.String r2 = "ticket_type"
            java.lang.String r5 = r1.getStringExtra(r2)
            java.lang.String r8 = r0.n
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r15
            r7 = r16
            net.one97.paytm.recharge.metro.c.c r1 = net.one97.paytm.recharge.metro.c.c.a(r1, r2, r3, r4, r5, r6, r7, r8)
            android.os.Bundle r2 = r1.getArguments()
            android.content.Intent r3 = r10.getIntent()
            java.lang.String r4 = "key_recent_product_type"
            java.lang.String r3 = r3.getStringExtra(r4)
            r2.putString(r4, r3)
            net.one97.paytm.recharge.metro.activity.-$$Lambda$AJRMetroStationListActivity$sF5owh3hLlRIKMfW8l9wjyK0La0 r2 = new net.one97.paytm.recharge.metro.activity.-$$Lambda$AJRMetroStationListActivity$sF5owh3hLlRIKMfW8l9wjyK0La0
            r2.<init>(r13)
            net.one97.paytm.recharge.widgets.c.b.a(r2)
            goto L_0x0044
        L_0x0037:
            android.view.View r1 = r0.v
            if (r1 == 0) goto L_0x0040
            int r2 = net.one97.paytm.recharge.R.color.white
            r1.setBackgroundResource(r2)
        L_0x0040:
            net.one97.paytm.recharge.metro.c.q r1 = net.one97.paytm.recharge.metro.c.q.a(r11, r12, r13)
        L_0x0044:
            androidx.fragment.app.j r2 = r10.getSupportFragmentManager()
            androidx.fragment.app.q r2 = r2.a()
            r3 = 0
            if (r9 == 0) goto L_0x006f
            boolean r4 = r0.f63209c
            if (r4 != 0) goto L_0x006f
            int r4 = net.one97.paytm.recharge.R.anim.slide_in_right
            int r5 = net.one97.paytm.recharge.R.anim.slide_out_left
            int r6 = net.one97.paytm.recharge.R.anim.slide_in_left
            int r7 = net.one97.paytm.recharge.R.anim.slide_out_right
            r2.a((int) r4, (int) r5, (int) r6, (int) r7)
            int r4 = net.one97.paytm.recharge.R.id.station_fragment_container
            r2.b(r4, r1, r3)
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getSimpleName()
            r2.a((java.lang.String) r1)
            goto L_0x0074
        L_0x006f:
            int r4 = net.one97.paytm.recharge.R.id.station_fragment_container
            r2.b(r4, r1, r3)
        L_0x0074:
            r2.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRMetroStationListActivity.a(java.util.List, java.lang.String, net.one97.paytm.recharge.model.metro.CJRMetroStationModel, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x b(CJRMetroStationModel cJRMetroStationModel) {
        String str;
        if (cJRMetroStationModel == null) {
            StringBuilder sb = new StringBuilder("/");
            c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
            sb.append(c.a.a(this.m));
            sb.append("_from_metro_qr_ticket");
            str = sb.toString();
            if ("MUMBAI_METRO_TP".equalsIgnoreCase(this.u) || "DELHI_METRO_TP".equalsIgnoreCase(this.u)) {
                StringBuilder sb2 = new StringBuilder("/");
                c.a aVar2 = net.one97.paytm.recharge.metro.f.c.f63576a;
                sb2.append(c.a.a(this.m));
                sb2.append("_from_trip_pass");
                str = sb2.toString();
            }
        } else {
            StringBuilder sb3 = new StringBuilder("/");
            c.a aVar3 = net.one97.paytm.recharge.metro.f.c.f63576a;
            sb3.append(c.a.a(this.m));
            sb3.append("_to_metro_qr_ticket");
            str = sb3.toString();
            if ("MUMBAI_METRO_TP".equalsIgnoreCase(this.u) || "DELHI_METRO_TP".equalsIgnoreCase(this.u)) {
                StringBuilder sb4 = new StringBuilder("/");
                c.a aVar4 = net.one97.paytm.recharge.metro.f.c.f63576a;
                sb4.append(c.a.a(this.m));
                sb4.append("_to_trip_pass");
                str = sb4.toString();
            }
        }
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a((Context) this, str);
        net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
        net.one97.paytm.recharge.widgets.c.d.a((ACTION_TYPE) null, (ERROR_TYPE) null).setScreenName(str);
        return null;
    }

    public void onBackPressed() {
        q();
        if (this.f63208b != null) {
            setResult(-1, getIntent().putExtra("sourceMetroStation", this.f63207a).putExtra("destinationMetroStation", this.f63208b));
            finish();
            return;
        }
        if (this.k != null) {
            setResult(-1, getIntent().putExtra("sourceMetroStation", this.k.getSource()).putExtra("destinationMetroStation", this.k.getDestination()).putExtra("metro_qr_frequent_object", this.k));
            finish();
        }
        if (this.f63210d) {
            this.f63211e.setText(this.f63214i);
        }
        super.onBackPressed();
        if (this.f63210d) {
            overridePendingTransition(R.anim.slide_no_change_mumbai_metro, R.anim.slide_down_mumbai_metro);
        }
    }

    public final void a(CJRMetroQRFrequentOrder cJRMetroQRFrequentOrder) {
        this.k = cJRMetroQRFrequentOrder;
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        String a2 = c.a.a(c.a.b(cJRMetroQRFrequentOrder.getProductType()));
        this.w.a(!TextUtils.isEmpty(this.m) ? this.m.toLowerCase() : "", "recent_item_selected", "", a2, ab.f61496a, "", "");
        onBackPressed();
    }

    public final void a(CJRMetroStationModel cJRMetroStationModel, CJRMetroStationModel cJRMetroStationModel2) {
        String str;
        String str2;
        String str3;
        String str4;
        if (cJRMetroStationModel2 == null) {
            this.f63207a = cJRMetroStationModel;
            String name = cJRMetroStationModel.getName();
            String str5 = "MUMBAI_METRO_TP".equalsIgnoreCase(this.u) ? "trip_a_station_selected" : "from_selected";
            a(this.f63213h, getIntent().getStringExtra("destination_station"), cJRMetroStationModel, getString(R.string.metro_destination_station), this.o, this.l);
            str = name;
            str2 = str5;
        } else if (!b.c((Context) this)) {
            az azVar = az.f61525a;
            az.a(this, ERROR_TYPE.NO_CONNECTION, ACTION_TYPE.UNDEFINED, getString(R.string.no_connection), getString(R.string.no_internet));
            return;
        } else {
            this.f63207a = cJRMetroStationModel;
            this.f63208b = cJRMetroStationModel2;
            onBackPressed();
            if (this.f63210d) {
                str4 = cJRMetroStationModel2.getName();
                str3 = "MUMBAI_METRO_TP".equalsIgnoreCase(this.u) ? "trip_b_station_selected" : "where_to_selected";
            } else {
                str4 = "";
                str3 = str4;
            }
            if (!TextUtils.isEmpty(this.u) && !"MUMBAI_METRO_SJT".equalsIgnoreCase(this.u) && !"MUMBAI_METRO_RJT".equalsIgnoreCase(this.u)) {
                "MUMBAI_METRO_TP".equalsIgnoreCase(this.u);
            }
            str = str4;
            str2 = str3;
        }
        d dVar = this.w;
        c.a aVar = net.one97.paytm.recharge.metro.f.c.f63576a;
        dVar.a(c.a.a(this.m), str2, "", str, ab.f61496a, "", "");
    }

    public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
        o();
        if (iJRPaytmDataModel == null) {
            finish();
        } else if (iJRPaytmDataModel instanceof CJRMetroStationListResponse) {
            this.f63213h = ((CJRMetroStationListResponse) iJRPaytmDataModel).getStations();
            a(this.f63213h, this.f63212g, this.f63207a, getString(R.string.metro_origin_station), this.o, this.l);
        }
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        o();
        if (!(iJRPaytmDataModel instanceof CJRMetroStationListResponse)) {
            Toast.makeText(this, R.string.network_error_heading_re, 0).show();
            finish();
        } else if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
            CJRRechargeUtilities.INSTANCE.handleError(str, this, (Fragment) null, networkCustomError, true, 103, obj);
        } else {
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
            finish();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 103) {
            if (i3 != 0) {
                b();
            } else {
                ay ayVar = ay.f61523a;
                ay.a(103);
            }
            ay ayVar2 = ay.f61523a;
            ay.a(false);
        }
    }
}
