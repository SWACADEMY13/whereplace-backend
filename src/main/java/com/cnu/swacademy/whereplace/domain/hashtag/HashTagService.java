package com.cnu.swacademy.whereplace.domain.hashtag;

import com.cnu.swacademy.whereplace.domain.comment.Comment;
import com.cnu.swacademy.whereplace.domain.comment.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Slf4j
@Service
public class HashTagService {

    private final HashTagRepository hashTagRepository;

    private final Map<String,Integer> hashTagMap;

    @Autowired
    public HashTagService(HashTagRepository hashTagRepository) {
        this.hashTagRepository = hashTagRepository;
        this.hashTagMap = loadAllHashTags();
    }

    private HashMap<String, Integer> loadAllHashTags(){
        List<HashTag> list = hashTagRepository.findAll();
        HashMap<String,Integer> hashTagMap = new HashMap<>();
        list.forEach(hashtag -> hashTagMap.put(hashtag.getTagName(),hashtag.getTagId()));
        return hashTagMap;
    }

    @Transactional
    public List<HashTag> create(List<HashTagDto.Request> dtos){ // 저장 전에 tagName 이 이미 존재하는지 확인

        if(dtos.isEmpty()){
            log.warn("{} : in save, List<HashTagDto.Request> hashTags is null",this.getClass().toString());
            return new ArrayList<>();
        }

        dtos.stream().filter(hashTagDto -> !hashTagMap.containsKey(hashTagDto.getTagName()))
                .forEach(hashTagDto -> {
                    HashTag hashTagEntity = hashTagDto.toEntity();
                    hashTagMap.put(hashTagDto.getTagName(),hashTagEntity.getTagId());
                    hashTagRepository.save(hashTagEntity);
                });

        List<HashTag> hashTags = new ArrayList<>();

        for (HashTagDto.Request dto : dtos) {
            hashTags.add(hashTagRepository.findByTagName(dto.getTagName()));
        }

        return hashTags;
    }

//    public List<Integer> findHashTagIdAll(List<HashTagDto.Request> dtos){
//        return dtos.stream().map(hashTag -> hashTagMap.get(hashTag.getTagName()))
//                .collect(Collectors.toList());
//    }
//
//    public Map<String, Integer> getHashTagMap() {
//        return hashTagMap;
//    }

    public HashTagDto.Response toDto(HashTag hashTag) {
        return HashTagDto.Response.builder()
                .tagId(hashTag.getTagId())
                .tagName(hashTag.getTagName())
                .build();
    }
}