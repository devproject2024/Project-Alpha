package net.one97.paytm.upi.requestmoney.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.core.content.b;
import java.util.List;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.RoboTextView;
import net.one97.paytm.upi.common.upi.BankAccountDetails;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.util.UpiUtils;

public final class i extends BaseExpandableListAdapter {

    /* renamed from: a  reason: collision with root package name */
    List<UpiProfileDefaultBank> f69468a;

    /* renamed from: b  reason: collision with root package name */
    int f69469b = 0;

    /* renamed from: c  reason: collision with root package name */
    private Context f69470c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f69471d;

    /* renamed from: e  reason: collision with root package name */
    private RoboTextView f69472e;

    /* renamed from: f  reason: collision with root package name */
    private RadioButton f69473f;

    public final boolean areAllItemsEnabled() {
        return true;
    }

    public final Object getChild(int i2, int i3) {
        return null;
    }

    public final long getChildId(int i2, int i3) {
        return 0;
    }

    public final Object getGroup(int i2) {
        return null;
    }

    public final int getGroupCount() {
        return 1;
    }

    public final long getGroupId(int i2) {
        return 0;
    }

    public final boolean hasStableIds() {
        return false;
    }

    public final boolean isChildSelectable(int i2, int i3) {
        return true;
    }

    public i(Context context, List<UpiProfileDefaultBank> list) {
        this.f69470c = context;
        this.f69468a = list;
    }

    public final int getChildrenCount(int i2) {
        List<UpiProfileDefaultBank> list = this.f69468a;
        if (list == null || list.size() <= 0) {
            return 1;
        }
        return this.f69468a.size();
    }

    public final View getGroupView(int i2, boolean z, View view, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f69470c).inflate(R.layout.upi_blank_layout, (ViewGroup) null);
    }

    public final View getChildView(int i2, int i3, boolean z, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f69470c).inflate(R.layout.item_upi_request_money_vpa, (ViewGroup) null);
        this.f69471d = (RoboTextView) inflate.findViewById(R.id.tv_vpa_name);
        this.f69472e = (RoboTextView) inflate.findViewById(R.id.tv_bank_acc_no);
        this.f69473f = (RadioButton) inflate.findViewById(R.id.radio_btn_vpa);
        if (i3 == 0) {
            ImageView imageView = (ImageView) inflate.findViewById(R.id.drop_icon_iv);
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.up_arrow);
        }
        this.f69473f.setVisibility(0);
        UpiProfileDefaultBank upiProfileDefaultBank = this.f69468a.get(i3);
        BankAccountDetails.BankAccount creditBank = upiProfileDefaultBank.getCreditBank();
        if (!TextUtils.isEmpty(creditBank.getAccount()) && !TextUtils.isEmpty(creditBank.getBankName())) {
            RoboTextView roboTextView = this.f69472e;
            roboTextView.setText(creditBank.getBankName() + this.f69470c.getString(R.string.upi_acc_no_prefix) + UpiUtils.maskNumber(creditBank.getAccount()));
        }
        if (!TextUtils.isEmpty(upiProfileDefaultBank.getVirtualAddress())) {
            this.f69471d.setText(upiProfileDefaultBank.getVirtualAddress());
        }
        if (this.f69469b == i3) {
            this.f69471d.setFontType(4);
            this.f69472e.setTextColor(b.c(this.f69470c, R.color.color_222222));
            this.f69471d.setTextColor(b.c(this.f69470c, R.color.color_222222));
            this.f69473f.setChecked(true);
        }
        return inflate;
    }
}
