package com.pet.mall.portal;

import com.pet.mall.portal.dao.PortalProductDao;
import com.pet.mall.portal.domain.PromotionProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PortalProductDaoTests {
    @Autowired
    private PortalProductDao portalProductDao;
    @Test
    public void testGetPromotionProductList(){
        List<Long> ids = new ArrayList<>();
        ids.add(26L);
        ids.add(27L);
        ids.add(28L);
        ids.add(29L);
        List<PromotionProduct> promotionProductList = portalProductDao.getPromotionProductList(ids);
        assertEquals(4,promotionProductList.size());
    }
}
