package net.one97.paytm.upgradeKyc.kycV3.activity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.location.LocationResult;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal;
import net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel;
import net.one97.paytm.common.utility.g;
import net.one97.paytm.common.utility.h;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.activity.UpgradeKycBaseActivity;
import net.one97.paytm.upgradeKyc.kycV3.a.a;
import net.one97.paytm.upgradeKyc.kycV3.activity.KycDoorStepActivity;
import net.one97.paytm.upgradeKyc.kycV3.c.c;
import net.one97.paytm.upgradeKyc.utils.l;

public final class KycNearByActivity extends UpgradeKycBaseActivity implements h, a.C1319a {

    /* renamed from: a  reason: collision with root package name */
    int f66117a = -1;

    /* renamed from: b  reason: collision with root package name */
    public net.one97.paytm.upgradeKyc.kycV3.c.c f66118b;

    /* renamed from: d  reason: collision with root package name */
    public g f66119d;

    /* renamed from: e  reason: collision with root package name */
    net.one97.paytm.upgradeKyc.kycV3.a.a f66120e = new net.one97.paytm.upgradeKyc.kycV3.a.a(this);

    /* renamed from: f  reason: collision with root package name */
    c.a f66121f = new c.a();

    /* renamed from: g  reason: collision with root package name */
    ArrayList<PayTMPartnerListModal.Response> f66122g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<PayTMPartnerListModal>> f66123h = new a(this);

    /* renamed from: i  reason: collision with root package name */
    private final z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> f66124i = new b(this);
    private HashMap j;

    public final View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    static final class a<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<PayTMPartnerListModal>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycNearByActivity f66125a;

        a(KycNearByActivity kycNearByActivity) {
            this.f66125a = kycNearByActivity;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.List} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.util.List} */
        /* JADX WARNING: type inference failed for: r0v15, types: [java.util.ArrayList<net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal$Response>] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onChanged(java.lang.Object r7) {
            /*
                r6 = this;
                net.one97.paytm.upgradeKyc.kycV3.b.b r7 = (net.one97.paytm.upgradeKyc.kycV3.b.b) r7
                r0 = 0
                if (r7 == 0) goto L_0x0008
                net.one97.paytm.upgradeKyc.kycV3.b.d r1 = r7.f66168a
                goto L_0x0009
            L_0x0008:
                r1 = r0
            L_0x0009:
                if (r1 != 0) goto L_0x000c
                return
            L_0x000c:
                int[] r2 = net.one97.paytm.upgradeKyc.kycV3.activity.e.f66158a
                int r1 = r1.ordinal()
                r1 = r2[r1]
                r2 = 1
                if (r1 == r2) goto L_0x0070
                r0 = 2
                java.lang.String r2 = "error_layout"
                if (r1 == r0) goto L_0x003c
                r7 = 3
                if (r1 == r7) goto L_0x0020
                goto L_0x006f
            L_0x0020:
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r7 = r6.f66125a
                int r0 = net.one97.paytm.upgradeKyc.R.id.error_layout
                android.view.View r7 = r7.a((int) r0)
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
                net.one97.paytm.upgradeKyc.kycV3.b.a((android.view.View) r7)
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r7 = r6.f66125a
                int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r7 = r7.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
                net.one97.paytm.common.widgets.a.a(r7)
                goto L_0x006f
            L_0x003c:
                com.paytm.network.model.NetworkCustomError r0 = r7.f66170c
                if (r0 == 0) goto L_0x006f
                net.one97.paytm.upgradeKyc.utils.l.a()
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r0 = r6.f66125a
                android.content.Context r0 = (android.content.Context) r0
                com.paytm.network.model.NetworkCustomError r7 = r7.f66170c
                if (r7 != 0) goto L_0x004e
                kotlin.g.b.k.a()
            L_0x004e:
                boolean r7 = net.one97.paytm.upgradeKyc.utils.l.a((android.content.Context) r0, (com.paytm.network.model.NetworkCustomError) r7)
                if (r7 != 0) goto L_0x006f
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r7 = r6.f66125a
                int r0 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r7 = r7.a((int) r0)
                com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
                net.one97.paytm.common.widgets.a.b(r7)
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r7 = r6.f66125a
                int r0 = net.one97.paytm.upgradeKyc.R.id.error_layout
                android.view.View r7 = r7.a((int) r0)
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)
                net.one97.paytm.upgradeKyc.kycV3.b.b(r7)
            L_0x006f:
                return
            L_0x0070:
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r1 = r6.f66125a
                int r3 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r1 = r1.a((int) r3)
                com.airbnb.lottie.LottieAnimationView r1 = (com.airbnb.lottie.LottieAnimationView) r1
                net.one97.paytm.common.widgets.a.b(r1)
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r1 = r6.f66125a
                int r3 = net.one97.paytm.upgradeKyc.R.id.center_rv
                android.view.View r1 = r1.a((int) r3)
                androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
                java.lang.String r3 = "center_rv"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r3 = r6.f66125a
                net.one97.paytm.upgradeKyc.kycV3.a.a r3 = r3.f66120e
                androidx.recyclerview.widget.RecyclerView$a r3 = (androidx.recyclerview.widget.RecyclerView.a) r3
                r1.setAdapter(r3)
                ResultType r1 = r7.f66169b
                net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r1 = (net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal) r1
                if (r1 == 0) goto L_0x00f5
                java.util.ArrayList<net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal$Response> r1 = r1.response
                if (r1 == 0) goto L_0x00f5
                java.util.Collection r1 = (java.util.Collection) r1
                boolean r1 = r1.isEmpty()
                r1 = r1 ^ r2
                if (r1 != r2) goto L_0x00f5
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r1 = r6.f66125a
                java.util.ArrayList<net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal$Response> r1 = r1.f66122g
                ResultType r3 = r7.f66169b
                net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r3 = (net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal) r3
                if (r3 == 0) goto L_0x00b5
                java.util.ArrayList<net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal$Response> r3 = r3.response
                goto L_0x00b6
            L_0x00b5:
                r3 = r0
            L_0x00b6:
                if (r3 != 0) goto L_0x00bb
                kotlin.g.b.k.a()
            L_0x00bb:
                java.util.Collection r3 = (java.util.Collection) r3
                r1.addAll(r3)
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r1 = r6.f66125a
                net.one97.paytm.upgradeKyc.kycV3.a.a r1 = r1.f66120e
                ResultType r7 = r7.f66169b
                net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal r7 = (net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal) r7
                if (r7 == 0) goto L_0x00cc
                java.util.ArrayList<net.one97.paytm.common.entity.upgradeKyc.PayTMPartnerListModal$Response> r0 = r7.response
            L_0x00cc:
                if (r0 != 0) goto L_0x00d1
                kotlin.g.b.k.a()
            L_0x00d1:
                java.util.List r0 = (java.util.List) r0
                java.lang.String r7 = "itemList"
                kotlin.g.b.k.c(r0, r7)
                r7 = r0
                java.util.Collection r7 = (java.util.Collection) r7
                boolean r3 = r7.isEmpty()
                r2 = r2 ^ r3
                if (r2 == 0) goto L_0x00f4
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r2 = r1.f66034a
                int r2 = r2.size()
                java.util.List<net.one97.paytm.common.entity.IJRDataModel> r3 = r1.f66034a
                r3.addAll(r7)
                int r7 = r0.size()
                r1.notifyItemRangeInserted(r2, r7)
            L_0x00f4:
                return
            L_0x00f5:
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r7 = r6.f66125a
                int r1 = net.one97.paytm.upgradeKyc.R.id.wallet_loader
                android.view.View r7 = r7.a((int) r1)
                com.airbnb.lottie.LottieAnimationView r7 = (com.airbnb.lottie.LottieAnimationView) r7
                net.one97.paytm.common.widgets.a.a(r7)
                net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity r7 = r6.f66125a
                net.one97.paytm.upgradeKyc.kycV3.c.c r7 = r7.e()
                net.one97.paytm.upgradeKyc.kycV3.b.c r1 = r7.f66215c
                androidx.lifecycle.y<net.one97.paytm.upgradeKyc.kycV3.b.b<com.paytm.network.model.IJRPaytmDataModel>> r7 = r7.f66213a
                java.lang.String r2 = "tabsLiveData"
                kotlin.g.b.k.c(r7, r2)
                java.lang.String r2 = ""
                android.content.Context r3 = r1.f66175b     // Catch:{ JSONException -> 0x01ab }
                boolean r3 = com.paytm.utility.b.c((android.content.Context) r3)     // Catch:{ JSONException -> 0x01ab }
                if (r3 == 0) goto L_0x01bf
                net.one97.paytm.upgradeKyc.helper.d$a r3 = net.one97.paytm.upgradeKyc.helper.d.f66026a     // Catch:{ JSONException -> 0x01ab }
                net.one97.paytm.upgradeKyc.helper.d r3 = net.one97.paytm.upgradeKyc.helper.d.a.a()     // Catch:{ JSONException -> 0x01ab }
                if (r3 == 0) goto L_0x0132
                net.one97.paytm.upgradeKyc.helper.d$a r2 = net.one97.paytm.upgradeKyc.helper.d.f66026a     // Catch:{ JSONException -> 0x01ab }
                net.one97.paytm.upgradeKyc.helper.d r2 = net.one97.paytm.upgradeKyc.helper.d.a.a()     // Catch:{ JSONException -> 0x01ab }
                if (r2 == 0) goto L_0x0131
                java.lang.String r0 = "screen_tabs"
                java.lang.String r0 = net.one97.paytm.upgradeKyc.helper.d.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x01ab }
            L_0x0131:
                r2 = r0
            L_0x0132:
                java.util.HashMap r0 = new java.util.HashMap     // Catch:{ JSONException -> 0x01ab }
                r0.<init>()     // Catch:{ JSONException -> 0x01ab }
                java.lang.String r3 = "Content-Type"
                java.lang.String r4 = "application/json"
                r0.put(r3, r4)     // Catch:{ JSONException -> 0x01ab }
                java.lang.String r3 = "session_token"
                android.content.Context r4 = r1.f66175b     // Catch:{ JSONException -> 0x01ab }
                java.lang.String r4 = com.paytm.utility.d.a(r4)     // Catch:{ JSONException -> 0x01ab }
                r0.put(r3, r4)     // Catch:{ JSONException -> 0x01ab }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x01ab }
                r3.<init>()     // Catch:{ JSONException -> 0x01ab }
                java.lang.String r4 = "noOfNearbyCentres"
                r5 = 0
                r3.put(r4, r5)     // Catch:{ JSONException -> 0x01ab }
                net.one97.paytm.upgradeKyc.helper.a$a r4 = net.one97.paytm.upgradeKyc.helper.a.f66022a     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r4 = net.one97.paytm.upgradeKyc.helper.a.C1317a.a()     // Catch:{ JSONException -> 0x01ab }
                android.content.Context r1 = r1.f66175b     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r1 = r4.a((android.content.Context) r1)     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.a$a r4 = com.paytm.network.a.C0715a.POST     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r1 = r1.a((com.paytm.network.a.C0715a) r4)     // Catch:{ JSONException -> 0x01ab }
                java.util.Map r0 = (java.util.Map) r0     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r0 = r1.a((java.util.Map<java.lang.String, java.lang.String>) r0)     // Catch:{ JSONException -> 0x01ab }
                net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel r1 = new net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel     // Catch:{ JSONException -> 0x01ab }
                r1.<init>()     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.model.IJRPaytmDataModel r1 = (com.paytm.network.model.IJRPaytmDataModel) r1     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r0 = r0.a((com.paytm.network.model.IJRPaytmDataModel) r1)     // Catch:{ JSONException -> 0x01ab }
                if (r2 != 0) goto L_0x017c
                kotlin.g.b.k.a()     // Catch:{ JSONException -> 0x01ab }
            L_0x017c:
                com.paytm.network.b r0 = r0.a((java.lang.String) r2)     // Catch:{ JSONException -> 0x01ab }
                java.lang.Class<net.one97.paytm.upgradeKyc.activity.InPersonVerification> r1 = net.one97.paytm.upgradeKyc.activity.InPersonVerification.class
                java.lang.String r1 = r1.getName()     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r0 = r0.c(r1)     // Catch:{ JSONException -> 0x01ab }
                java.lang.String r1 = r3.toString()     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r0 = r0.b((java.lang.String) r1)     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.a$b r1 = com.paytm.network.a.b.USER_FACING     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r0 = r0.a((com.paytm.network.a.b) r1)     // Catch:{ JSONException -> 0x01ab }
                net.one97.paytm.upgradeKyc.kycV3.b.c$l r1 = new net.one97.paytm.upgradeKyc.kycV3.b.c$l     // Catch:{ JSONException -> 0x01ab }
                r1.<init>(r7)     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.b r7 = r0.a((com.paytm.network.listener.b) r1)     // Catch:{ JSONException -> 0x01ab }
                com.paytm.network.a r7 = r7.l()     // Catch:{ JSONException -> 0x01ab }
                r7.a()     // Catch:{ JSONException -> 0x01ab }
                return
            L_0x01ab:
                r7 = move-exception
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r7 = r7.getMessage()
                r0.append(r7)
                java.lang.String r7 = r0.toString()
                com.paytm.utility.q.b(r7)
            L_0x01bf:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.kycV3.activity.KycNearByActivity.a.onChanged(java.lang.Object):void");
        }
    }

    static final class b<T> implements z<net.one97.paytm.upgradeKyc.kycV3.b.b<IJRPaytmDataModel>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycNearByActivity f66126a;

        b(KycNearByActivity kycNearByActivity) {
            this.f66126a = kycNearByActivity;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            net.one97.paytm.upgradeKyc.kycV3.b.d dVar;
            net.one97.paytm.upgradeKyc.kycV3.b.b bVar = (net.one97.paytm.upgradeKyc.kycV3.b.b) obj;
            if (bVar != null) {
                dVar = bVar.f66168a;
            } else {
                dVar = null;
            }
            if (dVar != null) {
                int i2 = e.f66159b[dVar.ordinal()];
                if (i2 == 1) {
                    KycNearByActivity.a(this.f66126a, bVar);
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        View a2 = this.f66126a.a(R.id.error_layout);
                        k.a((Object) a2, "error_layout");
                        net.one97.paytm.upgradeKyc.kycV3.b.a(a2);
                        net.one97.paytm.common.widgets.a.a((LottieAnimationView) this.f66126a.a(R.id.wallet_loader));
                    }
                } else if (bVar.f66170c != null) {
                    l.a();
                    Context context = this.f66126a;
                    NetworkCustomError networkCustomError = bVar.f66170c;
                    if (networkCustomError == null) {
                        k.a();
                    }
                    if (!l.a(context, networkCustomError)) {
                        net.one97.paytm.common.widgets.a.b((LottieAnimationView) this.f66126a.a(R.id.wallet_loader));
                        View a3 = this.f66126a.a(R.id.error_layout);
                        k.a((Object) a3, "error_layout");
                        net.one97.paytm.upgradeKyc.kycV3.b.b(a3);
                    }
                }
            }
        }
    }

    public final void b(int i2) {
        HashMap hashMap = new HashMap();
        if (this.f66122g.get(i2).cashPointsDetail.contactNo == null || this.f66122g.get(i2).cashPointsDetail.contactNo.size() <= 0 || this.f66122g.get(i2).cashPointsDetail.contactNo.get(0) == null) {
            hashMap.put("event_label", "");
        } else {
            String str = this.f66122g.get(i2).cashPointsDetail.contactNo.get(0);
            k.a((Object) str, "kycCenterList[position].…PointsDetail.contactNo[0]");
            hashMap.put("event_label", str);
        }
        UpgradeKycBaseActivity.a(this, "/kyc/nearby-kyc-points", "call_icon_clicked", hashMap, (String) null, 8);
        PayTMPartnerListModal.Response response = this.f66122g.get(i2);
        k.a((Object) response, "kycCenterList[position]");
        PayTMPartnerListModal.Response response2 = response;
        try {
            if (response2.cashPointsDetail.contactNo != null && response2.cashPointsDetail.contactNo.size() > 0) {
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:".concat(String.valueOf(response2.cashPointsDetail.contactNo.get(0))))));
            }
        } catch (Exception unused) {
            Toast.makeText(this, getString(R.string.some_went_wrong), 0).show();
        }
    }

    public final void c(int i2) {
        HashMap hashMap = new HashMap();
        if (this.f66122g.get(i2).cashPointsDetail.contactNo == null || this.f66122g.get(i2).cashPointsDetail.contactNo.size() <= 0 || this.f66122g.get(i2).cashPointsDetail.contactNo.get(0) == null) {
            hashMap.put("event_label", "");
        } else {
            String str = this.f66122g.get(i2).cashPointsDetail.contactNo.get(0);
            k.a((Object) str, "kycCenterList[position].…PointsDetail.contactNo[0]");
            hashMap.put("event_label", str);
        }
        UpgradeKycBaseActivity.a(this, "/kyc/nearby-kyc-points", "directions_clicked", hashMap, (String) null, 8);
        if (this.f66122g.get(i2).cashPointsDetail.location != null && this.f66122g.get(i2).cashPointsDetail.location.lat != null && this.f66122g.get(i2).cashPointsDetail.location.lon != null) {
            l.a();
            l.a(this.f66122g.get(i2).cashPointsDetail.location.lat, this.f66122g.get(i2).cashPointsDetail.location.lon, this);
        }
    }

    public final void d(int i2) {
        HashMap hashMap = new HashMap();
        if (this.f66122g.get(i2).cashPointsDetail.contactNo == null || this.f66122g.get(i2).cashPointsDetail.contactNo.size() <= 0 || this.f66122g.get(i2).cashPointsDetail.contactNo.get(0) == null) {
            hashMap.put("event_label", "");
        } else {
            String str = this.f66122g.get(i2).cashPointsDetail.contactNo.get(0);
            k.a((Object) str, "kycCenterList[position].…PointsDetail.contactNo[0]");
            hashMap.put("event_label", str);
        }
        UpgradeKycBaseActivity.a(this, "/kyc/nearby-kyc-points", "kyc_point_clicked", hashMap, (String) null, 8);
    }

    public final int a() {
        return R.layout.kyc_nearby_layout;
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final net.one97.paytm.upgradeKyc.kycV3.c.c e() {
        net.one97.paytm.upgradeKyc.kycV3.c.c cVar = this.f66118b;
        if (cVar == null) {
            k.a("viewModel");
        }
        return cVar;
    }

    public final g f() {
        g gVar = this.f66119d;
        if (gVar == null) {
            k.a("locationUtility");
        }
        return gVar;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a("/kyc/nearby-kyc-points", "kyc_new", "signal");
        this.f66118b = (net.one97.paytm.upgradeKyc.kycV3.c.c) net.one97.paytm.upgradeKyc.kycV3.b.a((AppCompatActivity) this, net.one97.paytm.upgradeKyc.kycV3.c.c.class);
        net.one97.paytm.upgradeKyc.kycV3.c.c cVar = this.f66118b;
        if (cVar == null) {
            k.a("viewModel");
        }
        q qVar = this;
        cVar.f66214b.observe(qVar, this.f66123h);
        net.one97.paytm.upgradeKyc.kycV3.c.c cVar2 = this.f66118b;
        if (cVar2 == null) {
            k.a("viewModel");
        }
        cVar2.f66213a.observe(qVar, this.f66124i);
        ((TextView) a(R.id.tv_retry)).setOnClickListener(new c(this));
        ((Button) a(R.id.btn_locationsetting)).setOnClickListener(new d(this));
        ((Button) a(R.id.btn_request_agent_visit)).setOnClickListener(new e(this));
        this.f66119d = new g(this, this, bundle);
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycNearByActivity f66127a;

        c(KycNearByActivity kycNearByActivity) {
            this.f66127a = kycNearByActivity;
        }

        public final void onClick(View view) {
            this.f66127a.e().a(this.f66127a.f66121f);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycNearByActivity f66128a;

        d(KycNearByActivity kycNearByActivity) {
            this.f66128a = kycNearByActivity;
        }

        public final void onClick(View view) {
            int i2 = this.f66128a.f66117a;
            if (i2 == 1) {
                this.f66128a.f().e();
            } else if (i2 == 2) {
                this.f66128a.f().f();
            } else if (i2 == 3) {
                this.f66128a.f().c();
            }
        }
    }

    static final class e implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ KycNearByActivity f66129a;

        e(KycNearByActivity kycNearByActivity) {
            this.f66129a = kycNearByActivity;
        }

        public final void onClick(View view) {
            KycNearByActivity.a(this.f66129a);
        }
    }

    public final void onResume() {
        super.onResume();
        g gVar = this.f66119d;
        if (gVar == null) {
            k.a("locationUtility");
        }
        gVar.b();
    }

    public final void onStop() {
        super.onStop();
        g gVar = this.f66119d;
        if (gVar == null) {
            k.a("locationUtility");
        }
        gVar.d();
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        g gVar = this.f66119d;
        if (gVar == null) {
            k.a("locationUtility");
        }
        gVar.a(i2, i3);
    }

    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        k.c(strArr, "permissions");
        k.c(iArr, "grantResults");
        super.onRequestPermissionsResult(i2, strArr, iArr);
        g gVar = this.f66119d;
        if (gVar == null) {
            k.a("locationUtility");
        }
        gVar.a(i2, strArr, iArr);
    }

    public final void onSaveInstanceState(Bundle bundle, PersistableBundle persistableBundle) {
        k.c(bundle, "outState");
        g gVar = this.f66119d;
        if (gVar == null) {
            k.a("locationUtility");
        }
        gVar.a(bundle);
        super.onSaveInstanceState(bundle, persistableBundle);
    }

    public final void a(String str) {
        k.c(str, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        Context context = this;
        Toast.makeText(context, str, 1).show();
        String s = com.paytm.utility.b.s(context);
        String t = com.paytm.utility.b.t(context);
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(t)) {
            k.a((Object) s, "lat");
            k.a((Object) t, "long");
            this.f66121f = new c.a(s, t);
        }
    }

    public final void a(LocationResult locationResult) {
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        if (!k.a((Object) this.f66121f.f66218a, (Object) "0.0d") || !k.a((Object) this.f66121f.f66219b, (Object) "0.0d")) {
            g gVar = this.f66119d;
            if (gVar == null) {
                k.a("locationUtility");
            }
            gVar.a();
        } else if (locationResult != null) {
            Collection b2 = locationResult.b();
            if (!(b2 == null || b2.isEmpty())) {
                Location location = locationResult.b().get(locationResult.b().size() - 1);
                k.a((Object) location, "locationResult.locations…esult.locations.size - 1]");
                String valueOf = String.valueOf(location.getLatitude());
                Location location2 = locationResult.b().get(locationResult.b().size() - 1);
                k.a((Object) location2, "locationResult.locations…esult.locations.size - 1]");
                this.f66121f = new c.a(valueOf, String.valueOf(location2.getLongitude()));
                net.one97.paytm.upgradeKyc.kycV3.c.c cVar = this.f66118b;
                if (cVar == null) {
                    k.a("viewModel");
                }
                cVar.a(this.f66121f);
                View a2 = a(R.id.location_error);
                k.a((Object) a2, "location_error");
                a2.setVisibility(8);
                e(0);
                StringBuilder sb = new StringBuilder();
                Location location3 = locationResult.b().get(locationResult.b().size() - 1);
                k.a((Object) location3, "locationResult.locations…esult.locations.size - 1]");
                sb.append(String.valueOf(location3.getLatitude()));
                sb.append(" , ");
                Location location4 = locationResult.b().get(locationResult.b().size() - 1);
                k.a((Object) location4, "locationResult.locations…esult.locations.size - 1]");
                sb.append(String.valueOf(location4.getLongitude()));
                g gVar2 = this.f66119d;
                if (gVar2 == null) {
                    k.a("locationUtility");
                }
                gVar2.a();
            }
        }
    }

    public final void aE_() {
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(0);
        e(8);
        this.f66117a = 3;
    }

    public final void aF_() {
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(0);
        e(8);
        this.f66117a = 2;
    }

    public final void aG_() {
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) a(R.id.wallet_loader));
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(0);
        e(8);
        this.f66117a = 1;
    }

    public final void d() {
        net.one97.paytm.common.widgets.a.a((LottieAnimationView) a(R.id.wallet_loader));
        View a2 = a(R.id.location_error);
        k.a((Object) a2, "location_error");
        a2.setVisibility(8);
        e(0);
    }

    private void e(int i2) {
        TextView textView = (TextView) a(R.id.visit_kyc_tv);
        k.a((Object) textView, "visit_kyc_tv");
        textView.setVisibility(i2);
        TextView textView2 = (TextView) a(R.id.sub_heading_nb);
        k.a((Object) textView2, "sub_heading_nb");
        textView2.setVisibility(i2);
        RecyclerView recyclerView = (RecyclerView) a(R.id.center_rv);
        k.a((Object) recyclerView, "center_rv");
        recyclerView.setVisibility(i2);
    }

    public static final /* synthetic */ void a(KycNearByActivity kycNearByActivity) {
        KycDoorStepActivity.a aVar = KycDoorStepActivity.f66107b;
        KycDoorStepActivity.a.a(kycNearByActivity, false);
        kycNearByActivity.finish();
    }

    public static final /* synthetic */ void a(KycNearByActivity kycNearByActivity, net.one97.paytm.upgradeKyc.kycV3.b.b bVar) {
        if (bVar.f66169b instanceof ScreenTabModel) {
            ResultType resulttype = bVar.f66169b;
            if (resulttype != null) {
                ScreenTabModel screenTabModel = (ScreenTabModel) resulttype;
                kycNearByActivity.e(8);
                if (TextUtils.isEmpty(screenTabModel.getTab1()) && TextUtils.isEmpty(screenTabModel.getTab2())) {
                    View a2 = kycNearByActivity.a(R.id.door_step);
                    k.a((Object) a2, "door_step");
                    net.one97.paytm.upgradeKyc.kycV3.b.b(a2);
                } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && !TextUtils.isEmpty(screenTabModel.getTab2())) {
                    View a3 = kycNearByActivity.a(R.id.door_step);
                    k.a((Object) a3, "door_step");
                    net.one97.paytm.upgradeKyc.kycV3.b.b(a3);
                } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && p.a(screenTabModel.getTab1(), "request", true)) {
                    View a4 = kycNearByActivity.a(R.id.door_step);
                    k.a((Object) a4, "door_step");
                    net.one97.paytm.upgradeKyc.kycV3.b.b(a4);
                } else if (!TextUtils.isEmpty(screenTabModel.getTab2()) && p.a(screenTabModel.getTab2(), "dynamic", true)) {
                    View a5 = kycNearByActivity.a(R.id.no_kyc_point);
                    k.a((Object) a5, "no_kyc_point");
                    net.one97.paytm.upgradeKyc.kycV3.b.b(a5);
                    View a6 = kycNearByActivity.a(R.id.door_step);
                    k.a((Object) a6, "door_step");
                    net.one97.paytm.upgradeKyc.kycV3.b.a(a6);
                } else if (!TextUtils.isEmpty(screenTabModel.getTab1()) && p.a(screenTabModel.getTab1(), "dynamic", true)) {
                    View a7 = kycNearByActivity.a(R.id.no_kyc_point);
                    k.a((Object) a7, "no_kyc_point");
                    net.one97.paytm.upgradeKyc.kycV3.b.b(a7);
                    View a8 = kycNearByActivity.a(R.id.door_step);
                    k.a((Object) a8, "door_step");
                    net.one97.paytm.upgradeKyc.kycV3.b.a(a8);
                } else if (!TextUtils.isEmpty(screenTabModel.getTab2()) && p.a(screenTabModel.getTab2(), "request", true)) {
                    View a9 = kycNearByActivity.a(R.id.door_step);
                    k.a((Object) a9, "door_step");
                    net.one97.paytm.upgradeKyc.kycV3.b.b(a9);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.upgradeKyc.ScreenTabModel");
            }
        } else {
            View a10 = kycNearByActivity.a(R.id.error_layout);
            k.a((Object) a10, "error_layout");
            net.one97.paytm.upgradeKyc.kycV3.b.a(a10);
        }
        net.one97.paytm.common.widgets.a.b((LottieAnimationView) kycNearByActivity.a(R.id.wallet_loader));
    }
}
