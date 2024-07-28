package net.one97.paytm.o2o.movies.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMovies;
import net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession;
import net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public final class SeatMapData implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    private String cinemaMovieInfoString;
    private boolean isMoviePassPresent;
    private CJRMovies movie;
    private String movieCensor;
    private String movieCode;
    private int movieDuration;
    private String movieImageUrl;
    private String movieLanguage;
    private String movieLocalizedLanguage;
    private String movieLocalizedTitle;
    private CJRMovieWidget movieOfferData;
    private int movieSessionPosition;
    private String movieTitle;
    private String seatStatus;
    private String selectedCategory;
    private String selectedCity;
    private CJRMoviesSession selectedMovieSession;
    private List<? extends CJRMoviesSession> sessionList;
    private String timeSlot;

    public static class Creator implements Parcelable.Creator {
        public final Object createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Parcel parcel2 = parcel;
            k.c(parcel2, "in");
            CJRMoviesSession cJRMoviesSession = (CJRMoviesSession) parcel2.readParcelable(SeatMapData.class.getClassLoader());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add((CJRMoviesSession) parcel2.readParcelable(SeatMapData.class.getClassLoader()));
                    readInt--;
                }
            } else {
                arrayList = null;
            }
            return new SeatMapData(cJRMoviesSession, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (CJRMovieWidget) parcel2.readParcelable(SeatMapData.class.getClassLoader()), parcel.readInt(), parcel.readString());
        }

        public final Object[] newArray(int i2) {
            return new SeatMapData[i2];
        }
    }

    public SeatMapData() {
        this((CJRMoviesSession) null, (List) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 0, (String) null, (String) null, false, (CJRMovieWidget) null, 0, (String) null, 262143, (g) null);
    }

    public static /* synthetic */ SeatMapData copy$default(SeatMapData seatMapData, CJRMoviesSession cJRMoviesSession, List list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, String str11, boolean z, CJRMovieWidget cJRMovieWidget, int i3, String str12, int i4, Object obj) {
        SeatMapData seatMapData2 = seatMapData;
        int i5 = i4;
        return seatMapData.copy((i5 & 1) != 0 ? seatMapData2.selectedMovieSession : cJRMoviesSession, (i5 & 2) != 0 ? seatMapData2.sessionList : list, (i5 & 4) != 0 ? seatMapData2.selectedCity : str, (i5 & 8) != 0 ? seatMapData2.selectedCategory : str2, (i5 & 16) != 0 ? seatMapData2.movieLanguage : str3, (i5 & 32) != 0 ? seatMapData2.movieLocalizedLanguage : str4, (i5 & 64) != 0 ? seatMapData2.timeSlot : str5, (i5 & 128) != 0 ? seatMapData2.movieCensor : str6, (i5 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? seatMapData2.movieImageUrl : str7, (i5 & 512) != 0 ? seatMapData2.movieTitle : str8, (i5 & TarConstants.EOF_BLOCK) != 0 ? seatMapData2.movieLocalizedTitle : str9, (i5 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0 ? seatMapData2.movieDuration : i2, (i5 & 4096) != 0 ? seatMapData2.movieCode : str10, (i5 & FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE) != 0 ? seatMapData2.seatStatus : str11, (i5 & 16384) != 0 ? seatMapData2.isMoviePassPresent : z, (i5 & 32768) != 0 ? seatMapData2.movieOfferData : cJRMovieWidget, (i5 & 65536) != 0 ? seatMapData2.movieSessionPosition : i3, (i5 & 131072) != 0 ? seatMapData2.cinemaMovieInfoString : str12);
    }

    public final CJRMoviesSession component1() {
        return this.selectedMovieSession;
    }

    public final String component10() {
        return this.movieTitle;
    }

    public final String component11() {
        return this.movieLocalizedTitle;
    }

    public final int component12() {
        return this.movieDuration;
    }

    public final String component13() {
        return this.movieCode;
    }

    public final String component14() {
        return this.seatStatus;
    }

    public final boolean component15() {
        return this.isMoviePassPresent;
    }

    public final CJRMovieWidget component16() {
        return this.movieOfferData;
    }

    public final int component17() {
        return this.movieSessionPosition;
    }

    public final String component18() {
        return this.cinemaMovieInfoString;
    }

    public final List<CJRMoviesSession> component2() {
        return this.sessionList;
    }

    public final String component3() {
        return this.selectedCity;
    }

    public final String component4() {
        return this.selectedCategory;
    }

    public final String component5() {
        return this.movieLanguage;
    }

    public final String component6() {
        return this.movieLocalizedLanguage;
    }

    public final String component7() {
        return this.timeSlot;
    }

    public final String component8() {
        return this.movieCensor;
    }

    public final String component9() {
        return this.movieImageUrl;
    }

    public final SeatMapData copy(CJRMoviesSession cJRMoviesSession, List<? extends CJRMoviesSession> list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, String str11, boolean z, CJRMovieWidget cJRMovieWidget, int i3, String str12) {
        return new SeatMapData(cJRMoviesSession, list, str, str2, str3, str4, str5, str6, str7, str8, str9, i2, str10, str11, z, cJRMovieWidget, i3, str12);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SeatMapData)) {
            return false;
        }
        SeatMapData seatMapData = (SeatMapData) obj;
        return k.a((Object) this.selectedMovieSession, (Object) seatMapData.selectedMovieSession) && k.a((Object) this.sessionList, (Object) seatMapData.sessionList) && k.a((Object) this.selectedCity, (Object) seatMapData.selectedCity) && k.a((Object) this.selectedCategory, (Object) seatMapData.selectedCategory) && k.a((Object) this.movieLanguage, (Object) seatMapData.movieLanguage) && k.a((Object) this.movieLocalizedLanguage, (Object) seatMapData.movieLocalizedLanguage) && k.a((Object) this.timeSlot, (Object) seatMapData.timeSlot) && k.a((Object) this.movieCensor, (Object) seatMapData.movieCensor) && k.a((Object) this.movieImageUrl, (Object) seatMapData.movieImageUrl) && k.a((Object) this.movieTitle, (Object) seatMapData.movieTitle) && k.a((Object) this.movieLocalizedTitle, (Object) seatMapData.movieLocalizedTitle) && this.movieDuration == seatMapData.movieDuration && k.a((Object) this.movieCode, (Object) seatMapData.movieCode) && k.a((Object) this.seatStatus, (Object) seatMapData.seatStatus) && this.isMoviePassPresent == seatMapData.isMoviePassPresent && k.a((Object) this.movieOfferData, (Object) seatMapData.movieOfferData) && this.movieSessionPosition == seatMapData.movieSessionPosition && k.a((Object) this.cinemaMovieInfoString, (Object) seatMapData.cinemaMovieInfoString);
    }

    public final int hashCode() {
        CJRMoviesSession cJRMoviesSession = this.selectedMovieSession;
        int i2 = 0;
        int hashCode = (cJRMoviesSession != null ? cJRMoviesSession.hashCode() : 0) * 31;
        List<? extends CJRMoviesSession> list = this.sessionList;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.selectedCity;
        int hashCode3 = (hashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.selectedCategory;
        int hashCode4 = (hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.movieLanguage;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.movieLocalizedLanguage;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.timeSlot;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.movieCensor;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.movieImageUrl;
        int hashCode9 = (hashCode8 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.movieTitle;
        int hashCode10 = (hashCode9 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.movieLocalizedTitle;
        int hashCode11 = (((hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31) + Integer.valueOf(this.movieDuration).hashCode()) * 31;
        String str10 = this.movieCode;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.seatStatus;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        boolean z = this.isMoviePassPresent;
        if (z) {
            z = true;
        }
        int i3 = (hashCode13 + (z ? 1 : 0)) * 31;
        CJRMovieWidget cJRMovieWidget = this.movieOfferData;
        int hashCode14 = (((i3 + (cJRMovieWidget != null ? cJRMovieWidget.hashCode() : 0)) * 31) + Integer.valueOf(this.movieSessionPosition).hashCode()) * 31;
        String str12 = this.cinemaMovieInfoString;
        if (str12 != null) {
            i2 = str12.hashCode();
        }
        return hashCode14 + i2;
    }

    public final String toString() {
        return "SeatMapData(selectedMovieSession=" + this.selectedMovieSession + ", sessionList=" + this.sessionList + ", selectedCity=" + this.selectedCity + ", selectedCategory=" + this.selectedCategory + ", movieLanguage=" + this.movieLanguage + ", movieLocalizedLanguage=" + this.movieLocalizedLanguage + ", timeSlot=" + this.timeSlot + ", movieCensor=" + this.movieCensor + ", movieImageUrl=" + this.movieImageUrl + ", movieTitle=" + this.movieTitle + ", movieLocalizedTitle=" + this.movieLocalizedTitle + ", movieDuration=" + this.movieDuration + ", movieCode=" + this.movieCode + ", seatStatus=" + this.seatStatus + ", isMoviePassPresent=" + this.isMoviePassPresent + ", movieOfferData=" + this.movieOfferData + ", movieSessionPosition=" + this.movieSessionPosition + ", cinemaMovieInfoString=" + this.cinemaMovieInfoString + ")";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        k.c(parcel, "parcel");
        parcel.writeParcelable(this.selectedMovieSession, i2);
        List<? extends CJRMoviesSession> list = this.sessionList;
        if (list != null) {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CJRMoviesSession writeParcelable : list) {
                parcel.writeParcelable(writeParcelable, i2);
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.selectedCity);
        parcel.writeString(this.selectedCategory);
        parcel.writeString(this.movieLanguage);
        parcel.writeString(this.movieLocalizedLanguage);
        parcel.writeString(this.timeSlot);
        parcel.writeString(this.movieCensor);
        parcel.writeString(this.movieImageUrl);
        parcel.writeString(this.movieTitle);
        parcel.writeString(this.movieLocalizedTitle);
        parcel.writeInt(this.movieDuration);
        parcel.writeString(this.movieCode);
        parcel.writeString(this.seatStatus);
        parcel.writeInt(this.isMoviePassPresent ? 1 : 0);
        parcel.writeParcelable(this.movieOfferData, i2);
        parcel.writeInt(this.movieSessionPosition);
        parcel.writeString(this.cinemaMovieInfoString);
    }

    public SeatMapData(CJRMoviesSession cJRMoviesSession, List<? extends CJRMoviesSession> list, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, String str10, String str11, boolean z, CJRMovieWidget cJRMovieWidget, int i3, String str12) {
        this.selectedMovieSession = cJRMoviesSession;
        this.sessionList = list;
        this.selectedCity = str;
        this.selectedCategory = str2;
        this.movieLanguage = str3;
        this.movieLocalizedLanguage = str4;
        this.timeSlot = str5;
        this.movieCensor = str6;
        this.movieImageUrl = str7;
        this.movieTitle = str8;
        this.movieLocalizedTitle = str9;
        this.movieDuration = i2;
        this.movieCode = str10;
        this.seatStatus = str11;
        this.isMoviePassPresent = z;
        this.movieOfferData = cJRMovieWidget;
        this.movieSessionPosition = i3;
        this.cinemaMovieInfoString = str12;
    }

    public final CJRMoviesSession getSelectedMovieSession() {
        return this.selectedMovieSession;
    }

    public final void setSelectedMovieSession(CJRMoviesSession cJRMoviesSession) {
        this.selectedMovieSession = cJRMoviesSession;
    }

    public final List<CJRMoviesSession> getSessionList() {
        return this.sessionList;
    }

    public final void setSessionList(List<? extends CJRMoviesSession> list) {
        this.sessionList = list;
    }

    public final String getSelectedCity() {
        return this.selectedCity;
    }

    public final void setSelectedCity(String str) {
        this.selectedCity = str;
    }

    public final String getSelectedCategory() {
        return this.selectedCategory;
    }

    public final void setSelectedCategory(String str) {
        this.selectedCategory = str;
    }

    public final String getMovieLanguage() {
        return this.movieLanguage;
    }

    public final void setMovieLanguage(String str) {
        this.movieLanguage = str;
    }

    public final String getMovieLocalizedLanguage() {
        return this.movieLocalizedLanguage;
    }

    public final void setMovieLocalizedLanguage(String str) {
        this.movieLocalizedLanguage = str;
    }

    public final String getTimeSlot() {
        return this.timeSlot;
    }

    public final void setTimeSlot(String str) {
        this.timeSlot = str;
    }

    public final String getMovieCensor() {
        return this.movieCensor;
    }

    public final void setMovieCensor(String str) {
        this.movieCensor = str;
    }

    public final String getMovieImageUrl() {
        return this.movieImageUrl;
    }

    public final void setMovieImageUrl(String str) {
        this.movieImageUrl = str;
    }

    public final String getMovieTitle() {
        return this.movieTitle;
    }

    public final void setMovieTitle(String str) {
        this.movieTitle = str;
    }

    public final String getMovieLocalizedTitle() {
        return this.movieLocalizedTitle;
    }

    public final void setMovieLocalizedTitle(String str) {
        this.movieLocalizedTitle = str;
    }

    public final int getMovieDuration() {
        return this.movieDuration;
    }

    public final void setMovieDuration(int i2) {
        this.movieDuration = i2;
    }

    public final String getMovieCode() {
        return this.movieCode;
    }

    public final void setMovieCode(String str) {
        this.movieCode = str;
    }

    public final String getSeatStatus() {
        return this.seatStatus;
    }

    public final void setSeatStatus(String str) {
        this.seatStatus = str;
    }

    public final boolean isMoviePassPresent() {
        return this.isMoviePassPresent;
    }

    public final void setMoviePassPresent(boolean z) {
        this.isMoviePassPresent = z;
    }

    public final CJRMovieWidget getMovieOfferData() {
        return this.movieOfferData;
    }

    public final void setMovieOfferData(CJRMovieWidget cJRMovieWidget) {
        this.movieOfferData = cJRMovieWidget;
    }

    public final int getMovieSessionPosition() {
        return this.movieSessionPosition;
    }

    public final void setMovieSessionPosition(int i2) {
        this.movieSessionPosition = i2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SeatMapData(net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession r20, java.util.List r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, int r31, java.lang.String r32, java.lang.String r33, boolean r34, net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget r35, int r36, java.lang.String r37, int r38, kotlin.g.b.g r39) {
        /*
            r19 = this;
            r0 = r38
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r20
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r21
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r22
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r23
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r24
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r25
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r26
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r27
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r28
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = 0
            goto L_0x0052
        L_0x0050:
            r11 = r29
        L_0x0052:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0058
            r12 = 0
            goto L_0x005a
        L_0x0058:
            r12 = r30
        L_0x005a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L_0x0060
            r13 = 0
            goto L_0x0062
        L_0x0060:
            r13 = r31
        L_0x0062:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L_0x0068
            r14 = 0
            goto L_0x006a
        L_0x0068:
            r14 = r32
        L_0x006a:
            r15 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r15 == 0) goto L_0x0070
            r15 = 0
            goto L_0x0072
        L_0x0070:
            r15 = r33
        L_0x0072:
            r2 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r2 == 0) goto L_0x0078
            r2 = 1
            goto L_0x007a
        L_0x0078:
            r2 = r34
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r35
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r17 = r0 & r17
            if (r17 == 0) goto L_0x008f
            r17 = -1
            goto L_0x0091
        L_0x008f:
            r17 = r36
        L_0x0091:
            r18 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r18
            if (r0 == 0) goto L_0x0099
            r0 = 0
            goto L_0x009b
        L_0x0099:
            r0 = r37
        L_0x009b:
            r20 = r19
            r21 = r1
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r26 = r7
            r27 = r8
            r28 = r9
            r29 = r10
            r30 = r11
            r31 = r12
            r32 = r13
            r33 = r14
            r34 = r15
            r35 = r2
            r36 = r16
            r37 = r17
            r38 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.o2o.movies.entity.SeatMapData.<init>(net.one97.paytm.o2o.movies.common.movies.search.CJRMoviesSession, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, java.lang.String, boolean, net.one97.paytm.o2o.movies.common.movies.widget.CJRMovieWidget, int, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final String getCinemaMovieInfoString() {
        return this.cinemaMovieInfoString;
    }

    public final void setCinemaMovieInfoString(String str) {
        this.cinemaMovieInfoString = str;
    }

    public final CJRMovies getMovie() {
        return this.movie;
    }

    public final void setMovie(CJRMovies cJRMovies) {
        this.movie = cJRMovies;
    }

    public final CJRMovies getSelectedMovie() {
        CJRMovies cJRMovies = this.movie;
        if (cJRMovies != null) {
            return cJRMovies;
        }
        CJRMovies cJRMovies2 = new CJRMovies();
        cJRMovies2.setTitle(this.movieTitle);
        cJRMovies2.setImageURL(this.movieImageUrl);
        cJRMovies2.setLanguage(this.movieLanguage);
        cJRMovies2.setCensor(this.movieCensor);
        cJRMovies2.setCode(this.movieCode);
        cJRMovies2.setDuration(this.movieDuration);
        this.movie = cJRMovies2;
        return cJRMovies2;
    }

    public final boolean isFreeSeating() {
        CJRMoviesSession cJRMoviesSession = this.selectedMovieSession;
        if (cJRMoviesSession != null) {
            return cJRMoviesSession.isFreeSeating();
        }
        return false;
    }

    public final int isFoodMandatory() {
        CJRMoviesSession cJRMoviesSession = this.selectedMovieSession;
        if (cJRMoviesSession != null) {
            return cJRMoviesSession.getmIsFoodMandatoryVoucer();
        }
        return 0;
    }

    public final boolean preconditionCheck() {
        return this.selectedMovieSession != null && this.sessionList != null && !TextUtils.isEmpty(this.selectedCity) && !TextUtils.isEmpty(this.timeSlot) && !TextUtils.isEmpty(this.movieCode) && !TextUtils.isEmpty(this.selectedCategory);
    }
}
