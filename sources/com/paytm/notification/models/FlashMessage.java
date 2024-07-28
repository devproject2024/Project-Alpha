package com.paytm.notification.models;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;

public final class FlashMessage implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((g) null);
    private HashMap<String, String> actions;
    private Bundle bundle;
    private String campaignId;
    private String category;
    public String customerId;
    private int displayPeriodInSecs;
    private Long displayTime;
    private long expiry;
    private Map<String, String> extras;
    private boolean isExpired;
    private boolean isSoundEnable;
    private boolean isSourcePaytm;
    private String message;
    private Integer notificationId;
    private String notificationType;
    private String position;
    private Integer priority;
    public String pushId;
    private Long receiveTime;
    private String title;

    public final int describeContents() {
        return 0;
    }

    public FlashMessage() {
        this.displayTime = 0L;
        this.receiveTime = 0L;
        this.extras = new HashMap();
    }

    public final String getNotificationType() {
        return this.notificationType;
    }

    public final void setNotificationType(String str) {
        this.notificationType = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getPushId() {
        String str = this.pushId;
        if (str == null) {
            k.a("pushId");
        }
        return str;
    }

    public final void setPushId(String str) {
        k.c(str, "<set-?>");
        this.pushId = str;
    }

    public final String getCategory() {
        return this.category;
    }

    public final void setCategory(String str) {
        this.category = str;
    }

    public final Integer getPriority() {
        return this.priority;
    }

    public final void setPriority(Integer num) {
        this.priority = num;
    }

    public final HashMap<String, String> getActions() {
        return this.actions;
    }

    public final void setActions(HashMap<String, String> hashMap) {
        this.actions = hashMap;
    }

    public final Long getDisplayTime() {
        return this.displayTime;
    }

    public final void setDisplayTime(Long l) {
        this.displayTime = l;
    }

    public final Long getReceiveTime() {
        return this.receiveTime;
    }

    public final void setReceiveTime(Long l) {
        this.receiveTime = l;
    }

    public final long getExpiry() {
        return this.expiry;
    }

    public final void setExpiry(long j) {
        this.expiry = j;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final void setCampaignId(String str) {
        this.campaignId = str;
    }

    public final String getPosition() {
        return this.position;
    }

    public final void setPosition(String str) {
        this.position = str;
    }

    public final boolean isSoundEnable() {
        return this.isSoundEnable;
    }

    public final void setSoundEnable(boolean z) {
        this.isSoundEnable = z;
    }

    public final boolean isExpired() {
        return this.isExpired;
    }

    public final void setExpired(boolean z) {
        this.isExpired = z;
    }

    public final boolean isSourcePaytm() {
        return this.isSourcePaytm;
    }

    public final void setSourcePaytm(boolean z) {
        this.isSourcePaytm = z;
    }

    public final Integer getNotificationId() {
        return this.notificationId;
    }

    public final void setNotificationId(Integer num) {
        this.notificationId = num;
    }

    public final int getDisplayPeriodInSecs() {
        return this.displayPeriodInSecs;
    }

    public final void setDisplayPeriodInSecs(int i2) {
        this.displayPeriodInSecs = i2;
    }

    public final String getCustomerId() {
        String str = this.customerId;
        if (str == null) {
            k.a("customerId");
        }
        return str;
    }

    public final void setCustomerId(String str) {
        k.c(str, "<set-?>");
        this.customerId = str;
    }

    public final Map<String, String> getExtras() {
        return this.extras;
    }

    public final void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }

    public final void setBundle(Bundle bundle2) {
        this.bundle = bundle2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FlashMessage(Parcel parcel) {
        this();
        k.c(parcel, "parcel");
        this.notificationType = parcel.readString();
        this.title = parcel.readString();
        this.message = parcel.readString();
        String readString = parcel.readString();
        this.pushId = readString == null ? "" : readString;
        this.category = parcel.readString();
        Object readValue = parcel.readValue(Integer.TYPE.getClassLoader());
        this.priority = (Integer) (!(readValue instanceof Integer) ? null : readValue);
        Object readValue2 = parcel.readValue(Long.TYPE.getClassLoader());
        this.displayTime = (Long) (!(readValue2 instanceof Long) ? null : readValue2);
        Object readValue3 = parcel.readValue(Long.TYPE.getClassLoader());
        this.receiveTime = (Long) (!(readValue3 instanceof Long) ? null : readValue3);
        this.expiry = parcel.readLong();
        this.campaignId = parcel.readString();
        this.position = parcel.readString();
        boolean z = true;
        this.isSoundEnable = parcel.readByte() != 0;
        this.isExpired = parcel.readByte() != 0;
        this.isSourcePaytm = parcel.readByte() == 0 ? false : z;
        Object readValue4 = parcel.readValue(Integer.TYPE.getClassLoader());
        this.notificationId = (Integer) (!(readValue4 instanceof Integer) ? null : readValue4);
        String readString2 = parcel.readString();
        this.customerId = readString2 == null ? "" : readString2;
        HashMap readHashMap = parcel.readHashMap(HashMap.class.getClassLoader());
        this.extras = !(readHashMap instanceof HashMap) ? null : readHashMap;
        Object readValue5 = parcel.readValue(Integer.TYPE.getClassLoader());
        if (readValue5 != null) {
            this.displayPeriodInSecs = ((Integer) readValue5).intValue();
            HashMap<String, String> readHashMap2 = parcel.readHashMap(HashMap.class.getClassLoader());
            this.actions = !(readHashMap2 instanceof HashMap) ? null : readHashMap2;
            return;
        }
        throw new u("null cannot be cast to non-null type kotlin.Int");
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeString(this.notificationType);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        String str = this.pushId;
        if (str == null) {
            k.a("pushId");
        }
        parcel.writeString(str);
        parcel.writeString(this.category);
        parcel.writeValue(this.priority);
        parcel.writeValue(this.displayTime);
        parcel.writeValue(this.receiveTime);
        parcel.writeLong(this.expiry);
        parcel.writeString(this.campaignId);
        parcel.writeString(this.position);
        parcel.writeByte(this.isSoundEnable ? (byte) 1 : 0);
        parcel.writeByte(this.isExpired ? (byte) 1 : 0);
        parcel.writeByte(this.isSourcePaytm ? (byte) 1 : 0);
        parcel.writeValue(this.notificationId);
        String str2 = this.customerId;
        if (str2 == null) {
            k.a("customerId");
        }
        parcel.writeString(str2);
        parcel.writeMap(this.extras);
        parcel.writeValue(Integer.valueOf(this.displayPeriodInSecs));
        parcel.writeMap(this.actions);
    }

    public static final class CREATOR implements Parcelable.Creator<FlashMessage> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(g gVar) {
            this();
        }

        public final FlashMessage createFromParcel(Parcel parcel) {
            k.c(parcel, "parcel");
            return new FlashMessage(parcel);
        }

        public final FlashMessage[] newArray(int i2) {
            return new FlashMessage[i2];
        }
    }

    public final Bundle getPushBundle() {
        if (this.bundle == null) {
            this.bundle = new Bundle();
            Map<String, String> map = this.extras;
            if (map != null) {
                if (map == null) {
                    k.a();
                }
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    String str2 = (String) next.getValue();
                    Bundle bundle2 = this.bundle;
                    if (bundle2 == null) {
                        k.a();
                    }
                    bundle2.putString(str, str2);
                }
            }
        }
        Bundle bundle3 = this.bundle;
        if (bundle3 == null) {
            k.a();
        }
        return bundle3;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FlashMessage(notificationType=");
        sb.append(this.notificationType);
        sb.append(", title=");
        sb.append(this.title);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", pushId='");
        String str = this.pushId;
        if (str == null) {
            k.a("pushId");
        }
        sb.append(str);
        sb.append("', category=");
        sb.append(this.category);
        sb.append(", priority=");
        sb.append(this.priority);
        sb.append(", actions=");
        sb.append(this.actions);
        sb.append(", displayTime=");
        sb.append(this.displayTime);
        sb.append(", receiveTime=");
        sb.append(this.receiveTime);
        sb.append(", expiry=");
        sb.append(this.expiry);
        sb.append(", campaignId=");
        sb.append(this.campaignId);
        sb.append(", position=");
        sb.append(this.position);
        sb.append(", isSoundEnable=");
        sb.append(this.isSoundEnable);
        sb.append(", isExpired=");
        sb.append(this.isExpired);
        sb.append(", isSourcePaytm=");
        sb.append(this.isSourcePaytm);
        sb.append(", notificationId=");
        sb.append(this.notificationId);
        sb.append(", displayPeriodInSecs=");
        sb.append(this.displayPeriodInSecs);
        sb.append(", customerId='");
        String str2 = this.customerId;
        if (str2 == null) {
            k.a("customerId");
        }
        sb.append(str2);
        sb.append("', extras=");
        sb.append(this.extras);
        sb.append(", bundle=");
        sb.append(this.bundle);
        sb.append(')');
        return sb.toString();
    }
}
