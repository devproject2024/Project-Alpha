package net.one97.paytm.moneytransferv4.accounts;

import kotlin.g.b.k;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f54920a;

    /* renamed from: b  reason: collision with root package name */
    public final String f54921b;

    /* renamed from: c  reason: collision with root package name */
    final String f54922c;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f54920a == dVar.f54920a && k.a((Object) this.f54921b, (Object) dVar.f54921b) && k.a((Object) this.f54922c, (Object) dVar.f54922c);
    }

    public final int hashCode() {
        boolean z = this.f54920a;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        String str = this.f54921b;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f54922c;
        if (str2 != null) {
            i3 = str2.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "AccountDeleteResponse(isSuccess=" + this.f54920a + ", errorCode=" + this.f54921b + ", errorMessage=" + this.f54922c + ")";
    }

    public d(boolean z, String str, String str2) {
        k.c(str2, ImagePickerUtils.IMAGE_PICKER_KEY_ERROR_MESSAGE);
        this.f54920a = z;
        this.f54921b = str;
        this.f54922c = str2;
    }

    public /* synthetic */ d() {
        this(true, (String) null, "");
    }
}
