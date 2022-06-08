package com.co.wh.rules;

public interface IRule<T> {

    public boolean createRule(String name, String rule);

    public boolean execRule(String name, T... parms);

    public boolean deleteRule(String name);

}
