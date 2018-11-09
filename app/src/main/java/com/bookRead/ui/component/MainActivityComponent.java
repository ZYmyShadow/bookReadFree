package com.bookRead.ui.component;

import com.bookRead.AppComponent;
import com.bookRead.module.MainActivityModule;
import com.bookRead.ui.activity.MainActivity;

import dagger.Component;

/**
 * @author zhazha.
 * @date 2018/11/07.
 */
@Component(modules = MainActivityModule.class, dependencies = AppComponent.class)
public interface MainActivityComponent {
    MainActivity inject(MainActivity mainActivity);
}
