public class Ship {
    private static int _NUMBER_=0;
    //Full names for printing a ships stats
    private static String[] statNames={"Health", "Attack", "Defense", "Speed", "Ship Number", "Number of Kills", "Time to return"};
    //Shortened versions for printing the full list more compact
    private static String[] shortNames={"HP", "ATK", "DEF", "SPD", "#", "#oK", "STA"};
    private int[] stats;
    private String name="";
    Ship(String _name, int _health, int _attack, int _defense, int _speed) {
        for(int i=0; i<_name.length()&&name.length()<16; i++) {
            if(_name.charAt(i)!=' ') {
                name+=_name.charAt(i);
            }
        }
        stats=new int[]{_health, _attack, _defense, _speed, ++_NUMBER_, 0, 0};
    }
    //This outputs all the shortened statNames so we can output them with the stats
    public static void statNames() {
        String out="Name";
        for(int i=0; i<shortNames.length; i++) {
            while(out.length()<17+5*i) {
                out+=" ";
            }
            out+=shortNames[i];
        }
        System.out.println(out);
    }
    //Outputs the stats with specific spacing so it all fits; the maximum length of a name is 16
    public void listStats() {
        String out=name;
        for(int i=0; i<stats.length-1; i++) {
            while(out.length()<17+5*i) {
                out+=" ";
            }
            out+=stats[i];
        }
        while(out.length()<17+5*(stats.length-1)) out+=" ";
        if(stats[6]>0) {
            out+="OUT";
        } else out+="IN";
        System.out.println(out);
    }
    public void detailedInfo() {
        System.out.println("Name: "+name);
        for(int i=0; i<stats.length; i++) {
            System.out.println(statNames[i]+": "+stats[i]);
        }
        System.out.println("Current Mission: ");
    }
    public void tick(long t) {
        stats[6]-=t;
        if(stats[6]<0) stats[6]=0;
    }
    //Simple getter and setter of the entire function
    public void setStats(int[] _stats) { stats = _stats; }
    public int[] getStats() { return stats; }
    //Getter and setter where you can select which value, makes things easier
    public void setStats(int val, int i) { stats[i]=val; }
    public int getStats(int i) { return stats[i]; }

    public String getName() { return name; }
}
