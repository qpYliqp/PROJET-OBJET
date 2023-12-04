package Buildings;

public class PopulationBuilder {


    public static Population build(int max, int travailleur, int habitant)
    {
        Population population = new Population(max);
        for(int i = 0; i < habitant; i++){
            population.add(new Habitant());
        }
        for(int i = 0; i < travailleur; i++){
            population.add(new Travailleur());
        }
        return population;
    }
}
