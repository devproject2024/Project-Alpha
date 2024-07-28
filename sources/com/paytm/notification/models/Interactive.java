package com.paytm.notification.models;

import com.google.gson.a.c;
import java.util.List;

public final class Interactive {
    @c(a = "buttons")
    private List<Buttons> buttons;
    @c(a = "click")
    private Click click;

    public final Click getClick() {
        return this.click;
    }

    public final void setClick(Click click2) {
        this.click = click2;
    }

    public final List<Buttons> getButtons() {
        return this.buttons;
    }

    public final void setButtons(List<Buttons> list) {
        this.buttons = list;
    }

    public final String toString() {
        return "Interactive(click=" + this.click + ", buttons=" + this.buttons + ')';
    }
}
