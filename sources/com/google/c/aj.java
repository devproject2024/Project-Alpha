package com.google.c;

import com.google.c.ac;
import java.util.Collections;
import java.util.List;

abstract class aj {

    /* renamed from: a  reason: collision with root package name */
    private static final aj f37713a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private static final aj f37714b = new b((byte) 0);

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> a(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void a(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void b(Object obj, long j);

    /* synthetic */ aj(byte b2) {
        this();
    }

    private aj() {
    }

    static aj a() {
        return f37713a;
    }

    static aj b() {
        return f37714b;
    }

    static final class a extends aj {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?> f37715a = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private a() {
            super((byte) 0);
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final <L> List<L> a(Object obj, long j) {
            return a(obj, j, 10);
        }

        /* access modifiers changed from: package-private */
        public final void b(Object obj, long j) {
            Object obj2;
            List list = (List) bx.f(obj, j);
            if (list instanceof ai) {
                obj2 = ((ai) list).e();
            } else if (!f37715a.isAssignableFrom(list.getClass())) {
                if (!(list instanceof be) || !(list instanceof ac.i)) {
                    obj2 = Collections.unmodifiableList(list);
                } else {
                    ac.i iVar = (ac.i) list;
                    if (iVar.a()) {
                        iVar.b();
                        return;
                    }
                    return;
                }
            } else {
                return;
            }
            bx.a(obj, j, obj2);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.c.ah} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.c.ah} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.c.ah} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static <L> java.util.List<L> a(java.lang.Object r3, long r4, int r6) {
            /*
                java.util.List r0 = c(r3, r4)
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L_0x002d
                boolean r1 = r0 instanceof com.google.c.ai
                if (r1 == 0) goto L_0x0014
                com.google.c.ah r0 = new com.google.c.ah
                r0.<init>((int) r6)
                goto L_0x0029
            L_0x0014:
                boolean r1 = r0 instanceof com.google.c.be
                if (r1 == 0) goto L_0x0024
                boolean r1 = r0 instanceof com.google.c.ac.i
                if (r1 == 0) goto L_0x0024
                com.google.c.ac$i r0 = (com.google.c.ac.i) r0
                com.google.c.ac$i r6 = r0.a(r6)
                r0 = r6
                goto L_0x0029
            L_0x0024:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>(r6)
            L_0x0029:
                com.google.c.bx.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
                goto L_0x007f
            L_0x002d:
                java.lang.Class<?> r1 = f37715a
                java.lang.Class r2 = r0.getClass()
                boolean r1 = r1.isAssignableFrom(r2)
                if (r1 == 0) goto L_0x004b
                java.util.ArrayList r1 = new java.util.ArrayList
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>(r2)
                r1.addAll(r0)
                com.google.c.bx.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            L_0x0049:
                r0 = r1
                goto L_0x007f
            L_0x004b:
                boolean r1 = r0 instanceof com.google.c.bw
                if (r1 == 0) goto L_0x0062
                com.google.c.ah r1 = new com.google.c.ah
                int r2 = r0.size()
                int r2 = r2 + r6
                r1.<init>((int) r2)
                com.google.c.bw r0 = (com.google.c.bw) r0
                r1.addAll(r0)
                com.google.c.bx.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
                goto L_0x0049
            L_0x0062:
                boolean r1 = r0 instanceof com.google.c.be
                if (r1 == 0) goto L_0x007f
                boolean r1 = r0 instanceof com.google.c.ac.i
                if (r1 == 0) goto L_0x007f
                r1 = r0
                com.google.c.ac$i r1 = (com.google.c.ac.i) r1
                boolean r2 = r1.a()
                if (r2 != 0) goto L_0x007f
                int r0 = r0.size()
                int r0 = r0 + r6
                com.google.c.ac$i r0 = r1.a(r0)
                com.google.c.bx.a((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            L_0x007f:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.c.aj.a.a(java.lang.Object, long, int):java.util.List");
        }

        /* access modifiers changed from: package-private */
        public final <E> void a(Object obj, Object obj2, long j) {
            List c2 = c(obj2, j);
            List a2 = a(obj, j, c2.size());
            int size = a2.size();
            int size2 = c2.size();
            if (size > 0 && size2 > 0) {
                a2.addAll(c2);
            }
            if (size > 0) {
                c2 = a2;
            }
            bx.a(obj, j, (Object) c2);
        }

        private static <E> List<E> c(Object obj, long j) {
            return (List) bx.f(obj, j);
        }
    }

    static final class b extends aj {
        private b() {
            super((byte) 0);
        }

        /* synthetic */ b(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final <L> List<L> a(Object obj, long j) {
            ac.i c2 = c(obj, j);
            if (c2.a()) {
                return c2;
            }
            int size = c2.size();
            ac.i a2 = c2.a(size == 0 ? 10 : size * 2);
            bx.a(obj, j, (Object) a2);
            return a2;
        }

        /* access modifiers changed from: package-private */
        public final void b(Object obj, long j) {
            c(obj, j).b();
        }

        /* access modifiers changed from: package-private */
        public final <E> void a(Object obj, Object obj2, long j) {
            ac.i c2 = c(obj, j);
            ac.i c3 = c(obj2, j);
            int size = c2.size();
            int size2 = c3.size();
            if (size > 0 && size2 > 0) {
                if (!c2.a()) {
                    c2 = c2.a(size2 + size);
                }
                c2.addAll(c3);
            }
            if (size > 0) {
                c3 = c2;
            }
            bx.a(obj, j, (Object) c3);
        }

        private static <E> ac.i<E> c(Object obj, long j) {
            return (ac.i) bx.f(obj, j);
        }
    }
}
