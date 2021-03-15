package com.syousui.androidstudyproject;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void tempArr() {
        String[][] catalog = {
                new String[]{"ONE", "1.1", "1.2", "1.3"},
                new String[]{"TWO", "2.1", "2.2", "2.3"},
        };
        System.out.println(catalog[0][0]);
        System.out.println(catalog.length);
//        System.out.println(catalog[0]);
        String[] temp = catalog[0];
//        System.out.println(Arrays.deepToString(Arrays.copyOfRange(catalog[0], 2, catalog[0].length)));

    }

    @Test
    public void testFindByIdMethod() {
//        AppCompatActivity.findViewById(R.id.chapter_name);
        System.out.println(R.id.chapter_name);
    }

    @Test
    public void getJson () {
    }
}