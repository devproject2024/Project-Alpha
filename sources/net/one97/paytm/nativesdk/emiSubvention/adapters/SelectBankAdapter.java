package net.one97.paytm.nativesdk.emiSubvention.adapters;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import com.bumptech.glide.e.h;
import java.util.ArrayList;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.emiSubvention.models.BankData;
import net.one97.paytm.nativesdk.emiSubvention.views.IBankDataProvider;

public class SelectBankAdapter extends RecyclerView.a<BaseViewHolder> {
    /* access modifiers changed from: private */
    public ArrayList<BankData> bankDataArrayList;
    /* access modifiers changed from: private */
    public IBankDataProvider bankDataProvider;

    public SelectBankAdapter(IBankDataProvider iBankDataProvider, ArrayList<BankData> arrayList) {
        this.bankDataArrayList = arrayList;
        this.bankDataProvider = iBankDataProvider;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return getViewHolder();
    }

    private BaseViewHolder getViewHolder() {
        return new BankNameViewHolder(getLayout());
    }

    private View getLayout() {
        return LayoutInflater.from(this.bankDataProvider.getContext()).inflate(R.layout.view_type_bank_item, (ViewGroup) null);
    }

    public void onBindViewHolder(BaseViewHolder baseViewHolder, int i2) {
        baseViewHolder.bindView(baseViewHolder.getAdapterPosition());
    }

    public int getItemCount() {
        ArrayList<BankData> arrayList = this.bankDataArrayList;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    abstract class BaseViewHolder extends RecyclerView.v {
        /* access modifiers changed from: package-private */
        public abstract void bindView(int i2);

        BaseViewHolder(View view) {
            super(view);
        }
    }

    class BankNameViewHolder extends BaseViewHolder {
        ImageView arrowImage;
        TextView bankDisableTextView;
        ImageView bankImage;
        TextView bankNameTextView;
        View bottomBorder;
        View bottomLastBorder;
        TextView headerTextView;
        View rootLayout;

        BankNameViewHolder(View view) {
            super(view);
            this.headerTextView = (TextView) view.findViewById(R.id.txv_header);
            this.bankNameTextView = (TextView) view.findViewById(R.id.txv_bank_name);
            this.bankDisableTextView = (TextView) view.findViewById(R.id.txv_emi_error);
            this.bankImage = (ImageView) view.findViewById(R.id.img_bank);
            this.arrowImage = (ImageView) view.findViewById(R.id.img_arrow);
            this.bottomBorder = view.findViewById(R.id.bottom_border);
            this.rootLayout = view.findViewById(R.id.root_layout);
            this.bottomLastBorder = view.findViewById(R.id.last_item_border);
        }

        /* access modifiers changed from: package-private */
        public void bindView(int i2) {
            BankData bankData = (BankData) SelectBankAdapter.this.bankDataArrayList.get(i2);
            setTextData(this.headerTextView, bankData.getTitle());
            setTextData(this.bankNameTextView, bankData.getBankName());
            handleTextData(bankData);
            if (!TextUtils.isEmpty(bankData.getBankLogoUrl())) {
                h hVar = new h();
                hVar.a(R.drawable.ic_paytm_payments_bank);
                hVar.c(R.drawable.native_ic_bank_error);
                b.b(SelectBankAdapter.this.bankDataProvider.getContext()).a(hVar).a(bankData.getBankLogoUrl()).a(this.bankImage);
            }
            handleBorder(bankData, i2);
            this.rootLayout.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    SelectBankAdapter selectBankAdapter = SelectBankAdapter.this;
                    BankNameViewHolder bankNameViewHolder = BankNameViewHolder.this;
                    selectBankAdapter.handleOnClick(bankNameViewHolder.getBankData(bankNameViewHolder.getAdapterPosition()));
                }
            });
        }

        /* access modifiers changed from: private */
        public BankData getBankData(int i2) {
            if (SelectBankAdapter.this.bankDataArrayList == null || i2 >= SelectBankAdapter.this.bankDataArrayList.size()) {
                return null;
            }
            return (BankData) SelectBankAdapter.this.bankDataArrayList.get(i2);
        }

        private void handleBorder(BankData bankData, int i2) {
            if (bankData.isLastData()) {
                this.bottomBorder.setVisibility(8);
                this.bottomLastBorder.setVisibility(0);
                return;
            }
            if (bankData.isEndData()) {
                this.bottomBorder.setVisibility(4);
            } else {
                this.bottomBorder.setVisibility(0);
            }
            this.bottomLastBorder.setVisibility(8);
        }

        private void handleTextData(BankData bankData) {
            if (!bankData.isEnabled()) {
                this.bankDisableTextView.setVisibility(0);
                this.bankNameTextView.setTextColor(androidx.core.content.b.c(SelectBankAdapter.this.bankDataProvider.getContext(), R.color.emiHeadingColor));
                return;
            }
            this.bankDisableTextView.setVisibility(8);
            this.bankNameTextView.setTextColor(androidx.core.content.b.c(SelectBankAdapter.this.bankDataProvider.getContext(), R.color.bank_name_color));
        }

        /* access modifiers changed from: package-private */
        public void setTextData(TextView textView, String str) {
            if (TextUtils.isEmpty(str)) {
                textView.setVisibility(8);
                return;
            }
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void handleOnClick(BankData bankData) {
        if (bankData != null) {
            this.bankDataProvider.handleOnClick(bankData);
        }
    }
}
