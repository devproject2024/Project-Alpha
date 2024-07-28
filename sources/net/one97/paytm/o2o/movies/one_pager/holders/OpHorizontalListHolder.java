package net.one97.paytm.o2o.movies.one_pager.holders;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.adapter.bd;
import net.one97.paytm.o2o.movies.one_pager.b;
import net.one97.paytm.o2o.movies.one_pager.c;
import net.one97.paytm.o2o.movies.one_pager.d;
import net.one97.paytm.o2o.movies.one_pager.f;
import net.one97.paytm.o2o.movies.utils.n;

public final class OpHorizontalListHolder extends b {

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f75672a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f75673b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f75674c;

    /* renamed from: d  reason: collision with root package name */
    private c.a f75675d;

    public OpHorizontalListHolder(View view, c.a aVar) {
        super(view);
        this.f75672a = (RecyclerView) view.findViewById(R.id.listRv);
        this.f75673b = (TextView) view.findViewById(R.id.titleTv);
        this.f75674c = (TextView) view.findViewById(R.id.viewAllTv);
        this.f75675d = aVar;
    }

    public final void a(d dVar, final Context context) {
        if (dVar != null && dVar.f75658b != null) {
            final f fVar = dVar.f75658b;
            if (!TextUtils.isEmpty(fVar.f75666d)) {
                n.a(this.f75674c, fVar.f75666d);
                this.f75674c.setText(fVar.f75666d);
                this.f75674c.setVisibility(0);
                if (!TextUtils.isEmpty(fVar.f75671i)) {
                    this.f75674c.setOnClickListener(new View.OnClickListener(fVar, context) {
                        private final /* synthetic */ f f$1;
                        private final /* synthetic */ Context f$2;

                        {
                            this.f$1 = r2;
                            this.f$2 = r3;
                        }

                        public final void onClick(View view) {
                            OpHorizontalListHolder.this.a(this.f$1, this.f$2, view);
                        }
                    });
                }
            } else {
                this.f75674c.setVisibility(8);
            }
            n.a(this.f75673b, fVar.f75667e);
            CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(context);
            customLinearLayoutManager.setOrientation(0);
            this.f75672a.setLayoutManager(customLinearLayoutManager);
            this.f75672a.setAdapter(new bd(context, fVar, this.f75675d));
            for (int i2 = 0; i2 < this.f75672a.getItemDecorationCount(); i2++) {
                this.f75672a.removeItemDecorationAt(i2);
            }
            this.f75672a.addItemDecoration(new RecyclerView.h() {
                public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
                    super.getItemOffsets(rect, view, recyclerView, sVar);
                    if (((RecyclerView.LayoutParams) view.getLayoutParams()).f4054c.getAdapterPosition() == 0) {
                        rect.left = n.a(20, context);
                    }
                    int i2 = 12;
                    if (fVar.f75663a.equals(b.BROWSE)) {
                        i2 = 28;
                    }
                    rect.right = n.a(i2, context);
                }
            });
        }
    }

    public class CustomLinearLayoutManager extends LinearLayoutManager {
        public boolean canScrollVertically() {
            return false;
        }

        public CustomLinearLayoutManager(Context context) {
            super(context);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(f fVar, Context context, View view) {
        net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b.launchDeeplink(fVar.f75671i, context, (String) null);
        net.one97.paytm.o2o.movies.common.c.c cVar = net.one97.paytm.o2o.movies.common.c.b.f75032a.f75033b;
        String str = net.one97.paytm.o2o.movies.common.b.b.f75006a;
        String str2 = fVar.f75667e;
        HashMap hashMap = new HashMap();
        hashMap.put(SDKConstants.EVENT_KEY_SCREEN_NAME, "/entertainment");
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75007b, "entertainment");
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75008c, "see_all_clicked");
        if (str2 != null && !TextUtils.isEmpty(str2)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.f75009d, str2);
        }
        if (com.paytm.utility.b.r(context)) {
            hashMap.put(net.one97.paytm.o2o.movies.common.b.b.q, com.paytm.utility.b.n(context));
        }
        hashMap.put(net.one97.paytm.o2o.movies.common.b.b.p, "entertainment");
        cVar.sendCustomEventWithMap(str, hashMap, context);
    }
}
