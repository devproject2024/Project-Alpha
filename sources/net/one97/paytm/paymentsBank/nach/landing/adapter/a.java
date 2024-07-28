package net.one97.paytm.paymentsBank.nach.landing.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.paytm.android.chat.bean.jsonbean.TxNotifyData;
import net.one97.paytm.bankCommon.utils.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.a.d;
import net.one97.paytm.paymentsBank.model.nach.Payload;
import net.one97.paytm.paymentsBank.nach.detailpage.NachMandateDetailActivity;
import net.one97.paytm.paymentsBank.pdc.activity.PDCPasscodePinActivity;

public final class a extends d<SectionListItem> implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    View.OnClickListener f18581c = new View.OnClickListener() {
        public final void onClick(View view) {
            a.this.a(view);
        }
    };

    public final /* synthetic */ void a(Object obj, d.b bVar, int i2) {
        String str;
        d.b bVar2 = bVar;
        SectionListItem sectionListItem = (SectionListItem) obj;
        int itemViewType = getItemViewType(i2);
        Payload payload = sectionListItem.getPayload();
        TextView textView = (TextView) bVar2.a(R.id.bankNameTv);
        TextView textView2 = (TextView) bVar2.a(R.id.frequencyTv);
        TextView textView3 = (TextView) bVar2.a(R.id.requestRupeesTv);
        TextView textView4 = (TextView) bVar2.a(R.id.dateTv);
        TextView textView5 = (TextView) bVar2.a(R.id.previousAmountTitle);
        TextView textView6 = (TextView) bVar2.a(R.id.prevfrequencyTv);
        TextView textView7 = (TextView) bVar2.a(R.id.prevrequestRupeesTv);
        if (itemViewType == 1) {
            textView.setText(sectionListItem.getSectionName());
        } else if (itemViewType == 2) {
            textView.setText(payload.getCorporate());
            textView3.setText(net.one97.paytm.bankCommon.mapping.a.ac(payload.getCurrentAmount()));
            textView2.setText(payload.getCurrentFrequency());
            String string = this.f17309a.getString(R.string.pb_nach_until_cancelled);
            String str2 = "";
            if (payload.getAmend().booleanValue()) {
                textView6.setVisibility(0);
                textView5.setVisibility(0);
                textView7.setVisibility(0);
                if ("VARIABLE".equals(payload.getCurrentAmountType())) {
                    str = string;
                    textView7.setText(this.f17309a.getString(R.string.pb_nach_upto_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getCurrentAmount())}));
                } else {
                    str = string;
                    textView7.setText(this.f17309a.getString(R.string.pb_nach_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getCurrentAmount())}));
                }
                if ("VARIABLE".equals(payload.getNewAmountType())) {
                    textView3.setText(this.f17309a.getString(R.string.pb_nach_upto_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getNewAmount())}));
                } else {
                    textView3.setText(this.f17309a.getString(R.string.pb_nach_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getNewAmount())}));
                }
                if (TextUtils.isEmpty(payload.getCurrentRecurringCode())) {
                    textView6.setText(payload.getCurrentFrequency());
                } else if ("OOFF".equals(payload.getCurrentRecurringCode())) {
                    textView6.setText(R.string.pb_nach_one_time);
                } else {
                    textView6.setText(payload.getCurrentFrequency());
                }
                if (TextUtils.isEmpty(payload.getNewRecurringCode())) {
                    textView2.setText(payload.getNewFrequency());
                } else if ("OOFF".equals(payload.getNewRecurringCode())) {
                    textView2.setText(R.string.pb_nach_one_time);
                } else {
                    textView2.setText(payload.getNewFrequency());
                }
                if (!TextUtils.isEmpty(payload.getNewEndDate())) {
                    str = this.f17309a.getString(R.string.pb_nach_to, new Object[]{payload.getNewEndDate()});
                }
                Context context = this.f17309a;
                int i3 = R.string.pb_nach_to_from;
                Object[] objArr = new Object[2];
                if (!TextUtils.isEmpty(payload.getNewStartDate())) {
                    str2 = payload.getNewStartDate();
                }
                objArr[0] = str2;
                objArr[1] = str;
                textView4.setText(context.getString(i3, objArr));
            } else {
                String str3 = string;
                textView6.setVisibility(8);
                textView5.setVisibility(8);
                textView7.setVisibility(8);
                if ("VARIABLE".equals(payload.getCurrentAmountType())) {
                    textView3.setText(this.f17309a.getString(R.string.pb_nach_upto_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getCurrentAmount())}));
                } else {
                    textView3.setText(this.f17309a.getString(R.string.pb_nach_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getCurrentAmount())}));
                }
                if (TextUtils.isEmpty(payload.getCurrentRecurringCode())) {
                    textView2.setText(payload.getCurrentFrequency());
                } else if ("OOFF".equals(payload.getCurrentRecurringCode())) {
                    textView2.setText(R.string.pb_nach_one_time);
                } else {
                    textView2.setText(payload.getCurrentFrequency());
                }
                if (!TextUtils.isEmpty(payload.getCurrentEndDate())) {
                    str3 = this.f17309a.getString(R.string.pb_nach_to, new Object[]{payload.getCurrentEndDate()});
                }
                Context context2 = this.f17309a;
                int i4 = R.string.pb_nach_to_from;
                Object[] objArr2 = new Object[2];
                if (!TextUtils.isEmpty(payload.getCurrentStartDate())) {
                    str2 = payload.getCurrentStartDate();
                }
                objArr2[0] = str2;
                objArr2[1] = str3;
                textView4.setText(context2.getString(i4, objArr2));
            }
            bVar2.a(R.id.acceptBtn).setTag(sectionListItem);
            bVar2.a(R.id.rejectBtn).setTag(sectionListItem);
        } else if (itemViewType == 4) {
            bVar2.itemView.setTag(sectionListItem);
            textView.setText(payload.getCorporate());
            textView3.setText(this.f17309a.getString(R.string.pb_nach_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getCurrentAmount())}));
            textView2.setText(payload.getCurrentFrequency());
        } else if (itemViewType == 3) {
            bVar2.itemView.setTag(sectionListItem);
            textView.setText(payload.getCorporate());
            textView3.setText(this.f17309a.getString(R.string.pb_nach_rupee, new Object[]{net.one97.paytm.bankCommon.mapping.a.ac(payload.getCurrentAmount())}));
            textView2.setText(payload.getCurrentFrequency());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Payload payload = ((SectionListItem) view.getTag()).getPayload();
        int id = view.getId();
        if (id == R.id.acceptBtn) {
            Intent intent = new Intent(this.f17309a, PDCPasscodePinActivity.class);
            intent.putExtra("ENTER_HEADER", "verifyPasscodeAndSendConsent");
            intent.putExtra("desc", this.f17309a.getString(R.string.pb_nach_passcode_desc_for_consent_accept, new Object[]{payload.getCorporate()}));
            intent.putExtra("isAcceptingMandate", true);
            intent.putExtra("postParams", f.a(payload.getAmend().booleanValue(), true, payload.getUmrn()));
            this.f17309a.startActivity(intent);
        } else if (id == R.id.rejectBtn) {
            Intent intent2 = new Intent(this.f17309a, PDCPasscodePinActivity.class);
            intent2.putExtra("ENTER_HEADER", "verifyPasscodeAndSendConsent");
            intent2.putExtra("desc", this.f17309a.getString(R.string.pb_nach_passcode_desc_for_consent_reject, new Object[]{payload.getCorporate()}));
            intent2.putExtra("isAcceptingMandate", false);
            intent2.putExtra("postParams", f.a(payload.getAmend().booleanValue(), false, payload.getUmrn()));
            this.f17309a.startActivity(intent2);
        }
    }

    public a(Context context) {
        super(context);
    }

    public final View a(Context context, ViewGroup viewGroup, int i2) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        if (i2 == 1) {
            return layoutInflater.inflate(R.layout.pb_nach_mandate_list_section_view_layout, viewGroup, false);
        }
        if (i2 == 2) {
            View inflate = layoutInflater.inflate(R.layout.pb_nach_mandate_awaiting_card_layout, viewGroup, false);
            inflate.findViewById(R.id.acceptBtn).setOnClickListener(this.f18581c);
            inflate.findViewById(R.id.rejectBtn).setOnClickListener(this.f18581c);
            return inflate;
        } else if (i2 == 4) {
            View inflate2 = layoutInflater.inflate(R.layout.pb_nach_mandate_accepted_card_layout, viewGroup, false);
            inflate2.findViewById(R.id.cancelledTv).setVisibility(8);
            inflate2.findViewById(R.id.arrowIv).setVisibility(0);
            inflate2.setOnClickListener(this);
            return inflate2;
        } else if (i2 != 3) {
            return null;
        } else {
            View inflate3 = layoutInflater.inflate(R.layout.pb_nach_mandate_accepted_card_layout, viewGroup, false);
            inflate3.findViewById(R.id.cancelledTv).setVisibility(0);
            inflate3.findViewById(R.id.arrowIv).setVisibility(8);
            inflate3.setOnClickListener(this);
            return inflate3;
        }
    }

    public final int getItemViewType(int i2) {
        if (((SectionListItem) a(i2)).isSection()) {
            return 1;
        }
        if ("PENDING".equalsIgnoreCase(((SectionListItem) a(i2)).getPayload().getStatus())) {
            return 2;
        }
        if ("ACCEPTED".equalsIgnoreCase(((SectionListItem) a(i2)).getPayload().getStatus())) {
            return 4;
        }
        return (TxNotifyData.UPI_STATUS_CANCELLED.equalsIgnoreCase(((SectionListItem) a(i2)).getPayload().getStatus()) || "REJECTED".equalsIgnoreCase(((SectionListItem) a(i2)).getPayload().getStatus())) ? 3 : 0;
    }

    public final void onClick(View view) {
        Payload payload = ((SectionListItem) view.getTag()).getPayload();
        Intent intent = new Intent(this.f17309a, NachMandateDetailActivity.class);
        intent.putExtra("key_payload", payload);
        this.f17309a.startActivity(intent);
    }
}
