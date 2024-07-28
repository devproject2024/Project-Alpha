package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;

public final class EventMessage implements Metadata.Entry {
    public static final Parcelable.Creator<EventMessage> CREATOR = new Parcelable.Creator<EventMessage>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new EventMessage[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new EventMessage(parcel);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private static final Format f32650f = Format.b((String) null, "application/id3", Long.MAX_VALUE);

    /* renamed from: g  reason: collision with root package name */
    private static final Format f32651g = Format.b((String) null, "application/x-scte35", Long.MAX_VALUE);

    /* renamed from: a  reason: collision with root package name */
    public final String f32652a;

    /* renamed from: b  reason: collision with root package name */
    public final String f32653b;

    /* renamed from: c  reason: collision with root package name */
    public final long f32654c;

    /* renamed from: d  reason: collision with root package name */
    public final long f32655d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f32656e;

    /* renamed from: h  reason: collision with root package name */
    private int f32657h;

    public final int describeContents() {
        return 0;
    }

    public EventMessage(String str, String str2, long j, long j2, byte[] bArr) {
        this.f32652a = str;
        this.f32653b = str2;
        this.f32654c = j;
        this.f32655d = j2;
        this.f32656e = bArr;
    }

    EventMessage(Parcel parcel) {
        this.f32652a = (String) ae.a(parcel.readString());
        this.f32653b = (String) ae.a(parcel.readString());
        this.f32654c = parcel.readLong();
        this.f32655d = parcel.readLong();
        this.f32656e = (byte[]) ae.a(parcel.createByteArray());
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.exoplayer2.Format a() {
        /*
            r5 = this;
            java.lang.String r0 = r5.f32652a
            int r1 = r0.hashCode()
            r2 = -1468477611(0xffffffffa878cf55, float:-1.38117235E-14)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002c
            r2 = -795945609(0xffffffffd08ed577, float:-1.91708344E10)
            if (r1 == r2) goto L_0x0022
            r2 = 1303648457(0x4db418c9, float:3.776904E8)
            if (r1 == r2) goto L_0x0018
            goto L_0x0037
        L_0x0018:
            java.lang.String r1 = "https://developer.apple.com/streaming/emsg-id3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 1
            goto L_0x0038
        L_0x0022:
            java.lang.String r1 = "https://aomedia.org/emsg/ID3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0038
        L_0x002c:
            java.lang.String r1 = "urn:scte:scte35:2014:bin"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0037
            r0 = 2
            goto L_0x0038
        L_0x0037:
            r0 = -1
        L_0x0038:
            if (r0 == 0) goto L_0x0043
            if (r0 == r4) goto L_0x0043
            if (r0 == r3) goto L_0x0040
            r0 = 0
            return r0
        L_0x0040:
            com.google.android.exoplayer2.Format r0 = f32651g
            return r0
        L_0x0043:
            com.google.android.exoplayer2.Format r0 = f32650f
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.metadata.emsg.EventMessage.a():com.google.android.exoplayer2.Format");
    }

    public final byte[] b() {
        if (a() != null) {
            return this.f32656e;
        }
        return null;
    }

    public final int hashCode() {
        if (this.f32657h == 0) {
            String str = this.f32652a;
            int i2 = 0;
            int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
            String str2 = this.f32653b;
            if (str2 != null) {
                i2 = str2.hashCode();
            }
            long j = this.f32654c;
            long j2 = this.f32655d;
            this.f32657h = ((((((hashCode + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.f32656e);
        }
        return this.f32657h;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            EventMessage eventMessage = (EventMessage) obj;
            return this.f32654c == eventMessage.f32654c && this.f32655d == eventMessage.f32655d && ae.a((Object) this.f32652a, (Object) eventMessage.f32652a) && ae.a((Object) this.f32653b, (Object) eventMessage.f32653b) && Arrays.equals(this.f32656e, eventMessage.f32656e);
        }
    }

    public final String toString() {
        return "EMSG: scheme=" + this.f32652a + ", id=" + this.f32655d + ", durationMs=" + this.f32654c + ", value=" + this.f32653b;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f32652a);
        parcel.writeString(this.f32653b);
        parcel.writeLong(this.f32654c);
        parcel.writeLong(this.f32655d);
        parcel.writeByteArray(this.f32656e);
    }
}
