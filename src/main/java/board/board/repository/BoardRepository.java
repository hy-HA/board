package board.board.repository;

import board.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
    //검색기능
    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
