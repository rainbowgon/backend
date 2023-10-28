package com.rainbowgon.member.global.error.exception;

import com.rainbowgon.member.global.error.errorCode.GlobalErrorCode;

public class MemberPhoneNumberDuplicationException extends CustomException {

    public static final CustomException EXCEPTION = new MemberPhoneNumberDuplicationException();

    public MemberPhoneNumberDuplicationException() {
        super(GlobalErrorCode.MEMBER_PHONE_NUMBER_DUPLICATION);
    }
}
