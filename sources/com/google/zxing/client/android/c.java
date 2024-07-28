package com.google.zxing.client.android;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import com.business.merchant_payments.mapqr.zxingutils.ScanDecodeThread;
import com.google.zxing.client.a.q;
import com.google.zxing.client.a.u;
import com.google.zxing.client.android.a.d;
import com.google.zxing.client.android.c.a;
import com.google.zxing.client.android.c.b;
import com.google.zxing.client.android.c.f;
import com.google.zxing.client.android.c.g;
import com.google.zxing.client.android.c.h;
import com.google.zxing.client.android.c.i;
import com.google.zxing.client.android.c.j;
import com.google.zxing.client.android.c.k;
import com.google.zxing.client.android.c.l;
import com.google.zxing.client.android.c.m;
import com.google.zxing.e;
import com.google.zxing.r;
import java.util.Collection;
import java.util.Map;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;

public final class c extends Handler {

    /* renamed from: d  reason: collision with root package name */
    private static final String f40163d = c.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    final h f40164a;

    /* renamed from: b  reason: collision with root package name */
    a f40165b = a.SUCCESS;

    /* renamed from: c  reason: collision with root package name */
    final d f40166c;

    /* renamed from: e  reason: collision with root package name */
    private final CaptureActivity f40167e;

    enum a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    public c(CaptureActivity captureActivity, Collection<com.google.zxing.a> collection, Map<e, ?> map, String str, d dVar) {
        this.f40167e = captureActivity;
        this.f40164a = new h(captureActivity, collection, map, str, new p(captureActivity.f40088c));
        this.f40164a.start();
        this.f40166c = dVar;
        dVar.c();
        a();
    }

    public final void handleMessage(Message message) {
        Bitmap bitmap;
        float f2;
        g gVar;
        SQLiteDatabase sQLiteDatabase;
        SQLiteDatabase sQLiteDatabase2;
        if (message.what == R.id.restart_preview) {
            a();
            return;
        }
        String str = null;
        if (message.what == R.id.decode_succeeded) {
            this.f40165b = a.SUCCESS;
            Bundle data = message.getData();
            if (data != null) {
                byte[] byteArray = data.getByteArray(ScanDecodeThread.BARCODE_BITMAP);
                bitmap = byteArray != null ? BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, (BitmapFactory.Options) null).copy(Bitmap.Config.ARGB_8888, true) : null;
                f2 = data.getFloat(ScanDecodeThread.BARCODE_SCALED_FACTOR);
            } else {
                bitmap = null;
                f2 = 1.0f;
            }
            CaptureActivity captureActivity = this.f40167e;
            r rVar = (r) message.obj;
            captureActivity.f40091f.a();
            captureActivity.f40089d = rVar;
            q c2 = u.c(rVar);
            switch (h.AnonymousClass1.f40183a[c2.q.ordinal()]) {
                case 1:
                    gVar = new a(captureActivity, c2);
                    break;
                case 2:
                    gVar = new com.google.zxing.client.android.c.c(captureActivity, c2);
                    break;
                case 3:
                    gVar = new f(captureActivity, c2, rVar);
                    break;
                case 4:
                    gVar = new l(captureActivity, c2);
                    break;
                case 5:
                    gVar = new m(captureActivity, c2);
                    break;
                case 6:
                    gVar = new com.google.zxing.client.android.c.d(captureActivity, c2);
                    break;
                case 7:
                    gVar = new j(captureActivity, c2);
                    break;
                case 8:
                    gVar = new i(captureActivity, c2);
                    break;
                case 9:
                    gVar = new b(captureActivity, c2);
                    break;
                case 10:
                    gVar = new com.google.zxing.client.android.c.e(captureActivity, c2, rVar);
                    break;
                default:
                    gVar = new k(captureActivity, c2, rVar);
                    break;
            }
            if (bitmap != null) {
                com.google.zxing.client.android.history.d dVar = captureActivity.f40090e;
                if (dVar.f40245b.getIntent().getBooleanExtra("SAVE_HISTORY", true) && !gVar.b() && dVar.f40246c) {
                    if (!PreferenceManager.getDefaultSharedPreferences(dVar.f40245b).getBoolean("preferences_remember_duplicates", false)) {
                        String str2 = rVar.f40577a;
                        try {
                            sQLiteDatabase2 = new com.google.zxing.client.android.history.a(dVar.f40245b).getWritableDatabase();
                            try {
                                sQLiteDatabase2.delete("history", "text=?", new String[]{str2});
                                com.google.zxing.client.android.history.d.a((Cursor) null, sQLiteDatabase2);
                            } catch (Throwable th) {
                                th = th;
                                com.google.zxing.client.android.history.d.a((Cursor) null, sQLiteDatabase2);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            sQLiteDatabase2 = null;
                            com.google.zxing.client.android.history.d.a((Cursor) null, sQLiteDatabase2);
                            throw th;
                        }
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX, rVar.f40577a);
                    contentValues.put("format", rVar.f40580d.toString());
                    contentValues.put("display", gVar.a().toString());
                    contentValues.put("timestamp", Long.valueOf(System.currentTimeMillis()));
                    try {
                        sQLiteDatabase = new com.google.zxing.client.android.history.a(dVar.f40245b).getWritableDatabase();
                        try {
                            sQLiteDatabase.insert("history", "timestamp", contentValues);
                            com.google.zxing.client.android.history.d.a((Cursor) null, sQLiteDatabase);
                        } catch (Throwable th3) {
                            th = th3;
                            com.google.zxing.client.android.history.d.a((Cursor) null, sQLiteDatabase);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        sQLiteDatabase = null;
                        com.google.zxing.client.android.history.d.a((Cursor) null, sQLiteDatabase);
                        throw th;
                    }
                }
                captureActivity.f40092g.b();
                captureActivity.a(bitmap, f2, rVar);
            }
            Intent intent = new Intent();
            intent.putExtra("qr_data", String.valueOf(rVar));
            captureActivity.setResult(-1, intent);
            captureActivity.finish();
        } else if (message.what == R.id.decode_failed) {
            this.f40165b = a.PREVIEW;
            this.f40166c.a(this.f40164a.a(), R.id.decode);
        } else if (message.what == R.id.return_scan_result) {
            this.f40167e.setResult(-1, (Intent) message.obj);
            this.f40167e.finish();
        } else if (message.what == R.id.launch_product_query) {
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(524288);
            intent2.setData(Uri.parse((String) message.obj));
            ResolveInfo resolveActivity = this.f40167e.getPackageManager().resolveActivity(intent2, 65536);
            if (!(resolveActivity == null || resolveActivity.activityInfo == null)) {
                str = resolveActivity.activityInfo.packageName;
            }
            if ("com.android.browser".equals(str) || "com.android.chrome".equals(str)) {
                intent2.setPackage(str);
                intent2.addFlags(268435456);
                intent2.putExtra("com.android.browser.application_id", str);
            }
            try {
                this.f40167e.startActivity(intent2);
            } catch (ActivityNotFoundException unused) {
            }
        }
    }

    private void a() {
        if (this.f40165b == a.SUCCESS) {
            this.f40165b = a.PREVIEW;
            this.f40166c.a(this.f40164a.a(), R.id.decode);
            this.f40167e.a();
        }
    }
}
