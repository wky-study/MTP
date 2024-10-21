package com.team.ecobuilders.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.ecobuilders.reply.dao.IReplyDAO;
import com.team.ecobuilders.reply.dto.ReplyDTO;


@Service
public class ReplyService {

	@Autowired
	IReplyDAO dao;
	
	// ��� �ۼ� 
	public int insertReply(ReplyDTO reply) {
		int result = dao.insertReply(reply);
		return result;
	}
	
	// ��� ��ȸ 
	public ReplyDTO getReply(String replyNo) {
		ReplyDTO result = dao.getReply(replyNo);
		return result;
	}

	// Ư�� �Խñ��� ��� ��� ��ȸ
	public List<ReplyDTO> getReplyList(int boardNo){
		List<ReplyDTO> result = dao.getReplyList(boardNo);
		return result;
	}
	
	// ��� ����
	public int deleteReply(String replyNo) {
		int result = dao.deleteReply(replyNo);
		return result;
	}
	
	// �ش� �Խñ� ��� ���� ��������
	public int replyCount(int replyCount) {
		int result = dao.replyCount(replyCount);
		return result;
	};
	
	
	
}
