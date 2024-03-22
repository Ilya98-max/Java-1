package com.example.demo.command;

import javax.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {

    String execute (HttpServletRequest request);
    default void refresh (){}
}
