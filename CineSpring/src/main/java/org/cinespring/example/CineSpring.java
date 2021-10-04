package org.cinespring.example;

import org.cinespring.example.model.entity.*;
import org.cinespring.example.service.CineManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Sisteme kayıtlı sinema salonlarının, filmlerin, yayında olan filmlerin, yayınlanma bilgilerinin, film salonlarının ve
 * ve bunlara ait bilgilerin görüntülenebildiği bir uygulama. context.xml içerisinde entity package' ın altındaki sınıflara
 * ait bir kaç bean örneği oluşturulmuş ve bu bean' ler CineManager sınıfındaki list' lere set edilmiştir. Gösterilen
 * bilgiler de bu list' lerin içerisindeki bilgilerdir.
 */
public class CineSpring {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        CineManager cineManager = applicationContext.getBean("cineManager", CineManager.class);

        // cinema salonlarının listelenmesi
        System.out.println("Cinema Salonları:");
        for (Cinema cinema : cineManager.getCinemaList()) {
            System.out.println(cinema);
        }

        System.out.println();

        // filmlerin listelenmesi
        System.out.println("Filmler:");
        for (Movie movie : cineManager.getMovieList()) {
            System.out.println(movie);
        }

        System.out.println();

        // film konularının listelenmesi
        System.out.println("Film Konuları:");
        for (MovieGenre movieGenre : cineManager.getMovieGenreList()) {
            System.out.println(movieGenre);
        }

        System.out.println();

        // film oturumlarının listelenmesi
        System.out.println("Film oturumları:");
        for (MovieSession movieSession : cineManager.getMovieSessionList()) {
            System.out.println(movieSession);
        }

        System.out.println();

        // gösterimdeki filmlerin listelenmesi
        System.out.println("Gösterimdeki filmler:");
        for (Screening screening : cineManager.getScreeningList()) {
            System.out.println(screening);
        }

        System.out.println();

        // oturum bilgilerinin listelenmesi
        System.out.println("Oturum Bilgileri:");
        for (Session session : cineManager.getSessionList()) {
            System.out.println(session);
        }

        System.out.println();

        // film salonlarının listelenmesi
        System.out.println("Film salonları:");
        for (Theatre theatre : cineManager.getTheatreList()) {
            System.out.println(theatre);
        }
    }
}
