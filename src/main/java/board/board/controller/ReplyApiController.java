package board.board.controller;

import board.board.domain.Reply;
import board.board.dto.ReplyDto;
import board.board.service.ReplyService;
import board.member.Member;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/board/{boardId}/reply")
@RequiredArgsConstructor
@Tag(name = "reply V1 API", description = "댓글을 관리하는 API")
public class ReplyApiController {

    @Autowired
    private final ReplyService replyService;

    @PostMapping
    @Operation(summary = "댓글을 생성합니다 ➕ ")
    public List<Reply> createReply(@PathVariable("boardId") Long boardId,
                              @RequestParam("content") ReplyDto replyDto,
                              //name 속성에는 세션에 저장된 속성의 이름을, required 속성에는 해당 속성이 반드시 필요한지 여부를 지정
                              @SessionAttribute(name = "user", required = false) Member user){
        List<Reply> replyList = replyService.createReply(replyDto, user, boardId);
        return replyList;
    }

//    @PutMapping("/{bno}")
//    @Operation(summary = "댓글을 수정합니다 ♻️ ")
//    public List<Reply> updateReply(@PathVariable("bno")Long bno, @RequestBody Reply reply){
////
////        replyService.updateReply();
////
////        return new ResponseEntity<>(getListByBoard(board), HttpStatus.CREATED);
//        return null;
//    }


    // 댓글 수정 처리
    @PutMapping("/{replyId}")
    @ResponseBody
    @Operation(summary = "댓글을 수정합니다 ♻️ ")
    public ResponseEntity<Void> editReply(@PathVariable("boardId") Long boardId,
                                            @PathVariable("replyId") Long replyId,
                                            @RequestParam("content") String content) {
        try {
            replyService.editReply(boardId, replyId, content);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @RequestMapping(value = "/{replyId}", method = RequestMethod.DELETE)
    @ResponseBody
    @Operation(summary = "댓글을 삭제합니다 🗑 ")
    public ResponseEntity<String>  deleteReply(@PathVariable Long boardId, @PathVariable Long replyId) {
        replyService.replyDelete(replyId);
        return ResponseEntity.ok("success");
        //return "redirect:/board/{boardId}";
    }

}
