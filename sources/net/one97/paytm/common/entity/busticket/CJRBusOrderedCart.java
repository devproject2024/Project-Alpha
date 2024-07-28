package net.one97.paytm.common.entity.busticket;

import android.graphics.Bitmap;
import com.google.gson.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRAction;
import net.one97.paytm.common.entity.shopping.CJRAttribute;
import net.one97.paytm.common.entity.shopping.CJRCards;
import net.one97.paytm.common.entity.shopping.CJRCashback;
import net.one97.paytm.common.entity.shopping.CJRFullFillmentObject;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryStatusFlow;
import net.one97.paytm.common.entity.shopping.CJROrderSummarySubscription;
import net.one97.paytm.common.entity.shopping.CJROtherTaxes;
import net.one97.paytm.common.entity.shopping.CJRReverseItemInfo;
import net.one97.paytm.common.entity.shopping.CJRTaxData;
import net.one97.paytm.common.entity.shopping.CJRTrackingParams;
import net.one97.paytm.common.entity.shopping.CJRZeroEMIItemInfo;

public class CJRBusOrderedCart extends IJRPaytmDataModel implements IJRDataModel {
    public static final String ORDER_ITEM_STATUS_CANCELED = "18";
    public static final String ORDER_ITEM_STATUS_FAILED = "6";
    public static final String ORDER_ITEM_STATUS_IMPS_ENABLED_FAILED = "34";
    public static final String ORDER_ITEM_STATUS_PENDING_1 = "1";
    public static final String ORDER_ITEM_STATUS_PENDING_13 = "13";
    public static final String ORDER_ITEM_STATUS_PENDING_15 = "15";
    public static final String ORDER_ITEM_STATUS_PENDING_2 = "2";
    public static final String ORDER_ITEM_STATUS_PENDING_22 = "22";
    public static final String ORDER_ITEM_STATUS_SUCCESS = "7";
    private static final long serialVersionUID = 1;
    @b(a = "zeroEMIItemInfo")
    private CJRZeroEMIItemInfo CJRZeroEMIItemInfo;
    public final String TAG_RECHARGE_NUMBER = "recharge_number";
    public final String TAG_RECHARGE_PRICE = "price";
    @b(a = "attributes")
    private CJRAttribute attributes;
    @b(a = "refund")
    @a
    private CJRBusRefundModel busRefundModel;
    @b(a = "card")
    private CJRCards cards;
    @b(a = "cashback_text")
    private String cashBackText;
    @b(a = "cashback_credited_text")
    private String cashbackDescription;
    @b(a = "child_item_id")
    private long childItemId;
    @b(a = "child_order_id")
    private long childOrderId;
    @b(a = "cashback_credited")
    private double creditedCashBack;
    @b(a = "delivery_type")
    private int deliveryType;
    @b(a = "failure_actions")
    private ArrayList<CJRAction> errorActions;
    @b(a = "hasReplacement")
    private int hasReplacement;
    private boolean isAllItemsSelected = false;
    @b(a = "isExchangeForwardItem")
    private int isExchangeForwardItem;
    private boolean isNPSRequested;
    private boolean isNPSTracked;
    @b(a = "is_pfa")
    private int isPFA;
    @b(a = "isReplacement")
    private int isReplacement;
    @b(a = "return_flow")
    private boolean isReturnFlow;
    private boolean isSellerRatingUpdatedFromCache;
    @b(a = "isZeroEMIOrder")
    private int isZeroEMIOrder;
    @b(a = "is_physical")
    private Boolean is_physical;
    @b(a = "lifafa_cashback")
    private double lifafaCashBack;
    @b(a = "cashback")
    private ArrayList<CJRCashback> lifafaCashbackModle;
    @b(a = "actions")
    private ArrayList<CJROrderSummaryAction> mAction;
    @b(a = "aggregate_item_price")
    private String mAggregateItemPrice;
    @b(a = "conv_fee")
    private String mConvFee;
    @b(a = "created_at")
    private String mCreatedAt;
    @b(a = "estimated_delivery_range")
    private ArrayList<String> mDates;
    @b(a = "discount_amount")
    private double mDiscountAmount;
    @b(a = "discount_surcharge_amount")
    private double mDiscountSurChargeAmount;
    @b(a = "discount_tax_amount")
    private double mDiscountTaxAmount;
    @b(a = "discounted_price")
    private double mDiscountedPrice;
    @b(a = "fs_name")
    private String mFSName;
    private String mFavLabelId;
    @b(a = "fulfillment_id")
    private long mFulfillmentId;
    @b(a = "fulfillment_info")
    private String mFulfillmentInfo;
    @b(a = "fulfillment_response")
    private String mFulfillmentResponse;
    @b(a = "fulfillment_sku")
    private String mFulfillmentSKU;
    @b(a = "fulfillment_status")
    private String mFulfillmentStatus;
    @b(a = "fulfillment")
    private CJRFullFillmentObject mFullFillmentOject;
    @b(a = "id")
    private long mId;
    @b(a = "info")
    private String mInfo;
    @b(a = "item_status")
    private String mItemStatus;
    @b(a = "mrp")
    private double mMRP;
    @b(a = "max_extend_sla")
    private int mMaxExtSLA;
    @b(a = "merchant_address")
    private HashMap<String, String> mMerchantAdress;
    @b(a = "merchant_id")
    private long mMerchantId;
    @b(a = "message")
    private String mMessage;
    @b(a = "meta_data")
    public Object mMetaDataResponse;
    private Bitmap mMovieMosterBitmap;
    @b(a = "name")
    private String mName;
    private String mOrderId;
    @b(a = "price")
    private double mPrice;
    @b(a = "price_incl_tax")
    private double mPriceInclTax;
    @b(a = "product")
    private CJROrderSummaryProductDetail mProductDetail;
    @b(a = "product_id")
    private long mProductId;
    @b(a = "promo_code")
    private String mPromoCode;
    @b(a = "promo_description")
    private String mPromoDescription;
    @b(a = "promo_text")
    private String mPromoText;
    @b(a = "qty_canceled")
    private int mQtyCanceled;
    @b(a = "qty_invoiced")
    private int mQtyInvoiced;
    @b(a = "qty_ordered")
    private int mQtyOrdered;
    @b(a = "qty_refunded")
    private int mQtyRefunded;
    @b(a = "qty_shipped")
    private int mQtyShipped;
    @b(a = "quantity")
    private int mQuantity;
    private String mRatingFromCache;
    @b(a = "configuration")
    private Map<String, String> mRechargeConfiguration;
    @b(a = "repeat")
    private boolean mRepeat;
    @b(a = "retry")
    private boolean mRetry;
    @b(a = "sku")
    private String mSKU;
    @b(a = "selling_price")
    private double mSellingPrice;
    @b(a = "shipping_amount")
    private String mShippingCharge;
    @b(a = "status")
    private String mStatus;
    @b(a = "status_flow")
    private ArrayList<CJROrderSummaryStatusFlow> mStatusFlow;
    @b(a = "status_text")
    private String mStatusText;
    @b(a = "status_text_image")
    private String mStatusTextImage;
    @b(a = "subtotal_incl_tax")
    private double mSubInclTotal;
    @b(a = "subtotal")
    private double mSubTotal;
    @b(a = "subscription")
    private CJROrderSummarySubscription mSubscription;
    @b(a = "tap_action")
    private CJROrderSummaryAction mTapAction;
    private String mTapActionLabel;
    private String mTapActionMessage;
    private ArrayList<CJROrderSummaryAction> mTapActions;
    @b(a = "tax_amount")
    private double mTaxAmount;
    @b(a = "tax_data")
    private CJRTaxData mTaxData;
    @b(a = "title")
    private String mTitle;
    @b(a = "total_price")
    private double mTotalPrice;
    @b(a = "updated_at")
    private String mUpdatedAt;
    @b(a = "vertical_id")
    private long mVerticalId;
    @b(a = "other_taxes")
    private ArrayList<CJROtherTaxes> otherTaxes;
    @b(a = "parent_item_id")
    private long parentItemId;
    @b(a = "parent_order_id")
    private long parentOrderId;
    @b(a = "pp_logo_url")
    private String ppLogoUrl;
    @b(a = "refund_amount")
    private double refundAmount;
    @b(a = "refund_source_text")
    private String refundSourceText;
    @b(a = "reverseItemInfo")
    private CJRReverseItemInfo reverseItemInfo;
    @b(a = "statusCode")
    private String statusCode;
    private ArrayList<CJROrderSummaryAction> tapActionList;
    @b(a = "total_cashback")
    private double totalCashBack;
    @b(a = "tracking_params")
    private CJRTrackingParams trackingParams;
    private int version = 0;

    public String getStatusTextImage() {
        return this.mStatusTextImage;
    }

    public String getStatusText() {
        return this.mStatusText;
    }

    public void setStatusText(String str) {
        this.mStatusText = str;
    }

    public Boolean getIs_physical() {
        Boolean bool = this.is_physical;
        return Boolean.valueOf(bool != null && bool.booleanValue());
    }

    public void setIs_physical(Boolean bool) {
        this.is_physical = bool;
    }

    public int getIsExchangeForwardItem() {
        return this.isExchangeForwardItem;
    }

    public CJRReverseItemInfo getReverseItemInfo() {
        return this.reverseItemInfo;
    }

    public boolean getIsRetry() {
        return this.mRetry;
    }

    public boolean getIsRepeat() {
        return this.mRepeat;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public double getPrice() {
        return this.mPrice;
    }

    public double getDiscountedPrice() {
        return this.mDiscountedPrice;
    }

    public int getQuantity() {
        return this.mQuantity;
    }

    public String getPromoText() {
        return this.mPromoText;
    }

    public int getIsZeroEMIOrder() {
        return this.isZeroEMIOrder;
    }

    public CJRZeroEMIItemInfo getCJRZeroEMIItemInfo() {
        return this.CJRZeroEMIItemInfo;
    }

    public String getCashBackText() {
        return this.cashBackText;
    }

    public double getLifafaCashBack() {
        return this.lifafaCashBack;
    }

    public ArrayList<CJRCashback> getLifafaCashbackModle() {
        return this.lifafaCashbackModle;
    }

    public double getTotalCashBack() {
        return this.totalCashBack;
    }

    public double getCreditedCashBack() {
        return this.creditedCashBack;
    }

    public double getRefundAmount() {
        return this.refundAmount;
    }

    public Map<String, String> getRechargeConfiguration() {
        return this.mRechargeConfiguration;
    }

    public void setTapActionMessage(String str) {
        this.mTapActionMessage = str;
    }

    public String getTapActionMessage() {
        return this.mTapActionMessage;
    }

    public ArrayList<CJRAction> getErrorActions() {
        ArrayList<CJRAction> arrayList = this.errorActions;
        if (arrayList != null) {
            Iterator<CJRAction> it2 = arrayList.iterator();
            while (it2.hasNext()) {
                it2.next().setError(true);
            }
        }
        return this.errorActions;
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public ArrayList<CJROrderSummaryAction> getAction() {
        return this.mAction;
    }

    public void setAction(ArrayList<CJROrderSummaryAction> arrayList) {
        this.mAction = arrayList;
    }

    public ArrayList<CJROrderSummaryAction> getTapActions() {
        return this.mTapActions;
    }

    public void setTapActions(ArrayList<CJROrderSummaryAction> arrayList) {
        this.mTapActions = arrayList;
    }

    public CJROrderSummaryAction getTapAction() {
        return this.mTapAction;
    }

    public CJROrderSummaryProductDetail getProductDetail() {
        return this.mProductDetail;
    }

    public long getId() {
        return this.mId;
    }

    public long getProductId() {
        return this.mProductId;
    }

    public long getVerticalId() {
        return this.mVerticalId;
    }

    public long getMerchantId() {
        return this.mMerchantId;
    }

    public String getSKU() {
        return this.mSKU;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public void setStatus(String str) {
        this.mStatus = str;
    }

    public String getItemStatus() {
        return this.mItemStatus;
    }

    public double getQtyOrdered() {
        return (double) this.mQtyOrdered;
    }

    public double getQtyInvoiced() {
        return (double) this.mQtyInvoiced;
    }

    public double getQtyShipped() {
        return (double) this.mQtyShipped;
    }

    public double getQtyRefunded() {
        return (double) this.mQtyRefunded;
    }

    public double getQtyCanceled() {
        return (double) this.mQtyCanceled;
    }

    public long getFulfillmentId() {
        return this.mFulfillmentId;
    }

    public String getFulfillmentSKU() {
        return this.mFulfillmentSKU;
    }

    public String getFulfillmentStatus() {
        return this.mFulfillmentStatus;
    }

    public String getFulfillmentInfo() {
        return this.mFulfillmentInfo;
    }

    public String getFulfillmentResponse() {
        return this.mFulfillmentResponse;
    }

    public String getPromoCode() {
        return this.mPromoCode;
    }

    public String getPromoDescription() {
        return this.mPromoDescription;
    }

    public double getMRP() {
        return this.mMRP;
    }

    public void setUpdateTravellersList(ArrayList<CJROrderSummaryAction> arrayList) {
        this.tapActionList = arrayList;
    }

    public ArrayList<CJROrderSummaryAction> getUpdatedTravellersList() {
        return this.tapActionList;
    }

    public double getPriceInclTax() {
        return this.mPriceInclTax;
    }

    public double getTaxAmount() {
        return this.mTaxAmount;
    }

    public String getConvFee() {
        return this.mConvFee;
    }

    public double getDiscountAmount() {
        return this.mDiscountAmount;
    }

    public double getDiscountTaxAmount() {
        return this.mDiscountTaxAmount;
    }

    public double getDiscountSurChargeAmount() {
        return this.mDiscountSurChargeAmount;
    }

    public double getSubTotal() {
        return this.mSubTotal;
    }

    public double getSubInclTotal() {
        return this.mSubInclTotal;
    }

    public double getSellingPrice() {
        return this.mSellingPrice;
    }

    public void setCreatedAt(String str) {
        this.mCreatedAt = str;
    }

    public String getCreatedAt() {
        return this.mCreatedAt;
    }

    public String getUpdatedAt() {
        return this.mUpdatedAt;
    }

    public String getInfo() {
        return this.mInfo;
    }

    public double getTotalPrice() {
        return this.mTotalPrice;
    }

    public boolean equals(Object obj) {
        try {
            return this.mName.equalsIgnoreCase(((CJRBusOrderedCart) obj).mName);
        } catch (Exception unused) {
            return false;
        }
    }

    public ArrayList<CJROrderSummaryStatusFlow> getStatusFlow() {
        return this.mStatusFlow;
    }

    public String getRechargeNumber() {
        return this.mRechargeConfiguration.containsKey("recharge_number") ? this.mRechargeConfiguration.get("recharge_number") : "";
    }

    public String getRechargePrice() {
        return this.mRechargeConfiguration.containsKey("price") ? this.mRechargeConfiguration.get("price") : "";
    }

    public String getFSName() {
        return this.mFSName;
    }

    public CJROrderSummarySubscription getSubscription() {
        return this.mSubscription;
    }

    public String getFavouriteLabelId() {
        return this.mFavLabelId;
    }

    public void setFavouriteLabelId(String str) {
        this.mFavLabelId = str;
    }

    public boolean getIsSellerRatingUpdatedFromCache() {
        return this.isSellerRatingUpdatedFromCache;
    }

    public void setIsSellerRatingUpdatedFromCache(boolean z) {
        this.isSellerRatingUpdatedFromCache = z;
    }

    public String getSellerRatingFromCache() {
        return this.mRatingFromCache;
    }

    public void setSellerRatingFromCache(String str) {
        this.mRatingFromCache = str;
    }

    public CJRFullFillmentObject getFullFillmentOject() {
        return this.mFullFillmentOject;
    }

    public void setFullFillmentOject(CJRFullFillmentObject cJRFullFillmentObject) {
        this.mFullFillmentOject = cJRFullFillmentObject;
    }

    public Object getMetaDataResponse() {
        return this.mMetaDataResponse;
    }

    public void setMetaDataResponse(Object obj) {
        this.mMetaDataResponse = obj;
    }

    public HashMap<String, String> getMerchantAdress() {
        return this.mMerchantAdress;
    }

    public CJRTaxData getTaxData() {
        return this.mTaxData;
    }

    public void setTaxData(CJRTaxData cJRTaxData) {
        this.mTaxData = cJRTaxData;
    }

    public String getPpLogoUrl() {
        return this.ppLogoUrl;
    }

    public int getIsPFA() {
        return this.isPFA;
    }

    public int getDeliveryType() {
        return this.deliveryType;
    }

    public CJRAttribute getAttributes() {
        return this.attributes;
    }

    public boolean isReplacement() {
        return this.isReplacement == 1;
    }

    public boolean hasReplacement() {
        return this.hasReplacement == 1;
    }

    public long getParentOrderId() {
        return this.parentOrderId;
    }

    public long getParentItemId() {
        return this.parentItemId;
    }

    public long getChildOrderId() {
        return this.childOrderId;
    }

    public long getChildItemId() {
        return this.childItemId;
    }

    public ArrayList<String> getDates() {
        return this.mDates;
    }

    public String getmEstimatedDelivery() {
        String str;
        String str2 = null;
        if (getDates() == null || getDates().size() <= 0) {
            return null;
        }
        String str3 = new String();
        if (getDates().get(1) != null) {
            str = getDates().get(1);
            if (str.contains("T")) {
                str = str.substring(0, str.indexOf("T"));
            }
        } else {
            str = null;
        }
        if (getDates().get(0) != null) {
            str2 = getDates().get(0);
            if (str2.contains("T")) {
                str2 = str2.substring(0, str2.indexOf("T"));
            }
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("MMM");
        if (str2 == null || str == null) {
            return str3;
        }
        try {
            Date parse = simpleDateFormat.parse(str);
            Date parse2 = simpleDateFormat.parse(str2);
            Calendar instance = Calendar.getInstance();
            instance.setTime(parse2);
            Integer valueOf = Integer.valueOf(instance.get(5));
            String format = simpleDateFormat2.format(instance.getTime());
            instance.setTime(parse);
            Integer valueOf2 = Integer.valueOf(instance.get(5));
            String format2 = simpleDateFormat2.format(instance.getTime());
            if (format2.equals(format)) {
                return str3 + valueOf + "-" + valueOf2 + " " + format2;
            }
            return str3 + valueOf + " " + format + "-" + valueOf2 + " " + format2;
        } catch (Exception unused) {
            return str3;
        }
    }

    public String getShippingCharge() {
        return this.mShippingCharge;
    }

    public ArrayList<CJROtherTaxes> getOtherTaxes() {
        return this.otherTaxes;
    }

    public String getTapActionLabel() {
        return this.mTapActionLabel;
    }

    public void setTapActionLabel(String str) {
        this.mTapActionLabel = str;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int i2) {
        this.version = i2;
    }

    public String getAggregateItemPrice() {
        return this.mAggregateItemPrice;
    }

    public String getstatusCode() {
        return this.statusCode;
    }

    public boolean isNPSTracked() {
        return this.isNPSTracked;
    }

    public void setNPSTracked(boolean z) {
        this.isNPSTracked = z;
    }

    public boolean getIsNPSRequested() {
        return this.isNPSRequested;
    }

    public void setIsNPSRequested(boolean z) {
        this.isNPSRequested = z;
    }

    public Bitmap getMovieMosterBitmap() {
        return this.mMovieMosterBitmap;
    }

    public void setMovieMosterBitmap(Bitmap bitmap) {
        this.mMovieMosterBitmap = bitmap;
    }

    public String getOrderId() {
        return this.mOrderId;
    }

    public void setOrderId(String str) {
        this.mOrderId = str;
    }

    public void setAllItemsSelected(boolean z) {
        this.isAllItemsSelected = z;
    }

    public boolean isAllItemsSelected() {
        return this.isAllItemsSelected;
    }

    public CJRCards getCards() {
        return this.cards;
    }

    public int getMaxExtSLA() {
        return this.mMaxExtSLA;
    }

    public CJRBusRefundModel getBusRefundModel() {
        return this.busRefundModel;
    }

    public void setBusRefundModel(CJRBusRefundModel cJRBusRefundModel) {
        this.busRefundModel = cJRBusRefundModel;
    }

    public CJRTrackingParams getTrackingParams() {
        return this.trackingParams;
    }

    public boolean isReturnFlow() {
        return this.isReturnFlow;
    }

    public String getCashbackDescription() {
        return this.cashbackDescription;
    }

    public void setRefundSourceText(String str) {
        this.refundSourceText = str;
    }

    public String getRefundSourceText() {
        return this.refundSourceText;
    }
}
