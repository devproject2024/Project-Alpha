package net.one97.paytm.paymentsBank.chequebook.signaturelanding.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.File;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.model.ChequeBookFinResponse;
import net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse;
import net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b;
import net.one97.paytm.paymentsBank.chequebook.utils.CbCreateSignature;
import net.one97.paytm.paymentsBank.chequebook.utils.CbSignaturePayload;
import net.one97.paytm.paymentsBank.chequebook.utils.CbSignatureResponse;
import net.one97.paytm.paymentsBank.chequebook.utils.CbSignatureUpload;
import net.one97.paytm.paymentsBank.chequebook.utils.e;
import net.one97.paytm.paymentsBank.chequebook.utils.g;
import net.one97.paytm.paymentsBank.chequebook.utils.h;

public final class b implements com.paytm.network.listener.b, b.a {

    /* renamed from: a  reason: collision with root package name */
    private h f17767a;

    /* renamed from: b  reason: collision with root package name */
    private String f17768b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f17769c;

    /* renamed from: d  reason: collision with root package name */
    private String f17770d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f17771e = "";

    /* renamed from: f  reason: collision with root package name */
    private final String f17772f;

    /* renamed from: g  reason: collision with root package name */
    private String f17773g;

    /* renamed from: h  reason: collision with root package name */
    private String f17774h;

    /* renamed from: i  reason: collision with root package name */
    private String f17775i;
    private String j;
    private g k;
    private b.C0286b l;
    private Context m;

    public final void b() {
    }

    public b(g gVar, b.C0286b bVar, Context context) {
        k.c(bVar, "signatureLandingView");
        k.c(context, "mContext");
        this.k = gVar;
        this.l = bVar;
        this.m = context;
        String simpleName = getClass().getSimpleName();
        k.a((Object) simpleName, "this.javaClass.simpleName");
        this.f17772f = simpleName;
        this.f17773g = p.a("\n        {\n  \"status\": \"SUCCESS\",\n  \"responseCode\": \"20000\",\n  \"message\": \"Signature Found\",\n  \"payload\": [\n    {\n      \"id\": 358,\n      \"imageId\": \"BDM292790135647\",\n      \"status\": \"ACCEPTED\",\n      \"uploadedAt\": 1580123381000,\n      \"approvedBy\": null,\n      \"approvedAt\": 1580712949000,\n      \"url\": null,\n      \"remarks\": null,\n      \"channel\": null,\n      \"rejectCode\": null,\n      \"documentTypeName\": \"DL\",\n      \"documentTypeDescription\": \"Driving License\",\n      \"customerId\": null,\n      \"supportDocuments\": [\n        {\n          \"id\": 121,\n          \"documentId\": \"BDM292791160506\",\n          \"status\": \"IN_USE\",\n          \"active\": true,\n          \"url\": null,\n          \"meta\": {}\n        }\n      ]\n    },\n    {\n      \"id\": 358,\n      \"imageId\": \"BDM292790135647\",\n      \"status\": \"REJECTED\",\n      \"uploadedAt\": 1580123381000,\n      \"approvedBy\": null,\n      \"approvedAt\": 1580712949000,\n      \"url\": null,\n      \"remarks\": null,\n      \"channel\": null,\n      \"rejectCode\": null,\n      \"documentTypeName\": \"DL\",\n      \"documentTypeDescription\": \"Driving License\",\n      \"customerId\": null,\n      \"supportDocuments\": [\n        {\n          \"id\": 121,\n          \"documentId\": \"BDM292791160506\",\n          \"status\": \"IN_USE\",\n          \"active\": true,\n          \"url\": null,\n          \"meta\": {}\n        }\n      ]\n    }\n  ]\n}\n    ");
        this.f17774h = "";
        this.f17775i = "";
        this.j = "{\n  \"status\": \"SUCCESS\",\n  \"responseCode\": \"20000\",\n  \"message\": \"Signature Found\",\n  \"payload\": [\n    {\n      \"id\": 358,\n      \"imageId\": \"BDM292790135647\",\n      \"status\": \"ACCEPTED\",\n      \"uploadedAt\": 1580123381000,\n      \"approvedBy\": null,\n      \"approvedAt\": 1580712949000,\n      \"url\": null,\n      \"remarks\": null,\n      \"channel\": null,\n      \"rejectCode\": null,\n      \"documentTypeName\": \"DL\",\n      \"documentTypeDescription\": \"Driving License\",\n      \"customerId\": null,\n      \"supportDocuments\": [\n        {\n          \"id\": 121,\n          \"documentId\": \"BDM292791160506\",\n          \"status\": \"IN_USE\",\n          \"active\": true,\n          \"url\": null,\n          \"meta\": {}\n        }\n      ]\n    },\n    {\n      \"id\": 358,\n      \"imageId\": \"BDM292790135647\",\n      \"status\": \"APPROVAL_PENDING\",\n      \"uploadedAt\": 1580123381000,\n      \"approvedBy\": null,\n      \"approvedAt\": 1580712949000,\n      \"url\": null,\n      \"remarks\": null,\n      \"channel\": null,\n      \"rejectCode\": null,\n      \"documentTypeName\": \"DL\",\n      \"documentTypeDescription\": \"Driving License\",\n      \"customerId\": null,\n      \"supportDocuments\": [\n        {\n          \"id\": 121,\n          \"documentId\": \"BDM292791160506\",\n          \"status\": \"IN_USE\",\n          \"active\": true,\n          \"url\": null,\n          \"meta\": {}\n        }\n      ]\n    }\n  ]\n}";
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014 A[Catch:{ Exception -> 0x000f }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleErrorCode(int r4, com.paytm.network.model.IJRPaytmDataModel r5, com.paytm.network.model.NetworkCustomError r6) {
        /*
            r3 = this;
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$b r0 = r3.l
            r1 = 0
            r0.a(r1)
            if (r6 == 0) goto L_0x0011
            com.paytm.network.model.NetworkResponse r0 = r6.networkResponse     // Catch:{ Exception -> 0x000f }
            if (r0 == 0) goto L_0x0011
            byte[] r0 = r0.data     // Catch:{ Exception -> 0x000f }
            goto L_0x0012
        L_0x000f:
            goto L_0x0028
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0017
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x000f }
        L_0x0017:
            java.lang.String r1 = new java.lang.String     // Catch:{ Exception -> 0x000f }
            java.nio.charset.Charset r2 = kotlin.m.d.f47971a     // Catch:{ Exception -> 0x000f }
            r1.<init>(r0, r2)     // Catch:{ Exception -> 0x000f }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x000f }
            r0.<init>(r1)     // Catch:{ Exception -> 0x000f }
            java.lang.String r1 = "errorMessage"
            r0.getString(r1)     // Catch:{ Exception -> 0x000f }
        L_0x0028:
            boolean r0 = r5 instanceof net.one97.paytm.paymentsBank.chequebook.utils.CbCreateSignature
            if (r0 == 0) goto L_0x0032
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$b r5 = r3.l
            r5.d()
            goto L_0x0055
        L_0x0032:
            boolean r0 = r5 instanceof net.one97.paytm.paymentsBank.chequebook.model.CBGetSignatureResponse
            if (r0 == 0) goto L_0x0042
            r0 = 404(0x194, float:5.66E-43)
            if (r4 != r0) goto L_0x0042
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$b r5 = r3.l
            if (r5 == 0) goto L_0x0055
            r5.e()
            goto L_0x0055
        L_0x0042:
            boolean r0 = r5 instanceof net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse
            if (r0 == 0) goto L_0x0055
            net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse r5 = (net.one97.paytm.paymentsBank.chequebook.model.DocumentCreateResponse) r5
            boolean r5 = r5.isViewSignature()
            if (r5 == 0) goto L_0x0055
            net.one97.paytm.paymentsBank.chequebook.signaturelanding.a.b$b r5 = r3.l
            if (r5 == 0) goto L_0x0055
            r5.e()
        L_0x0055:
            android.content.Context r5 = r3.m
            net.one97.paytm.bankCommon.utils.f.a((android.content.Context) r5, (com.paytm.network.model.NetworkCustomError) r6, (int) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.chequebook.signaturelanding.b.b.handleErrorCode(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null) {
            String str = null;
            if (iJRPaytmDataModel instanceof CbSignatureResponse) {
                this.l.a(false);
                CbSignatureResponse cbSignatureResponse = (CbSignatureResponse) iJRPaytmDataModel;
                CbSignaturePayload signaturePayload = cbSignatureResponse.getSignaturePayload();
                if (signaturePayload != null) {
                    str = signaturePayload.getUrl();
                }
                if (str != null) {
                    this.f17770d = signaturePayload.getUrl();
                    if (!TextUtils.isEmpty(this.f17770d)) {
                        b.C0286b bVar = this.l;
                        String str2 = this.f17770d;
                        String status = cbSignatureResponse.getSignaturePayload().getStatus();
                        if (status == null) {
                            status = "";
                        }
                        bVar.c(str2, status);
                    }
                } else if (TextUtils.isEmpty(cbSignatureResponse.getResponseMessage())) {
                    Context context = this.m;
                    com.paytm.utility.b.b(context, context.getString(R.string.error), this.m.getString(R.string.pb_something_wrong_try_again));
                } else {
                    Context context2 = this.m;
                    com.paytm.utility.b.b(context2, context2.getString(R.string.error), cbSignatureResponse.getResponseMessage());
                }
            } else if (iJRPaytmDataModel instanceof CbCreateSignature) {
                CbCreateSignature cbCreateSignature = (CbCreateSignature) iJRPaytmDataModel;
                if (cbCreateSignature.getPayload() == null) {
                    return;
                }
                if (TextUtils.isEmpty(cbCreateSignature.getPayload().getUrl()) || TextUtils.isEmpty(cbCreateSignature.getPayload().getImageId())) {
                    this.l.b(false);
                    Context context3 = this.m;
                    com.paytm.utility.b.b(context3, context3.getString(R.string.error), this.m.getString(R.string.pb_something_wrong_try_again));
                    return;
                }
                this.f17775i = cbCreateSignature.getPayload().getImageId();
                this.l.b(cbCreateSignature.getPayload().getUrl(), cbCreateSignature.getPayload().getImageId());
            } else if (iJRPaytmDataModel instanceof CbSignatureUpload) {
                String status2 = ((CbSignatureUpload) iJRPaytmDataModel).getStatus();
                if (status2 == null || !p.a(status2, "SUCCESS", true)) {
                    b.C0286b bVar2 = this.l;
                    String string = this.m.getString(R.string.error);
                    k.a((Object) string, "mContext.getString(R.string.error)");
                    String string2 = this.m.getString(R.string.pb_something_wrong_try_again);
                    k.a((Object) string2, "mContext.getString(R.str…omething_wrong_try_again)");
                    bVar2.a(string, string2);
                    return;
                }
                this.l.b();
            } else if (iJRPaytmDataModel instanceof ChequeBookFinResponse) {
                this.l.a(false);
                if (h.a(this.m) != null) {
                    h.a("CB_KEY_FIN_RESPONSE", new f().b(iJRPaytmDataModel), this.m);
                }
                this.l.c();
            } else if (iJRPaytmDataModel instanceof CBGetSignatureResponse) {
                CBGetSignatureResponse cBGetSignatureResponse = (CBGetSignatureResponse) iJRPaytmDataModel;
                String status3 = cBGetSignatureResponse.getStatus();
                e eVar = e.f17951a;
                if (!p.a(status3, e.P(), true) || !k.a((Object) cBGetSignatureResponse.getResponseCode(), (Object) "20000")) {
                    this.l.a(false);
                    b.C0286b bVar3 = this.l;
                    if (bVar3 != null) {
                        bVar3.e();
                    }
                    b.C0286b bVar4 = this.l;
                    String message = cBGetSignatureResponse.getMessage();
                    if (message == null) {
                        k.a();
                    }
                    bVar4.a("", message);
                } else if (p.a(cBGetSignatureResponse.getMessage(), "Signature Found", true)) {
                    this.l.a(cBGetSignatureResponse);
                }
            } else if (iJRPaytmDataModel instanceof DocumentCreateResponse) {
                this.l.a(false);
                DocumentCreateResponse documentCreateResponse = (DocumentCreateResponse) iJRPaytmDataModel;
                if (documentCreateResponse.isViewSignature()) {
                    try {
                        DocumentCreateResponse.Payload payload = ((DocumentCreateResponse) iJRPaytmDataModel).getPayload();
                        Object url = payload != null ? payload.getUrl() : null;
                        b.C0286b bVar5 = this.l;
                        if (bVar5 != null) {
                            if (url != null) {
                                str = url.toString();
                            }
                            bVar5.d(str, ((DocumentCreateResponse) iJRPaytmDataModel).getSignatureType());
                        }
                    } catch (Exception unused) {
                        b.C0286b bVar6 = this.l;
                        if (bVar6 != null) {
                            bVar6.e();
                        }
                    }
                } else {
                    b.C0286b bVar7 = this.l;
                    if (bVar7 != null) {
                        bVar7.e();
                    }
                    this.l.a(false);
                    b.C0286b bVar8 = this.l;
                    String message2 = documentCreateResponse.getMessage();
                    if (message2 == null) {
                        k.a();
                    }
                    bVar8.a("", message2);
                }
            }
        }
    }

    public final void a() {
        this.f17767a = h.a(this.m);
    }

    public final void c(String str) {
        g gVar = this.k;
        a a2 = gVar != null ? gVar.a((com.paytm.network.listener.b) this, str) : null;
        if (com.paytm.utility.b.c(this.m)) {
            this.l.a(true);
            if (a2 != null) {
                a2.a();
                return;
            }
            return;
        }
        b.C0286b bVar = this.l;
        String string = this.m.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.m.getString(R.string.no_internet);
        k.a((Object) string2, "mContext.getString(R.string.no_internet)");
        bVar.a(string, string2);
    }

    public final void a(String str, String str2) {
        g gVar = this.k;
        a a2 = gVar != null ? gVar.a((com.paytm.network.listener.b) this, str, str2) : null;
        if (com.paytm.utility.b.c(this.m) && a2 != null) {
            a2.a();
        }
    }

    public final void d() {
        a aVar;
        g.a aVar2 = g.f17964b;
        g a2 = g.a.a(this.m.getApplicationContext());
        if (a2 != null) {
            Context applicationContext = this.m.getApplicationContext();
            k.a((Object) applicationContext, "mContext.applicationContext");
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            aVar = a2.b(applicationContext, this, simpleName);
        } else {
            aVar = null;
        }
        if (!com.paytm.utility.b.c(this.m.getApplicationContext())) {
            b.C0286b bVar = this.l;
            String string = this.m.getString(R.string.error);
            k.a((Object) string, "mContext.getString(R.string.error)");
            String string2 = this.m.getString(R.string.pb_something_wrong_try_again);
            k.a((Object) string2, "mContext.getString(R.str…omething_wrong_try_again)");
            bVar.a(string, string2);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(String str, Uri uri, String str2) {
        k.c(str, "txnToken");
        k.c(uri, "selectedImage");
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_FILE_PATH);
        this.f17771e = str;
        new File(str2);
        k.c(uri, "data");
        g gVar = this.k;
        a b2 = gVar != null ? gVar.b(this.m, "Signature ", a.c.PAYMENTSBANK, a.b.USER_FACING, this) : null;
        if (com.paytm.utility.b.c(this.m)) {
            this.l.a(true);
            if (b2 == null) {
                k.a();
            }
            b2.a();
            return;
        }
        this.l.a(false);
    }

    public final void a(String str) {
        a aVar;
        k.c(str, "imageId");
        this.f17769c = true;
        g.a aVar2 = g.f17964b;
        if (g.a.a(this.m) != null) {
            String simpleName = getClass().getSimpleName();
            k.a((Object) simpleName, "javaClass.simpleName");
            aVar = g.a(this.m, str, (com.paytm.network.listener.b) this, simpleName, this.f17771e);
        } else {
            aVar = null;
        }
        if (!com.paytm.utility.b.c(this.m)) {
            this.l.b(false);
        } else if (aVar != null) {
            aVar.a();
        }
    }

    public final String c() {
        return this.f17770d;
    }

    public final void a(Context context, b.C0286b bVar, String str) {
        k.c(context, "context");
        k.c(bVar, "signatureLandingView");
        k.c(str, "signatureImageUrl");
        this.m = context;
        this.l = bVar;
        this.f17770d = str;
    }

    public final void b(String str) {
        a aVar;
        k.c(str, "txnToken");
        g gVar = this.k;
        if (gVar != null) {
            aVar = gVar.a(this.m, str, "Signature Landing", a.c.PAYMENTSBANK, a.b.USER_FACING, (com.paytm.network.listener.b) this);
        } else {
            aVar = null;
        }
        if (com.paytm.utility.b.c(this.m)) {
            this.l.a(true);
            if (aVar != null) {
                aVar.a();
                return;
            }
            return;
        }
        this.l.a(false);
        b.C0286b bVar = this.l;
        String string = this.m.getString(R.string.error);
        k.a((Object) string, "mContext.getString(R.string.error)");
        String string2 = this.m.getString(R.string.pb_something_wrong_try_again);
        k.a((Object) string2, "mContext.getString(R.str…omething_wrong_try_again)");
        bVar.a(string, string2);
    }
}
