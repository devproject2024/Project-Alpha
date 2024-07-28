package com.travel.train.helper;

import com.paytm.utility.q;
import com.travel.train.model.trainticket.CJRTrainSearchResultsTrain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public final class f implements Comparator<CJRTrainSearchResultsTrain> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final SimpleDateFormat f27287a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static String f27288b = "CJRTrainListSort";

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return 0;
    }

    public static class b implements Comparator<CJRTrainSearchResultsTrain> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((CJRTrainSearchResultsTrain) obj, (CJRTrainSearchResultsTrain) obj2);
        }

        private static int a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2) {
            try {
                Date parse = f.f27287a.parse(cJRTrainSearchResultsTrain.getDeparture());
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                Date parse2 = f.f27287a.parse(cJRTrainSearchResultsTrain2.getDeparture());
                Calendar instance2 = Calendar.getInstance();
                instance2.setTime(parse2);
                return instance.getTimeInMillis() > instance2.getTimeInMillis() ? -1 : 1;
            } catch (ParseException e2) {
                String unused = f.f27288b;
                q.c(e2.getMessage());
                return 0;
            }
        }
    }

    public static class a implements Comparator<CJRTrainSearchResultsTrain> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((CJRTrainSearchResultsTrain) obj, (CJRTrainSearchResultsTrain) obj2);
        }

        private static int a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2) {
            try {
                Date parse = f.f27287a.parse(cJRTrainSearchResultsTrain.getArrival());
                Calendar instance = Calendar.getInstance();
                instance.setTime(parse);
                Date parse2 = f.f27287a.parse(cJRTrainSearchResultsTrain2.getArrival());
                Calendar instance2 = Calendar.getInstance();
                instance2.setTime(parse2);
                return instance.getTimeInMillis() > instance2.getTimeInMillis() ? -1 : 1;
            } catch (ParseException e2) {
                String unused = f.f27288b;
                q.c(e2.getMessage());
                return 0;
            }
        }
    }

    public static class c implements Comparator<CJRTrainSearchResultsTrain> {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            return a((CJRTrainSearchResultsTrain) obj, (CJRTrainSearchResultsTrain) obj2);
        }

        private static int a(CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain, CJRTrainSearchResultsTrain cJRTrainSearchResultsTrain2) {
            try {
                return f.f27287a.parse(cJRTrainSearchResultsTrain.getArrival()).getTime() - f.f27287a.parse(cJRTrainSearchResultsTrain.getDeparture()).getTime() > f.f27287a.parse(cJRTrainSearchResultsTrain2.getArrival()).getTime() - f.f27287a.parse(cJRTrainSearchResultsTrain2.getDeparture()).getTime() ? -1 : 1;
            } catch (ParseException e2) {
                String unused = f.f27288b;
                q.c(e2.getMessage());
                return 0;
            }
        }
    }
}
