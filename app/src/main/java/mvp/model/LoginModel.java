package mvp.model;


import entity.User;

/**
 * MVP中的model数据处理类
 * 这里处理登录时的数据
 */
public class LoginModel {

    /**
     * 处理登录业务并返回结果
     */
    public void login(String name, String password, OnLoginResultListener onLoginResultListener) {
        //一般登录都是请求服务器，验证
        //这里就简单一点，大家别介意
        if ("liwen".equals(name) && "123456".equals(password)) {
            onLoginResultListener.loginSuccess(new User(name, password));//登录成功,给他返回用户对象
        } else {
            onLoginResultListener.loginFailure();//登录失败
        }
    }

    //回调接口
    public interface OnLoginResultListener {

        void loginSuccess(User user);//登录成功后回调的方法，返回User对象

        void loginFailure();//登录失败后回掉的方法
    }
}
