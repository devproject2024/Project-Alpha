package org.parceler.a;

import android.os.Parcel;
import java.util.Collection;
import org.parceler.i;

public abstract class d<T, C extends Collection<T>> implements i<Collection<T>, C> {
    public abstract T a(Parcel parcel);

    public abstract C a();

    public abstract void a(T t, Parcel parcel);

    public final /* synthetic */ void c(Object obj, Parcel parcel) {
        Collection<Object> collection = (Collection) obj;
        if (collection == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(collection.size());
        for (Object a2 : collection) {
            a(a2, parcel);
        }
    }

    public final /* synthetic */ Object c(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        Collection a2 = a();
        for (int i2 = 0; i2 < readInt; i2++) {
            a2.add(a(parcel));
        }
        return a2;
    }
}
