package com.jz.service;

import com.jz.dto.OwnerDTO;
import com.jz.dto.RepoDTO;

import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {



        List<RepoDTO> list = GetData.getUsersRepos("JakubZdzieblo");

        for (RepoDTO r : list) {
            System.out.println(r);
        }

        OwnerDTO owner = GetData.getOwnerByUsername("JakubZdzieblo");

        System.out.println(owner);

        Map<String, Integer> stats = Languages.getStats(list);

        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ": " + value);

        }

    }

}
