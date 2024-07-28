package net.one97.paytm.o2o.movies.actor.holders;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import net.one97.paytm.o2o.movies.R;
import net.one97.paytm.o2o.movies.actor.ActorBaseItemData;
import net.one97.paytm.o2o.movies.actor.itemdata.ActorIntroItemData;
import net.one97.paytm.o2o.movies.common.g;
import net.one97.paytm.o2o.movies.utils.n;

public class ActorIntroViewHolder extends ActorBaseHolder {
    ImageView actorIv;
    LinearLayout aliasLL;
    TextView aliasLabel;
    TextView aliasTv;
    TextView birthLabel;
    LinearLayout birthNameLL;
    TextView birthTv;
    LinearLayout bornInfoLL;
    TextView bornInfoLabel = ((TextView) this.bornInfoLL.findViewById(R.id.labelTv));
    TextView bornInfoTv = ((TextView) this.bornInfoLL.findViewById(R.id.descriptionTv));
    View divider;
    LinearLayout heightLL;
    TextView heightLabel;
    TextView heightTv;
    TextView introTv;
    View itemView;
    LinearLayout lastItem;
    ImageView movieCountIv;
    TextView movieCountTv;
    TextView nameTv;
    TextView summaryTv;

    public ActorIntroViewHolder(View view) {
        super(view);
        this.itemView = view;
        this.nameTv = (TextView) view.findViewById(R.id.nameTv);
        this.summaryTv = (TextView) view.findViewById(R.id.summaryTv);
        this.introTv = (TextView) view.findViewById(R.id.introTv);
        this.actorIv = (ImageView) view.findViewById(R.id.actorIv);
        this.movieCountIv = (ImageView) view.findViewById(R.id.movieCountIv);
        this.movieCountTv = (TextView) view.findViewById(R.id.movieCountTv);
        this.divider = view.findViewById(R.id.divider);
        this.bornInfoLL = (LinearLayout) view.findViewById(R.id.bornInfoLL);
        this.heightLL = (LinearLayout) view.findViewById(R.id.heightLL);
        this.heightLabel = (TextView) this.heightLL.findViewById(R.id.labelTv);
        this.heightTv = (TextView) this.heightLL.findViewById(R.id.descriptionTv);
        this.birthNameLL = (LinearLayout) view.findViewById(R.id.birthNameLL);
        this.birthLabel = (TextView) this.birthNameLL.findViewById(R.id.labelTv);
        this.birthTv = (TextView) this.birthNameLL.findViewById(R.id.descriptionTv);
        this.aliasLL = (LinearLayout) view.findViewById(R.id.aliasInfoLL);
        this.aliasLabel = (TextView) this.aliasLL.findViewById(R.id.labelTv);
        this.aliasTv = (TextView) this.aliasLL.findViewById(R.id.descriptionTv);
    }

    public void setData(ActorBaseItemData actorBaseItemData, final Context context) {
        if (actorBaseItemData != null && actorBaseItemData.introData != null) {
            final ActorIntroItemData actorIntroItemData = actorBaseItemData.introData;
            if (!TextUtils.isEmpty(actorIntroItemData.name)) {
                this.nameTv.setText(actorIntroItemData.name);
            } else {
                this.nameTv.setText("");
            }
            if (!TextUtils.isEmpty(actorIntroItemData.profession)) {
                this.introTv.setText(actorIntroItemData.profession);
            } else {
                this.introTv.setText("");
            }
            if (!TextUtils.isEmpty(actorIntroItemData.movieCountText)) {
                this.movieCountTv.setText(actorIntroItemData.movieCountText);
                this.movieCountIv.setVisibility(0);
            } else {
                this.movieCountTv.setText("");
                this.movieCountIv.setVisibility(8);
            }
            if (!TextUtils.isEmpty(actorIntroItemData.image)) {
                g a2 = g.a();
                String str = actorIntroItemData.image;
                w.a().a(str).a(R.drawable.ic_actor_placeholder).a((ah) new g.a()).a(this.actorIv, (e) null);
            }
            if (!TextUtils.isEmpty(actorIntroItemData.bornInfo)) {
                this.bornInfoLL.setVisibility(0);
                this.bornInfoLabel.setText("BORN");
                this.bornInfoTv.setText(actorIntroItemData.bornInfo);
                this.lastItem = this.bornInfoLL;
            } else {
                this.bornInfoLL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(actorIntroItemData.height)) {
                this.heightLL.setVisibility(0);
                this.heightLabel.setText("HEIGHT");
                this.heightTv.setText(actorIntroItemData.height);
                this.lastItem = this.heightLL;
            } else {
                this.heightLL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(actorIntroItemData.birthName)) {
                this.birthNameLL.setVisibility(0);
                this.birthLabel.setText("BIRTH NAME");
                this.birthTv.setText(actorIntroItemData.birthName);
                this.lastItem = this.birthNameLL;
            } else {
                this.birthNameLL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(actorIntroItemData.nickName)) {
                this.aliasLL.setVisibility(0);
                this.aliasLabel.setText("ALSO KNOWN AS");
                this.aliasTv.setText(actorIntroItemData.nickName);
                this.lastItem = this.aliasLL;
            } else {
                this.aliasLL.setVisibility(8);
            }
            if (!TextUtils.isEmpty(actorIntroItemData.summary)) {
                this.summaryTv.setText(actorIntroItemData.summary);
                this.summaryTv.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    public void onGlobalLayout() {
                        ActorIntroViewHolder.this.summaryTv.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                        if (ActorIntroViewHolder.this.summaryTv.getLayout().getLineCount() > 5) {
                            ActorIntroViewHolder.this.handleSummaryGreaterThan5Lines(context, actorIntroItemData);
                        }
                    }
                });
            } else {
                this.summaryTv.setText("");
            }
            LinearLayout linearLayout = this.lastItem;
            if (linearLayout != null) {
                linearLayout.findViewById(R.id.hDivider).setVisibility(8);
            }
            n.a(actorBaseItemData.showDivider, this.divider);
        }
    }

    /* access modifiers changed from: private */
    public void handleSummaryGreaterThan5Lines(final Context context, final ActorIntroItemData actorIntroItemData) {
        int lineEnd = this.summaryTv.getLayout().getLineEnd(4);
        final String str = actorIntroItemData.summary.substring(0, lineEnd - 30) + "...more";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.paytm_blue)), str.length() - 4, str.length(), 33);
        this.summaryTv.setText(spannableString);
        this.summaryTv.setOnClickListener(new View.OnClickListener() {
            boolean isExpanded = false;

            public void onClick(View view) {
                if (this.isExpanded) {
                    SpannableString spannableString = new SpannableString(str);
                    spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.paytm_blue)), str.length() - 4, str.length(), 33);
                    ActorIntroViewHolder.this.summaryTv.setText(spannableString);
                } else {
                    SpannableString spannableString2 = new SpannableString(actorIntroItemData.summary + " less");
                    spannableString2.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.paytm_blue)), actorIntroItemData.summary.length() + 1, actorIntroItemData.summary.length() + 5, 33);
                    ActorIntroViewHolder.this.summaryTv.setText(spannableString2);
                }
                this.isExpanded = !this.isExpanded;
            }
        });
    }
}
