package com.git.vladkudryshov.testparsejson.parser.json;

import com.git.vladkudryshov.testparsejson.parser.IUser;
import com.git.vladkudryshov.testparsejson.parser.IUserList;
import com.git.vladkudryshov.testparsejson.parser.IUserListParser;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class UserListJsonParser implements IUserListParser {

    private final String mResource;

    public UserListJsonParser(final String pResource) {
        mResource = pResource;
    }

    @Override
    public IUserList parse() throws Exception {
        final JSONArray jsonArray = new JSONArray(mResource);
        final List<IUser> userList = new ArrayList<IUser>();

        for (int i = 0; i < jsonArray.length(); i++) {
            userList.add(new UserJson(jsonArray.getJSONObject(i)));
        }
        return new UserJsonList(userList);
    }
}
