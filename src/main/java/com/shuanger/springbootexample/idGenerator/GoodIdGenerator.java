package com.shuanger.springbootexample.idGenerator;

import com.shuanger.springbootexample.cache.CacheService;
import com.shuanger.springbootexample.domain.GoodsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;


@Component(IdGeneratorFactory.EXCHANGE)
public class GoodIdGenerator implements IdGenerator<GoodsInfo> {

    @Autowired
    private CacheService cacheService;

    private static final String CACHE_PREFIX = "EXAMPLE-";

    /**
     * 2位good id + 2位 provider id + 1位 商品类型 + 4位日期 + 6位 自增ID
     *
     * @param dependence
     * @return
     */
    @Override
    public String generate(GoodsInfo dependence) {

        return String.format("%2s%2s%1s%4s%6s", this.getGoodPart(dependence.getGoodId()),
                this.getProviderPart(dependence.getProviderId()), this.getGoodType(dependence.getGoodType()),
                this.getDatePart(), this.getIncreasePart());
    }

    /**
     * 渠道后两位
     *
     * @param goodId
     * @return
     */
    private String getGoodPart(String goodId) {
        if (null == goodId || goodId.length() < 2) {
            return "XX";
        }
        return goodId.substring(goodId.length() - 2);
    }

    /**
     * 供应商后两位
     *
     * @param providerId
     * @return
     */
    private String getProviderPart(String providerId) {
        if (null == providerId || providerId.length() < 2) {
            return "XX";
        }
        return providerId.substring(providerId.length() - 2);
    }

    /**
     * 1位 商品类型
     *
     * @param goodType
     * @return
     */
    private String getGoodType(Integer goodType) {
        if (null == goodType) {
            return "X";
        }
        String typeStr = String.valueOf(goodType);
        return typeStr.substring(typeStr.length() - 1);
    }

    /**
     * 6位 Redis 自增ID，可支持到10W级
     *
     * @return
     */
    private String getIncreasePart() {
        LocalDate localDate = LocalDate.now();
        int year1 = localDate.getYear();
        Month month = localDate.getMonth();
        int dayOfMonth = localDate.getDayOfMonth();

        String key = String.format("%04d%02d%02d", year1, month, dayOfMonth);
        Long dailyIncreaseId = cacheService.incrDaily(CACHE_PREFIX + key);
        // 6位 日订单量可支持到10W级
        return String.format("%06d", dailyIncreaseId);
    }

    /**
     * 4位日期 月/日
     *
     * @return
     */
    private String getDatePart() {
        LocalDate localDate = LocalDate.now();
        Month month = localDate.getMonth();
        int dayOfMonth = localDate.getDayOfMonth();

        return String.format("%02d%02d", month.getValue(), dayOfMonth);
    }
}
