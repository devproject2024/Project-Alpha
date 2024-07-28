package net.one97.paytm.h5.b;

import java.io.Serializable;
import net.one97.paytm.h5.c;
import net.one97.paytm.h5paytmsdk.c.q;
import net.one97.paytm.h5paytmsdk.c.r;

public final class e implements Serializable, q {
    private String verticalName;

    public e(String str) {
        this.verticalName = str;
    }

    public final void provideValuesForKeys(String str, r rVar) {
        c cVar = c.f50543a;
        c.a(this.verticalName, str, new c.C0910c() {
            public final void onResult(Object obj) {
                e.lambda$provideValuesForKeys$0(r.this, obj);
            }
        });
    }

    static /* synthetic */ void lambda$provideValuesForKeys$0(r rVar, Object obj) {
        if (rVar != null) {
            rVar.a(obj);
        }
    }
}
