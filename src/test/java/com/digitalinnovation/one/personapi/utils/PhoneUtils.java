package com.digitalinnovation.one.personapi.utils;

import com.digitalinnovation.one.personapi.dto.request.PhoneDTO;
import com.digitalinnovation.one.personapi.entity.Phone;
import com.digitalinnovation.one.personapi.enums.PhoneType;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "82 99999-9999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

	public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                    .number(PHONE_NUMBER)
                    .type(PHONE_TYPE)
                    .build();
	}

	public static Phone createFakeEntity() {
        return Phone.builder()
                    .id(PHONE_ID)
                    .number(PHONE_NUMBER)
                    .type(PHONE_TYPE)
                    .build();
	}

}
