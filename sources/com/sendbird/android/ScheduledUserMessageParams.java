package com.sendbird.android;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class ScheduledUserMessageParams extends UserMessageParams {
    private Integer mDay;
    private Integer mHour;
    private Integer mMin;
    private Integer mMonth;
    private String mTimezone;
    private Integer mYear;

    public ScheduledUserMessageParams(String str, int i2, int i3, int i4, int i5, int i6, String str2) {
        super(str);
        setSchedule(i2, i3, i4, i5, i6, str2);
    }

    public void setSchedule(int i2, int i3, int i4, int i5, int i6, String str) {
        this.mYear = Integer.valueOf(i2);
        this.mMonth = Integer.valueOf(i3);
        this.mDay = Integer.valueOf(i4);
        this.mHour = Integer.valueOf(i5);
        this.mMin = Integer.valueOf(i6);
        this.mTimezone = str;
    }

    public Date getScheduledDateTime() {
        Date date = null;
        try {
            if (!(this.mYear == null || this.mMonth == null || this.mDay == null || this.mHour == null || this.mMin == null || this.mTimezone == null)) {
                String format = String.format(Locale.US, "%04d-%02d-%02d %02d:%02d", new Object[]{this.mYear, this.mMonth, this.mDay, this.mHour, this.mMin});
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone(this.mTimezone));
                date = simpleDateFormat.parse(format);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return date == null ? new Date() : date;
    }

    public String getScheduledTimezone() {
        String str = this.mTimezone;
        return str != null ? str : "UTC";
    }

    /* access modifiers changed from: package-private */
    public String getScheduledString() {
        if (this.mYear == null || this.mMonth == null || this.mDay == null || this.mHour == null || this.mMin == null || this.mTimezone == null) {
            return null;
        }
        return String.format(Locale.US, "%04d-%02d-%02d %02d:%02d %s", new Object[]{this.mYear, this.mMonth, this.mDay, this.mHour, this.mMin, this.mTimezone});
    }

    public String toString() {
        return "ScheduledUserMessageParams{mYear=" + this.mYear + ", mMonth=" + this.mMonth + ", mDay=" + this.mDay + ", mHour=" + this.mHour + ", mMin=" + this.mMin + ", mTimezone='" + this.mTimezone + '\'' + ", mMessage='" + this.mMessage + '\'' + ", mTargetLanguages=" + this.mTargetLanguages + ", mData='" + this.mData + '\'' + ", mCustomType='" + this.mCustomType + '\'' + ", mMentionType=" + this.mMentionType + ", mMentionedUserIds=" + this.mMentionedUserIds + ", mPushNotificationDeliveryOption=" + this.mPushNotificationDeliveryOption + ", mMetaArrays=" + this.mMetaArrays + '}';
    }
}
