package com.jz.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jz.dto.OwnerDTO;
import com.jz.dto.RepoDTO;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;


import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GetData {



    public static List<RepoDTO> getUsersRepos(String username) {

        return getListByUrl("https://api.github.com/users/" + username + "/repos?per_page=100");

    }

    public static OwnerDTO getOwnerByUsername(String username) {

        String token = Token.token;

        return getOwnerByUrl("https://api.github.com/users/" + username + "?access_token="+token);

    }

    public static OwnerDTO getOwnerByUrl(String ownerUrl) {

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod();
        ObjectMapper mapper = new ObjectMapper();

        connectMethod(ownerUrl, client, method);

        return getOwnerFromMethod(method, mapper);

    }

    public static List<RepoDTO> getListByUrl(String repoUrl) {

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod();
        ObjectMapper mapper = new ObjectMapper();

        connectMethod(repoUrl, client, method);

        return getRepoListFromMethod(method, mapper);


    }

    private static List<RepoDTO> getRepoListFromMethod(GetMethod method, ObjectMapper mapper) {

        List<RepoDTO> results = new ArrayList<>();
        byte[] responseBody;
        String json;
        try{
            responseBody = method.getResponseBody();

            json = new String(responseBody);

            results = mapper.readValue(json, new TypeReference<List<RepoDTO>>(){});

        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return results;
    }

    private static OwnerDTO getOwnerFromMethod(GetMethod method, ObjectMapper mapper) {

        OwnerDTO owner = new OwnerDTO();
        byte[] responseBody;
        String json;

        try{

            responseBody = method.getResponseBody();

            json = new String(responseBody);

            owner = mapper.readValue(json, OwnerDTO.class);

        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return owner;
    }

    private static void connectMethod(String repoUrl, HttpClient client, GetMethod method) {
        try {
            method.setURI(new URI(repoUrl, false));
        } catch (URIException e) {
            e.printStackTrace();
        }

        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler(3, false));

        try {
            int statusCode = client.executeMethod(method);

            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }

        } catch (HttpException e) {
            System.err.println("Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
