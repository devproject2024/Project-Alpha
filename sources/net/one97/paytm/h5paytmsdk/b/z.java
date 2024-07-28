package net.one97.paytm.h5paytmsdk.b;

import android.app.Activity;
import com.alibaba.a.e;
import com.alipay.iap.android.common.b.c;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5Event;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.o;
import kotlin.u;
import net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity;

public final class z extends y {
    public z() {
        super("paytmRequestPermission");
    }

    public final boolean handleEvent(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        super.handleEvent(h5Event, h5BridgeContext);
        if (b(h5Event)) {
            if (h5Event == null) {
                k.a();
            }
            e param = h5Event.getParam();
            ArrayList arrayList = new ArrayList();
            String string = param.getString("permission");
            k.a((Object) string, "permissionToRequest");
            CharSequence charSequence = string;
            if (p.c(charSequence, (CharSequence) AppConstants.COMMA)) {
                List<String> b2 = p.b(charSequence, new String[]{AppConstants.COMMA});
                if (b2.isEmpty()) {
                    a(H5Event.Error.INVALID_PARAM, "invalid params");
                    return true;
                }
                for (String str : b2) {
                    CharSequence charSequence2 = str;
                    if (charSequence2.length() > 0) {
                        if (str != null) {
                            String[] a2 = a(p.b(charSequence2).toString());
                            if (a2 == null) {
                                c.e();
                                a(H5Event.Error.INVALID_PARAM, "invalid params");
                                return true;
                            }
                            kotlin.a.k.a(arrayList, (T[]) a2);
                        } else {
                            throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    }
                }
            } else {
                String[] a3 = a(string);
                if (a3 == null) {
                    c.e();
                    a(H5Event.Error.INVALID_PARAM, "invalid params");
                    return true;
                }
                kotlin.a.k.a(arrayList, (T[]) a3);
            }
            if (h5Event.getActivity() instanceof PaytmH5Activity) {
                Activity activity = h5Event.getActivity();
                if (activity != null) {
                    PaytmH5Activity paytmH5Activity = (PaytmH5Activity) activity;
                    Object[] array = arrayList.toArray(new String[0]);
                    if (array != null) {
                        paytmH5Activity.f17103a.addObserver(new a(this, paytmH5Activity));
                        paytmH5Activity.a((String[]) array);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.h5paytmsdk.ui.PaytmH5Activity");
                }
            }
        }
        return true;
    }

    static final class a implements Observer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ z f17068a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ PaytmH5Activity f17069b;

        a(z zVar, PaytmH5Activity paytmH5Activity) {
            this.f17068a = zVar;
            this.f17069b = paytmH5Activity;
        }

        public final void update(Observable observable, Object obj) {
            z zVar = this.f17068a;
            if (obj instanceof o) {
                o oVar = (o) obj;
                Object first = oVar.getFirst();
                if (first != null) {
                    Object[] objArr = (Object[]) first;
                    Object second = oVar.getSecond();
                    if (second != null) {
                        int[] iArr = (int[]) second;
                        HashMap hashMap = new HashMap();
                        int length = objArr.length;
                        int i2 = 0;
                        int i3 = 0;
                        while (i2 < length) {
                            Object obj2 = objArr[i2];
                            int i4 = i3 + 1;
                            if (obj2 != null) {
                                String b2 = z.b((String) obj2);
                                if (b2 != null) {
                                    hashMap.put(b2, Integer.valueOf(iArr[i3] == 0 ? 1 : 0));
                                }
                                i2++;
                                i3 = i4;
                            } else {
                                throw new u("null cannot be cast to non-null type kotlin.String");
                            }
                        }
                        zVar.a((Object) hashMap);
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.IntArray");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type kotlin.Array<*>");
                }
            } else {
                k.a(obj, "arg");
                zVar.a("success", obj);
                zVar.a((Object) null);
            }
            this.f17069b.f17103a.deleteObservers();
        }
    }
}
