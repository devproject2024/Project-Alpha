package com.google.androidbrowserhelper.trusted;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.c;
import androidx.browser.customtabs.d;
import androidx.browser.customtabs.e;
import androidx.browser.customtabs.f;
import com.google.androidbrowserhelper.R;

public class ManageDataLauncherActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private String f37621a;

    /* renamed from: b  reason: collision with root package name */
    private e f37622b;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0055, code lost:
        if (r5.filter.hasCategory("androidx.browser.trusted.category.TrustedWebActivities") != false) goto L_0x0059;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r5) {
        /*
            r4 = this;
            super.onCreate(r5)
            com.google.androidbrowserhelper.trusted.f r5 = new com.google.androidbrowserhelper.trusted.f
            r5.<init>(r4)
            android.content.SharedPreferences r5 = r5.f37677a
            java.lang.String r0 = "KEY_PROVIDER_PACKAGE"
            r1 = 0
            java.lang.String r5 = r5.getString(r0, r1)
            r4.f37621a = r5
            java.lang.String r5 = r4.f37621a
            if (r5 != 0) goto L_0x001b
            r4.b()
            return
        L_0x001b:
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            boolean r0 = com.google.androidbrowserhelper.trusted.a.b(r0, r5)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0028
            goto L_0x0059
        L_0x0028:
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r3 = "android.support.customtabs.action.CustomTabsService"
            r0.<init>(r3)
            android.content.Intent r5 = r0.setPackage(r5)
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            r3 = 64
            java.util.List r5 = r0.queryIntentServices(r5, r3)
            boolean r0 = r5.isEmpty()
            if (r0 != 0) goto L_0x0058
            java.lang.Object r5 = r5.get(r2)
            android.content.pm.ResolveInfo r5 = (android.content.pm.ResolveInfo) r5
            android.content.IntentFilter r0 = r5.filter
            if (r0 == 0) goto L_0x0058
            android.content.IntentFilter r5 = r5.filter
            java.lang.String r0 = "androidx.browser.trusted.category.TrustedWebActivities"
            boolean r5 = r5.hasCategory(r0)
            if (r5 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            r1 = 0
        L_0x0059:
            if (r1 != 0) goto L_0x005f
            r4.c()
            return
        L_0x005f:
            android.widget.ProgressBar r5 = new android.widget.ProgressBar
            r5.<init>(r4)
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = -2
            r0.<init>(r1, r1)
            r1 = 17
            r0.gravity = r1
            r5.setLayoutParams(r0)
            android.widget.FrameLayout r0 = new android.widget.FrameLayout
            r0.<init>(r4)
            r0.addView(r5)
            r4.setContentView((android.view.View) r0)
            android.content.pm.PackageManager r5 = r4.getPackageManager()
            java.lang.String r0 = r4.f37621a
            boolean r5 = com.google.androidbrowserhelper.trusted.a.d(r5, r0)
            if (r5 == 0) goto L_0x0090
            com.google.androidbrowserhelper.trusted.ManageDataLauncherActivity$a r5 = new com.google.androidbrowserhelper.trusted.ManageDataLauncherActivity$a
            r5.<init>(r4, r2)
            r4.f37622b = r5
            goto L_0x0097
        L_0x0090:
            com.google.androidbrowserhelper.trusted.ManageDataLauncherActivity$b r5 = new com.google.androidbrowserhelper.trusted.ManageDataLauncherActivity$b
            r5.<init>(r4, r2)
            r4.f37622b = r5
        L_0x0097:
            java.lang.String r5 = r4.f37621a
            androidx.browser.customtabs.e r0 = r4.f37622b
            androidx.browser.customtabs.c.a(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.androidbrowserhelper.trusted.ManageDataLauncherActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public final Uri a() {
        try {
            ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), 128);
            if (activityInfo.metaData == null || !activityInfo.metaData.containsKey("android.support.customtabs.trusted.MANAGE_SPACE_URL")) {
                return null;
            }
            Uri parse = Uri.parse(activityInfo.metaData.getString("android.support.customtabs.trusted.MANAGE_SPACE_URL"));
            StringBuilder sb = new StringBuilder("Using clean-up URL from Manifest (");
            sb.append(parse);
            sb.append(").");
            return parse;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new RuntimeException(e2);
        }
    }

    protected static void a(RuntimeException runtimeException) {
        throw runtimeException;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        Toast.makeText(this, getString(R.string.manage_space_no_data_toast), 1).show();
        finish();
    }

    private void c() {
        String str;
        try {
            str = getPackageManager().getApplicationLabel(getPackageManager().getApplicationInfo(this.f37621a, 0)).toString();
        } catch (PackageManager.NameNotFoundException unused) {
            str = this.f37621a;
        }
        Toast.makeText(this, getString(R.string.manage_space_not_supported_toast, new Object[]{str}), 1).show();
        finish();
    }

    public void onStop() {
        super.onStop();
        e eVar = this.f37622b;
        if (eVar != null) {
            unbindService(eVar);
        }
        finish();
    }

    private static boolean a(Activity activity, f fVar, String str, Uri uri) {
        Intent intent = new d.a().a(fVar).c().f1901a;
        intent.setAction("android.support.customtabs.action.ACTION_MANAGE_TRUSTED_WEB_ACTIVITY_DATA");
        intent.setPackage(str);
        intent.setData(uri);
        try {
            activity.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    class a extends e {
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private a() {
        }

        /* synthetic */ a(ManageDataLauncherActivity manageDataLauncherActivity, byte b2) {
            this();
        }

        public final void a(ComponentName componentName, c cVar) {
            if (!ManageDataLauncherActivity.this.isFinishing()) {
                ManageDataLauncherActivity.a(ManageDataLauncherActivity.this, cVar.a((androidx.browser.customtabs.b) null, (PendingIntent) null));
            }
        }
    }

    class b extends e {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public f f37625c;

        /* renamed from: d  reason: collision with root package name */
        private androidx.browser.customtabs.b f37626d;

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        private b() {
            this.f37626d = new androidx.browser.customtabs.b() {
                public final void a(int i2, Uri uri, boolean z, Bundle bundle) {
                    if (!ManageDataLauncherActivity.this.isFinishing()) {
                        if (!z) {
                            ManageDataLauncherActivity.a(new RuntimeException("Failed to validate origin ".concat(String.valueOf(uri))));
                            ManageDataLauncherActivity.this.finish();
                            return;
                        }
                        ManageDataLauncherActivity.a(ManageDataLauncherActivity.this, b.this.f37625c);
                    }
                }
            };
        }

        /* synthetic */ b(ManageDataLauncherActivity manageDataLauncherActivity, byte b2) {
            this();
        }

        public final void a(ComponentName componentName, c cVar) {
            if (!ManageDataLauncherActivity.this.isFinishing()) {
                Uri a2 = ManageDataLauncherActivity.this.a();
                if (a2 == null) {
                    ManageDataLauncherActivity.a(new RuntimeException("Can't launch settings without an url"));
                    ManageDataLauncherActivity.this.finish();
                    return;
                }
                this.f37625c = cVar.a(this.f37626d, (PendingIntent) null);
                if (!cVar.a()) {
                    ManageDataLauncherActivity.this.b();
                } else {
                    this.f37625c.a(a2);
                }
            }
        }
    }

    static /* synthetic */ void a(ManageDataLauncherActivity manageDataLauncherActivity, f fVar) {
        if (a(manageDataLauncherActivity, fVar, manageDataLauncherActivity.f37621a, manageDataLauncherActivity.a())) {
            manageDataLauncherActivity.finish();
        } else {
            manageDataLauncherActivity.c();
        }
    }
}
