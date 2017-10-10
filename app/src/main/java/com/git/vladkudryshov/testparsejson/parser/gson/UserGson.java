package com.git.vladkudryshov.testparsejson.parser.gson;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.google.gson.annotations.SerializedName;

public class UserGson implements IUser {

    @SerializedName("id")
    private long mId;

    @SerializedName("firstName")
    private String mFirstName;


    @SerializedName("surName")
    private String mSurName;

    @SerializedName("age")
    private int mAge;


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
}
