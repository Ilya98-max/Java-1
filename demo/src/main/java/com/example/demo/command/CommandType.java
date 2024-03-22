package com.example.demo.command;

import com.example.demo.command.impl.AddUserCommand;
import com.example.demo.command.impl.DefaultCommand;
import com.example.demo.command.impl.LoginCommand;
import com.example.demo.command.impl.LogoutCommand;

import javax.sound.midi.ShortMessage;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT (new DefaultCommand());
    Command command ;
    CommandType(Command command) {
        this.command = command;
    }
    public static Command define(String commandStr) {
        CommandType  current =  CommandType.valueOf(commandStr.toUpperCase());

       return current.command;
    }


}
