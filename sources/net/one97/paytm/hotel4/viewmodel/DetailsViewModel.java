package net.one97.paytm.hotel4.viewmodel;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.text.Html;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.BulletSpan;
import androidx.lifecycle.y;
import com.business.merchant_payments.utility.StringUtility;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import com.travel.utils.h;
import com.travel.utils.l;
import com.travel.utils.s;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.g.a.b;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.hotel4.service.a.a;
import net.one97.paytm.hotel4.service.model.ErrorData;
import net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem;
import net.one97.paytm.hotel4.service.model.details.Address;
import net.one97.paytm.hotel4.service.model.details.Basic;
import net.one97.paytm.hotel4.service.model.details.CJRRoom;
import net.one97.paytm.hotel4.service.model.details.Data;
import net.one97.paytm.hotel4.service.model.details.Facilities;
import net.one97.paytm.hotel4.service.model.details.HotelDetails;
import net.one97.paytm.hotel4.service.model.details.HotelPolicy;
import net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages;
import net.one97.paytm.hotel4.service.model.details.Images;
import net.one97.paytm.hotel4.service.model.details.PaytmImages;
import net.one97.paytm.hotel4.service.model.details.RoomOption;
import net.one97.paytm.hotel4.service.model.details.TnC;
import net.one97.paytm.hotel4.utils.e;
import net.one97.paytm.hotels2.entity.CJRHotelSearchInput;
import net.one97.paytm.hotels2.utils.c;

public final class DetailsViewModel extends BaseViewModel {
    private y<String> _about = new y<>();
    private y<String> _aboutShortened = new y<>();
    private y<String> _cin = new y<>();
    private y<String> _cin_date = new y<>();
    private y<Boolean> _closeNoRoomsBottomSheetClose = new y<>();
    private y<String> _cout = new y<>();
    private y<String> _cout_date = new y<>();
    private y<String> _fullAddress = new y<>();
    private y<String> _image0_url = new y<>();
    private y<String> _image1_url = new y<>();
    private y<Integer> _image1_visibility = new y<>();
    private y<String> _image2_url = new y<>();
    private y<Integer> _image2_visibility = new y<>();
    private y<String> _image3_url = new y<>();
    private y<Integer> _image3_visibility = new y<>();
    private y<String> _imageCount = new y<>();
    private y<Integer> _imageCount_visibility = new y<>();
    private y<String> _name = new y<>();
    private y<String> _nights_count = new y<>();
    private y<String> _nights_count_text = new y<>();
    private y<Integer> _originalPrice_visibility = new y<>();
    private y<List<String>> _policy = new y<>();
    private y<String> _pricePerRoom = new y<>();
    private y<Boolean> _showAmenitiesViewAll = new y<>();
    private y<Boolean> _showHotelPolicyViewAll = new y<>();
    private y<Boolean> _showReadMoreAboutHotel = new y<>();
    private y<String> _streetAddress = new y<>();
    private y<List<String>> _tnc = new y<>();
    private l<Boolean> aboutHotelReadMoreDialogListener = new l<>();
    private l<Boolean> allAmenitiesOpenDialogListener = new l<>();
    private y<List<String>> amenitiesAllBasic = new y<>();
    private y<List<String>> amenitiesBasic = new y<>();
    private l<ErrorData> apiCallFailure = new l<>();
    private l<HotelDetails> apiCallSuccess = new l<>();
    private h debounceClick = new h(750);
    private String detailRequestID = "";
    private a detailsRepo;
    private HotelDetails detailsResponse;
    private y<Boolean> favPressed = new y<>();
    private l<Boolean> hotelPolicyViewAllDialogListener = new l<>();
    private y<PaytmImages> images = new y<>();
    private l<Boolean> isApiCalling = new l<>();
    private y<Boolean> isFromMap = new y<>();
    private y<CJRHotelSearchInput> searchData = new y<>();
    private y<SRPDataItem> selectedData = new y<>();
    private l<Map<String, String>> sharePressed = new l<>();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DetailsViewModel(SharedViewModel sharedViewModel) {
        super(sharedViewModel);
        k.c(sharedViewModel, "parent");
    }

    public final y<SRPDataItem> getSelectedData() {
        return this.selectedData;
    }

    public final void setSelectedData(y<SRPDataItem> yVar) {
        k.c(yVar, "<set-?>");
        this.selectedData = yVar;
    }

    public final y<CJRHotelSearchInput> getSearchData() {
        return this.searchData;
    }

    public final void setSearchData(y<CJRHotelSearchInput> yVar) {
        k.c(yVar, "<set-?>");
        this.searchData = yVar;
    }

    public final l<HotelDetails> getApiCallSuccess() {
        return this.apiCallSuccess;
    }

    public final void setApiCallSuccess(l<HotelDetails> lVar) {
        k.c(lVar, "<set-?>");
        this.apiCallSuccess = lVar;
    }

    public final l<Boolean> isApiCalling() {
        return this.isApiCalling;
    }

    public final void setApiCalling(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.isApiCalling = lVar;
    }

    public final l<ErrorData> getApiCallFailure() {
        return this.apiCallFailure;
    }

    public final void setApiCallFailure(l<ErrorData> lVar) {
        k.c(lVar, "<set-?>");
        this.apiCallFailure = lVar;
    }

    public final y<PaytmImages> getImages() {
        return this.images;
    }

    public final void setImages(y<PaytmImages> yVar) {
        k.c(yVar, "<set-?>");
        this.images = yVar;
    }

    public final y<List<String>> getAmenitiesBasic() {
        return this.amenitiesBasic;
    }

    public final void setAmenitiesBasic(y<List<String>> yVar) {
        k.c(yVar, "<set-?>");
        this.amenitiesBasic = yVar;
    }

    public final y<List<String>> getAmenitiesAllBasic() {
        return this.amenitiesAllBasic;
    }

    public final void setAmenitiesAllBasic(y<List<String>> yVar) {
        k.c(yVar, "<set-?>");
        this.amenitiesAllBasic = yVar;
    }

    public final y<Boolean> getFavPressed() {
        return this.favPressed;
    }

    public final void setFavPressed(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.favPressed = yVar;
    }

    public final l<Map<String, String>> getSharePressed() {
        return this.sharePressed;
    }

    public final void setSharePressed(l<Map<String, String>> lVar) {
        k.c(lVar, "<set-?>");
        this.sharePressed = lVar;
    }

    public final y<String> get_name() {
        return this._name;
    }

    public final void set_name(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._name = yVar;
    }

    public final y<String> get_streetAddress() {
        return this._streetAddress;
    }

    public final void set_streetAddress(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._streetAddress = yVar;
    }

    public final y<String> get_fullAddress() {
        return this._fullAddress;
    }

    public final void set_fullAddress(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._fullAddress = yVar;
    }

    public final y<String> get_pricePerRoom() {
        return this._pricePerRoom;
    }

    public final void set_pricePerRoom(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._pricePerRoom = yVar;
    }

    public final y<String> get_about() {
        return this._about;
    }

    public final void set_about(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._about = yVar;
    }

    public final y<String> get_aboutShortened() {
        return this._aboutShortened;
    }

    public final void set_aboutShortened(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._aboutShortened = yVar;
    }

    public final y<String> get_cin() {
        return this._cin;
    }

    public final void set_cin(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._cin = yVar;
    }

    public final y<String> get_cout() {
        return this._cout;
    }

    public final void set_cout(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._cout = yVar;
    }

    public final y<String> get_cin_date() {
        return this._cin_date;
    }

    public final void set_cin_date(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._cin_date = yVar;
    }

    public final y<String> get_cout_date() {
        return this._cout_date;
    }

    public final void set_cout_date(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._cout_date = yVar;
    }

    public final y<String> get_nights_count() {
        return this._nights_count;
    }

    public final void set_nights_count(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._nights_count = yVar;
    }

    public final y<String> get_nights_count_text() {
        return this._nights_count_text;
    }

    public final void set_nights_count_text(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._nights_count_text = yVar;
    }

    public final y<List<String>> get_policy() {
        return this._policy;
    }

    public final void set_policy(y<List<String>> yVar) {
        k.c(yVar, "<set-?>");
        this._policy = yVar;
    }

    public final y<List<String>> get_tnc() {
        return this._tnc;
    }

    public final void set_tnc(y<List<String>> yVar) {
        k.c(yVar, "<set-?>");
        this._tnc = yVar;
    }

    public final y<String> get_imageCount() {
        return this._imageCount;
    }

    public final void set_imageCount(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._imageCount = yVar;
    }

    public final y<Integer> get_imageCount_visibility() {
        return this._imageCount_visibility;
    }

    public final void set_imageCount_visibility(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this._imageCount_visibility = yVar;
    }

    public final y<Boolean> get_showAmenitiesViewAll() {
        return this._showAmenitiesViewAll;
    }

    public final void set_showAmenitiesViewAll(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._showAmenitiesViewAll = yVar;
    }

    public final y<Boolean> get_showHotelPolicyViewAll() {
        return this._showHotelPolicyViewAll;
    }

    public final void set_showHotelPolicyViewAll(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._showHotelPolicyViewAll = yVar;
    }

    public final y<String> get_image0_url() {
        return this._image0_url;
    }

    public final void set_image0_url(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._image0_url = yVar;
    }

    public final y<String> get_image1_url() {
        return this._image1_url;
    }

    public final void set_image1_url(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._image1_url = yVar;
    }

    public final y<String> get_image2_url() {
        return this._image2_url;
    }

    public final void set_image2_url(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._image2_url = yVar;
    }

    public final y<String> get_image3_url() {
        return this._image3_url;
    }

    public final void set_image3_url(y<String> yVar) {
        k.c(yVar, "<set-?>");
        this._image3_url = yVar;
    }

    public final y<Integer> get_image1_visibility() {
        return this._image1_visibility;
    }

    public final void set_image1_visibility(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this._image1_visibility = yVar;
    }

    public final y<Integer> get_image2_visibility() {
        return this._image2_visibility;
    }

    public final void set_image2_visibility(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this._image2_visibility = yVar;
    }

    public final y<Integer> get_image3_visibility() {
        return this._image3_visibility;
    }

    public final void set_image3_visibility(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this._image3_visibility = yVar;
    }

    public final y<Integer> get_originalPrice_visibility() {
        return this._originalPrice_visibility;
    }

    public final void set_originalPrice_visibility(y<Integer> yVar) {
        k.c(yVar, "<set-?>");
        this._originalPrice_visibility = yVar;
    }

    public final y<Boolean> get_closeNoRoomsBottomSheetClose() {
        return this._closeNoRoomsBottomSheetClose;
    }

    public final void set_closeNoRoomsBottomSheetClose(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._closeNoRoomsBottomSheetClose = yVar;
    }

    public final y<Boolean> get_showReadMoreAboutHotel() {
        return this._showReadMoreAboutHotel;
    }

    public final void set_showReadMoreAboutHotel(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this._showReadMoreAboutHotel = yVar;
    }

    public final HotelDetails getDetailsResponse() {
        return this.detailsResponse;
    }

    public final void setDetailsResponse(HotelDetails hotelDetails) {
        this.detailsResponse = hotelDetails;
    }

    public final a getDetailsRepo() {
        return this.detailsRepo;
    }

    public final void setDetailsRepo(a aVar) {
        this.detailsRepo = aVar;
    }

    public final String getDetailRequestID() {
        return this.detailRequestID;
    }

    public final void setDetailRequestID(String str) {
        this.detailRequestID = str;
    }

    public final y<Boolean> isFromMap() {
        return this.isFromMap;
    }

    public final void setFromMap(y<Boolean> yVar) {
        k.c(yVar, "<set-?>");
        this.isFromMap = yVar;
    }

    public final l<Boolean> getAllAmenitiesOpenDialogListener() {
        return this.allAmenitiesOpenDialogListener;
    }

    public final void setAllAmenitiesOpenDialogListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.allAmenitiesOpenDialogListener = lVar;
    }

    public final l<Boolean> getHotelPolicyViewAllDialogListener() {
        return this.hotelPolicyViewAllDialogListener;
    }

    public final void setHotelPolicyViewAllDialogListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.hotelPolicyViewAllDialogListener = lVar;
    }

    public final l<Boolean> getAboutHotelReadMoreDialogListener() {
        return this.aboutHotelReadMoreDialogListener;
    }

    public final void setAboutHotelReadMoreDialogListener(l<Boolean> lVar) {
        k.c(lVar, "<set-?>");
        this.aboutHotelReadMoreDialogListener = lVar;
    }

    public final void initDetailsRepository(a aVar) {
        k.c(aVar, "repo");
        this.detailsRepo = aVar;
    }

    public final void setSelectedHotel(CJRHotelSearchInput cJRHotelSearchInput, SRPDataItem sRPDataItem, String str) {
        if ((!k.a((Object) this.selectedData.getValue(), (Object) sRPDataItem)) || (!k.a((Object) this.searchData.getValue(), (Object) cJRHotelSearchInput))) {
            clearCurrentData();
        }
        this.selectedData.setValue(sRPDataItem);
        this.searchData.setValue(cJRHotelSearchInput);
        SRPDataItem value = this.selectedData.getValue();
        if (value != null) {
            k.a((Object) value, "it");
            fetchDetailData(value, str);
        }
    }

    private final void clearCurrentData() {
        setDetailsDta((HotelDetails) null);
    }

    public final void closeButtonNoRoomsPressed() {
        this._closeNoRoomsBottomSheetClose.postValue(Boolean.TRUE);
    }

    private final String getFormattedDate(String str) {
        return new SimpleDateFormat("EEE, d MMM").format(new SimpleDateFormat("yyyy-MM-dd").parse(str)).toString();
    }

    public final void loadDetailErrorView() {
        getParent().postScreenNavigationEvent("5", "666");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0195, code lost:
        r3 = r3.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDetailsDta(net.one97.paytm.hotel4.service.model.details.HotelDetails r6) {
        /*
            r5 = this;
            r5.detailsResponse = r6
            net.one97.paytm.hotel4.service.model.details.HotelDetails r6 = r5.detailsResponse
            r0 = 0
            if (r6 == 0) goto L_0x02f3
            androidx.lifecycle.y<java.lang.String> r1 = r5._name
            net.one97.paytm.hotel4.service.model.details.Data r2 = r6.getData()
            if (r2 != 0) goto L_0x0012
            kotlin.g.b.k.a()
        L_0x0012:
            java.lang.String r2 = r2.getName()
            r1.postValue(r2)
            androidx.lifecycle.y<java.lang.String> r1 = r5._streetAddress
            net.one97.paytm.hotel4.service.model.details.Data r2 = r6.getData()
            if (r2 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            net.one97.paytm.hotel4.service.model.details.Address r2 = r2.getAddress()
            if (r2 != 0) goto L_0x002d
            kotlin.g.b.k.a()
        L_0x002d:
            java.lang.String r2 = r2.getLocality()
            r1.postValue(r2)
            net.one97.paytm.hotel4.service.model.details.Data r1 = r6.getData()
            if (r1 != 0) goto L_0x003d
            kotlin.g.b.k.a()
        L_0x003d:
            net.one97.paytm.hotel4.service.model.details.Address r1 = r1.getAddress()
            if (r1 != 0) goto L_0x0046
            kotlin.g.b.k.a()
        L_0x0046:
            java.lang.String r1 = r1.getLocality()
            java.lang.String r2 = " - "
            if (r1 == 0) goto L_0x00ca
            androidx.lifecycle.y<java.lang.String> r1 = r5._fullAddress
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            net.one97.paytm.hotel4.service.model.details.Data r4 = r6.getData()
            if (r4 != 0) goto L_0x005e
            kotlin.g.b.k.a()
        L_0x005e:
            net.one97.paytm.hotel4.service.model.details.Address r4 = r4.getAddress()
            if (r4 != 0) goto L_0x0067
            kotlin.g.b.k.a()
        L_0x0067:
            java.lang.String r4 = r4.getStreetAddress()
            r3.append(r4)
            r3.append(r2)
            net.one97.paytm.hotel4.service.model.details.Data r4 = r6.getData()
            if (r4 != 0) goto L_0x007a
            kotlin.g.b.k.a()
        L_0x007a:
            net.one97.paytm.hotel4.service.model.details.Address r4 = r4.getAddress()
            if (r4 != 0) goto L_0x0083
            kotlin.g.b.k.a()
        L_0x0083:
            java.lang.String r4 = r4.getLocality()
            r3.append(r4)
            r3.append(r2)
            net.one97.paytm.hotel4.service.model.details.Data r4 = r6.getData()
            if (r4 != 0) goto L_0x0096
            kotlin.g.b.k.a()
        L_0x0096:
            net.one97.paytm.hotel4.service.model.details.Address r4 = r4.getAddress()
            if (r4 != 0) goto L_0x009f
            kotlin.g.b.k.a()
        L_0x009f:
            java.lang.String r4 = r4.getCity()
            r3.append(r4)
            r3.append(r2)
            net.one97.paytm.hotel4.service.model.details.Data r2 = r6.getData()
            if (r2 != 0) goto L_0x00b2
            kotlin.g.b.k.a()
        L_0x00b2:
            net.one97.paytm.hotel4.service.model.details.Address r2 = r2.getAddress()
            if (r2 != 0) goto L_0x00bb
            kotlin.g.b.k.a()
        L_0x00bb:
            java.lang.String r2 = r2.getZip()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.postValue(r2)
            goto L_0x0129
        L_0x00ca:
            androidx.lifecycle.y<java.lang.String> r1 = r5._fullAddress
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            net.one97.paytm.hotel4.service.model.details.Data r4 = r6.getData()
            if (r4 != 0) goto L_0x00da
            kotlin.g.b.k.a()
        L_0x00da:
            net.one97.paytm.hotel4.service.model.details.Address r4 = r4.getAddress()
            if (r4 != 0) goto L_0x00e3
            kotlin.g.b.k.a()
        L_0x00e3:
            java.lang.String r4 = r4.getStreetAddress()
            r3.append(r4)
            r3.append(r2)
            net.one97.paytm.hotel4.service.model.details.Data r4 = r6.getData()
            if (r4 != 0) goto L_0x00f6
            kotlin.g.b.k.a()
        L_0x00f6:
            net.one97.paytm.hotel4.service.model.details.Address r4 = r4.getAddress()
            if (r4 != 0) goto L_0x00ff
            kotlin.g.b.k.a()
        L_0x00ff:
            java.lang.String r4 = r4.getCity()
            r3.append(r4)
            r3.append(r2)
            net.one97.paytm.hotel4.service.model.details.Data r2 = r6.getData()
            if (r2 != 0) goto L_0x0112
            kotlin.g.b.k.a()
        L_0x0112:
            net.one97.paytm.hotel4.service.model.details.Address r2 = r2.getAddress()
            if (r2 != 0) goto L_0x011b
            kotlin.g.b.k.a()
        L_0x011b:
            java.lang.String r2 = r2.getZip()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.postValue(r2)
        L_0x0129:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r1 = r5.detailsResponse
            if (r1 != 0) goto L_0x0130
            kotlin.g.b.k.a()
        L_0x0130:
            net.one97.paytm.hotel4.service.model.details.Data r1 = r1.getData()
            if (r1 != 0) goto L_0x0139
            kotlin.g.b.k.a()
        L_0x0139:
            java.util.List r1 = r1.getRoomOptions()
            if (r1 == 0) goto L_0x01d2
            net.one97.paytm.hotel4.service.model.details.HotelDetails r1 = r5.detailsResponse
            if (r1 != 0) goto L_0x0146
            kotlin.g.b.k.a()
        L_0x0146:
            net.one97.paytm.hotel4.service.model.details.Data r1 = r1.getData()
            if (r1 != 0) goto L_0x014f
            kotlin.g.b.k.a()
        L_0x014f:
            java.util.List r1 = r1.getRoomOptions()
            if (r1 != 0) goto L_0x0158
            kotlin.g.b.k.a()
        L_0x0158:
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x01d2
            net.one97.paytm.hotel4.service.model.details.HotelDetails r1 = r5.detailsResponse
            if (r1 != 0) goto L_0x0165
            kotlin.g.b.k.a()
        L_0x0165:
            net.one97.paytm.hotel4.service.model.details.Data r1 = r1.getData()
            if (r1 != 0) goto L_0x016e
            kotlin.g.b.k.a()
        L_0x016e:
            java.util.List r1 = r1.getRoomOptions()
            if (r1 != 0) goto L_0x0177
            kotlin.g.b.k.a()
        L_0x0177:
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            net.one97.paytm.hotel4.service.model.details.RoomOption r1 = (net.one97.paytm.hotel4.service.model.details.RoomOption) r1
            java.util.List r1 = r1.getSubRoomOptionses()
            if (r1 == 0) goto L_0x01d2
            androidx.lifecycle.y<java.lang.String> r1 = r5._pricePerRoom
            net.one97.paytm.hotel4.service.model.details.Data r3 = r6.getData()
            if (r3 != 0) goto L_0x018f
            kotlin.g.b.k.a()
        L_0x018f:
            java.util.List r3 = r3.getRoomOptions()
            if (r3 == 0) goto L_0x01a2
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.hotel4.service.model.details.RoomOption r3 = (net.one97.paytm.hotel4.service.model.details.RoomOption) r3
            if (r3 == 0) goto L_0x01a2
            java.util.List r3 = r3.getSubRoomOptionses()
            goto L_0x01a3
        L_0x01a2:
            r3 = r0
        L_0x01a3:
            if (r3 != 0) goto L_0x01a8
            kotlin.g.b.k.a()
        L_0x01a8:
            java.lang.Object r3 = r3.get(r2)
            net.one97.paytm.hotel4.service.model.details.SubRoomOptions r3 = (net.one97.paytm.hotel4.service.model.details.SubRoomOptions) r3
            java.util.List r3 = r3.getSubRoomProviders()
            if (r3 == 0) goto L_0x01c1
            java.lang.Object r2 = r3.get(r2)
            net.one97.paytm.hotel4.service.model.details.SubRoomProvider r2 = (net.one97.paytm.hotel4.service.model.details.SubRoomProvider) r2
            if (r2 == 0) goto L_0x01c1
            net.one97.paytm.hotel4.service.model.details.Otas r2 = r2.getOta()
            goto L_0x01c2
        L_0x01c1:
            r2 = r0
        L_0x01c2:
            if (r2 != 0) goto L_0x01c7
            kotlin.g.b.k.a()
        L_0x01c7:
            java.lang.Integer r2 = r2.getPrice()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.postValue(r2)
        L_0x01d2:
            androidx.lifecycle.y<java.lang.String> r1 = r5._cin
            net.one97.paytm.hotel4.service.model.details.Data r2 = r6.getData()
            if (r2 != 0) goto L_0x01dd
            kotlin.g.b.k.a()
        L_0x01dd:
            net.one97.paytm.hotel4.service.model.details.HotelPolicy r2 = r2.getHotelPolicy()
            if (r2 != 0) goto L_0x01e6
            kotlin.g.b.k.a()
        L_0x01e6:
            java.lang.String r2 = r2.getCheckInTime()
            r1.postValue(r2)
            androidx.lifecycle.y<java.lang.String> r1 = r5._cin_date
            androidx.lifecycle.y<net.one97.paytm.hotels2.entity.CJRHotelSearchInput> r2 = r5.searchData
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r2 = (net.one97.paytm.hotels2.entity.CJRHotelSearchInput) r2
            if (r2 == 0) goto L_0x01fe
            java.lang.String r2 = r2.getCheckInDate()
            goto L_0x01ff
        L_0x01fe:
            r2 = r0
        L_0x01ff:
            java.lang.String r2 = r5.getFormattedDate(r2)
            r1.postValue(r2)
            androidx.lifecycle.y<java.lang.String> r1 = r5._cout
            net.one97.paytm.hotel4.service.model.details.Data r2 = r6.getData()
            if (r2 != 0) goto L_0x0211
            kotlin.g.b.k.a()
        L_0x0211:
            net.one97.paytm.hotel4.service.model.details.HotelPolicy r2 = r2.getHotelPolicy()
            if (r2 != 0) goto L_0x021a
            kotlin.g.b.k.a()
        L_0x021a:
            java.lang.String r2 = r2.getCheckOutTime()
            r1.postValue(r2)
            androidx.lifecycle.y<java.lang.String> r1 = r5._cout_date
            androidx.lifecycle.y<net.one97.paytm.hotels2.entity.CJRHotelSearchInput> r2 = r5.searchData
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r2 = (net.one97.paytm.hotels2.entity.CJRHotelSearchInput) r2
            if (r2 == 0) goto L_0x0232
            java.lang.String r2 = r2.getCheckOutDate()
            goto L_0x0233
        L_0x0232:
            r2 = r0
        L_0x0233:
            java.lang.String r2 = r5.getFormattedDate(r2)
            r1.postValue(r2)
            androidx.lifecycle.y<java.lang.String> r1 = r5._nights_count
            androidx.lifecycle.y<net.one97.paytm.hotels2.entity.CJRHotelSearchInput> r2 = r5.searchData
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r2 = (net.one97.paytm.hotels2.entity.CJRHotelSearchInput) r2
            if (r2 == 0) goto L_0x024f
            int r2 = r2.getNumOfNights()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0250
        L_0x024f:
            r2 = r0
        L_0x0250:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r1.postValue(r2)
            androidx.lifecycle.y<java.lang.String> r1 = r5._nights_count_text
            net.one97.paytm.hotel4.utils.e r2 = net.one97.paytm.hotel4.utils.e.f28642a
            androidx.lifecycle.y<net.one97.paytm.hotels2.entity.CJRHotelSearchInput> r2 = r5.searchData
            java.lang.Object r2 = r2.getValue()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r2 = (net.one97.paytm.hotels2.entity.CJRHotelSearchInput) r2
            if (r2 == 0) goto L_0x026e
            int r2 = r2.getNumOfNights()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x026f
        L_0x026e:
            r2 = r0
        L_0x026f:
            java.lang.String r3 = "Night"
            java.lang.String r4 = ""
            java.lang.String r2 = net.one97.paytm.hotel4.utils.e.a(r3, r4, r2)
            r1.postValue(r2)
            net.one97.paytm.hotel4.service.model.details.Data r1 = r6.getData()
            if (r1 == 0) goto L_0x028b
            java.lang.String r1 = r1.getDescription()
            if (r1 == 0) goto L_0x028b
            r5.updateHotelAbout(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x028b:
            net.one97.paytm.hotel4.service.model.details.Data r1 = r6.getData()
            if (r1 == 0) goto L_0x029c
            net.one97.paytm.hotel4.service.model.details.HotelPolicy r1 = r1.getHotelPolicy()
            if (r1 == 0) goto L_0x029c
            r5.buildPolicy(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x029c:
            net.one97.paytm.hotel4.service.model.details.Data r1 = r6.getData()
            if (r1 == 0) goto L_0x02ad
            net.one97.paytm.hotel4.service.model.details.TnC r1 = r1.getTnc()
            if (r1 == 0) goto L_0x02ad
            r5.buildTnc(r1)
            kotlin.x r1 = kotlin.x.f47997a
        L_0x02ad:
            net.one97.paytm.hotel4.service.model.details.Data r1 = r6.getData()
            if (r1 == 0) goto L_0x02b7
            net.one97.paytm.hotel4.service.model.details.PaytmImages r0 = r1.getPaytmImages()
        L_0x02b7:
            net.one97.paytm.hotel4.service.model.details.HotelDetails r1 = r5.detailsResponse
            if (r1 != 0) goto L_0x02be
            kotlin.g.b.k.a()
        L_0x02be:
            net.one97.paytm.hotel4.service.model.details.Data r1 = r1.getData()
            if (r1 != 0) goto L_0x02c7
            kotlin.g.b.k.a()
        L_0x02c7:
            java.util.List r1 = r1.getRoomOptions()
            r5.setImages(r0, r1)
            net.one97.paytm.hotel4.service.model.details.Data r6 = r6.getData()
            if (r6 == 0) goto L_0x02e5
            net.one97.paytm.hotel4.service.model.details.Facilities r6 = r6.getFacilities()
            if (r6 == 0) goto L_0x02e5
            net.one97.paytm.hotel4.service.model.details.Basic r6 = r6.getBasic()
            if (r6 == 0) goto L_0x02e5
            r5.updateAmenities(r6)
            kotlin.x r6 = kotlin.x.f47997a
        L_0x02e5:
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem> r6 = r5.selectedData
            java.lang.Object r6 = r6.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r6 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r6
            r5.setOriginalPriceVisibility(r6)
            kotlin.x r6 = kotlin.x.f47997a
            return
        L_0x02f3:
            r6 = r5
            net.one97.paytm.hotel4.viewmodel.DetailsViewModel r6 = (net.one97.paytm.hotel4.viewmodel.DetailsViewModel) r6
            androidx.lifecycle.y<java.lang.String> r1 = r6._name
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._about
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._streetAddress
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._fullAddress
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._pricePerRoom
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._cin
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._cin_date
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._cout
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._cout_date
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._nights_count
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.String> r1 = r6._nights_count_text
            r1.postValue(r0)
            androidx.lifecycle.y<java.util.List<java.lang.String>> r1 = r6._policy
            r1.postValue(r0)
            androidx.lifecycle.y<java.util.List<java.lang.String>> r1 = r6._tnc
            r1.postValue(r0)
            r6.setImages(r0, r0)
            androidx.lifecycle.y<java.util.List<java.lang.String>> r1 = r6.amenitiesBasic
            r1.postValue(r0)
            androidx.lifecycle.y<java.lang.Boolean> r1 = r6._showAmenitiesViewAll
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.postValue(r2)
            androidx.lifecycle.y<java.lang.Boolean> r1 = r6._showReadMoreAboutHotel
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r1.postValue(r2)
            r6.setOriginalPriceVisibility(r0)
            kotlin.x r6 = kotlin.x.f47997a
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.DetailsViewModel.setDetailsDta(net.one97.paytm.hotel4.service.model.details.HotelDetails):void");
    }

    private final void setOriginalPriceVisibility(SRPDataItem sRPDataItem) {
        this._originalPrice_visibility.postValue(8);
        if (sRPDataItem == null) {
            return;
        }
        if (sRPDataItem.getPriceData().getOriginalPrice() == sRPDataItem.getPriceData().getFinalPrice()) {
            this._originalPrice_visibility.postValue(8);
        } else {
            this._originalPrice_visibility.postValue(0);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r1.isEmpty() != false) goto L_0x0012;
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x022b A[Catch:{ Exception -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x023e A[Catch:{ Exception -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ea A[Catch:{ Exception -> 0x03a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00fd A[Catch:{ Exception -> 0x03a2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateImage(net.one97.paytm.hotel4.service.model.details.PaytmImages r5, int r6, java.util.List<net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages> r7) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0012
            java.util.List r1 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r1 != 0) goto L_0x000c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x000c:
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x03a2 }
            if (r1 == 0) goto L_0x0032
        L_0x0012:
            if (r7 != 0) goto L_0x0017
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0017:
            java.lang.Object r1 = r7.get(r0)     // Catch:{ Exception -> 0x03a2 }
            net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages r1 = (net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages) r1     // Catch:{ Exception -> 0x03a2 }
            java.util.List r1 = r1.getImageUrl()     // Catch:{ Exception -> 0x03a2 }
            if (r1 == 0) goto L_0x0032
            int r2 = r1.size()     // Catch:{ Exception -> 0x03a2 }
            if (r2 <= 0) goto L_0x0032
            androidx.lifecycle.y<java.lang.String> r2 = r4._image0_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r2.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
        L_0x0032:
            r1 = 2
            r2 = 1
            if (r6 != r2) goto L_0x0139
            if (r7 != 0) goto L_0x003b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x003b:
            java.lang.Object r6 = r7.get(r0)     // Catch:{ Exception -> 0x03a2 }
            net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages r6 = (net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages) r6     // Catch:{ Exception -> 0x03a2 }
            java.util.List r6 = r6.getImageUrl()     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x0060
            int r7 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r7 <= 0) goto L_0x0060
            androidx.lifecycle.y<java.lang.String> r7 = r4._image1_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r3 = r6.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r7.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r7 = r4._image1_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r7.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
            goto L_0x009b
        L_0x0060:
            if (r5 == 0) goto L_0x009b
            java.util.List r7 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r7 != 0) goto L_0x006b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x006b:
            int r7 = r7.size()     // Catch:{ Exception -> 0x03a2 }
            if (r7 <= 0) goto L_0x009b
            java.util.List r7 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r7 != 0) goto L_0x007a
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x007a:
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r7 == 0) goto L_0x009b
            androidx.lifecycle.y<java.lang.String> r7 = r4._image1_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r3 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r3 != 0) goto L_0x008b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x008b:
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r7.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r7 = r4._image1_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r7.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
        L_0x009b:
            if (r6 == 0) goto L_0x00a7
            int r7 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r7 <= r2) goto L_0x00a7
            androidx.lifecycle.y<java.lang.String> r7 = r4._image2_url     // Catch:{ Exception -> 0x03a2 }
            r3 = r6
            goto L_0x00d2
        L_0x00a7:
            if (r5 == 0) goto L_0x00e2
            java.util.List r7 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r7 != 0) goto L_0x00b2
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x00b2:
            int r7 = r7.size()     // Catch:{ Exception -> 0x03a2 }
            if (r7 <= 0) goto L_0x00e2
            java.util.List r7 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r7 != 0) goto L_0x00c1
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x00c1:
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r7 == 0) goto L_0x00e2
            androidx.lifecycle.y<java.lang.String> r7 = r4._image2_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r3 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r3 != 0) goto L_0x00d2
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x00d2:
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r7.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r7 = r4._image2_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r7.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
        L_0x00e2:
            if (r6 == 0) goto L_0x00fd
            int r7 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r7 <= r1) goto L_0x00fd
            androidx.lifecycle.y<java.lang.String> r5 = r4._image3_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r6 = r6.get(r1)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r5 = r4._image3_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            return
        L_0x00fd:
            if (r5 == 0) goto L_0x0138
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0108
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0108:
            int r6 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x0138
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0117
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0117:
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x0138
            androidx.lifecycle.y<java.lang.String> r6 = r4._image3_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r5 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r5 != 0) goto L_0x0128
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0128:
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r5)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r5 = r4._image3_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
        L_0x0138:
            return
        L_0x0139:
            if (r6 != r1) goto L_0x027a
            if (r7 != 0) goto L_0x0140
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0140:
            java.lang.Object r6 = r7.get(r0)     // Catch:{ Exception -> 0x03a2 }
            net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages r6 = (net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages) r6     // Catch:{ Exception -> 0x03a2 }
            java.util.List r6 = r6.getImageUrl()     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r7 = r7.get(r2)     // Catch:{ Exception -> 0x03a2 }
            net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages r7 = (net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages) r7     // Catch:{ Exception -> 0x03a2 }
            java.util.List r7 = r7.getImageUrl()     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x016f
            int r1 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r1 <= 0) goto L_0x016f
            androidx.lifecycle.y<java.lang.String> r1 = r4._image1_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r3 = r6.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r1.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r1 = r4._image1_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r1.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
            goto L_0x01aa
        L_0x016f:
            if (r5 == 0) goto L_0x01aa
            java.util.List r1 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r1 != 0) goto L_0x017a
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x017a:
            int r1 = r1.size()     // Catch:{ Exception -> 0x03a2 }
            if (r1 <= 0) goto L_0x01aa
            java.util.List r1 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r1 != 0) goto L_0x0189
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0189:
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r1 == 0) goto L_0x01aa
            androidx.lifecycle.y<java.lang.String> r1 = r4._image1_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r3 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r3 != 0) goto L_0x019a
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x019a:
            java.lang.Object r3 = r3.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r1.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r1 = r4._image1_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r1.postValue(r3)     // Catch:{ Exception -> 0x03a2 }
        L_0x01aa:
            if (r6 == 0) goto L_0x01b5
            int r1 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r1 <= r2) goto L_0x01b5
            androidx.lifecycle.y<java.lang.String> r1 = r4._image2_url     // Catch:{ Exception -> 0x03a2 }
            goto L_0x0213
        L_0x01b5:
            if (r7 == 0) goto L_0x01e8
            int r6 = r7.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x01e8
            androidx.lifecycle.y<java.lang.String> r6 = r4._image2_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r1 = r7.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r6 = r4._image2_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
            int r6 = r7.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= r2) goto L_0x0223
            androidx.lifecycle.y<java.lang.String> r5 = r4._image3_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r6 = r7.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r5 = r4._image3_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            return
        L_0x01e8:
            if (r5 == 0) goto L_0x0223
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x01f3
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x01f3:
            int r6 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x0223
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0202
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0202:
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x0223
            androidx.lifecycle.y<java.lang.String> r1 = r4._image2_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0213
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0213:
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r1.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r6 = r4._image2_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
        L_0x0223:
            if (r7 == 0) goto L_0x023e
            int r6 = r7.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x023e
            androidx.lifecycle.y<java.lang.String> r5 = r4._image3_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r6 = r7.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r5 = r4._image3_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            return
        L_0x023e:
            if (r5 == 0) goto L_0x0279
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0249
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0249:
            int r6 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x0279
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0258
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0258:
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x0279
            androidx.lifecycle.y<java.lang.String> r6 = r4._image3_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r5 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r5 != 0) goto L_0x0269
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0269:
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r5)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r5 = r4._image3_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
        L_0x0279:
            return
        L_0x027a:
            r3 = 3
            if (r6 < r3) goto L_0x03a2
            if (r7 != 0) goto L_0x0282
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0282:
            java.lang.Object r6 = r7.get(r0)     // Catch:{ Exception -> 0x03a2 }
            net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages r6 = (net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages) r6     // Catch:{ Exception -> 0x03a2 }
            java.util.List r6 = r6.getImageUrl()     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r3 = r7.get(r2)     // Catch:{ Exception -> 0x03a2 }
            net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages r3 = (net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages) r3     // Catch:{ Exception -> 0x03a2 }
            java.util.List r3 = r3.getImageUrl()     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r7 = r7.get(r1)     // Catch:{ Exception -> 0x03a2 }
            net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages r7 = (net.one97.paytm.hotel4.service.model.details.HotelRoomTypeImages) r7     // Catch:{ Exception -> 0x03a2 }
            java.util.List r7 = r7.getImageUrl()     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x02bb
            int r1 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r1 <= 0) goto L_0x02bb
            androidx.lifecycle.y<java.lang.String> r1 = r4._image1_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r6 = r6.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r1.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r6 = r4._image1_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
            goto L_0x02f6
        L_0x02bb:
            if (r5 == 0) goto L_0x02f6
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x02c6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x02c6:
            int r6 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x02f6
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x02d5
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x02d5:
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x02f6
            androidx.lifecycle.y<java.lang.String> r6 = r4._image1_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r1 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r1 != 0) goto L_0x02e6
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x02e6:
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r6 = r4._image1_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
        L_0x02f6:
            if (r3 == 0) goto L_0x0311
            int r6 = r3.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x0311
            androidx.lifecycle.y<java.lang.String> r6 = r4._image2_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r1 = r3.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r6 = r4._image2_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
            goto L_0x034c
        L_0x0311:
            if (r5 == 0) goto L_0x034c
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x031c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x031c:
            int r6 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x034c
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x032b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x032b:
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x034c
            androidx.lifecycle.y<java.lang.String> r6 = r4._image2_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r1 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r1 != 0) goto L_0x033c
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x033c:
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r6 = r4._image2_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r1)     // Catch:{ Exception -> 0x03a2 }
        L_0x034c:
            if (r7 == 0) goto L_0x0367
            int r6 = r7.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x0367
            androidx.lifecycle.y<java.lang.String> r5 = r4._image3_url     // Catch:{ Exception -> 0x03a2 }
            java.lang.Object r6 = r7.get(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r5 = r4._image3_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
            return
        L_0x0367:
            if (r5 == 0) goto L_0x03a2
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0372
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0372:
            int r6 = r6.size()     // Catch:{ Exception -> 0x03a2 }
            if (r6 <= 0) goto L_0x03a2
            java.util.List r6 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r6 != 0) goto L_0x0381
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0381:
            java.lang.Object r6 = r6.get(r2)     // Catch:{ Exception -> 0x03a2 }
            if (r6 == 0) goto L_0x03a2
            androidx.lifecycle.y<java.lang.String> r6 = r4._image3_url     // Catch:{ Exception -> 0x03a2 }
            java.util.List r5 = r5.getFull()     // Catch:{ Exception -> 0x03a2 }
            if (r5 != 0) goto L_0x0392
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x03a2 }
        L_0x0392:
            java.lang.Object r5 = r5.get(r2)     // Catch:{ Exception -> 0x03a2 }
            r6.postValue(r5)     // Catch:{ Exception -> 0x03a2 }
            androidx.lifecycle.y<java.lang.Integer> r5 = r4._image3_visibility     // Catch:{ Exception -> 0x03a2 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r0)     // Catch:{ Exception -> 0x03a2 }
            r5.postValue(r6)     // Catch:{ Exception -> 0x03a2 }
        L_0x03a2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.DetailsViewModel.updateImage(net.one97.paytm.hotel4.service.model.details.PaytmImages, int, java.util.List):void");
    }

    private final void setImages(PaytmImages paytmImages, List<RoomOption> list) {
        String paytmRoomName;
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (list != null) {
            for (RoomOption roomOption : list) {
                Images images2 = roomOption.getImages();
                if (images2 == null) {
                    k.a();
                }
                List<String> full = images2.getFull();
                if (full == null) {
                    k.a();
                }
                if (!full.isEmpty() && (paytmRoomName = roomOption.getPaytmRoomName()) != null) {
                    Images images3 = roomOption.getImages();
                    if (images3 == null) {
                        k.a();
                    }
                    List<String> full2 = images3.getFull();
                    if (full2 != null) {
                        arrayList.addAll(full2);
                        arrayList2.add(new HotelRoomTypeImages(paytmRoomName, full2));
                    }
                }
            }
        }
        this._image0_url.postValue(null);
        this._image1_visibility.postValue(8);
        this._image2_visibility.postValue(8);
        this._image3_visibility.postValue(8);
        this._imageCount_visibility.postValue(8);
        if (paytmImages != null) {
            if (paytmImages == null) {
                k.a();
            }
            List<String> full3 = paytmImages.getFull();
            if (full3 == null) {
                k.a();
            }
            arrayList.addAll(full3);
            List<String> full4 = paytmImages.getFull();
            if (full4 == null) {
                k.a();
            }
            if (!full4.isEmpty()) {
                y<String> yVar = this._image0_url;
                List<String> full5 = paytmImages.getFull();
                if (full5 == null) {
                    k.a();
                }
                yVar.postValue(full5.get(0));
            }
        }
        if (arrayList2.size() > 0) {
            if (arrayList2.size() == 1) {
                updateImage(paytmImages, 1, arrayList2);
            } else if (arrayList2.size() == 2) {
                updateImage(paytmImages, 2, arrayList2);
            } else if (arrayList2.size() == 3) {
                updateImage(paytmImages, 3, arrayList2);
            } else {
                updateImage(paytmImages, arrayList2.size(), arrayList2);
            }
        } else if (paytmImages != null) {
            List<String> full6 = paytmImages.getFull();
            if (full6 == null) {
                k.a();
            }
            if (!full6.isEmpty()) {
                List<String> full7 = paytmImages.getFull();
                if (full7 == null) {
                    k.a();
                }
                if (full7.size() > 1) {
                    y<String> yVar2 = this._image1_url;
                    List<String> full8 = paytmImages.getFull();
                    if (full8 == null) {
                        k.a();
                    }
                    yVar2.postValue(full8.get(1));
                    this._image1_visibility.postValue(0);
                }
            }
            List<String> full9 = paytmImages.getFull();
            if (full9 == null) {
                k.a();
            }
            if (!full9.isEmpty()) {
                List<String> full10 = paytmImages.getFull();
                if (full10 == null) {
                    k.a();
                }
                if (full10.size() > 2) {
                    y<String> yVar3 = this._image2_url;
                    List<String> full11 = paytmImages.getFull();
                    if (full11 == null) {
                        k.a();
                    }
                    yVar3.postValue(full11.get(2));
                    this._image2_visibility.postValue(0);
                }
            }
            List<String> full12 = paytmImages.getFull();
            if (full12 == null) {
                k.a();
            }
            if (!full12.isEmpty()) {
                List<String> full13 = paytmImages.getFull();
                if (full13 == null) {
                    k.a();
                }
                if (full13.size() > 3) {
                    y<String> yVar4 = this._image3_url;
                    List<String> full14 = paytmImages.getFull();
                    if (full14 == null) {
                        k.a();
                    }
                    yVar4.postValue(full14.get(3));
                    this._image3_visibility.postValue(0);
                }
            }
        }
        if (arrayList.size() - 4 > 0) {
            y<String> yVar5 = this._imageCount;
            yVar5.postValue("+" + String.valueOf(arrayList.size() - 4) + " Images");
            this._imageCount_visibility.postValue(0);
            return;
        }
        this._imageCount_visibility.postValue(8);
    }

    private final void fetchDetailData(SRPDataItem sRPDataItem, String str) {
        this.detailRequestID = str;
        a aVar = this.detailsRepo;
        if (aVar != null) {
            aVar.a(this.apiCallSuccess, this.apiCallFailure, sRPDataItem, getParent().getSearchInput(), str);
        }
    }

    public final void fetchDetailForUpdatedRoomData() {
        this.detailRequestID = this.detailRequestID;
        a aVar = this.detailsRepo;
        if (aVar != null) {
            y yVar = this.apiCallSuccess;
            y yVar2 = this.apiCallFailure;
            SRPDataItem value = this.selectedData.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "selectedData.value!!");
            aVar.a(yVar, yVar2, value, getParent().getSearchInput(), this.detailRequestID);
        }
    }

    public final void fetchDetailForRoomSelection() {
        this.isApiCalling.postValue(Boolean.TRUE);
        this.detailRequestID = this.detailRequestID;
        a aVar = this.detailsRepo;
        if (aVar != null) {
            y yVar = this.apiCallSuccess;
            y yVar2 = this.apiCallFailure;
            SRPDataItem value = this.selectedData.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "selectedData.value!!");
            aVar.a(yVar, yVar2, value, getParent().getSearchTemporaryInput(), this.detailRequestID);
        }
    }

    public final void onFavPressed() {
        this.favPressed.postValue(Boolean.TRUE);
    }

    public final void onAmenitiesViewAllPressed() {
        this.allAmenitiesOpenDialogListener.postValue(Boolean.TRUE);
    }

    public final void onAboutHotelPressed() {
        this.aboutHotelReadMoreDialogListener.postValue(Boolean.TRUE);
    }

    public final void onHotelPolicyViewAllPressed() {
        this.hotelPolicyViewAllDialogListener.postValue(Boolean.TRUE);
    }

    public final void openFullMapFragment() {
        sendPulseEvent("map_clicked");
        getParent().postScreenNavigationEvent("5", "333");
    }

    private final void sendPulseEvent(String str) {
        Data data;
        Data data2;
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
        HotelDetails hotelDetails = this.detailsResponse;
        if (hotelDetails != null) {
            String str2 = null;
            if ((hotelDetails != null ? hotelDetails.getData() : null) != null) {
                HotelDetails hotelDetails2 = this.detailsResponse;
                if (((hotelDetails2 == null || (data2 = hotelDetails2.getData()) == null) ? null : data2.getName()) != null) {
                    Map map2 = hashMap;
                    HotelDetails hotelDetails3 = this.detailsResponse;
                    if (!(hotelDetails3 == null || (data = hotelDetails3.getData()) == null)) {
                        str2 = data.getName();
                    }
                    if (str2 != null) {
                        map2.put("event_label2", str2);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Any");
                    }
                }
            }
        }
        c.b().a("customEvent", "Hotel Details", "hotels_details", str, hashMap);
    }

    private final void sendPulseEventMapNav() {
        Data data;
        Data data2;
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
        HotelDetails hotelDetails = this.detailsResponse;
        if (hotelDetails != null) {
            String str = null;
            if ((hotelDetails != null ? hotelDetails.getData() : null) != null) {
                HotelDetails hotelDetails2 = this.detailsResponse;
                if (((hotelDetails2 == null || (data2 = hotelDetails2.getData()) == null) ? null : data2.getName()) != null) {
                    Map map2 = hashMap;
                    HotelDetails hotelDetails3 = this.detailsResponse;
                    if (!(hotelDetails3 == null || (data = hotelDetails3.getData()) == null)) {
                        str = data.getName();
                    }
                    if (str != null) {
                        map2.put("event_label2", str);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Any");
                    }
                }
            }
        }
        Map map3 = hashMap;
        map3.put("event_label3", "googlemaps");
        c.b().a("customEvent", "Hotel Details", "hotels_details", "nav_clicked", map3);
    }

    public final void onBackPressed() {
        sendPulseBack();
        getParent().postScreenNavigationEvent("5", "2");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0055, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void sendPulseBack() {
        /*
            r9 = this;
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r9.getParent()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Any"
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            if (r1 == 0) goto L_0x004e
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r1 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r1 = r1.getSearchInput()
            if (r1 != 0) goto L_0x0024
            kotlin.g.b.k.a()
        L_0x0024:
            java.lang.String r1 = r1.getCity()
            if (r1 == 0) goto L_0x004e
            r1 = r0
            java.util.Map r1 = (java.util.Map) r1
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r3 = r9.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r3 = r3.getSearchInput()
            if (r3 != 0) goto L_0x003a
            kotlin.g.b.k.a()
        L_0x003a:
            java.lang.String r3 = r3.getCity()
            if (r3 == 0) goto L_0x0048
            java.lang.Object r3 = (java.lang.Object) r3
            java.lang.String r4 = "event_label"
            r1.put(r4, r3)
            goto L_0x004e
        L_0x0048:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r2)
            throw r0
        L_0x004e:
            r8 = r0
            java.util.Map r8 = (java.util.Map) r8
            androidx.lifecycle.y<net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem> r0 = r9.selectedData
            if (r0 == 0) goto L_0x0062
            java.lang.Object r0 = r0.getValue()
            net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem r0 = (net.one97.paytm.hotel4.service.model.datamodel.srpDataModel.SRPDataItem) r0
            if (r0 == 0) goto L_0x0062
            java.lang.String r0 = r0.getName()
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            if (r0 == 0) goto L_0x007c
            java.lang.Object r0 = (java.lang.Object) r0
            java.lang.String r1 = "event_label2"
            r8.put(r1, r0)
            net.one97.paytm.hotels2.utils.d r3 = net.one97.paytm.hotels2.utils.c.b()
            java.lang.String r4 = "customEvent"
            java.lang.String r5 = "Hotel Details"
            java.lang.String r6 = "hotels_details"
            java.lang.String r7 = "back_tapped"
            r3.a(r4, r5, r6, r7, r8)
            return
        L_0x007c:
            kotlin.u r0 = new kotlin.u
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.DetailsViewModel.sendPulseBack():void");
    }

    public final void onSearchOtherHotel() {
        closeButtonNoRoomsPressed();
        getParent().postScreenNavigationEvent("5", "2");
    }

    public final void onSharePressed() {
        HotelDetails hotelDetails;
        Data data;
        CJRHotelSearchInput searchInput;
        if (!this.debounceClick.a("sharedButton") && (hotelDetails = this.detailsResponse) != null && (data = hotelDetails.getData()) != null && (searchInput = getParent().getSearchInput()) != null) {
            int adultCount = searchInput.getAdultCount();
            int childCount = searchInput.getChildCount();
            ArrayList<CJRRoom> rooms = searchInput.getRooms();
            if (rooms == null) {
                k.a();
            }
            int size = rooms.size();
            e eVar = e.f28642a;
            Address address = data.getAddress();
            String address2 = address != null ? address.toString() : null;
            if (address2 == null) {
                k.a();
            }
            String id = data.getId();
            if (id == null) {
                k.a();
            }
            String name = data.getName();
            if (name == null) {
                k.a();
            }
            PaytmImages paytmImages = data.getPaytmImages();
            String checkOutDate = searchInput.getCheckOutDate();
            String checkInDate = searchInput.getCheckInDate();
            String city = searchInput.getCity();
            if (city == null) {
                k.a();
            }
            this.sharePressed.postValue(e.a(address2, id, name, paytmImages, checkOutDate, checkInDate, city, String.valueOf(size), String.valueOf(adultCount), String.valueOf(childCount), String.valueOf(searchInput.getRooms())));
        }
    }

    public final void onGalleryPressed() {
        sendPulseEvent("gallery_opened");
        getParent().postScreenNavigationEvent("5", "6");
    }

    public final void onSelectRoomPressed() {
        HotelDetails hotelDetails = this.detailsResponse;
        if (hotelDetails != null) {
            if (hotelDetails == null) {
                k.a();
            }
            if (hotelDetails.getData() != null) {
                HotelDetails hotelDetails2 = this.detailsResponse;
                if (hotelDetails2 == null) {
                    k.a();
                }
                Data data = hotelDetails2.getData();
                if (data == null) {
                    k.a();
                }
                List<RoomOption> roomOptions = data.getRoomOptions();
                if (roomOptions == null) {
                    k.a();
                }
                if (!roomOptions.isEmpty()) {
                    getParent().postScreenNavigationEvent("5", "7");
                } else {
                    getParent().postScreenNavigationEvent("5", "111");
                }
            }
        }
    }

    private final void updateAmenities(Basic basic) {
        List<String> amenitiesList = Basic.Companion.getAmenitiesList(basic);
        HotelDetails hotelDetails = this.detailsResponse;
        if (hotelDetails == null) {
            k.a();
        }
        Data data = hotelDetails.getData();
        if (data == null) {
            k.a();
        }
        Facilities facilities = data.getFacilities();
        if (facilities == null) {
            k.a();
        }
        ArrayList<String> more = facilities.getMore();
        List<String> amenitiesList2 = Basic.Companion.getAmenitiesList(basic);
        int size = amenitiesList.size();
        if (more == null) {
            k.a();
        }
        if (size + more.size() > 10) {
            this._showAmenitiesViewAll.postValue(Boolean.TRUE);
        } else {
            this._showAmenitiesViewAll.postValue(Boolean.FALSE);
        }
        if (amenitiesList.size() <= 10) {
            Iterator<String> it2 = more.iterator();
            while (it2.hasNext()) {
                String next = it2.next();
                if (amenitiesList.size() <= 10) {
                    k.a((Object) next, "item");
                    amenitiesList.add(next);
                }
                k.a((Object) next, "item");
                amenitiesList2.add(next);
            }
        }
        this.amenitiesBasic.postValue(amenitiesList);
        this.amenitiesAllBasic.postValue(amenitiesList2);
    }

    private final void updateHotelAbout(String str) {
        int length = str.length();
        String textFromHTMLParsing = getTextFromHTMLParsing(str);
        if (length > 200) {
            this._showReadMoreAboutHotel.postValue(Boolean.TRUE);
            if (textFromHTMLParsing != null) {
                String substring = textFromHTMLParsing.substring(0, 200);
                k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                y<String> yVar = this._aboutShortened;
                yVar.postValue(substring + AppConstants.DOTS);
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            this._showReadMoreAboutHotel.postValue(Boolean.FALSE);
            this._aboutShortened.postValue(textFromHTMLParsing);
        }
        this._about.postValue(textFromHTMLParsing);
    }

    private final String getTextFromHTMLParsing(String str) {
        Spanned spanned;
        if (!validateHtml(str)) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = Html.fromHtml(str, 0);
        } else {
            spanned = Html.fromHtml(str);
        }
        return spanned.toString();
    }

    private final boolean validateHtml(String str) {
        Pattern compile = TextUtils.isEmpty("<(\"[^\"]*\"|'[^']*'|[^'\">])*>") ? null : Pattern.compile("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
        if (compile != null) {
            return compile.matcher(str).find();
        }
        return false;
    }

    public final CharSequence toBulletedList(List<String> list) {
        k.c(list, "$this$toBulletedList");
        Color.RGBToHSV(0, 175, 238, new float[3]);
        Iterable iterable = list;
        SpannableString spannableString = new SpannableString(kotlin.a.k.a(iterable, (CharSequence) StringUtility.NEW_LINE, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (b) null, 62));
        int i2 = 0;
        int i3 = 0;
        for (Object next : iterable) {
            int i4 = i2 + 1;
            if (i2 < 0) {
                kotlin.a.k.a();
            }
            int length = ((String) next).length() + i3;
            int i5 = 1;
            if (i2 == list.size() - 1) {
                i5 = 0;
            }
            int i6 = length + i5;
            spannableString.setSpan(new BulletSpan(32), i3, i6, 0);
            i3 = i6;
            i2 = i4;
        }
        return spannableString;
    }

    private final void buildPolicy(HotelPolicy hotelPolicy) {
        boolean z;
        if (hotelPolicy.getOther() != null) {
            y<List<String>> yVar = this._tnc;
            List<String> other = hotelPolicy.getOther();
            if (other == null) {
                k.a();
            }
            Collection arrayList = new ArrayList();
            Iterator it2 = other.iterator();
            while (true) {
                z = true;
                if (!it2.hasNext()) {
                    break;
                }
                Object next = it2.next();
                String str = (String) next;
                if (str == null || p.b(str).toString().length() <= 3) {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            List c2 = ab.c((List) arrayList);
            if (c2 == null) {
                k.a();
            }
            yVar.postValue(c2);
            y<Boolean> yVar2 = this._showHotelPolicyViewAll;
            List<String> other2 = hotelPolicy.getOther();
            if (other2 == null) {
                k.a();
            }
            if (other2.size() <= 3) {
                z = false;
            }
            yVar2.postValue(Boolean.valueOf(z));
        }
    }

    private final void buildTnc(TnC tnC) {
        y<List<String>> yVar = this._policy;
        List<String> conditions = tnC.getConditions();
        if (conditions == null) {
            k.a();
        }
        Collection arrayList = new ArrayList();
        for (Object next : conditions) {
            String str = (String) next;
            if (str != null && p.b(str).toString().length() > 3) {
                arrayList.add(next);
            }
        }
        List c2 = ab.c((List) arrayList);
        if (c2 == null) {
            k.a();
        }
        yVar.postValue(c2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r9 = r9.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendHotelDetailslOpenPulseEvent(boolean r9) {
        /*
            r8 = this;
            if (r9 == 0) goto L_0x0069
            java.util.HashMap r9 = new java.util.HashMap
            r9.<init>()
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r0 = r8.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r0 = r0.getSearchInput()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Any"
            if (r0 == 0) goto L_0x0037
            r0 = r9
            java.util.Map r0 = (java.util.Map) r0
            net.one97.paytm.hotel4.viewmodel.SharedViewModel r2 = r8.getParent()
            net.one97.paytm.hotels2.entity.CJRHotelSearchInput r2 = r2.getSearchInput()
            if (r2 != 0) goto L_0x0023
            kotlin.g.b.k.a()
        L_0x0023:
            java.lang.String r2 = r2.getCity()
            if (r2 == 0) goto L_0x0031
            java.lang.Object r2 = (java.lang.Object) r2
            java.lang.String r3 = "event_label"
            r0.put(r3, r2)
            goto L_0x0037
        L_0x0031:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r1)
            throw r9
        L_0x0037:
            r7 = r9
            java.util.Map r7 = (java.util.Map) r7
            net.one97.paytm.hotel4.service.model.details.HotelDetails r9 = r8.detailsResponse
            if (r9 == 0) goto L_0x0049
            net.one97.paytm.hotel4.service.model.details.Data r9 = r9.getData()
            if (r9 == 0) goto L_0x0049
            java.lang.String r9 = r9.getName()
            goto L_0x004a
        L_0x0049:
            r9 = 0
        L_0x004a:
            if (r9 == 0) goto L_0x0063
            java.lang.Object r9 = (java.lang.Object) r9
            java.lang.String r0 = "event_label2"
            r7.put(r0, r9)
            net.one97.paytm.hotels2.utils.d r2 = net.one97.paytm.hotels2.utils.c.b()
            java.lang.String r3 = "customEvent"
            java.lang.String r4 = "Hotel Details"
            java.lang.String r5 = "hotels_details"
            java.lang.String r6 = "page_opened"
            r2.a(r3, r4, r5, r6, r7)
            goto L_0x0069
        L_0x0063:
            kotlin.u r9 = new kotlin.u
            r9.<init>(r1)
            throw r9
        L_0x0069:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.hotel4.viewmodel.DetailsViewModel.sendHotelDetailslOpenPulseEvent(boolean):void");
    }

    public final void openGoogleMap() {
        Context context = getParent().getContext();
        if (context != null) {
            try {
                sendPulseEventMapNav();
                SRPDataItem value = this.selectedData.getValue();
                if (value == null) {
                    k.a();
                }
                String name = value.getName();
                y<SRPDataItem> yVar = this.selectedData;
                if (yVar == null) {
                    k.a();
                }
                SRPDataItem value2 = yVar.getValue();
                if (value2 == null) {
                    k.a();
                }
                double latitude = value2.getLatitude();
                y<SRPDataItem> yVar2 = this.selectedData;
                if (yVar2 == null) {
                    k.a();
                }
                SRPDataItem value3 = yVar2.getValue();
                if (value3 == null) {
                    k.a();
                }
                double longitude = value3.getLongitude();
                s sVar = s.f28553a;
                s.a(context, latitude, longitude, name);
            } catch (Exception unused) {
            }
        }
    }
}
