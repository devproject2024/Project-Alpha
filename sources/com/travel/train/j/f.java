package com.travel.train.j;

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
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.travel.train.R;
import com.travel.train.activity.AJRTrainOrderSummaryNew;
import com.travel.train.i.aa;
import com.travel.train.model.trainticket.CJRTrainActionResponse;
import com.travel.train.model.trainticket.CJRTrainOrderSummaryAction;
import java.net.URL;
import java.net.URLConnection;
import net.one97.paytm.common.entity.replacement.CJRReplacementResponse;

public class f {

    /* renamed from: i  reason: collision with root package name */
    public static final String f27532i = f.class.getSimpleName();
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f27533a;

    /* renamed from: b  reason: collision with root package name */
    public String f27534b;

    /* renamed from: c  reason: collision with root package name */
    public String f27535c;

    /* renamed from: d  reason: collision with root package name */
    String f27536d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public DownloadManager f27537e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public long f27538f;
    /* access modifiers changed from: package-private */

    /* renamed from: g  reason: collision with root package name */
    public int f27539g;
    /* access modifiers changed from: package-private */

    /* renamed from: h  reason: collision with root package name */
    public CJRTrainOrderSummaryAction f27540h;
    String j = "Ticket";
    BroadcastReceiver k = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|34) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            android.widget.Toast.makeText(r12.f27533a, r12.f27533a.getResources().getString(com.travel.train.R.string.no_pdf_view_msg), 0).show();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x010b */
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
                com.travel.train.j.f r8 = com.travel.train.j.f.this
                android.app.DownloadManager r8 = r8.f27537e
                android.database.Cursor r6 = r8.query(r6)
                boolean r8 = r6.moveToFirst()
                if (r8 == 0) goto L_0x0198
                java.lang.String r8 = "status"
                int r8 = r6.getColumnIndex(r8)
                int r8 = r6.getInt(r8)
                java.lang.String r9 = "reason"
                int r9 = r6.getColumnIndex(r9)
                r6.getInt(r9)
                r9 = 8
                if (r8 != r9) goto L_0x0121
                java.lang.String unused = com.travel.train.j.f.f27532i
                java.lang.String r13 = "download successful..0"
                com.paytm.utility.q.d(r13)
                java.lang.String r13 = "title"
                int r13 = r6.getColumnIndex(r13)
                r6.getString(r13)
                int r13 = r6.getInt(r5)
                long r0 = (long) r13
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0120
                java.lang.String unused = com.travel.train.j.f.f27532i
                java.lang.String r13 = "download successful..1"
                com.paytm.utility.q.d(r13)
                com.travel.train.j.f r13 = com.travel.train.j.f.this
                long r0 = r13.f27538f
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0120
                java.lang.String unused = com.travel.train.j.f.f27532i
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r0 = "download success in "
                r13.<init>(r0)
                com.travel.train.j.f r0 = com.travel.train.j.f.this
                int r0 = r0.f27539g
                int r0 = 5 - r0
                r13.append(r0)
                java.lang.String r0 = " tries"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                com.paytm.utility.q.d(r13)
                com.travel.train.j.f r13 = com.travel.train.j.f.this
                r13.b()
                com.travel.train.j.f.d()
                com.travel.train.j.f r13 = com.travel.train.j.f.this
                java.lang.String r13 = r13.n
                boolean r13 = android.text.TextUtils.isEmpty(r13)
                java.lang.String r0 = "local_uri"
                if (r13 != 0) goto L_0x00e4
                com.travel.train.j.f r13 = com.travel.train.j.f.this
                java.lang.String r13 = r13.n
                java.lang.String r1 = "share ticket"
                boolean r13 = r13.equalsIgnoreCase(r1)
                if (r13 == 0) goto L_0x00e4
                int r13 = android.os.Build.VERSION.SDK_INT
                r1 = 24
                if (r13 < r1) goto L_0x00d6
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                java.io.File r13 = r12.getExternalFilesDir(r13)
                java.lang.String r0 = "com.travel.train.provider"
                android.net.Uri r12 = androidx.core.content.FileProvider.getUriForFile(r12, r0, r13)
                com.travel.train.j.f r13 = com.travel.train.j.f.this
                com.travel.train.j.f.a((com.travel.train.j.f) r13, (android.net.Uri) r12)
                return
            L_0x00d6:
                com.travel.train.j.f r12 = com.travel.train.j.f.this
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                com.travel.train.j.f.b(r12, r13)
                return
            L_0x00e4:
                com.travel.train.j.f r12 = com.travel.train.j.f.this
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                if (r13 == 0) goto L_0x0120
                android.net.Uri r13 = android.net.Uri.parse(r13)     // Catch:{ Exception -> 0x0120 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0120 }
                java.lang.String r1 = "android.intent.action.VIEW"
                r0.<init>(r1)     // Catch:{ Exception -> 0x0120 }
                java.lang.String r1 = "application/pdf"
                r0.setDataAndType(r13, r1)     // Catch:{ Exception -> 0x0120 }
                r13 = 67108864(0x4000000, float:1.5046328E-36)
                r0.setFlags(r13)     // Catch:{ Exception -> 0x0120 }
                android.app.Activity r13 = r12.f27533a     // Catch:{ ActivityNotFoundException -> 0x010b }
                r13.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x010b }
                return
            L_0x010b:
                android.app.Activity r13 = r12.f27533a     // Catch:{ Exception -> 0x0120 }
                android.app.Activity r12 = r12.f27533a     // Catch:{ Exception -> 0x0120 }
                android.content.res.Resources r12 = r12.getResources()     // Catch:{ Exception -> 0x0120 }
                int r0 = com.travel.train.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0120 }
                java.lang.String r12 = r12.getString(r0)     // Catch:{ Exception -> 0x0120 }
                android.widget.Toast r12 = android.widget.Toast.makeText(r13, r12, r5)     // Catch:{ Exception -> 0x0120 }
                r12.show()     // Catch:{ Exception -> 0x0120 }
            L_0x0120:
                return
            L_0x0121:
                java.lang.String unused = com.travel.train.j.f.f27532i
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "download failed - retry times = "
                r3.<init>(r4)
                com.travel.train.j.f r4 = com.travel.train.j.f.this
                int r4 = r4.f27539g
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                com.paytm.utility.q.d(r3)
                com.travel.train.j.f r3 = com.travel.train.j.f.this
                com.travel.train.j.f.l(r3)
                com.travel.train.j.f r3 = com.travel.train.j.f.this
                int r3 = r3.f27539g
                if (r3 <= 0) goto L_0x017f
                java.lang.String unused = com.travel.train.j.f.f27532i
                java.lang.String r12 = "will retry download"
                com.paytm.utility.q.d(r12)
                long r12 = r13.getLongExtra(r2, r0)
                com.travel.train.j.f r0 = com.travel.train.j.f.this
                android.app.DownloadManager r0 = r0.f27537e
                long[] r1 = new long[r7]
                r1[r5] = r12
                r0.remove(r1)
                com.travel.train.j.f r12 = com.travel.train.j.f.this
                com.travel.train.model.trainticket.CJRTrainOrderSummaryAction r13 = r12.f27540h
                com.travel.train.j.f r0 = com.travel.train.j.f.this
                int r0 = r0.f27539g
                java.lang.String r1 = com.travel.train.j.f.f27532i
                java.lang.String r1 = "handleDownloadTicketClick"
                com.paytm.utility.q.d(r1)
                if (r13 == 0) goto L_0x017e
                r12.f27539g = r0
                r12.f27540h = r13
                r12.b((com.travel.train.model.trainticket.CJRTrainOrderSummaryAction) r13)
            L_0x017e:
                return
            L_0x017f:
                java.lang.String unused = com.travel.train.j.f.f27532i
                java.lang.String r13 = "------ error downloading ticket ------"
                com.paytm.utility.q.d(r13)
                int r13 = com.travel.train.R.string.some_prob
                android.widget.Toast r12 = android.widget.Toast.makeText(r12, r13, r5)
                r12.show()
                com.travel.train.j.f r12 = com.travel.train.j.f.this
                r12.b()
                com.travel.train.j.f.d()
            L_0x0198:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.f.AnonymousClass5.onReceive(android.content.Context, android.content.Intent):void");
        }
    };
    private b l;
    private aa m;
    /* access modifiers changed from: private */
    public String n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public String p = "CJRTrainActionTapActionClickHelper";

    static /* synthetic */ void d() {
    }

    static /* synthetic */ int l(f fVar) {
        int i2 = fVar.f27539g;
        fVar.f27539g = i2 - 1;
        return i2;
    }

    public f(Activity activity, b bVar, aa aaVar) {
        this.f27533a = activity;
        this.l = bVar;
        this.m = aaVar;
    }

    public final void a(CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction) {
        if (cJRTrainOrderSummaryAction != null) {
            this.f27539g = 1;
            this.f27540h = cJRTrainOrderSummaryAction;
            b(cJRTrainOrderSummaryAction);
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction) {
        if (!TextUtils.isEmpty(cJRTrainOrderSummaryAction.getConfirmation())) {
            c(cJRTrainOrderSummaryAction);
        } else {
            d(cJRTrainOrderSummaryAction);
        }
    }

    private void c(final CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction) {
        try {
            String confirmation = cJRTrainOrderSummaryAction.getConfirmation();
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f27533a);
            builder.setMessage(confirmation);
            builder.setPositiveButton(this.f27533a.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    f.this.d(cJRTrainOrderSummaryAction);
                }
            });
            builder.setNegativeButton(this.f27533a.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public void d(CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction) {
        try {
            q.d("action click + action=" + cJRTrainOrderSummaryAction.toString());
            boolean e2 = e(cJRTrainOrderSummaryAction);
            if (cJRTrainOrderSummaryAction.getUrlParams() == null || cJRTrainOrderSummaryAction.getUrlParams().getMethod() == null || !cJRTrainOrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                q.d("executeGetCall");
                this.n = cJRTrainOrderSummaryAction.getLabel();
                a(cJRTrainOrderSummaryAction.getUrlParams().getUrl(), e2);
                return;
            }
            q.d("-post call");
            String str = null;
            if (cJRTrainOrderSummaryAction.getUrlParams().getBody() != null) {
                str = cJRTrainOrderSummaryAction.getUrlParams().getBody().toString();
            }
            this.n = cJRTrainOrderSummaryAction.getLabel();
            a(cJRTrainOrderSummaryAction.getUrlParams().getUrl(), str, e2);
        } catch (Exception unused) {
            b();
            q.a();
        }
    }

    private void a(String str, boolean z) {
        this.m.d();
        q.d("getting sso token");
        q.d("just got sso token");
        if (z) {
            q.d("making get request with return replace");
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f27533a.getApplicationContext();
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.k;
            bVar.f42879c = a.C0715a.GET;
            bVar.f42880d = str;
            bVar.f42882f = n.b(this.f27533a.getApplicationContext());
            bVar.f42885i = new CJRReplacementResponse();
            bVar.j = this.l;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
            return;
        }
        q.d("making get request w/o return replace");
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = this.f27533a.getApplicationContext();
        bVar2.f42878b = a.c.TRAIN;
        bVar2.n = a.b.SILENT;
        bVar2.o = g.k;
        bVar2.f42879c = a.C0715a.GET;
        bVar2.f42880d = str;
        bVar2.f42882f = n.b(this.f27533a.getApplicationContext());
        bVar2.f42885i = new CJRTrainActionResponse();
        bVar2.j = this.l;
        com.paytm.network.a l3 = bVar2.l();
        l3.f42859c = false;
        l3.a();
    }

    private void a(String str, String str2, boolean z) {
        this.m.d();
        if (z) {
            com.paytm.network.b bVar = new com.paytm.network.b();
            bVar.f42877a = this.f27533a.getApplicationContext();
            bVar.f42878b = a.c.TRAIN;
            bVar.n = a.b.SILENT;
            bVar.o = g.k;
            bVar.f42879c = a.C0715a.POST;
            bVar.f42880d = str;
            bVar.f42882f = n.b(this.f27533a.getApplicationContext());
            bVar.f42884h = str2;
            bVar.f42885i = new CJRReplacementResponse();
            bVar.j = this.l;
            com.paytm.network.a l2 = bVar.l();
            l2.f42859c = false;
            l2.a();
            return;
        }
        com.paytm.network.b bVar2 = new com.paytm.network.b();
        bVar2.f42877a = this.f27533a.getApplicationContext();
        bVar2.f42878b = a.c.TRAIN;
        bVar2.n = a.b.SILENT;
        bVar2.o = g.k;
        bVar2.f42879c = a.C0715a.POST;
        bVar2.f42880d = str;
        bVar2.f42882f = n.b(this.f27533a.getApplicationContext());
        bVar2.f42884h = str2;
        bVar2.f42885i = new CJRTrainActionResponse();
        bVar2.j = this.l;
        com.paytm.network.a l3 = bVar2.l();
        l3.f42859c = false;
        l3.a();
    }

    private static boolean e(CJRTrainOrderSummaryAction cJRTrainOrderSummaryAction) {
        return (cJRTrainOrderSummaryAction == null || cJRTrainOrderSummaryAction.getActionName() == null || !cJRTrainOrderSummaryAction.getActionName().equalsIgnoreCase("Replace_Item")) ? false : true;
    }

    public class a extends AsyncTask<Void, Void, String> {

        /* renamed from: b  reason: collision with root package name */
        private String f27549b;

        /* renamed from: c  reason: collision with root package name */
        private String f27550c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00b3 A[Catch:{ Exception -> 0x017c }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0120 A[Catch:{ Exception -> 0x017c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void onPostExecute(java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.String r0 = "_"
                java.lang.String r9 = (java.lang.String) r9
                com.travel.train.j.f r1 = com.travel.train.j.f.this
                boolean r1 = r1.o
                if (r1 == 0) goto L_0x0012
                com.travel.train.j.f r9 = com.travel.train.j.f.this
                boolean unused = r9.o = false
                return
            L_0x0012:
                java.lang.String r1 = r8.f27549b     // Catch:{ Exception -> 0x017c }
                com.travel.train.j.f r2 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                java.lang.String unused = r2.f27534b = r1     // Catch:{ Exception -> 0x017c }
                com.travel.train.j.f r2 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                r2.b()     // Catch:{ Exception -> 0x017c }
                java.lang.String unused = com.travel.train.j.f.f27532i     // Catch:{ Exception -> 0x017c }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017c }
                java.lang.String r3 = "onPostExecute - url = "
                r2.<init>(r3)     // Catch:{ Exception -> 0x017c }
                r2.append(r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r3 = ", invoiceUrl = "
                r2.append(r3)     // Catch:{ Exception -> 0x017c }
                com.travel.train.j.f r3 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                java.lang.String r3 = r3.f27534b     // Catch:{ Exception -> 0x017c }
                r2.append(r3)     // Catch:{ Exception -> 0x017c }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x017c }
                com.paytm.utility.q.d(r2)     // Catch:{ Exception -> 0x017c }
                r2 = 1
                if (r9 == 0) goto L_0x0133
                java.lang.String r3 = "application/pdf"
                boolean r9 = r9.equalsIgnoreCase(r3)     // Catch:{ Exception -> 0x017c }
                if (r9 == 0) goto L_0x0133
                com.travel.train.j.f r9 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                boolean r1 = com.paytm.utility.s.a()     // Catch:{ Exception -> 0x017c }
                if (r1 == 0) goto L_0x0061
                android.app.Activity r1 = r9.f27533a     // Catch:{ Exception -> 0x017c }
                boolean r1 = com.paytm.utility.s.c((android.app.Activity) r1)     // Catch:{ Exception -> 0x017c }
                if (r1 != 0) goto L_0x0061
                android.app.Activity r9 = r9.f27533a     // Catch:{ Exception -> 0x017c }
                com.paytm.utility.s.b((android.app.Activity) r9)     // Catch:{ Exception -> 0x017c }
                return
            L_0x0061:
                java.lang.String r1 = r9.f27534b     // Catch:{ Exception -> 0x017c }
                if (r1 == 0) goto L_0x0128
                android.content.IntentFilter r1 = new android.content.IntentFilter     // Catch:{ Exception -> 0x017c }
                java.lang.String r3 = "android.intent.action.DOWNLOAD_COMPLETE"
                r1.<init>(r3)     // Catch:{ Exception -> 0x017c }
                android.app.Activity r3 = r9.f27533a     // Catch:{ Exception -> 0x017c }
                android.content.BroadcastReceiver r4 = r9.k     // Catch:{ Exception -> 0x017c }
                r3.registerReceiver(r4, r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r1 = r9.f27534b     // Catch:{ Exception -> 0x017c }
                android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r3 = com.travel.train.j.f.f27532i     // Catch:{ Exception -> 0x017c }
                java.lang.String r3 = "will download data with url = "
                java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r3 = r3.concat(r4)     // Catch:{ Exception -> 0x017c }
                com.paytm.utility.q.d(r3)     // Catch:{ Exception -> 0x017c }
                android.app.Activity r3 = r9.f27533a     // Catch:{ Exception -> 0x017c }
                android.content.pm.PackageManager r3 = r3.getPackageManager()     // Catch:{ Exception -> 0x017c }
                java.lang.String r4 = "com.android.providers.downloads"
                int r3 = r3.getApplicationEnabledSetting(r4)     // Catch:{ Exception -> 0x017c }
                r4 = 2
                if (r3 == r4) goto L_0x00a1
                r4 = 3
                if (r3 == r4) goto L_0x00a1
                r4 = 4
                if (r3 != r4) goto L_0x009f
                goto L_0x00a1
            L_0x009f:
                r3 = 1
                goto L_0x00a5
            L_0x00a1:
                r9.a()     // Catch:{ Exception -> 0x017c }
                r3 = 0
            L_0x00a5:
                if (r3 == 0) goto L_0x0120
                java.lang.String r3 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x017c }
                java.lang.String r4 = "mounted"
                boolean r3 = r4.equals(r3)     // Catch:{ Exception -> 0x017c }
                if (r3 == 0) goto L_0x0120
                android.app.Activity r3 = r9.f27533a     // Catch:{ Exception -> 0x017c }
                java.lang.String r4 = "download"
                java.lang.Object r3 = r3.getSystemService(r4)     // Catch:{ Exception -> 0x017c }
                android.app.DownloadManager r3 = (android.app.DownloadManager) r3     // Catch:{ Exception -> 0x017c }
                r9.f27537e = r3     // Catch:{ Exception -> 0x017c }
                android.app.DownloadManager$Request r3 = new android.app.DownloadManager$Request     // Catch:{ Exception -> 0x017c }
                r3.<init>(r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r1 = ""
                java.lang.String r4 = r9.f27535c     // Catch:{ Exception -> 0x017c }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x017c }
                if (r4 != 0) goto L_0x00d0
                java.lang.String r1 = r9.f27535c     // Catch:{ Exception -> 0x017c }
            L_0x00d0:
                java.lang.String r4 = r9.f27536d     // Catch:{ Exception -> 0x017c }
                boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x017c }
                if (r4 != 0) goto L_0x00da
                java.lang.String r1 = r9.f27536d     // Catch:{ Exception -> 0x017c }
            L_0x00da:
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017c }
                r4.<init>()     // Catch:{ Exception -> 0x017c }
                java.lang.String r5 = r9.j     // Catch:{ Exception -> 0x017c }
                r4.append(r5)     // Catch:{ Exception -> 0x017c }
                r4.append(r0)     // Catch:{ Exception -> 0x017c }
                r4.append(r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x017c }
                r3.setTitle(r4)     // Catch:{ Exception -> 0x017c }
                java.lang.String r4 = "Downloading..."
                r3.setDescription(r4)     // Catch:{ Exception -> 0x017c }
                android.app.Activity r4 = r9.f27533a     // Catch:{ Exception -> 0x017c }
                java.lang.String r5 = android.os.Environment.DIRECTORY_DOWNLOADS     // Catch:{ Exception -> 0x017c }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017c }
                r6.<init>()     // Catch:{ Exception -> 0x017c }
                java.lang.String r7 = r9.j     // Catch:{ Exception -> 0x017c }
                r6.append(r7)     // Catch:{ Exception -> 0x017c }
                r6.append(r0)     // Catch:{ Exception -> 0x017c }
                r6.append(r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r0 = ".pdf"
                r6.append(r0)     // Catch:{ Exception -> 0x017c }
                java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x017c }
                r3.setDestinationInExternalFilesDir(r4, r5, r0)     // Catch:{ Exception -> 0x017c }
                r3.setNotificationVisibility(r2)     // Catch:{ Exception -> 0x017c }
                android.app.DownloadManager r0 = r9.f27537e     // Catch:{ Exception -> 0x017c }
                long r0 = r0.enqueue(r3)     // Catch:{ Exception -> 0x017c }
                goto L_0x0125
            L_0x0120:
                r9.b()     // Catch:{ Exception -> 0x017c }
                r0 = 0
            L_0x0125:
                r9.f27538f = r0     // Catch:{ Exception -> 0x017c }
                return
            L_0x0128:
                java.lang.String r0 = com.travel.train.j.f.f27532i     // Catch:{ Exception -> 0x017c }
                java.lang.String r0 = "invoice url is null"
                com.paytm.utility.q.d(r0)     // Catch:{ Exception -> 0x017c }
                r9.b()     // Catch:{ Exception -> 0x017c }
                return
            L_0x0133:
                android.content.Intent r9 = new android.content.Intent     // Catch:{ Exception -> 0x017c }
                com.travel.train.j.f r0 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                android.app.Activity r0 = r0.f27533a     // Catch:{ Exception -> 0x017c }
                java.lang.Class<com.travel.train.activity.AJRTrainWebViewActivity> r3 = com.travel.train.activity.AJRTrainWebViewActivity.class
                r9.<init>(r0, r3)     // Catch:{ Exception -> 0x017c }
                java.lang.String r0 = "url"
                r9.putExtra(r0, r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r0 = r8.f27550c     // Catch:{ Exception -> 0x017c }
                boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x017c }
                java.lang.String r1 = "title"
                if (r0 != 0) goto L_0x0157
                java.lang.String r0 = r8.f27550c     // Catch:{ Exception -> 0x017c }
                r9.putExtra(r1, r0)     // Catch:{ Exception -> 0x017c }
                goto L_0x0160
            L_0x0157:
                com.travel.train.j.f r0 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                java.lang.String r0 = r0.n     // Catch:{ Exception -> 0x017c }
                r9.putExtra(r1, r0)     // Catch:{ Exception -> 0x017c }
            L_0x0160:
                java.lang.String r0 = "From"
                java.lang.String r1 = "Order_summary"
                r9.putExtra(r0, r1)     // Catch:{ Exception -> 0x017c }
                java.lang.String r0 = "order_id"
                com.travel.train.j.f r1 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                java.lang.String r1 = r1.f27535c     // Catch:{ Exception -> 0x017c }
                r9.putExtra(r0, r1)     // Catch:{ Exception -> 0x017c }
                com.travel.train.j.f r0 = com.travel.train.j.f.this     // Catch:{ Exception -> 0x017c }
                android.app.Activity r0 = r0.f27533a     // Catch:{ Exception -> 0x017c }
                r0.startActivityForResult(r9, r2)     // Catch:{ Exception -> 0x017c }
                return
            L_0x017c:
                java.lang.String unused = com.travel.train.j.f.f27532i
                java.lang.String r9 = "problem in downloading file"
                com.paytm.utility.q.c(r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.f.a.onPostExecute(java.lang.Object):void");
        }

        public a(String str, String str2) {
            this.f27550c = str2;
            this.f27549b = str;
            boolean unused = f.this.o = false;
            String unused2 = f.f27532i;
            q.d("FileLoader initialized, title = " + this.f27550c + ", link = " + str + ", cancelDownload = " + f.this.o);
        }

        private String a() {
            String str = null;
            try {
                String str2 = this.f27549b;
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.getContent();
                str = openConnection.getContentType();
                String unused = f.f27532i;
                q.d("doInBackground - link = " + str2 + ", urlConnection.getContent() = " + openConnection.getContent() + ", contentType = " + str);
                return str;
            } catch (Exception e2) {
                if (!com.paytm.utility.b.v) {
                    return str;
                }
                String unused2 = f.this.p;
                q.c(e2.getMessage());
                return str;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f27533a);
            builder.setMessage(this.f27533a.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
            builder.setPositiveButton(this.f27533a.getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f27544a = false;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (this.f27544a) {
                        s.b((Context) f.this.f27533a);
                        f.this.f27533a.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        f.this.f27533a.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        String unused = f.this.p;
                        q.c(e2.getMessage());
                        f.this.f27533a.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(this.f27533a.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
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
        Activity activity = this.f27533a;
        if (activity instanceof AJRTrainOrderSummaryNew) {
            ((AJRTrainOrderSummaryNew) activity).removeProgressDialog();
        }
    }

    static /* synthetic */ void a(f fVar, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", uri);
        fVar.f27533a.startActivity(Intent.createChooser(intent, "Share Ticket"));
    }

    static /* synthetic */ void b(f fVar, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(str));
        fVar.f27533a.startActivity(Intent.createChooser(intent, "Share Ticket"));
    }
}
