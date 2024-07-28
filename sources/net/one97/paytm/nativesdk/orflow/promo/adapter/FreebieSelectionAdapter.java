package net.one97.paytm.nativesdk.orflow.promo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.interfaces.IPromoSelectListener;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;

public class FreebieSelectionAdapter extends RecyclerView.a<FreebieSelectViewHolder> {
    /* access modifiers changed from: private */
    public List<Freebie> freebieList;
    private Context mContext;
    private IPromoSelectListener promoSelectListener;
    public int selectedItem = -1;
    private boolean viewMode;

    public FreebieSelectionAdapter(Context context, List<Freebie> list, boolean z, IPromoSelectListener iPromoSelectListener) {
        this.mContext = context;
        this.freebieList = list;
        this.viewMode = z;
        this.promoSelectListener = iPromoSelectListener;
    }

    public FreebieSelectViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FreebieSelectViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.lyt_fb_select, viewGroup, false), this.promoSelectListener);
    }

    public void onBindViewHolder(FreebieSelectViewHolder freebieSelectViewHolder, int i2) {
        freebieSelectViewHolder.bindView(this.mContext, this.freebieList.get(i2), this.viewMode, i2);
    }

    public int getItemCount() {
        List<Freebie> list = this.freebieList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    class FreebieSelectViewHolder extends RecyclerView.v {
        private ImageView imgFreebie;
        /* access modifiers changed from: private */
        public ViewGroup layoutParent;
        /* access modifiers changed from: private */
        public RadioButton radioButtonSelect;
        private TextView txvDescription;
        private TextView txvValue;

        FreebieSelectViewHolder(View view, final IPromoSelectListener iPromoSelectListener) {
            super(view);
            this.radioButtonSelect = (RadioButton) view.findViewById(R.id.rb_fb_select);
            this.imgFreebie = (ImageView) view.findViewById(R.id.img_freebie);
            this.txvDescription = (TextView) view.findViewById(R.id.txv_data);
            this.txvValue = (TextView) view.findViewById(R.id.txv_value);
            this.layoutParent = (ViewGroup) view.findViewById(R.id.ll_fb_select);
            this.layoutParent.setOnClickListener(new View.OnClickListener(FreebieSelectionAdapter.this) {
                public void onClick(View view) {
                    FreebieSelectionAdapter.this.selectedItem = FreebieSelectViewHolder.this.getAdapterPosition();
                    FreebieSelectionAdapter.this.notifyDataSetChanged();
                    iPromoSelectListener.onPromoSelect((Freebie) FreebieSelectionAdapter.this.freebieList.get(FreebieSelectionAdapter.this.selectedItem));
                }
            });
            this.radioButtonSelect.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(FreebieSelectionAdapter.this) {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (FreebieSelectViewHolder.this.radioButtonSelect.isChecked() && FreebieSelectionAdapter.this.selectedItem != FreebieSelectViewHolder.this.getAdapterPosition()) {
                        FreebieSelectViewHolder.this.layoutParent.performClick();
                    }
                }
            });
        }

        /* access modifiers changed from: package-private */
        public void bindView(Context context, Freebie freebie, boolean z, int i2) {
            boolean z2 = false;
            this.radioButtonSelect.setVisibility(z ? 8 : 0);
            if (!TextUtils.isEmpty(freebie.getImageUrl())) {
                b.b(this.imgFreebie.getContext()).a(freebie.getImageUrl()).a(this.imgFreebie);
            }
            this.txvDescription.setText(freebie.getName());
            this.txvValue.setText(getValue(context, freebie));
            RadioButton radioButton = this.radioButtonSelect;
            if (FreebieSelectionAdapter.this.selectedItem == i2) {
                z2 = true;
            }
            radioButton.setChecked(z2);
        }

        private String getValue(Context context, Freebie freebie) {
            return context.getString(R.string.rupee_symbol) + " " + freebie.getOfferPrice();
        }
    }
}
