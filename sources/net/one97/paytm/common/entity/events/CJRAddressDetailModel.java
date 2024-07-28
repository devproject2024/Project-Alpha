package net.one97.paytm.common.entity.events;

import android.text.TextUtils;
import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.events.CJREventDateTimeModel;

public class CJRAddressDetailModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "eventDateTime")
    private List<CJREventDateTimeModel> eventDateTimeList;
    @b(a = "id")
    private int id;
    @b(a = "address")
    private String mAddress;
    @b(a = "address_name")
    private String mAddressName;
    @b(a = "contact")
    private String mContact;
    private Map<String, List<CJRSeatDetailsModel>> mDateTimeToSeatListMap;
    private Map<String, List<CJREventDateTimeModel.Time>> mDateToTimeListMap;
    @b(a = "description")
    private String mDescription;
    @b(a = "email")
    private String mEmail;
    @b(a = "latitude")
    private Double mLatitude;
    @b(a = "longitude")
    private Double mLongitude;
    @b(a = "name")
    private String mName;
    @b(a = "pincode")
    private String mPincode;
    @b(a = "seatDetails")
    private List<CJRSeatDetailsModel> mSeatDetailsModel;
    private boolean mSoldOut;

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public String getAddress() {
        return this.mAddress;
    }

    public void setAddress(String str) {
        this.mAddress = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getPincode() {
        return this.mPincode;
    }

    public void setPincode(String str) {
        this.mPincode = str;
    }

    public Double getLatitude() {
        return this.mLatitude;
    }

    public void setLatitude(Double d2) {
        this.mLatitude = d2;
    }

    public Double getLongitude() {
        return this.mLongitude;
    }

    public void setLongitude(Double d2) {
        this.mLongitude = d2;
    }

    public List<CJREventDateTimeModel> getEventDateTimeList() {
        return this.eventDateTimeList;
    }

    public void setEventDateTimeList(List<CJREventDateTimeModel> list) {
        this.eventDateTimeList = list;
    }

    public String getmContact() {
        return this.mContact;
    }

    public void setmContact(String str) {
        this.mContact = str;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public List<CJRSeatDetailsModel> getSeatDetailsModel() {
        return this.mSeatDetailsModel;
    }

    public void setSeatDetailsModel(List<CJRSeatDetailsModel> list) {
        this.mSeatDetailsModel = list;
    }

    public void setSoldOutInfo(boolean z) {
        this.mSoldOut = z;
    }

    public boolean getSoldOutInfo() {
        return this.mSoldOut;
    }

    public String getAddressName() {
        return this.mAddressName;
    }

    public void setAddressName(String str) {
        this.mAddressName = str;
    }

    public Map<String, List<CJRSeatDetailsModel>> getDateTimeToSeatListMap() {
        if (this.mDateTimeToSeatListMap == null) {
            this.mDateTimeToSeatListMap = extractDateTimeToSeatListMap(this.eventDateTimeList);
        }
        return this.mDateTimeToSeatListMap;
    }

    public Map<String, List<CJRSeatDetailsModel>> getDateTimeToSeatListMapForDateRange() {
        List<CJREventDateTimeModel> list = this.eventDateTimeList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (CJREventDateTimeModel next : this.eventDateTimeList) {
            List<String> list2 = next.getmEventDateList();
            String str = next.getmTime().getmStart();
            List<CJRSeatDetailsModel> list3 = next.getmSeatDetails();
            if (list2 != null && list2.size() > 0) {
                String str2 = (list2.get(0) + "-" + list2.get(list2.size() - 1)) + str;
                if (hashMap.containsKey(str2)) {
                    checkAndAddCurrentSeatDetailListToSingleList(list3, (List) hashMap.get(str2));
                } else {
                    ArrayList arrayList = new ArrayList();
                    addCurrentSeatDetailListToSingleList(list3, arrayList);
                    hashMap.put(str2, arrayList);
                }
            }
        }
        return hashMap;
    }

    public Map<String, List<CJREventDateTimeModel.Time>> getDateToTimeListMap() {
        if (this.mDateToTimeListMap == null) {
            this.mDateToTimeListMap = extractDateTimeMap(this.eventDateTimeList);
        }
        return this.mDateToTimeListMap;
    }

    public Map<String, List<CJREventDateTimeModel.Time>> getDateToTimeListMap(boolean z) {
        return extractDateTimeMap(this.eventDateTimeList, z);
    }

    public Map<String, List<CJREventDateTimeModel.Time>> getmDateToTimeListMapForDateRange(boolean z) {
        List<CJREventDateTimeModel> list = this.eventDateTimeList;
        if (list == null || list.size() <= 0) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (CJREventDateTimeModel next : this.eventDateTimeList) {
            List<CJRSeatDetailsModel> list2 = next.getmSeatDetails();
            if ((!(list2 != null) || !(list2.size() > 0)) || ((z || list2.get(0).getIsSeasonPass() != 1) && (!z || list2.get(0).getIsSeasonPass() == 1))) {
                List<String> list3 = next.getmEventDateList();
                CJREventDateTimeModel.Time time = next.getmTime();
                if (list3 != null && list3.size() > 0) {
                    String str = list3.get(0) + "-" + list3.get(list3.size() - 1);
                    if (linkedHashMap.containsKey(str)) {
                        List list4 = (List) linkedHashMap.get(str);
                        if (!checkIfTimeAlreadyExistsInList(time, list4)) {
                            list4.add(time);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(time);
                        linkedHashMap.put(str, arrayList);
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public Map<String, List<CJRSeatDetailsModel>> extractDateTimeToSeatListMap(List<CJREventDateTimeModel> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (CJREventDateTimeModel next : list) {
            List<String> list2 = next.getmEventDateList();
            CJREventDateTimeModel.Time time = next.getmTime();
            String str = time.getmStart() + time.getmTo();
            List<CJRSeatDetailsModel> list3 = next.getmSeatDetails();
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

    public String getDateFromIndex(int i2) {
        Map<String, List<CJREventDateTimeModel.Time>> dateToTimeListMap = getDateToTimeListMap();
        return (dateToTimeListMap == null || dateToTimeListMap.keySet() == null || dateToTimeListMap.keySet().size() <= i2) ? "" : (String) dateToTimeListMap.keySet().toArray()[i2];
    }

    public String getDateRangeFromIndex(int i2) {
        Map<String, List<CJREventDateTimeModel.Time>> map = getmDateToTimeListMapForDateRange(true);
        return (map == null || map.keySet() == null || map.keySet().size() <= i2) ? "" : (String) map.keySet().toArray()[i2];
    }

    public CJREventDateTimeModel.Time getTimeFromIndex(int i2, int i3) {
        Map<String, List<CJREventDateTimeModel.Time>> dateToTimeListMap = getDateToTimeListMap();
        String str = (dateToTimeListMap == null || dateToTimeListMap.keySet() == null || dateToTimeListMap.keySet().size() <= i2) ? "" : (String) dateToTimeListMap.keySet().toArray()[i2];
        if (dateToTimeListMap.get(str) != null) {
            return (CJREventDateTimeModel.Time) dateToTimeListMap.get(str).get(i3);
        }
        return null;
    }

    public CJREventDateTimeModel.Time getTimeForDateRangeFromIndex(int i2, int i3) {
        Map<String, List<CJREventDateTimeModel.Time>> map = getmDateToTimeListMapForDateRange(true);
        String str = (map == null || map.keySet() == null || map.keySet().size() <= i2) ? "" : (String) map.keySet().toArray()[i2];
        if (map.get(str) != null) {
            return (CJREventDateTimeModel.Time) map.get(str).get(i3);
        }
        return null;
    }

    private void checkAndAddCurrentSeatDetailListToSingleList(List<CJRSeatDetailsModel> list, List<CJRSeatDetailsModel> list2) {
        if (list != null && list.size() > 0 && list2 != null && list2.size() > 0) {
            for (CJRSeatDetailsModel next : list) {
                if (!hasSeatBeenAlreadyAdded(next, list2)) {
                    list2.add(next);
                }
            }
        }
    }

    private boolean hasSeatBeenAlreadyAdded(CJRSeatDetailsModel cJRSeatDetailsModel, List<CJRSeatDetailsModel> list) {
        if (!(cJRSeatDetailsModel == null || list == null || list.size() <= 0)) {
            for (CJRSeatDetailsModel seatId : list) {
                if (seatId.getSeatId().equalsIgnoreCase(cJRSeatDetailsModel.getSeatId())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void addCurrentSeatDetailListToSingleList(List<CJRSeatDetailsModel> list, List<CJRSeatDetailsModel> list2) {
        if (list != null && list.size() > 0 && list2 != null) {
            for (CJRSeatDetailsModel add : list) {
                list2.add(add);
            }
        }
    }

    public LinkedHashMap<String, List<CJREventDateTimeModel.Time>> extractDateTimeMap(List<CJREventDateTimeModel> list, boolean z) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        LinkedHashMap<String, List<CJREventDateTimeModel.Time>> linkedHashMap = new LinkedHashMap<>();
        for (CJREventDateTimeModel next : list) {
            List<CJRSeatDetailsModel> list2 = next.getmSeatDetails();
            if ((!(list2 != null) || !(list2.size() > 0)) || ((z || list2.get(0).getIsSeasonPass() != 1) && (!z || list2.get(0).getIsSeasonPass() == 1))) {
                List<String> list3 = next.getmEventDateList();
                CJREventDateTimeModel.Time time = next.getmTime();
                if (list3 != null && list3.size() > 0) {
                    for (String next2 : list3) {
                        if (next2 != null) {
                            if (linkedHashMap.containsKey(next2)) {
                                List list4 = linkedHashMap.get(next2);
                                if (!checkIfTimeAlreadyExistsInList(time, list4)) {
                                    list4.add(time);
                                }
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(time);
                                linkedHashMap.put(next2, arrayList);
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public LinkedHashMap<String, List<CJREventDateTimeModel.Time>> extractDateTimeMap(List<CJREventDateTimeModel> list) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        LinkedHashMap<String, List<CJREventDateTimeModel.Time>> linkedHashMap = new LinkedHashMap<>();
        for (CJREventDateTimeModel next : list) {
            List<String> list2 = next.getmEventDateList();
            CJREventDateTimeModel.Time time = next.getmTime();
            if (list2 != null && list2.size() > 0) {
                if (next.getmSeatDetails() == null || next.getmSeatDetails().size() <= 0 || next.getmSeatDetails().get(0).getIsSeasonPass() != 1) {
                    for (String next2 : list2) {
                        if (next2 != null) {
                            if (linkedHashMap.containsKey(next2)) {
                                List list3 = linkedHashMap.get(next2);
                                if (!checkIfTimeAlreadyExistsInList(time, list3)) {
                                    list3.add(time);
                                }
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(time);
                                linkedHashMap.put(next2, arrayList);
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    private boolean checkIfTimeAlreadyExistsInList(CJREventDateTimeModel.Time time, List<CJREventDateTimeModel.Time> list) {
        if (!(list == null || list.size() <= 0 || time == null)) {
            for (CJREventDateTimeModel.Time time2 : list) {
                String str = time2.getmStart();
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(time.getmStart()) && str.equalsIgnoreCase(time.getmStart())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean extractVenueSoldOutInfo(List<CJREventDateTimeModel> list) {
        if (list != null && list.size() > 0) {
            for (CJREventDateTimeModel cJREventDateTimeModel : list) {
                List<CJRSeatDetailsModel> list2 = cJREventDateTimeModel.getmSeatDetails();
                if (list2 != null && list2.size() > 0) {
                    for (CJRSeatDetailsModel seatsAvailable : list2) {
                        if (seatsAvailable.getSeatsAvailable() > 0) {
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        return true;
    }

    public int getId() {
        return this.id;
    }
}
