package com.coder.zzq.apparchitecture.model.bean;

/**
 * Created by pig on 2018/1/15.
 */

public class LoginParams {

    /**
     * LoginAccount : string
     * Password : string
     * UserType : 0
     */

    private String LoginAccount;
    private String Password;
    private int UserType;

    public String getLoginAccount() {
        return LoginAccount;
    }

    public void setLoginAccount(String LoginAccount) {
        this.LoginAccount = LoginAccount;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }
}
