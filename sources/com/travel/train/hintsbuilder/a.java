package com.travel.train.hintsbuilder;

import android.app.Activity;
import android.view.View;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    CJRTrainShowSquareTipsView f27478a;

    public a(Activity activity) {
        this.f27478a = new CJRTrainShowSquareTipsView(activity);
    }

    public final a a(View view) {
        this.f27478a.setTarget(view);
        return this;
    }

    public final CJRTrainShowSquareTipsView a() {
        return this.f27478a;
    }

    public final a a(String str) {
        this.f27478a.setTitle(str);
        return this;
    }

    public final a b(String str) {
        this.f27478a.setDescription(str);
        return this;
    }

    public final a a(c cVar) {
        this.f27478a.setCallback(cVar);
        return this;
    }

    public final a a(int i2) {
        this.f27478a.setDelay(i2);
        return this;
    }

    public final a c(String str) {
        this.f27478a.setPositiveButton(str);
        return this;
    }

    public final a d(String str) {
        this.f27478a.setNegativeButton(str);
        return this;
    }

    public final a b(int i2) {
        this.f27478a.setLayout(i2);
        return this;
    }

    public final a b() {
        this.f27478a.setBackground_alpha(90);
        return this;
    }

    public final a c() {
        this.f27478a.setDismissOnTouch(true);
        return this;
    }
}
