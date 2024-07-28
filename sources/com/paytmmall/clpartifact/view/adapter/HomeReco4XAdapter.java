package com.paytmmall.clpartifact.view.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.databinding.ItemReco4xBinding;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.DataBindingUtils;
import com.paytmmall.clpartifact.utils.DeeplLinkHandler;
import com.paytmmall.clpartifact.utils.GaHandler;
import com.paytmmall.clpartifact.utils.ValidateViewResponse;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter;
import com.paytmmall.clpartifact.view.viewHolder.CLPCarouselItem4X;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import com.paytmmall.clpartifact.widgets.callback.CustomActionHelper;
import java.util.List;

public class HomeReco4XAdapter extends RecyclerView.a<CLPCarouselItem4X> {
    /* access modifiers changed from: private */
    public int CLICKED_OUTSIDE = -2;
    private int currentPosition;
    private CustomAction customAction;
    private IGAHandlerListener gaHandler;
    /* access modifiers changed from: private */
    public boolean isExpanded;
    private boolean isStackView;
    /* access modifiers changed from: private */
    public List<Item> items;
    private RecyclerView.LayoutManager layoutManager;
    private View mView;
    private int maxValue = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    public RecoRvClick recoRvClickListener;

    public HomeReco4XAdapter(List<Item> list, View view, IGAHandlerListener iGAHandlerListener, CustomAction customAction2, RecoRvClick recoRvClick, Boolean bool, RecyclerView.LayoutManager layoutManager2, boolean z) {
        this.items = list;
        this.gaHandler = iGAHandlerListener;
        this.mView = view;
        this.recoRvClickListener = recoRvClick;
        this.isExpanded = bool.booleanValue();
        this.customAction = customAction2;
        this.layoutManager = layoutManager2;
        this.isStackView = z;
        if (!z && !bool.booleanValue()) {
            this.maxValue = 2;
        }
    }

    public CLPCarouselItem4X onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return new CLPCarouselItem4X((ItemReco4xBinding) DataBindingUtils.getViewBinding(viewGroup, R.layout.item_reco_4x), this.gaHandler, this.customAction, Boolean.valueOf(this.isExpanded), this.isStackView);
    }

    public void onBindViewHolder(CLPCarouselItem4X cLPCarouselItem4X, int i2) {
        setGaData(i2);
        this.currentPosition = i2;
        cLPCarouselItem4X.bindItem(this.items.get(i2), this.mView, i2);
        if (!this.isExpanded && this.isStackView) {
            cLPCarouselItem4X.setWidthBasedOnPosition(i2);
        } else if (this.isExpanded) {
            if (i2 != 0) {
                cLPCarouselItem4X.itemView.setVisibility(4);
            }
            cLPCarouselItem4X.startOpenAnimation(0, this.layoutManager);
        }
        AnonymousClass1 r0 = new RecoRvClick() {
            public void closeCount(int i2) {
            }

            public void onItemClick(android.view.View view, int i2) {
                if (i2 >= 0 && i2 < HomeReco4XAdapter.this.items.size()) {
                    HomeReco4XAdapter homeReco4XAdapter = HomeReco4XAdapter.this;
                    homeReco4XAdapter.handleDeeplink(view, (Item) homeReco4XAdapter.items.get(i2), i2);
                }
            }

            public void closeClick(int i2) {
                if (i2 >= 0 && i2 < HomeReco4XAdapter.this.items.size()) {
                    if (!HomeReco4XAdapter.this.isExpanded) {
                        new Handler().postDelayed(new Runnable(i2) {
                            private final /* synthetic */ int f$1;

                            {
                                this.f$1 = r2;
                            }

                            public final void run() {
                                HomeReco4XAdapter.AnonymousClass1.this.lambda$closeClick$0$HomeReco4XAdapter$1(this.f$1);
                            }
                        }, 200);
                    } else if (i2 == HomeReco4XAdapter.this.CLICKED_OUTSIDE) {
                        HomeReco4XAdapter.this.recoRvClickListener.closeCount(i2);
                    } else {
                        HomeReco4XAdapter.this.recoRvClickListener.closeClick(i2);
                        HomeReco4XAdapter.this.onItemClosed(i2);
                    }
                }
            }

            public /* synthetic */ void lambda$closeClick$0$HomeReco4XAdapter$1(int i2) {
                HomeReco4XAdapter.this.onItemClosed(i2);
            }
        };
        TextView textView = (TextView) cLPCarouselItem4X.itemView.findViewById(R.id.reco_label);
        if (Build.VERSION.SDK_INT >= 23) {
            if (!isBillReminder(this.items.get(i2).getmUrlType(), cLPCarouselItem4X.getContext()) || cLPCarouselItem4X.itemView.getContext().checkSelfPermission("android.permission.READ_CONTACTS") != 0) {
                textView.setText(this.items.get(i2).getmName());
            } else {
                textView.setText(getContactDisplayNameByNumber(this.items.get(i2), cLPCarouselItem4X.getContext()));
            }
        } else if (isBillReminder(this.items.get(i2).getmUrlType(), cLPCarouselItem4X.getContext())) {
            textView.setText(getContactDisplayNameByNumber(this.items.get(i2), cLPCarouselItem4X.getContext()));
        } else {
            textView.setText(this.items.get(i2).getmName());
        }
        cLPCarouselItem4X.onClick(r0, this.items.get(i2));
    }

    public boolean isBillReminder(String str, Context context) {
        return context.getResources().getString(R.string.bill_mobile_prepaid).equals(str) || context.getResources().getString(R.string.bill_mobile_postpaid).equals(str);
    }

    public void onItemClosed(int i2) {
        if (i2 >= 0 && i2 < this.items.size()) {
            String str = "";
            String label = (this.items.get(i2).getCta() == null || TextUtils.isEmpty(this.items.get(i2).getCta().getLabel())) ? str : this.items.get(i2).getCta().getLabel();
            if (!TextUtils.isEmpty(this.items.get(i2).getTitle())) {
                str = this.items.get(i2).getTitle();
            }
            ValidateViewResponse.setRecoDisallowedSet(this.items.get(i2).getId() + label + str);
            GaHandler.getInstance().fireCrossCLick(this.items.get(i2), this.currentPosition);
            this.items.remove(i2);
            if (this.isExpanded) {
                notifyItemRemoved(i2);
            } else {
                notifyDataSetChanged();
            }
            RecoRvClick recoRvClick = this.recoRvClickListener;
            if (recoRvClick != null) {
                recoRvClick.closeCount(getItemCount());
            }
        }
    }

    private void setGaData(int i2) {
        if (this.items.size() > 0 && this.items.get(i2) != null && this.mView.getGaData() != null) {
            this.items.get(i2).setGaData(this.mView.getGaData());
        }
    }

    public int getItemCount() {
        List<Item> list = this.items;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return Math.min(this.maxValue, this.items.size());
    }

    public void setItem(List<Item> list) {
        if (list.size() <= 0) {
            list = this.items;
        }
        this.items = list;
        notifyItemChanged(0, this.items);
    }

    public void handleDeeplink(android.view.View view, Item item, int i2) {
        if (this.isExpanded || this.items.size() == 1) {
            DeeplLinkHandler.Companion.handleDeepLink(item, i2, this.gaHandler, item.getGaData(), CustomActionHelper.INSTANCE.getHostActivity(view.getContext(), this.customAction));
            return;
        }
        this.recoRvClickListener.onItemClick(view, i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getContactDisplayNameByNumber(com.paytmmall.clpartifact.modal.clpCommon.Item r9, android.content.Context r10) {
        /*
            r8 = this;
            android.net.Uri r0 = android.provider.ContactsContract.PhoneLookup.CONTENT_FILTER_URI
            java.lang.String r1 = r9.getmTitle()
            java.lang.String r1 = android.net.Uri.encode(r1)
            android.net.Uri r3 = android.net.Uri.withAppendedPath(r0, r1)
            android.content.ContentResolver r2 = r10.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r10 = r2.query(r3, r4, r5, r6, r7)
            if (r10 == 0) goto L_0x0030
            int r0 = r10.getCount()     // Catch:{ all -> 0x003a }
            if (r0 <= 0) goto L_0x0030
            r10.moveToNext()     // Catch:{ all -> 0x003a }
            java.lang.String r9 = "display_name"
            int r9 = r10.getColumnIndex(r9)     // Catch:{ all -> 0x003a }
            java.lang.String r9 = r10.getString(r9)     // Catch:{ all -> 0x003a }
            goto L_0x0034
        L_0x0030:
            java.lang.String r9 = r9.getmName()     // Catch:{ all -> 0x003a }
        L_0x0034:
            if (r10 == 0) goto L_0x0039
            r10.close()
        L_0x0039:
            return r9
        L_0x003a:
            r9 = move-exception
            if (r10 == 0) goto L_0x0040
            r10.close()
        L_0x0040:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter.getContactDisplayNameByNumber(com.paytmmall.clpartifact.modal.clpCommon.Item, android.content.Context):java.lang.String");
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(int i2) {
        this.maxValue = i2;
    }

    public int getActualCount() {
        List<Item> list = this.items;
        if (list != null) {
            return list.size();
        }
        return 0;
    }
}
