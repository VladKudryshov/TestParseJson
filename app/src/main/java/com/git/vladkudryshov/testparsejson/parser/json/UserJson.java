package com.git.vladkudryshov.testparsejson.parser.json;

import com.git.vladkudryshov.testparsejson.parser.IUser;

import org.json.JSONObject;

public class UserJson implements IUser {

    private static final String AGE = "age";
    private static final String SUR_NAME = "surName";
    private static final String FIRST_NAME = "firstName";
    private static final String ID = "id";
    private final JSONObject mUserObject;

    public UserJson(final JSONObject pPUserObject) {
        mUserObject = pPUserObject;
    }

    @Override
    public long getId() {
        return mUserObject.optLong(ID);
    }

    @Override
    public String getFirstName() {
        return mUserObject.optString(FIRST_NAME);
    }

    @Override
    public String getSurName() {
        return mUserObject.optString(SUR_NAME);
    }

    @Override
    public int getAge() {
        return mUserObject.optInt(AGE);
    }
}
