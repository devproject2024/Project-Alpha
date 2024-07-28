package com.paytm.notification.models;

import android.os.Bundle;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import com.paytm.notification.models.callback.InboxHandlerReadyCallback;
import java.util.Date;
import kotlin.g.b.k;

public final class PaytmInbox {
    private String body = "";
    private String campaignId = "";
    private String customerId;
    private Date date = new Date();
    private Bundle extras = new Bundle();
    private String imageUrl;
    private boolean isRead;
    private boolean isUnRead;
    private String pushId;
    private String status;
    private String title = "";

    public final Date getDate() {
        return this.date;
    }

    public final void setDate(Date date2) {
        k.c(date2, "<set-?>");
        this.date = date2;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final void setExtras(Bundle bundle) {
        k.c(bundle, "<set-?>");
        this.extras = bundle;
    }

    public final String getBody() {
        return this.body;
    }

    public final void setBody(String str) {
        k.c(str, "<set-?>");
        this.body = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        k.c(str, "<set-?>");
        this.title = str;
    }

    public final String getPushId() {
        return this.pushId;
    }

    public final void setPushId(String str) {
        this.pushId = str;
    }

    public final String getCustomerId() {
        return this.customerId;
    }

    public final void setCustomerId(String str) {
        this.customerId = str;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final boolean isRead() {
        return this.isRead;
    }

    public final void setRead(boolean z) {
        this.isRead = z;
    }

    public final boolean isUnRead() {
        return this.isUnRead;
    }

    public final void setUnRead(boolean z) {
        this.isUnRead = z;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final void setCampaignId(String str) {
        k.c(str, "<set-?>");
        this.campaignId = str;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public final void markClicked() {
        try {
            g.c cVar = g.f43191a;
            g.c.a((InboxHandlerReadyCallback) new PaytmInbox$markClicked$1(this));
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
    }

    public final void markRead() {
        try {
            g.c cVar = g.f43191a;
            g.c.a((InboxHandlerReadyCallback) new PaytmInbox$markRead$1(this));
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
    }
}
