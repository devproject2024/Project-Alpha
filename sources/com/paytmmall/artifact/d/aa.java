package com.paytmmall.artifact.d;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import androidx.core.app.a;
import androidx.core.content.FileProvider;
import com.paytm.utility.q;
import com.paytmmall.artifact.R;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

public final class aa {

    /* renamed from: d  reason: collision with root package name */
    protected static ArrayList<Long> f15676d = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f15677h = "ShareUtils";

    /* renamed from: a  reason: collision with root package name */
    protected Uri f15678a;

    /* renamed from: b  reason: collision with root package name */
    protected ArrayList<Uri> f15679b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    protected Long f15680c;

    /* renamed from: e  reason: collision with root package name */
    protected Activity f15681e;

    /* renamed from: f  reason: collision with root package name */
    protected int f15682f = 0;

    /* renamed from: g  reason: collision with root package name */
    protected String f15683g = "";

    /* renamed from: i  reason: collision with root package name */
    private Uri f15684i = null;
    private String j = "";
    private BroadcastReceiver k = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            aa.this.a(intent.getLongExtra("extra_download_id", -1));
        }
    };

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(DialogInterface dialogInterface, int i2) {
    }

    public final boolean a(String str, final Activity activity, String str2, final String str3) {
        boolean z;
        this.f15681e = activity;
        this.f15683g = str;
        ArrayList arrayList = new ArrayList();
        arrayList.add(str3);
        if (!y.a() || y.b(this.f15681e)) {
            z = true;
        } else {
            a.a(this.f15681e, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 60);
            z = false;
        }
        if (!z) {
            return false;
        }
        this.f15682f = arrayList.size();
        Activity activity2 = this.f15681e;
        String string = activity2.getResources().getString(R.string.please_wait_progress_msg);
        Boolean bool = Boolean.TRUE;
        d.a(activity2, string, bool, bool);
        f15676d = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        if (this.f15682f > 0) {
            for (int i2 = 0; i2 < this.f15682f; i2++) {
                arrayList2.add(arrayList.get(i2));
            }
        }
        Activity activity3 = this.f15681e;
        if (activity3 != null) {
            ((ClipboardManager) activity3.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("ws_clip", str2));
        }
        new Handler().postDelayed(new Runnable() {
            public final void run() {
                aa.a(aa.this, str3);
            }
        }, 100);
        return true;
    }

    public static boolean a(String str, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static String a(String str, int i2) {
        return str + "_" + i2;
    }

    private static String a(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("imwidth", String.valueOf(Math.abs(240))).build().toString();
        } catch (Exception unused) {
            return str;
        }
    }

    private Uri b(String str) {
        return FileProvider.getUriForFile(this.f15681e, this.f15681e.getPackageName() + ".provider", new File(this.f15681e.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + str));
    }

    public final void a(long j2) {
        Activity activity;
        String str;
        f15676d.remove(Long.valueOf(j2));
        if (f15676d.isEmpty() && (activity = this.f15681e) != null) {
            BroadcastReceiver broadcastReceiver = this.k;
            if (broadcastReceiver != null) {
                activity.unregisterReceiver(broadcastReceiver);
            }
            d.h();
            Activity activity2 = this.f15681e;
            Intent intent = new Intent();
            boolean z = this.f15679b.size() > 1;
            intent.setAction(z ? "android.intent.action.SEND_MULTIPLE" : "android.intent.action.SEND");
            if (z) {
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f15679b);
            } else {
                intent.putExtra("android.intent.extra.STREAM", this.f15679b.get(0));
            }
            intent.addFlags(1);
            intent.setType("image/*");
            intent.setType("text/plain");
            if (!TextUtils.isEmpty(this.f15683g) && this.f15683g.length() > 0) {
                intent.setPackage(this.f15683g);
            }
            if (activity2 != null) {
                ClipboardManager clipboardManager = (ClipboardManager) activity2.getSystemService("clipboard");
                if (clipboardManager.hasPrimaryClip()) {
                    ClipDescription primaryClipDescription = clipboardManager.getPrimaryClipDescription();
                    ClipData primaryClip = clipboardManager.getPrimaryClip();
                    if (!(primaryClip == null || primaryClipDescription == null || !primaryClipDescription.hasMimeType("text/plain"))) {
                        str = String.valueOf(primaryClip.getItemAt(0).getText());
                        intent.putExtra("android.intent.extra.TEXT", str);
                        activity2.startActivity(intent);
                    }
                }
            }
            str = null;
            intent.putExtra("android.intent.extra.TEXT", str);
            activity2.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Activity activity, DialogInterface dialogInterface, int i2) {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:com.android.providers.downloads"));
            activity.startActivity(intent);
        } catch (ActivityNotFoundException e2) {
            q.c(e2.getMessage());
            activity.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
        }
    }

    static /* synthetic */ void a(aa aaVar, String str) {
        boolean z;
        DownloadManager downloadManager;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(str);
        arrayList2.add(UUID.randomUUID().toString());
        if (arrayList.size() > 0) {
            boolean z2 = false;
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                if (!new File(aaVar.f15681e.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + (a((String) arrayList2.get(i2), i2) + ".jpg")).exists()) {
                    z2 = true;
                }
            }
            Activity activity = aaVar.f15681e;
            int applicationEnabledSetting = activity.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
            if (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage(activity.getResources().getString(R.string.enable_download_manager_permission_alert_msg));
                    builder.setPositiveButton(activity.getResources().getString(R.string.action_settings), new DialogInterface.OnClickListener(activity) {
                        private final /* synthetic */ Activity f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            aa.a(this.f$0, dialogInterface, i2);
                        }
                    });
                    builder.setNegativeButton(activity.getResources().getString(R.string.cancel), $$Lambda$aa$CpvPr7f6svR1mRrTvHF24MYMSs.INSTANCE);
                    builder.show();
                } catch (Exception unused) {
                }
                z = false;
            } else {
                z = true;
            }
            if (z && "mounted".equals(Environment.getExternalStorageState()) && (downloadManager = (DownloadManager) aaVar.f15681e.getSystemService(Item.CTA_URL_TYPE_DOWNLOAD)) != null) {
                aaVar.f15681e.registerReceiver(aaVar.k, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    aaVar.j = a((String) arrayList2.get(i3), i3) + ".jpg";
                    String str2 = (String) arrayList.get(i3);
                    try {
                        str2 = a(str2);
                        aaVar.f15678a = Uri.parse(str2.replaceAll(" ", "%20"));
                    } catch (Exception unused2) {
                        aaVar.f15678a = Uri.parse(str2);
                    }
                    if (z2) {
                        DownloadManager.Request request = new DownloadManager.Request(aaVar.f15678a);
                        request.setAllowedNetworkTypes(3);
                        request.setAllowedOverRoaming(true);
                        request.setTitle("Downloading... ");
                        request.setDescription("Downloading... ");
                        request.setVisibleInDownloadsUi(true);
                        request.setDestinationInExternalFilesDir(aaVar.f15681e, Environment.DIRECTORY_DOWNLOADS, aaVar.j);
                        aaVar.f15680c = Long.valueOf(downloadManager.enqueue(request));
                        f15676d.add(aaVar.f15680c);
                        aaVar.f15684i = aaVar.b(aaVar.j);
                        aaVar.f15679b.add(aaVar.f15684i);
                    } else {
                        aaVar.f15684i = aaVar.b(aaVar.j);
                        aaVar.f15679b.add(aaVar.f15684i);
                    }
                }
            }
            if (!z2) {
                aaVar.a(1001);
            }
        }
    }
}
