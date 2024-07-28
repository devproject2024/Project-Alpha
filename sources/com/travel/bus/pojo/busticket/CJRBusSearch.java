package com.travel.bus.pojo.busticket;

import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.gson.g;
import com.google.gson.internal.Excluder;
import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.f;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import com.travel.bus.pojo.CJRBusSearchOperatorInfo;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemBoardDropCount;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemBody;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemDictionary;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemFare;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemFeature;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemFlag;
import com.travel.bus.pojo.bussearch.CJRBusSearchItemMessages;
import com.travel.bus.pojo.bussearch.CJRBusSearchMetaDataV3;
import com.travel.bus.pojo.bussearch.CJRDetailedFare;
import com.travel.bus.pojo.bussearch.CJRbusSearchItemFlags;
import com.travel.bus.pojo.photos.CJRBusPhotoWrapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CJRBusSearch extends IJRPaytmDataModel {
    @b(a = "body")
    public CJRBusSearchItemBody body;
    private HashMap<Integer, Integer> mAmenityCount = new HashMap<>();
    private String mDestinationName;
    private HashMap<Integer, Integer> mOperatorTagCount = new HashMap<>();
    private String mSourceName;
    @b(a = "meta")
    private CJRBusSearchMetaDataV3 meta;
    private HashMap<String, ArrayList<Integer>> operatorGroupListMap = new HashMap<>();

    public CJRBusSearchMetaDataV3 getMeta() {
        return this.meta;
    }

    public CJRBusSearchItemBody getBody() {
        return this.body;
    }

    public HashMap<Integer, Integer> getmAmenityCount() {
        return this.mAmenityCount;
    }

    public void setmAmenityCount(HashMap<Integer, Integer> hashMap) {
        this.mAmenityCount = hashMap;
    }

    public HashMap<Integer, Integer> getmOperatorTagCount() {
        return this.mOperatorTagCount;
    }

    public void setmOperatorTagCount(HashMap<Integer, Integer> hashMap) {
        this.mOperatorTagCount = hashMap;
    }

    public void setBody(CJRBusSearchItemBody cJRBusSearchItemBody) {
        this.body = cJRBusSearchItemBody;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        CJRBusSearch cJRBusSearch = new CJRBusSearch();
        cJRBusSearch.parseJson(str, cJRBusSearch, fVar);
        return cJRBusSearch;
    }

    public void parseJson(String str, CJRBusSearch cJRBusSearch, f fVar) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        JSONObject jSONObject2 = jSONObject.getJSONObject("body");
        cJRBusSearch.meta = (CJRBusSearchMetaDataV3) new f().a(jSONObject.getJSONObject("meta").toString(), new CJRBusSearchMetaDataV3().getClass());
        this.mSourceName = cJRBusSearch.meta.getSourceCity();
        this.mDestinationName = cJRBusSearch.meta.getDestinationCity();
        CJRBusSearchItemBody cJRBusSearchItemBody = new CJRBusSearchItemBody();
        if (jSONObject2 != null && jSONObject2 != null) {
            if (!jSONObject2.isNull("dictionary")) {
                cJRBusSearchItemBody.setDictionary(getDictionaryData(jSONObject2.getJSONObject("dictionary"), fVar));
            }
            if (!jSONObject2.isNull("trips")) {
                cJRBusSearchItemBody.setTrips(getTripsData(cJRBusSearchItemBody.getDictionary().getOperators(), jSONObject2.getJSONArray("trips")));
            }
            cJRBusSearch.setBody(cJRBusSearchItemBody);
            setOperatorGroups(cJRBusSearch);
        }
    }

    public HashMap<String, ArrayList<Integer>> getOperator_groups() {
        if (this.operatorGroupListMap == null) {
            this.operatorGroupListMap = new HashMap<>();
        }
        return this.operatorGroupListMap;
    }

    private void setOperatorGroups(CJRBusSearch cJRBusSearch) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (cJRBusSearch.getBody() != null && cJRBusSearch.getBody().getDictionary() != null && cJRBusSearch.getBody().getDictionary().getOperators() != null && cJRBusSearch.getBody().getDictionary().getOperators().size() > 0) {
            for (String next : cJRBusSearch.getBody().getDictionary().getOperators().keySet()) {
                if (cJRBusSearch.getBody().getDictionary().getOperators().get(next).getIsGrouped().booleanValue()) {
                    arrayList.add(next);
                }
            }
            if (cJRBusSearch.getBody() != null && cJRBusSearch.getBody().getTrips().size() > 0) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String str = (String) it2.next();
                    for (int i2 = 0; i2 < cJRBusSearch.getBody().getTrips().size(); i2++) {
                        if (str.equals(String.valueOf(cJRBusSearch.getBody().getTrips().get(i2).getOperatorId()))) {
                            arrayList2.add(Integer.valueOf(i2));
                        }
                    }
                    this.operatorGroupListMap.put(cJRBusSearch.getBody().getDictionary().getOperators().get(str).getName(), arrayList2);
                    arrayList2.clear();
                }
            }
        }
    }

    private CJRBusSearchItemDictionary getDictionaryData(JSONObject jSONObject, f fVar) throws JSONException {
        CJRBusSearchItemDictionary cJRBusSearchItemDictionary = new CJRBusSearchItemDictionary();
        if (!jSONObject.isNull(StringSet.messages)) {
            cJRBusSearchItemDictionary.setMessages(getMessages(jSONObject.getJSONObject(StringSet.messages)));
        }
        if (!jSONObject.isNull("boarding_points")) {
            cJRBusSearchItemDictionary.setBoardingPoints(getBoardDropPoints(jSONObject.getString("boarding_points")));
        }
        if (!jSONObject.isNull("dropping_points")) {
            cJRBusSearchItemDictionary.setDroppingPoints(getBoardDropPoints(jSONObject.getString("dropping_points")));
        }
        if (!jSONObject.isNull("operator_tags")) {
            cJRBusSearchItemDictionary.setOperatorTags(getOperatorTagData(jSONObject.getString("operator_tags")));
        }
        if (!jSONObject.isNull("amenities")) {
            cJRBusSearchItemDictionary.setAmenitiesInfo(getAmenityData(jSONObject.getString("amenities")));
        }
        if (!jSONObject.isNull("operators")) {
            cJRBusSearchItemDictionary.setOperators(getOperatorData(jSONObject.getString("operators")));
        }
        if (!jSONObject.isNull("ecosystem_offers")) {
            cJRBusSearchItemDictionary.setEcosystemOffers((HashMap) fVar.a(jSONObject.getString("ecosystem_offers"), new a<HashMap<String, ArrayList<BusEcosystemOfferInfo>>>() {
            }.getType()));
        }
        if (!jSONObject.isNull("photos")) {
            f.f22810b = ((f) fVar.a(jSONObject.getString("photos"), f.class)).f22811a;
            cJRBusSearchItemDictionary.setPhotos((f) fVar.a(jSONObject.getString("photos"), f.class));
        }
        return cJRBusSearchItemDictionary;
    }

    private HashMap<String, CJRBusSearchOperatorInfo> getOperatorData(String str) throws JSONException {
        HashMap<String, CJRBusSearchOperatorInfo> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            CJRBusSearchOperatorInfo cJRBusSearchOperatorInfo = new CJRBusSearchOperatorInfo();
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(next);
            if (!jSONObject2.isNull("logo_url")) {
                cJRBusSearchOperatorInfo.setLogoUrl(jSONObject2.getString("logo_url"));
            }
            if (!jSONObject2.isNull("name")) {
                cJRBusSearchOperatorInfo.setName(jSONObject2.getString("name"));
            }
            if (!jSONObject2.isNull("internal_provider_operator_id")) {
                cJRBusSearchOperatorInfo.setInternalProviderOperatorId(Integer.valueOf(jSONObject2.getInt("internal_provider_operator_id")));
            }
            if (!jSONObject2.isNull("is_grouped")) {
                cJRBusSearchOperatorInfo.setIsGrouped(Boolean.valueOf(jSONObject2.getBoolean("is_grouped")));
            }
            if (!jSONObject2.isNull("provider_id")) {
                cJRBusSearchOperatorInfo.setProviderId(Integer.valueOf(jSONObject2.getInt("provider_id")));
            }
            if (!jSONObject2.isNull("count")) {
                cJRBusSearchOperatorInfo.setCount(Integer.valueOf(jSONObject2.getInt("count")));
            }
            hashMap.put(next, cJRBusSearchOperatorInfo);
        }
        return hashMap;
    }

    private HashMap<String, CJRBusSearchItemBoardDropCount> getBoardDropPoints(String str) throws JSONException {
        HashMap<String, CJRBusSearchItemBoardDropCount> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            CJRBusSearchItemBoardDropCount cJRBusSearchItemBoardDropCount = new CJRBusSearchItemBoardDropCount();
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(next);
            if (!jSONObject2.isNull("count")) {
                cJRBusSearchItemBoardDropCount.setCount(Integer.valueOf(jSONObject2.getInt("count")));
            }
            hashMap.put(next, cJRBusSearchItemBoardDropCount);
        }
        return hashMap;
    }

    private CJRBusSearchItemMessages getMessages(JSONObject jSONObject) throws JSONException {
        f fVar = new f();
        return (CJRBusSearchItemMessages) fVar.a(fVar.a((Object) jSONObject), CJRBusSearchItemMessages.class);
    }

    private ArrayList<CJRDetailedFare> getDetailedFare(String str) {
        g gVar = new g();
        Excluder a2 = gVar.f39463a.clone();
        a2.f39477e = true;
        gVar.f39463a = a2;
        gVar.a();
        return new ArrayList<>(Arrays.asList((Object[]) new f().a(str, CJRDetailedFare[].class)));
    }

    private ArrayList<CJRBusSearchItem> getTripsData(HashMap<String, CJRBusSearchOperatorInfo> hashMap, JSONArray jSONArray) throws JSONException {
        ArrayList<CJRBusSearchItem> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            CJRBusSearchItem cJRBusSearchItem = new CJRBusSearchItem();
            JSONObject jSONObject = jSONArray.getJSONObject(i2);
            if (jSONObject.has("detailed_fare")) {
                cJRBusSearchItem.setDetailedFare(getDetailedFare(jSONObject.getJSONArray("detailed_fare").toString()));
            }
            cJRBusSearchItem.setSource(this.mSourceName);
            cJRBusSearchItem.setDestination(this.mDestinationName);
            if (!jSONObject.isNull("available_seats")) {
                cJRBusSearchItem.setAvailableSeats(Integer.valueOf(jSONObject.getInt("available_seats")));
            }
            if (!jSONObject.isNull("total_seats")) {
                cJRBusSearchItem.setTotalSeats(Integer.valueOf(jSONObject.getInt("total_seats")));
            }
            if (!jSONObject.isNull("provider_operator_name")) {
                cJRBusSearchItem.setProviderOperatorName(jSONObject.getString("provider_operator_name"));
            }
            if (!jSONObject.isNull("ratings_source")) {
                cJRBusSearchItem.setRatingSource(jSONObject.getString("ratings_source"));
            }
            if (!jSONObject.isNull("bus_type_name")) {
                cJRBusSearchItem.setBusTypeName(jSONObject.getString("bus_type_name"));
            }
            if (!jSONObject.isNull(AppConstants.DURATION)) {
                cJRBusSearchItem.setDuration(jSONObject.getString(AppConstants.DURATION));
            }
            if (!jSONObject.isNull("ratings")) {
                cJRBusSearchItem.setRatings(getRatings(jSONObject.getJSONObject("ratings")));
            }
            if (!jSONObject.isNull("trip_id")) {
                cJRBusSearchItem.setTripId(jSONObject.getString("trip_id"));
            }
            if (!jSONObject.isNull("bus_id")) {
                cJRBusSearchItem.setBusId(jSONObject.getString("bus_id"));
            }
            if (!jSONObject.isNull("provider_trip_id")) {
                cJRBusSearchItem.setProviderTripId(jSONObject.getString("provider_trip_id"));
            }
            if (!jSONObject.isNull("route_time_id")) {
                cJRBusSearchItem.setRouteTimeId(jSONObject.getString("route_time_id"));
            }
            if (!jSONObject.isNull("operator_id")) {
                cJRBusSearchItem.setOperatorId(Integer.valueOf(jSONObject.getInt("operator_id")));
                cJRBusSearchItem.setOperatorObj(hashMap.get(String.valueOf(cJRBusSearchItem.getOperatorId())));
            }
            if (!jSONObject.isNull("departure_datetime")) {
                cJRBusSearchItem.setDepartureDatetime(jSONObject.getString("departure_datetime"));
            }
            if (!jSONObject.isNull("arrival_datetime")) {
                cJRBusSearchItem.setArrivalDatetime(jSONObject.getString("arrival_datetime"));
            }
            if (!jSONObject.isNull("boarding_points") && jSONObject.has("boarding_points")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("boarding_points");
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                    arrayList2.add(jSONArray2.getString(i3));
                }
                if (arrayList2.size() > 0) {
                    cJRBusSearchItem.setBoardingPoints(arrayList2);
                }
            }
            if (!jSONObject.isNull("dropping_points") && jSONObject.has("dropping_points")) {
                JSONArray jSONArray3 = jSONObject.getJSONArray("dropping_points");
                ArrayList arrayList3 = new ArrayList();
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    arrayList3.add(jSONArray3.getString(i4));
                }
                if (arrayList3.size() > 0) {
                    cJRBusSearchItem.setDroppingPoints(arrayList3);
                }
            }
            if (!jSONObject.isNull("operator_tags") && jSONObject.has("operator_tags")) {
                JSONArray jSONArray4 = jSONObject.getJSONArray("operator_tags");
                ArrayList arrayList4 = new ArrayList();
                for (int i5 = 0; i5 < jSONArray4.length(); i5++) {
                    arrayList4.add(Integer.valueOf(jSONArray4.getInt(i5)));
                }
                if (arrayList4.size() > 0) {
                    cJRBusSearchItem.setOperatorTags(arrayList4);
                }
            }
            if (!jSONObject.isNull("ecosystem_offers") && jSONObject.has("ecosystem_offers")) {
                JSONArray jSONArray5 = jSONObject.getJSONArray("ecosystem_offers");
                ArrayList arrayList5 = new ArrayList();
                for (int i6 = 0; i6 < jSONArray5.length(); i6++) {
                    arrayList5.add(jSONArray5.getString(i6));
                }
                if (arrayList5.size() > 0) {
                    cJRBusSearchItem.setEcosystemOffers(arrayList5);
                }
            }
            if (!jSONObject.isNull("bus_type_tags") && jSONObject.has("bus_type_tags")) {
                JSONArray jSONArray6 = jSONObject.getJSONArray("bus_type_tags");
                ArrayList arrayList6 = new ArrayList();
                for (int i7 = 0; i7 < jSONArray6.length(); i7++) {
                    arrayList6.add(jSONArray6.getString(i7));
                }
                if (arrayList6.size() > 0) {
                    cJRBusSearchItem.setBusTypeTags(arrayList6);
                }
            }
            if (cJRBusSearchItem.getOperatorTags() != null) {
                Set<Integer> keySet = this.mOperatorTagCount.keySet();
                if (keySet == null || keySet.size() <= 0) {
                    Iterator<Integer> it2 = cJRBusSearchItem.getOperatorTags().iterator();
                    while (it2.hasNext()) {
                        this.mOperatorTagCount.put(Integer.valueOf(it2.next().intValue()), 1);
                    }
                } else {
                    Iterator<Integer> it3 = cJRBusSearchItem.getOperatorTags().iterator();
                    while (it3.hasNext()) {
                        int intValue = it3.next().intValue();
                        if (keySet.contains(Integer.valueOf(intValue))) {
                            this.mOperatorTagCount.put(Integer.valueOf(intValue), Integer.valueOf(this.mOperatorTagCount.get(Integer.valueOf(intValue)).intValue() + 1));
                        } else {
                            this.mOperatorTagCount.put(Integer.valueOf(intValue), 1);
                        }
                    }
                }
            }
            if (!jSONObject.isNull("amenities") && jSONObject.has("amenities")) {
                JSONArray jSONArray7 = jSONObject.getJSONArray("amenities");
                ArrayList arrayList7 = new ArrayList();
                for (int i8 = 0; i8 < jSONArray7.length(); i8++) {
                    arrayList7.add(Integer.valueOf(jSONArray7.getInt(i8)));
                }
                if (arrayList7.size() > 0) {
                    cJRBusSearchItem.setAmenities(arrayList7);
                }
            }
            if (cJRBusSearchItem.getAmenities() != null) {
                Set<Integer> keySet2 = this.mAmenityCount.keySet();
                if (keySet2 == null || keySet2.size() <= 0) {
                    Iterator<Integer> it4 = cJRBusSearchItem.getAmenities().iterator();
                    while (it4.hasNext()) {
                        this.mAmenityCount.put(Integer.valueOf(it4.next().intValue()), 1);
                    }
                } else {
                    Iterator<Integer> it5 = cJRBusSearchItem.getAmenities().iterator();
                    while (it5.hasNext()) {
                        int intValue2 = it5.next().intValue();
                        if (keySet2.contains(Integer.valueOf(intValue2))) {
                            this.mAmenityCount.put(Integer.valueOf(intValue2), Integer.valueOf(this.mAmenityCount.get(Integer.valueOf(intValue2)).intValue() + 1));
                        } else {
                            this.mAmenityCount.put(Integer.valueOf(intValue2), 1);
                        }
                    }
                }
            }
            if (!jSONObject.isNull("state") && jSONObject.has("state")) {
                cJRBusSearchItem.setFlag(getFlagData(jSONObject.getJSONObject("state")));
            }
            if (!jSONObject.isNull("flags") && jSONObject.has("flags")) {
                cJRBusSearchItem.setFlags(getFlagsData(jSONObject.getJSONObject("flags")));
            }
            if (!jSONObject.isNull("feature") && jSONObject.has("feature")) {
                cJRBusSearchItem.setFeature(getFeatureData(jSONObject.getJSONObject("feature")));
            }
            if (!jSONObject.isNull("fare") && jSONObject.has("fare")) {
                cJRBusSearchItem.setFare(getFareData(jSONObject.getJSONObject("fare")));
            }
            if (!jSONObject.isNull("photos") && jSONObject.has("photos")) {
                cJRBusSearchItem.setPhotos(getPhotoData(jSONObject.getJSONArray("photos")));
            }
            arrayList.add(cJRBusSearchItem);
        }
        return arrayList;
    }

    private BusRatingModel getRatings(JSONObject jSONObject) throws JSONException {
        BusRatingModel busRatingModel = new BusRatingModel();
        if (!jSONObject.isNull("average") && jSONObject.has("average")) {
            busRatingModel.setAverage_rating(jSONObject.getDouble("average"));
        }
        if (!jSONObject.isNull("count") && jSONObject.has("count")) {
            busRatingModel.setCount(jSONObject.getInt("count"));
        }
        if (!jSONObject.isNull("review_count") && jSONObject.has("review_count")) {
            busRatingModel.setReview_count(jSONObject.getInt("review_count"));
        }
        if (!jSONObject.isNull("color_code") && jSONObject.has("color_code")) {
            busRatingModel.setColor_code(jSONObject.getString("color_code"));
        }
        return busRatingModel;
    }

    private CJRBusSearchItemFare getFareData(JSONObject jSONObject) throws JSONException {
        CJRBusSearchItemFare cJRBusSearchItemFare = new CJRBusSearchItemFare();
        if (!jSONObject.isNull("tax_inclusive") && jSONObject.has("tax_inclusive")) {
            cJRBusSearchItemFare.setTaxInclusive(Boolean.valueOf(jSONObject.getBoolean("tax_inclusive")));
        }
        if (!jSONObject.isNull("prices") && jSONObject.has("prices")) {
            cJRBusSearchItemFare.setPrices(getPrice(jSONObject.getJSONArray("prices")));
        }
        return cJRBusSearchItemFare;
    }

    private ArrayList<CJRBusPhotoWrapper> getPhotoData(JSONArray jSONArray) {
        return (ArrayList) new f().a(jSONArray.toString(), new a<ArrayList<CJRBusPhotoWrapper>>() {
        }.getType());
    }

    private double[] getPrice(JSONArray jSONArray) throws JSONException {
        double[] dArr = new double[jSONArray.length()];
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            dArr[i2] = jSONArray.getDouble(i2);
        }
        return dArr;
    }

    private CJRBusSearchItemFeature getFeatureData(JSONObject jSONObject) throws JSONException {
        CJRBusSearchItemFeature cJRBusSearchItemFeature = new CJRBusSearchItemFeature();
        if (!jSONObject.isNull("single_lady") && jSONObject.has("single_lady")) {
            cJRBusSearchItemFeature.setSingleLady(Boolean.valueOf(jSONObject.getBoolean("single_lady")));
        }
        if (!jSONObject.isNull("extra_traveller_details") && jSONObject.has("extra_traveller_details")) {
            cJRBusSearchItemFeature.setExtraTravellerDetails(Boolean.valueOf(jSONObject.getBoolean("extra_traveller_details")));
        }
        if (!jSONObject.isNull("collect_location_points") && jSONObject.has("collect_location_points")) {
            cJRBusSearchItemFeature.setCollectLocationPoints(Boolean.valueOf(jSONObject.getBoolean("collect_location_points")));
        }
        if (!jSONObject.isNull("concession") && jSONObject.has("concession")) {
            cJRBusSearchItemFeature.setConcession(Boolean.valueOf(jSONObject.getBoolean("concession")));
        }
        return cJRBusSearchItemFeature;
    }

    private CJRbusSearchItemFlags getFlagsData(JSONObject jSONObject) throws JSONException {
        CJRbusSearchItemFlags cJRbusSearchItemFlags = new CJRbusSearchItemFlags();
        if (!jSONObject.isNull("sleeper") && jSONObject.has("sleeper")) {
            cJRbusSearchItemFlags.setSleeper(Boolean.valueOf(jSONObject.getBoolean("sleeper")));
        }
        if (!jSONObject.isNull("ac") && jSONObject.has("ac")) {
            cJRbusSearchItemFlags.setAc(Boolean.valueOf(jSONObject.getBoolean("ac")));
        }
        if (!jSONObject.isNull("cancellable") && jSONObject.has("cancellable")) {
            cJRbusSearchItemFlags.setCancellable(Boolean.valueOf(jSONObject.getBoolean("cancellable")));
        }
        if (!jSONObject.isNull("m_ticket") && jSONObject.has("m_ticket")) {
            cJRbusSearchItemFlags.setMTicket(Boolean.valueOf(jSONObject.getBoolean("m_ticket")));
        }
        if (!jSONObject.isNull("seater") && jSONObject.has("seater")) {
            cJRbusSearchItemFlags.setSeater(Boolean.valueOf(jSONObject.getBoolean("seater")));
        }
        if (!jSONObject.isNull("semi_sleeper") && jSONObject.has("semi_sleeper")) {
            cJRbusSearchItemFlags.setSemiSleeper(Boolean.valueOf(jSONObject.getBoolean("semi_sleeper")));
        }
        if (!jSONObject.isNull("is_social_distancing_guaranteed") && jSONObject.has("is_social_distancing_guaranteed")) {
            cJRbusSearchItemFlags.setSocialDistancingGuaranteed(jSONObject.getBoolean("is_social_distancing_guaranteed"));
        }
        return cJRbusSearchItemFlags;
    }

    private CJRBusSearchItemFlag getFlagData(JSONObject jSONObject) throws JSONException {
        CJRBusSearchItemFlag cJRBusSearchItemFlag = new CJRBusSearchItemFlag();
        if (!jSONObject.isNull("sold_out") && jSONObject.has("sold_out")) {
            cJRBusSearchItemFlag.setSoldOut(Boolean.valueOf(jSONObject.getBoolean("sold_out")));
        }
        if (!jSONObject.isNull("departed") && jSONObject.has("departed")) {
            cJRBusSearchItemFlag.setDeparted(Boolean.valueOf(jSONObject.getBoolean("departed")));
        }
        if (!jSONObject.isNull("blocked") && jSONObject.has("blocked")) {
            cJRBusSearchItemFlag.setBlocked(Boolean.valueOf(jSONObject.getBoolean("blocked")));
        }
        if (!jSONObject.isNull("selling_fast") && jSONObject.has("selling_fast")) {
            cJRBusSearchItemFlag.setSellingFast(jSONObject.getBoolean("selling_fast"));
        }
        return cJRBusSearchItemFlag;
    }

    private HashMap<String, CJRBusSearchOperatorTagInfo> getOperatorTagData(String str) throws JSONException {
        HashMap<String, CJRBusSearchOperatorTagInfo> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            CJRBusSearchOperatorTagInfo cJRBusSearchOperatorTagInfo = new CJRBusSearchOperatorTagInfo();
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(next);
            if (!jSONObject2.isNull("tag_id")) {
                cJRBusSearchOperatorTagInfo.setTagId(jSONObject2.getString("tag_id"));
            }
            if (!jSONObject2.isNull("label")) {
                cJRBusSearchOperatorTagInfo.setLabel(jSONObject2.getString("label"));
            }
            if (!jSONObject2.isNull(RequestConfirmationDialogFragment.KEY_DESCRIPTION)) {
                cJRBusSearchOperatorTagInfo.setDescription(jSONObject2.getString(RequestConfirmationDialogFragment.KEY_DESCRIPTION));
            }
            if (!jSONObject2.isNull("tag_type")) {
                cJRBusSearchOperatorTagInfo.setTagType(jSONObject2.getString("tag_type"));
            }
            if (!jSONObject2.isNull(H5Param.MENU_ICON)) {
                cJRBusSearchOperatorTagInfo.setIcon(jSONObject2.getString(H5Param.MENU_ICON));
            }
            if (!jSONObject2.isNull("priority")) {
                cJRBusSearchOperatorTagInfo.setPriority(Integer.valueOf(jSONObject2.getInt("priority")));
            }
            if (!jSONObject2.isNull("src_id")) {
                cJRBusSearchOperatorTagInfo.setSrcId(jSONObject2.getString("src_id"));
            }
            if (!jSONObject2.isNull("dest_id")) {
                cJRBusSearchOperatorTagInfo.setDestId(jSONObject2.getString("dest_id"));
            }
            if (!jSONObject2.isNull("rule_type")) {
                cJRBusSearchOperatorTagInfo.setRuleType(jSONObject2.getString("rule_type"));
            }
            if (!jSONObject2.isNull("rule_priority")) {
                cJRBusSearchOperatorTagInfo.setRulePriority(Integer.valueOf(jSONObject2.getInt("rule_priority")));
            }
            hashMap.put(next, cJRBusSearchOperatorTagInfo);
        }
        return hashMap;
    }

    public HashMap<String, CJRBusSearchAmenitiesInfo> getAmenityData(String str) throws JSONException {
        HashMap<String, CJRBusSearchAmenitiesInfo> hashMap = new HashMap<>();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            CJRBusSearchAmenitiesInfo cJRBusSearchAmenitiesInfo = new CJRBusSearchAmenitiesInfo();
            JSONObject jSONObject2 = (JSONObject) jSONObject.get(next);
            if (!jSONObject2.isNull("id")) {
                cJRBusSearchAmenitiesInfo.setId(jSONObject2.getString("id"));
            }
            if (!jSONObject2.isNull("name")) {
                cJRBusSearchAmenitiesInfo.setName(jSONObject2.getString("name"));
            }
            if (!jSONObject2.isNull("label")) {
                cJRBusSearchAmenitiesInfo.setLabel(jSONObject2.getString("label"));
            }
            if (!jSONObject2.isNull(H5Param.MENU_ICON)) {
                cJRBusSearchAmenitiesInfo.setIcon(jSONObject2.getString(H5Param.MENU_ICON));
            }
            if (!jSONObject2.isNull("icon_selected")) {
                cJRBusSearchAmenitiesInfo.setIconSelected(jSONObject2.getString("icon_selected"));
            }
            hashMap.put(next, cJRBusSearchAmenitiesInfo);
        }
        return hashMap;
    }
}
