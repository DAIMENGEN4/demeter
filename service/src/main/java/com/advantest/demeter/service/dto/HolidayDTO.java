package com.advantest.demeter.service.dto;

import com.advantest.demeter.common.constants.CountryCode;
import com.advantest.demeter.common.constants.HolidayType;
import com.advantest.demeter.database.po.HolidayPO;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public record HolidayDTO(
        Long id,
        String holidayName,
        String description,
        String holidayDate,
        HolidayType holidayType,
        Boolean isRecurring,
        CountryCode countryCode
) {
    public static HolidayDTO of(HolidayPO holidayPO) {
        return new HolidayDTO(
                holidayPO.getId(),
                holidayPO.getHolidayName(),
                holidayPO.getDescription(),
                holidayPO.getHolidayDate(),
                HolidayType.fromInt(holidayPO.getHolidayType()),
                holidayPO.getIsRecurring(),
                CountryCode.fromInt(holidayPO.getCountryCode())
        );
    }
}
