package Entity;

public class Customer {
    private String uid;
    private String firname;
    private String surname;
    private String email;
    private String mobile;
    private int stamp;
    private String msgChk;
    private String judgeCode;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getFirname() {
        return firname;
    }

    public void setFirname(String firname) {
        this.firname = firname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStamp() {
        return stamp;
    }

    public void setStamp(int stamp) {
        this.stamp = stamp;
    }

    public String getMsgChk() {
        return msgChk;
    }

    public void setMsgChk(String msgChk) {
        this.msgChk = msgChk;
    }

    public String getJudgeCode() {
        return judgeCode;
    }

    public void setJudgeCode(String judgeCode) {
        this.judgeCode = judgeCode;
    }
}
