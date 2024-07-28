package net.one97.paytm.recharge.legacy.catalog.b;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.paytm.utility.q;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.recharge.common.b.a.a.a;
import net.one97.paytm.recharge.model.v4.CJRCategoryData;

@Deprecated
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static ArrayList<String> f62816a = new ArrayList<>();

    public static void a(Context context) {
        if (f62816a.isEmpty()) {
            f62816a.add("17_getcategory.json");
            f62816a.add("21_getcategory.json");
            f62816a.add("18_getcategory.json");
            f62816a.add("26_getcategory.json");
            f62816a.add("68869_getcategory.json");
            f62816a.add("78640_getcategory.json");
            f62816a.add("166690_getcategory.json");
            f62816a.add("101950_getcategory.json");
            f62816a.add("100253_getcategory.json");
            f62816a.add("104154_getcategory.json");
        }
        new Thread(new Runnable(context) {
            private final /* synthetic */ Context f$0;

            {
                this.f$0 = r1;
            }

            public final void run() {
                e.b(this.f$0);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(Context context) {
        if (context != null) {
            Iterator<String> it2 = f62816a.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                InputStream inputStream = null;
                try {
                    InputStream open = context.getApplicationContext().getAssets().open(next);
                    if (open != null) {
                        InputStreamReader inputStreamReader = new InputStreamReader(open);
                        f fVar = new f();
                        String substring = next.substring(0, next.indexOf("_"));
                        a aVar = a.f60878a;
                        a.a(context.getApplicationContext(), substring, fVar.a((Object) (CJRCategoryData) fVar.a((Reader) inputStreamReader, CJRCategoryData.class)));
                    }
                    if (open != null) {
                        try {
                            open.close();
                        } catch (IOException e2) {
                            q.d(e2.getMessage());
                        }
                    }
                } catch (OutOfMemoryError e3) {
                    q.d(e3.getMessage());
                    System.gc();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e4) {
                    q.d(e4.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Exception e5) {
                    q.d(e5.getMessage());
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e6) {
                            q.d(e6.getMessage());
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x004c A[SYNTHETIC, Splitter:B:24:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005b A[SYNTHETIC, Splitter:B:31:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006b A[SYNTHETIC, Splitter:B:38:0x006b] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:28:0x0052=Splitter:B:28:0x0052, B:21:0x0043=Splitter:B:21:0x0043} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r3, java.lang.String r4) {
        /*
            r0 = 0
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ IOException -> 0x0050, Exception -> 0x0041, all -> 0x003e }
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ IOException -> 0x0050, Exception -> 0x0041, all -> 0x003e }
            java.io.InputStream r3 = r3.open(r4)     // Catch:{ IOException -> 0x0050, Exception -> 0x0041, all -> 0x003e }
            if (r3 == 0) goto L_0x0038
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0036, Exception -> 0x0034 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0036, Exception -> 0x0034 }
            com.google.gsonhtcfix.f r1 = new com.google.gsonhtcfix.f     // Catch:{ IOException -> 0x0036, Exception -> 0x0034 }
            r1.<init>()     // Catch:{ IOException -> 0x0036, Exception -> 0x0034 }
            java.lang.Class<net.one97.paytm.recharge.model.v4.CJRCategoryData> r2 = net.one97.paytm.recharge.model.v4.CJRCategoryData.class
            java.lang.Object r4 = r1.a((java.io.Reader) r4, r2)     // Catch:{ IOException -> 0x0036, Exception -> 0x0034 }
            net.one97.paytm.recharge.model.v4.CJRCategoryData r4 = (net.one97.paytm.recharge.model.v4.CJRCategoryData) r4     // Catch:{ IOException -> 0x0036, Exception -> 0x0034 }
            java.lang.String r4 = r1.a((java.lang.Object) r4)     // Catch:{ IOException -> 0x0036, Exception -> 0x0034 }
            if (r3 == 0) goto L_0x0033
            r3.close()     // Catch:{ IOException -> 0x002b }
            goto L_0x0033
        L_0x002b:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.d(r3)
        L_0x0033:
            return r4
        L_0x0034:
            r4 = move-exception
            goto L_0x0043
        L_0x0036:
            r4 = move-exception
            goto L_0x0052
        L_0x0038:
            if (r3 == 0) goto L_0x0067
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0067
        L_0x003e:
            r4 = move-exception
            r3 = r0
            goto L_0x0069
        L_0x0041:
            r4 = move-exception
            r3 = r0
        L_0x0043:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0068 }
            com.paytm.utility.q.d(r4)     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0067
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0067
        L_0x0050:
            r4 = move-exception
            r3 = r0
        L_0x0052:
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0068 }
            com.paytm.utility.q.d(r4)     // Catch:{ all -> 0x0068 }
            if (r3 == 0) goto L_0x0067
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0067
        L_0x005f:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.d(r3)
        L_0x0067:
            return r0
        L_0x0068:
            r4 = move-exception
        L_0x0069:
            if (r3 == 0) goto L_0x0077
            r3.close()     // Catch:{ IOException -> 0x006f }
            goto L_0x0077
        L_0x006f:
            r3 = move-exception
            java.lang.String r3 = r3.getMessage()
            com.paytm.utility.q.d(r3)
        L_0x0077:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.legacy.catalog.b.e.a(android.content.Context, java.lang.String):java.lang.String");
    }
}
