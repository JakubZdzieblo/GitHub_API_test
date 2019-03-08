package com.jz.service;

import com.jz.dto.OwnerDTO;
import com.jz.dto.RepoDTO;

import java.util.List;

public class Test {

    public static void main(String[] args) {



        List<RepoDTO> list = GetData.getUsersRepos("JakubZdzieblo");

        for (RepoDTO r : list) {
            System.out.println(r);
        }

        OwnerDTO owner = GetData.getOwnerByUsername("JakubZdzieblo");

        System.out.println(owner);

    }

}
