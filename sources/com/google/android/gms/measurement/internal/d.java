package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.internal.measurement.ab;
import com.google.android.gms.internal.measurement.aj;
import com.google.android.gms.internal.measurement.dv;
import com.google.android.gms.internal.measurement.jz;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;
import net.one97.paytm.upi.util.UpiContract;

final class d extends jg {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String[] f11776a = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f11777c = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String[] f11778d = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", UpiContract.DeviceInfoColumns.ANDROID_ID, "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;"};
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final String[] f11779e = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final String[] f11780f = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final String[] f11781g = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f11782h = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f11783i = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final e j = new e(this, k(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final jb k = new jb(j());

    d(jj jjVar) {
        super(jjVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    public final void b() {
        w();
        e().beginTransaction();
    }

    public final void c() {
        w();
        e().setTransactionSuccessful();
    }

    public final void x_() {
        w();
        e().endTransaction();
    }

    private final long b(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = e().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j2 = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j2;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e2) {
            J_().f11828c.a("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long a(String str, String[] strArr, long j2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = e().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j3 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j3;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j2;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Database error", str, e2);
            throw e2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase e() {
        h();
        try {
            return this.j.getWritableDatabase();
        } catch (SQLiteException e2) {
            J_().f11831f.a("Error opening database", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0157  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.k a(java.lang.String r27, java.lang.String r28) {
        /*
            r26 = this;
            r15 = r27
            r14 = r28
            com.google.android.gms.common.internal.s.a((java.lang.String) r27)
            com.google.android.gms.common.internal.s.a((java.lang.String) r28)
            r26.h()
            r26.w()
            com.google.android.gms.measurement.internal.ke r0 = r26.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.o.am
            boolean r0 = r0.d(r15, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            java.lang.String r2 = "lifetime_count"
            java.lang.String r3 = "current_bundle_count"
            java.lang.String r4 = "last_fire_timestamp"
            java.lang.String r5 = "last_bundled_timestamp"
            java.lang.String r6 = "last_bundled_day"
            java.lang.String r7 = "last_sampled_complex_event_id"
            java.lang.String r8 = "last_sampling_rate"
            java.lang.String r9 = "last_exempt_from_sampling"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r2 = java.util.Arrays.asList(r2)
            r1.<init>(r2)
            if (r0 == 0) goto L_0x003e
            java.lang.String r2 = "current_session_count"
            r1.add(r2)
        L_0x003e:
            r18 = 0
            android.database.sqlite.SQLiteDatabase r2 = r26.e()     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            java.lang.String r3 = "events"
            r10 = 0
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            java.lang.Object[] r1 = r1.toArray(r4)     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            r4 = r1
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            java.lang.String r5 = "app_id=? and name=?"
            r1 = 2
            java.lang.String[] r6 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            r6[r10] = r15     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            r11 = 1
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r12 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0132, all -> 0x012e }
            boolean r2 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            if (r2 != 0) goto L_0x006d
            if (r12 == 0) goto L_0x006c
            r12.close()
        L_0x006c:
            return r18
        L_0x006d:
            long r4 = r12.getLong(r10)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            long r6 = r12.getLong(r11)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            long r16 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r1 = 3
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r8 = 0
            if (r2 == 0) goto L_0x0085
            r19 = r8
            goto L_0x008b
        L_0x0085:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r19 = r1
        L_0x008b:
            r1 = 4
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            if (r2 == 0) goto L_0x0095
            r21 = r18
            goto L_0x009f
        L_0x0095:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r21 = r1
        L_0x009f:
            r1 = 5
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            if (r2 == 0) goto L_0x00a9
            r22 = r18
            goto L_0x00b3
        L_0x00a9:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r22 = r1
        L_0x00b3:
            r1 = 6
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            if (r2 == 0) goto L_0x00bd
            r23 = r18
            goto L_0x00c7
        L_0x00bd:
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r23 = r1
        L_0x00c7:
            r1 = 7
            boolean r2 = r12.isNull(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            if (r2 != 0) goto L_0x00e0
            long r1 = r12.getLong(r1)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r24 = 1
            int r3 = (r1 > r24 ? 1 : (r1 == r24 ? 0 : -1))
            if (r3 != 0) goto L_0x00d9
            r10 = 1
        L_0x00d9:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r10)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r24 = r1
            goto L_0x00e2
        L_0x00e0:
            r24 = r18
        L_0x00e2:
            if (r0 == 0) goto L_0x00f1
            r0 = 8
            boolean r1 = r12.isNull(r0)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            if (r1 != 0) goto L_0x00f1
            long r0 = r12.getLong(r0)     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r8 = r0
        L_0x00f1:
            com.google.android.gms.measurement.internal.k r0 = new com.google.android.gms.measurement.internal.k     // Catch:{ SQLiteException -> 0x012a, all -> 0x0126 }
            r1 = r0
            r2 = r27
            r3 = r28
            r10 = r16
            r25 = r12
            r12 = r19
            r14 = r21
            r15 = r22
            r16 = r23
            r17 = r24
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0124 }
            boolean r1 = r25.moveToNext()     // Catch:{ SQLiteException -> 0x0124 }
            if (r1 == 0) goto L_0x011e
            com.google.android.gms.measurement.internal.dy r1 = r26.J_()     // Catch:{ SQLiteException -> 0x0124 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ SQLiteException -> 0x0124 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r27)     // Catch:{ SQLiteException -> 0x0124 }
            r1.a(r2, r3)     // Catch:{ SQLiteException -> 0x0124 }
        L_0x011e:
            if (r25 == 0) goto L_0x0123
            r25.close()
        L_0x0123:
            return r0
        L_0x0124:
            r0 = move-exception
            goto L_0x0135
        L_0x0126:
            r0 = move-exception
            r25 = r12
            goto L_0x0155
        L_0x012a:
            r0 = move-exception
            r25 = r12
            goto L_0x0135
        L_0x012e:
            r0 = move-exception
            r25 = r18
            goto L_0x0155
        L_0x0132:
            r0 = move-exception
            r25 = r18
        L_0x0135:
            com.google.android.gms.measurement.internal.dy r1 = r26.J_()     // Catch:{ all -> 0x0154 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ all -> 0x0154 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r27)     // Catch:{ all -> 0x0154 }
            com.google.android.gms.measurement.internal.dw r4 = r26.l()     // Catch:{ all -> 0x0154 }
            r5 = r28
            java.lang.String r4 = r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0154 }
            r1.a(r2, r3, r4, r0)     // Catch:{ all -> 0x0154 }
            if (r25 == 0) goto L_0x0153
            r25.close()
        L_0x0153:
            return r18
        L_0x0154:
            r0 = move-exception
        L_0x0155:
            if (r25 == 0) goto L_0x015a
            r25.close()
        L_0x015a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.a(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.k");
    }

    public final void a(k kVar) {
        s.a(kVar);
        h();
        w();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", kVar.f12313a);
        contentValues.put("name", kVar.f12314b);
        contentValues.put("lifetime_count", Long.valueOf(kVar.f12315c));
        contentValues.put("current_bundle_count", Long.valueOf(kVar.f12316d));
        contentValues.put("last_fire_timestamp", Long.valueOf(kVar.f12318f));
        contentValues.put("last_bundled_timestamp", Long.valueOf(kVar.f12319g));
        contentValues.put("last_bundled_day", kVar.f12320h);
        contentValues.put("last_sampled_complex_event_id", kVar.f12321i);
        contentValues.put("last_sampling_rate", kVar.j);
        if (H_().d(kVar.f12313a, o.am)) {
            contentValues.put("current_session_count", Long.valueOf(kVar.f12317e));
        }
        contentValues.put("last_exempt_from_sampling", (kVar.k == null || !kVar.k.booleanValue()) ? null : 1L);
        try {
            if (e().insertWithOnConflict(EventsModuleManager.MODULE_NAME, (String) null, contentValues, 5) == -1) {
                J_().f11828c.a("Failed to insert/update event aggregates (got -1). appId", dy.a(kVar.f12313a));
            }
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing event aggregates. appId", dy.a(kVar.f12313a), e2);
        }
    }

    public final void b(String str, String str2) {
        s.a(str);
        s.a(str2);
        h();
        w();
        try {
            J_().k.a("Deleted user attribute rows", Integer.valueOf(e().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error deleting user attribute. appId", dy.a(str), l().c(str2), e2);
        }
    }

    public final boolean a(jr jrVar) {
        s.a(jrVar);
        h();
        w();
        if (c(jrVar.f12289a, jrVar.f12291c) == null) {
            if (jq.a(jrVar.f12291c)) {
                if (b("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{jrVar.f12289a}) >= 25) {
                    return false;
                }
            } else if (!H_().d(jrVar.f12289a, o.aa)) {
                if (b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{jrVar.f12289a, jrVar.f12290b}) >= 25) {
                    return false;
                }
            } else if (!"_npa".equals(jrVar.f12291c)) {
                if (b("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{jrVar.f12289a, jrVar.f12290b}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", jrVar.f12289a);
        contentValues.put("origin", jrVar.f12290b);
        contentValues.put("name", jrVar.f12291c);
        contentValues.put("set_timestamp", Long.valueOf(jrVar.f12292d));
        a(contentValues, "value", jrVar.f12293e);
        try {
            if (e().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                J_().f11828c.a("Failed to insert/update user property (got -1). appId", dy.a(jrVar.f12289a));
            }
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing user property. appId", dy.a(jrVar.f12289a), e2);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.jr c(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.s.a((java.lang.String) r19)
            com.google.android.gms.common.internal.s.a((java.lang.String) r20)
            r18.h()
            r18.w()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.e()     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0083, all -> 0x007e }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x007a, all -> 0x0076 }
            if (r3 != 0) goto L_0x0041
            if (r10 == 0) goto L_0x0040
            r10.close()
        L_0x0040:
            return r9
        L_0x0041:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0076 }
            r11 = r18
            java.lang.Object r7 = r11.a((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.jr r0 = new com.google.android.gms.measurement.internal.jr     // Catch:{ SQLiteException -> 0x0074 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0074 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0074 }
            if (r1 == 0) goto L_0x006e
            com.google.android.gms.measurement.internal.dy r1 = r18.J_()     // Catch:{ SQLiteException -> 0x0074 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ SQLiteException -> 0x0074 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0074 }
            r1.a(r2, r3)     // Catch:{ SQLiteException -> 0x0074 }
        L_0x006e:
            if (r10 == 0) goto L_0x0073
            r10.close()
        L_0x0073:
            return r0
        L_0x0074:
            r0 = move-exception
            goto L_0x0087
        L_0x0076:
            r0 = move-exception
            r11 = r18
            goto L_0x00a5
        L_0x007a:
            r0 = move-exception
            r11 = r18
            goto L_0x0087
        L_0x007e:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto L_0x00a5
        L_0x0083:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x0087:
            com.google.android.gms.measurement.internal.dy r1 = r18.J_()     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ all -> 0x00a4 }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r19)     // Catch:{ all -> 0x00a4 }
            com.google.android.gms.measurement.internal.dw r4 = r18.l()     // Catch:{ all -> 0x00a4 }
            java.lang.String r4 = r4.c(r8)     // Catch:{ all -> 0x00a4 }
            r1.a(r2, r3, r4, r0)     // Catch:{ all -> 0x00a4 }
            if (r10 == 0) goto L_0x00a3
            r10.close()
        L_0x00a3:
            return r9
        L_0x00a4:
            r0 = move-exception
        L_0x00a5:
            if (r10 == 0) goto L_0x00aa
            r10.close()
        L_0x00aa:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.c(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.jr");
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.jr> a(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.s.a((java.lang.String) r14)
            r13.h()
            r13.w()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.e()     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r3 = "user_attributes"
            java.lang.String r4 = "name"
            java.lang.String r5 = "origin"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6, r7}     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r12 = 0
            r6[r12] = r14     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0085, all -> 0x0082 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x0041
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            return r0
        L_0x0041:
            java.lang.String r7 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x004d
            java.lang.String r3 = ""
        L_0x004d:
            r6 = r3
            r3 = 2
            long r8 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x0080 }
            r3 = 3
            java.lang.Object r10 = r13.a((android.database.Cursor) r2, (int) r3)     // Catch:{ SQLiteException -> 0x0080 }
            if (r10 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.dy r3 = r13.J_()     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r4 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r14)     // Catch:{ SQLiteException -> 0x0080 }
            r3.a(r4, r5)     // Catch:{ SQLiteException -> 0x0080 }
            goto L_0x0074
        L_0x006a:
            com.google.android.gms.measurement.internal.jr r3 = new com.google.android.gms.measurement.internal.jr     // Catch:{ SQLiteException -> 0x0080 }
            r4 = r3
            r5 = r14
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0080 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x0080 }
        L_0x0074:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0080 }
            if (r3 != 0) goto L_0x0041
            if (r2 == 0) goto L_0x007f
            r2.close()
        L_0x007f:
            return r0
        L_0x0080:
            r0 = move-exception
            goto L_0x0087
        L_0x0082:
            r14 = move-exception
            r2 = r1
            goto L_0x009d
        L_0x0085:
            r0 = move-exception
            r2 = r1
        L_0x0087:
            com.google.android.gms.measurement.internal.dy r3 = r13.J_()     // Catch:{ all -> 0x009c }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x009c }
            java.lang.String r4 = "Error querying user properties. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r14)     // Catch:{ all -> 0x009c }
            r3.a(r4, r14, r0)     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x009b
            r2.close()
        L_0x009b:
            return r1
        L_0x009c:
            r14 = move-exception
        L_0x009d:
            if (r2 == 0) goto L_0x00a2
            r2.close()
        L_0x00a2:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.a(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00f6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00f7, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00fe, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ff, code lost:
        r12 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0102, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0103, code lost:
        r12 = r21;
        r11 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0123, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00fe A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0123  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.jr> a(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            com.google.android.gms.common.internal.s.a((java.lang.String) r22)
            r21.h()
            r21.w()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0102, all -> 0x00fe }
            r3 = 3
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x0102, all -> 0x00fe }
            r11 = r22
            r2.add(r11)     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00fe }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00fe }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00fe }
            boolean r5 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x00fa, all -> 0x00fe }
            if (r5 != 0) goto L_0x0032
            r5 = r23
            r2.add(r5)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            java.lang.String r6 = " and origin=?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            goto L_0x0034
        L_0x0032:
            r5 = r23
        L_0x0034:
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            if (r6 != 0) goto L_0x004c
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            java.lang.String r7 = "*"
            java.lang.String r6 = r6.concat(r7)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            r2.add(r6)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            java.lang.String r6 = " and name glob ?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
        L_0x004c:
            int r6 = r2.size()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            java.lang.Object[] r2 = r2.toArray(r6)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            r16 = r2
            java.lang.String[] r16 = (java.lang.String[]) r16     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            android.database.sqlite.SQLiteDatabase r12 = r21.e()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            java.lang.String r13 = "user_attributes"
            java.lang.String r2 = "name"
            java.lang.String r6 = "set_timestamp"
            java.lang.String r7 = "value"
            java.lang.String r8 = "origin"
            java.lang.String[] r14 = new java.lang.String[]{r2, r6, r7, r8}     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            java.lang.String r15 = r4.toString()     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = "1001"
            android.database.Cursor r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x00f6, all -> 0x00fe }
            boolean r4 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            if (r4 != 0) goto L_0x008a
            if (r2 == 0) goto L_0x0089
            r2.close()
        L_0x0089:
            return r0
        L_0x008a:
            int r4 = r0.size()     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r6) goto L_0x00a4
            com.google.android.gms.measurement.internal.dy r3 = r21.J_()     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            r3.a(r4, r6)     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            r12 = r21
            goto L_0x00e1
        L_0x00a4:
            r4 = 0
            java.lang.String r7 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            r4 = 1
            long r8 = r2.getLong(r4)     // Catch:{ SQLiteException -> 0x00f2, all -> 0x00ee }
            r4 = 2
            r12 = r21
            java.lang.Object r10 = r12.a((android.database.Cursor) r2, (int) r4)     // Catch:{ SQLiteException -> 0x00ec }
            java.lang.String r13 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x00ec }
            if (r10 != 0) goto L_0x00cd
            com.google.android.gms.measurement.internal.dy r4 = r21.J_()     // Catch:{ SQLiteException -> 0x00e9 }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ SQLiteException -> 0x00e9 }
            java.lang.String r5 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r22)     // Catch:{ SQLiteException -> 0x00e9 }
            r14 = r24
            r4.a(r5, r6, r13, r14)     // Catch:{ SQLiteException -> 0x00e9 }
            goto L_0x00db
        L_0x00cd:
            r14 = r24
            com.google.android.gms.measurement.internal.jr r15 = new com.google.android.gms.measurement.internal.jr     // Catch:{ SQLiteException -> 0x00e9 }
            r4 = r15
            r5 = r22
            r6 = r13
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x00e9 }
            r0.add(r15)     // Catch:{ SQLiteException -> 0x00e9 }
        L_0x00db:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00e9 }
            if (r4 != 0) goto L_0x00e7
        L_0x00e1:
            if (r2 == 0) goto L_0x00e6
            r2.close()
        L_0x00e6:
            return r0
        L_0x00e7:
            r5 = r13
            goto L_0x008a
        L_0x00e9:
            r0 = move-exception
            r5 = r13
            goto L_0x010a
        L_0x00ec:
            r0 = move-exception
            goto L_0x010a
        L_0x00ee:
            r0 = move-exception
            r12 = r21
            goto L_0x0120
        L_0x00f2:
            r0 = move-exception
            r12 = r21
            goto L_0x010a
        L_0x00f6:
            r0 = move-exception
            r12 = r21
            goto L_0x0109
        L_0x00fa:
            r0 = move-exception
            r12 = r21
            goto L_0x0107
        L_0x00fe:
            r0 = move-exception
            r12 = r21
            goto L_0x0121
        L_0x0102:
            r0 = move-exception
            r12 = r21
            r11 = r22
        L_0x0107:
            r5 = r23
        L_0x0109:
            r2 = r1
        L_0x010a:
            com.google.android.gms.measurement.internal.dy r3 = r21.J_()     // Catch:{ all -> 0x011f }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x011f }
            java.lang.String r4 = "(2)Error querying user properties"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r22)     // Catch:{ all -> 0x011f }
            r3.a(r4, r6, r5, r0)     // Catch:{ all -> 0x011f }
            if (r2 == 0) goto L_0x011e
            r2.close()
        L_0x011e:
            return r1
        L_0x011f:
            r0 = move-exception
        L_0x0120:
            r1 = r2
        L_0x0121:
            if (r1 == 0) goto L_0x0126
            r1.close()
        L_0x0126:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.a(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    public final boolean a(zzv zzv) {
        s.a(zzv);
        h();
        w();
        if (c(zzv.f12389a, zzv.f12391c.f12372a) == null) {
            if (b("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzv.f12389a}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzv.f12389a);
        contentValues.put("origin", zzv.f12390b);
        contentValues.put("name", zzv.f12391c.f12372a);
        a(contentValues, "value", zzv.f12391c.a());
        contentValues.put("active", Boolean.valueOf(zzv.f12393e));
        contentValues.put("trigger_event_name", zzv.f12394f);
        contentValues.put("trigger_timeout", Long.valueOf(zzv.f12396h));
        L_();
        contentValues.put("timed_out_event", jq.a((Parcelable) zzv.f12395g));
        contentValues.put("creation_timestamp", Long.valueOf(zzv.f12392d));
        L_();
        contentValues.put("triggered_event", jq.a((Parcelable) zzv.f12397i));
        contentValues.put("triggered_timestamp", Long.valueOf(zzv.f12391c.f12373b));
        contentValues.put("time_to_live", Long.valueOf(zzv.j));
        L_();
        contentValues.put("expired_event", jq.a((Parcelable) zzv.k));
        try {
            if (e().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                J_().f11828c.a("Failed to insert/update conditional user property (got -1)", dy.a(zzv.f12389a));
            }
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing conditional user property", dy.a(zzv.f12389a), e2);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzv d(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.s.a((java.lang.String) r30)
            com.google.android.gms.common.internal.s.a((java.lang.String) r31)
            r29.h()
            r29.w()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.e()     // Catch:{ SQLiteException -> 0x0104, all -> 0x00ff }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x0104, all -> 0x00ff }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0104, all -> 0x00ff }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x0104, all -> 0x00ff }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x0104, all -> 0x00ff }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0104, all -> 0x00ff }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            if (r3 != 0) goto L_0x0055
            if (r9 == 0) goto L_0x0054
            r9.close()
        L_0x0054:
            return r8
        L_0x0055:
            java.lang.String r16 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00f7 }
            r10 = r29
            java.lang.Object r5 = r10.a((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x00f5 }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00f5 }
            if (r0 == 0) goto L_0x0068
            r20 = 1
            goto L_0x006a
        L_0x0068:
            r20 = 0
        L_0x006a:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00f5 }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f5 }
            com.google.android.gms.measurement.internal.jn r0 = r29.G_()     // Catch:{ SQLiteException -> 0x00f5 }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f5 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzan> r2 = com.google.android.gms.measurement.internal.zzan.CREATOR     // Catch:{ SQLiteException -> 0x00f5 }
            android.os.Parcelable r0 = r0.a((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f5 }
            r22 = r0
            com.google.android.gms.measurement.internal.zzan r22 = (com.google.android.gms.measurement.internal.zzan) r22     // Catch:{ SQLiteException -> 0x00f5 }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f5 }
            com.google.android.gms.measurement.internal.jn r0 = r29.G_()     // Catch:{ SQLiteException -> 0x00f5 }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f5 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzan> r2 = com.google.android.gms.measurement.internal.zzan.CREATOR     // Catch:{ SQLiteException -> 0x00f5 }
            android.os.Parcelable r0 = r0.a((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f5 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzan r25 = (com.google.android.gms.measurement.internal.zzan) r25     // Catch:{ SQLiteException -> 0x00f5 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f5 }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f5 }
            com.google.android.gms.measurement.internal.jn r0 = r29.G_()     // Catch:{ SQLiteException -> 0x00f5 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f5 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzan> r2 = com.google.android.gms.measurement.internal.zzan.CREATOR     // Catch:{ SQLiteException -> 0x00f5 }
            android.os.Parcelable r0 = r0.a((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f5 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzan r28 = (com.google.android.gms.measurement.internal.zzan) r28     // Catch:{ SQLiteException -> 0x00f5 }
            com.google.android.gms.measurement.internal.zzkl r17 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ SQLiteException -> 0x00f5 }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00f5 }
            com.google.android.gms.measurement.internal.zzv r0 = new com.google.android.gms.measurement.internal.zzv     // Catch:{ SQLiteException -> 0x00f5 }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00f5 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00f5 }
            if (r1 == 0) goto L_0x00ef
            com.google.android.gms.measurement.internal.dy r1 = r29.J_()     // Catch:{ SQLiteException -> 0x00f5 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ SQLiteException -> 0x00f5 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r30)     // Catch:{ SQLiteException -> 0x00f5 }
            com.google.android.gms.measurement.internal.dw r4 = r29.l()     // Catch:{ SQLiteException -> 0x00f5 }
            java.lang.String r4 = r4.c(r7)     // Catch:{ SQLiteException -> 0x00f5 }
            r1.a(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00f5 }
        L_0x00ef:
            if (r9 == 0) goto L_0x00f4
            r9.close()
        L_0x00f4:
            return r0
        L_0x00f5:
            r0 = move-exception
            goto L_0x0108
        L_0x00f7:
            r0 = move-exception
            r10 = r29
            goto L_0x0126
        L_0x00fb:
            r0 = move-exception
            r10 = r29
            goto L_0x0108
        L_0x00ff:
            r0 = move-exception
            r10 = r29
            r9 = r8
            goto L_0x0126
        L_0x0104:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x0108:
            com.google.android.gms.measurement.internal.dy r1 = r29.J_()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ all -> 0x0125 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r30)     // Catch:{ all -> 0x0125 }
            com.google.android.gms.measurement.internal.dw r4 = r29.l()     // Catch:{ all -> 0x0125 }
            java.lang.String r4 = r4.c(r7)     // Catch:{ all -> 0x0125 }
            r1.a(r2, r3, r4, r0)     // Catch:{ all -> 0x0125 }
            if (r9 == 0) goto L_0x0124
            r9.close()
        L_0x0124:
            return r8
        L_0x0125:
            r0 = move-exception
        L_0x0126:
            if (r9 == 0) goto L_0x012b
            r9.close()
        L_0x012b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.d(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzv");
    }

    public final int e(String str, String str2) {
        s.a(str);
        s.a(str2);
        h();
        w();
        try {
            return e().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error deleting conditional property", dy.a(str), l().c(str2), e2);
            return 0;
        }
    }

    public final List<zzv> b(String str, String str2, String str3) {
        s.a(str);
        h();
        w();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return a(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzv> a(String str, String[] strArr) {
        h();
        w();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", "trigger_event_name", "trigger_timeout", "timed_out_event", "creation_timestamp", "triggered_event", "triggered_timestamp", "time_to_live", "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object a2 = a(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j2 = cursor.getLong(6);
                    long j3 = cursor.getLong(8);
                    long j4 = cursor.getLong(10);
                    boolean z2 = z;
                    zzv zzv = r3;
                    zzv zzv2 = new zzv(string, string2, new zzkl(string3, j4, a2, string2), j3, z2, string4, (zzan) G_().a(cursor.getBlob(7), zzan.CREATOR), j2, (zzan) G_().a(cursor.getBlob(9), zzan.CREATOR), cursor.getLong(11), (zzan) G_().a(cursor.getBlob(12), zzan.CREATOR));
                    arrayList.add(zzv);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    J_().f11828c.a("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error querying conditional user property value", e2);
            List<zzv> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x02bb  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x02c2  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00f3 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f5 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0112 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0114 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0131 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0133 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0150 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0152 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0172 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0176 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x019e A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01a0 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01bd A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01bf A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01d8 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x01da A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e9 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01fe A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x021c A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x021d A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x022c A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0268 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0282 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0293  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.fb b(java.lang.String r35) {
        /*
            r34 = this;
            r1 = r35
            com.google.android.gms.common.internal.s.a((java.lang.String) r35)
            r34.h()
            r34.w()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r34.e()     // Catch:{ SQLiteException -> 0x02a6, all -> 0x02a1 }
            java.lang.String r4 = "apps"
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "ssaid_reporting_enabled"
            java.lang.String r30 = "admob_app_id"
            java.lang.String r31 = "dynamite_version"
            java.lang.String r32 = "safelisted_events"
            java.lang.String r33 = "ga_app_id"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33}     // Catch:{ SQLiteException -> 0x02a6, all -> 0x02a1 }
            java.lang.String r6 = "app_id=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x02a6, all -> 0x02a1 }
            r11 = 0
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x02a6, all -> 0x02a1 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x02a6, all -> 0x02a1 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x029d, all -> 0x0299 }
            if (r4 != 0) goto L_0x006c
            if (r3 == 0) goto L_0x006b
            r3.close()
        L_0x006b:
            return r2
        L_0x006c:
            com.google.android.gms.measurement.internal.fb r4 = new com.google.android.gms.measurement.internal.fb     // Catch:{ SQLiteException -> 0x029d, all -> 0x0299 }
            r5 = r34
            com.google.android.gms.measurement.internal.jj r6 = r5.f12261b     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r6 = r6.f12266b     // Catch:{ SQLiteException -> 0x0297 }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0297 }
            r4.a((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r6 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0297 }
            r4.b((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 2
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.e((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 3
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.g((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.a((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 5
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.b((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.g((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 7
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.h((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 8
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.d((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 9
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.e((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 10
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x00d8
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x00d6
            goto L_0x00d8
        L_0x00d6:
            r6 = 0
            goto L_0x00d9
        L_0x00d8:
            r6 = 1
        L_0x00d9:
            r4.a((boolean) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 11
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r8 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r8 = r8.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r8.h()     // Catch:{ SQLiteException -> 0x0297 }
            boolean r8 = r4.j     // Catch:{ SQLiteException -> 0x0297 }
            long r9 = r4.f11934c     // Catch:{ SQLiteException -> 0x0297 }
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x00f5
            r9 = 1
            goto L_0x00f6
        L_0x00f5:
            r9 = 0
        L_0x00f6:
            r8 = r8 | r9
            r4.j = r8     // Catch:{ SQLiteException -> 0x0297 }
            r4.f11934c = r6     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 12
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r8 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r8 = r8.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r8.h()     // Catch:{ SQLiteException -> 0x0297 }
            boolean r8 = r4.j     // Catch:{ SQLiteException -> 0x0297 }
            long r9 = r4.f11935d     // Catch:{ SQLiteException -> 0x0297 }
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0114
            r9 = 1
            goto L_0x0115
        L_0x0114:
            r9 = 0
        L_0x0115:
            r8 = r8 | r9
            r4.j = r8     // Catch:{ SQLiteException -> 0x0297 }
            r4.f11935d = r6     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 13
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r8 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r8 = r8.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r8.h()     // Catch:{ SQLiteException -> 0x0297 }
            boolean r8 = r4.j     // Catch:{ SQLiteException -> 0x0297 }
            long r9 = r4.f11936e     // Catch:{ SQLiteException -> 0x0297 }
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0133
            r9 = 1
            goto L_0x0134
        L_0x0133:
            r9 = 0
        L_0x0134:
            r8 = r8 | r9
            r4.j = r8     // Catch:{ SQLiteException -> 0x0297 }
            r4.f11936e = r6     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 14
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r8 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r8 = r8.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r8.h()     // Catch:{ SQLiteException -> 0x0297 }
            boolean r8 = r4.j     // Catch:{ SQLiteException -> 0x0297 }
            long r9 = r4.f11937f     // Catch:{ SQLiteException -> 0x0297 }
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x0152
            r9 = 1
            goto L_0x0153
        L_0x0152:
            r9 = 0
        L_0x0153:
            r8 = r8 | r9
            r4.j = r8     // Catch:{ SQLiteException -> 0x0297 }
            r4.f11937f = r6     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 15
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.h((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 16
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.i((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 17
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 == 0) goto L_0x0176
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x017b
        L_0x0176:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x0297 }
        L_0x017b:
            r4.c((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 18
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.f((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 19
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r8 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r8 = r8.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r8.h()     // Catch:{ SQLiteException -> 0x0297 }
            boolean r8 = r4.j     // Catch:{ SQLiteException -> 0x0297 }
            long r9 = r4.f11938g     // Catch:{ SQLiteException -> 0x0297 }
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x01a0
            r9 = 1
            goto L_0x01a1
        L_0x01a0:
            r9 = 0
        L_0x01a1:
            r8 = r8 | r9
            r4.j = r8     // Catch:{ SQLiteException -> 0x0297 }
            r4.f11938g = r6     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 20
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r8 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r8 = r8.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r8.h()     // Catch:{ SQLiteException -> 0x0297 }
            boolean r8 = r4.j     // Catch:{ SQLiteException -> 0x0297 }
            long r9 = r4.f11939h     // Catch:{ SQLiteException -> 0x0297 }
            int r12 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r12 == 0) goto L_0x01bf
            r9 = 1
            goto L_0x01c0
        L_0x01bf:
            r9 = 0
        L_0x01c0:
            r8 = r8 | r9
            r4.j = r8     // Catch:{ SQLiteException -> 0x0297 }
            r4.f11939h = r6     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 21
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.i((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 22
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r8 = 0
            if (r7 == 0) goto L_0x01da
            r6 = r8
            goto L_0x01de
        L_0x01da:
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x01de:
            r4.j(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 23
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x01f2
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x01f0
            goto L_0x01f2
        L_0x01f0:
            r6 = 0
            goto L_0x01f3
        L_0x01f2:
            r6 = 1
        L_0x01f3:
            r4.b((boolean) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 24
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x0207
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0205
            goto L_0x0207
        L_0x0205:
            r6 = 0
            goto L_0x0208
        L_0x0207:
            r6 = 1
        L_0x0208:
            r4.c((boolean) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 25
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.c((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 26
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 == 0) goto L_0x021d
            goto L_0x0221
        L_0x021d:
            long r8 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0221:
            r4.f((long) r8)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 27
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x0259
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r7 = ","
            r8 = -1
            java.lang.String[] r6 = r6.split(r7, r8)     // Catch:{ SQLiteException -> 0x0297 }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.fc r7 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r7 = r7.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r7.h()     // Catch:{ SQLiteException -> 0x0297 }
            java.util.List<java.lang.String> r7 = r4.f11933b     // Catch:{ SQLiteException -> 0x0297 }
            boolean r7 = com.google.android.gms.measurement.internal.jq.a((java.util.List<java.lang.String>) r7, (java.util.List<java.lang.String>) r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x0259
            r4.j = r0     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0256
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0297 }
            r0.<init>(r6)     // Catch:{ SQLiteException -> 0x0297 }
            goto L_0x0257
        L_0x0256:
            r0 = r2
        L_0x0257:
            r4.f11933b = r0     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0259:
            com.google.android.gms.internal.measurement.jz.a()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.ke r0 = r34.H_()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.o.aC     // Catch:{ SQLiteException -> 0x0297 }
            boolean r0 = r0.d(r1, r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r0 == 0) goto L_0x0271
            r0 = 28
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0297 }
            r4.d((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0271:
            com.google.android.gms.measurement.internal.fc r0 = r4.f11932a     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.eu r0 = r0.K_()     // Catch:{ SQLiteException -> 0x0297 }
            r0.h()     // Catch:{ SQLiteException -> 0x0297 }
            r4.j = r11     // Catch:{ SQLiteException -> 0x0297 }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0297 }
            if (r0 == 0) goto L_0x0291
            com.google.android.gms.measurement.internal.dy r0 = r34.J_()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r35)     // Catch:{ SQLiteException -> 0x0297 }
            r0.a(r6, r7)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0291:
            if (r3 == 0) goto L_0x0296
            r3.close()
        L_0x0296:
            return r4
        L_0x0297:
            r0 = move-exception
            goto L_0x02aa
        L_0x0299:
            r0 = move-exception
            r5 = r34
            goto L_0x02c0
        L_0x029d:
            r0 = move-exception
            r5 = r34
            goto L_0x02aa
        L_0x02a1:
            r0 = move-exception
            r5 = r34
            r3 = r2
            goto L_0x02c0
        L_0x02a6:
            r0 = move-exception
            r5 = r34
            r3 = r2
        L_0x02aa:
            com.google.android.gms.measurement.internal.dy r4 = r34.J_()     // Catch:{ all -> 0x02bf }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ all -> 0x02bf }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r35)     // Catch:{ all -> 0x02bf }
            r4.a(r6, r1, r0)     // Catch:{ all -> 0x02bf }
            if (r3 == 0) goto L_0x02be
            r3.close()
        L_0x02be:
            return r2
        L_0x02bf:
            r0 = move-exception
        L_0x02c0:
            if (r3 == 0) goto L_0x02c5
            r3.close()
        L_0x02c5:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.b(java.lang.String):com.google.android.gms.measurement.internal.fb");
    }

    public final void a(fb fbVar) {
        s.a(fbVar);
        h();
        w();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", fbVar.b());
        contentValues.put("app_instance_id", fbVar.c());
        contentValues.put("gmp_app_id", fbVar.d());
        contentValues.put("resettable_device_id_hash", fbVar.g());
        contentValues.put("last_bundle_index", Long.valueOf(fbVar.r()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(fbVar.i()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(fbVar.j()));
        contentValues.put("app_version", fbVar.k());
        contentValues.put("app_store", fbVar.m());
        contentValues.put("gmp_version", Long.valueOf(fbVar.n()));
        contentValues.put("dev_cert_hash", Long.valueOf(fbVar.o()));
        contentValues.put("measurement_enabled", Boolean.valueOf(fbVar.q()));
        fbVar.f11932a.K_().h();
        contentValues.put("day", Long.valueOf(fbVar.f11934c));
        fbVar.f11932a.K_().h();
        contentValues.put("daily_public_events_count", Long.valueOf(fbVar.f11935d));
        fbVar.f11932a.K_().h();
        contentValues.put("daily_events_count", Long.valueOf(fbVar.f11936e));
        fbVar.f11932a.K_().h();
        contentValues.put("daily_conversions_count", Long.valueOf(fbVar.f11937f));
        contentValues.put("config_fetched_time", Long.valueOf(fbVar.s()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(fbVar.t()));
        contentValues.put("app_version_int", Long.valueOf(fbVar.l()));
        contentValues.put("firebase_instance_id", fbVar.h());
        fbVar.f11932a.K_().h();
        contentValues.put("daily_error_events_count", Long.valueOf(fbVar.f11938g));
        fbVar.f11932a.K_().h();
        contentValues.put("daily_realtime_events_count", Long.valueOf(fbVar.f11939h));
        contentValues.put("health_monitor_sample", fbVar.v());
        contentValues.put(UpiContract.DeviceInfoColumns.ANDROID_ID, Long.valueOf(fbVar.w()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(fbVar.x()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(fbVar.y()));
        contentValues.put("admob_app_id", fbVar.e());
        contentValues.put("dynamite_version", Long.valueOf(fbVar.p()));
        if (fbVar.A() != null) {
            if (fbVar.A().size() == 0) {
                J_().f11831f.a("Safelisted events should not be an empty list. appId", fbVar.b());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(AppConstants.COMMA, fbVar.A()));
            }
        }
        jz.a();
        if (H_().d(fbVar.b(), o.aC)) {
            contentValues.put("ga_app_id", fbVar.f());
        }
        try {
            SQLiteDatabase e2 = e();
            if (((long) e2.update("apps", contentValues, "app_id = ?", new String[]{fbVar.b()})) == 0 && e2.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                J_().f11828c.a("Failed to insert/update app (got -1). appId", dy.a(fbVar.b()));
            }
        } catch (SQLiteException e3) {
            J_().f11828c.a("Error storing app. appId", dy.a(fbVar.b()), e3);
        }
    }

    public final long c(String str) {
        s.a(str);
        h();
        w();
        try {
            return (long) e().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, H_().b(str, o.p))))});
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error deleting over the limit events. appId", dy.a(str), e2);
            return 0;
        }
    }

    public final c a(long j2, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        s.a(str);
        h();
        w();
        String[] strArr = {str};
        c cVar = new c();
        Cursor cursor = null;
        try {
            SQLiteDatabase e2 = e();
            cursor = e2.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                J_().f11831f.a("Not updating daily counts, app is not known. appId", dy.a(str));
                if (cursor != null) {
                    cursor.close();
                }
                return cVar;
            }
            if (cursor.getLong(0) == j2) {
                cVar.f11744b = cursor.getLong(1);
                cVar.f11743a = cursor.getLong(2);
                cVar.f11745c = cursor.getLong(3);
                cVar.f11746d = cursor.getLong(4);
                cVar.f11747e = cursor.getLong(5);
            }
            if (z) {
                cVar.f11744b++;
            }
            if (z2) {
                cVar.f11743a++;
            }
            if (z3) {
                cVar.f11745c++;
            }
            if (z4) {
                cVar.f11746d++;
            }
            if (z5) {
                cVar.f11747e++;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j2));
            contentValues.put("daily_public_events_count", Long.valueOf(cVar.f11743a));
            contentValues.put("daily_events_count", Long.valueOf(cVar.f11744b));
            contentValues.put("daily_conversions_count", Long.valueOf(cVar.f11745c));
            contentValues.put("daily_error_events_count", Long.valueOf(cVar.f11746d));
            contentValues.put("daily_realtime_events_count", Long.valueOf(cVar.f11747e));
            e2.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return cVar;
        } catch (SQLiteException e3) {
            J_().f11828c.a("Error updating daily counts. appId", dy.a(str), e3);
            if (cursor != null) {
                cursor.close();
            }
            return cVar;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] d(java.lang.String r11) {
        /*
            r10 = this;
            com.google.android.gms.common.internal.s.a((java.lang.String) r11)
            r10.h()
            r10.w()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r10.e()     // Catch:{ SQLiteException -> 0x0055, all -> 0x0052 }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch:{ SQLiteException -> 0x0055, all -> 0x0052 }
            java.lang.String r4 = "app_id=?"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0055, all -> 0x0052 }
            r9 = 0
            r5[r9] = r11     // Catch:{ SQLiteException -> 0x0055, all -> 0x0052 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0055, all -> 0x0052 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0050 }
            if (r2 != 0) goto L_0x0031
            if (r1 == 0) goto L_0x0030
            r1.close()
        L_0x0030:
            return r0
        L_0x0031:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x0050 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0050 }
            if (r3 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.dy r3 = r10.J_()     // Catch:{ SQLiteException -> 0x0050 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ SQLiteException -> 0x0050 }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0050 }
            r3.a(r4, r5)     // Catch:{ SQLiteException -> 0x0050 }
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.close()
        L_0x004f:
            return r2
        L_0x0050:
            r2 = move-exception
            goto L_0x0057
        L_0x0052:
            r11 = move-exception
            r1 = r0
            goto L_0x006d
        L_0x0055:
            r2 = move-exception
            r1 = r0
        L_0x0057:
            com.google.android.gms.measurement.internal.dy r3 = r10.J_()     // Catch:{ all -> 0x006c }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x006c }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ all -> 0x006c }
            r3.a(r4, r11, r2)     // Catch:{ all -> 0x006c }
            if (r1 == 0) goto L_0x006b
            r1.close()
        L_0x006b:
            return r0
        L_0x006c:
            r11 = move-exception
        L_0x006d:
            if (r1 == 0) goto L_0x0072
            r1.close()
        L_0x0072:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.d(java.lang.String):byte[]");
    }

    public final boolean a(aj.g gVar, boolean z) {
        h();
        w();
        s.a(gVar);
        s.a(gVar.zzs);
        s.a(gVar.a());
        z_();
        long a2 = j().a();
        if (gVar.zzj < a2 - ke.d() || gVar.zzj > ke.d() + a2) {
            J_().f11831f.a("Storing bundle outside of the max uploading time span. appId, now, timestamp", dy.a(gVar.zzs), Long.valueOf(a2), Long.valueOf(gVar.zzj));
        }
        try {
            byte[] c2 = G_().c(gVar.i());
            J_().k.a("Saving bundle, size", Integer.valueOf(c2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", gVar.zzs);
            contentValues.put("bundle_end_timestamp", Long.valueOf(gVar.zzj));
            contentValues.put("data", c2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (gVar.b()) {
                contentValues.put("retry_count", Integer.valueOf(gVar.zzao));
            }
            try {
                if (e().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                J_().f11828c.a("Failed to insert bundle (got -1). appId", dy.a(gVar.zzs));
                return false;
            } catch (SQLiteException e2) {
                J_().f11828c.a("Error storing bundle. appId", dy.a(gVar.zzs), e2);
                return false;
            }
        } catch (IOException e3) {
            J_().f11828c.a("Data loss. Failed to serialize bundle. appId", dy.a(gVar.zzs), e3);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.e()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003d
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.dy r3 = r6.J_()     // Catch:{ all -> 0x003c }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x003c }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.a(r4, r2)     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x003b
            r0.close()
        L_0x003b:
            return r1
        L_0x003c:
            r1 = move-exception
        L_0x003d:
            if (r0 == 0) goto L_0x0042
            r0.close()
        L_0x0042:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.f():java.lang.String");
    }

    public final boolean y_() {
        return b("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final List<Pair<aj.g, Long>> a(String str, int i2, int i3) {
        h();
        w();
        s.b(i2 > 0);
        s.b(i3 > 0);
        s.a(str);
        Cursor cursor = null;
        try {
            cursor = e().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i2));
            if (!cursor.moveToFirst()) {
                List<Pair<aj.g, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            do {
                long j2 = cursor.getLong(0);
                try {
                    byte[] b2 = G_().b(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && b2.length + i4 > i3) {
                        break;
                    }
                    try {
                        aj.g.a aVar = (aj.g.a) jn.a(aj.g.c(), b2);
                        if (!cursor.isNull(2)) {
                            aVar.h(cursor.getInt(2));
                        }
                        i4 += b2.length;
                        arrayList.add(Pair.create((aj.g) ((dv) aVar.w()), Long.valueOf(j2)));
                    } catch (IOException e2) {
                        J_().f11828c.a("Failed to merge queued bundle. appId", dy.a(str), e2);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e3) {
                    J_().f11828c.a("Failed to unzip queued bundle. appId", dy.a(str), e3);
                }
            } while (i4 <= i3);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e4) {
            J_().f11828c.a("Error querying bundles. appId", dy.a(str), e4);
            List<Pair<aj.g, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final void z_() {
        int delete;
        h();
        w();
        if (y()) {
            long a2 = I_().f11864g.a();
            long b2 = j().b();
            if (Math.abs(b2 - a2) > o.y.a(null).longValue()) {
                I_().f11864g.a(b2);
                h();
                w();
                if (y() && (delete = e().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(j().a()), String.valueOf(ke.d())})) > 0) {
                    J_().k.a("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(List<Long> list) {
        h();
        w();
        s.a(list);
        if (list.size() == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        } else if (y()) {
            String join = TextUtils.join(AppConstants.COMMA, list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (b(sb3.toString(), (String[]) null) > 0) {
                J_().f11831f.a("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase e2 = e();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                e2.execSQL(sb4.toString());
            } catch (SQLiteException e3) {
                J_().f11828c.a("Error incrementing retry count. error", e3);
            }
        }
    }

    private final boolean a(String str, int i2, ab.b bVar) {
        Integer num;
        w();
        h();
        s.a(str);
        s.a(bVar);
        Integer num2 = null;
        if (TextUtils.isEmpty(bVar.zze)) {
            ea eaVar = J_().f11831f;
            Object a2 = dy.a(str);
            Integer valueOf = Integer.valueOf(i2);
            if (bVar.a()) {
                num2 = Integer.valueOf(bVar.zzd);
            }
            eaVar.a("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", a2, valueOf, String.valueOf(num2));
            return false;
        }
        byte[] i3 = bVar.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        if (bVar.a()) {
            num = Integer.valueOf(bVar.zzd);
        } else {
            num = null;
        }
        contentValues.put("filter_id", num);
        contentValues.put("event_name", bVar.zze);
        if (H_().d(str, o.al)) {
            contentValues.put("session_scoped", (bVar.zzc & 64) != 0 ? Boolean.valueOf(bVar.zzk) : null);
        }
        contentValues.put("data", i3);
        try {
            if (e().insertWithOnConflict("event_filters", (String) null, contentValues, 5) == -1) {
                J_().f11828c.a("Failed to insert event filter (got -1). appId", dy.a(str));
            }
            return true;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing event filter. appId", dy.a(str), e2);
            return false;
        }
    }

    private final boolean a(String str, int i2, ab.e eVar) {
        Integer num;
        w();
        h();
        s.a(str);
        s.a(eVar);
        Integer num2 = null;
        if (TextUtils.isEmpty(eVar.zze)) {
            ea eaVar = J_().f11831f;
            Object a2 = dy.a(str);
            Integer valueOf = Integer.valueOf(i2);
            if (eVar.a()) {
                num2 = Integer.valueOf(eVar.zzd);
            }
            eaVar.a("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", a2, valueOf, String.valueOf(num2));
            return false;
        }
        byte[] i3 = eVar.i();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i2));
        if (eVar.a()) {
            num = Integer.valueOf(eVar.zzd);
        } else {
            num = null;
        }
        contentValues.put("filter_id", num);
        contentValues.put("property_name", eVar.zze);
        if (H_().d(str, o.al)) {
            contentValues.put("session_scoped", (eVar.zzc & 32) != 0 ? Boolean.valueOf(eVar.zzi) : null);
        }
        contentValues.put("data", i3);
        try {
            if (e().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            J_().f11828c.a("Failed to insert property filter (got -1). appId", dy.a(str));
            return false;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing property filter. appId", dy.a(str), e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.ab.b>> f(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.w()
            r12.h()
            com.google.android.gms.common.internal.s.a((java.lang.String) r13)
            com.google.android.gms.common.internal.s.a((java.lang.String) r14)
            androidx.a.a r0 = new androidx.a.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.e()
            r9 = 0
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            java.lang.String r4 = "app_id=? AND event_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0094 }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0094 }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0094 }
            com.google.android.gms.internal.measurement.ab$b$a r2 = com.google.android.gms.internal.measurement.ab.b.c()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.fe r1 = com.google.android.gms.measurement.internal.jn.a(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.ab$b$a r1 = (com.google.android.gms.internal.measurement.ab.b.a) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.ff r1 = r1.w()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.dv r1 = (com.google.android.gms.internal.measurement.dv) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.ab$b r1 = (com.google.android.gms.internal.measurement.ab.b) r1     // Catch:{ IOException -> 0x0078 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0094 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0094 }
            if (r3 != 0) goto L_0x0074
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0094 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0094 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0094 }
        L_0x0074:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0094 }
            goto L_0x0088
        L_0x0078:
            r1 = move-exception
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()     // Catch:{ SQLiteException -> 0x0094 }
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0094 }
            r2.a(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0094 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0094 }
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x0093
            r14.close()
        L_0x0093:
            return r0
        L_0x0094:
            r0 = move-exception
            goto L_0x009b
        L_0x0096:
            r13 = move-exception
            r14 = r9
            goto L_0x00b1
        L_0x0099:
            r0 = move-exception
            r14 = r9
        L_0x009b:
            com.google.android.gms.measurement.internal.dy r1 = r12.J_()     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r13)     // Catch:{ all -> 0x00b0 }
            r1.a(r2, r13, r0)     // Catch:{ all -> 0x00b0 }
            if (r14 == 0) goto L_0x00af
            r14.close()
        L_0x00af:
            return r9
        L_0x00b0:
            r13 = move-exception
        L_0x00b1:
            if (r14 == 0) goto L_0x00b6
            r14.close()
        L_0x00b6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.f(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.ab.e>> g(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.w()
            r12.h()
            com.google.android.gms.common.internal.s.a((java.lang.String) r13)
            com.google.android.gms.common.internal.s.a((java.lang.String) r14)
            androidx.a.a r0 = new androidx.a.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.e()
            r9 = 0
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "audience_id"
            java.lang.String r4 = "data"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4}     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            java.lang.String r4 = "app_id=? AND property_name=?"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            r10 = 0
            r5[r10] = r13     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            r11 = 1
            r5[r11] = r14     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0099, all -> 0x0096 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0094 }
            if (r1 != 0) goto L_0x0042
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0094 }
            if (r14 == 0) goto L_0x0041
            r14.close()
        L_0x0041:
            return r13
        L_0x0042:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0094 }
            com.google.android.gms.internal.measurement.ab$e$a r2 = com.google.android.gms.internal.measurement.ab.e.c()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.fe r1 = com.google.android.gms.measurement.internal.jn.a(r2, (byte[]) r1)     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.ab$e$a r1 = (com.google.android.gms.internal.measurement.ab.e.a) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.ff r1 = r1.w()     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.dv r1 = (com.google.android.gms.internal.measurement.dv) r1     // Catch:{ IOException -> 0x0078 }
            com.google.android.gms.internal.measurement.ab$e r1 = (com.google.android.gms.internal.measurement.ab.e) r1     // Catch:{ IOException -> 0x0078 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0094 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0094 }
            if (r3 != 0) goto L_0x0074
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0094 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0094 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0094 }
        L_0x0074:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0094 }
            goto L_0x0088
        L_0x0078:
            r1 = move-exception
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()     // Catch:{ SQLiteException -> 0x0094 }
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c     // Catch:{ SQLiteException -> 0x0094 }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0094 }
            r2.a(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0094 }
        L_0x0088:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0094 }
            if (r1 != 0) goto L_0x0042
            if (r14 == 0) goto L_0x0093
            r14.close()
        L_0x0093:
            return r0
        L_0x0094:
            r0 = move-exception
            goto L_0x009b
        L_0x0096:
            r13 = move-exception
            r14 = r9
            goto L_0x00b1
        L_0x0099:
            r0 = move-exception
            r14 = r9
        L_0x009b:
            com.google.android.gms.measurement.internal.dy r1 = r12.J_()     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r13)     // Catch:{ all -> 0x00b0 }
            r1.a(r2, r13, r0)     // Catch:{ all -> 0x00b0 }
            if (r14 == 0) goto L_0x00af
            r14.close()
        L_0x00af:
            return r9
        L_0x00b0:
            r13 = move-exception
        L_0x00b1:
            if (r14 == 0) goto L_0x00b6
            r14.close()
        L_0x00b6:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.g(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> a(java.lang.String r13, java.util.List<java.lang.String> r14) {
        /*
            r12 = this;
            r12.w()
            r12.h()
            com.google.android.gms.common.internal.s.a((java.lang.String) r13)
            com.google.android.gms.common.internal.s.a(r14)
            androidx.a.a r0 = new androidx.a.a
            r0.<init>()
            boolean r1 = r14.isEmpty()
            if (r1 == 0) goto L_0x0018
            return r0
        L_0x0018:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "app_id=? AND property_name in ("
            r1.append(r2)
            r2 = 0
            r3 = 0
        L_0x0024:
            int r4 = r14.size()
            if (r3 >= r4) goto L_0x0039
            if (r3 <= 0) goto L_0x0031
            java.lang.String r4 = ","
            r1.append(r4)
        L_0x0031:
            java.lang.String r4 = "?"
            r1.append(r4)
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0039:
            java.lang.String r3 = ")"
            r1.append(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r14)
            r3.add(r2, r13)
            android.database.sqlite.SQLiteDatabase r4 = r12.e()
            r14 = 0
            java.lang.String r5 = "property_filters"
            java.lang.String r6 = "audience_id"
            java.lang.String r7 = "filter_id"
            java.lang.String[] r6 = new java.lang.String[]{r6, r7}     // Catch:{ SQLiteException -> 0x00ae, all -> 0x00ab }
            java.lang.String r7 = r1.toString()     // Catch:{ SQLiteException -> 0x00ae, all -> 0x00ab }
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00ae, all -> 0x00ab }
            java.lang.Object[] r1 = r3.toArray(r1)     // Catch:{ SQLiteException -> 0x00ae, all -> 0x00ab }
            r8 = r1
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ SQLiteException -> 0x00ae, all -> 0x00ab }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00ae, all -> 0x00ab }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00a9 }
            if (r3 != 0) goto L_0x0075
            if (r1 == 0) goto L_0x0074
            r1.close()
        L_0x0074:
            return r0
        L_0x0075:
            int r3 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x00a9 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00a9 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x00a9 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x00a9 }
            if (r4 != 0) goto L_0x0091
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00a9 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x00a9 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00a9 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x00a9 }
        L_0x0091:
            r3 = 1
            int r3 = r1.getInt(r3)     // Catch:{ SQLiteException -> 0x00a9 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00a9 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x00a9 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x00a9 }
            if (r3 != 0) goto L_0x0075
            if (r1 == 0) goto L_0x00a8
            r1.close()
        L_0x00a8:
            return r0
        L_0x00a9:
            r0 = move-exception
            goto L_0x00b0
        L_0x00ab:
            r13 = move-exception
            r1 = r14
            goto L_0x00c6
        L_0x00ae:
            r0 = move-exception
            r1 = r14
        L_0x00b0:
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()     // Catch:{ all -> 0x00c5 }
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c     // Catch:{ all -> 0x00c5 }
            java.lang.String r3 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r13)     // Catch:{ all -> 0x00c5 }
            r2.a(r3, r13, r0)     // Catch:{ all -> 0x00c5 }
            if (r1 == 0) goto L_0x00c4
            r1.close()
        L_0x00c4:
            return r14
        L_0x00c5:
            r13 = move-exception
        L_0x00c6:
            if (r1 == 0) goto L_0x00cb
            r1.close()
        L_0x00cb:
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.a(java.lang.String, java.util.List):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> e(java.lang.String r8) {
        /*
            r7 = this;
            r7.w()
            r7.h()
            com.google.android.gms.common.internal.s.a((java.lang.String) r8)
            androidx.a.a r0 = new androidx.a.a
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.e()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            return r8
        L_0x0032:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x0065 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0065 }
            if (r4 != 0) goto L_0x004e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0065 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0065 }
        L_0x004e:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0065 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            goto L_0x006c
        L_0x0067:
            r8 = move-exception
            r1 = r2
            goto L_0x0082
        L_0x006a:
            r0 = move-exception
            r1 = r2
        L_0x006c:
            com.google.android.gms.measurement.internal.dy r3 = r7.J_()     // Catch:{ all -> 0x0081 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r8)     // Catch:{ all -> 0x0081 }
            r3.a(r4, r8, r0)     // Catch:{ all -> 0x0081 }
            if (r1 == 0) goto L_0x0080
            r1.close()
        L_0x0080:
            return r2
        L_0x0081:
            r8 = move-exception
        L_0x0082:
            if (r1 == 0) goto L_0x0087
            r1.close()
        L_0x0087:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.e(java.lang.String):java.util.Map");
    }

    private final boolean c(String str, List<Integer> list) {
        s.a(str);
        w();
        h();
        SQLiteDatabase e2 = e();
        try {
            long b2 = b("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY, H_().b(str, o.F)));
            if (b2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < list.size(); i2++) {
                Integer num = list.get(i2);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(AppConstants.COMMA, arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return e2.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e3) {
            J_().f11828c.a("Database error querying filters. appId", dy.a(str), e3);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.aj.i> f(java.lang.String r12) {
        /*
            r11 = this;
            r11.w()
            r11.h()
            com.google.android.gms.common.internal.s.a((java.lang.String) r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.e()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            java.lang.String r2 = "audience_id"
            java.lang.String r3 = "current_results"
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}     // Catch:{ SQLiteException -> 0x007f, all -> 0x007c }
            java.lang.String r3 = "app_id=?"
            r9 = 1
            java.lang.String[] r4 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x007f, all -> 0x007c }
            r10 = 0
            r4[r10] = r12     // Catch:{ SQLiteException -> 0x007f, all -> 0x007c }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x007f, all -> 0x007c }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x007a }
            if (r1 != 0) goto L_0x0033
            if (r0 == 0) goto L_0x0032
            r0.close()
        L_0x0032:
            return r8
        L_0x0033:
            androidx.a.a r1 = new androidx.a.a     // Catch:{ SQLiteException -> 0x007a }
            r1.<init>()     // Catch:{ SQLiteException -> 0x007a }
        L_0x0038:
            int r2 = r0.getInt(r10)     // Catch:{ SQLiteException -> 0x007a }
            byte[] r3 = r0.getBlob(r9)     // Catch:{ SQLiteException -> 0x007a }
            com.google.android.gms.internal.measurement.aj$i$a r4 = com.google.android.gms.internal.measurement.aj.i.d()     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.measurement.fe r3 = com.google.android.gms.measurement.internal.jn.a(r4, (byte[]) r3)     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.measurement.aj$i$a r3 = (com.google.android.gms.internal.measurement.aj.i.a) r3     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.measurement.ff r3 = r3.w()     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ IOException -> 0x005a }
            com.google.android.gms.internal.measurement.aj$i r3 = (com.google.android.gms.internal.measurement.aj.i) r3     // Catch:{ IOException -> 0x005a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x007a }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x007a }
            goto L_0x006e
        L_0x005a:
            r3 = move-exception
            com.google.android.gms.measurement.internal.dy r4 = r11.J_()     // Catch:{ SQLiteException -> 0x007a }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ SQLiteException -> 0x007a }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x007a }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x007a }
            r4.a(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x007a }
        L_0x006e:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x007a }
            if (r2 != 0) goto L_0x0038
            if (r0 == 0) goto L_0x0079
            r0.close()
        L_0x0079:
            return r1
        L_0x007a:
            r1 = move-exception
            goto L_0x0081
        L_0x007c:
            r12 = move-exception
            r0 = r8
            goto L_0x0097
        L_0x007f:
            r1 = move-exception
            r0 = r8
        L_0x0081:
            com.google.android.gms.measurement.internal.dy r2 = r11.J_()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r12)     // Catch:{ all -> 0x0096 }
            r2.a(r3, r12, r1)     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0095
            r0.close()
        L_0x0095:
            return r8
        L_0x0096:
            r12 = move-exception
        L_0x0097:
            if (r0 == 0) goto L_0x009c
            r0.close()
        L_0x009c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.f(java.lang.String):java.util.Map");
    }

    private static void a(ContentValues contentValues, String str, Object obj) {
        s.a(str);
        s.a(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    private final Object a(Cursor cursor, int i2) {
        int type = cursor.getType(i2);
        if (type == 0) {
            J_().f11828c.a("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i2));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i2));
            }
            if (type == 3) {
                return cursor.getString(i2);
            }
            if (type != 4) {
                J_().f11828c.a("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            J_().f11828c.a("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    public final long A_() {
        return a("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    public final long h(String str, String str2) {
        long j2;
        String str3 = str;
        String str4 = str2;
        s.a(str);
        s.a(str2);
        h();
        w();
        SQLiteDatabase e2 = e();
        e2.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                j2 = a(sb.toString(), new String[]{str3}, -1);
                if (j2 == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (e2.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        J_().f11828c.a("Failed to insert column (got -1). appId", dy.a(str), str4);
                        e2.endTransaction();
                        return -1;
                    }
                    j2 = 0;
                }
                try {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("app_id", str3);
                    contentValues2.put(str4, Long.valueOf(1 + j2));
                    if (((long) e2.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                        J_().f11828c.a("Failed to update column (got 0). appId", dy.a(str), str4);
                        e2.endTransaction();
                        return -1;
                    }
                    e2.setTransactionSuccessful();
                    e2.endTransaction();
                    return j2;
                } catch (SQLiteException e3) {
                    e = e3;
                    try {
                        J_().f11828c.a("Error inserting column. appId", dy.a(str), str4, e);
                        e2.endTransaction();
                        return j2;
                    } catch (Throwable th) {
                        th = th;
                        e2.endTransaction();
                        throw th;
                    }
                }
            } catch (SQLiteException e4) {
                e = e4;
                j2 = 0;
                J_().f11828c.a("Error inserting column. appId", dy.a(str), str4, e);
                e2.endTransaction();
                return j2;
            }
        } catch (SQLiteException e5) {
            e = e5;
            j2 = 0;
            J_().f11828c.a("Error inserting column. appId", dy.a(str), str4, e);
            e2.endTransaction();
            return j2;
        } catch (Throwable th2) {
            th = th2;
            e2.endTransaction();
            throw th;
        }
    }

    public final long B_() {
        return a("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long a(aj.g gVar) throws IOException {
        h();
        w();
        s.a(gVar);
        s.a(gVar.zzs);
        byte[] i2 = gVar.i();
        long a2 = G_().a(i2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", gVar.zzs);
        contentValues.put("metadata_fingerprint", Long.valueOf(a2));
        contentValues.put("metadata", i2);
        try {
            e().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return a2;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing raw event metadata. appId", dy.a(gVar.zzs), e2);
            throw e2;
        }
    }

    public final boolean C_() {
        return b("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean D_() {
        return b("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long g(String str) {
        s.a(str);
        return a("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0057  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(long r5) {
        /*
            r4 = this;
            r4.h()
            r4.w()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.e()     // Catch:{ SQLiteException -> 0x0041, all -> 0x003e }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0041, all -> 0x003e }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0041, all -> 0x003e }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0041, all -> 0x003e }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0041, all -> 0x003e }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003c }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.dy r6 = r4.J_()     // Catch:{ SQLiteException -> 0x003c }
            com.google.android.gms.measurement.internal.ea r6 = r6.k     // Catch:{ SQLiteException -> 0x003c }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.a(r1)     // Catch:{ SQLiteException -> 0x003c }
            if (r5 == 0) goto L_0x0031
            r5.close()
        L_0x0031:
            return r0
        L_0x0032:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003c }
            if (r5 == 0) goto L_0x003b
            r5.close()
        L_0x003b:
            return r6
        L_0x003c:
            r6 = move-exception
            goto L_0x0043
        L_0x003e:
            r6 = move-exception
            r5 = r0
            goto L_0x0055
        L_0x0041:
            r6 = move-exception
            r5 = r0
        L_0x0043:
            com.google.android.gms.measurement.internal.dy r1 = r4.J_()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11828c     // Catch:{ all -> 0x0054 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.a(r2, r6)     // Catch:{ all -> 0x0054 }
            if (r5 == 0) goto L_0x0053
            r5.close()
        L_0x0053:
            return r0
        L_0x0054:
            r6 = move-exception
        L_0x0055:
            if (r5 == 0) goto L_0x005a
            r5.close()
        L_0x005a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.a(long):java.lang.String");
    }

    public final long m() {
        Cursor cursor = null;
        try {
            cursor = e().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j2 = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j2;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error querying raw events", e2);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.aj.c, java.lang.Long> a(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.h()
            r7.w()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.e()     // Catch:{ SQLiteException -> 0x0078, all -> 0x0075 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0078, all -> 0x0075 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x0078, all -> 0x0075 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0078, all -> 0x0075 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0078, all -> 0x0075 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0078, all -> 0x0075 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0073 }
            if (r2 != 0) goto L_0x0035
            com.google.android.gms.measurement.internal.dy r8 = r7.J_()     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.measurement.internal.ea r8 = r8.k     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.String r9 = "Main event not found"
            r8.a(r9)     // Catch:{ SQLiteException -> 0x0073 }
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            return r0
        L_0x0035:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0073 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.internal.measurement.aj$c$a r4 = com.google.android.gms.internal.measurement.aj.c.c()     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.fe r2 = com.google.android.gms.measurement.internal.jn.a(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.aj$c$a r2 = (com.google.android.gms.internal.measurement.aj.c.a) r2     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.ff r2 = r2.w()     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.dv r2 = (com.google.android.gms.internal.measurement.dv) r2     // Catch:{ IOException -> 0x005d }
            com.google.android.gms.internal.measurement.aj$c r2 = (com.google.android.gms.internal.measurement.aj.c) r2     // Catch:{ IOException -> 0x005d }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0073 }
            if (r1 == 0) goto L_0x005c
            r1.close()
        L_0x005c:
            return r8
        L_0x005d:
            r2 = move-exception
            com.google.android.gms.measurement.internal.dy r3 = r7.J_()     // Catch:{ SQLiteException -> 0x0073 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ SQLiteException -> 0x0073 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0073 }
            r3.a(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0073 }
            if (r1 == 0) goto L_0x0072
            r1.close()
        L_0x0072:
            return r0
        L_0x0073:
            r8 = move-exception
            goto L_0x007a
        L_0x0075:
            r8 = move-exception
            r1 = r0
            goto L_0x008c
        L_0x0078:
            r8 = move-exception
            r1 = r0
        L_0x007a:
            com.google.android.gms.measurement.internal.dy r9 = r7.J_()     // Catch:{ all -> 0x008b }
            com.google.android.gms.measurement.internal.ea r9 = r9.f11828c     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "Error selecting main event"
            r9.a(r2, r8)     // Catch:{ all -> 0x008b }
            if (r1 == 0) goto L_0x008a
            r1.close()
        L_0x008a:
            return r0
        L_0x008b:
            r8 = move-exception
        L_0x008c:
            if (r1 == 0) goto L_0x0091
            r1.close()
        L_0x0091:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.d.a(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean a(String str, Long l, long j2, aj.c cVar) {
        h();
        w();
        s.a(cVar);
        s.a(str);
        s.a(l);
        byte[] i2 = cVar.i();
        J_().k.a("Saving complex main event, appId, data size", l().a(str), Integer.valueOf(i2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j2));
        contentValues.put("main_event", i2);
        try {
            if (e().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            J_().f11828c.a("Failed to insert complex main event (got -1). appId", dy.a(str));
            return false;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing complex main event. appId", dy.a(str), e2);
            return false;
        }
    }

    public final boolean a(l lVar, long j2, boolean z) {
        h();
        w();
        s.a(lVar);
        s.a(lVar.f12338a);
        aj.c.a b2 = aj.c.c().b(lVar.f12341d);
        Iterator<String> it2 = lVar.f12342e.iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            aj.e.a a2 = aj.e.d().a(next);
            G_().a(a2, lVar.f12342e.a(next));
            b2.a(a2);
        }
        byte[] i2 = ((aj.c) ((dv) b2.w())).i();
        J_().k.a("Saving event, name, data size", l().a(lVar.f12339b), Integer.valueOf(i2.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", lVar.f12338a);
        contentValues.put("name", lVar.f12339b);
        contentValues.put("timestamp", Long.valueOf(lVar.f12340c));
        contentValues.put("metadata_fingerprint", Long.valueOf(j2));
        contentValues.put("data", i2);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (e().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            J_().f11828c.a("Failed to insert raw event (got -1). appId", dy.a(lVar.f12338a));
            return false;
        } catch (SQLiteException e2) {
            J_().f11828c.a("Error storing raw event. appId", dy.a(lVar.f12338a), e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, List<ab.a> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<ab.a> list2 = list;
        s.a(list);
        for (int i2 = 0; i2 < list.size(); i2++) {
            ab.a.C0155a aVar = (ab.a.C0155a) list2.get(i2).m();
            if (aVar.b() != 0) {
                ab.a.C0155a aVar2 = aVar;
                for (int i3 = 0; i3 < aVar2.b(); i3++) {
                    ab.b.a aVar3 = (ab.b.a) aVar2.b(i3).m();
                    ab.b.a aVar4 = (ab.b.a) ((dv.b) aVar3.clone());
                    String b2 = fx.b(aVar3.a());
                    if (b2 != null) {
                        aVar4.a(b2);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    boolean z3 = z2;
                    for (int i4 = 0; i4 < aVar3.b(); i4++) {
                        ab.c a2 = aVar3.a(i4);
                        String a3 = ga.a(a2.zzg);
                        if (a3 != null) {
                            aVar4.a(i4, (ab.c) ((dv) ((ab.c.a) a2.m()).a(a3).w()));
                            z3 = true;
                        }
                    }
                    if (z3) {
                        aVar2 = aVar2.a(i3, aVar4);
                        list2.set(i2, (ab.a) ((dv) aVar2.w()));
                    }
                }
                aVar = aVar2;
            }
            if (aVar.a() != 0) {
                for (int i5 = 0; i5 < aVar.a(); i5++) {
                    ab.e a4 = aVar.a(i5);
                    String a5 = fz.a(a4.zze);
                    if (a5 != null) {
                        aVar = aVar.a(i5, ((ab.e.a) a4.m()).a(a5));
                        list2.set(i2, (ab.a) ((dv) aVar.w()));
                    }
                }
            }
        }
        w();
        h();
        s.a(str);
        s.a(list);
        SQLiteDatabase e2 = e();
        e2.beginTransaction();
        try {
            w();
            h();
            s.a(str);
            SQLiteDatabase e3 = e();
            e3.delete("property_filters", "app_id=?", new String[]{str2});
            e3.delete("event_filters", "app_id=?", new String[]{str2});
            for (ab.a next : list) {
                w();
                h();
                s.a(str);
                s.a(next);
                if (!next.a()) {
                    J_().f11831f.a("Audience with no ID. appId", dy.a(str));
                } else {
                    int i6 = next.zzd;
                    Iterator<ab.b> it2 = next.zzf.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().a()) {
                                J_().f11831f.a("Event filter with no ID. Audience definition ignored. appId, audienceId", dy.a(str), Integer.valueOf(i6));
                                break;
                            }
                        } else {
                            Iterator<ab.e> it3 = next.zze.iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!it3.next().a()) {
                                        J_().f11831f.a("Property filter with no ID. Audience definition ignored. appId, audienceId", dy.a(str), Integer.valueOf(i6));
                                        break;
                                    }
                                } else {
                                    Iterator<ab.b> it4 = next.zzf.iterator();
                                    while (true) {
                                        if (it4.hasNext()) {
                                            if (!a(str2, i6, it4.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<ab.e> it5 = next.zze.iterator();
                                        while (true) {
                                            if (it5.hasNext()) {
                                                if (!a(str2, i6, it5.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        w();
                                        h();
                                        s.a(str);
                                        SQLiteDatabase e4 = e();
                                        e4.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(i6)});
                                        e4.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(i6)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (ab.a next2 : list) {
                arrayList.add(next2.a() ? Integer.valueOf(next2.zzd) : null);
            }
            c(str2, (List<Integer>) arrayList);
            e2.setTransactionSuccessful();
        } finally {
            e2.endTransaction();
        }
    }

    private final boolean y() {
        return k().getDatabasePath("google_app_measurement.db").exists();
    }
}
