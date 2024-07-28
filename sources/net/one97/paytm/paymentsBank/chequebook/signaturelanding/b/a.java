package net.one97.paytm.paymentsBank.chequebook.signaturelanding.b;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.Toast;
import com.google.gsonhtcfix.f;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.model.PBTncData;
import net.one97.paytm.common.entity.upgradeKyc.PermanentAddress;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.view.SignatureLandingActivity;
import net.one97.paytm.paymentsBank.chequebook.utils.CbCreateSignature;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.f;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.chequebook.utils.h;
import net.one97.paytm.paymentsBank.utils.n;

public final class a implements b, a.C0285a {

    /* renamed from: a  reason: collision with root package name */
    private h f17758a;

    /* renamed from: b  reason: collision with root package name */
    private PermanentAddress f17759b;

    /* renamed from: c  reason: collision with root package name */
    private String f17760c = "";

    /* renamed from: d  reason: collision with root package name */
    private int f17761d = 1;

    /* renamed from: e  reason: collision with root package name */
    private String f17762e;

    /* renamed from: f  reason: collision with root package name */
    private Boolean f17763f = Boolean.TRUE;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<PBTncData> f17764g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private boolean f17765h;

    /* renamed from: i  reason: collision with root package name */
    private final String f17766i;
    private String j;
    private String k;
    private boolean l;
    private boolean m;
    private final g n;
    private final a.b o;
    private final Context p;

    public final void b() {
    }

    public a(g gVar, a.b bVar, Context context) {
        k.c(bVar, "signatureLandingView");
        k.c(context, "mContext");
        this.n = gVar;
        this.o = bVar;
        this.p = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.f17766i = simpleName;
        this.j = "";
        this.k = "";
    }

    public final void b(String str) {
        this.f17762e = str;
    }

    public final void a(boolean z) {
        this.f17763f = Boolean.valueOf(z);
    }

    public final String e() {
        return this.f17762e;
    }

    public final Boolean f() {
        return this.f17763f;
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.o.a(false);
        if (iJRPaytmDataModel instanceof CbCreateSignature) {
            this.o.c();
        } else if (iJRPaytmDataModel != null && (iJRPaytmDataModel instanceof CBGetSignatureResponse) && i2 == 404) {
            a.b bVar = this.o;
            if (bVar != null) {
                bVar.d();
            }
        } else if (!(iJRPaytmDataModel instanceof GetDocumentCreateResponse) || !((GetDocumentCreateResponse) iJRPaytmDataModel).isDocumentGetApi()) {
            if (!(iJRPaytmDataModel instanceof DocumentCreateResponse) || !((DocumentCreateResponse) iJRPaytmDataModel).isAcknowledgeSig()) {
                this.o.a(networkCustomError);
            } else {
                this.o.a(networkCustomError);
            }
        } else if (i2 == 404) {
            a.b bVar2 = this.o;
            if (bVar2 != null) {
                bVar2.a(Boolean.FALSE);
            }
        } else {
            a.b bVar3 = this.o;
            if (bVar3 != null) {
                bVar3.a(Boolean.TRUE);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.lang.Integer} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v5, types: [com.paytm.network.a] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.paytm.network.a] */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r14) {
        /*
            r13 = this;
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r1 = 0
            r0.a(r1)
            if (r14 == 0) goto L_0x053b
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbSignatureResponse
            if (r0 == 0) goto L_0x0039
            net.one97.paytm.paymentsBank.chequebook.utils.CbSignatureResponse r14 = (net.one97.paytm.paymentsBank.chequebook.utils.CbSignatureResponse) r14
            net.one97.paytm.paymentsBank.chequebook.utils.CbSignaturePayload r14 = r14.getSignaturePayload()
            if (r14 == 0) goto L_0x0020
            java.lang.String r14 = r14.getUrl()
            if (r14 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.b((java.lang.String) r14)
            return
        L_0x0020:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.c()
            android.content.Context r14 = r13.p
            int r0 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r14.getString(r0)
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.pb_something_wrong_try_again
            java.lang.String r1 = r1.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r14, (java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x0039:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidateResponse
            java.lang.String r2 = ""
            java.lang.String r3 = "mContext.getString(R.string.error)"
            if (r0 == 0) goto L_0x0081
            net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidateResponse r14 = (net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidateResponse) r14
            net.one97.paytm.paymentsBank.chequebook.utils.CbPreValidatePayLoad r0 = r14.getPreValidatePayload()
            if (r0 == 0) goto L_0x007b
            java.lang.String r1 = r0.getErrorMessage()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0061
            java.lang.String r14 = r14.getRequestId()
            r13.j = r14
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.b()
            return
        L_0x0061:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r0 = r0.getErrorMessage()
            if (r0 != 0) goto L_0x0077
            kotlin.g.b.k.a()
        L_0x0077:
            r14.b(r1, r0)
            return
        L_0x007b:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.b(r2, r2)
            return
        L_0x0081:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse
            java.lang.String r4 = "mContext.getString(R.str…omething_wrong_try_again)"
            r5 = 0
            if (r0 == 0) goto L_0x012d
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse r14 = (net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutResponse) r14
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r0 = r14.getCheckOutPayload()
            if (r0 == 0) goto L_0x0095
            java.lang.String r0 = r0.getErrorMessage()
            goto L_0x0096
        L_0x0095:
            r0 = r5
        L_0x0096:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00ed
            java.lang.Integer r0 = r14.getResponseCode()
            if (r0 != 0) goto L_0x00a5
            goto L_0x00cd
        L_0x00a5:
            int r0 = r0.intValue()
            r1 = 437(0x1b5, float:6.12E-43)
            if (r0 != r1) goto L_0x00cd
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r14 = r14.getCheckOutPayload()
            if (r14 == 0) goto L_0x00c4
            java.lang.String r5 = r14.getErrorMessage()
        L_0x00c4:
            if (r5 != 0) goto L_0x00c9
            kotlin.g.b.k.a()
        L_0x00c9:
            r0.a(r1, r5)
            return
        L_0x00cd:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r14 = r14.getCheckOutPayload()
            if (r14 == 0) goto L_0x00e4
            java.lang.String r5 = r14.getErrorMessage()
        L_0x00e4:
            if (r5 != 0) goto L_0x00e9
            kotlin.g.b.k.a()
        L_0x00e9:
            r0.b(r1, r5)
            return
        L_0x00ed:
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r0 = r14.getCheckOutPayload()
            if (r0 == 0) goto L_0x00f8
            java.lang.String r0 = r0.getOrderId()
            goto L_0x00f9
        L_0x00f8:
            r0 = r5
        L_0x00f9:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0111
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            net.one97.paytm.paymentsBank.chequebook.utils.CbCheckOutPayLoad r14 = r14.getCheckOutPayload()
            if (r14 == 0) goto L_0x010d
            java.lang.String r5 = r14.getOrderId()
        L_0x010d:
            r0.a((java.lang.String) r5)
            return
        L_0x0111:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            android.content.Context r0 = r13.p
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r0.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.pb_something_wrong_try_again
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r14.b(r0, r1)
            return
        L_0x012d:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbCreateSignature
            if (r0 == 0) goto L_0x017d
            net.one97.paytm.paymentsBank.chequebook.utils.CbCreateSignature r14 = (net.one97.paytm.paymentsBank.chequebook.utils.CbCreateSignature) r14
            net.one97.paytm.paymentsBank.chequebook.utils.CreateSignPayload r0 = r14.getPayload()
            if (r0 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.utils.CreateSignPayload r0 = r14.getPayload()
            java.lang.String r0 = r0.getUrl()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0164
            net.one97.paytm.paymentsBank.chequebook.utils.CreateSignPayload r0 = r14.getPayload()
            java.lang.String r0 = r0.getImageId()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0164
            net.one97.paytm.paymentsBank.chequebook.utils.CreateSignPayload r14 = r14.getPayload()
            java.lang.String r14 = r14.getImageId()
            r13.k = r14
            return
        L_0x0164:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.c()
            android.content.Context r14 = r13.p
            int r0 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r14.getString(r0)
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.pb_something_wrong_try_again
            java.lang.String r1 = r1.getString(r2)
            com.paytm.utility.b.b((android.content.Context) r14, (java.lang.String) r0, (java.lang.String) r1)
            return
        L_0x017d:
            boolean r0 = r14 instanceof net.one97.paytm.bankCommon.model.PBKYCFetchTnc
            r6 = 1
            if (r0 == 0) goto L_0x023b
            net.one97.paytm.bankCommon.model.PBKYCFetchTnc r14 = (net.one97.paytm.bankCommon.model.PBKYCFetchTnc) r14
            java.lang.String r0 = r14.getStatus()
            if (r0 == 0) goto L_0x053b
            android.content.Context r0 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r0 = r0.getString(r2)
            java.lang.String r2 = r14.getStatus()
            java.lang.String r4 = "error"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r4, (boolean) r6)
            if (r2 == 0) goto L_0x01c2
            java.lang.String r1 = r14.getMessage()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01ae
            java.lang.String r0 = r14.getMessage()
        L_0x01ae:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r14.b(r1, r0)
            return
        L_0x01c2:
            java.lang.String r2 = r14.getStatus()
            java.lang.String r5 = "success"
            boolean r2 = kotlin.m.p.a((java.lang.String) r2, (java.lang.String) r5, (boolean) r6)
            if (r2 == 0) goto L_0x0227
            java.util.ArrayList r0 = r14.getTncDataList()
            if (r0 == 0) goto L_0x0226
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r6
            if (r0 != r6) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            java.util.ArrayList r2 = r14.getTncDataList()
            java.lang.String r3 = "response.tncDataList"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            r0.a((java.util.ArrayList<net.one97.paytm.bankCommon.model.PBTncData>) r2)
            java.util.ArrayList r0 = r14.getTncDataList()
            java.lang.String r2 = "response?.tncDataList"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            java.lang.String r2 = "tncList"
            kotlin.g.b.k.c(r0, r2)
            r13.f17764g = r0
            java.util.ArrayList r14 = r14.getTncDataList()
            if (r14 == 0) goto L_0x020d
            java.lang.Object r14 = r14.get(r1)
            net.one97.paytm.bankCommon.model.PBTncData r14 = (net.one97.paytm.bankCommon.model.PBTncData) r14
            if (r14 == 0) goto L_0x020d
            int r6 = r14.getVersion()
        L_0x020d:
            r13.f17761d = r6
            boolean r14 = r13.l
            if (r14 == 0) goto L_0x021f
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            if (r14 == 0) goto L_0x021c
            java.util.ArrayList<net.one97.paytm.bankCommon.model.PBTncData> r0 = r13.f17764g
            r14.b((java.util.ArrayList<net.one97.paytm.bankCommon.model.PBTncData>) r0)
        L_0x021c:
            r13.l = r1
            return
        L_0x021f:
            boolean r14 = r13.m
            if (r14 == 0) goto L_0x0226
            r13.c((boolean) r14)
        L_0x0226:
            return
        L_0x0227:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r4)
            r14.b(r1, r0)
            return
        L_0x023b:
            boolean r0 = r14 instanceof net.one97.paytm.bankCommon.model.PBKYCTncAccept
            java.lang.String r7 = "mContext.getString(R.string.some_went_wrong)"
            if (r0 == 0) goto L_0x02cf
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            if (r0 == 0) goto L_0x0248
            r0.a(r1)
        L_0x0248:
            net.one97.paytm.bankCommon.model.PBKYCTncAccept r14 = (net.one97.paytm.bankCommon.model.PBKYCTncAccept) r14
            java.lang.String r0 = r14.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r8 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r8 = net.one97.paytm.paymentsBank.chequebook.utils.e.P()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r8, (boolean) r6)
            if (r0 == 0) goto L_0x02b3
            java.lang.String r0 = r14.getResponseCode()
            java.lang.String r8 = "2004"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r8)
            if (r0 == 0) goto L_0x02b3
            r13.f17765h = r6
            boolean r14 = r13.m
            if (r14 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.utils.g r6 = r13.n
            if (r6 == 0) goto L_0x0281
            android.content.Context r7 = r13.p
            com.paytm.network.a$c r9 = com.paytm.network.a.c.PAYMENTSBANK
            r10 = r13
            com.paytm.network.listener.b r10 = (com.paytm.network.listener.b) r10
            com.paytm.network.a$b r11 = com.paytm.network.a.b.USER_FACING
            java.lang.String r12 = r13.f17760c
            java.lang.String r8 = "Request Cheque Book"
            com.paytm.network.a r5 = r6.a((android.content.Context) r7, (java.lang.String) r8, (com.paytm.network.a.c) r9, (com.paytm.network.listener.b) r10, (com.paytm.network.a.b) r11, (java.lang.String) r12)
        L_0x0281:
            android.content.Context r14 = r13.p
            boolean r14 = com.paytm.utility.b.c((android.content.Context) r14)
            if (r14 == 0) goto L_0x0292
            if (r5 != 0) goto L_0x028e
            kotlin.g.b.k.a()
        L_0x028e:
            r5.a()
            return
        L_0x0292:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.a(r1)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            android.content.Context r0 = r13.p
            int r1 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r0 = r0.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.pb_something_wrong_try_again
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r4)
            r14.b(r0, r1)
            return
        L_0x02b3:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.a(r1)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            java.lang.String r14 = r14.getMessage()
            if (r14 != 0) goto L_0x02cb
            android.content.Context r14 = r13.p
            int r1 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r14 = r14.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
        L_0x02cb:
            r0.b(r2, r14)
            return
        L_0x02cf:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse
            if (r0 == 0) goto L_0x033d
            net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse r14 = (net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse) r14
            java.lang.String r0 = r14.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r2 = net.one97.paytm.paymentsBank.chequebook.utils.e.P()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r2, (boolean) r6)
            if (r0 == 0) goto L_0x0316
            java.lang.String r0 = r14.getResponseCode()
            java.lang.String r2 = "20200"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r2)
            if (r0 == 0) goto L_0x0316
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.a((net.one97.paytm.paymentsBank.chequebook.model.CBDocumentTypeResponse) r14)
            r13.g()
            java.lang.String r14 = r13.f17762e
            r0 = r14
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0310
            java.lang.String r0 = "UPLOADED"
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r0, (boolean) r1)
            if (r14 == 0) goto L_0x0310
            r13.d()
            return
        L_0x0310:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.a(r1)
            return
        L_0x0316:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.a(r1)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r14 = r14.getMessage()
            if (r14 != 0) goto L_0x0339
            android.content.Context r14 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r14 = r14.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
        L_0x0339:
            r0.b(r1, r14)
            return
        L_0x033d:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse
            if (r0 == 0) goto L_0x046c
            r0 = r14
            net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse r0 = (net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse) r0
            boolean r2 = r0.isAcknowledgeSig()
            if (r2 == 0) goto L_0x03d1
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.a(r1)
            java.lang.String r14 = r0.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r2 = net.one97.paytm.paymentsBank.chequebook.utils.e.P()
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r6)
            if (r14 == 0) goto L_0x03aa
            java.lang.String r14 = r0.getResponseCode()
            java.lang.String r2 = "20002"
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r14 == 0) goto L_0x03aa
            net.one97.paytm.paymentsBank.chequebook.utils.g$a r14 = net.one97.paytm.paymentsBank.chequebook.utils.g.f17964b
            android.content.Context r14 = r13.p
            android.content.Context r14 = r14.getApplicationContext()
            net.one97.paytm.paymentsBank.chequebook.utils.g r14 = net.one97.paytm.paymentsBank.chequebook.utils.g.a.a(r14)
            if (r14 == 0) goto L_0x0398
            android.content.Context r0 = r13.p
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "mContext.applicationContext"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            r1 = r13
            com.paytm.network.listener.b r1 = (com.paytm.network.listener.b) r1
            java.lang.Class r2 = r13.getClass()
            java.lang.String r2 = r2.getSimpleName()
            java.lang.String r3 = "javaClass.simpleName"
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r3)
            com.paytm.network.a r5 = r14.b(r0, r1, r2)
        L_0x0398:
            android.content.Context r14 = r13.p
            android.content.Context r14 = r14.getApplicationContext()
            boolean r14 = com.paytm.utility.b.c((android.content.Context) r14)
            if (r14 == 0) goto L_0x03a9
            if (r5 == 0) goto L_0x03a9
            r5.a()
        L_0x03a9:
            return
        L_0x03aa:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.a(r1)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x03cd
            android.content.Context r0 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r0 = r0.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
        L_0x03cd:
            r14.b(r1, r0)
            return
        L_0x03d1:
            boolean r2 = r0.isViewSignature()
            if (r2 == 0) goto L_0x03f3
            net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse r14 = (net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse) r14     // Catch:{ Exception -> 0x03f2 }
            net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse$Payload r14 = r14.getPayload()     // Catch:{ Exception -> 0x03f2 }
            if (r14 == 0) goto L_0x03e4
            java.lang.Object r14 = r14.getUrl()     // Catch:{ Exception -> 0x03f2 }
            goto L_0x03e5
        L_0x03e4:
            r14 = r5
        L_0x03e5:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o     // Catch:{ Exception -> 0x03f2 }
            if (r0 == 0) goto L_0x03f2
            if (r14 == 0) goto L_0x03ef
            java.lang.String r5 = r14.toString()     // Catch:{ Exception -> 0x03f2 }
        L_0x03ef:
            r0.c(r5)     // Catch:{ Exception -> 0x03f2 }
        L_0x03f2:
            return
        L_0x03f3:
            java.lang.String r14 = r0.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r2 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r2 = net.one97.paytm.paymentsBank.chequebook.utils.e.P()
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r2, (boolean) r6)
            if (r14 == 0) goto L_0x0445
            java.lang.String r14 = r0.getResponseCode()
            java.lang.String r2 = "20102"
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r2)
            if (r14 == 0) goto L_0x0445
            net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse$Payload r14 = r0.getPayload()
            if (r14 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse$Payload r14 = r0.getPayload()
            if (r14 != 0) goto L_0x041e
            kotlin.g.b.k.a()
        L_0x041e:
            java.lang.Boolean r14 = r14.getActive()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            boolean r14 = kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.Object) r1)
            if (r14 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse$Payload r14 = r0.getPayload()
            if (r14 != 0) goto L_0x0433
            kotlin.g.b.k.a()
        L_0x0433:
            java.lang.String r14 = r14.getStatus()
            java.lang.String r1 = "NOT_IN_USE"
            boolean r14 = kotlin.m.p.a((java.lang.String) r14, (java.lang.String) r1, (boolean) r6)
            if (r14 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.a((net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse) r0)
            return
        L_0x0445:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            r14.a(r1)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            android.content.Context r1 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.error
            java.lang.String r1 = r1.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r3)
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x0468
            android.content.Context r0 = r13.p
            int r2 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r0 = r0.getString(r2)
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r7)
        L_0x0468:
            r14.b(r1, r0)
            return
        L_0x046c:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse
            if (r0 == 0) goto L_0x0495
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.a(r1)
            android.content.Context r0 = r13.p
            net.one97.paytm.paymentsBank.chequebook.utils.h r0 = net.one97.paytm.paymentsBank.chequebook.utils.h.a((android.content.Context) r0)
            if (r0 == 0) goto L_0x048d
            com.google.gsonhtcfix.f r0 = new com.google.gsonhtcfix.f
            r0.<init>()
            java.lang.String r14 = r0.a((java.lang.Object) r14)
            android.content.Context r0 = r13.p
            java.lang.String r1 = "CB_KEY_FIN_RESPONSE"
            net.one97.paytm.paymentsBank.chequebook.utils.h.a(r1, r14, r0)
        L_0x048d:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            if (r14 == 0) goto L_0x0494
            r14.e()
        L_0x0494:
            return
        L_0x0495:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse
            if (r0 == 0) goto L_0x04ec
            net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse r14 = (net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse) r14
            java.lang.String r0 = r14.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r1 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r1 = net.one97.paytm.paymentsBank.chequebook.utils.e.P()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r6)
            if (r0 == 0) goto L_0x04e4
            java.lang.String r0 = r14.getResponseCode()
            java.lang.String r1 = "20100"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x04e4
            java.util.List r0 = r14.getPayload()
            if (r0 == 0) goto L_0x04dc
            java.util.List r0 = r14.getPayload()
            if (r0 == 0) goto L_0x04cb
            int r0 = r0.size()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
        L_0x04cb:
            if (r5 != 0) goto L_0x04d0
            kotlin.g.b.k.a()
        L_0x04d0:
            int r0 = r5.intValue()
            if (r0 <= 0) goto L_0x04dc
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.a((net.one97.paytm.paymentsBank.chequebook.model.GetDocumentCreateResponse) r14)
            return
        L_0x04dc:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14.a((java.lang.Boolean) r0)
            return
        L_0x04e4:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r14 = r13.o
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r14.a((java.lang.Boolean) r0)
            return
        L_0x04ec:
            boolean r0 = r14 instanceof net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse
            if (r0 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse r14 = (net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse) r14
            java.lang.String r0 = r14.getStatus()
            net.one97.paytm.paymentsBank.chequebook.utils.e r3 = net.one97.paytm.paymentsBank.chequebook.utils.e.f17951a
            java.lang.String r3 = net.one97.paytm.paymentsBank.chequebook.utils.e.P()
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r3, (boolean) r6)
            if (r0 == 0) goto L_0x0520
            java.lang.String r0 = r14.getResponseCode()
            java.lang.String r3 = "20000"
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 == 0) goto L_0x0520
            java.lang.String r0 = r14.getMessage()
            java.lang.String r1 = "Signature Found"
            boolean r0 = kotlin.m.p.a((java.lang.String) r0, (java.lang.String) r1, (boolean) r6)
            if (r0 == 0) goto L_0x053b
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.a((net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse) r14)
            return
        L_0x0520:
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            r0.a(r1)
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.a$b r0 = r13.o
            java.lang.String r14 = r14.getMessage()
            if (r14 != 0) goto L_0x0538
            android.content.Context r14 = r13.p
            int r1 = net.one97.paytm.paymentsBank.R.string.some_went_wrong
            java.lang.String r14 = r14.getString(r1)
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r7)
        L_0x0538:
            r0.b(r2, r14)
        L_0x053b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.a.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
    }

    public final void a() {
        this.f17758a = h.a(this.p);
        f fVar = new f();
        h hVar = this.f17758a;
        com.paytm.network.a aVar = null;
        if (hVar != null) {
            String a2 = hVar != null ? h.a("CB_ADDRESS_RESPONSE") : null;
            String a3 = this.f17758a != null ? h.a("PRODUCT_ID") : null;
            if (a3 == null) {
                k.a();
            }
            this.f17760c = a3;
            if (a2 != null) {
                this.f17759b = (PermanentAddress) fVar.a(a2, PermanentAddress.class);
            }
        }
        g gVar = this.n;
        if (gVar != null) {
            b bVar = this;
            k.c(bVar, "apiListener");
            String C = n.C();
            if (URLUtil.isValidUrl(C)) {
                String e2 = com.paytm.utility.b.e(gVar.f17966a, C);
                Map hashMap = new HashMap();
                e eVar = e.f17951a;
                String a4 = e.a();
                String a5 = d.a(gVar.f17966a);
                k.a((Object) a5, "CJRNetUtility.getSSOToken(mContext)");
                hashMap.put(a4, a5);
                hashMap.put("Accept", "application/json");
                hashMap.put("Content-Type", "application/json");
                aVar = new com.paytm.network.b().a(gVar.f17966a).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new CBDocumentTypeResponse((String) null, (String) null, (String) null, (List) null, 15, (kotlin.g.b.g) null)).f().a(bVar).c(SignatureLandingActivity.class.getName()).l();
            }
        }
        if (com.paytm.utility.b.c(this.p)) {
            this.o.a(true);
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a.b bVar2 = this.o;
        String string = this.p.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.p.getString(R.string.no_internet);
        k.a((Object) string2, "mContext.getString(R.string.no_internet)");
        bVar2.b(string, string2);
    }

    public final void d() {
        g gVar = this.n;
        com.paytm.network.a a2 = gVar != null ? gVar.a((b) this, (String) null) : null;
        if (com.paytm.utility.b.c(this.p)) {
            this.o.a(true);
            if (a2 != null) {
                a2.a();
                return;
            }
            return;
        }
        a.b bVar = this.o;
        String string = this.p.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.p.getString(R.string.no_internet);
        k.a((Object) string2, "mContext.getString(R.string.no_internet)");
        bVar.b(string, string2);
    }

    public final void a(String str, String str2) {
        k.c(str2, "signImageID");
        g gVar = this.n;
        com.paytm.network.a aVar = null;
        if (gVar != null) {
            b bVar = this;
            k.c(bVar, "apiListener");
            k.c(str2, "signImageID");
            String A = n.A();
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                k.a((Object) A, "url");
                String a2 = p.a(A, "{imageID}", str2, false);
                if (str == null) {
                    k.a();
                }
                A = p.a(a2, "{docID}", str, false);
            }
            if (URLUtil.isValidUrl(A)) {
                String e2 = com.paytm.utility.b.e(gVar.f17966a, A);
                Map hashMap = new HashMap();
                e eVar = e.f17951a;
                String a3 = e.a();
                String a4 = d.a(gVar.f17966a);
                k.a((Object) a4, "CJRNetUtility.getSSOToken(mContext)");
                hashMap.put(a3, a4);
                hashMap.put("Accept", "application/json");
                hashMap.put("Content-Type", "application/json");
                aVar = new com.paytm.network.b().a(gVar.f17966a).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.PUT).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new DocumentCreateResponse()).f().a(bVar).c(SignatureLandingActivity.class.getName()).l();
            }
        }
        if (com.paytm.utility.b.c(this.p)) {
            this.o.a(true);
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a.b bVar2 = this.o;
        String string = this.p.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.p.getString(R.string.no_internet);
        k.a((Object) string2, "mContext.getString(R.string.no_internet)");
        bVar2.b(string, string2);
    }

    public final void b(String str, String str2) {
        k.c(str2, "signImageID");
        g gVar = this.n;
        com.paytm.network.a aVar = null;
        if (gVar != null) {
            b bVar = this;
            k.c(bVar, "apiListener");
            String y = n.y();
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                k.a((Object) y, "url");
                if (str2 == null) {
                    k.a();
                }
                String a2 = p.a(y, "{imageID}", str2, true);
                if (str == null) {
                    k.a();
                }
                y = p.a(a2, "{docType}", str, true);
            }
            if (URLUtil.isValidUrl(y)) {
                String e2 = com.paytm.utility.b.e(gVar.f17966a, y);
                Map hashMap = new HashMap();
                e eVar = e.f17951a;
                String a3 = e.a();
                String a4 = d.a(gVar.f17966a);
                k.a((Object) a4, "CJRNetUtility.getSSOToken(mContext)");
                hashMap.put(a3, a4);
                hashMap.put("Accept", "application/json");
                hashMap.put("Content-Type", "application/json");
                aVar = new com.paytm.network.b().a(gVar.f17966a).a(e2).a((Map<String, String>) hashMap).a(a.C0715a.GET).a(a.c.PAYMENTSBANK).a(a.b.SILENT).a((IJRPaytmDataModel) new GetDocumentCreateResponse()).f().a((b) new g.C0294g(bVar)).c(SignatureLandingActivity.class.getName()).l();
            }
        }
        if (com.paytm.utility.b.c(this.p)) {
            this.o.a(true);
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        a.b bVar2 = this.o;
        String string = this.p.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.p.getString(R.string.no_internet);
        k.a((Object) string2, "mContext.getString(R.string.no_internet)");
        bVar2.b(string, string2);
    }

    public final void b(boolean z) {
        boolean z2;
        this.l = z;
        if (this.f17764g.size() <= 0 || !this.l) {
            ArrayList<PBTncData> arrayList = this.f17764g;
            com.paytm.network.a aVar = null;
            if ((arrayList != null ? Integer.valueOf(arrayList.size()) : null).intValue() <= 0 || this.l || !(z2 = this.m)) {
                g gVar = this.n;
                if (gVar != null) {
                    aVar = gVar.a((b) this);
                }
                if (com.paytm.utility.b.c(this.p)) {
                    if (this.l) {
                        this.o.a(true);
                    }
                    if (aVar != null) {
                        aVar.a();
                        return;
                    }
                    return;
                }
                a.b bVar = this.o;
                String string = this.p.getString(R.string.error);
                k.a((Object) string, "mContext.getString(R.string.error)");
                String string2 = this.p.getString(R.string.no_internet);
                k.a((Object) string2, "mContext.getString(R.string.no_internet)");
                bVar.b(string, string2);
                return;
            }
            c(z2);
            return;
        }
        a.b bVar2 = this.o;
        if (bVar2 != null) {
            bVar2.b(this.f17764g);
        }
    }

    public final void c(boolean z) {
        this.m = z;
        h();
    }

    public final void a(String str) {
        g gVar = this.n;
        com.paytm.network.a a2 = gVar != null ? gVar.a((b) this, str, (String) null) : null;
        if (com.paytm.utility.b.c(this.p) && a2 != null) {
            a2.a();
        }
    }

    public final void c() {
        this.m = true;
        if (k.a((Object) this.f17763f, (Object) Boolean.FALSE)) {
            a.b bVar = this.o;
            if (bVar != null) {
                bVar.b();
                return;
            }
            return;
        }
        if (this.f17758a != null) {
            h.a("CB_ADDRESS_RESPONSE");
        }
        b(false);
    }

    public final void c(String str) {
        if (com.paytm.utility.b.c(this.p)) {
            this.o.a(true);
            g gVar = this.n;
            com.paytm.network.a a2 = gVar != null ? gVar.a(this.p, (b) this, str) : null;
            if (a2 != null) {
                a2.a();
                return;
            }
            return;
        }
        a.b bVar = this.o;
        String string = this.p.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.p.getString(R.string.no_internet);
        k.a((Object) string2, "mContext.getString(R.string.no_internet)");
        bVar.b(string, string2);
    }

    private final void h() {
        g gVar = this.n;
        com.paytm.network.a a2 = gVar != null ? gVar.a(this.f17761d, "Cheque_TnC", (b) this) : null;
        if (com.paytm.utility.b.c(this.p)) {
            this.o.a(true);
            if (a2 != null) {
                a2.a();
                return;
            }
            return;
        }
        a.b bVar = this.o;
        String string = this.p.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.p.getString(R.string.no_internet);
        k.a((Object) string2, "mContext.getString(R.string.no_internet)");
        bVar.b(string, string2);
    }

    public final f.a.C0293a g() {
        if (!k.a((Object) this.f17763f, (Object) Boolean.FALSE)) {
            return f.a.C0293a.FIRST_TIME_USER;
        }
        if (TextUtils.isEmpty(this.f17762e) || !p.a(this.f17762e, "UPLOADED", false)) {
            return f.a.C0293a.NOT_FIRST_TIME_USER_OTHER_SIGNATURE_STATUS;
        }
        return f.a.C0293a.NOT_FIRST_TIME_UPLOADED_SIGNATURE_STATUS;
    }

    public final void a(String str, boolean z, String str2) {
        k.c(str, "txnToken");
        k.c(str2, "cbName");
        com.paytm.network.a aVar = null;
        if (!z) {
            g gVar = this.n;
            if (gVar != null) {
                aVar = gVar.a(this.p, str, "Signature Landing", a.c.PAYMENTSBANK, a.b.USER_FACING, (b) this);
            }
            if (com.paytm.utility.b.c(this.p)) {
                this.o.a(true);
                if (aVar == null) {
                    k.a();
                }
                aVar.a();
                return;
            }
            this.o.a(false);
        } else if (this.f17759b == null) {
            Toast.makeText(this.p, "Please Select Adress To proceed", 0).show();
        } else {
            g gVar2 = this.n;
            if (gVar2 != null) {
                Context context = this.p;
                aVar = gVar2.a(context, str, this.j, "RequestCB", a.c.PAYMENTSBANK, a.b.USER_FACING, this, this.f17759b, this.f17760c, "", str2, true);
            }
            if (com.paytm.utility.b.c(this.p)) {
                a.b bVar = this.o;
                if (bVar != null) {
                    bVar.a(true);
                }
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            a.b bVar2 = this.o;
            if (bVar2 != null) {
                bVar2.a(false);
            }
        }
    }
}
