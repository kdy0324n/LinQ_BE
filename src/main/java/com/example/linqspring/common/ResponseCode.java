package com.example.linqspring.common;

public interface ResponseCode {
    //200
    String SUCCESS = "SU";
    //400
    String VALIDATION_FAILED = "VF";
    String DUPLICATE_ID = "DI";
    String DUPLICATE_EMAIL = "DE";
    String DUPLICATE_NICKNAME = "DN";
    String NOT_EXISTED_USER = "NU";
    String NOT_EXISTED_BOARD = "NB";
    //401
    String AUTHORIZATION_FAIL = "AF";
    String SIGN_IN_FAIL = "SF";
    //403
    String NO_PERMISSION = "NP";

    //500
    String DATABASE_ERROR = "DBE";


}
