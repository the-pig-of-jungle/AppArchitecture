package programmer.zzq.appstructurelib.mvp.model.biz;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import programmer.zzq.appstructure.manager.UserInfoManager;
import programmer.zzq.appstructurelib.mvp.contract.WelcomeContract;

/**
 * Created by 朱志强 on 2017/5/12.
 */

public class WelcomeBiz extends BaseBiz implements WelcomeContract.IWelcomeBiz{

    @Override
    public boolean isBizSuccessful(int bizCode) {
        return true;
    }

    @Override
    public Observable<Boolean> hasLogined() {
        return Observable.create(new ObservableOnSubscribe<Boolean>() {
            @Override
            public void subscribe(ObservableEmitter<Boolean> e) throws Exception {
                e.onNext(!UserInfoManager.isUserInfoEmpty());
                e.onComplete();
            }
        });
    }
}
