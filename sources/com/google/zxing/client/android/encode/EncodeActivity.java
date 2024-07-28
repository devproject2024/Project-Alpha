package com.google.zxing.client.android.encode;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.zxing.client.android.R;
import com.google.zxing.client.android.i;
import com.google.zxing.w;
import java.util.regex.Pattern;

public final class EncodeActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40202a = EncodeActivity.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f40203b = Pattern.compile("[^A-Za-z0-9]");

    /* renamed from: c  reason: collision with root package name */
    private d f40204c;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            if ("com.google.zxing.client.android.ENCODE".equals(action) || "android.intent.action.SEND".equals(action)) {
                setContentView(R.layout.encode);
                return;
            }
        }
        finish();
    }

    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.encode, menu);
        d dVar = this.f40204c;
        int i2 = dVar != null && dVar.f40213d ? R.string.menu_encode_mecard : R.string.menu_encode_vcard;
        MenuItem findItem = menu.findItem(R.id.menu_encode);
        findItem.setTitle(i2);
        Intent intent = getIntent();
        if (intent != null) {
            findItem.setVisible("CONTACT_TYPE".equals(intent.getStringExtra("ENCODE_TYPE")));
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0115 A[SYNTHETIC, Splitter:B:38:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011b A[SYNTHETIC, Splitter:B:41:0x011b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onOptionsItemSelected(android.view.MenuItem r11) {
        /*
            r10 = this;
            int r11 = r11.getItemId()
            int r0 = com.google.zxing.client.android.R.id.menu_share
            r1 = 1
            r2 = 0
            if (r11 != r0) goto L_0x0120
            com.google.zxing.client.android.encode.d r11 = r10.f40204c
            if (r11 == 0) goto L_0x011f
            java.lang.String r0 = r11.f40210a
            if (r0 == 0) goto L_0x011f
            android.graphics.Bitmap r3 = r11.a()     // Catch:{ w -> 0x011f }
            if (r3 == 0) goto L_0x011f
            java.io.File r4 = new java.io.File
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()
            java.lang.String r6 = "BarcodeScanner"
            r4.<init>(r5, r6)
            java.io.File r5 = new java.io.File
            java.lang.String r6 = "Barcodes"
            r5.<init>(r4, r6)
            boolean r4 = r5.exists()
            if (r4 != 0) goto L_0x0047
            boolean r4 = r5.mkdirs()
            if (r4 != 0) goto L_0x0047
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Couldn't make dir "
            r11.<init>(r0)
            r11.append(r5)
            int r11 = com.google.zxing.client.android.R.string.msg_unmount_usb
            r10.a(r11)
            goto L_0x011f
        L_0x0047:
            java.io.File r4 = new java.io.File
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.util.regex.Pattern r7 = f40203b
            java.util.regex.Matcher r7 = r7.matcher(r0)
            java.lang.String r8 = "_"
            java.lang.String r7 = r7.replaceAll(r8)
            int r8 = r7.length()
            r9 = 24
            if (r8 <= r9) goto L_0x0066
            java.lang.String r7 = r7.substring(r2, r9)
        L_0x0066:
            r6.append(r7)
            java.lang.String r7 = ".png"
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r4.<init>(r5, r6)
            boolean r5 = r4.delete()
            if (r5 != 0) goto L_0x0085
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Could not delete "
            r5.<init>(r6)
            r5.append(r4)
        L_0x0085:
            r5 = 0
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00fb }
            r6.<init>(r4)     // Catch:{ FileNotFoundException -> 0x00fb }
            android.graphics.Bitmap$CompressFormat r7 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x00f6, all -> 0x00f3 }
            r3.compress(r7, r2, r6)     // Catch:{ FileNotFoundException -> 0x00f6, all -> 0x00f3 }
            r6.close()     // Catch:{ IOException -> 0x0093 }
        L_0x0093:
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "mailto:"
            android.net.Uri r3 = android.net.Uri.parse(r3)
            java.lang.String r6 = "android.intent.action.SEND"
            r2.<init>(r6, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            int r6 = com.google.zxing.client.android.R.string.app_name
            java.lang.String r6 = r10.getString(r6)
            r3.append(r6)
            java.lang.String r6 = " - "
            r3.append(r6)
            java.lang.String r11 = r11.f40212c
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            java.lang.String r3 = "android.intent.extra.SUBJECT"
            r2.putExtra(r3, r11)
            java.lang.String r11 = "android.intent.extra.TEXT"
            r2.putExtra(r11, r0)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "file://"
            r11.<init>(r0)
            java.lang.String r0 = r4.getAbsolutePath()
            r11.append(r0)
            java.lang.String r11 = r11.toString()
            android.net.Uri r11 = android.net.Uri.parse(r11)
            java.lang.String r0 = "android.intent.extra.STREAM"
            r2.putExtra(r0, r11)
            java.lang.String r11 = "image/png"
            r2.setType(r11)
            r11 = 524288(0x80000, float:7.34684E-40)
            r2.addFlags(r11)
            android.content.Intent r11 = android.content.Intent.createChooser(r2, r5)
            r10.startActivity(r11)
            goto L_0x011f
        L_0x00f3:
            r11 = move-exception
            r5 = r6
            goto L_0x0119
        L_0x00f6:
            r11 = move-exception
            r5 = r6
            goto L_0x00fc
        L_0x00f9:
            r11 = move-exception
            goto L_0x0119
        L_0x00fb:
            r11 = move-exception
        L_0x00fc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
            java.lang.String r2 = "Couldn't access file "
            r0.<init>(r2)     // Catch:{ all -> 0x00f9 }
            r0.append(r4)     // Catch:{ all -> 0x00f9 }
            java.lang.String r2 = " due to "
            r0.append(r2)     // Catch:{ all -> 0x00f9 }
            r0.append(r11)     // Catch:{ all -> 0x00f9 }
            int r11 = com.google.zxing.client.android.R.string.msg_unmount_usb     // Catch:{ all -> 0x00f9 }
            r10.a(r11)     // Catch:{ all -> 0x00f9 }
            if (r5 == 0) goto L_0x011f
            r5.close()     // Catch:{  }
            goto L_0x011f
        L_0x0119:
            if (r5 == 0) goto L_0x011e
            r5.close()     // Catch:{ IOException -> 0x011e }
        L_0x011e:
            throw r11
        L_0x011f:
            return r1
        L_0x0120:
            int r0 = com.google.zxing.client.android.R.id.menu_encode
            if (r11 != r0) goto L_0x0141
            android.content.Intent r11 = r10.getIntent()
            if (r11 != 0) goto L_0x012b
            return r2
        L_0x012b:
            com.google.zxing.client.android.encode.d r0 = r10.f40204c
            boolean r0 = r0.f40213d
            r0 = r0 ^ r1
            java.lang.String r2 = "USE_VCARD"
            r11.putExtra(r2, r0)
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r11.addFlags(r0)
            r10.startActivity(r11)
            r10.finish()
            return r1
        L_0x0141:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.client.android.encode.EncodeActivity.onOptionsItemSelected(android.view.MenuItem):boolean");
    }

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        Display defaultDisplay = ((WindowManager) getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i2 = point.x;
        int i3 = point.y;
        if (i2 >= i3) {
            i2 = i3;
        }
        int i4 = (i2 * 7) / 8;
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.f40204c = new d(this, intent, i4, intent.getBooleanExtra("USE_VCARD", false));
                Bitmap a2 = this.f40204c.a();
                if (a2 == null) {
                    a(R.string.msg_encode_contents_failed);
                    this.f40204c = null;
                    return;
                }
                ((ImageView) findViewById(R.id.image_view)).setImageBitmap(a2);
                TextView textView = (TextView) findViewById(R.id.contents_text_view);
                if (intent.getBooleanExtra("ENCODE_SHOW_CONTENTS", true)) {
                    textView.setText(this.f40204c.f40211b);
                    setTitle(this.f40204c.f40212c);
                    return;
                }
                textView.setText("");
                setTitle("");
            } catch (w unused) {
                a(R.string.msg_encode_contents_failed);
                this.f40204c = null;
            }
        }
    }

    private void a(int i2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(i2);
        builder.setPositiveButton(R.string.button_ok, new i(this));
        builder.setOnCancelListener(new i(this));
        builder.show();
    }
}
