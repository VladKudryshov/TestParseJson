package com.git.vladkudryshov.testparsejson.parser.gson;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class UserGson implements IUser {

    @SerializedName("id")
    private long mId;

    @SerializedName("firstName")
    private String mFirstName;

    @SerializedName("surName")
    private String mSurName;

    @SerializedName("age")
    private int mAge;

    @SerializedName("lastSession")
    private Date mLastSession;

    @Override
    public long getId() {
        return mId;
    }

    @Override
    public String getFirstName() {
        return mFirstName;
    }

    @Override
    public String getSurName() {
        return mSurName;
    }

    @Override
    public int getAge() {
        return mAge;
    }

    @Override
    public String getLastSession() {
        final DateFormat formatter = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss", Locale.ENGLISH);

        return formatter.format(mLastSession);
    }
}
