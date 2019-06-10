package com.tdeado.utils;

import com.tdeado.utils.json.GsonUtil;

public class Main {
    public static void main(String[] args) {

        Order  o= (Order) GsonUtil.jsonTobean("{\"id\":\"1137981457073217536\",\"platform\":0,\"platformOrder\":\"69719061011433234643016\",\"aircompany\":\"PN\",\"dptTime\":\"2019-06-11 13:35:35\",\"arrTime\":\"2019-06-11 15:45:11\",\"code\":\"PN6361\",\"dptCity\":\"CGO\",\"arrCity\":\"XNN\",\"dptAirport\":\"XNN\",\"arrAirport\":\"CGO\",\"passengerNumber\":1,\"collection\":\"604.0\",\"policyPerson\":null,\"policyCode\":\"FAKE\",\"policyRemarks\":\"all cabins\",\"platformStatus\":0,\"position\":\"Q\",\"flightReturn\":\"\",\"contactName\":\"\\u8d75\\u6587\\u6d9b\",\"contactEML\":\"\",\"contactNumber\":\"158****1201\",\"mode\":1}",Order.class);
        System.err.println(o);
        System.err.println(o.getArrTime());
    }
}
