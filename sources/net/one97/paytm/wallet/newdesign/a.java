package net.one97.paytm.wallet.newdesign;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import androidx.core.content.b;
import com.paytm.utility.q;
import java.util.Objects;
import net.one97.paytm.addmoney.d;
import net.one97.paytm.j.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f70456a;

    private a() {
    }

    public static a a() {
        synchronized (a.class) {
            if (f70456a == null) {
                f70456a = new a();
            }
        }
        return f70456a;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r7, java.lang.String r8) {
        /*
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI     // Catch:{ Exception -> 0x003c }
            java.lang.String r8 = android.net.Uri.encode(r8)     // Catch:{ Exception -> 0x003c }
            android.net.Uri r2 = android.net.Uri.withAppendedPath(r0, r8)     // Catch:{ Exception -> 0x003c }
            java.lang.String r8 = "_id"
            java.lang.String r0 = "number"
            java.lang.String r1 = "display_name"
            java.lang.String[] r3 = new java.lang.String[]{r8, r0, r1}     // Catch:{ Exception -> 0x003c }
            android.content.ContentResolver r1 = r7.getContentResolver()     // Catch:{ Exception -> 0x003c }
            r4 = 0
            r5 = 0
            r6 = 0
            android.database.Cursor r7 = r1.query(r2, r3, r4, r5, r6)     // Catch:{ Exception -> 0x003c }
            boolean r8 = r7.moveToFirst()     // Catch:{ all -> 0x0035 }
            if (r8 == 0) goto L_0x002d
            java.lang.String r8 = "1"
            if (r7 == 0) goto L_0x002c
            r7.close()     // Catch:{ Exception -> 0x003c }
        L_0x002c:
            return r8
        L_0x002d:
            if (r7 == 0) goto L_0x0032
            r7.close()     // Catch:{ Exception -> 0x003c }
        L_0x0032:
            java.lang.String r7 = "0"
            return r7
        L_0x0035:
            r8 = move-exception
            if (r7 == 0) goto L_0x003b
            r7.close()     // Catch:{ Exception -> 0x003c }
        L_0x003b:
            throw r8     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            java.lang.String r7 = "2"
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.wallet.newdesign.a.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String a(String str) {
        if (str.contains(".com")) {
            return str.replaceAll(".com", "");
        }
        return str.contains(".COM") ? str.replaceAll(".COM", "") : str;
    }

    public static String b(Context context, String str) {
        Cursor query;
        String str2 = null;
        if ((Build.VERSION.SDK_INT >= 23 && b.a(context, "android.permission.READ_CONTACTS") != 0) || (query = context.getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(str)), new String[]{"display_name"}, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        if (query.moveToFirst()) {
            str2 = query.getString(query.getColumnIndex("display_name"));
        }
        if (query != null && !query.isClosed()) {
            query.close();
        }
        return str2;
    }

    public static void a(Activity activity, String... strArr) {
        if (activity != null && !activity.isFinishing()) {
            try {
                net.one97.paytm.j.a.b("/wallet/add-money", "Wallet", activity.getApplicationContext());
                String str = strArr.length > 0 ? strArr[0] : null;
                c.a();
                if (!c.a("enableGv", false) || "wallet".equalsIgnoreCase(str)) {
                    Objects.requireNonNull(d.g());
                    Intent a2 = d.a((Context) activity, (String) null);
                    a2.putExtra("intent_extra_wallet_type", "wallet_type_add");
                    activity.startActivityForResult(a2, 128);
                    return;
                }
                Objects.requireNonNull(d.g());
                activity.startActivityForResult(d.a((Context) activity, (String) null), 128);
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                net.one97.paytm.j.a.b("/wallet/add-money", "Wallet", activity.getApplicationContext());
                Objects.requireNonNull(d.g());
                activity.startActivity(d.a((Context) activity, (String) null));
                activity.finish();
            } catch (Exception e2) {
                q.b(e2.getMessage());
            }
        }
    }

    public static final Bitmap a(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth() + 5;
        int height = bitmap.getHeight() + 5;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        float f2 = (width > height ? (float) height : (float) width) / 2.0f;
        float f3 = (float) (width / 2);
        float f4 = (float) (height / 2);
        canvas.drawCircle(f3, f4, f2, paint);
        paint.setShader((Shader) null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.rgb(240, 240, 240));
        paint.setStrokeWidth(5.0f);
        canvas.drawCircle(f3, f4, f2 - 2.0f, paint);
        return createBitmap;
    }
}
