package com.team.ecobuilders.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.team.ecobuilders.reply.dto.ReplyDTO;


@Mapper
public interface IReplyDAO {

	// =============�����Խ���=======================
	// ��� ��� (INSERT)
	int insertReply(ReplyDTO reply);
	
	// ��� ��ȸ (SELECT, WHERE replyNo)
	ReplyDTO getReply(String replyNo);
	
	// Ư�� �Խñۿ� ���� ��� ��� ��ȸ (SELECT, WHERE boardNo)
	List<ReplyDTO> getReplyList(int boardNo);
	
	// ��� ���� ó�� (UPDATE)
	int deleteReply(String replyNo);
	
	// ===============�����Խ���======================
	// ��� ��� (INSERT)
	int photoInsertReply(ReplyDTO reply);
	
	// ��� ��ȸ (SELECT, WHERE replyNo)
	ReplyDTO photoGetReply(String replyNo);
	
	// Ư�� �Խñۿ� ���� ��� ��� ��ȸ (SELECT, WHERE boardNo)
	List<ReplyDTO> photoGetReplyList(int boardNo);
	
	// ��� ���� ó�� (UPDATE)
	int photoDeleteReply(String replyNo);	
	
	
	
	
	
	
	
}
