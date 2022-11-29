package com.Tsega.tsega;

import io.realm.RealmObject;

public class Note extends RealmObject {
    String title;

    long Createdtime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public long getCreatedtime() {
        return Createdtime;
    }

    public void setCreatedtime(long createdtime) {
        Createdtime = createdtime;
    }

}
