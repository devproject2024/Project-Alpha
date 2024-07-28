package net.one97.paytm.passbook.mapping.a;

import com.google.gsonhtcfix.f;
import com.paytm.network.b.g;
import com.paytm.network.model.IJRPaytmDataModel;
import java.io.Reader;
import net.one97.paytm.passbook.beans.CJRCashWallet;
import net.one97.paytm.passbook.beans.CJRFlyoutBanner;
import net.one97.paytm.passbook.beans.CJRLedger;
import net.one97.paytm.passbook.beans.CustProductList;
import net.one97.paytm.passbook.beans.GiftVoucherResponseData;
import net.one97.paytm.passbook.beans.PreAuthTxnHistory;
import net.one97.paytm.passbook.beans.TollTagDeActivateModel;
import net.one97.paytm.passbook.beans.TollTagResponseDataModel;
import net.one97.paytm.passbook.beans.TolltagActivateModal;
import net.one97.paytm.passbook.beans.postcard.ReceivedLifafaDetailsResponse;
import net.one97.paytm.passbook.beans.postcard.SentLifafaDetailsResponse;
import net.one97.paytm.passbook.beans.postpaid.CJRPPUserProfileKycTnc;
import net.one97.paytm.passbook.beans.transactionsTag.AllTagsResponse;
import net.one97.paytm.passbook.beans.transactionsTag.UpdateTagsResponse;
import net.one97.paytm.passbook.beans.userinfov2.CJRUserInfoV2;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.spendanalytics.model.SpendAnalyticsResponse;
import net.one97.paytm.passbook.toll_kotlin.imported.model.TollWalletpsgHstryResponseModel;

public final class h implements g, i.a<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private i.a f57889a;

    /* renamed from: b  reason: collision with root package name */
    private g f57890b;

    /* renamed from: c  reason: collision with root package name */
    private f f57891c;

    public final /* synthetic */ void onResponse(Object obj) {
        String str;
        String str2 = "";
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        this.f57891c = new f();
        if (this.f57889a != null) {
            try {
                str = iJRPaytmDataModel.getNetworkResponse().headers.get("Content-Encoding");
                try {
                    if (iJRPaytmDataModel.getNetworkResponse().data != null) {
                        if (str == null || !str.equals("gzip")) {
                            str2 = new String(iJRPaytmDataModel.getNetworkResponse().data);
                        } else {
                            Reader a2 = g.a(iJRPaytmDataModel.getNetworkResponse().data);
                            if (a2 != null) {
                                str2 = g.a(a2);
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                str = str2;
            }
            if (str == null) {
                if (iJRPaytmDataModel instanceof CJRCashWallet) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(iJRPaytmDataModel.getNetworkResponse().statusCode);
                    ((CJRCashWallet) iJRPaytmDataModel).setStatusCode(sb.toString());
                }
                this.f57889a.onResponse(iJRPaytmDataModel);
            } else if (iJRPaytmDataModel instanceof CJRCashWallet) {
                CJRCashWallet cJRCashWallet = (CJRCashWallet) this.f57891c.a(str2, CJRCashWallet.class);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(iJRPaytmDataModel.getNetworkResponse().statusCode);
                cJRCashWallet.setStatusCode(sb2.toString());
                this.f57889a.onResponse(cJRCashWallet);
            } else if (iJRPaytmDataModel instanceof CJRFlyoutBanner) {
                this.f57889a.onResponse((CJRFlyoutBanner) this.f57891c.a(str2, CJRFlyoutBanner.class));
            } else if (iJRPaytmDataModel instanceof CustProductList) {
                this.f57889a.onResponse((CustProductList) this.f57891c.a(str2, CustProductList.class));
            } else if (iJRPaytmDataModel instanceof CJRLedger) {
                this.f57889a.onResponse((CJRLedger) this.f57891c.a(str2, CJRLedger.class));
            } else if (iJRPaytmDataModel instanceof CJRPPUserProfileKycTnc) {
                this.f57889a.onResponse((CJRPPUserProfileKycTnc) this.f57891c.a(str2, CJRPPUserProfileKycTnc.class));
            } else if (iJRPaytmDataModel instanceof GiftVoucherResponseData) {
                this.f57889a.onResponse((GiftVoucherResponseData) this.f57891c.a(str2, GiftVoucherResponseData.class));
            } else if (iJRPaytmDataModel instanceof TollTagResponseDataModel) {
                this.f57889a.onResponse((TollTagResponseDataModel) this.f57891c.a(str2, TollTagResponseDataModel.class));
            } else if (iJRPaytmDataModel instanceof PreAuthTxnHistory) {
                this.f57889a.onResponse((PreAuthTxnHistory) this.f57891c.a(str2, PreAuthTxnHistory.class));
            } else if (iJRPaytmDataModel instanceof TolltagActivateModal) {
                this.f57889a.onResponse((TolltagActivateModal) this.f57891c.a(str2, TolltagActivateModal.class));
            } else if (iJRPaytmDataModel instanceof TollTagDeActivateModel) {
                this.f57889a.onResponse((TollTagDeActivateModel) this.f57891c.a(str2, TollTagDeActivateModel.class));
            } else if (iJRPaytmDataModel instanceof TollWalletpsgHstryResponseModel) {
                this.f57889a.onResponse((TollWalletpsgHstryResponseModel) this.f57891c.a(str2, TollWalletpsgHstryResponseModel.class));
            } else if (iJRPaytmDataModel instanceof CJRUserInfoV2) {
                this.f57889a.onResponse((CJRUserInfoV2) this.f57891c.a(str2, CJRUserInfoV2.class));
            } else if (iJRPaytmDataModel instanceof SpendAnalyticsResponse) {
                this.f57889a.onResponse((SpendAnalyticsResponse) this.f57891c.a(str2, SpendAnalyticsResponse.class));
            } else if (iJRPaytmDataModel instanceof ReceivedLifafaDetailsResponse) {
                this.f57889a.onResponse((ReceivedLifafaDetailsResponse) this.f57891c.a(str2, ReceivedLifafaDetailsResponse.class));
            } else if (iJRPaytmDataModel instanceof SentLifafaDetailsResponse) {
                this.f57889a.onResponse((SentLifafaDetailsResponse) this.f57891c.a(str2, SentLifafaDetailsResponse.class));
            } else if (iJRPaytmDataModel instanceof AllTagsResponse) {
                this.f57889a.onResponse((AllTagsResponse) this.f57891c.a(str2, AllTagsResponse.class));
            } else if (iJRPaytmDataModel instanceof UpdateTagsResponse) {
                this.f57889a.onResponse((UpdateTagsResponse) this.f57891c.a(str2, UpdateTagsResponse.class));
            } else {
                this.f57889a.onResponse(this.f57891c.a(str2, iJRPaytmDataModel.getClass()));
            }
        }
    }

    public h(i.a aVar, g gVar) {
        this.f57889a = aVar;
        this.f57890b = gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onErrorResponse(int r4, com.paytm.network.model.IJRPaytmDataModel r5, com.paytm.network.model.NetworkCustomError r6) {
        /*
            r3 = this;
            net.one97.paytm.passbook.mapping.a.g r0 = r3.f57890b
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.paytm.network.model.NetworkResponse r0 = r6.networkResponse
            if (r0 == 0) goto L_0x009e
            int r4 = r0.statusCode
            java.util.Map<java.lang.String, java.lang.String> r1 = r0.headers
            java.lang.String r2 = "Content-Encoding"
            java.lang.Object r1 = r1.get(r2)
            java.lang.String r1 = (java.lang.String) r1
            byte[] r2 = r0.data
            if (r2 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0030
            java.lang.String r2 = "gzip"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0030
            byte[] r0 = r0.data
            java.io.Reader r0 = com.paytm.network.b.g.a((byte[]) r0)
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = com.paytm.network.b.g.a((java.io.Reader) r0)
            goto L_0x003b
        L_0x0030:
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r0.data
            r1.<init>(r0)
            r0 = r1
            goto L_0x003b
        L_0x0039:
            java.lang.String r0 = ""
        L_0x003b:
            r1 = 401(0x191, float:5.62E-43)
            if (r4 == r1) goto L_0x0098
            r1 = 410(0x19a, float:5.75E-43)
            if (r4 == r1) goto L_0x0098
            r1 = 480(0x1e0, float:6.73E-43)
            if (r4 == r1) goto L_0x0098
            r1 = 753(0x2f1, float:1.055E-42)
            if (r4 != r1) goto L_0x004c
            goto L_0x0098
        L_0x004c:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0097
            boolean r1 = r5 instanceof net.one97.paytm.passbook.beans.CJRAccountSummary     // Catch:{ Exception -> 0x008f }
            if (r1 == 0) goto L_0x0066
            com.google.gsonhtcfix.f r1 = r3.f57891c     // Catch:{ Exception -> 0x008f }
            java.lang.Class<net.one97.paytm.passbook.beans.CJRAccountSummary> r2 = net.one97.paytm.passbook.beans.CJRAccountSummary.class
            java.lang.Object r0 = r1.a((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.passbook.beans.CJRAccountSummary r0 = (net.one97.paytm.passbook.beans.CJRAccountSummary) r0     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.passbook.mapping.a.i$a r1 = r3.f57889a     // Catch:{ Exception -> 0x008f }
            r1.onResponse(r0)     // Catch:{ Exception -> 0x008f }
            return
        L_0x0066:
            boolean r1 = r5 instanceof net.one97.paytm.passbook.beans.SavingAccountDetailDataModel     // Catch:{ Exception -> 0x008f }
            if (r1 == 0) goto L_0x007a
            com.google.gsonhtcfix.f r1 = r3.f57891c     // Catch:{ Exception -> 0x008f }
            java.lang.Class<net.one97.paytm.passbook.beans.SavingAccountDetailDataModel> r2 = net.one97.paytm.passbook.beans.SavingAccountDetailDataModel.class
            java.lang.Object r0 = r1.a((java.lang.String) r0, r2)     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.passbook.beans.SavingAccountDetailDataModel r0 = (net.one97.paytm.passbook.beans.SavingAccountDetailDataModel) r0     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.passbook.mapping.a.i$a r1 = r3.f57889a     // Catch:{ Exception -> 0x008f }
            r1.onResponse(r0)     // Catch:{ Exception -> 0x008f }
            return
        L_0x007a:
            net.one97.paytm.passbook.mapping.a.g r0 = r3.f57890b     // Catch:{ Exception -> 0x008f }
            if (r0 == 0) goto L_0x008e
            java.lang.String r0 = new java.lang.String     // Catch:{ Exception -> 0x008f }
            com.paytm.network.model.NetworkResponse r1 = r6.getNetworkResponse()     // Catch:{ Exception -> 0x008f }
            byte[] r1 = r1.data     // Catch:{ Exception -> 0x008f }
            r0.<init>(r1)     // Catch:{ Exception -> 0x008f }
            net.one97.paytm.passbook.mapping.a.g r0 = r3.f57890b     // Catch:{ Exception -> 0x008f }
            r0.onErrorResponse(r4, r5, r6)     // Catch:{ Exception -> 0x008f }
        L_0x008e:
            return
        L_0x008f:
            net.one97.paytm.passbook.mapping.a.g r0 = r3.f57890b
            if (r0 == 0) goto L_0x0097
            r0.onErrorResponse(r4, r5, r6)
        L_0x0097:
            return
        L_0x0098:
            net.one97.paytm.passbook.mapping.a.g r0 = r3.f57890b
            r0.onErrorResponse(r4, r5, r6)
            return
        L_0x009e:
            net.one97.paytm.passbook.mapping.a.g r0 = r3.f57890b
            if (r0 == 0) goto L_0x00a5
            r0.onErrorResponse(r4, r5, r6)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.mapping.a.h.onErrorResponse(int, com.paytm.network.model.IJRPaytmDataModel, com.paytm.network.model.NetworkCustomError):void");
    }
}
