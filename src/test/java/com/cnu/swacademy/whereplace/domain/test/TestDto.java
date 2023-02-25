package com.cnu.swacademy.whereplace.domain.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class TestDto {
    @Data
    public static class OneMemberDto {
        private int anotherIntValue;
        OneMemberDto(int a){
            this.anotherIntValue=a;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FullMemberDto {
        private int test_id;
        private int intValue;
        private String stringValue;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberDtoWithOutId {
        private int intValue;
        private String stringValue;
    }
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberDtoWithOutStringValue {
        private int test_id;
        private int intValue;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MemberDtoWithOutIntValue {
        private int test_id;
        private String stringValue;
    }
}
