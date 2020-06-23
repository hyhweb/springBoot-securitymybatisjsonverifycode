package com.springboot.securitymybatisjsonverifycode.common.bean;

/**
 * @author Administrator
 */
public class SelectItem<T> {
    private T value;
    private String text;
    private String other;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "SelectItem{" +
                "value=" + value +
                ", text='" + text + '\'' +
                ", other='" + other + '\'' +
                '}';
    }
}
