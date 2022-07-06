package com.pet.mall.security.annotation;

import java.lang.annotation.*;

/**
 * Custom annotation, the cache method with this annotation will throw an exception
 * Created by pet on 2022/6/17.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheException {
}
