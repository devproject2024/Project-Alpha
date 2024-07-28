package net.one97.paytm.vipcashback.f;

import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.sendbird.android.constant.StringSet;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.vipcashback.CashbackVoucherListModal;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.vipcashback.f.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final C0397a f20855a = new C0397a((byte) 0);

    /* renamed from: net.one97.paytm.vipcashback.f.a$a  reason: collision with other inner class name */
    public static final class C0397a {
        private C0397a() {
        }

        public /* synthetic */ C0397a(byte b2) {
            this();
        }

        public static com.paytm.network.a a(b bVar, String str, String str2, boolean z) {
            String str3;
            String str4;
            k.c(bVar, "apiListener");
            k.c(str, StringSet.filter);
            k.c(str2, "pageNo");
            k.a((Object) f.a(), "GTMHelper.getInstance()");
            String str5 = f.m() + "?filter[is_merchant]=" + z;
            if (!z) {
                str5 = str5 + "&sort=createdAt,Desc";
            }
            d.a aVar = d.f20859a;
            String d2 = d.a.d(str5, H5Param.PAGE, str2);
            d.a aVar2 = d.f20859a;
            String d3 = d.a.d(d2, ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, "10");
            if (z) {
                d.a aVar3 = d.f20859a;
                str3 = d.a.d(d3, "filter[type]", "VOUCHER");
            } else {
                d.a aVar4 = d.f20859a;
                str3 = d.a.d(d3, "filter[type]", "DEAL,VOUCHER");
            }
            if (z) {
                d.a aVar5 = d.f20859a;
                str4 = d.a.d(str3, "filter[client]", "PROMO");
            } else {
                d.a aVar6 = d.f20859a;
                str4 = d.a.d(str3, "filter[client]", "PROMO,DEAL");
            }
            String str6 = str4 + '&' + str;
            if (TextUtils.isEmpty(str6)) {
                return null;
            }
            d.a aVar7 = d.f20859a;
            com.paytm.network.b a2 = d.a.c().a(a.C0715a.GET).a(str6);
            d.a aVar8 = d.f20859a;
            return a2.a((Map<String, String>) d.a.b()).a((IJRPaytmDataModel) new CashbackVoucherListModal()).c("voucherlist").a(bVar).l();
        }
    }
}
