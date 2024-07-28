package com.travel.flight.tooltipwidget;

import android.graphics.Typeface;
import android.view.View;
import java.util.ArrayList;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    int f25512a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f25513b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f25514c;

    /* renamed from: d  reason: collision with root package name */
    View f25515d = null;

    /* renamed from: e  reason: collision with root package name */
    C0478a f25516e = C0478a.FROM_MASTER_VIEW;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25517f;

    /* renamed from: g  reason: collision with root package name */
    Typeface f25518g = null;

    /* renamed from: h  reason: collision with root package name */
    ArrayList<String> f25519h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f25520i = null;
    private CharSequence j = null;
    private CharSequence k = null;

    /* renamed from: com.travel.flight.tooltipwidget.a$a  reason: collision with other inner class name */
    public enum C0478a {
        FROM_MASTER_VIEW,
        FROM_TOP,
        NONE
    }

    public final a a(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        this.f25520i = charSequence3;
        this.j = charSequence2;
        this.k = charSequence;
        this.f25512a = 0;
        this.f25519h.add(charSequence3.toString());
        this.f25519h.add(charSequence2.toString());
        this.f25519h.add(charSequence.toString());
        return this;
    }
}
