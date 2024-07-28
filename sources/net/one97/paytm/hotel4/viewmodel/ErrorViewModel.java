package net.one97.paytm.hotel4.viewmodel;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.travel.utils.l;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.o;

public final class ErrorViewModel extends ai {
    /* access modifiers changed from: private */
    public static final String ACTION1 = ACTION1;
    /* access modifiers changed from: private */
    public static final String ACTION2 = ACTION2;
    public static final Companion Companion = new Companion((g) null);
    private final y<String> actionButton1Text = new y<>();
    private final y<String> actionButton2Text = new y<>();
    private final l<o<String, String>> buttonClickEvent;
    private final y<String> message = new y<>();
    private final y<Boolean> showActionButton1 = new y<>();
    private final y<Boolean> showActionButton2 = new y<>();
    private final y<Boolean> showCloseButton = new y<>();
    private final y<String> tag1 = new y<>();
    private final y<String> tag2 = new y<>();
    private final y<String> title = new y<>();

    public ErrorViewModel() {
        this.tag1.setValue("TAG1");
        this.tag2.setValue("TAG2");
        this.actionButton1Text.setValue("");
        this.actionButton2Text.setValue("");
        this.buttonClickEvent = new l<>();
    }

    public final y<String> getTitle() {
        return this.title;
    }

    public final y<String> getMessage() {
        return this.message;
    }

    public final y<String> getActionButton1Text() {
        return this.actionButton1Text;
    }

    public final y<String> getActionButton2Text() {
        return this.actionButton2Text;
    }

    public final y<Boolean> getShowActionButton1() {
        return this.showActionButton1;
    }

    public final y<Boolean> getShowActionButton2() {
        return this.showActionButton2;
    }

    public final y<Boolean> getShowCloseButton() {
        return this.showCloseButton;
    }

    public final y<String> getTag1() {
        return this.tag1;
    }

    public final y<String> getTag2() {
        return this.tag2;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getACTION1() {
            return ErrorViewModel.ACTION1;
        }

        public final String getACTION2() {
            return ErrorViewModel.ACTION2;
        }
    }

    public final l<o<String, String>> getButtonClickEvent() {
        return this.buttonClickEvent;
    }

    public final void clicked(String str) {
        k.c(str, "action");
        if (k.a((Object) str, (Object) ACTION1)) {
            String value = this.tag1.getValue();
            if (value == null) {
                k.a();
            }
            k.a((Object) value, "tag1.value!!");
            this.buttonClickEvent.postValue(new o(str, value));
        } else if (k.a((Object) str, (Object) ACTION2)) {
            String value2 = this.tag2.getValue();
            if (value2 == null) {
                k.a();
            }
            k.a((Object) value2, "tag2.value!!");
            this.buttonClickEvent.postValue(new o(str, value2));
        }
    }

    public final String getAction1() {
        return ACTION1;
    }

    public final String getAction2() {
        return ACTION2;
    }
}
