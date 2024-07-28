package net.one97.paytm.contacts.utils;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.contacts.entities.beans.ContactDetail;
import net.one97.paytm.contacts.utils.e;
import net.one97.paytm.utils.x;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    Queue<Integer> f50270a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    HashMap<Integer, Boolean> f50271b;

    /* renamed from: c  reason: collision with root package name */
    private Context f50272c;

    /* renamed from: d  reason: collision with root package name */
    private int f50273d;

    /* renamed from: e  reason: collision with root package name */
    private x.e f50274e;

    /* renamed from: f  reason: collision with root package name */
    private int f50275f;

    public f(Context context, int i2, x.e eVar) {
        k.c(context, "context");
        k.c(eVar, "listener");
        this.f50272c = context;
        this.f50273d = i2;
        this.f50274e = eVar;
        this.f50271b = new HashMap<>();
    }

    public final void a(Integer[] numArr) {
        k.c(numArr, "parms");
        this.f50275f = numArr.length;
        for (Integer intValue : numArr) {
            int intValue2 = intValue.intValue();
            if (intValue2 == e.g.PHONEBOOK.getType() || intValue2 == e.g.TRANSFER_BEN.getType()) {
                this.f50271b.put(Integer.valueOf(intValue2), Boolean.FALSE);
            }
            this.f50270a.add(Integer.valueOf(intValue2));
        }
        a();
    }

    public final void a() {
        if (this.f50270a.isEmpty()) {
            this.f50274e.d();
            return;
        }
        Integer peek = this.f50270a.peek();
        k.a((Object) peek, "syncReqt.peek()");
        a(peek.intValue());
    }

    public static final class a implements x.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f50276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f50277b;

        public final void d() {
        }

        a(f fVar, int i2) {
            this.f50276a = fVar;
            this.f50277b = i2;
        }

        public final void a(ArrayList<ContactDetail> arrayList) {
            k.c(arrayList, "contactList");
            k.c(arrayList, "contactList");
        }

        public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
            k.c(linkedHashSet, "contactList");
            k.c(linkedHashSet, "contactList");
        }

        public final void b(e.h hVar, Context context, int i2) {
            k.c(hVar, "sycing");
            k.c(context, "context");
            x.e.a.a(hVar, context);
        }

        public final void a(e.h hVar, Context context, int i2, boolean z) {
            k.c(hVar, "sycing");
            k.c(context, "context");
            this.f50276a.f50270a.poll();
            this.f50276a.f50271b.put(Integer.valueOf(this.f50277b), Boolean.TRUE);
            this.f50276a.b();
            this.f50276a.a();
        }
    }

    public static final class b implements x.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f50278a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f50279b;

        public final void d() {
        }

        b(f fVar, int i2) {
            this.f50278a = fVar;
            this.f50279b = i2;
        }

        public final void a(ArrayList<ContactDetail> arrayList) {
            k.c(arrayList, "contactList");
            k.c(arrayList, "contactList");
        }

        public final void a(LinkedHashSet<IJRDataModel> linkedHashSet) {
            k.c(linkedHashSet, "contactList");
            k.c(linkedHashSet, "contactList");
        }

        public final void a(e.h hVar, Context context, int i2, boolean z) {
            k.c(hVar, "sycing");
            k.c(context, "context");
            x.e.a.b(hVar, context);
        }

        public final void b(e.h hVar, Context context, int i2) {
            k.c(hVar, "sycing");
            k.c(context, "context");
            this.f50278a.f50270a.poll();
            this.f50278a.f50271b.put(Integer.valueOf(this.f50279b), Boolean.TRUE);
            this.f50278a.b();
            this.f50278a.a();
        }
    }

    private void a(int i2) {
        if (i2 == 1) {
            new net.one97.paytm.contacts.sync.f(this.f50272c, new a(this, i2), this.f50273d).a();
        } else if (i2 == 2) {
            new net.one97.paytm.contacts.sync.b(this.f50272c, new b(this, i2), e.b.TRANSFER_BENEFICIARY.getType(), this.f50273d).a();
        } else if (i2 == 3) {
            this.f50270a.poll();
            this.f50274e.b(e.h.TRANSFER_BEN_CALL_DONE, this.f50272c, this.f50273d);
        }
    }

    public final void b() {
        if (this.f50271b.size() != this.f50275f) {
            boolean z = true;
            Iterator it2 = this.f50271b.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it2.next();
                ((Number) entry.getKey()).intValue();
                if (!((Boolean) entry.getValue()).booleanValue()) {
                    z = false;
                    break;
                }
            }
            if (z) {
                this.f50274e.d();
            }
        }
    }
}
