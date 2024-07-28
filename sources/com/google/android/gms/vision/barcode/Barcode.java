package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.b;

public class Barcode extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Barcode> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    public int f12552a;

    /* renamed from: b  reason: collision with root package name */
    public String f12553b;

    /* renamed from: c  reason: collision with root package name */
    public String f12554c;

    /* renamed from: d  reason: collision with root package name */
    public int f12555d;

    /* renamed from: e  reason: collision with root package name */
    public Point[] f12556e;

    /* renamed from: f  reason: collision with root package name */
    public Email f12557f;

    /* renamed from: g  reason: collision with root package name */
    public Phone f12558g;

    /* renamed from: h  reason: collision with root package name */
    public Sms f12559h;

    /* renamed from: i  reason: collision with root package name */
    public WiFi f12560i;
    public UrlBookmark j;
    public GeoPoint k;
    public CalendarEvent l;
    public ContactInfo m;
    public DriverLicense n;
    public byte[] o;
    public boolean p;

    public static class Address extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Address> CREATOR = new b();

        /* renamed from: a  reason: collision with root package name */
        public int f12561a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f12562b;

        public Address() {
        }

        public Address(int i2, String[] strArr) {
            this.f12561a = i2;
            this.f12562b = strArr;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.b(parcel, 2, this.f12561a);
            b.a(parcel, 3, this.f12562b);
            b.b(parcel, a2);
        }
    }

    public static class CalendarDateTime extends AbstractSafeParcelable {
        public static final Parcelable.Creator<CalendarDateTime> CREATOR = new d();

        /* renamed from: a  reason: collision with root package name */
        public int f12563a;

        /* renamed from: b  reason: collision with root package name */
        public int f12564b;

        /* renamed from: c  reason: collision with root package name */
        public int f12565c;

        /* renamed from: d  reason: collision with root package name */
        public int f12566d;

        /* renamed from: e  reason: collision with root package name */
        public int f12567e;

        /* renamed from: f  reason: collision with root package name */
        public int f12568f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f12569g;

        /* renamed from: h  reason: collision with root package name */
        public String f12570h;

        public CalendarDateTime() {
        }

        public CalendarDateTime(int i2, int i3, int i4, int i5, int i6, int i7, boolean z, String str) {
            this.f12563a = i2;
            this.f12564b = i3;
            this.f12565c = i4;
            this.f12566d = i5;
            this.f12567e = i6;
            this.f12568f = i7;
            this.f12569g = z;
            this.f12570h = str;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.b(parcel, 2, this.f12563a);
            b.b(parcel, 3, this.f12564b);
            b.b(parcel, 4, this.f12565c);
            b.b(parcel, 5, this.f12566d);
            b.b(parcel, 6, this.f12567e);
            b.b(parcel, 7, this.f12568f);
            b.a(parcel, 8, this.f12569g);
            b.a(parcel, 9, this.f12570h, false);
            b.b(parcel, a2);
        }
    }

    public static class CalendarEvent extends AbstractSafeParcelable {
        public static final Parcelable.Creator<CalendarEvent> CREATOR = new f();

        /* renamed from: a  reason: collision with root package name */
        public String f12571a;

        /* renamed from: b  reason: collision with root package name */
        public String f12572b;

        /* renamed from: c  reason: collision with root package name */
        public String f12573c;

        /* renamed from: d  reason: collision with root package name */
        public String f12574d;

        /* renamed from: e  reason: collision with root package name */
        public String f12575e;

        /* renamed from: f  reason: collision with root package name */
        public CalendarDateTime f12576f;

        /* renamed from: g  reason: collision with root package name */
        public CalendarDateTime f12577g;

        public CalendarEvent() {
        }

        public CalendarEvent(String str, String str2, String str3, String str4, String str5, CalendarDateTime calendarDateTime, CalendarDateTime calendarDateTime2) {
            this.f12571a = str;
            this.f12572b = str2;
            this.f12573c = str3;
            this.f12574d = str4;
            this.f12575e = str5;
            this.f12576f = calendarDateTime;
            this.f12577g = calendarDateTime2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12571a, false);
            b.a(parcel, 3, this.f12572b, false);
            b.a(parcel, 4, this.f12573c, false);
            b.a(parcel, 5, this.f12574d, false);
            b.a(parcel, 6, this.f12575e, false);
            b.a(parcel, 7, this.f12576f, i2, false);
            b.a(parcel, 8, this.f12577g, i2, false);
            b.b(parcel, a2);
        }
    }

    public static class ContactInfo extends AbstractSafeParcelable {
        public static final Parcelable.Creator<ContactInfo> CREATOR = new e();

        /* renamed from: a  reason: collision with root package name */
        public PersonName f12578a;

        /* renamed from: b  reason: collision with root package name */
        public String f12579b;

        /* renamed from: c  reason: collision with root package name */
        public String f12580c;

        /* renamed from: d  reason: collision with root package name */
        public Phone[] f12581d;

        /* renamed from: e  reason: collision with root package name */
        public Email[] f12582e;

        /* renamed from: f  reason: collision with root package name */
        public String[] f12583f;

        /* renamed from: g  reason: collision with root package name */
        public Address[] f12584g;

        public ContactInfo() {
        }

        public ContactInfo(PersonName personName, String str, String str2, Phone[] phoneArr, Email[] emailArr, String[] strArr, Address[] addressArr) {
            this.f12578a = personName;
            this.f12579b = str;
            this.f12580c = str2;
            this.f12581d = phoneArr;
            this.f12582e = emailArr;
            this.f12583f = strArr;
            this.f12584g = addressArr;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12578a, i2, false);
            b.a(parcel, 3, this.f12579b, false);
            b.a(parcel, 4, this.f12580c, false);
            b.a(parcel, 5, (T[]) this.f12581d, i2);
            b.a(parcel, 6, (T[]) this.f12582e, i2);
            b.a(parcel, 7, this.f12583f);
            b.a(parcel, 8, (T[]) this.f12584g, i2);
            b.b(parcel, a2);
        }
    }

    public static class DriverLicense extends AbstractSafeParcelable {
        public static final Parcelable.Creator<DriverLicense> CREATOR = new h();

        /* renamed from: a  reason: collision with root package name */
        public String f12585a;

        /* renamed from: b  reason: collision with root package name */
        public String f12586b;

        /* renamed from: c  reason: collision with root package name */
        public String f12587c;

        /* renamed from: d  reason: collision with root package name */
        public String f12588d;

        /* renamed from: e  reason: collision with root package name */
        public String f12589e;

        /* renamed from: f  reason: collision with root package name */
        public String f12590f;

        /* renamed from: g  reason: collision with root package name */
        public String f12591g;

        /* renamed from: h  reason: collision with root package name */
        public String f12592h;

        /* renamed from: i  reason: collision with root package name */
        public String f12593i;
        public String j;
        public String k;
        public String l;
        public String m;
        public String n;

        public DriverLicense() {
        }

        public DriverLicense(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
            this.f12585a = str;
            this.f12586b = str2;
            this.f12587c = str3;
            this.f12588d = str4;
            this.f12589e = str5;
            this.f12590f = str6;
            this.f12591g = str7;
            this.f12592h = str8;
            this.f12593i = str9;
            this.j = str10;
            this.k = str11;
            this.l = str12;
            this.m = str13;
            this.n = str14;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12585a, false);
            b.a(parcel, 3, this.f12586b, false);
            b.a(parcel, 4, this.f12587c, false);
            b.a(parcel, 5, this.f12588d, false);
            b.a(parcel, 6, this.f12589e, false);
            b.a(parcel, 7, this.f12590f, false);
            b.a(parcel, 8, this.f12591g, false);
            b.a(parcel, 9, this.f12592h, false);
            b.a(parcel, 10, this.f12593i, false);
            b.a(parcel, 11, this.j, false);
            b.a(parcel, 12, this.k, false);
            b.a(parcel, 13, this.l, false);
            b.a(parcel, 14, this.m, false);
            b.a(parcel, 15, this.n, false);
            b.b(parcel, a2);
        }
    }

    public static class Email extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Email> CREATOR = new g();

        /* renamed from: a  reason: collision with root package name */
        public int f12594a;

        /* renamed from: b  reason: collision with root package name */
        public String f12595b;

        /* renamed from: c  reason: collision with root package name */
        public String f12596c;

        /* renamed from: d  reason: collision with root package name */
        public String f12597d;

        public Email() {
        }

        public Email(int i2, String str, String str2, String str3) {
            this.f12594a = i2;
            this.f12595b = str;
            this.f12596c = str2;
            this.f12597d = str3;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.b(parcel, 2, this.f12594a);
            b.a(parcel, 3, this.f12595b, false);
            b.a(parcel, 4, this.f12596c, false);
            b.a(parcel, 5, this.f12597d, false);
            b.b(parcel, a2);
        }
    }

    public static class GeoPoint extends AbstractSafeParcelable {
        public static final Parcelable.Creator<GeoPoint> CREATOR = new j();

        /* renamed from: a  reason: collision with root package name */
        public double f12598a;

        /* renamed from: b  reason: collision with root package name */
        public double f12599b;

        public GeoPoint() {
        }

        public GeoPoint(double d2, double d3) {
            this.f12598a = d2;
            this.f12599b = d3;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12598a);
            b.a(parcel, 3, this.f12599b);
            b.b(parcel, a2);
        }
    }

    public static class PersonName extends AbstractSafeParcelable {
        public static final Parcelable.Creator<PersonName> CREATOR = new i();

        /* renamed from: a  reason: collision with root package name */
        public String f12600a;

        /* renamed from: b  reason: collision with root package name */
        public String f12601b;

        /* renamed from: c  reason: collision with root package name */
        public String f12602c;

        /* renamed from: d  reason: collision with root package name */
        public String f12603d;

        /* renamed from: e  reason: collision with root package name */
        public String f12604e;

        /* renamed from: f  reason: collision with root package name */
        public String f12605f;

        /* renamed from: g  reason: collision with root package name */
        public String f12606g;

        public PersonName() {
        }

        public PersonName(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f12600a = str;
            this.f12601b = str2;
            this.f12602c = str3;
            this.f12603d = str4;
            this.f12604e = str5;
            this.f12605f = str6;
            this.f12606g = str7;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12600a, false);
            b.a(parcel, 3, this.f12601b, false);
            b.a(parcel, 4, this.f12602c, false);
            b.a(parcel, 5, this.f12603d, false);
            b.a(parcel, 6, this.f12604e, false);
            b.a(parcel, 7, this.f12605f, false);
            b.a(parcel, 8, this.f12606g, false);
            b.b(parcel, a2);
        }
    }

    public static class Phone extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Phone> CREATOR = new l();

        /* renamed from: a  reason: collision with root package name */
        public int f12607a;

        /* renamed from: b  reason: collision with root package name */
        public String f12608b;

        public Phone() {
        }

        public Phone(int i2, String str) {
            this.f12607a = i2;
            this.f12608b = str;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.b(parcel, 2, this.f12607a);
            b.a(parcel, 3, this.f12608b, false);
            b.b(parcel, a2);
        }
    }

    public static class Sms extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Sms> CREATOR = new k();

        /* renamed from: a  reason: collision with root package name */
        public String f12609a;

        /* renamed from: b  reason: collision with root package name */
        public String f12610b;

        public Sms() {
        }

        public Sms(String str, String str2) {
            this.f12609a = str;
            this.f12610b = str2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12609a, false);
            b.a(parcel, 3, this.f12610b, false);
            b.b(parcel, a2);
        }
    }

    public static class UrlBookmark extends AbstractSafeParcelable {
        public static final Parcelable.Creator<UrlBookmark> CREATOR = new n();

        /* renamed from: a  reason: collision with root package name */
        public String f12611a;

        /* renamed from: b  reason: collision with root package name */
        public String f12612b;

        public UrlBookmark() {
        }

        public UrlBookmark(String str, String str2) {
            this.f12611a = str;
            this.f12612b = str2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12611a, false);
            b.a(parcel, 3, this.f12612b, false);
            b.b(parcel, a2);
        }
    }

    public static class WiFi extends AbstractSafeParcelable {
        public static final Parcelable.Creator<WiFi> CREATOR = new m();

        /* renamed from: a  reason: collision with root package name */
        public String f12613a;

        /* renamed from: b  reason: collision with root package name */
        public String f12614b;

        /* renamed from: c  reason: collision with root package name */
        public int f12615c;

        public WiFi() {
        }

        public WiFi(String str, String str2, int i2) {
            this.f12613a = str;
            this.f12614b = str2;
            this.f12615c = i2;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            int a2 = b.a(parcel, 20293);
            b.a(parcel, 2, this.f12613a, false);
            b.a(parcel, 3, this.f12614b, false);
            b.b(parcel, 4, this.f12615c);
            b.b(parcel, a2);
        }
    }

    public Barcode() {
    }

    public Barcode(int i2, String str, String str2, int i3, Point[] pointArr, Email email, Phone phone, Sms sms, WiFi wiFi, UrlBookmark urlBookmark, GeoPoint geoPoint, CalendarEvent calendarEvent, ContactInfo contactInfo, DriverLicense driverLicense, byte[] bArr, boolean z) {
        this.f12552a = i2;
        this.f12553b = str;
        this.o = bArr;
        this.f12554c = str2;
        this.f12555d = i3;
        this.f12556e = pointArr;
        this.p = z;
        this.f12557f = email;
        this.f12558g = phone;
        this.f12559h = sms;
        this.f12560i = wiFi;
        this.j = urlBookmark;
        this.k = geoPoint;
        this.l = calendarEvent;
        this.m = contactInfo;
        this.n = driverLicense;
    }

    public final Rect a() {
        int i2 = Integer.MAX_VALUE;
        int i3 = 0;
        int i4 = Integer.MAX_VALUE;
        int i5 = Integer.MIN_VALUE;
        int i6 = Integer.MIN_VALUE;
        while (true) {
            Point[] pointArr = this.f12556e;
            if (i3 >= pointArr.length) {
                return new Rect(i2, i4, i5, i6);
            }
            Point point = pointArr[i3];
            i2 = Math.min(i2, point.x);
            i5 = Math.max(i5, point.x);
            i4 = Math.min(i4, point.y);
            i6 = Math.max(i6, point.y);
            i3++;
        }
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = b.a(parcel, 20293);
        b.b(parcel, 2, this.f12552a);
        b.a(parcel, 3, this.f12553b, false);
        b.a(parcel, 4, this.f12554c, false);
        b.b(parcel, 5, this.f12555d);
        b.a(parcel, 6, (T[]) this.f12556e, i2);
        b.a(parcel, 7, this.f12557f, i2, false);
        b.a(parcel, 8, this.f12558g, i2, false);
        b.a(parcel, 9, this.f12559h, i2, false);
        b.a(parcel, 10, this.f12560i, i2, false);
        b.a(parcel, 11, this.j, i2, false);
        b.a(parcel, 12, this.k, i2, false);
        b.a(parcel, 13, this.l, i2, false);
        b.a(parcel, 14, this.m, i2, false);
        b.a(parcel, 15, this.n, i2, false);
        b.a(parcel, 16, this.o, false);
        b.a(parcel, 17, this.p);
        b.b(parcel, a2);
    }
}
