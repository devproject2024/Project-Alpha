package androidx.core.e;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.a.e;
import androidx.a.g;
import androidx.core.e.c;
import androidx.core.g.f;
import androidx.core.graphics.d;
import androidx.core.graphics.k;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.activities.CommunityPostActivity;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final e<String, Typeface> f2874a = new e<>(16);

    /* renamed from: b  reason: collision with root package name */
    static final Object f2875b = new Object();

    /* renamed from: c  reason: collision with root package name */
    static final g<String, ArrayList<c.a<c>>> f2876c = new g<>();

    /* renamed from: d  reason: collision with root package name */
    private static final c f2877d = new c("fonts");

    /* renamed from: e  reason: collision with root package name */
    private static final Comparator<byte[]> f2878e = new Comparator<byte[]>() {
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: byte} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* bridge */ /* synthetic */ int compare(java.lang.Object r5, java.lang.Object r6) {
            /*
                r4 = this;
                byte[] r5 = (byte[]) r5
                byte[] r6 = (byte[]) r6
                int r0 = r5.length
                int r1 = r6.length
                if (r0 == r1) goto L_0x000c
                int r5 = r5.length
                int r6 = r6.length
            L_0x000a:
                int r5 = r5 - r6
                return r5
            L_0x000c:
                r0 = 0
                r1 = 0
            L_0x000e:
                int r2 = r5.length
                if (r1 >= r2) goto L_0x001f
                byte r2 = r5[r1]
                byte r3 = r6[r1]
                if (r2 == r3) goto L_0x001c
                byte r5 = r5[r1]
                byte r6 = r6[r1]
                goto L_0x000a
            L_0x001c:
                int r1 = r1 + 1
                goto L_0x000e
            L_0x001f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.b.AnonymousClass4.compare(java.lang.Object, java.lang.Object):int");
        }
    };

    static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Typeface f2893a;

        /* renamed from: b  reason: collision with root package name */
        final int f2894b;

        c(Typeface typeface, int i2) {
            this.f2893a = typeface;
            this.f2894b = i2;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0073, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0084, code lost:
        r3 = f2877d;
        r3.a(new androidx.core.e.c.AnonymousClass2(r2, new android.os.Handler(), new androidx.core.e.b.AnonymousClass3()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0098, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Typeface a(final android.content.Context r3, final androidx.core.e.a r4, final androidx.core.content.b.f.a r5, boolean r6, int r7, final int r8) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r4.f2873f
            r0.append(r1)
            java.lang.String r1 = "-"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            androidx.a.e<java.lang.String, android.graphics.Typeface> r1 = f2874a
            java.lang.Object r1 = r1.get(r0)
            android.graphics.Typeface r1 = (android.graphics.Typeface) r1
            if (r1 == 0) goto L_0x0026
            if (r5 == 0) goto L_0x0025
            r5.a((android.graphics.Typeface) r1)
        L_0x0025:
            return r1
        L_0x0026:
            r1 = 0
            if (r6 == 0) goto L_0x0044
            r2 = -1
            if (r7 != r2) goto L_0x0044
            androidx.core.e.b$c r3 = a((android.content.Context) r3, (androidx.core.e.a) r4, (int) r8)
            if (r5 == 0) goto L_0x0041
            int r4 = r3.f2894b
            if (r4 != 0) goto L_0x003c
            android.graphics.Typeface r4 = r3.f2893a
            r5.a((android.graphics.Typeface) r4, (android.os.Handler) r1)
            goto L_0x0041
        L_0x003c:
            int r4 = r3.f2894b
            r5.a((int) r4, (android.os.Handler) r1)
        L_0x0041:
            android.graphics.Typeface r3 = r3.f2893a
            return r3
        L_0x0044:
            androidx.core.e.b$1 r2 = new androidx.core.e.b$1
            r2.<init>(r3, r4, r8, r0)
            if (r6 == 0) goto L_0x0057
            androidx.core.e.c r3 = f2877d     // Catch:{ InterruptedException -> 0x0056 }
            java.lang.Object r3 = r3.a(r2, r7)     // Catch:{ InterruptedException -> 0x0056 }
            androidx.core.e.b$c r3 = (androidx.core.e.b.c) r3     // Catch:{ InterruptedException -> 0x0056 }
            android.graphics.Typeface r3 = r3.f2893a     // Catch:{ InterruptedException -> 0x0056 }
            return r3
        L_0x0056:
            return r1
        L_0x0057:
            if (r5 != 0) goto L_0x005b
            r3 = r1
            goto L_0x0060
        L_0x005b:
            androidx.core.e.b$2 r3 = new androidx.core.e.b$2
            r3.<init>()
        L_0x0060:
            java.lang.Object r4 = f2875b
            monitor-enter(r4)
            androidx.a.g<java.lang.String, java.util.ArrayList<androidx.core.e.c$a<androidx.core.e.b$c>>> r5 = f2876c     // Catch:{ all -> 0x0099 }
            java.lang.Object r5 = r5.get(r0)     // Catch:{ all -> 0x0099 }
            java.util.ArrayList r5 = (java.util.ArrayList) r5     // Catch:{ all -> 0x0099 }
            if (r5 == 0) goto L_0x0074
            if (r3 == 0) goto L_0x0072
            r5.add(r3)     // Catch:{ all -> 0x0099 }
        L_0x0072:
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            return r1
        L_0x0074:
            if (r3 == 0) goto L_0x0083
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0099 }
            r5.<init>()     // Catch:{ all -> 0x0099 }
            r5.add(r3)     // Catch:{ all -> 0x0099 }
            androidx.a.g<java.lang.String, java.util.ArrayList<androidx.core.e.c$a<androidx.core.e.b$c>>> r3 = f2876c     // Catch:{ all -> 0x0099 }
            r3.put(r0, r5)     // Catch:{ all -> 0x0099 }
        L_0x0083:
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            androidx.core.e.c r3 = f2877d
            androidx.core.e.b$3 r4 = new androidx.core.e.b$3
            r4.<init>(r0)
            android.os.Handler r5 = new android.os.Handler
            r5.<init>()
            androidx.core.e.c$2 r6 = new androidx.core.e.c$2
            r6.<init>(r2, r5, r4)
            r3.a(r6)
            return r1
        L_0x0099:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0099 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.e.b.a(android.content.Context, androidx.core.e.a, androidx.core.content.b.f$a, boolean, int, int):android.graphics.Typeface");
    }

    /* renamed from: androidx.core.e.b$b  reason: collision with other inner class name */
    public static class C0041b {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f2888a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2889b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2890c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2891d;

        /* renamed from: e  reason: collision with root package name */
        final int f2892e;

        public C0041b(Uri uri, int i2, int i3, boolean z, int i4) {
            this.f2888a = (Uri) f.a(uri);
            this.f2889b = i2;
            this.f2890c = i3;
            this.f2891d = z;
            this.f2892e = i4;
        }
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final int f2886a;

        /* renamed from: b  reason: collision with root package name */
        final C0041b[] f2887b;

        public a(int i2, C0041b[] bVarArr) {
            this.f2886a = i2;
            this.f2887b = bVarArr;
        }
    }

    public static Map<Uri, ByteBuffer> a(Context context, C0041b[] bVarArr) {
        HashMap hashMap = new HashMap();
        for (C0041b bVar : bVarArr) {
            if (bVar.f2892e == 0) {
                Uri uri = bVar.f2888a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, k.a(context, uri));
                }
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    private static boolean a(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (!Arrays.equals(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature byteArray : signatureArr) {
            arrayList.add(byteArray.toByteArray());
        }
        return arrayList;
    }

    private static C0041b[] a(Context context, a aVar, String str) {
        Cursor cursor;
        Uri uri;
        a aVar2 = aVar;
        String str2 = str;
        ArrayList arrayList = new ArrayList();
        Uri build = new Uri.Builder().scheme("content").authority(str2).build();
        Uri build2 = new Uri.Builder().scheme("content").authority(str2).appendPath(CommunityPostActivity.TYPE_FILE).build();
        Cursor cursor2 = null;
        try {
            if (Build.VERSION.SDK_INT > 16) {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar2.f2870c}, (String) null, (CancellationSignal) null);
            } else {
                cursor = context.getContentResolver().query(build, new String[]{"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"}, "query = ?", new String[]{aVar2.f2870c}, (String) null);
            }
            cursor2 = cursor;
            if (cursor2 != null && cursor2.getCount() > 0) {
                int columnIndex = cursor2.getColumnIndex("result_code");
                arrayList = new ArrayList();
                int columnIndex2 = cursor2.getColumnIndex("_id");
                int columnIndex3 = cursor2.getColumnIndex("file_id");
                int columnIndex4 = cursor2.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursor2.getColumnIndex("font_weight");
                int columnIndex6 = cursor2.getColumnIndex("font_italic");
                while (cursor2.moveToNext()) {
                    int i2 = columnIndex != -1 ? cursor2.getInt(columnIndex) : 0;
                    int i3 = columnIndex4 != -1 ? cursor2.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        uri = ContentUris.withAppendedId(build, cursor2.getLong(columnIndex2));
                    } else {
                        uri = ContentUris.withAppendedId(build2, cursor2.getLong(columnIndex3));
                    }
                    arrayList.add(new C0041b(uri, i3, columnIndex5 != -1 ? cursor2.getInt(columnIndex5) : 400, columnIndex6 != -1 && cursor2.getInt(columnIndex6) == 1, i2));
                }
            }
            return (C0041b[]) arrayList.toArray(new C0041b[0]);
        } finally {
            if (cursor2 != null) {
                cursor2.close();
            }
        }
    }

    static c a(Context context, a aVar, int i2) {
        List<List<byte[]>> list;
        a aVar2;
        try {
            PackageManager packageManager = context.getPackageManager();
            Resources resources = context.getResources();
            String str = aVar.f2868a;
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: ".concat(String.valueOf(str)));
            } else if (resolveContentProvider.packageName.equals(aVar.f2869b)) {
                List<byte[]> a2 = a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(a2, f2878e);
                if (aVar.f2871d != null) {
                    list = aVar.f2871d;
                } else {
                    list = androidx.core.content.b.c.a(resources, aVar.f2872e);
                }
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        resolveContentProvider = null;
                        break;
                    }
                    ArrayList arrayList = new ArrayList(list.get(i3));
                    Collections.sort(arrayList, f2878e);
                    if (a(a2, (List<byte[]>) arrayList)) {
                        break;
                    }
                    i3++;
                }
                if (resolveContentProvider == null) {
                    aVar2 = new a(1, (C0041b[]) null);
                } else {
                    aVar2 = new a(0, a(context, aVar, resolveContentProvider.authority));
                }
                int i4 = -3;
                if (aVar2.f2886a == 0) {
                    Typeface a3 = d.a(context, aVar2.f2887b, i2);
                    if (a3 != null) {
                        i4 = 0;
                    }
                    return new c(a3, i4);
                }
                if (aVar2.f2886a == 1) {
                    i4 = -2;
                }
                return new c((Typeface) null, i4);
            } else {
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + aVar.f2869b);
            }
        } catch (PackageManager.NameNotFoundException unused) {
            return new c((Typeface) null, -1);
        }
    }
}
