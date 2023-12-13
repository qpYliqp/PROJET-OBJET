package Buildings;

public abstract class Building {

    protected Population population;
    private boolean isBuilt =false;

    protected int ConstructionTime;

    String name;

    public Population getPopulation() {
        return population;
    }

    public String getname()
    {
        return name;
    }

    public boolean getBuilt() {
        return isBuilt;
    }

    public void setBuilt(boolean built) {
        isBuilt = built;
    }

    public int getConstructionTime() {
        return ConstructionTime;
    }

    public void setConstructionTime(int constructionTime) {
        ConstructionTime = constructionTime;
    }

    public void removeConstructionTime(int constructionTime) {
        ConstructionTime -= constructionTime;
    }

    public abstract void Production();

    public abstract void Consumption();

    public abstract boolean CONDITION();

    public abstract String PrintCondition();

    public abstract void ConstructionRessource();





}
