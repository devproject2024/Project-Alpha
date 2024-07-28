package net.one97.paytm.o2o.movies.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.b;
import java.util.ArrayList;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.widgets.CircularImageView;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.activity.AJRReviewDetailActivity;

public final class l extends RecyclerView.a<RecyclerView.v> {

    /* renamed from: a  reason: collision with root package name */
    Context f74669a;

    /* renamed from: b  reason: collision with root package name */
    CriticReviewAndRating f74670b;

    /* renamed from: c  reason: collision with root package name */
    String f74671c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<CriticRatingReviewItem> f74672d;

    public l(Context context, CriticReviewAndRating criticReviewAndRating, ArrayList<CriticRatingReviewItem> arrayList, String str) {
        k.c(criticReviewAndRating, "ratingAndReview");
        this.f74669a = context;
        this.f74670b = criticReviewAndRating;
        this.f74672d = arrayList;
        this.f74671c = str;
    }

    public final RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f74669a).inflate(R.layout.item_review, (ViewGroup) null, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…item_review, null, false)");
        return new av(inflate);
    }

    public final int getItemCount() {
        ArrayList<CriticRatingReviewItem> arrayList = this.f74672d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.v vVar, int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        k.c(vVar, "holder");
        av avVar = (av) vVar;
        CircularImageView circularImageView = avVar.f74484e;
        k.a((Object) circularImageView, "holder.ivReviewSource");
        circularImageView.setVisibility(8);
        TextView textView = avVar.f74480a;
        k.a((Object) textView, "holder.txtValueRating");
        textView.setVisibility(8);
        TextView textView2 = avVar.f74482c;
        k.a((Object) textView2, "holder.txtReviewSource");
        textView2.setVisibility(8);
        TextView textView3 = avVar.f74481b;
        k.a((Object) textView3, "holder.txtCriticsReviewItem");
        textView3.setVisibility(8);
        TextView textView4 = avVar.f74483d;
        k.a((Object) textView4, "holder.reviewDate");
        textView4.setVisibility(8);
        ImageView imageView = avVar.f74485f;
        k.a((Object) imageView, "holder.ivRatingStar");
        imageView.setVisibility(8);
        View view = avVar.f74486g;
        k.a((Object) view, "holder.dividerView");
        view.setVisibility(0);
        ArrayList<CriticRatingReviewItem> arrayList = this.f74672d;
        String str5 = null;
        Integer valueOf = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        if (valueOf == null) {
            k.a();
        }
        if (i2 == valueOf.intValue() - 1) {
            View view2 = avVar.f74486g;
            k.a((Object) view2, "holder.dividerView");
            view2.setVisibility(8);
        }
        ArrayList<CriticRatingReviewItem> arrayList2 = this.f74672d;
        CriticRatingReviewItem criticRatingReviewItem = arrayList2 != null ? arrayList2.get(i2) : null;
        if (criticRatingReviewItem != null) {
            if (!TextUtils.isEmpty(criticRatingReviewItem.f74232f)) {
                TextView textView5 = avVar.f74483d;
                k.a((Object) textView5, "holder.reviewDate");
                textView5.setText(b.h(criticRatingReviewItem.f74232f, "yyyy-MM-dd", "MMM dd, yyyy"));
                TextView textView6 = avVar.f74483d;
                k.a((Object) textView6, "holder.reviewDate");
                textView6.setVisibility(0);
            }
            if (!TextUtils.isEmpty(criticRatingReviewItem.f74231e)) {
                TextView textView7 = avVar.f74481b;
                k.a((Object) textView7, "holder.txtCriticsReviewItem");
                textView7.setVisibility(0);
                String str6 = criticRatingReviewItem.f74231e;
                if (str6 == null) {
                    k.a();
                }
                if (str6 == null) {
                    throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                } else if (p.b(str6).toString().length() <= 100) {
                    TextView textView8 = avVar.f74481b;
                    k.a((Object) textView8, "holder.txtCriticsReviewItem");
                    String str7 = criticRatingReviewItem.f74231e;
                    if (str7 != null) {
                        textView8.setText(p.b(str7).toString());
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                } else {
                    String str8 = criticRatingReviewItem.f74231e;
                    if (str8 != null) {
                        String obj = p.b(str8).toString();
                        if (obj != null) {
                            String substring = obj.substring(0, 100);
                            k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            SpannableString spannableString = new SpannableString(substring + "...more");
                            Context context = this.f74669a;
                            if (context == null) {
                                k.a();
                            }
                            Resources resources = context.getResources();
                            if (resources == null) {
                                k.a();
                            }
                            spannableString.setSpan(new ForegroundColorSpan(resources.getColor(R.color.color_00b9f5)), 103, 107, 33);
                            TextView textView9 = avVar.f74481b;
                            k.a((Object) textView9, "holder.txtCriticsReviewItem");
                            textView9.setText(spannableString);
                        } else {
                            throw new u("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                }
            }
            if (!TextUtils.isEmpty(criticRatingReviewItem.f74229c)) {
                DwhSource dwhSource = criticRatingReviewItem.f74228b;
                if (dwhSource != null) {
                    str2 = dwhSource.f74236a;
                } else {
                    str2 = null;
                }
                if (!TextUtils.isEmpty(str2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(criticRatingReviewItem.f74229c);
                    sb.append(", ");
                    DwhSource dwhSource2 = criticRatingReviewItem.f74228b;
                    if (dwhSource2 != null) {
                        str4 = dwhSource2.f74236a;
                    } else {
                        str4 = null;
                    }
                    sb.append(str4);
                    str3 = sb.toString();
                } else {
                    str3 = criticRatingReviewItem.f74229c;
                }
                TextView textView10 = avVar.f74482c;
                k.a((Object) textView10, "holder.txtReviewSource");
                textView10.setText(str3);
                TextView textView11 = avVar.f74482c;
                k.a((Object) textView11, "holder.txtReviewSource");
                textView11.setVisibility(0);
            }
            if (!TextUtils.isEmpty(criticRatingReviewItem.f74230d)) {
                TextView textView12 = avVar.f74480a;
                k.a((Object) textView12, "holder.txtValueRating");
                textView12.setText(criticRatingReviewItem.f74230d);
                TextView textView13 = avVar.f74480a;
                k.a((Object) textView13, "holder.txtValueRating");
                textView13.setVisibility(0);
                ImageView imageView2 = avVar.f74485f;
                k.a((Object) imageView2, "holder.ivRatingStar");
                imageView2.setVisibility(0);
            }
            DwhSource dwhSource3 = criticRatingReviewItem.f74228b;
            if (dwhSource3 != null) {
                str = dwhSource3.f74237b;
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                Context context2 = this.f74669a;
                ImageView imageView3 = avVar.f74484e;
                DwhSource dwhSource4 = criticRatingReviewItem.f74228b;
                if (dwhSource4 != null) {
                    str5 = dwhSource4.f74237b;
                }
                b.a(context2, imageView3, str5);
                CircularImageView circularImageView2 = avVar.f74484e;
                k.a((Object) circularImageView2, "holder.ivReviewSource");
                circularImageView2.setVisibility(0);
            }
            avVar.f74487h.setOnClickListener(new a(this, criticRatingReviewItem, vVar));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ l f74673a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CriticRatingReviewItem f74674b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ RecyclerView.v f74675c;

        a(l lVar, CriticRatingReviewItem criticRatingReviewItem, RecyclerView.v vVar) {
            this.f74673a = lVar;
            this.f74674b = criticRatingReviewItem;
            this.f74675c = vVar;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(this.f74673a.f74669a, AJRReviewDetailActivity.class);
            this.f74673a.f74670b.setSelectedSourceId(this.f74674b.f74227a);
            CriticReviewAndRating criticReviewAndRating = this.f74673a.f74670b;
            if (criticReviewAndRating != null) {
                intent.putExtra("ratingAndReview", criticReviewAndRating);
                intent.putExtra("movieName", this.f74673a.f74671c);
                Context context = this.f74673a.f74669a;
                if (context != null) {
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type android.os.Parcelable");
        }
    }
}
