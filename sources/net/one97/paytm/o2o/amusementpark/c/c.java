package net.one97.paytm.o2o.amusementpark.c;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.e;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.h;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRSelectCitiesModel;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkModel;
import net.one97.paytm.common.entity.recharge.v2.CJRUtilityLocationModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRHomePageLayoutV2;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.a.e;
import net.one97.paytm.o2o.amusementpark.activity.AJRAmParkDetailPage;
import net.one97.paytm.o2o.amusementpark.activity.AJRAmParkSearchPage;
import net.one97.paytm.o2o.amusementpark.activity.AJRAmParkSelectCityActivity;
import net.one97.paytm.o2o.amusementpark.activity.AmParkVerticalActivity;
import net.one97.paytm.o2o.amusementpark.d.g;
import net.one97.paytm.o2o.amusementpark.utils.b;
import net.one97.paytm.o2o.amusementpark.utils.f;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends d implements View.OnClickListener, e.b, e.c, e.d, AmParkVerticalActivity.a, f.b {

    /* renamed from: c  reason: collision with root package name */
    private static final String f73536c = c.class.getSimpleName();
    /* access modifiers changed from: private */
    public boolean A = false;
    private RoboTextView B;
    private String C;
    private RelativeLayout D;
    private ImageView E;
    private RelativeLayout F;
    private g G;
    private ImageView H;

    /* renamed from: a  reason: collision with root package name */
    ArrayList<CJRAmParkDetailModel> f73537a;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f73538d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.gms.common.api.e f73539e;

    /* renamed from: f  reason: collision with root package name */
    private String f73540f = null;

    /* renamed from: g  reason: collision with root package name */
    private CJRSelectCitiesModel f73541g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public CJRSelectCityModel f73542h = null;

    /* renamed from: i  reason: collision with root package name */
    private TextView f73543i;
    private LinearLayout j;
    private CJRAmParkModel k = null;
    private ImageView l;
    private ImageView m;
    private RelativeLayout n;
    /* access modifiers changed from: private */
    public CJRSelectCityModel o = null;
    private net.one97.paytm.o2o.amusementpark.a.c p = null;
    private RecyclerView q;
    private net.one97.paytm.o2o.amusementpark.a.e r;
    private ArrayList<CJRHomePageItem> s;
    private String t = null;
    private String u = null;
    private String v = null;
    private String w = null;
    private String x = null;
    /* access modifiers changed from: private */
    public b y;
    private f z;

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0158 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
            r9 = this;
            java.lang.String r0 = "city_extra_item"
            java.lang.String r1 = "extra_home_data"
            super.onCreate(r10)
            net.one97.paytm.o2o.amusementpark.utils.b r10 = new net.one97.paytm.o2o.amusementpark.utils.b
            androidx.fragment.app.FragmentActivity r2 = r9.getActivity()
            r10.<init>(r2, r9)
            r9.y = r10
            android.os.Bundle r10 = r9.getArguments()
            if (r10 == 0) goto L_0x002e
            android.os.Bundle r10 = r9.getArguments()
            java.lang.String r2 = "url_type"
            boolean r10 = r10.containsKey(r2)
            if (r10 == 0) goto L_0x002e
            android.os.Bundle r10 = r9.getArguments()
            java.lang.String r10 = r10.getString(r2)
            r9.C = r10
        L_0x002e:
            android.os.Bundle r10 = r9.getArguments()     // Catch:{ Exception -> 0x0158 }
            java.lang.String r2 = "ampark"
            if (r10 == 0) goto L_0x012f
            android.os.Bundle r10 = r9.getArguments()     // Catch:{ Exception -> 0x0158 }
            boolean r10 = r10.containsKey(r1)     // Catch:{ Exception -> 0x0158 }
            if (r10 == 0) goto L_0x012f
            android.os.Bundle r10 = r9.getArguments()     // Catch:{ Exception -> 0x0158 }
            java.io.Serializable r10 = r10.getSerializable(r1)     // Catch:{ Exception -> 0x0158 }
            boolean r10 = r10 instanceof net.one97.paytm.common.entity.shopping.CJRHomePageItem     // Catch:{ Exception -> 0x0158 }
            if (r10 == 0) goto L_0x012f
            android.os.Bundle r10 = r9.getArguments()     // Catch:{ Exception -> 0x0158 }
            java.io.Serializable r10 = r10.getSerializable(r1)     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.shopping.CJRHomePageItem r10 = (net.one97.paytm.common.entity.shopping.CJRHomePageItem) r10     // Catch:{ Exception -> 0x0158 }
            if (r10 == 0) goto L_0x012f
            java.lang.String r1 = r10.getmParkName()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x0068
            java.lang.String r1 = r10.getmParkName()     // Catch:{ Exception -> 0x0158 }
            r9.t = r1     // Catch:{ Exception -> 0x0158 }
        L_0x0068:
            java.lang.String r1 = r10.getmParkId()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x0078
            java.lang.String r1 = r10.getmParkId()     // Catch:{ Exception -> 0x0158 }
            r9.u = r1     // Catch:{ Exception -> 0x0158 }
        L_0x0078:
            java.lang.String r1 = r10.getmParkCategory()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x0088
            java.lang.String r1 = r10.getmParkCategory()     // Catch:{ Exception -> 0x0158 }
            r9.v = r1     // Catch:{ Exception -> 0x0158 }
        L_0x0088:
            java.lang.String r1 = r10.getmParkCityName()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x00b6
            java.lang.String r1 = r10.getmParkCityName()     // Catch:{ Exception -> 0x0158 }
            r9.w = r1     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r1 = new net.one97.paytm.common.entity.CJRSelectCityModel     // Catch:{ Exception -> 0x0158 }
            r1.<init>()     // Catch:{ Exception -> 0x0158 }
            r9.f73542h = r1     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r1 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            java.lang.String r3 = r9.w     // Catch:{ Exception -> 0x0158 }
            r1.setValue(r3)     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r1 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            java.lang.String r3 = r9.w     // Catch:{ Exception -> 0x0158 }
            r1.setlabel(r3)     // Catch:{ Exception -> 0x0158 }
            androidx.fragment.app.FragmentActivity r1 = r9.getActivity()     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r3 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.o2o.amusementpark.f.b.a(r1, r3, r2)     // Catch:{ Exception -> 0x0158 }
        L_0x00b6:
            java.lang.String r1 = r10.getmParkProviderId()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x00c6
            java.lang.String r1 = r10.getmParkProviderId()     // Catch:{ Exception -> 0x0158 }
            r9.x = r1     // Catch:{ Exception -> 0x0158 }
        L_0x00c6:
            java.lang.String r1 = r9.t     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x00fd
            java.lang.String r1 = r9.v     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x00fd
            java.lang.String r1 = r9.w     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x00fd
            java.lang.String r1 = r9.x     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x00fd
            java.lang.String r1 = r9.u     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x00fd
            java.lang.String r4 = r9.v     // Catch:{ Exception -> 0x0158 }
            java.lang.String r5 = r9.t     // Catch:{ Exception -> 0x0158 }
            java.lang.String r6 = r9.x     // Catch:{ Exception -> 0x0158 }
            java.lang.String r7 = r9.w     // Catch:{ Exception -> 0x0158 }
            java.lang.String r8 = r9.u     // Catch:{ Exception -> 0x0158 }
            r3 = r9
            r3.a(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0158 }
            goto L_0x012f
        L_0x00fd:
            java.lang.String r1 = r10.getParkcityLabel()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x012f
            java.lang.String r1 = r10.getParkcityValue()     // Catch:{ Exception -> 0x0158 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0158 }
            if (r1 != 0) goto L_0x012f
            net.one97.paytm.common.entity.CJRSelectCityModel r1 = new net.one97.paytm.common.entity.CJRSelectCityModel     // Catch:{ Exception -> 0x0158 }
            r1.<init>()     // Catch:{ Exception -> 0x0158 }
            r9.f73542h = r1     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r1 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            java.lang.String r3 = r10.getParkcityLabel()     // Catch:{ Exception -> 0x0158 }
            r1.setValue(r3)     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r1 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            java.lang.String r10 = r10.getParkcityValue()     // Catch:{ Exception -> 0x0158 }
            r1.setlabel(r10)     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r10 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            r9.a((net.one97.paytm.common.entity.CJRSelectCityModel) r10)     // Catch:{ Exception -> 0x0158 }
        L_0x012f:
            android.os.Bundle r10 = r9.getArguments()     // Catch:{ Exception -> 0x0158 }
            if (r10 == 0) goto L_0x0158
            android.os.Bundle r10 = r9.getArguments()     // Catch:{ Exception -> 0x0158 }
            boolean r10 = r10.containsKey(r0)     // Catch:{ Exception -> 0x0158 }
            if (r10 == 0) goto L_0x0158
            net.one97.paytm.common.entity.CJRSelectCityModel r10 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            if (r10 != 0) goto L_0x014f
            android.os.Bundle r10 = r9.getArguments()     // Catch:{ Exception -> 0x0158 }
            android.os.Parcelable r10 = r10.getParcelable(r0)     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r10 = (net.one97.paytm.common.entity.CJRSelectCityModel) r10     // Catch:{ Exception -> 0x0158 }
            r9.f73542h = r10     // Catch:{ Exception -> 0x0158 }
        L_0x014f:
            androidx.fragment.app.FragmentActivity r10 = r9.getActivity()     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r9.f73542h     // Catch:{ Exception -> 0x0158 }
            net.one97.paytm.o2o.amusementpark.f.b.a(r10, r0, r2)     // Catch:{ Exception -> 0x0158 }
        L_0x0158:
            android.content.Context r10 = r9.getContext()     // Catch:{ Exception -> 0x0163 }
            r0 = 1
            java.lang.String r1 = ""
            net.one97.paytm.o2o.amusementpark.utils.k.a(r10, r0, r1)     // Catch:{ Exception -> 0x0163 }
            goto L_0x016b
        L_0x0163:
            r10 = move-exception
            boolean r0 = com.paytm.utility.b.v
            if (r0 == 0) goto L_0x016b
            r10.getMessage()
        L_0x016b:
            net.one97.paytm.o2o.amusementpark.c.c$1 r10 = new net.one97.paytm.o2o.amusementpark.c.c$1
            r10.<init>()
            r9.G = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.c.c.onCreate(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.park_home_fragment, (ViewGroup) null);
        this.F = (RelativeLayout) inflate.findViewById(R.id.no_park);
        this.D = (RelativeLayout) inflate.findViewById(R.id.events_home_fragment_progressbar);
        this.l = (ImageView) inflate.findViewById(R.id.back_arrow);
        this.l.setOnClickListener(this);
        this.q = (RecyclerView) inflate.findViewById(R.id.recycler_parent_container);
        this.f73543i = (TextView) inflate.findViewById(R.id.txtview_event_location);
        this.f73543i.setOnClickListener(this);
        this.j = (LinearLayout) inflate.findViewById(R.id.lineat_city_location);
        this.j.setOnClickListener(this);
        this.m = (ImageView) inflate.findViewById(R.id.location_img);
        this.m.setOnClickListener(this);
        this.n = (RelativeLayout) inflate.findViewById(R.id.event_search_icon_lyt);
        this.B = (RoboTextView) inflate.findViewById(R.id.event_search_txt);
        this.B.setText(R.string.amusement_park_home_search_hint);
        this.H = (ImageView) inflate.findViewById(R.id.iv_sort);
        this.H.setOnClickListener(this);
        this.E = (ImageView) inflate.findViewById(R.id.back_to_top);
        this.E.setOnClickListener(this);
        this.E.setVisibility(8);
        if (this.f73542h == null) {
            this.n.setClickable(false);
            this.n.setEnabled(false);
        }
        this.n.setOnClickListener(this);
        try {
            this.f73538d = (LinearLayout) inflate.findViewById(R.id.no_network);
            inflate.findViewById(R.id.network_retry_btn).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!com.paytm.utility.b.c((Context) c.this.getActivity())) {
                        return;
                    }
                    if (c.this.f73542h == null || TextUtils.isEmpty(c.this.f73542h.getValue())) {
                        c.this.f();
                        c.this.d();
                        return;
                    }
                    c.this.h();
                    c.this.y.a(c.this.f73542h, c.j());
                    c cVar = c.this;
                    cVar.c(cVar.f73542h.getValue());
                }
            });
            if (com.paytm.utility.b.c((Context) getActivity())) {
                this.f73538d.setVisibility(8);
            } else {
                this.f73538d.setVisibility(0);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.getMessage();
            }
        }
        if (!(this.o == null && this.f73542h == null) && !this.f73542h.getValue().toLowerCase().equalsIgnoreCase(StringSet.all)) {
            CJRSelectCityModel cJRSelectCityModel = this.f73542h;
            if (cJRSelectCityModel != null) {
                c(cJRSelectCityModel.getValue());
            } else {
                CJRSelectCityModel cJRSelectCityModel2 = this.o;
                if (cJRSelectCityModel2 != null) {
                    c(cJRSelectCityModel2.getValue());
                }
            }
            CJRSelectCitiesModel cJRSelectCitiesModel = this.f73541g;
            if (cJRSelectCitiesModel == null || cJRSelectCitiesModel.getCities() == null || this.f73541g.getCities().size() == 0) {
                e();
            }
        } else if (com.paytm.utility.b.O((Context) getActivity()) && com.paytm.utility.b.P((Context) getActivity())) {
            try {
                this.f73539e = new e.a(getActivity()).a((e.b) this).a((e.c) this).a((a<? extends a.d.C0127d>) com.google.android.gms.location.f.f11372a).a();
                if (this.f73539e != null) {
                    this.z = new f(getActivity(), getActivity(), this.f73539e, this);
                    if (this.f73542h == null) {
                        this.z.b();
                    } else {
                        e();
                    }
                }
            } catch (Exception e3) {
                if (com.paytm.utility.b.v) {
                    e3.getMessage();
                }
            }
        }
        f();
        if (getActivity() != null) {
            getActivity();
            AmParkVerticalActivity.a(this.q, (AmParkVerticalActivity.a) this);
        }
        return inflate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x009a A[Catch:{ Exception -> 0x0104 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a2 A[Catch:{ Exception -> 0x0104 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.lang.String r13) {
        /*
            r12 = this;
            net.one97.paytm.common.entity.CJRSelectCityModel r0 = r12.f73542h     // Catch:{ Exception -> 0x0104 }
            r1 = 1
            if (r0 == 0) goto L_0x001a
            android.widget.RelativeLayout r0 = r12.n     // Catch:{ Exception -> 0x0104 }
            r0.setClickable(r1)     // Catch:{ Exception -> 0x0104 }
            android.widget.RelativeLayout r0 = r12.n     // Catch:{ Exception -> 0x0104 }
            r0.setEnabled(r1)     // Catch:{ Exception -> 0x0104 }
            android.widget.TextView r0 = r12.f73543i     // Catch:{ Exception -> 0x0104 }
            net.one97.paytm.common.entity.CJRSelectCityModel r2 = r12.f73542h     // Catch:{ Exception -> 0x0104 }
            java.lang.String r2 = r2.getLabel()     // Catch:{ Exception -> 0x0104 }
            r0.setText(r2)     // Catch:{ Exception -> 0x0104 }
        L_0x001a:
            java.lang.String r0 = "All"
            if (r13 != 0) goto L_0x0020
            r2 = 0
            goto L_0x006a
        L_0x0020:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0104 }
            r2.<init>()     // Catch:{ Exception -> 0x0104 }
            boolean r3 = r13.equals(r0)     // Catch:{ Exception -> 0x0104 }
            if (r3 == 0) goto L_0x0032
            net.one97.paytm.common.entity.amPark.CJRAmParkModel r2 = r12.k     // Catch:{ Exception -> 0x0104 }
            java.util.ArrayList r2 = r2.getmParkDetailModelList()     // Catch:{ Exception -> 0x0104 }
            goto L_0x006a
        L_0x0032:
            net.one97.paytm.common.entity.amPark.CJRAmParkModel r3 = r12.k     // Catch:{ Exception -> 0x0104 }
            java.util.ArrayList r3 = r3.getmParkDetailModelList()     // Catch:{ Exception -> 0x0104 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ Exception -> 0x0104 }
        L_0x003c:
            boolean r4 = r3.hasNext()     // Catch:{ Exception -> 0x0104 }
            if (r4 == 0) goto L_0x006a
            java.lang.Object r4 = r3.next()     // Catch:{ Exception -> 0x0104 }
            net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel r4 = (net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel) r4     // Catch:{ Exception -> 0x0104 }
            java.util.ArrayList r5 = r4.getCategories()     // Catch:{ Exception -> 0x0104 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0104 }
        L_0x0050:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x0104 }
            if (r6 == 0) goto L_0x003c
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x0104 }
            net.one97.paytm.common.entity.amPark.CJRCategoriesDetailModel r6 = (net.one97.paytm.common.entity.amPark.CJRCategoriesDetailModel) r6     // Catch:{ Exception -> 0x0104 }
            java.lang.String r6 = r6.getCategory()     // Catch:{ Exception -> 0x0104 }
            boolean r6 = r6.equals(r13)     // Catch:{ Exception -> 0x0104 }
            if (r6 == 0) goto L_0x0050
            r2.add(r4)     // Catch:{ Exception -> 0x0104 }
            goto L_0x003c
        L_0x006a:
            r12.f73537a = r2     // Catch:{ Exception -> 0x0104 }
            java.util.ArrayList<net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel> r2 = r12.f73537a     // Catch:{ Exception -> 0x0104 }
            r3 = 8
            r4 = 0
            if (r2 == 0) goto L_0x0082
            java.util.ArrayList<net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel> r2 = r12.f73537a     // Catch:{ Exception -> 0x0104 }
            boolean r2 = r2.isEmpty()     // Catch:{ Exception -> 0x0104 }
            if (r2 == 0) goto L_0x007c
            goto L_0x0082
        L_0x007c:
            android.widget.RelativeLayout r2 = r12.F     // Catch:{ Exception -> 0x0104 }
            r2.setVisibility(r3)     // Catch:{ Exception -> 0x0104 }
            goto L_0x008e
        L_0x0082:
            android.widget.RelativeLayout r2 = r12.F     // Catch:{ Exception -> 0x0104 }
            r2.setVisibility(r4)     // Catch:{ Exception -> 0x0104 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0104 }
            r2.<init>()     // Catch:{ Exception -> 0x0104 }
            r12.f73537a = r2     // Catch:{ Exception -> 0x0104 }
        L_0x008e:
            net.one97.paytm.common.entity.amPark.CJRAmParkModel r2 = r12.k     // Catch:{ Exception -> 0x0104 }
            java.util.List r2 = r2.getmCategoryList()     // Catch:{ Exception -> 0x0104 }
            int r5 = r2.indexOf(r0)     // Catch:{ Exception -> 0x0104 }
            if (r5 <= 0) goto L_0x00a0
            r2.remove(r5)     // Catch:{ Exception -> 0x0104 }
            r2.add(r4, r0)     // Catch:{ Exception -> 0x0104 }
        L_0x00a0:
            if (r2 == 0) goto L_0x00ab
            boolean r0 = r2.isEmpty()     // Catch:{ Exception -> 0x0104 }
            if (r0 == 0) goto L_0x00a9
            goto L_0x00ab
        L_0x00a9:
            r7 = r2
            goto L_0x00b1
        L_0x00ab:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ Exception -> 0x0104 }
            r2.<init>()     // Catch:{ Exception -> 0x0104 }
            goto L_0x00a9
        L_0x00b1:
            androidx.recyclerview.widget.RecyclerView r0 = r12.q     // Catch:{ Exception -> 0x0104 }
            r0.setHasFixedSize(r1)     // Catch:{ Exception -> 0x0104 }
            androidx.recyclerview.widget.RecyclerView r0 = r12.q     // Catch:{ Exception -> 0x0104 }
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0104 }
            net.one97.paytm.o2o.amusementpark.a.e r0 = new net.one97.paytm.o2o.amusementpark.a.e     // Catch:{ Exception -> 0x0104 }
            androidx.fragment.app.FragmentActivity r6 = r12.getActivity()     // Catch:{ Exception -> 0x0104 }
            java.util.ArrayList<net.one97.paytm.common.entity.shopping.CJRHomePageItem> r8 = r12.s     // Catch:{ Exception -> 0x0104 }
            java.util.ArrayList<net.one97.paytm.common.entity.amPark.CJRAmParkDetailModel> r9 = r12.f73537a     // Catch:{ Exception -> 0x0104 }
            r5 = r0
            r10 = r12
            r11 = r13
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x0104 }
            r12.r = r0     // Catch:{ Exception -> 0x0104 }
            androidx.recyclerview.widget.LinearLayoutManager r13 = new androidx.recyclerview.widget.LinearLayoutManager     // Catch:{ Exception -> 0x0104 }
            androidx.fragment.app.FragmentActivity r0 = r12.getActivity()     // Catch:{ Exception -> 0x0104 }
            r13.<init>(r0)     // Catch:{ Exception -> 0x0104 }
            r13.setOrientation(r1)     // Catch:{ Exception -> 0x0104 }
            androidx.recyclerview.widget.RecyclerView r0 = r12.q     // Catch:{ Exception -> 0x0104 }
            r0.setLayoutManager(r13)     // Catch:{ Exception -> 0x0104 }
            androidx.recyclerview.widget.RecyclerView r13 = r12.q     // Catch:{ Exception -> 0x0104 }
            net.one97.paytm.o2o.amusementpark.a.e r0 = r12.r     // Catch:{ Exception -> 0x0104 }
            r13.setAdapter(r0)     // Catch:{ Exception -> 0x0104 }
            androidx.recyclerview.widget.RecyclerView r13 = r12.q     // Catch:{ Exception -> 0x0104 }
            r0 = 0
            r13.setAlpha(r0)     // Catch:{ Exception -> 0x0104 }
            androidx.recyclerview.widget.RecyclerView r13 = r12.q     // Catch:{ Exception -> 0x0104 }
            r13.setVisibility(r4)     // Catch:{ Exception -> 0x0104 }
            androidx.recyclerview.widget.RecyclerView r13 = r12.q     // Catch:{ Exception -> 0x0104 }
            android.view.ViewPropertyAnimator r13 = r13.animate()     // Catch:{ Exception -> 0x0104 }
            r0 = 1065353216(0x3f800000, float:1.0)
            android.view.ViewPropertyAnimator r13 = r13.alpha(r0)     // Catch:{ Exception -> 0x0104 }
            r0 = 500(0x1f4, double:2.47E-321)
            r13.setDuration(r0)     // Catch:{ Exception -> 0x0104 }
            r12.i()     // Catch:{ Exception -> 0x0104 }
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.c.c.b(java.lang.String):void");
    }

    public void onResume() {
        super.onResume();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        CJRHomePageV2 cJRHomePageV2;
        ArrayList<CJRHomePageLayoutV2> homePageLayoutList;
        CJRHomePageLayoutV2 cJRHomePageLayoutV2;
        i();
        if (iJRPaytmDataModel instanceof CJRAmParkModel) {
            if (getActivity() != null) {
                this.k = (CJRAmParkModel) iJRPaytmDataModel;
                CJRSelectCityModel cJRSelectCityModel = this.o;
                if (cJRSelectCityModel != null) {
                    this.f73542h = cJRSelectCityModel;
                    this.o = null;
                }
                b(this.k.getmActiveCategory());
            } else {
                return;
            }
        } else if (iJRPaytmDataModel instanceof CJRSelectCitiesModel) {
            this.f73541g = (CJRSelectCitiesModel) iJRPaytmDataModel;
            net.one97.paytm.o2o.amusementpark.utils.e.a(this.f73541g.getCities());
            CJRSelectCityModel cJRSelectCityModel2 = this.f73542h;
            if (cJRSelectCityModel2 == null || cJRSelectCityModel2.getValue().toLowerCase().equalsIgnoreCase(StringSet.all)) {
                c();
            }
        } else if (!(!(iJRPaytmDataModel instanceof CJRHomePageV2) || (cJRHomePageV2 = (CJRHomePageV2) iJRPaytmDataModel) == null || cJRHomePageV2.getmPage() == null || cJRHomePageV2.getmPage().size() <= 0 || (homePageLayoutList = cJRHomePageV2.getmPage().get(0).getHomePageLayoutList()) == null || homePageLayoutList.size() <= 0 || (cJRHomePageLayoutV2 = homePageLayoutList.get(0)) == null || cJRHomePageLayoutV2.getHomePageItemList() == null || cJRHomePageLayoutV2.getHomePageItemList().size() <= 0)) {
            this.s = cJRHomePageLayoutV2.getHomePageItemList();
            net.one97.paytm.o2o.amusementpark.a.e eVar = this.r;
            if (eVar != null) {
                eVar.f73111b = this.s;
                eVar.a(eVar.f73112c, eVar.f73115f);
                this.r.notifyDataSetChanged();
            }
        }
        super.onApiSuccess(iJRPaytmDataModel);
    }

    private void c() {
        if (this.f73542h == null) {
            this.f73542h = d(this.f73540f);
        }
        c(this.f73542h.getValue());
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 1) {
            if (i2 != 2 && i2 == 115) {
                h();
                if (i3 == -1) {
                    f fVar = this.z;
                    if (fVar != null) {
                        fVar.a();
                    }
                } else if (i3 == 0) {
                    e();
                }
            }
        } else if (intent != null) {
            try {
                if (intent.hasExtra("userselectedcity")) {
                    h();
                    this.o = (CJRSelectCityModel) intent.getSerializableExtra("userselectedcity");
                    net.one97.paytm.o2o.amusementpark.f.b.a(getActivity(), this.o, "ampark");
                    this.f73542h = this.o;
                    this.k = null;
                    if (com.paytm.utility.b.c((Context) getActivity())) {
                        this.y.a(this.f73542h, j());
                        c(this.o.getValue());
                        return;
                    }
                    i();
                    this.f73538d.setVisibility(0);
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.getMessage();
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        i();
        if (getActivity() != null && !getActivity().isFinishing()) {
            if (networkCustomError != null) {
                try {
                    this.o = null;
                    String message = networkCustomError.getMessage();
                    if ((networkCustomError.getAlertTitle() != null && networkCustomError.getAlertMessage() != null) || (message != null && message.equalsIgnoreCase("417"))) {
                        String string = getActivity().getResources().getString(R.string.no_park_found_in_this_city);
                        if (!this.A && getActivity() != null && !getActivity().isFinishing()) {
                            final h hVar = new h(getActivity());
                            hVar.setTitle((CharSequence) null);
                            hVar.a(string);
                            hVar.setCancelable(false);
                            WindowManager.LayoutParams a2 = a((Dialog) hVar);
                            hVar.a(-1, getActivity().getString(R.string.ok), new View.OnClickListener() {
                                public final void onClick(View view) {
                                    hVar.cancel();
                                    boolean unused = c.this.A = false;
                                    c.this.g();
                                }
                            });
                            hVar.show();
                            if (a2 != null) {
                                hVar.getWindow().setAttributes(a2);
                            }
                            this.A = true;
                        }
                    } else if (networkCustomError.getMessage() == null || !networkCustomError.getMessage().equalsIgnoreCase("parsing_error")) {
                        com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.network_error_heading), getResources().getString(R.string.network_error_message) + " " + networkCustomError.getUrl());
                    } else {
                        com.paytm.utility.b.d((Context) getActivity(), networkCustomError.getUrl(), String.valueOf(networkCustomError.networkResponse.statusCode));
                    }
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.getMessage();
                    }
                }
            }
            super.handleErrorCode(i2, iJRPaytmDataModel, networkCustomError);
        }
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        try {
            if (getActivity() != null) {
                if (this.k != null && this.k.getmParkDetailModelList().size() > 0) {
                    b(this.k.getmActiveCategory());
                } else if (com.paytm.utility.b.c((Context) getActivity())) {
                    b(false);
                    h();
                    this.y.a(str, j(), "");
                } else {
                    i();
                    b(true);
                }
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.getMessage();
            }
        }
    }

    private void b(boolean z2) {
        LinearLayout linearLayout = this.f73538d;
        if (linearLayout == null) {
            return;
        }
        if (z2) {
            i();
            this.f73538d.setVisibility(0);
            return;
        }
        linearLayout.setVisibility(8);
    }

    public void onStart() {
        super.onStart();
        try {
            if (this.f73539e != null && !this.f73539e.f()) {
                this.f73539e.d();
            }
            if (getActivity() != null) {
                net.one97.paytm.o2o.amusementpark.a.a().handlePlayServicesError(getActivity());
            }
            e.C1472e eVar = (e.C1472e) this.q.getChildViewHolder(this.q.getChildAt(0));
            if (eVar != null && eVar.f73131g != null && eVar.f73130f != null) {
                eVar.f73131g.postDelayed(eVar.f73130f, eVar.f73126b);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.getMessage();
            }
        }
    }

    public void onStop() {
        super.onStop();
        i();
        try {
            if (this.f73539e != null && this.f73539e.f()) {
                this.f73539e.e();
            }
            e.C1472e eVar = (e.C1472e) this.q.getChildViewHolder(this.q.getChildAt(0));
            if (eVar != null && eVar.f73131g != null && eVar.f73130f != null) {
                eVar.f73131g.removeCallbacks(eVar.f73130f);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.getMessage();
            }
        }
    }

    public void onConnected(Bundle bundle) {
        if (this.k == null) {
            d();
        }
    }

    public void onConnectionSuspended(int i2) {
        try {
            if (this.f73539e != null) {
                this.f73539e.d();
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.b(e2.getMessage());
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        if (this.k == null) {
            d();
        }
    }

    public final void a() {
        i();
        d();
    }

    public final void a(CJRUtilityLocationModel cJRUtilityLocationModel) {
        if (cJRUtilityLocationModel == null) {
            getActivity().getResources().getString(R.string.no_gps);
        } else if (cJRUtilityLocationModel != null && !TextUtils.isEmpty(cJRUtilityLocationModel.getCity())) {
            this.f73540f = cJRUtilityLocationModel.getCity();
            d();
        }
        new StringBuilder("Current location is ").append(this.f73540f);
        e();
    }

    /* access modifiers changed from: private */
    public void d() {
        h();
        if (this.f73542h == null) {
            g();
        } else {
            c();
        }
        if (net.one97.paytm.o2o.amusementpark.utils.e.f73650a == null || net.one97.paytm.o2o.amusementpark.utils.e.f73650a.size() == 0) {
            e();
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.back_arrow) {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        } else if (view.getId() == R.id.event_search_icon_lyt) {
            ArrayList<CJRAmParkDetailModel> arrayList = this.f73537a;
            if (arrayList == null || arrayList.isEmpty()) {
                Toast.makeText(getActivity(), R.string.no_parks_desc, 0).show();
            } else if (this.f73542h != null) {
                Intent intent = new Intent(getActivity(), AJRAmParkSearchPage.class);
                intent.putExtra("userselectedcity", this.f73542h.getValue());
                startActivityForResult(intent, 2);
            }
        } else if (view.getId() == R.id.location_img || view.getId() == R.id.txtview_event_location || view.getId() == R.id.lineat_city_location) {
            Intent intent2 = new Intent(getActivity(), AJRAmParkSelectCityActivity.class);
            intent2.putExtra("userselectedcity", this.f73542h);
            CJRSelectCityModel cJRSelectCityModel = this.f73542h;
            if (cJRSelectCityModel != null) {
                intent2.putExtra("usercurrentcity", cJRSelectCityModel.getValue());
            }
            intent2.putExtra("sourcename", this.C);
            startActivityForResult(intent2, 1);
        } else if (view.getId() == R.id.back_to_top) {
            RecyclerView recyclerView = this.q;
            if (recyclerView != null) {
                recyclerView.smoothScrollToPosition(0);
            }
            this.E.setVisibility(8);
        } else if (view.getId() == R.id.iv_sort) {
            new f(this.G).show(getFragmentManager(), "");
        }
    }

    public final void a(String str) {
        try {
            h();
            if (this.p != null) {
                net.one97.paytm.o2o.amusementpark.a.c cVar = this.p;
                cVar.f73088b = str;
                cVar.notifyDataSetChanged();
            }
            if (!TextUtils.isEmpty(str) && this.f73537a != null) {
                this.r.a(this.f73537a, str);
            }
            i();
        } catch (Exception unused) {
        }
    }

    public final void a(String str, String str2, String str3, String str4) {
        Intent intent = new Intent(getActivity(), AJRAmParkDetailPage.class);
        intent.putExtra("userselectedcity", this.f73542h.getValue());
        intent.putExtra("selectedcategoryname", str);
        intent.putExtra("selectedevent", str2);
        intent.putExtra("selectedeventproviderid", str3);
        intent.putExtra("selectedeventid", str4);
        startActivity(intent);
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel, int i2, String str) {
        String uRLType;
        try {
            if (iJRPaytmDataModel instanceof CJRHomePageItem) {
                CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) iJRPaytmDataModel;
                CJRHomePageItem cJRHomePageItem2 = new CJRHomePageItem();
                cJRHomePageItem2.setParentItem(str);
                cJRHomePageItem2.setUrl(cJRHomePageItem.getURL());
                cJRHomePageItem2.setItemID(cJRHomePageItem.getItemID());
                cJRHomePageItem2.setName(cJRHomePageItem.getName());
                try {
                    net.one97.paytm.o2o.amusementpark.a.b().sendPromotionClick(cJRHomePageItem2, getActivity(), i2, "", "/amusement-parks");
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        e2.getMessage();
                    }
                }
                if (cJRHomePageItem != null) {
                    String url = cJRHomePageItem.getURL();
                    if (!TextUtils.isEmpty(url) && url.startsWith("paytmmp://")) {
                        a(cJRHomePageItem.getURLType(), iJRPaytmDataModel, "");
                    } else if (Patterns.WEB_URL.matcher(url).matches() && (uRLType = cJRHomePageItem.getURLType()) != null && !TextUtils.isEmpty(uRLType) && uRLType.equalsIgnoreCase(CLPConstants.URL_TYPE_EMBED) && url != null && URLUtil.isValidUrl(url)) {
                        a(cJRHomePageItem.getURLType(), iJRPaytmDataModel, CLPConstants.GA_CHANNEL_NAME);
                    }
                }
            }
        } catch (Exception e3) {
            e3.getMessage();
        }
    }

    private void e() {
        try {
            if (getActivity() != null) {
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    b(false);
                    this.y.a(j());
                    return;
                }
                b(true);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.getMessage();
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        try {
            if (getActivity() != null) {
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    b(false);
                    h();
                    this.y.a(this.f73542h, j());
                    return;
                }
                b(true);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.getMessage();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private net.one97.paytm.common.entity.CJRSelectCityModel d(java.lang.String r4) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x002d
            net.one97.paytm.common.entity.CJRSelectCitiesModel r0 = r3.f73541g
            java.util.ArrayList r0 = r0.getCities()
            java.util.Iterator r0 = r0.iterator()
        L_0x000c:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002d
            java.lang.Object r1 = r0.next()
            net.one97.paytm.common.entity.CJRSelectCityModel r1 = (net.one97.paytm.common.entity.CJRSelectCityModel) r1
            java.lang.String r2 = r1.getLabel()
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = r1.getValue()
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x000c
        L_0x002c:
            return r1
        L_0x002d:
            net.one97.paytm.common.entity.CJRSelectCityModel r4 = net.one97.paytm.o2o.amusementpark.utils.e.a((java.lang.String) r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.c.c.d(java.lang.String):net.one97.paytm.common.entity.CJRSelectCityModel");
    }

    public final void a(boolean z2) {
        if (z2) {
            this.E.setVisibility(0);
        } else {
            this.E.setVisibility(8);
        }
    }

    public final void a(CJRHomePageItem cJRHomePageItem) {
        String str;
        if (cJRHomePageItem != null) {
            CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
            String str2 = null;
            String str3 = !TextUtils.isEmpty(cJRHomePageItem.getmParkName()) ? cJRHomePageItem.getmParkName() : null;
            String str4 = !TextUtils.isEmpty(cJRHomePageItem.getmParkId()) ? cJRHomePageItem.getmParkId() : null;
            String str5 = !TextUtils.isEmpty(cJRHomePageItem.getmParkCategory()) ? cJRHomePageItem.getmParkCategory() : null;
            if (!TextUtils.isEmpty(cJRHomePageItem.getmParkCityName())) {
                String str6 = cJRHomePageItem.getmParkCityName();
                cJRSelectCityModel.setValue(str6);
                cJRSelectCityModel.setlabel(str6);
                str = str6;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(cJRHomePageItem.getmParkProviderId())) {
                str2 = cJRHomePageItem.getmParkProviderId();
            }
            String str7 = str2;
            if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str)) {
                a(str5, str3, str7, str, str4);
            } else if (!TextUtils.isEmpty(cJRHomePageItem.getParkcityValue()) && !TextUtils.isEmpty(cJRHomePageItem.getParkcityLabel())) {
                cJRSelectCityModel.setValue(cJRHomePageItem.getParkcityValue());
                cJRSelectCityModel.setlabel(cJRHomePageItem.getParkcityLabel());
                a(cJRSelectCityModel);
            }
        }
    }

    public final void a(String str, String str2, String str3, String str4, String str5) {
        Intent intent = new Intent(getActivity(), AJRAmParkDetailPage.class);
        intent.putExtra("userselectedcity", str4);
        intent.putExtra("selectedcategoryname", str);
        intent.putExtra("selectedevent", str2);
        intent.putExtra("selectedeventproviderid", str3);
        intent.putExtra("selectedeventid", str5);
        startActivity(intent);
    }

    public final void a(CJRSelectCityModel cJRSelectCityModel) {
        if (cJRSelectCityModel != null) {
            this.f73542h = cJRSelectCityModel;
            net.one97.paytm.o2o.amusementpark.f.b.a(getActivity(), this.f73542h, "ampark");
        }
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        h();
        if (i2 == 57) {
            if (s.a(iArr)) {
                this.z.b();
            } else {
                e();
            }
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    /* access modifiers changed from: private */
    public void g() {
        this.o = new CJRSelectCityModel();
        this.o.setValue(StringSet.all);
        this.o.setlabel("All Cities");
        this.o.setLatitude("");
        this.o.setLongitude("");
        net.one97.paytm.o2o.amusementpark.f.b.a(getActivity(), this.o, "ampark");
        c(this.o.getValue());
    }

    private static WindowManager.LayoutParams a(Dialog dialog) {
        WindowManager.LayoutParams layoutParams;
        try {
            layoutParams = new WindowManager.LayoutParams();
            try {
                layoutParams.copyFrom(dialog.getWindow().getAttributes());
                layoutParams.width = -1;
                layoutParams.height = -2;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            layoutParams = null;
            q.b(e.getMessage());
            return layoutParams;
        }
        return layoutParams;
    }

    /* access modifiers changed from: private */
    public void h() {
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(0);
        }
    }

    private void i() {
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public static JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "FJRAmParkHomeFragment");
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2) {
        try {
            if (getActivity() != null) {
                if (com.paytm.utility.b.c((Context) getActivity())) {
                    b(false);
                    h();
                    this.y.a(str, j(), str2);
                    return;
                }
                i();
                b(true);
            }
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                e2.getMessage();
            }
        }
    }

    static /* synthetic */ void a(c cVar, String str) {
        cVar.o = new CJRSelectCityModel();
        cVar.o.setValue(StringSet.all);
        cVar.o.setlabel("All Cities");
        cVar.o.setLatitude("");
        cVar.o.setLongitude("");
        net.one97.paytm.o2o.amusementpark.f.b.a(cVar.getActivity(), cVar.o, "ampark");
        cVar.a(cVar.o.getValue(), str);
    }
}
