package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.ch;
import com.google.android.gms.internal.p001firebaseperf.ci;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-perf.ci  reason: invalid package */
public abstract class ci<MessageType extends ci<MessageType, BuilderType>, BuilderType extends ch<MessageType, BuilderType>> implements ex {
    private static boolean zzmv = false;
    protected int zzmu = 0;

    public final co i() {
        try {
            cw zzs = co.zzs(o());
            a(zzs.f9528a);
            zzs.f9528a.i();
            return new cy(zzs.f9529b);
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

    public final byte[] j() {
        try {
            byte[] bArr = new byte[o()];
            da a2 = da.a(bArr);
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
    public int k() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void a(Iterable<T> iterable, List<? super T> list) {
        dt.a(iterable);
        if (iterable instanceof ej) {
            List<?> d2 = ((ej) iterable).d();
            ej ejVar = (ej) list;
            int size = list.size();
            for (Object next : d2) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(ejVar.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = ejVar.size() - 1; size2 >= size; size2--) {
                        ejVar.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof co) {
                    ejVar.a((co) next);
                } else {
                    ejVar.add((String) next);
                }
            }
        } else if (iterable instanceof fl) {
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
