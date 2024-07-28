package net.one97.paytm.utils.b;

import net.one97.paytm.core.R;

public enum a {
    MOBILE_RECHARGE(1, R.string.activate_mobile_recharge, "https://assetscdn.paytm.com/images/catalog/wallet/ic_mobile.png", R.string.cash_back_recharge_now, "paytmmp://mobile_prepaid?url=https://catalog.paytm.com/v1/mobile/mobile-prepaid/17", 17),
    DTH_RECHARGE(2, R.string.activate_dth_recharge, "https://assetscdn.paytm.com/images/catalog/wallet/ic_dth.png", R.string.cash_back_recharge_now, "paytmmp://dth?url=https://catalog.paytm.com/v1/mobile/DTH/18", 18),
    METRO_RECHARGE(3, R.string.activate_metro_recharge, "https://assetscdn.paytm.com/images/catalog/wallet/ic_metro.png", R.string.cash_back_recharge_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/77409", 77409),
    ELECTRICITY_BILL_PAYMENT(4, R.string.activate_bill_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_electricity.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/26", 26),
    PAY_USING_UPI(5, R.string.activate_upi_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_pay_upi.png", R.string.cash_back_pay_now, "paytmmp://upi_landing", 0),
    PAY_USING_UPI_6(6, R.string.activate_upi_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_pay_upi.png", R.string.cash_back_pay_now, "paytmmp://upi_landing", 0),
    PAY_USING_UPI_7(7, R.string.activate_upi_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_pay_upi.png", R.string.cash_back_send_money, "paytmmp://upi_landing", 0),
    SCAN_PAY(8, R.string.activate_scan_pay, "https://assetscdn.paytm.com/images/catalog/wallet/ic_scan.png", R.string.cash_back_pay_now, "paytmmp://cash_wallet", 0),
    PAY_USING_PAYTM_BANK(9, R.string.activate_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_bank.png", R.string.cash_back_pay_now, "paytmmp://payment_bank?featuretype=bank_landing", 0),
    SEND_MONEY(10, R.string.activate_send_money, "https://assetscdn.paytm.com/images/catalog/wallet/ic_pay.png", R.string.cash_back_send_money, "paytmmp://cash_wallet", 0),
    RECHARGE_OFFER(11, R.string.activate_recharge, "https://assetscdn.paytm.com/images/catalog/wallet/ic_recharges.png", R.string.cash_back_recharge_now, "paytmmp://", 0),
    BILL_PAYMENT(12, R.string.activate_bill_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_bill_payments.png", R.string.cash_back_pay_now, "paytmmp://", 0),
    RECHARGE_BILL_PAYMENT(13, R.string.activate_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_recharges_bill_payments.png", R.string.cash_back_pay_now, "paytmmp://", 0),
    LANDLINE_BILL_PAYMENT(14, R.string.activate_bill_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_landline.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/75505", 75505),
    FEE_PAYMENT(15, R.string.activate_fee_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_fees.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/46007", 46007),
    LOAN_EMI_PAYMENT(16, R.string.activate_emi_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_loan.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/37217", 37217),
    MUNICIPAL_PAYMENT(17, R.string.activate_municipal_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_mubnicipal.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v2/mobile/getproductlist/107730", 107730),
    FUEL_PAYMENT(18, R.string.activate_fuel_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_petrol.png", R.string.cash_back_pay_now, "paytmmp://cash_wallet", 0),
    INSURANCE_PREMIUM_PAYMENT(19, R.string.activate_premium_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_insurance.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/64739", 64739),
    DATA_CARD_RECHARGE(20, R.string.activate_data_card_recharge, "https://assetscdn.paytm.com/images/catalog/wallet/ic_datacard.png", R.string.cash_back_pay_now, "paytmmp://datacard-prepaid?url=https://catalog.paytm.com/v1/mobile/datacard-prepaid/19", 19),
    WATER_BILL_PAYMENT(21, R.string.activate_water_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_water.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/68869", 68869),
    GAS_BILL_PAYMENT(22, R.string.activate_gas_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_gas.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/78640", 78640),
    PAYTM_GOLD(23, R.string.activate_gold_purchase, "https://assetscdn.paytm.com/images/catalog/wallet/group_58.png", R.string.cash_back_buy_now, "paytmmp://digital-gold", 0),
    BROADBAND_BILL_PAYMENT(24, R.string.activate_bill_payment, "https://assetscdn.paytm.com/images/catalog/wallet/ic_broadband.png", R.string.cash_back_pay_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/75505", 75505),
    TOLL_TAG_RECHARGE(25, R.string.activate_toll_tag_recharge, "https://assetscdn.paytm.com/images/catalog/wallet/ic_fastag.png", R.string.cash_back_recharge_now, "paytmmp://utility?url=https://catalog.paytm.com/v1/mobile/getproductlist/100253", 100253),
    MOVIE_TICKETS(26, R.string.activate_movie_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_movies.png", R.string.cash_back_book_now, "paytmmp://movietickets", 80491),
    TRAIN_TICKETS(27, R.string.activate_train_tkt_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_train.png", R.string.cash_back_book_now, "paytmmp://trainticket", 82653),
    BUS_TICKETS(28, R.string.activate_bus_tkt_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_bus.png", R.string.cash_back_book_now, "paytmmp://busticket", 25173),
    FLIGHT_TICKETS(29, R.string.activate_flight_tkt_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_flights.png", R.string.cash_back_book_now, "paytmmp://flightticket", 69089),
    EVENT_TICKETS(30, R.string.activate_event_tkt_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_events.png", R.string.cash_back_book_now, "paytmmp://events", 0),
    HOTEL_BOOKING(31, R.string.activate_hotel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_hotels.png", R.string.cash_back_book_now, "paytmmp://hotel-booking", 0),
    TRAVEL_OFFERS(32, R.string.activate_travel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_travel.png", R.string.cash_back_book_now, "paytmmp://", 0),
    OTHERS(33, R.string.activate_payment_using_paytm, "https://assetscdn.paytm.com/images/catalog/wallet/ic_scan.png", 0, "", 0),
    WALLET_ADD_MONEY(34, R.string.activate_travel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_travel.png", R.string.cash_back_book_now, "paytmmp://", 0),
    DONATIONS(35, R.string.activate_travel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_travel.png", R.string.cash_back_book_now, "paytmmp://", 132935),
    APARTMENT(36, R.string.activate_travel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_travel.png", R.string.cash_back_book_now, "paytmmp://", 101950),
    CREDIR_CARD(37, R.string.activate_travel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_travel.png", R.string.cash_back_book_now, "paytmmp://", 156705),
    P2B(38, R.string.activate_travel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_travel.png", R.string.cash_back_book_now, "paytmmp://", 0),
    GIFT_VOUCHER(39, R.string.activate_travel_booking, "https://assetscdn.paytm.com/images/catalog/wallet/ic_travel.png", R.string.cash_back_book_now, "paytmmp://", 0);
    
    public static final C1408a Companion = null;
    private final int activatScreenCtaID;
    private final int categoryId;
    private final String deeplink;
    private final int id;
    private final String image;
    private final int progressCTAId;

    private a(int i2, int i3, String str, int i4, String str2, int i5) {
        this.id = i2;
        this.activatScreenCtaID = i3;
        this.image = str;
        this.progressCTAId = i4;
        this.deeplink = str2;
        this.categoryId = i5;
    }

    public final int getId() {
        return this.id;
    }

    public final int getActivatScreenCtaID() {
        return this.activatScreenCtaID;
    }

    public final String getImage() {
        return this.image;
    }

    public final int getProgressCTAId() {
        return this.progressCTAId;
    }

    public final String getDeeplink() {
        return this.deeplink;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    static {
        Companion = new C1408a((byte) 0);
    }

    /* renamed from: net.one97.paytm.utils.b.a$a  reason: collision with other inner class name */
    public static final class C1408a {
        private C1408a() {
        }

        public /* synthetic */ C1408a(byte b2) {
            this();
        }
    }
}
