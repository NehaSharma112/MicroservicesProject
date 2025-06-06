package com.ticket_management_system.central_api.Exception;

public class WrongCredentials extends RuntimeException{
    public WrongCredentials(String msg){super(msg);}
}
