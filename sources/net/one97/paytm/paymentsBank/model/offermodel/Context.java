package net.one97.paytm.paymentsBank.model.offermodel;

import com.google.gson.a.c;

public class Context {
    @c(a = "user")
    private User user;

    public void setUser(User user2) {
        this.user = user2;
    }

    public User getUser() {
        return this.user;
    }

    public String toString() {
        return "Context{user = '" + this.user + '\'' + "}";
    }
}
