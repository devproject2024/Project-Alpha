package com.bumptech.glide.load.b;

import androidx.core.g.e;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class t<Data, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    private final Class<Data> f6941a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a<List<Throwable>> f6942b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends i<Data, ResourceType, Transcode>> f6943c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6944d;

    public t(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<i<Data, ResourceType, Transcode>> list, e.a<List<Throwable>> aVar) {
        this.f6941a = cls;
        this.f6942b = aVar;
        this.f6943c = (List) j.a(list);
        this.f6944d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final v<Transcode> a(com.bumptech.glide.load.a.e<Data> eVar, i iVar, int i2, int i3, i.a<ResourceType> aVar) throws q {
        List list = (List) j.a(this.f6942b.a(), "Argument must not be null");
        try {
            return a(eVar, iVar, i2, i3, aVar, list);
        } finally {
            this.f6942b.a(list);
        }
    }

    private v<Transcode> a(com.bumptech.glide.load.a.e<Data> eVar, com.bumptech.glide.load.i iVar, int i2, int i3, i.a<ResourceType> aVar, List<Throwable> list) throws q {
        int size = this.f6943c.size();
        v<Transcode> vVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            i iVar2 = (i) this.f6943c.get(i4);
            try {
                vVar = iVar2.f6870a.a(aVar.a(iVar2.a(eVar, i2, i3, iVar)), iVar);
            } catch (q e2) {
                list.add(e2);
            }
            if (vVar != null) {
                break;
            }
        }
        if (vVar != null) {
            return vVar;
        }
        throw new q(this.f6944d, (List<Throwable>) new ArrayList(list));
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f6943c.toArray()) + '}';
    }
}
