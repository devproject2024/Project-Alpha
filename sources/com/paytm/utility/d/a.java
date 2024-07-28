package com.paytm.utility.d;

import com.alipay.mobile.h5container.api.H5Event;
import com.paytm.utility.q;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43787a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final CoroutineExceptionHandler f43788b = new C0752a(CoroutineExceptionHandler.Key);

    private a() {
    }

    public static final void a(kotlin.g.a.a<x> aVar) {
        k.c(aVar, "function");
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, f43788b, (CoroutineStart) null, new d(aVar, (kotlin.d.d) null), 2, (Object) null);
    }

    public static final void a(kotlin.g.a.b<Object, x> bVar, kotlin.g.a.a<? extends Object>... aVarArr) {
        k.c(bVar, H5Event.TYPE_CALL_BACK);
        k.c(aVarArr, "func_list");
        x.a aVar = new x.a();
        aVar.element = false;
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, f43788b, (CoroutineStart) null, new c(aVarArr, aVar, true, bVar, (kotlin.d.d) null), 2, (Object) null);
    }

    @f(b = "BackgroundUtils.kt", c = {89}, d = "invokeSuspend", e = "com.paytm.utility.storage.BackgroundUtils$performAndReturnFirstTask$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ kotlin.g.a.b $callback;
        final /* synthetic */ boolean $dispatchOnMainThread;
        final /* synthetic */ kotlin.g.a.a[] $func_list;
        final /* synthetic */ x.a $isProcessed;
        Object L$0;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(kotlin.g.a.a[] aVarArr, x.a aVar, boolean z, kotlin.g.a.b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.$func_list = aVarArr;
            this.$isProcessed = aVar;
            this.$dispatchOnMainThread = z;
            this.$callback = bVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.$func_list, this.$isProcessed, this.$dispatchOnMainThread, this.$callback, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        @f(b = "Emitters.kt", c = {161}, d = "invokeSuspend", e = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1")
        public static final class b extends kotlin.d.b.a.k implements m<FlowCollector<? super Object>, kotlin.d.d<? super kotlin.x>, Object> {
            final /* synthetic */ Flow $this_transform;
            Object L$0;
            Object L$1;
            int label;
            private FlowCollector p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(Flow flow, kotlin.d.d dVar) {
                super(2, dVar);
                this.$this_transform = flow;
            }

            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                b bVar = new b(this.$this_transform, dVar);
                bVar.p$ = (FlowCollector) obj;
                return bVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
            }

            public final Object invokeSuspend$$forInline(Object obj) {
                final FlowCollector flowCollector = this.p$;
                this.$this_transform.collect(new FlowCollector<Object>(this) {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ b f43792a;

                    {
                        this.f43792a = r1;
                    }

                    public final Object emit(Object obj, kotlin.d.d dVar) {
                        return flowCollector.emit(obj, dVar);
                    }
                }, this);
                return kotlin.x.f47997a;
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                int i2 = this.label;
                if (i2 == 0) {
                    ResultKt.a(obj);
                    final FlowCollector flowCollector = this.p$;
                    Flow flow = this.$this_transform;
                    this.L$0 = flowCollector;
                    this.L$1 = flow;
                    this.label = 1;
                    if (flow.collect(new FlowCollector<Object>(this) {

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ b f43790a;

                        {
                            this.f43790a = r1;
                        }

                        public final Object emit(Object obj, kotlin.d.d dVar) {
                            return flowCollector.emit(obj, dVar);
                        }
                    }, this) == aVar) {
                        return aVar;
                    }
                } else if (i2 == 1) {
                    ResultKt.a(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return kotlin.x.f47997a;
            }
        }

        /* renamed from: com.paytm.utility.d.a$c$a  reason: collision with other inner class name */
        public static final class C0753a implements FlowCollector<Object> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c f43789a;

            public C0753a(c cVar) {
                this.f43789a = cVar;
            }

            public final Object emit(Object obj, kotlin.d.d<? super kotlin.x> dVar) {
                if (!this.f43789a.$isProcessed.element) {
                    this.f43789a.$isProcessed.element = true;
                    a.a(this.f43789a.$dispatchOnMainThread, obj, this.f43789a.$callback);
                }
                return kotlin.x.f47997a;
            }
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                Flow flow = FlowKt.flow(new b(FlowKt.channelFlow(new m<ProducerScope<? super Object>, kotlin.d.d<? super kotlin.x>, Object>(this, (kotlin.d.d) null) {
                    int label;
                    private ProducerScope p$;
                    final /* synthetic */ c this$0;

                    {
                        this.this$0 = r1;
                    }

                    public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                        k.c(dVar, "completion");
                        AnonymousClass1 r0 = 

                        /* renamed from: com.paytm.utility.d.a$a  reason: collision with other inner class name */
                        public static final class C0752a extends kotlin.d.a implements CoroutineExceptionHandler {
                            public C0752a(f.c cVar) {
                                super(cVar);
                            }

                            public final void handleException(kotlin.d.f fVar, Throwable th) {
                                k.c(fVar, "context");
                                k.c(th, "exception");
                                q.d("handler got ".concat(String.valueOf(th)));
                                throw th;
                            }
                        }

                        public static final void a(boolean z, Object obj, kotlin.g.a.b<Object, kotlin.x> bVar) {
                            k.c(obj, "out");
                            k.c(bVar, H5Event.TYPE_CALL_BACK);
                            CoroutineDispatcher io2 = Dispatchers.getIO();
                            if (z) {
                                io2 = Dispatchers.getMain();
                            }
                            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, io2, (CoroutineStart) null, new b(bVar, obj, (kotlin.d.d) null), 2, (Object) null);
                        }

                        @kotlin.d.b.a.f(b = "BackgroundUtils.kt", c = {}, d = "invokeSuspend", e = "com.paytm.utility.storage.BackgroundUtils$dispatch$1")
                        static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                            final /* synthetic */ kotlin.g.a.b $callback;
                            final /* synthetic */ Object $out;
                            int label;
                            private CoroutineScope p$;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            b(kotlin.g.a.b bVar, Object obj, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.$callback = bVar;
                                this.$out = obj;
                            }

                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                k.c(dVar, "completion");
                                b bVar = new b(this.$callback, this.$out, dVar);
                                bVar.p$ = (CoroutineScope) obj;
                                return bVar;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else if (!(obj instanceof p.b)) {
                                    this.$callback.invoke(this.$out);
                                    return kotlin.x.f47997a;
                                } else {
                                    throw ((p.b) obj).exception;
                                }
                            }
                        }

                        @kotlin.d.b.a.f(b = "BackgroundUtils.kt", c = {}, d = "invokeSuspend", e = "com.paytm.utility.storage.BackgroundUtils$performTask$1")
                        static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
                            final /* synthetic */ kotlin.g.a.a $function;
                            int label;
                            private CoroutineScope p$;

                            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                            d(kotlin.g.a.a aVar, kotlin.d.d dVar) {
                                super(2, dVar);
                                this.$function = aVar;
                            }

                            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                                k.c(dVar, "completion");
                                d dVar2 = new d(this.$function, dVar);
                                dVar2.p$ = (CoroutineScope) obj;
                                return dVar2;
                            }

                            public final Object invoke(Object obj, Object obj2) {
                                return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
                            }

                            public final Object invokeSuspend(Object obj) {
                                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                                if (this.label != 0) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                } else if (!(obj instanceof p.b)) {
                                    this.$function.invoke();
                                    return kotlin.x.f47997a;
                                } else {
                                    throw ((p.b) obj).exception;
                                }
                            }
                        }
                    }
