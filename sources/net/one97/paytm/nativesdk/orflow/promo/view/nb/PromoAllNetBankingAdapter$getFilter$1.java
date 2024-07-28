package net.one97.paytm.nativesdk.orflow.promo.view.nb;

import android.widget.Filter;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;

public final class PromoAllNetBankingAdapter$getFilter$1 extends Filter {
    final /* synthetic */ PromoAllNetBankingAdapter this$0;

    PromoAllNetBankingAdapter$getFilter$1(PromoAllNetBankingAdapter promoAllNetBankingAdapter) {
        this.this$0 = promoAllNetBankingAdapter;
    }

    /* access modifiers changed from: protected */
    public final Filter.FilterResults performFiltering(CharSequence charSequence) {
        k.c(charSequence, "charSequence");
        String obj = charSequence.toString();
        if (obj != null) {
            String lowerCase = obj.toLowerCase();
            k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
            CharSequence charSequence2 = lowerCase;
            if (charSequence2.length() == 0) {
                PromoAllNetBankingAdapter promoAllNetBankingAdapter = this.this$0;
                promoAllNetBankingAdapter.filteredSectionWrappers = promoAllNetBankingAdapter.sectionWrappers;
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it2 = this.this$0.sectionWrappers.iterator();
                while (it2.hasNext()) {
                    PromoPayOptionAdapterParam promoPayOptionAdapterParam = (PromoPayOptionAdapterParam) it2.next();
                    k.a((Object) promoPayOptionAdapterParam, "sectionWrapper");
                    if (!(promoPayOptionAdapterParam.getVIEWTYPE() == 7 || promoPayOptionAdapterParam.getVIEWTYPE() == 9 || promoPayOptionAdapterParam.getVIEWTYPE() == 10)) {
                        BaseDataModel data = promoPayOptionAdapterParam.getData();
                        if (data != null) {
                            String channelName = ((PayChannelOptions) data).getChannelName();
                            k.a((Object) channelName, "(sectionWrapper.data as …annelOptions).channelName");
                            if (channelName != null) {
                                String lowerCase2 = channelName.toLowerCase();
                                k.a((Object) lowerCase2, "(this as java.lang.String).toLowerCase()");
                                if (p.a((CharSequence) lowerCase2, charSequence2, false)) {
                                    arrayList.add(promoPayOptionAdapterParam);
                                }
                            } else {
                                throw new u("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions");
                        }
                    }
                }
                this.this$0.filteredSectionWrappers = arrayList;
            }
            Filter.FilterResults filterResults = new Filter.FilterResults();
            filterResults.values = this.this$0.filteredSectionWrappers;
            return filterResults;
        }
        throw new u("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        k.c(charSequence, "charSequence");
        k.c(filterResults, "filterResults");
        PromoAllNetBankingAdapter promoAllNetBankingAdapter = this.this$0;
        Object obj = filterResults.values;
        if (obj != null) {
            promoAllNetBankingAdapter.filteredSectionWrappers = (ArrayList) obj;
            if (this.this$0.filteredSectionWrappers.size() <= 0) {
                this.this$0.netBankingProviderListner.onEmptyList();
            } else {
                this.this$0.netBankingProviderListner.onNonEmptyList();
            }
            this.this$0.notifyDataSetChanged();
            return;
        }
        throw new u("null cannot be cast to non-null type java.util.ArrayList<net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam>");
    }
}
