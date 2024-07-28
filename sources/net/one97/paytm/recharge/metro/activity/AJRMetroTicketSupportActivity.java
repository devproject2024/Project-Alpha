package net.one97.paytm.recharge.metro.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.g;
import com.paytmmall.clpartifact.view.actions.IuserActions;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel;
import net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.common.utils.ay;
import net.one97.paytm.recharge.common.utils.az;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.metro.f.c;
import net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel;
import net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel;
import net.one97.paytm.recharge.model.metro.CJRMetroStationModel;
import net.one97.paytm.recharge.widgets.c.d;
import net.one97.paytm.recharge.widgets.model.ACTION_TYPE;
import net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel;
import net.one97.paytm.recharge.widgets.model.CRUFlowModel;
import net.one97.paytm.recharge.widgets.model.ERROR_TYPE;

public final class AJRMetroTicketSupportActivity extends CJRBaseMetroActivity {

    /* renamed from: e  reason: collision with root package name */
    public static final a f63227e = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public net.one97.paytm.recharge.metro.a f63228a;

    /* renamed from: b  reason: collision with root package name */
    public CJRActiveMetroTicketModel f63229b;

    /* renamed from: c  reason: collision with root package name */
    public CJRActiveMetroTicketQRItemModel f63230c;

    /* renamed from: d  reason: collision with root package name */
    public String f63231d = "";

    /* renamed from: g  reason: collision with root package name */
    private CJRMetroStationModel f63232g;

    /* renamed from: h  reason: collision with root package name */
    private String f63233h;

    /* renamed from: i  reason: collision with root package name */
    private String f63234i;
    private int j = -1;
    private int k = -1;
    private HashMap l;

    public final View a(int i2) {
        if (this.l == null) {
            this.l = new HashMap();
        }
        View view = (View) this.l.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.l.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        a(intent);
    }

    private final void a(Intent intent) {
        d dVar = d.f64967a;
        Integer num = null;
        d.a((ACTION_TYPE) null, (ERROR_TYPE) null).setScreenName(f63227e.getClass().getSimpleName());
        this.f63233h = intent != null ? intent.getStringExtra("metro_request_type") : null;
        if (intent != null) {
            num = Integer.valueOf(intent.getIntExtra("list_position", -1));
        }
        if (num == null) {
            k.a();
        }
        this.k = num.intValue();
        if (this.k != -1) {
            CJRActiveMetroTicketModel cJRActiveMetroTicketModel = (CJRActiveMetroTicketModel) intent.getSerializableExtra("activeMetroTickets");
            if (cJRActiveMetroTicketModel == null) {
                k.a();
            }
            this.f63229b = cJRActiveMetroTicketModel;
            CJRActiveMetroTicketModel cJRActiveMetroTicketModel2 = this.f63229b;
            if (cJRActiveMetroTicketModel2 == null) {
                k.a("mActiveTicket");
            }
            List<CJRActiveMetroTicketQRItemModel> qrCodes = cJRActiveMetroTicketModel2.getQrCodes();
            if (qrCodes == null) {
                k.a();
            }
            CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = qrCodes.get(this.k);
            k.a((Object) cJRActiveMetroTicketQRItemModel, "mActiveTicket.qrCodes!![mListPosition]");
            this.f63230c = cJRActiveMetroTicketQRItemModel;
            this.j = intent.getIntExtra("layoutType", -1);
            String value = c.e.SVP.getValue();
            CJRActiveMetroTicketModel cJRActiveMetroTicketModel3 = this.f63229b;
            if (cJRActiveMetroTicketModel3 == null) {
                k.a("mActiveTicket");
            }
            boolean z = true;
            if (!p.a(value, cJRActiveMetroTicketModel3.getProductType(), true)) {
                String value2 = c.e.STORE_VALUE.getValue();
                CJRActiveMetroTicketModel cJRActiveMetroTicketModel4 = this.f63229b;
                if (cJRActiveMetroTicketModel4 == null) {
                    k.a("mActiveTicket");
                }
                p.a(value2, cJRActiveMetroTicketModel4.getProductType(), true);
            }
            this.f63234i = intent.getStringExtra("metroTicketVariant");
            String stringExtra = intent.getStringExtra("vertical_name");
            k.a((Object) stringExtra, "intent.getStringExtra(CJ…TENT_EXTRA_VERTICAL_NAME)");
            this.f63231d = stringExtra;
            Intent putExtra = new Intent(this, AJRMetroStationListActivityV2.class).putExtra("metroTicketVariant", this.f63233h);
            CJRActiveMetroTicketModel cJRActiveMetroTicketModel5 = this.f63229b;
            if (cJRActiveMetroTicketModel5 == null) {
                k.a("mActiveTicket");
            }
            Intent putExtra2 = putExtra.putExtra("destination_name_for_penalty", cJRActiveMetroTicketModel5.getDestination());
            String value3 = c.e.SVP.getValue();
            CJRActiveMetroTicketModel cJRActiveMetroTicketModel6 = this.f63229b;
            if (cJRActiveMetroTicketModel6 == null) {
                k.a("mActiveTicket");
            }
            if (!p.a(value3, cJRActiveMetroTicketModel6.getProductType(), true)) {
                String value4 = c.e.STORE_VALUE.getValue();
                CJRActiveMetroTicketModel cJRActiveMetroTicketModel7 = this.f63229b;
                if (cJRActiveMetroTicketModel7 == null) {
                    k.a("mActiveTicket");
                }
                if (!p.a(value4, cJRActiveMetroTicketModel7.getProductType(), true)) {
                    z = false;
                }
            }
            Intent putExtra3 = putExtra2.putExtra("is_store_value_pass", z).putExtra("is_new_metro_flow", false).putExtra("layout_title_for_penalty", getString(R.string.metro_select_station_title_On_help)).putExtra("metro_event_label", intent.getStringExtra("metro_event_label"));
            c.a aVar = c.f63576a;
            startActivityForResult(putExtra3.putExtra("metro_event_category", c.a.a(this.f63234i)).putExtra("source_name_for_penalty", new CJRMetroStationModel(H5BridgeContext.INVALID_ID, "")), IuserActions.HIDE_KEYBOARD);
            return;
        }
        throw new RuntimeException("List position expected");
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if ((i2 == 110 && i3 == -1) || (i2 == 1011 && i3 == 1012)) {
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra("destinationMetroStation") : null;
            if (serializableExtra != null) {
                this.f63232g = (CJRMetroStationModel) serializableExtra;
                Context context = this;
                if (com.paytm.utility.b.c(context)) {
                    a(context, getString(R.string.please_wait_progress_msg_re));
                    b();
                    return;
                }
                Toast.makeText(context, R.string.network_error_heading_re, 0).show();
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.model.metro.CJRMetroStationModel");
        } else if (i2 == 104) {
            if (i3 != 0) {
                b();
                return;
            }
            ay ayVar = ay.f61523a;
            ay.a(104);
        } else if (i2 != 105) {
            finish();
        } else if (i3 != 0) {
            d();
        } else {
            ay ayVar2 = ay.f61523a;
            ay.a(105);
        }
    }

    private final void b() {
        CJRMetroStationModel cJRMetroStationModel = this.f63232g;
        String str = null;
        if ((cJRMetroStationModel != null ? cJRMetroStationModel.getId() : null) != null) {
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a((ACTION_TYPE) null, (ERROR_TYPE) null);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName == null) {
                flowName = new CRUFlowModel((String) null, (String) null, (LinkedList) null, (String) null, (Integer) null, (Integer) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, (List) null, (String) null, (Stack) null, (String) null, (StringBuilder) null, 1048575, (g) null);
            }
            a2.setFlowName(flowName);
            CRUFlowModel flowName2 = a2.getFlowName();
            if (flowName2 != null) {
                flowName2.setActionType(ACTION_TYPE.GET_PENALTY_DETAIL.name());
            }
            CRUFlowModel flowName3 = a2.getFlowName();
            if (flowName3 != null) {
                flowName3.setErrorType(ERROR_TYPE.UNDEFINED.name());
            }
            CRUFlowModel flowName4 = a2.getFlowName();
            if (flowName4 != null) {
                CJRActiveMetroTicketModel cJRActiveMetroTicketModel = this.f63229b;
                if (cJRActiveMetroTicketModel == null) {
                    k.a("mActiveTicket");
                }
                flowName4.setVariantType(cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getProductType() : null);
            }
            Context context = this;
            CJRMetroStationModel cJRMetroStationModel2 = this.f63232g;
            if (cJRMetroStationModel2 != null) {
                str = cJRMetroStationModel2.getId();
            }
            String str2 = str;
            if (str2 == null) {
                k.a();
            }
            CJRActiveMetroTicketQRItemModel cJRActiveMetroTicketQRItemModel = this.f63230c;
            if (cJRActiveMetroTicketQRItemModel == null) {
                k.a("mQRCode");
            }
            String qrCodeId = cJRActiveMetroTicketQRItemModel.getQrCodeId();
            if (qrCodeId == null) {
                k.a();
            }
            net.one97.paytm.recharge.metro.f.a.a("fetch_metro_panality_details", context, str2, qrCodeId, this, this.f63233h, a2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0176  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a_(java.lang.String r21, com.paytm.network.model.IJRPaytmDataModel r22, java.lang.Object r23) {
        /*
            r20 = this;
            r1 = r20
            r2 = r22
            java.lang.String r0 = "DTM_202"
            java.lang.Class<net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity> r3 = net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity.class
            java.lang.String r4 = "tag"
            r5 = r21
            kotlin.g.b.k.c(r5, r4)
            if (r2 != 0) goto L_0x0016
            r20.finish()
            return
        L_0x0016:
            boolean r4 = r2 instanceof net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0117
            r0 = r2
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r0 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel) r0
            java.util.List r0 = r0.getPenalties()
            if (r0 == 0) goto L_0x010f
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0031
            r20.d()
            return
        L_0x0031:
            int r3 = r0.size()
            if (r3 != r6) goto L_0x0095
            java.lang.Object r0 = r0.get(r5)
            java.lang.String r3 = "reasons[0]"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel r0 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel) r0
            java.lang.String r3 = r0.getReason()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x0096
            java.lang.String r0 = r0.getReason()
            java.lang.String r0 = r0.toString()
            java.util.Locale r3 = java.util.Locale.ENGLISH
            java.lang.String r4 = "Locale.ENGLISH"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            if (r0 == 0) goto L_0x008d
            java.lang.String r0 = r0.toLowerCase(r3)
            java.lang.String r3 = "(this as java.lang.String).toLowerCase(locale)"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            int r3 = r0.hashCode()
            r4 = -802291197(0xffffffffd02e0203, float:-1.16774697E10)
            if (r3 == r4) goto L_0x0080
            r4 = 6481946(0x62e81a, float:9.083141E-39)
            if (r3 == r4) goto L_0x0077
            goto L_0x008b
        L_0x0077:
            java.lang.String r3 = "destination changes penalty"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x008b
            goto L_0x0088
        L_0x0080:
            java.lang.String r3 = "overtravelling charges"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x008b
        L_0x0088:
            r0 = 2
            r5 = 2
            goto L_0x0096
        L_0x008b:
            r5 = 1
            goto L_0x0096
        L_0x008d:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r2)
            throw r0
        L_0x0095:
            r5 = 3
        L_0x0096:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            java.lang.String r3 = "layoutType"
            r0.putInt(r3, r5)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = r1.f63229b
            java.lang.String r4 = "mActiveTicket"
            if (r3 != 0) goto L_0x00a9
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00a9:
            java.lang.String r3 = r3.getProductType()
            java.lang.String r5 = "product-type"
            r0.putString(r5, r3)
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketModel r3 = r1.f63229b
            if (r3 != 0) goto L_0x00b9
            kotlin.g.b.k.a((java.lang.String) r4)
        L_0x00b9:
            java.lang.String r3 = r3.getBalanceAmount()
            java.lang.String r4 = "BALANCE"
            r0.putString(r4, r3)
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r3 = "metroPenaltyDetails"
            r0.putSerializable(r3, r2)
            java.lang.String r2 = r1.f63233h
            java.lang.String r3 = "Mumbai Metro"
            r0.putString(r3, r2)
            android.content.Intent r2 = r20.getIntent()
            java.lang.String r3 = "metro_event_label"
            java.lang.String r2 = r2.getStringExtra(r3)
            r0.putString(r3, r2)
            net.one97.paytm.recharge.metro.f.c$a r2 = net.one97.paytm.recharge.metro.f.c.f63576a
            java.lang.String r2 = r1.f63234i
            java.lang.String r2 = net.one97.paytm.recharge.metro.f.c.a.a((java.lang.String) r2)
            java.lang.String r3 = "metro_event_category"
            r0.putString(r3, r2)
            net.one97.paytm.recharge.metro.c.n r2 = new net.one97.paytm.recharge.metro.c.n
            r2.<init>()
            r2.setArguments(r0)
            androidx.fragment.app.j r0 = r20.getSupportFragmentManager()
            androidx.fragment.app.q r0 = r0.a()
            int r3 = net.one97.paytm.recharge.R.id.container
            androidx.fragment.app.Fragment r2 = (androidx.fragment.app.Fragment) r2
            java.lang.Class<net.one97.paytm.recharge.metro.c.n> r4 = net.one97.paytm.recharge.metro.c.n.class
            java.lang.String r4 = r4.getSimpleName()
            androidx.fragment.app.q r0 = r0.b(r3, r2, r4)
            r0.b()
            r20.o()
            return
        L_0x010f:
            kotlin.u r0 = new kotlin.u
            java.lang.String r2 = "null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.recharge.model.metro.CJRMetroPenaltyReasonModel>"
            r0.<init>(r2)
            throw r0
        L_0x0117:
            boolean r4 = r2 instanceof net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel
            r7 = 0
            if (r4 == 0) goto L_0x01c0
            r4 = r2
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel r4 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel) r4
            java.lang.String r8 = "response"
            kotlin.g.b.k.c(r4, r8)
            java.util.HashMap r8 = r4.getPenaltyMap()     // Catch:{ Exception -> 0x0164 }
            if (r8 == 0) goto L_0x0161
            java.util.HashMap r8 = r4.getPenaltyMap()     // Catch:{ Exception -> 0x0164 }
            java.lang.String r9 = "response.penaltyMap"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x0164 }
            java.util.Map r8 = (java.util.Map) r8     // Catch:{ Exception -> 0x0164 }
            boolean r8 = r8.isEmpty()     // Catch:{ Exception -> 0x0164 }
            r8 = r8 ^ r6
            if (r8 == 0) goto L_0x0161
            java.util.HashMap r8 = r4.getPenaltyMap()     // Catch:{ Exception -> 0x0164 }
            boolean r8 = r8.containsKey(r0)     // Catch:{ Exception -> 0x0164 }
            if (r8 == 0) goto L_0x0161
            java.util.HashMap r4 = r4.getPenaltyMap()     // Catch:{ Exception -> 0x0164 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0164 }
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel$Penalty r0 = (net.one97.paytm.recharge.model.metro.CJRMetroPenaltyMessageModel.Penalty) r0     // Catch:{ Exception -> 0x0164 }
            if (r0 == 0) goto L_0x0157
            java.lang.String r4 = r0.getTitle()     // Catch:{ Exception -> 0x0164 }
            goto L_0x0158
        L_0x0157:
            r4 = r7
        L_0x0158:
            if (r0 == 0) goto L_0x016d
            java.util.ArrayList r0 = r0.getMessage()     // Catch:{ Exception -> 0x015f }
            goto L_0x016e
        L_0x015f:
            r0 = move-exception
            goto L_0x0166
        L_0x0161:
            r0 = r7
            r4 = r0
            goto L_0x016e
        L_0x0164:
            r0 = move-exception
            r4 = r7
        L_0x0166:
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
        L_0x016d:
            r0 = r7
        L_0x016e:
            if (r0 == 0) goto L_0x01b1
            int r8 = r0.size()
            if (r8 <= 0) goto L_0x01b1
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            java.lang.String r9 = "messageList"
            r8.putStringArrayList(r9, r0)
            java.lang.String r0 = "title"
            r8.putString(r0, r4)
            net.one97.paytm.recharge.metro.c.o r0 = new net.one97.paytm.recharge.metro.c.o
            r0.<init>()
            r0.setArguments(r8)
            java.lang.String r4 = "fjrStationListFragment"
            kotlin.g.b.k.c(r0, r4)
            androidx.fragment.app.j r4 = r20.getSupportFragmentManager()
            androidx.fragment.app.q r4 = r4.a()
            int r8 = net.one97.paytm.recharge.R.id.container
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            java.lang.Class<net.one97.paytm.recharge.metro.c.o> r9 = net.one97.paytm.recharge.metro.c.o.class
            java.lang.String r9 = r9.getSimpleName()
            androidx.fragment.app.q r0 = r4.b(r8, r0, r9)
            androidx.fragment.app.q r0 = r0.a((java.lang.String) r7)
            r0.b()
            goto L_0x01bd
        L_0x01b1:
            r0 = r1
            android.content.Context r0 = (android.content.Context) r0
            int r4 = net.one97.paytm.recharge.R.string.error_metro_mumbai_no_penalty
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r4, r6)
            r0.show()
        L_0x01bd:
            r20.o()
        L_0x01c0:
            net.one97.paytm.recharge.metro.a r4 = r1.f63228a
            if (r4 == 0) goto L_0x0568
            boolean r0 = r2 instanceof net.one97.paytm.common.entity.CJRRechargeCart
            java.lang.String r8 = "SUCCESS"
            if (r0 == 0) goto L_0x0285
            r0 = r2
            net.one97.paytm.common.entity.CJRRechargeCart r0 = (net.one97.paytm.common.entity.CJRRechargeCart) r0
            if (r0 == 0) goto L_0x027f
            net.one97.paytm.common.entity.shopping.CJRCartStatus r2 = r0.getCartStatus()
            if (r2 != 0) goto L_0x01d7
            goto L_0x027f
        L_0x01d7:
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            android.content.Context r2 = (android.content.Context) r2
            android.os.Bundle r2 = net.one97.paytm.recharge.common.utils.az.a((android.content.Context) r2, (net.one97.paytm.common.entity.CJRRechargeCart) r0, (boolean) r5, (boolean) r5)
            java.lang.String r3 = "extra.has.error"
            boolean r3 = r2.getBoolean(r3)
            net.one97.paytm.common.entity.shopping.CJRCartStatus r5 = r0.getCartStatus()
            if (r5 == 0) goto L_0x01f1
            java.lang.String r7 = r5.getResult()
        L_0x01f1:
            boolean r5 = kotlin.m.p.a((java.lang.String) r8, (java.lang.String) r7, (boolean) r6)
            if (r5 == 0) goto L_0x0243
            if (r3 != 0) goto L_0x0243
            r4.f63127d = r0
            net.one97.paytm.recharge.common.utils.ax$a r0 = net.one97.paytm.recharge.common.utils.ax.f61521a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r2 = "mBaseActivity.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            com.paytm.b.a.a r0 = net.one97.paytm.recharge.common.utils.ax.a.a(r0)
            java.lang.String r2 = "sso_token="
            java.lang.String r3 = ""
            java.lang.String r0 = r0.b((java.lang.String) r2, (java.lang.String) r3, (boolean) r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0238
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r4.f63124a
            int r5 = net.one97.paytm.recharge.R.string.please_wait_progress_msg_re
            java.lang.String r3 = r3.getString(r5)
            r0.a((android.content.Context) r2, (java.lang.String) r3)
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            net.one97.paytm.recharge.common.e.ai r2 = (net.one97.paytm.recharge.common.e.ai) r2
            r0.getWalletToken(r2)
            return
        L_0x0238:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.o()
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.s()
            return
        L_0x0243:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.o()
            java.lang.String r0 = "extra.error.title"
            java.lang.String r0 = r2.getString(r0)
            java.lang.String r3 = "extra.error.msg"
            java.lang.String r2 = r2.getString(r3)
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0265
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            int r3 = net.one97.paytm.recharge.R.string.network_error_message_re
            java.lang.String r2 = r2.getString(r3)
        L_0x0265:
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 == 0) goto L_0x0271
            java.lang.String r0 = "utility_hide_title"
        L_0x0271:
            net.one97.paytm.recharge.common.utils.az r3 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r4.f63124a
            android.content.Context r3 = (android.content.Context) r3
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r4 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r5 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.METRO_PENALTY
            net.one97.paytm.recharge.common.utils.az.a(r3, r4, r5, r0, r2)
            return
        L_0x027f:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.o()
            return
        L_0x0285:
            boolean r0 = r2 instanceof net.one97.paytm.common.entity.CJRPGTokenList
            if (r0 == 0) goto L_0x04ff
            net.one97.paytm.recharge.di.helper.CJRRechargeUtilities r0 = net.one97.paytm.recharge.di.helper.CJRRechargeUtilities.INSTANCE
            net.one97.paytm.common.entity.CJRPGTokenList r2 = (net.one97.paytm.common.entity.CJRPGTokenList) r2
            java.lang.String r0 = r0.getPgToken(r2)
            r3.getSimpleName()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "wallet Sso Token ::"
            r2.<init>(r3)
            if (r0 != 0) goto L_0x02a1
            kotlin.g.b.k.a()
        L_0x02a1:
            r2.append(r0)
            com.paytm.utility.b.j()
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 != 0) goto L_0x04f4
            boolean r2 = r4.f63129f
            if (r2 != 0) goto L_0x04f3
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            org.json.JSONObject r8 = new org.json.JSONObject
            r8.<init>()
            org.json.JSONObject r9 = new org.json.JSONObject
            r9.<init>()
            net.one97.paytm.recharge.widgets.c.d r10 = net.one97.paytm.recharge.widgets.c.d.f64967a
            net.one97.paytm.recharge.widgets.model.CJRRechargeErrorModel r19 = net.one97.paytm.recharge.widgets.c.d.a((net.one97.paytm.recharge.widgets.model.ACTION_TYPE) r7, (net.one97.paytm.recharge.widgets.model.ERROR_TYPE) r7)
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r10 = r19.getFlowName()
            if (r10 == 0) goto L_0x02dd
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r11 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.CLP_PROCEED
            java.lang.String r11 = r11.name()
            r10.setActionType(r11)
        L_0x02dd:
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r10 = r19.getFlowName()
            if (r10 == 0) goto L_0x02ec
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r11 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            java.lang.String r11 = r11.name()
            r10.setErrorType(r11)
        L_0x02ec:
            java.lang.String r10 = "product_id"
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r11 = r4.f63126c     // Catch:{ Exception -> 0x04ab }
            if (r11 == 0) goto L_0x02fb
            long r11 = r11.getProductId()     // Catch:{ Exception -> 0x04ab }
            java.lang.Long r11 = java.lang.Long.valueOf(r11)     // Catch:{ Exception -> 0x04ab }
            goto L_0x02fc
        L_0x02fb:
            r11 = r7
        L_0x02fc:
            r8.put(r10, r11)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r10 = "qty"
            r8.put(r10, r6)     // Catch:{ Exception -> 0x04ab }
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ Exception -> 0x04ab }
            r10.<init>()     // Catch:{ Exception -> 0x04ab }
            java.lang.String r11 = "price"
            net.one97.paytm.common.entity.CJRRechargeCart r12 = r4.f63127d     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x031a
            net.one97.paytm.common.entity.shopping.CJRCart r12 = r12.getCart()     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x031a
            java.lang.String r12 = r12.getFinalPrice()     // Catch:{ Exception -> 0x04ab }
            goto L_0x031b
        L_0x031a:
            r12 = r7
        L_0x031b:
            r10.put(r11, r12)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r11 = net.one97.paytm.recharge.common.utils.ab.f61497b     // Catch:{ Exception -> 0x04ab }
            java.lang.String r12 = com.paytm.utility.e.z     // Catch:{ Exception -> 0x04ab }
            r10.put(r11, r12)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r11 = "tokenType"
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r12 = r4.f63125b     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x0335
            int r12 = r12.getCode()     // Catch:{ Exception -> 0x04ab }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ Exception -> 0x04ab }
            goto L_0x0336
        L_0x0335:
            r12 = r7
        L_0x0336:
            r9.put(r11, r12)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r11 = "source_id"
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r12 = r4.f63125b     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x034b
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r12 = r12.getActualSource()     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x034b
            java.lang.String r12 = r12.getId()     // Catch:{ Exception -> 0x04ab }
            goto L_0x034c
        L_0x034b:
            r12 = r7
        L_0x034c:
            r9.put(r11, r12)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r11 = "destination_id"
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r12 = r4.f63125b     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x0360
            net.one97.paytm.recharge.model.metro.CJRMetroStationModel r12 = r12.getNewDestination()     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x0360
            java.lang.String r12 = r12.getId()     // Catch:{ Exception -> 0x04ab }
            goto L_0x0361
        L_0x0360:
            r12 = r7
        L_0x0361:
            r9.put(r11, r12)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r11 = "parentOrderId"
            net.one97.paytm.recharge.model.metro.CJRMetroPenaltyDetailsModel r12 = r4.f63125b     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x0373
            long r12 = r12.getOrderId()     // Catch:{ Exception -> 0x04ab }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ Exception -> 0x04ab }
            goto L_0x0374
        L_0x0373:
            r12 = r7
        L_0x0374:
            r9.put(r11, r12)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r11 = "qrcodeid"
            net.one97.paytm.common.entity.recharge.CJRActiveMetroTicketQRItemModel r12 = r4.f63126c     // Catch:{ Exception -> 0x04ab }
            if (r12 == 0) goto L_0x0381
            java.lang.String r7 = r12.getQrCodeId()     // Catch:{ Exception -> 0x04ab }
        L_0x0381:
            r9.put(r11, r7)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r7 = "meta_data"
            r8.put(r7, r9)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r7 = "configuration"
            r8.put(r7, r10)     // Catch:{ Exception -> 0x04ab }
            net.one97.paytm.recharge.widgets.model.CRUFlowModel r7 = r19.getFlowName()     // Catch:{ Exception -> 0x04ab }
            if (r7 == 0) goto L_0x039b
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x04ab }
            r7.setRequestBody(r9)     // Catch:{ Exception -> 0x04ab }
        L_0x039b:
            r3.put(r8)     // Catch:{ Exception -> 0x04ab }
            java.lang.String r7 = "cart_items"
            r2.put(r7, r3)     // Catch:{ Exception -> 0x04ab }
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.lang.String r5 = "Content-Type"
            java.lang.String r7 = "application/json"
            r3.put(r5, r7)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r5 = r4.f63124a
            android.content.Context r5 = (android.content.Context) r5
            java.lang.String r5 = com.paytm.utility.d.a(r5)
            java.lang.String r7 = "sso_token"
            r3.put(r7, r5)
            net.one97.paytm.recharge.di.helper.c r5 = net.one97.paytm.recharge.di.helper.c.f62654a
            java.lang.String r5 = net.one97.paytm.recharge.di.helper.c.a((org.json.JSONObject) r2)
            boolean r7 = android.webkit.URLUtil.isValidUrl(r5)
            if (r7 == 0) goto L_0x0488
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r7 = r4.f63124a
            android.content.Context r7 = (android.content.Context) r7
            java.lang.String r5 = com.paytm.utility.b.s(r7, r5)
            java.lang.String r7 = com.paytm.utility.b.k()
            android.net.Uri r8 = android.net.Uri.parse(r5)
            java.lang.String r9 = "Uri.parse(url)"
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r9)
            java.lang.String r8 = r8.getQuery()
            java.lang.String r9 = "&client_id="
            if (r8 == 0) goto L_0x0401
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = "&wallet_token="
            r8.append(r5)
            r8.append(r0)
            r8.append(r9)
            r8.append(r7)
            java.lang.String r0 = r8.toString()
            goto L_0x041b
        L_0x0401:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r5)
            java.lang.String r5 = "?wallet_token="
            r8.append(r5)
            r8.append(r0)
            r8.append(r9)
            r8.append(r7)
            java.lang.String r0 = r8.toString()
        L_0x041b:
            java.lang.String r5 = "POST"
            java.lang.String r0 = com.paytm.utility.b.d((java.lang.String) r0, (java.lang.String) r5)
            java.lang.String r13 = net.one97.paytm.recharge.common.utils.ab.b(r0)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x045c
            r4.f63129f = r6
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.c r0 = new net.one97.paytm.recharge.common.f.c
            net.one97.paytm.recharge.metro.a$b r5 = new net.one97.paytm.recharge.metro.a$b
            r5.<init>(r4)
            r14 = r5
            net.one97.paytm.recharge.common.e.ai r14 = (net.one97.paytm.recharge.common.e.ai) r14
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r4 = new net.one97.paytm.common.entity.recharge.CJRRechargePayment
            r4.<init>()
            r15 = r4
            com.paytm.network.model.IJRPaytmDataModel r15 = (com.paytm.network.model.IJRPaytmDataModel) r15
            r16 = 0
            r17 = r3
            java.util.Map r17 = (java.util.Map) r17
            java.lang.String r18 = r2.toString()
            java.lang.String r12 = "metro_checkout"
            r11 = r0
            r11.<init>((java.lang.String) r12, (java.lang.String) r13, (net.one97.paytm.recharge.common.e.ai) r14, (com.paytm.network.model.IJRPaytmDataModel) r15, (java.util.Map<java.lang.String, java.lang.String>) r16, (java.util.Map<java.lang.String, java.lang.String>) r17, (java.lang.String) r18, (java.lang.Object) r19)
            net.one97.paytm.recharge.common.f.a r0 = (net.one97.paytm.recharge.common.f.a) r0
            net.one97.paytm.recharge.common.f.d.b(r0)
            return
        L_0x045c:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.o()
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            net.one97.paytm.recharge.common.f.c r5 = new net.one97.paytm.recharge.common.f.c
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r4 = r4.f63124a
            r14 = r4
            net.one97.paytm.recharge.common.e.ai r14 = (net.one97.paytm.recharge.common.e.ai) r14
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r4 = new net.one97.paytm.common.entity.recharge.CJRRechargePayment
            r4.<init>()
            r15 = r4
            com.paytm.network.model.IJRPaytmDataModel r15 = (com.paytm.network.model.IJRPaytmDataModel) r15
            r16 = 0
            r17 = r3
            java.util.Map r17 = (java.util.Map) r17
            java.lang.String r18 = r2.toString()
            java.lang.String r12 = "metro_checkout"
            r11 = r5
            r11.<init>((java.lang.String) r12, (java.lang.String) r13, (net.one97.paytm.recharge.common.e.ai) r14, (com.paytm.network.model.IJRPaytmDataModel) r15, (java.util.Map<java.lang.String, java.lang.String>) r16, (java.util.Map<java.lang.String, java.lang.String>) r17, (java.lang.String) r18, (java.lang.Object) r19)
            net.one97.paytm.recharge.common.f.a r5 = (net.one97.paytm.recharge.common.f.a) r5
            r0.a((net.one97.paytm.recharge.common.f.a) r5)
            return
        L_0x0488:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.o()
            net.one97.paytm.recharge.common.utils.az r0 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            android.content.Context r0 = (android.content.Context) r0
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r2 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r3 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.METRO_PENALTY
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r5 = r4.f63124a
            int r6 = net.one97.paytm.recharge.R.string.error
            java.lang.String r5 = r5.getString(r6)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r4 = r4.f63124a
            int r6 = net.one97.paytm.recharge.R.string.msg_invalid_url
            java.lang.String r4 = r4.getString(r6)
            net.one97.paytm.recharge.common.utils.az.a(r0, r2, r3, r5, r4)
            goto L_0x04f3
        L_0x04ab:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            com.paytm.utility.q.d(r0)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.o()
            androidx.appcompat.app.c$a r0 = new androidx.appcompat.app.c$a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            android.content.Context r2 = (android.content.Context) r2
            r0.<init>(r2)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            int r3 = net.one97.paytm.recharge.R.string.network_error_heading_re
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            androidx.appcompat.app.c$a r2 = r0.a((java.lang.CharSequence) r2)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r3 = r4.f63124a
            int r6 = net.one97.paytm.recharge.R.string.network_error_message_re
            java.lang.String r3 = r3.getString(r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r2.b((java.lang.CharSequence) r3)
            r0.a((boolean) r5)
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            int r3 = net.one97.paytm.recharge.R.string.ok_re
            java.lang.String r2 = r2.getString(r3)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            net.one97.paytm.recharge.metro.a$a r3 = net.one97.paytm.recharge.metro.a.C1220a.f63131a
            android.content.DialogInterface$OnClickListener r3 = (android.content.DialogInterface.OnClickListener) r3
            r0.a((java.lang.CharSequence) r2, (android.content.DialogInterface.OnClickListener) r3)
            r0.b()
        L_0x04f3:
            return
        L_0x04f4:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.o()
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r0 = r4.f63124a
            r0.s()
            return
        L_0x04ff:
            boolean r0 = r2 instanceof net.one97.paytm.common.entity.recharge.CJRRechargePayment
            if (r0 == 0) goto L_0x0568
            r0 = r2
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r0
            r4.f63128e = r0
            net.one97.paytm.common.entity.recharge.CJRRechargePayment r0 = r4.f63128e
            if (r0 != 0) goto L_0x050f
            kotlin.g.b.k.a()
        L_0x050f:
            java.lang.String r2 = r0.getStatus()
            if (r2 == 0) goto L_0x053e
            java.lang.String r2 = r0.getStatus()
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r8, (boolean) r6)
            if (r2 == 0) goto L_0x053e
            r3.getSimpleName()
            com.paytm.utility.b.j()
            boolean r2 = net.one97.paytm.recharge.common.utils.ab.a((net.one97.paytm.common.entity.recharge.CJRRechargePayment) r0)
            if (r2 == 0) goto L_0x0535
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener r4 = (net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener) r4
            net.one97.paytm.recharge.common.utils.ba.a((android.content.Context) r2, (net.one97.paytm.common.entity.recharge.CJRRechargePayment) r0, (net.one97.paytm.nativesdk.Utils.FetchPayOptionsListener) r4)
            return
        L_0x0535:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            r2.o()
            r4.a(r0)
            return
        L_0x053e:
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            r2.o()
            net.one97.paytm.recharge.common.utils.az r2 = net.one97.paytm.recharge.common.utils.az.f61525a
            net.one97.paytm.recharge.common.activity.CJRRechargeBaseActivity r2 = r4.f63124a
            android.content.Context r2 = (android.content.Context) r2
            net.one97.paytm.recharge.widgets.model.ERROR_TYPE r3 = net.one97.paytm.recharge.widgets.model.ERROR_TYPE.UNDEFINED
            net.one97.paytm.recharge.widgets.model.ACTION_TYPE r4 = net.one97.paytm.recharge.widgets.model.ACTION_TYPE.METRO_PENALTY
            com.paytm.network.model.CJRError r5 = r0.getError()
            java.lang.String r6 = "rechargePayment.error"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            java.lang.String r5 = r5.getTitle()
            com.paytm.network.model.CJRError r0 = r0.getError()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r6)
            java.lang.String r0 = r0.getMessage()
            net.one97.paytm.recharge.common.utils.az.a(r2, r3, r4, r5, r0)
        L_0x0568:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.metro.activity.AJRMetroTicketSupportActivity.a_(java.lang.String, com.paytm.network.model.IJRPaytmDataModel, java.lang.Object):void");
    }

    public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
        CJRRechargeErrorModel cJRRechargeErrorModel;
        ACTION_TYPE action_type;
        ERROR_TYPE error_type;
        k.c(str, "tag");
        o();
        if (iJRPaytmDataModel instanceof CJRMetroPenaltyDetailsModel) {
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
                Activity activity = this;
                if (networkCustomError == null) {
                    k.a();
                }
                CJRRechargeUtilities.handleError$default(cJRRechargeUtilities, str, activity, (Fragment) null, networkCustomError, false, 104, obj, 20, (Object) null);
            } else if (networkCustomError == null || networkCustomError.getStatusCode() != 422 || TextUtils.isEmpty(networkCustomError.getAlertMessage())) {
                if (obj instanceof CJRRechargeErrorModel) {
                    az azVar = az.f61525a;
                    az.a((CJRRechargeErrorModel) obj);
                }
                finish();
            } else {
                String str2 = null;
                if (obj instanceof CJRRechargeErrorModel) {
                    CJRRechargeErrorModel cJRRechargeErrorModel2 = (CJRRechargeErrorModel) obj;
                    ACTION_TYPE.Companion companion = ACTION_TYPE.Companion;
                    CRUFlowModel flowName = cJRRechargeErrorModel2.getFlowName();
                    if (flowName != null) {
                        str2 = flowName.getActionType();
                    }
                    cJRRechargeErrorModel = cJRRechargeErrorModel2;
                    action_type = companion.getActionType(str2, ACTION_TYPE.METRO_PENALTY);
                } else {
                    action_type = null;
                    cJRRechargeErrorModel = null;
                }
                com.paytm.utility.g.a((g.a) new b(this));
                az azVar2 = az.f61525a;
                Context context = this;
                if (cJRRechargeErrorModel == null || (error_type = cJRRechargeErrorModel.getErrorType()) == null) {
                    error_type = ERROR_TYPE.UNDEFINED;
                }
                az.a(context, error_type, action_type, getString(R.string.error_heading), networkCustomError.getAlertMessage(), false, cJRRechargeErrorModel, false, 1504);
            }
        } else if (iJRPaytmDataModel instanceof CJRMetroPenaltyMessageModel) {
            if (CJRRechargeUtilities.INSTANCE.isAuthError(networkCustomError)) {
                CJRRechargeUtilities cJRRechargeUtilities2 = CJRRechargeUtilities.INSTANCE;
                Activity activity2 = this;
                if (networkCustomError == null) {
                    k.a();
                }
                CJRRechargeUtilities.handleError$default(cJRRechargeUtilities2, str, activity2, (Fragment) null, networkCustomError, false, 105, obj, 20, (Object) null);
                return;
            }
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar3 = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
            finish();
        } else if (networkCustomError != null) {
            CJRRechargeUtilities.handleError$default(CJRRechargeUtilities.INSTANCE, str, this, (Fragment) null, networkCustomError, false, 104, obj, 20, (Object) null);
        } else {
            if (obj instanceof CJRRechargeErrorModel) {
                az azVar4 = az.f61525a;
                az.a((CJRRechargeErrorModel) obj);
            }
            finish();
        }
    }

    static final class b implements g.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AJRMetroTicketSupportActivity f63235a;

        b(AJRMetroTicketSupportActivity aJRMetroTicketSupportActivity) {
            this.f63235a = aJRMetroTicketSupportActivity;
        }

        public final void onOkClick() {
            this.f63235a.finish();
        }
    }

    public final void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void d() {
        Context context = this;
        if (com.paytm.utility.b.c(context)) {
            a(context, getString(R.string.please_wait_progress_msg_re));
            d dVar = d.f64967a;
            CJRRechargeErrorModel a2 = d.a(ACTION_TYPE.GET_PENALTY_MSG, ERROR_TYPE.UNDEFINED);
            CRUFlowModel flowName = a2.getFlowName();
            if (flowName != null) {
                CJRActiveMetroTicketModel cJRActiveMetroTicketModel = this.f63229b;
                if (cJRActiveMetroTicketModel == null) {
                    k.a("mActiveTicket");
                }
                flowName.setVariantType(cJRActiveMetroTicketModel != null ? cJRActiveMetroTicketModel.getProductType() : null);
            }
            net.one97.paytm.recharge.metro.f.a.a("fetch_metro_panality_message", context, (ai) this, this.f63233h, (Object) a2);
            return;
        }
        Toast.makeText(context, R.string.network_error_heading_re, 0).show();
    }
}
