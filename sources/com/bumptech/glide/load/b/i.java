package com.bumptech.glide.load.b;

import android.util.Log;
import androidx.core.g.e;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.d.f.e;
import com.bumptech.glide.load.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class i<DataType, ResourceType, Transcode> {

    /* renamed from: a  reason: collision with root package name */
    final e<ResourceType, Transcode> f6870a;

    /* renamed from: b  reason: collision with root package name */
    private final Class<DataType> f6871b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends k<DataType, ResourceType>> f6872c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a<List<Throwable>> f6873d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6874e;

    interface a<ResourceType> {
        v<ResourceType> a(v<ResourceType> vVar);
    }

    public i(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends k<DataType, ResourceType>> list, com.bumptech.glide.load.d.f.e<ResourceType, Transcode> eVar, e.a<List<Throwable>> aVar) {
        this.f6871b = cls;
        this.f6872c = list;
        this.f6870a = eVar;
        this.f6873d = aVar;
        this.f6874e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* access modifiers changed from: package-private */
    public final v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i2, int i3, com.bumptech.glide.load.i iVar) throws q {
        List list = (List) j.a(this.f6873d.a(), "Argument must not be null");
        try {
            return a(eVar, i2, i3, iVar, list);
        } finally {
            this.f6873d.a(list);
        }
    }

    private v<ResourceType> a(com.bumptech.glide.load.a.e<DataType> eVar, int i2, int i3, com.bumptech.glide.load.i iVar, List<Throwable> list) throws q {
        int size = this.f6872c.size();
        v<ResourceType> vVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            k kVar = (k) this.f6872c.get(i4);
            try {
                if (kVar.a(eVar.a(), iVar)) {
                    vVar = kVar.a(eVar.a(), i2, i3, iVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e2) {
                if (Log.isLoggable("DecodePath", 2)) {
                    new StringBuilder("Failed to decode data for ").append(kVar);
                }
                list.add(e2);
            }
            if (vVar != null) {
                break;
            }
        }
        if (vVar != null) {
            return vVar;
        }
        throw new q(this.f6874e, (List<Throwable>) new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f6871b + ", decoders=" + this.f6872c + ", transcoder=" + this.f6870a + '}';
    }
}
