package com.git.vladkudryshov.testparsejson.parser.json;

import com.git.vladkudryshov.testparsejson.parser.IUser;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class UserJson implements IUser {

    private static final String AGE = "age";
    private static final String SUR_NAME = "surName";
    private static final String FIRST_NAME = "firstName";
    private static final String ID = "id";
    private static final String LAST_SESSION = "lastSession";
    private final JSONObject mUserObject;

    UserJson(final JSONObject pPUserObject) {
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

    @Override
    public String getLastSession() throws ParseException {
        final long dateLong = mUserObject.optLong(LAST_SESSION);
        final Date date = new Date(dateLong);
        final DateFormat formatter = new SimpleDateFormat("dd MMM yyyy, HH:mm:ss", Locale.ENGLISH);
        return formatter.format(date);
    }
}
