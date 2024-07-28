package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.b.d;
import com.google.android.gms.b.f;

public final class t extends f<p> {

    /* renamed from: a  reason: collision with root package name */
    private static final t f8866a = new t();

    private t() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View a(Context context, int i2, int i3) throws f.a {
        return f8866a.b(context, i2, i3);
    }

    private final View b(Context context, int i2, int i3) throws f.a {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i2, i3);
            return (View) d.a(((p) a(context)).a(d.a(context), signInButtonConfig));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i2);
            sb.append(" and color ");
            sb.append(i3);
            throw new f.a(sb.toString(), e2);
        }
    }

    public final /* synthetic */ Object a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        if (queryLocalInterface instanceof p) {
            return (p) queryLocalInterface;
        }
        return new ac(iBinder);
    }
}
