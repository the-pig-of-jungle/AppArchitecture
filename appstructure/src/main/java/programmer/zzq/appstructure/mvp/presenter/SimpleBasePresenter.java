package programmer.zzq.appstructure.mvp.presenter;


import programmer.zzq.appstructure.mvp.contract.BaseContract;

/**
 * Created by 朱志强 on 2017/4/14.
 */
public abstract class SimpleBasePresenter<V extends BaseContract.IBaseMvpView, B extends BaseContract.IBaseBiz> implements BaseContract.IBasePresenter{

    protected V mMvpView;
    protected B mBiz;

    public SimpleBasePresenter() {
        mBiz = createBiz();
    }

    protected abstract B createBiz();

    @Override
    public void attachView(BaseContract.IBaseMvpView mvpView) {
        mMvpView = (V) mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }




}
