package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class TextController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/spongebob")
    public String greeting(@RequestParam(value = "value", defaultValue = "HEllo THeRe") String value) {
        value = value.toLowerCase();
        char[] valueArr = value.toCharArray();
        ArrayList<Integer> indexes = this.randomIndexes(value.length());
        for (Integer i : indexes) {
            valueArr[i] = Character.toUpperCase(valueArr[i]);
        }
        return new String(valueArr);
    }
    @GetMapping("/surprised")
    public String surprisedCapital(@RequestParam(value = "value", defaultValue = "W H A T") String value) {
        value = value.toUpperCase();
        char[] valueArr = value.toCharArray();
        ArrayList<String> returnArr = new ArrayList<>();
        for (char c : valueArr) {
            returnArr.add(Character.toString(c));
            returnArr.add(" ");
        }
        StringBuilder sb = new StringBuilder();
        for (String s : returnArr) {
            sb.append(s);
            System.out.println(s);
        }
        return sb.toString();
    }

    private ArrayList<Integer> randomIndexes(int len) {
        Random rand = new Random();
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < (int) len/2; i++) {
            int randIndex = rand.nextInt(len);
            while (indexes.contains(randIndex)) {
                randIndex = rand.nextInt(len);
            }
            indexes.add(randIndex);
        }
        return indexes;
    }
}