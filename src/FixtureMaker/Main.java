package FixtureMaker;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> teams = List.of("Galatasaray", "Bursaspor", "Fenerbahçe", "Beşiktaş", "Başakşehir", "Trabzonspor", "Gençlerbirliği");
        FixtureGenerator fixture = new FixtureGenerator(teams);
        fixture.generateFixture();
        fixture.printFixture();

    }


}
