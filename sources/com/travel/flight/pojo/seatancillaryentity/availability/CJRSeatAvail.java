package com.travel.flight.pojo.seatancillaryentity.availability;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRSeatAvail extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @a
    @b(a = "assisted")
    private final boolean assisted;
    @a
    @b(a = "code")
    private final String code;
    @a
    @b(a = "combo")
    private final boolean combo;
    @a
    @b(a = "el_room")
    private final boolean elRoom;
    @a
    @b(a = "em_exit")
    private final boolean emExit;
    @a
    @b(a = "group")
    private final String group;
    @a
    @b(a = "no_child")
    private final boolean noChild;
    @a
    @b(a = "number")
    private final String number;
    @a
    @b(a = "select_msg")
    private final String selectMsg;
    @a
    @b(a = "window")
    private final boolean window;

    public CJRSeatAvail(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, String str2, String str3, boolean z6, String str4) {
        this.assisted = z;
        this.emExit = z2;
        this.elRoom = z3;
        this.window = z4;
        this.noChild = z5;
        this.number = str;
        this.group = str2;
        this.code = str3;
        this.combo = z6;
        this.selectMsg = str4;
    }

    public boolean getAssisted() {
        return this.assisted;
    }

    public boolean getEmExit() {
        return this.emExit;
    }

    public boolean getElRoom() {
        return this.elRoom;
    }

    public boolean getWindow() {
        return this.window;
    }

    public boolean getNoChild() {
        return this.noChild;
    }

    public String getNumber() {
        return this.number;
    }

    public String getGroup() {
        return this.group;
    }

    public String getCode() {
        return this.code;
    }

    public boolean getCombo() {
        return this.combo;
    }

    public String getSelectMsg() {
        return this.selectMsg;
    }

    public String toString() {
        return "SeatAvail{assisted=" + this.assisted + ", emExit=" + this.emExit + ", elRoom=" + this.elRoom + ", window=" + this.window + ", noChild=" + this.noChild + ", number='" + this.number + '\'' + ", group='" + this.group + '\'' + ", code='" + this.code + '\'' + ", combo=" + this.combo + ", selectMsg='" + this.selectMsg + '\'' + '}';
    }
}
