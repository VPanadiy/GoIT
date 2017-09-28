package Java_Core.Collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Splayd on 10.12.2016.
 */
public class FilmExample {
    public static void main(String[] args) {
        final List<Film> filmList = new ArrayList<>();
        filmList.add(new Film("WarCraft", 2016, 4.0f));
        filmList.add(new Film("StarWars", 2015, 3.9f));
        filmList.add(new Film("Elfen Lied", 2004, 5.0f));

        for(Film film: filmList){
            System.out.println(film);
        }

        filmList
                .stream()
                .map(film -> film.getName())
                .forEach(film -> System.out.println(film));
    }
}
