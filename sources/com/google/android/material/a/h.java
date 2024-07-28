package com.google.android.material.a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Property;
import androidx.a.g;
import java.util.ArrayList;
import java.util.List;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final g<String, i> f35813a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    private final g<String, PropertyValuesHolder[]> f35814b = new g<>();

    private void a(String str, i iVar) {
        this.f35813a.put(str, iVar);
    }

    public final boolean b(String str) {
        return this.f35814b.get(str) != null;
    }

    public final PropertyValuesHolder[] c(String str) {
        if (b(str)) {
            return a(this.f35814b.get(str));
        }
        throw new IllegalArgumentException();
    }

    public final void a(String str, PropertyValuesHolder[] propertyValuesHolderArr) {
        this.f35814b.put(str, propertyValuesHolderArr);
    }

    private static PropertyValuesHolder[] a(PropertyValuesHolder[] propertyValuesHolderArr) {
        PropertyValuesHolder[] propertyValuesHolderArr2 = new PropertyValuesHolder[propertyValuesHolderArr.length];
        for (int i2 = 0; i2 < propertyValuesHolderArr.length; i2++) {
            propertyValuesHolderArr2[i2] = propertyValuesHolderArr[i2].clone();
        }
        return propertyValuesHolderArr2;
    }

    public final <T> ObjectAnimator a(String str, T t, Property<T, ?> property) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(t, c(str));
        ofPropertyValuesHolder.setProperty(property);
        a(str).a((Animator) ofPropertyValuesHolder);
        return ofPropertyValuesHolder;
    }

    public final long a() {
        int size = this.f35813a.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i c2 = this.f35813a.c(i2);
            j = Math.max(j, c2.f35815a + c2.f35816b);
        }
        return j;
    }

    public static h a(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0) {
            return null;
        }
        return a(context, resourceId);
    }

    public static h a(Context context, int i2) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
            if (loadAnimator instanceof AnimatorSet) {
                return a((List<Animator>) ((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return a((List<Animator>) arrayList);
        } catch (Exception unused) {
            new StringBuilder("Can't load animation resource ID #0x").append(Integer.toHexString(i2));
            return null;
        }
    }

    private static h a(List<Animator> list) {
        h hVar = new h();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(hVar, list.get(i2));
        }
        return hVar;
    }

    private static void a(h hVar, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            hVar.a(objectAnimator.getPropertyName(), objectAnimator.getValues());
            hVar.a(objectAnimator.getPropertyName(), i.a((ValueAnimator) objectAnimator));
            return;
        }
        throw new IllegalArgumentException("Animator must be an ObjectAnimator: ".concat(String.valueOf(animator)));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        return this.f35813a.equals(((h) obj).f35813a);
    }

    public final int hashCode() {
        return this.f35813a.hashCode();
    }

    public final String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f35813a + "}\n";
    }

    public final i a(String str) {
        if (this.f35813a.get(str) != null) {
            return this.f35813a.get(str);
        }
        throw new IllegalArgumentException();
    }
}
