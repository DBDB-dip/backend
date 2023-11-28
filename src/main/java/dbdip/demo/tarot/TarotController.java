package dbdip.demo.tarot;

import dbdip.demo.tarot.entity.TarotCardDescription;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarot")
@RequiredArgsConstructor
public class TarotController {
    private final TarotService tarotService;

    @GetMapping("/{userId}") //OK
    public ResponseEntity<TarotCardDescription> drawTodayTarot(@PathVariable Integer userId) {
        TarotCardDescription selectedCard = tarotService.drawTodayTarot(userId);

        if (selectedCard != null) {
            return new ResponseEntity<>(selectedCard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
