package com.jong960107.study03_04.service;


import com.jong960107.study03_04.domain.Memo;
import com.jong960107.study03_04.domain.MemoRepository;
import com.jong960107.study03_04.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto memoRequestDto){

        Memo memo = memoRepository.findById(id).orElseThrow(

                () -> new IllegalArgumentException("해당 아이디 없음")

        );
        memo.update(memoRequestDto);
        return memo.getId();


    }



}
