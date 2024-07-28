package net.one97.paytm.upi.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.MoneyTransferContract;
import net.one97.paytm.upi.requestmoney.a.e;
import net.one97.paytm.upi.util.UpiAppUtils;
import net.one97.paytm.upi.util.UpiUtils;

public class MoneyTransferRecentListAdapter extends RecyclerView.a<BeneficiaryViewHolder> {
    public static int MONEY_TRANSFER_PRESENTER = 0;
    public static int REQUEST_MONEY_PRESENTER = 1;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public MoneyTransferContract.Presenter moneyTransferPresenter;
    /* access modifiers changed from: private */
    public int presenterType;
    /* access modifiers changed from: private */
    public e.a requestMoneyPresenter;

    public MoneyTransferRecentListAdapter(Context context, int i2, MoneyTransferContract.Presenter presenter, e.a aVar) {
        this.mContext = context;
        this.moneyTransferPresenter = presenter;
        this.requestMoneyPresenter = aVar;
        this.presenterType = i2;
    }

    public BeneficiaryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view;
        if (this.presenterType == MONEY_TRANSFER_PRESENTER) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.upi_beneficiary_item_new, viewGroup, false);
        } else {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.upi_beneficiary_entry, viewGroup, false);
        }
        return new BeneficiaryViewHolder(view);
    }

    public void onBindViewHolder(BeneficiaryViewHolder beneficiaryViewHolder, int i2) {
        if (this.presenterType == MONEY_TRANSFER_PRESENTER) {
            this.moneyTransferPresenter.onBindRepositoryRowViewAtPosition(i2, beneficiaryViewHolder);
        } else {
            this.requestMoneyPresenter.a(i2, beneficiaryViewHolder);
        }
    }

    public int getItemCount() {
        if (this.presenterType == MONEY_TRANSFER_PRESENTER) {
            return this.moneyTransferPresenter.getRepositoriesRowsCount();
        }
        return this.requestMoneyPresenter.b();
    }

    public class BeneficiaryViewHolder extends RecyclerView.v implements MoneyTransferContract.MoneyTransferRecentListRowView {
        private TextView amount;
        private TextView bankName;
        private TextView date;
        private TextView headerBankLogoName;
        private TextView initials;
        private View listItem;
        private TextView name;
        private ImageView noNameIcon;
        private TextView number;
        private ImageView selected_icon;

        BeneficiaryViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.beneficiary_name);
            this.number = (TextView) view.findViewById(R.id.beneficiary_number);
            if (MoneyTransferRecentListAdapter.this.presenterType != MoneyTransferRecentListAdapter.MONEY_TRANSFER_PRESENTER) {
                this.amount = (TextView) view.findViewById(R.id.beneficiary_amount);
                this.bankName = (TextView) view.findViewById(R.id.beneficiary_bank_name);
            } else {
                this.date = (TextView) view.findViewById(R.id.date_tv);
            }
            this.headerBankLogoName = (TextView) view.findViewById(R.id.headerBankLogoName);
            this.initials = (TextView) view.findViewById(R.id.beneficiary_circle);
            this.listItem = view.findViewById(R.id.beneficiary_item);
            this.noNameIcon = (ImageView) view.findViewById(R.id.beneficiary_no_name_icon);
            this.selected_icon = (ImageView) view.findViewById(R.id.selected_icon);
        }

        public void setSelectedState(boolean z) {
            if (z) {
                this.name.setTextColor(b.c(MoneyTransferRecentListAdapter.this.mContext, R.color.color_999999));
                this.number.setTextColor(b.c(MoneyTransferRecentListAdapter.this.mContext, R.color.color_999999));
                if (this.selected_icon.getVisibility() == 8) {
                    this.selected_icon.setVisibility(0);
                    MoneyTransferRecentListAdapter.this.addflipAnimation(this.selected_icon, true);
                    return;
                }
                return;
            }
            this.name.setTextColor(b.c(MoneyTransferRecentListAdapter.this.mContext, R.color.color_222222));
            this.number.setTextColor(b.c(MoneyTransferRecentListAdapter.this.mContext, R.color.color_222222));
            if (this.selected_icon.getVisibility() == 0) {
                this.selected_icon.setVisibility(8);
                MoneyTransferRecentListAdapter.this.addflipAnimation(this.selected_icon, false);
            }
        }

        public void setAmount(String str) {
            this.amount.setText(str);
        }

        public void setBeneficiaryName(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.number.setText(str);
                this.initials.setText(UpiAppUtils.getInitialsSingle(str));
                return;
            }
            this.noNameIcon.setVisibility(0);
        }

        public void setDate(String str, String str2) {
            this.date.setText(String.format(MoneyTransferRecentListAdapter.this.mContext.getString(R.string.money_transfer_last_transfer), new Object[]{str, str2}));
        }

        public void setAccountNumberOrVpa(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (MoneyTransferRecentListAdapter.this.presenterType != MoneyTransferRecentListAdapter.MONEY_TRANSFER_PRESENTER) {
                this.name.setText(str);
            } else if (UpiAppUtils.checkIsVpa(str)) {
                this.name.setText(Html.fromHtml(String.format(MoneyTransferRecentListAdapter.this.mContext.getString(R.string.money_transfer_upi), new Object[]{str})));
            } else {
                this.name.setText(Html.fromHtml(String.format(MoneyTransferRecentListAdapter.this.mContext.getString(R.string.money_transfer_acc_no_with_placeholder), new Object[]{UpiAppUtils.insertSpaceAfterInterval(UpiUtils.maskNumber(str), 4)})));
            }
        }

        public void setRowIcon(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.initials.setVisibility(8);
                this.noNameIcon.setVisibility(0);
                MoneyTransferRecentListAdapter.this.setBankIcon(this.noNameIcon, str);
                return;
            }
            this.noNameIcon.setVisibility(8);
            this.initials.setVisibility(0);
        }

        public void setBankName(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.bankName.setVisibility(0);
                this.bankName.setText(str);
                return;
            }
            this.bankName.setVisibility(8);
        }

        public void setLogoBankName(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.headerBankLogoName.setVisibility(0);
                this.headerBankLogoName.setText(str);
                return;
            }
            this.headerBankLogoName.setVisibility(0);
            this.headerBankLogoName.setText(MoneyTransferRecentListAdapter.this.mContext.getString(R.string.bhim_upi));
        }

        public void setListRowClick(final int i2) {
            this.listItem.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (MoneyTransferRecentListAdapter.this.presenterType == MoneyTransferRecentListAdapter.MONEY_TRANSFER_PRESENTER && MoneyTransferRecentListAdapter.this.moneyTransferPresenter != null) {
                        MoneyTransferRecentListAdapter.this.moneyTransferPresenter.onRecentRowClick(i2);
                    } else if (MoneyTransferRecentListAdapter.this.requestMoneyPresenter != null) {
                        MoneyTransferRecentListAdapter.this.requestMoneyPresenter.a(i2);
                    }
                }
            });
        }

        public void setListRowLongClick(final int i2) {
            this.listItem.setOnLongClickListener(new View.OnLongClickListener() {
                public final boolean onLongClick(View view) {
                    MoneyTransferRecentListAdapter.this.moneyTransferPresenter.onRecentRowLongClick(i2);
                    return true;
                }
            });
        }
    }

    public void unSelectAll() {
        this.moneyTransferPresenter.unSelectAll();
        notifyDataSetChanged();
    }

    public void setBankIcon(ImageView imageView, String str) {
        Drawable a2 = b.a(this.mContext, R.drawable.ic_default_bank);
        if (!TextUtils.isEmpty(str)) {
            if (str.toUpperCase().startsWith("ICIC")) {
                a2 = b.a(this.mContext, R.drawable.icici);
            } else if (str.toUpperCase().startsWith("KOT")) {
                a2 = b.a(this.mContext, R.drawable.kotak);
            } else if (str.toUpperCase().startsWith("UTI")) {
                a2 = b.a(this.mContext, R.drawable.axis);
            } else if (str.toUpperCase().startsWith("HDF")) {
                a2 = b.a(this.mContext, R.drawable.hdfc);
            } else if (str.toUpperCase().startsWith("SBI")) {
                a2 = b.a(this.mContext, R.drawable.sbi);
            } else if (str.toUpperCase().startsWith("PNB")) {
                a2 = b.a(this.mContext, R.drawable.pnb);
            } else if (str.toUpperCase().startsWith("UPI")) {
                a2 = b.a(this.mContext, R.drawable.ic_bhim);
            } else if (str.toUpperCase().startsWith("PYT")) {
                a2 = b.a(this.mContext, R.drawable.paytm_logo_money_transfer);
            }
        }
        imageView.setImageDrawable(a2);
    }

    /* access modifiers changed from: private */
    public void addflipAnimation(View view, boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.mContext, R.anim.flip_anim);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationStart(Animation animation) {
            }
        });
    }
}
