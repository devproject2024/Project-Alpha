package com.travel.f;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.R;
import com.travel.g.c;
import com.travel.utils.r;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import net.one97.paytm.common.entity.replacement.CJRReplacementResponse;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;

public class a {

    /* renamed from: i  reason: collision with root package name */
    public static final String f23431i = a.class.getSimpleName();
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f23432a;

    /* renamed from: b  reason: collision with root package name */
    public String f23433b;

    /* renamed from: c  reason: collision with root package name */
    public String f23434c;

    /* renamed from: d  reason: collision with root package name */
    public String f23435d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public DownloadManager f23436e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public long f23437f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public int f23438g;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public CJROrderSummaryAction f23439h;
    String j = "Ticket";
    BroadcastReceiver k = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|43) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            android.widget.Toast.makeText(r12.f23432a, r12.f23432a.getResources().getString(com.travel.R.string.no_pdf_view_msg), 0).show();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x011f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onReceive(android.content.Context r12, android.content.Intent r13) {
            /*
                r11 = this;
                r0 = -1
                java.lang.String r2 = "extra_download_id"
                long r3 = r13.getLongExtra(r2, r0)
                android.os.Bundle r5 = r13.getExtras()
                android.app.DownloadManager$Query r6 = new android.app.DownloadManager$Query
                r6.<init>()
                r7 = 1
                long[] r8 = new long[r7]
                long r9 = r5.getLong(r2)
                r5 = 0
                r8[r5] = r9
                r6.setFilterById(r8)
                com.travel.f.a r8 = com.travel.f.a.this
                android.app.DownloadManager r8 = r8.f23436e
                android.database.Cursor r6 = r8.query(r6)
                boolean r8 = r6.moveToFirst()
                if (r8 == 0) goto L_0x0200
                java.lang.String r8 = "status"
                int r8 = r6.getColumnIndex(r8)
                int r8 = r6.getInt(r8)
                java.lang.String r9 = "reason"
                int r9 = r6.getColumnIndex(r9)
                r6.getInt(r9)
                r9 = 8
                if (r8 != r9) goto L_0x0135
                java.lang.String unused = com.travel.f.a.f23431i
                java.lang.String r13 = "download successful..0"
                com.paytm.utility.q.d(r13)
                java.lang.String r13 = "title"
                int r13 = r6.getColumnIndex(r13)
                r6.getString(r13)
                int r13 = r6.getInt(r5)
                long r0 = (long) r13
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0134
                java.lang.String unused = com.travel.f.a.f23431i
                java.lang.String r13 = "download successful..1"
                com.paytm.utility.q.d(r13)
                com.travel.f.a r13 = com.travel.f.a.this
                long r0 = r13.f23437f
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0134
                java.lang.String unused = com.travel.f.a.f23431i
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r0 = "download success in "
                r13.<init>(r0)
                com.travel.f.a r0 = com.travel.f.a.this
                int r0 = r0.f23438g
                int r0 = 5 - r0
                r13.append(r0)
                java.lang.String r0 = " tries"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                com.paytm.utility.q.d(r13)
                com.travel.f.a r13 = com.travel.f.a.this
                r13.b()
                com.travel.f.a.d()
                com.travel.f.a r13 = com.travel.f.a.this
                java.lang.String r13 = r13.n
                boolean r13 = android.text.TextUtils.isEmpty(r13)
                java.lang.String r0 = "local_uri"
                if (r13 != 0) goto L_0x00f8
                com.travel.f.a r13 = com.travel.f.a.this
                java.lang.String r13 = r13.n
                java.lang.String r1 = "share ticket"
                boolean r13 = r13.equalsIgnoreCase(r1)
                if (r13 == 0) goto L_0x00f8
                int r13 = android.os.Build.VERSION.SDK_INT
                r1 = 24
                if (r13 < r1) goto L_0x00ea
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                java.io.File r13 = r12.getExternalFilesDir(r13)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r12.getPackageName()
                r0.append(r1)
                java.lang.String r1 = ".provider"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                android.net.Uri r12 = androidx.core.content.FileProvider.getUriForFile(r12, r0, r13)
                com.travel.f.a r13 = com.travel.f.a.this
                com.travel.f.a.a((com.travel.f.a) r13, (android.net.Uri) r12)
                return
            L_0x00ea:
                com.travel.f.a r12 = com.travel.f.a.this
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                com.travel.f.a.b(r12, r13)
                return
            L_0x00f8:
                com.travel.f.a r12 = com.travel.f.a.this
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                if (r13 == 0) goto L_0x0134
                android.net.Uri r13 = android.net.Uri.parse(r13)     // Catch:{ Exception -> 0x0134 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0134 }
                java.lang.String r1 = "android.intent.action.VIEW"
                r0.<init>(r1)     // Catch:{ Exception -> 0x0134 }
                java.lang.String r1 = "application/pdf"
                r0.setDataAndType(r13, r1)     // Catch:{ Exception -> 0x0134 }
                r13 = 67108864(0x4000000, float:1.5046328E-36)
                r0.setFlags(r13)     // Catch:{ Exception -> 0x0134 }
                android.app.Activity r13 = r12.f23432a     // Catch:{ ActivityNotFoundException -> 0x011f }
                r13.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x011f }
                return
            L_0x011f:
                android.app.Activity r13 = r12.f23432a     // Catch:{ Exception -> 0x0134 }
                android.app.Activity r12 = r12.f23432a     // Catch:{ Exception -> 0x0134 }
                android.content.res.Resources r12 = r12.getResources()     // Catch:{ Exception -> 0x0134 }
                int r0 = com.travel.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0134 }
                java.lang.String r12 = r12.getString(r0)     // Catch:{ Exception -> 0x0134 }
                android.widget.Toast r12 = android.widget.Toast.makeText(r13, r12, r5)     // Catch:{ Exception -> 0x0134 }
                r12.show()     // Catch:{ Exception -> 0x0134 }
            L_0x0134:
                return
            L_0x0135:
                java.lang.String unused = com.travel.f.a.f23431i
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "download failed - retry times = "
                r3.<init>(r4)
                com.travel.f.a r4 = com.travel.f.a.this
                int r4 = r4.f23438g
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                com.paytm.utility.q.d(r3)
                com.travel.f.a r3 = com.travel.f.a.this
                com.travel.f.a.l(r3)
                com.travel.f.a r3 = com.travel.f.a.this
                int r3 = r3.f23438g
                if (r3 <= 0) goto L_0x01e7
                java.lang.String unused = com.travel.f.a.f23431i
                java.lang.String r12 = "will retry download"
                com.paytm.utility.q.d(r12)
                long r12 = r13.getLongExtra(r2, r0)
                com.travel.f.a r0 = com.travel.f.a.this
                android.app.DownloadManager r0 = r0.f23436e
                long[] r1 = new long[r7]
                r1[r5] = r12
                r0.remove(r1)
                com.travel.f.a r12 = com.travel.f.a.this
                net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r13 = r12.f23439h
                com.travel.f.a r0 = com.travel.f.a.this
                int r0 = r0.f23438g
                java.lang.String r1 = com.travel.f.a.f23431i
                java.lang.String r1 = "handleDownloadTicketClick"
                com.paytm.utility.q.d(r1)
                if (r13 == 0) goto L_0x01e6
                r12.f23438g = r0
                r12.f23439h = r13
                java.lang.String r0 = r13.getConfirmation()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x01e3
                java.lang.String r0 = r13.getConfirmation()     // Catch:{ Exception -> 0x01d6 }
                android.app.AlertDialog$Builder r1 = new android.app.AlertDialog$Builder     // Catch:{ Exception -> 0x01d6 }
                android.app.Activity r2 = r12.f23432a     // Catch:{ Exception -> 0x01d6 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x01d6 }
                r1.setMessage(r0)     // Catch:{ Exception -> 0x01d6 }
                android.app.Activity r0 = r12.f23432a     // Catch:{ Exception -> 0x01d6 }
                android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x01d6 }
                int r2 = com.travel.R.string.yes     // Catch:{ Exception -> 0x01d6 }
                java.lang.String r0 = r0.getString(r2)     // Catch:{ Exception -> 0x01d6 }
                com.travel.f.a$1 r2 = new com.travel.f.a$1     // Catch:{ Exception -> 0x01d6 }
                r2.<init>(r13)     // Catch:{ Exception -> 0x01d6 }
                r1.setPositiveButton(r0, r2)     // Catch:{ Exception -> 0x01d6 }
                android.app.Activity r13 = r12.f23432a     // Catch:{ Exception -> 0x01d6 }
                android.content.res.Resources r13 = r13.getResources()     // Catch:{ Exception -> 0x01d6 }
                int r0 = com.travel.R.string.no     // Catch:{ Exception -> 0x01d6 }
                java.lang.String r13 = r13.getString(r0)     // Catch:{ Exception -> 0x01d6 }
                com.travel.f.a$2 r0 = new com.travel.f.a$2     // Catch:{ Exception -> 0x01d6 }
                r0.<init>()     // Catch:{ Exception -> 0x01d6 }
                r1.setNegativeButton(r13, r0)     // Catch:{ Exception -> 0x01d6 }
                r1.setCancelable(r5)     // Catch:{ Exception -> 0x01d6 }
                r1.show()     // Catch:{ Exception -> 0x01d6 }
                return
            L_0x01d6:
                r12 = move-exception
                boolean r13 = com.paytm.utility.b.v
                if (r13 == 0) goto L_0x01e2
                java.lang.String r12 = r12.getMessage()
                com.paytm.utility.q.c(r12)
            L_0x01e2:
                return
            L_0x01e3:
                r12.a((net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r13)
            L_0x01e6:
                return
            L_0x01e7:
                java.lang.String unused = com.travel.f.a.f23431i
                java.lang.String r13 = "------ error downloading ticket ------"
                com.paytm.utility.q.d(r13)
                int r13 = com.travel.R.string.some_prob
                android.widget.Toast r12 = android.widget.Toast.makeText(r12, r13, r5)
                r12.show()
                com.travel.f.a r12 = com.travel.f.a.this
                r12.b()
                com.travel.f.a.d()
            L_0x0200:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.f.a.AnonymousClass5.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    /* access modifiers changed from: private */
    public String l = "CJRActionTapActionClickHelper";
    private b m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public boolean o;

    static /* synthetic */ void d() {
    }

    static /* synthetic */ int l(a aVar) {
        int i2 = aVar.f23438g;
        aVar.f23438g = i2 - 1;
        return i2;
    }

    public a(Activity activity, b bVar) {
        this.f23432a = activity;
        this.m = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        IJRPaytmDataModel iJRPaytmDataModel;
        IJRPaytmDataModel iJRPaytmDataModel2;
        try {
            q.d("action click + action=" + cJROrderSummaryAction.toString());
            boolean z = false;
            if (!(cJROrderSummaryAction == null || cJROrderSummaryAction.getActionName() == null || !cJROrderSummaryAction.getActionName().equalsIgnoreCase("Replace_Item"))) {
                z = true;
            }
            if (cJROrderSummaryAction.getUrlParams() != null) {
                if (cJROrderSummaryAction.getUrlParams().getMethod() != null && cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                    q.d("-post call");
                    String oVar = cJROrderSummaryAction.getUrlParams().getBody() != null ? cJROrderSummaryAction.getUrlParams().getBody().toString() : null;
                    this.n = cJROrderSummaryAction.getLabel();
                    String b2 = b(cJROrderSummaryAction.getUrlParams().getUrl());
                    HashMap hashMap = new HashMap();
                    hashMap.put("ssotoken", com.travel.utils.b.a(this.f23432a.getApplicationContext()));
                    hashMap.put("Content-Type", "application/json");
                    if (z) {
                        iJRPaytmDataModel2 = new CJRReplacementResponse();
                    } else {
                        iJRPaytmDataModel2 = new CJRActionResponse();
                    }
                    com.paytm.network.b bVar = new com.paytm.network.b();
                    bVar.f42877a = this.f23432a.getApplicationContext();
                    bVar.f42878b = a.c.FLIGHT;
                    bVar.f42879c = a.C0715a.POST;
                    bVar.n = a.b.SILENT;
                    bVar.o = this.f23432a.getClass().getSimpleName();
                    bVar.f42880d = b2;
                    bVar.f42881e = null;
                    bVar.f42882f = hashMap;
                    bVar.f42883g = null;
                    bVar.f42884h = oVar;
                    bVar.f42885i = iJRPaytmDataModel2;
                    bVar.j = this.m;
                    bVar.t = null;
                    com.paytm.network.a l2 = bVar.l();
                    l2.f42860d = true;
                    l2.a();
                    return;
                }
            }
            q.d("executeGetCall");
            this.n = cJROrderSummaryAction.getLabel();
            String url = cJROrderSummaryAction.getUrlParams().getUrl();
            q.d("getting sso token");
            String b3 = b(url);
            q.d("just got sso token");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("ssotoken", com.travel.utils.b.a(this.f23432a.getApplicationContext()));
            if (z) {
                q.d("making get request with return replace");
                iJRPaytmDataModel = new CJRReplacementResponse();
            } else {
                q.d("making get request w/o return replace");
                iJRPaytmDataModel = new CJRActionResponse();
            }
            com.paytm.network.b bVar2 = new com.paytm.network.b();
            bVar2.f42877a = this.f23432a.getApplicationContext();
            bVar2.f42878b = a.c.FLIGHT;
            bVar2.f42879c = a.C0715a.GET;
            bVar2.n = a.b.SILENT;
            bVar2.o = this.f23432a.getClass().getSimpleName();
            bVar2.f42880d = b3;
            bVar2.f42881e = null;
            bVar2.f42882f = hashMap2;
            bVar2.f42883g = null;
            bVar2.f42884h = null;
            bVar2.f42885i = iJRPaytmDataModel;
            bVar2.j = this.m;
            bVar2.t = null;
            com.paytm.network.a l3 = bVar2.l();
            l3.f42860d = true;
            l3.a();
        } catch (Exception unused) {
            b();
            q.a();
        }
    }

    private String b(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        return str2 + "sso_token=" + r.a(this.f23432a.getApplicationContext()).b("sso_token=", "", true);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.n = str;
        }
    }

    /* renamed from: com.travel.f.a$a  reason: collision with other inner class name */
    public class C0454a extends AsyncTask<Void, Void, String> {

        /* renamed from: b  reason: collision with root package name */
        private String f23448b;

        /* renamed from: c  reason: collision with root package name */
        private String f23449c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00b3 A[Catch:{ Exception -> 0x0169 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0120 A[Catch:{ Exception -> 0x0169 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onPostExecute(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.String r0 = "_"
                java.lang.String r9 = (java.lang.String) r9
                com.travel.f.a r1 = com.travel.f.a.this
                boolean r1 = r1.o
                if (r1 == 0) goto L_0x0012
                com.travel.f.a r9 = com.travel.f.a.this
                boolean unused = r9.o = false
                return
            L_0x0012:
                java.lang.String r2 = r8.f23448b     // Catch:{ Exception -> 0x0169 }
                com.travel.f.a r1 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                java.lang.String unused = r1.f23433b = r2     // Catch:{ Exception -> 0x0169 }
                com.travel.f.a r1 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                r1.b()     // Catch:{ Exception -> 0x0169 }
                java.lang.String unused = com.travel.f.a.f23431i     // Catch:{ Exception -> 0x0169 }
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = "onPostExecute - url = "
                r1.<init>(r3)     // Catch:{ Exception -> 0x0169 }
                r1.append(r2)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = ", invoiceUrl = "
                r1.append(r3)     // Catch:{ Exception -> 0x0169 }
                com.travel.f.a r3 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = r3.f23433b     // Catch:{ Exception -> 0x0169 }
                r1.append(r3)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0169 }
                com.paytm.utility.q.d(r1)     // Catch:{ Exception -> 0x0169 }
                r6 = 1
                if (r9 == 0) goto L_0x0133
                java.lang.String r1 = "application/pdf"
                boolean r9 = r9.equalsIgnoreCase(r1)     // Catch:{ Exception -> 0x0169 }
                if (r9 == 0) goto L_0x0133
                com.travel.f.a r9 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                boolean r1 = com.paytm.utility.s.a()     // Catch:{ Exception -> 0x0169 }
                if (r1 == 0) goto L_0x0061
                android.app.Activity r1 = r9.f23432a     // Catch:{ Exception -> 0x0169 }
                boolean r1 = com.paytm.utility.s.c((android.app.Activity) r1)     // Catch:{ Exception -> 0x0169 }
                if (r1 != 0) goto L_0x0061
                android.app.Activity r9 = r9.f23432a     // Catch:{ Exception -> 0x0169 }
                com.paytm.utility.s.b((android.app.Activity) r9)     // Catch:{ Exception -> 0x0169 }
                return
            L_0x0061:
                java.lang.String r1 = r9.f23433b     // Catch:{ Exception -> 0x0169 }
                if (r1 == 0) goto L_0x0128
                android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ Exception -> 0x0169 }
                java.lang.String r2 = "android.intent.action.DOWNLOAD_COMPLETE"
                r1.<init>(r2)     // Catch:{ Exception -> 0x0169 }
                android.app.Activity r2 = r9.f23432a     // Catch:{ Exception -> 0x0169 }
                android.content.BroadcastReceiver r3 = r9.k     // Catch:{ Exception -> 0x0169 }
                r2.registerReceiver(r3, r1)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r1 = r9.f23433b     // Catch:{ Exception -> 0x0169 }
                android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r2 = com.travel.f.a.f23431i     // Catch:{ Exception -> 0x0169 }
                java.lang.String r2 = "will download data with url = "
                java.lang.String r3 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x0169 }
                com.paytm.utility.q.d(r2)     // Catch:{ Exception -> 0x0169 }
                android.app.Activity r2 = r9.f23432a     // Catch:{ Exception -> 0x0169 }
                android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = "com.android.providers.downloads"
                int r2 = r2.getApplicationEnabledSetting(r3)     // Catch:{ Exception -> 0x0169 }
                r3 = 2
                if (r2 == r3) goto L_0x00a1
                r3 = 3
                if (r2 == r3) goto L_0x00a1
                r3 = 4
                if (r2 != r3) goto L_0x009f
                goto L_0x00a1
            L_0x009f:
                r2 = 1
                goto L_0x00a5
            L_0x00a1:
                r9.a()     // Catch:{ Exception -> 0x0169 }
                r2 = 0
            L_0x00a5:
                if (r2 == 0) goto L_0x0120
                java.lang.String r2 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = "mounted"
                boolean r2 = r3.equals(r2)     // Catch:{ Exception -> 0x0169 }
                if (r2 == 0) goto L_0x0120
                android.app.Activity r2 = r9.f23432a     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = "download"
                java.lang.Object r2 = r2.getSystemService(r3)     // Catch:{ Exception -> 0x0169 }
                android.app.DownloadManager r2 = (android.app.DownloadManager) r2     // Catch:{ Exception -> 0x0169 }
                r9.f23436e = r2     // Catch:{ Exception -> 0x0169 }
                android.app.DownloadManager$Request r2 = new android.app.DownloadManager$Request     // Catch:{ Exception -> 0x0169 }
                r2.<init>(r1)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r1 = ""
                java.lang.String r3 = r9.f23434c     // Catch:{ Exception -> 0x0169 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0169 }
                if (r3 != 0) goto L_0x00d0
                java.lang.String r1 = r9.f23434c     // Catch:{ Exception -> 0x0169 }
            L_0x00d0:
                java.lang.String r3 = r9.f23435d     // Catch:{ Exception -> 0x0169 }
                boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0169 }
                if (r3 != 0) goto L_0x00da
                java.lang.String r1 = r9.f23435d     // Catch:{ Exception -> 0x0169 }
            L_0x00da:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0169 }
                r3.<init>()     // Catch:{ Exception -> 0x0169 }
                java.lang.String r4 = r9.j     // Catch:{ Exception -> 0x0169 }
                r3.append(r4)     // Catch:{ Exception -> 0x0169 }
                r3.append(r0)     // Catch:{ Exception -> 0x0169 }
                r3.append(r1)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0169 }
                r2.setTitle(r3)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r3 = "Downloading..."
                r2.setDescription(r3)     // Catch:{ Exception -> 0x0169 }
                android.app.Activity r3 = r9.f23432a     // Catch:{ Exception -> 0x0169 }
                java.lang.String r4 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ Exception -> 0x0169 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0169 }
                r5.<init>()     // Catch:{ Exception -> 0x0169 }
                java.lang.String r7 = r9.j     // Catch:{ Exception -> 0x0169 }
                r5.append(r7)     // Catch:{ Exception -> 0x0169 }
                r5.append(r0)     // Catch:{ Exception -> 0x0169 }
                r5.append(r1)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r0 = ".pdf"
                r5.append(r0)     // Catch:{ Exception -> 0x0169 }
                java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x0169 }
                r2.setDestinationInExternalFilesDir(r3, r4, r0)     // Catch:{ Exception -> 0x0169 }
                r2.setNotificationVisibility(r6)     // Catch:{ Exception -> 0x0169 }
                android.app.DownloadManager r0 = r9.f23436e     // Catch:{ Exception -> 0x0169 }
                long r0 = r0.enqueue(r2)     // Catch:{ Exception -> 0x0169 }
                goto L_0x0125
            L_0x0120:
                r9.b()     // Catch:{ Exception -> 0x0169 }
                r0 = 0
            L_0x0125:
                r9.f23437f = r0     // Catch:{ Exception -> 0x0169 }
                return
            L_0x0128:
                java.lang.String r0 = com.travel.f.a.f23431i     // Catch:{ Exception -> 0x0169 }
                java.lang.String r0 = "invoice url is null"
                com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x0169 }
                r9.b()     // Catch:{ Exception -> 0x0169 }
                return
            L_0x0133:
                java.lang.String r9 = r8.f23449c     // Catch:{ Exception -> 0x0169 }
                boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x0169 }
                if (r9 != 0) goto L_0x013f
                java.lang.String r9 = r8.f23449c     // Catch:{ Exception -> 0x0169 }
            L_0x013d:
                r3 = r9
                goto L_0x0146
            L_0x013f:
                com.travel.f.a r9 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                java.lang.String r9 = r9.n     // Catch:{ Exception -> 0x0169 }
                goto L_0x013d
            L_0x0146:
                com.travel.d.a()     // Catch:{ Exception -> 0x0169 }
                com.travel.common.b r0 = com.travel.d.b()     // Catch:{ Exception -> 0x0169 }
                com.travel.f.a r9 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                android.app.Activity r1 = r9.f23432a     // Catch:{ Exception -> 0x0169 }
                com.travel.f.a r9 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                java.lang.String r4 = r9.f23434c     // Catch:{ Exception -> 0x0169 }
                java.lang.String r5 = "Order_summary"
                android.content.Intent r9 = r0.a((android.content.Context) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0169 }
                com.travel.f.a r0 = com.travel.f.a.this     // Catch:{ Exception -> 0x0169 }
                android.app.Activity r0 = r0.f23432a     // Catch:{ Exception -> 0x0169 }
                r0.startActivityForResult(r9, r6)     // Catch:{ Exception -> 0x0169 }
                return
            L_0x0169:
                java.lang.String unused = com.travel.f.a.f23431i
                java.lang.String r9 = "problem in downloading file"
                com.paytm.utility.q.c(r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.f.a.C0454a.onPostExecute(java.lang.Object):void");
        }

        public C0454a(String str, String str2) {
            this.f23449c = str2;
            this.f23448b = str;
            boolean unused = a.this.o = false;
            String unused2 = a.f23431i;
            q.d("FileLoader initialized, title = " + this.f23449c + ", link = " + str + ", cancelDownload = " + a.this.o);
        }

        private String a() {
            String str = null;
            try {
                String str2 = this.f23448b;
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.getContent();
                str = openConnection.getContentType();
                String unused = a.f23431i;
                q.d("doInBackground - link = " + str2 + ", urlConnection.getContent() = " + openConnection.getContent() + ", contentType = " + str);
                return str;
            } catch (Exception e2) {
                if (!com.paytm.utility.b.v) {
                    return str;
                }
                String unused2 = a.this.l;
                q.c(e2.getMessage());
                return str;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f23432a);
            builder.setMessage(this.f23432a.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
            builder.setPositiveButton(this.f23432a.getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f23443a = false;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (this.f23443a) {
                        s.b((Context) a.this.f23432a);
                        a.this.f23432a.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        a.this.f23432a.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        String unused = a.this.l;
                        q.c(e2.getMessage());
                        a.this.f23432a.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(this.f23432a.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        ((c) this.f23432a).a();
    }

    static /* synthetic */ void a(a aVar, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", uri);
        aVar.f23432a.startActivity(Intent.createChooser(intent, "Share Ticket"));
    }

    static /* synthetic */ void b(a aVar, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(str));
        aVar.f23432a.startActivity(Intent.createChooser(intent, "Share Ticket"));
    }
}
