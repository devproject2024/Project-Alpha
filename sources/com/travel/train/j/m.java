package com.travel.train.j;

import android.content.Context;
import com.google.gsonhtcfix.f;
import com.travel.train.model.trainticket.CJRTrainRecentsItemModel;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.utility.l;
import org.json.JSONException;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final a f27577a = new a((byte) 0);

    public static final class a {

        public static final class b extends com.google.gsonhtcfix.c.a<List<? extends CJRTrainRecentsItemModel>> {
        }

        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:35:0x00d8 A[Catch:{ Exception -> 0x0125 }, LOOP:0: B:17:0x0045->B:35:0x00d8, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00dc A[EDGE_INSN: B:50:0x00dc->B:36:0x00dc ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(com.travel.train.model.trainticket.CJRTrainRecentsItemModel r11, java.lang.String r12, int r13, android.content.Context r14) {
            /*
                java.lang.String r0 = "listItem"
                kotlin.g.b.k.c(r11, r0)
                java.lang.String r0 = "keyName"
                kotlin.g.b.k.c(r12, r0)
                if (r14 != 0) goto L_0x000d
                return
            L_0x000d:
                java.lang.String r0 = "search_train_most_visited"
                boolean r0 = r12.equals(r0)
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x0022
                java.lang.String r0 = "train_ls_recent_searched_pref"
                boolean r0 = r12.equals(r0)
                if (r0 == 0) goto L_0x0020
                goto L_0x0022
            L_0x0020:
                r0 = 0
                goto L_0x0023
            L_0x0022:
                r0 = 1
            L_0x0023:
                java.util.List r3 = a(r14, r12)     // Catch:{ Exception -> 0x0125 }
                if (r3 != 0) goto L_0x0030
                java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ Exception -> 0x0125 }
                r3.<init>()     // Catch:{ Exception -> 0x0125 }
                java.util.List r3 = (java.util.List) r3     // Catch:{ Exception -> 0x0125 }
            L_0x0030:
                r4 = 0
                java.util.concurrent.CopyOnWriteArraySet r5 = new java.util.concurrent.CopyOnWriteArraySet     // Catch:{ Exception -> 0x0125 }
                r6 = r3
                java.util.Collection r6 = (java.util.Collection) r6     // Catch:{ Exception -> 0x0125 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x0125 }
                int r6 = r3.size()     // Catch:{ Exception -> 0x0125 }
                int r6 = r6 - r1
                if (r6 < 0) goto L_0x00de
                if (r6 < 0) goto L_0x00de
                r8 = r4
                r4 = 0
                r7 = 0
            L_0x0045:
                if (r0 != 0) goto L_0x00a1
                java.lang.String r9 = r11.getSourceCityCode()     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r10 = r3.get(r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r10 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r10     // Catch:{ Exception -> 0x0125 }
                java.lang.String r10 = r10.getSourceCityCode()     // Catch:{ Exception -> 0x0125 }
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r2)     // Catch:{ Exception -> 0x0125 }
                if (r9 == 0) goto L_0x00a1
                java.lang.String r9 = r11.getSourceCityName()     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r10 = r3.get(r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r10 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r10     // Catch:{ Exception -> 0x0125 }
                java.lang.String r10 = r10.getSourceCityName()     // Catch:{ Exception -> 0x0125 }
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r2)     // Catch:{ Exception -> 0x0125 }
                if (r9 == 0) goto L_0x00a1
                java.lang.String r9 = r11.getDestinationCityCode()     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r10 = r3.get(r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r10 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r10     // Catch:{ Exception -> 0x0125 }
                java.lang.String r10 = r10.getDestinationCityCode()     // Catch:{ Exception -> 0x0125 }
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r2)     // Catch:{ Exception -> 0x0125 }
                if (r9 == 0) goto L_0x00a1
                java.lang.String r9 = r11.getDestinationCityName()     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r10 = r3.get(r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r10 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r10     // Catch:{ Exception -> 0x0125 }
                java.lang.String r10 = r10.getDestinationCityName()     // Catch:{ Exception -> 0x0125 }
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r2)     // Catch:{ Exception -> 0x0125 }
                if (r9 == 0) goto L_0x00a1
                r7 = r5
                java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r7 = kotlin.a.k.a(r7, (int) r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r7 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r7     // Catch:{ Exception -> 0x0125 }
                goto L_0x00d4
            L_0x00a1:
                if (r0 == 0) goto L_0x00d6
                java.lang.String r9 = r11.getTrainName()     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r10 = r3.get(r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r10 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r10     // Catch:{ Exception -> 0x0125 }
                java.lang.String r10 = r10.getTrainName()     // Catch:{ Exception -> 0x0125 }
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r2)     // Catch:{ Exception -> 0x0125 }
                if (r9 == 0) goto L_0x00d6
                java.lang.String r9 = r11.getTrainNumber()     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r10 = r3.get(r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r10 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r10     // Catch:{ Exception -> 0x0125 }
                java.lang.String r10 = r10.getTrainNumber()     // Catch:{ Exception -> 0x0125 }
                boolean r9 = kotlin.m.p.a((java.lang.String) r9, (java.lang.String) r10, (boolean) r2)     // Catch:{ Exception -> 0x0125 }
                if (r9 == 0) goto L_0x00d6
                r7 = r5
                java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r7 = kotlin.a.k.a(r7, (int) r4)     // Catch:{ Exception -> 0x0125 }
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r7 = (com.travel.train.model.trainticket.CJRTrainRecentsItemModel) r7     // Catch:{ Exception -> 0x0125 }
            L_0x00d4:
                r8 = r7
                r7 = 1
            L_0x00d6:
                if (r4 == r6) goto L_0x00dc
                int r4 = r4 + 1
                goto L_0x0045
            L_0x00dc:
                r4 = r8
                goto L_0x00df
            L_0x00de:
                r7 = 0
            L_0x00df:
                if (r7 != 0) goto L_0x00f2
                int r1 = r5.size()     // Catch:{ Exception -> 0x0125 }
                if (r1 <= r13) goto L_0x00f2
                r13 = r5
                java.lang.Iterable r13 = (java.lang.Iterable) r13     // Catch:{ Exception -> 0x0125 }
                java.lang.Object r13 = kotlin.a.k.a(r13, (int) r2)     // Catch:{ Exception -> 0x0125 }
                r5.remove(r13)     // Catch:{ Exception -> 0x0125 }
                goto L_0x00f7
            L_0x00f2:
                if (r7 == 0) goto L_0x00f7
                r5.remove(r4)     // Catch:{ Exception -> 0x0125 }
            L_0x00f7:
                r5.add(r11)     // Catch:{ Exception -> 0x0125 }
                android.content.SharedPreferences r11 = r14.getSharedPreferences(r12, r2)     // Catch:{ Exception -> 0x0125 }
                android.content.SharedPreferences$Editor r11 = r11.edit()     // Catch:{ Exception -> 0x0125 }
                java.lang.String r12 = com.paytm.utility.b.n((android.content.Context) r14)     // Catch:{ Exception -> 0x0125 }
                com.google.gsonhtcfix.f r13 = new com.google.gsonhtcfix.f     // Catch:{ Exception -> 0x0125 }
                r13.<init>()     // Catch:{ Exception -> 0x0125 }
                java.lang.String r13 = r13.a((java.lang.Object) r5)     // Catch:{ Exception -> 0x0125 }
                android.content.SharedPreferences$Editor r11 = r11.putString(r12, r13)     // Catch:{ Exception -> 0x0125 }
                if (r0 == 0) goto L_0x0118
                java.lang.String r12 = "recentSearchedList"
                goto L_0x011a
            L_0x0118:
                java.lang.String r12 = "searchedcitieswithdate"
            L_0x011a:
                java.lang.String r13 = com.paytm.utility.b.n((android.content.Context) r14)     // Catch:{ Exception -> 0x0125 }
                android.content.SharedPreferences$Editor r11 = r11.putString(r12, r13)     // Catch:{ Exception -> 0x0125 }
                r11.apply()     // Catch:{ Exception -> 0x0125 }
            L_0x0125:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.m.a.a(com.travel.train.model.trainticket.CJRTrainRecentsItemModel, java.lang.String, int, android.content.Context):void");
        }

        public static List<CJRTrainRecentsItemModel> a(Context context, String str) {
            k.c(str, "keyName");
            if (context == null) {
                return null;
            }
            try {
                return (List) new f().a(context.getSharedPreferences(str, 0).getString(com.paytm.utility.b.n(context), (String) null), new C0492a().getType());
            } catch (JSONException e2) {
                l.a((Throwable) e2);
                return null;
            }
        }

        /* renamed from: com.travel.train.j.m$a$a  reason: collision with other inner class name */
        public static final class C0492a extends com.google.gsonhtcfix.c.a<List<? extends CJRTrainRecentsItemModel>> {
            C0492a() {
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x002b, code lost:
            r2 = (r2 = r19.getBody()).getTrainDetails();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(com.travel.train.model.searchResult.CJRSearchByTrainNumberModel r19, java.lang.String r20, com.travel.train.model.trainticket.CJRTrainLSSearchResult.Schedule r21, com.travel.train.model.CJRTrainSearchInput r22, android.content.Context r23) {
            /*
                r0 = r23
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                com.travel.train.model.trainticket.CJRTrainRecentsItemModel r15 = new com.travel.train.model.trainticket.CJRTrainRecentsItemModel
                r2 = 0
                r4 = 0
                r5 = 0
                r6 = 0
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r16 = 4095(0xfff, float:5.738E-42)
                r17 = 0
                r1 = r15
                r18 = r15
                r15 = r16
                r16 = r17
                r1.<init>(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
                r1 = 0
                if (r19 == 0) goto L_0x0037
                com.travel.train.model.searchResult.Body r2 = r19.getBody()
                if (r2 == 0) goto L_0x0037
                com.travel.train.model.searchResult.CJRSearchByTrainDetails r2 = r2.getTrainDetails()
                if (r2 == 0) goto L_0x0037
                java.lang.String r2 = r2.getTrainNumber()
                r3 = r2
                goto L_0x0038
            L_0x0037:
                r3 = r1
            L_0x0038:
                r2 = r18
                r2.setTrainNumber(r3)
                if (r19 == 0) goto L_0x0050
                com.travel.train.model.searchResult.Body r3 = r19.getBody()
                if (r3 == 0) goto L_0x0050
                com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r3.getTrainDetails()
                if (r3 == 0) goto L_0x0050
                java.lang.String r3 = r3.getTrainName()
                goto L_0x0051
            L_0x0050:
                r3 = r1
            L_0x0051:
                r2.setTrainName(r3)
                r3 = r20
                r2.setDateOfTravel(r3)
                if (r19 == 0) goto L_0x0072
                com.travel.train.model.searchResult.Body r3 = r19.getBody()
                if (r3 == 0) goto L_0x0072
                com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r3.getTrainDetails()
                if (r3 == 0) goto L_0x0072
                com.travel.train.model.searchResult.FromStation r3 = r3.getFromStation()
                if (r3 == 0) goto L_0x0072
                java.lang.String r3 = r3.getStationCode()
                goto L_0x0073
            L_0x0072:
                r3 = r1
            L_0x0073:
                r2.setSourceCityCode(r3)
                if (r19 == 0) goto L_0x0090
                com.travel.train.model.searchResult.Body r3 = r19.getBody()
                if (r3 == 0) goto L_0x0090
                com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r3.getTrainDetails()
                if (r3 == 0) goto L_0x0090
                com.travel.train.model.searchResult.FromStation r3 = r3.getFromStation()
                if (r3 == 0) goto L_0x0090
                java.lang.String r3 = r3.getStationName()
                if (r3 != 0) goto L_0x0098
            L_0x0090:
                if (r22 == 0) goto L_0x0097
                java.lang.String r3 = r22.getmSourceCityName()
                goto L_0x0098
            L_0x0097:
                r3 = r1
            L_0x0098:
                r2.setSourceCityName(r3)
                if (r21 == 0) goto L_0x00a2
                int r3 = r21.getSourceSelectedPosition()
                goto L_0x00a3
            L_0x00a2:
                r3 = 0
            L_0x00a3:
                r2.setSourceSelectedPosition(r3)
                if (r19 == 0) goto L_0x00bf
                com.travel.train.model.searchResult.Body r3 = r19.getBody()
                if (r3 == 0) goto L_0x00bf
                com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r3.getTrainDetails()
                if (r3 == 0) goto L_0x00bf
                com.travel.train.model.searchResult.ToStation r3 = r3.getToStation()
                if (r3 == 0) goto L_0x00bf
                java.lang.String r3 = r3.getStationCode()
                goto L_0x00c0
            L_0x00bf:
                r3 = r1
            L_0x00c0:
                r2.setDestinationCityCode(r3)
                if (r19 == 0) goto L_0x00e0
                com.travel.train.model.searchResult.Body r3 = r19.getBody()
                if (r3 == 0) goto L_0x00e0
                com.travel.train.model.searchResult.CJRSearchByTrainDetails r3 = r3.getTrainDetails()
                if (r3 == 0) goto L_0x00e0
                com.travel.train.model.searchResult.ToStation r3 = r3.getToStation()
                if (r3 == 0) goto L_0x00e0
                java.lang.String r3 = r3.getStationName()
                if (r3 != 0) goto L_0x00de
                goto L_0x00e0
            L_0x00de:
                r1 = r3
                goto L_0x00e6
            L_0x00e0:
                if (r22 == 0) goto L_0x00e6
                java.lang.String r1 = r22.getmDestCityName()
            L_0x00e6:
                r2.setDestinationCityName(r1)
                if (r21 == 0) goto L_0x00f0
                int r1 = r21.getDestSelectedPosition()
                goto L_0x00f1
            L_0x00f0:
                r1 = 1
            L_0x00f1:
                r2.setDestSelectedPosition(r1)
                r1 = 3
                java.lang.String r3 = "search_train_most_visited"
                a(r2, r3, r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.travel.train.j.m.a.a(com.travel.train.model.searchResult.CJRSearchByTrainNumberModel, java.lang.String, com.travel.train.model.trainticket.CJRTrainLSSearchResult$Schedule, com.travel.train.model.CJRTrainSearchInput, android.content.Context):void");
        }
    }
}
