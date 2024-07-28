package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.ce;
import com.google.android.gms.internal.measurement.cf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class ce<MessageType extends ce<MessageType, BuilderType>, BuilderType extends cf<MessageType, BuilderType>> implements ff {
    protected int zza = 0;

    public final cm h() {
        try {
            cv zzc = cm.zzc(n());
            a(zzc.f10536a);
            return zzc.a();
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final byte[] i() {
        try {
            byte[] bArr = new byte[n()];
            de a2 = de.a(bArr);
            a(a2);
            a2.i();
            return bArr;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public int j() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void a(Iterable<T> iterable, List<? super T> list) {
        dx.a(iterable);
        if (iterable instanceof em) {
            List<?> q_ = ((em) iterable).q_();
            em emVar = (em) list;
            int size = list.size();
            for (Object next : q_) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(emVar.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = emVar.size() - 1; size2 >= size; size2--) {
                        emVar.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof cm) {
                    emVar.a((cm) next);
                } else {
                    emVar.add((String) next);
                }
            }
        } else if (iterable instanceof fs) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}
