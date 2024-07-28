package com.paytmmall.clpartifact.view.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.a.a;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytmmall.clpartifact.R;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.listeners.ICLPCommunicationListener;
import com.paytmmall.clpartifact.listeners.IGAHandlerListener;
import com.paytmmall.clpartifact.modal.clpCommon.Item;
import com.paytmmall.clpartifact.modal.clpCommon.View;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.paytmmall.clpartifact.view.actions.RecoRvClick;
import com.paytmmall.clpartifact.view.adapter.HomeReco4XAdapter;
import com.paytmmall.clpartifact.widgets.callback.CustomAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;

public final class RecoExpandActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public final int CLICKED_OUTSIDE = -2;
    private HashMap _$_findViewCache;
    private Bitmap blurredBitmap;
    /* access modifiers changed from: private */
    public ArrayList<Item> filteredList;
    private LinearLayoutManager layoutManager;
    private HomeReco4XAdapter recoRVAdapter;
    private View view;

    public final void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final android.view.View _$_findCachedViewById(int i2) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        android.view.View view2 = (android.view.View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        android.view.View findViewById = findViewById(i2);
        this._$_findViewCache.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ ArrayList access$getFilteredList$p(RecoExpandActivity recoExpandActivity) {
        ArrayList<Item> arrayList = recoExpandActivity.filteredList;
        if (arrayList == null) {
            k.a("filteredList");
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r4) {
        /*
            r3 = this;
            super.onCreate(r4)
            int r4 = com.paytmmall.clpartifact.R.layout.activity_reco_expand
            r3.setContentView((int) r4)
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r0 = "reco_image"
            java.lang.String r4 = r4.getStringExtra(r0)
            r0 = 0
            java.io.FileInputStream r4 = r3.openFileInput(r4)     // Catch:{ Exception -> 0x0029 }
            java.lang.String r1 = "openFileInput(filename)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x0029 }
            r1 = r4
            java.io.InputStream r1 = (java.io.InputStream) r1     // Catch:{ Exception -> 0x0029 }
            android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch:{ Exception -> 0x0029 }
            r4.close()     // Catch:{ Exception -> 0x0027 }
            goto L_0x002e
        L_0x0027:
            r4 = move-exception
            goto L_0x002b
        L_0x0029:
            r4 = move-exception
            r1 = r0
        L_0x002b:
            r4.printStackTrace()
        L_0x002e:
            if (r1 == 0) goto L_0x004f
            com.paytmmall.clpartifact.utils.BlurBuilder$Companion r4 = com.paytmmall.clpartifact.utils.BlurBuilder.Companion
            r2 = r3
            android.content.Context r2 = (android.content.Context) r2
            android.graphics.Bitmap r4 = r4.blur(r2, r1)
            r3.blurredBitmap = r4
            int r4 = com.paytmmall.clpartifact.R.id.bgReco
            android.view.View r4 = r3._$_findCachedViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            android.graphics.Bitmap r1 = r3.blurredBitmap
            if (r1 != 0) goto L_0x004c
            java.lang.String r2 = "blurredBitmap"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x004c:
            r4.setImageBitmap(r1)
        L_0x004f:
            android.content.Intent r4 = r3.getIntent()
            java.lang.String r1 = "reco_view"
            java.io.Serializable r4 = r4.getSerializableExtra(r1)
            if (r4 == 0) goto L_0x00ef
            com.paytmmall.clpartifact.modal.clpCommon.View r4 = (com.paytmmall.clpartifact.modal.clpCommon.View) r4
            r3.view = r4
            com.paytmmall.clpartifact.utils.RecoUtils r4 = new com.paytmmall.clpartifact.utils.RecoUtils
            r4.<init>()
            com.paytmmall.clpartifact.modal.clpCommon.View r1 = r3.view
            if (r1 != 0) goto L_0x006e
            java.lang.String r2 = "view"
            kotlin.g.b.k.a((java.lang.String) r2)
        L_0x006e:
            java.util.List<com.paytmmall.clpartifact.modal.clpCommon.Item> r1 = r1.mItems
            if (r1 == 0) goto L_0x00e7
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.util.ArrayList r4 = r4.getFilteredItemList(r1)
            r3.filteredList = r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            if (r4 >= r1) goto L_0x009b
            r4 = r3
            com.paytmmall.clpartifact.view.activity.RecoExpandActivity r4 = (com.paytmmall.clpartifact.view.activity.RecoExpandActivity) r4
            android.content.res.Resources r4 = r4.getResources()
            int r1 = com.paytmmall.clpartifact.R.drawable.reco_show_less_up_arrow
            androidx.vectordrawable.a.a.i r4 = androidx.vectordrawable.a.a.i.a(r4, r1, r0)
            int r1 = com.paytmmall.clpartifact.R.id.recoShowLessButton
            android.view.View r1 = r3._$_findCachedViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r1.setCompoundDrawablesWithIntrinsicBounds(r0, r0, r4, r0)
            goto L_0x00b2
        L_0x009b:
            android.content.res.Resources r4 = r3.getResources()
            int r1 = com.paytmmall.clpartifact.R.drawable.reco_show_less_up_arrow
            androidx.vectordrawable.a.a.i r4 = androidx.vectordrawable.a.a.i.a(r4, r1, r0)
            int r1 = com.paytmmall.clpartifact.R.id.recoShowLessButton
            android.view.View r1 = r3._$_findCachedViewById(r1)
            android.widget.Button r1 = (android.widget.Button) r1
            android.graphics.drawable.Drawable r4 = (android.graphics.drawable.Drawable) r4
            r1.setCompoundDrawablesWithIntrinsicBounds(r0, r0, r4, r0)
        L_0x00b2:
            int r4 = com.paytmmall.clpartifact.R.id.recoExpandedRV
            android.view.View r4 = r3._$_findCachedViewById(r4)
            androidx.recyclerview.widget.RecyclerView r4 = (androidx.recyclerview.widget.RecyclerView) r4
            java.lang.String r0 = "recoExpandedRV"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r0)
            r3.setRecoRV(r4)
            int r4 = com.paytmmall.clpartifact.R.id.recoShowLessButton
            android.view.View r4 = r3._$_findCachedViewById(r4)
            android.widget.Button r4 = (android.widget.Button) r4
            com.paytmmall.clpartifact.view.activity.RecoExpandActivity$onCreate$3 r0 = new com.paytmmall.clpartifact.view.activity.RecoExpandActivity$onCreate$3
            r0.<init>(r3)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r4.setOnClickListener(r0)
            int r4 = com.paytmmall.clpartifact.R.id.bgReco
            android.view.View r4 = r3._$_findCachedViewById(r4)
            android.widget.ImageView r4 = (android.widget.ImageView) r4
            com.paytmmall.clpartifact.view.activity.RecoExpandActivity$onCreate$4 r0 = new com.paytmmall.clpartifact.view.activity.RecoExpandActivity$onCreate$4
            r0.<init>(r3)
            android.view.View$OnClickListener r0 = (android.view.View.OnClickListener) r0
            r4.setOnClickListener(r0)
            return
        L_0x00e7:
            kotlin.u r4 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> /* = java.util.ArrayList<com.paytmmall.clpartifact.modal.clpCommon.Item> */"
            r4.<init>(r0)
            throw r4
        L_0x00ef:
            kotlin.u r4 = new kotlin.u
            java.lang.String r0 = "null cannot be cast to non-null type com.paytmmall.clpartifact.modal.clpCommon.View"
            r4.<init>(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytmmall.clpartifact.view.activity.RecoExpandActivity.onCreate(android.os.Bundle):void");
    }

    private final void setRecoRV(RecyclerView recyclerView) {
        HomeReco4XAdapter homeReco4XAdapter = this.recoRVAdapter;
        if (homeReco4XAdapter == null) {
            RecoRvClick recoExpandActivity$setRecoRV$clickListener$1 = new RecoExpandActivity$setRecoRV$clickListener$1(this);
            this.layoutManager = new LinearLayoutManager(this);
            ArrayList<Item> arrayList = this.filteredList;
            if (arrayList == null) {
                k.a("filteredList");
            }
            List list = arrayList;
            View view2 = this.view;
            if (view2 == null) {
                k.a("view");
            }
            Boolean bool = Boolean.TRUE;
            LinearLayoutManager linearLayoutManager = this.layoutManager;
            if (linearLayoutManager == null) {
                k.a("layoutManager");
            }
            this.recoRVAdapter = new HomeReco4XAdapter(list, view2, (IGAHandlerListener) null, (CustomAction) null, recoExpandActivity$setRecoRV$clickListener$1, bool, linearLayoutManager, false);
            LinearLayoutManager linearLayoutManager2 = this.layoutManager;
            if (linearLayoutManager2 == null) {
                k.a("layoutManager");
            }
            recyclerView.setLayoutManager(linearLayoutManager2);
            recyclerView.setAdapter(this.recoRVAdapter);
            recyclerView.addOnItemTouchListener(new RecoExpandActivity$setRecoRV$1(this, recyclerView));
        } else if (homeReco4XAdapter != null) {
            ArrayList<Item> arrayList2 = this.filteredList;
            if (arrayList2 == null) {
                k.a("filteredList");
            }
            homeReco4XAdapter.setItem(arrayList2);
        }
    }

    /* access modifiers changed from: private */
    public final void startCloseAnimation(int i2, RecyclerView.LayoutManager layoutManager2) {
        int i3 = i2 - 1;
        android.view.View findViewByPosition = layoutManager2.findViewByPosition(i3);
        if (findViewByPosition != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(findViewByPosition.getContext(), R.anim.sf_item_go_up);
            k.a((Object) loadAnimation, "AnimationUtils.loadAnima…    R.anim.sf_item_go_up)");
            findViewByPosition.startAnimation(loadAnimation);
            loadAnimation.setAnimationListener(new RecoExpandActivity$startCloseAnimation$1(this, i3, layoutManager2, findViewByPosition));
        }
    }

    public final void onBackPressed() {
        goBack();
    }

    public final void goBack() {
        CLPArtifact instance = CLPArtifact.getInstance();
        k.a((Object) instance, "CLPArtifact.getInstance()");
        ICLPCommunicationListener communicationListener = instance.getCommunicationListener();
        Context context = this;
        communicationListener.sendCustomGTMEvents(context, getString(R.string.carousel_icon_4x), getString(R.string.show_less_clicked), "", "", getString(R.string.recoExpanded), getString(R.string.verticalId));
        a a2 = a.a(context);
        k.a((Object) a2, "LocalBroadcastManager.getInstance(this)");
        Intent intent = new Intent(CLPConstants.RECO_LOCALBROADCAST);
        View view2 = this.view;
        if (view2 == null) {
            k.a("view");
        }
        intent.putExtra(CLPConstants.RECO_DATA, view2);
        a2.a(intent);
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            k.a("layoutManager");
        }
        if (linearLayoutManager.getChildCount() > 1) {
            LinearLayoutManager linearLayoutManager2 = this.layoutManager;
            if (linearLayoutManager2 == null) {
                k.a("layoutManager");
            }
            int childCount = linearLayoutManager2.getChildCount();
            LinearLayoutManager linearLayoutManager3 = this.layoutManager;
            if (linearLayoutManager3 == null) {
                k.a("layoutManager");
            }
            startCloseAnimation(childCount, linearLayoutManager3);
            return;
        }
        finish();
    }
}
