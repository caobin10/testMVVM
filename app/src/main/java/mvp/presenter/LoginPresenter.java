package mvp.presenter;

import android.text.TextUtils;
import android.util.Log;
import com.mvp.login.ui.activity.MyActivity;
import entity.User;
import mvp.model.LoginModel;
import mvp.view.LoginView;

/**
 * mvp中Presenter中的设计
 * 也是比较难，需要重点理解的一个
 * presenter是主持人的意思，view和model的中间者
 * 需要同时要有View的对象和Model的对象！一般做法是：在构造方法中创建model对象，并创建一个方法绑定View接口
 * 这里可以发现数据处理后或者逻辑判断完后都是给mvp中的View对象来做操作的！
 */
public class LoginPresenter {

    /**
     * 登录业务实现者，数据处理的操作者
     */
    private LoginModel mLoginModel;

    /**
     * 在构造方法中实例化model对象
     */
    public LoginPresenter() {
        mLoginModel = new LoginModel();
    }

    //视图接口对象
    private LoginView mLoginView;

    /**
     * 绑定View 的方法
     *
     * @param loginView
     */
    public void bind(MyActivity loginView) {
        mLoginView = loginView;
    }

    /**
     * 登录业务
     */
    public void login() {
        String account = mLoginView.getAccount();
        String password = mLoginView.getPassword();
        Log.e("TAG", "account:" + account + ",password" + password);
        if (checkParameter(account, password)) {
            doSomePrepare();
            //登录 ，需要处理数据，所有要在model中执行
            mLoginModel.login(account, password, new LoginModel.OnLoginResultListener() {
                //登录成功的回调方法
                @Override
                public void loginSuccess(User user) {
                    mLoginView.loginSuccess(user);   //在给视图页面返回User对象
                }

                //登录失败的回调方法
                @Override
                public void loginFailure() {
                    mLoginView.showVerifyFailed();//在给视图页面返回验证失败的结果
                }
            });
        }
    }

    /**
     * 做一些准备
     */
    private void doSomePrepare() {
        //这里可以设置按钮不可点击！否则一直点击登录也是不好
    }

    /**
     * 检测参数是否是否为空~~~
     *
     * @param account
     * @param password
     * @return
     */
    private boolean checkParameter(String account, String password) {
        if (TextUtils.isEmpty(account) | TextUtils.isEmpty(password)) {
            mLoginView.showVerifyFailed();//提示错误
            return false;
        } else if (!checkNetwork()) {
            mLoginView.showNetworkError();//提示网络错误
            return false;
        }
        return true;
    }

    /**
     * 检测网络是否可用
     */
    public boolean checkNetwork() {
        return true;//先显示可以联网，实际中要用代码判断
    }
}
