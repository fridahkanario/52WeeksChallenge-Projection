package com.example.a52weekchallenge;


import androidx.test.filters.SmallTest;
import androidx.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.runner.RunWith;

// @RunWith is required only if you use a mix of JUnit3 and JUnit4.
@RunWith(AndroidJUnit4.class)
@SmallTest
public class LogHistoryAndroidUnitTest {

    public static final String TEST_STRING = "This is a string";
    public static final long TEST_LONG = 12345678L;
    private MainActivity mLogHistory;

    @Before
    public void createLogHistory() {
        mLogHistory = new MainActivity();
    }

}
