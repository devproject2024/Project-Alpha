package com.google.android.play.core.assetpacks;

import android.os.Bundle;
import com.google.android.play.core.b.b;
import com.google.android.play.core.b.bh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;

final class bo {

    /* renamed from: a  reason: collision with root package name */
    static final b f37071a = new b("ExtractorSessionStoreView");

    /* renamed from: b  reason: collision with root package name */
    final ad f37072b;

    /* renamed from: c  reason: collision with root package name */
    final bh<dk> f37073c;

    /* renamed from: d  reason: collision with root package name */
    final ba f37074d;

    /* renamed from: e  reason: collision with root package name */
    final Map<Integer, bl> f37075e = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    final ReentrantLock f37076f = new ReentrantLock();

    /* renamed from: g  reason: collision with root package name */
    private final bh<Executor> f37077g;

    bo(ad adVar, bh<dk> bhVar, ba baVar, bh<Executor> bhVar2) {
        this.f37072b = adVar;
        this.f37073c = bhVar;
        this.f37074d = baVar;
        this.f37077g = bhVar2;
    }

    static String a(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList != null && !stringArrayList.isEmpty()) {
            return stringArrayList.get(0);
        }
        throw new ax("Session without pack received.");
    }

    static <T> List<T> a(List<T> list) {
        return list == null ? Collections.emptyList() : list;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        a(new bi(this, i2));
    }

    /* access modifiers changed from: package-private */
    public final bl b(int i2) {
        Map<Integer, bl> map = this.f37075e;
        Integer valueOf = Integer.valueOf(i2);
        bl blVar = map.get(valueOf);
        if (blVar != null) {
            return blVar;
        }
        throw new ax(String.format("Could not find session %d while trying to get it", new Object[]{valueOf}), i2);
    }

    /* access modifiers changed from: package-private */
    public final void c(int i2) {
        a(new bh(this, i2));
    }

    /* access modifiers changed from: package-private */
    public final <T> T a(bn<T> bnVar) {
        try {
            this.f37076f.lock();
            return bnVar.a();
        } finally {
            this.f37076f.unlock();
        }
    }
}
