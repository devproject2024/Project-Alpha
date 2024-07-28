package com.travel.train.hintsbuilder;

import android.app.Activity;
import android.view.View;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public CJRTrainShowTipsView f27479a;

    public b(Activity activity) {
        this.f27479a = new CJRTrainShowTipsView(activity);
    }

    public final b a(View view) {
        this.f27479a.setTarget(view);
        return this;
    }

    public final CJRTrainShowTipsView a() {
        return this.f27479a;
    }

    public final b a(String str) {
        this.f27479a.setTitle(str);
        return this;
    }

    public final b b(String str) {
        this.f27479a.setDescription(str);
        return this;
    }

    public final b a(c cVar) {
        this.f27479a.setCallback(cVar);
        return this;
    }

    public final b b() {
        this.f27479a.setDelay(500);
        return this;
    }

    public final b c(String str) {
        this.f27479a.setPositiveButton(str);
        return this;
    }

    public final b d(String str) {
        this.f27479a.setNegativeButton(str);
        return this;
    }

    public final b a(int i2) {
        this.f27479a.setLayout(i2);
        return this;
    }

    public final b c() {
        this.f27479a.setBackground_alpha(90);
        return this;
    }

    public final b a(boolean z) {
        this.f27479a.setDismissOnTouch(z);
        return this;
    }
}
