package com.jong960107.study03_04.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Getter
@NoArgsConstructor
public class Memo extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents){

        this.username = username;
        this.contents = contents;

    }


  public Memo(MemoRequestDto requestDto){

      this.username = requestDto.getUsername();
      this.contents = requestDto.getContents();


  }

  public void update(MemoRequestDto memoRequestDto){

      this.username = memoRequestDto.getUsername();
      this.contents = memoRequestDto.getContents();


  }


}
