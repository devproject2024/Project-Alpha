package net.one97.paytm.landingpage.fragment;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.common.b.a;
import net.one97.paytm.common.b.d;

public final class PostpaidLimitIncreaseBottomSheetFragment$setupClickableLinksText2$clickableSpan2$1 extends ClickableSpan {
    final /* synthetic */ PostpaidLimitIncreaseBottomSheetFragment this$0;

    PostpaidLimitIncreaseBottomSheetFragment$setupClickableLinksText2$clickableSpan2$1(PostpaidLimitIncreaseBottomSheetFragment postpaidLimitIncreaseBottomSheetFragment) {
        this.this$0 = postpaidLimitIncreaseBottomSheetFragment;
    }

    public final void onClick(View view) {
        k.c(view, "widget");
        a b2 = d.b();
        this.this$0.getContext();
        String a2 = b2.a(this.this$0.ppClixUrlGTMKey);
        PostpaidLimitIncreaseBottomSheetFragment.access$getWebviewTitle$p(this.this$0);
        d.a().b((Activity) this.this$0.getActivity(), a2);
    }

    public final void updateDrawState(TextPaint textPaint) {
        k.c(textPaint, "ds");
        super.updateDrawState(textPaint);
        this.this$0.decorateLink(textPaint);
    }
}
