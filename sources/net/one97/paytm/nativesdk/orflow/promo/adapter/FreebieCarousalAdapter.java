package net.one97.paytm.nativesdk.orflow.promo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import java.util.ArrayList;
import java.util.List;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.orflow.promo.model.Freebie;
import net.one97.paytm.nativesdk.orflow.promo.utils.PromoUtils;

public class FreebieCarousalAdapter extends RecyclerView.a<FreebieViewHolder> {
    private static int GRAT_MAX_SIZE = 4;
    public static int MAX_SIZE = 4;
    private List<Freebie> freebieList;
    private boolean isGratFreebie;
    private Context mContext;

    public FreebieCarousalAdapter(Context context, List<Freebie> list) {
        this.freebieList = list;
        this.mContext = context;
    }

    public FreebieCarousalAdapter(Context context, ArrayList<Freebie> arrayList, boolean z) {
        this(context, arrayList);
        this.isGratFreebie = z;
    }

    public FreebieViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new FreebieViewHolder(getCarousalView(this.mContext, R.layout.carousal_item), this.freebieList);
    }

    private View getCarousalView(Context context, int i2) {
        return LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
    }

    public void onBindViewHolder(FreebieViewHolder freebieViewHolder, int i2) {
        List<Freebie> list = this.freebieList;
        if (list != null && list.size() > i2 && !TextUtils.isEmpty(this.freebieList.get(i2).getImageUrl())) {
            b.b(this.mContext).a(this.freebieList.get(i2).getImageUrl()).a(freebieViewHolder.imageView);
            handleTexts(freebieViewHolder, this.freebieList.size() - getMaxSize(this.isGratFreebie), i2);
        }
    }

    private int getMaxSize(boolean z) {
        return z ? GRAT_MAX_SIZE : MAX_SIZE;
    }

    private void handleTexts(FreebieViewHolder freebieViewHolder, int i2, int i3) {
        if (i3 != getItemCount() - 1 || i2 == 0) {
            freebieViewHolder.llMoreItems.setVisibility(8);
            return;
        }
        freebieViewHolder.llMoreItems.setVisibility(0);
        freebieViewHolder.txvMoreItems.setText(getMoreText(i2));
    }

    private String getMoreText(int i2) {
        return "+ " + i2 + " more";
    }

    public int getItemCount() {
        List<Freebie> list = this.freebieList;
        if (list != null) {
            return list.size() <= getMaxSize(this.isGratFreebie) ? this.freebieList.size() : getMaxSize(this.isGratFreebie);
        }
        return 0;
    }

    public void updateList(List<Freebie> list) {
        this.freebieList = list;
        notifyDataSetChanged();
    }

    static class FreebieViewHolder extends RecyclerView.v {
        ImageView imageView;
        LinearLayout llMoreItems;
        TextView txvMoreItems;

        FreebieViewHolder(final View view, final List<Freebie> list) {
            super(view);
            this.imageView = (ImageView) view.findViewById(R.id.img_carousal);
            this.txvMoreItems = (TextView) view.findViewById(R.id.txv_more_text);
            this.llMoreItems = (LinearLayout) view.findViewById(R.id.ll_more);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    PromoUtils.startFreebieListActivity(view.getContext(), (List<Freebie>) list, true);
                }
            });
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(PromoUtils.convertDpToPixel(50, view.getContext()), PromoUtils.convertDpToPixel(50, view.getContext()));
            layoutParams.rightMargin = PromoUtils.convertDpToPixel(15, view.getContext());
            this.imageView.setLayoutParams(layoutParams);
        }
    }
}
