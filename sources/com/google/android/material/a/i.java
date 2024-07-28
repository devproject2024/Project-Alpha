package com.google.android.material.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public long f35815a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f35816b = 300;

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f35817c = null;

    /* renamed from: d  reason: collision with root package name */
    private int f35818d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f35819e = 1;

    public i(long j) {
        this.f35815a = j;
        this.f35816b = 150;
    }

    private i(long j, long j2, TimeInterpolator timeInterpolator) {
        this.f35815a = j;
        this.f35816b = j2;
        this.f35817c = timeInterpolator;
    }

    public final TimeInterpolator a() {
        TimeInterpolator timeInterpolator = this.f35817c;
        return timeInterpolator != null ? timeInterpolator : a.f35801b;
    }

    static i a(ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), b(valueAnimator));
        iVar.f35818d = valueAnimator.getRepeatCount();
        iVar.f35819e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator b(ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
            return a.f35801b;
        }
        if (interpolator instanceof AccelerateInterpolator) {
            return a.f35802c;
        }
        return interpolator instanceof DecelerateInterpolator ? a.f35803d : interpolator;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f35815a == iVar.f35815a && this.f35816b == iVar.f35816b && this.f35818d == iVar.f35818d && this.f35819e == iVar.f35819e) {
            return a().getClass().equals(iVar.a().getClass());
        }
        return false;
    }

    public final String toString() {
        return 10 + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + this.f35815a + " duration: " + this.f35816b + " interpolator: " + a().getClass() + " repeatCount: " + this.f35818d + " repeatMode: " + this.f35819e + "}\n";
    }

    public final void a(Animator animator) {
        animator.setStartDelay(this.f35815a);
        animator.setDuration(this.f35816b);
        animator.setInterpolator(a());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f35818d);
            valueAnimator.setRepeatMode(this.f35819e);
        }
    }

    public final int hashCode() {
        long j = this.f35815a;
        long j2 = this.f35816b;
        return (((((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + a().getClass().hashCode()) * 31) + this.f35818d) * 31) + this.f35819e;
    }
}
