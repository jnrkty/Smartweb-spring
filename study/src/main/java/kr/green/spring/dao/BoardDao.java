package kr.green.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.green.spring.vo.AccountVo;
import kr.green.spring.vo.BoardVo;

public interface BoardDao {
		
	
	public void setBoard(@Param("board")BoardVo board);
		public List<BoardVo> getBoards();

	
}
