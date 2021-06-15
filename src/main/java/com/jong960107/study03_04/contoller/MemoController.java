package com.jong960107.study03_04.contoller;


import com.jong960107.study03_04.domain.Memo;
import com.jong960107.study03_04.domain.MemoRepository;
import com.jong960107.study03_04.domain.MemoRequestDto;
import com.jong960107.study03_04.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class MemoController {

    private final MemoRepository memoRepository;
    private final MemoService memoService;


    @GetMapping("/api/memos")
    public List<Memo> getMemos(){

        LocalDateTime start = LocalDateTime.now().minusDays(1);
        LocalDateTime end = LocalDateTime.now();

        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start,end);

    }


    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto memoRequestDto){

        Memo memo = new Memo(memoRequestDto);
        return memoRepository.save(memo);

    }

    @PutMapping("/api/memos/{id}")
    public Long putMemo(@PathVariable Long id,@RequestBody MemoRequestDto memoRequestDto){

        memoService.update(id,memoRequestDto);

        return id;

    }

    @DeleteMapping("/api/memos/{id}")
    public  Long deleteMemo(@PathVariable Long id){

        memoRepository.deleteById(id);
        return id;

    }








}
