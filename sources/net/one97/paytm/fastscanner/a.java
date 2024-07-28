package net.one97.paytm.fastscanner;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import net.one97.paytm.fastscanner.a.b;
import net.one97.paytm.fastscanner.b.b;
import net.one97.paytm.fastscanner.b.e;
import net.one97.paytm.fastscanner.c.c;

public final class a extends Handler {
    public final void handleMessage(Message message) {
        k.c(message, "message");
        if (message.what == R.id.decode_succeeded) {
            Object obj = message.obj;
            k.a(obj, "message.obj");
            ArrayList<e> a2 = a(obj);
            b bVar = b.f50423a;
            b.a("ganesh", "scanned data".concat(String.valueOf(a2)));
            net.one97.paytm.fastscanner.c.a aVar = net.one97.paytm.fastscanner.c.a.f50448b;
            c a3 = net.one97.paytm.fastscanner.c.a.a();
            if (a3 != null) {
                Iterator<e> it2 = a2.iterator();
                while (it2.hasNext()) {
                    e next = it2.next();
                    k.a((Object) next, "qrData");
                    a3.a(next);
                }
            }
        } else if (message.what == R.id.decode_succeeded_gallery) {
            Object obj2 = message.obj;
            k.a(obj2, "message.obj");
            ArrayList<e> a4 = a(obj2);
            b bVar2 = b.f50423a;
            b.a("ganesh", "scanned data from gallery".concat(String.valueOf(a4)));
            net.one97.paytm.fastscanner.c.a aVar2 = net.one97.paytm.fastscanner.c.a.f50448b;
            c a5 = net.one97.paytm.fastscanner.c.a.a();
            if (a5 != null) {
                Iterator<e> it3 = a4.iterator();
                while (it3.hasNext()) {
                    e next2 = it3.next();
                    k.a((Object) next2, "qrData");
                    a5.b(next2);
                }
            }
        } else if (message.what == R.id.exception) {
            b bVar3 = b.f50423a;
            b.a("ganesh", "scanned data from gallery is not recognised");
            net.one97.paytm.fastscanner.c.a aVar3 = net.one97.paytm.fastscanner.c.a.f50448b;
            c a6 = net.one97.paytm.fastscanner.c.a.a();
            if (a6 != null) {
                a6.a();
            }
        }
        b.a aVar4 = net.one97.paytm.fastscanner.a.b.f50413c;
        net.one97.paytm.fastscanner.a.b e2 = net.one97.paytm.fastscanner.a.b.f50414f;
        if (e2 != null) {
            e2.a(R.id.decode);
        }
    }

    private static ArrayList<e> a(Object obj) {
        ArrayList<e> arrayList = new ArrayList<>();
        if (obj instanceof Object[]) {
            for (Object obj2 : (Object[]) obj) {
                if (obj2 instanceof e) {
                    if (((e) obj2).f50433a.length() > 0) {
                        arrayList.add(obj2);
                    }
                }
            }
        }
        if (obj instanceof ArrayList) {
            Iterator it2 = ((ArrayList) obj).iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (next instanceof e) {
                    if (((e) next).f50433a.length() > 0) {
                        arrayList.add(next);
                    }
                }
            }
        }
        return arrayList;
    }
}
