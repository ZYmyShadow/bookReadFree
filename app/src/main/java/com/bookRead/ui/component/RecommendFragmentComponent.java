package com.bookRead.ui.component;

import com.bookRead.AppComponent;
import com.bookRead.module.RecommendFragmentModule;
import com.bookRead.ui.fragment.RecommendFragment;

import dagger.Component;

@Component(modules = RecommendFragmentModule.class, dependencies = AppComponent.class)
public interface RecommendFragmentComponent {
    RecommendFragment inject(RecommendFragment recommendFragment);
}
