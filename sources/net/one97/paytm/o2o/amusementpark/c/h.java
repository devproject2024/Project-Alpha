package net.one97.paytm.o2o.amusementpark.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.contactsSdk.database.ContactColumn;
import com.paytm.network.a;
import com.sendbird.android.constant.StringSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.one97.paytm.common.entity.amPark.AmParkInputForm;
import net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel;
import net.one97.paytm.common.entity.amPark.CJRAddressDetailModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;
import net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel;
import net.one97.paytm.common.entity.amPark.CJRPromoValidateResponseModel;
import net.one97.paytm.common.entity.amPark.CJRPromoValidateStaticResponseModel;
import net.one97.paytm.common.entity.amPark.CJRSeatDetailsModel;
import net.one97.paytm.common.entity.amPark.CJRValidatePackage;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.o2o.amusementpark.R;
import net.one97.paytm.o2o.amusementpark.activity.AJRAmParkBookActivity;
import net.one97.paytm.o2o.amusementpark.c.a.a;
import net.one97.paytm.o2o.amusementpark.c.a.b;
import net.one97.paytm.o2o.amusementpark.c.a.c;
import net.one97.paytm.o2o.amusementpark.c.a.d;
import net.one97.paytm.o2o.amusementpark.c.a.f;
import net.one97.paytm.o2o.amusementpark.c.a.g;
import net.one97.paytm.o2o.amusementpark.c.g;
import net.one97.paytm.o2o.amusementpark.d.i;
import net.one97.paytm.o2o.amusementpark.d.j;
import net.one97.paytm.o2o.amusementpark.d.k;
import net.one97.paytm.recharge.domain.entities.CJRAutomaticSubscriptionHistory;
import org.json.JSONException;
import org.json.JSONObject;

public class h extends net.one97.paytm.i.h implements a.C1473a, b.a, c.a, d.a, f.b, g.a, g.b, i.a, k {
    private Fragment A;
    private Fragment B;
    private net.one97.paytm.o2o.amusementpark.e.c C = new net.one97.paytm.o2o.amusementpark.e.c();
    private boolean D;
    private AmParkTravellerResponseModel E;
    private CJRParticularAmParkDescriptionModel F;
    /* access modifiers changed from: private */
    public boolean G;
    private int H;
    private FrameLayout I;
    private LinearLayout J;
    private Handler K = new Handler() {
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            if (!h.this.isDetached()) {
                switch (message.what) {
                    case 1:
                        h.this.n();
                        return;
                    case 2:
                        h hVar = h.this;
                        hVar.a(hVar.G);
                        return;
                    case 3:
                        h.l();
                        h.this.o();
                        return;
                    case 4:
                        h.this.q();
                        return;
                    case 5:
                        h.e(h.this);
                        h.this.t();
                        return;
                    case 6:
                        h.h(h.this);
                        return;
                    case 7:
                        h.i(h.this);
                        return;
                    case 8:
                        h.e(h.this);
                        h.this.s();
                        return;
                    default:
                        return;
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    ViewTreeObserver.OnGlobalLayoutListener f73577a;

    /* renamed from: b  reason: collision with root package name */
    public String f73578b;

    /* renamed from: c  reason: collision with root package name */
    public CJRAmParkDateTimeModel.Time f73579c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f73580d;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f73581e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f73582f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f73583g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f73584h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f73585i = false;
    /* access modifiers changed from: private */
    public boolean j = false;
    private FrameLayout k;
    /* access modifiers changed from: private */
    public FrameLayout l;
    private net.one97.paytm.o2o.amusementpark.c.a.g m;
    private c n;
    private g o;
    private b p;
    private f q;
    private d r;
    private a s;
    private NestedScrollView t;
    private CJRAddressDetailModel u;
    private Bundle v;
    private List<CJRSeatDetailsModel> w;
    private List<CJRSeatDetailsModel> x;
    private j y;
    private Fragment z;

    static /* synthetic */ void l() {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.park_booking_summary, viewGroup, false);
        this.k = (FrameLayout) inflate.findViewById(R.id.events_booking_summary_package_details_frame_layout);
        this.l = (FrameLayout) inflate.findViewById(R.id.events_booking_summary_venue_details_frame_layout);
        if (c("device_height") == 0) {
            b("device_height", getActivity().getWindowManager().getDefaultDisplay().getHeight());
        }
        this.f73577a = new ViewTreeObserver.OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                h.b(StringSet.height, h.this.l.getHeight());
            }
        };
        this.l.getViewTreeObserver().addOnGlobalLayoutListener(this.f73577a);
        if (this.C == null) {
            this.C = new net.one97.paytm.o2o.amusementpark.e.c();
        }
        net.one97.paytm.o2o.amusementpark.e.c cVar = this.C;
        Context context = getContext();
        j jVar = this.y;
        cVar.f73620b = this;
        cVar.f73619a = context;
        cVar.f73622d = jVar;
        b(getArguments());
        getActivity().getWindow().setSoftInputMode(3);
        this.t = (NestedScrollView) inflate.findViewById(R.id.event_book_container_scroll_view);
        this.I = (FrameLayout) inflate.findViewById(R.id.fragment_park_booking_page);
        this.J = (LinearLayout) inflate.findViewById(R.id.book_summary_main_view);
        return inflate;
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f73582f = true;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (Build.VERSION.SDK_INT < 16) {
            this.l.getViewTreeObserver().removeGlobalOnLayoutListener(this.f73577a);
        } else {
            this.l.getViewTreeObserver().removeOnGlobalLayoutListener(this.f73577a);
        }
        net.one97.paytm.o2o.amusementpark.e.c cVar = this.C;
        if (cVar != null) {
            cVar.f73619a = null;
            this.C = null;
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.y = (j) activity;
    }

    public void onResume() {
        g gVar;
        super.onResume();
        j jVar = this.y;
        if (jVar != null) {
            jVar.e();
        }
        int i2 = 0;
        this.f73582f = false;
        if (this.f73580d) {
            b(this.f73581e);
            Fragment fragment = this.z;
            if (fragment == null) {
                m();
            } else if (fragment == this.m) {
                getActivity().getSupportFragmentManager().a().a((Fragment) this.m).c();
                this.m = null;
                a(this.G);
            } else {
                c cVar = this.n;
                if (fragment == cVar) {
                    a((Fragment) cVar);
                    getActivity().getSupportFragmentManager().a().a((Fragment) this.n).c();
                    this.n = null;
                    n();
                }
            }
            Fragment fragment2 = this.A;
            if (fragment2 != null && fragment2 == (gVar = this.o)) {
                if (!gVar.f73564b) {
                    a((Fragment) this.o);
                }
                if (this.o != null) {
                    getActivity().getSupportFragmentManager().a().a((Fragment) this.o).c();
                    this.o = null;
                }
                q();
            }
            if (this.B != null) {
                int i3 = -1;
                List<CJRSeatDetailsModel> list = this.x;
                if (list != null) {
                    int i4 = 0;
                    for (CJRSeatDetailsModel selectedQuantity : list) {
                        i4 += selectedQuantity.getSelectedQuantity();
                    }
                    i3 = i4;
                }
                AmParkTravellerResponseModel amParkTravellerResponseModel = this.E;
                if (!(amParkTravellerResponseModel == null || amParkTravellerResponseModel.getForm() == null || this.E.getForm().size() <= 0)) {
                    i2 = this.E.getForm().size();
                }
                if (i2 == 0 || i3 == 0 || i2 == i3) {
                    Fragment fragment3 = this.B;
                    if (fragment3 != this.q && fragment3 != this.r) {
                        b bVar = this.p;
                        if (fragment3 == bVar) {
                            a((Fragment) bVar);
                            if (this.p != null) {
                                getActivity().getSupportFragmentManager().a().a((Fragment) this.p).c();
                                this.p = null;
                            }
                        }
                    } else if (this.H > 1 && this.q != null) {
                        getActivity().getSupportFragmentManager().a().a((Fragment) this.q).c();
                        this.q = null;
                        s();
                    } else if (this.r != null) {
                        getActivity().getSupportFragmentManager().a().a((Fragment) this.r).c();
                        this.r = null;
                        t();
                    }
                }
            }
        } else {
            m();
        }
    }

    private void a(Fragment fragment) {
        if (fragment != null && !this.f73582f) {
            c cVar = this.n;
            if (!(cVar == null || cVar == fragment || this.f73584h)) {
                getActivity().getSupportFragmentManager().a().a((Fragment) this.n).c();
                this.n = null;
                a(this.G);
            }
            g gVar = this.o;
            if (!(gVar == null || gVar == fragment)) {
                if (p() > 0) {
                    getActivity().getSupportFragmentManager().a().a((Fragment) this.o).c();
                    this.o = null;
                }
                o();
            }
            b bVar = this.p;
            if (!(bVar == null || bVar == fragment)) {
                getActivity().getSupportFragmentManager().a().a((Fragment) this.p).c();
                this.p = null;
                t();
            }
            d dVar = this.r;
            if (dVar != null && dVar != fragment) {
                getActivity().getSupportFragmentManager().a().a((Fragment) this.r).c();
                this.r = null;
                t();
            }
        }
    }

    private void b(Bundle bundle) {
        if (bundle != null) {
            this.u = (CJRAddressDetailModel) bundle.getSerializable("event-seat-selection-fragment-key-venue-model");
            this.f73578b = bundle.getString("event-seat-selection-fragment-key-date");
            this.f73579c = (CJRAmParkDateTimeModel.Time) bundle.getSerializable("event-seat-selection-fragment-key-time-model");
            this.w = (List) bundle.getSerializable("event-seat-selection-fragment-key-seat-list");
            this.F = (CJRParticularAmParkDescriptionModel) bundle.getSerializable("event-address-list");
            this.v = bundle;
            this.G = bundle.getBoolean("is-single-venue-and-date-and-time", false);
            a(this.F);
        }
    }

    private void m() {
        if (this.z != null) {
            return;
        }
        if (this.G) {
            a(true);
            q();
            return;
        }
        n();
    }

    /* access modifiers changed from: private */
    public void a(boolean z2) {
        if (!this.f73582f) {
            Bundle bundle = new Bundle();
            if (this.u != null) {
                bundle.putString("title", this.F.getName());
            }
            bundle.putString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, this.f73578b);
            bundle.putSerializable("time", this.f73579c);
            bundle.putBoolean("is-single-venue-and-date-and-time", z2);
            bundle.putString("category", this.F.getCategories().get(0).getCategory());
            if (this.z != null) {
                getActivity().getSupportFragmentManager().a().a(this.z);
                this.z = null;
            }
            this.m = new net.one97.paytm.o2o.amusementpark.c.a.g();
            net.one97.paytm.o2o.amusementpark.c.a.g gVar = this.m;
            if (gVar != null) {
                gVar.f73525a = this;
                gVar.setArguments(bundle);
                getActivity().getSupportFragmentManager().a().b(R.id.events_booking_summary_venue_details_frame_layout, this.m, (String) null).c();
                this.z = this.m;
            }
        }
    }

    /* access modifiers changed from: private */
    public void n() {
        if (!this.f73582f) {
            Fragment fragment = this.z;
            if (fragment == null || (fragment != null && fragment == this.n && !this.f73584h)) {
                g();
                return;
            }
            if (this.f73584h) {
                a((Fragment) this.n);
            }
            Bundle bundle = new Bundle();
            if (this.u != null) {
                bundle.putString("title", this.F.getName());
            }
            bundle.putString("category", this.F.getCategories().get(0).getCategory());
            bundle.putString(CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR, this.f73578b);
            bundle.putSerializable("time", this.f73579c);
            bundle.putBoolean("show_continue", this.f73584h);
            this.n = new c();
            c cVar = this.n;
            if (cVar != null) {
                cVar.f73488a = this;
                cVar.setArguments(bundle);
                getActivity().getSupportFragmentManager().a().b(R.id.events_booking_summary_venue_details_frame_layout, this.n, (String) null).c();
                this.z = this.n;
            }
        }
    }

    /* access modifiers changed from: private */
    public void o() {
        if (!this.f73582f && this.w != null && p() > 0) {
            Bundle bundle = new Bundle();
            if (this.A != null) {
                getActivity().getSupportFragmentManager().a().a(this.A);
                this.A = null;
            }
            List<CJRSeatDetailsModel> list = this.w;
            if (list != null) {
                bundle.putSerializable("event-seat-selection-fragment-key-seat-list", new ArrayList(list));
            }
            bundle.putString("title", this.F.getName());
            bundle.putString("category", this.F.getCategories().get(0).getCategory());
            bundle.putSerializable("seat-summay-state", "minimized");
            bundle.putString("park_id", this.F.getId());
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.height = -2;
            this.k.setLayoutParams(layoutParams);
            this.o = new g();
            g gVar = this.o;
            if (gVar != null) {
                gVar.f73563a = this;
                gVar.setArguments(bundle);
                getActivity().getSupportFragmentManager().a().b(R.id.events_booking_summary_package_details_frame_layout, this.o, (String) null).c();
                this.A = this.o;
            }
        }
    }

    private int p() {
        List<CJRSeatDetailsModel> list = this.w;
        int i2 = 0;
        if (list != null) {
            for (CJRSeatDetailsModel selectedQuantity : list) {
                if (selectedQuantity.getSelectedQuantity() > 0) {
                    i2++;
                }
            }
        }
        return i2;
    }

    /* access modifiers changed from: private */
    public void q() {
        if (!this.f73582f) {
            g gVar = this.o;
            if (gVar != null && !gVar.f73564b) {
                a((Fragment) this.o);
            }
            if (this.A != null) {
                getActivity().getSupportFragmentManager().a().a(this.A);
                this.A = null;
            }
            List<CJRSeatDetailsModel> list = this.x;
            if (list != null && list.size() > 0) {
                r();
            }
            Bundle bundle = new Bundle();
            List<CJRSeatDetailsModel> list2 = this.w;
            if (list2 != null) {
                bundle.putSerializable("event-seat-selection-fragment-key-seat-list", new ArrayList(list2));
            }
            bundle.putString("title", this.F.getName());
            bundle.putString("category", this.F.getCategories().get(0).getCategory());
            ViewGroup.LayoutParams layoutParams = this.k.getLayoutParams();
            layoutParams.height = (int) (((double) (c("device_height") - c(StringSet.height))) * 0.8d);
            this.k.setLayoutParams(layoutParams);
            this.o = new g();
            g gVar2 = this.o;
            if (gVar2 != null) {
                gVar2.setArguments(bundle);
                this.o.f73563a = this;
                getActivity().getSupportFragmentManager().a().b(R.id.events_booking_summary_package_details_frame_layout, this.o, (String) null).c();
                this.A = this.o;
            }
        }
    }

    private void r() {
        List<CJRSeatDetailsModel> list;
        List<CJRSeatDetailsModel> list2;
        HashSet hashSet = new HashSet(this.x);
        List<CJRSeatDetailsModel> list3 = this.w;
        boolean z2 = true;
        if (list3 != null && list3.size() > 0) {
            for (CJRSeatDetailsModel contains : this.w) {
                if (hashSet.contains(contains)) {
                    z2 = false;
                }
            }
        }
        if (z2 && (list2 = this.x) != null) {
            list2.clear();
        }
        if (!z2 && (list = this.x) != null && list.size() == 0) {
            for (CJRSeatDetailsModel next : this.w) {
                if (next.getSelectedQuantity() > 0) {
                    this.x.add(next);
                }
            }
        }
    }

    public final void c() {
        j jVar = this.y;
        if (jVar == null || !(jVar instanceof AJRAmParkBookActivity) || ((AJRAmParkBookActivity) jVar).f73294a == null || ((AJRAmParkBookActivity) this.y).f73294a.size() != 1) {
            Handler handler = this.K;
            if (handler != null) {
                handler.sendEmptyMessage(1);
                return;
            }
            return;
        }
        ((AJRAmParkBookActivity) this.y).a();
        this.z = this.n;
    }

    public final void d() {
        Handler handler = this.K;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
    }

    public final void a(List<CJRSeatDetailsModel> list) {
        if (!this.f73582f) {
            if (this.s != null) {
                getActivity().getSupportFragmentManager().a().a((Fragment) this.s).c();
                this.s = null;
            }
            if (this.B != null) {
                getActivity().getSupportFragmentManager().a().a(this.B).c();
                this.B = null;
            }
            this.x = list;
            Handler handler = this.K;
            if (handler != null) {
                handler.sendEmptyMessage(3);
            }
            net.one97.paytm.o2o.amusementpark.e.c cVar = this.C;
            if (list != null && list.size() != 0 && cVar.f73621c != null) {
                int i2 = 0;
                for (CJRSeatDetailsModel selectedQuantity : list) {
                    i2 += selectedQuantity.getSelectedQuantity();
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("providerId", cVar.f73621c.getProviderId());
                    jSONObject.put("entId", cVar.f73621c.getId());
                    jSONObject.put("ticketCount", i2);
                    jSONObject.put("providerEventId", cVar.f73621c.getProviderEventId());
                    jSONObject.put("seatInfo", net.one97.paytm.o2o.amusementpark.e.c.a(list));
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    String jSONObject2 = jSONObject.toString();
                    if (cVar.f73622d != null) {
                        cVar.f73622d.b(CJRAutomaticSubscriptionHistory.PROCESSING);
                    }
                    String u2 = com.paytm.utility.b.u(cVar.f73619a, com.paytm.utility.c.b(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("ampark_fetch_detail_url"), cVar.f73619a));
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = cVar.f73619a;
                    bVar.f42878b = a.c.AM_PARK;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.f42880d = u2;
                    bVar.f42881e = null;
                    bVar.f42882f = hashMap;
                    bVar.f42883g = null;
                    bVar.f42884h = jSONObject2;
                    bVar.f42885i = new AmParkTravellerResponseModel();
                    bVar.j = cVar;
                    bVar.n = a.b.USER_FACING;
                    bVar.o = "AmPark";
                    bVar.t = net.one97.paytm.o2o.amusementpark.e.c.a();
                    com.paytm.network.a l2 = bVar.l();
                    l2.f42859c = false;
                    l2.a();
                }
            }
        }
    }

    public final void b() {
        Handler handler = this.K;
        if (handler != null) {
            handler.sendEmptyMessage(4);
            if (this.B == this.q) {
                this.K.sendEmptyMessage(5);
            }
        }
    }

    public final void e() {
        j jVar = this.y;
        if (jVar != null) {
            jVar.f();
        }
    }

    public final void f() {
        j jVar = this.y;
        if (jVar != null) {
            jVar.g();
        }
    }

    public final void g() {
        this.f73584h = false;
        a(this.G);
        q();
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L_0x01d0
            java.util.ArrayList r0 = r8.getForm()
            if (r0 == 0) goto L_0x01d0
            java.util.ArrayList r0 = r8.getForm()
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0014
            goto L_0x01d0
        L_0x0014:
            boolean r0 = r7.f73582f
            if (r0 == 0) goto L_0x0019
            return
        L_0x0019:
            androidx.fragment.app.Fragment r0 = r7.B
            r1 = 0
            if (r0 == 0) goto L_0x0035
            androidx.fragment.app.FragmentActivity r0 = r7.getActivity()
            androidx.fragment.app.j r0 = r0.getSupportFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            androidx.fragment.app.Fragment r2 = r7.B
            androidx.fragment.app.q r0 = r0.a((androidx.fragment.app.Fragment) r2)
            r0.c()
            r7.B = r1
        L_0x0035:
            java.util.ArrayList r0 = r8.getForm()
            int r0 = r0.size()
            r7.H = r0
            r0 = 0
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r2 = r7.E     // Catch:{ Exception -> 0x00e9 }
            if (r2 == 0) goto L_0x00e6
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r2 = r7.E     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r2 = r2.getForm()     // Catch:{ Exception -> 0x00e9 }
            if (r2 == 0) goto L_0x00e6
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r2 = r7.E     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r2 = r2.getForm()     // Catch:{ Exception -> 0x00e9 }
            int r2 = r2.size()     // Catch:{ Exception -> 0x00e9 }
            if (r2 <= 0) goto L_0x00e6
            int r2 = r7.H     // Catch:{ Exception -> 0x00e9 }
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r3 = r7.E     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r3 = r3.getForm()     // Catch:{ Exception -> 0x00e9 }
            int r3 = r3.size()     // Catch:{ Exception -> 0x00e9 }
            if (r2 == r3) goto L_0x006a
            r7.E = r8     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00eb
        L_0x006a:
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r2 = r7.E     // Catch:{ Exception -> 0x00e9 }
            boolean r2 = d((net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel) r2)     // Catch:{ Exception -> 0x00e9 }
            if (r2 == 0) goto L_0x0076
            r7.E = r8     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00eb
        L_0x0076:
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r2 = r7.E     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x00e9 }
            r3.<init>()     // Catch:{ Exception -> 0x00e9 }
            int r4 = r2.getFlag()     // Catch:{ Exception -> 0x00e9 }
            r2.setFlag(r4)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r4 = r2.getProviderOid()     // Catch:{ Exception -> 0x00e9 }
            r2.setProviderOid(r4)     // Catch:{ Exception -> 0x00e9 }
            r4 = 0
        L_0x008c:
            java.util.ArrayList r5 = r8.getForm()     // Catch:{ Exception -> 0x00e9 }
            int r5 = r5.size()     // Catch:{ Exception -> 0x00e9 }
            if (r4 >= r5) goto L_0x00de
            java.util.ArrayList r5 = r2.getForm()     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ Exception -> 0x00e9 }
            net.one97.paytm.common.entity.amPark.AmParkInputForm r5 = (net.one97.paytm.common.entity.amPark.AmParkInputForm) r5     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r5 = r5.getTitle()     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r6 = r8.getForm()     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r6 = r6.get(r4)     // Catch:{ Exception -> 0x00e9 }
            java.util.ArrayList r6 = (java.util.ArrayList) r6     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x00e9 }
            net.one97.paytm.common.entity.amPark.AmParkInputForm r6 = (net.one97.paytm.common.entity.amPark.AmParkInputForm) r6     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r6 = r6.getTitle()     // Catch:{ Exception -> 0x00e9 }
            boolean r5 = r6.equals(r5)     // Catch:{ Exception -> 0x00e9 }
            if (r5 == 0) goto L_0x00d0
            java.util.ArrayList r5 = r2.getForm()     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x00e9 }
            r3.add(r5)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00db
        L_0x00d0:
            java.util.ArrayList r5 = r8.getForm()     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r5 = r5.get(r4)     // Catch:{ Exception -> 0x00e9 }
            r3.add(r5)     // Catch:{ Exception -> 0x00e9 }
        L_0x00db:
            int r4 = r4 + 1
            goto L_0x008c
        L_0x00de:
            r2.setForm(r3)     // Catch:{ Exception -> 0x00e9 }
            r7.E = r2     // Catch:{ Exception -> 0x00e9 }
            net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel r8 = r7.E     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00eb
        L_0x00e6:
            r7.E = r8     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00eb
        L_0x00e9:
            r7.E = r8
        L_0x00eb:
            int r2 = r7.H
            r3 = 1
            if (r8 != 0) goto L_0x00f2
            r4 = r1
            goto L_0x0118
        L_0x00f2:
            int r4 = r8.getFlag()
            if (r4 != 0) goto L_0x00f9
            goto L_0x0100
        L_0x00f9:
            int r4 = r8.getFlag()
            if (r4 != r3) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r0 = 1
        L_0x0101:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            java.lang.String r5 = "traveller-num-of-passenger"
            r4.putInt(r5, r2)
            java.lang.String r2 = "traveller-is-static-form"
            r4.putBoolean(r2, r0)
            java.lang.String r0 = "traveller-details"
            r4.putSerializable(r0, r8)
        L_0x0118:
            if (r8 == 0) goto L_0x018d
            java.util.ArrayList r0 = r8.getForm()
            if (r0 == 0) goto L_0x018d
            java.util.ArrayList r0 = r8.getForm()
            int r0 = r0.size()
            if (r0 <= r3) goto L_0x018d
            int r8 = r8.getFlag()
            if (r8 != r3) goto L_0x018d
            boolean r8 = r7.f73582f
            if (r8 != 0) goto L_0x018c
            net.one97.paytm.o2o.amusementpark.c.a.b r8 = r7.p
            if (r8 == 0) goto L_0x014f
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            androidx.fragment.app.j r8 = r8.getSupportFragmentManager()
            androidx.fragment.app.q r8 = r8.a()
            net.one97.paytm.o2o.amusementpark.c.a.b r0 = r7.p
            androidx.fragment.app.q r8 = r8.a((androidx.fragment.app.Fragment) r0)
            r8.c()
            r7.p = r1
        L_0x014f:
            net.one97.paytm.o2o.amusementpark.c.a.f r8 = r7.q
            if (r8 == 0) goto L_0x016a
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            androidx.fragment.app.j r8 = r8.getSupportFragmentManager()
            androidx.fragment.app.q r8 = r8.a()
            net.one97.paytm.o2o.amusementpark.c.a.f r0 = r7.q
            androidx.fragment.app.q r8 = r8.a((androidx.fragment.app.Fragment) r0)
            r8.c()
            r7.q = r1
        L_0x016a:
            net.one97.paytm.o2o.amusementpark.c.a.d r8 = r7.r
            if (r8 == 0) goto L_0x0185
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            androidx.fragment.app.j r8 = r8.getSupportFragmentManager()
            androidx.fragment.app.q r8 = r8.a()
            net.one97.paytm.o2o.amusementpark.c.a.d r0 = r7.r
            androidx.fragment.app.q r8 = r8.a((androidx.fragment.app.Fragment) r0)
            r8.c()
            r7.r = r1
        L_0x0185:
            net.one97.paytm.o2o.amusementpark.d.j r8 = r7.y
            if (r8 == 0) goto L_0x018c
            r8.a(r4)
        L_0x018c:
            return
        L_0x018d:
            boolean r8 = r7.f73582f
            if (r8 != 0) goto L_0x01d0
            if (r4 == 0) goto L_0x01d0
            net.one97.paytm.o2o.amusementpark.c.a.b r8 = r7.p
            r7.a((androidx.fragment.app.Fragment) r8)
            net.one97.paytm.o2o.amusementpark.c.a.b r8 = new net.one97.paytm.o2o.amusementpark.c.a.b
            r8.<init>()
            r7.p = r8
            net.one97.paytm.common.entity.amPark.CJRParticularAmParkDescriptionModel r8 = r7.F
            java.lang.String r8 = r8.getId()
            java.lang.String r0 = "park_id"
            r4.putString(r0, r8)
            r7.D = r3
            net.one97.paytm.o2o.amusementpark.c.a.b r8 = r7.p
            if (r8 == 0) goto L_0x01d0
            r8.f73427c = r7
            r8.setArguments(r4)
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            androidx.fragment.app.j r8 = r8.getSupportFragmentManager()
            androidx.fragment.app.q r8 = r8.a()
            int r0 = net.one97.paytm.o2o.amusementpark.R.id.events_booking_summary_traveller_details_venue_layout
            net.one97.paytm.o2o.amusementpark.c.a.b r2 = r7.p
            androidx.fragment.app.q r8 = r8.b(r0, r2, r1)
            r8.c()
            net.one97.paytm.o2o.amusementpark.c.a.b r8 = r7.p
            r7.B = r8
        L_0x01d0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.amusementpark.c.h.c(net.one97.paytm.common.entity.amPark.AmParkTravellerResponseModel):void");
    }

    /* access modifiers changed from: private */
    public void s() {
        if (!this.f73582f) {
            int w2 = w();
            String v2 = v();
            u();
            if (w2 != 0) {
                TextUtils.isEmpty(v2);
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("traveller-details", this.E);
            bundle.putSerializable("title", this.F.getName());
            bundle.putSerializable("category", this.F.getCategories().get(0).getCategory());
            if (this.C == null) {
                this.C = new net.one97.paytm.o2o.amusementpark.e.c();
            }
            this.q = new f();
            if (this.B != null) {
                getActivity().getSupportFragmentManager().a().a(this.B).c();
                this.B = null;
            }
            f fVar = this.q;
            if (fVar != null) {
                fVar.setArguments(bundle);
                this.q.f73514a = this;
                getActivity().getSupportFragmentManager().a().b(R.id.events_booking_summary_traveller_details_venue_layout, this.q, (String) null).c();
                this.B = this.q;
            }
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        if (!this.f73582f) {
            int w2 = w();
            String v2 = v();
            String u2 = u();
            if (w2 != 0 && !TextUtils.isEmpty(v2)) {
                Bundle bundle = new Bundle();
                bundle.putString("traveller-minimized-name", v2);
                bundle.putString("traveller-minimized-desc", u2);
                bundle.putInt("traveller-minimized-count", w2);
                bundle.putString("title", this.F.getName());
                bundle.putString("category", this.F.getCategories().get(0).getCategory());
                if (this.C == null) {
                    this.C = new net.one97.paytm.o2o.amusementpark.e.c();
                }
                this.r = new d();
                if (this.B != null) {
                    getActivity().getSupportFragmentManager().a().a(this.B).c();
                    this.B = null;
                }
                d dVar = this.r;
                if (dVar != null) {
                    dVar.setArguments(bundle);
                    this.r.f73497a = this;
                    getActivity().getSupportFragmentManager().a().b(R.id.events_booking_summary_traveller_details_venue_layout, this.r, (String) null).c();
                    this.B = this.r;
                }
            }
        }
    }

    private String u() {
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.E;
        if (amParkTravellerResponseModel == null || amParkTravellerResponseModel.getForm() == null || this.E.getForm().size() == 0) {
            return null;
        }
        for (int i2 = 0; i2 < this.E.getForm().size(); i2++) {
            ArrayList arrayList = this.E.getForm().get(i2);
            if (arrayList == null || arrayList.size() == 0) {
                return null;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                AmParkInputForm amParkInputForm = (AmParkInputForm) it2.next();
                if (!TextUtils.isEmpty(amParkInputForm.getTitle())) {
                    if (amParkInputForm.getTitle().toLowerCase().contains("number") || amParkInputForm.getTitle().toLowerCase().contains("no") || amParkInputForm.getTitle().toLowerCase().contains("mobile") || amParkInputForm.getTitle().toLowerCase().contains(ContactColumn.PHONE_NUMBER)) {
                        return amParkInputForm.getAppliedData();
                    }
                    if (amParkInputForm.getTitle().toLowerCase().contains(AppConstants.KEY_EMAIL)) {
                        return amParkInputForm.getAppliedData();
                    }
                }
            }
        }
        return "";
    }

    private String v() {
        ArrayList arrayList;
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.E;
        if (amParkTravellerResponseModel == null || amParkTravellerResponseModel.getForm() == null || this.E.getForm().size() == 0 || (arrayList = this.E.getForm().get(0)) == null || arrayList.size() == 0) {
            return null;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            AmParkInputForm amParkInputForm = (AmParkInputForm) it2.next();
            if (!TextUtils.isEmpty(amParkInputForm.getTitle()) && amParkInputForm.getTitle().toLowerCase().contains("name") && !TextUtils.isEmpty(amParkInputForm.getAppliedData())) {
                return amParkInputForm.getAppliedData();
            }
        }
        return ((AmParkInputForm) arrayList.get(0)).getAppliedData();
    }

    private int w() {
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.E;
        if (amParkTravellerResponseModel == null || amParkTravellerResponseModel.getForm() == null) {
            return 0;
        }
        return this.E.getForm().size();
    }

    public final void a(CJRParticularAmParkDescriptionModel cJRParticularAmParkDescriptionModel) {
        this.C.f73621c = cJRParticularAmParkDescriptionModel;
    }

    public final void a(AmParkTravellerResponseModel amParkTravellerResponseModel) {
        com.paytm.utility.b.j();
        this.E = amParkTravellerResponseModel;
        if (!this.f73583g) {
            this.K.sendEmptyMessage(5);
            this.K.sendEmptyMessage(6);
            return;
        }
        Fragment fragment = this.A;
        if (fragment != null && fragment == this.o) {
            this.K.sendEmptyMessage(3);
        }
        Fragment fragment2 = this.z;
        if (fragment2 != null && fragment2 == this.n) {
            this.K.sendEmptyMessage(2);
        }
        if (d(amParkTravellerResponseModel)) {
            this.K.sendEmptyMessage(8);
            j();
            return;
        }
        this.K.sendEmptyMessage(5);
    }

    public final void b(AmParkTravellerResponseModel amParkTravellerResponseModel) {
        if (amParkTravellerResponseModel != null) {
            this.E = amParkTravellerResponseModel;
        }
    }

    private static boolean d(AmParkTravellerResponseModel amParkTravellerResponseModel) {
        if (amParkTravellerResponseModel == null || amParkTravellerResponseModel.getForm() == null || amParkTravellerResponseModel.getForm().size() <= 0) {
            return true;
        }
        Iterator<ArrayList<AmParkInputForm>> it2 = amParkTravellerResponseModel.getForm().iterator();
        while (it2.hasNext()) {
            Iterator it3 = it2.next().iterator();
            while (true) {
                if (it3.hasNext()) {
                    AmParkInputForm amParkInputForm = (AmParkInputForm) it3.next();
                    if (amParkInputForm != null && amParkInputForm.getTitle() != null && amParkInputForm.getTitle().toLowerCase().contains("name") && TextUtils.isEmpty(amParkInputForm.getAppliedData())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final void a() {
        if (!this.f73582f && this.B != null) {
            getActivity().getSupportFragmentManager().a().a(this.B).c();
            this.B = null;
            t();
        }
    }

    public final void a(int i2) {
        net.one97.paytm.o2o.amusementpark.c.a.a aVar = this.s;
        if (aVar != null) {
            aVar.a(i2);
        }
    }

    public final void h() {
        AmParkTravellerResponseModel amParkTravellerResponseModel = this.E;
        if (amParkTravellerResponseModel != null) {
            c(amParkTravellerResponseModel);
        }
    }

    public final void a(String str) {
        j jVar = this.y;
        if (jVar != null) {
            jVar.b(str);
        }
    }

    public final void b(String str) {
        net.one97.paytm.o2o.amusementpark.c.a.a aVar = this.s;
        if (aVar != null && aVar.f73411a != null) {
            net.one97.paytm.o2o.amusementpark.e.b bVar = aVar.f73411a;
            if (!TextUtils.isEmpty(str)) {
                bVar.m = str;
                bVar.a(CJRAutomaticSubscriptionHistory.PROCESSING);
                int flag = bVar.f73611g == null ? 0 : bVar.f73611g.getFlag();
                if (flag == 0) {
                    bVar.b();
                } else if (flag == 1) {
                    bVar.a();
                }
                if (flag != 1 || bVar.f73609e != null) {
                    if (flag != 0 || bVar.f73610f != null) {
                        if (flag == 0) {
                            bVar.f73610f.setPromocode(str);
                        } else {
                            bVar.f73609e.setPromocode(str);
                        }
                        String u2 = com.paytm.utility.b.u(bVar.f73605a, com.paytm.utility.c.b(net.one97.paytm.o2o.amusementpark.a.a().getStringFromGTM("cartVerify"), bVar.f73605a));
                        HashMap<String, String> a2 = com.paytm.utility.b.a((HashMap<String, String>) new HashMap(), bVar.f73605a);
                        a2.put("Content-Type", "application/json");
                        String b2 = new com.google.gson.f().b(flag == 0 ? bVar.f73610f : bVar.f73609e);
                        com.paytm.network.b bVar2 = new com.paytm.network.b();
                        bVar2.f42877a = bVar.f73605a;
                        bVar2.f42878b = a.c.AM_PARK;
                        bVar2.f42879c = a.C0715a.POST;
                        bVar2.f42880d = u2;
                        bVar2.f42881e = null;
                        bVar2.f42882f = a2;
                        bVar2.f42883g = null;
                        bVar2.f42884h = b2;
                        bVar2.f42885i = flag == 1 ? new CJRPromoValidateResponseModel() : new CJRPromoValidateStaticResponseModel();
                        bVar2.j = bVar;
                        bVar2.n = a.b.USER_FACING;
                        bVar2.o = "AmPark";
                        bVar2.t = net.one97.paytm.o2o.amusementpark.e.b.j();
                        com.paytm.network.a l2 = bVar2.l();
                        l2.f42859c = false;
                        l2.a();
                    }
                }
            }
        }
    }

    public final void i() {
        j jVar = this.y;
        if (jVar != null) {
            jVar.i();
        }
    }

    public final void j() {
        this.K.sendEmptyMessage(7);
    }

    public final void a(Bundle bundle) {
        e eVar = new e(this);
        eVar.setArguments(bundle);
        eVar.f73549a = this.C;
        getActivity().getSupportFragmentManager().a().b(R.id.fragment_park_booking_page, eVar, (String) null).c();
        this.I.setVisibility(0);
        this.J.setVisibility(8);
        this.f73585i = true;
        ((AJRAmParkBookActivity) getActivity()).a(true);
    }

    public final void k() {
        this.f73585i = false;
        this.I.setVisibility(8);
        this.J.setVisibility(0);
        ((AJRAmParkBookActivity) getActivity()).a(false);
    }

    public final void b(List<CJRSeatDetailsModel> list) {
        if (getActivity() != null && !com.paytm.utility.b.c((Context) getActivity())) {
            com.paytm.utility.b.b((Context) getActivity(), getActivity().getString(R.string.no_connection), getActivity().getString(R.string.no_internet));
        } else if (this.F == null || !c(list)) {
            com.paytm.utility.b.b((Context) getActivity(), "Error", "Booking not allowed for multiple packages/shifts. Please reselect packages.");
        } else {
            net.one97.paytm.o2o.amusementpark.e.c cVar = this.C;
            if (cVar == null || list == null) {
                com.paytm.utility.b.b((Context) getActivity(), "Error", "Visitor selection failed, please select again.");
                return;
            }
            JSONObject b2 = cVar.b(list);
            if (b2 != null) {
                String jSONObject = b2.toString();
                if (cVar.f73622d != null) {
                    cVar.f73622d.b(CJRAutomaticSubscriptionHistory.PROCESSING);
                }
                String u2 = com.paytm.utility.b.u(cVar.f73619a, "https://apiproxy.paytm.com/v1/entertainment/themeparks/validatePackage");
                HashMap hashMap = new HashMap();
                hashMap.put("Content-Type", "application/json");
                com.paytm.network.b bVar = new com.paytm.network.b();
                bVar.f42877a = cVar.f73619a;
                bVar.f42878b = a.c.AM_PARK;
                bVar.f42879c = a.C0715a.POST;
                bVar.f42880d = u2;
                bVar.f42881e = null;
                bVar.f42882f = hashMap;
                bVar.f42883g = null;
                bVar.f42884h = jSONObject;
                bVar.f42885i = new CJRValidatePackage();
                bVar.j = cVar;
                bVar.n = a.b.USER_FACING;
                bVar.o = "AmPark";
                bVar.t = net.one97.paytm.o2o.amusementpark.e.c.a();
                com.paytm.network.a l2 = bVar.l();
                l2.f42859c = false;
                l2.a();
            }
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

    public final void a(CJRValidatePackage cJRValidatePackage) {
        if (cJRValidatePackage == null) {
            return;
        }
        if (!cJRValidatePackage.getShowMessage().booleanValue()) {
            g gVar = this.o;
            if (gVar != null) {
                gVar.a();
                return;
            }
            return;
        }
        FragmentActivity activity = getActivity();
        final String type = cJRValidatePackage.getType();
        String message = cJRValidatePackage.getMessage();
        if (!this.j && !activity.isFinishing()) {
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
                    boolean unused = h.this.j = false;
                    String str = type;
                    if (str != null && str.equalsIgnoreCase("warning")) {
                        h.l(h.this);
                    }
                }
            });
            hVar.show();
            if (a2 != null) {
                hVar.getWindow().setAttributes(a2);
            }
            this.j = true;
        }
    }

    private boolean c(List<CJRSeatDetailsModel> list) {
        if (list != null) {
            try {
                if (list.size() > 0 && this.F.getmMultiPackage() == 0) {
                    int i2 = list.get(0).getmPackageId();
                    for (CJRSeatDetailsModel cJRSeatDetailsModel : list) {
                        if (i2 != cJRSeatDetailsModel.getmPackageId()) {
                            return false;
                        }
                    }
                }
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static void b(String str, int i2) {
        net.one97.paytm.o2o.amusementpark.f.a.a(net.one97.paytm.o2o.amusementpark.a.a().getAppContext().getApplicationContext()).a(str, i2, false);
    }

    private static int c(String str) {
        return net.one97.paytm.o2o.amusementpark.f.a.a(net.one97.paytm.o2o.amusementpark.a.a().getAppContext().getApplicationContext()).b(str, 0, false);
    }

    static /* synthetic */ void e(h hVar) {
        View currentFocus = hVar.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            ((InputMethodManager) hVar.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
    }

    static /* synthetic */ void h(h hVar) {
        if (!hVar.f73582f) {
            List<CJRSeatDetailsModel> list = hVar.x;
            if (list == null || list.size() == 0) {
                Toast.makeText(hVar.getActivity(), "Please select package(s) to proceed.", 0).show();
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putSerializable("seat-summary-selected-list", new ArrayList(hVar.x));
            bundle.putSerializable("event-address-list", hVar.F);
            bundle.putSerializable("traveller-response-model", hVar.E);
            bundle.putSerializable("event-seat-selection-fragment-key-venue-model", hVar.u);
            bundle.putString("event-seat-selection-fragment-key-date", hVar.f73578b);
            bundle.putSerializable("event-seat-selection-fragment-key-time-model", hVar.f73579c);
            net.one97.paytm.o2o.amusementpark.e.c cVar = hVar.C;
            String str = "";
            if (!(cVar == null || cVar.f73621c == null || TextUtils.isEmpty(cVar.f73621c.getId()))) {
                str = cVar.f73621c.getId();
            }
            bundle.putString("park_id", str);
            hVar.s = new net.one97.paytm.o2o.amusementpark.c.a.a();
            net.one97.paytm.o2o.amusementpark.c.a.a aVar = hVar.s;
            if (aVar != null) {
                aVar.setArguments(bundle);
                hVar.s.f73413c = hVar;
                hVar.getActivity().getSupportFragmentManager().a().b(R.id.events_booking_summary_review_pay_frame_layout, hVar.s, (String) null).c();
            }
        }
    }

    static /* synthetic */ void i(h hVar) {
        if (!hVar.f73582f && hVar.s != null) {
            hVar.getActivity().getSupportFragmentManager().a().a((Fragment) hVar.s).c();
            hVar.s = null;
        }
    }

    static /* synthetic */ void l(h hVar) {
        g gVar = hVar.o;
        if (gVar != null) {
            gVar.a();
        }
    }
}
