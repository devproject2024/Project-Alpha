package com.google.android.gms.internal.firebase_ml;

import com.alipay.mobile.h5container.api.H5ErrorCode;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.gms.internal.firebase_ml.ep;
import com.google.android.gms.internal.firebase_ml.gg;
import com.google.android.gms.internal.firebase_ml.t;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class bg {

    public static final class a extends gg<a, C0143a> implements hp {
        /* access modifiers changed from: private */
        public static final a zzamx;
        private static volatile hz<a> zzh;
        private b zzamu;
        private int zzamv;
        private c zzamw;
        private int zzj;

        private a() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.bg$a$a  reason: collision with other inner class name */
        public static final class C0143a extends gg.b<a, C0143a> implements hp {
            private C0143a() {
                super(a.zzamx);
            }

            /* synthetic */ C0143a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new a();
                case 2:
                    return new C0143a((byte) 0);
                case 3:
                    return a((hn) zzamx, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzamu", "zzamv", "zzamw"});
                case 4:
                    return zzamx;
                case 5:
                    hz<a> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (a.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzamx);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends gg<b, C0144a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzanc;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private l zzanb;
            private int zzj;

            private b() {
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new C0144a((byte) 0);
                    case 3:
                        return a((hn) zzanc, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzj", "zzamy", bq.zzf(), "zzamz", "zzana", "zzanb"});
                    case 4:
                        return zzanc;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzanc);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.bg$a$b$a  reason: collision with other inner class name */
            public static final class C0144a extends gg.b<b, C0144a> implements hp {
                private C0144a() {
                    super(b.zzanc);
                }

                /* synthetic */ C0144a(byte b2) {
                    this();
                }
            }

            static {
                b bVar = new b();
                zzanc = bVar;
                gg.a(b.class, bVar);
            }
        }

        static {
            a aVar = new a();
            zzamx = aVar;
            gg.a(a.class, aVar);
        }
    }

    public static final class ab extends gg<ab, a> implements hp {
        /* access modifiers changed from: private */
        public static final ab zzane;
        private static volatile hz<ab> zzh;
        private int zzamv;
        private c zzamw;
        private b zzand;
        private int zzj;

        private ab() {
        }

        public static final class a extends gg.b<ab, a> implements hp {
            private a() {
                super(ab.zzane);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ab();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzane, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzand", "zzamv", "zzamw"});
                case 4:
                    return zzane;
                case 5:
                    hz<ab> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ab.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzane);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ab abVar = new ab();
            zzane = abVar;
            gg.a(ab.class, abVar);
        }

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzanh;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private l zzanb;
            private gq<bc.b> zzanf = ia.a();
            private gq<bc.b> zzang = ia.a();
            private int zzj;

            private b() {
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzanh);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzanh, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003\u001b\u0004\u001b\u0005ဉ\u0002", new Object[]{"zzj", "zzamy", bq.zzf(), "zzamz", "zzanf", bc.b.class, "zzang", bc.b.class, "zzanb"});
                    case 4:
                        return zzanh;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzanh);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                b bVar = new b();
                zzanh = bVar;
                gg.a(b.class, bVar);
            }
        }
    }

    public static final class ac extends gg<ac, a> implements hp {
        /* access modifiers changed from: private */
        public static final ac zzbfr;
        private static volatile hz<ac> zzh;
        private g zzaoq;
        private af zzbfk;
        private int zzbfl;
        private int zzbfm;
        private int zzbfn;
        private int zzbfo;
        private int zzbfp;
        private int zzbfq;
        private int zzj;

        public enum b implements gj {
            NO_ERROR(0),
            METADATA_FILE_UNAVAILABLE(1),
            METADATA_ENTRY_NOT_FOUND(2),
            METADATA_JSON_INVALID(3),
            METADATA_HASH_NOT_FOUND(4),
            DOWNLOAD_MANAGER_SERVICE_MISSING(5),
            DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS(6),
            DOWNLOAD_MANAGER_HTTP_BAD_REQUEST(400),
            DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED(401),
            DOWNLOAD_MANAGER_HTTP_FORBIDDEN(403),
            DOWNLOAD_MANAGER_HTTP_NOT_FOUND(H5ErrorCode.HTTP_NOT_FOUND),
            DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT(408),
            DOWNLOAD_MANAGER_HTTP_ABORTED(H5ErrorCode.HTTP_CONFLICT),
            DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS(429),
            DOWNLOAD_MANAGER_HTTP_CANCELLED(499),
            DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED(H5ErrorCode.HTTP_NOT_IMPLEMENTED),
            DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR(500),
            DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE(H5ErrorCode.HTTP_SERVICE_UNAVAILABLE),
            DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED(504),
            DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED(511),
            DOWNLOAD_MANAGER_FILE_ERROR(7),
            DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE(8),
            DOWNLOAD_MANAGER_HTTP_DATA_ERROR(9),
            DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS(10),
            DOWNLOAD_MANAGER_INSUFFICIENT_SPACE(11),
            DOWNLOAD_MANAGER_DEVICE_NOT_FOUND(12),
            DOWNLOAD_MANAGER_CANNOT_RESUME(13),
            DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS(14),
            DOWNLOAD_MANAGER_UNKNOWN_ERROR(15),
            POST_DOWNLOAD_FILE_NOT_FOUND(16),
            POST_DOWNLOAD_MOVE_FILE_FAILED(17),
            POST_DOWNLOAD_UNZIP_FAILED(18),
            RAPID_RESPONSE_COULD_NOT_BE_WRITTEN(19),
            DRIVER_OBJECT_DEALLOCATED(20);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzbr(int i2) {
                if (i2 == 400) {
                    return DOWNLOAD_MANAGER_HTTP_BAD_REQUEST;
                }
                if (i2 == 401) {
                    return DOWNLOAD_MANAGER_HTTP_UNAUTHORIZED;
                }
                if (i2 == 403) {
                    return DOWNLOAD_MANAGER_HTTP_FORBIDDEN;
                }
                if (i2 == 404) {
                    return DOWNLOAD_MANAGER_HTTP_NOT_FOUND;
                }
                if (i2 == 408) {
                    return DOWNLOAD_MANAGER_HTTP_REQUEST_TIMEOUT;
                }
                if (i2 == 409) {
                    return DOWNLOAD_MANAGER_HTTP_ABORTED;
                }
                if (i2 == 429) {
                    return DOWNLOAD_MANAGER_HTTP_TOO_MANY_REQUESTS;
                }
                if (i2 == 511) {
                    return DOWNLOAD_MANAGER_HTTP_NETWORK_AUTHENTICATION_REQUIRED;
                }
                if (i2 == 503) {
                    return DOWNLOAD_MANAGER_HTTP_SERVICE_UNAVAILABLE;
                }
                if (i2 == 504) {
                    return DOWNLOAD_MANAGER_HTTP_DEADLINE_EXCEEDED;
                }
                switch (i2) {
                    case 0:
                        return NO_ERROR;
                    case 1:
                        return METADATA_FILE_UNAVAILABLE;
                    case 2:
                        return METADATA_ENTRY_NOT_FOUND;
                    case 3:
                        return METADATA_JSON_INVALID;
                    case 4:
                        return METADATA_HASH_NOT_FOUND;
                    case 5:
                        return DOWNLOAD_MANAGER_SERVICE_MISSING;
                    case 6:
                        return DOWNLOAD_MANAGER_HTTP_UNKNOWN_STATUS;
                    case 7:
                        return DOWNLOAD_MANAGER_FILE_ERROR;
                    case 8:
                        return DOWNLOAD_MANAGER_UNHANDLED_HTTP_CODE;
                    case 9:
                        return DOWNLOAD_MANAGER_HTTP_DATA_ERROR;
                    case 10:
                        return DOWNLOAD_MANAGER_TOO_MANY_REDIRECTS;
                    case 11:
                        return DOWNLOAD_MANAGER_INSUFFICIENT_SPACE;
                    case 12:
                        return DOWNLOAD_MANAGER_DEVICE_NOT_FOUND;
                    case 13:
                        return DOWNLOAD_MANAGER_CANNOT_RESUME;
                    case 14:
                        return DOWNLOAD_MANAGER_FILE_ALREADY_EXISTS;
                    case 15:
                        return DOWNLOAD_MANAGER_UNKNOWN_ERROR;
                    case 16:
                        return POST_DOWNLOAD_FILE_NOT_FOUND;
                    case 17:
                        return POST_DOWNLOAD_MOVE_FILE_FAILED;
                    case 18:
                        return POST_DOWNLOAD_UNZIP_FAILED;
                    case 19:
                        return RAPID_RESPONSE_COULD_NOT_BE_WRITTEN;
                    case 20:
                        return DRIVER_OBJECT_DEALLOCATED;
                    default:
                        switch (i2) {
                            case 499:
                                return DOWNLOAD_MANAGER_HTTP_CANCELLED;
                            case 500:
                                return DOWNLOAD_MANAGER_HTTP_INTERNAL_SERVICE_ERROR;
                            case H5ErrorCode.HTTP_NOT_IMPLEMENTED /*501*/:
                                return DOWNLOAD_MANAGER_HTTP_UNIMPLEMENTED;
                            default:
                                return null;
                        }
                }
            }

            public static gl zzf() {
                return da.f9795a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cz();
            }
        }

        private ac() {
        }

        public static final class a extends gg.b<ac, a> implements hp {
            private a() {
                super(ac.zzbfr);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ac();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbfr, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006င\u0005\u0007ဌ\u0006\bင\u0007", new Object[]{"zzj", "zzaoq", "zzbfk", "zzbfl", "zzbfm", "zzbfn", "zzbfo", "zzbfp", b.zzf(), "zzbfq"});
                case 4:
                    return zzbfr;
                case 5:
                    hz<ac> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ac.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbfr);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ac acVar = new ac();
            zzbfr = acVar;
            gg.a(ac.class, acVar);
        }
    }

    public static final class ad extends gg<ad, a> implements hp {
        private static final go<Integer, b> zzbhc = new dc();
        private static final go<Integer, b> zzbhe = new db();
        private static final go<Integer, b> zzbhg = new dd();
        /* access modifiers changed from: private */
        public static final ad zzbhi;
        private static volatile hz<ad> zzh;
        private long zzazi;
        private gn zzbhb = gi.a();
        private gn zzbhd = gi.a();
        private gn zzbhf = gi.a();
        private int zzbhh;
        private int zzj;

        public enum b implements gj {
            UNKNOWN_ERROR(0),
            NO_CONNECTION(1),
            RPC_ERROR(2),
            RPC_RETURNED_INVALID_RESULT(3),
            RPC_RETURNED_MALFORMED_RESULT(4),
            RPC_EXPONENTIAL_BACKOFF_FAILED(5),
            DIRECTORY_CREATION_FAILED(10),
            FILE_WRITE_FAILED_DISK_FULL(11),
            FILE_WRITE_FAILED(12),
            FILE_READ_FAILED(13),
            FILE_READ_RETURNED_INVALID_DATA(14),
            FILE_READ_RETURNED_MALFORMED_DATA(15);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzbs(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_ERROR;
                }
                if (i2 == 1) {
                    return NO_CONNECTION;
                }
                if (i2 == 2) {
                    return RPC_ERROR;
                }
                if (i2 == 3) {
                    return RPC_RETURNED_INVALID_RESULT;
                }
                if (i2 == 4) {
                    return RPC_RETURNED_MALFORMED_RESULT;
                }
                if (i2 == 5) {
                    return RPC_EXPONENTIAL_BACKOFF_FAILED;
                }
                switch (i2) {
                    case 10:
                        return DIRECTORY_CREATION_FAILED;
                    case 11:
                        return FILE_WRITE_FAILED_DISK_FULL;
                    case 12:
                        return FILE_WRITE_FAILED;
                    case 13:
                        return FILE_READ_FAILED;
                    case 14:
                        return FILE_READ_RETURNED_INVALID_DATA;
                    case 15:
                        return FILE_READ_RETURNED_MALFORMED_DATA;
                    default:
                        return null;
                }
            }

            public static gl zzf() {
                return df.f9796a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new de();
            }
        }

        private ad() {
        }

        public static final class a extends gg.b<ad, a> implements hp {
            private a() {
                super(ad.zzbhi);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ad();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbhi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဃ\u0000\u0002\u001e\u0003\u001e\u0004\u001e\u0005င\u0001", new Object[]{"zzj", "zzazi", "zzbhb", b.zzf(), "zzbhd", b.zzf(), "zzbhf", b.zzf(), "zzbhh"});
                case 4:
                    return zzbhi;
                case 5:
                    hz<ad> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ad.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbhi);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ad adVar = new ad();
            zzbhi = adVar;
            gg.a(ad.class, adVar);
        }
    }

    public static final class af extends gg<af, a> implements hp {
        /* access modifiers changed from: private */
        public static final af zzbik;
        private static volatile hz<af> zzh;
        private String zzbii = "";
        private String zzbij = "";
        private int zzj;

        private af() {
        }

        public static final class a extends gg.b<af, a> implements hp {
            private a() {
                super(af.zzbik);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new af();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbik, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzj", "zzbii", "zzbij"});
                case 4:
                    return zzbik;
                case 5:
                    hz<af> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (af.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbik);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            af afVar = new af();
            zzbik = afVar;
            gg.a(af.class, afVar);
        }
    }

    public static final class ag extends gg<ag, a> implements hp {
        /* access modifiers changed from: private */
        public static final ag zzanj;
        private static volatile hz<ag> zzh;
        private int zzamv;
        private c zzamw;
        private b zzani;
        private int zzj;

        private ag() {
        }

        public static final class a extends gg.b<ag, a> implements hp {
            private a() {
                super(ag.zzanj);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static final class b extends gg<b, a> implements hp {
            private static final go<Integer, n.a> zzann = new bh();
            private static final go<Integer, n.b> zzanp = new bi();
            /* access modifiers changed from: private */
            public static final b zzanq;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private boolean zzank;
            private ep.a zzanl;
            private gn zzanm = gi.a();
            private gn zzano = gi.a();
            private int zzj;

            private b() {
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzanq);
                }

                public final a a(bq bqVar) {
                    if (this.f9920b) {
                        d();
                        this.f9920b = false;
                    }
                    b.a((b) this.f9919a, bqVar);
                    return this;
                }

                public final a a(boolean z) {
                    if (this.f9920b) {
                        d();
                        this.f9920b = false;
                    }
                    b.a((b) this.f9919a, z);
                    return this;
                }

                public final a a(f fVar) {
                    if (this.f9920b) {
                        d();
                        this.f9920b = false;
                    }
                    b.a((b) this.f9919a, fVar);
                    return this;
                }

                public final a a(ep.a aVar) {
                    if (this.f9920b) {
                        d();
                        this.f9920b = false;
                    }
                    b.a((b) this.f9919a, aVar);
                    return this;
                }

                public final a a(Iterable<? extends n.a> iterable) {
                    if (this.f9920b) {
                        d();
                        this.f9920b = false;
                    }
                    b.a((b) this.f9919a, (Iterable) iterable);
                    return this;
                }

                public final a b(Iterable<? extends n.b> iterable) {
                    if (this.f9920b) {
                        d();
                        this.f9920b = false;
                    }
                    b.b((b) this.f9919a, iterable);
                    return this;
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            public static a a() {
                return (a) zzanq.g();
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzanq, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004\u0006\u001e\u0007\u001e", new Object[]{"zzj", "zzamy", bq.zzf(), "zzank", "zzamz", "zzana", "zzanl", "zzanm", n.a.zzf(), "zzano", n.b.zzf()});
                    case 4:
                        return zzanq;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzanq);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                b bVar = new b();
                zzanq = bVar;
                gg.a(b.class, bVar);
            }

            static /* synthetic */ void a(b bVar, bq bqVar) {
                bVar.zzamy = bqVar.zzd();
                bVar.zzj |= 1;
            }

            static /* synthetic */ void a(b bVar, boolean z) {
                bVar.zzj |= 4;
                bVar.zzamz = z;
            }

            static /* synthetic */ void a(b bVar, f fVar) {
                fVar.getClass();
                bVar.zzana = fVar;
                bVar.zzj |= 8;
            }

            static /* synthetic */ void a(b bVar, ep.a aVar) {
                aVar.getClass();
                bVar.zzanl = aVar;
                bVar.zzj |= 16;
            }

            static /* synthetic */ void a(b bVar, Iterable iterable) {
                if (!bVar.zzanm.c()) {
                    bVar.zzanm = gg.a(bVar.zzanm);
                }
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    bVar.zzanm.c(((n.a) it2.next()).zzd());
                }
            }

            static /* synthetic */ void b(b bVar, Iterable iterable) {
                if (!bVar.zzano.c()) {
                    bVar.zzano = gg.a(bVar.zzano);
                }
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    bVar.zzano.c(((n.b) it2.next()).zzd());
                }
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ag();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzanj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzani", "zzamv", "zzamw"});
                case 4:
                    return zzanj;
                case 5:
                    hz<ag> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ag.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzanj);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ag agVar = new ag();
            zzanj = agVar;
            gg.a(ag.class, agVar);
        }
    }

    public static final class ah extends gg<ah, a> implements hp {
        /* access modifiers changed from: private */
        public static final ah zzans;
        private static volatile hz<ah> zzh;
        private int zzamv;
        private c zzamw;
        private b zzanr;
        private int zzj;

        private ah() {
        }

        public static final class a extends gg.b<ah, a> implements hp {
            private a() {
                super(ah.zzans);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ah();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzans, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzanr", "zzamv", "zzamw"});
                case 4:
                    return zzans;
                case 5:
                    hz<ah> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ah.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzans);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzanw;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private d zzant;
            private int zzanu;
            private int zzanv;
            private int zzj;

            private b() {
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzanw, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzj", "zzamy", bq.zzf(), "zzamz", "zzana", "zzant", "zzanu", "zzanv"});
                    case 4:
                        return zzanw;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzanw);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzanw);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            static {
                b bVar = new b();
                zzanw = bVar;
                gg.a(b.class, bVar);
            }
        }

        static {
            ah ahVar = new ah();
            zzans = ahVar;
            gg.a(ah.class, ahVar);
        }
    }

    public static final class ai extends gg<ai, a> implements hp {
        /* access modifiers changed from: private */
        public static final ai zzany;
        private static volatile hz<ai> zzh;
        private int zzamv;
        private c zzamw;
        private b zzanx;
        private int zzj;

        private ai() {
        }

        public static final class a extends gg.b<ai, a> implements hp {
            private a() {
                super(ai.zzany);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ai();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzany, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzanx", "zzamv", "zzamw"});
                case 4:
                    return zzany;
                case 5:
                    hz<ai> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ai.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzany);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzaoa;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private q zzanz;
            private int zzj;

            private b() {
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzaoa, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzj", "zzamy", bq.zzf(), "zzamz", "zzana", "zzanz"});
                    case 4:
                        return zzaoa;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzaoa);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzaoa);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            static {
                b bVar = new b();
                zzaoa = bVar;
                gg.a(b.class, bVar);
            }
        }

        static {
            ai aiVar = new ai();
            zzany = aiVar;
            gg.a(ai.class, aiVar);
        }
    }

    public static final class aj extends gg<aj, a> implements hp {
        /* access modifiers changed from: private */
        public static final aj zzaoc;
        private static volatile hz<aj> zzh;
        private int zzamv;
        private c zzamw;
        private b zzaob;
        private int zzj;

        private aj() {
        }

        public static final class a extends gg.b<aj, a> implements hp {
            private a() {
                super(aj.zzaoc);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new aj();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaoc, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaob", "zzamv", "zzamw"});
                case 4:
                    return zzaoc;
                case 5:
                    hz<aj> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (aj.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaoc);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzaoe;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private boolean zzank;
            private t zzaod;
            private int zzj;

            private b() {
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzaoe, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzj", "zzamy", bq.zzf(), "zzank", "zzamz", "zzana", "zzaod"});
                    case 4:
                        return zzaoe;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzaoe);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzaoe);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            static {
                b bVar = new b();
                zzaoe = bVar;
                gg.a(b.class, bVar);
            }
        }

        static {
            aj ajVar = new aj();
            zzaoc = ajVar;
            gg.a(aj.class, ajVar);
        }
    }

    public static final class ak extends gg<ak, a> implements hp {
        /* access modifiers changed from: private */
        public static final ak zzaog;
        private static volatile hz<ak> zzh;
        private int zzamv;
        private c zzamw;
        private b zzaof;
        private int zzj;

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzaoi;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private x zzaoh;
            private int zzj;

            private b() {
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzaoi);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzaoi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzj", "zzamy", bq.zzf(), "zzamz", "zzana", "zzaoh"});
                    case 4:
                        return zzaoi;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzaoi);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                b bVar = new b();
                zzaoi = bVar;
                gg.a(b.class, bVar);
            }
        }

        private ak() {
        }

        public static final class a extends gg.b<ak, a> implements hp {
            private a() {
                super(ak.zzaog);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ak();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaog, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaof", "zzamv", "zzamw"});
                case 4:
                    return zzaog;
                case 5:
                    hz<ak> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ak.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaog);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ak akVar = new ak();
            zzaog = akVar;
            gg.a(ak.class, akVar);
        }
    }

    public static final class al extends gg<al, a> implements hp {
        /* access modifiers changed from: private */
        public static final al zzaok;
        private static volatile hz<al> zzh;
        private int zzamv;
        private c zzamw;
        private b zzaoj;
        private int zzj;

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzaol;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private int zzj;

            private b() {
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzaol);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzaol, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzamy", bq.zzf(), "zzamz", "zzana"});
                    case 4:
                        return zzaol;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzaol);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                b bVar = new b();
                zzaol = bVar;
                gg.a(b.class, bVar);
            }
        }

        private al() {
        }

        public static final class a extends gg.b<al, a> implements hp {
            private a() {
                super(al.zzaok);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new al();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaok, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoj", "zzamv", "zzamw"});
                case 4:
                    return zzaok;
                case 5:
                    hz<al> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (al.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaok);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            al alVar = new al();
            zzaok = alVar;
            gg.a(al.class, alVar);
        }
    }

    public static final class am extends gg<am, a> implements hp {
        /* access modifiers changed from: private */
        public static final am zzaon;
        private static volatile hz<am> zzh;
        private int zzamv;
        private c zzamw;
        private b zzaom;
        private int zzj;

        private am() {
        }

        public static final class a extends gg.b<am, a> implements hp {
            private a() {
                super(am.zzaon);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new am();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaon, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaom", "zzamv", "zzamw"});
                case 4:
                    return zzaon;
                case 5:
                    hz<am> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (am.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaon);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzaoo;
            private static volatile hz<b> zzh;
            private int zzamy;
            private boolean zzamz;
            private f zzana;
            private boolean zzank;
            private int zzj;

            private b() {
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzaoo, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဉ\u0003", new Object[]{"zzj", "zzamy", bq.zzf(), "zzank", "zzamz", "zzana"});
                    case 4:
                        return zzaoo;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzaoo);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzaoo);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            static {
                b bVar = new b();
                zzaoo = bVar;
                gg.a(b.class, bVar);
            }
        }

        static {
            am amVar = new am();
            zzaon = amVar;
            gg.a(am.class, amVar);
        }
    }

    public static final class aq extends gg<aq, a> implements hp {
        /* access modifiers changed from: private */
        public static final aq zzaoz;
        private static volatile hz<aq> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private aq() {
        }

        public static final class a extends gg.b<aq, a> implements hp {
            private a() {
                super(aq.zzaoz);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new aq();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaoz, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzaoz;
                case 5:
                    hz<aq> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (aq.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaoz);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            aq aqVar = new aq();
            zzaoz = aqVar;
            gg.a(aq.class, aqVar);
        }
    }

    public static final class ar extends gg<ar, b> implements hp {
        /* access modifiers changed from: private */
        public static final ar zzapb;
        private static volatile hz<ar> zzh;
        private int zzapa;
        private int zzer;
        private int zzj;

        public enum a implements gj {
            UNKNOWN_MODEL_TYPE(0),
            STABLE_MODEL(1),
            LATEST_MODEL(2);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzat(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_MODEL_TYPE;
                }
                if (i2 == 1) {
                    return STABLE_MODEL;
                }
                if (i2 != 2) {
                    return null;
                }
                return LATEST_MODEL;
            }

            public static gl zzf() {
                return bk.f9766a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new bl();
            }
        }

        private ar() {
        }

        public static final class b extends gg.b<ar, b> implements hp {
            private b() {
                super(ar.zzapb);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ar();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzapb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဌ\u0001", new Object[]{"zzj", "zzer", "zzapa", a.zzf()});
                case 4:
                    return zzapb;
                case 5:
                    hz<ar> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ar.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapb);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ar arVar = new ar();
            zzapb = arVar;
            gg.a(ar.class, arVar);
        }
    }

    public static final class as extends gg<as, a> implements hp {
        /* access modifiers changed from: private */
        public static final as zzapg;
        private static volatile hz<as> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private as() {
        }

        public static final class a extends gg.b<as, a> implements hp {
            private a() {
                super(as.zzapg);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new as();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapg;
                case 5:
                    hz<as> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (as.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapg);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            as asVar = new as();
            zzapg = asVar;
            gg.a(as.class, asVar);
        }
    }

    public static final class at extends gg<at, a> implements hp {
        /* access modifiers changed from: private */
        public static final at zzaph;
        private static volatile hz<at> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private at() {
        }

        public static final class a extends gg.b<at, a> implements hp {
            private a() {
                super(at.zzaph);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new at();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaph, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzaph;
                case 5:
                    hz<at> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (at.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaph);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            at atVar = new at();
            zzaph = atVar;
            gg.a(at.class, atVar);
        }
    }

    public static final class au extends gg<au, a> implements hp {
        /* access modifiers changed from: private */
        public static final au zzapi;
        private static volatile hz<au> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private au() {
        }

        public static final class a extends gg.b<au, a> implements hp {
            private a() {
                super(au.zzapi);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new au();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapi, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapi;
                case 5:
                    hz<au> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (au.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapi);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            au auVar = new au();
            zzapi = auVar;
            gg.a(au.class, auVar);
        }
    }

    public static final class av extends gg<av, a> implements hp {
        /* access modifiers changed from: private */
        public static final av zzapj;
        private static volatile hz<av> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private av() {
        }

        public static final class a extends gg.b<av, a> implements hp {
            private a() {
                super(av.zzapj);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new av();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapj;
                case 5:
                    hz<av> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (av.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapj);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            av avVar = new av();
            zzapj = avVar;
            gg.a(av.class, avVar);
        }
    }

    public static final class aw extends gg<aw, a> implements hp {
        /* access modifiers changed from: private */
        public static final aw zzapk;
        private static volatile hz<aw> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private aw() {
        }

        public static final class a extends gg.b<aw, a> implements hp {
            private a() {
                super(aw.zzapk);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new aw();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapk, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapk;
                case 5:
                    hz<aw> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (aw.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapk);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            aw awVar = new aw();
            zzapk = awVar;
            gg.a(aw.class, awVar);
        }
    }

    public static final class ax extends gg<ax, a> implements hp {
        /* access modifiers changed from: private */
        public static final ax zzapl;
        private static volatile hz<ax> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private ax() {
        }

        public static final class a extends gg.b<ax, a> implements hp {
            private a() {
                super(ax.zzapl);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ax();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapl;
                case 5:
                    hz<ax> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ax.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapl);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ax axVar = new ax();
            zzapl = axVar;
            gg.a(ax.class, axVar);
        }
    }

    public static final class ay extends gg<ay, a> implements hp {
        /* access modifiers changed from: private */
        public static final ay zzapm;
        private static volatile hz<ay> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private ay() {
        }

        public static final class a extends gg.b<ay, a> implements hp {
            private a() {
                super(ay.zzapm);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ay();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapm, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapm;
                case 5:
                    hz<ay> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ay.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapm);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ay ayVar = new ay();
            zzapm = ayVar;
            gg.a(ay.class, ayVar);
        }
    }

    public static final class az extends gg<az, a> implements hp {
        /* access modifiers changed from: private */
        public static final az zzapn;
        private static volatile hz<az> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private az() {
        }

        public static final class a extends gg.b<az, a> implements hp {
            private a() {
                super(az.zzapn);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new az();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapn, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapn;
                case 5:
                    hz<az> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (az.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapn);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            az azVar = new az();
            zzapn = azVar;
            gg.a(az.class, azVar);
        }
    }

    public static final class ba extends gg<ba, a> implements hp {
        /* access modifiers changed from: private */
        public static final ba zzapo;
        private static volatile hz<ba> zzh;
        private f zzana;
        private g zzaoq;
        private ar zzaoy;
        private int zzj;

        private ba() {
        }

        public static final class a extends gg.b<ba, a> implements hp {
            private a() {
                super(ba.zzapo);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ba();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzaoy", "zzana"});
                case 4:
                    return zzapo;
                case 5:
                    hz<ba> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ba.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapo);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            ba baVar = new ba();
            zzapo = baVar;
            gg.a(ba.class, baVar);
        }
    }

    public static final class c extends gg<c, a> implements hp {
        /* access modifiers changed from: private */
        public static final c zzaqk;
        private static volatile hz<c> zzh;
        private long zzaqe;
        private long zzaqf;
        private long zzaqg;
        private long zzaqh;
        private long zzaqi;
        private long zzaqj;
        private int zzj;

        private c() {
        }

        public static final class a extends gg.b<c, a> implements hp {
            private a() {
                super(c.zzaqk);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new c();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaqk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဃ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004\u0006ဃ\u0005", new Object[]{"zzj", "zzaqe", "zzaqf", "zzaqg", "zzaqh", "zzaqi", "zzaqj"});
                case 4:
                    return zzaqk;
                case 5:
                    hz<c> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (c.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaqk);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            c cVar = new c();
            zzaqk = cVar;
            gg.a(c.class, cVar);
        }
    }

    public static final class i extends gg<i, a> implements hp {
        /* access modifiers changed from: private */
        public static final i zzazr;
        private static volatile hz<i> zzh;
        private float zzat;
        private float zzazp;
        private float zzazq;
        private int zzj;

        private i() {
        }

        public static final class a extends gg.b<i, a> implements hp {
            private a() {
                super(i.zzazr);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new i();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzazr, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003ခ\u0002", new Object[]{"zzj", "zzazp", "zzazq", "zzat"});
                case 4:
                    return zzazr;
                case 5:
                    hz<i> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (i.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzazr);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            i iVar = new i();
            zzazr = iVar;
            gg.a(i.class, iVar);
        }
    }

    public static final class r extends gg<r, b> implements hp {
        /* access modifiers changed from: private */
        public static final r zzbdr;
        private static volatile hz<r> zzh;
        private g zzaoq;
        private i zzbdo;
        private c zzbdp;
        private d zzbdq;
        private int zzj;

        public static final class a extends gg<a, C0147a> implements hp {
            /* access modifiers changed from: private */
            public static final a zzbdt;
            private static volatile hz<a> zzh;
            private float zzar;
            private String zzbds = "";
            private int zzj;

            private a() {
            }

            /* renamed from: com.google.android.gms.internal.firebase_ml.bg$r$a$a  reason: collision with other inner class name */
            public static final class C0147a extends gg.b<a, C0147a> implements hp {
                private C0147a() {
                    super(a.zzbdt);
                }

                /* synthetic */ C0147a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new a();
                    case 2:
                        return new C0147a((byte) 0);
                    case 3:
                        return a((hn) zzbdt, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ခ\u0000\u0002ဈ\u0001", new Object[]{"zzj", "zzar", "zzbds"});
                    case 4:
                        return zzbdt;
                    case 5:
                        hz<a> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (a.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzbdt);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                a aVar = new a();
                zzbdt = aVar;
                gg.a(a.class, aVar);
            }
        }

        public static final class c extends gg<c, a> implements hp {
            /* access modifiers changed from: private */
            public static final c zzbdv;
            private static volatile hz<c> zzh;
            private a zzbdu;
            private int zzj;

            private c() {
            }

            public static final class a extends gg.b<c, a> implements hp {
                private a() {
                    super(c.zzbdv);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzbdv, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzj", "zzbdu"});
                    case 4:
                        return zzbdv;
                    case 5:
                        hz<c> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (c.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzbdv);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                c cVar = new c();
                zzbdv = cVar;
                gg.a(c.class, cVar);
            }
        }

        public static final class d extends gg<d, a> implements hp {
            /* access modifiers changed from: private */
            public static final d zzbdx;
            private static volatile hz<d> zzh;
            private gq<a> zzbdw = ia.a();

            private d() {
            }

            public static final class a extends gg.b<d, a> implements hp {
                private a() {
                    super(d.zzbdx);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new d();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzbdx, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzbdw", a.class});
                    case 4:
                        return zzbdx;
                    case 5:
                        hz<d> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (d.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzbdx);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                d dVar = new d();
                zzbdx = dVar;
                gg.a(d.class, dVar);
            }
        }

        private r() {
        }

        public static final class b extends gg.b<r, b> implements hp {
            private b() {
                super(r.zzbdr);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new r();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzbdr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzj", "zzaoq", "zzbdo", "zzbdp", "zzbdq"});
                case 4:
                    return zzbdr;
                case 5:
                    hz<r> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (r.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbdr);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            r rVar = new r();
            zzbdr = rVar;
            gg.a(r.class, rVar);
        }
    }

    public static final class w extends gg<w, a> implements hp {
        /* access modifiers changed from: private */
        public static final w zzbeo;
        private static volatile hz<w> zzh;
        private f zzana;
        private x zzaoh;
        private g zzaoq;
        private int zzj;

        private w() {
        }

        public static final class a extends gg.b<w, a> implements hp {
            private a() {
                super(w.zzbeo);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new w();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbeo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzana", "zzaoh"});
                case 4:
                    return zzbeo;
                case 5:
                    hz<w> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (w.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbeo);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            w wVar = new w();
            zzbeo = wVar;
            gg.a(w.class, wVar);
        }
    }

    public static final class x extends gg<x, a> implements hp {
        /* access modifiers changed from: private */
        public static final x zzbep;
        private static volatile hz<x> zzh;
        private int zzbdz;
        private int zzj;

        public enum b implements gj {
            INVALID_MODE(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzbp(int i2) {
                if (i2 == 0) {
                    return INVALID_MODE;
                }
                if (i2 == 1) {
                    return STREAM;
                }
                if (i2 != 2) {
                    return null;
                }
                return SINGLE_IMAGE;
            }

            public static gl zzf() {
                return cw.f9783a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cv();
            }
        }

        private x() {
        }

        public static final class a extends gg.b<x, a> implements hp {
            private a() {
                super(x.zzbep);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new x();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbep, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzj", "zzbdz", b.zzf()});
                case 4:
                    return zzbep;
                case 5:
                    hz<x> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (x.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbep);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            x xVar = new x();
            zzbep = xVar;
            gg.a(x.class, xVar);
        }
    }

    public static final class y extends gg<y, a> implements hp {
        /* access modifiers changed from: private */
        public static final y zzbeu;
        private static volatile hz<y> zzh;
        private f zzana;
        private g zzaoq;
        private int zzj;

        private y() {
        }

        public static final class a extends gg.b<y, a> implements hp {
            private a() {
                super(y.zzbeu);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new y();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbeu, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzj", "zzaoq", "zzana"});
                case 4:
                    return zzbeu;
                case 5:
                    hz<y> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (y.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbeu);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            y yVar = new y();
            zzbeu = yVar;
            gg.a(y.class, yVar);
        }
    }

    public static final class z extends gg<z, b> implements hp {
        /* access modifiers changed from: private */
        public static final z zzbez;
        private static volatile hz<z> zzh;
        private g zzaoq;
        private gq<c> zzbev = ia.a();
        private int zzbew;
        private int zzbex;
        private int zzbey;
        private int zzj;

        public enum a implements gj {
            NO_ERROR(0),
            STATUS_SENSITIVE_TOPIC(1),
            STATUS_QUALITY_THRESHOLDED(2),
            STATUS_INTERNAL_ERROR(3),
            STATUS_NOT_SUPPORTED_LANGUAGE(101),
            STATUS_32_BIT_CPU(1001),
            STATUS_32_BIT_APP(1002);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzbq(int i2) {
                if (i2 == 0) {
                    return NO_ERROR;
                }
                if (i2 == 1) {
                    return STATUS_SENSITIVE_TOPIC;
                }
                if (i2 == 2) {
                    return STATUS_QUALITY_THRESHOLDED;
                }
                if (i2 == 3) {
                    return STATUS_INTERNAL_ERROR;
                }
                if (i2 == 101) {
                    return STATUS_NOT_SUPPORTED_LANGUAGE;
                }
                if (i2 == 1001) {
                    return STATUS_32_BIT_CPU;
                }
                if (i2 != 1002) {
                    return null;
                }
                return STATUS_32_BIT_APP;
            }

            public static gl zzf() {
                return cx.f9784a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cy();
            }
        }

        public static final class c extends gg<c, a> implements hp {
            /* access modifiers changed from: private */
            public static final c zzbfi;
            private static volatile hz<c> zzh;
            private float zzar;
            private int zzj;

            private c() {
            }

            public static final class a extends gg.b<c, a> implements hp {
                private a() {
                    super(c.zzbfi);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new c();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzbfi, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ခ\u0000", new Object[]{"zzj", "zzar"});
                    case 4:
                        return zzbfi;
                    case 5:
                        hz<c> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (c.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzbfi);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                c cVar = new c();
                zzbfi = cVar;
                gg.a(c.class, cVar);
            }
        }

        private z() {
        }

        public static final class b extends gg.b<z, b> implements hp {
            private b() {
                super(z.zzbez);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new z();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzbez, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004င\u0002\u0005င\u0003", new Object[]{"zzj", "zzaoq", "zzbev", c.class, "zzbew", a.zzf(), "zzbex", "zzbey"});
                case 4:
                    return zzbez;
                case 5:
                    hz<z> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (z.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbez);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            z zVar = new z();
            zzbez = zVar;
            gg.a(z.class, zVar);
        }
    }

    public static final class ae extends gg<ae, a> implements hp {
        /* access modifiers changed from: private */
        public static final ae zzbih;
        private static volatile hz<ae> zzh;
        private String zzbhw = "";
        private String zzbhx = "";
        private String zzbhy = "";
        private String zzbhz = "";
        String zzbia = "";
        private String zzbib = "";
        private String zzbic = "";
        private gq<String> zzbid = ia.a();
        private String zzbie = "";
        private boolean zzbif;
        private boolean zzbig;
        private int zzj;

        private ae() {
        }

        public static final class a extends gg.b<ae, a> implements hp {
            private a() {
                super(ae.zzbih);
            }

            public final a a(String str) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.a((ae) this.f9919a, str);
                return this;
            }

            public final a b(String str) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.b((ae) this.f9919a, str);
                return this;
            }

            public final a c(String str) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.c((ae) this.f9919a, str);
                return this;
            }

            public final a d(String str) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.d((ae) this.f9919a, str);
                return this;
            }

            public final a e(String str) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.e((ae) this.f9919a, str);
                return this;
            }

            public final a f(String str) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.f((ae) this.f9919a, str);
                return this;
            }

            public final a g(String str) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.g((ae) this.f9919a, str);
                return this;
            }

            public final a a(Iterable<String> iterable) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                ae.a((ae) this.f9919a, (Iterable) iterable);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static a a() {
            return (a) zzbih.g();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ae();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbih, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\b\u001a\tဈ\u0007\nဇ\b\u000bဇ\t", new Object[]{"zzj", "zzbhw", "zzbhx", "zzbhy", "zzbhz", "zzbia", "zzbib", "zzbic", "zzbid", "zzbie", "zzbif", "zzbig"});
                case 4:
                    return zzbih;
                case 5:
                    hz<ae> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ae.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbih);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static ae b() {
            return zzbih;
        }

        static {
            ae aeVar = new ae();
            zzbih = aeVar;
            gg.a(ae.class, aeVar);
        }

        static /* synthetic */ void a(ae aeVar, String str) {
            str.getClass();
            aeVar.zzj |= 1;
            aeVar.zzbhw = str;
        }

        static /* synthetic */ void b(ae aeVar, String str) {
            str.getClass();
            aeVar.zzj |= 2;
            aeVar.zzbhx = str;
        }

        static /* synthetic */ void c(ae aeVar, String str) {
            str.getClass();
            aeVar.zzj |= 4;
            aeVar.zzbhy = str;
        }

        static /* synthetic */ void d(ae aeVar, String str) {
            str.getClass();
            aeVar.zzj |= 8;
            aeVar.zzbhz = str;
        }

        static /* synthetic */ void e(ae aeVar, String str) {
            str.getClass();
            aeVar.zzj |= 16;
            aeVar.zzbia = str;
        }

        static /* synthetic */ void f(ae aeVar, String str) {
            str.getClass();
            aeVar.zzj |= 32;
            aeVar.zzbib = str;
        }

        static /* synthetic */ void g(ae aeVar, String str) {
            str.getClass();
            aeVar.zzj |= 64;
            aeVar.zzbic = str;
        }

        static /* synthetic */ void a(ae aeVar, Iterable iterable) {
            if (!aeVar.zzbid.c()) {
                gq<String> gqVar = aeVar.zzbid;
                int size = gqVar.size();
                aeVar.zzbid = gqVar.d(size == 0 ? 10 : size << 1);
            }
            gq<String> gqVar2 = aeVar.zzbid;
            gk.a(iterable);
            if (iterable instanceof gz) {
                List<?> a2 = ((gz) iterable).a();
                gz gzVar = (gz) gqVar2;
                int size2 = gqVar2.size();
                for (Object next : a2) {
                    if (next == null) {
                        StringBuilder sb = new StringBuilder(37);
                        sb.append("Element at index ");
                        sb.append(gzVar.size() - size2);
                        sb.append(" is null.");
                        String sb2 = sb.toString();
                        for (int size3 = gzVar.size() - 1; size3 >= size2; size3--) {
                            gzVar.remove(size3);
                        }
                        throw new NullPointerException(sb2);
                    } else if (next instanceof fh) {
                        gzVar.a((fh) next);
                    } else {
                        gzVar.add((String) next);
                    }
                }
            } else if (iterable instanceof hy) {
                gqVar2.addAll((Collection) iterable);
            } else {
                if ((gqVar2 instanceof ArrayList) && (iterable instanceof Collection)) {
                    ((ArrayList) gqVar2).ensureCapacity(gqVar2.size() + ((Collection) iterable).size());
                }
                int size4 = gqVar2.size();
                for (Object next2 : iterable) {
                    if (next2 == null) {
                        StringBuilder sb3 = new StringBuilder(37);
                        sb3.append("Element at index ");
                        sb3.append(gqVar2.size() - size4);
                        sb3.append(" is null.");
                        String sb4 = sb3.toString();
                        for (int size5 = gqVar2.size() - 1; size5 >= size4; size5--) {
                            gqVar2.remove(size5);
                        }
                        throw new NullPointerException(sb4);
                    }
                    gqVar2.add(next2);
                }
            }
        }
    }

    public static final class f extends gg<f, a> implements hp {
        /* access modifiers changed from: private */
        public static final f zzayy;
        private static volatile hz<f> zzh;
        private int zzayv;
        private int zzayw;
        private int zzayx;
        private int zzj;

        public enum b implements gj {
            UNKNOWN_FORMAT(0),
            NV16(1),
            NV21(2),
            YV12(3),
            YUV_420_888(7),
            BITMAP(4),
            CM_SAMPLE_BUFFER_REF(5),
            UI_IMAGE(6);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzbd(int i2) {
                switch (i2) {
                    case 0:
                        return UNKNOWN_FORMAT;
                    case 1:
                        return NV16;
                    case 2:
                        return NV21;
                    case 3:
                        return YV12;
                    case 4:
                        return BITMAP;
                    case 5:
                        return CM_SAMPLE_BUFFER_REF;
                    case 6:
                        return UI_IMAGE;
                    case 7:
                        return YUV_420_888;
                    default:
                        return null;
                }
            }

            public static gl zzf() {
                return ce.f9775a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cd();
            }
        }

        private f() {
        }

        public static final class a extends gg.b<f, a> implements hp {
            private a() {
                super(f.zzayy);
            }

            public final a a(b bVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                f.a((f) this.f9919a, bVar);
                return this;
            }

            public final a a(int i2) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                f.a((f) this.f9919a, i2);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static a a() {
            return (a) zzayy.g();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new f();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzayy, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဋ\u0002", new Object[]{"zzj", "zzayv", b.zzf(), "zzayw", "zzayx"});
                case 4:
                    return zzayy;
                case 5:
                    hz<f> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (f.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzayy);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            f fVar = new f();
            zzayy = fVar;
            gg.a(f.class, fVar);
        }

        static /* synthetic */ void a(f fVar, b bVar) {
            fVar.zzayv = bVar.zzd();
            fVar.zzj |= 1;
        }

        static /* synthetic */ void a(f fVar, int i2) {
            fVar.zzj |= 2;
            fVar.zzayw = i2;
        }
    }

    public static final class g extends gg<g, a> implements hp {
        /* access modifiers changed from: private */
        public static final g zzazm;
        private static volatile hz<g> zzh;
        private int zzamy;
        private boolean zzamz;
        private boolean zzaqa;
        private long zzazi;
        private boolean zzazj;
        private boolean zzazk;
        private int zzazl;
        private int zzj;

        private g() {
        }

        public static final class a extends gg.b<g, a> implements hp {
            private a() {
                super(g.zzazm);
            }

            public final a a(long j) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                g.a((g) this.f9919a, j);
                return this;
            }

            public final a a(bq bqVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                g.a((g) this.f9919a, bqVar);
                return this;
            }

            public final a a(boolean z) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                g.a((g) this.f9919a, z);
                return this;
            }

            public final a a() {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                g.a((g) this.f9919a);
                return this;
            }

            public final a b() {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                g.b((g) this.f9919a);
                return this;
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        public static a a() {
            return (a) zzazm.g();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new g();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzazm, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဃ\u0000\u0002ဌ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဋ\u0006", new Object[]{"zzj", "zzazi", "zzamy", bq.zzf(), "zzamz", "zzazj", "zzazk", "zzaqa", "zzazl"});
                case 4:
                    return zzazm;
                case 5:
                    hz<g> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (g.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzazm);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            g gVar = new g();
            zzazm = gVar;
            gg.a(g.class, gVar);
        }

        static /* synthetic */ void a(g gVar, long j) {
            gVar.zzj |= 1;
            gVar.zzazi = j;
        }

        static /* synthetic */ void a(g gVar, bq bqVar) {
            gVar.zzamy = bqVar.zzd();
            gVar.zzj |= 2;
        }

        static /* synthetic */ void a(g gVar, boolean z) {
            gVar.zzj |= 4;
            gVar.zzamz = z;
        }

        static /* synthetic */ void a(g gVar) {
            gVar.zzj |= 8;
            gVar.zzazj = true;
        }

        static /* synthetic */ void b(g gVar) {
            gVar.zzj |= 16;
            gVar.zzazk = true;
        }
    }

    public static final class n extends gg<n, c> implements hp {
        private static final go<Integer, a> zzann = new co();
        private static final go<Integer, b> zzanp = new cn();
        /* access modifiers changed from: private */
        public static final n zzbcc;
        private static volatile hz<n> zzh;
        private f zzana;
        private ep.a zzanl;
        private gn zzanm = gi.a();
        private gn zzano = gi.a();
        private g zzaoq;
        private int zzj;

        public enum a implements gj {
            FORMAT_UNKNOWN(0),
            FORMAT_CODE_128(1),
            FORMAT_CODE_39(2),
            FORMAT_CODE_93(4),
            FORMAT_CODABAR(8),
            FORMAT_DATA_MATRIX(16),
            FORMAT_EAN_13(32),
            FORMAT_EAN_8(64),
            FORMAT_ITF(128),
            FORMAT_QR_CODE(UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS),
            FORMAT_UPC_A(512),
            FORMAT_UPC_E(TarConstants.EOF_BLOCK),
            FORMAT_PDF417(EmiUtil.EMI_PLAN_REQUEST_CODE),
            FORMAT_AZTEC(4096);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzbk(int i2) {
                if (i2 == 0) {
                    return FORMAT_UNKNOWN;
                }
                if (i2 == 1) {
                    return FORMAT_CODE_128;
                }
                if (i2 == 2) {
                    return FORMAT_CODE_39;
                }
                switch (i2) {
                    case 4:
                        return FORMAT_CODE_93;
                    case 8:
                        return FORMAT_CODABAR;
                    case 16:
                        return FORMAT_DATA_MATRIX;
                    case 32:
                        return FORMAT_EAN_13;
                    case 64:
                        return FORMAT_EAN_8;
                    case 128:
                        return FORMAT_ITF;
                    case UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS /*256*/:
                        return FORMAT_QR_CODE;
                    case 512:
                        return FORMAT_UPC_A;
                    case TarConstants.EOF_BLOCK /*1024*/:
                        return FORMAT_UPC_E;
                    case EmiUtil.EMI_PLAN_REQUEST_CODE /*2048*/:
                        return FORMAT_PDF417;
                    case 4096:
                        return FORMAT_AZTEC;
                    default:
                        return null;
                }
            }

            public static gl zzf() {
                return cq.f9780a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cp();
            }
        }

        public enum b implements gj {
            TYPE_UNKNOWN(0),
            TYPE_CONTACT_INFO(1),
            TYPE_EMAIL(2),
            TYPE_ISBN(3),
            TYPE_PHONE(4),
            TYPE_PRODUCT(5),
            TYPE_SMS(6),
            TYPE_TEXT(7),
            TYPE_URL(8),
            TYPE_WIFI(9),
            TYPE_GEO(10),
            TYPE_CALENDAR_EVENT(11),
            TYPE_DRIVER_LICENSE(12);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzbl(int i2) {
                switch (i2) {
                    case 0:
                        return TYPE_UNKNOWN;
                    case 1:
                        return TYPE_CONTACT_INFO;
                    case 2:
                        return TYPE_EMAIL;
                    case 3:
                        return TYPE_ISBN;
                    case 4:
                        return TYPE_PHONE;
                    case 5:
                        return TYPE_PRODUCT;
                    case 6:
                        return TYPE_SMS;
                    case 7:
                        return TYPE_TEXT;
                    case 8:
                        return TYPE_URL;
                    case 9:
                        return TYPE_WIFI;
                    case 10:
                        return TYPE_GEO;
                    case 11:
                        return TYPE_CALENDAR_EVENT;
                    case 12:
                        return TYPE_DRIVER_LICENSE;
                    default:
                        return null;
                }
            }

            public static gl zzf() {
                return cr.f9781a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cs();
            }
        }

        private n() {
        }

        public static final class c extends gg.b<n, c> implements hp {
            private c() {
                super(n.zzbcc);
            }

            public final c a(g.a aVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                n.a((n) this.f9919a, (g) aVar.i());
                return this;
            }

            public final c a(ep.a aVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                n.a((n) this.f9919a, aVar);
                return this;
            }

            public final c a(Iterable<? extends a> iterable) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                n.a((n) this.f9919a, (Iterable) iterable);
                return this;
            }

            public final c b(Iterable<? extends b> iterable) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                n.b((n) this.f9919a, iterable);
                return this;
            }

            public final c a(f fVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                n.a((n) this.f9919a, fVar);
                return this;
            }

            /* synthetic */ c(byte b2) {
                this();
            }
        }

        public static c a() {
            return (c) zzbcc.g();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new n();
                case 2:
                    return new c((byte) 0);
                case 3:
                    return a((hn) zzbcc, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004\u001e\u0005ဉ\u0002", new Object[]{"zzj", "zzaoq", "zzanl", "zzanm", a.zzf(), "zzano", b.zzf(), "zzana"});
                case 4:
                    return zzbcc;
                case 5:
                    hz<n> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (n.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbcc);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            n nVar = new n();
            zzbcc = nVar;
            gg.a(n.class, nVar);
        }

        static /* synthetic */ void a(n nVar, g gVar) {
            gVar.getClass();
            nVar.zzaoq = gVar;
            nVar.zzj |= 1;
        }

        static /* synthetic */ void a(n nVar, ep.a aVar) {
            aVar.getClass();
            nVar.zzanl = aVar;
            nVar.zzj |= 2;
        }

        static /* synthetic */ void a(n nVar, Iterable iterable) {
            if (!nVar.zzanm.c()) {
                nVar.zzanm = gg.a(nVar.zzanm);
            }
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                nVar.zzanm.c(((a) it2.next()).zzd());
            }
        }

        static /* synthetic */ void b(n nVar, Iterable iterable) {
            if (!nVar.zzano.c()) {
                nVar.zzano = gg.a(nVar.zzano);
            }
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                nVar.zzano.c(((b) it2.next()).zzd());
            }
        }

        static /* synthetic */ void a(n nVar, f fVar) {
            fVar.getClass();
            nVar.zzana = fVar;
            nVar.zzj |= 4;
        }
    }

    public static final class an extends gg<an, a> implements hp {
        /* access modifiers changed from: private */
        public static final an zzaop;
        private static volatile hz<an> zzh;
        private int zzamy;
        private int zzj;

        private an() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new an();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaop, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzj", "zzamy", bq.zzf()});
                case 4:
                    return zzaop;
                case 5:
                    hz<an> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (an.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaop);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<an, a> implements hp {
            private a() {
                super(an.zzaop);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            an anVar = new an();
            zzaop = anVar;
            gg.a(an.class, anVar);
        }
    }

    public static final class q extends gg<q, a> implements hp {
        /* access modifiers changed from: private */
        public static final q zzbdn;
        private static volatile hz<q> zzh;
        private float zzat;
        private int zzbdl;
        private l zzbdm;
        private int zzj;

        private q() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new q();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbdn, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဋ\u0000\u0002ခ\u0001\u0003ဉ\u0002", new Object[]{"zzj", "zzbdl", "zzat", "zzbdm"});
                case 4:
                    return zzbdn;
                case 5:
                    hz<q> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (q.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbdn);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<q, a> implements hp {
            private a() {
                super(q.zzbdn);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            q qVar = new q();
            zzbdn = qVar;
            gg.a(q.class, qVar);
        }
    }

    public static final class l extends gg<l, a> implements hp {
        /* access modifiers changed from: private */
        public static final l zzbbj;
        private static volatile hz<l> zzh;
        private k zzbbf;
        private b zzbbg;
        private b zzbbh;
        private boolean zzbbi;
        private int zzj;

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzbbo;
            private static volatile hz<b> zzh;
            private boolean zzbbk;
            private boolean zzbbl;
            private boolean zzbbm;
            private boolean zzbbn;
            private int zzj;

            private b() {
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzbbo);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzbbo, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003", new Object[]{"zzj", "zzbbk", "zzbbl", "zzbbm", "zzbbn"});
                    case 4:
                        return zzbbo;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzbbo);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                b bVar = new b();
                zzbbo = bVar;
                gg.a(b.class, bVar);
            }
        }

        private l() {
        }

        public static final class a extends gg.b<l, a> implements hp {
            private a() {
                super(l.zzbbj);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new l();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbbj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzj", "zzbbf", "zzbbg", "zzbbh", "zzbbi"});
                case 4:
                    return zzbbj;
                case 5:
                    hz<l> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (l.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbbj);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            l lVar = new l();
            zzbbj = lVar;
            gg.a(l.class, lVar);
        }
    }

    public static final class b extends gg<b, a> implements hp {
        /* access modifiers changed from: private */
        public static final b zzaqd;
        private static volatile hz<b> zzh;
        private int zzapa;
        private boolean zzaqc;
        private int zzj;

        private b() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new b();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaqd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzj", "zzapa", k.b.zzf(), "zzaqc"});
                case 4:
                    return zzaqd;
                case 5:
                    hz<b> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (b.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaqd);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<b, a> implements hp {
            private a() {
                super(b.zzaqd);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            b bVar = new b();
            zzaqd = bVar;
            gg.a(b.class, bVar);
        }
    }

    public static final class h extends gg<h, a> implements hp {
        /* access modifiers changed from: private */
        public static final h zzazo;
        private static volatile hz<h> zzh;
        private int zzapa;
        private boolean zzazn;
        private int zzj;

        private h() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new h();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzazo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001", new Object[]{"zzj", "zzapa", k.b.zzf(), "zzazn"});
                case 4:
                    return zzazo;
                case 5:
                    hz<h> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (h.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzazo);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<h, a> implements hp {
            private a() {
                super(h.zzazo);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            h hVar = new h();
            zzazo = hVar;
            gg.a(h.class, hVar);
        }
    }

    public static final class bb extends gg<bb, a> implements hp {
        /* access modifiers changed from: private */
        public static final bb zzapp;
        private static volatile hz<bb> zzh;
        private int zzamy;
        private l zzanb;
        private int zzj;

        private bb() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new bb();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapp, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzj", "zzanb", "zzamy", bq.zzf()});
                case 4:
                    return zzapp;
                case 5:
                    hz<bb> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (bb.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapp);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<bb, a> implements hp {
            private a() {
                super(bb.zzapp);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            bb bbVar = new bb();
            zzapp = bbVar;
            gg.a(bb.class, bbVar);
        }
    }

    public static final class s extends gg<s, a> implements hp {
        /* access modifiers changed from: private */
        public static final s zzbdy;
        private static volatile hz<s> zzh;
        private int zzamy;
        private t zzaod;
        private int zzj;

        private s() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new s();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbdy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001", new Object[]{"zzj", "zzaod", "zzamy", bq.zzf()});
                case 4:
                    return zzbdy;
                case 5:
                    hz<s> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (s.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbdy);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<s, a> implements hp {
            private a() {
                super(s.zzbdy);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            s sVar = new s();
            zzbdy = sVar;
            gg.a(s.class, sVar);
        }
    }

    public static final class v extends gg<v, a> implements hp {
        /* access modifiers changed from: private */
        public static final v zzben;
        private static volatile hz<v> zzh;
        private int zzamy;
        private t zzaod;
        private long zzbel;
        private long zzbem;
        private int zzj;

        private v() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new v();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzben, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဃ\u0002\u0004ဃ\u0003", new Object[]{"zzj", "zzaod", "zzamy", bq.zzf(), "zzbel", "zzbem"});
                case 4:
                    return zzben;
                case 5:
                    hz<v> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (v.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzben);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<v, a> implements hp {
            private a() {
                super(v.zzben);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            v vVar = new v();
            zzben = vVar;
            gg.a(v.class, vVar);
        }
    }

    public static final class aa extends gg<aa, a> implements hp {
        /* access modifiers changed from: private */
        public static final aa zzbfj;
        private static volatile hz<aa> zzh;
        private f zzana;
        private g zzaoq;
        private int zzj;

        private aa() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new aa();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbfj, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzj", "zzaoq", "zzana"});
                case 4:
                    return zzbfj;
                case 5:
                    hz<aa> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (aa.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbfj);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<aa, a> implements hp {
            private a() {
                super(aa.zzbfj);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            aa aaVar = new aa();
            zzbfj = aaVar;
            gg.a(aa.class, aaVar);
        }
    }

    public static final class bc extends gg<bc, a> implements hp {
        /* access modifiers changed from: private */
        public static final bc zzapq;
        private static volatile hz<bc> zzh;
        private l zzanb;
        private gq<b> zzanf = ia.a();
        private gq<b> zzang = ia.a();
        private g zzaoq;
        private long zzaor;
        private int zzj;

        private bc() {
        }

        public static final class b extends gg<b, a> implements hp {
            /* access modifiers changed from: private */
            public static final b zzapt;
            private static volatile hz<b> zzh;
            private int zzapr;
            private gn zzaps = gi.a();
            private int zzj;

            /* renamed from: com.google.android.gms.internal.firebase_ml.bg$bc$b$b  reason: collision with other inner class name */
            public enum C0145b implements gj {
                UNKNOWN_DATA_TYPE(0),
                TYPE_FLOAT32(1),
                TYPE_INT32(2),
                TYPE_BYTE(3),
                TYPE_LONG(4);
                
                private static final gm<C0145b> zzac = null;
                private final int value;

                public final int zzd() {
                    return this.value;
                }

                public static C0145b zzau(int i2) {
                    if (i2 == 0) {
                        return UNKNOWN_DATA_TYPE;
                    }
                    if (i2 == 1) {
                        return TYPE_FLOAT32;
                    }
                    if (i2 == 2) {
                        return TYPE_INT32;
                    }
                    if (i2 == 3) {
                        return TYPE_BYTE;
                    }
                    if (i2 != 4) {
                        return null;
                    }
                    return TYPE_LONG;
                }

                public static gl zzf() {
                    return bn.f9767a;
                }

                public final String toString() {
                    return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                private C0145b(int i2) {
                    this.value = i2;
                }

                static {
                    zzac = new bm();
                }
            }

            private b() {
            }

            public static final class a extends gg.b<b, a> implements hp {
                private a() {
                    super(b.zzapt);
                }

                /* synthetic */ a(byte b2) {
                    this();
                }
            }

            /* access modifiers changed from: protected */
            public final Object a(int i2, Object obj) {
                switch (bf.f9765a[i2 - 1]) {
                    case 1:
                        return new b();
                    case 2:
                        return new a((byte) 0);
                    case 3:
                        return a((hn) zzapt, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u0016", new Object[]{"zzj", "zzapr", C0145b.zzf(), "zzaps"});
                    case 4:
                        return zzapt;
                    case 5:
                        hz<b> hzVar = zzh;
                        if (hzVar == null) {
                            synchronized (b.class) {
                                hzVar = zzh;
                                if (hzVar == null) {
                                    hzVar = new gg.a<>(zzapt);
                                    zzh = hzVar;
                                }
                            }
                        }
                        return hzVar;
                    case 6:
                        return (byte) 1;
                    case 7:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                b bVar = new b();
                zzapt = bVar;
                gg.a(b.class, bVar);
            }
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new bc();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzapq, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001b\u0005ဃ\u0002", new Object[]{"zzj", "zzaoq", "zzanb", "zzanf", b.class, "zzang", b.class, "zzaor"});
                case 4:
                    return zzapq;
                case 5:
                    hz<bc> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (bc.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzapq);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<bc, a> implements hp {
            private a() {
                super(bc.zzapq);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            bc bcVar = new bc();
            zzapq = bcVar;
            gg.a(bc.class, bcVar);
        }
    }

    public static final class m extends gg<m, a> implements hp {
        /* access modifiers changed from: private */
        public static final m zzbbt;
        private static volatile hz<m> zzh;
        private int zzbbp;
        private float zzbbq;
        private int zzbbr;
        private int zzbbs;
        private int zzj;

        public enum b implements gj {
            CATEGORY_UNKNOWN(0),
            CATEGORY_HOME_GOOD(1),
            CATEGORY_FASHION_GOOD(2),
            CATEGORY_ANIMAL(3),
            CATEGORY_FOOD(4),
            CATEGORY_PLACE(5),
            CATEGORY_PLANT(6);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzbj(int i2) {
                switch (i2) {
                    case 0:
                        return CATEGORY_UNKNOWN;
                    case 1:
                        return CATEGORY_HOME_GOOD;
                    case 2:
                        return CATEGORY_FASHION_GOOD;
                    case 3:
                        return CATEGORY_ANIMAL;
                    case 4:
                        return CATEGORY_FOOD;
                    case 5:
                        return CATEGORY_PLACE;
                    case 6:
                        return CATEGORY_PLANT;
                    default:
                        return null;
                }
            }

            public static gl zzf() {
                return cm.f9779a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cl();
            }
        }

        private m() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new m();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbbt, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ခ\u0001\u0003င\u0002\u0004ဋ\u0003", new Object[]{"zzj", "zzbbp", b.zzf(), "zzbbq", "zzbbr", "zzbbs"});
                case 4:
                    return zzbbt;
                case 5:
                    hz<m> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (m.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbbt);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<m, a> implements hp {
            private a() {
                super(m.zzbbt);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            m mVar = new m();
            zzbbt = mVar;
            gg.a(m.class, mVar);
        }
    }

    public static final class t extends gg<t, b> implements hp {
        /* access modifiers changed from: private */
        public static final t zzbee;
        private static volatile hz<t> zzh;
        private l zzbdm;
        private int zzbdz;
        private boolean zzbea;
        private boolean zzbeb;
        private int zzbec;
        private float zzbed;
        private int zzj;

        public enum a implements gj {
            MODE_UNSPECIFIED(0),
            STREAM(1),
            SINGLE_IMAGE(2);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzbo(int i2) {
                if (i2 == 0) {
                    return MODE_UNSPECIFIED;
                }
                if (i2 == 1) {
                    return STREAM;
                }
                if (i2 != 2) {
                    return null;
                }
                return SINGLE_IMAGE;
            }

            public static gl zzf() {
                return ct.f9782a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cu();
            }
        }

        private t() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new t();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzbee, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဋ\u0003\u0005ခ\u0004\u0006ဉ\u0005", new Object[]{"zzj", "zzbdz", a.zzf(), "zzbea", "zzbeb", "zzbec", "zzbed", "zzbdm"});
                case 4:
                    return zzbee;
                case 5:
                    hz<t> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (t.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbee);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends gg.b<t, b> implements hp {
            private b() {
                super(t.zzbee);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        static {
            t tVar = new t();
            zzbee = tVar;
            gg.a(t.class, tVar);
        }
    }

    public static final class ao extends gg<ao, a> implements hp {
        /* access modifiers changed from: private */
        public static final ao zzaos;
        private static volatile hz<ao> zzh;
        private f zzana;
        private l zzanb;
        private g zzaoq;
        private long zzaor;
        private float zzat;
        private int zzj;

        private ao() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ao();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaos, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဃ\u0002\u0004ခ\u0003\u0005ဉ\u0004", new Object[]{"zzj", "zzaoq", "zzanb", "zzaor", "zzat", "zzana"});
                case 4:
                    return zzaos;
                case 5:
                    hz<ao> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ao.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaos);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<ao, a> implements hp {
            private a() {
                super(ao.zzaos);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            ao aoVar = new ao();
            zzaos = aoVar;
            gg.a(ao.class, aoVar);
        }
    }

    public static final class p extends gg<p, a> implements hp {
        /* access modifiers changed from: private */
        public static final p zzbdk;
        private static volatile hz<p> zzh;
        private f zzana;
        private g zzaoq;
        private int zzbbs;
        private q zzbdi;
        private float zzbdj;
        private int zzj;

        private p() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new p();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbdk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဋ\u0003\u0005ခ\u0004", new Object[]{"zzj", "zzaoq", "zzbdi", "zzana", "zzbbs", "zzbdj"});
                case 4:
                    return zzbdk;
                case 5:
                    hz<p> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (p.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbdk);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<p, a> implements hp {
            private a() {
                super(p.zzbdk);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            p pVar = new p();
            zzbdk = pVar;
            gg.a(p.class, pVar);
        }
    }

    public static final class d extends gg<d, a> implements hp {
        /* access modifiers changed from: private */
        public static final d zzawj;
        private static volatile hz<d> zzh;
        private int zzawd;
        private int zzawe;
        private int zzawf;
        private int zzawg;
        private boolean zzawh;
        private float zzawi;
        private int zzj;

        public enum b implements gj {
            UNKNOWN_CLASSIFICATIONS(0),
            NO_CLASSIFICATIONS(1),
            ALL_CLASSIFICATIONS(2);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzax(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_CLASSIFICATIONS;
                }
                if (i2 == 1) {
                    return NO_CLASSIFICATIONS;
                }
                if (i2 != 2) {
                    return null;
                }
                return ALL_CLASSIFICATIONS;
            }

            public static gl zzf() {
                return bw.f9770a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new bv();
            }
        }

        public enum c implements gj {
            UNKNOWN_CONTOURS(0),
            NO_CONTOURS(1),
            ALL_CONTOURS(2);
            
            private static final gm<c> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static c zzay(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_CONTOURS;
                }
                if (i2 == 1) {
                    return NO_CONTOURS;
                }
                if (i2 != 2) {
                    return null;
                }
                return ALL_CONTOURS;
            }

            public static gl zzf() {
                return bx.f9771a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private c(int i2) {
                this.value = i2;
            }

            static {
                zzac = new by();
            }
        }

        /* renamed from: com.google.android.gms.internal.firebase_ml.bg$d$d  reason: collision with other inner class name */
        public enum C0146d implements gj {
            UNKNOWN_LANDMARKS(0),
            NO_LANDMARKS(1),
            ALL_LANDMARKS(2);
            
            private static final gm<C0146d> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static C0146d zzaz(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_LANDMARKS;
                }
                if (i2 == 1) {
                    return NO_LANDMARKS;
                }
                if (i2 != 2) {
                    return null;
                }
                return ALL_LANDMARKS;
            }

            public static gl zzf() {
                return ca.f9773a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private C0146d(int i2) {
                this.value = i2;
            }

            static {
                zzac = new bz();
            }
        }

        public enum e implements gj {
            UNKNOWN_PERFORMANCE(0),
            FAST(1),
            ACCURATE(2);
            
            private static final gm<e> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static e zzba(int i2) {
                if (i2 == 0) {
                    return UNKNOWN_PERFORMANCE;
                }
                if (i2 == 1) {
                    return FAST;
                }
                if (i2 != 2) {
                    return null;
                }
                return ACCURATE;
            }

            public static gl zzf() {
                return cb.f9774a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private e(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cc();
            }
        }

        private d() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new d();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzawj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဇ\u0004\u0006ခ\u0005", new Object[]{"zzj", "zzawd", C0146d.zzf(), "zzawe", b.zzf(), "zzawf", e.zzf(), "zzawg", c.zzf(), "zzawh", "zzawi"});
                case 4:
                    return zzawj;
                case 5:
                    hz<d> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (d.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzawj);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<d, a> implements hp {
            private a() {
                super(d.zzawj);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            d dVar = new d();
            zzawj = dVar;
            gg.a(d.class, dVar);
        }
    }

    public static final class o extends gg<o, a> implements hp {
        /* access modifiers changed from: private */
        public static final o zzbdh;
        private static volatile hz<o> zzh;
        private f zzana;
        private d zzant;
        private int zzanu;
        private int zzanv;
        private g zzaoq;
        private ep.b zzbdg;
        private int zzj;

        private o() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new o();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbdh, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဋ\u0004\u0006ဋ\u0005", new Object[]{"zzj", "zzaoq", "zzbdg", "zzana", "zzant", "zzanu", "zzanv"});
                case 4:
                    return zzbdh;
                case 5:
                    hz<o> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (o.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbdh);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<o, a> implements hp {
            private a() {
                super(o.zzbdh);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            o oVar = new o();
            zzbdh = oVar;
            gg.a(o.class, oVar);
        }
    }

    public static final class j extends gg<j, b> implements hp {
        /* access modifiers changed from: private */
        public static final j zzazw;
        private static volatile hz<j> zzh;
        private int zzamy;
        private l zzanb;
        private long zzazs;
        private long zzazt;
        private int zzazu;
        private long zzazv;
        private int zzj;

        public enum a implements gj {
            UNKNOWN_STATUS(0),
            EXPLICITLY_REQUESTED(1),
            IMPLICITLY_REQUESTED(2),
            MODEL_INFO_RETRIEVAL_SUCCEEDED(3),
            MODEL_INFO_RETRIEVAL_FAILED(4),
            SCHEDULED(5),
            DOWNLOADING(6),
            SUCCEEDED(7),
            FAILED(8),
            LIVE(9),
            UPDATE_AVAILABLE(10),
            DOWNLOADED(11);
            
            private static final gm<a> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static a zzbe(int i2) {
                switch (i2) {
                    case 0:
                        return UNKNOWN_STATUS;
                    case 1:
                        return EXPLICITLY_REQUESTED;
                    case 2:
                        return IMPLICITLY_REQUESTED;
                    case 3:
                        return MODEL_INFO_RETRIEVAL_SUCCEEDED;
                    case 4:
                        return MODEL_INFO_RETRIEVAL_FAILED;
                    case 5:
                        return SCHEDULED;
                    case 6:
                        return DOWNLOADING;
                    case 7:
                        return SUCCEEDED;
                    case 8:
                        return FAILED;
                    case 9:
                        return LIVE;
                    case 10:
                        return UPDATE_AVAILABLE;
                    case 11:
                        return DOWNLOADED;
                    default:
                        return null;
                }
            }

            public static gl zzf() {
                return cf.f9776a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private a(int i2) {
                this.value = i2;
            }

            static {
                zzac = new cg();
            }
        }

        private j() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new j();
                case 2:
                    return new b((byte) 0);
                case 3:
                    return a((hn) zzazw, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဃ\u0001\u0003ဌ\u0002\u0004ဃ\u0003\u0005ဌ\u0004\u0006ဂ\u0005", new Object[]{"zzj", "zzanb", "zzazs", "zzamy", bq.zzf(), "zzazt", "zzazu", a.zzf(), "zzazv"});
                case 4:
                    return zzazw;
                case 5:
                    hz<j> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (j.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzazw);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class b extends gg.b<j, b> implements hp {
            private b() {
                super(j.zzazw);
            }

            /* synthetic */ b(byte b2) {
                this();
            }
        }

        static {
            j jVar = new j();
            zzazw = jVar;
            gg.a(j.class, jVar);
        }
    }

    public static final class ap extends gg<ap, a> implements hp {
        private static final go<Integer, bq> zzaow = new bj();
        /* access modifiers changed from: private */
        public static final ap zzaox;
        private static volatile hz<ap> zzh;
        private long zzaor;
        private l zzaot;
        private l zzaou;
        private gn zzaov = gi.a();
        private int zzj;

        private ap() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new ap();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaox, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002", new Object[]{"zzj", "zzaot", "zzaou", "zzaov", bq.zzf(), "zzaor"});
                case 4:
                    return zzaox;
                case 5:
                    hz<ap> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (ap.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaox);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<ap, a> implements hp {
            private a() {
                super(ap.zzaox);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            ap apVar = new ap();
            zzaox = apVar;
            gg.a(ap.class, apVar);
        }
    }

    public static final class u extends gg<u, a> implements hp {
        /* access modifiers changed from: private */
        public static final u zzbek;
        private static volatile hz<u> zzh;
        private f zzana;
        private t zzaod;
        private g zzaoq;
        private gq<m> zzbej = ia.a();
        private int zzj;

        private u() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new u();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbek, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004\u001b", new Object[]{"zzj", "zzaoq", "zzana", "zzaod", "zzbej", m.class});
                case 4:
                    return zzbek;
                case 5:
                    hz<u> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (u.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbek);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<u, a> implements hp {
            private a() {
                super(u.zzbek);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            u uVar = new u();
            zzbek = uVar;
            gg.a(u.class, uVar);
        }
    }

    public static final class k extends gg<k, a> implements hp {
        /* access modifiers changed from: private */
        public static final k zzbar;
        private static volatile hz<k> zzh;
        private int zzapa;
        private String zzbak = "";
        private String zzbal = "";
        private int zzbam;
        private String zzban = "";
        private String zzbao = "";
        private long zzbap;
        private boolean zzbaq;
        private int zzj;

        public enum b implements gj {
            TYPE_UNKNOWN(0),
            CUSTOM(1),
            AUTOML_IMAGE_LABELING(2),
            BASE_TRANSLATE(3),
            CUSTOM_OBJECT_DETECTION(4),
            CUSTOM_IMAGE_LABELING(5);
            
            private static final gm<b> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static b zzbf(int i2) {
                if (i2 == 0) {
                    return TYPE_UNKNOWN;
                }
                if (i2 == 1) {
                    return CUSTOM;
                }
                if (i2 == 2) {
                    return AUTOML_IMAGE_LABELING;
                }
                if (i2 == 3) {
                    return BASE_TRANSLATE;
                }
                if (i2 == 4) {
                    return CUSTOM_OBJECT_DETECTION;
                }
                if (i2 != 5) {
                    return null;
                }
                return CUSTOM_IMAGE_LABELING;
            }

            public static gl zzf() {
                return ci.f9777a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private b(int i2) {
                this.value = i2;
            }

            static {
                zzac = new ch();
            }
        }

        public enum c implements gj {
            SOURCE_UNKNOWN(0),
            APP_ASSET(1),
            LOCAL(2),
            CLOUD(3),
            SDK_BUILT_IN(4);
            
            private static final gm<c> zzac = null;
            private final int value;

            public final int zzd() {
                return this.value;
            }

            public static c zzbg(int i2) {
                if (i2 == 0) {
                    return SOURCE_UNKNOWN;
                }
                if (i2 == 1) {
                    return APP_ASSET;
                }
                if (i2 == 2) {
                    return LOCAL;
                }
                if (i2 == 3) {
                    return CLOUD;
                }
                if (i2 != 4) {
                    return null;
                }
                return SDK_BUILT_IN;
            }

            public static gl zzf() {
                return cj.f9778a;
            }

            public final String toString() {
                return SimpleComparison.LESS_THAN_OPERATION + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            private c(int i2) {
                this.value = i2;
            }

            static {
                zzac = new ck();
            }
        }

        private k() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new k();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzbar, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဌ\u0005\u0007ဃ\u0006\bဇ\u0007", new Object[]{"zzj", "zzbak", "zzbal", "zzbam", c.zzf(), "zzban", "zzbao", "zzapa", b.zzf(), "zzbap", "zzbaq"});
                case 4:
                    return zzbar;
                case 5:
                    hz<k> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (k.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzbar);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<k, a> implements hp {
            private a() {
                super(k.zzbar);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            k kVar = new k();
            zzbar = kVar;
            gg.a(k.class, kVar);
        }
    }

    public static final class bd extends gg<bd, a> implements hp {
        private static final go<Integer, bq> zzaow = new bo();
        /* access modifiers changed from: private */
        public static final bd zzaqb;
        private static volatile hz<bd> zzh;
        private long zzaor;
        private l zzaot;
        private l zzaou;
        private gn zzaov = gi.a();
        private boolean zzaqa;
        private int zzj;

        private bd() {
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new bd();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzaqb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001e\u0004ဃ\u0002\u0005ဇ\u0003", new Object[]{"zzj", "zzaot", "zzaou", "zzaov", bq.zzf(), "zzaor", "zzaqa"});
                case 4:
                    return zzaqb;
                case 5:
                    hz<bd> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (bd.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzaqb);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static final class a extends gg.b<bd, a> implements hp {
            private a() {
                super(bd.zzaqb);
            }

            /* synthetic */ a(byte b2) {
                this();
            }
        }

        static {
            bd bdVar = new bd();
            zzaqb = bdVar;
            gg.a(bd.class, bdVar);
        }
    }

    public static final class e extends gg.c<e, a> implements hp {
        /* access modifiers changed from: private */
        public static final e zzayu;
        private static volatile hz<e> zzh;
        private int zzaxa;
        ae zzaxb;
        private int zzaxc;
        private boolean zzaxd;
        private j zzaxe;
        private bd zzaxf;
        private bc zzaxg;
        private bb zzaxh;
        private o zzaxi;
        private aa zzaxj;
        private n zzaxk;
        private p zzaxl;
        private s zzaxm;
        private v zzaxn;
        private u zzaxo;
        private w zzaxp;
        private y zzaxq;
        private z zzaxr;
        private r zzaxs;
        private ac zzaxt;
        private at zzaxu;
        private aq zzaxv;
        private as zzaxw;
        private av zzaxx;
        private au zzaxy;
        private aw zzaxz;
        private ax zzaya;
        private ay zzayb;
        private az zzayc;
        private ba zzayd;
        private an zzaye;
        private ap zzayf;
        private ao zzayg;
        private h zzayh;
        private b zzayi;
        private a zzayj;
        private ab zzayk;
        private ah zzayl;
        private ag zzaym;
        private ai zzayn;
        private aj zzayo;
        private am zzayp;
        private ak zzayq;
        private al zzayr;
        private gq<t.e> zzays = ia.a();
        private ad zzayt;
        private byte zzch = 2;
        private int zzj;

        public static final class a extends gg.d<e, a> implements hp {
            private a() {
                super(e.zzayu);
            }

            /* synthetic */ a(byte b2) {
                this();
            }

            public final a a(ae.a aVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                e.a((e) this.f9919a, (ae) aVar.i());
                return this;
            }

            public final a a(br brVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                e.a((e) this.f9919a, brVar);
                return this;
            }

            public final a a(boolean z) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                e.a((e) this.f9919a, z);
                return this;
            }

            public final a a(n nVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                e.a((e) this.f9919a, nVar);
                return this;
            }

            public final a a(n.c cVar) {
                if (this.f9920b) {
                    d();
                    this.f9920b = false;
                }
                e.a((e) this.f9919a, (n) cVar.i());
                return this;
            }

            public final ae a() {
                e eVar = (e) this.f9919a;
                return eVar.zzaxb == null ? ae.b() : eVar.zzaxb;
            }
        }

        static {
            e eVar = new e();
            zzayu = eVar;
            gg.a(e.class, eVar);
        }

        private e() {
        }

        public static a a() {
            return (a) zzayu.g();
        }

        /* access modifiers changed from: protected */
        public final Object a(int i2, Object obj) {
            int i3 = 0;
            switch (bf.f9765a[i2 - 1]) {
                case 1:
                    return new e();
                case 2:
                    return new a((byte) 0);
                case 3:
                    return a((hn) zzayu, "\u0001-\u0000\u0002\u0001/-\u0000\u0001\u0001\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0003\u0004ဉ\u0005\u0005ဉ\u0007\u0006ဉ\b\u0007ဉ\t\bဉ\u0013\tဉ\u0014\nဉ\u0015\u000bဉ\u0016\fဉ\u0017\rဉ\u0018\u000eဉ\u0019\u000fဉ\u001a\u0010ဉ\u001b\u0011ဉ\u001c\u0012ဉ\n\u0013ဉ\u0010\u0014ဉ\u0004\u0015ဉ\u0011\u0016ဉ\u0012\u0017ဉ\u001d\u0018ဉ\u001e\u0019ဉ\u001f\u001aဉ\u000b\u001bဉ\f\u001cဉ\r\u001dဉ\u0006\u001eဉ\"\u001fဉ# ဉ$!ဉ%\"ဉ&#ဉ'$ဉ(%ဇ\u0002'ဉ (ဉ!)Л*ဉ+,ဉ\u000e-ဉ\u000f.ဉ)/ဉ*", new Object[]{"zzj", "zzaxa", "zzaxb", "zzaxc", br.zzf(), "zzaxe", "zzaxg", "zzaxi", "zzaxj", "zzaxk", "zzaxu", "zzaxv", "zzaxw", "zzaxx", "zzaxy", "zzaxz", "zzaya", "zzayb", "zzayc", "zzayd", "zzaxl", "zzaxr", "zzaxf", "zzaxs", "zzaxt", "zzaye", "zzayf", "zzayg", "zzaxm", "zzaxn", "zzaxo", "zzaxh", "zzayj", "zzayk", "zzayl", "zzaym", "zzayn", "zzayo", "zzayp", "zzaxd", "zzayh", "zzayi", "zzays", t.e.class, "zzayt", "zzaxp", "zzaxq", "zzayq", "zzayr"});
                case 4:
                    return zzayu;
                case 5:
                    hz<e> hzVar = zzh;
                    if (hzVar == null) {
                        synchronized (e.class) {
                            hzVar = zzh;
                            if (hzVar == null) {
                                hzVar = new gg.a<>(zzayu);
                                zzh = hzVar;
                            }
                        }
                    }
                    return hzVar;
                case 6:
                    return Byte.valueOf(this.zzch);
                case 7:
                    if (obj != null) {
                        i3 = 1;
                    }
                    this.zzch = (byte) i3;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static /* synthetic */ void a(e eVar, ae aeVar) {
            aeVar.getClass();
            eVar.zzaxb = aeVar;
            eVar.zzj |= 1;
        }

        static /* synthetic */ void a(e eVar, br brVar) {
            eVar.zzaxc = brVar.zzd();
            eVar.zzj |= 2;
        }

        static /* synthetic */ void a(e eVar, boolean z) {
            eVar.zzj |= 4;
            eVar.zzaxd = z;
        }

        static /* synthetic */ void a(e eVar, n nVar) {
            nVar.getClass();
            eVar.zzaxk = nVar;
            eVar.zzj |= 512;
        }
    }
}
