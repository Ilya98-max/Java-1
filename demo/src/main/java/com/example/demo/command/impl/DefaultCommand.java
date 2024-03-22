package com.example.demo.command.impl;

import com.example.demo.command.Command;

import javax.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return "index.jsp";
    }
}

