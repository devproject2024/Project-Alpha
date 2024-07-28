package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.ab;
import com.google.android.gms.internal.measurement.aj;
import com.google.android.gms.internal.measurement.dh;
import com.google.android.gms.internal.measurement.ed;
import com.google.android.gms.internal.measurement.eg;
import com.google.android.gms.internal.measurement.fe;
import com.google.android.gms.internal.measurement.ib;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import net.one97.paytm.upi.util.UpiContract;

public final class jn extends jg {
    jn(jj jjVar) {
        super(jjVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void a(aj.k.a aVar, Object obj) {
        s.a(obj);
        aVar.a().b().c();
        if (obj instanceof String) {
            aVar.b((String) obj);
        } else if (obj instanceof Long) {
            aVar.b(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.a(((Double) obj).doubleValue());
        } else {
            J_().f11828c.a("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(aj.e.a aVar, Object obj) {
        s.a(obj);
        aVar.a().b().c();
        if (obj instanceof String) {
            aVar.b((String) obj);
        } else if (obj instanceof Long) {
            aVar.a(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.a(((Double) obj).doubleValue());
        } else {
            J_().f11828c.a("Ignoring invalid (type) event param value", obj);
        }
    }

    static Object b(aj.c cVar, String str) {
        aj.e a2 = a(cVar, str);
        if (a2 == null) {
            return null;
        }
        if (a2.a()) {
            return a2.zze;
        }
        if (a2.b()) {
            return Long.valueOf(a2.zzf);
        }
        if (a2.c()) {
            return Double.valueOf(a2.zzh);
        }
        return null;
    }

    static void a(aj.c.a aVar, String str, Object obj) {
        List<aj.e> a2 = aVar.a();
        int i2 = 0;
        while (true) {
            if (i2 >= a2.size()) {
                i2 = -1;
                break;
            } else if (str.equals(a2.get(i2).zzd)) {
                break;
            } else {
                i2++;
            }
        }
        aj.e.a a3 = aj.e.d().a(str);
        if (obj instanceof Long) {
            a3.a(((Long) obj).longValue());
        }
        if (i2 >= 0) {
            aVar.a(i2, a3);
        } else {
            aVar.a(a3);
        }
    }

    /* access modifiers changed from: package-private */
    public final String a(aj.f fVar) {
        ed<aj.e> edVar;
        aj.f fVar2 = fVar;
        if (fVar2 == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (aj.g next : fVar2.zzc) {
            if (next != null) {
                a(sb, 1);
                sb.append("bundle {\n");
                if ((next.zzc & 1) != 0) {
                    a(sb, 1, "protocol_version", (Object) Integer.valueOf(next.zze));
                }
                a(sb, 1, "platform", (Object) next.zzm);
                if ((next.zzc & 16384) != 0) {
                    a(sb, 1, "gmp_version", (Object) Long.valueOf(next.zzu));
                }
                if ((next.zzc & 32768) != 0) {
                    a(sb, 1, "uploading_gmp_version", (Object) Long.valueOf(next.zzv));
                }
                if ((next.zzd & 16) != 0) {
                    a(sb, 1, "dynamite_version", (Object) Long.valueOf(next.zzas));
                }
                if ((next.zzc & 536870912) != 0) {
                    a(sb, 1, "config_version", (Object) Long.valueOf(next.zzak));
                }
                a(sb, 1, "gmp_app_id", (Object) next.zzac);
                a(sb, 1, "admob_app_id", (Object) next.zzap);
                a(sb, 1, "app_id", (Object) next.zzs);
                a(sb, 1, "app_version", (Object) next.zzt);
                if ((next.zzc & 33554432) != 0) {
                    a(sb, 1, "app_version_major", (Object) Integer.valueOf(next.zzag));
                }
                a(sb, 1, "firebase_instance_id", (Object) next.zzaf);
                if ((next.zzc & 524288) != 0) {
                    a(sb, 1, "dev_cert_hash", (Object) Long.valueOf(next.zzz));
                }
                a(sb, 1, "app_store", (Object) next.zzr);
                if ((next.zzc & 2) != 0) {
                    a(sb, 1, "upload_timestamp_millis", (Object) Long.valueOf(next.zzh));
                }
                if ((next.zzc & 4) != 0) {
                    a(sb, 1, "start_timestamp_millis", (Object) Long.valueOf(next.zzi));
                }
                if (next.a()) {
                    a(sb, 1, "end_timestamp_millis", (Object) Long.valueOf(next.zzj));
                }
                if ((next.zzc & 16) != 0) {
                    a(sb, 1, "previous_bundle_start_timestamp_millis", (Object) Long.valueOf(next.zzk));
                }
                if ((next.zzc & 32) != 0) {
                    a(sb, 1, "previous_bundle_end_timestamp_millis", (Object) Long.valueOf(next.zzl));
                }
                a(sb, 1, "app_instance_id", (Object) next.zzy);
                a(sb, 1, "resettable_device_id", (Object) next.zzw);
                a(sb, 1, "device_id", (Object) next.zzaj);
                a(sb, 1, "ds_id", (Object) next.zzam);
                if ((next.zzc & 131072) != 0) {
                    a(sb, 1, "limited_ad_tracking", (Object) Boolean.valueOf(next.zzx));
                }
                a(sb, 1, "os_version", (Object) next.zzn);
                a(sb, 1, "device_model", (Object) next.zzo);
                a(sb, 1, "user_default_language", (Object) next.zzp);
                if ((next.zzc & TarConstants.EOF_BLOCK) != 0) {
                    a(sb, 1, "time_zone_offset_minutes", (Object) Integer.valueOf(next.zzq));
                }
                if ((next.zzc & 1048576) != 0) {
                    a(sb, 1, "bundle_sequential_index", (Object) Integer.valueOf(next.zzaa));
                }
                if ((next.zzc & 8388608) != 0) {
                    a(sb, 1, "service_upload", (Object) Boolean.valueOf(next.zzad));
                }
                a(sb, 1, "health_monitor", (Object) next.zzab);
                if (((next.zzc & 1073741824) != 0) && next.zzal != 0) {
                    a(sb, 1, UpiContract.DeviceInfoColumns.ANDROID_ID, (Object) Long.valueOf(next.zzal));
                }
                if (next.b()) {
                    a(sb, 1, "retry_counter", (Object) Integer.valueOf(next.zzao));
                }
                ed<aj.k> edVar2 = next.zzg;
                if (edVar2 != null) {
                    for (aj.k next2 : edVar2) {
                        if (next2 != null) {
                            a(sb, 2);
                            sb.append("user_property {\n");
                            a(sb, 2, "set_timestamp_millis", (Object) next2.a() ? Long.valueOf(next2.zzd) : null);
                            a(sb, 2, "name", (Object) l().c(next2.zze));
                            a(sb, 2, "string_value", (Object) next2.zzf);
                            a(sb, 2, "int_value", (Object) next2.b() ? Long.valueOf(next2.zzg) : null);
                            a(sb, 2, "double_value", (Object) next2.c() ? Double.valueOf(next2.zzi) : null);
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                ed<aj.a> edVar3 = next.zzae;
                if (edVar3 != null) {
                    for (aj.a next3 : edVar3) {
                        if (next3 != null) {
                            a(sb, 2);
                            sb.append("audience_membership {\n");
                            if ((next3.zzc & 1) != 0) {
                                a(sb, 2, "audience_id", (Object) Integer.valueOf(next3.zzd));
                            }
                            if ((next3.zzc & 8) != 0) {
                                a(sb, 2, "new_audience", (Object) Boolean.valueOf(next3.zzg));
                            }
                            a(sb, "current_data", next3.a());
                            a(sb, "previous_data", next3.b());
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                ed<aj.c> edVar4 = next.zzf;
                if (edVar4 != null) {
                    for (aj.c next4 : edVar4) {
                        if (next4 != null) {
                            a(sb, 2);
                            sb.append("event {\n");
                            a(sb, 2, "name", (Object) l().a(next4.zze));
                            if (next4.b()) {
                                a(sb, 2, "timestamp_millis", (Object) Long.valueOf(next4.zzf));
                            }
                            if ((next4.zzc & 4) != 0) {
                                a(sb, 2, "previous_timestamp_millis", (Object) Long.valueOf(next4.zzg));
                            }
                            if ((next4.zzc & 8) != 0) {
                                a(sb, 2, "count", (Object) Integer.valueOf(next4.zzh));
                            }
                            if (!(next4.a() == 0 || (edVar = next4.zzd) == null)) {
                                Iterator<aj.e> it2 = edVar.iterator();
                                while (it2.hasNext()) {
                                    aj.e next5 = it2.next();
                                    if (next5 != null) {
                                        a(sb, 3);
                                        sb.append("param {\n");
                                        a(sb, 3, "name", (Object) l().b(next5.zzd));
                                        a(sb, 3, "string_value", (Object) next5.zze);
                                        Iterator<aj.e> it3 = it2;
                                        a(sb, 3, "int_value", (Object) next5.b() ? Long.valueOf(next5.zzf) : null);
                                        a(sb, 3, "double_value", (Object) next5.c() ? Double.valueOf(next5.zzh) : null);
                                        a(sb, 3);
                                        sb.append("}\n");
                                        it2 = it3;
                                    }
                                }
                            }
                            a(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                a(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String a(ab.b bVar) {
        if (bVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (bVar.a()) {
            a(sb, 0, "filter_id", (Object) Integer.valueOf(bVar.zzd));
        }
        a(sb, 0, "event_name", (Object) l().a(bVar.zze));
        String a2 = a(bVar.zzi, bVar.zzj, bVar.zzk);
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", (Object) a2);
        }
        a(sb, 1, "event_count_filter", bVar.b());
        sb.append("  filters {\n");
        for (ab.c a3 : bVar.zzf) {
            a(sb, 2, a3);
        }
        a(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String a(ab.e eVar) {
        if (eVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (eVar.a()) {
            a(sb, 0, "filter_id", (Object) Integer.valueOf(eVar.zzd));
        }
        a(sb, 0, "property_name", (Object) l().c(eVar.zze));
        String a2 = a(eVar.zzg, eVar.zzh, eVar.zzi);
        if (!a2.isEmpty()) {
            a(sb, 0, "filter_type", (Object) a2);
        }
        a(sb, 1, eVar.b());
        sb.append("}\n");
        return sb.toString();
    }

    private static String a(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private static void a(StringBuilder sb, String str, aj.i iVar) {
        Integer num;
        if (iVar != null) {
            a(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (iVar.zzd.size() != 0) {
                a(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long l : iVar.zzd) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (iVar.a() != 0) {
                a(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long l2 : iVar.zzc) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(l2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (iVar.b() != 0) {
                a(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (aj.b next : iVar.zze) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next.a() ? Integer.valueOf(next.zzd) : null);
                    sb.append(AppConstants.COLON);
                    sb.append(next.b() ? Long.valueOf(next.zze) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (iVar.c() != 0) {
                a(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (aj.j next2 : iVar.zzf) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    if (next2.a()) {
                        num = Integer.valueOf(next2.zzd);
                    } else {
                        num = null;
                    }
                    sb.append(num);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : next2.zze) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            a(sb, 3);
            sb.append("}\n");
        }
    }

    private static void a(StringBuilder sb, int i2, String str, ab.d dVar) {
        if (dVar != null) {
            a(sb, i2);
            sb.append(str);
            sb.append(" {\n");
            if (dVar.a()) {
                a(sb, i2, "comparison_type", (Object) dVar.b().name());
            }
            if (dVar.c()) {
                a(sb, i2, "match_as_float", (Object) Boolean.valueOf(dVar.zze));
            }
            a(sb, i2, "comparison_value", (Object) dVar.zzf);
            a(sb, i2, "min_comparison_value", (Object) dVar.zzg);
            a(sb, i2, "max_comparison_value", (Object) dVar.zzh);
            a(sb, i2);
            sb.append("}\n");
        }
    }

    private final void a(StringBuilder sb, int i2, ab.c cVar) {
        if (cVar != null) {
            a(sb, i2);
            sb.append("filter {\n");
            if (cVar.e()) {
                a(sb, i2, "complement", (Object) Boolean.valueOf(cVar.zzf));
            }
            a(sb, i2, "param_name", (Object) l().b(cVar.zzg));
            int i3 = i2 + 1;
            ab.f b2 = cVar.b();
            if (b2 != null) {
                a(sb, i3);
                sb.append("string_filter");
                sb.append(" {\n");
                if (b2.a()) {
                    a(sb, i3, "match_type", (Object) b2.b().name());
                }
                a(sb, i3, "expression", (Object) b2.zze);
                if ((b2.zzc & 4) != 0) {
                    a(sb, i3, "case_sensitive", (Object) Boolean.valueOf(b2.zzf));
                }
                if (b2.d() > 0) {
                    a(sb, i3 + 1);
                    sb.append("expression_list {\n");
                    for (String append : b2.zzg) {
                        a(sb, i3 + 2);
                        sb.append(append);
                        sb.append(StringUtility.NEW_LINE);
                    }
                    sb.append("}\n");
                }
                a(sb, i3);
                sb.append("}\n");
            }
            a(sb, i3, "number_filter", cVar.d());
            a(sb, i2);
            sb.append("}\n");
        }
    }

    private static void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("  ");
        }
    }

    private static void a(StringBuilder sb, int i2, String str, Object obj) {
        if (obj != null) {
            a(sb, i2 + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        J_().f11828c.a("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002a, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T a(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ a -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ a -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ a -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ a -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ a -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002b
        L_0x001c:
            com.google.android.gms.measurement.internal.dy r5 = r4.J_()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.ea r5 = r5.f11828c     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.a(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002b:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jn.a(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    public final boolean a(zzan zzan, zzm zzm) {
        s.a(zzan);
        s.a(zzm);
        ib.a();
        if (H_().d((String) null, o.aJ)) {
            if (!TextUtils.isEmpty(zzm.f12381b) || !TextUtils.isEmpty(zzm.r)) {
                return true;
            }
            return false;
        } else if (!TextUtils.isEmpty(zzm.f12381b) || !TextUtils.isEmpty(zzm.r)) {
            return true;
        } else {
            return false;
        }
    }

    static boolean a(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean a(List<Long> list, int i2) {
        if (i2 >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i2 % 64)) & list.get(i2 / 64).longValue()) != 0;
    }

    static List<Long> a(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            long j = 0;
            for (int i3 = 0; i3 < 64; i3++) {
                int i4 = (i2 << 6) + i3;
                if (i4 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i4)) {
                    j |= 1 << i3;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<Long> a(List<Long> list, List<Integer> list2) {
        int i2;
        ArrayList arrayList = new ArrayList(list);
        for (Integer next : list2) {
            if (next.intValue() < 0) {
                J_().f11831f.a("Ignoring negative bit index to be cleared", next);
            } else {
                int intValue = next.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    J_().f11831f.a("Ignoring bit index greater than bitSet size", next, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (next.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i3 = size2;
            i2 = size;
            size = i3;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i2);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(j().a() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final long a(byte[] bArr) {
        s.a(bArr);
        L_().h();
        MessageDigest e2 = jq.e();
        if (e2 != null) {
            return jq.a(e2.digest(bArr));
        }
        J_().f11828c.a("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final byte[] b(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[TarConstants.EOF_BLOCK];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            J_().f11828c.a("Failed to ungzip content", e2);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] c(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            J_().f11828c.a("Failed to gzip content", e2);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public final List<Integer> b() {
        Map<String, String> a2 = o.a(this.f12261b.k());
        if (a2 == null || a2.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = o.M.a(null).intValue();
        Iterator<Map.Entry<String, String>> it2 = a2.entrySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry next = it2.next();
            if (((String) next.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            J_().f11831f.a("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e2) {
                    J_().f11831f.a("Experiment ID NumberFormatException", e2);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    static <Builder extends fe> Builder a(Builder builder, byte[] bArr) throws eg {
        dh b2 = dh.b();
        if (b2 != null) {
            return builder.a(bArr, b2);
        }
        return builder.a(bArr);
    }

    static int a(aj.g.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i2 = 0; i2 < aVar.f(); i2++) {
            if (str.equals(aVar.c(i2).zze)) {
                return i2;
            }
        }
        return -1;
    }

    public final /* bridge */ /* synthetic */ jn G_() {
        return super.G_();
    }

    public final /* bridge */ /* synthetic */ jv d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ d F_() {
        return super.F_();
    }

    public final /* bridge */ /* synthetic */ ev E_() {
        return super.E_();
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }

    static aj.e a(aj.c cVar, String str) {
        for (aj.e next : cVar.zzd) {
            if (next.zzd.equals(str)) {
                return next;
            }
        }
        return null;
    }
}
