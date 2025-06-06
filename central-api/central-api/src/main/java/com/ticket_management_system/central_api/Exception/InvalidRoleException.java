package com.ticket_management_system.central_api.Exception;

public class InvalidRoleException extends RuntimeException{
    public InvalidRoleException(String msg){
        super(msg);
    }
}
