package net.one97.paytm.wallet.newdesign.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.paytm.utility.b;
import com.paytm.utility.b.b;
import com.paytm.utility.q;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.locale.b.e;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.wallet.d.l;

public class AJRTrustSeal extends AppCompatLockActivity {

    /* renamed from: e  reason: collision with root package name */
    Dialog f70465e;

    /* renamed from: f  reason: collision with root package name */
    private Toolbar f70466f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ImageView f70467g;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_trust_seal_show);
        this.f70467g = (ImageView) findViewById(R.id.seal_image_view);
        this.f70466f = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.f70466f);
        this.f70466f.setNavigationIcon((int) R.drawable.back_arrow);
        this.f70466f.setNavigationOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJRTrustSeal.this.finish();
            }
        });
        try {
            if (this.f70465e == null) {
                this.f70465e = net.one97.paytm.wallet.utility.a.b((Activity) this);
            }
            if (this.f70465e != null && !this.f70465e.isShowing()) {
                this.f70465e.show();
            }
        } catch (Exception e2) {
            if (b.v) {
                q.b(e2.getMessage());
            }
        }
        new a(this, (byte) 0).execute(new String[]{"https://assetscdn.paytm.com/images/catalog/wallet/group_10_" + l.a((Context) this).toLowerCase() + ".png"});
    }

    public final void a() {
        this.f51786a = 102;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(e.a(context));
    }

    class a extends AsyncTask<String, Void, Void> {

        /* renamed from: a  reason: collision with root package name */
        String f70469a;

        private a() {
        }

        /* synthetic */ a(AJRTrustSeal aJRTrustSeal, byte b2) {
            this();
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            super.onPostExecute((Void) obj);
            AJRTrustSeal aJRTrustSeal = AJRTrustSeal.this;
            try {
                if (aJRTrustSeal.f70465e != null && aJRTrustSeal.f70465e.isShowing()) {
                    aJRTrustSeal.f70465e.dismiss();
                }
            } catch (Exception e2) {
                if (b.v) {
                    q.b(e2.getMessage());
                }
            }
            try {
                File file = new File(AJRTrustSeal.this.getExternalCacheDir(), this.f70469a);
                Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (decodeFile != null) {
                    AJRTrustSeal.this.f70467g.setImageBitmap(decodeFile);
                    return;
                }
                b.a.C0750a a2 = com.paytm.utility.b.b.a(AJRTrustSeal.this.getApplicationContext());
                a2.f43753a = file;
                a2.a(AJRTrustSeal.this.f70467g);
            } catch (Exception unused) {
                AJRTrustSeal.this.finish();
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't wrap try/catch for region: R(10:5|6|7|8|9|10|11|12|(1:14)|20) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x001e */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.String... r5) {
            /*
                r4 = this;
                r0 = 0
                r1 = 0
                r5 = r5[r0]     // Catch:{ Exception -> 0x006d }
                net.one97.paytm.wallet.newdesign.activity.AJRTrustSeal r0 = net.one97.paytm.wallet.newdesign.activity.AJRTrustSeal.this     // Catch:{ Exception -> 0x006d }
                java.io.File r0 = r0.getExternalCacheDir()     // Catch:{ Exception -> 0x006d }
                boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x006d }
                if (r2 == 0) goto L_0x0011
                return r1
            L_0x0011:
                java.lang.String r2 = "/"
                int r2 = r5.lastIndexOf(r2)     // Catch:{ Exception -> 0x001e }
                java.lang.String r2 = r5.substring(r2)     // Catch:{ Exception -> 0x001e }
                r4.f70469a = r2     // Catch:{ Exception -> 0x001e }
                goto L_0x0020
            L_0x001e:
                r4.f70469a = r5     // Catch:{ Exception -> 0x006d }
            L_0x0020:
                java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x006d }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x006d }
                java.lang.String r3 = r4.f70469a     // Catch:{ Exception -> 0x006d }
                r2.<init>(r0, r3)     // Catch:{ Exception -> 0x006d }
                boolean r0 = r2.exists()     // Catch:{ IOException -> 0x0064 }
                if (r0 != 0) goto L_0x0075
                r2.createNewFile()     // Catch:{ IOException -> 0x0064 }
                java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x0064 }
                r0.<init>(r5)     // Catch:{ IOException -> 0x0064 }
                java.net.URLConnection r5 = r0.openConnection()     // Catch:{ IOException -> 0x0064 }
                java.lang.Object r5 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r5)     // Catch:{ IOException -> 0x0064 }
                java.net.URLConnection r5 = (java.net.URLConnection) r5     // Catch:{ IOException -> 0x0064 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x0064 }
                r0 = 30000(0x7530, float:4.2039E-41)
                r5.setConnectTimeout(r0)     // Catch:{ IOException -> 0x0064 }
                r5.setReadTimeout(r0)     // Catch:{ IOException -> 0x0064 }
                r0 = 1
                r5.setInstanceFollowRedirects(r0)     // Catch:{ IOException -> 0x0064 }
                java.io.InputStream r5 = r5.getInputStream()     // Catch:{ IOException -> 0x0064 }
                java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0064 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x0064 }
                net.one97.paytm.wallet.newdesign.activity.AJRTrustSeal.a(r5, r0)     // Catch:{ IOException -> 0x0064 }
                r0.close()     // Catch:{ IOException -> 0x0064 }
                r0.flush()     // Catch:{ IOException -> 0x0064 }
                goto L_0x0075
            L_0x0064:
                r5 = move-exception
                java.lang.String r5 = r5.getMessage()     // Catch:{ Exception -> 0x006d }
                com.paytm.utility.q.b(r5)     // Catch:{ Exception -> 0x006d }
                goto L_0x0075
            L_0x006d:
                r5 = move-exception
                java.lang.String r5 = r5.getMessage()
                com.paytm.utility.q.b(r5)
            L_0x0075:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.activity.AJRTrustSeal.a.doInBackground(java.lang.String[]):java.lang.Void");
        }
    }

    public static void a(InputStream inputStream, OutputStream outputStream) {
        try {
            byte[] bArr = new byte[TarConstants.EOF_BLOCK];
            while (true) {
                int read = inputStream.read(bArr, 0, TarConstants.EOF_BLOCK);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }
}
