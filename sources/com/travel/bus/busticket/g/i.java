package com.travel.bus.busticket.g;

import android.os.AsyncTask;
import com.travel.bus.busticket.c.d;
import com.travel.bus.pojo.busticket.TripBusDetailsItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    d.a f22384a;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<TripBusDetailsItem> f22385b;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<TripBusDetailsItem> f22386c;

    /* renamed from: d  reason: collision with root package name */
    int f22387d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f22388e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f22389f = "CJRSelectSeatFragmentPresenter";

    static /* synthetic */ int a(i iVar) {
        int i2 = iVar.f22387d;
        iVar.f22387d = i2 + 1;
        return i2;
    }

    static /* synthetic */ int b(i iVar) {
        int i2 = iVar.f22388e;
        iVar.f22388e = i2 + 1;
        return i2;
    }

    public i(d.a aVar) {
        this.f22384a = aVar;
    }

    public static int a(String str, ArrayList<TripBusDetailsItem> arrayList) {
        if (arrayList == null) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            TripBusDetailsItem tripBusDetailsItem = arrayList.get(i3);
            if (tripBusDetailsItem != null && tripBusDetailsItem.getAvailable()) {
                String a2 = com.travel.bus.busticket.i.i.a(tripBusDetailsItem.getFare());
                if (!(tripBusDetailsItem.detailedFare == null || tripBusDetailsItem.detailedFare.getDeal() == null)) {
                    a2 = com.travel.bus.busticket.i.i.a(tripBusDetailsItem.detailedFare.getBaseFare().doubleValue());
                }
                if (a2.equalsIgnoreCase(com.travel.bus.busticket.i.i.a(str))) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public final void a(ArrayList<TripBusDetailsItem> arrayList) {
        new a(arrayList).execute(new Void[0]);
    }

    class a extends AsyncTask<Void, Void, Void> {

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<TripBusDetailsItem> f22391b;

        /* renamed from: c  reason: collision with root package name */
        private HashMap<Long, Long> f22392c;

        /* renamed from: d  reason: collision with root package name */
        private HashMap<Long, Long> f22393d;

        public a(ArrayList<TripBusDetailsItem> arrayList) {
            this.f22391b = arrayList;
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ void onPostExecute(Object obj) {
            i.this.f22384a.a(i.this.f22385b, i.this.f22386c, this.f22392c.size() + i.this.f22387d, this.f22393d.size() + i.this.f22388e);
        }

        /* access modifiers changed from: protected */
        public final /* synthetic */ Object doInBackground(Object[] objArr) {
            long j;
            long j2;
            ArrayList<TripBusDetailsItem> arrayList = this.f22391b;
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            i.this.f22385b = new ArrayList<>();
            i.this.f22386c = new ArrayList<>();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            Iterator<TripBusDetailsItem> it2 = this.f22391b.iterator();
            while (it2.hasNext()) {
                TripBusDetailsItem next = it2.next();
                if (next.getLowerBerth().booleanValue()) {
                    if (!hashMap.containsKey(Long.valueOf(next.getRow()))) {
                        hashMap.put(Long.valueOf(next.getRow()), next);
                    } else if (next.getWidth() > ((TripBusDetailsItem) hashMap.get(Long.valueOf(next.getRow()))).getWidth()) {
                        hashMap.put(Long.valueOf(next.getRow()), next);
                    }
                } else if (!hashMap2.containsKey(Long.valueOf(next.getRow()))) {
                    hashMap2.put(Long.valueOf(next.getRow()), next);
                } else if (next.getWidth() > ((TripBusDetailsItem) hashMap2.get(Long.valueOf(next.getRow()))).getWidth()) {
                    hashMap2.put(Long.valueOf(next.getRow()), next);
                }
            }
            TreeMap treeMap = new TreeMap(hashMap);
            TreeMap treeMap2 = new TreeMap(hashMap2);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (Map.Entry value : treeMap.entrySet()) {
                arrayList2.add(value.getValue());
            }
            for (Map.Entry value2 : treeMap2.entrySet()) {
                arrayList3.add(value2.getValue());
            }
            this.f22392c = new HashMap<>();
            this.f22393d = new HashMap<>();
            if (!arrayList2.isEmpty()) {
                long j3 = 0;
                int i2 = 0;
                while (i2 < arrayList2.size() - 1) {
                    if (((TripBusDetailsItem) arrayList2.get(i2)).getWidth() == 1) {
                        int i3 = i2 + 1;
                        if (((TripBusDetailsItem) arrayList2.get(i3)).getRow() - ((TripBusDetailsItem) arrayList2.get(i2)).getRow() > 1) {
                            i.a(i.this);
                            j3 += 2;
                            i2++;
                            this.f22392c.put(Long.valueOf(((TripBusDetailsItem) arrayList2.get(i2)).getRow()), Long.valueOf(j3));
                        } else {
                            j2 = ((TripBusDetailsItem) arrayList2.get(i3)).getRow() - ((TripBusDetailsItem) arrayList2.get(i2)).getRow();
                        }
                    } else {
                        i.a(i.this);
                        j2 = ((TripBusDetailsItem) arrayList2.get(i2)).getWidth();
                    }
                    j3 += j2;
                    i2++;
                    this.f22392c.put(Long.valueOf(((TripBusDetailsItem) arrayList2.get(i2)).getRow()), Long.valueOf(j3));
                }
                this.f22392c.put(Long.valueOf(((TripBusDetailsItem) arrayList2.get(0)).getRow()), 0L);
            }
            if (!arrayList3.isEmpty()) {
                long j4 = 0;
                int i4 = 0;
                while (i4 < arrayList3.size() - 1) {
                    if (((TripBusDetailsItem) arrayList3.get(i4)).getWidth() == 1) {
                        int i5 = i4 + 1;
                        if (((TripBusDetailsItem) arrayList3.get(i5)).getRow() - ((TripBusDetailsItem) arrayList3.get(i4)).getRow() > 1) {
                            i.b(i.this);
                            j4 += 2;
                            i4++;
                            this.f22393d.put(Long.valueOf(((TripBusDetailsItem) arrayList3.get(i4)).getRow()), Long.valueOf(j4));
                        } else {
                            j = ((TripBusDetailsItem) arrayList3.get(i5)).getRow() - ((TripBusDetailsItem) arrayList3.get(i4)).getRow();
                        }
                    } else {
                        i.b(i.this);
                        j = ((TripBusDetailsItem) arrayList3.get(i4)).getWidth();
                    }
                    j4 += j;
                    i4++;
                    this.f22393d.put(Long.valueOf(((TripBusDetailsItem) arrayList3.get(i4)).getRow()), Long.valueOf(j4));
                }
                this.f22393d.put(Long.valueOf(((TripBusDetailsItem) arrayList3.get(0)).getRow()), 0L);
            }
            Iterator<TripBusDetailsItem> it3 = this.f22391b.iterator();
            while (it3.hasNext()) {
                TripBusDetailsItem next2 = it3.next();
                if (next2 != null) {
                    if (next2.getLowerBerth().booleanValue()) {
                        if (this.f22392c.containsKey(Long.valueOf(next2.getRow()))) {
                            next2.setRow(this.f22392c.get(Long.valueOf(next2.getRow())).longValue());
                        }
                        i.this.f22385b.add(next2);
                    } else {
                        if (this.f22393d.containsKey(Long.valueOf(next2.getRow()))) {
                            next2.setRow(this.f22393d.get(Long.valueOf(next2.getRow())).longValue());
                        }
                        i.this.f22386c.add(next2);
                    }
                }
            }
            return null;
        }
    }
}
