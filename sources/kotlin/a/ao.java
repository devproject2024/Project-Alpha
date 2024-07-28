package kotlin.a;

import java.util.Iterator;
import java.util.List;
import kotlin.d.b.a.f;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.l.g;
import kotlin.x;

public final class ao {
    public static final <T> Iterator<List<T>> a(Iterator<? extends T> it2) {
        k.d(it2, "iterator");
        if (!it2.hasNext()) {
            return v.f47892a;
        }
        return g.a(new a(900, 900, it2, false, true, (d) null));
    }

    @f(b = "SlidingWindow.kt", c = {34, 40, 49, 55, 58}, d = "invokeSuspend", e = "kotlin.collections.SlidingWindowKt$windowedIterator$1")
    static final class a extends j implements m<kotlin.l.f<? super List<? extends T>>, d<? super x>, Object> {
        final /* synthetic */ Iterator $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        private kotlin.l.f p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(int i2, int i3, Iterator it2, boolean z, boolean z2, d dVar) {
            super(2, dVar);
            this.$size = i2;
            this.$step = i3;
            this.$iterator = it2;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.d(dVar, "completion");
            a aVar = new a(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, dVar);
            aVar.p$ = (kotlin.l.f) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x010d  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x01a4  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x01b0  */
        /* JADX WARNING: Removed duplicated region for block: B:91:0x01a0 A[SYNTHETIC] */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) {
            /*
                r18 = this;
                r0 = r18
                kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r2 = r0.label
                r3 = 5
                r4 = 4
                r5 = 3
                r6 = 2
                r7 = 1
                if (r2 == 0) goto L_0x0065
                if (r2 == r7) goto L_0x004e
                if (r2 == r6) goto L_0x0017
                if (r2 == r5) goto L_0x0037
                if (r2 == r4) goto L_0x0024
                if (r2 != r3) goto L_0x001c
            L_0x0017:
                kotlin.ResultKt.a((java.lang.Object) r19)
                goto L_0x01f4
            L_0x001c:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0024:
                java.lang.Object r2 = r0.L$1
                kotlin.a.aj r2 = (kotlin.a.aj) r2
                int r5 = r0.I$1
                int r6 = r0.I$0
                java.lang.Object r8 = r0.L$0
                kotlin.l.f r8 = (kotlin.l.f) r8
                kotlin.ResultKt.a((java.lang.Object) r19)
                r11 = r1
                r1 = r0
                goto L_0x01d3
            L_0x0037:
                java.lang.Object r2 = r0.L$3
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r6 = r0.L$1
                kotlin.a.aj r6 = (kotlin.a.aj) r6
                int r8 = r0.I$1
                int r9 = r0.I$0
                java.lang.Object r10 = r0.L$0
                kotlin.l.f r10 = (kotlin.l.f) r10
                kotlin.ResultKt.a((java.lang.Object) r19)
                r11 = r1
                r1 = r0
                goto L_0x018f
            L_0x004e:
                java.lang.Object r2 = r0.L$3
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r3 = r0.L$1
                java.util.ArrayList r3 = (java.util.ArrayList) r3
                int r4 = r0.I$1
                int r5 = r0.I$0
                java.lang.Object r8 = r0.L$0
                kotlin.l.f r8 = (kotlin.l.f) r8
                kotlin.ResultKt.a((java.lang.Object) r19)
                r10 = r1
                r9 = r4
                r1 = r0
                goto L_0x00ba
            L_0x0065:
                kotlin.ResultKt.a((java.lang.Object) r19)
                kotlin.l.f r2 = r0.p$
                int r8 = r0.$size
                r9 = 1024(0x400, float:1.435E-42)
                int r8 = kotlin.j.e.c(r8, r9)
                int r9 = r0.$step
                int r10 = r0.$size
                int r9 = r9 - r10
                if (r9 < 0) goto L_0x00f4
                java.util.ArrayList r3 = new java.util.ArrayList
                r3.<init>(r8)
                r4 = 0
                java.util.Iterator r5 = r0.$iterator
                r10 = r1
                r1 = r0
                r16 = r8
                r8 = r2
                r2 = r5
                r5 = r16
            L_0x0089:
                boolean r11 = r2.hasNext()
                if (r11 == 0) goto L_0x00cb
                java.lang.Object r11 = r2.next()
                if (r4 <= 0) goto L_0x0098
                int r4 = r4 + -1
                goto L_0x0089
            L_0x0098:
                r3.add(r11)
                int r12 = r3.size()
                int r13 = r1.$size
                if (r12 != r13) goto L_0x0089
                r1.L$0 = r8
                r1.I$0 = r5
                r1.I$1 = r9
                r1.L$1 = r3
                r1.I$2 = r4
                r1.L$2 = r11
                r1.L$3 = r2
                r1.label = r7
                java.lang.Object r4 = r8.a(r3, r1)
                if (r4 != r10) goto L_0x00ba
                return r10
            L_0x00ba:
                boolean r4 = r1.$reuseBuffer
                if (r4 == 0) goto L_0x00c2
                r3.clear()
                goto L_0x00c9
            L_0x00c2:
                java.util.ArrayList r3 = new java.util.ArrayList
                int r4 = r1.$size
                r3.<init>(r4)
            L_0x00c9:
                r4 = r9
                goto L_0x0089
            L_0x00cb:
                r2 = r3
                java.util.Collection r2 = (java.util.Collection) r2
                boolean r2 = r2.isEmpty()
                r2 = r2 ^ r7
                if (r2 == 0) goto L_0x01f4
                boolean r2 = r1.$partialWindows
                if (r2 != 0) goto L_0x00e1
                int r2 = r3.size()
                int r7 = r1.$size
                if (r2 != r7) goto L_0x01f4
            L_0x00e1:
                r1.L$0 = r8
                r1.I$0 = r5
                r1.I$1 = r9
                r1.L$1 = r3
                r1.I$2 = r4
                r1.label = r6
                java.lang.Object r1 = r8.a(r3, r1)
                if (r1 != r10) goto L_0x01f4
                return r10
            L_0x00f4:
                kotlin.a.aj r6 = new kotlin.a.aj
                r6.<init>(r8)
                java.util.Iterator r10 = r0.$iterator
                r11 = r1
                r1 = r0
                r16 = r10
                r10 = r2
                r2 = r16
                r17 = r9
                r9 = r8
                r8 = r17
            L_0x0107:
                boolean r12 = r2.hasNext()
                if (r12 == 0) goto L_0x01a0
                java.lang.Object r12 = r2.next()
                boolean r13 = r6.b()
                if (r13 != 0) goto L_0x0196
                java.lang.Object[] r13 = r6.f47874e
                int r14 = r6.f47872c
                int r15 = r6.size()
                int r14 = r14 + r15
                int r15 = r6.f47871b
                int r14 = r14 % r15
                r13[r14] = r12
                int r13 = r6.size()
                int r13 = r13 + r7
                r6.f47873d = r13
                boolean r13 = r6.b()
                if (r13 == 0) goto L_0x0107
                int r13 = r6.size()
                int r14 = r1.$size
                if (r13 >= r14) goto L_0x0168
                int r12 = r6.f47871b
                int r13 = r6.f47871b
                int r13 = r13 >> r7
                int r12 = r12 + r13
                int r12 = r12 + r7
                int r12 = kotlin.j.e.c(r12, r14)
                int r13 = r6.f47872c
                if (r13 != 0) goto L_0x0157
                java.lang.Object[] r13 = r6.f47874e
                java.lang.Object[] r12 = java.util.Arrays.copyOf(r13, r12)
                java.lang.String r13 = "java.util.Arrays.copyOf(this, newSize)"
                kotlin.g.b.k.b(r12, r13)
                goto L_0x015d
            L_0x0157:
                java.lang.Object[] r12 = new java.lang.Object[r12]
                java.lang.Object[] r12 = r6.toArray(r12)
            L_0x015d:
                kotlin.a.aj r13 = new kotlin.a.aj
                int r6 = r6.size()
                r13.<init>(r12, r6)
                r6 = r13
                goto L_0x0107
            L_0x0168:
                boolean r13 = r1.$reuseBuffer
                if (r13 == 0) goto L_0x0170
                r13 = r6
                java.util.List r13 = (java.util.List) r13
                goto L_0x017a
            L_0x0170:
                java.util.ArrayList r13 = new java.util.ArrayList
                r14 = r6
                java.util.Collection r14 = (java.util.Collection) r14
                r13.<init>(r14)
                java.util.List r13 = (java.util.List) r13
            L_0x017a:
                r1.L$0 = r10
                r1.I$0 = r9
                r1.I$1 = r8
                r1.L$1 = r6
                r1.L$2 = r12
                r1.L$3 = r2
                r1.label = r5
                java.lang.Object r12 = r10.a(r13, r1)
                if (r12 != r11) goto L_0x018f
                return r11
            L_0x018f:
                int r12 = r1.$step
                r6.a((int) r12)
                goto L_0x0107
            L_0x0196:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "ring buffer is full"
                r1.<init>(r2)
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                throw r1
            L_0x01a0:
                boolean r2 = r1.$partialWindows
                if (r2 == 0) goto L_0x01f4
                r2 = r6
                r5 = r8
                r6 = r9
                r8 = r10
            L_0x01a8:
                int r9 = r2.size()
                int r10 = r1.$step
                if (r9 <= r10) goto L_0x01d9
                boolean r9 = r1.$reuseBuffer
                if (r9 == 0) goto L_0x01b8
                r9 = r2
                java.util.List r9 = (java.util.List) r9
                goto L_0x01c2
            L_0x01b8:
                java.util.ArrayList r9 = new java.util.ArrayList
                r10 = r2
                java.util.Collection r10 = (java.util.Collection) r10
                r9.<init>(r10)
                java.util.List r9 = (java.util.List) r9
            L_0x01c2:
                r1.L$0 = r8
                r1.I$0 = r6
                r1.I$1 = r5
                r1.L$1 = r2
                r1.label = r4
                java.lang.Object r9 = r8.a(r9, r1)
                if (r9 != r11) goto L_0x01d3
                return r11
            L_0x01d3:
                int r9 = r1.$step
                r2.a((int) r9)
                goto L_0x01a8
            L_0x01d9:
                r4 = r2
                java.util.Collection r4 = (java.util.Collection) r4
                boolean r4 = r4.isEmpty()
                r4 = r4 ^ r7
                if (r4 == 0) goto L_0x01f4
                r1.L$0 = r8
                r1.I$0 = r6
                r1.I$1 = r5
                r1.L$1 = r2
                r1.label = r3
                java.lang.Object r1 = r8.a(r2, r1)
                if (r1 != r11) goto L_0x01f4
                return r11
            L_0x01f4:
                kotlin.x r1 = kotlin.x.f47997a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.a.ao.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
