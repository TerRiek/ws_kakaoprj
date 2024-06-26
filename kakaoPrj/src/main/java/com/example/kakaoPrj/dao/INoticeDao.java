package com.example.kakaoPrj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.kakaoPrj.dto.NoticeDto;

@Mapper
public interface INoticeDao {
	public List<NoticeDto> listDao(@Param("writer") String writer);
	public NoticeDto detailDao(@Param("nno") String nno);
	public int writeDao(@Param("dto") NoticeDto dto );
	public int deleteDao(@Param("nno") String nno);
	public int updateDao(@Param("nno") String nno, @Param("title") String title, @Param("content") String content);
	public List<NoticeDto> getMeWroten(@Param("writer") String writer);
	public List<NoticeDto> getMeMentioned(@Param("receiver") String receiver);
	public List<NoticeDto> getMySelf(@Param("writer") String writer);
}
