package net.one97.paytm.managebeneficiary;

import android.content.Context;
import android.text.TextUtils;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class f {

    /* renamed from: b  reason: collision with root package name */
    private static f f53294b;

    /* renamed from: a  reason: collision with root package name */
    private g f53295a;

    public static void a(g gVar) {
        if (f53294b == null) {
            f fVar = new f();
            f53294b = fVar;
            fVar.f53295a = gVar;
        }
    }

    private static f b() {
        if (f53294b == null) {
            synchronized (f.class) {
                try {
                    Class.forName("net.one97.paytm.landingpage.utils.MBModuleCommunicator").getMethod("init", new Class[0]).invoke((Object) null, new Object[0]);
                } catch (ClassNotFoundException e2) {
                    q.b(e2.getMessage());
                } catch (IllegalAccessException e3) {
                    q.b(e3.getMessage());
                } catch (NoSuchMethodException e4) {
                    q.b(e4.getMessage());
                } catch (InvocationTargetException e5) {
                    q.b(e5.getMessage());
                }
            }
        }
        f fVar = f53294b;
        if (fVar != null) {
            return fVar;
        }
        throw new RuntimeException("getInstance() called before MBModuleCommunicator's init()");
    }

    public static g a() {
        return b().f53295a;
    }

    public static a a(Context context, String str, b bVar, Map<String, String> map, a.C0715a aVar, String str2, IJRPaytmDataModel iJRPaytmDataModel, a.c cVar, a.b bVar2) {
        com.paytm.network.b bVar3 = new com.paytm.network.b();
        bVar3.f42877a = context;
        bVar3.f42878b = cVar;
        bVar3.f42879c = aVar;
        bVar3.n = bVar2;
        bVar3.o = context.getClass().getSimpleName();
        bVar3.f42880d = str;
        bVar3.f42885i = iJRPaytmDataModel;
        bVar3.j = bVar;
        bVar3.f42882f = map;
        if (!TextUtils.isEmpty(str2)) {
            bVar3.f42884h = str2;
        }
        return bVar3.l();
    }
}
