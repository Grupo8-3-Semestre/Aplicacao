//package sptech.school.voveaplication.service.email;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import sptech.school.voveaplication.api.controller.filme.FilmeController;
//import sptech.school.voveaplication.service.email.EmailSheduler;
//
//@Configuration
//@EnableScheduling
//public class Observer {
//
//    @Scheduled(cron = "0 37 00 ? * SUN")
//        public void updatePopularMovies() {
//            FilmeController filmeController = new FilmeController();
//            EmailSheduler emailSheduler = new EmailSheduler();
//            filmeController.filmesPopulares();
//            emailSheduler.enviarEmailAgendado();
//        }
//    }
