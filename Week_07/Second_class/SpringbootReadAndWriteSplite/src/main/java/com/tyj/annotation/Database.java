package com.tyj.annotation;

public @interface Database {
    boolean readOnly() default true;
}
