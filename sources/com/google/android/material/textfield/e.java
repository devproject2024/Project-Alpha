package com.google.android.material.textfield;

import android.content.Context;
import com.google.android.material.internal.CheckableImageButton;

abstract class e {

    /* renamed from: c  reason: collision with root package name */
    TextInputLayout f36833c;

    /* renamed from: d  reason: collision with root package name */
    Context f36834d;

    /* renamed from: e  reason: collision with root package name */
    CheckableImageButton f36835e;

    /* access modifiers changed from: package-private */
    public abstract void a();

    /* access modifiers changed from: package-private */
    public void a(boolean z) {
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2) {
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return false;
    }

    e(TextInputLayout textInputLayout) {
        this.f36833c = textInputLayout;
        this.f36834d = textInputLayout.getContext();
        this.f36835e = textInputLayout.getEndIconView();
    }
}
