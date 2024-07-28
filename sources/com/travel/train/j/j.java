package com.travel.train.j;

import android.text.TextUtils;
import com.travel.train.i.q;
import com.travel.train.model.trainticket.CJRTrainFilterModel;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public boolean f27565a = false;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRTrainSearchResultsTrain> f27566b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private CJRTrainFilterModel f27567c = new CJRTrainFilterModel();

    /* renamed from: d  reason: collision with root package name */
    private q f27568d;

    /* renamed from: e  reason: collision with root package name */
    private String f27569e = "CJRTrainFilterUtils";

    public j(q qVar) {
        this.f27568d = qVar;
    }

    public final void a(CJRTrainSearchResults cJRTrainSearchResults, CJRTrainFilterModel cJRTrainFilterModel) {
        this.f27567c = cJRTrainFilterModel;
        this.f27566b = cJRTrainSearchResults.getBody().getTrains();
        if (!b(c(this.f27566b)) && !b(d(this.f27566b)) && !b(e(this.f27566b)) && !b(f(this.f27566b)) && !b(a(this.f27566b, cJRTrainFilterModel))) {
            this.f27568d.a(this.f27566b);
        }
    }

    private boolean b(List<CJRTrainSearchResultsTrain> list) {
        if (this.f27565a) {
            this.f27566b = list;
            this.f27565a = false;
            if (list.size() <= 0) {
                this.f27568d.a(this.f27566b);
                return true;
            }
        }
        return false;
    }

    private List<CJRTrainSearchResultsTrain> c(List<CJRTrainSearchResultsTrain> list) {
        ArrayList arrayList = new ArrayList();
        if (this.f27567c.getmSelectedSourceList().size() > 0) {
            Set<Map.Entry<String, String>> entrySet = this.f27567c.getmSelectedSourceList().entrySet();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                for (Map.Entry<String, String> value : entrySet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(value.getValue());
                    if (list.get(i2).getSourceName().equals(sb.toString())) {
                        arrayList.add(list.get(i2));
                    }
                }
            }
            this.f27565a = true;
        }
        return arrayList;
    }

    private List<CJRTrainSearchResultsTrain> d(List<CJRTrainSearchResultsTrain> list) {
        ArrayList arrayList = new ArrayList();
        if (this.f27567c.getmSelectedDestinationList().size() > 0) {
            Set<Map.Entry<String, String>> entrySet = this.f27567c.getmSelectedDestinationList().entrySet();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                for (Map.Entry<String, String> value : entrySet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(value.getValue());
                    if (list.get(i2).getDestinationName().equals(sb.toString())) {
                        arrayList.add(list.get(i2));
                    }
                }
            }
            this.f27565a = true;
        }
        return arrayList;
    }

    private List<CJRTrainSearchResultsTrain> e(List<CJRTrainSearchResultsTrain> list) {
        ArrayList arrayList = new ArrayList();
        if (this.f27567c.getmSelecteddepartureList().size() > 0) {
            Set<Map.Entry<String, String>> entrySet = this.f27567c.getmSelecteddepartureList().entrySet();
            int size = list.size();
            if (list.size() > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    for (Map.Entry<String, String> value : entrySet) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(value.getValue());
                        String sb2 = sb.toString();
                        if (list.get(i2).getDeparture() != null) {
                            Long a2 = a(list.get(i2).getDeparture());
                            if (sb2.equalsIgnoreCase("early morning")) {
                                Long b2 = b("00:00:00");
                                Long b3 = b("06:00:00");
                                if (a2.longValue() >= b2.longValue() && a2.longValue() <= b3.longValue() && !arrayList.contains(list.get(i2))) {
                                    arrayList.add(list.get(i2));
                                }
                            } else if (sb2.equalsIgnoreCase("morning")) {
                                Long b4 = b("06:00:00");
                                Long b5 = b("12:00:00");
                                if (a2.longValue() >= b4.longValue() && a2.longValue() <= b5.longValue() && !arrayList.contains(list.get(i2))) {
                                    arrayList.add(list.get(i2));
                                }
                            } else if (sb2.equalsIgnoreCase("afternoon")) {
                                Long b6 = b("12:00:00");
                                Long b7 = b("18:00:00");
                                if (a2.longValue() >= b6.longValue() && a2.longValue() <= b7.longValue() && !arrayList.contains(list.get(i2))) {
                                    arrayList.add(list.get(i2));
                                }
                            } else if (sb2.equalsIgnoreCase("night")) {
                                Long b8 = b("18:00:00");
                                Long b9 = b("23:59:59");
                                Long b10 = b("00:00:00");
                                if (((a2.longValue() >= b8.longValue() && a2.longValue() <= b9.longValue()) || a2 == b10) && !arrayList.contains(list.get(i2))) {
                                    arrayList.add(list.get(i2));
                                }
                            }
                        }
                    }
                }
            }
            this.f27565a = true;
        }
        return arrayList;
    }

    private List<CJRTrainSearchResultsTrain> f(List<CJRTrainSearchResultsTrain> list) {
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0 && this.f27567c.getmSelectedArrivaList().size() > 0) {
            Set<Map.Entry<String, String>> entrySet = this.f27567c.getmSelectedArrivaList().entrySet();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                for (Map.Entry<String, String> value : entrySet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(value.getValue());
                    String sb2 = sb.toString();
                    if (list.get(i2).getArrival() != null) {
                        Long a2 = a(list.get(i2).getArrival());
                        if (sb2.equalsIgnoreCase("early morning")) {
                            Long b2 = b("00:00:00");
                            Long b3 = b("06:00:00");
                            if (a2.longValue() >= b2.longValue() && a2.longValue() <= b3.longValue() && !arrayList.contains(list.get(i2))) {
                                arrayList.add(list.get(i2));
                            }
                        } else if (sb2.equalsIgnoreCase("morning")) {
                            Long b4 = b("06:00:00");
                            Long b5 = b("12:00:00");
                            if (a2.longValue() >= b4.longValue() && a2.longValue() <= b5.longValue() && !arrayList.contains(list.get(i2))) {
                                arrayList.add(list.get(i2));
                            }
                        } else if (sb2.equalsIgnoreCase("afternoon")) {
                            Long b6 = b("12:00:00");
                            Long b7 = b("18:00:00");
                            if (a2.longValue() >= b6.longValue() && a2.longValue() <= b7.longValue() && !arrayList.contains(list.get(i2))) {
                                arrayList.add(list.get(i2));
                            }
                        } else if (sb2.equalsIgnoreCase("night")) {
                            Long b8 = b("18:00:00");
                            Long b9 = b("23:59:59");
                            Long b10 = b("00:00:00");
                            if (((a2.longValue() >= b8.longValue() && a2.longValue() <= b9.longValue()) || a2 == b10) && !arrayList.contains(list.get(i2))) {
                                arrayList.add(list.get(i2));
                            }
                        }
                    }
                }
            }
            this.f27565a = true;
        }
        return arrayList;
    }

    public final List<CJRTrainSearchResultsTrain> a(List<CJRTrainSearchResultsTrain> list, CJRTrainFilterModel cJRTrainFilterModel) {
        this.f27567c.setmSelectedFareCalssesList(cJRTrainFilterModel.getmSelectedFareCalssesList());
        ArrayList arrayList = new ArrayList();
        if (list.size() > 0 && this.f27567c.getmSelectedFareCalssesList().size() > 0) {
            HashMap<String, String> hashMap = this.f27567c.getmSelectedFareCalssesList();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                ArrayList arrayList2 = new ArrayList();
                if (list.get(i2).getMAvailability() != null && list.get(i2).getMAvailability().size() > 0) {
                    for (int i3 = 0; i3 < list.get(i2).getMAvailability().size(); i3++) {
                        CJRTrainSearchResultsAvailibiltyObject cJRTrainSearchResultsAvailibiltyObject = list.get(i2).getMAvailability().get(i3);
                        if (hashMap.containsKey(cJRTrainSearchResultsAvailibiltyObject.getClassType())) {
                            arrayList2.add(cJRTrainSearchResultsAvailibiltyObject);
                        }
                    }
                }
                if (arrayList2.size() > 0) {
                    list.get(i2).setMAvailability(arrayList2);
                    arrayList.add(list.get(i2));
                }
            }
            this.f27565a = true;
        }
        return arrayList;
    }

    public static List<CJRTrainSearchResultsTrain> a(List<CJRTrainSearchResultsTrain> list) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            ArrayList arrayList2 = new ArrayList();
            if (list.get(i2).getMAvailability() != null && list.get(i2).getMAvailability().size() > 0) {
                for (int i3 = 0; i3 < list.get(i2).getMAvailability().size(); i3++) {
                    if (!TextUtils.isEmpty(list.get(i2).getMAvailability().get(i3).getColour()) && list.get(i2).getMAvailability().get(i3).getColour().equalsIgnoreCase("GREEN")) {
                        arrayList2.add(list.get(i2).getMAvailability().get(i3));
                    }
                }
            }
            if (arrayList2.size() > 0) {
                list.get(i2).setMAvailability(arrayList2);
                arrayList.add(list.get(i2));
            }
        }
        return arrayList;
    }

    private static Long a(String str) {
        Date date = null;
        if (str == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm:ss");
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e2) {
            com.paytm.utility.q.c(e2.getMessage());
        }
        return b(simpleDateFormat2.format(date));
    }

    private static Long b(String str) {
        Date date;
        try {
            date = new SimpleDateFormat("HH:mm:ss").parse(str);
        } catch (ParseException e2) {
            com.paytm.utility.q.c(e2.getMessage());
            date = null;
        }
        return Long.valueOf(date.getTime());
    }
}
