package com.example.myzuul.fifter;

/**
 * @author Administrator
 */
public abstract class EatuulFilter {
    abstract public String filterType();
    abstract public int filterOrder();
    abstract public void run();
}