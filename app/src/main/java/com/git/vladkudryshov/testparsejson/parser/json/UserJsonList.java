package com.git.vladkudryshov.testparsejson.parser.json;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.git.vladkudryshov.testparsejson.parser.IUserList;

import java.util.List;

public class UserJsonList implements IUserList {

    private final List<IUser> mUserList;

    public UserJsonList(final List<IUser> pUserList) {
        mUserList = pUserList;
    }

    @Override
    public List<IUser> getUserList() {
        return mUserList;
    }
}
