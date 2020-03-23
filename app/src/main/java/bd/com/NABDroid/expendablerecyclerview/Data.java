package bd.com.NABDroid.expendablerecyclerview;

public class Data {
    private String law;
    private int lawID;
    private boolean expanded;

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law;
    }

    public Data() {
    }

    public int getLawID() {
        return lawID;
    }

    public void setLawID(int lawID) {
        this.lawID = lawID;
    }

    public Data(String law, int lawID) {
        this.law = law;
        this.lawID = lawID;
        this.expanded = false;
    }
}
