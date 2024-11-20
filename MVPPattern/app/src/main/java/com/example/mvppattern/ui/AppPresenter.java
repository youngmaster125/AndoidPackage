package com.example.mvppattern.ui;
import com.example.mvppattern.ui.AppView;
import com.example.mvppattern.util.MyModel;

// This will acts as Presenter [The Waiter] ;)
public class AppPresenter {

    // 1- The link between Presenter and the view(MainActivity) is done by Interface

    AppView appView;

    public AppPresenter(AppView appView) {
        this.appView = appView;
    }



    // 2- Linkage between presenter and Model
    public MyModel GetAppFromModel(){
        return new MyModel("Master Coding App",900000,4);
    }


    // 3- Linkage Between presenter and MainActivity (Calling The interface)
    public void getAppName(){
        appView.onGetAppName( GetAppFromModel().getAppName());
    }
}
