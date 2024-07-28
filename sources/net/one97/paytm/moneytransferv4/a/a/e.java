package net.one97.paytm.moneytransferv4.a.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.giftcards.CJRGiftCardUserInputField;
import net.one97.paytm.moneytransfer.R;
import net.one97.paytm.moneytransfer.c.t;
import net.one97.paytm.moneytransfer.utils.m;
import net.one97.paytm.p2p.theme.ThemeData;
import net.one97.paytm.upi.common.upi.UpiTransactionModelV2;
import net.one97.paytm.upi.f;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.util.AnimationUtils;

public final class e extends net.one97.paytm.upi.b<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    final List<UpiTransactionModelV2> f54814a;

    /* renamed from: e  reason: collision with root package name */
    private final int f54815e;

    /* renamed from: f  reason: collision with root package name */
    private final int f54816f = 1;

    /* renamed from: g  reason: collision with root package name */
    private final int f54817g = 2;

    public e(List<UpiTransactionModelV2> list) {
        k.c(list, "list");
        this.f54814a = list;
    }

    public final int getItemViewType(int i2) {
        if (i2 == this.f54814a.size() && this.f66589d) {
            return this.f54815e;
        }
        if (k.a((Object) this.f54814a.get(i2).getTxnType(), (Object) "DEBIT")) {
            return this.f54816f;
        }
        return this.f54817g;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        if (i2 == this.f54816f) {
            return new c(this, a(R.layout.mt_txn_history_sent_item_view, viewGroup));
        }
        if (i2 == this.f54817g) {
            return new b(this, a(R.layout.mt_txn_history_received_item_view, viewGroup));
        }
        return new a(this, new FrameLayout(viewGroup.getContext()));
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        k.c(vVar, "holder");
        ThemeData themeData = null;
        boolean z = false;
        if (vVar instanceof b) {
            UpiTransactionModelV2 upiTransactionModelV2 = this.f54814a.get(i2);
            k.c(upiTransactionModelV2, "upiTransactionModelV2");
            t a2 = t.a(((b) vVar).itemView);
            k.a((Object) a2, "MtTxnHistoryReceivedItemViewBinding.bind(itemView)");
            TextView textView = a2.f53837a;
            k.a((Object) textView, "amountTextView");
            String k = m.k(upiTransactionModelV2.getAmount());
            k.a((Object) k, "MoneyTransferUtils.getFo…ransactionModelV2.amount)");
            textView.setText(f.b(k));
            TextView textView2 = a2.f53839c;
            k.a((Object) textView2, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            textView2.setText(upiTransactionModelV2.getDate());
            TextView textView3 = a2.f53841e;
            k.a((Object) textView3, "note");
            View view = textView3;
            CharSequence note = upiTransactionModelV2.getNote();
            if (!(note == null || p.a(note)) && !p.a(upiTransactionModelV2.getNote(), "NA", true)) {
                z = true;
            }
            f.a(view, z);
            TextView textView4 = a2.f53841e;
            k.a((Object) textView4, "note");
            textView4.setText(upiTransactionModelV2.getNote());
            String themeId = upiTransactionModelV2.getThemeId();
            if (!TextUtils.isEmpty(themeId)) {
                i a3 = i.a();
                k.a((Object) a3, "PaytmUpiSdk.getInstance()");
                net.one97.paytm.upi.f.a g2 = a3.g();
                if (g2 != null) {
                    LottieAnimationView lottieAnimationView = a2.f53840d;
                    k.a((Object) lottieAnimationView, "receivedViewBinding.lottieAnimationView");
                    Context context = lottieAnimationView.getContext();
                    k.a((Object) context, "receivedViewBinding.lottieAnimationView.context");
                    themeData = g2.a(context, themeId);
                }
                if (themeData != null) {
                    AnimationUtils.setJsonLottieAnimation(a2.f53840d, themeData.getJsonData());
                    LottieAnimationView lottieAnimationView2 = a2.f53840d;
                    k.a((Object) lottieAnimationView2, "receivedViewBinding.lottieAnimationView");
                    f.b((View) lottieAnimationView2);
                    View view2 = a2.f53842f;
                    k.a((Object) view2, "receivedViewBinding.receivedBackgroundView");
                    Drawable background = view2.getBackground();
                    if (background != null) {
                        ((GradientDrawable) background).setColor(Color.parseColor(themeData.getBgcolor()));
                        int parseColor = Color.parseColor(themeData.getColor());
                        a2.f53837a.setTextColor(parseColor);
                        a2.f53843g.setTextColor(parseColor);
                        a2.f53841e.setTextColor(parseColor);
                        return;
                    }
                    throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                }
                b.a(a2);
                return;
            }
            b.a(a2);
        } else if (vVar instanceof c) {
            c cVar = (c) vVar;
            UpiTransactionModelV2 upiTransactionModelV22 = this.f54814a.get(i2);
            k.c(upiTransactionModelV22, "upiTransactionModelV2");
            net.one97.paytm.moneytransfer.c.u a4 = net.one97.paytm.moneytransfer.c.u.a(cVar.itemView);
            k.a((Object) a4, "MtTxnHistorySentItemViewBinding.bind(itemView)");
            TextView textView5 = a4.f53845a;
            k.a((Object) textView5, "amountTextView");
            String k2 = m.k(upiTransactionModelV22.getAmount());
            k.a((Object) k2, "MoneyTransferUtils.getFo…ransactionModelV2.amount)");
            textView5.setText(f.b(k2));
            TextView textView6 = a4.f53847c;
            k.a((Object) textView6, CJRGiftCardUserInputField.FIELD_TYPE_CALENDAR);
            textView6.setText(upiTransactionModelV22.getDate());
            TextView textView7 = a4.f53849e;
            k.a((Object) textView7, "note");
            View view3 = textView7;
            CharSequence note2 = upiTransactionModelV22.getNote();
            if (!(note2 == null || p.a(note2)) && !p.a(upiTransactionModelV22.getNote(), "NA", true)) {
                z = true;
            }
            f.a(view3, z);
            TextView textView8 = a4.f53849e;
            k.a((Object) textView8, "note");
            textView8.setText(upiTransactionModelV22.getNote());
            String status = upiTransactionModelV22.getStatus();
            if (status != null) {
                int hashCode = status.hashCode();
                if (hashCode != -1149187101) {
                    if (hashCode == 2066319421 && status.equals("FAILED")) {
                        TextView textView9 = a4.f53852h;
                        k.a((Object) textView9, "paymentStatusTextView");
                        textView9.setText(cVar.f54820a.a(R.string.upi_payment_failed));
                        int c2 = f.c("#ffdedf");
                        View view4 = a4.f53850f;
                        k.a((Object) view4, "paymentCardBackground");
                        c.a(c2, view4);
                        a4.f53851g.setImageResource(R.drawable.money_transfer_txn_failed);
                        c.a(a4);
                        return;
                    }
                } else if (status.equals("SUCCESS")) {
                    TextView textView10 = a4.f53852h;
                    k.a((Object) textView10, "paymentStatusTextView");
                    textView10.setText(cVar.f54820a.a(R.string.paid));
                    int c3 = f.c("#e5f6fd");
                    View view5 = a4.f53850f;
                    k.a((Object) view5, "paymentCardBackground");
                    c.a(c3, view5);
                    a4.f53851g.setImageResource(R.drawable.mt_success_greenbg_white_tick);
                    String themeId2 = upiTransactionModelV22.getThemeId();
                    if (!TextUtils.isEmpty(themeId2)) {
                        i a5 = i.a();
                        k.a((Object) a5, "PaytmUpiSdk.getInstance()");
                        net.one97.paytm.upi.f.a g3 = a5.g();
                        if (g3 != null) {
                            LottieAnimationView lottieAnimationView3 = a4.f53848d;
                            k.a((Object) lottieAnimationView3, "sentViewBinding.lottieAnimationView");
                            Context context2 = lottieAnimationView3.getContext();
                            k.a((Object) context2, "sentViewBinding.lottieAnimationView.context");
                            themeData = g3.a(context2, themeId2);
                        }
                        if (themeData != null) {
                            AnimationUtils.setJsonLottieAnimation(a4.f53848d, themeData.getJsonData());
                            LottieAnimationView lottieAnimationView4 = a4.f53848d;
                            k.a((Object) lottieAnimationView4, "sentViewBinding.lottieAnimationView");
                            f.b((View) lottieAnimationView4);
                            View view6 = a4.f53850f;
                            k.a((Object) view6, "sentViewBinding.paymentCardBackground");
                            Drawable background2 = view6.getBackground();
                            if (background2 != null) {
                                ((GradientDrawable) background2).setColor(Color.parseColor(themeData.getBgcolor()));
                                int parseColor2 = Color.parseColor(themeData.getColor());
                                a4.f53852h.setTextColor(parseColor2);
                                a4.f53845a.setTextColor(parseColor2);
                                a4.f53849e.setTextColor(parseColor2);
                                return;
                            }
                            throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                        }
                        c.a(a4);
                        return;
                    }
                    c.a(a4);
                    return;
                }
            }
            TextView textView11 = a4.f53852h;
            k.a((Object) textView11, "paymentStatusTextView");
            textView11.setText(cVar.f54820a.a(R.string.upi_payment_failed));
            int c4 = f.c("#ffefcc");
            View view7 = a4.f53850f;
            k.a((Object) view7, "paymentCardBackground");
            c.a(c4, view7);
            a4.f53851g.setImageResource(R.drawable.ic_pending_copy);
            c.a(a4);
        }
    }

    public final class b extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54819a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f54819a = eVar;
        }

        static void a(t tVar) {
            LottieAnimationView lottieAnimationView = tVar.f53840d;
            k.a((Object) lottieAnimationView, "receivedViewBinding.lottieAnimationView");
            f.a((View) lottieAnimationView);
            View view = tVar.f53842f;
            k.a((Object) view, "receivedViewBinding.receivedBackgroundView");
            Drawable background = view.getBackground();
            if (background != null) {
                ((GradientDrawable) background).setColor(-1);
                int parseColor = Color.parseColor("#1d252d");
                tVar.f53837a.setTextColor(parseColor);
                tVar.f53837a.setTextColor(parseColor);
                tVar.f53841e.setTextColor(parseColor);
                return;
            }
            throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }

    public final class c extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54820a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f54820a = eVar;
        }

        static void a(int i2, View view) {
            if (view.getBackground() instanceof GradientDrawable) {
                Drawable background = view.getBackground();
                if (background != null) {
                    ((GradientDrawable) background).setColor(i2);
                    return;
                }
                throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            }
        }

        static void a(net.one97.paytm.moneytransfer.c.u uVar) {
            LottieAnimationView lottieAnimationView = uVar.f53848d;
            k.a((Object) lottieAnimationView, "sentViewBinding.lottieAnimationView");
            f.a((View) lottieAnimationView);
            View view = uVar.f53850f;
            k.a((Object) view, "sentViewBinding.paymentCardBackground");
            Drawable background = view.getBackground();
            if (background != null) {
                ((GradientDrawable) background).setColor(f.c("#e5f6fd"));
                uVar.f53852h.setTextColor(Color.parseColor("#1d252d"));
                uVar.f53845a.setTextColor(Color.parseColor("#1d252d"));
                uVar.f53849e.setTextColor(Color.parseColor("#1d252d"));
                return;
            }
            throw new u("null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
        }
    }

    public final class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f54818a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar, View view) {
            super(view);
            k.c(view, "itemView");
            this.f54818a = eVar;
        }
    }

    public final int getItemCount() {
        if (this.f66589d) {
            return this.f54814a.size() + 1;
        }
        return this.f54814a.size();
    }
}
