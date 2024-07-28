package androidx.core.app;

import android.app.Person;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import com.alipay.mobile.h5container.api.H5Param;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public CharSequence f2781a;

    /* renamed from: b  reason: collision with root package name */
    IconCompat f2782b;

    /* renamed from: c  reason: collision with root package name */
    public String f2783c;

    /* renamed from: d  reason: collision with root package name */
    public String f2784d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2785e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f2786f;

    l(a aVar) {
        this.f2781a = aVar.f2787a;
        this.f2782b = aVar.f2788b;
        this.f2783c = aVar.f2789c;
        this.f2784d = aVar.f2790d;
        this.f2785e = aVar.f2791e;
        this.f2786f = aVar.f2792f;
    }

    public final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("name", this.f2781a);
        IconCompat iconCompat = this.f2782b;
        bundle.putBundle(H5Param.MENU_ICON, iconCompat != null ? iconCompat.c() : null);
        bundle.putString("uri", this.f2783c);
        bundle.putString("key", this.f2784d);
        bundle.putBoolean("isBot", this.f2785e);
        bundle.putBoolean("isImportant", this.f2786f);
        return bundle;
    }

    public final Person b() {
        Person.Builder name = new Person.Builder().setName(this.f2781a);
        IconCompat iconCompat = this.f2782b;
        Icon icon = null;
        if (iconCompat != null) {
            icon = iconCompat.a((Context) null);
        }
        return name.setIcon(icon).setUri(this.f2783c).setKey(this.f2784d).setBot(this.f2785e).setImportant(this.f2786f).build();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        CharSequence f2787a;

        /* renamed from: b  reason: collision with root package name */
        IconCompat f2788b;

        /* renamed from: c  reason: collision with root package name */
        String f2789c;

        /* renamed from: d  reason: collision with root package name */
        String f2790d;

        /* renamed from: e  reason: collision with root package name */
        boolean f2791e;

        /* renamed from: f  reason: collision with root package name */
        boolean f2792f;

        public final a a(CharSequence charSequence) {
            this.f2787a = charSequence;
            return this;
        }

        public final a a(IconCompat iconCompat) {
            this.f2788b = iconCompat;
            return this;
        }

        public final l a() {
            return new l(this);
        }
    }
}
