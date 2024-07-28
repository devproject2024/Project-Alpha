package net.one97.paytm.fastscanner.e;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.zxing.b.j;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.o;
import com.google.zxing.r;
import java.util.Hashtable;
import java.util.Map;
import net.one97.paytm.fastscanner.R;
import net.one97.paytm.fastscanner.b.d;
import net.one97.paytm.fastscanner.b.f;

public final class a extends net.one97.paytm.fastscanner.b.a {

    /* renamed from: b  reason: collision with root package name */
    private static final String f50472b = a.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private final com.google.zxing.g.a f50473c = new com.google.zxing.g.a();

    /* renamed from: d  reason: collision with root package name */
    private final Map<e, Object> f50474d = new Hashtable();

    /* renamed from: e  reason: collision with root package name */
    private byte[] f50475e;

    /* renamed from: f  reason: collision with root package name */
    private long f50476f;

    public a(HandlerThread handlerThread) {
        super(handlerThread);
        this.f50474d.put(e.CHARACTER_SET, "utf-8");
        this.f50474d.put(e.TRY_HARDER, Boolean.TRUE);
        this.f50474d.put(e.POSSIBLE_FORMATS, com.google.zxing.a.QR_CODE);
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void handleMessage(android.os.Message r14) {
        /*
            r13 = this;
            int r0 = r14.what
            int r1 = net.one97.paytm.fastscanner.R.id.decode
            r2 = 0
            r3 = 1
            r4 = 0
            if (r0 != r1) goto L_0x00d5
            java.lang.Object r0 = r14.obj
            byte[] r0 = (byte[]) r0
            byte[] r0 = (byte[]) r0
            int r12 = r14.arg1
            int r11 = r14.arg2
            if (r0 == 0) goto L_0x00d4
            int r14 = r0.length
            if (r14 != 0) goto L_0x001a
            goto L_0x00d4
        L_0x001a:
            byte[] r14 = r13.f50475e
            if (r14 != 0) goto L_0x0025
            int r14 = r12 * r11
            byte[] r14 = new byte[r14]
            r13.f50475e = r14
            goto L_0x002e
        L_0x0025:
            int r14 = r14.length
            int r1 = r12 * r11
            if (r14 >= r1) goto L_0x002e
            byte[] r14 = new byte[r1]
            r13.f50475e = r14
        L_0x002e:
            byte[] r14 = r13.f50475e
            java.util.Arrays.fill(r14, r4)
            r14 = 0
        L_0x0034:
            if (r14 >= r11) goto L_0x0050
            r1 = 0
        L_0x0037:
            if (r1 >= r12) goto L_0x004d
            int r5 = r14 * r12
            int r5 = r5 + r1
            int r6 = r0.length
            if (r5 >= r6) goto L_0x004d
            byte[] r6 = r13.f50475e
            int r7 = r1 * r11
            int r7 = r7 + r11
            int r7 = r7 - r14
            int r7 = r7 - r3
            byte r5 = r0[r5]
            r6[r7] = r5
            int r1 = r1 + 1
            goto L_0x0037
        L_0x004d:
            int r14 = r14 + 1
            goto L_0x0034
        L_0x0050:
            com.google.zxing.n r14 = new com.google.zxing.n     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            byte[] r6 = r13.f50475e     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            r9 = 0
            r10 = 0
            r5 = r14
            r7 = r11
            r8 = r12
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            com.google.zxing.c r0 = new com.google.zxing.c     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            com.google.zxing.b.j r1 = new com.google.zxing.b.j     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            r1.<init>(r14)     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            r0.<init>(r1)     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            java.lang.Runtime r14 = java.lang.Runtime.getRuntime()     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            long r5 = r14.maxMemory()     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            r7 = 1024(0x400, double:5.06E-321)
            long r5 = r5 / r7
            int r14 = (int) r5     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            r1 = 1024(0x400, float:1.435E-42)
            if (r14 < r1) goto L_0x0078
            r14 = 1
            goto L_0x0079
        L_0x0078:
            r14 = 0
        L_0x0079:
            if (r14 == 0) goto L_0x0084
            com.google.zxing.g.a r14 = r13.f50473c     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            java.util.Map<com.google.zxing.e, java.lang.Object> r1 = r13.f50474d     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            com.google.zxing.r r2 = r14.a(r0, r1)     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            goto L_0x00a3
        L_0x0084:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            long r5 = r13.f50476f     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            long r0 = r0 - r5
            r5 = 5000(0x1388, double:2.4703E-320)
            int r14 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r14 < 0) goto L_0x0093
            r14 = 1
            goto L_0x0094
        L_0x0093:
            r14 = 0
        L_0x0094:
            if (r14 == 0) goto L_0x00a3
            java.lang.System.gc()     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            r13.f50476f = r0     // Catch:{ q -> 0x00a2, all -> 0x00a0 }
            goto L_0x00a3
        L_0x00a0:
            r14 = move-exception
            throw r14
        L_0x00a2:
        L_0x00a3:
            if (r2 == 0) goto L_0x00c0
            net.one97.paytm.fastscanner.b.e[] r14 = new net.one97.paytm.fastscanner.b.e[r3]
            net.one97.paytm.fastscanner.b.e r0 = new net.one97.paytm.fastscanner.b.e
            java.lang.String r1 = r2.f40577a
            r0.<init>(r1, r4, r4)
            r14[r4] = r0
            net.one97.paytm.fastscanner.b.d r0 = net.one97.paytm.fastscanner.b.d.f50426a
            net.one97.paytm.fastscanner.a r0 = net.one97.paytm.fastscanner.b.d.b()
            int r1 = net.one97.paytm.fastscanner.R.id.decode_succeeded
            android.os.Message r14 = android.os.Message.obtain(r0, r1, r14)
            r14.sendToTarget()
            return
        L_0x00c0:
            net.one97.paytm.fastscanner.c.a r14 = net.one97.paytm.fastscanner.c.a.f50448b
            net.one97.paytm.fastscanner.c.a.j()
            net.one97.paytm.fastscanner.b.d r14 = net.one97.paytm.fastscanner.b.d.f50426a
            net.one97.paytm.fastscanner.a r14 = net.one97.paytm.fastscanner.b.d.b()
            int r0 = net.one97.paytm.fastscanner.R.id.decode_failed
            android.os.Message r14 = android.os.Message.obtain(r14, r0)
            r14.sendToTarget()
        L_0x00d4:
            return
        L_0x00d5:
            int r0 = r14.what
            int r1 = net.one97.paytm.fastscanner.R.id.decode_from_gallery
            if (r0 != r1) goto L_0x00e3
            java.lang.Object r14 = r14.obj
            android.graphics.Bitmap r14 = (android.graphics.Bitmap) r14
            r13.a((android.graphics.Bitmap) r14)
            return
        L_0x00e3:
            int r0 = r14.what
            int r1 = net.one97.paytm.fastscanner.R.id.decode_from_gallery_file
            if (r0 != r1) goto L_0x013e
            java.lang.Object r14 = r14.obj
            android.net.Uri r14 = (android.net.Uri) r14
            net.one97.paytm.fastscanner.c.a r0 = net.one97.paytm.fastscanner.c.a.f50448b     // Catch:{ FileNotFoundException -> 0x0100 }
            net.one97.paytm.fastscanner.c.b r0 = net.one97.paytm.fastscanner.c.a.h()     // Catch:{ FileNotFoundException -> 0x0100 }
            android.content.Context r0 = r0.getContext()     // Catch:{ FileNotFoundException -> 0x0100 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0100 }
            java.io.InputStream r0 = r0.openInputStream(r14)     // Catch:{ FileNotFoundException -> 0x0100 }
            goto L_0x0105
        L_0x0100:
            r0 = move-exception
            r0.printStackTrace()
            r0 = r2
        L_0x0105:
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options
            r1.<init>()
            r1.inJustDecodeBounds = r3
            android.graphics.BitmapFactory.decodeStream(r0, r2, r1)
            int r3 = a((android.graphics.BitmapFactory.Options) r1)
            r1.inSampleSize = r3
            net.one97.paytm.fastscanner.c.a r3 = net.one97.paytm.fastscanner.c.a.f50448b     // Catch:{ FileNotFoundException -> 0x0128 }
            net.one97.paytm.fastscanner.c.b r3 = net.one97.paytm.fastscanner.c.a.h()     // Catch:{ FileNotFoundException -> 0x0128 }
            android.content.Context r3 = r3.getContext()     // Catch:{ FileNotFoundException -> 0x0128 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0128 }
            java.io.InputStream r0 = r3.openInputStream(r14)     // Catch:{ FileNotFoundException -> 0x0128 }
            goto L_0x012c
        L_0x0128:
            r14 = move-exception
            r14.printStackTrace()
        L_0x012c:
            r1.inJustDecodeBounds = r4
            android.graphics.Bitmap r14 = android.graphics.BitmapFactory.decodeStream(r0, r2, r1)
            r13.a((android.graphics.Bitmap) r14)
            r0.close()     // Catch:{ IOException -> 0x0139 }
            return
        L_0x0139:
            r14 = move-exception
            r14.printStackTrace()
            return
        L_0x013e:
            int r14 = r14.what
            int r0 = net.one97.paytm.fastscanner.R.id.quit
            if (r14 != r0) goto L_0x014d
            android.os.Looper r14 = android.os.Looper.myLooper()
            if (r14 == 0) goto L_0x014d
            r14.quit()
        L_0x014d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.fastscanner.e.a.handleMessage(android.os.Message):void");
    }

    private static int a(BitmapFactory.Options options) {
        int i2 = options.outHeight;
        int i3 = options.outWidth;
        int i4 = 1;
        if (i2 > 960 || i3 > 1280) {
            int i5 = i2 / 2;
            int i6 = i3 / 2;
            while (i5 / i4 > 960 && i6 / i4 > 1280) {
                i4 *= 2;
            }
        }
        return i4;
    }

    private void a(Bitmap bitmap) {
        if (bitmap != null) {
            if (bitmap.getByteCount() / TarConstants.EOF_BLOCK > ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 10) {
                new Exception("Size too big");
                a().countDown();
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            try {
                r a2 = new com.google.zxing.g.a().a(new c(new j(new o(width, height, iArr))), (Map<e, ?>) null);
                if (!TextUtils.isEmpty(a2.toString())) {
                    f.a().c();
                    net.one97.paytm.fastscanner.b.e[] eVarArr = {new net.one97.paytm.fastscanner.b.e(String.valueOf(a2), 0, 1)};
                    d dVar = d.f50426a;
                    Message.obtain(d.b(), R.id.decode_succeeded_gallery, eVarArr).sendToTarget();
                    return;
                }
                new Exception("Error in decoding via Zxing");
                a().countDown();
            } catch (m unused) {
                a().countDown();
            } catch (com.google.zxing.d unused2) {
                a().countDown();
            } catch (h unused3) {
                a().countDown();
            }
        }
    }
}
