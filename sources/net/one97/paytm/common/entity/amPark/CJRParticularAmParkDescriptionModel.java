package net.one97.paytm.common.entity.amPark;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.amPark.CJRAmParkDateTimeModel;

public class CJRParticularAmParkDescriptionModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "buyLabel")
    private String buyLabel;
    private String citySearched;
    private String entityCity;
    @b(a = "active_from")
    private String mActiveFrom;
    @b(a = "active_to")
    private String mActiveTo;
    @b(a = "address")
    private CJRAddressDetailModel mAddress;
    @b(a = "categories")
    private List<CJRCategoriesDetailModel> mCategories = new ArrayList();
    @b(a = "conv_fee")
    private String mConvFee;
    private Map<String, List<CJRSeatDetailsModel>> mDateTimeToSeatListMap;
    private Map<String, List<CJRAmParkDateTimeModel.Time>> mDateToTimeListMap;
    @b(a = "description")
    private String mDescription;
    @b(a = "form")
    private String mForm;
    @b(a = "id")
    private String mId;
    @b(a = "instructions")
    private String mInstructions;
    @b(a = "inventory")
    private String mInventory;
    @b(a = "park_rides")
    private ArrayList<CJRParkRidesDetailModel> mMajorAttractions = new ArrayList<>();
    @b(a = "merchantId")
    private Integer mMerchantId;
    @b(a = "mul_pack")
    private int mMultiPackage;
    @b(a = "name")
    private String mName;
    @b(a = "offer_url")
    private String mOfferUrl;
    @b(a = "parkDateTime")
    private List<CJRAmParkDateTimeModel> mParkDateTimeList = new ArrayList();
    @b(a = "paytm_commission")
    private String mPaytmCommission;
    @b(a = "pg_charges")
    private String mPgCharges;
    @b(a = "price")
    private String mPrice;
    @b(a = "product_id")
    private String mProductId;
    @b(a = "provider_event_id")
    private String mProviderEventId;
    @b(a = "provider_id")
    private String mProviderId;
    @b(a = "provider_name")
    private String mProviderName;
    @b(a = "resources")
    private List<CJRResourceDetailModel> mResources = new ArrayList();
    @b(a = "seatMap")
    private Integer mSeatMap;
    @b(a = "tags")
    private String mTags;
    @b(a = "terms")
    private String mTerms;
    @b(a = "rideLabel")
    private String rideLabel;
    @b(a = "venueLabel")
    private String venueLabel;

    public String getId() {
        return this.mId;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getProviderEventId() {
        return this.mProviderEventId;
    }

    public void setProviderEventId(String str) {
        this.mProviderEventId = str;
    }

    public String getActiveFrom() {
        return this.mActiveFrom;
    }

    public void setActiveFrom(String str) {
        this.mActiveFrom = str;
    }

    public String getActiveTo() {
        return this.mActiveTo;
    }

    public void setActiveTo(String str) {
        this.mActiveTo = str;
    }

    public String getPrice() {
        return this.mPrice;
    }

    public void setPrice(String str) {
        this.mPrice = str;
    }

    public String getInventory() {
        return this.mInventory;
    }

    public void setInventory(String str) {
        this.mInventory = str;
    }

    public String getConvFee() {
        return this.mConvFee;
    }

    public void setConvFee(String str) {
        this.mConvFee = str;
    }

    public String getPgCharges() {
        return this.mPgCharges;
    }

    public void setPgCharges(String str) {
        this.mPgCharges = str;
    }

    public String getPaytmCommission() {
        return this.mPaytmCommission;
    }

    public void setPaytmCommission(String str) {
        this.mPaytmCommission = str;
    }

    public String getTags() {
        return this.mTags;
    }

    public void setTags(String str) {
        this.mTags = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getInstructions() {
        return this.mInstructions;
    }

    public void setInstructions(String str) {
        this.mInstructions = str;
    }

    public String getForm() {
        return this.mForm;
    }

    public void setForm(String str) {
        this.mForm = str;
    }

    public String getTerms() {
        return this.mTerms;
    }

    public void setTerms(String str) {
        this.mTerms = str;
    }

    public String getProviderId() {
        return this.mProviderId;
    }

    public void setProviderId(String str) {
        this.mProviderId = str;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public void setProviderName(String str) {
        this.mProviderName = str;
    }

    public String getProductId() {
        return this.mProductId;
    }

    public void setProductId(String str) {
        this.mProductId = str;
    }

    public List<CJRCategoriesDetailModel> getCategories() {
        return this.mCategories;
    }

    public void setCategories(List<CJRCategoriesDetailModel> list) {
        this.mCategories = list;
    }

    public List<CJRResourceDetailModel> getResources() {
        return this.mResources;
    }

    public void setResources(List<CJRResourceDetailModel> list) {
        this.mResources = list;
    }

    public CJRAddressDetailModel getmAddress() {
        return this.mAddress;
    }

    public void setmAddress(CJRAddressDetailModel cJRAddressDetailModel) {
        this.mAddress = cJRAddressDetailModel;
    }

    public List<CJRAmParkDateTimeModel> getmParkDateTimeList() {
        return this.mParkDateTimeList;
    }

    public void setmParkDateTimeList(List<CJRAmParkDateTimeModel> list) {
        this.mParkDateTimeList = list;
    }

    public ArrayList<CJRParkRidesDetailModel> getmMajorAttractions() {
        return this.mMajorAttractions;
    }

    public String getEntityCity() {
        return this.entityCity;
    }

    public void setEntityCity(String str) {
        this.entityCity = str;
    }

    public String getCitySearched() {
        return this.citySearched;
    }

    public void setCitySearched(String str) {
        this.citySearched = str;
    }

    public int getmMultiPackage() {
        return this.mMultiPackage;
    }

    public void setmMultiPackage(int i2) {
        this.mMultiPackage = i2;
    }

    public Map<String, List<CJRSeatDetailsModel>> getDateTimeToSeatListMap() {
        if (this.mDateTimeToSeatListMap == null) {
            this.mDateTimeToSeatListMap = extractDateTimeToSeatListMap(this.mParkDateTimeList);
        }
        return this.mDateTimeToSeatListMap;
    }

    public Map<String, List<CJRAmParkDateTimeModel.Time>> getDateToTimeListMap() {
        if (this.mDateToTimeListMap == null) {
            this.mDateToTimeListMap = extractDateTimeMap(this.mParkDateTimeList);
        }
        return this.mDateToTimeListMap;
    }

    public Map<String, List<CJRSeatDetailsModel>> extractDateTimeToSeatListMap(List<CJRAmParkDateTimeModel> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (CJRAmParkDateTimeModel next : list) {
            List<String> list2 = next.getmParkDateList();
            CJRAmParkDateTimeModel.Time time = next.getmTime();
            String str = time.getmStart() + time.getmTo();
            List<CJRParkPackageDetailsModel> list3 = next.getmPackageDetailsList();
            if (list2 != null && list2.size() > 0) {
                for (String next2 : list2) {
                    if (next2 != null) {
                        String str2 = next2 + str;
                        if (hashMap.containsKey(str2)) {
                            checkAndAddCurrentSeatDetailListToSingleList(list3, (List) hashMap.get(str2));
                        } else {
                            ArrayList arrayList = new ArrayList();
                            addCurrentSeatDetailListToSingleList(list3, arrayList);
                            hashMap.put(str2, arrayList);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public HashMap<String, List<CJRAmParkDateTimeModel.Time>> extractDateTimeMap(List<CJRAmParkDateTimeModel> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        HashMap<String, List<CJRAmParkDateTimeModel.Time>> hashMap = new HashMap<>();
        for (CJRAmParkDateTimeModel next : list) {
            List<String> list2 = next.getmParkDateList();
            CJRAmParkDateTimeModel.Time time = next.getmTime();
            if (list2 != null && list2.size() > 0) {
                for (String next2 : list2) {
                    if (next2 != null) {
                        if (hashMap.containsKey(next2)) {
                            List list3 = hashMap.get(next2);
                            if (!checkIfTimeAlreadyExistsInList(time, list3)) {
                                list3.add(time);
                            }
                        } else {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(time);
                            hashMap.put(next2, arrayList);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    private boolean checkIfTimeAlreadyExistsInList(CJRAmParkDateTimeModel.Time time, List<CJRAmParkDateTimeModel.Time> list) {
        if (!(list == null || list.size() <= 0 || time == null)) {
            for (CJRAmParkDateTimeModel.Time next : list) {
                String str = next.getmStart();
                String str2 = next.getmTo();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(time.getmStart()) && !TextUtils.isEmpty(time.getmTo()) && str.equalsIgnoreCase(time.getmStart()) && str2.equalsIgnoreCase(time.getmTo())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void checkAndAddCurrentSeatDetailListToSingleList(List<CJRParkPackageDetailsModel> list, List<CJRSeatDetailsModel> list2) {
        if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
            for (CJRParkPackageDetailsModel next : list) {
                List<CJRSeatDetailsModel> list3 = next.getmParkSeatDetails();
                for (int i2 = 0; i2 < list3.size(); i2++) {
                    CJRSeatDetailsModel cJRSeatDetailsModel = list3.get(i2);
                    if (!hasSeatBeenAlreadyAdded(cJRSeatDetailsModel, list2) && cJRSeatDetailsModel.getPrice() != 0) {
                        cJRSeatDetailsModel.setmPackageId(next.getmParkPackageId());
                        cJRSeatDetailsModel.setmPackageType(next.getmParkPackageType());
                        cJRSeatDetailsModel.setmPackageDescription(next.getmParkPackageDescription());
                        cJRSeatDetailsModel.setmIndex(i2);
                        list2.add(cJRSeatDetailsModel);
                    }
                }
            }
        }
    }

    private boolean hasSeatBeenAlreadyAdded(CJRSeatDetailsModel cJRSeatDetailsModel, List<CJRSeatDetailsModel> list) {
        if (!(cJRSeatDetailsModel == null || list == null || list.size() <= 0)) {
            for (CJRSeatDetailsModel seatId : list) {
                if (seatId.getSeatId() == cJRSeatDetailsModel.getSeatId()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void addCurrentSeatDetailListToSingleList(List<CJRParkPackageDetailsModel> list, List<CJRSeatDetailsModel> list2) {
        if (list != null && list.size() > 0 && list2 != null) {
            for (CJRParkPackageDetailsModel next : list) {
                List<CJRSeatDetailsModel> list3 = next.getmParkSeatDetails();
                for (int i2 = 0; i2 < list3.size(); i2++) {
                    CJRSeatDetailsModel cJRSeatDetailsModel = list3.get(i2);
                    if (!hasSeatBeenAlreadyAdded(cJRSeatDetailsModel, list2) && cJRSeatDetailsModel.getPrice() != 0) {
                        cJRSeatDetailsModel.setmPackageId(next.getmParkPackageId());
                        cJRSeatDetailsModel.setmPackageType(next.getmParkPackageType());
                        cJRSeatDetailsModel.setmPackageDescription(next.getmParkPackageDescription());
                        cJRSeatDetailsModel.setmIndex(i2);
                        list2.add(cJRSeatDetailsModel);
                    }
                }
            }
        }
    }

    public String getmOfferUrl() {
        return this.mOfferUrl;
    }

    public void setmOfferUrl(String str) {
        this.mOfferUrl = str;
    }

    public Integer getmSeatMap() {
        return this.mSeatMap;
    }

    public void setmSeatMap(Integer num) {
        this.mSeatMap = num;
    }

    public Integer getmMerchantId() {
        return this.mMerchantId;
    }

    public void setmMerchantId(Integer num) {
        this.mMerchantId = num;
    }

    public String getRideLabel() {
        return this.rideLabel;
    }

    public void setRideLabel(String str) {
        this.rideLabel = str;
    }

    public String getVenueLabel() {
        return this.venueLabel;
    }

    public void setVenueLabel(String str) {
        this.venueLabel = str;
    }

    public String getBuyLabel() {
        return this.buyLabel;
    }

    public void setBuyLabel(String str) {
        this.buyLabel = str;
    }
}
