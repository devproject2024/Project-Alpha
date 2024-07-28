package e.a.a;

import com.google.c.aa;
import com.google.c.ac;
import com.google.c.ad;
import com.google.c.at;
import com.google.c.au;
import com.google.c.bd;

public final class a {

    public interface b extends au {
    }

    public interface d extends au {
    }

    /* renamed from: e.a.a.a$a  reason: collision with other inner class name */
    public static final class C0768a extends aa<C0768a, C0769a> implements b {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final C0768a f46005b;

        /* renamed from: c  reason: collision with root package name */
        private static volatile bd<C0768a> f46006c;

        /* renamed from: a  reason: collision with root package name */
        private String f46007a = "";

        private C0768a() {
        }

        /* renamed from: e.a.a.a$a$a  reason: collision with other inner class name */
        public static final class C0769a extends aa.a<C0768a, C0769a> implements b {
            /* synthetic */ C0769a(byte b2) {
                this();
            }

            private C0769a() {
                super(C0768a.f46005b);
            }
        }

        public final Object a(aa.g gVar) {
            switch (gVar) {
                case NEW_MUTABLE_INSTANCE:
                    return new C0768a();
                case NEW_BUILDER:
                    return new C0769a((byte) 0);
                case BUILD_MESSAGE_INFO:
                    return a((at) f46005b, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"experimentId_"});
                case GET_DEFAULT_INSTANCE:
                    return f46005b;
                case GET_PARSER:
                    bd<C0768a> bdVar = f46006c;
                    if (bdVar == null) {
                        synchronized (C0768a.class) {
                            bdVar = f46006c;
                            if (bdVar == null) {
                                bdVar = new aa.b<>(f46005b);
                                f46006c = bdVar;
                            }
                        }
                    }
                    return bdVar;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            C0768a aVar = new C0768a();
            f46005b = aVar;
            aa.a(C0768a.class, aVar);
        }
    }

    public static final class c extends aa<c, C0770a> implements d {
        /* access modifiers changed from: private */
        public static final c p;
        private static volatile bd<c> q;

        /* renamed from: a  reason: collision with root package name */
        public String f46008a = "";

        /* renamed from: b  reason: collision with root package name */
        public String f46009b = "";

        /* renamed from: c  reason: collision with root package name */
        public long f46010c;

        /* renamed from: g  reason: collision with root package name */
        public String f46011g = "";

        /* renamed from: h  reason: collision with root package name */
        public long f46012h;

        /* renamed from: i  reason: collision with root package name */
        public long f46013i;
        private String j = "";
        private String k = "";
        private String l = "";
        private String m = "";
        private String n = "";
        private ac.i<C0768a> o = l();

        private c() {
        }

        public static c a(byte[] bArr) throws ad {
            return (c) aa.a(p, bArr);
        }

        /* renamed from: e.a.a.a$c$a  reason: collision with other inner class name */
        public static final class C0770a extends aa.a<c, C0770a> implements d {
            /* synthetic */ C0770a(byte b2) {
                this();
            }

            private C0770a() {
                super(c.p);
            }
        }

        public final Object a(aa.g gVar) {
            switch (gVar) {
                case NEW_MUTABLE_INSTANCE:
                    return new c();
                case NEW_BUILDER:
                    return new C0770a((byte) 0);
                case BUILD_MESSAGE_INFO:
                    return a((at) p, "\u0000\r\u0000\u0000\u0001\r\r\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004Ȉ\u0005\u0002\u0006\u0002\u0007Ȉ\bȈ\tȈ\nȈ\u000bȈ\f\f\r\u001b", new Object[]{"experimentId_", "variantId_", "experimentStartTimeMillis_", "triggerEvent_", "triggerTimeoutMillis_", "timeToLiveMillis_", "setEventToLog_", "activateEventToLog_", "clearEventToLog_", "timeoutEventToLog_", "ttlExpiryEventToLog_", "overflowPolicy_", "ongoingExperiments_", C0768a.class});
                case GET_DEFAULT_INSTANCE:
                    return p;
                case GET_PARSER:
                    bd<c> bdVar = q;
                    if (bdVar == null) {
                        synchronized (c.class) {
                            bdVar = q;
                            if (bdVar == null) {
                                bdVar = new aa.b<>(p);
                                q = bdVar;
                            }
                        }
                    }
                    return bdVar;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            c cVar = new c();
            p = cVar;
            aa.a(c.class, cVar);
        }
    }
}
