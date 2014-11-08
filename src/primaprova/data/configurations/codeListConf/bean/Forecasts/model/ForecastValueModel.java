package primaprova.data.configurations.codeListConf.bean.Forecasts.model;

/**
 * Created by fabrizio on 11/8/14.
 */
public class ForecastValueModel {

    private String notes;

    private String flags;

    private int value;

    public ForecastValueModel(String notes, String flags, int value) {
        this.notes = notes;
        this.flags = flags;
        this.value = value;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ForecastValueModel{" +
                "notes='" + notes + '\'' +
                ", flags='" + flags + '\'' +
                ", value=" + value +
                '}';
    }
}
