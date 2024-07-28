package com.paytm.notification.models;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class Content {
    @c(a = "body")
    private String body = "";
    @c(a = "duration")
    private int duration;
    @c(a = "expiry")
    private String expiry;
    @c(a = "icon_src")
    private String iconSource;
    @c(a = "img_source")
    private String imageSource;
    @c(a = "inbox_title")
    private String inboxTitle = "";
    @c(a = "position")
    private String position;
    @c(a = "priority")
    private String priority = "";
    @c(a = "received")
    private long received;
    @c(a = "sound")
    private String sound;
    @c(a = "style")
    private Style style;
    @c(a = "subtext")
    private String subText;
    @c(a = "subtitle")
    private String subTitle = "";
    @c(a = "summary")
    private String summary;
    @c(a = "title")
    private String title = "";
    @c(a = "type")
    private String type = "";

    public static /* synthetic */ void style$annotations() {
    }

    public static /* synthetic */ void subTitle$annotations() {
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        k.c(str, "<set-?>");
        this.type = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        k.c(str, "<set-?>");
        this.title = str;
    }

    public final String getInboxTitle() {
        return this.inboxTitle;
    }

    public final void setInboxTitle(String str) {
        k.c(str, "<set-?>");
        this.inboxTitle = str;
    }

    public final String getSubText() {
        return this.subText;
    }

    public final void setSubText(String str) {
        this.subText = str;
    }

    public final String getBody() {
        return this.body;
    }

    public final void setBody(String str) {
        k.c(str, "<set-?>");
        this.body = str;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final void setSummary(String str) {
        this.summary = str;
    }

    public final String getSubTitle() {
        return this.subTitle;
    }

    public final void setSubTitle(String str) {
        k.c(str, "<set-?>");
        this.subTitle = str;
    }

    public final String getImageSource() {
        return this.imageSource;
    }

    public final void setImageSource(String str) {
        this.imageSource = str;
    }

    public final String getIconSource() {
        return this.iconSource;
    }

    public final void setIconSource(String str) {
        this.iconSource = str;
    }

    public final String getPosition() {
        return this.position;
    }

    public final void setPosition(String str) {
        this.position = str;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(int i2) {
        this.duration = i2;
    }

    public final long getReceived() {
        return this.received;
    }

    public final void setReceived(long j) {
        this.received = j;
    }

    public final String getExpiry() {
        return this.expiry;
    }

    public final void setExpiry(String str) {
        this.expiry = str;
    }

    public final String getPriority() {
        return this.priority;
    }

    public final void setPriority(String str) {
        k.c(str, "<set-?>");
        this.priority = str;
    }

    public final Style getStyle() {
        return this.style;
    }

    public final void setStyle(Style style2) {
        this.style = style2;
    }

    public final String getSound() {
        return this.sound;
    }

    public final void setSound(String str) {
        this.sound = str;
    }

    public final String toString() {
        return "Content(type='" + this.type + "', title='" + this.title + "', inboxTitle='" + this.inboxTitle + "', subText=" + this.subText + ", body='" + this.body + "', summary=" + this.summary + ", subTitle='" + this.subTitle + "', imageSource=" + this.imageSource + ", iconSource=" + this.iconSource + ", position=" + this.position + ", duration=" + this.duration + ", received=" + this.received + ", expiry=" + this.expiry + ", priority='" + this.priority + "', style=" + this.style + ", sound=" + this.sound + ')';
    }
}
