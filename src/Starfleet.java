public class Starfleet {
    private int money=0;
    private Ship[] fleet=new Ship[0];
    Starfleet(){

    }
    public void addShip(String _name, int _health, int _attack, int _defense, int _speed) {
        Ship[] temp=new Ship[fleet.length+1];
        for(int i=0; i<fleet.length; i++) {
            temp[i]=fleet[i];
        }
        temp[fleet.length]=new Ship(_name, _health, _attack, _defense, _speed);
        fleet=temp;
    }
    public void showFleet() {
        Ship.statNames();
        for(int i=0; i<fleet.length; i++) {
            fleet[i].listStats();
        }
    }
    public void tick(long t) {
        for(int i=0; i<fleet.length; i++) {
            fleet[i].tick(t);
        }
    }
    public Ship[] getFleet() { return fleet; }
    public Ship getShip(int i) { return fleet[i]; }
    public void setMoney(int _money) { money = _money; }
    public int getMoney() { return money; }
}
