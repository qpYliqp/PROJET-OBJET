package Buildings;

public class Farm extends Building{


    Farm(){
        this.name = BuildingNames.FARM;
        this.population = PopulationBuilder.build(20,3,5);
        this.setBuilt(false);
    }
    @Override
    public void Production()
    {

    }

    @Override
    public void Consumption()
    {

    }

}
