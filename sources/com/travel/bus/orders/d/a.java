package com.travel.bus.orders.d;

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
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.bus.R;
import com.travel.bus.busticket.activity.AJRBusWebViewActivity;
import com.travel.bus.busticket.f.d;
import com.travel.bus.busticket.i.p;
import com.travel.bus.orders.activity.BusOrderSummary;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import net.one97.paytm.common.entity.replacement.CJRReplacementResponse;
import net.one97.paytm.common.entity.shopping.CJRActionResponse;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.upi.util.UpiConstants;

public class a {

    /* renamed from: g  reason: collision with root package name */
    public static final String f22607g = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public Activity f22608a;

    /* renamed from: b  reason: collision with root package name */
    public String f22609b;

    /* renamed from: c  reason: collision with root package name */
    public String f22610c;

    /* renamed from: d  reason: collision with root package name */
    public String f22611d;
    /* access modifiers changed from: package-private */

    /* renamed from: e  reason: collision with root package name */
    public int f22612e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public CJROrderSummaryAction f22613f;

    /* renamed from: h  reason: collision with root package name */
    private b f22614h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public String f22615i;
    /* access modifiers changed from: private */
    public DownloadManager j;
    /* access modifiers changed from: private */
    public long k;
    /* access modifiers changed from: private */
    public boolean l;
    private String m = "Ticket";
    private BroadcastReceiver n = new BroadcastReceiver() {
        /* JADX WARNING: Can't wrap try/catch for region: R(3:25|26|38) */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            android.widget.Toast.makeText(r12.f22608a, r12.f22608a.getResources().getString(com.travel.bus.R.string.no_pdf_view_msg), 0).show();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
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
                com.travel.bus.orders.d.a r8 = com.travel.bus.orders.d.a.this
                android.app.DownloadManager r8 = r8.j
                android.database.Cursor r6 = r8.query(r6)
                boolean r8 = r6.moveToFirst()
                if (r8 == 0) goto L_0x01a6
                java.lang.String r8 = "status"
                int r8 = r6.getColumnIndex(r8)
                int r8 = r6.getInt(r8)
                java.lang.String r9 = "reason"
                int r9 = r6.getColumnIndex(r9)
                r6.getInt(r9)
                r9 = 8
                if (r8 != r9) goto L_0x0121
                java.lang.String unused = com.travel.bus.orders.d.a.f22607g
                java.lang.String r13 = "download successful..0"
                com.paytm.utility.q.d(r13)
                java.lang.String r13 = "title"
                int r13 = r6.getColumnIndex(r13)
                r6.getString(r13)
                int r13 = r6.getInt(r5)
                long r0 = (long) r13
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0120
                java.lang.String unused = com.travel.bus.orders.d.a.f22607g
                java.lang.String r13 = "download successful..1"
                com.paytm.utility.q.d(r13)
                com.travel.bus.orders.d.a r13 = com.travel.bus.orders.d.a.this
                long r0 = r13.k
                int r13 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r13 != 0) goto L_0x0120
                java.lang.String unused = com.travel.bus.orders.d.a.f22607g
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                java.lang.String r0 = "download success in "
                r13.<init>(r0)
                com.travel.bus.orders.d.a r0 = com.travel.bus.orders.d.a.this
                int r0 = r0.f22612e
                int r0 = 5 - r0
                r13.append(r0)
                java.lang.String r0 = " tries"
                r13.append(r0)
                java.lang.String r13 = r13.toString()
                com.paytm.utility.q.d(r13)
                com.travel.bus.orders.d.a r13 = com.travel.bus.orders.d.a.this
                r13.b()
                com.travel.bus.orders.d.a.d()
                com.travel.bus.orders.d.a r13 = com.travel.bus.orders.d.a.this
                java.lang.String r13 = r13.f22615i
                boolean r13 = android.text.TextUtils.isEmpty(r13)
                java.lang.String r0 = "local_uri"
                if (r13 != 0) goto L_0x00e4
                com.travel.bus.orders.d.a r13 = com.travel.bus.orders.d.a.this
                java.lang.String r13 = r13.f22615i
                java.lang.String r1 = "share ticket"
                boolean r13 = r13.equalsIgnoreCase(r1)
                if (r13 == 0) goto L_0x00e4
                int r13 = android.os.Build.VERSION.SDK_INT
                r1 = 24
                if (r13 < r1) goto L_0x00d6
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                java.io.File r13 = r12.getExternalFilesDir(r13)
                java.lang.String r0 = "com.travel.bus.provider"
                android.net.Uri r12 = androidx.core.content.FileProvider.getUriForFile(r12, r0, r13)
                com.travel.bus.orders.d.a r13 = com.travel.bus.orders.d.a.this
                com.travel.bus.orders.d.a.a((com.travel.bus.orders.d.a) r13, (android.net.Uri) r12)
                return
            L_0x00d6:
                com.travel.bus.orders.d.a r12 = com.travel.bus.orders.d.a.this
                int r13 = r6.getColumnIndex(r0)
                java.lang.String r13 = r6.getString(r13)
                com.travel.bus.orders.d.a.b((com.travel.bus.orders.d.a) r12, (java.lang.String) r13)
                return
            L_0x00e4:
                com.travel.bus.orders.d.a r12 = com.travel.bus.orders.d.a.this
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
                android.app.Activity r13 = r12.f22608a     // Catch:{ ActivityNotFoundException -> 0x010b }
                r13.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x010b }
                return
            L_0x010b:
                android.app.Activity r13 = r12.f22608a     // Catch:{ Exception -> 0x0120 }
                android.app.Activity r12 = r12.f22608a     // Catch:{ Exception -> 0x0120 }
                android.content.res.Resources r12 = r12.getResources()     // Catch:{ Exception -> 0x0120 }
                int r0 = com.travel.bus.R.string.no_pdf_view_msg     // Catch:{ Exception -> 0x0120 }
                java.lang.String r12 = r12.getString(r0)     // Catch:{ Exception -> 0x0120 }
                android.widget.Toast r12 = android.widget.Toast.makeText(r13, r12, r5)     // Catch:{ Exception -> 0x0120 }
                r12.show()     // Catch:{ Exception -> 0x0120 }
            L_0x0120:
                return
            L_0x0121:
                java.lang.String unused = com.travel.bus.orders.d.a.f22607g
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "download failed - retry times = "
                r3.<init>(r4)
                com.travel.bus.orders.d.a r4 = com.travel.bus.orders.d.a.this
                int r4 = r4.f22612e
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                com.paytm.utility.q.d(r3)
                com.travel.bus.orders.d.a r3 = com.travel.bus.orders.d.a.this
                com.travel.bus.orders.d.a.k(r3)
                com.travel.bus.orders.d.a r3 = com.travel.bus.orders.d.a.this
                int r3 = r3.f22612e
                if (r3 <= 0) goto L_0x018d
                java.lang.String unused = com.travel.bus.orders.d.a.f22607g
                java.lang.String r12 = "will retry download"
                com.paytm.utility.q.d(r12)
                long r12 = r13.getLongExtra(r2, r0)
                com.travel.bus.orders.d.a r0 = com.travel.bus.orders.d.a.this
                android.app.DownloadManager r0 = r0.j
                long[] r1 = new long[r7]
                r1[r5] = r12
                r0.remove(r1)
                com.travel.bus.orders.d.a r12 = com.travel.bus.orders.d.a.this
                net.one97.paytm.common.entity.shopping.CJROrderSummaryAction r13 = r12.f22613f
                com.travel.bus.orders.d.a r0 = com.travel.bus.orders.d.a.this
                int r0 = r0.f22612e
                java.lang.String r1 = com.travel.bus.orders.d.a.f22607g
                java.lang.String r1 = "handleDownloadTicketClick"
                com.paytm.utility.q.d(r1)
                if (r13 == 0) goto L_0x018c
                r12.f22612e = r0
                r12.f22613f = r13
                java.lang.String r0 = r13.getConfirmation()
                boolean r0 = android.text.TextUtils.isEmpty(r0)
                if (r0 != 0) goto L_0x0189
                r12.a((net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r13)
                return
            L_0x0189:
                r12.b((net.one97.paytm.common.entity.shopping.CJROrderSummaryAction) r13)
            L_0x018c:
                return
            L_0x018d:
                java.lang.String unused = com.travel.bus.orders.d.a.f22607g
                java.lang.String r13 = "------ error downloading ticket ------"
                com.paytm.utility.q.d(r13)
                int r13 = com.travel.bus.R.string.some_prob
                android.widget.Toast r12 = android.widget.Toast.makeText(r12, r13, r5)
                r12.show()
                com.travel.bus.orders.d.a r12 = com.travel.bus.orders.d.a.this
                r12.b()
                com.travel.bus.orders.d.a.d()
            L_0x01a6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.bus.orders.d.a.AnonymousClass2.onReceive(android.content.Context, android.content.Intent):void");
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    static /* synthetic */ void d() {
    }

    static /* synthetic */ int k(a aVar) {
        int i2 = aVar.f22612e;
        aVar.f22612e = i2 - 1;
        return i2;
    }

    public a(Activity activity, b bVar) {
        this.f22608a = activity;
        this.f22614h = bVar;
    }

    /* access modifiers changed from: package-private */
    public final void a(CJROrderSummaryAction cJROrderSummaryAction) {
        try {
            String confirmation = cJROrderSummaryAction.getConfirmation();
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f22608a);
            builder.setMessage(confirmation);
            builder.setPositiveButton(this.f22608a.getResources().getString(R.string.yes), new DialogInterface.OnClickListener(cJROrderSummaryAction) {
                private final /* synthetic */ CJROrderSummaryAction f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    a.this.a(this.f$1, dialogInterface, i2);
                }
            });
            builder.setNegativeButton(this.f22608a.getResources().getString(R.string.no), $$Lambda$a$0N_d9IH92uNIadZMa0kwRKyVfjM.INSTANCE);
            builder.setCancelable(false);
            builder.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJROrderSummaryAction cJROrderSummaryAction, DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        b(cJROrderSummaryAction);
    }

    /* access modifiers changed from: package-private */
    public final void b(CJROrderSummaryAction cJROrderSummaryAction) {
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
                    this.f22615i = cJROrderSummaryAction.getLabel();
                    String b2 = b(cJROrderSummaryAction.getUrlParams().getUrl());
                    HashMap hashMap = new HashMap();
                    hashMap.put("Content-Type", "application/json");
                    if (z) {
                        com.paytm.network.b bVar = new com.paytm.network.b();
                        bVar.f42877a = this.f22608a.getApplicationContext();
                        bVar.f42878b = a.c.BUS;
                        bVar.f42879c = a.C0715a.POST;
                        bVar.f42880d = b2;
                        bVar.f42881e = null;
                        bVar.f42882f = hashMap;
                        bVar.f42883g = null;
                        bVar.f42884h = oVar;
                        bVar.f42885i = new CJRReplacementResponse();
                        bVar.j = this.f22614h;
                        bVar.n = a.b.SILENT;
                        bVar.o = "bus-order-summary-page";
                        com.paytm.network.a l2 = bVar.l();
                        l2.f42860d = true;
                        l2.a();
                        return;
                    }
                    com.paytm.network.b bVar2 = new com.paytm.network.b();
                    bVar2.f42877a = this.f22608a.getApplicationContext();
                    bVar2.f42878b = a.c.BUS;
                    bVar2.f42879c = a.C0715a.POST;
                    bVar2.f42880d = b2;
                    bVar2.f42881e = null;
                    bVar2.f42882f = hashMap;
                    bVar2.f42883g = null;
                    bVar2.f42884h = oVar;
                    bVar2.f42885i = new CJRActionResponse();
                    bVar2.j = this.f22614h;
                    bVar2.t = null;
                    bVar2.n = a.b.SILENT;
                    bVar2.o = "bus-order-summary-page";
                    com.paytm.network.a l3 = bVar2.l();
                    l3.f42860d = true;
                    l3.a();
                    return;
                }
            }
            q.d("executeGetCall");
            this.f22615i = cJROrderSummaryAction.getLabel();
            String url = cJROrderSummaryAction.getUrlParams().getUrl();
            q.d("getting sso token");
            String b3 = b(url);
            q.d("just got sso token");
            if (z) {
                q.d("making get request with return replace");
                HashMap hashMap2 = new HashMap();
                hashMap2.put("ssotoken", p.a(this.f22608a.getApplicationContext()));
                com.paytm.network.b bVar3 = new com.paytm.network.b();
                bVar3.f42877a = this.f22608a.getApplicationContext();
                bVar3.f42878b = a.c.BUS;
                bVar3.f42879c = a.C0715a.GET;
                bVar3.f42880d = b3;
                bVar3.f42881e = null;
                bVar3.f42882f = hashMap2;
                bVar3.f42883g = null;
                bVar3.f42884h = null;
                bVar3.f42885i = new CJRReplacementResponse();
                bVar3.j = this.f22614h;
                bVar3.t = null;
                bVar3.n = a.b.SILENT;
                bVar3.o = "bus-order-summary-page";
                com.paytm.network.a l4 = bVar3.l();
                l4.f42860d = true;
                l4.a();
                return;
            }
            q.d("making get request w/o return replace");
            HashMap hashMap3 = new HashMap();
            hashMap3.put("ssotoken", p.a(this.f22608a.getApplicationContext()));
            com.paytm.network.b bVar4 = new com.paytm.network.b();
            bVar4.f42877a = this.f22608a.getApplicationContext();
            bVar4.f42878b = a.c.BUS;
            bVar4.f42879c = a.C0715a.GET;
            bVar4.f42880d = b3;
            bVar4.f42881e = null;
            bVar4.f42882f = hashMap3;
            bVar4.f42883g = null;
            bVar4.f42884h = null;
            bVar4.f42885i = new CJRActionResponse();
            bVar4.j = this.f22614h;
            bVar4.t = null;
            bVar4.n = a.b.SILENT;
            bVar4.o = "bus-order-summary-page";
            com.paytm.network.a l5 = bVar4.l();
            l5.f42860d = true;
            l5.a();
        } catch (Exception unused) {
            b();
            q.a();
        }
    }

    private static String b(String str) {
        String str2;
        Uri parse = Uri.parse(str);
        if (parse == null) {
            str2 = str + AppConstants.AND_SIGN;
        } else if (parse.getQuery() != null) {
            str2 = str + AppConstants.AND_SIGN;
        } else {
            str2 = str + "?";
        }
        com.travel.bus.a.a();
        return str2 + "sso_token=" + com.travel.bus.b.a.a(com.travel.bus.a.b().D()).b("sso_token=", "", true);
    }

    public final void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f22615i = str;
        }
    }

    /* renamed from: com.travel.bus.orders.d.a$a  reason: collision with other inner class name */
    public class C0441a extends AsyncTask<Void, Void, String> {

        /* renamed from: b  reason: collision with root package name */
        private String f22620b;

        /* renamed from: c  reason: collision with root package name */
        private String f22621c;

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            return a();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            String str = (String) obj;
            if (a.this.l) {
                boolean unused = a.this.l = false;
                return;
            }
            try {
                String str2 = this.f22620b;
                String unused2 = a.this.f22609b = str2;
                a.this.b();
                String unused3 = a.f22607g;
                q.d("onPostExecute - url = " + str2 + ", invoiceUrl = " + a.this.f22609b);
                if (str == null || !str.equalsIgnoreCase("application/pdf")) {
                    Intent intent = new Intent(a.this.f22608a, AJRBusWebViewActivity.class);
                    intent.putExtra("url", str2);
                    if (!TextUtils.isEmpty(this.f22621c)) {
                        intent.putExtra("title", this.f22621c);
                    } else {
                        intent.putExtra("title", a.this.f22615i);
                    }
                    intent.putExtra(UpiConstants.FROM, "Order_summary");
                    intent.putExtra("order_id", a.this.f22610c);
                    a.this.f22608a.startActivityForResult(intent, 1);
                    return;
                }
                a aVar = a.this;
                if (!s.a() || s.c(aVar.f22608a)) {
                    aVar.a();
                } else {
                    s.b(aVar.f22608a);
                }
            } catch (Exception unused4) {
                String unused5 = a.f22607g;
                q.c("problem in downloading file");
            }
        }

        public C0441a(String str, String str2) {
            this.f22621c = str2;
            this.f22620b = str;
            boolean unused = a.this.l = false;
            String unused2 = a.f22607g;
            q.d("FileLoader initialized, title = " + this.f22621c + ", link = " + str + ", cancelDownload = " + a.this.l);
        }

        private String a() {
            String str = null;
            try {
                String str2 = this.f22620b;
                URLConnection openConnection = new URL(str2).openConnection();
                openConnection.getContent();
                str = openConnection.getContentType();
                String unused = a.f22607g;
                q.d("doInBackground - link = " + str2 + ", urlConnection.getContent() = " + openConnection.getContent() + ", contentType = " + str);
                return str;
            } catch (Exception e2) {
                if (!com.paytm.utility.b.v) {
                    return str;
                }
                q.c(e2.getMessage());
                return str;
            }
        }
    }

    public final void a(final boolean z) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f22608a);
            if (z) {
                builder.setMessage(this.f22608a.getResources().getString(R.string.write_to_sdcard_permission_alert_msg));
            } else {
                builder.setMessage(this.f22608a.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
            }
            builder.setPositiveButton(this.f22608a.getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (z) {
                        s.b((Context) a.this.f22608a);
                        a.this.f22608a.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        a.this.f22608a.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        q.c(e2.getMessage());
                        a.this.f22608a.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(this.f22608a.getResources().getString(R.string.cancel), $$Lambda$a$lXRMTQkql8y5nv9xsJwfIxG3R0.INSTANCE);
            builder.show();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
        }
    }

    public final void a() {
        try {
            if (this.f22609b != null) {
                this.f22608a.registerReceiver(this.n, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                Uri parse = Uri.parse(this.f22609b);
                q.d("will download data with url = ".concat(String.valueOf(parse)));
                this.k = a(parse);
                return;
            }
            q.d("invoice url is null");
            b();
        } catch (Exception unused) {
        }
    }

    private long a(Uri uri) {
        if (!e() || !f()) {
            b();
            return 0;
        }
        this.j = (DownloadManager) this.f22608a.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        String str = !TextUtils.isEmpty(this.f22610c) ? this.f22610c : "";
        if (!TextUtils.isEmpty(this.f22611d)) {
            str = this.f22611d;
        }
        request.setTitle(this.m + "_" + str);
        request.setDescription("Downloading...");
        Activity activity = this.f22608a;
        String str2 = Environment.DIRECTORY_DOWNLOADS;
        request.setDestinationInExternalFilesDir(activity, str2, this.m + "_" + str + ".pdf");
        request.setNotificationVisibility(1);
        return this.j.enqueue(request);
    }

    public final void b() {
        Activity activity = this.f22608a;
        if (activity instanceof BusOrderSummary) {
            ((d) activity).removeProgress();
        }
    }

    private boolean e() {
        int applicationEnabledSetting = this.f22608a.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3 && applicationEnabledSetting != 4) {
            return true;
        }
        a(false);
        return false;
    }

    private static boolean f() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    static /* synthetic */ void a(a aVar, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", uri);
        aVar.f22608a.startActivity(Intent.createChooser(intent, "Share Ticket"));
    }

    static /* synthetic */ void b(a aVar, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("application/pdf");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(str));
        aVar.f22608a.startActivity(Intent.createChooser(intent, "Share Ticket"));
    }
}
