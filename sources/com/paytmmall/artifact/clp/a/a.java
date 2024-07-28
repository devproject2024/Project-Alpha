package com.paytmmall.artifact.clp.a;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.fragment.app.j;
import androidx.lifecycle.y;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.CLPResponse;
import com.paytmmall.clpartifact.modal.clpCommon.Page;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPDiffUtilCallback;
import com.paytmmall.clpartifact.utils.GAUtil;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.utils.ViewHolderFactory;
import com.paytmmall.clpartifact.utils.WidgetLayoutType;
import com.paytmmall.clpartifact.view.viewHolder.CLPBaseViewHolder;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: i  reason: collision with root package name */
    private static h.c<Page> f15568i = new h.c<Page>() {
        public final /* synthetic */ boolean a(Object obj, Object obj2) {
            return ((Page) obj).getId().equals(((Page) obj2).getId());
        }

        public final /* synthetic */ boolean b(Object obj, Object obj2) {
            return ((Page) obj).equals((Page) obj2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f15569a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public boolean f15570b;

    /* renamed from: c  reason: collision with root package name */
    private j f15571c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Object> f15572d;

    /* renamed from: e  reason: collision with root package name */
    private List<Page> f15573e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f15574f;

    /* renamed from: g  reason: collision with root package name */
    private IGAHandlerListener f15575g;

    /* renamed from: h  reason: collision with root package name */
    private CustomAction f15576h;

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public a(j jVar, boolean z, Map<String, Object> map, IGAHandlerListener iGAHandlerListener, CustomAction customAction) {
        this.f15571c = jVar;
        this.f15572d = map;
        this.f15573e = new ArrayList();
        this.f15570b = true;
        this.f15574f = z;
        this.f15575g = iGAHandlerListener;
        this.f15576h = customAction;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        if (i2 != 629) {
            return ViewHolderFactory.getViewHolder(viewGroup, ViewHolderFactory.parseViewType(WidgetLayoutType.Companion.getLayoutTypeNameNameFromIndex(i2)), this.f15571c, this.f15575g, this.f15576h);
        }
        ICLPCommunicationListener communicationListener = CLPArtifact.getInstance().getCommunicationListener();
        if (!this.f15574f || communicationListener == null || communicationListener.isMallApp()) {
            return new C0210a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.clp_rv_empty_item, viewGroup, false));
        }
        return new C0210a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.clp_home_empty_item, viewGroup, false));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        if (!(vVar instanceof C0210a)) {
            int a2 = a(i2);
            Page page = this.f15573e.get(a2);
            if ((vVar instanceof CLPBaseViewHolder) && page != null && page.getViews() != null && page.getViews().size() > 0) {
                View view = page.getViews().get(0);
                HashMap hashMap = new HashMap(this.f15572d);
                hashMap.put(GAUtil.KEY_PREV_SCREEN_TITLE, view.getTitle());
                hashMap.put(GAUtil.KEY_PREV_WIDGET_NAME, view.getTitle());
                hashMap.put(GAUtil.KEY_PREV_WIDGET_TYPE, view.getType());
                hashMap.put(GAUtil.KEY_PREV_WIDGET_POSITION, Integer.valueOf(a2 + 1));
                view.setGaData(hashMap);
                ((CLPBaseViewHolder) vVar).bind(view, (CLPBaseViewHolder.IParentListProvider) new CLPBaseViewHolder.IParentListProvider() {
                    public final List getParentList() {
                        return a.this.a();
                    }
                });
            }
            this.f15569a.postValue(Boolean.TRUE);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List a() {
        return this.f15573e;
    }

    public final int getItemViewType(int i2) {
        List<View> list;
        if (i2 == 0 && this.f15570b) {
            return 629;
        }
        Page page = this.f15573e.get(a(i2));
        if (page == null) {
            list = null;
        } else {
            list = page.getViews();
        }
        if (list != null) {
            return WidgetLayoutType.Companion.getLayoutTypeIndexfromName(list.get(0));
        }
        return 0;
    }

    private int a(int i2) {
        return this.f15570b ? i2 - 1 : i2;
    }

    public final int getItemCount() {
        List<Page> list = this.f15573e;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.f15573e.size() + (this.f15570b ? 1 : 0);
    }

    public final boolean a(List<Page> list, CLPResponse cLPResponse) {
        ArrayList arrayList = new ArrayList(this.f15573e);
        this.f15573e.addAll(list);
        boolean sanitizeCLPResponse = ValidateViewResponse.sanitizeCLPResponse(this.f15573e, cLPResponse);
        ValidateViewResponse.maintainClpViewList(this.f15573e);
        h.a(new CLPDiffUtilCallback(arrayList, this.f15573e)).a((RecyclerView.a) this);
        return sanitizeCLPResponse;
    }

    /* renamed from: com.paytmmall.artifact.clp.a.a$a  reason: collision with other inner class name */
    class C0210a extends RecyclerView.v {
        C0210a(android.view.View view) {
            super(view);
        }
    }
}
