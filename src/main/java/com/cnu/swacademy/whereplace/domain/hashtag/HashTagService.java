package com.cnu.swacademy.whereplace.domain.hashtag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
public class HashTagService {

    private final HashTagRepository repository;

    private Map<String,Integer> hashTagMap;

    @Autowired
    public HashTagService(HashTagRepository repository) {
        this.repository = repository;
        this.hashTagMap = loadAllHashTags();
    }

    private HashMap<String, Integer> loadAllHashTags(){
        List<HashTag> list = repository.findAll();
        HashMap<String,Integer> hashTagMap=new HashMap<>();
        list.forEach(hashtag -> hashTagMap.put(hashtag.getTagName(),hashtag.getTagId()));
        return hashTagMap;
    }


    public List<HashTag> save(List<HashTagDto.Request> hashTags){

        if(hashTags.isEmpty()){
            log.warn("{} : in save, List<HashTagDto.Request> hashTags is null",this.getClass().toString());
            return new ArrayList<>();
        }

        hashTags.stream().filter(hashTag -> hashTagMap.containsKey(hashTag.getTagName()))
                        .forEach(hashTag ->{
                            HashTag hashTagEntity=hashTag.toEntity();
                            hashTagMap.put(hashTag.getTagName(),hashTagEntity.getTagId());
                            repository.save(hashTagEntity);
                        });

        return hashTags.stream().map(HashTagDto.Request::toEntity).collect(Collectors.toList());
    }

    public List<Integer> findHashTagIdAll(List<HashTagDto.Request> hashTags){
        return hashTags.stream().map(hashTag -> hashTagMap.get(hashTag.getTagName()))
                .collect(Collectors.toList());
    }


    public Map<String, Integer> getHashTagMap() {
        return hashTagMap;
    }
}
