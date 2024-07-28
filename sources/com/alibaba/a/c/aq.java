package com.alibaba.a.c;

import com.alibaba.a.d.c;

final class aq extends w {
    public aq(c cVar) {
        super(cVar);
    }

    public final void a(ah ahVar, Object obj) throws Exception {
        a(ahVar);
        b(ahVar, obj);
    }

    public final void b(ah ahVar, Object obj) throws Exception {
        ba baVar = ahVar.f6266a;
        if (obj != null) {
            baVar.append((CharSequence) obj.toString());
        } else if (baVar.b(bb.WriteNullNumberAsZero)) {
            baVar.a('0');
        } else {
            baVar.write("null");
        }
    }
}
