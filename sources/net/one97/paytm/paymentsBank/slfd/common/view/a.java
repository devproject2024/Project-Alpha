package net.one97.paytm.paymentsBank.slfd.common.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.model.slfd.RedemptionResponseListItem;

public final class a extends RecyclerView.a<C0330a> {

    /* renamed from: a  reason: collision with root package name */
    private final List<RedemptionResponseListItem> f18993a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f18994b;

    public a(List<RedemptionResponseListItem> list, boolean z) {
        this.f18993a = list;
        this.f18994b = z;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        C0330a aVar = (C0330a) vVar;
        k.c(aVar, "holder");
        List<RedemptionResponseListItem> list = this.f18993a;
        RedemptionResponseListItem redemptionResponseListItem = list != null ? list.get(i2) : null;
        boolean z = this.f18994b;
        if (redemptionResponseListItem != null) {
            aVar.f18996b.setText(aVar.f18995a.getString(R.string.fd_num, new Object[]{redemptionResponseListItem.getFdNumber()}));
            if (z) {
                String status = redemptionResponseListItem.getStatus();
                if (status != null) {
                    switch (status.hashCode()) {
                        case -2062792981:
                            if (status.equals("FULL_REDEEMED")) {
                                aVar.b(redemptionResponseListItem);
                                aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_full_redemption));
                                aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_21c17a));
                                aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_full_redeem));
                                aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_21c17a));
                                return;
                            }
                            break;
                        case 746406716:
                            if (status.equals("FAIL_REDEEMED")) {
                                aVar.a(redemptionResponseListItem);
                                aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_failure));
                                aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_fd5c5c));
                                aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_fail_redeem));
                                aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_fd5c5c));
                                return;
                            }
                            break;
                        case 928583939:
                            if (status.equals("PENDING_REDEEMED")) {
                                aVar.a(redemptionResponseListItem);
                                aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_pending));
                                aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                                aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_pending_redeem));
                                aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                                return;
                            }
                            break;
                        case 1969559641:
                            if (status.equals("PARTIAL_REDEEMED")) {
                                aVar.b(redemptionResponseListItem);
                                aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_partial_redemption));
                                aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                                aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_pending_redeem));
                                aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                                return;
                            }
                            break;
                    }
                }
                aVar.a(redemptionResponseListItem);
                aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_pending));
                aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_pending_redeem));
                aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                return;
            }
            String status2 = redemptionResponseListItem.getStatus();
            if (status2 != null) {
                int hashCode = status2.hashCode();
                if (hashCode != -1867169789) {
                    if (hashCode != -1086574198) {
                        if (hashCode == -682587753 && status2.equals(SDKConstants.CUI_VALUE_PAYMENT_STATUS_PENDING)) {
                            aVar.a(redemptionResponseListItem);
                            aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_pending));
                            aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                            aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_pending_redeem));
                            aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                            return;
                        }
                    } else if (status2.equals(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
                        aVar.a(redemptionResponseListItem);
                        aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_failure));
                        aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_fd5c5c));
                        aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_fail_redeem));
                        aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_fd5c5c));
                        return;
                    }
                } else if (status2.equals("success")) {
                    aVar.b(redemptionResponseListItem);
                    String redemptionStatus = redemptionResponseListItem.getRedemptionStatus();
                    if (redemptionStatus != null) {
                        int hashCode2 = redemptionStatus.hashCode();
                        if (hashCode2 != -2062792981) {
                            if (hashCode2 == 1969559641 && redemptionStatus.equals("PARTIAL_REDEEMED")) {
                                aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_partial_redemption));
                                aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                                aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_pending_redeem));
                                aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
                                return;
                            }
                            return;
                        } else if (redemptionStatus.equals("FULL_REDEEMED")) {
                            aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_full_redemption));
                            aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_21c17a));
                            aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_full_redeem));
                            aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_21c17a));
                            return;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            aVar.a(redemptionResponseListItem);
            aVar.f18997c.setText(aVar.f18995a.getString(R.string.fd_pending));
            aVar.f18997c.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
            aVar.f18997c.setBackground(b.a(aVar.f18995a, R.drawable.pb_bg_fd_pending_redeem));
            aVar.f18998d.setTextColor(b.c(aVar.f18995a, net.one97.paytm.common.assets.R.color.color_ffa400));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_redeem_slfd, viewGroup, false);
        k.a((Object) inflate, "view");
        return new C0330a(inflate);
    }

    public final int getItemCount() {
        List<RedemptionResponseListItem> list = this.f18993a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* renamed from: net.one97.paytm.paymentsBank.slfd.common.view.a$a  reason: collision with other inner class name */
    public static final class C0330a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final Context f18995a;

        /* renamed from: b  reason: collision with root package name */
        final TextView f18996b;

        /* renamed from: c  reason: collision with root package name */
        final TextView f18997c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f18998d;

        /* renamed from: e  reason: collision with root package name */
        private final TextView f18999e;

        /* renamed from: f  reason: collision with root package name */
        private final TextView f19000f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0330a(View view) {
            super(view);
            k.c(view, "itemView");
            this.f18995a = view.getContext();
            View findViewById = view.findViewById(R.id.tv_fd_no);
            if (findViewById != null) {
                this.f18996b = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.tv_fd_redeem_status);
                if (findViewById2 != null) {
                    this.f18997c = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_fd_redeem_amount);
                    if (findViewById3 != null) {
                        this.f18999e = (TextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.tv_invested_amount);
                        if (findViewById4 != null) {
                            this.f19000f = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.tv_interest_amount);
                            if (findViewById5 != null) {
                                this.f18998d = (TextView) findViewById5;
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.widget.TextView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.TextView");
                }
                throw new u("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.TextView");
        }

        /* access modifiers changed from: package-private */
        public final void a(RedemptionResponseListItem redemptionResponseListItem) {
            String c2 = net.one97.paytm.bankCommon.mapping.a.c(redemptionResponseListItem.getRedemptionAmount());
            this.f18999e.setText(this.f18995a.getString(R.string.fd_amount, new Object[]{c2}));
            this.f19000f.setText(this.f18995a.getString(R.string.slfd_invested_breakup, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(redemptionResponseListItem.getRedemptionAmount()), redemptionResponseListItem.getInterestRate()}));
            this.f18998d.setText(this.f18995a.getString(R.string.slfd_interest_amount, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(net.one97.paytm.paymentsBank.slfd.b.a.a.a(redemptionResponseListItem.getRedemptionAmount(), redemptionResponseListItem.getNetAmountPayout())))}));
        }

        /* access modifiers changed from: package-private */
        public final void b(RedemptionResponseListItem redemptionResponseListItem) {
            String c2 = net.one97.paytm.bankCommon.mapping.a.c(redemptionResponseListItem.getNetAmountPayout());
            this.f18999e.setText(this.f18995a.getString(R.string.fd_amount, new Object[]{c2}));
            this.f19000f.setText(this.f18995a.getString(R.string.slfd_invested_breakup, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(redemptionResponseListItem.getRedemptionAmount()), redemptionResponseListItem.getInterestRate()}));
            this.f18998d.setText(this.f18995a.getString(R.string.slfd_interest_amount, new Object[]{net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(net.one97.paytm.paymentsBank.slfd.b.a.a.a(redemptionResponseListItem.getRedemptionAmount(), redemptionResponseListItem.getNetAmountPayout())))}));
        }
    }
}
