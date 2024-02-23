package mystudy.spring.service;

public class UserResetEvent {
    private final String username;
    private final String resetCode;

    public UserResetEvent(String username, String resetCode){
        this.username = username;
        this.resetCode = resetCode;
    }

    public String getUsername() {
        return username;
    }

    public String getResetCode() {
        return resetCode;
    }
}
