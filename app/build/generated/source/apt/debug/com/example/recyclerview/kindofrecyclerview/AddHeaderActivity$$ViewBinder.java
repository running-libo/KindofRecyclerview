// Generated code from Butter Knife. Do not modify!
package com.example.recyclerview.kindofrecyclerview;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.ViewBinder;

public class AddHeaderActivity$$ViewBinder<T extends com.example.recyclerview.kindofrecyclerview.AddHeaderActivity> implements ViewBinder<T> {
  @Override public void bind(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131427423, "field 'rvAddheader'");
    target.rvAddheader = finder.castView(view, 2131427423, "field 'rvAddheader'");
  }

  @Override public void unbind(T target) {
    target.rvAddheader = null;
  }
}
