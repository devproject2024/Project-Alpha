package net.one97.paytm.feed.events.models;

import kotlin.g.b.k;

public final class FeedEventNames {
    private static final String COMMENT_DELETED = COMMENT_DELETED;
    private static final String COMMENT_ED = COMMENT_ED;
    private static final String COMMENT_UPDATED = COMMENT_UPDATED;
    private static final String FEED_ENGAGED = FEED_ENGAGED;
    private static String FEED_ITEM_VIEWED = "userViewed";
    private static final String FEED_SCROLL = FEED_SCROLL;
    private static final String FOLLOWED = FOLLOWED;
    public static final FeedEventNames INSTANCE = new FeedEventNames();
    private static final String POST_CLICKED = POST_CLICKED;
    private static final String POST_LIKED = POST_LIKED;
    private static final String POST_REPORT = POST_REPORT;
    private static final String POST_SAVED = POST_SAVED;
    private static final String POST_SHARED = POST_SHARED;
    private static final String POST_UNLIKED = POST_UNLIKED;
    private static final String UNFOLLOWED = UNFOLLOWED;
    private static String USER_SESSION = "userSession";

    private FeedEventNames() {
    }

    public final String getPOST_LIKED() {
        return POST_LIKED;
    }

    public final String getPOST_UNLIKED() {
        return POST_UNLIKED;
    }

    public final String getPOST_SHARED() {
        return POST_SHARED;
    }

    public final String getPOST_CLICKED() {
        return POST_CLICKED;
    }

    public final String getPOST_REPORT() {
        return POST_REPORT;
    }

    public final String getFOLLOWED() {
        return FOLLOWED;
    }

    public final String getUNFOLLOWED() {
        return UNFOLLOWED;
    }

    public final String getCOMMENT_ED() {
        return COMMENT_ED;
    }

    public final String getCOMMENT_DELETED() {
        return COMMENT_DELETED;
    }

    public final String getFEED_SCROLL() {
        return FEED_SCROLL;
    }

    public final String getCOMMENT_UPDATED() {
        return COMMENT_UPDATED;
    }

    public final String getPOST_SAVED() {
        return POST_SAVED;
    }

    public final String getFEED_ENGAGED() {
        return FEED_ENGAGED;
    }

    public final String getUSER_SESSION() {
        return USER_SESSION;
    }

    public final void setUSER_SESSION(String str) {
        k.c(str, "<set-?>");
        USER_SESSION = str;
    }

    public final String getFEED_ITEM_VIEWED() {
        return FEED_ITEM_VIEWED;
    }

    public final void setFEED_ITEM_VIEWED(String str) {
        k.c(str, "<set-?>");
        FEED_ITEM_VIEWED = str;
    }
}
