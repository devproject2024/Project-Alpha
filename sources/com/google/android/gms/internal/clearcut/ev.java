package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

final class ev implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private et<?, ?> f9351a;

    /* renamed from: b  reason: collision with root package name */
    private Object f9352b;

    /* renamed from: c  reason: collision with root package name */
    private List<Object> f9353c = new ArrayList();

    ev() {
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final ev clone() {
        Object clone;
        ev evVar = new ev();
        try {
            evVar.f9351a = this.f9351a;
            if (this.f9353c == null) {
                evVar.f9353c = null;
            } else {
                evVar.f9353c.addAll(this.f9353c);
            }
            if (this.f9352b != null) {
                if (this.f9352b instanceof ex) {
                    clone = (ex) ((ex) this.f9352b).clone();
                } else if (this.f9352b instanceof byte[]) {
                    clone = ((byte[]) this.f9352b).clone();
                } else {
                    int i2 = 0;
                    if (this.f9352b instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) this.f9352b;
                        byte[][] bArr2 = new byte[bArr.length][];
                        evVar.f9352b = bArr2;
                        while (i2 < bArr.length) {
                            bArr2[i2] = (byte[]) bArr[i2].clone();
                            i2++;
                        }
                    } else if (this.f9352b instanceof boolean[]) {
                        clone = ((boolean[]) this.f9352b).clone();
                    } else if (this.f9352b instanceof int[]) {
                        clone = ((int[]) this.f9352b).clone();
                    } else if (this.f9352b instanceof long[]) {
                        clone = ((long[]) this.f9352b).clone();
                    } else if (this.f9352b instanceof float[]) {
                        clone = ((float[]) this.f9352b).clone();
                    } else if (this.f9352b instanceof double[]) {
                        clone = ((double[]) this.f9352b).clone();
                    } else if (this.f9352b instanceof ex[]) {
                        ex[] exVarArr = (ex[]) this.f9352b;
                        ex[] exVarArr2 = new ex[exVarArr.length];
                        evVar.f9352b = exVarArr2;
                        while (i2 < exVarArr.length) {
                            exVarArr2[i2] = (ex) exVarArr[i2].clone();
                            i2++;
                        }
                    }
                }
                evVar.f9352b = clone;
            }
            return evVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    /* access modifiers changed from: package-private */
    public final int a() {
        if (this.f9352b == null) {
            Iterator<Object> it2 = this.f9353c.iterator();
            if (!it2.hasNext()) {
                return 0;
            }
            it2.next();
            throw new NoSuchMethodError();
        }
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void b() throws IOException {
        if (this.f9352b == null) {
            Iterator<Object> it2 = this.f9353c.iterator();
            if (it2.hasNext()) {
                it2.next();
                throw new NoSuchMethodError();
            }
            return;
        }
        throw new NoSuchMethodError();
    }

    public final boolean equals(Object obj) {
        List<Object> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ev)) {
            return false;
        }
        ev evVar = (ev) obj;
        if (this.f9352b == null || evVar.f9352b == null) {
            List<Object> list2 = this.f9353c;
            if (list2 != null && (list = evVar.f9353c) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(c(), evVar.c());
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            et<?, ?> etVar = this.f9351a;
            if (etVar != evVar.f9351a) {
                return false;
            }
            if (!etVar.f9345a.isArray()) {
                return this.f9352b.equals(evVar.f9352b);
            }
            Object obj2 = this.f9352b;
            return obj2 instanceof byte[] ? Arrays.equals((byte[]) obj2, (byte[]) evVar.f9352b) : obj2 instanceof int[] ? Arrays.equals((int[]) obj2, (int[]) evVar.f9352b) : obj2 instanceof long[] ? Arrays.equals((long[]) obj2, (long[]) evVar.f9352b) : obj2 instanceof float[] ? Arrays.equals((float[]) obj2, (float[]) evVar.f9352b) : obj2 instanceof double[] ? Arrays.equals((double[]) obj2, (double[]) evVar.f9352b) : obj2 instanceof boolean[] ? Arrays.equals((boolean[]) obj2, (boolean[]) evVar.f9352b) : Arrays.deepEquals((Object[]) obj2, (Object[]) evVar.f9352b);
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(c()) + 527;
        } catch (IOException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private final byte[] c() throws IOException {
        byte[] bArr = new byte[a()];
        eq.a(bArr, 0);
        b();
        return bArr;
    }
}
