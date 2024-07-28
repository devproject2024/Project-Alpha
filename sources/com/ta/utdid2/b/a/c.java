package com.ta.utdid2.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.b.a.b;
import java.io.File;
import java.util.Map;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private String f16128a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f16129b = "";

    /* renamed from: c  reason: collision with root package name */
    private boolean f16130c = false;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16131d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f16132e = false;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences f16133f;

    /* renamed from: g  reason: collision with root package name */
    private b f16134g;

    /* renamed from: h  reason: collision with root package name */
    private SharedPreferences.Editor f16135h;

    /* renamed from: i  reason: collision with root package name */
    private b.a f16136i;
    private Context j;
    private d k;
    private boolean l;

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087 A[SYNTHETIC, Splitter:B:26:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public c(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            r10 = this;
            r10.<init>()
            java.lang.String r0 = ""
            r10.f16128a = r0
            r10.f16129b = r0
            r0 = 0
            r10.f16130c = r0
            r10.f16131d = r0
            r10.f16132e = r0
            r1 = 0
            r10.f16133f = r1
            r10.f16134g = r1
            r10.f16135h = r1
            r10.f16136i = r1
            r10.j = r1
            r10.k = r1
            r10.l = r0
            r10.f16130c = r0
            r2 = 1
            r10.l = r2
            r10.f16128a = r13
            r10.f16129b = r12
            r10.j = r11
            java.lang.String r3 = "t"
            r4 = 0
            if (r11 == 0) goto L_0x003d
            android.content.SharedPreferences r6 = r11.getSharedPreferences(r13, r0)
            r10.f16133f = r6
            android.content.SharedPreferences r6 = r10.f16133f
            long r6 = r6.getLong(r3, r4)
            goto L_0x003e
        L_0x003d:
            r6 = r4
        L_0x003e:
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0047:
            boolean r8 = com.ta.utdid2.a.a.e.a(r1)
            if (r8 != 0) goto L_0x0067
            java.lang.String r8 = "mounted"
            boolean r8 = r1.equals(r8)
            if (r8 == 0) goto L_0x005a
            r10.f16132e = r2
            r10.f16131d = r2
            goto L_0x006b
        L_0x005a:
            java.lang.String r8 = "mounted_ro"
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x0067
            r10.f16131d = r2
            r10.f16132e = r0
            goto L_0x006b
        L_0x0067:
            r10.f16132e = r0
            r10.f16131d = r0
        L_0x006b:
            boolean r1 = r10.f16131d
            java.lang.String r2 = "t2"
            if (r1 != 0) goto L_0x0075
            boolean r1 = r10.f16132e
            if (r1 == 0) goto L_0x010b
        L_0x0075:
            if (r11 == 0) goto L_0x010b
            boolean r1 = com.ta.utdid2.a.a.e.a(r12)
            if (r1 != 0) goto L_0x010b
            com.ta.utdid2.b.a.d r12 = r10.c(r12)
            r10.k = r12
            com.ta.utdid2.b.a.d r12 = r10.k
            if (r12 == 0) goto L_0x010b
            com.ta.utdid2.b.a.b r12 = r12.a((java.lang.String) r13)     // Catch:{ Exception -> 0x010b }
            r10.f16134g = r12     // Catch:{ Exception -> 0x010b }
            com.ta.utdid2.b.a.b r12 = r10.f16134g     // Catch:{ Exception -> 0x010b }
            long r8 = r12.a(r3)     // Catch:{ Exception -> 0x010b }
            android.content.SharedPreferences r12 = r10.f16133f     // Catch:{ Exception -> 0x00b7 }
            long r6 = r12.getLong(r2, r4)     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.b r12 = r10.f16134g     // Catch:{ Exception -> 0x00b7 }
            long r8 = r12.a(r2)     // Catch:{ Exception -> 0x00b7 }
            int r12 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x00b9
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00b9
            android.content.SharedPreferences r11 = r10.f16133f     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.b r12 = r10.f16134g     // Catch:{ Exception -> 0x00b7 }
            a((android.content.SharedPreferences) r11, (com.ta.utdid2.b.a.b) r12)     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.d r11 = r10.k     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.b r11 = r11.a((java.lang.String) r13)     // Catch:{ Exception -> 0x00b7 }
            r10.f16134g = r11     // Catch:{ Exception -> 0x00b7 }
            goto L_0x010c
        L_0x00b7:
            goto L_0x010c
        L_0x00b9:
            if (r12 <= 0) goto L_0x00cd
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00cd
            com.ta.utdid2.b.a.b r12 = r10.f16134g     // Catch:{ Exception -> 0x00b7 }
            android.content.SharedPreferences r1 = r10.f16133f     // Catch:{ Exception -> 0x00b7 }
            a((com.ta.utdid2.b.a.b) r12, (android.content.SharedPreferences) r1)     // Catch:{ Exception -> 0x00b7 }
            android.content.SharedPreferences r11 = r11.getSharedPreferences(r13, r0)     // Catch:{ Exception -> 0x00b7 }
            r10.f16133f = r11     // Catch:{ Exception -> 0x00b7 }
            goto L_0x010c
        L_0x00cd:
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x00e3
            int r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e3
            com.ta.utdid2.b.a.b r12 = r10.f16134g     // Catch:{ Exception -> 0x00b7 }
            android.content.SharedPreferences r1 = r10.f16133f     // Catch:{ Exception -> 0x00b7 }
            a((com.ta.utdid2.b.a.b) r12, (android.content.SharedPreferences) r1)     // Catch:{ Exception -> 0x00b7 }
            android.content.SharedPreferences r11 = r11.getSharedPreferences(r13, r0)     // Catch:{ Exception -> 0x00b7 }
            r10.f16133f = r11     // Catch:{ Exception -> 0x00b7 }
            goto L_0x010c
        L_0x00e3:
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x00f9
            if (r1 <= 0) goto L_0x00f9
            android.content.SharedPreferences r11 = r10.f16133f     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.b r12 = r10.f16134g     // Catch:{ Exception -> 0x00b7 }
            a((android.content.SharedPreferences) r11, (com.ta.utdid2.b.a.b) r12)     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.d r11 = r10.k     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.b r11 = r11.a((java.lang.String) r13)     // Catch:{ Exception -> 0x00b7 }
            r10.f16134g = r11     // Catch:{ Exception -> 0x00b7 }
            goto L_0x010c
        L_0x00f9:
            if (r12 != 0) goto L_0x010c
            android.content.SharedPreferences r11 = r10.f16133f     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.b r12 = r10.f16134g     // Catch:{ Exception -> 0x00b7 }
            a((android.content.SharedPreferences) r11, (com.ta.utdid2.b.a.b) r12)     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.d r11 = r10.k     // Catch:{ Exception -> 0x00b7 }
            com.ta.utdid2.b.a.b r11 = r11.a((java.lang.String) r13)     // Catch:{ Exception -> 0x00b7 }
            r10.f16134g = r11     // Catch:{ Exception -> 0x00b7 }
            goto L_0x010c
        L_0x010b:
            r8 = r4
        L_0x010c:
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 != 0) goto L_0x0118
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x0148
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x0148
        L_0x0118:
            long r11 = java.lang.System.currentTimeMillis()
            boolean r13 = r10.l
            if (r13 == 0) goto L_0x012a
            if (r13 == 0) goto L_0x0148
            int r13 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r13 != 0) goto L_0x0148
            int r13 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r13 != 0) goto L_0x0148
        L_0x012a:
            android.content.SharedPreferences r13 = r10.f16133f
            if (r13 == 0) goto L_0x0138
            android.content.SharedPreferences$Editor r13 = r13.edit()
            r13.putLong(r2, r11)
            r13.commit()
        L_0x0138:
            com.ta.utdid2.b.a.b r13 = r10.f16134g     // Catch:{ Exception -> 0x0148 }
            if (r13 == 0) goto L_0x0148
            com.ta.utdid2.b.a.b r13 = r10.f16134g     // Catch:{ Exception -> 0x0148 }
            com.ta.utdid2.b.a.b$a r13 = r13.c()     // Catch:{ Exception -> 0x0148 }
            r13.a((java.lang.String) r2, (long) r11)     // Catch:{ Exception -> 0x0148 }
            r13.b()     // Catch:{ Exception -> 0x0148 }
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.c.<init>(android.content.Context, java.lang.String, java.lang.String):void");
    }

    private d c(String str) {
        File d2 = d(str);
        if (d2 == null) {
            return null;
        }
        this.k = new d(d2.getAbsolutePath());
        return this.k;
    }

    private static File d(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", new Object[]{externalStorageDirectory.getAbsolutePath(), File.separator, str}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static void a(SharedPreferences sharedPreferences, b bVar) {
        if (sharedPreferences != null && bVar != null) {
            b.a c2 = bVar.c();
            c2.a();
            for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value instanceof String) {
                    c2.a(str, (String) value);
                } else if (value instanceof Integer) {
                    c2.a(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    c2.a(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    c2.a(str, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    c2.a(str, ((Boolean) value).booleanValue());
                }
            }
            c2.b();
        }
    }

    private static void a(b bVar, SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit;
        if (bVar != null && sharedPreferences != null && (edit = sharedPreferences.edit()) != null) {
            edit.clear();
            for (Map.Entry next : bVar.b().entrySet()) {
                String str = (String) next.getKey();
                Object value = next.getValue();
                if (value instanceof String) {
                    edit.putString(str, (String) value);
                } else if (value instanceof Integer) {
                    edit.putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    edit.putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    edit.putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof Boolean) {
                    edit.putBoolean(str, ((Boolean) value).booleanValue());
                }
            }
            edit.commit();
        }
    }

    private boolean b() {
        b bVar = this.f16134g;
        if (bVar == null) {
            return false;
        }
        boolean a2 = bVar.a();
        if (!a2) {
            a();
        }
        return a2;
    }

    private void c() {
        b bVar;
        SharedPreferences sharedPreferences;
        if (this.f16135h == null && (sharedPreferences = this.f16133f) != null) {
            this.f16135h = sharedPreferences.edit();
        }
        if (this.f16132e && this.f16136i == null && (bVar = this.f16134g) != null) {
            this.f16136i = bVar.c();
        }
        b();
    }

    public final void a(String str, String str2) {
        if (!e.a(str) && !str.equals("t")) {
            c();
            SharedPreferences.Editor editor = this.f16135h;
            if (editor != null) {
                editor.putString(str, str2);
            }
            b.a aVar = this.f16136i;
            if (aVar != null) {
                aVar.a(str, str2);
            }
        }
    }

    public final void a(String str) {
        if (!e.a(str) && !str.equals("t")) {
            c();
            SharedPreferences.Editor editor = this.f16135h;
            if (editor != null) {
                editor.remove(str);
            }
            b.a aVar = this.f16136i;
            if (aVar != null) {
                aVar.a(str);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r5 = this;
            long r0 = java.lang.System.currentTimeMillis()
            android.content.SharedPreferences$Editor r2 = r5.f16135h
            r3 = 0
            if (r2 == 0) goto L_0x0020
            boolean r4 = r5.l
            if (r4 != 0) goto L_0x0016
            android.content.SharedPreferences r4 = r5.f16133f
            if (r4 == 0) goto L_0x0016
            java.lang.String r4 = "t"
            r2.putLong(r4, r0)
        L_0x0016:
            android.content.SharedPreferences$Editor r0 = r5.f16135h
            boolean r0 = r0.commit()
            if (r0 != 0) goto L_0x0020
            r0 = 0
            goto L_0x0021
        L_0x0020:
            r0 = 1
        L_0x0021:
            android.content.SharedPreferences r1 = r5.f16133f
            if (r1 == 0) goto L_0x0031
            android.content.Context r1 = r5.j
            if (r1 == 0) goto L_0x0031
            java.lang.String r2 = r5.f16128a
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)
            r5.f16133f = r1
        L_0x0031:
            r1 = 0
            java.lang.String r1 = android.os.Environment.getExternalStorageState()     // Catch:{ Exception -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r2 = move-exception
            r2.printStackTrace()
        L_0x003b:
            boolean r2 = com.ta.utdid2.a.a.e.a(r1)
            if (r2 != 0) goto L_0x00a4
            java.lang.String r2 = "mounted"
            boolean r4 = r1.equals(r2)
            if (r4 == 0) goto L_0x0084
            com.ta.utdid2.b.a.b r4 = r5.f16134g
            if (r4 != 0) goto L_0x0079
            java.lang.String r3 = r5.f16129b
            com.ta.utdid2.b.a.d r3 = r5.c(r3)
            if (r3 == 0) goto L_0x0084
            java.lang.String r4 = r5.f16128a
            com.ta.utdid2.b.a.b r3 = r3.a((java.lang.String) r4)
            r5.f16134g = r3
            boolean r3 = r5.l
            if (r3 != 0) goto L_0x0069
            android.content.SharedPreferences r3 = r5.f16133f
            com.ta.utdid2.b.a.b r4 = r5.f16134g
            a((android.content.SharedPreferences) r3, (com.ta.utdid2.b.a.b) r4)
            goto L_0x0070
        L_0x0069:
            com.ta.utdid2.b.a.b r3 = r5.f16134g
            android.content.SharedPreferences r4 = r5.f16133f
            a((com.ta.utdid2.b.a.b) r3, (android.content.SharedPreferences) r4)
        L_0x0070:
            com.ta.utdid2.b.a.b r3 = r5.f16134g
            com.ta.utdid2.b.a.b$a r3 = r3.c()
            r5.f16136i = r3
            goto L_0x0084
        L_0x0079:
            com.ta.utdid2.b.a.b$a r4 = r5.f16136i
            if (r4 == 0) goto L_0x0084
            boolean r4 = r4.b()
            if (r4 != 0) goto L_0x0084
            r0 = 0
        L_0x0084:
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0096
            java.lang.String r2 = "mounted_ro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x00a4
            com.ta.utdid2.b.a.b r1 = r5.f16134g
            if (r1 == 0) goto L_0x00a4
        L_0x0096:
            com.ta.utdid2.b.a.d r1 = r5.k     // Catch:{ Exception -> 0x00a4 }
            if (r1 == 0) goto L_0x00a4
            com.ta.utdid2.b.a.d r1 = r5.k     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = r5.f16128a     // Catch:{ Exception -> 0x00a4 }
            com.ta.utdid2.b.a.b r1 = r1.a((java.lang.String) r2)     // Catch:{ Exception -> 0x00a4 }
            r5.f16134g = r1     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.b.a.c.a():boolean");
    }

    public final String b(String str) {
        b();
        SharedPreferences sharedPreferences = this.f16133f;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!e.a(string)) {
                return string;
            }
        }
        b bVar = this.f16134g;
        if (bVar != null) {
            return bVar.a(str, "");
        }
        return "";
    }
}
