package com.example.linqspring.common;

public interface ResponseMessage {
    //200
    String SUCCESS = "sucess";
    //400
    String VALIDATION_FAILED = "validation failed";
    String DUPLICATE_ID = "duplicate id";
    String DUPLICATE_EMAIL = "duplicate email";
    String DUPLICATE_NICKNAME = "duplicate nickname";
    String NOT_EXISTED_USER = "this user does not exist";
    String NOT_EXISTED_BOARD = "this board does not exist";
    //401
    String AUTHORIZATION_FAIL = "Authorization Failed";
    String SIGN_IN_FAIL = "login information mismatch";
    //403
    String NO_PERMISSION = "Do not have permission";

    //500
    String DATABASE_ERROR = "database error";
}
