package net.one97.paytm.o2o.movies.fragment;

import java.util.Comparator;
import net.one97.paytm.o2o.movies.common.movies.movieslot.CJRMovieSessionDetails;

/* renamed from: net.one97.paytm.o2o.movies.fragment.-$$Lambda$i$wvmCWrptZihsKFaDZT50fOT2zKk  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$i$wvmCWrptZihsKFaDZT50fOT2zKk implements Comparator {
    public static final /* synthetic */ $$Lambda$i$wvmCWrptZihsKFaDZT50fOT2zKk INSTANCE = new $$Lambda$i$wvmCWrptZihsKFaDZT50fOT2zKk();

    private /* synthetic */ $$Lambda$i$wvmCWrptZihsKFaDZT50fOT2zKk() {
    }

    public final int compare(Object obj, Object obj2) {
        return Float.compare(((CJRMovieSessionDetails) obj).getDistanceKm(), ((CJRMovieSessionDetails) obj2).getDistanceKm());
    }
}
