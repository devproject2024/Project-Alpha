package net.one97.paytm.nativesdk.orflow.promo.view.nb;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.b;
import com.bumptech.glide.e.a;
import com.bumptech.glide.e.h;
import com.bumptech.glide.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.nativesdk.DirectPaymentBL;
import net.one97.paytm.nativesdk.R;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;
import net.one97.paytm.nativesdk.common.model.Body;
import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;
import net.one97.paytm.nativesdk.instruments.netbanking.listeners.NetBankingProviderListner;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions;
import net.one97.paytm.nativesdk.orflow.promo.model.PromoPayOptionAdapterParam;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.BaseViewHolder;
import net.one97.paytm.nativesdk.orflow.promo.view.viewholders.PromoEmptyNbListView;

public final class PromoAllNetBankingAdapter extends RecyclerView.a<RecyclerView.v> implements Filterable, SectionIndexer {
    /* access modifiers changed from: private */
    public ArrayList<PromoPayOptionAdapterParam> filteredSectionWrappers;
    private final Context mContext;
    private ArrayList<Integer> mSectionPositions = new ArrayList<>();
    /* access modifiers changed from: private */
    public final NetBankingProviderListner netBankingProviderListner;
    private final View.OnClickListener onClickListener;
    /* access modifiers changed from: private */
    public final ArrayList<PromoPayOptionAdapterParam> sectionWrappers = new ArrayList<>();

    public final int getSectionForPosition(int i2) {
        return 0;
    }

    public PromoAllNetBankingAdapter(Context context, ArrayList<PromoPayOptionAdapterParam> arrayList, NetBankingProviderListner netBankingProviderListner2, View.OnClickListener onClickListener2) {
        k.c(context, "mContext");
        k.c(arrayList, "filteredSectionWrappers");
        k.c(netBankingProviderListner2, "netBankingProviderListner");
        k.c(onClickListener2, "onClickListener");
        this.mContext = context;
        this.filteredSectionWrappers = arrayList;
        this.netBankingProviderListner = netBankingProviderListner2;
        this.onClickListener = onClickListener2;
        this.sectionWrappers.addAll(this.filteredSectionWrappers);
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        RecyclerView.v vVar;
        k.c(viewGroup, "parent");
        if (i2 == 9) {
            vVar = SectionViewHolder.Companion.create(this.mContext, viewGroup);
        } else if (i2 == 7) {
            vVar = PromoTopBanksViewHolder.Companion.create(this.mContext, viewGroup);
        } else if (i2 == 10) {
            vVar = PromoEmptyNbListView.Companion.create(this.mContext, viewGroup);
        } else {
            vVar = NetBankingViewHolder.Companion.create(this.mContext, viewGroup);
        }
        if (vVar instanceof BaseViewHolder) {
            ((BaseViewHolder) vVar).setOnClickListener(this.onClickListener);
        }
        return vVar;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        ((BaseViewHolder) vVar).bindView(this.filteredSectionWrappers.get(i2));
    }

    public final int getItemCount() {
        return this.filteredSectionWrappers.size();
    }

    public final int getItemViewType(int i2) {
        PromoPayOptionAdapterParam promoPayOptionAdapterParam = this.filteredSectionWrappers.get(i2);
        k.a((Object) promoPayOptionAdapterParam, "filteredSectionWrappers[position]");
        return promoPayOptionAdapterParam.getVIEWTYPE();
    }

    public static final class SectionViewHolder extends BaseViewHolder<PromoPayOptionAdapterParam> {
        public static final Companion Companion = new Companion((g) null);

        public final void bindView(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SectionViewHolder(Context context, View view) {
            super(context, view);
            k.c(context, "context");
            k.c(view, "view");
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final SectionViewHolder create(Context context, ViewGroup viewGroup) {
                k.c(context, "context");
                k.c(viewGroup, "parent");
                return new SectionViewHolder(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.vh_promo_nb_title));
            }
        }
    }

    public static final class NetBankingViewHolder extends BaseViewHolder<PromoPayOptionAdapterParam> {
        public static final Companion Companion = new Companion((g) null);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetBankingViewHolder(Context context, View view) {
            super(context, view);
            k.c(context, "context");
            k.c(view, "view");
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final NetBankingViewHolder create(Context context, ViewGroup viewGroup) {
                k.c(context, "context");
                k.c(viewGroup, "parent");
                return new NetBankingViewHolder(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.vh_promo_nb_item));
            }
        }

        public final void bindView(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
            if (promoPayOptionAdapterParam != null) {
                BaseDataModel data = promoPayOptionAdapterParam.getData();
                if (data != null) {
                    PayChannelOptions payChannelOptions = (PayChannelOptions) data;
                    if (promoPayOptionAdapterParam.isSelected()) {
                        ImageView imageView = (ImageView) getMView().findViewById(R.id.imgGreenTick);
                        k.a((Object) imageView, "mView.imgGreenTick");
                        imageView.setVisibility(0);
                    } else {
                        ImageView imageView2 = (ImageView) getMView().findViewById(R.id.imgGreenTick);
                        k.a((Object) imageView2, "mView.imgGreenTick");
                        imageView2.setVisibility(8);
                    }
                    TextView textView = (TextView) getMView().findViewById(R.id.tvBankName);
                    k.a((Object) textView, "mView.tvBankName");
                    textView.setText(payChannelOptions.getChannelName());
                    i b2 = b.b(getMContext());
                    StringBuilder sb = new StringBuilder();
                    DirectPaymentBL instance = DirectPaymentBL.getInstance();
                    k.a((Object) instance, "DirectPaymentBL.getInstance()");
                    CJPayMethodResponse cjPayMethodResponse = instance.getCjPayMethodResponse();
                    k.a((Object) cjPayMethodResponse, "DirectPaymentBL.getInstance().cjPayMethodResponse");
                    Body body = cjPayMethodResponse.getBody();
                    k.a((Object) body, "DirectPaymentBL.getInsta….cjPayMethodResponse.body");
                    sb.append(body.getIconBaseUrl());
                    sb.append(payChannelOptions.getIconUrl());
                    b2.a(sb.toString()).b((a<?>) ((h) new h().a(R.drawable.ic_paytm_payments_bank)).c(R.drawable.ic_paytm_payments_bank)).a((ImageView) getMView().findViewById(R.id.iv_bank_icon));
                    if (TextUtils.isEmpty(promoPayOptionAdapterParam.getPromoErrorMessage())) {
                        TextView textView2 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                        k.a((Object) textView2, "mView.tvErrorMessage");
                        textView2.setVisibility(8);
                    } else {
                        TextView textView3 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                        k.a((Object) textView3, "mView.tvErrorMessage");
                        textView3.setVisibility(0);
                        TextView textView4 = (TextView) getMView().findViewById(R.id.tvErrorMessage);
                        k.a((Object) textView4, "mView.tvErrorMessage");
                        textView4.setText(promoPayOptionAdapterParam.getPromoErrorMessage());
                    }
                    ConstraintLayout constraintLayout = (ConstraintLayout) getMView().findViewById(R.id.nbItemParent);
                    k.a((Object) constraintLayout, "mView.nbItemParent");
                    constraintLayout.setTag(Integer.valueOf(getAdapterPosition()));
                    ((ConstraintLayout) getMView().findViewById(R.id.nbItemParent)).setOnClickListener(getMOnClickListener());
                    return;
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions");
            }
        }
    }

    public static final class PromoTopBanksViewHolder extends BaseViewHolder<PromoPayOptionAdapterParam> {
        public static final Companion Companion = new Companion((g) null);
        private PromoTopBanksAdapter mTopBanksAdapter;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[PromoPayOptionAdapterParam.NetworkCallState.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[PromoPayOptionAdapterParam.NetworkCallState.Default.ordinal()] = 1;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PromoTopBanksViewHolder(Context context, View view) {
            super(context, view);
            k.c(context, "context");
            k.c(view, "view");
        }

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(g gVar) {
                this();
            }

            public final PromoTopBanksViewHolder create(Context context, ViewGroup viewGroup) {
                k.c(context, "context");
                k.c(viewGroup, "parent");
                return new PromoTopBanksViewHolder(context, BaseViewHolder.Companion.getView(viewGroup, R.layout.vh_promo_topbanks));
            }
        }

        public final void bindView(PromoPayOptionAdapterParam promoPayOptionAdapterParam) {
            if (promoPayOptionAdapterParam != null && promoPayOptionAdapterParam.getNbTopBankList() != null) {
                if (!promoPayOptionAdapterParam.isSelected()) {
                    Iterator<PromoPayOptionAdapterParam> it2 = promoPayOptionAdapterParam.getNbTopBankList().iterator();
                    while (it2.hasNext()) {
                        PromoPayOptionAdapterParam next = it2.next();
                        k.a((Object) next, "listItem");
                        next.setSelected(false);
                    }
                }
                PromoTopBanksAdapter promoTopBanksAdapter = this.mTopBanksAdapter;
                if (promoTopBanksAdapter == null) {
                    Context mContext = getMContext();
                    ArrayList<PromoPayOptionAdapterParam> nbTopBankList = promoPayOptionAdapterParam.getNbTopBankList();
                    k.a((Object) nbTopBankList, "item.nbTopBankList");
                    View.OnClickListener mOnClickListener = getMOnClickListener();
                    if (mOnClickListener == null) {
                        k.a();
                    }
                    this.mTopBanksAdapter = new PromoTopBanksAdapter(mContext, nbTopBankList, mOnClickListener);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getMContext());
                    linearLayoutManager.setOrientation(0);
                    RecyclerView recyclerView = (RecyclerView) getMView().findViewById(R.id.topBankLayout);
                    if (recyclerView != null) {
                        recyclerView.setLayoutManager(linearLayoutManager);
                    }
                    RecyclerView recyclerView2 = (RecyclerView) getMView().findViewById(R.id.topBankLayout);
                    if (recyclerView2 != null) {
                        recyclerView2.setAdapter(this.mTopBanksAdapter);
                    }
                } else if (promoTopBanksAdapter != null) {
                    promoTopBanksAdapter.notifyDataSetChanged();
                }
                PromoPayOptionAdapterParam.NetworkCallState networkCallState = promoPayOptionAdapterParam.getNetworkCallState();
                if (networkCallState != null && WhenMappings.$EnumSwitchMapping$0[networkCallState.ordinal()] == 1) {
                    TextView textView = (TextView) getMView().findViewById(R.id.tvSelectOtherBank);
                    k.a((Object) textView, "mView.tvSelectOtherBank");
                    textView.setVisibility(0);
                } else {
                    TextView textView2 = (TextView) getMView().findViewById(R.id.tvSelectOtherBank);
                    k.a((Object) textView2, "mView.tvSelectOtherBank");
                    textView2.setVisibility(8);
                }
                if (!TextUtils.isEmpty(promoPayOptionAdapterParam.getPromoErrorMessage())) {
                    TextView textView3 = (TextView) getMView().findViewById(R.id.tvPromoError);
                    k.a((Object) textView3, "mView.tvPromoError");
                    textView3.setVisibility(0);
                    TextView textView4 = (TextView) getMView().findViewById(R.id.tvPromoError);
                    k.a((Object) textView4, "mView.tvPromoError");
                    textView4.setText(promoPayOptionAdapterParam.getPromoErrorMessage());
                } else {
                    TextView textView5 = (TextView) getMView().findViewById(R.id.tvPromoError);
                    k.a((Object) textView5, "mView.tvPromoError");
                    textView5.setVisibility(8);
                }
                ((TextView) getMView().findViewById(R.id.tvSelectOtherBank)).setOnClickListener(getMOnClickListener());
            }
        }
    }

    public final String[] getSections() {
        ArrayList arrayList = new ArrayList(26);
        this.mSectionPositions = new ArrayList<>(26);
        int size = this.filteredSectionWrappers.size();
        for (int i2 = 0; i2 < size; i2++) {
            PromoPayOptionAdapterParam promoPayOptionAdapterParam = this.filteredSectionWrappers.get(i2);
            k.a((Object) promoPayOptionAdapterParam, "filteredSectionWrappers[i]");
            if (promoPayOptionAdapterParam.getVIEWTYPE() == 1) {
                PromoPayOptionAdapterParam promoPayOptionAdapterParam2 = this.filteredSectionWrappers.get(i2);
                k.a((Object) promoPayOptionAdapterParam2, "filteredSectionWrappers[i]");
                BaseDataModel data = promoPayOptionAdapterParam2.getData();
                if (data != null) {
                    String valueOf = String.valueOf(((PayChannelOptions) data).getChannelName().charAt(0));
                    if (valueOf != null) {
                        String upperCase = valueOf.toUpperCase();
                        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        if (!arrayList.contains(upperCase)) {
                            arrayList.add(upperCase);
                            this.mSectionPositions.add(Integer.valueOf(i2));
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.nativesdk.instruments.netbanking.modal.PayChannelOptions");
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new u("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final int getPositionForSection(int i2) {
        Integer num = this.mSectionPositions.get(i2);
        k.a((Object) num, "mSectionPositions[sectionIndex]");
        return num.intValue();
    }

    public final Filter getFilter() {
        return new PromoAllNetBankingAdapter$getFilter$1(this);
    }

    public final ArrayList<PromoPayOptionAdapterParam> getFilteredList() {
        return this.filteredSectionWrappers;
    }

    public final ArrayList<PromoPayOptionAdapterParam> getMasterList() {
        return this.sectionWrappers;
    }
}
