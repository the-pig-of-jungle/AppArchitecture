package programmer.zzq.appstructurelib.mvp.model.bean;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public class UserInfo {

    /**
     * UserId : 35
     * LoginName : zhuzhiqiang
     * UserName : 朱志强
     * Phone :
     * CompanyCode : 001
     * CompanyName : 千一物流
     * BranchCode : 031
     * BranchName : 喀什
     * Token : 56c2f13c-9d45-46c7-8708-21720b467576
     */

    private String UserId;
    private String LoginName;
    private String UserName;
    private String Phone;
    private String CompanyCode;
    private String CompanyName;
    private String BranchCode;
    private String BranchName;
    private String Token;

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
}
