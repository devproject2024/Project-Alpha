package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.r;

public final class d extends g {
    public d(Context context) {
        super(context);
    }

    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        i iVar = (i) a(i2, i3, i4, charSequence);
        f fVar = new f(this.f1335a, this, iVar);
        iVar.a((r) fVar);
        return fVar;
    }
}
