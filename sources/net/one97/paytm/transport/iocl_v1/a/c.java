package net.one97.paytm.transport.iocl_v1.a;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.iocl.R;
import net.one97.paytm.transport.iocl_v1.activity.AJRIOCLHomeActivity;
import net.one97.paytm.transport.iocl_v1.activity.IOCLBaseActivity;
import net.one97.paytm.transport.iocl_v1.b.d;
import net.one97.paytm.transport.iocl_v1.data.IOCLRedeemHistoryModel;
import net.one97.paytm.transport.iocl_v1.data.a;

public class c extends Fragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private d f14340a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f14341b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f14342c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public LinearLayoutManager f14343d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f14344e = 0;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.iocl_history_fragment_v1, viewGroup, false);
        if (!com.paytm.utility.b.c((Context) getActivity())) {
            getString(R.string.iocl_no_connection);
            com.paytm.utility.b.a((Context) (IOCLBaseActivity) getActivity(), getString(R.string.iocl_no_internet), false);
        } else if (com.paytm.utility.b.r((Context) getActivity())) {
            net.one97.paytm.transport.iocl_v1.b.b.a(getContext(), (b) this, this.f14344e);
            this.f14341b = true;
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.history_recycler_view);
            recyclerView.setNestedScrollingEnabled(false);
            this.f14343d = new LinearLayoutManager(getContext());
            recyclerView.setLayoutManager(this.f14343d);
            this.f14340a = new d(getContext());
            recyclerView.setAdapter(this.f14340a);
            recyclerView.addOnScrollListener(new RecyclerView.l() {
                public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
                    super.onScrolled(recyclerView, i2, i3);
                    int childCount = c.this.f14343d.getChildCount();
                    int itemCount = c.this.f14343d.getItemCount();
                    int findFirstVisibleItemPosition = c.this.f14343d.findFirstVisibleItemPosition();
                    if (!c.this.f14341b && !c.this.f14342c && i3 > 0 && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0 && itemCount >= net.one97.paytm.transport.iocl_v1.b.b.f14413d && com.paytm.utility.b.c((Context) c.this.getActivity())) {
                        if (com.paytm.utility.b.r((Context) c.this.getActivity())) {
                            Context context = c.this.getContext();
                            c cVar = c.this;
                            net.one97.paytm.transport.iocl_v1.b.b.a(context, (b) cVar, cVar.f14344e);
                        } else {
                            ((IOCLBaseActivity) c.this.getActivity()).f();
                        }
                        boolean unused = c.this.f14341b = true;
                    }
                }
            });
        } else {
            ((IOCLBaseActivity) getActivity()).f();
        }
        return inflate;
    }

    public final void a() {
        int childCount = this.f14343d.getChildCount();
        int itemCount = this.f14343d.getItemCount();
        int findFirstVisibleItemPosition = this.f14343d.findFirstVisibleItemPosition();
        if (!this.f14341b && !this.f14342c && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition >= 0 && itemCount >= net.one97.paytm.transport.iocl_v1.b.b.f14413d && com.paytm.utility.b.c((Context) getActivity())) {
            if (com.paytm.utility.b.r((Context) getActivity())) {
                if ((getActivity() instanceof AJRIOCLHomeActivity) && getActivity() != null) {
                    ((AJRIOCLHomeActivity) getActivity()).a(true);
                }
                net.one97.paytm.transport.iocl_v1.b.b.a(getContext(), (b) this, this.f14344e);
                this.f14341b = true;
                return;
            }
            ((IOCLBaseActivity) getActivity()).f();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof IOCLRedeemHistoryModel) {
            IOCLRedeemHistoryModel iOCLRedeemHistoryModel = (IOCLRedeemHistoryModel) iJRPaytmDataModel;
            if (this.f14344e == 0) {
                d dVar = this.f14340a;
                ArrayList<a> response = iOCLRedeemHistoryModel.getResponse();
                if (response == null || response.size() == 0) {
                    dVar.f14417a = response;
                } else {
                    ArrayList<a> arrayList = new ArrayList<>();
                    dVar.f14419c = dVar.a(response.get(0).f14451e);
                    arrayList.add(new a(dVar.f14419c));
                    arrayList.add(response.get(0));
                    for (int i2 = 1; i2 < response.size(); i2++) {
                        if (!dVar.f14419c.equalsIgnoreCase(dVar.a(response.get(i2).f14451e))) {
                            arrayList.add(new a(dVar.a(response.get(i2).f14451e)));
                            dVar.f14419c = dVar.a(response.get(i2).f14451e);
                        }
                        arrayList.add(response.get(i2));
                    }
                    dVar.f14417a = arrayList;
                    dVar.notifyDataSetChanged();
                }
            } else {
                this.f14340a.a(iOCLRedeemHistoryModel.getResponse());
            }
            this.f14341b = false;
            if (iOCLRedeemHistoryModel.getResponse() == null || iOCLRedeemHistoryModel.getResponse().size() == 0) {
                this.f14342c = true;
            } else {
                this.f14344e++;
            }
            if ((getActivity() instanceof AJRIOCLHomeActivity) && getActivity() != null) {
                ((AJRIOCLHomeActivity) getActivity()).a(false);
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f14341b = false;
        if ((getActivity() instanceof AJRIOCLHomeActivity) && getActivity() != null) {
            ((AJRIOCLHomeActivity) getActivity()).a(false);
            if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410) {
                ((AJRIOCLHomeActivity) getActivity()).f();
            }
        }
    }
}
