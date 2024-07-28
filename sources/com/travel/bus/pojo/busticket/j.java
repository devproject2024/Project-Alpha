package com.travel.bus.pojo.busticket;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;

public final class j {
    @b(a = "action")

    /* renamed from: a  reason: collision with root package name */
    public String f22818a;
    @b(a = "title")

    /* renamed from: b  reason: collision with root package name */
    public String f22819b;
    @b(a = "message")

    /* renamed from: c  reason: collision with root package name */
    public String f22820c;
    @b(a = "button_text")

    /* renamed from: d  reason: collision with root package name */
    private String f22821d;

    public final String a() {
        if (TextUtils.isEmpty(this.f22821d)) {
            this.f22821d = "Okay";
        }
        return this.f22821d;
    }
}
