package com.alibaba.a.c;

import com.alibaba.a.a.b;
import com.alibaba.a.d;
import com.alibaba.a.d.c;
import com.alibaba.a.d.g;
import com.business.merchant_payments.common.utility.AppUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Member;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    protected final c f6336a;

    /* renamed from: b  reason: collision with root package name */
    boolean f6337b = false;

    /* renamed from: c  reason: collision with root package name */
    private final String f6338c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6339d;

    /* renamed from: e  reason: collision with root package name */
    private final String f6340e;

    public abstract void a(ah ahVar, Object obj) throws Exception;

    public abstract void b(ah ahVar, Object obj) throws Exception;

    public w(c cVar) {
        this.f6336a = cVar;
        if (cVar.f6352b != null) {
            g.a((AccessibleObject) cVar.f6352b);
        } else {
            g.a((AccessibleObject) cVar.f6353c);
        }
        this.f6338c = "\"" + cVar.f6351a + "\":";
        this.f6339d = "'" + cVar.f6351a + "':";
        this.f6340e = cVar.f6351a + AppConstants.COLON;
        b bVar = (b) cVar.a(b.class);
        if (bVar != null) {
            for (bb bbVar : bVar.f()) {
                if (bbVar == bb.WriteMapNullValue) {
                    this.f6337b = true;
                }
            }
        }
    }

    public final Field a() {
        return this.f6336a.f6353c;
    }

    public final String b() {
        return this.f6336a.f6351a;
    }

    public final Object a(Object obj) throws Exception {
        Member member;
        try {
            return this.f6336a.a(obj);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder("get property error。 ");
            c cVar = this.f6336a;
            if (cVar.f6352b != null) {
                member = cVar.f6352b;
            } else {
                member = cVar.f6353c;
            }
            sb.append(member.getDeclaringClass().getName() + AppUtility.CENTER_DOT + member.getName());
            throw new d(sb.toString(), e2);
        }
    }

    public final void a(ah ahVar) throws IOException {
        ba baVar = ahVar.f6266a;
        if (!ahVar.b(bb.QuoteFieldNames)) {
            baVar.write(this.f6340e);
        } else if (ahVar.b(bb.UseSingleQuotes)) {
            baVar.write(this.f6339d);
        } else {
            baVar.write(this.f6338c);
        }
    }
}
