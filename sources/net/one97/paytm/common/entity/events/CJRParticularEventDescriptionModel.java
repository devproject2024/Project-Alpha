package net.one97.paytm.common.entity.events;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRParticularEventDescriptionModel extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "boxOffice")
    private CJREventPickupAddressInfo boxOffice;
    @b(a = "cities")
    private ArrayList<String> cities;
    private String citySearched;
    @b(a = "courier")
    private int courier;
    @b(a = "cp_enabled")
    private int cpEnabled;
    private String entityCity;
    @b(a = "active_from")
    private String mActiveFrom;
    @b(a = "active_to")
    private String mActiveTo;
    @b(a = "addressList")
    private ArrayList<CJRAddressDetailModel> mAddressList = new ArrayList<>();
    @b(a = "artist_label")
    private String mArtistLabel;
    @b(a = "artist")
    private List<CJREventTabDetailModel> mArtistList;
    @b(a = "categories")
    private List<CJRCategoriesDetailModel> mCategories = new ArrayList();
    @b(a = "conv_fee")
    private String mConvFee;
    @b(a = "vKey")
    private List<CJREventTabDetailModel> mCustomTabs;
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
    @b(a = "merchantId")
    private Integer mMerchantId;
    @b(a = "mul_pack")
    private int mMultiPackage;
    @b(a = "name")
    private String mName;
    @b(a = "offer_url")
    private String mOfferUrl;
    @b(a = "paytm_commission")
    private String mPaytmCommission;
    @b(a = "pdp_label")
    private String mPdpLabel;
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
    @b(a = "provider_label")
    private String mProviderLabel;
    @b(a = "provider_name")
    private String mProviderName;
    @b(a = "resources")
    private List<CJRResourceDetailModel> mResources = new ArrayList();
    @b(a = "tags")
    private String mTags;
    @b(a = "terms")
    private String mTerms;
    @b(a = "search_name")
    private String searchName;
    @b(a = "seatMap")
    private Integer seatMap;
    @b(a = "seats_io_id")
    private int seats_io_id;
    @b(a = "svgUrl")
    private String svgUrl;
    @b(a = "zoom")
    private int zoom;

    public static long getSerialVersionUID() {
        return 1;
    }

    public int getSeatsIoId() {
        return this.seats_io_id;
    }

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

    public Integer getSeatMap() {
        return this.seatMap;
    }

    public void setSeatMap(Integer num) {
        this.seatMap = num;
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

    public String getmProviderLabel() {
        return this.mProviderLabel;
    }

    public void setmProviderLabel(String str) {
        this.mProviderLabel = str;
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

    public String getPdpLabel() {
        return this.mPdpLabel;
    }

    public void setPdpLabel(String str) {
        this.mPdpLabel = str;
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

    public ArrayList<CJRAddressDetailModel> getmAddressList() {
        return this.mAddressList;
    }

    public void setmAddressList(ArrayList<CJRAddressDetailModel> arrayList) {
        this.mAddressList = arrayList;
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

    public List<CJREventTabDetailModel> getArtistList() {
        return this.mArtistList;
    }

    public List<CJREventTabDetailModel> getCustomTabs() {
        return this.mCustomTabs;
    }

    public String getArtistLabel() {
        return this.mArtistLabel;
    }

    public String getmOfferUrl() {
        return this.mOfferUrl;
    }

    public void setmOfferUrl(String str) {
        this.mOfferUrl = str;
    }

    public Integer getmMerchantId() {
        return this.mMerchantId;
    }

    public void setmMerchantId(Integer num) {
        this.mMerchantId = num;
    }

    public int getmMultiPackage() {
        return this.mMultiPackage;
    }

    public void setmMultiPackage(int i2) {
        this.mMultiPackage = i2;
    }

    public boolean isZoomable() {
        return this.zoom == 1;
    }

    public int getCourier() {
        return this.courier;
    }

    public void setCourier(int i2) {
        this.courier = i2;
    }

    public CJREventPickupAddressInfo getBoxOffice() {
        return this.boxOffice;
    }

    public void setBoxOffice(CJREventPickupAddressInfo cJREventPickupAddressInfo) {
        this.boxOffice = cJREventPickupAddressInfo;
    }

    public int getCpEnabled() {
        return this.cpEnabled;
    }

    public String getSearchName() {
        return this.searchName;
    }

    public ArrayList<String> getCities() {
        return this.cities;
    }

    public String getSvgUrl() {
        return this.svgUrl;
    }
}
