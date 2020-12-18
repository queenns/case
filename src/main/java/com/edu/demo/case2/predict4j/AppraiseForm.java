package com.edu.demo.case2.predict4j;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author liu.xiaojian
 * @Date 2020-12-17 17:16
 **/
@Data
@ApiModel
public class AppraiseForm {

    @ApiModelProperty(value = "车辆上牌所在省", dataType = "Integer", required = true, example = "33")
    private Integer provinceId;

    @ApiModelProperty(value = "车辆上牌所在城市", dataType = "Integer", required = true, example = "199")
    private Integer cityId;

    @ApiModelProperty(value = "车辆品牌", dataType = "Integer", required = true, example = "2")
    private Integer pbId;

    @ApiModelProperty(value = "车辆父车系", dataType = "Integer", required = true, example = "14")
    private Integer pserId;

    @ApiModelProperty(value = "车辆车型", dataType = "Integer", required = true, example = "5992")
    private Integer mid;

    @ApiModelProperty(value = "车辆行驶里程", dataType = "Double", required = true, example = "14.8")
    private Double mileAge;

    @ApiModelProperty(value = "车辆颜色", dataType = "Integer", required = true, example = "5")
    private Integer color;

    @ApiModelProperty(value = "首次上牌日期", dataType = "Integer", required = true, example = "20091001")
    private Integer cardTime;

    @ApiModelProperty(value = "车源状态", dataType = "Integer", required = true, example = "6")
    private Integer status;

    @ApiModelProperty(value = "发布时间", dataType = "Integer", required = true, example = "20201216")
    private Integer createTime;

    @ApiModelProperty(value = "更新时间", dataType = "Integer", required = true, example = "20201217")
    private Integer updateTime;

}
