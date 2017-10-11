package com.git.vladkudryshov.testparsejson.parser.gson;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.git.vladkudryshov.testparsejson.parser.IUserList;

import java.util.List;

class UserGsonList implements IUserList {

    private final List<IUser> mUserGsonList;

    UserGsonList(final List<IUser> pUsersLists) {
        mUserGsonList = pUsersLists;
    }

    @Override
    public List<IUser> getUserList() {
        return mUserGsonList;
    }
}
