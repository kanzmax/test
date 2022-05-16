public class car_project {
    private String type;
    private String name;
    private String comfort;
    private int cost;
    private int passengers;
    private int gas;

    public car_project(){
        type = "";
        name = "";
        comfort = "";
        cost = 0;
        passengers = 0;
        gas = 0;
    }

    public car_project(String typ, String nam,String comfor, int iCost,int pass, int gasAmount){
        type = typ;
        name = nam;
        comfort = comfor;
        cost = iCost;
        passengers = pass;
        gas = gasAmount;
    }

    public void setType(String t)
    { this.type=t; }
    public String getType()
    { return this.type; }

    public void setName(String n)
    { this.name=n; }
    public String getName()
    { return this.name; }

    public void setCost(int c)
    { this.cost=c; }
    public int getCost()
    { return this.cost; }

    public void setPassengers(int p)
    { this.passengers=p; }
    public int getPassengers()
    { return this.passengers; }

    public void setGas(int g)
    { this.gas=g; }
    public int getGas()
    { return this.gas; }

    public void setComfort(String comf){
        this.comfort = comf;
    }
    public String getComfort(){
        return this.comfort;
    }

}