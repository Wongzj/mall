package com.pet.mall.portal.controller;

import com.pet.mall.common.api.CommonPage;
import com.pet.mall.common.api.CommonResult;
import com.pet.mall.model.PmsBrand;
import com.pet.mall.model.PmsProduct;
import com.pet.mall.portal.service.PortalBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@Api(tags = "PortalBrandController", description = "Brand management")
@RequestMapping("/brand")
public class PortalBrandController {

    @Autowired
    private PortalBrandService homeBrandService;

    @ApiOperation("Get recommended brands by page")
    @RequestMapping(value = "/recommendList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> recommendList(@RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<PmsBrand> brandList = homeBrandService.recommendList(pageNum, pageSize);
        return CommonResult.success(brandList);
    }

    @ApiOperation("Get brand details")
    @RequestMapping(value = "/detail/{brandId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> detail(@PathVariable Long brandId) {
        PmsBrand brand = homeBrandService.detail(brandId);
        return CommonResult.success(brand);
    }

    @ApiOperation("Get brand related products by page")
    @RequestMapping(value = "/productList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsProduct>> productList(@RequestParam Long brandId,
                                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                            @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize) {
        CommonPage<PmsProduct> result = homeBrandService.productList(brandId,pageNum, pageSize);
        return CommonResult.success(result);
    }
}
