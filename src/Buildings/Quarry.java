package Buildings;

public class Quarry extends Building{

    Quarry(){
        this.name = BuildingNames.QUARRY;
        this.population = PopulationBuilder.build(15,3,5);
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
