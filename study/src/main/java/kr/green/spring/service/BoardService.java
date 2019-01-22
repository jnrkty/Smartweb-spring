package kr.green.spring.service;

import java.sql.Date;
import java.util.List;

import kr.green.spring.vo.BoardVo;

public interface BoardService {

	public void register(BoardVo board);
	public List<BoardVo> getBoards();
}
