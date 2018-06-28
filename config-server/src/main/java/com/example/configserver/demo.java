package com.example.configserver;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class demo {

    public static void main(String[] args) {
        String s = "https://github.com/ityouknow/spring-cloud-starter\\info/refs?service=git-upload-pack";
        System.out.println(File.separator);
       s = s.substring(0, s.lastIndexOf(File.separator));
        System.out.println(s);
}

}
