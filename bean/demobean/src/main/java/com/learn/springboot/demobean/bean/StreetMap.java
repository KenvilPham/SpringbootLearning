package com.learn.springboot.demobean.bean;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class StreetMap {
    private static final String[] froms = { "79 Mai Hắc Đế, Hai Bà Trưng", "15 Đoàn Trần Nghiệp, Hai Bà Trưng",
            "18 Hào Nam, Đống Đa", "2 Hàng Bạc, Hoàn Kiếm", "48 Tố Hữu, Nam Từ Liêm" };
    private static final String[] tos = { "Sân bay Nội Bài", "Hồ Đồng Đò", "Sân Gold Tam Đảo", "Royal City",
            "Aeon mall Hà Đông", "Vinmec", "Cầu Long Biên" };

    private Random random;
    private String route;

    public String getRoute() {
        return this.route;
    }

    private <T> T getRandomFromArrayString(T[] array) {
        int index = random.nextInt(array.length);
        return array[index];
    }

    public StreetMap() {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        route = "From: <b>" + getRandomFromArrayString(froms) + "</b> -> To: <b>" + getRandomFromArrayString(tos) + "</b>";
    }
}
