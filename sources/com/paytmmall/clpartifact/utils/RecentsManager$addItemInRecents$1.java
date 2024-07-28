package com.paytmmall.clpartifact.utils;

import kotlin.d.a.a;
import kotlin.d.b.a.f;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

@f(b = "RecentsManager.kt", c = {50}, d = "invokeSuspend", e = "com/paytmmall/clpartifact/utils/RecentsManager$addItemInRecents$1")
final class RecentsManager$addItemInRecents$1 extends k implements m<CoroutineScope, d<? super x>, Object> {
    final /* synthetic */ String $itemName;
    int label;
    private CoroutineScope p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RecentsManager$addItemInRecents$1(String str, d dVar) {
        super(2, dVar);
        this.$itemName = str;
    }

    public final d<x> create(Object obj, d<?> dVar) {
        kotlin.g.b.k.c(dVar, "completion");
        RecentsManager$addItemInRecents$1 recentsManager$addItemInRecents$1 = new RecentsManager$addItemInRecents$1(this.$itemName, dVar);
        recentsManager$addItemInRecents$1.p$ = (CoroutineScope) obj;
        return recentsManager$addItemInRecents$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((RecentsManager$addItemInRecents$1) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
    }

    public final Object invokeSuspend(Object obj) {
        a aVar = a.COROUTINE_SUSPENDED;
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof p.b)) {
            RecentsManager.INSTANCE.addItemInRecentsBG(this.$itemName);
            return x.f47997a;
        } else {
            throw ((p.b) obj).exception;
        }
    }
}
