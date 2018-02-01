package com.project.cx.processcontrol.base;

import java.util.List;

/**
 * Created by Administrator on 2018/1/24 0024.
 */

public interface IAdapter<T> {
    void setItems(List<T> items);
    void addItem(T item);
    void delItem(T item);
    void addItems(List<T> items);
    void clearItems();
    T getItem(int position);
}
