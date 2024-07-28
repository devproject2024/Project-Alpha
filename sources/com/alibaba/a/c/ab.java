package com.alibaba.a.c;

import com.alibaba.a.b.a.z;
import com.alibaba.a.b.b;
import com.alibaba.a.b.d;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public final class ab implements z, at {

    /* renamed from: a  reason: collision with root package name */
    public static ab f6261a = new ab();

    public final int a() {
        return 12;
    }

    public final <T> T a(b bVar, Type type, Object obj) {
        d g2 = bVar.g();
        if (g2.a() == 8) {
            g2.d();
            return null;
        }
        bVar.a(12);
        InetAddress inetAddress = null;
        int i2 = 0;
        while (true) {
            String l = g2.l();
            g2.a(17);
            if (l.equals(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS)) {
                bVar.a(17);
                inetAddress = (InetAddress) bVar.a((Type) InetAddress.class);
            } else if (l.equals("port")) {
                bVar.a(17);
                if (g2.a() == 2) {
                    i2 = g2.n();
                    g2.d();
                } else {
                    throw new com.alibaba.a.d("port is not int");
                }
            } else {
                bVar.a(17);
                bVar.a((Object) null);
            }
            if (g2.a() == 16) {
                g2.d();
            } else {
                bVar.a(13);
                return new InetSocketAddress(inetAddress, i2);
            }
        }
    }

    public final void a(ah ahVar, Object obj, Object obj2, Type type) throws IOException {
        if (obj == null) {
            ahVar.f6266a.write("null");
            return;
        }
        ba baVar = ahVar.f6266a;
        InetSocketAddress inetSocketAddress = (InetSocketAddress) obj;
        InetAddress address = inetSocketAddress.getAddress();
        baVar.a('{');
        if (address != null) {
            baVar.a(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS, false);
            ahVar.c(address);
            baVar.a(',');
        }
        baVar.a("port", false);
        baVar.a(inetSocketAddress.getPort());
        baVar.a('}');
    }
}
