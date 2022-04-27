package com.jaeyeun.jpastudy.test;

import org.junit.jupiter.api.Test;

public class ContinueTest {

    @Test
    public void continueTest() {
        int i = 10;

        // for문
        while (i <=10){
            if (i % 2 == 0){
                continue;
            }
            System.out.println(i);
            i++;
        }

        // stream 사용

    }
}
