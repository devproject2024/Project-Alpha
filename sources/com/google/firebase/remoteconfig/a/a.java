package com.google.firebase.remoteconfig.a;

import com.google.c.aa;
import com.google.c.ac;
import com.google.c.at;
import com.google.c.au;
import com.google.c.bd;
import java.io.IOException;
import java.io.InputStream;

public final class a {

    public interface b extends au {
    }

    public interface d extends au {
    }

    public interface f extends au {
    }

    public interface h extends au {
    }

    public interface j extends au {
    }

    public static final class g extends aa<g, C0663a> implements h {
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public static final g f39328h;

        /* renamed from: i  reason: collision with root package name */
        private static volatile bd<g> f39329i;

        /* renamed from: a  reason: collision with root package name */
        public C0659a f39330a;

        /* renamed from: b  reason: collision with root package name */
        public C0659a f39331b;

        /* renamed from: c  reason: collision with root package name */
        public C0659a f39332c;

        /* renamed from: g  reason: collision with root package name */
        private ac.i<i> f39333g = l();

        private g() {
        }

        public static g a(InputStream inputStream) throws IOException {
            return (g) aa.a(f39328h, inputStream);
        }

        /* renamed from: com.google.firebase.remoteconfig.a.a$g$a  reason: collision with other inner class name */
        public static final class C0663a extends aa.a<g, C0663a> implements h {
            /* synthetic */ C0663a(byte b2) {
                this();
            }

            private C0663a() {
                super(g.f39328h);
            }
        }

        public final Object a(aa.g gVar) {
            switch (gVar) {
                case NEW_MUTABLE_INSTANCE:
                    return new g();
                case NEW_BUILDER:
                    return new C0663a((byte) 0);
                case BUILD_MESSAGE_INFO:
                    return a((at) f39328h, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b", new Object[]{"bitField0_", "fetchedConfigHolder_", "activeConfigHolder_", "defaultsConfigHolder_", "metadata_", "appliedResource_", i.class});
                case GET_DEFAULT_INSTANCE:
                    return f39328h;
                case GET_PARSER:
                    bd<g> bdVar = f39329i;
                    if (bdVar == null) {
                        synchronized (g.class) {
                            bdVar = f39329i;
                            if (bdVar == null) {
                                bdVar = new aa.b<>(f39328h);
                                f39329i = bdVar;
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
            g gVar = new g();
            f39328h = gVar;
            aa.a(g.class, gVar);
        }
    }

    public static final class c extends aa<c, C0661a> implements d {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final c f39320c;

        /* renamed from: g  reason: collision with root package name */
        private static volatile bd<c> f39321g;

        /* renamed from: a  reason: collision with root package name */
        public String f39322a = "";

        /* renamed from: b  reason: collision with root package name */
        public com.google.c.j f39323b = com.google.c.j.EMPTY;

        private c() {
        }

        /* renamed from: com.google.firebase.remoteconfig.a.a$c$a  reason: collision with other inner class name */
        public static final class C0661a extends aa.a<c, C0661a> implements d {
            /* synthetic */ C0661a(byte b2) {
                this();
            }

            private C0661a() {
                super(c.f39320c);
            }
        }

        public final Object a(aa.g gVar) {
            switch (gVar) {
                case NEW_MUTABLE_INSTANCE:
                    return new c();
                case NEW_BUILDER:
                    return new C0661a((byte) 0);
                case BUILD_MESSAGE_INFO:
                    return a((at) f39320c, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"bitField0_", "key_", "value_"});
                case GET_DEFAULT_INSTANCE:
                    return f39320c;
                case GET_PARSER:
                    bd<c> bdVar = f39321g;
                    if (bdVar == null) {
                        synchronized (c.class) {
                            bdVar = f39321g;
                            if (bdVar == null) {
                                bdVar = new aa.b<>(f39320c);
                                f39321g = bdVar;
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
            f39320c = cVar;
            aa.a(c.class, cVar);
        }
    }

    public static final class e extends aa<e, C0662a> implements f {
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public static final e f39324c;

        /* renamed from: g  reason: collision with root package name */
        private static volatile bd<e> f39325g;

        /* renamed from: a  reason: collision with root package name */
        public String f39326a = "";

        /* renamed from: b  reason: collision with root package name */
        public ac.i<c> f39327b = l();

        private e() {
        }

        /* renamed from: com.google.firebase.remoteconfig.a.a$e$a  reason: collision with other inner class name */
        public static final class C0662a extends aa.a<e, C0662a> implements f {
            /* synthetic */ C0662a(byte b2) {
                this();
            }

            private C0662a() {
                super(e.f39324c);
            }
        }

        public final Object a(aa.g gVar) {
            switch (gVar) {
                case NEW_MUTABLE_INSTANCE:
                    return new e();
                case NEW_BUILDER:
                    return new C0662a((byte) 0);
                case BUILD_MESSAGE_INFO:
                    return a((at) f39324c, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b", new Object[]{"bitField0_", "namespace_", "keyValue_", c.class});
                case GET_DEFAULT_INSTANCE:
                    return f39324c;
                case GET_PARSER:
                    bd<e> bdVar = f39325g;
                    if (bdVar == null) {
                        synchronized (e.class) {
                            bdVar = f39325g;
                            if (bdVar == null) {
                                bdVar = new aa.b<>(f39324c);
                                f39325g = bdVar;
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
            e eVar = new e();
            f39324c = eVar;
            aa.a(e.class, eVar);
        }
    }

    /* renamed from: com.google.firebase.remoteconfig.a.a$a  reason: collision with other inner class name */
    public static final class C0659a extends aa<C0659a, C0660a> implements b {
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public static final C0659a f39315g;

        /* renamed from: h  reason: collision with root package name */
        private static volatile bd<C0659a> f39316h;

        /* renamed from: a  reason: collision with root package name */
        public ac.i<e> f39317a = l();

        /* renamed from: b  reason: collision with root package name */
        public long f39318b;

        /* renamed from: c  reason: collision with root package name */
        public ac.i<com.google.c.j> f39319c = l();

        private C0659a() {
        }

        /* renamed from: com.google.firebase.remoteconfig.a.a$a$a  reason: collision with other inner class name */
        public static final class C0660a extends aa.a<C0659a, C0660a> implements b {
            /* synthetic */ C0660a(byte b2) {
                this();
            }

            private C0660a() {
                super(C0659a.f39315g);
            }
        }

        public final Object a(aa.g gVar) {
            switch (gVar) {
                case NEW_MUTABLE_INSTANCE:
                    return new C0659a();
                case NEW_BUILDER:
                    return new C0660a((byte) 0);
                case BUILD_MESSAGE_INFO:
                    return a((at) f39315g, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u0005\u0000\u0003\u001c", new Object[]{"bitField0_", "namespaceKeyValue_", e.class, "timestamp_", "experimentPayload_"});
                case GET_DEFAULT_INSTANCE:
                    return f39315g;
                case GET_PARSER:
                    bd<C0659a> bdVar = f39316h;
                    if (bdVar == null) {
                        synchronized (C0659a.class) {
                            bdVar = f39316h;
                            if (bdVar == null) {
                                bdVar = new aa.b<>(f39315g);
                                f39316h = bdVar;
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
            C0659a aVar = new C0659a();
            f39315g = aVar;
            aa.a(C0659a.class, aVar);
        }

        public static C0659a a() {
            return f39315g;
        }
    }

    public static final class i extends aa<i, C0664a> implements j {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public static final i f39334b;

        /* renamed from: c  reason: collision with root package name */
        private static volatile bd<i> f39335c;

        /* renamed from: a  reason: collision with root package name */
        private String f39336a = "";

        private i() {
        }

        /* renamed from: com.google.firebase.remoteconfig.a.a$i$a  reason: collision with other inner class name */
        public static final class C0664a extends aa.a<i, C0664a> implements j {
            /* synthetic */ C0664a(byte b2) {
                this();
            }

            private C0664a() {
                super(i.f39334b);
            }
        }

        public final Object a(aa.g gVar) {
            switch (gVar) {
                case NEW_MUTABLE_INSTANCE:
                    return new i();
                case NEW_BUILDER:
                    return new C0664a((byte) 0);
                case BUILD_MESSAGE_INFO:
                    return a((at) f39334b, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0005\u0001\u0003\b\u0002", new Object[]{"bitField0_", "resourceId_", "appUpdateTime_", "namespace_"});
                case GET_DEFAULT_INSTANCE:
                    return f39334b;
                case GET_PARSER:
                    bd<i> bdVar = f39335c;
                    if (bdVar == null) {
                        synchronized (i.class) {
                            bdVar = f39335c;
                            if (bdVar == null) {
                                bdVar = new aa.b<>(f39334b);
                                f39335c = bdVar;
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
            i iVar = new i();
            f39334b = iVar;
            aa.a(i.class, iVar);
        }
    }
}
