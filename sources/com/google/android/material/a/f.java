package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

public final class f extends Property<ImageView, Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f35809a = new Matrix();

    public final /* synthetic */ Object get(Object obj) {
        this.f35809a.set(((ImageView) obj).getImageMatrix());
        return this.f35809a;
    }

    public final /* synthetic */ void set(Object obj, Object obj2) {
        ((ImageView) obj).setImageMatrix((Matrix) obj2);
    }

    public f() {
        super(Matrix.class, "imageMatrixProperty");
    }
}
