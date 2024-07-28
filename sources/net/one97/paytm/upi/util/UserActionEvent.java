package net.one97.paytm.upi.util;

import androidx.lifecycle.y;
import kotlin.g.b.k;

public final class UserActionEvent {
    public static final UserActionEvent INSTANCE = new UserActionEvent();
    private static final y<Action> actionLiveData = new y<>();

    public enum ActionType {
        DECLINE,
        SPAM,
        PAY
    }

    public static final class Action {
        private final String data;
        private final String type;

        public Action(String str, String str2) {
            k.c(str, "type");
            k.c(str2, "data");
            this.type = str;
            this.data = str2;
        }

        public final String getData() {
            return this.data;
        }

        public final String getType() {
            return this.type;
        }
    }

    private UserActionEvent() {
    }

    public final Action getAction() {
        return actionLiveData.getValue();
    }

    public final void setAction(Action action) {
        actionLiveData.postValue(action);
    }

    public final y<Action> getActionLiveData() {
        return actionLiveData;
    }
}
