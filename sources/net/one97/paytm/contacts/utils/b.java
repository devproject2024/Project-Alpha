package net.one97.paytm.contacts.utils;

import java.util.LinkedHashSet;
import kotlin.g.b.k;
import net.one97.paytm.contacts.entities.beans.ContactDetail;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f50245a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static LinkedHashSet<ContactDetail> f50246b = new LinkedHashSet<>();

    private b() {
    }

    public static void a(LinkedHashSet<ContactDetail> linkedHashSet) {
        k.c(linkedHashSet, "contactDetails");
        f50246b = linkedHashSet;
    }

    public static LinkedHashSet<ContactDetail> a() {
        return f50246b;
    }

    public static void b() {
        f50246b = new LinkedHashSet<>();
    }
}
