package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcelable;
import androidx.versionedparcelable.a;
import java.nio.charset.Charset;

public class IconCompatParcelizer {
    public static IconCompat read(a aVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2984a = aVar.b(iconCompat.f2984a, 1);
        iconCompat.f2986c = aVar.c(iconCompat.f2986c);
        iconCompat.f2987d = aVar.b(iconCompat.f2987d, 3);
        iconCompat.f2988e = aVar.b(iconCompat.f2988e, 4);
        iconCompat.f2989f = aVar.b(iconCompat.f2989f, 5);
        iconCompat.f2990g = (ColorStateList) aVar.b(iconCompat.f2990g, 6);
        iconCompat.j = aVar.c(iconCompat.j);
        iconCompat.f2991i = PorterDuff.Mode.valueOf(iconCompat.j);
        switch (iconCompat.f2984a) {
            case -1:
                if (iconCompat.f2987d != null) {
                    iconCompat.f2985b = iconCompat.f2987d;
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid icon");
                }
            case 1:
            case 5:
                if (iconCompat.f2987d == null) {
                    iconCompat.f2985b = iconCompat.f2986c;
                    iconCompat.f2984a = 3;
                    iconCompat.f2988e = 0;
                    iconCompat.f2989f = iconCompat.f2986c.length;
                    break;
                } else {
                    iconCompat.f2985b = iconCompat.f2987d;
                    break;
                }
            case 2:
            case 4:
            case 6:
                iconCompat.f2985b = new String(iconCompat.f2986c, Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f2985b = iconCompat.f2986c;
                break;
        }
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, a aVar) {
        iconCompat.j = iconCompat.f2991i.name();
        switch (iconCompat.f2984a) {
            case -1:
                iconCompat.f2987d = (Parcelable) iconCompat.f2985b;
                break;
            case 1:
            case 5:
                iconCompat.f2987d = (Parcelable) iconCompat.f2985b;
                break;
            case 2:
                iconCompat.f2986c = ((String) iconCompat.f2985b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f2986c = (byte[]) iconCompat.f2985b;
                break;
            case 4:
            case 6:
                iconCompat.f2986c = iconCompat.f2985b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        if (-1 != iconCompat.f2984a) {
            aVar.a(iconCompat.f2984a, 1);
        }
        if (iconCompat.f2986c != null) {
            aVar.b(iconCompat.f2986c);
        }
        if (iconCompat.f2987d != null) {
            aVar.a(iconCompat.f2987d, 3);
        }
        if (iconCompat.f2988e != 0) {
            aVar.a(iconCompat.f2988e, 4);
        }
        if (iconCompat.f2989f != 0) {
            aVar.a(iconCompat.f2989f, 5);
        }
        if (iconCompat.f2990g != null) {
            aVar.a((Parcelable) iconCompat.f2990g, 6);
        }
        if (iconCompat.j != null) {
            aVar.b(iconCompat.j);
        }
    }
}
