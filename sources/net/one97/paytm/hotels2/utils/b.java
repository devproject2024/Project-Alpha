package net.one97.paytm.hotels2.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.paytm.utility.q;
import com.paytm.utility.s;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.net.URL;
import net.one97.paytm.hotels2.R;

public final class b extends AsyncTask<Void, Void, String> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f29977a = "FileLoader";

    /* renamed from: b  reason: collision with root package name */
    private String f29978b;

    /* renamed from: c  reason: collision with root package name */
    private String f29979c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Activity f29980d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public DownloadManager f29981e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f29982f;

    /* renamed from: g  reason: collision with root package name */
    private BroadcastReceiver f29983g = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("extra_download_id", -1);
            Bundle extras = intent.getExtras();
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(new long[]{extras.getLong("extra_download_id")});
            Cursor query2 = b.this.f29981e.query(query);
            if (query2 != null && query2.moveToFirst()) {
                int i2 = query2.getInt(query2.getColumnIndex("status"));
                if (i2 == 8) {
                    query2.getString(query2.getColumnIndex("title"));
                    if (longExtra == ((long) query2.getInt(0)) && longExtra == b.this.f29982f) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            final String string = query2.getString(query2.getColumnIndex("local_uri"));
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    if (!TextUtils.isEmpty(string)) {
                                        b.this.a(string);
                                    }
                                }
                            }, 10000);
                        } else {
                            b.this.a(query2.getString(query2.getColumnIndex("local_uri")));
                        }
                    }
                } else if (i2 == 16 && longExtra == ((long) query2.getInt(0))) {
                    long unused = b.this.f29982f;
                }
            }
            query2.close();
        }
    };

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return c();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        String str = (String) obj;
        if (str != null) {
            try {
                if (str.equalsIgnoreCase("application/pdf")) {
                    if (s.a() && !s.c(this.f29980d)) {
                        s.b(this.f29980d);
                        return;
                    } else if (this.f29978b != null) {
                        a();
                        return;
                    } else {
                        return;
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
        com.paytm.utility.b.b((Context) this.f29980d, this.f29980d.getString(R.string.hotels_error), this.f29980d.getString(R.string.hotels_invoice_dwnld_error));
    }

    public b(String str, String str2, Activity activity) {
        this.f29979c = str2;
        this.f29978b = str;
        this.f29980d = activity;
    }

    private String c() {
        try {
            return new URL(this.f29978b).openConnection().getContentType();
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.c(e2.getMessage());
            }
            return null;
        }
    }

    public final void a() {
        boolean z;
        long j;
        this.f29980d.registerReceiver(this.f29983g, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        Uri parse = Uri.parse(this.f29978b);
        int applicationEnabledSetting = this.f29980d.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
            d();
            z = false;
        } else {
            z = true;
        }
        if (!z || !"mounted".equals(Environment.getExternalStorageState())) {
            j = 0;
        } else {
            this.f29981e = (DownloadManager) this.f29980d.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD);
            DownloadManager.Request request = new DownloadManager.Request(parse);
            String str = "Invoice_" + this.f29979c;
            request.setTitle(str);
            request.setDescription("Downloading...");
            request.setDestinationInExternalFilesDir(this.f29980d, Environment.DIRECTORY_DOWNLOADS, str + ".pdf");
            request.setNotificationVisibility(1);
            j = this.f29981e.enqueue(request);
        }
        this.f29982f = j;
    }

    public final BroadcastReceiver b() {
        return this.f29983g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        android.widget.Toast.makeText(r3.f29980d, r3.f29980d.getResources().getString(net.one97.paytm.hotels2.R.string.hotels_no_pdf_view_msg), 0).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0051 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r4) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0067 }
            if (r0 != 0) goto L_0x0067
            android.app.Activity r0 = r3.f29980d     // Catch:{ Exception -> 0x0067 }
            if (r0 == 0) goto L_0x0067
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r4 = r4.getPath()     // Catch:{ Exception -> 0x0067 }
            android.app.Activity r0 = r3.f29980d     // Catch:{ Exception -> 0x0067 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067 }
            r1.<init>()     // Catch:{ Exception -> 0x0067 }
            net.one97.paytm.hotels2.utils.d r2 = net.one97.paytm.hotels2.utils.c.b()     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = r2.c()     // Catch:{ Exception -> 0x0067 }
            r1.append(r2)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r2 = ".provider"
            r1.append(r2)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0067 }
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0067 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0067 }
            android.net.Uri r4 = androidx.core.content.FileProvider.getUriForFile(r0, r1, r2)     // Catch:{ Exception -> 0x0067 }
            android.content.Intent r0 = new android.content.Intent     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "android.intent.action.VIEW"
            r0.<init>(r1)     // Catch:{ Exception -> 0x0067 }
            java.lang.String r1 = "application/pdf"
            r0.setDataAndType(r4, r1)     // Catch:{ Exception -> 0x0067 }
            r4 = 67108864(0x4000000, float:1.5046328E-36)
            r0.setFlags(r4)     // Catch:{ Exception -> 0x0067 }
            r4 = 1
            r0.setFlags(r4)     // Catch:{ Exception -> 0x0067 }
            android.app.Activity r4 = r3.f29980d     // Catch:{ ActivityNotFoundException -> 0x0051 }
            r4.startActivity(r0)     // Catch:{ ActivityNotFoundException -> 0x0051 }
            return
        L_0x0051:
            android.app.Activity r4 = r3.f29980d     // Catch:{ Exception -> 0x0067 }
            android.app.Activity r0 = r3.f29980d     // Catch:{ Exception -> 0x0067 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ Exception -> 0x0067 }
            int r1 = net.one97.paytm.hotels2.R.string.hotels_no_pdf_view_msg     // Catch:{ Exception -> 0x0067 }
            java.lang.String r0 = r0.getString(r1)     // Catch:{ Exception -> 0x0067 }
            r1 = 0
            android.widget.Toast r4 = android.widget.Toast.makeText(r4, r0, r1)     // Catch:{ Exception -> 0x0067 }
            r4.show()     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotels2.utils.b.a(java.lang.String):void");
    }

    private void d() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.f29980d);
            builder.setMessage(this.f29980d.getResources().getString(R.string.hotels_enable_download_manager_permission_alert_msg));
            builder.setPositiveButton(this.f29980d.getResources().getString(R.string.hotels_action_settings), new DialogInterface.OnClickListener() {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ boolean f29987a = false;

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    if (this.f29987a) {
                        s.b((Context) b.this.f29980d);
                        b.this.f29980d.finish();
                        return;
                    }
                    try {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:com.android.providers.downloads"));
                        b.this.f29980d.startActivity(intent);
                    } catch (ActivityNotFoundException e2) {
                        String unused = b.this.f29977a;
                        q.c(e2.getMessage());
                        b.this.f29980d.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
                    }
                }
            });
            builder.setNegativeButton(this.f29980d.getResources().getString(R.string.hotels_cancel), new DialogInterface.OnClickListener() {
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
}
