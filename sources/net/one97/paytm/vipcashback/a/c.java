package net.one97.paytm.vipcashback.a;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.vipcashback.MerchantGameItem;
import net.one97.paytm.common.entity.vipcashback.MerchantStage;
import net.one97.paytm.common.entity.vipcashback.MerchantTasksItem;
import net.one97.paytm.common.entity.vipcashback.MyOfferBusinessUIObj;
import net.one97.paytm.vipcashback.R;
import net.one97.paytm.vipcashback.activity.MerchantCashbackOfferDetailActivity;
import net.one97.paytm.vipcashback.d.a;
import net.one97.paytm.vipcashback.widget.MerchantProgressTimelineView;

public final class c extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final Context f20561a;

    /* renamed from: b  reason: collision with root package name */
    private int f20562b = ((int) (((double) com.paytm.utility.b.a((Activity) this.f20561a)) * 0.8d));

    /* renamed from: c  reason: collision with root package name */
    private ArrayList<MyOfferBusinessUIObj> f20563c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private final int f20564d = 1;

    /* renamed from: e  reason: collision with root package name */
    private final int f20565e = 2;

    /* renamed from: f  reason: collision with root package name */
    private final MerchantGameItem f20566f;

    public c(Context context, MerchantGameItem merchantGameItem) {
        k.c(context, "context");
        k.c(merchantGameItem, "merchantGameItem");
        this.f20561a = context;
        this.f20566f = merchantGameItem;
        a(this.f20563c, this.f20566f);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f20564d) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.merchant_cashback_my_offers_detail_transaction_based, viewGroup, false);
            k.a((Object) inflate, "view");
            return new b(this, inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.merchant_cashback_my_offers_detail_progress_item, viewGroup, false);
        k.a((Object) inflate2, "view");
        return new a(this, inflate2);
    }

    public final int getItemCount() {
        return this.f20566f.getTotalTxnCount();
    }

    public final int getItemViewType(int i2) {
        return this.f20564d;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        RecyclerView.v vVar2 = vVar;
        int i3 = i2;
        k.c(vVar2, "holder");
        boolean z = false;
        if (getItemViewType(i3) != this.f20564d) {
            a aVar = (a) vVar2;
            MerchantStage merchantStage = this.f20566f.getMerchantStages().get(i3);
            RoboTextView roboTextView = aVar.f20568b;
            k.a((Object) merchantStage, "merchantStage");
            roboTextView.setText(merchantStage.getStageScreenConstruct1());
            a.i.C0390a aVar2 = a.i.f20808a;
            String str = null;
            if (a.i.f20809b.equals(merchantStage.getStageStatus())) {
                aVar.f20569c.setVisibility(0);
                aVar.f20570d.setVisibility(0);
                RoboTextView roboTextView2 = aVar.f20569c;
                StringBuilder sb = new StringBuilder();
                sb.append(merchantStage.getStageSuccessTxnCount());
                sb.append('/');
                sb.append(merchantStage.getStageTotalTxnCount());
                roboTextView2.setText(sb.toString());
                MerchantProgressTimelineView merchantProgressTimelineView = aVar.f20570d;
                int i4 = this.f20562b;
                int stageSuccessTxnCount = merchantStage.getStageSuccessTxnCount();
                int stageTotalTxnCount = merchantStage.getStageTotalTxnCount();
                merchantProgressTimelineView.f21045a = i4;
                merchantProgressTimelineView.f21046b = stageSuccessTxnCount;
                merchantProgressTimelineView.f21047c = stageTotalTxnCount;
                merchantProgressTimelineView.removeAllViews();
                Context context = merchantProgressTimelineView.f21048d;
                if (context == null) {
                    k.a("mContext");
                }
                ProgressBar progressBar = new ProgressBar(context, (AttributeSet) null, 16842872);
                Context context2 = merchantProgressTimelineView.f21048d;
                if (context2 == null) {
                    k.a("mContext");
                }
                progressBar.setBackgroundColor(androidx.core.content.b.c(context2, net.one97.paytm.common.assets.R.color.color_e2ebee));
                if (Build.VERSION.SDK_INT < 21) {
                    Drawable mutate = progressBar.getProgressDrawable().mutate();
                    Context context3 = merchantProgressTimelineView.f21048d;
                    if (context3 == null) {
                        k.a("mContext");
                    }
                    mutate.setColorFilter(androidx.core.content.b.c(context3, R.color.color_00c673), PorterDuff.Mode.SRC_IN);
                    progressBar.setProgressDrawable(mutate);
                } else {
                    Context context4 = merchantProgressTimelineView.f21048d;
                    if (context4 == null) {
                        k.a("mContext");
                    }
                    progressBar.setProgressTintList(ColorStateList.valueOf(androidx.core.content.b.c(context4, R.color.color_00c673)));
                }
                int i5 = (int) (((double) merchantProgressTimelineView.f21045a) * 0.8d);
                Context context5 = merchantProgressTimelineView.f21048d;
                if (context5 == null) {
                    k.a("mContext");
                }
                progressBar.setLayoutParams(new LinearLayout.LayoutParams(i5, context5.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_3dp), 1.0f));
                progressBar.setMax(stageTotalTxnCount);
                progressBar.setProgress(stageSuccessTxnCount);
                merchantProgressTimelineView.addView(progressBar);
                TextView textView = new TextView(merchantProgressTimelineView.getContext());
                textView.setText(merchantProgressTimelineView.getContext().getString(R.string.x_left, new Object[]{Integer.valueOf(stageTotalTxnCount - stageSuccessTxnCount)}));
                textView.setTextSize(2, 12.0f);
                textView.setTextColor(androidx.core.content.b.c(merchantProgressTimelineView.getContext(), net.one97.paytm.common.assets.R.color.color_666666));
                Context context6 = merchantProgressTimelineView.getContext();
                k.a((Object) context6, "context");
                int dimensionPixelSize = context6.getResources().getDimensionPixelSize(net.one97.paytm.common.assets.R.dimen.dimen_4dp);
                int i6 = dimensionPixelSize * 2;
                int i7 = dimensionPixelSize / 2;
                textView.setPadding(i6, i7, i6, i7);
                textView.setSingleLine();
                textView.setBackground(androidx.core.content.b.a(merchantProgressTimelineView.getContext(), R.drawable.shape_solid_bg_grey));
                merchantProgressTimelineView.addView(textView);
                aVar.f20568b.setFontType(3);
            } else {
                aVar.f20569c.setVisibility(8);
                aVar.f20570d.setVisibility(8);
                aVar.f20568b.setFontType(2);
            }
            aVar.f20573g.setVisibility(8);
            if (!TextUtils.isEmpty(merchantStage.getStageGratificationText())) {
                aVar.f20571e.setVisibility(0);
                aVar.f20572f.setText(merchantStage.getStageGratificationText());
                a.i.C0390a aVar3 = a.i.f20808a;
                if (a.i.f20815h.equals(merchantStage.getStageStatus())) {
                    aVar.f20567a.setImageResource(net.one97.paytm.common.assets.R.drawable.ic_tick);
                    aVar.f20571e.setBackgroundResource(R.drawable.bg_rectangle_e2ebee);
                    ArrayList<MerchantTasksItem> tasks = merchantStage.getTasks();
                    MerchantTasksItem merchantTasksItem = tasks != null ? tasks.get(0) : null;
                    if (merchantTasksItem != null) {
                        str = merchantTasksItem.getRedemptionText();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        aVar.f20573g.setVisibility(0);
                        if (merchantTasksItem != null) {
                            z = merchantTasksItem.isGratificationProcessed();
                        }
                        if (z) {
                            aVar.f20572f.setTextColor(androidx.core.content.b.c(this.f20561a, R.color.color_00c673));
                            aVar.f20573g.setImageResource(R.drawable.ic_chevron_right_00c673);
                        } else {
                            aVar.f20572f.setTextColor(androidx.core.content.b.c(this.f20561a, net.one97.paytm.common.assets.R.color.color_f5a109));
                            aVar.f20573g.setImageResource(R.drawable.ic_chevron_right_f5a109);
                        }
                        aVar.f20571e.setOnClickListener(new C0376c(this, merchantStage));
                        return;
                    }
                    return;
                }
                aVar.f20567a.setImageResource(R.drawable.ic_cashback_timelinne_idle);
                aVar.f20571e.setBackgroundResource(R.drawable.bg_rectangle_10_666666);
                aVar.f20572f.setTextColor(androidx.core.content.b.c(this.f20561a, net.one97.paytm.common.assets.R.color.color_999999));
                aVar.f20571e.setOnClickListener((View.OnClickListener) null);
                return;
            }
            aVar.f20571e.setVisibility(8);
        } else if (vVar2 != null) {
            b bVar = (b) vVar2;
            MerchantGameItem merchantGameItem = this.f20566f;
            if (merchantGameItem != null) {
                MyOfferBusinessUIObj myOfferBusinessUIObj = this.f20563c.get(i3);
                k.a((Object) myOfferBusinessUIObj, "uiObjList[position]");
                MyOfferBusinessUIObj myOfferBusinessUIObj2 = myOfferBusinessUIObj;
                if (i3 == merchantGameItem.getSuccessTxnCount() - 1) {
                    bVar.f20580f.setBackgroundResource(net.one97.paytm.common.assets.R.color.color_e2ebee);
                    bVar.f20580f.setVisibility(0);
                    bVar.f20577c.setImageResource(net.one97.paytm.common.assets.R.drawable.ic_tick);
                } else if (i3 < merchantGameItem.getSuccessTxnCount() - 1) {
                    bVar.f20580f.setBackgroundResource(net.one97.paytm.common.assets.R.color.color_21c17a);
                    bVar.f20580f.setVisibility(0);
                    bVar.f20577c.setImageResource(net.one97.paytm.common.assets.R.drawable.ic_tick);
                } else {
                    bVar.f20580f.setBackgroundResource(net.one97.paytm.common.assets.R.color.color_e2ebee);
                    bVar.f20580f.setVisibility(0);
                    bVar.f20577c.setImageResource(R.drawable.ic_cashback_timelinne_idle);
                }
                if (i3 == getItemCount() - 1) {
                    bVar.f20580f.setVisibility(8);
                }
                bVar.f20575a.setText(myOfferBusinessUIObj2.getTitle());
                bVar.f20579e.setVisibility(8);
                if (!myOfferBusinessUIObj2.isGratificationMessageVisible() || TextUtils.isEmpty(myOfferBusinessUIObj2.getGratificationMessage())) {
                    bVar.f20576b.setVisibility(8);
                    return;
                }
                bVar.f20576b.setVisibility(0);
                bVar.f20578d.setText(myOfferBusinessUIObj2.getGratificationMessage());
                a.i.C0390a aVar4 = a.i.f20808a;
                if (p.a(a.i.f20815h, myOfferBusinessUIObj2.getStageStatus(), true)) {
                    bVar.f20576b.setBackgroundResource(R.drawable.bg_rectangle_e2ebee);
                    bVar.f20579e.setVisibility(0);
                    if (myOfferBusinessUIObj2.isGratificationProcessed()) {
                        bVar.f20578d.setTextColor(androidx.core.content.b.c(this.f20561a, R.color.color_00c673));
                        bVar.f20579e.setImageResource(R.drawable.ic_chevron_right_00c673);
                    } else {
                        bVar.f20578d.setTextColor(androidx.core.content.b.c(this.f20561a, net.one97.paytm.common.assets.R.color.color_f5a109));
                        bVar.f20579e.setImageResource(R.drawable.ic_chevron_right_f5a109);
                    }
                } else {
                    bVar.f20576b.setBackgroundResource(R.drawable.bg_rectangle_666666);
                    bVar.f20578d.setTextColor(androidx.core.content.b.c(this.f20561a, net.one97.paytm.common.assets.R.color.color_999999));
                    bVar.f20579e.setVisibility(8);
                }
                if (!TextUtils.isEmpty(myOfferBusinessUIObj2.getRedemptionText())) {
                    bVar.f20576b.setOnClickListener(new d(myOfferBusinessUIObj2, this, i3, bVar));
                }
            }
        } else {
            throw new u("null cannot be cast to non-null type net.one97.paytm.vipcashback.adapter.MerchantCashbackMyOffersDetailProgressAdapter.ViewHolderTransctionBased");
        }
    }

    /* renamed from: net.one97.paytm.vipcashback.a.c$c  reason: collision with other inner class name */
    static final class C0376c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f20582a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MerchantStage f20583b;

        C0376c(c cVar, MerchantStage merchantStage) {
            this.f20582a = cVar;
            this.f20583b = merchantStage;
        }

        public final void onClick(View view) {
            if (this.f20582a.f20561a instanceof MerchantCashbackOfferDetailActivity) {
                MerchantStage merchantStage = this.f20583b;
                k.a((Object) merchantStage, "merchantStage");
                ((MerchantCashbackOfferDetailActivity) this.f20582a.f20561a).a(merchantStage);
            }
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MyOfferBusinessUIObj f20584a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f20585b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f20586c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f20587d;

        d(MyOfferBusinessUIObj myOfferBusinessUIObj, c cVar, int i2, b bVar) {
            this.f20584a = myOfferBusinessUIObj;
            this.f20585b = cVar;
            this.f20586c = i2;
            this.f20587d = bVar;
        }

        public final void onClick(View view) {
            MerchantStage stage;
            if ((this.f20585b.f20561a instanceof MerchantCashbackOfferDetailActivity) && (stage = this.f20584a.getStage()) != null) {
                ((MerchantCashbackOfferDetailActivity) this.f20585b.f20561a).a(stage);
            }
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        ImageView f20567a;

        /* renamed from: b  reason: collision with root package name */
        RoboTextView f20568b;

        /* renamed from: c  reason: collision with root package name */
        RoboTextView f20569c;

        /* renamed from: d  reason: collision with root package name */
        MerchantProgressTimelineView f20570d;

        /* renamed from: e  reason: collision with root package name */
        LinearLayout f20571e;

        /* renamed from: f  reason: collision with root package name */
        TextView f20572f;

        /* renamed from: g  reason: collision with root package name */
        ImageView f20573g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ c f20574h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c cVar, View view) {
            super(view);
            k.c(view, "view");
            this.f20574h = cVar;
            View findViewById = view.findViewById(R.id.iv_status_icon);
            if (findViewById != null) {
                this.f20567a = (ImageView) findViewById;
                View findViewById2 = view.findViewById(R.id.tv_stage_title);
                if (findViewById2 != null) {
                    this.f20568b = (RoboTextView) findViewById2;
                    View findViewById3 = view.findViewById(R.id.tv_transaction_count);
                    if (findViewById3 != null) {
                        this.f20569c = (RoboTextView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.progress_timeline);
                        if (findViewById4 != null) {
                            this.f20570d = (MerchantProgressTimelineView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.lyt_gratification);
                            if (findViewById5 != null) {
                                this.f20571e = (LinearLayout) findViewById5;
                                View findViewById6 = view.findViewById(R.id.tv_title);
                                if (findViewById6 != null) {
                                    this.f20572f = (TextView) findViewById6;
                                    View findViewById7 = view.findViewById(R.id.iv_arrow);
                                    if (findViewById7 != null) {
                                        this.f20573g = (ImageView) findViewById7;
                                        return;
                                    }
                                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                                }
                                throw new u("null cannot be cast to non-null type android.widget.TextView");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
                        }
                        throw new u("null cannot be cast to non-null type net.one97.paytm.vipcashback.widget.MerchantProgressTimelineView");
                    }
                    throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
                }
                throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
            }
            throw new u("null cannot be cast to non-null type android.widget.ImageView");
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        RoboTextView f20575a;

        /* renamed from: b  reason: collision with root package name */
        LinearLayout f20576b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f20577c;

        /* renamed from: d  reason: collision with root package name */
        TextView f20578d;

        /* renamed from: e  reason: collision with root package name */
        ImageView f20579e;

        /* renamed from: f  reason: collision with root package name */
        View f20580f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ c f20581g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c cVar, View view) {
            super(view);
            k.c(view, "view");
            this.f20581g = cVar;
            View findViewById = view.findViewById(R.id.tv_stage_title);
            if (findViewById != null) {
                this.f20575a = (RoboTextView) findViewById;
                View findViewById2 = view.findViewById(R.id.lyt_gratification);
                if (findViewById2 != null) {
                    this.f20576b = (LinearLayout) findViewById2;
                    View findViewById3 = view.findViewById(R.id.iv_status_icon);
                    if (findViewById3 != null) {
                        this.f20577c = (ImageView) findViewById3;
                        View findViewById4 = view.findViewById(R.id.tv_title);
                        if (findViewById4 != null) {
                            this.f20578d = (TextView) findViewById4;
                            View findViewById5 = view.findViewById(R.id.iv_arrow);
                            if (findViewById5 != null) {
                                this.f20579e = (ImageView) findViewById5;
                                View findViewById6 = view.findViewById(R.id.status_line);
                                if (findViewById6 != null) {
                                    this.f20580f = findViewById6;
                                    return;
                                }
                                throw new u("null cannot be cast to non-null type android.view.View");
                            }
                            throw new u("null cannot be cast to non-null type android.widget.ImageView");
                        }
                        throw new u("null cannot be cast to non-null type android.widget.TextView");
                    }
                    throw new u("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00d2, code lost:
        r0 = r0.get(0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(java.util.ArrayList<net.one97.paytm.common.entity.vipcashback.MyOfferBusinessUIObj> r15, net.one97.paytm.common.entity.vipcashback.MerchantGameItem r16) {
        /*
            java.util.ArrayList r0 = r16.getMerchantStages()
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.vipcashback.MerchantStage r0 = (net.one97.paytm.common.entity.vipcashback.MerchantStage) r0
            java.lang.String r2 = "merchantStage"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r3 = r0.getStageTotalTxnCount()
            net.one97.paytm.cashback.posttxn.Campaign r4 = r16.getCampaign()
            java.lang.String r5 = "merchantGameItem.campaign"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getOfferKeyword()
            java.lang.String r5 = "merchantGameItem.campaign.offerKeyword"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r5 = "%s"
            java.lang.String r6 = ""
            java.lang.String r4 = kotlin.m.p.a(r4, r5, r6, r1)
            int r5 = r16.getTotalTxnCount()
            r6 = r0
            r0 = 0
            r7 = 0
        L_0x0035:
            if (r0 >= r5) goto L_0x0158
            net.one97.paytm.common.entity.vipcashback.MyOfferBusinessUIObj r8 = new net.one97.paytm.common.entity.vipcashback.MyOfferBusinessUIObj
            r8.<init>()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            int r10 = r0 + 1
            int r11 = r10 % 10
            int r12 = r10 % 100
            r13 = 1
            if (r11 != r13) goto L_0x0064
            r14 = 11
            if (r12 == r14) goto L_0x0064
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = java.lang.String.valueOf(r10)
            r11.append(r12)
            java.lang.String r12 = "st"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            goto L_0x00b3
        L_0x0064:
            r14 = 2
            if (r11 != r14) goto L_0x0081
            r14 = 12
            if (r12 == r14) goto L_0x0081
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = java.lang.String.valueOf(r10)
            r11.append(r12)
            java.lang.String r12 = "nd"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            goto L_0x00b3
        L_0x0081:
            r14 = 3
            if (r11 != r14) goto L_0x009e
            r11 = 13
            if (r12 == r11) goto L_0x009e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = java.lang.String.valueOf(r10)
            r11.append(r12)
            java.lang.String r12 = "rd"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            goto L_0x00b3
        L_0x009e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = java.lang.String.valueOf(r10)
            r11.append(r12)
            java.lang.String r12 = "th"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
        L_0x00b3:
            r9.append(r11)
            java.lang.String r11 = " "
            r9.append(r11)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            r8.setTitle(r9)
            int r9 = r3 + -1
            if (r0 != r9) goto L_0x014e
            r8.setGratificationMessageVisible(r13)
            java.util.ArrayList r0 = r6.getTasks()
            if (r0 == 0) goto L_0x00df
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.vipcashback.MerchantTasksItem r0 = (net.one97.paytm.common.entity.vipcashback.MerchantTasksItem) r0
            if (r0 == 0) goto L_0x00df
            boolean r0 = r0.isGratificationProcessed()
            goto L_0x00e0
        L_0x00df:
            r0 = 0
        L_0x00e0:
            r8.setGratificationProcessed(r0)
            java.util.ArrayList r0 = r6.getTasks()
            r9 = 0
            if (r0 == 0) goto L_0x00f7
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.vipcashback.MerchantTasksItem r0 = (net.one97.paytm.common.entity.vipcashback.MerchantTasksItem) r0
            if (r0 == 0) goto L_0x00f7
            java.lang.String r0 = r0.getRedemptionText()
            goto L_0x00f8
        L_0x00f7:
            r0 = r9
        L_0x00f8:
            r8.setRedemptionText(r0)
            java.lang.String r0 = r6.getStageStatus()
            r8.setStageStatus(r0)
            r8.setStage(r6)
            java.lang.String r0 = r6.getStageGratificationText()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x012d
            java.lang.String r0 = r6.getStageGratificationText()
            r8.setGratificationMessage(r0)
            java.util.ArrayList r0 = r6.getTasks()
            if (r0 == 0) goto L_0x012a
            java.lang.Object r0 = r0.get(r1)
            net.one97.paytm.common.entity.vipcashback.MerchantTasksItem r0 = (net.one97.paytm.common.entity.vipcashback.MerchantTasksItem) r0
            if (r0 == 0) goto L_0x012a
            java.lang.String r9 = r0.getRrnNo()
        L_0x012a:
            r8.setRrnNo(r9)
        L_0x012d:
            java.util.ArrayList r0 = r16.getMerchantStages()
            int r0 = r0.size()
            int r0 = r0 - r13
            if (r7 >= r0) goto L_0x0151
            java.util.ArrayList r0 = r16.getMerchantStages()
            int r7 = r7 + 1
            java.lang.Object r0 = r0.get(r7)
            net.one97.paytm.common.entity.vipcashback.MerchantStage r0 = (net.one97.paytm.common.entity.vipcashback.MerchantStage) r0
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r2)
            int r6 = r0.getStageTotalTxnCount()
            int r3 = r3 + r6
            r6 = r0
            goto L_0x0151
        L_0x014e:
            r8.setGratificationMessageVisible(r1)
        L_0x0151:
            r0 = r15
            r15.add(r8)
            r0 = r10
            goto L_0x0035
        L_0x0158:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.vipcashback.a.c.a(java.util.ArrayList, net.one97.paytm.common.entity.vipcashback.MerchantGameItem):void");
    }
}
