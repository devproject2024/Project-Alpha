package net.one97.paytm.wallet.c;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import androidx.fragment.app.j;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.f;
import com.paytm.network.a;
import com.paytm.network.b.g;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytmmall.clpartifact.common.StoreFrontGAHandler;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;
import com.paytmmall.clpartifact.utils.SFInterface;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.view.viewmodel.HomeResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.common.b.d;
import net.one97.paytm.common.entity.shopping.CJRHomePageV2;
import net.one97.paytm.i.h;
import net.one97.paytm.j.c;
import net.one97.paytm.utils.l;
import net.one97.paytm.wallet.c.n;

public class n extends h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f70086a = n.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public RecyclerView f70087b;

    /* renamed from: c  reason: collision with root package name */
    private int f70088c;

    public void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        this.f70087b = new RecyclerView(getContext());
        this.f70088c = getArguments().getInt("deal_type", 123);
        try {
            if (this.f70088c == 321) {
                c.a();
                str = c.a("thank_you_page_promotion_banner_v2", (String) null);
            } else {
                c.a();
                String a2 = c.a("postpaymentdeals", (String) null);
                if (!TextUtils.isEmpty(a2)) {
                    if (this.f70088c == 123) {
                        str = a2 + "wallet-bank-post-transaction-deals";
                    } else {
                        str = a2 + "post-transaction-deals-entertainment";
                    }
                } else {
                    return;
                }
            }
            String str2 = str + com.paytm.utility.c.a((Context) getActivity(), true);
            if (str2 != null && !TextUtils.isEmpty(str2)) {
                if (URLUtil.isValidUrl(str2)) {
                    String a3 = l.a((Context) getActivity(), "PG page", "Summary Page");
                    HashMap<String, String> i2 = com.paytm.utility.a.i();
                    if (com.paytm.utility.a.m(getActivity())) {
                        d.a(getContext(), str2, new b() {
                            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                            }

                            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                                if (n.this.getActivity() != null && !n.this.getActivity().isFinishing() && n.this.isAdded() && !n.this.isDetached() && (iJRPaytmDataModel instanceof CJRHomePageV2) && new CJRHomePageV2().getErrorMsg() == null) {
                                    com.paytm.utility.d.a.a(new kotlin.g.a.a(iJRPaytmDataModel) {
                                        private final /* synthetic */ IJRPaytmDataModel f$1;

                                        {
                                            this.f$1 = r2;
                                        }

                                        public final Object invoke() {
                                            return n.AnonymousClass1.this.a(this.f$1);
                                        }
                                    });
                                }
                            }

                            /* access modifiers changed from: private */
                            public /* synthetic */ x a(IJRPaytmDataModel iJRPaytmDataModel) {
                                String a2 = g.a(g.a(iJRPaytmDataModel.getNetworkResponse().data));
                                SanitizedResponseModel sanitizedResponse = SFInterface.INSTANCE.getSanitizedResponse((HomeResponse) new f().a(a2, HomeResponse.class), false);
                                final a aVar = new a(sanitizedResponse.getRvWidgets(), sanitizedResponse.getGaListener());
                                n.this.f70087b.post(new Runnable() {
                                    public final void run() {
                                        n.this.f70087b.setLayoutManager(new LinearLayoutManager(n.this.getContext()));
                                        n.this.f70087b.setAdapter(aVar);
                                    }
                                });
                                return null;
                            }
                        }, i2, (Map<String, String>) null, a.C0715a.POST, a3, new CJRHomePageV2(), a.c.PAYMENTS, a.b.SILENT).a();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f70087b;
    }

    static class a extends RecyclerView.a {

        /* renamed from: a  reason: collision with root package name */
        List<com.paytmmall.clpartifact.modal.clpCommon.View> f70092a;

        /* renamed from: b  reason: collision with root package name */
        StoreFrontGAHandler f70093b;

        public a(List<com.paytmmall.clpartifact.modal.clpCommon.View> list, StoreFrontGAHandler storeFrontGAHandler) {
            this.f70092a = list;
            this.f70093b = storeFrontGAHandler;
        }

        public final int getItemViewType(int i2) {
            return ViewHolderFactory.getViewType(this.f70092a.get(i2).getType());
        }

        public final int getItemCount() {
            List<com.paytmmall.clpartifact.modal.clpCommon.View> list = this.f70092a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            return ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), (j) null, this.f70093b);
        }

        public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
            ((CLPBaseViewHolder) vVar).bind(this.f70092a.get(i2), (CLPBaseViewHolder.IParentListProvider) null);
        }
    }
}
