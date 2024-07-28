package kotlin.d.a;

import kotlin.ResultKt;
import kotlin.d.b.a.i;
import kotlin.d.f;
import kotlin.d.g;
import kotlin.g.a.m;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.x;

public class c {
    public static final <T> kotlin.d.d<x> a(kotlin.g.a.b<? super kotlin.d.d<? super T>, ? extends Object> bVar, kotlin.d.d<? super T> dVar) {
        kotlin.d.b.a.a aVar;
        k.d(bVar, "$this$createCoroutineUnintercepted");
        k.d(dVar, "completion");
        k.d(dVar, "completion");
        if (bVar instanceof kotlin.d.b.a.a) {
            return ((kotlin.d.b.a.a) bVar).create(dVar);
        }
        f context = dVar.getContext();
        if (context == g.INSTANCE) {
            if (dVar != null) {
                aVar = new a(dVar, dVar, bVar);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
        } else if (dVar != null) {
            aVar = new b(dVar, context, dVar, context, bVar);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return aVar;
    }

    public static final <R, T> kotlin.d.d<x> a(m<? super R, ? super kotlin.d.d<? super T>, ? extends Object> mVar, R r, kotlin.d.d<? super T> dVar) {
        kotlin.d.b.a.a aVar;
        k.d(mVar, "$this$createCoroutineUnintercepted");
        k.d(dVar, "completion");
        k.d(dVar, "completion");
        if (mVar instanceof kotlin.d.b.a.a) {
            return ((kotlin.d.b.a.a) mVar).create(r, dVar);
        }
        f context = dVar.getContext();
        if (context == g.INSTANCE) {
            if (dVar != null) {
                aVar = new C0833c(dVar, dVar, mVar, r);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }
        } else if (dVar != null) {
            aVar = new d(dVar, context, dVar, context, mVar, r);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        }
        return aVar;
    }

    public static final <T> kotlin.d.d<T> a(kotlin.d.d<? super T> dVar) {
        kotlin.d.d<Object> intercepted;
        k.d(dVar, "$this$intercepted");
        kotlin.d.b.a.d dVar2 = (kotlin.d.b.a.d) (!(dVar instanceof kotlin.d.b.a.d) ? null : dVar);
        return (dVar2 == null || (intercepted = dVar2.intercepted()) == null) ? dVar : intercepted;
    }

    public static final class a extends i {
        final /* synthetic */ kotlin.d.d $completion;
        final /* synthetic */ kotlin.g.a.b $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(kotlin.d.d dVar, kotlin.d.d dVar2, kotlin.g.a.b bVar) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                ResultKt.a(obj);
                kotlin.d.d dVar = this;
                kotlin.g.a.b bVar = this.$this_createCoroutineUnintercepted$inlined;
                if (bVar != null) {
                    return ((kotlin.g.a.b) ab.a((Object) bVar, 1)).invoke(dVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } else if (i2 == 1) {
                this.label = 2;
                ResultKt.a(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    /* renamed from: kotlin.d.a.c$c  reason: collision with other inner class name */
    public static final class C0833c extends i {
        final /* synthetic */ kotlin.d.d $completion;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ m $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0833c(kotlin.d.d dVar, kotlin.d.d dVar2, m mVar, Object obj) {
            super(dVar2);
            this.$completion = dVar;
            this.$this_createCoroutineUnintercepted$inlined = mVar;
            this.$receiver$inlined = obj;
        }

        public final Object invokeSuspend(Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                ResultKt.a(obj);
                kotlin.d.d dVar = this;
                m mVar = this.$this_createCoroutineUnintercepted$inlined;
                if (mVar != null) {
                    return ((m) ab.a((Object) mVar, 2)).invoke(this.$receiver$inlined, dVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } else if (i2 == 1) {
                this.label = 2;
                ResultKt.a(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    public static final class b extends kotlin.d.b.a.d {
        final /* synthetic */ kotlin.d.d $completion;
        final /* synthetic */ f $context;
        final /* synthetic */ kotlin.g.a.b $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(kotlin.d.d dVar, f fVar, kotlin.d.d dVar2, f fVar2, kotlin.g.a.b bVar) {
            super(dVar2, fVar2);
            this.$completion = dVar;
            this.$context = fVar;
            this.$this_createCoroutineUnintercepted$inlined = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                ResultKt.a(obj);
                kotlin.d.d dVar = this;
                kotlin.g.a.b bVar = this.$this_createCoroutineUnintercepted$inlined;
                if (bVar != null) {
                    return ((kotlin.g.a.b) ab.a((Object) bVar, 1)).invoke(dVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type (kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } else if (i2 == 1) {
                this.label = 2;
                ResultKt.a(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }

    public static final class d extends kotlin.d.b.a.d {
        final /* synthetic */ kotlin.d.d $completion;
        final /* synthetic */ f $context;
        final /* synthetic */ Object $receiver$inlined;
        final /* synthetic */ m $this_createCoroutineUnintercepted$inlined;
        private int label;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(kotlin.d.d dVar, f fVar, kotlin.d.d dVar2, f fVar2, m mVar, Object obj) {
            super(dVar2, fVar2);
            this.$completion = dVar;
            this.$context = fVar;
            this.$this_createCoroutineUnintercepted$inlined = mVar;
            this.$receiver$inlined = obj;
        }

        public final Object invokeSuspend(Object obj) {
            int i2 = this.label;
            if (i2 == 0) {
                this.label = 1;
                ResultKt.a(obj);
                kotlin.d.d dVar = this;
                m mVar = this.$this_createCoroutineUnintercepted$inlined;
                if (mVar != null) {
                    return ((m) ab.a((Object) mVar, 2)).invoke(this.$receiver$inlined, dVar);
                }
                throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
            } else if (i2 == 1) {
                this.label = 2;
                ResultKt.a(obj);
                return obj;
            } else {
                throw new IllegalStateException("This coroutine had already completed".toString());
            }
        }
    }
}
