package net.one97.paytm.trustlist;

import java.util.ArrayList;
import java.util.Iterator;
import net.one97.paytm.common.entity.trustlist.MessageInfo;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    private static c f65172b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<MessageInfo> f65173a = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private boolean f65174c = false;

    /* renamed from: d  reason: collision with root package name */
    private String f65175d = "";

    private c() {
    }

    public static c a() {
        if (f65172b == null) {
            f65172b = new c();
        }
        return f65172b;
    }

    public final synchronized void a(String str) {
        ArrayList<MessageInfo> arrayList = new ArrayList<>();
        if (!this.f65174c) {
            this.f65173a = arrayList;
            return;
        }
        this.f65175d = str;
        Iterator<MessageInfo> it2 = this.f65173a.iterator();
        while (it2.hasNext()) {
            MessageInfo next = it2.next();
            if (next.getBody().contains(str)) {
                arrayList.add(next);
            }
        }
        this.f65173a = arrayList;
    }

    public final synchronized void a(boolean z) {
        if (!z) {
            this.f65173a = new ArrayList<>();
        }
        this.f65174c = z;
    }
}
