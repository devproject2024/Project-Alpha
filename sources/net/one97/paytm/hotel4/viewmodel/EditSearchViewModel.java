package net.one97.paytm.hotel4.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.y;
import com.paytm.utility.b;
import com.travel.utils.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.GuestAndRoomCountDetails;
import net.one97.paytm.hotel4.service.model.PopularRecentDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.search.FilterParams;
import net.one97.paytm.hotel4.service.model.datamodel.search.Locations;
import net.one97.paytm.hotel4.service.model.datamodel.search.SearchParamsDataItem;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SortKeysItem;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import org.json.JSONObject;

public final class EditSearchViewModel extends BaseViewModel {
    public GuestAndRoomCountDetails adultCount;
    private final int adultCountViewTag = 2;
    private l<String> checkInDate = new l<>();
    private l<String> checkInDay = new l<>();
    private l<String> checkInMonth = new l<>();
    private l<String> checkoutDate = new l<>();
    private l<String> checkoutDay = new l<>();
    private l<String> checkoutMonth = new l<>();
    public GuestAndRoomCountDetails childCount;
    private final int childeCountViewTag = 3;
    private y<Boolean> cityLocalityClick = new y<>();
    private l<String> cityName = new l<>();
    private y<Boolean> closeButtonClickListener = new y<>();
    private y<Boolean> dateClick = new y<>();
    private y<Integer> defaultValueOfAdult = new y<>();
    private y<Integer> defaultValueOfChild = new y<>();
    private y<Integer> defaultValueOfroomCount = new y<>();
    private int guestCountPerRoom = -1;
    private l<String> hotelName = new l<>();
    private y<Boolean> isOpenFromRoomSelection = new y<>();
    private l<String> locality = new l<>();
    private AutoSearchDataItem mAutoSearchDataItem;
    private Locations mLocationDetails;
    private int maxRoomValue = 1;
    private final int minAdultValue = 1;
    private final int minChildValue;
    private final int minRoomValue = 1;
    private String msearchType = "";
    private l<Integer> nightCount = new l<>();
    private l<String> nightCountText = new l<>();
    public GuestAndRoomCountDetails roomCount;
    private final int roomCountViewTag = 1;
    private y<o<Boolean, AutoSearchDataItem>> searchButtonClickListener = new y<>();
    private CJRHotelSearchInput searchInput;
    private String stringDateCheckIn = "";
    private String stringDateCheckout = "";
    private l<AutoSearchDataItem> updateRecentSearch = new l<>();
    private y<Boolean> updateSearchButtonClickListener = new y<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditSearchViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final int getRoomCountViewTag() {
        return this.roomCountViewTag;
    }

    public final int getAdultCountViewTag() {
        return this.adultCountViewTag;
    }

    public final int getChildeCountViewTag() {
        return this.childeCountViewTag;
    }

    public final y<Integer> getDefaultValueOfroomCount() {
        return this.defaultValueOfroomCount;
    }

    public final void setDefaultValueOfroomCount(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.defaultValueOfroomCount = yVar;
    }

    public final y<Integer> getDefaultValueOfAdult() {
        return this.defaultValueOfAdult;
    }

    public final void setDefaultValueOfAdult(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.defaultValueOfAdult = yVar;
    }

    public final y<Integer> getDefaultValueOfChild() {
        return this.defaultValueOfChild;
    }

    public final void setDefaultValueOfChild(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this.defaultValueOfChild = yVar;
    }

    public final l<AutoSearchDataItem> getUpdateRecentSearch() {
        return this.updateRecentSearch;
    }

    public final void setUpdateRecentSearch(l<AutoSearchDataItem> lVar) {
        k.c(lVar, "<set-?>");
        this.updateRecentSearch = lVar;
    }

    public final int getMaxRoomValue() {
        return this.maxRoomValue;
    }

    public final void setMaxRoomValue(int i2) {
        this.maxRoomValue = i2;
    }

    public final int getMinRoomValue() {
        return this.minRoomValue;
    }

    public final int getMinAdultValue() {
        return this.minAdultValue;
    }

    public final int getMinChildValue() {
        return this.minChildValue;
    }

    public final int getGuestCountPerRoom() {
        return this.guestCountPerRoom;
    }

    public final void setGuestCountPerRoom(int i2) {
        this.guestCountPerRoom = i2;
    }

    public final GuestAndRoomCountDetails getRoomCount() {
        GuestAndRoomCountDetails guestAndRoomCountDetails = this.roomCount;
        if (guestAndRoomCountDetails == null) {
            k.a("roomCount");
        }
        return guestAndRoomCountDetails;
    }

    public final void setRoomCount(GuestAndRoomCountDetails guestAndRoomCountDetails) {
        k.c(guestAndRoomCountDetails, "<set-?>");
        this.roomCount = guestAndRoomCountDetails;
    }

    public final GuestAndRoomCountDetails getAdultCount() {
        GuestAndRoomCountDetails guestAndRoomCountDetails = this.adultCount;
        if (guestAndRoomCountDetails == null) {
            k.a("adultCount");
        }
        return guestAndRoomCountDetails;
    }

    public final void setAdultCount(GuestAndRoomCountDetails guestAndRoomCountDetails) {
        k.c(guestAndRoomCountDetails, "<set-?>");
        this.adultCount = guestAndRoomCountDetails;
    }

    public final GuestAndRoomCountDetails getChildCount() {
        GuestAndRoomCountDetails guestAndRoomCountDetails = this.childCount;
        if (guestAndRoomCountDetails == null) {
            k.a("childCount");
        }
        return guestAndRoomCountDetails;
    }

    public final void setChildCount(GuestAndRoomCountDetails guestAndRoomCountDetails) {
        k.c(guestAndRoomCountDetails, "<set-?>");
        this.childCount = guestAndRoomCountDetails;
    }

    public final y<Boolean> getCloseButtonClickListener() {
        return this.closeButtonClickListener;
    }

    public final void setCloseButtonClickListener(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.closeButtonClickListener = yVar;
    }

    public final y<o<Boolean, AutoSearchDataItem>> getSearchButtonClickListener() {
        return this.searchButtonClickListener;
    }

    public final void setSearchButtonClickListener(y<o<Boolean, AutoSearchDataItem>> yVar) {
        k.c(yVar, "<set-?>");
        this.searchButtonClickListener = yVar;
    }

    public final y<Boolean> getUpdateSearchButtonClickListener() {
        return this.updateSearchButtonClickListener;
    }

    public final void setUpdateSearchButtonClickListener(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.updateSearchButtonClickListener = yVar;
    }

    public final y<Boolean> getCityLocalityClick() {
        return this.cityLocalityClick;
    }

    public final void setCityLocalityClick(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.cityLocalityClick = yVar;
    }

    public final y<Boolean> getDateClick() {
        return this.dateClick;
    }

    public final void setDateClick(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.dateClick = yVar;
    }

    public final y<Boolean> isOpenFromRoomSelection() {
        return this.isOpenFromRoomSelection;
    }

    public final void setOpenFromRoomSelection(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.isOpenFromRoomSelection = yVar;
    }

    public final CJRHotelSearchInput getSearchInput() {
        return this.searchInput;
    }

    public final void setSearchInput(CJRHotelSearchInput cJRHotelSearchInput) {
        this.searchInput = cJRHotelSearchInput;
    }

    public final l<String> getCityName() {
        return this.cityName;
    }

    public final void setCityName(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.cityName = lVar;
    }

    public final l<String> getLocality() {
        return this.locality;
    }

    public final void setLocality(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.locality = lVar;
    }

    public final l<String> getCheckInDate() {
        return this.checkInDate;
    }

    public final void setCheckInDate(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.checkInDate = lVar;
    }

    public final l<String> getCheckInMonth() {
        return this.checkInMonth;
    }

    public final void setCheckInMonth(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.checkInMonth = lVar;
    }

    public final l<String> getCheckInDay() {
        return this.checkInDay;
    }

    public final void setCheckInDay(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.checkInDay = lVar;
    }

    public final l<String> getCheckoutDate() {
        return this.checkoutDate;
    }

    public final void setCheckoutDate(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.checkoutDate = lVar;
    }

    public final l<String> getCheckoutMonth() {
        return this.checkoutMonth;
    }

    public final void setCheckoutMonth(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.checkoutMonth = lVar;
    }

    public final l<String> getCheckoutDay() {
        return this.checkoutDay;
    }

    public final void setCheckoutDay(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.checkoutDay = lVar;
    }

    public final l<Integer> getNightCount() {
        return this.nightCount;
    }

    public final void setNightCount(l<Integer> lVar) {
        k.c(lVar, "<set-?>");
        this.nightCount = lVar;
    }

    public final l<String> getNightCountText() {
        return this.nightCountText;
    }

    public final void setNightCountText(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.nightCountText = lVar;
    }

    public final String getStringDateCheckIn() {
        return this.stringDateCheckIn;
    }

    public final void setStringDateCheckIn(String str) {
        k.c(str, "<set-?>");
        this.stringDateCheckIn = str;
    }

    public final String getStringDateCheckout() {
        return this.stringDateCheckout;
    }

    public final void setStringDateCheckout(String str) {
        k.c(str, "<set-?>");
        this.stringDateCheckout = str;
    }

    public final l<String> getHotelName() {
        return this.hotelName;
    }

    public final void setHotelName(l<String> lVar) {
        k.c(lVar, "<set-?>");
        this.hotelName = lVar;
    }

    public final String getMsearchType() {
        return this.msearchType;
    }

    public final void setMsearchType(String str) {
        k.c(str, "<set-?>");
        this.msearchType = str;
    }

    public final void setHotelName(String str) {
        k.c(str, "hotelName");
        this.hotelName.setValue(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0028, code lost:
        r1 = r1.getRooms();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setAllData() {
        /*
            r5 = this;
            androidx.lifecycle.y<java.lang.Boolean> r0 = r5.isOpenFromRoomSelection
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r5.getParent()
            androidx.lifecycle.y r1 = r1.isFromRoomSelection()
            java.lang.Object r1 = r1.getValue()
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            if (r1 != 0) goto L_0x0014
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
        L_0x0014:
            r0.setValue(r1)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r5.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r0.getSearchInput()
            r5.searchInput = r0
            androidx.lifecycle.y<java.lang.Integer> r0 = r5.defaultValueOfroomCount
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r5.searchInput
            r2 = 0
            if (r1 == 0) goto L_0x0037
            java.util.ArrayList r1 = r1.getRooms()
            if (r1 == 0) goto L_0x0037
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0038
        L_0x0037:
            r1 = r2
        L_0x0038:
            r0.setValue(r1)
            androidx.lifecycle.y<java.lang.Integer> r0 = r5.defaultValueOfAdult
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r5.searchInput
            if (r1 == 0) goto L_0x004a
            int r1 = r1.getAdultCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x004b
        L_0x004a:
            r1 = r2
        L_0x004b:
            r0.setValue(r1)
            androidx.lifecycle.y<java.lang.Integer> r0 = r5.defaultValueOfChild
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r5.searchInput
            if (r1 == 0) goto L_0x005d
            int r1 = r1.getChildCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x005e
        L_0x005d:
            r1 = r2
        L_0x005e:
            r0.setValue(r1)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            if (r0 == 0) goto L_0x006a
            java.lang.String r0 = r0.getPoi()
            goto L_0x006b
        L_0x006a:
            r0 = r2
        L_0x006b:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x0090
            com.travel.utils.l<java.lang.String> r0 = r5.cityName
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r5.searchInput
            if (r1 == 0) goto L_0x007e
            java.lang.String r1 = r1.getCity()
            goto L_0x007f
        L_0x007e:
            r1 = r2
        L_0x007f:
            r0.setValue(r1)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            if (r0 == 0) goto L_0x008a
            java.lang.String r2 = r0.getCity()
        L_0x008a:
            java.lang.String r0 = ""
            r4 = r2
            r2 = r0
            r0 = r4
            goto L_0x00cf
        L_0x0090:
            com.travel.utils.l<java.lang.String> r0 = r5.cityName
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r5.searchInput
            if (r3 == 0) goto L_0x00a0
            java.lang.String r3 = r3.getPoi()
            goto L_0x00a1
        L_0x00a0:
            r3 = r2
        L_0x00a1:
            r1.append(r3)
            java.lang.String r3 = ", "
            r1.append(r3)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r5.searchInput
            if (r3 == 0) goto L_0x00b2
            java.lang.String r3 = r3.getCity()
            goto L_0x00b3
        L_0x00b2:
            r3 = r2
        L_0x00b3:
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r0.setValue(r1)
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r5.searchInput
            if (r0 == 0) goto L_0x00c6
            java.lang.String r0 = r0.getCity()
            goto L_0x00c7
        L_0x00c6:
            r0 = r2
        L_0x00c7:
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r5.searchInput
            if (r1 == 0) goto L_0x00cf
            java.lang.String r2 = r1.getPoi()
        L_0x00cf:
            r1 = 0
            r5.createHotelAutoSearchObject(r0, r2, r1)
            com.travel.utils.l<java.lang.Integer> r0 = r5.nightCount
            java.lang.Object r0 = r0.getValue()
            java.lang.Integer r0 = (java.lang.Integer) r0
            r5.updateNightText(r0)
            r5.setCheckInCheckOutInfo()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.EditSearchViewModel.setAllData():void");
    }

    public final void onCityLocalityClick() {
        Boolean value = getParent().isFromRoomSelection().getValue();
        if (value == null) {
            k.a();
        }
        if (!value.booleanValue()) {
            this.cityLocalityClick.postValue(Boolean.TRUE);
        }
    }

    public final void dateClick() {
        this.dateClick.setValue(Boolean.TRUE);
    }

    public final void closeButtonClickHandler() {
        this.closeButtonClickListener.postValue(Boolean.TRUE);
    }

    public final void searchButtonClick() {
        getParent().setSelectedSRPFilter(new HashMap());
        getParent().setFromFilterAvailableApiCall(false);
        closeButtonClickHandler();
        updateSearchInput(true);
        y<o<Boolean, AutoSearchDataItem>> yVar = this.searchButtonClickListener;
        Boolean bool = Boolean.TRUE;
        AutoSearchDataItem autoSearchDataItem = this.mAutoSearchDataItem;
        if (autoSearchDataItem == null) {
            k.a("mAutoSearchDataItem");
        }
        yVar.postValue(new o(bool, autoSearchDataItem));
    }

    public final void updateSearchButtonClick() {
        updateTemporarySearchInput();
        this.updateSearchButtonClickListener.postValue(Boolean.TRUE);
    }

    public final void updateNightText(Integer num) {
        l<String> lVar = this.nightCountText;
        e eVar = e.f28642a;
        lVar.setValue(e.a("Night", "", num));
    }

    public final void increaseCount(int i2) {
        if (i2 == this.roomCountViewTag) {
            GuestAndRoomCountDetails guestAndRoomCountDetails = this.roomCount;
            if (guestAndRoomCountDetails == null) {
                k.a("roomCount");
            }
            Integer value = guestAndRoomCountDetails.getCount().getValue();
            if (value == null) {
                k.a();
            }
            if (value.intValue() < this.maxRoomValue) {
                value = Integer.valueOf(value.intValue() + 1);
            }
            GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.adultCount;
            if (guestAndRoomCountDetails2 == null) {
                k.a("adultCount");
            }
            Integer value2 = guestAndRoomCountDetails2.getCount().getValue();
            if (value2 == null) {
                k.a();
            }
            checkRoomAdultCountDisablement(value2, value);
            GuestAndRoomCountDetails guestAndRoomCountDetails3 = this.roomCount;
            if (guestAndRoomCountDetails3 == null) {
                k.a("roomCount");
            }
            guestAndRoomCountDetails3.getCount().postValue(value);
            int intValue = value.intValue();
            GuestAndRoomCountDetails guestAndRoomCountDetails4 = this.adultCount;
            if (guestAndRoomCountDetails4 == null) {
                k.a("adultCount");
            }
            Integer value3 = guestAndRoomCountDetails4.getCount().getValue();
            if (value3 == null) {
                k.a();
            }
            k.a((Object) value3, "adultCount.count.value!!");
            if (k.a(intValue, value3.intValue()) > 0) {
                increaseAdultValue(value.intValue());
            }
        } else if (i2 == this.adultCountViewTag) {
            GuestAndRoomCountDetails guestAndRoomCountDetails5 = this.roomCount;
            if (guestAndRoomCountDetails5 == null) {
                k.a("roomCount");
            }
            Integer value4 = guestAndRoomCountDetails5.getCount().getValue();
            if (value4 == null) {
                k.a();
            }
            k.a((Object) value4, "roomCount.count.value!!");
            increaseAdultValue(value4.intValue());
        } else if (i2 == this.childeCountViewTag) {
            increaseChildValue();
        }
    }

    public final void decreaseCount(int i2) {
        if (i2 == this.roomCountViewTag) {
            GuestAndRoomCountDetails guestAndRoomCountDetails = this.roomCount;
            if (guestAndRoomCountDetails == null) {
                k.a("roomCount");
            }
            Integer value = guestAndRoomCountDetails.getCount().getValue();
            if (value == null) {
                k.a();
            }
            if (value.intValue() > this.minRoomValue) {
                value = Integer.valueOf(value.intValue() - 1);
            }
            GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.adultCount;
            if (guestAndRoomCountDetails2 == null) {
                k.a("adultCount");
            }
            Integer value2 = guestAndRoomCountDetails2.getCount().getValue();
            if (value2 == null) {
                k.a();
            }
            checkRoomAdultCountDisablement(value2, value);
            GuestAndRoomCountDetails guestAndRoomCountDetails3 = this.roomCount;
            if (guestAndRoomCountDetails3 == null) {
                k.a("roomCount");
            }
            guestAndRoomCountDetails3.getCount().postValue(value);
        } else if (i2 == this.adultCountViewTag) {
            GuestAndRoomCountDetails guestAndRoomCountDetails4 = this.adultCount;
            if (guestAndRoomCountDetails4 == null) {
                k.a("adultCount");
            }
            Integer value3 = guestAndRoomCountDetails4.getCount().getValue();
            if (value3 == null) {
                k.a();
            }
            int intValue = value3.intValue();
            GuestAndRoomCountDetails guestAndRoomCountDetails5 = this.roomCount;
            if (guestAndRoomCountDetails5 == null) {
                k.a("roomCount");
            }
            Integer value4 = guestAndRoomCountDetails5.getCount().getValue();
            if (value4 == null) {
                k.a();
            }
            k.a((Object) value4, "roomCount.count.value!!");
            if (k.a(intValue, value4.intValue()) > 0) {
                GuestAndRoomCountDetails guestAndRoomCountDetails6 = this.adultCount;
                if (guestAndRoomCountDetails6 == null) {
                    k.a("adultCount");
                }
                Integer value5 = guestAndRoomCountDetails6.getCount().getValue();
                if (value5 == null) {
                    k.a();
                }
                if (value5.intValue() > this.minAdultValue) {
                    value5 = Integer.valueOf(value5.intValue() - 1);
                }
                GuestAndRoomCountDetails guestAndRoomCountDetails7 = this.roomCount;
                if (guestAndRoomCountDetails7 == null) {
                    k.a("roomCount");
                }
                Integer value6 = guestAndRoomCountDetails7.getCount().getValue();
                if (value6 == null) {
                    k.a();
                }
                checkRoomAdultCountDisablement(value5, value6);
                GuestAndRoomCountDetails guestAndRoomCountDetails8 = this.adultCount;
                if (guestAndRoomCountDetails8 == null) {
                    k.a("adultCount");
                }
                guestAndRoomCountDetails8.getCount().postValue(value5);
            }
        } else if (i2 == this.childeCountViewTag) {
            GuestAndRoomCountDetails guestAndRoomCountDetails9 = this.childCount;
            if (guestAndRoomCountDetails9 == null) {
                k.a("childCount");
            }
            Integer value7 = guestAndRoomCountDetails9.getCount().getValue();
            if (value7 == null) {
                k.a();
            }
            if (value7.intValue() > this.minChildValue) {
                value7 = Integer.valueOf(value7.intValue() - 1);
            }
            checkChildCountDisablement(value7);
            GuestAndRoomCountDetails guestAndRoomCountDetails10 = this.childCount;
            if (guestAndRoomCountDetails10 == null) {
                k.a("childCount");
            }
            guestAndRoomCountDetails10.getCount().postValue(value7);
        }
    }

    private final void increaseAdultValue(int i2) {
        GuestAndRoomCountDetails guestAndRoomCountDetails = this.adultCount;
        if (guestAndRoomCountDetails == null) {
            k.a("adultCount");
        }
        Integer value = guestAndRoomCountDetails.getCount().getValue();
        if (value == null) {
            k.a();
        }
        Integer valueOf = Integer.valueOf(value.intValue() + 1);
        checkRoomAdultCountDisablement(valueOf, Integer.valueOf(i2));
        GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.adultCount;
        if (guestAndRoomCountDetails2 == null) {
            k.a("adultCount");
        }
        guestAndRoomCountDetails2.getCount().postValue(valueOf);
    }

    private final void increaseChildValue() {
        GuestAndRoomCountDetails guestAndRoomCountDetails = this.childCount;
        if (guestAndRoomCountDetails == null) {
            k.a("childCount");
        }
        Integer value = guestAndRoomCountDetails.getCount().getValue();
        if (value == null) {
            k.a();
        }
        Integer valueOf = Integer.valueOf(value.intValue() + 1);
        checkChildCountDisablement(valueOf);
        GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.childCount;
        if (guestAndRoomCountDetails2 == null) {
            k.a("childCount");
        }
        guestAndRoomCountDetails2.getCount().postValue(valueOf);
    }

    public final void setRoomDetails(String str, String str2) {
        y yVar = new y();
        y yVar2 = new y();
        yVar.setValue(Boolean.FALSE);
        yVar2.setValue(Boolean.TRUE);
        int i2 = this.roomCountViewTag;
        y<Integer> yVar3 = this.defaultValueOfroomCount;
        this.roomCount = new GuestAndRoomCountDetails(i2, str, str2, yVar3, yVar3.getValue(), this.maxRoomValue, false, yVar, yVar2);
    }

    public final void setAdultDetails(String str, String str2) {
        y yVar = new y();
        y yVar2 = new y();
        yVar.setValue(Boolean.FALSE);
        yVar2.setValue(Boolean.TRUE);
        int i2 = this.adultCountViewTag;
        y<Integer> yVar3 = this.defaultValueOfAdult;
        this.adultCount = new GuestAndRoomCountDetails(i2, str, str2, yVar3, yVar3.getValue(), this.guestCountPerRoom, false, yVar, yVar2);
    }

    public final void setChildDetails(String str, String str2) {
        y yVar = new y();
        y yVar2 = new y();
        yVar.setValue(Boolean.FALSE);
        yVar2.setValue(Boolean.TRUE);
        int i2 = this.childeCountViewTag;
        y<Integer> yVar3 = this.defaultValueOfChild;
        this.childCount = new GuestAndRoomCountDetails(i2, str, str2, yVar3, yVar3.getValue(), this.guestCountPerRoom, true, yVar, yVar2);
    }

    public final void setCounterDefaultBehaviour() {
        GuestAndRoomCountDetails guestAndRoomCountDetails = this.adultCount;
        if (guestAndRoomCountDetails == null) {
            k.a("adultCount");
        }
        Integer value = guestAndRoomCountDetails.getCount().getValue();
        GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.roomCount;
        if (guestAndRoomCountDetails2 == null) {
            k.a("roomCount");
        }
        checkRoomAdultCountDisablement(value, guestAndRoomCountDetails2.getCount().getValue());
        GuestAndRoomCountDetails guestAndRoomCountDetails3 = this.childCount;
        if (guestAndRoomCountDetails3 == null) {
            k.a("childCount");
        }
        checkChildCountDisablement(guestAndRoomCountDetails3.getCount().getValue());
    }

    private final void checkRoomAdultCountDisablement(Integer num, Integer num2) {
        if (num2 != null) {
            num2.intValue();
            if (num != null) {
                num.intValue();
                if (num2.intValue() == this.minRoomValue) {
                    GuestAndRoomCountDetails guestAndRoomCountDetails = this.roomCount;
                    if (guestAndRoomCountDetails == null) {
                        k.a("roomCount");
                    }
                    guestAndRoomCountDetails.getShowDisableMinus().postValue(Boolean.TRUE);
                } else {
                    GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.roomCount;
                    if (guestAndRoomCountDetails2 == null) {
                        k.a("roomCount");
                    }
                    guestAndRoomCountDetails2.getShowDisableMinus().postValue(Boolean.FALSE);
                }
                if (num2.intValue() < this.maxRoomValue) {
                    GuestAndRoomCountDetails guestAndRoomCountDetails3 = this.roomCount;
                    if (guestAndRoomCountDetails3 == null) {
                        k.a("roomCount");
                    }
                    guestAndRoomCountDetails3.getShowDisabledPlus().postValue(Boolean.FALSE);
                } else {
                    GuestAndRoomCountDetails guestAndRoomCountDetails4 = this.roomCount;
                    if (guestAndRoomCountDetails4 == null) {
                        k.a("roomCount");
                    }
                    guestAndRoomCountDetails4.getShowDisabledPlus().postValue(Boolean.TRUE);
                }
                if (num.intValue() == this.minAdultValue) {
                    GuestAndRoomCountDetails guestAndRoomCountDetails5 = this.adultCount;
                    if (guestAndRoomCountDetails5 == null) {
                        k.a("adultCount");
                    }
                    guestAndRoomCountDetails5.getShowDisableMinus().postValue(Boolean.TRUE);
                } else {
                    GuestAndRoomCountDetails guestAndRoomCountDetails6 = this.adultCount;
                    if (guestAndRoomCountDetails6 == null) {
                        k.a("adultCount");
                    }
                    guestAndRoomCountDetails6.getShowDisableMinus().postValue(Boolean.FALSE);
                }
                if (k.a(num2.intValue(), num.intValue()) < 0) {
                    GuestAndRoomCountDetails guestAndRoomCountDetails7 = this.adultCount;
                    if (guestAndRoomCountDetails7 == null) {
                        k.a("adultCount");
                    }
                    guestAndRoomCountDetails7.getShowDisableMinus().postValue(Boolean.FALSE);
                }
                if (k.a((Object) num2, (Object) num)) {
                    GuestAndRoomCountDetails guestAndRoomCountDetails8 = this.adultCount;
                    if (guestAndRoomCountDetails8 == null) {
                        k.a("adultCount");
                    }
                    guestAndRoomCountDetails8.getShowDisableMinus().postValue(Boolean.TRUE);
                }
            }
        }
    }

    private final void checkChildCountDisablement(Integer num) {
        if (num != null) {
            num.intValue();
            if (num.intValue() == this.minChildValue) {
                GuestAndRoomCountDetails guestAndRoomCountDetails = this.childCount;
                if (guestAndRoomCountDetails == null) {
                    k.a("childCount");
                }
                guestAndRoomCountDetails.getShowDisableMinus().postValue(Boolean.TRUE);
                return;
            }
            GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.childCount;
            if (guestAndRoomCountDetails2 == null) {
                k.a("childCount");
            }
            guestAndRoomCountDetails2.getShowDisableMinus().postValue(Boolean.FALSE);
        }
    }

    public final void setCheckInCheckOutInfo() {
        List<String> formattedDate = getParent().getFormattedDate(this.stringDateCheckIn);
        if (formattedDate.size() > 2) {
            this.checkInDay.setValue(formattedDate.get(0));
            this.checkInMonth.setValue(formattedDate.get(1));
            String str = formattedDate.get(2);
            if (p.b(str, "0", false)) {
                str = p.a(str, "0", "", false);
            }
            this.checkInDate.setValue(str);
        }
        List<String> formattedDate2 = getParent().getFormattedDate(this.stringDateCheckout);
        if (formattedDate2.size() > 2) {
            this.checkoutDay.setValue(formattedDate2.get(0));
            this.checkoutMonth.setValue(formattedDate2.get(1));
            String str2 = formattedDate2.get(2);
            if (p.b(str2, "0", false)) {
                str2 = p.a(str2, "0", "", false);
            }
            this.checkoutDate.setValue(str2);
        }
    }

    public final void updateSearchInput(boolean z) {
        CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
        if (searchInput2 != null) {
            GuestAndRoomCountDetails guestAndRoomCountDetails = this.adultCount;
            if (guestAndRoomCountDetails == null) {
                k.a("adultCount");
            }
            Integer value = guestAndRoomCountDetails.getCount().getValue();
            if (value == null) {
                k.a();
            }
            searchInput2.setAdultCount(value.intValue());
        }
        CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
        if (searchInput3 != null) {
            GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.childCount;
            if (guestAndRoomCountDetails2 == null) {
                k.a("childCount");
            }
            Integer value2 = guestAndRoomCountDetails2.getCount().getValue();
            if (value2 == null) {
                k.a();
            }
            searchInput3.setChildCount(value2.intValue());
        }
        CJRHotelSearchInput searchInput4 = getParent().getSearchInput();
        if (searchInput4 != null) {
            searchInput4.setRooms(getRoomDetails());
        }
        CJRHotelSearchInput searchInput5 = getParent().getSearchInput();
        if (searchInput5 != null) {
            searchInput5.setCheckInDate(b.b(this.stringDateCheckIn, "yyyy-MM-dd", "yyyy-MM-dd"));
        }
        CJRHotelSearchInput searchInput6 = getParent().getSearchInput();
        if (searchInput6 != null) {
            searchInput6.setCheckOutDate(b.b(this.stringDateCheckout, "yyyy-MM-dd", "yyyy-MM-dd"));
        }
        CJRHotelSearchInput searchInput7 = getParent().getSearchInput();
        if (searchInput7 != null) {
            Integer value3 = this.nightCount.getValue();
            if (value3 == null) {
                k.a();
            }
            searchInput7.setNumOfNights(value3.intValue());
        }
        updateNightText(this.nightCount.getValue());
        if (z) {
            updateCityLocality();
        }
    }

    public final void updateTemporarySearchInput() {
        getParent().setSearchTemporaryInput(new CJRHotelSearchInput());
        CJRHotelSearchInput searchTemporaryInput = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput != null) {
            GuestAndRoomCountDetails guestAndRoomCountDetails = this.adultCount;
            if (guestAndRoomCountDetails == null) {
                k.a("adultCount");
            }
            Integer value = guestAndRoomCountDetails.getCount().getValue();
            if (value == null) {
                k.a();
            }
            searchTemporaryInput.setAdultCount(value.intValue());
        }
        CJRHotelSearchInput searchTemporaryInput2 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput2 != null) {
            GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.childCount;
            if (guestAndRoomCountDetails2 == null) {
                k.a("childCount");
            }
            Integer value2 = guestAndRoomCountDetails2.getCount().getValue();
            if (value2 == null) {
                k.a();
            }
            searchTemporaryInput2.setChildCount(value2.intValue());
        }
        CJRHotelSearchInput searchTemporaryInput3 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput3 != null) {
            searchTemporaryInput3.setRooms(getRoomDetails());
        }
        CJRHotelSearchInput searchTemporaryInput4 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput4 != null) {
            searchTemporaryInput4.setCheckInDate(b.b(this.stringDateCheckIn, "yyyy-MM-dd", "yyyy-MM-dd"));
        }
        CJRHotelSearchInput searchTemporaryInput5 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput5 != null) {
            searchTemporaryInput5.setCheckOutDate(b.b(this.stringDateCheckout, "yyyy-MM-dd", "yyyy-MM-dd"));
        }
        CJRHotelSearchInput searchTemporaryInput6 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput6 != null) {
            Integer value3 = this.nightCount.getValue();
            if (value3 == null) {
                k.a();
            }
            searchTemporaryInput6.setNumOfNights(value3.intValue());
        }
        CJRHotelSearchInput searchTemporaryInput7 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput7 != null) {
            searchTemporaryInput7.setCity(this.cityName.getValue());
        }
        updateNightText(this.nightCount.getValue());
    }

    public final ArrayList<CJRRoom> getRoomDetails() {
        ArrayList<CJRRoom> arrayList = new ArrayList<>();
        GuestAndRoomCountDetails guestAndRoomCountDetails = this.adultCount;
        if (guestAndRoomCountDetails == null) {
            k.a("adultCount");
        }
        Integer value = guestAndRoomCountDetails.getCount().getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "adultCount.count.value!!");
        int intValue = value.intValue();
        GuestAndRoomCountDetails guestAndRoomCountDetails2 = this.childCount;
        if (guestAndRoomCountDetails2 == null) {
            k.a("childCount");
        }
        Integer value2 = guestAndRoomCountDetails2.getCount().getValue();
        if (value2 == null) {
            k.a();
        }
        k.a((Object) value2, "childCount.count.value!!");
        int intValue2 = value2.intValue();
        GuestAndRoomCountDetails guestAndRoomCountDetails3 = this.roomCount;
        if (guestAndRoomCountDetails3 == null) {
            k.a("roomCount");
        }
        Integer value3 = guestAndRoomCountDetails3.getCount().getValue();
        while (true) {
            if (value3 != null && value3.intValue() == 0) {
                return arrayList;
            }
            double d2 = (double) intValue;
            if (value3 == null) {
                k.a();
            }
            int ceil = (int) Math.ceil(d2 / ((double) value3.intValue()));
            int ceil2 = (int) Math.ceil(((double) intValue2) / ((double) value3.intValue()));
            CJRRoom cJRRoom = r7;
            CJRRoom cJRRoom2 = new CJRRoom(0, 0, 0, (ArrayList) null, (String) null, (String) null, (String) null, 127, (g) null);
            CJRRoom cJRRoom3 = cJRRoom;
            cJRRoom3.setAdultCount(ceil);
            cJRRoom3.setChildrenCount(ceil2);
            if (ceil2 > 0) {
                cJRRoom3.setChildrenAges(new ArrayList());
                for (int i2 = 0; i2 < ceil2; i2++) {
                    ArrayList<Integer> childrenAges = cJRRoom3.getChildrenAges();
                    if (childrenAges != null) {
                        childrenAges.add(5);
                    }
                }
            } else {
                cJRRoom3.setChildrenAges(new ArrayList());
            }
            arrayList.add(cJRRoom3);
            intValue -= ceil;
            intValue2 -= ceil2;
            value3 = Integer.valueOf(value3.intValue() - 1);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void openCalder(androidx.fragment.app.Fragment r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.String r1 = "activity"
            r2 = r20
            kotlin.g.b.k.c(r2, r1)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r19.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            if (r1 == 0) goto L_0x010c
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyy MM dd"
            r3.<init>(r4)
            java.lang.String r4 = r1.getCheckInDate()
            if (r4 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            java.lang.String r5 = " "
            java.lang.String r6 = "-"
            r7 = 0
            java.lang.String r4 = kotlin.m.p.a(r4, r6, r5, r7)
            java.lang.String r8 = r0.stringDateCheckIn
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9 = 1
            if (r8 == 0) goto L_0x003d
            int r8 = r8.length()
            if (r8 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r8 = 0
            goto L_0x003e
        L_0x003d:
            r8 = 1
        L_0x003e:
            java.lang.String r10 = "format.format(format.parse(checkInDateLocal))"
            if (r8 != 0) goto L_0x0062
            java.lang.String r4 = r0.stringDateCheckIn
            java.lang.String r4 = kotlin.m.p.a(r4, r6, r5, r7)
            java.util.Date r4 = r3.parse(r4)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r4 = r3.format(r4)     // Catch:{ Exception -> 0x0054 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)     // Catch:{ Exception -> 0x0054 }
            goto L_0x006d
        L_0x0054:
            java.lang.String r4 = r1.getCheckInDate()
            if (r4 != 0) goto L_0x005e
            kotlin.g.b.k.a()
        L_0x005e:
            java.lang.String r4 = kotlin.m.p.a(r4, r6, r5, r7)
        L_0x0062:
            java.util.Date r4 = r3.parse(r4)
            java.lang.String r4 = r3.format(r4)
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r10)
        L_0x006d:
            r13 = r4
            java.lang.String r4 = r1.getCheckOutDate()
            if (r4 != 0) goto L_0x0077
            kotlin.g.b.k.a()
        L_0x0077:
            java.lang.String r4 = kotlin.m.p.a(r4, r6, r5, r7)
            java.lang.String r8 = r0.stringDateCheckout
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            if (r8 == 0) goto L_0x0089
            int r8 = r8.length()
            if (r8 != 0) goto L_0x0088
            goto L_0x0089
        L_0x0088:
            r9 = 0
        L_0x0089:
            java.lang.String r8 = "format.format(format.parse(checkOutDateLocal))"
            if (r9 != 0) goto L_0x00ae
            java.lang.String r4 = r0.stringDateCheckout
            java.lang.String r4 = kotlin.m.p.a(r4, r6, r5, r7)
            java.util.Date r4 = r3.parse(r4)     // Catch:{ Exception -> 0x00a0 }
            java.lang.String r4 = r3.format(r4)     // Catch:{ Exception -> 0x00a0 }
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r8)     // Catch:{ Exception -> 0x00a0 }
            r14 = r4
            goto L_0x00ba
        L_0x00a0:
            java.lang.String r4 = r1.getCheckOutDate()
            if (r4 != 0) goto L_0x00aa
            kotlin.g.b.k.a()
        L_0x00aa:
            java.lang.String r4 = kotlin.m.p.a(r4, r6, r5, r7)
        L_0x00ae:
            java.util.Date r4 = r3.parse(r4)
            java.lang.String r3 = r3.format(r4)
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r8)
            r14 = r3
        L_0x00ba:
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r19.getParent()
            r3.getContext()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r19.getParent()
            net.one97.paytm.hotel4.service.model.datamodel.HotelConfig r3 = r3.getHotelConfig()
            java.lang.String r3 = r3.getToday()
            java.lang.String r4 = "dd/MM/yyyy"
            java.lang.String r8 = "yyyy-MM-dd"
            java.lang.String r3 = com.paytm.utility.b.b((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r8)
            java.lang.String r4 = "CJRAppCommonUtility.form…d/MM/yyyy\", \"yyyy-MM-dd\")"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            kotlin.m.p.a(r3, r6, r5, r7)
            net.one97.paytm.hotels2.utils.d r11 = net.one97.paytm.hotels2.utils.c.b()
            android.content.Context r12 = r20.getContext()
            java.lang.String r16 = r1.getCity()
            net.one97.paytm.hotels2.utils.d r3 = net.one97.paytm.hotels2.utils.c.b()
            java.lang.String r4 = "HotelController.getHotelEventListener()"
            kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r4)
            java.lang.String r17 = r3.d()
            int r18 = r1.getMaxStayNoightCount()
            java.lang.String r15 = "Select Dates"
            android.content.Intent r1 = r11.a((android.content.Context) r12, (java.lang.String) r13, (java.lang.String) r14, (java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (int) r18)
            androidx.fragment.app.FragmentActivity r2 = r20.getActivity()
            if (r2 == 0) goto L_0x010c
            r3 = 99
            r2.startActivityForResult(r1, r3)
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.EditSearchViewModel.openCalder(androidx.fragment.app.Fragment):void");
    }

    public final void setSelectedInput(Intent intent) {
        k.c(intent, "data");
        if (intent.hasExtra("localitySearchType")) {
            String stringExtra = intent.getStringExtra("localitySearchType");
            k.a((Object) stringExtra, "data.getStringExtra(CJRH…ENT_LOCALITY_RESULT_TYPE)");
            this.msearchType = stringExtra;
            String str = this.msearchType;
            int hashCode = str.hashCode();
            if (hashCode != 888645703) {
                if (hashCode != 1133114528) {
                    if (hashCode == 1303869229 && str.equals("trendingSearch")) {
                        setTrendingSearchData(intent);
                    }
                } else if (str.equals("userLocation")) {
                    setLocationSearchData(intent);
                }
            } else if (str.equals("searched")) {
                setSearchedTypeData(intent);
            }
        }
    }

    private final void setLocationSearchData(Intent intent) {
        this.mLocationDetails = new Locations((String) null, (String) null, (String) null, 7, (g) null);
        Locations locations = this.mLocationDetails;
        if (locations == null) {
            k.a("mLocationDetails");
        }
        String stringExtra = intent.getStringExtra("lat");
        k.a((Object) stringExtra, "data.getStringExtra(\"lat\")");
        locations.setLat(stringExtra);
        Locations locations2 = this.mLocationDetails;
        if (locations2 == null) {
            k.a("mLocationDetails");
        }
        String stringExtra2 = intent.getStringExtra("lon");
        k.a((Object) stringExtra2, "data.getStringExtra(\"lon\")");
        locations2.setLon(stringExtra2);
        Locations locations3 = this.mLocationDetails;
        if (locations3 == null) {
            k.a("mLocationDetails");
        }
        String stringExtra3 = intent.getStringExtra("cityName");
        k.a((Object) stringExtra3, "data.getStringExtra(\"cityName\")");
        locations3.setCityName(stringExtra3);
        l<String> lVar = this.cityName;
        lVar.setValue(intent.getStringExtra("locality") + ", " + intent.getStringExtra("cityName"));
        this.locality.setValue(intent.getStringExtra("locality"));
        Locations locations4 = this.mLocationDetails;
        if (locations4 == null) {
            k.a("mLocationDetails");
        }
        createHotelAutoSearchObject(locations4.getCityName(), this.locality.getValue(), true);
    }

    private final void setTrendingSearchData(Intent intent) {
        Serializable serializableExtra = intent.getSerializableExtra("selected_data_popular");
        if (serializableExtra != null) {
            PopularRecentDataItem popularRecentDataItem = (PopularRecentDataItem) serializableExtra;
            this.cityName.setValue(popularRecentDataItem.getCity());
            createHotelAutoSearchObject(popularRecentDataItem.getCity(), "", false);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.PopularRecentDataItem");
    }

    private final void setSearchedTypeData(Intent intent) {
        l<String> lVar;
        Serializable serializableExtra = intent.getSerializableExtra("selected_data_autoSuggest");
        if (serializableExtra != null) {
            AutoSearchDataItem autoSearchDataItem = (AutoSearchDataItem) serializableExtra;
            this.mAutoSearchDataItem = autoSearchDataItem;
            String str = null;
            if (autoSearchDataItem.getDisplay() != null) {
                List<String> display = autoSearchDataItem.getDisplay();
                Integer valueOf = display != null ? Integer.valueOf(display.size()) : null;
                if (valueOf == null) {
                    k.a();
                }
                if (valueOf.intValue() > 1) {
                    List<String> display2 = autoSearchDataItem.getDisplay();
                    if (!TextUtils.isEmpty(display2 != null ? display2.get(1) : null)) {
                        lVar = this.cityName;
                        StringBuilder sb = new StringBuilder();
                        List<String> display3 = autoSearchDataItem.getDisplay();
                        sb.append(display3 != null ? display3.get(0) : null);
                        sb.append(", ");
                        List<String> display4 = autoSearchDataItem.getDisplay();
                        if (display4 != null) {
                            str = display4.get(1);
                        }
                        sb.append(str);
                        str = sb.toString();
                        lVar.setValue(str);
                        return;
                    }
                }
            }
            lVar = this.cityName;
            List<String> display5 = autoSearchDataItem.getDisplay();
            if (display5 != null) {
                str = display5.get(0);
            }
            lVar.setValue(str);
            return;
        }
        throw new u("null cannot be cast to non-null type net.one97.paytm.hotel4.service.model.datamodel.search.AutoSearchDataItem");
    }

    public final void createHotelAutoSearchObject(String str, String str2, boolean z) {
        try {
            this.mAutoSearchDataItem = new AutoSearchDataItem((Integer) null, (List) null, (SearchParamsDataItem) null, (String) null, (Integer) null, false, 63, (g) null);
            ArrayList arrayList = new ArrayList();
            if (str == null) {
                k.a();
            }
            arrayList.add(str);
            AutoSearchDataItem autoSearchDataItem = this.mAutoSearchDataItem;
            if (autoSearchDataItem == null) {
                k.a("mAutoSearchDataItem");
            }
            autoSearchDataItem.setDisplay(arrayList);
            SearchParamsDataItem searchParamsDataItem = new SearchParamsDataItem((String) null, (String) null, (String) null, false, false, (FilterParams) null, 63, (g) null);
            searchParamsDataItem.setCity(str);
            if (!TextUtils.isEmpty(str2)) {
                searchParamsDataItem.setPoi(str2);
            }
            searchParamsDataItem.setNearBy(z);
            AutoSearchDataItem autoSearchDataItem2 = this.mAutoSearchDataItem;
            if (autoSearchDataItem2 == null) {
                k.a("mAutoSearchDataItem");
            }
            autoSearchDataItem2.setSearchParams(searchParamsDataItem);
        } catch (Exception unused) {
        }
    }

    private final void updateCityLocality() {
        FilterParams filter_params;
        FilterParams filter_params2;
        new JSONObject();
        String str = this.msearchType;
        int hashCode = str.hashCode();
        String str2 = null;
        if (hashCode != 888645703) {
            if (hashCode != 1133114528) {
                if (hashCode == 1303869229 && str.equals("trendingSearch")) {
                    CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
                    if (searchInput2 != null) {
                        searchInput2.setPlaceDetail(this.cityName.getValue());
                    }
                    CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
                    if (searchInput3 != null) {
                        AutoSearchDataItem autoSearchDataItem = this.mAutoSearchDataItem;
                        if (autoSearchDataItem == null) {
                            k.a("mAutoSearchDataItem");
                        }
                        SearchParamsDataItem searchParams = autoSearchDataItem.getSearchParams();
                        searchInput3.setCity(searchParams != null ? searchParams.getCity() : null);
                    }
                    CJRHotelSearchInput searchInput4 = getParent().getSearchInput();
                    if (searchInput4 != null) {
                        searchInput4.setHotelId("");
                    }
                    CJRHotelSearchInput searchInput5 = getParent().getSearchInput();
                    if (searchInput5 != null) {
                        searchInput5.setPoi("");
                    }
                    CJRHotelSearchInput searchInput6 = getParent().getSearchInput();
                    if (searchInput6 != null) {
                        searchInput6.setNearBySearch(false);
                    }
                    CJRHotelSearchInput searchInput7 = getParent().getSearchInput();
                    if (searchInput7 != null) {
                        searchInput7.setSortBy((SortKeysItem) null);
                    }
                }
            } else if (str.equals("userLocation")) {
                CJRHotelSearchInput searchInput8 = getParent().getSearchInput();
                if (searchInput8 != null) {
                    searchInput8.setPlaceDetail(this.cityName.getValue());
                }
                CJRHotelSearchInput searchInput9 = getParent().getSearchInput();
                if (searchInput9 != null) {
                    searchInput9.setPoi(this.locality.getValue());
                }
                CJRHotelSearchInput searchInput10 = getParent().getSearchInput();
                if (searchInput10 != null) {
                    searchInput10.setCity(this.cityName.getValue());
                }
                CJRHotelSearchInput searchInput11 = getParent().getSearchInput();
                if (searchInput11 != null) {
                    searchInput11.setNearBySearch(true);
                }
                CJRHotelSearchInput searchInput12 = getParent().getSearchInput();
                if (searchInput12 != null) {
                    searchInput12.setPlaceDetail("Near me");
                }
                CJRHotelSearchInput searchInput13 = getParent().getSearchInput();
                if (searchInput13 != null) {
                    Locations locations = this.mLocationDetails;
                    if (locations == null) {
                        k.a("mLocationDetails");
                    }
                    searchInput13.setCity(locations.getCityName());
                }
                CJRHotelSearchInput searchInput14 = getParent().getSearchInput();
                if (searchInput14 != null) {
                    Locations locations2 = this.mLocationDetails;
                    if (locations2 == null) {
                        k.a("mLocationDetails");
                    }
                    searchInput14.setLocationDetails(locations2);
                }
                CJRHotelSearchInput searchInput15 = getParent().getSearchInput();
                if (searchInput15 != null) {
                    searchInput15.setHotelId("");
                }
                CJRHotelSearchInput searchInput16 = getParent().getSearchInput();
                if (searchInput16 != null) {
                    searchInput16.setSortBy(getSortObj());
                }
            }
        } else if (str.equals("searched")) {
            CJRHotelSearchInput searchInput17 = getParent().getSearchInput();
            if (searchInput17 != null) {
                searchInput17.setNearBySearch(false);
            }
            CJRHotelSearchInput searchInput18 = getParent().getSearchInput();
            if (searchInput18 != null) {
                searchInput18.setPlaceDetail(this.cityName.getValue());
            }
            CJRHotelSearchInput searchInput19 = getParent().getSearchInput();
            if (searchInput19 != null) {
                AutoSearchDataItem autoSearchDataItem2 = this.mAutoSearchDataItem;
                if (autoSearchDataItem2 == null) {
                    k.a("mAutoSearchDataItem");
                }
                SearchParamsDataItem searchParams2 = autoSearchDataItem2.getSearchParams();
                searchInput19.setCity(searchParams2 != null ? searchParams2.getCity() : null);
            }
            CJRHotelSearchInput searchInput20 = getParent().getSearchInput();
            if (searchInput20 != null) {
                AutoSearchDataItem autoSearchDataItem3 = this.mAutoSearchDataItem;
                if (autoSearchDataItem3 == null) {
                    k.a("mAutoSearchDataItem");
                }
                SearchParamsDataItem searchParams3 = autoSearchDataItem3.getSearchParams();
                searchInput20.setLocationDetails((searchParams3 == null || (filter_params2 = searchParams3.getFilter_params()) == null) ? null : filter_params2.getLocation());
            }
            CJRHotelSearchInput searchInput21 = getParent().getSearchInput();
            if (searchInput21 != null) {
                AutoSearchDataItem autoSearchDataItem4 = this.mAutoSearchDataItem;
                if (autoSearchDataItem4 == null) {
                    k.a("mAutoSearchDataItem");
                }
                SearchParamsDataItem searchParams4 = autoSearchDataItem4.getSearchParams();
                searchInput21.setHotelId((searchParams4 == null || (filter_params = searchParams4.getFilter_params()) == null) ? null : filter_params.getHotelId());
            }
            CJRHotelSearchInput searchInput22 = getParent().getSearchInput();
            if (searchInput22 != null) {
                AutoSearchDataItem autoSearchDataItem5 = this.mAutoSearchDataItem;
                if (autoSearchDataItem5 == null) {
                    k.a("mAutoSearchDataItem");
                }
                SearchParamsDataItem searchParams5 = autoSearchDataItem5.getSearchParams();
                searchInput22.setPoi(searchParams5 != null ? searchParams5.getPoi() : null);
            }
            CJRHotelSearchInput searchInput23 = getParent().getSearchInput();
            if (searchInput23 != null) {
                AutoSearchDataItem autoSearchDataItem6 = this.mAutoSearchDataItem;
                if (autoSearchDataItem6 == null) {
                    k.a("mAutoSearchDataItem");
                }
                SearchParamsDataItem searchParams6 = autoSearchDataItem6.getSearchParams();
                if (searchParams6 == null) {
                    k.a();
                }
                searchInput23.setLocalitySearch(searchParams6.is_locality_search());
            }
            AutoSearchDataItem autoSearchDataItem7 = this.mAutoSearchDataItem;
            if (autoSearchDataItem7 == null) {
                k.a("mAutoSearchDataItem");
            }
            SearchParamsDataItem searchParams7 = autoSearchDataItem7.getSearchParams();
            if (searchParams7 != null) {
                str2 = searchParams7.getSort_by();
            }
            if (!TextUtils.isEmpty(str2)) {
                SortKeysItem sortKeysItem = new SortKeysItem((String) null, (String) null, (String) null, false, 15, (g) null);
                sortKeysItem.setUrlParams("sort_by");
                sortKeysItem.setSelected(true);
                AutoSearchDataItem autoSearchDataItem8 = this.mAutoSearchDataItem;
                if (autoSearchDataItem8 == null) {
                    k.a("mAutoSearchDataItem");
                }
                SearchParamsDataItem searchParams8 = autoSearchDataItem8.getSearchParams();
                if (searchParams8 == null) {
                    k.a();
                }
                sortKeysItem.setDefault(searchParams8.getSort_by());
                CJRHotelSearchInput searchInput24 = getParent().getSearchInput();
                if (searchInput24 != null) {
                    searchInput24.setSortBy(sortKeysItem);
                }
            }
            AutoSearchDataItem autoSearchDataItem9 = this.mAutoSearchDataItem;
            if (autoSearchDataItem9 == null) {
                k.a("mAutoSearchDataItem");
            }
            if (!autoSearchDataItem9.isRecentSearch()) {
                AutoSearchDataItem autoSearchDataItem10 = this.mAutoSearchDataItem;
                if (autoSearchDataItem10 == null) {
                    k.a("mAutoSearchDataItem");
                }
                autoSearchDataItem10.setRecentSearch(true);
                l<AutoSearchDataItem> lVar = this.updateRecentSearch;
                AutoSearchDataItem autoSearchDataItem11 = this.mAutoSearchDataItem;
                if (autoSearchDataItem11 == null) {
                    k.a("mAutoSearchDataItem");
                }
                lVar.setValue(autoSearchDataItem11);
            }
        }
    }

    public final SortKeysItem getSortObj() {
        SortKeysItem sortKeysItem = new SortKeysItem((String) null, (String) null, (String) null, false, 15, (g) null);
        sortKeysItem.setUrlParams("sort_by");
        sortKeysItem.setSelected(true);
        sortKeysItem.setDefault("distance_asc");
        sortKeysItem.setName("Closest");
        return sortKeysItem;
    }

    public final void setmaxRoomCount(int i2) {
        this.maxRoomValue = i2;
    }
}
