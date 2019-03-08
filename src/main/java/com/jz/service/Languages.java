package com.jz.service;

import com.jz.dto.RepoDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Languages {

    public static Map getStats(List<RepoDTO> list) {

        HashMap<String, Integer> count = new HashMap<>();

        for(RepoDTO repo : list) {

            String lang = repo.getLanguage();
            if (lang == null) {
                lang = "Unknown";
            }

            if (count.containsKey(lang)) {
                count.put(lang, count.get(lang) + 1);
            } else {
                count.put(lang, 1);
            }
        }

        return count;

    }

}
