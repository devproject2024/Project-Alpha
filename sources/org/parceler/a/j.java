package org.parceler.a;

import android.os.Parcel;
import java.util.Map;
import org.parceler.i;

public abstract class j<K, V, M extends Map<K, V>> implements i<Map<K, V>, M> {
    public abstract K a(Parcel parcel);

    public abstract M a();

    public abstract void a(K k, Parcel parcel);

    public abstract V b(Parcel parcel);

    public abstract void b(V v, Parcel parcel);

    public final /* synthetic */ void c(Object obj, Parcel parcel) {
        Map map = (Map) obj;
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry entry : map.entrySet()) {
            a(entry.getKey(), parcel);
            b(entry.getValue(), parcel);
        }
    }

    public final /* synthetic */ Object c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        Map a2 = a();
        for (int i2 = 0; i2 < readInt; i2++) {
            a2.put(a(parcel), b(parcel));
        }
        return a2;
    }
}
