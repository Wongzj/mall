package com.pet.mall.service;

import com.pet.mall.model.UmsMemberLevel;

import java.util.List;

public interface UmsMemberLevelService {

    List<UmsMemberLevel> list(Integer defaultStatus);
}
