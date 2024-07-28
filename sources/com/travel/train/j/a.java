package com.travel.train.j;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f27480a = a(Arrays.asList(new Integer[]{-957596, -686759, -416706, -1784274, -9977996, -10902850, -14642227, -5414233, -8366207}));

    /* renamed from: b  reason: collision with root package name */
    public static a f27481b = a(Arrays.asList(new Integer[]{-1739917, -1023342, -4560696, -6982195, -8812853, -10177034, -11549705, -11677471, -11684180, -8271996, -5319295, -30107, -2825897, -10929, -18611, -6190977, -7297874}));

    /* renamed from: c  reason: collision with root package name */
    private final List<Integer> f27482c;

    /* renamed from: d  reason: collision with root package name */
    private final Random f27483d = new Random(System.currentTimeMillis());

    private static a a(List<Integer> list) {
        return new a(list);
    }

    private a(List<Integer> list) {
        this.f27482c = list;
    }

    public final int a() {
        List<Integer> list = this.f27482c;
        return list.get(this.f27483d.nextInt(list.size())).intValue();
    }
}
