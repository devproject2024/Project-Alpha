package com.travel.flight.flightorder.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.travel.flight.R;
import com.travel.flight.activity.FlightWebViewActivity;
import com.travel.flight.flightorder.activity.FlightOrderSummary;
import com.travel.flight.flightorder.g.d;
import com.travel.flight.pojo.flightticket.CJRActionResponse;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction;
import net.one97.paytm.upi.util.UpiConstants;

public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f24384g = a.class.getSimpleName();
    /* access modifiers changed from: package-private */

    /* renamed from: a  reason: collision with root package name */
    public Activity f24385a;

    /* renamed from: b  reason: collision with root package name */
    public String f24386b;

    /* renamed from: c  reason: collision with root package name */
    public String f24387c;

    /* renamed from: d  reason: collision with root package name */
    public String f24388d;

    /* renamed from: e  reason: collision with root package name */
    public int f24389e;

    /* renamed from: f  reason: collision with root package name */
    public CJROrderSummaryAction f24390f;

    /* renamed from: h  reason: collision with root package name */
    private b f24391h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f24392i;
    /* access modifiers changed from: private */
    public DownloadManager j;
    /* access modifiers changed from: private */
    public long k;
    /* access modifiers changed from: private */
    public boolean l;
    private String m = "Ticket";
    private BroadcastReceiver n = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(3:21|22|30) */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            android.widget.Toast.makeText(r12.f24385a, r12.f24385a.getResources().getString(com.travel.flight.R.string.no_pdf_view_msg), 0).show();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0111 */
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
                com.travel.flight.flightorder.e.a r8 = com.travel.flight.flightorder.e.a.this
                android.app.DownloadManager r8 = r8.j
                android.database.Cursor r6 = r8.query(r6)
                boolean r8 = r6.moveToFirst()
                if (r8 == 0) goto L_0x019e
                java.lang.String r8 = "status"
                int r8 = r6.getColumnIndex(r8)
                int r8 = r6.getInt(r8)
                java.lang.String r9 = "reason"
                int r9 = r6.getColumnIndex(r9)
                r6.getInt(r9)
                r9 = 8
                if (r8 != r9) goto L_0x0127
                java.lang.String unused = com.travel.flight.flightorder.e.a.f24384g
                java.lang.String r13 = "download successful..0"
                com.paytm.utility.q.d(r13)
                java.lang.String r13 = "title"
                int r13 = r6.getColumnIndex(r13)
                r6.getString(r13)
                int r13 = r6.getInt(r5)
                long r0 = (long) r13
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0126
                java.lang.String unused = com.travel.flight.flightorder.e.a.f24384g
                java.lang.String r13 = "download successful..1"
                com.paytm.utility.q.d(r13)
                com.travel.flight.flightorder.e.a r13 = com.travel.flight.flightorder.e.a.this
                long r0 = r13.k
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0126
                java.lang.String unused = com.travel.flight.flightorder.e.a.f24384g
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r0 = "download success in "
                r13.<init>(r0)
                com.travel.flight.flightorder.e.a r0 = com.travel.flight.flightorder.e.a.this
                int r0 = r0.f24389e
                int r0 = 5 - r0
                r13.append(r0)
                java.lang.String r0 = " tries"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                com.paytm.utility.q.d(r13)
                com.travel.flight.flightorder.e.a r13 = com.travel.flight.flightorder.e.a.this
                r13.f()
                com.travel.flight.flightorder.e.a.c()
                com.travel.flight.flightorder.e.a r13 = com.travel.flight.flightorder.e.a.this
                java.lang.String r13 = r13.f24392i
                boolean r13 = android.text.TextUtils.isEmpty(r13)
                java.lang.String r0 = "local_uri"
                if (r13 != 0) goto L_0x00ea
                com.travel.flight.flightorder.e.a r13 = com.travel.flight.flightorder.e.a.this
                java.lang.String r13 = r13.f24392i
                java.lang.String r1 = "share ticket"
                boolean r13 = r13.equalsIgnoreCase(r1)
                if (r13 == 0) goto L_0x00ea
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                android.net.Uri r13 = android.net.Uri.parse(r13)
                java.lang.String r13 = r13.getPath()
                java.io.File r0 = new java.io.File
                r0.<init>(r13)
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r1 = r12.getPackageName()
                r13.append(r1)
                java.lang.String r1 = ".provider"
                r13.append(r1)
                java.lang.String r13 = r13.toString()
                android.net.Uri r12 = androidx.core.content.FileProvider.getUriForFile(r12, r13, r0)
                com.travel.flight.flightorder.e.a r13 = com.travel.flight.flightorder.e.a.this
                com.travel.flight.flightorder.e.a.a((com.travel.flight.flightorder.e.a) r13, (android.net.Uri) r12)
                return
            L_0x00ea:
                com.travel.flight.flightorder.e.a r12 = com.travel.flight.flightorder.e.a.this
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                if (r13 == 0) goto L_0x0126
                android.net.Uri r13 = android.net.Uri.parse(r13)     // Catch:{ Exception -> 0x0126 }
                android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0126 }
                java.lang.String r1 = "android.intent.action.VIEW"
                r0.<init>(r1)     // Catch:{ Exception -> 0x0126 }
                java.lang.String r1 = "application/pdf"
                r0.setDataAndType(r13, r1)     // Catch:{ Exception -> 0x0126 }
                r13 = 67108864(0x4000000, float:1.5046328E-36)
                r0.setFlags(r13)     // Catch:{ Exception -> 0x0126 }
                android.app.Activity r13 = r12.f24385a     // Catch:{ ActivityNotFoundException -> 0x0111 }
                r13.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0111 }
                return
            L_0x0111:
                android.app.Activity r13 = r12.f24385a     // Catch:{ Exception -> 0x0126 }
                android.app.Activity r12 = r12.f24385a     // Catch:{ Exception -> 0x0126 }
                android.content.res.Resources r12 = r12.getResources()     // Catch:{ Exception -> 0x0126 }
                int r0 = com.travel.flight.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0126 }
                java.lang.String r12 = r12.getString(r0)     // Catch:{ Exception -> 0x0126 }
                android.widget.Toast r12 = android.widget.Toast.makeText(r13, r12, r5)     // Catch:{ Exception -> 0x0126 }
                r12.show()     // Catch:{ Exception -> 0x0126 }
            L_0x0126:
                return
            L_0x0127:
                java.lang.String unused = com.travel.flight.flightorder.e.a.f24384g
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "download failed - retry times = "
                r3.<init>(r4)
                com.travel.flight.flightorder.e.a r4 = com.travel.flight.flightorder.e.a.this
                int r4 = r4.f24389e
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                com.paytm.utility.q.d(r3)
                com.travel.flight.flightorder.e.a r3 = com.travel.flight.flightorder.e.a.this
                com.travel.flight.flightorder.e.a.l(r3)
                com.travel.flight.flightorder.e.a r3 = com.travel.flight.flightorder.e.a.this
                int r3 = r3.f24389e
                if (r3 <= 0) goto L_0x0185
                java.lang.String unused = com.travel.flight.flightorder.e.a.f24384g
                java.lang.String r12 = "will retry download"
                com.paytm.utility.q.d(r12)
                long r12 = r13.getLongExtra(r2, r0)
                com.travel.flight.flightorder.e.a r0 = com.travel.flight.flightorder.e.a.this
                android.app.DownloadManager r0 = r0.j
                long[] r1 = new long[r7]
                r1[r5] = r12
                r0.remove(r1)
                com.travel.flight.flightorder.e.a r12 = com.travel.flight.flightorder.e.a.this
                net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction r13 = r12.f24390f
                com.travel.flight.flightorder.e.a r0 = com.travel.flight.flightorder.e.a.this
                int r0 = r0.f24389e
                java.lang.String r1 = com.travel.flight.flightorder.e.a.f24384g
                java.lang.String r1 = "handleDownloadTicketClick"
                com.paytm.utility.q.d(r1)
                if (r13 == 0) goto L_0x0184
                r12.f24389e = r0
                r12.f24390f = r13
                r12.a((net.one97.paytm.common.entity.flightticket.CJROrderSummaryAction) r13)
            L_0x0184:
                return
            L_0x0185:
                java.lang.String unused = com.travel.flight.flightorder.e.a.f24384g
                java.lang.String r13 = "------ error downloading ticket ------"
                com.paytm.utility.q.d(r13)
                int r13 = com.travel.flight.R.string.some_prob
                android.widget.Toast r12 = android.widget.Toast.makeText(r12, r13, r5)
                r12.show()
                com.travel.flight.flightorder.e.a r12 = com.travel.flight.flightorder.e.a.this
                r12.f()
                com.travel.flight.flightorder.e.a.c()
            L_0x019e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.flight.flightorder.e.a.AnonymousClass5.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    static /* synthetic */ void c() {
    }

    static /* synthetic */ int l(a aVar) {
        int i2 = aVar.f24389e;
        aVar.f24389e = i2 - 1;
        return i2;
    }

    public a(Activity activity, b bVar) {
        this.f24385a = activity;
        this.f24391h = bVar;
    }

    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        if (!TextUtils.isEmpty(cJROrderSummaryAction.getConfirmation())) {
            b(cJROrderSummaryAction);
        } else {
            c(cJROrderSummaryAction);
        }
    }

    private void b(final CJROrderSummaryAction cJROrderSummaryAction) {
        try {
            String confirmation = cJROrderSummaryAction.getConfirmation();
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f24385a);
            builder.setMessage(confirmation);
            builder.setPositiveButton(this.f24385a.getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    a.this.c(cJROrderSummaryAction);
                }
            });
            builder.setNegativeButton(this.f24385a.getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                }
            });
            builder.setCancelable(false);
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void c(CJROrderSummaryAction cJROrderSummaryAction) {
        try {
            q.d("action click + action=" + cJROrderSummaryAction.toString());
            d(cJROrderSummaryAction);
            if (cJROrderSummaryAction.getUrlParams() == null || cJROrderSummaryAction.getUrlParams().getMethod() == null || !cJROrderSummaryAction.getUrlParams().getMethod().equalsIgnoreCase("POST")) {
                d();
                q.d("executeGetCall");
                this.f24392i = cJROrderSummaryAction.getLabel();
                String url = cJROrderSummaryAction.getUrlParams().getUrl();
                if (!"downloadinvoice".equalsIgnoreCase(cJROrderSummaryAction.getType())) {
                    if (!"Share Ticket".equalsIgnoreCase(cJROrderSummaryAction.getName())) {
                        d();
                        b(url);
                        return;
                    }
                }
                a(cJROrderSummaryAction.getUrlParams().getnewUrl(), cJROrderSummaryAction.getName());
                return;
            }
            q.d("-post call");
            if (cJROrderSummaryAction.getUrlParams().getBody() != null) {
                cJROrderSummaryAction.getUrlParams().getBody();
            }
            this.f24392i = cJROrderSummaryAction.getLabel();
            cJROrderSummaryAction.getUrlParams().getUrl();
            d();
        } catch (Exception unused) {
            f();
            q.a();
        }
    }

    private void b(String str) {
        d();
        HashMap hashMap = new HashMap();
        hashMap.put("ssotoken", com.travel.flight.flightorder.i.a.a(this.f24385a.getApplicationContext()));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = this.f24385a.getApplicationContext();
        bVar.f42878b = a.c.FLIGHT;
        bVar.f42879c = a.C0715a.GET;
        bVar.n = a.b.SILENT;
        bVar.o = this.f24385a.getClass().getSimpleName();
        bVar.f42880d = str;
        bVar.f42881e = null;
        bVar.f42882f = hashMap;
        bVar.f42883g = null;
        bVar.f42884h = null;
        bVar.f42885i = new CJRActionResponse();
        bVar.j = this.f24391h;
        bVar.t = null;
        com.paytm.network.a l2 = bVar.l();
        l2.f42860d = true;
        l2.a();
    }

    private void d() {
        Activity activity = this.f24385a;
        if (activity instanceof FlightOrderSummary) {
            ((FlightOrderSummary) activity).showProgressDialog(activity, activity.getResources().getString(R.string.pre_f_please_wait_progress_msg));
        }
    }

    private static boolean d(CJROrderSummaryAction cJROrderSummaryAction) {
        return (cJROrderSummaryAction == null || cJROrderSummaryAction.getName() == null || !cJROrderSummaryAction.getName().equalsIgnoreCase("Replace_Item")) ? false : true;
    }

    private void a(String str, String str2) {
        q.d("new FileLoader - with title - ".concat(String.valueOf(str2)));
        new C0468a(str, str2).onPostExecute("application/pdf");
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f24392i = str;
        }
    }

    /* renamed from: com.travel.flight.flightorder.e.a$a  reason: collision with other inner class name */
    public class C0468a extends AsyncTask<Void, Void, String> {

        /* renamed from: b  reason: collision with root package name */
        private String f24401b;

        /* renamed from: c  reason: collision with root package name */
        private String f24402c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        public C0468a(String str, String str2) {
            this.f24402c = str2;
            this.f24401b = str;
            boolean unused = a.this.l = false;
            String unused2 = a.f24384g;
            q.d("FileLoader initialized, title = " + this.f24402c + ", link = " + str + ", cancelDownload = " + a.this.l);
        }

        private String a() {
            String str;
            try {
                String str2 = this.f24401b;
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.getContent();
                str = openConnection.getContentType();
                try {
                    String unused = a.f24384g;
                    q.d("doInBackground - link = " + str2 + ", urlConnection.getContent() = " + openConnection.getContent() + ", contentType = " + str);
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                str = null;
                a.c(a.this);
                return str;
            }
            return str;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void onPostExecute(String str) {
            a.this.f();
            a.c(a.this);
            if (a.this.l) {
                boolean unused = a.this.l = false;
                return;
            }
            try {
                String str2 = this.f24401b;
                String unused2 = a.this.f24386b = str2;
                a.this.f();
                String unused3 = a.f24384g;
                q.d("onPostExecute - url = " + str2 + ", invoiceUrl = " + a.this.f24386b);
                if (str == null || !str.equalsIgnoreCase("application/pdf")) {
                    Intent intent = new Intent(a.this.f24385a, FlightWebViewActivity.class);
                    intent.putExtra("url", str2);
                    if (!TextUtils.isEmpty(this.f24402c)) {
                        intent.putExtra("title", this.f24402c);
                    } else {
                        intent.putExtra("title", a.this.f24392i);
                    }
                    intent.putExtra(UpiConstants.FROM, "Order_summary");
                    intent.putExtra("order_id", a.this.f24387c);
                    a.this.f24385a.startActivityForResult(intent, 1);
                    return;
                }
                a.this.a();
            } catch (Exception unused4) {
                String unused5 = a.f24384g;
                q.c("problem in downloading file");
            }
        }
    }

    public final void a() {
        boolean z;
        long j2;
        if (s.a() && !s.c(this.f24385a)) {
            s.b(this.f24385a);
        } else if (this.f24386b != null) {
            this.f24385a.registerReceiver(this.n, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            Uri parse = Uri.parse(this.f24386b);
            q.d("will download data with url = ".concat(String.valueOf(parse)));
            int applicationEnabledSetting = this.f24385a.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                e();
                z = false;
            } else {
                z = true;
            }
            if (!z || !"mounted".equals(Environment.getExternalStorageState())) {
                f();
                j2 = 0;
            } else {
                this.j = (DownloadManager) this.f24385a.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
                DownloadManager.Request request = new DownloadManager.Request(parse);
                request.addRequestHeader(AppConstants.SSO_TOKEN, com.travel.flight.flightorder.i.a.a((Context) this.f24385a));
                String str = !TextUtils.isEmpty(this.f24387c) ? this.f24387c : "";
                if (!TextUtils.isEmpty(this.f24388d)) {
                    str = this.f24388d;
                }
                request.setTitle(this.m + "_" + str);
                request.setDescription("Downloading...");
                Activity activity = this.f24385a;
                String str2 = Environment.DIRECTORY_DOWNLOADS;
                request.setDestinationInExternalFilesDir(activity, str2, this.m + "_" + str + ".pdf");
                request.setNotificationVisibility(1);
                j2 = this.j.enqueue(request);
            }
            this.k = j2;
        } else {
            q.d("invoice url is null");
            f();
        }
    }

    private void e() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f24385a);
            builder.setMessage(this.f24385a.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
            builder.setPositiveButton(this.f24385a.getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f24396a = false;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (this.f24396a) {
                        s.b((Context) a.this.f24385a);
                        a.this.f24385a.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        a.this.f24385a.startActivity(intent);
                    } catch (ActivityNotFoundException unused) {
                        a.this.f24385a.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(this.f24385a.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                }
            });
            builder.show();
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        Activity activity = this.f24385a;
        if (activity instanceof FlightOrderSummary) {
            ((d) activity).removeProgress();
        }
    }

    static /* synthetic */ void c(a aVar) {
        Activity activity = aVar.f24385a;
        if (activity instanceof FlightOrderSummary) {
            ((FlightOrderSummary) activity).hideProgress();
        }
    }

    static /* synthetic */ void a(a aVar, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", uri);
        aVar.f24385a.startActivity(Intent.createChooser(intent, "Share Ticket"));
    }
}
