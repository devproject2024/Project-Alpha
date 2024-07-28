package com.travel.train.k;

import android.text.TextUtils;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.alipay.mobile.h5container.api.H5Param;
import com.google.gsonhtcfix.f;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import com.travel.train.a.a;
import com.travel.train.j.i;
import com.travel.train.j.n;
import com.travel.train.model.CJRTrainSearchInput;
import com.travel.train.model.e;
import com.travel.train.model.trainticket.CJRNearByStationResult;
import com.travel.train.model.trainticket.CJRTrainDetails;
import com.travel.train.model.trainticket.CJRTrainQuickBookFavourites;
import com.travel.train.model.trainticket.CJRTrainSearchResults;
import com.travel.train.model.trainticket.CJRTrainSearchResultsAvailibiltyObject;
import com.travel.train.model.trainticket.CJRTrainSearchResultsBody;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import com.travel.train.model.trainticket.CJRTrainUserFavourite;
import com.travel.train.model.trainticket.CJRTravelDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.m.p;

public final class c extends ai implements b {

    /* renamed from: a  reason: collision with root package name */
    public y<String> f27630a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<CJRTrainSearchInput> f27631b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<Integer> f27632c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<CJRTrainSearchResults> f27633d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<NetworkCustomError> f27634e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    public y<NetworkCustomError> f27635f = new y<>();

    /* renamed from: g  reason: collision with root package name */
    public com.travel.train.l.c f27636g = new com.travel.train.l.c();

    /* renamed from: h  reason: collision with root package name */
    public y<NetworkCustomError> f27637h = new y<>();

    /* renamed from: i  reason: collision with root package name */
    public y<Boolean> f27638i = new y<>();
    public y<Boolean> j = new y<>();
    public y<CJRTrainDetails> k = new y<>();
    public y<CJRNearByStationResult> l = new y<>();
    public y<Boolean> m = new y<>();
    public y<e> n = new y<>();
    public y<CJRTrainQuickBookFavourites> o = new y<>();
    public y<ArrayList<CJRTrainUserFavourite>> p = new y<>();
    public boolean q;
    public a r;
    private boolean s;
    private ArrayList<CJRTrainUserFavourite> t = new ArrayList<>();
    private final String u = "CJRTrainTravellerViewHolder";

    public c(a aVar, boolean z) {
        k.c(aVar, "mRepo");
        this.r = aVar;
        this.s = z;
    }

    public final void a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.f27638i.postValue(Boolean.TRUE);
        a aVar = this.r;
        if (aVar != null) {
            b bVar = this;
            aVar.a(bVar, bVar, hashMap, hashMap2);
        }
    }

    public final void b(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(hashMap, "headers");
        k.c(hashMap2, "urlParams");
        this.m.postValue(Boolean.TRUE);
        a aVar = this.r;
        if (aVar != null) {
            b bVar = this;
            aVar.d(bVar, bVar, hashMap, hashMap2);
        }
    }

    public final void a() {
        if (b()) {
            this.l.setValue(null);
        }
    }

    public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel != null) {
            if (iJRPaytmDataModel instanceof CJRTrainSearchResults) {
                this.f27638i.postValue(Boolean.FALSE);
                this.j.postValue(Boolean.TRUE);
                CJRTrainSearchResults cJRTrainSearchResults = (CJRTrainSearchResults) iJRPaytmDataModel;
                this.f27632c.setValue(cJRTrainSearchResults.getCode());
                a(cJRTrainSearchResults);
                d();
            } else if (iJRPaytmDataModel instanceof CJRTrainDetails) {
                this.m.postValue(Boolean.FALSE);
                this.k.postValue(iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRTrainQuickBookFavourites) {
                this.o.setValue(iJRPaytmDataModel);
                d();
            } else if (iJRPaytmDataModel instanceof CJRNearByStationResult) {
                this.l.setValue(iJRPaytmDataModel);
            }
        }
    }

    public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        Integer internalCode;
        com.travel.train.model.a aVar = new com.travel.train.model.a();
        if ((networkCustomError != null ? networkCustomError.networkResponse : null) != null) {
            NetworkResponse networkResponse = networkCustomError.networkResponse;
            if (networkResponse.data != null) {
                try {
                    byte[] bArr = networkResponse.data;
                    k.a((Object) bArr, "response.data");
                    Object a2 = new f().a(new String(bArr, d.f47971a), aVar.getClass());
                    k.a((Object) a2, "Gson().fromJson(jsonStri…NewErrorFormat.javaClass)");
                    aVar = (com.travel.train.model.a) a2;
                } catch (Exception unused) {
                }
            }
        }
        if ((iJRPaytmDataModel instanceof CJRTrainSearchResults) || (iJRPaytmDataModel instanceof CJRNearByStationResult)) {
            this.j.postValue(Boolean.TRUE);
            this.f27638i.postValue(Boolean.FALSE);
            if (i2 == 503) {
                this.f27634e.postValue(networkCustomError);
                return;
            }
            if (networkCustomError != null) {
                str = networkCustomError.getMessage();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (p.a(networkCustomError != null ? networkCustomError.getMessage() : null, "parsing_error", false)) {
                    this.f27635f.postValue(networkCustomError);
                    return;
                }
            }
            if (!(aVar == null || aVar.getStatus() == null)) {
                com.travel.train.model.b status = aVar.getStatus();
                k.a((Object) status, "cjrNewErrorFormat.status");
                if (status.getMessage() != null) {
                    com.travel.train.model.b status2 = aVar.getStatus();
                    k.a((Object) status2, "cjrNewErrorFormat.status");
                    com.travel.train.model.c message = status2.getMessage();
                    k.a((Object) message, "cjrNewErrorFormat.status.message");
                    if (!TextUtils.isEmpty(message.a())) {
                        com.travel.train.model.b status3 = aVar.getStatus();
                        k.a((Object) status3, "cjrNewErrorFormat.status");
                        com.travel.train.model.c message2 = status3.getMessage();
                        k.a((Object) message2, "cjrNewErrorFormat.status.message");
                        if (!TextUtils.isEmpty(message2.b())) {
                            if (aVar.getInternalCode() == null || (internalCode = aVar.getInternalCode()) == null || 250 != internalCode.intValue()) {
                                com.travel.train.l.c cVar = this.f27636g;
                                com.travel.train.model.b status4 = aVar.getStatus();
                                k.a((Object) status4, "cjrNewErrorFormat.status");
                                com.travel.train.model.c message3 = status4.getMessage();
                                k.a((Object) message3, "cjrNewErrorFormat.status.message");
                                String a3 = message3.a();
                                com.travel.train.model.b status5 = aVar.getStatus();
                                k.a((Object) status5, "cjrNewErrorFormat.status");
                                com.travel.train.model.c message4 = status5.getMessage();
                                k.a((Object) message4, "cjrNewErrorFormat.status.message");
                                cVar.a(a3, message4.b());
                                return;
                            }
                            this.f27632c.setValue(aVar.getInternalCode());
                            a((CJRTrainSearchResults) null);
                            return;
                        }
                    }
                }
            }
            if (networkCustomError == null || networkCustomError.getAlertTitle() == null || networkCustomError.getAlertMessage() == null) {
                this.f27637h.postValue(networkCustomError);
            } else {
                this.f27637h.postValue(networkCustomError);
            }
        } else if (iJRPaytmDataModel instanceof CJRTrainDetails) {
            this.m.postValue(Boolean.FALSE);
            e eVar = new e();
            eVar.a(i2);
            eVar.a(iJRPaytmDataModel);
            eVar.a(networkCustomError);
            this.n.postValue(eVar);
            if (aVar != null && aVar.getStatus() != null) {
                com.travel.train.model.b status6 = aVar.getStatus();
                k.a((Object) status6, "cjrNewErrorFormat.status");
                if (status6.getMessage() != null) {
                    com.travel.train.model.b status7 = aVar.getStatus();
                    k.a((Object) status7, "cjrNewErrorFormat.status");
                    com.travel.train.model.c message5 = status7.getMessage();
                    k.a((Object) message5, "cjrNewErrorFormat.status.message");
                    if (!TextUtils.isEmpty(message5.a())) {
                        com.travel.train.model.b status8 = aVar.getStatus();
                        k.a((Object) status8, "cjrNewErrorFormat.status");
                        com.travel.train.model.c message6 = status8.getMessage();
                        k.a((Object) message6, "cjrNewErrorFormat.status.message");
                        if (!TextUtils.isEmpty(message6.b())) {
                            com.travel.train.l.c cVar2 = this.f27636g;
                            com.travel.train.model.b status9 = aVar.getStatus();
                            k.a((Object) status9, "cjrNewErrorFormat.status");
                            com.travel.train.model.c message7 = status9.getMessage();
                            k.a((Object) message7, "cjrNewErrorFormat.status.message");
                            String a4 = message7.a();
                            com.travel.train.model.b status10 = aVar.getStatus();
                            k.a((Object) status10, "cjrNewErrorFormat.status");
                            com.travel.train.model.c message8 = status10.getMessage();
                            k.a((Object) message8, "cjrNewErrorFormat.status.message");
                            cVar2.a(a4, message8.b());
                        }
                    }
                }
            }
        }
    }

    public final void a(String str) {
        k.c(str, "errorMsg");
        this.f27630a.postValue(str);
    }

    public final void a(CJRTrainSearchInput cJRTrainSearchInput) {
        k.c(cJRTrainSearchInput, H5Param.MENU_REFRESH);
        this.f27631b.setValue(cJRTrainSearchInput);
    }

    public final void a(int i2) {
        this.f27632c.setValue(Integer.valueOf(i2));
    }

    public final void a(CJRTrainSearchResults cJRTrainSearchResults) {
        b(cJRTrainSearchResults);
        this.f27633d.setValue(cJRTrainSearchResults);
        d();
    }

    public final boolean b() {
        CJRNearByStationResult value = this.l.getValue();
        return (value == null || value.getNearByStations() == null || value.getNearByStations().size() <= 0) ? false : true;
    }

    public final void c() {
        if (this.s) {
            this.q = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0086 A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0099 A[Catch:{ Exception -> 0x0080 }, LOOP:2: B:37:0x0093->B:39:0x0099, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c6 A[Catch:{ Exception -> 0x0080 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d9 A[Catch:{ Exception -> 0x0080 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.travel.train.model.trainticket.CJRTrainSearchResults r12) {
        /*
            if (r12 == 0) goto L_0x00fe
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r0 = r12.getBody()
            if (r0 == 0) goto L_0x00fe
            com.travel.train.model.trainticket.CJRTrainSearchResultsBody r0 = r12.getBody()
            r1 = 0
            if (r0 == 0) goto L_0x0014
            java.util.List r0 = r0.getTrains()
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x00fe
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x00fe
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
            r3 = 0
            r4 = 0
        L_0x0026:
            if (r4 >= r2) goto L_0x006e
            java.lang.Object r5 = r0.get(r4)
            com.travel.train.model.trainticket.CJRTrainSearchResultsTrain r5 = (com.travel.train.model.trainticket.CJRTrainSearchResultsTrain) r5
            java.util.List r6 = r5.getClasses()
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            int r7 = r7.size()
            r8 = 0
        L_0x003a:
            if (r8 >= r7) goto L_0x0067
            if (r12 == 0) goto L_0x0064
            java.util.HashMap r9 = r12.getTrainClassesLinkedMap()
            if (r9 == 0) goto L_0x0064
            java.lang.Object r10 = r6.get(r8)
            boolean r9 = r9.containsKey(r10)
            if (r9 != 0) goto L_0x0064
            java.util.HashMap r9 = r12.getTrainClassesLinkedMap()
            if (r9 != 0) goto L_0x0057
            kotlin.g.b.k.a()
        L_0x0057:
            java.util.Map r9 = (java.util.Map) r9
            java.lang.Object r10 = r6.get(r8)
            java.lang.Object r11 = r6.get(r8)
            r9.put(r10, r11)
        L_0x0064:
            int r8 = r8 + 1
            goto L_0x003a
        L_0x0067:
            r6 = 1
            r5.setMIsCollapse(r6)
            int r4 = r4 + 1
            goto L_0x0026
        L_0x006e:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r12 == 0) goto L_0x0083
            com.travel.train.model.trainticket.CJRTrainSearchResultsMeta r2 = r12.getMeta()     // Catch:{ Exception -> 0x0080 }
            if (r2 == 0) goto L_0x0083
            java.util.HashMap r2 = r2.getClasses()     // Catch:{ Exception -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r12 = move-exception
            goto L_0x00f7
        L_0x0083:
            r2 = r1
        L_0x0084:
            if (r2 != 0) goto L_0x0089
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0080 }
        L_0x0089:
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ Exception -> 0x0080 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ Exception -> 0x0080 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x0080 }
        L_0x0093:
            boolean r3 = r2.hasNext()     // Catch:{ Exception -> 0x0080 }
            if (r3 == 0) goto L_0x00b3
            java.lang.Object r3 = r2.next()     // Catch:{ Exception -> 0x0080 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ Exception -> 0x0080 }
            r5 = r0
            java.util.Map r5 = (java.util.Map) r5     // Catch:{ Exception -> 0x0080 }
            r5.put(r4, r3)     // Catch:{ Exception -> 0x0080 }
            r12.setTrainClassesMap(r0)     // Catch:{ Exception -> 0x0080 }
            goto L_0x0093
        L_0x00b3:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Exception -> 0x0080 }
            r0.<init>()     // Catch:{ Exception -> 0x0080 }
            if (r12 == 0) goto L_0x00c4
            com.travel.train.model.trainticket.CJRTrainSearchResultsMeta r2 = r12.getMeta()     // Catch:{ Exception -> 0x0080 }
            if (r2 == 0) goto L_0x00c4
            java.util.HashMap r1 = r2.getQuota()     // Catch:{ Exception -> 0x0080 }
        L_0x00c4:
            if (r1 != 0) goto L_0x00c9
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0080 }
        L_0x00c9:
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Exception -> 0x0080 }
            java.util.Set r1 = r1.entrySet()     // Catch:{ Exception -> 0x0080 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0080 }
        L_0x00d3:
            boolean r2 = r1.hasNext()     // Catch:{ Exception -> 0x0080 }
            if (r2 == 0) goto L_0x00fe
            java.lang.Object r2 = r1.next()     // Catch:{ Exception -> 0x0080 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0080 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ Exception -> 0x0080 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0080 }
            r4 = r0
            java.util.Map r4 = (java.util.Map) r4     // Catch:{ Exception -> 0x0080 }
            r4.put(r3, r2)     // Catch:{ Exception -> 0x0080 }
            if (r12 == 0) goto L_0x00d3
            r12.setMTrainQuotaMap(r0)     // Catch:{ Exception -> 0x0080 }
            goto L_0x00d3
        L_0x00f7:
            java.lang.String r12 = r12.getMessage()
            com.paytm.utility.q.c(r12)
        L_0x00fe:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.train.k.c.b(com.travel.train.model.trainticket.CJRTrainSearchResults):void");
    }

    private final void d() {
        CJRTrainQuickBookFavourites value;
        CJRTrainSearchResultsBody body;
        if (this.s) {
            this.t.clear();
            y<CJRTrainSearchResults> yVar = this.f27633d;
            List<CJRTrainSearchResultsTrain> list = null;
            CJRTrainSearchResults value2 = yVar != null ? yVar.getValue() : null;
            if (!(value2 == null || (body = value2.getBody()) == null)) {
                list = body.getTrains();
            }
            if (!(list == null || list.size() <= 0 || (value = this.o.getValue()) == null || value.getBody() == null || value.getBody().getUserFavourites() == null)) {
                Iterator<CJRTrainUserFavourite> it2 = value.getBody().getUserFavourites().iterator();
                while (it2.hasNext()) {
                    CJRTrainUserFavourite next = it2.next();
                    if (next != null) {
                        for (CJRTrainSearchResultsTrain next2 : list) {
                            if (p.a(next.getTrainNumber(), next2.getTrainNumber(), true)) {
                                CJRTravelDetails matchRules = value.getBody().getMatchRules();
                                k.a((Object) matchRules, "quickBookResponse.body.getMatchRules()");
                                if (n.a(next, next2, matchRules.getSrp()) && !n.a(next2, next.getClassName())) {
                                    a(next, next2);
                                }
                            }
                        }
                    }
                }
            }
            this.p.postValue(this.t);
        }
    }

    private void a(CJRTrainUserFavourite cJRTrainUserFavourite, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain) {
        k.c(cJRTrainUserFavourite, "userFavourite");
        k.c(cJRTrainSearchResultsTrain, "train");
        if (!TextUtils.isEmpty(cJRTrainSearchResultsTrain.getDeparture()) && !TextUtils.isEmpty(cJRTrainSearchResultsTrain.getArrival())) {
            StringBuilder sb = new StringBuilder();
            cJRTrainUserFavourite.setmDepartureDateForQuickBook(cJRTrainSearchResultsTrain.getDeparture());
            sb.append(i.f(cJRTrainSearchResultsTrain.getDeparture()));
            String e2 = i.e(cJRTrainSearchResultsTrain.getDeparture());
            sb.append(", ");
            sb.append(e2);
            cJRTrainUserFavourite.setmDepartureDate(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i.f(cJRTrainSearchResultsTrain.getArrival()));
            String e3 = i.e(cJRTrainSearchResultsTrain.getArrival());
            sb2.append(", ");
            sb2.append(e3);
            cJRTrainUserFavourite.setmArrivalDate(sb2.toString());
            if (cJRTrainSearchResultsTrain.getMAvailability() != null) {
                ArrayList<CJRTrainSearchResultsAvailibiltyObject> mAvailability = cJRTrainSearchResultsTrain.getMAvailability();
                if (mAvailability == null) {
                    k.a();
                }
                Iterator<CJRTrainSearchResultsAvailibiltyObject> it2 = mAvailability.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    CJRTrainSearchResultsAvailibiltyObject next = it2.next();
                    if (p.a(next.getClassType(), cJRTrainUserFavourite.getClassName(), true)) {
                        if (!TextUtils.isEmpty(next.getStatus())) {
                            cJRTrainUserFavourite.setmAvailabilityStatus(next.getStatus());
                        }
                        if (!TextUtils.isEmpty(next.getTimeOfAvailability())) {
                            cJRTrainUserFavourite.setmStatusTime(next.getTimeOfAvailability());
                        }
                        if (!TextUtils.isEmpty(next.getFare())) {
                            cJRTrainUserFavourite.setFareDetail(next.getFare());
                        }
                        StringBuilder sb3 = new StringBuilder();
                        if (!TextUtils.isEmpty(next.getClassName())) {
                            sb3.append(next.getClassName());
                        }
                        if (!TextUtils.isEmpty(next.getClassType())) {
                            sb3.append(" (");
                            sb3.append(next.getClassType());
                            sb3.append(")");
                        }
                        cJRTrainUserFavourite.setClassFullName(sb3.toString());
                    }
                }
            }
            this.t.add(cJRTrainUserFavourite);
        }
    }
}
