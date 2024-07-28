package net.one97.paytm.hotel4.viewmodel;

import android.text.TextUtils;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.text.SimpleDateFormat;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.hotel4.utils.f;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;

public final class SRPHeaderViewModel extends BaseViewModel {
    private String dateText = "";
    private CJRHotelSearchInput searchInputData;
    private String srpHeaderText = H5Logger.HEADER;
    private String srpLoaderHeaderText = H5Logger.HEADER;
    private String srpSubheaderText = "Sub Header";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SRPHeaderViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
        updateData();
    }

    public final CJRHotelSearchInput getSearchInputData() {
        return this.searchInputData;
    }

    public final void setSearchInputData(CJRHotelSearchInput cJRHotelSearchInput) {
        this.searchInputData = cJRHotelSearchInput;
    }

    public final String getSrpLoaderHeaderText() {
        return this.srpLoaderHeaderText;
    }

    public final void setSrpLoaderHeaderText(String str) {
        this.srpLoaderHeaderText = str;
    }

    public final String getSrpHeaderText() {
        return this.srpHeaderText;
    }

    public final void setSrpHeaderText(String str) {
        this.srpHeaderText = str;
    }

    public final String getSrpSubheaderText() {
        return this.srpSubheaderText;
    }

    public final void setSrpSubheaderText(String str) {
        k.c(str, "<set-?>");
        this.srpSubheaderText = str;
    }

    public final String getDateText() {
        return this.dateText;
    }

    public final void setDateText(String str) {
        k.c(str, "<set-?>");
        this.dateText = str;
    }

    public final void updateData() {
        this.searchInputData = getParent().getSearchInput();
        setHeaderText();
        setHeaderTextForLoaderScreen();
        setSubHeader();
        this.dateText = getDateInfo();
    }

    public final void onEditClick() {
        getParent().postScreenNavigationEvent("2", "11");
    }

    public final void setHeaderText() {
        CJRHotelSearchInput cJRHotelSearchInput = this.searchInputData;
        String str = null;
        if (TextUtils.isEmpty(cJRHotelSearchInput != null ? cJRHotelSearchInput.getHotelId() : null)) {
            CJRHotelSearchInput cJRHotelSearchInput2 = this.searchInputData;
            if (!TextUtils.isEmpty(cJRHotelSearchInput2 != null ? cJRHotelSearchInput2.getPoi() : null)) {
                StringBuilder sb = new StringBuilder();
                CJRHotelSearchInput cJRHotelSearchInput3 = this.searchInputData;
                sb.append(cJRHotelSearchInput3 != null ? cJRHotelSearchInput3.getPoi() : null);
                sb.append(", ");
                CJRHotelSearchInput cJRHotelSearchInput4 = this.searchInputData;
                if (cJRHotelSearchInput4 != null) {
                    str = cJRHotelSearchInput4.getCity();
                }
                sb.append(str);
                str = sb.toString();
                this.srpHeaderText = str;
            }
        }
        CJRHotelSearchInput cJRHotelSearchInput5 = this.searchInputData;
        if (cJRHotelSearchInput5 != null) {
            str = cJRHotelSearchInput5.getCity();
        }
        this.srpHeaderText = str;
    }

    public final void setHeaderTextForLoaderScreen() {
        CJRHotelSearchInput cJRHotelSearchInput = this.searchInputData;
        String str = null;
        if (!TextUtils.isEmpty(cJRHotelSearchInput != null ? cJRHotelSearchInput.getPoi() : null)) {
            StringBuilder sb = new StringBuilder();
            CJRHotelSearchInput cJRHotelSearchInput2 = this.searchInputData;
            sb.append(cJRHotelSearchInput2 != null ? cJRHotelSearchInput2.getPoi() : null);
            sb.append(", ");
            CJRHotelSearchInput cJRHotelSearchInput3 = this.searchInputData;
            if (cJRHotelSearchInput3 != null) {
                str = cJRHotelSearchInput3.getCity();
            }
            sb.append(str);
            str = sb.toString();
        } else {
            CJRHotelSearchInput cJRHotelSearchInput4 = this.searchInputData;
            if (cJRHotelSearchInput4 != null) {
                str = cJRHotelSearchInput4.getCity();
            }
        }
        this.srpLoaderHeaderText = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x002c, code lost:
        r1 = r1.getRooms();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setSubHeader() {
        /*
            r6 = this;
            net.one97.paytm.hotel4.utils.e r0 = net.one97.paytm.hotel4.utils.e.f28642a
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r6.searchInputData
            if (r0 != 0) goto L_0x0009
            kotlin.g.b.k.a()
        L_0x0009:
            int r0 = r0.getAdultCount()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r6.searchInputData
            if (r1 != 0) goto L_0x0014
            kotlin.g.b.k.a()
        L_0x0014:
            int r1 = r1.getChildCount()
            int r0 = r0 + r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = " Guest"
            java.lang.String r2 = ", "
            java.lang.String r0 = net.one97.paytm.hotel4.utils.e.a(r1, r2, r0)
            net.one97.paytm.hotel4.utils.e r1 = net.one97.paytm.hotel4.utils.e.f28642a
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r6.searchInputData
            r2 = 0
            if (r1 == 0) goto L_0x003b
            java.util.ArrayList r1 = r1.getRooms()
            if (r1 == 0) goto L_0x003b
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x003c
        L_0x003b:
            r1 = r2
        L_0x003c:
            java.lang.String r3 = " Room"
            java.lang.String r4 = ""
            java.lang.String r1 = net.one97.paytm.hotel4.utils.e.a(r3, r4, r1)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r6.getDateInfo()
            r3.append(r4)
            java.lang.String r4 = " • "
            r3.append(r4)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r4 = r6.searchInputData
            if (r4 != 0) goto L_0x005c
            kotlin.g.b.k.a()
        L_0x005c:
            int r4 = r4.getAdultCount()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r5 = r6.searchInputData
            if (r5 != 0) goto L_0x0067
            kotlin.g.b.k.a()
        L_0x0067:
            int r5 = r5.getChildCount()
            int r4 = r4 + r5
            r3.append(r4)
            r3.append(r0)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r6.searchInputData
            if (r0 == 0) goto L_0x0084
            java.util.ArrayList r0 = r0.getRooms()
            if (r0 == 0) goto L_0x0084
            int r0 = r0.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
        L_0x0084:
            r3.append(r2)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r6.srpSubheaderText = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.SRPHeaderViewModel.setSubHeader():void");
    }

    private final String getDateInfo() {
        CJRHotelSearchInput cJRHotelSearchInput = this.searchInputData;
        String str = null;
        List<String> formattedDate = getFormattedDate(cJRHotelSearchInput != null ? cJRHotelSearchInput.getCheckInDate() : null);
        CJRHotelSearchInput cJRHotelSearchInput2 = this.searchInputData;
        if (cJRHotelSearchInput2 != null) {
            str = cJRHotelSearchInput2.getCheckOutDate();
        }
        List<String> formattedDate2 = getFormattedDate(str);
        if (formattedDate == null || formattedDate.size() <= 1 || formattedDate2 == null || formattedDate2.size() <= 1) {
            return "";
        }
        String str2 = formattedDate.get(1);
        if (p.b(str2, "0", false)) {
            str2 = p.a(str2, "0", "", false);
        }
        String str3 = formattedDate2.get(1);
        if (p.b(str3, "0", false)) {
            str3 = p.a(str3, "0", "", false);
        }
        String str4 = formattedDate.get(0);
        String str5 = formattedDate2.get(0);
        if (k.a((Object) formattedDate.get(0), (Object) formattedDate2.get(0))) {
            return str2 + " - " + str3 + ' ' + str4;
        }
        return str2 + ' ' + str4 + " - " + str3 + ' ' + str5;
    }

    private final List<String> getFormattedDate(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String format = new SimpleDateFormat("MMM,dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        k.a((Object) format, "checkInStr");
        return p.a((CharSequence) format, new String[]{AppConstants.COMMA});
    }

    public final String getNoSearchResultURL() {
        return f.c("lookingformorehotels");
    }

    public final String getErrorURL() {
        return f.c("searchemptyresult");
    }
}
