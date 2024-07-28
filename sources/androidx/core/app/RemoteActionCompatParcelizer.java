package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcelable;
import androidx.core.graphics.drawable.IconCompat;
import androidx.versionedparcelable.a;
import androidx.versionedparcelable.c;

public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(a aVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        remoteActionCompat.f2653a = (IconCompat) aVar.c(remoteActionCompat.f2653a);
        remoteActionCompat.f2654b = aVar.b(remoteActionCompat.f2654b, 2);
        remoteActionCompat.f2655c = aVar.b(remoteActionCompat.f2655c, 3);
        remoteActionCompat.f2656d = (PendingIntent) aVar.b(remoteActionCompat.f2656d, 4);
        remoteActionCompat.f2657e = aVar.b(remoteActionCompat.f2657e, 5);
        remoteActionCompat.f2658f = aVar.b(remoteActionCompat.f2658f, 6);
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, a aVar) {
        aVar.a((c) remoteActionCompat.f2653a);
        aVar.a(remoteActionCompat.f2654b, 2);
        aVar.a(remoteActionCompat.f2655c, 3);
        aVar.a((Parcelable) remoteActionCompat.f2656d, 4);
        aVar.a(remoteActionCompat.f2657e, 5);
        aVar.a(remoteActionCompat.f2658f, 6);
    }
}
