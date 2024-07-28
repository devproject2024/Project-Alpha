package com.paytm.dynamic.flight;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.d;
import androidx.databinding.e;
import com.paytmmall.clpartifact.utils.CLPConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.common.viewmodel.BaseViewModel;
import net.one97.paytm.paytm_finance.R;

public class DataBinderMapperImpl extends d {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_BESTBOTTOMSHEETRECHARGE = 1;
    private static final int LAYOUT_FRAGMENTCITYBUSADDMONEY = 2;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.best_bottom_sheet_recharge, 1);
        INTERNAL_LAYOUT_ID_LOOKUP.put(R.layout.fragment_city_bus_add_money, 2);
    }

    public ViewDataBinding getDataBinder(e eVar, View view, int i2) {
        int i3 = INTERNAL_LAYOUT_ID_LOOKUP.get(i2);
        if (i3 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        } else if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            if ("layout/fragment_city_bus_add_money_0".equals(tag)) {
                return new com.paytm.dynamic.flight.a.d(eVar, view);
            }
            throw new IllegalArgumentException("The tag for fragment_city_bus_add_money is invalid. Received: ".concat(String.valueOf(tag)));
        } else if ("layout/best_bottom_sheet_recharge_0".equals(tag)) {
            return new com.paytm.dynamic.flight.a.b(eVar, view);
        } else {
            throw new IllegalArgumentException("The tag for best_bottom_sheet_recharge is invalid. Received: ".concat(String.valueOf(tag)));
        }
    }

    public ViewDataBinding getDataBinder(e eVar, View[] viewArr, int i2) {
        if (viewArr == null || viewArr.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(i2) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f21359a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public String convertBrIdToString(int i2) {
        return a.f21358a.get(i2);
    }

    public List<d> collectDependencies() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(new com.travel.DataBinderMapperImpl());
        arrayList.add(new com.travel.common.DataBinderMapperImpl());
        arrayList.add(new com.travel.flight.DataBinderMapperImpl());
        arrayList.add(new com.travel.train.DataBinderMapperImpl());
        arrayList.add(new net.one97.paytm.hotels2.DataBinderMapperImpl());
        arrayList.add(new net.one97.travelpass.DataBinderMapperImpl());
        return arrayList;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        static final SparseArray<String> f21358a;

        static {
            SparseArray<String> sparseArray = new SparseArray<>(195);
            f21358a = sparseArray;
            sparseArray.put(0, "_all");
            f21358a.put(44, "emiViewModel");
            f21358a.put(45, "instrumentSheetViewModel");
            f21358a.put(46, "section");
            f21358a.put(47, "transcationViewModel");
            f21358a.put(48, "allNetBankingViewModel");
            f21358a.put(49, "bankMandateIfscCodeViewModel");
            f21358a.put(50, "codViewModel");
            f21358a.put(51, "view");
            f21358a.put(52, "netBankingViewModel");
            f21358a.put(53, "netbanking");
            f21358a.put(39, "saveCardModel");
            f21358a.put(19, "model");
            f21358a.put(54, "showInstrumentInfoMsg");
            f21358a.put(55, "a");
            f21358a.put(56, "otpViewholder");
            f21358a.put(57, "pincvvmodel");
            f21358a.put(58, "bank_mandate");
            f21358a.put(59, "debitCardModel");
            f21358a.put(60, "selectedInstrumentSheetViewModel");
            f21358a.put(61, "typeface");
            f21358a.put(62, "aoaWalletViewModel");
            f21358a.put(63, "bankViewModel");
            f21358a.put(64, "landingPageViewModel");
            f21358a.put(65, "walletViewModel");
            f21358a.put(66, "digitalCreditModel");
            f21358a.put(41, "cvvHelpModel");
            f21358a.put(67, "bankMandateSubDetailsViewModel");
            f21358a.put(68, "upiHelpModel");
            f21358a.put(69, "upiCollectModel");
            f21358a.put(72, "handler");
            f21358a.put(73, "slider");
            f21358a.put(74, "isCollapsed");
            f21358a.put(75, "rating");
            f21358a.put(76, "showMoreVisibility");
            f21358a.put(8, "type");
            f21358a.put(77, "showRating");
            f21358a.put(78, "levelToRateCount");
            f21358a.put(79, "id");
            f21358a.put(80, "badgeText");
            f21358a.put(81, "totalReview");
            f21358a.put(82, "item");
            f21358a.put(20, "adapter");
            f21358a.put(83, "reviewDetail");
            f21358a.put(84, "showWishListIcon");
            f21358a.put(85, "ratingModel");
            f21358a.put(86, "entityType");
            f21358a.put(87, "totalRatings");
            f21358a.put(88, "ratingTotal");
            f21358a.put(89, "iSCOLLAPSED");
            f21358a.put(90, "starNumber");
            f21358a.put(91, "offerTag");
            f21358a.put(92, "badgeImageUrl");
            f21358a.put(93, "notificationActive");
            f21358a.put(94, "subCashback");
            f21358a.put(95, "following");
            f21358a.put(96, "name");
            f21358a.put(97, "tickerText");
            f21358a.put(33, "viewModel");
            f21358a.put(35, CLPConstants.ARGUMENT_KEY_POSITION);
            f21358a.put(98, "clickHandler");
            f21358a.put(99, "groupAdapter");
            f21358a.put(5, "dataModel");
            f21358a.put(9, "title");
            f21358a.put(100, "reviewDate");
            f21358a.put(101, "imageUrl");
            f21358a.put(102, "isSelected");
            f21358a.put(103, "isApplied");
            f21358a.put(104, "avgRating");
            f21358a.put(105, "IS_COLLAPSED");
            f21358a.put(106, "redirect");
            f21358a.put(107, "product");
            f21358a.put(108, "holder");
            f21358a.put(109, "label");
            f21358a.put(110, "clickhandler");
            f21358a.put(111, "cashback");
            f21358a.put(112, "entityIdentifier");
            f21358a.put(113, "pagerIndicatorVisibility");
            f21358a.put(114, "fragment");
            f21358a.put(115, "seourl");
            f21358a.put(116, "isWishListed");
            f21358a.put(117, "initialFrom");
            f21358a.put(118, "layoutManager");
            f21358a.put(119, "dialogDataModel");
            f21358a.put(120, "showSeparation");
            f21358a.put(121, "showPrice");
            f21358a.put(122, "showRatingBar");
            f21358a.put(123, "initialTo");
            f21358a.put(124, "category");
            f21358a.put(125, "defaultItemData");
            f21358a.put(126, "ratingData");
            f21358a.put(com.travel.a.f21418c, "bookingInfo");
            f21358a.put(com.travel.a.f21419d, "bookingData");
            f21358a.put(com.travel.flight.a.f23481e, "note");
            f21358a.put(com.travel.flight.a.f23482f, "flight");
            f21358a.put(com.travel.flight.a.f23483g, "cards");
            f21358a.put(com.travel.flight.a.f23484h, "orderSummaryBundleResponse");
            f21358a.put(com.travel.flight.a.f23485i, "isOnwardJourney");
            f21358a.put(com.travel.flight.a.j, "parentViewModel");
            f21358a.put(com.travel.flight.a.k, "onwardFlightImage");
            f21358a.put(com.travel.flight.a.l, "isDepartureFilter");
            f21358a.put(com.travel.flight.a.m, "hotelData");
            f21358a.put(com.travel.flight.a.n, "selectedAirline");
            f21358a.put(com.travel.flight.a.o, "paymentDetail");
            f21358a.put(com.travel.flight.a.p, "oneWayViewModel");
            f21358a.put(com.travel.flight.a.q, "airlineInfo");
            f21358a.put(com.travel.flight.a.r, "datePriceInfo");
            f21358a.put(8126480, "sharedViewModel");
            f21358a.put(com.travel.flight.a.t, "flightBookingRefund");
            f21358a.put(com.travel.flight.a.u, "paymentDetails");
            f21358a.put(com.travel.flight.a.v, "info");
            f21358a.put(com.travel.flight.a.w, "rootBody");
            f21358a.put(com.travel.flight.a.x, "flightInfo");
            f21358a.put(com.travel.flight.a.y, "presenter");
            f21358a.put(com.travel.flight.a.z, "parentOrder");
            f21358a.put(com.travel.flight.a.A, "filterViewModel");
            f21358a.put(com.travel.flight.a.B, "toolTip");
            f21358a.put(com.travel.flight.a.C, "flightBundleCouponViewHolderCompanion");
            f21358a.put(com.travel.flight.a.D, "rootData");
            f21358a.put(com.travel.flight.a.E, "passengerInfo");
            f21358a.put(com.travel.flight.a.F, "imgNote");
            f21358a.put(com.travel.flight.a.G, "irtSplitViewModel");
            f21358a.put(com.travel.flight.a.H, "filterInfo");
            f21358a.put(com.travel.flight.a.I, "important");
            f21358a.put(com.travel.flight.a.J, "discountedStrip");
            f21358a.put(com.travel.flight.a.K, "irtViewModel");
            f21358a.put(com.travel.flight.a.L, "charges");
            f21358a.put(com.travel.flight.a.M, "hotelInfo");
            f21358a.put(com.travel.flight.a.N, "returnFlightImage");
            f21358a.put(com.travel.flight.a.O, "filterHomeViewModel");
            f21358a.put(com.travel.flight.a.P, "passenger");
            f21358a.put(com.travel.flight.a.Q, "filterRemoveIcon");
            f21358a.put(com.travel.flight.a.R, "filterChangeListener");
            f21358a.put(com.travel.flight.a.S, BaseViewModel.PaymentType.CARD);
            f21358a.put(com.travel.flight.a.T, "formattedPriorityCheckindatamodel");
            f21358a.put(com.travel.flight.a.U, "flightItem");
            f21358a.put(net.one97.paytm.hotels2.a.f29092g, "titleMsg");
            f21358a.put(net.one97.paytm.hotels2.a.f29093h, "parentIndex");
            f21358a.put(net.one97.paytm.hotels2.a.f29094i, "data");
            f21358a.put(net.one97.paytm.hotels2.a.j, "reviewViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.k, "_amenities_extra_visibility");
            f21358a.put(net.one97.paytm.hotels2.a.l, SDKConstants.EVENT_KEY_SCREEN_NAME);
            f21358a.put(net.one97.paytm.hotels2.a.m, "showMoreLess");
            f21358a.put(net.one97.paytm.hotels2.a.n, "details");
            f21358a.put(net.one97.paytm.hotels2.a.o, CJRGiftCardUserInputField.FIELD_TYPE_TEXTBOX);
            f21358a.put(net.one97.paytm.hotels2.a.p, "isInfoVisible");
            f21358a.put(net.one97.paytm.hotels2.a.q, "srpHeaderViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.r, "_amenities2_visibility");
            f21358a.put(net.one97.paytm.hotels2.a.s, "cancelOrderViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.t, "viewmodel");
            f21358a.put(net.one97.paytm.hotels2.a.u, "datamodel");
            f21358a.put(net.one97.paytm.hotels2.a.v, "detailsviewmodel");
            f21358a.put(net.one97.paytm.hotels2.a.w, "autoSearchDataItem");
            f21358a.put(net.one97.paytm.hotels2.a.x, "roomItem");
            f21358a.put(net.one97.paytm.hotels2.a.y, "hotelBookingStatusViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.z, "_amenities2_image");
            f21358a.put(net.one97.paytm.hotels2.a.A, "_amenities_extra");
            f21358a.put(net.one97.paytm.hotels2.a.B, "selectedGalleryImage");
            f21358a.put(net.one97.paytm.hotels2.a.C, "isTitleVisible");
            f21358a.put(net.one97.paytm.hotels2.a.D, "refundData");
            f21358a.put(net.one97.paytm.hotels2.a.E, "headerViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.F, "reviewModel");
            f21358a.put(net.one97.paytm.hotels2.a.G, "_amenities1_image");
            f21358a.put(net.one97.paytm.hotels2.a.H, "selectedCity");
            f21358a.put(net.one97.paytm.hotels2.a.I, "srpHeaderViewModelNoresult");
            f21358a.put(net.one97.paytm.hotels2.a.J, "imageSrc");
            f21358a.put(net.one97.paytm.hotels2.a.K, "_amenities3_visibility");
            f21358a.put(net.one97.paytm.hotels2.a.L, "hotelSearchViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.M, "amenityType");
            f21358a.put(net.one97.paytm.hotels2.a.N, "pagerGalleryViewmodel");
            f21358a.put(net.one97.paytm.hotels2.a.O, "rvviewmodel");
            f21358a.put(net.one97.paytm.hotels2.a.P, "srpHeaderViewModelInclude");
            f21358a.put(net.one97.paytm.hotels2.a.Q, "rsviewmodel");
            f21358a.put(net.one97.paytm.hotels2.a.R, "dataViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.S, "hotel");
            f21358a.put(net.one97.paytm.hotels2.a.T, "errorViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.U, "showingAllPromocode");
            f21358a.put(net.one97.paytm.hotels2.a.V, "_amenities1_visibility");
            f21358a.put(net.one97.paytm.hotels2.a.W, "cancelViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.X, "srpViewModel");
            f21358a.put(net.one97.paytm.hotels2.a.Y, "selectedRoomOption");
            f21358a.put(net.one97.paytm.hotels2.a.Z, "message");
            f21358a.put(net.one97.paytm.hotels2.a.aa, "pair");
            f21358a.put(net.one97.paytm.hotels2.a.ab, "_amenities0_visibility");
            f21358a.put(net.one97.paytm.hotels2.a.ac, "amenityUrl");
            f21358a.put(net.one97.paytm.hotels2.a.ad, "_amenities3_image");
            f21358a.put(net.one97.paytm.hotels2.a.ae, "continueView");
            f21358a.put(net.one97.paytm.hotels2.a.af, "selectedRoom");
            f21358a.put(net.one97.paytm.hotels2.a.ag, "_amenities0_image");
            f21358a.put(net.one97.paytm.hotels2.a.ah, "promoitem");
            f21358a.put(net.one97.paytm.hotels2.a.ai, "imgSrc");
            f21358a.put(net.one97.paytm.hotels2.a.aj, "headerTitleMsg");
            f21358a.put(net.one97.travelpass.a.f30031d, "redemptionAdapter");
            f21358a.put(net.one97.travelpass.a.f30032e, "itemClickListener");
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        static final HashMap<String, Integer> f21359a;

        static {
            HashMap<String, Integer> hashMap = new HashMap<>(2);
            f21359a = hashMap;
            hashMap.put("layout/best_bottom_sheet_recharge_0", Integer.valueOf(R.layout.best_bottom_sheet_recharge));
            f21359a.put("layout/fragment_city_bus_add_money_0", Integer.valueOf(R.layout.fragment_city_bus_add_money));
        }
    }
}
