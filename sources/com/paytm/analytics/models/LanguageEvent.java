package com.paytm.analytics.models;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class LanguageEvent {
    public static final Companion Companion = new Companion((g) null);
    public static final String EVENT_TYPE_DEVICE_LANGUAGE = "device_language";
    private String ISO3Country;
    private String ISO3Language;
    private String country;
    private String displayCountry;
    private String displayLanguage;
    private String displayName;
    private String language;
    private String locale;

    public LanguageEvent() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, PriceRangeSeekBar.INVALID_POINTER_ID, (g) null);
    }

    public static /* synthetic */ LanguageEvent copy$default(LanguageEvent languageEvent, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        LanguageEvent languageEvent2 = languageEvent;
        int i3 = i2;
        return languageEvent.copy((i3 & 1) != 0 ? languageEvent2.language : str, (i3 & 2) != 0 ? languageEvent2.ISO3Language : str2, (i3 & 4) != 0 ? languageEvent2.country : str3, (i3 & 8) != 0 ? languageEvent2.ISO3Country : str4, (i3 & 16) != 0 ? languageEvent2.displayCountry : str5, (i3 & 32) != 0 ? languageEvent2.displayName : str6, (i3 & 64) != 0 ? languageEvent2.locale : str7, (i3 & 128) != 0 ? languageEvent2.displayLanguage : str8);
    }

    public final String component1() {
        return this.language;
    }

    public final String component2() {
        return this.ISO3Language;
    }

    public final String component3() {
        return this.country;
    }

    public final String component4() {
        return this.ISO3Country;
    }

    public final String component5() {
        return this.displayCountry;
    }

    public final String component6() {
        return this.displayName;
    }

    public final String component7() {
        return this.locale;
    }

    public final String component8() {
        return this.displayLanguage;
    }

    public final LanguageEvent copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        return new LanguageEvent(str, str2, str3, str4, str5, str6, str7, str8);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LanguageEvent)) {
            return false;
        }
        LanguageEvent languageEvent = (LanguageEvent) obj;
        return k.a((Object) this.language, (Object) languageEvent.language) && k.a((Object) this.ISO3Language, (Object) languageEvent.ISO3Language) && k.a((Object) this.country, (Object) languageEvent.country) && k.a((Object) this.ISO3Country, (Object) languageEvent.ISO3Country) && k.a((Object) this.displayCountry, (Object) languageEvent.displayCountry) && k.a((Object) this.displayName, (Object) languageEvent.displayName) && k.a((Object) this.locale, (Object) languageEvent.locale) && k.a((Object) this.displayLanguage, (Object) languageEvent.displayLanguage);
    }

    public final int hashCode() {
        String str = this.language;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ISO3Language;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.country;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.ISO3Country;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.displayCountry;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.displayName;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.locale;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.displayLanguage;
        if (str8 != null) {
            i2 = str8.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "LanguageEvent(language=" + this.language + ", ISO3Language=" + this.ISO3Language + ", country=" + this.country + ", ISO3Country=" + this.ISO3Country + ", displayCountry=" + this.displayCountry + ", displayName=" + this.displayName + ", locale=" + this.locale + ", displayLanguage=" + this.displayLanguage + ")";
    }

    public LanguageEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.language = str;
        this.ISO3Language = str2;
        this.country = str3;
        this.ISO3Country = str4;
        this.displayCountry = str5;
        this.displayName = str6;
        this.locale = str7;
        this.displayLanguage = str8;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final String getISO3Language() {
        return this.ISO3Language;
    }

    public final void setISO3Language(String str) {
        this.ISO3Language = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getISO3Country() {
        return this.ISO3Country;
    }

    public final void setISO3Country(String str) {
        this.ISO3Country = str;
    }

    public final String getDisplayCountry() {
        return this.displayCountry;
    }

    public final void setDisplayCountry(String str) {
        this.displayCountry = str;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final void setDisplayName(String str) {
        this.displayName = str;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final void setLocale(String str) {
        this.locale = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LanguageEvent(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.g.b.g r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.models.LanguageEvent.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getDisplayLanguage() {
        return this.displayLanguage;
    }

    public final void setDisplayLanguage(String str) {
        this.displayLanguage = str;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }
}
