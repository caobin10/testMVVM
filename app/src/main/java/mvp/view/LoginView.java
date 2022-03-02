package mvp.view;


import entity.User;

/**
 * mvp中的View的定义
 * 用户登录界面用户的操作行为的定义
 */
public interface LoginView {

    String getAccount();//获取用户的账号，返回账号

    String getPassword();//获取用户的莫玛，返回密码

    void loginSuccess(User user);//登录的实现，需要传入用户对象

    void showNetworkError();//显示网络异常

    void showVerifyFailed();//信息验证失败,账号或密码有误

}
