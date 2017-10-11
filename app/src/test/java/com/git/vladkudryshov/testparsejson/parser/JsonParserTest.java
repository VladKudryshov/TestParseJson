package com.git.vladkudryshov.testparsejson.parser;

import com.git.vladkudryshov.testparsejson.BuildConfig;
import com.git.vladkudryshov.testparsejson.http.IHttpClient;
import com.git.vladkudryshov.testparsejson.mocks.Mocks;
import com.git.vladkudryshov.testparsejson.parser.json.UserJsonParser;
import com.git.vladkudryshov.testparsejson.parser.json.UserListJsonParser;
import com.git.vladkudryshov.testparsejson.utils.IOUtils;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = 24
)
public class JsonParserTest {

    private static final int ACTUAL_AGE = 21;
    public static final String ACTUAL_DATE = "10 Oct 2017, 18:57:55";
    private IHttpClient mHttpClient;

    @Before
    public void setUp() {
        mHttpClient = mock(IHttpClient.class);
    }

    @Test
    public void parseUserListJson() throws Exception {
        final InputStream mockedInputStream = Mocks.stream("user_list.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mHttpClient.request("http://myBackend/getUserList");
        final IUserListParser userListJsonParser = new UserListJsonParser(IOUtils.toString(response));
        final IUserList userList = userListJsonParser.parse();

        final IUser user = userList.getUserList().get(3);

        assertEquals(user.getId(), 3);
        assertEquals(user.getFirstName(), "Tracey");
        assertEquals(user.getSurName(), "Lynch");
        assertEquals(user.getAge(), ACTUAL_AGE);

    }

    @Test
    public void parseUserJson() throws Exception {
        final InputStream mockedInputStream = Mocks.stream("user.json");
        when(mHttpClient.request(Matchers.anyString())).thenReturn(mockedInputStream);
        final InputStream response = mHttpClient.request("http://myBackend/getUser?id=3");
        final IUserParser userJsonParser = new UserJsonParser(IOUtils.toString(response));

        final IUser user = userJsonParser.parse();

        assertEquals(user.getId(), 3);
        assertEquals(user.getFirstName(), "Tracey");
        assertEquals(user.getSurName(), "Lynch");
        assertEquals(user.getAge(), ACTUAL_AGE);
        assertEquals(user.getLastSession(), ACTUAL_DATE);

    }

}