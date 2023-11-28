package dbdip.demo.tarot;

import dbdip.demo.tarot.entity.TarotCardDescription;
import dbdip.demo.tarot.entity.TodayTarot;
import dbdip.demo.tarot.entity.TodayTarotId;
import dbdip.demo.tarot.repository.TarotCardDescriptionRepository;
import dbdip.demo.tarot.repository.TodayTarotRepository;
import dbdip.demo.users.entity.Users;
import dbdip.demo.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class TarotService {
    private final TodayTarotRepository todayTarotRepository;
    private final UsersRepository usersRepository;
    private final TarotCardDescriptionRepository tarotCardDescriptionRepository;

    public TarotCardDescription drawTodayTarot(Integer userId) {
        Users user = usersRepository.findById(userId).orElse(null);
        TarotCardDescription selectedCard = null;

        if (user != null) {
            LocalDate today = LocalDate.now();
            selectedCard = selectRandomTarotCard();

            TodayTarotId todayTarotId = new TodayTarotId(user.getId(), today);
            TodayTarot todayTarot = TodayTarot.builder()
                    .id(todayTarotId)
                    .cardDescription(selectedCard)
                    .build();

            todayTarotRepository.save(todayTarot);
        }
        return selectedCard;
    }
    private TarotCardDescription selectRandomTarotCard() {
        int randomIndex = new Random().nextInt(300);
        return tarotCardDescriptionRepository.findById(randomIndex).orElseThrow(null);
    }
}
