package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import androidx.lifecycle.y;
import com.paytm.utility.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.utils.l;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.details.PriceData;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.SubRoomOptions;
import net.one97.paytm.hotel4.service.model.details.SubRoomProvider;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotels2.R;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;
import net.one97.paytm.nativesdk.Constants.SDKConstants;

public final class RoomSelectionViewModel extends BaseViewModel {
    private y<String> _bedType = new y<>();
    private l<Boolean> _refreshAddHotelData = new l<>();
    private l<Boolean> _refreshRemoveHotelData = new l<>();
    private y<Boolean> _roomSelectedPopUp = new y<>();
    private y<String> _roomTypeCount = new y<>();
    private y<String> _selectedRoomCGSTPrice = new y<>();
    private y<Integer> _selectedRoomCount = new y<>();
    private y<SubRoomOptions> _selectedRoomData = new y<>();
    private y<Boolean> _selectedRoomDataContinue = new y<>();
    private y<Double> _selectedRoomFinalPriceWithTax = new y<>();
    private y<String> _selectedRoomFinalPriceWithTaxProceedToPay = new y<>();
    private y<String> _selectedRoomNightTitle = new y<>();
    private y<String> _selectedRoomOptionTitle = new y<>();
    private y<Double> _selectedRoomPrice = new y<>();
    private y<String> _selectedRoomSGSTPrice = new y<>();
    private y<String> _selectedRoomTitle = new y<>();
    private y<RoomOption> _selectedRoomTypeData = new y<>();
    private boolean _showingProgress;
    private y<String> _subHeaderText = new y<>();
    private y<String> _title = new y<>();
    private l<List<String>> allInclusionsDialogListener = new l<>();
    private y<Boolean> closeFareBreakUpButtonClickListener = new y<>();
    private boolean isRoomSelectedPopUpCancelled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RoomSelectionViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final y<String> get_title() {
        return this._title;
    }

    public final void set_title(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._title = yVar;
    }

    public final y<String> get_roomTypeCount() {
        return this._roomTypeCount;
    }

    public final void set_roomTypeCount(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._roomTypeCount = yVar;
    }

    public final y<SubRoomOptions> get_selectedRoomData() {
        return this._selectedRoomData;
    }

    public final void set_selectedRoomData(y<SubRoomOptions> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomData = yVar;
    }

    public final y<RoomOption> get_selectedRoomTypeData() {
        return this._selectedRoomTypeData;
    }

    public final void set_selectedRoomTypeData(y<RoomOption> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomTypeData = yVar;
    }

    public final y<String> get_bedType() {
        return this._bedType;
    }

    public final void set_bedType(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._bedType = yVar;
    }

    public final y<Boolean> get_selectedRoomDataContinue() {
        return this._selectedRoomDataContinue;
    }

    public final void set_selectedRoomDataContinue(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomDataContinue = yVar;
    }

    public final boolean get_showingProgress() {
        return this._showingProgress;
    }

    public final void set_showingProgress(boolean z) {
        this._showingProgress = z;
    }

    public final y<Boolean> get_roomSelectedPopUp() {
        return this._roomSelectedPopUp;
    }

    public final void set_roomSelectedPopUp(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._roomSelectedPopUp = yVar;
    }

    public final boolean isRoomSelectedPopUpCancelled() {
        return this.isRoomSelectedPopUpCancelled;
    }

    public final void setRoomSelectedPopUpCancelled(boolean z) {
        this.isRoomSelectedPopUpCancelled = z;
    }

    public final y<Double> get_selectedRoomPrice() {
        return this._selectedRoomPrice;
    }

    public final void set_selectedRoomPrice(y<Double> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomPrice = yVar;
    }

    public final y<String> get_selectedRoomSGSTPrice() {
        return this._selectedRoomSGSTPrice;
    }

    public final void set_selectedRoomSGSTPrice(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomSGSTPrice = yVar;
    }

    public final y<String> get_selectedRoomCGSTPrice() {
        return this._selectedRoomCGSTPrice;
    }

    public final void set_selectedRoomCGSTPrice(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomCGSTPrice = yVar;
    }

    public final y<Double> get_selectedRoomFinalPriceWithTax() {
        return this._selectedRoomFinalPriceWithTax;
    }

    public final void set_selectedRoomFinalPriceWithTax(y<Double> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomFinalPriceWithTax = yVar;
    }

    public final y<String> get_selectedRoomFinalPriceWithTaxProceedToPay() {
        return this._selectedRoomFinalPriceWithTaxProceedToPay;
    }

    public final void set_selectedRoomFinalPriceWithTaxProceedToPay(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomFinalPriceWithTaxProceedToPay = yVar;
    }

    public final y<String> get_selectedRoomOptionTitle() {
        return this._selectedRoomOptionTitle;
    }

    public final void set_selectedRoomOptionTitle(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomOptionTitle = yVar;
    }

    public final y<String> get_selectedRoomTitle() {
        return this._selectedRoomTitle;
    }

    public final void set_selectedRoomTitle(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomTitle = yVar;
    }

    public final y<String> get_selectedRoomNightTitle() {
        return this._selectedRoomNightTitle;
    }

    public final void set_selectedRoomNightTitle(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomNightTitle = yVar;
    }

    public final y<String> get_subHeaderText() {
        return this._subHeaderText;
    }

    public final void set_subHeaderText(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._subHeaderText = yVar;
    }

    public final y<Boolean> getCloseFareBreakUpButtonClickListener() {
        return this.closeFareBreakUpButtonClickListener;
    }

    public final void setCloseFareBreakUpButtonClickListener(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.closeFareBreakUpButtonClickListener = yVar;
    }

    public final y<Integer> get_selectedRoomCount() {
        return this._selectedRoomCount;
    }

    public final void set_selectedRoomCount(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this._selectedRoomCount = yVar;
    }

    public final l<Boolean> get_refreshAddHotelData() {
        return this._refreshAddHotelData;
    }

    public final void set_refreshAddHotelData(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this._refreshAddHotelData = lVar;
    }

    public final l<Boolean> get_refreshRemoveHotelData() {
        return this._refreshRemoveHotelData;
    }

    public final void set_refreshRemoveHotelData(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this._refreshRemoveHotelData = lVar;
    }

    public final l<List<String>> getAllInclusionsDialogListener() {
        return this.allInclusionsDialogListener;
    }

    public final void setAllInclusionsDialogListener(l<List<String>> lVar) {
        k.c(lVar, "<set-?>");
        this.allInclusionsDialogListener = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        r1 = r1.getRooms();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void makeSubHeader() {
        /*
            r7 = this;
            net.one97.paytm.hotel4.utils.e r0 = net.one97.paytm.hotel4.utils.e.f28642a
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r7.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r0.getSearchInput()
            if (r0 != 0) goto L_0x000f
            kotlin.g.b.k.a()
        L_0x000f:
            int r0 = r0.getAdultCount()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r7.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            if (r1 != 0) goto L_0x0020
            kotlin.g.b.k.a()
        L_0x0020:
            int r1 = r1.getChildCount()
            int r0 = r0 + r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = " Guest"
            java.lang.String r2 = ", "
            java.lang.String r0 = net.one97.paytm.hotel4.utils.e.a(r1, r2, r0)
            net.one97.paytm.hotel4.utils.e r1 = net.one97.paytm.hotel4.utils.e.f28642a
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r7.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            r2 = 0
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r1 = r1.getRooms()
            if (r1 == 0) goto L_0x004d
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x004e
        L_0x004d:
            r1 = r2
        L_0x004e:
            java.lang.String r3 = " Room"
            java.lang.String r4 = ""
            java.lang.String r1 = net.one97.paytm.hotel4.utils.e.a(r3, r4, r1)
            androidx.lifecycle.y<java.lang.String> r3 = r7._subHeaderText
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r7.getDateInfo()
            r4.append(r5)
            java.lang.String r5 = " • "
            r4.append(r5)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r5 = r7.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r5 = r5.getSearchInput()
            if (r5 != 0) goto L_0x0076
            kotlin.g.b.k.a()
        L_0x0076:
            int r5 = r5.getAdultCount()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r6 = r7.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r6 = r6.getSearchInput()
            if (r6 != 0) goto L_0x0087
            kotlin.g.b.k.a()
        L_0x0087:
            int r6 = r6.getChildCount()
            int r5 = r5 + r6
            r4.append(r5)
            r4.append(r0)
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r7.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r0.getSearchInput()
            if (r0 == 0) goto L_0x00ab
            java.util.ArrayList r0 = r0.getRooms()
            if (r0 == 0) goto L_0x00ab
            int r0 = r0.size()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x00ac
        L_0x00ab:
            r0 = r2
        L_0x00ac:
            r4.append(r0)
            r4.append(r1)
            java.lang.String r0 = r4.toString()
            r3.postValue(r0)
            androidx.lifecycle.y<java.lang.Integer> r0 = r7._selectedRoomCount
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r7.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            if (r1 == 0) goto L_0x00d3
            java.util.ArrayList r1 = r1.getRooms()
            if (r1 == 0) goto L_0x00d3
            int r1 = r1.size()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
        L_0x00d3:
            r0.postValue(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel.makeSubHeader():void");
    }

    private final String getDateInfo() {
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        String str = null;
        List<String> formattedDate = getFormattedDate(searchInput != null ? searchInput.getCheckInDate() : null);
        CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
        if (searchInput2 != null) {
            str = searchInput2.getCheckOutDate();
        }
        List<String> formattedDate2 = getFormattedDate(str);
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
        String format = new SimpleDateFormat("MMM,dd").format(new SimpleDateFormat("yyyy-MM-dd").parse(str));
        k.a((Object) format, "checkInStr");
        return p.a((CharSequence) format, new String[]{AppConstants.COMMA});
    }

    public final void selectDefaultRoomSelect(SubRoomOptions subRoomOptions, RoomOption roomOption) {
        k.c(subRoomOptions, "selectedData");
        k.c(roomOption, "roomOption");
        onRoomSelect(subRoomOptions, roomOption);
    }

    public final void addRoomSelected(SubRoomOptions subRoomOptions, RoomOption roomOption) {
        k.c(subRoomOptions, "selectedData");
        k.c(roomOption, "roomOption");
        String value = this._title.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "_title.value!!");
        sendPageOpenPulseEvent("edit_room_selection", value);
        onEditPressed();
    }

    public final void reduceRoomSelected(SubRoomOptions subRoomOptions, RoomOption roomOption) {
        k.c(subRoomOptions, "selectedData");
        k.c(roomOption, "roomOption");
        String value = this._title.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "_title.value!!");
        sendPageOpenPulseEvent("edit_room_selection", value);
        onEditPressed();
    }

    public final boolean addRoom() {
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        if (searchInput == null) {
            k.a();
        }
        ArrayList<CJRRoom> rooms = searchInput.getRooms();
        CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
        if (searchInput2 == null) {
            k.a();
        }
        int adultCount = searchInput2.getAdultCount();
        if (rooms == null) {
            k.a();
        }
        if (adultCount <= rooms.size()) {
            return false;
        }
        getParent().setSearchTemporaryInput(new CJRHotelSearchInput());
        CJRHotelSearchInput searchTemporaryInput = getParent().getSearchTemporaryInput();
        String str = null;
        if (searchTemporaryInput != null) {
            CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
            searchTemporaryInput.setCity(searchInput3 != null ? searchInput3.getCity() : null);
        }
        CJRHotelSearchInput searchTemporaryInput2 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput2 != null) {
            CJRHotelSearchInput searchInput4 = getParent().getSearchInput();
            searchTemporaryInput2.setCheckInDate(searchInput4 != null ? searchInput4.getCheckInDate() : null);
        }
        CJRHotelSearchInput searchTemporaryInput3 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput3 != null) {
            CJRHotelSearchInput searchInput5 = getParent().getSearchInput();
            if (searchInput5 != null) {
                str = searchInput5.getCheckOutDate();
            }
            searchTemporaryInput3.setCheckOutDate(str);
        }
        CJRHotelSearchInput searchTemporaryInput4 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput4 != null) {
            SharedViewModel parent = getParent();
            int size = rooms.size() + 1;
            CJRHotelSearchInput searchInput6 = getParent().getSearchInput();
            if (searchInput6 == null) {
                k.a();
            }
            int adultCount2 = searchInput6.getAdultCount();
            CJRHotelSearchInput searchInput7 = getParent().getSearchInput();
            if (searchInput7 == null) {
                k.a();
            }
            searchTemporaryInput4.setRooms(parent.getRoomDetails(size, adultCount2, searchInput7.getChildCount()));
        }
        return true;
    }

    public final boolean removeLastAddedRoom() {
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        if (searchInput == null) {
            k.a();
        }
        ArrayList<CJRRoom> rooms = searchInput.getRooms();
        if (rooms == null) {
            k.a();
        }
        if (rooms.size() == 1) {
            return false;
        }
        getParent().setSearchTemporaryInput(new CJRHotelSearchInput());
        CJRHotelSearchInput searchTemporaryInput = getParent().getSearchTemporaryInput();
        String str = null;
        if (searchTemporaryInput != null) {
            CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
            searchTemporaryInput.setCity(searchInput2 != null ? searchInput2.getCity() : null);
        }
        CJRHotelSearchInput searchTemporaryInput2 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput2 != null) {
            CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
            searchTemporaryInput2.setCheckInDate(searchInput3 != null ? searchInput3.getCheckInDate() : null);
        }
        CJRHotelSearchInput searchTemporaryInput3 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput3 != null) {
            CJRHotelSearchInput searchInput4 = getParent().getSearchInput();
            if (searchInput4 != null) {
                str = searchInput4.getCheckOutDate();
            }
            searchTemporaryInput3.setCheckOutDate(str);
        }
        CJRHotelSearchInput searchTemporaryInput4 = getParent().getSearchTemporaryInput();
        if (searchTemporaryInput4 != null) {
            SharedViewModel parent = getParent();
            int size = rooms.size() - 1;
            CJRHotelSearchInput searchInput5 = getParent().getSearchInput();
            if (searchInput5 == null) {
                k.a();
            }
            int adultCount = searchInput5.getAdultCount();
            CJRHotelSearchInput searchInput6 = getParent().getSearchInput();
            if (searchInput6 == null) {
                k.a();
            }
            searchTemporaryInput4.setRooms(parent.getRoomDetails(size, adultCount, searchInput6.getChildCount()));
        }
        return true;
    }

    public final void onRoomSelect(SubRoomOptions subRoomOptions, RoomOption roomOption) {
        k.c(subRoomOptions, "selectedData");
        k.c(roomOption, "roomOption");
        List<SubRoomProvider> subRoomProviders = subRoomOptions.getSubRoomProviders();
        if (subRoomProviders == null) {
            k.a();
        }
        PriceData priceData = subRoomProviders.get(0).getPriceData();
        Double d2 = null;
        sendPulseEventRoomSelected(priceData != null ? Double.valueOf(priceData.getTotalPriceWithTax()) : null);
        this._selectedRoomData.postValue(subRoomOptions);
        this._selectedRoomTypeData.postValue(roomOption);
        if (roomOption.getBedType() != null) {
            this._bedType.postValue(roomOption.getBedType());
        }
        this._selectedRoomDataContinue.postValue(Boolean.TRUE);
        if (this.isRoomSelectedPopUpCancelled) {
            this._roomSelectedPopUp.postValue(Boolean.FALSE);
        } else {
            this._roomSelectedPopUp.postValue(Boolean.TRUE);
        }
        y<Double> yVar = this._selectedRoomPrice;
        List<SubRoomProvider> subRoomProviders2 = subRoomOptions.getSubRoomProviders();
        if (subRoomProviders2 == null) {
            k.a();
        }
        PriceData priceData2 = subRoomProviders2.get(0).getPriceData();
        yVar.postValue(priceData2 != null ? Double.valueOf(priceData2.getFinalPrice()) : null);
        y<String> yVar2 = this._selectedRoomSGSTPrice;
        List<SubRoomProvider> subRoomProviders3 = subRoomOptions.getSubRoomProviders();
        if (subRoomProviders3 == null) {
            k.a();
        }
        PriceData priceData3 = subRoomProviders3.get(0).getPriceData();
        yVar2.postValue(String.valueOf(priceData3 != null ? Double.valueOf(priceData3.getFinalSGST()) : null));
        y<String> yVar3 = this._selectedRoomCGSTPrice;
        List<SubRoomProvider> subRoomProviders4 = subRoomOptions.getSubRoomProviders();
        if (subRoomProviders4 == null) {
            k.a();
        }
        PriceData priceData4 = subRoomProviders4.get(0).getPriceData();
        yVar3.postValue(String.valueOf(priceData4 != null ? Double.valueOf(priceData4.getFinalCGST()) : null));
        y<Double> yVar4 = this._selectedRoomFinalPriceWithTax;
        List<SubRoomProvider> subRoomProviders5 = subRoomOptions.getSubRoomProviders();
        if (subRoomProviders5 == null) {
            k.a();
        }
        PriceData priceData5 = subRoomProviders5.get(0).getPriceData();
        if (priceData5 != null) {
            d2 = Double.valueOf(priceData5.getTotalPriceWithTax());
        }
        yVar4.postValue(d2);
        this._selectedRoomFinalPriceWithTaxProceedToPay.postValue("Proceed to Pay ");
        y<String> yVar5 = this._selectedRoomOptionTitle;
        StringBuilder sb = new StringBuilder();
        CJRHotelSearchInput searchInput = getParent().getSearchInput();
        if (searchInput == null) {
            k.a();
        }
        ArrayList<CJRRoom> rooms = searchInput.getRooms();
        if (rooms == null) {
            k.a();
        }
        sb.append(String.valueOf(rooms.size()));
        sb.append(" X ");
        sb.append(roomOption.getPaytmRoomName());
        yVar5.postValue(sb.toString());
        this._selectedRoomTitle.postValue(subRoomOptions.getPaytmRoomName());
        y<String> yVar6 = this._selectedRoomNightTitle;
        StringBuilder sb2 = new StringBuilder("for ");
        CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
        if (searchInput2 == null) {
            k.a();
        }
        ArrayList<CJRRoom> rooms2 = searchInput2.getRooms();
        if (rooms2 == null) {
            k.a();
        }
        sb2.append(String.valueOf(rooms2.size()));
        e eVar = e.f28642a;
        CJRHotelSearchInput searchInput3 = getParent().getSearchInput();
        if (searchInput3 == null) {
            k.a();
        }
        ArrayList<CJRRoom> rooms3 = searchInput3.getRooms();
        if (rooms3 == null) {
            k.a();
        }
        sb2.append(e.a(" Room", "", Integer.valueOf(rooms3.size())));
        sb2.append(", ");
        CJRHotelSearchInput searchInput4 = getParent().getSearchInput();
        if (searchInput4 == null) {
            k.a();
        }
        sb2.append(searchInput4.getNumOfNights());
        sb2.append(" ");
        e eVar2 = e.f28642a;
        CJRHotelSearchInput searchInput5 = getParent().getSearchInput();
        if (searchInput5 == null) {
            k.a();
        }
        sb2.append(e.a("Night", "", Integer.valueOf(searchInput5.getNumOfNights())));
        yVar6.postValue(sb2.toString());
    }

    public final void sendPageOpenPulseEvent(String str, String str2) {
        k.c(str, "EVENT_ACTION");
        k.c(str2, "name");
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        map2.put("event_label2", str2);
        c.b().a("customEvent", "Hotel Details", "hotels_details", str, map2);
    }

    private final void sendPulseEventRoomSelected(Double d2) {
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        String value = this._title.getValue();
        if (value != null) {
            map2.put("event_label2", value);
            CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
            if (searchInput2 == null) {
                k.a();
            }
            ArrayList<CJRRoom> rooms = searchInput2.getRooms();
            if (rooms == null) {
                k.a();
            }
            map2.put("event_label3", Integer.valueOf(rooms.size()));
            if (d2 != null) {
                map2.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, d2);
                c.b().a("customEvent", "Hotel Details", "hotels_details", "room_selected", map2);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Any");
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }

    private final void sendPulseEventReviewSelected(Double d2) {
        HashMap hashMap = new HashMap();
        if (getParent().getSearchInput() != null) {
            Map map = hashMap;
            CJRHotelSearchInput searchInput = getParent().getSearchInput();
            if (searchInput == null) {
                k.a();
            }
            String city = searchInput.getCity();
            if (city != null) {
                map.put("event_label", city);
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Any");
            }
        }
        Map map2 = hashMap;
        String value = this._title.getValue();
        if (value != null) {
            map2.put("event_label2", value);
            CJRHotelSearchInput searchInput2 = getParent().getSearchInput();
            if (searchInput2 == null) {
                k.a();
            }
            ArrayList<CJRRoom> rooms = searchInput2.getRooms();
            if (rooms == null) {
                k.a();
            }
            map2.put("event_label3", Integer.valueOf(rooms.size()));
            if (d2 != null) {
                map2.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, d2);
                c.b().a("customEvent", "Hotel Details", "hotels_details", "review_tapped", map2);
                return;
            }
            throw new u("null cannot be cast to non-null type kotlin.Any");
        }
        throw new u("null cannot be cast to non-null type kotlin.Any");
    }

    public final void onRoomSelectedPopUpCancelled() {
        this.isRoomSelectedPopUpCancelled = true;
        this._roomSelectedPopUp.postValue(Boolean.FALSE);
    }

    public final void onBackPressed() {
        getParent().postScreenNavigationEvent("7", "5");
    }

    public final void onEditPressed() {
        String value = this._title.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "_title.value!!");
        sendPageOpenPulseEvent("edit_search_select", value);
        getParent().postScreenNavigationEvent("7", "11");
    }

    public final void onFareBreakupPressed() {
        String value = this._title.getValue();
        if (value == null) {
            k.a();
        }
        k.a((Object) value, "_title.value!!");
        sendPageOpenPulseEvent("price_break_up", value);
        this.closeFareBreakUpButtonClickListener.postValue(Boolean.FALSE);
        getParent().postScreenNavigationEvent("7", "33");
    }

    public final void loadNoRoomView() {
        getParent().postScreenNavigationEvent("7", "111");
    }

    public final void onContinuePressed() {
        if (getParent().getContext() == null || !b.c(getParent().getContext())) {
            Context context = getParent().getContext();
            Context context2 = getParent().getContext();
            if (context2 == null) {
                k.a();
            }
            String string = context2.getResources().getString(R.string.hotels_hotel_no_internet_title);
            Context context3 = getParent().getContext();
            if (context3 == null) {
                k.a();
            }
            b.a(context, string, context3.getResources().getString(R.string.hotels_hotel_no_internet_message));
            return;
        }
        this.closeFareBreakUpButtonClickListener.postValue(Boolean.TRUE);
        sendPulseEventReviewSelected(this._selectedRoomPrice.getValue());
        getParent().postScreenNavigationEvent("7", "8");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0024, code lost:
        r3 = r3.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onInclusionsPressed(net.one97.paytm.hotel4.service.model.details.SubRoomOptions r3) {
        /*
            r2 = this;
            java.lang.String r0 = "_allInclusions"
            kotlin.g.b.k.c(r3, r0)
            androidx.lifecycle.y<java.lang.String> r0 = r2._title
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x0010
            kotlin.g.b.k.a()
        L_0x0010:
            java.lang.String r1 = "_title.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "inclusion"
            r2.sendPageOpenPulseEvent(r1, r0)
            com.travel.utils.l<java.util.List<java.lang.String>> r0 = r2.allInclusionsDialogListener
            java.util.List r3 = r3.getSubRoomProviders()
            if (r3 == 0) goto L_0x0032
            r1 = 0
            java.lang.Object r3 = r3.get(r1)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r3 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r3
            if (r3 == 0) goto L_0x0032
            java.util.List r3 = r3.getIncludes()
            goto L_0x0033
        L_0x0032:
            r3 = 0
        L_0x0033:
            r0.postValue(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel.onInclusionsPressed(net.one97.paytm.hotel4.service.model.details.SubRoomOptions):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0029, code lost:
        r1 = (r1 = r1.getSubRoomProviders()).get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onInclusionsPressedReviewScreen() {
        /*
            r3 = this;
            androidx.lifecycle.y<java.lang.String> r0 = r3._title
            java.lang.Object r0 = r0.getValue()
            if (r0 != 0) goto L_0x000b
            kotlin.g.b.k.a()
        L_0x000b:
            java.lang.String r1 = "_title.value!!"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "inclusion"
            r3.sendPageOpenPulseEvent(r1, r0)
            com.travel.utils.l<java.util.List<java.lang.String>> r0 = r3.allInclusionsDialogListener
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.details.SubRoomOptions> r1 = r3._selectedRoomData
            java.lang.Object r1 = r1.getValue()
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r1 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r1
            if (r1 == 0) goto L_0x0037
            java.util.List r1 = r1.getSubRoomProviders()
            if (r1 == 0) goto L_0x0037
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r1 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r1
            if (r1 == 0) goto L_0x0037
            java.util.List r1 = r1.getIncludes()
            goto L_0x0038
        L_0x0037:
            r1 = 0
        L_0x0038:
            r0.postValue(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.RoomSelectionViewModel.onInclusionsPressedReviewScreen():void");
    }
}
