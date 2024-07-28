package com.paytmmall.clpartifact.utils;

import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "SFGsonUtils.kt", c = {42}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/utils/SFGsonUtils$getSFPojo$2")
final class SFGsonUtils$getSFPojo$2 extends k implements m<CoroutineScope, d<? super T>, Object> {
    final /* synthetic */ Object $obj;
    final /* synthetic */ Class $targetClass;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SFGsonUtils$getSFPojo$2(Object obj, Class cls, d dVar) {
        super(2, dVar);
        this.$obj = obj;
        this.$targetClass = cls;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        SFGsonUtils$getSFPojo$2 sFGsonUtils$getSFPojo$2 = new SFGsonUtils$getSFPojo$2(this.$obj, this.$targetClass, dVar);
        sFGsonUtils$getSFPojo$2.p$ = (CoroutineScope) obj;
        return sFGsonUtils$getSFPojo$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SFGsonUtils$getSFPojo$2) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof p.b)) {
            return SFGsonUtils.INSTANCE.getSFPojoWithoutCoroutine(this.$obj, this.$targetClass);
        } else {
            throw ((p.b) obj).exception;
        }
    }
}
