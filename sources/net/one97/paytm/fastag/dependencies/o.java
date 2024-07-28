package net.one97.paytm.fastag.dependencies;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import net.one97.paytm.fastag.model.DeviceAccount;

public final class o {

    /* renamed from: g  reason: collision with root package name */
    private static o f13746g;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f13747a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f13748b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13749c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<String> f13750d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<DeviceAccount> f13751e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<Boolean> f13752f = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ConcurrentHashMap<String, Boolean> f13753h = new ConcurrentHashMap<>();

    public static o a() {
        if (f13746g == null) {
            f13746g = new o();
        }
        return f13746g;
    }
}
