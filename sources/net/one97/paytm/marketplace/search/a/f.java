package net.one97.paytm.marketplace.search.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b.b;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.utils.GAUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.one97.paytm.c;
import net.one97.paytm.common.entity.CJRItem;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.shopping.CJRLayoutParams;
import net.one97.paytm.common.utility.d;
import net.one97.paytm.marketplace.search.activity.AJRSearchActivity;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.utils.j;

public final class f extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    public boolean f53426a;

    /* renamed from: b  reason: collision with root package name */
    private List<CJRHomePageItem> f53427b;

    /* renamed from: c  reason: collision with root package name */
    private List<CJRHomePageItem> f53428c;

    /* renamed from: d  reason: collision with root package name */
    private Context f53429d;

    /* renamed from: e  reason: collision with root package name */
    private String f53430e;

    /* renamed from: f  reason: collision with root package name */
    private String f53431f;

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        CJRHomePageItem cJRHomePageItem;
        a aVar = (a) vVar;
        List<CJRHomePageItem> list = this.f53428c;
        if (list != null) {
            cJRHomePageItem = list.get(i2);
            str = "related_services";
        } else {
            cJRHomePageItem = this.f53427b.get(i2);
            str = "top_services";
        }
        if (cJRHomePageItem != null) {
            cJRHomePageItem.setPromoName(this.f53430e);
            aVar.f53432a.setText(cJRHomePageItem.getName());
            List<CJRHomePageItem> list2 = this.f53427b;
            if (list2 == null || !list2.get(i2).isMore()) {
                List<CJRHomePageItem> list3 = this.f53428c;
                if (list3 != null && list3.get(i2).isMore()) {
                    aVar.f53434c.setImageDrawable(this.f53429d.getResources().getDrawable(R.drawable.ic_more_icon));
                } else if (!cJRHomePageItem.getImageUrl().isEmpty()) {
                    b.a.C0750a a2 = b.a(this.f53429d);
                    a2.f43753a = cJRHomePageItem.getImageUrl();
                    b.a.C0750a.a(a2, aVar.f53434c, (com.paytm.utility.b.b.b) null, 2);
                } else {
                    b.a.C0750a a3 = b.a(this.f53429d);
                    a3.f43753a = null;
                    b.a.C0750a.a(a3, aVar.f53434c, (com.paytm.utility.b.b.b) null, 2);
                }
            } else {
                aVar.f53434c.setImageDrawable(this.f53429d.getResources().getDrawable(R.drawable.ic_more_icon));
            }
            aVar.itemView.setOnClickListener(new View.OnClickListener(cJRHomePageItem, i2, str) {
                private final /* synthetic */ CJRHomePageItem f$1;
                private final /* synthetic */ int f$2;
                private final /* synthetic */ String f$3;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                }

                public final void onClick(View view) {
                    f.this.a(this.f$1, this.f$2, this.f$3, view);
                }
            });
            CJRLayoutParams layoutParam = cJRHomePageItem.getLayoutParam();
            if (layoutParam == null || TextUtils.isEmpty(layoutParam.getLabel())) {
                aVar.f53435d.setVisibility(4);
                aVar.f53436e.setVisibility(4);
                return;
            }
            aVar.f53435d.setVisibility(0);
            aVar.f53436e.setVisibility(0);
            aVar.f53435d.setText(layoutParam.getLabel());
        }
    }

    public f(Context context, List<CJRHomePageItem> list, List<CJRHomePageItem> list2, String str, String str2) {
        this.f53427b = list;
        this.f53428c = list2;
        this.f53429d = context;
        this.f53430e = str;
        this.f53431f = str2;
    }

    public final int getItemCount() {
        List<CJRHomePageItem> list = this.f53427b;
        if (list != null) {
            return list.size();
        }
        List<CJRHomePageItem> list2 = this.f53428c;
        if (list2 != null) {
            return list2.size();
        }
        return 0;
    }

    public class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f53432a;

        /* renamed from: b  reason: collision with root package name */
        TextView f53433b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f53434c;

        /* renamed from: d  reason: collision with root package name */
        TextView f53435d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f53436e;

        public a(View view) {
            super(view);
            this.f53434c = (ImageView) view.findViewById(R.id.grid_image_1);
            this.f53432a = (TextView) view.findViewById(R.id.grid_text_1);
            this.f53433b = (TextView) view.findViewById(R.id.tv_label);
            this.f53436e = (ImageView) view.findViewById(R.id.ic_raises);
            this.f53435d = (TextView) view.findViewById(R.id.tv_label);
        }
    }

    public final void a(ArrayList<CJRHomePageItem> arrayList, ArrayList<CJRHomePageItem> arrayList2) {
        this.f53427b = arrayList;
        this.f53428c = arrayList2;
        notifyDataSetChanged();
    }

    private static String a(Context context) {
        return context instanceof AJRSearchActivity ? AJRSearchActivity.a(((AJRSearchActivity) context).getIntent()) : "";
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        View view;
        List<CJRHomePageItem> list = this.f53427b;
        if (list == null || list.isEmpty()) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vertical_category_lyt_row_paytm, (ViewGroup) null);
            inflate.setLayoutParams(new ViewGroup.LayoutParams(viewGroup.getMeasuredWidth() / 4, -1));
            view = inflate;
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.popular_services_lyt_row_paytm, (ViewGroup) null);
        }
        return new a(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(CJRHomePageItem cJRHomePageItem, int i2, String str, View view) {
        String uRLType = cJRHomePageItem.getURLType();
        if (TextUtils.isEmpty(cJRHomePageItem.getDeeplink())) {
            cJRHomePageItem.setDeeplink(cJRHomePageItem.getURL());
        }
        String deeplink = cJRHomePageItem.getDeeplink();
        if (!(!TextUtils.isEmpty(deeplink) && (deeplink.startsWith("paytmmp") || deeplink.startsWith("paytmmall")))) {
            String url = cJRHomePageItem.getURL();
            StringBuilder sb = new StringBuilder();
            sb.append("paytmmp://");
            sb.append(uRLType);
            sb.append(!TextUtils.isEmpty(url) ? "?url=".concat(String.valueOf(url)) : "");
            cJRHomePageItem.setDeeplink(sb.toString());
        }
        String name = cJRHomePageItem.getName();
        HashMap hashMap = new HashMap();
        hashMap.put("user_id", net.one97.paytm.j.a.b(this.f53429d));
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/search" + a(this.f53429d));
        hashMap.put("event_label", name);
        String str2 = d.cv;
        hashMap.put(str2, "search" + a(this.f53429d));
        hashMap.put("event_category", "search");
        hashMap.put("event_action", "input_submitted");
        hashMap.put("search_type", str);
        hashMap.put("search_term", name);
        hashMap.put(CLPConstants.ARGUMENT_KEY_POSITION, Integer.valueOf(i2 + 1));
        hashMap.put(SDKConstants.EVENT_KEY_EVENT_LABEL4, this.f53431f);
        net.one97.paytm.j.a.b(GAUtil.CUSTOM_EVENT, (Map<String, Object>) hashMap, this.f53429d);
        j.a(this.f53429d, uRLType, (IJRDataModel) cJRHomePageItem, "", -1, (ArrayList<? extends CJRItem>) null, false, "", (c) null);
    }
}
