package com.coder.zzq.apparchitecture.model.bean;

/**
 * Created by 喜欢、陪你看风景 on 2018/1/11.
 */

public class UserInfo {
    /**
     * UserId : 35
     * LoginName : zhuzhiqiang
     * UserName : 朱志强
     * Phone :
     * CompanyCode : 001
     * CompanyName : 千一物流
     * BranchCode : 029
     * BranchName : 新东方（乌）
     * Token : 98082a74-2b57-43b2-b701-048ec661cac0
     */

    private String UserId = "";
    private String LoginName = "";
    private String UserName = "";
    private String Phone = "";
    private String CompanyCode = "";
    private String CompanyName = "";
    private String BranchCode = "";
    private String BranchName = "";
    private String Token = "";
    private String Sign = "";
    private String ServiceTel = "";

    public String getServiceTel() {
        return ServiceTel;
    }

    public void setServiceTel(String serviceTel) {
        ServiceTel = serviceTel;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String LoginName) {
        this.LoginName = LoginName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String CompanyCode) {
        this.CompanyCode = CompanyCode;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getBranchCode() {
        return BranchCode;
    }

    public void setBranchCode(String BranchCode) {
        this.BranchCode = BranchCode;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String BranchName) {
        this.BranchName = BranchName;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String Token) {
        this.Token = Token;
    }


    public String getSign() {
        return Sign;
    }

    public void setSign(String sign) {
        Sign = sign;
    }
}
