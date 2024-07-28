package net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.b;

import android.content.Context;
import android.widget.Toast;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.mapping.d;
import net.one97.paytm.bankCommon.model.PBCJRAddress;
import net.one97.paytm.common.entity.upgradeKyc.PermanentAddress;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c;
import net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.view.a;
import net.one97.paytm.paymentsBank.chequebook.utils.CbCataloguePayLoad;
import net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.utils.n;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONObject;

public final class a implements b, c.a {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<PBCJRAddress> f17685a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private PermanentAddress f17686b;

    /* renamed from: c  reason: collision with root package name */
    private int f17687c = 1;

    /* renamed from: d  reason: collision with root package name */
    private h f17688d;

    /* renamed from: e  reason: collision with root package name */
    private List<CbCataloguePayLoad> f17689e;

    /* renamed from: f  reason: collision with root package name */
    private String f17690f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f17691g;

    /* renamed from: h  reason: collision with root package name */
    private String f17692h = "";

    /* renamed from: i  reason: collision with root package name */
    private final String f17693i;
    private String j;
    private ChequeBookFinResponse k;
    private final g l;
    private final c.b m;
    private Context n;

    public final void a() {
    }

    public final void b() {
    }

    public a(g gVar, c.b bVar, Context context) {
        k.c(bVar, "requestCbView");
        k.c(context, "mContext");
        this.l = gVar;
        this.m = bVar;
        this.n = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.f17693i = simpleName;
        this.j = "";
    }

    public final void a(a.C0280a aVar, int i2) {
        PBCJRAddress pBCJRAddress = this.f17685a.get(i2);
        k.a((Object) pBCJRAddress, "addressTableList.get(position)");
        PBCJRAddress pBCJRAddress2 = pBCJRAddress;
        if (aVar != null) {
            String name = pBCJRAddress2.getName();
            k.a((Object) name, "rowValue.name");
            k.c(name, "mName");
            aVar.f17714b.setText(name);
        }
        if (aVar != null) {
            String address1 = pBCJRAddress2.getAddress1();
            k.a((Object) address1, "rowValue.address1");
            k.c(address1, "mFullAddress");
            aVar.f17715c.setText(address1);
        }
        if (aVar != null) {
            String mobile = pBCJRAddress2.getMobile();
            k.a((Object) mobile, "rowValue.mobile");
            k.c(mobile, "mContact");
            aVar.f17716d.setText(mobile);
        }
    }

    public final int f() {
        return this.f17685a.size();
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.m.a(false);
        c.b bVar = this.m;
        String string = this.n.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.n.getString(R.string.some_went_wrong);
        k.a((Object) string2, "mContext.getString(R.string.some_went_wrong)");
        bVar.c(string, string2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v7, types: [com.paytm.network.a] */
    /* JADX WARNING: type inference failed for: r3v10, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r3v12 */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* JADX WARNING: type inference failed for: r3v14 */
    /* JADX WARNING: type inference failed for: r3v15 */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        r0 = r0.getAddress();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r15) {
        /*
            r14 = this;
            if (r15 == 0) goto L_0x0409
            boolean r0 = r15 instanceof net.one97.paytm.common.entity.CJRAadharPanGet
            java.lang.String r1 = "CB_ADDRESS_RESPONSE"
            java.lang.String r2 = "mContext.getString(R.string.some_went_wrong)"
            r3 = 0
            java.lang.String r4 = "mContext.getString(R.string.error)"
            r5 = 0
            if (r0 == 0) goto L_0x012c
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            r0.a(r5)
            net.one97.paytm.common.entity.CJRAadharPanGet r15 = (net.one97.paytm.common.entity.CJRAadharPanGet) r15
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r15.getCersaiInfo()
            if (r0 == 0) goto L_0x0026
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x0026
            net.one97.paytm.common.entity.upgradeKyc.PermanentAddress r0 = r0.getPermanentAddress()
            goto L_0x0027
        L_0x0026:
            r0 = r3
        L_0x0027:
            if (r0 == 0) goto L_0x0110
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r0 = r15.getCersaiInfo()
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.common.entity.upgradeKyc.Address r0 = r0.getAddress()
            if (r0 == 0) goto L_0x003a
            net.one97.paytm.common.entity.upgradeKyc.PermanentAddress r0 = r0.getPermanentAddress()
            goto L_0x003b
        L_0x003a:
            r0 = r3
        L_0x003b:
            if (r0 != 0) goto L_0x0040
            kotlin.g.b.k.a()
        L_0x0040:
            r14.f17686b = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = r0.getStreet1()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r5 = " , "
            if (r4 != 0) goto L_0x005f
            java.lang.String r4 = r0.getStreet1()
            r2.append(r4)
            r2.append(r5)
        L_0x005f:
            java.lang.String r4 = r0.getStreet2()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r6 = ", "
            if (r4 != 0) goto L_0x0077
            java.lang.String r4 = r0.getStreet2()
            r2.append(r4)
            r2.append(r6)
        L_0x0077:
            java.lang.String r4 = r0.getLocality()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x008d
            java.lang.String r4 = r0.getLocality()
            r2.append(r4)
            r2.append(r5)
        L_0x008d:
            java.lang.String r4 = r0.getCity()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00a3
            java.lang.String r4 = r0.getCity()
            r2.append(r4)
            r2.append(r6)
        L_0x00a3:
            java.lang.String r4 = r0.getState()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00b9
            java.lang.String r4 = r0.getState()
            r2.append(r4)
            r2.append(r6)
        L_0x00b9:
            java.lang.String r4 = r0.getPostalCode()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x00d1
            java.lang.String r0 = r0.getPostalCode()
            r2.append(r0)
            java.lang.String r0 = "."
            r2.append(r0)
        L_0x00d1:
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "builder.toString()"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r2 = r14.m
            java.lang.String r4 = r15.getName()
            java.lang.String r5 = "response.name"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            r2.b(r4, r0)
            net.one97.paytm.paymentsBank.chequebook.utils.h r0 = r14.f17688d
            if (r0 == 0) goto L_0x010f
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            net.one97.paytm.common.entity.upgradeKyc.CersaiDetails r15 = r15.getCersaiInfo()
            if (r15 == 0) goto L_0x0101
            net.one97.paytm.common.entity.upgradeKyc.Address r15 = r15.getAddress()
            if (r15 == 0) goto L_0x0101
            net.one97.paytm.common.entity.upgradeKyc.PermanentAddress r3 = r15.getPermanentAddress()
        L_0x0101:
            if (r3 != 0) goto L_0x0106
            kotlin.g.b.k.a()
        L_0x0106:
            java.lang.String r15 = r0.a((java.lang.Object) r3)
            android.content.Context r0 = r14.n
            net.one97.paytm.paymentsBank.chequebook.utils.h.a(r1, r15, r0)
        L_0x010f:
            return
        L_0x0110:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            android.content.Context r0 = r14.n
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r0.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r1 = r14.n
            int r3 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r1 = r1.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r15.c(r0, r1)
            return
        L_0x012c:
            boolean r0 = r15 instanceof net.one97.paytm.bankCommon.model.PBKYCTncAccept
            java.lang.String r6 = "response.message"
            r7 = 1
            if (r0 == 0) goto L_0x01c4
            net.one97.paytm.bankCommon.model.PBKYCTncAccept r15 = (net.one97.paytm.bankCommon.model.PBKYCTncAccept) r15
            java.lang.String r0 = r15.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r1 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r1 = net.one97.paytm.paymentsBank.chequebook.utils.e.P()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r7)
            if (r0 == 0) goto L_0x017f
            java.lang.String r0 = r15.getResponseCode()
            java.lang.String r1 = "2004"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x017f
            net.one97.paytm.paymentsBank.chequebook.utils.g r7 = r14.l
            if (r7 == 0) goto L_0x016b
            android.content.Context r8 = r14.n
            com.paytm.network.a$c r10 = com.paytm.network.a.c.PAYMENTSBANK
            r11 = r14
            com.paytm.network.listener.b r11 = (com.paytm.network.listener.b) r11
            com.paytm.network.a$b r12 = com.paytm.network.a.b.USER_FACING
            java.lang.String r13 = r14.f17690f
            if (r13 != 0) goto L_0x0165
            kotlin.g.b.k.a()
        L_0x0165:
            java.lang.String r9 = "Request Cheque Book"
            com.paytm.network.a r3 = r7.a((android.content.Context) r8, (java.lang.String) r9, (com.paytm.network.a.c) r10, (com.paytm.network.listener.b) r11, (com.paytm.network.a.b) r12, (java.lang.String) r13)
        L_0x016b:
            android.content.Context r15 = r14.n
            boolean r15 = com.paytm.utility.b.c((android.content.Context) r15)
            if (r15 == 0) goto L_0x0179
            if (r3 == 0) goto L_0x0178
            r3.a()
        L_0x0178:
            return
        L_0x0179:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            r15.a(r5)
            return
        L_0x017f:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            r0.a(r5)
            java.lang.String r0 = r15.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x01a8
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            android.content.Context r1 = r14.n
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r15 = r15.getMessage()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r0.c(r1, r15)
            return
        L_0x01a8:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            android.content.Context r0 = r14.n
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r0.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r1 = r14.n
            int r3 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r1 = r1.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r15.c(r0, r1)
            return
        L_0x01c4:
            boolean r0 = r15 instanceof net.one97.paytm.bankCommon.model.PBKYCFetchTnc
            java.lang.String r8 = "error"
            if (r0 == 0) goto L_0x025b
            net.one97.paytm.bankCommon.model.PBKYCFetchTnc r15 = (net.one97.paytm.bankCommon.model.PBKYCFetchTnc) r15
            java.lang.String r0 = r15.getStatus()
            if (r0 == 0) goto L_0x0409
            java.lang.String r0 = r15.getStatus()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r8, (boolean) r7)
            if (r0 == 0) goto L_0x021c
            java.lang.String r0 = r15.getMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0200
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            android.content.Context r1 = r14.n
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r15 = r15.getMessage()
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r6)
            r0.c(r1, r15)
            return
        L_0x0200:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            android.content.Context r0 = r14.n
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r0.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r1 = r14.n
            int r3 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r1 = r1.getString(r3)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r15.c(r0, r1)
            return
        L_0x021c:
            java.lang.String r0 = r15.getStatus()
            java.lang.String r1 = "success"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r7)
            if (r0 == 0) goto L_0x025a
            java.util.ArrayList r0 = r15.getTncDataList()
            if (r0 == 0) goto L_0x025a
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r7
            if (r0 != r7) goto L_0x025a
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            java.util.ArrayList r1 = r15.getTncDataList()
            java.lang.String r2 = "response.tncDataList"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r0.a((java.util.ArrayList<net.one97.paytm.bankCommon.model.PBTncData>) r1)
            java.util.ArrayList r15 = r15.getTncDataList()
            if (r15 == 0) goto L_0x0257
            java.lang.Object r15 = r15.get(r5)
            net.one97.paytm.bankCommon.model.PBTncData r15 = (net.one97.paytm.bankCommon.model.PBTncData) r15
            if (r15 == 0) goto L_0x0257
            int r7 = r15.getVersion()
        L_0x0257:
            r14.f17687c = r7
        L_0x025a:
            return
        L_0x025b:
            boolean r0 = r15 instanceof net.one97.paytm.bankCommon.model.PBCJRAddresses
            if (r0 == 0) goto L_0x02ac
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            r0.a(r5)
            net.one97.paytm.bankCommon.model.PBCJRAddresses r15 = (net.one97.paytm.bankCommon.model.PBCJRAddresses) r15
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            r0.a(r5)
            if (r15 == 0) goto L_0x02a1
            java.util.ArrayList<net.one97.paytm.bankCommon.model.PBCJRAddress> r0 = r14.f17685a
            r0.clear()
            java.util.ArrayList<net.one97.paytm.bankCommon.model.PBCJRAddress> r0 = r14.f17685a
            net.one97.paytm.bankCommon.model.PBCJRAddressList r2 = r15.getAddress()
            java.util.Collection r2 = (java.util.Collection) r2
            r0.addAll(r2)
            java.util.ArrayList<net.one97.paytm.bankCommon.model.PBCJRAddress> r0 = r14.f17685a
            int r0 = r0.size()
            if (r0 == 0) goto L_0x02a1
            net.one97.paytm.paymentsBank.chequebook.utils.h r0 = r14.f17688d
            if (r0 == 0) goto L_0x02a1
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            java.util.ArrayList<net.one97.paytm.bankCommon.model.PBCJRAddress> r2 = r14.f17685a
            java.lang.Object r2 = r2.get(r5)
            java.lang.String r0 = r0.a((java.lang.Object) r2)
            java.lang.String r0 = r0.toString()
            android.content.Context r2 = r14.n
            net.one97.paytm.paymentsBank.chequebook.utils.h.a(r1, r0, r2)
        L_0x02a1:
            net.one97.paytm.bankCommon.model.PBCJRAddressList r15 = r15.getAddress()
            int r15 = r15.size()
            if (r15 > 0) goto L_0x0409
            return
        L_0x02ac:
            boolean r0 = r15 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbCatalogueResponse
            if (r0 == 0) goto L_0x02d8
            net.one97.paytm.paymentsBank.chequebook.utils.CbCatalogueResponse r15 = (net.one97.paytm.paymentsBank.chequebook.utils.CbCatalogueResponse) r15
            java.util.List r15 = r15.getCataloguePayload()
            if (r15 != 0) goto L_0x02bb
            kotlin.g.b.k.a()
        L_0x02bb:
            r14.f17689e = r15
            java.util.List<net.one97.paytm.paymentsBank.chequebook.utils.CbCataloguePayLoad> r15 = r14.f17689e
            java.lang.String r0 = "cbCatPayload"
            if (r15 != 0) goto L_0x02c6
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x02c6:
            if (r15 == 0) goto L_0x02d4
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            java.util.List<net.one97.paytm.paymentsBank.chequebook.utils.CbCataloguePayLoad> r1 = r14.f17689e
            if (r1 != 0) goto L_0x02d1
            kotlin.g.b.k.a((java.lang.String) r0)
        L_0x02d1:
            r15.a((java.util.List<net.one97.paytm.paymentsBank.chequebook.utils.CbCataloguePayLoad>) r1)
        L_0x02d4:
            r14.g()
            return
        L_0x02d8:
            boolean r0 = r15 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidateResponse
            if (r0 == 0) goto L_0x031b
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            r0.a(r5)
            net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidateResponse r15 = (net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidateResponse) r15
            net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidatePayLoad r0 = r15.getPreValidatePayload()
            if (r0 == 0) goto L_0x0409
            java.lang.String r1 = r0.getErrorMessage()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0301
            java.lang.String r15 = r15.getRequestId()
            r14.j = r15
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            r15.b()
            return
        L_0x0301:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            android.content.Context r1 = r14.n
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r0 = r0.getErrorMessage()
            if (r0 != 0) goto L_0x0317
            kotlin.g.b.k.a()
        L_0x0317:
            r15.a(r1, r0)
            return
        L_0x031b:
            boolean r0 = r15 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse
            if (r0 == 0) goto L_0x03d6
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            r0.a(r5)
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse r15 = (net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse) r15
            java.lang.Integer r0 = r15.getResponseCode()
            if (r0 != 0) goto L_0x032d
            goto L_0x035b
        L_0x032d:
            int r0 = r0.intValue()
            r1 = 437(0x1b5, float:6.12E-43)
            if (r0 != r1) goto L_0x035b
            java.lang.String r0 = r15.getResponseMessage()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x035b
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            android.content.Context r1 = r14.n
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            java.lang.String r15 = r15.getResponseMessage()
            if (r15 != 0) goto L_0x0357
            kotlin.g.b.k.a()
        L_0x0357:
            r0.c(r1, r15)
            return
        L_0x035b:
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r0 = r15.getCheckOutPayload()
            if (r0 == 0) goto L_0x0366
            java.lang.String r0 = r0.getErrorMessage()
            goto L_0x0367
        L_0x0366:
            r0 = r3
        L_0x0367:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x038f
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            android.content.Context r1 = r14.n
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r15 = r15.getCheckOutPayload()
            if (r15 == 0) goto L_0x0386
            java.lang.String r3 = r15.getErrorMessage()
        L_0x0386:
            if (r3 != 0) goto L_0x038b
            kotlin.g.b.k.a()
        L_0x038b:
            r0.a(r1, r3)
            return
        L_0x038f:
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r0 = r15.getCheckOutPayload()
            if (r0 == 0) goto L_0x039a
            java.lang.String r0 = r0.getOrderId()
            goto L_0x039b
        L_0x039a:
            r0 = r3
        L_0x039b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x03b8
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r15 = r15.getCheckOutPayload()
            if (r15 == 0) goto L_0x03af
            java.lang.String r3 = r15.getOrderId()
        L_0x03af:
            if (r3 != 0) goto L_0x03b4
            kotlin.g.b.k.a()
        L_0x03b4:
            r0.a((java.lang.String) r3)
            return
        L_0x03b8:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r15 = r14.m
            android.content.Context r0 = r14.n
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r0.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            android.content.Context r1 = r14.n
            int r2 = net.one97.paytm.paymentsBank.R.string.pb_something_wrong_try_again
            java.lang.String r1 = r1.getString(r2)
            java.lang.String r2 = "mContext.getString(R.str…omething_wrong_try_again)"
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
            r15.a(r0, r1)
            return
        L_0x03d6:
            boolean r0 = r15 instanceof net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames
            if (r0 == 0) goto L_0x0409
            net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames r15 = (net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames) r15
            java.lang.String r0 = r15.getStatus()
            java.lang.String r1 = "SUCCESS"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r5)
            if (r0 == 0) goto L_0x03ee
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            r0.a((net.one97.paytm.paymentsBank.chequebook.utils.ChequeBookNames) r15)
            return
        L_0x03ee:
            android.content.Context r15 = r14.n
            int r0 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r15 = r15.getString(r0)
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r14.m
            kotlin.g.b.k.a((java.lang.Object) r15, (java.lang.String) r8)
            android.content.Context r1 = r14.n
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r0.d(r15, r1)
        L_0x0409:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.b.a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void c() {
        g gVar = this.l;
        com.paytm.network.a a2 = gVar != null ? gVar.a((b) this) : null;
        if (!com.paytm.utility.b.c(this.n)) {
            this.n.getString(R.string.no_internet);
        } else if (a2 != null) {
            a2.a();
        }
    }

    public final void d() {
        ChequeBookResponse response;
        ChequeBookSignature signature;
        String status;
        ChequeBookFinResponse chequeBookFinResponse;
        ChequeBookResponse response2;
        ChequeBookSignature signature2;
        String status2;
        ChequeBookResponse response3;
        ChequeBookSignature signature3;
        String status3;
        this.f17688d = h.a(this.n);
        f fVar = new f();
        com.paytm.network.a aVar = null;
        this.f17691g = this.f17688d != null ? h.a("CB_KEY_FIN_RESPONSE") : null;
        this.k = (ChequeBookFinResponse) fVar.a(this.f17691g, ChequeBookFinResponse.class);
        ChequeBookFinResponse chequeBookFinResponse2 = this.k;
        if (!((chequeBookFinResponse2 != null && (response3 = chequeBookFinResponse2.getResponse()) != null && (signature3 = response3.getSignature()) != null && (status3 = signature3.getStatus()) != null && p.a(status3, "ACCEPTED", true)) || (chequeBookFinResponse = this.k) == null || (response2 = chequeBookFinResponse.getResponse()) == null || (signature2 = response2.getSignature()) == null || (status2 = signature2.getStatus()) == null)) {
            p.a(status2, "APPROVAL_PENDING", true);
        }
        ChequeBookFinResponse chequeBookFinResponse3 = this.k;
        if (!(chequeBookFinResponse3 == null || (response = chequeBookFinResponse3.getResponse()) == null || (signature = response.getSignature()) == null || (status = signature.getStatus()) == null)) {
            p.a(status, "ACCEPTED", true);
        }
        g gVar = this.l;
        if (gVar != null) {
            aVar = gVar.a(this.n, "Request Cheque Book", a.c.PAYMENTSBANK, a.b.USER_FACING, (b) this);
        }
        if (com.paytm.utility.b.c(this.n)) {
            this.m.a(true);
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        this.m.a(false);
    }

    public final void g() {
        g gVar = this.l;
        com.paytm.network.a b2 = gVar != null ? gVar.b(this, "Request Cheque Book") : null;
        if (!com.paytm.utility.b.c(this.n)) {
            this.m.a(false);
        } else if (b2 != null) {
            b2.a();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000b, code lost:
        r1 = (r1 = r1.getResponse()).getSignature();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean i() {
        /*
            r3 = this;
            r0 = 1
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse r1 = r3.k     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x0016
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse r1 = r1.getResponse()     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x0016
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature r1 = r1.getSignature()     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x0016
            java.lang.String r1 = r1.getStatus()     // Catch:{ Exception -> 0x002c }
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            if (r1 == 0) goto L_0x002b
            java.lang.String r2 = "UPLOADED"
            boolean r2 = r1.equals(r2)     // Catch:{ Exception -> 0x002c }
            if (r2 != 0) goto L_0x002b
            java.lang.String r2 = "REJECTED"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x002c }
            if (r1 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            return r0
        L_0x002b:
            r0 = 0
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.b.a.i():boolean");
    }

    public final String j() {
        ChequeBookResponse response;
        ChequeBookSignature signature;
        ChequeBookFinResponse chequeBookFinResponse = this.k;
        if (chequeBookFinResponse == null || (response = chequeBookFinResponse.getResponse()) == null || (signature = response.getSignature()) == null) {
            return null;
        }
        return signature.getStatus();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r0 = (r0 = r0.getResponse()).getSignature();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r4 = this;
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse r0 = r4.k
            r1 = 0
            if (r0 == 0) goto L_0x0016
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookResponse r0 = r0.getResponse()
            if (r0 == 0) goto L_0x0016
            net.one97.paytm.paymentsBank.chequebook.model.ChequeBookSignature r0 = r0.getSignature()
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = r0.getStatus()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            if (r0 == 0) goto L_0x0055
            java.lang.String r2 = "UPLOADED"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x0055
            java.lang.String r2 = "REJECTED"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x002a
            goto L_0x0055
        L_0x002a:
            net.one97.paytm.paymentsBank.chequebook.utils.g r0 = r4.l
            if (r0 == 0) goto L_0x0039
            int r1 = r4.f17687c
            r2 = r4
            com.paytm.network.listener.b r2 = (com.paytm.network.listener.b) r2
            java.lang.String r3 = "Cheque_TnC"
            com.paytm.network.a r1 = r0.a((int) r1, (java.lang.String) r3, (com.paytm.network.listener.b) r2)
        L_0x0039:
            android.content.Context r0 = r4.n
            boolean r0 = com.paytm.utility.b.c((android.content.Context) r0)
            if (r0 == 0) goto L_0x004d
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r4.m
            r2 = 1
            r0.a(r2)
            if (r1 == 0) goto L_0x004c
            r1.a()
        L_0x004c:
            return
        L_0x004d:
            android.content.Context r0 = r4.n
            int r1 = net.one97.paytm.paymentsBank.R.string.no_internet
            r0.getString(r1)
            return
        L_0x0055:
            net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.a.c$b r0 = r4.m
            java.lang.String r1 = ""
            r0.b(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.orderFlow.requestchequebook.b.a.e():void");
    }

    public final void h() {
        g gVar = this.l;
        com.paytm.network.a aVar = null;
        if (gVar != null) {
            Context context = this.n;
            b bVar = this;
            k.c(context, "context");
            k.c(bVar, "apiListener");
            k.c("Suggested Names", SDKConstants.EVENT_KEY_SCREEN_NAME);
            String o = n.o();
            Map hashMap = new HashMap();
            e eVar = e.f17951a;
            String f2 = e.f();
            String a2 = d.a(gVar.f17966a);
            k.a((Object) a2, "CJRServerUtility.getSSOToken(mContext)");
            hashMap.put(f2, a2);
            hashMap.put("Accept", "application/json");
            hashMap.put("Client-Id", UpiConstants.B2C_ANDROID);
            hashMap.put("Content-Type", "application/json");
            new JSONObject();
            if (com.paytm.utility.b.c(context)) {
                aVar = new com.paytm.network.b().a(context).a(a.c.PAYMENTSBANK).a(a.b.USER_FACING).a(a.C0715a.POST).c("Suggested Names").a(o).a((Map<String, String>) hashMap).a(false).a((IJRPaytmDataModel) new ChequeBookNames((String) null, (List) null, (String) null, (String) null, 15, (kotlin.g.b.g) null)).a(bVar).l();
            }
        }
        if (com.paytm.utility.b.c(this.n)) {
            if (aVar == null) {
                k.a();
            }
            aVar.a();
        }
    }

    public final void a(CbCataloguePayLoad cbCataloguePayLoad) {
        k.c(cbCataloguePayLoad, "get");
        this.f17690f = cbCataloguePayLoad.getProductId();
        if (this.f17688d == null) {
            k.a();
        }
        h.a("PRODUCT_ID", this.f17690f, this.n);
    }

    public final void a(String str, String str2) {
        com.paytm.network.a aVar;
        k.c(str, "txnToken");
        k.c(str2, "cbName");
        if (this.f17686b == null) {
            Toast.makeText(this.n, "Please Select Adress To proceed", 0).show();
            return;
        }
        g gVar = this.l;
        if (gVar != null) {
            Context context = this.n;
            String str3 = this.j;
            a.c cVar = a.c.PAYMENTSBANK;
            a.b bVar = a.b.USER_FACING;
            b bVar2 = this;
            PermanentAddress permanentAddress = this.f17686b;
            if (permanentAddress == null) {
                k.a();
            }
            String str4 = this.f17690f;
            if (str4 == null) {
                k.a();
            }
            aVar = gVar.a(context, str, str3, "RequestCB", cVar, bVar, bVar2, permanentAddress, str4, "", str2, false);
        } else {
            aVar = null;
        }
        if (com.paytm.utility.b.c(this.n)) {
            c.b bVar3 = this.m;
            if (bVar3 != null) {
                bVar3.a(true);
            }
            if (aVar == null) {
                k.a();
            }
            aVar.a();
            return;
        }
        c.b bVar4 = this.m;
        if (bVar4 != null) {
            bVar4.a(false);
        }
    }
}
