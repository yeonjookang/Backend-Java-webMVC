package jwp.util;

import jwp.model.User;

import javax.servlet.http.HttpSession;

public class UserSessionUtils {
    public static final String USER_SESSION_KEY="user";
    public static User getUserFromSession(HttpSession session){
        Object user = session.getAttribute(USER_SESSION_KEY);
        if(user == null) {
            return null;
        }
        return (User)user;
    }
    public static boolean isLogined(HttpSession session) {
        //세션 자체는 일반적으로 항상 존재하며, 사용자 로그인 여부를 확인하려면 세션에 사용자 정보를 저장하여 이 정보의 존재 여부를 검사해야한다.
        return getUserFromSession(session)!=null;
    }
}
