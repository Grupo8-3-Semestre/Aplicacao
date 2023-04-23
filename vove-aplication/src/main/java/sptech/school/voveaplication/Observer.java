package sptech.school.voveaplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class Observer {

    @Scheduled(cron = "0 36 23 ? * SAT")
        public void updatePopularMovies() {
            FilmeController filmeController = new FilmeController();
            EmailSheduler emailSheduler = new EmailSheduler();
            filmeController.filmesPopulares();
            emailSheduler.enviarEmailAgendado();
        }
    }
