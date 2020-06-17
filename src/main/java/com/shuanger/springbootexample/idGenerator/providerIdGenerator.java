package com.shuanger.springbootexample.idGenerator;

import com.shuanger.springbootexample.cache.CacheService;
import com.shuanger.springbootexample.domain.GoodsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;


@Component(IdGeneratorFactory.ORDER)
public class providerIdGenerator implements IdGenerator<GoodsProvider> {

    @Autowired
    private CacheService cacheService;

    private static final String CACHE_PREFIX = "EXAMPLE-";

    /**
     * 2位providerId + 4位日期 + 6位 自增ID + 4位 contactId
     *
     * @param dependence
     * @return
     */
    @Override
    public String generate(GoodsProvider dependence) {

        return String.format("%2s%4s%6s%4s", this.getProviderPart(dependence.getProviderId()),
                this.getDatePart(), this.getIncreasePart(), this.getContactPart(dependence.getContactId()));
    }

    /**
     * provider后两位
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
     * 4位日期 月/日
     *
     * @return
     */
    private String getDatePart() {
        LocalDate localDate = LocalDate.now();

        Month month1 = localDate.getMonth();
        int dayOfMonth = localDate.getDayOfMonth();
        return String.format("%02d%02d", month1.getValue(), dayOfMonth);
    }

    /**
     * 6位 Redis 自增ID，可支持到10W级
     *
     * @return
     */
    private String getIncreasePart() {
        LocalDate localDate = LocalDate.now();
        int year1 = localDate.getYear();
        Month month1 = localDate.getMonth();
        int dayOfMonth = localDate.getDayOfMonth();

        String key = String.format("%04d%02d%02d", year1, month1.getValue(), dayOfMonth);
        Long dailyIncreaseId = cacheService.incrDaily(CACHE_PREFIX + key);
        // 6位 日订单量可支持到10W级
        return String.format("%06d", dailyIncreaseId);
    }

    /**
     * 4位 contactId
     *
     * @param contactId
     * @return
     */
    private String getContactPart(String contactId) {
        if (null == contactId || contactId.length() < 4) {
            return "XXXX";
        }
        return contactId.substring(contactId.length() - 4);
    }
}
