package com.google.androidbrowserhelper.trusted;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.a;
import androidx.browser.customtabs.d;
import androidx.browser.trusted.h;
import androidx.core.content.b;
import com.google.androidbrowserhelper.trusted.a.a;
import com.google.androidbrowserhelper.trusted.a.c;

public class LauncherActivity extends AppCompatActivity {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f37616a;

    /* renamed from: b  reason: collision with root package name */
    private b f37617b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37618c;

    /* renamed from: d  reason: collision with root package name */
    private a f37619d;

    /* renamed from: e  reason: collision with root package name */
    private d f37620e;

    public void onCreate(Bundle bundle) {
        boolean z;
        boolean z2;
        int identifier;
        super.onCreate(bundle);
        boolean z3 = false;
        boolean z4 = (getIntent().getFlags() & 268435456) != 0;
        boolean z5 = (getIntent().getFlags() & 524288) != 0;
        if (!z4 || z5) {
            Intent intent = new Intent(getIntent());
            intent.setFlags((268435456 | getIntent().getFlags()) & -524289);
            startActivity(intent);
            z = true;
        } else {
            z = false;
        }
        if (z) {
            finish();
        } else if (bundle == null || !bundle.getBoolean("android.support.customtabs.trusted.BROWSER_WAS_LAUNCHED_KEY")) {
            this.f37617b = b.a(this);
            if (this.f37617b.f37657f == 0) {
                z2 = false;
            } else {
                z2 = isTaskRoot();
            }
            if (z2) {
                this.f37619d = new a(this, this.f37617b.f37657f, b.c(this, this.f37617b.f37658g), ImageView.ScaleType.CENTER, this.f37617b.f37660i, this.f37617b.f37659h);
            }
            androidx.browser.customtabs.a a2 = new a.C0027a().a(b.c(this, this.f37617b.f37654c)).b(b.c(this, this.f37617b.f37656e)).a();
            Uri data = getIntent().getData();
            if (data != null) {
                StringBuilder sb = new StringBuilder("Using URL from Intent (");
                sb.append(data);
                sb.append(").");
            } else if (this.f37617b.f37652a != null) {
                StringBuilder sb2 = new StringBuilder("Using URL from Manifest (");
                sb2.append(this.f37617b.f37652a);
                sb2.append(").");
                data = Uri.parse(this.f37617b.f37652a);
            } else {
                data = Uri.parse("https://www.example.com/");
            }
            h hVar = new h(data);
            hVar.f1944b.a(b.c(this, this.f37617b.f37653b));
            hVar.f1944b.f1904b.b(b.c(this, this.f37617b.f37655d));
            hVar.f1944b.f1903a.putExtra("androidx.browser.customtabs.extra.COLOR_SCHEME", 0);
            d.a aVar = hVar.f1944b;
            if (aVar.f1905c == null) {
                aVar.f1905c = new SparseArray<>();
            }
            aVar.f1905c.put(2, a2.a());
            if (this.f37617b.j != null) {
                hVar.f1945c = this.f37617b.j;
            }
            this.f37620e = new d(this);
            this.f37620e.a(hVar, (c) this.f37619d, (Runnable) new Runnable() {
                public final void run() {
                    LauncherActivity.this.a();
                }
            }, d.f37662a);
            if (!f37616a) {
                String str = this.f37620e.f37664c;
                if (a.f37628a.contains(str)) {
                    int e2 = a.e(getPackageManager(), str);
                    if (e2 != 0 && e2 < 362600000) {
                        z3 = true;
                    }
                    if (z3 && (identifier = getResources().getIdentifier("string/update_chrome_toast", (String) null, getPackageName())) != 0) {
                        Toast.makeText(this, identifier, 1).show();
                    }
                }
                f37616a = true;
            }
            new f(this).f37677a.edit().putString("KEY_PROVIDER_PACKAGE", this.f37620e.f37664c).apply();
        } else {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a() {
        this.f37618c = true;
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        if (this.f37618c) {
            finish();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        d dVar = this.f37620e;
        if (dVar != null && !dVar.f37666e) {
            if (dVar.f37665d != null) {
                dVar.f37663b.unbindService(dVar.f37665d);
            }
            dVar.f37666e = true;
        }
        com.google.androidbrowserhelper.trusted.a.a aVar = this.f37619d;
        if (aVar != null && aVar.f37632a != null) {
            com.google.androidbrowserhelper.trusted.a.b bVar = aVar.f37632a;
            bVar.f37642b.cancel(true);
            bVar.f37641a = null;
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("android.support.customtabs.trusted.BROWSER_WAS_LAUNCHED_KEY", this.f37618c);
    }

    public void onEnterAnimationComplete() {
        super.onEnterAnimationComplete();
        com.google.androidbrowserhelper.trusted.a.a aVar = this.f37619d;
        if (aVar != null) {
            aVar.f37633b = true;
            if (aVar.f37634c != null) {
                aVar.f37634c.run();
                aVar.f37634c = null;
            }
        }
    }
}
