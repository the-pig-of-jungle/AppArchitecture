package programmer.zzq.appstructure.mvp.presenter;


import programmer.zzq.appstructure.mvp.contract.BaseContract;

/**
 * Created by 朱志强 on 2017/4/14.
 */
public abstract class BasePresenter<V extends BaseContract.IBaseMvpView, B extends BaseContract.IBaseBiz> implements BaseContract.IBasePresenter<V> {

    protected V mMvpView;
    protected B mBiz;

    public BasePresenter() {
        mBiz = createBiz();
    }

    protected abstract B createBiz();

    @Override
    public void attachView(V mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    @Override
    public V getMvpView() {
        return mMvpView;
    }
}
